# ## Circuito completo: de la solicitud a la entrega
---

## FASE 1 — El Jefe de Servicio registra la solicitud

### Actor: Jefe de Servicio (Ana, del sector Informática)

Ana necesita pedir comidas para tres personas de su sector. El enunciado dice:

> *Registrar pedidos nominados de comidas, identificando a cada persona mediante nombre, apellido y DNI.*
> *Gestionar de manera independiente las solicitudes de desayuno, almuerzo, merienda y cena.*
> *Utilizar automáticamente el tipo de menú asociado a cada persona.*

### Datos que se almacenan

#### En `SolicitudComida`:

```
SolicitudComida
  id: 1
  fecha: 25/09/2026
  estado: CONFIRMADA          ← el Jefe la confirma al enviarla
  creadoEn: 22/09/2026 10:00
  usuario_id: 5               ← Ana (quien la registra)
  sector_id: 3                ← Informática
```

#### En `DetalleSolicitud` (tres registros, uno por persona):

```
DetalleSolicitud
  id: 1
  solicitud_id: 1             ← pertenece a la solicitud de arriba
  personal_id: 10             ← Juan Pérez
  tipo_comida_id: 2           ← Almuerzo
  tipo_menu_id: 1             ← Vegetariano (menú de Juan)
  condicion: REGULAR          ← entra en el cupo
  estaAutorizado: false       ← todavía no fue autorizado

DetalleSolicitud
  id: 2
  solicitud_id: 1
  personal_id: 11             ← Laura Gómez
  tipo_comida_id: 2           ← Almuerzo
  tipo_menu_id: 2             ← Común
  condicion: REGULAR
  estaAutorizado: false

DetalleSolicitud
  id: 3
  solicitud_id: 1
  personal_id: 12             ← Pedro López
  tipo_comida_id: 4           ← Cena
  tipo_menu_id: 2             ← Común
  condicion: EXCEPCION        ← excede el cupo del sector
  estaAutorizado: false
```

### ¿Por qué separar solicitud de detalle?

El enunciado dice:

> *Las cantidades autorizadas deberán obtenerse a partir de las solicitudes nominadas efectivamente autorizadas y no deberán sobrescribir la información del pedido original.*

Cada detalle lleva su propia autorización. La solicitud original nunca se modifica.

### ¿Por qué `condicion` REGULAR y EXCEPCION?

El enunciado dice:

> *Identificar las solicitudes que quedan comprendidas dentro del cupo Regular y aquellas que correspondan a Excepción.*
> *Mantener la condición Regular o Excepción asignada a cada solicitud durante el posterior circuito de autorización y entrega.*

Si el sector Informática tiene 20 cupos de almuerzo y ya tiene 20 pedidos, el pedido 21 es `EXCEPCION`.

---

## FASE 2 — Servicio de Alimentación autoriza

### Actor: Servicio de Alimentación (María)

María revisa los pedidos de todos los sectores. El enunciado dice:

> *Autorizar o no autorizar de manera nominada las solicitudes realizadas.*
> *Mantener diferenciada la información originalmente solicitada de la posteriormente autorizada.*

María autoriza los almuerzos de Juan y Laura, pero rechaza la cena de Pedro.

### Datos que se modifican

#### En `DetalleSolicitud`:

```
DetalleSolicitud id: 1 (Juan, Almuerzo)
  estaAutorizado: true        ← CAMBIA
  autorizadoEn: 23/09/2026 09:00
  autorizadoPor: 8            ← María

DetalleSolicitud id: 2 (Laura, Almuerzo)
  estaAutorizado: true        ← CAMBIA
  autorizadoEn: 23/09/2026 09:00
  autorizadoPor: 8            ← María

DetalleSolicitud id: 3 (Pedro, Cena)
  estaAutorizado: false       ← NO CAMBIA (rechazado)
```

#### En `SolicitudComida`:

```
SolicitudComida id: 1
  estado: AUTORIZADA          ← CAMBIA (porque tiene al menos un detalle autorizado)
```

### ¿Por qué el estado de la solicitud cambia pero los detalles son independientes?

El enunciado dice:

> *Las cantidades autorizadas deberían obtenerse a partir de las solicitudes nominadas efectivamente autorizadas y no deberían sobrescribir la información del pedido original.*

La solicitud refleja que **al menos algo fue autorizado**, pero cada detalle mantiene su propio estado. La solicitud original queda intacta.

---

## FASE 3 — Sector Comedor entrega

### Actor: Sector Comedor (Carlos)

El 25/09/2026 a las 12:30, alguien se acerca al comedor a retirar las comidas. El enunciado dice:

> *Consultar las comidas autorizadas para cada persona en una fecha determinada.*
> *Verificar si una comida autorizada ya fue entregada.*
> *Registrar la entrega de una o varias comidas en una misma operación.*
> *Permitir que una persona retire comidas correspondientes a otras personas autorizadas.*
> *Registrar quién fue el responsable efectivo del retiro.*
> *Impedir que una misma comida autorizada sea entregada más de una vez.*

