# Roadmap de implementación e issues

## Objetivo

Implementar la Etapa 1 del sistema de alimentación con cinco integrantes trabajando en paralelo, minimizando bloqueos entre tareas.

La estrategia es construir primero un **contrato común pequeño** —modelo de datos, permisos, API y convenciones— y luego dividir el trabajo en módulos casi independientes. Cada integrante trabaja en su propia rama y todos integran mediante pull requests pequeñas.

## Reglas de trabajo para evitar bloqueos

1. Nadie espera a que otro termine todo el módulo: se acuerdan primero contratos, nombres y datos mínimos.
2. Cada issue debe poder cerrarse con tests propios.
3. Los módulos deben depender de servicios/interfaces, no de implementaciones internas de otra persona.
4. Las migraciones de base de datos se integran de forma ordenada y se prueban sobre una base limpia.
5. Los cambios compartidos —configuración, modelos centrales y permisos— se revisan entre dos personas antes de fusionarse.
6. Usar ramas por issue y PRs chicos: `feature/123-modelos`, `fix/145-validacion-dni`.
7. Agregar datos iniciales reproducibles: roles, permisos, tipos de personal, menús y tipos de comida.

---

# Reparto sugerido del equipo

## Integrante 1 — Base técnica y modelo de datos

Responsable de dejar disponible la infraestructura común, pero sin convertirse en cuello de botella:

- Configuración de Flask, SQLAlchemy y PostgreSQL.
- Estructura MVC y manejo de configuración por ambiente.
- Modelos y migraciones iniciales.
- Seeds/catálogos básicos.
- Convenciones de errores y respuestas JSON.

## Integrante 2 — Autenticación, usuarios, roles y permisos

- Login y logout manuales.
- Flask-Session.
- Gestión de usuarios.
- Roles, permisos y bloqueo.
- Decoradores o servicios de autorización.

## Integrante 3 — Sectores, personal y catálogos

- CRUD de sectores.
- CRUD de personal.
- Tipos de personal y tipos de menú.
- Reglas de residentes, personal fijo, sectores y activos.
- Importación CSV.

## Integrante 4 — Cupos y pedidos

- CRUD y consultas de cupos.
- Creación, modificación y eliminación de pedidos.
- Detalles nominados.
- Cálculo Regular/Excepción.
- Endpoints de consulta de pedidos.

## Integrante 5 — Autorizaciones, entregas y auditoría

- Autorización nominada.
- Rechazo de pedidos.
- Consulta de comidas autorizadas.
- Registro de entregas y prevención de duplicados.
- Auditoría y resúmenes operativos.

> El Integrante 5 puede comenzar con contratos, tests y servicios usando datos de prueba mientras el módulo de pedidos se termina. La integración real queda desbloqueada cuando exista el contrato de `DetalleSolicitud`.

---

# Fase 0 — Organización y contratos comunes

Estas tareas son cortas y deben cerrarse al inicio. No conviene empezar cinco implementaciones distintas antes de acordar estos puntos.

## ISSUE 001 — Acordar modelo conceptual y reglas de negocio

**Responsables:** todo el equipo.  
**Prioridad:** crítica.  
**Estimación:** 1 día.

### Alcance

- Confirmar `Persona`, `Usuario` y `Personal` según el enunciado.
- Confirmar que el personal fijo pertenece a un único sector y el residente no requiere sector.
- Confirmar que una persona puede ser usuario y personal.
- Confirmar que un `DetalleSolicitud` representa una persona, una fecha y un tipo de comida.
- Confirmar que un `DetalleSolicitud` puede tener como máximo un `DetalleEntrega`.
- Decidir los estados de la solicitud: `CONFIRMADA`, `AUTORIZADA`, `RECHAZADA`.
- Definir si se mantiene `estado` explícito en la solicitud y cómo se actualiza.

### Criterios de aceptación

- El modelo conceptual está aprobado por los cinco integrantes.
- Las decisiones quedan documentadas.
- No existen nombres alternativos para las mismas relaciones.

## ISSUE 002 — Definir contrato de API y formato de errores

**Responsables:** Integrantes 1, 2 y 4.  
**Prioridad:** crítica.  
**Estimación:** 1 día.

### Alcance

Definir:

- Formato JSON de éxito.
- Formato JSON de error.
- Códigos HTTP.
- Paginación.
- Fechas y horas en ISO 8601.
- Convención de nombres de campos.
- Autenticación Bearer para la API.

### Criterios de aceptación

- Existe un documento de contrato.
- Cada endpoint tiene entrada, salida, permisos y errores.
- Los módulos pueden implementar sus endpoints sin esperar código de otros módulos.