Pedro se presenta en el comedor y retira las tres comidas (la suya ya fue rechazada, así que solo retira las dos de almuerzo autorizadas... pero supongamos que Pedro retira las comidas de Juan y Laura, y la suya de cena no porque fue rechazada).

En realidad, para el ejemplo del circuito completo, usemos algo más claro:

```
Pedro retira las comidas de Juan y Laura (ambas autorizadas).
```

### Datos que se almacenan

#### En `Entrega`:

```
Entrega
  id: 1
  fechaHora: 25/09/2026 12:30
  notas: ""
  usuario_id: 9               ← Carlos (quien registra en el sistema)
  personal_id: 12             ← Pedro (responsable del retiro)
```

#### En `DetalleEntrega` (dos registros, uno por comida entregada):

```
DetalleEntrega
  id: 1
  entrega_id: 1               ← pertenece a la entrega de arriba
  detalle_solicitud_id: 1     → Juan, Almuerzo, Vegetariano
  tipo_menu_id: 1             ← Vegetariano (menú que se entregó)
  creadoEn: 25/09/2026 12:30

DetalleEntrega
  id: 2
  entrega_id: 1
  detalle_solicitud_id: 2     → Laura, Almuerzo, Común
  tipo_menu_id: 2             ← Común
  creadoEn: 25/09/2026 12:30
```

### ¿Por qué `DetalleEntrega` tiene `tipo_menu_id`?

El enunciado dice:

> *Visualizar el tipo de menú correspondiente.*

Se registra qué menú se entregó efectivamente, por si difiere del solicitado originalmente.

### ¿Por qué `DetalleEntrega` apunta a `DetalleSolicitud`?

Para garantizar:

1. **Que solo se entregue lo autorizado:** `validarAutorizacion()` verifica que `DetalleSolicitud.estaAutorizado == true`.
2. **Que no se entregue dos veces:** como la relación es `1 a 1`, un `DetalleSolicitud` solo puede tener un `DetalleEntrega`. Si se intenta crear otro, el sistema lo rechaza.

El enunciado dice:

> *Impedir que una misma comida autorizada sea entregada más de una vez.*

### ¿Por qué `Personal` como responsable del retiro?

El enunciado dice:

> *Permitir que una persona retire comidas correspondientes a otras personas autorizadas.*
> *Registrar quién fue el responsable efectivo del retiro.*

Pedro no comió las comidas de Juan y Laura, pero las retiró. El modelo lo registra:

```
Entrega
  responsable del retiro: Pedro
  ├── comida de Juan
  └── comida de Laura
```

---

## Estado final de los datos

```
SolicitudComida (25/09/2026, estado: AUTORIZADA)
│
├── Detalle 1: Juan → Almuerzo → Vegetariano → REGULAR   → autorizado ✓ → ENTREGADO ✓
├── Detalle 2: Laura → Almuerzo → Común     → REGULAR   → autorizado ✓ → ENTREGADO ✓
└── Detalle 3: Pedro → Cena     → Común     → EXCEPCION → NO autorizado → sin entrega

Entrega (25/09/2026 12:30, retira Pedro)
├── DetalleEntrega 1 → Detalle 1 (Juan)
└── DetalleEntrega 2 → Detalle 2 (Laura)
```

## Visualización del flujo en el modelo

```
┌─────────────────────────────────────────────────────────────────────┐
│  FASE 1: Jefe de Servicio (Ana)                                     │
│                                                                     │
│  Crea SolicitudComida                                               │
│    └── Crea DetalleSolicitud × 3 (uno por persona/comida)           │
│        cada uno con condición REGULAR o EXCEPCION                   │
│        estado de solicitud: CONFIRMADA                              │
└──────────────────────────────┬──────────────────────────────────────┘
                               ▼
┌─────────────────────────────────────────────────────────────────────┐
│  FASE 2: Servicio de Alimentación (María)                           │
│                                                                     │
│  Revisa DetalleSolicitud de cada sector                             │
│    └── Autoriza o no autoriza DETALLE POR DETALLE                   │
│        no modifica la solicitud original                            │
│        estado de solicitud cambia a AUTORIZADA                      │
└──────────────────────────────┬──────────────────────────────────────┘
                               ▼
┌─────────────────────────────────────────────────────────────────────┐
│  FASE 3: Sector Comedor (Carlos)                                    │
│                                                                     │
│  Busca persona por DNI/nombre                                       │
│    └── Consulta comidas autorizadas para esa fecha                  │
│        └── Verifica que NO haya sido entregada ya                   │
│            └── Crea Entrega con responsable del retiro              │
│                └── Crea DetalleEntrega × N                          │
│                    cada uno apunta a UN DetalleSolicitud             │
│                    no se puede duplicar                             │
└─────────────────────────────────────────────────────────────────────┘
```