## ISSUE 003 — Configurar repositorio, calidad y datos de prueba

**Responsables:** Integrante 1, con revisión de todo el equipo.  
**Prioridad:** alta.  
**Estimación:** 1 día.

### Alcance

- Estructura MVC.
- Variables de entorno y configuración local.
- Poetry y dependencias.
- PostgreSQL de desarrollo.
- Migraciones.
- Linter, formatter y tests.
- Fixtures/factory de datos.
- README de instalación.

### Criterios de aceptación

- Una persona nueva puede levantar el proyecto siguiendo el README.
- Las pruebas se ejecutan con un comando.
- La base puede crearse desde cero.

---

# Fase 1 — Trabajo paralelo sobre módulos independientes

Comienza cuando estén acordados los contratos de Fase 0. Los issues de esta fase pueden ejecutarse simultáneamente.

## ISSUE 010 — Implementar tablas y migraciones de seguridad

**Responsable:** Integrante 1.  
**Prioridad:** alta.  
**Estimación:** 1–2 días.

### Alcance

Crear tablas y relaciones para:

- `roles`.
- `permisos`.
- `rol_permisos`.
- `usuarios`.
- `sectores`.

Agregar restricciones de unicidad para correo, DNI y nombre donde corresponda.

## ISSUE 011 — Implementar catálogos y personal

**Responsable:** Integrante 3.  
**Prioridad:** alta.  
**Estimación:** 2–3 días.

### Alcance

- `tipos_personal`.
- `tipos_menu`.
- `personal`.
- CRUD de personal.
- Reglas de personal fijo y residente.
- Activación/desactivación.
- Validación de DNI.
- Preservación de datos históricos.

### Criterios de aceptación

- Personal fijo requiere sector.
- Residente puede no tener sector.
- Personal inactivo no aparece para nuevos pedidos.
- El menú predeterminado queda disponible.
- Modificar una persona no modifica detalles históricos.

## ISSUE 012 — Implementar autenticación y autorización

**Responsable:** Integrante 2.  
**Prioridad:** alta.  
**Estimación:** 2–3 días.

### Alcance

- Login manual.
- Hash seguro de contraseñas.
- Sesiones con Flask-Session.
- Logout.
- Usuario autenticado.
- Roles y permisos.
- Bloqueo de usuarios.
- Decoradores/middleware de permisos.

### Criterios de aceptación

- Un usuario bloqueado no inicia sesión.
- Las contraseñas nunca se devuelven ni se registran.
- Los endpoints verifican autenticación antes de reglas de negocio.
- El acceso a vistas y API se valida en backend.

## ISSUE 013 — Implementar sectores y responsables

**Responsable:** Integrante 3.  
**Prioridad:** alta.  
**Estimación:** 1–2 días.

### Alcance

- CRUD de sectores.
- Estado activo/inactivo.
- Asociación de Jefes de Servicio.
- Un jefe pertenece a un único sector.
- Un sector puede tener varios jefes.
- No desactivar sectores con usuarios activos.

## ISSUE 014 — Implementar cupos

**Responsable:** Integrante 4.  
**Prioridad:** alta.  
**Estimación:** 1–2 días.

### Alcance

- `tipos_comida`.
- `cupos_sector`.
- CRUD de cupos.
- Un cupo por sector y tipo de comida.
- No crear cupos para sectores inactivos.
- Consulta limitada al sector para Jefes de Servicio.
- No modificar históricamente pedidos existentes.

## ISSUE 015 — Definir contratos de pedidos, autorizaciones y entregas

**Responsable:** Integrante 5, con revisión de Integrante 4.  
**Prioridad:** alta.  
**Estimación:** 1 día.

### Alcance

Documentar payloads y respuestas para:

- Crear un pedido.
- Listar detalles nominados.
- Autorizar/rechazar.
- Consultar comidas autorizadas.
- Registrar una entrega con varias comidas.

### Criterios de aceptación

- Se identifica claramente quién es el comensal.
- Se identifica quién retira.
- Se diferencia el usuario que registra la entrega del responsable del retiro.
- Se define cómo se evita la entrega duplicada.

---

# Fase 2 — Circuito de pedidos, autorización y entrega

Los issues 020, 021 y 022 deben comenzar en paralelo utilizando los contratos de Fase 1.

## ISSUE 020 — Implementar solicitudes y detalles nominados

**Responsable:** Integrante 4.  
**Prioridad:** crítica.  
**Estimación:** 3–4 días.

### Alcance

- `solicitudes_comida`.
- `detalles_solicitud`.
- Crear pedidos diarios, semanales y mensuales.
- Desayuno, almuerzo, merienda y cena independientes.
- Cálculo de `REGULAR` y `EXCEPCION` según cupo.
- Evitar duplicados por persona, sector, fecha y tipo de comida.
- Consulta, modificación y eliminación cuando corresponda.
- Scoping del Jefe de Servicio a su sector.

### Criterios de aceptación

- Todos los pedidos son nominados.
- El menú se copia al detalle al crear el pedido.
- Cambios posteriores del personal no modifican el histórico.
- Un pedido confirmado puede modificarse.
- Un pedido autorizado o rechazado no puede modificarse por el Jefe.

## ISSUE 021 — Implementar autorización nominada

**Responsable:** Integrante 5.  
**Prioridad:** crítica.  
**Estimación:** 2–3 días.

### Alcance

- Autorizar o no autorizar cada detalle.
- Autorización individual y masiva.
- Registrar usuario y fecha de autorización.
- Rechazo completo de pedido.
- Mantener pedidos y autorizaciones diferenciados.
- Exponer totales calculados desde detalles autorizados.

### Criterios de aceptación

- No se puede autorizar un detalle que no pertenece al pedido.
- Un pedido rechazado no queda disponible para entrega.
- Los detalles autorizados siguen siendo nominados.
- Se conserva el pedido original.

## ISSUE 022 — Implementar entregas

**Responsable:** Integrante 5.  
**Prioridad:** crítica.  
**Estimación:** 2–3 días.

### Alcance

- `entregas`.
- `detalles_entrega`.
- Registrar una entrega con una o varias comidas.
- Registrar el usuario del Sector Comedor que carga la operación.
- Registrar el responsable efectivo del retiro.
- Verificar autorización vigente.
- Impedir entregar dos veces el mismo detalle autorizado.
- Fecha y hora generadas en servidor.
- Consultar detalle e historial de entregas.

### Criterios de aceptación

Para una operación como:

```text
Entrega (25/09/2026 12:30, registrada por Carlos, retira Pedro)
  ├── DetalleEntrega → comida autorizada de Juan
  └── DetalleEntrega → comida autorizada de Laura
```

- Se crea una fila en `entregas`.
- Se crean dos filas en `detalles_entrega`.
- Ambas apuntan a su `detalle_solicitud`.
- Una segunda entrega del mismo detalle falla con conflicto.
- Una comida no autorizada falla con validación.

## ISSUE 023 — Implementar consultas de comidas autorizadas

**Responsable:** Integrante 5.  
**Prioridad:** alta.  
**Estimación:** 1–2 días.

### Alcance

- Búsqueda por DNI, nombre, apellido, fecha, sector y comida.
- Vista por persona con desayuno, almuerzo, merienda y cena.
- Mostrar menú autorizado.
- Mostrar si ya fue entregada.
- Mostrar solo pedidos autorizados.

## ISSUE 024 — Implementar resúmenes y auditoría

**Responsables:** Integrantes 1 y 5.  
**Prioridad:** media-alta.  
**Estimación:** 2–3 días.

### Alcance

- `registros_auditoria`.
- Registrar operaciones relevantes.
- Resumen pedidos.
- Resumen autorizaciones.
- Resumen entregas.
- Totales autorizado vs. entregado.
- Filtros por fecha, sector, comida y menú.

---

# Fase 3 — Aplicación privada de administración

Estas tareas pueden avanzar en paralelo con la API después de tener contratos y servicios.

## ISSUE 030 — Layout base Jinja

**Responsable:** Integrante 2.  
**Prioridad:** alta.  
**Estimación:** 1–2 días.

- Layout base.
- Navegación.
- Usuario autenticado.
- Mensajes flash.
- Responsive básico.

## ISSUE 031 — Vistas de usuarios, roles y permisos

**Responsable:** Integrante 2.  
**Prioridad:** alta.  
**Estimación:** 2–3 días.

- CRUD de usuarios.
- Filtros, ordenamiento y paginación.
- Asignación de rol.
- Sector obligatorio para Jefe de Servicio.
- Bloqueo/desbloqueo.

## ISSUE 032 — Vistas de sectores

**Responsable:** Integrante 3.  
**Prioridad:** media-alta.  
**Estimación:** 1–2 días.

- CRUD.
- Filtros.
- Jefes asociados.
- Estado activo/inactivo.

## ISSUE 033 — Vistas de personal y carga CSV

**Responsable:** Integrante 3.  
**Prioridad:** media-alta.  
**Estimación:** 2–3 días.

- CRUD.
- Filtros.
- Importación CSV.
- Informe de procesados, importados y rechazados.

## ISSUE 034 — Vistas de cupos y parámetros

**Responsable:** Integrante 4.  
**Prioridad:** media.  
**Estimación:** 1–2 días.

- CRUD de cupos.
- Validaciones.
- Configuración de paginación.
- Mantenimiento del sitio.

---

# Fase 4 — Integración, pruebas y entrega

## ISSUE 040 — Pruebas de reglas de negocio

**Responsables:** todo el equipo; coordinan Integrantes 1 y 5.  
**Prioridad:** crítica.  
**Estimación:** 2–3 días.

Casos mínimos:

- Personal fijo sin sector: rechazar.
- Residente con sector: validar la regla definida.
- Personal inactivo en nuevo pedido: rechazar.
- Pedido duplicado: rechazar.
- Cupo agotado: marcar excepción.
- Modificar pedido autorizado: rechazar.
- Autorizar detalle ajeno: rechazar.
- Entregar no autorizado: rechazar.
- Entregar dos veces: rechazar.
- Retirar comidas para varias personas: aceptar.
- Cambiar sector de personal: no alterar históricos.
- Cambiar menú: no alterar detalles históricos.

## ISSUE 041 — Pruebas de permisos y seguridad

**Responsables:** Integrantes 2 y 5.  
**Prioridad:** crítica.  
**Estimación:** 1–2 días.

- Usuario bloqueado.
- Token ausente o inválido.
- Rol incorrecto.
- Jefe consultando otro sector.
- Inyección SQL mediante entradas.
- Contraseñas no expuestas.
- Validación siempre en backend.

## ISSUE 042 — Migración limpia y datos demo

**Responsable:** Integrante 1.  
**Prioridad:** alta.  
**Estimación:** 1 día.

- Crear base desde cero.
- Ejecutar migraciones.
- Cargar catálogos.
- Cargar usuarios demo por rol.
- Cargar sectores, personal, cupos y ejemplos del circuito.

## ISSUE 043 — Prueba de recorrido completo

**Responsables:** todo el equipo.  
**Prioridad:** crítica.  
**Estimación:** 1 día.

Recorrer:

```text
Crear personal
→ crear sector y jefe
→ configurar cupo
→ crear pedido nominado
→ autorizar algunos detalles
→ consultar comidas autorizadas
→ registrar entrega de varias comidas
→ intentar duplicar entrega
→ consultar resumen e historial
```

## ISSUE 044 — Documentación y defensa

**Responsables:** todo el equipo.  
**Prioridad:** alta.  
**Estimación:** 1–2 días.

- README.
- Decisiones del modelo.
- API.
- Instalación.
- Datos demo.
- División de responsabilidades.
- Guion de defensa.
- Versionado semántico de la entrega.

---

# Dependencias mínimas

```text
001 + 002 + 003
        │
        ├── 010 → 012 → 031
        ├── 011 → 013 → 032/033
        ├── 010 + 014 → 020
        ├── 015 + 020 → 021 → 022 → 023
        └── 024

040 + 041 + 042 + 043 + 044 → entrega
```

La dependencia importante es solamente el **contrato de datos y API**, no la finalización completa de otro módulo. Por ejemplo, Integrante 5 puede desarrollar autorización y entregas con fixtures de pedidos mientras Integrante 4 implementa el endpoint real.

# Riesgos a resolver temprano

1. **Persona vs. Usuario vs. Personal:** el enunciado indica que el personal no necesariamente tiene cuenta, pero un Jefe puede ser ambas cosas. Mantener la separación y documentarla.
2. **Estado de solicitud:** si se mantiene `estado`, actualizarlo de manera transaccional junto con la autorización. Si se elimina, definir cómo distinguir pendiente de rechazado.
3. **Históricos:** copiar menú, condición y referencias relevantes al detalle. Cambios actuales de personal o cupo no deben alterar históricos.
4. **Entrega múltiple:** `Entrega` representa la operación; `DetalleEntrega` representa cada comida. El responsable del retiro pertenece a la operación completa.
5. **Duplicados:** imponer restricciones en base de datos además de validar en backend.
6. **Cupos:** no dependen del tipo de menú; cada persona consume una unidad.
7. **Usuarios jefes:** un Jefe de Servicio pertenece a un único sector; un sector puede tener varios jefes.

# Orden recomendado para comenzar mañana

```text
Día 1: ISSUE 001, 002 y 003 en conjunto.
Día 2: ISSUE 010, 011, 012, 013, 014 y 015 en paralelo.
Día 3+: ISSUE 020, 021, 022, 030, 031, 032, 033 y 034 en paralelo.
Después: ISSUE 023, 024, 040, 041, 042, 043 y 044.
```
