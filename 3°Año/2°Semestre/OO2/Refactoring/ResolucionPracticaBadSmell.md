# Parte A

# Ejercicio 1 - Sistema de nomina

a) Metodo imprimir recibos bad smells:

Metodo imprimirRecibos:
1. Long method, el metodo imprimirrecibos tiene muchas responsabilidades. -> refactoring, extract method, extraer la logica de calcular el bruto.
2. Magic number, en imprimir recibirrecibos aparece el numero 0.13 sin indicar el porque -> refactoring, implementar una variabole estatica inidicando el porque aparece
3. Feature Envy(Envidia de atributos), el metodo imprimirRecibos le pide datos al empleado para realizar calculos, en ves de delegar la responsabilidad al mismo empleado. -> refactoring, extract method y move method hacia la clase empleado
4. Loops(Bucles), el for en los 3 metodos se puede transfgormar a un steam -> refactorging, replace loop with pipeline, se cambia el for pro un stream

---

# Devolución del Ejercicio 1 (Parte A)

**Nota orientativa: 6/10** — Detectaste olores reales y propusiste refactorings concretos (bien), pero te comiste el smell central del ejercicio y no respondiste la consigna b) tal como fue pedida.

## ✅ Lo que está bien

1. **Long Method** bien identificado en `imprimirRecibos`, y con el refactoring correcto (Extract Method).
2. **Magic Number**: buen ojo al marcar el `0.13`. (Ojo: también lo son `450` y `200` — hubiera sumado nombrarlos.)
3. Siempre asociás smell → refactoring, que es exactamente la mecánica que se evalúa.
4. La idea de mover el cálculo hacia `Empleado` es audaz y defendible (ver punto 3 de precisiones).

## ❌ Lo que falta (y es lo que más puntúa)

1. **Duplicated Code — el corazón del ejercicio.** El bloque
   `bruto = sueldoBasico + horasExtra * 450 + antiguedad * 200; descuento = bruto * 0.13`
   está copiado en **tres métodos** (`imprimirRecibos`, `calcularCostoEstimado`, `guardarBackupDeLiquidacion`). Es el smell principal: si mañana cambia la fórmula, hay que tocar tres lugares. Sin esto, la respuesta queda incompleta aunque todo lo demás esté bien.
2. **Consigna b) sin responder**: pide explícitamente el **orden** de aplicación de los refactorings y el porqué de ese orden.
3. **Comments**: el `// le aplico el 13% de descuento por aportes` es un smell tipo *Comments* (explica QUÉ hace la línea siguiente, no POR QUÉ). Una constante bien nombrada (`PORCENTAJE_APORTES`) elimina la necesidad del comentario.
4. **Alcance**: solo analizaste `imprimirRecibos`. Los otros dos métodos tienen los mismos olores; la consigna pide el código completo.

## ⚖️ Precisiones sobre lo que escribiste

1. **Feature Envy (ítem 3)**: es *debatible* y en parcial hay que justificarlo con evidencia ("usa 4 datos de `Empleado` y ninguno de la propia clase"). Que un servicio use getters de otra clase no es Feature Envy per se; la línea es fina. Si lo sostenés, está bien — pero cuidado: proponés **Extract Method + Move Method** juntos sin decir cuál es el resultado final. Elegí una postura: o `ProcesadorNomina.calcularNeto(Empleado)` (Extract Method simple) **o** `Empleado.getSueldoNeto()` (Move Method), y quedate con esa.
2. **Loops → Replace Loop with Pipeline (ítem 4)**: es válido pero **secundario**, y ojo: no todo `for` es un smell. Donde sí aplica es en los acumuladores de `calcularCostoEstimado`/`guardarBackupDeLiquidacion`. En `imprimirRecibos` el loop tiene efectos secundarios (imprime por pantalla): meterlo en un stream obligaría a `peek`, que es mala práctica. Además, una vez hecho el Extract Method, esto queda cosmético.
3. **Magic Number (ítem 2)**: el refactoring tiene nombre propio: **Replace Magic Number with Symbolic Constant**. Decir "implementar una variable estática" está bien, pero nombralo con su nombre canónico y listá los tres números mágicos, no solo uno.

## 📋 Lo que se esperaba como respuesta modelo (en orden)

1. **Duplicated Code** → **Extract Method** `private double calcularNeto(Empleado e)` (o **Move Method** → `Empleado.getSueldoNeto()`). Primero porque es un cambio seguro que unifica la fórmula en un solo lugar.
2. **Long Method** → **Extract Method** para separar cálculo de presentación (`imprimirRecibo(Empleado, double)`).
3. **Magic Number + Comments** → **Replace Magic Number with Symbolic Constant** (`PORCENTAJE_APORTES`, `VALOR_HORA_EXTRA`, `VALOR_ANTIGUEDAD`) + **Rename Method** si hace falta. Con esto el comentario desaparece solo.
4. *(Extra)* **Replace Loop with Pipeline** donde no hay efectos secundarios.

> **El orden importa y es parte de la consigna**: primero duplicación (unifica el cambio), después estructura (acorta métodos), después estética (nombres y constantes). Cada paso deja el código más simple para el siguiente.

## ✏️ Detalles de forma

Prolijidad y ortografía cuentan en parcial: "transfgormar", "steam" (stream), "refactorging", "variabole", "inidicando". Un renglón de revisión antes de entregar evita perder puntos de onda. 

# Ejercicio 2 - reservas de hotel

# Identificando bad smells y orden en que aplicarlos:
1. Long parameter list (lista de parametros) -> refactoring replace parameters with object, los parametros necesarios para calcular precio corresponden a un objeto reserva
2. fecha inicio y fecha fin podrian ser un objeto rangoFechas
3. move method, el caculo total lo deberia de implemetnar el objeto reserva
4. replace condicional con polimorfismo, para reemplazar el if aplicaria polimorfimos con tipo de habitacion para el objeto reserva, y que este se encargue de aplicar el cargo rpo el tipo de habitacion
5. replace condicional con polifmorfismo, mismo para categoria cliente
6. 800 magic number, aplicar refactoring replace magic numbre with symbolic constant
7. comments, el comentario en disponibilidad indica que hace en vez del porque

---

# Devolución del Ejercicio 2 (Parte A)

**Nota orientativa: 7/10** — Mejor que el Ejercicio 1: la mayoría de los refactorings que proponés son los correctos y hasta tuviste la idea de diseño del objeto `Reserva`. Lo que baja la nota es que casi no nombrás los **smells** (que es lo que pide la consigna a) y se te escaparon dos olores importantes.

## ✅ Lo que está bien

1. **Ítems 4 y 5**: identificaste que los dos `if/else if` se resuelven con **Replace Conditional with Polymorphism**, uno por cada variación (`tipoHabitacion`, `categoriaCliente`). Es exactamente la corrección canónica, y encima la distribuiste bien: cada jerarquía encapsula su variación.
2. **Ítem 1 + 3**: la idea de crear un objeto `Reserva` y que el cálculo viva ahí (**Move Method**) es una lectura de diseño madura — muchos resuelven solo lo mínimo y no se avivan de esto.
3. **Ítem 2**: `RangoFechas` es el objeto correcto para el par de fechas.
4. **Ítem 7**: buen ojo con el `// consulta a la base de datos` de `disponibilidad` (smell **Comments**).

## ❌ Lo que falta (y puntúa)

1. **No nombrás los smells, solo los refactorings.** La consigna a) pide "identifique los bad smells **y justifique**". En tu lista, los ítems 2, 4 y 5 dan la solución pero no dicen el olor. Faltan tres nombres clave:
   - **Switch Statements** (los `if/else if` por código de tipo) → ítems 4 y 5.
   - **Data Clumps** (`fechaInicio` + `fechaFin` viajan juntas en `calcularPrecio` y en `disponibilidad`) → ítem 2.
   - **Primitive Obsession** (`String tipoHabitacion`, `int categoriaCliente`, `String codigoPromocional`) — este ni lo mencionás.
2. **Primitive Obsession es el olor más importante que se escapó**, y trae un bonus de examen: `tipoHabitacion == "simple"` compara **referencias** en Java, no valores. Es un bug latente que la comparación con `.equals` o, mejor aún, el objeto `TipoHabitacion`, elimina de raíz. Mencionar esto diferencia una respuesta de 7 de una de 9.
3. **Parámetros sin uso** (dos detalles que suman):
   - `codigoPromocional` se recibe en `calcularPrecio` y **nunca se usa** → *unused parameter* / *Speculative Generality* → **Remove Parameter**.
   - `disponibilidad` recibe `categoriaCliente` y `tarifaBase` que **tampoco usa**.
4. **Magic numbers incompletos**: marcaste solo el `800`. También lo son `1.0`, `1.5`, `2.2`, `0.05`, `0.10`, `0.20`. (Si aplicás polimorfismo, esas tasas terminan en cada subclase, donde conviene nombrarlas igual.)

## ⚖️ Precisiones sobre lo que escribiste

1. **Ítem 1**: el nombre canónico es **Introduce Parameter Object** (o **Preserve Whole Object** si pasás el objeto completo). "Replace parameters with object" no es un nombre estándar de Fowler; en parcial usá el canónico. Que el objeto sea `Reserva` está bien pensado: es *Preserve Whole Object* llevado al dominio.
2. **Ítems 1 y 2 se solapan**: `RangoFechas` debería ser un atributo **dentro** de `Reserva`, no una alternativa. En la respuesta conviene presentarlo como una secuencia: primero agrupar las fechas, después agrupar todo en `Reserva`.
3. **Ítem 3**: al mover el cálculo a `Reserva`, mencioná el smell que lo justifica (**Feature Envy**: el método usa 6 datos de los parámetros y ninguno de `GestorReservas`). También ojo: `disponibilidad` sí es legítima en `GestorReservas` (consulta disponibilidad del hotel, no de una reserva).

## 📋 Respuesta modelo (en orden, con nombre de smell)

1. **Data Clumps** (`fechaInicio`, `fechaFin`) → **Introduce Parameter Object**: clase `RangoFechas` con `diferenciaEnDias()`. Beneficio extra: `disponibilidad` también la usa.
2. **Long Parameter List** (7 parámetros) → **Introduce Parameter Object / Preserve Whole Object**: clase `Reserva` (`RangoFechas estadia`, `TipoHabitacion tipo`, `CategoriaCliente categoria`, `double tarifaBase`, `boolean incluyeDesayuno`).
3. **Feature Envy** (el cálculo vive en `GestorReservas` pero usa datos de la reserva) → **Move Method**: `Reserva.calcularPrecio()`.
4. **Primitive Obsession + Switch Statements** (`String tipoHabitacion` con `==`, `int categoriaCliente`) → **Replace Primitive with Object** + **Replace Conditional with Polymorphism**: jerarquías `TipoHabitacion` (`getFactor()`) y `CategoriaCliente` (`getDescuento()`).
5. **Magic Numbers + Comments** → **Replace Magic Number with Symbolic Constant** (`PRECIO_DESAYUNO = 800`, tasas nombradas) + eliminar comentarios que explican el *qué*.
6. **Unused parameters** (`codigoPromocional`, y los dos de `disponibilidad`) → **Remove Parameter**.

> **Por qué este orden**: agrupar datos primero (1-2) es mecánico y seguro; recién después se mueve comportamiento (3) sobre una `Reserva` ya existente; el polimorfismo (4) se aplica sobre los atributos ya encapsulados; y al final la estética (5-6). Cada paso deja el siguiente más natural — es la misma lógica del Ejercicio 1.

## ✏️ Detalles de forma

"polifmorfismo", "rpo", "caculo", "implemetnar", "numbre" → polimorfismo, por, cálculo, implementar, number/number→número mágico. Cuidado también con mezclar el título de consigna ("# Identificando bad smells...") con el nivel de los ejercicios: en un parcial, respondé con la estructura del enunciado (a) smells y justificación, b) refactorings y orden).
   
# Ejercicio 3 - Facturacion de comercio:

# Respuesta, orden / bad smells / refactoring

1. Data Class, la clase Factura solo guarda datos y no posee comportamiento, refactoring extract class, crear calse Direccion y clase Cliente, la clase Cliente tendra la direccion.

´´´java 
public class Factura {
    private int numero;
    private double total;
    private Cliente cliente;

    public Factura(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    // Getters y Setters...
}

public class ImpresorFacturas {
    public String generar Encabezado(Factura factura) {
        String ecabezado = "Factura Nro: " + factura.numero + "\n";
        ecabezado += "Cliente: " + factura.cliente.getNombre() + "\n";
        ecabezado += "Direccion: " + factura.cliente.getDireccion().getCalle() + ", " + factura.cliente.getDireccion().getNumero() + ", " + factura.cliente.getDireccion().getCiudad() + "\n";
        return ecabezado;
    } 

    public String generarPie(Factura factura) {
        return "Total: " + factura.getTotal() + " - ciudad: " + factura.getCliente().getDireccion().getCiudad();
    }
}

public class Cliente {
    private String nombre;
    private Direccion direccion;

    public Cliente(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Getters y Setters...
}

public class ServicionNotificaciones {
    public void enviarNotificacion(Factura factura) {
        String ciudad = factura.getCliente().getDireccion().getCiudad();
        System.out.println("Enviando notificación a la ciudad: " + ciudad);
    }
}

2. Feature Envy, el metodo generarEncabezado y generarPie le piden datos a la factura para realizar calculos, en ves de delegar la responsabilidad al mismo objeto factura, refactoring move method hacia la clase factura. 

´´´java
public class Factura {
    private int numero;
    private double total;
    private Cliente cliente;

    public Factura(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public String generarEncabezado() {
        String encabezado = "Factura Nro: " + this.numero + "\n";
        encabezado += "Cliente: " + this.cliente.getNombre() + "\n";
        encabezado += "Direccion: " + this.cliente.getDireccion().getCalle() + ", " + this.cliente.getDireccion().getNumero() + ", " + this.cliente.getDireccion().getCiudad() + "\n";
        return encabezado;
    }

    public String generarPie() {
        return "Total: " + this.total + " - ciudad: " + this.cliente.getDireccion().getCiudad();
    }

    // Getters y Setters...
}

public class ImpresorFacturas {
    public void imprimirFactura(Factura factura) {
        System.out.println(factura.generarEncabezado());
        System.out.println(factura.generarPie());
    }
}

public class Cliente {
    private String nombre;
    private Direccion direccion;

    public Cliente(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Getters y Setters...
}

public class ServicionNotificaciones {
    public void enviarNotificacion(Factura factura) {
        String ciudad = factura.getCliente().getDireccion().getCiudad();
        System.out.println("Enviando notificación a la ciudad: " + ciudad);
    }
}
´´´

3. Message Chain, el metodo enviarNotificacion le pide datos a la factura para realizar calculos, en ves de delegar la responsabilidad al mismo objeto factura, refactoring hide delegate, crear un metodo en la clase factura que devuelva la ciudad del cliente.

´´´java
public class Factura {
    private int numero;
    private double total;
    private Cliente cliente;

    public Factura(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public String generarEncabezado() {
        String encabezado = "Factura Nro: " + this.numero + "\n";
        encabezado += "Cliente: " + this.cliente.getNombre() + "\n";
        encabezado += "Direccion: " + this.cliente.getDireccion().getCalle() + ", " + this.cliente.getDireccion().getNumero() + ", " + this.cliente.getDireccion().getCiudad() + "\n";
        return encabezado;
    }

    public String generarPie() {
        return "Total: " + this.total + " - ciudad: " + this.cliente.getDireccion().getCiudad();
    }

    public String getCiudadCliente() {
        return this.cliente.getDireccion().getCiudad();
    }

    // Getters y Setters...
}

...

public class ServicionNotificaciones {
    public void enviarNotificacion(Factura factura) {
        String ciudad = factura.getCiudadCliente();
        System.out.println("Enviando notificación a la ciudad: " + ciudad);
    }
}
´´´

# Ejercico 4 - Jerarquia de vehiculos

1. Refused Bequest (Herencia rechazada), La clase vehiculo define despegar() y anclar(), pero Auto no usa ninguna de los dos, y Avion herada anclar() solo para recharlo. Refactorgin push down method, mover los metodos despegar() y anclar() a la clase Avion.
   
2. Lazy class (Clase perezosa), la clase Avion no tiene ningun comportamiento, refactoring collapse class, eliminar la clase avion y mover sus metodos a la clase Vehiculo.

3. spective generality (Generalidad especulativa), la clase Vehiculo tiene un metodo despegar() y anclar() que no son utilizados por todas las subclases, refactoring remove parameter, eliminar metodos; ValidadorPatentes es lazy class, refactorign inline class, eliminar la clase ValidadorPatentes y mover su metodo validar() a la clase Vehiculo.

# Ejercicio 5 - Gestion de biblioteca

´´´java 
public class Catalogo {
    private BaseDeDatos db;

    public List<Libro> buscarPorTitulo(String titulo) {
        return db.buscarPorTitulo(titulo);
    }

    public List<Libro> buscarPorAutor(String autor) {
        return db.buscarPorAutor(autor);
    }

    public Libro obtenerPorIsbn(String isbn) {
        return db.obtenerPorIsbn(isbn);
    }

    public void guardar(Libro libro) {
        db.guardar(libro);
    }

    public void eliminar(Libro libro) {
        db.eliminar(libro);
    }
    
    public BaseDeDatos getDb() {
        return db;
    }
}

public class ServicioPrestamos {
    private List<Prestamo> historial;
    private String ultimoPrestamoDetalle;
    private LocalDate ultimaFechaDevolucion;

    public void registrar(Prestamo p) {
        historial.add(p);
        ultimoPrestamoDetalle = p.getLibro().getTitulo() + " a " + p.getSocio();
        ultimaFechaDevolucion = p.getFechaDevolucion();
    }

    public String detalleUltimoPrestamo() {
        return ultimoPrestamoDetalle;
    }

    public void estadisticas() {
        // usa directamente los atributos internos de BaseDeDatos        
        BaseDeDatos db = Sistema.getBaseDeDatos();
        for (int i = 0; i < db.getTablas().size(); i++) {
            for (int j = 0; j < db.getTablas().get(i).getFilas().size(); j++) {
                
            System.out.println(db.getTablas().get(i).getFilas().get(j).get("libro"));
            }
        }
    }
}
´´´


1. Middle Man, La clase catalogo funciona como intermediario entre el servicio de prestamos y la base de datos sin agregar logica propia,
refactoring remove middle man, eliminar la clase catalogo, y que el servicio de prestamos se comunique directamente con la base de datos.

2. Temporary Field, ultimoPrestamoDetalle y ultimaFechaDevolucion son campos que solo se usan temporalmente en el metodo registrar, refactoring replace temp with query, eliminar los campos y calcular el detalle del ultimo prestamo y la ultima fecha de devolucion directamente en los metodos detalleUltimoPrestamo() y estadisticas().

3. Feature Envy, el metodo estadisticas() accede a los atributos internos de la clase BaseDeDatos, refactoring move method, mover el metodo estadisticas() a la clase BaseDeDatos. O bien si lo vemos como una message chain, refactoring hide delegate, crear un metodo en la clase BaseDeDatos que devuelva las estadisticas.

4. Comments, el comentario en estadisticas() indica que hace en vez del porque, refactoring remove comment, eliminar el comentario y agregar un nombre de metodo descriptivo.

# Parte B 

# Ejercicio 7 - Calculo de impuestos

```java 
    public class CalculadoraImpuestos {
        public double calcularMonto(String tipoContribuyente, double monto) {
            double resultado = 0;
            if (tipoContribuyente == "responsable_inscripto") {
                resultado = monto * 0.21;
            } else if (tipoContribuyente == "monotributo") {
                resultado = monto * 0.15;
            } else if (tipoContribuyente == "exento") {
                resultado = 0;
            } else if (tipoContribuyente == "no_residente") {
                resultado = monto * 0.30;
            }
            return resultado;
        }
    }
```

a) Codigo resultante:

```java 
    public class CalculadoraImpuestos {
        public double calcularMonto(TipoContribuyente tipoContribuyente, double monto) {
            return tipoContribuyente.getMonto(monto);
        }
    } 

    public interface TipoContribuyente {
        public double getMonto(double monto);
    }

    public class ResponsableInscripto implements TipoContribuyente {
        public double getMonto(double monto) {
            return monto * 0.21;
        }
    }

    public class Montoributo implements TipoContribuyente {
        public double getMonto(double monto) {
            return monto * 0.15;
        }
    }

    public class Excento implements TipoContribuyente {
        public double getMonto(double monto){
            return 0;
        }
    }

    public class NoResidente implements TipoContribuyente {
        public double getMonto(double monto){
            return = monto * 0.3;
        }
    }
```

b) Diagrama de clases UML

```plantuml

class CalculadoraImpuestos {
    + CalculadoraImpuestos(tipoContribuyente: TipoContribuyente; monto: double)
}

interface TipoContribuyente {
    + getMonto(monto:double)
}

class ResponsableInscripto {
    + getMonto(monto:double)
}

class Montoributo {
    + getMonto(monto:double)
}

class Excento {
    + getMonto(monto:double)
}

class NoResidente {
    + getMonto(monto:double)
}

ResponsableInscripto --|> TipoContribuyente
Montoributo --|> TipoContribuyente
Excento --|> TipoContribuyente
NoResidente --|> TipoContribuyente
```

c) 
```java 
    public class CalculadoraImpuestos {
        public double calcularMonto(TipoContribuyente tipoContribuyente, double monto) {
            return tipoContribuyente.getMonto(monto);
        }
    } 
```

---

# Devolución del Ejercicio 7 (Parte B)

**Nota orientativa: 8/10** — La estructura es exactamente la canónica del refactoring: interfaz + una clase por rama + cliente que delega. Se descuenta por errores de sintaxis, nombres y un diagrama que no coincide con el código.

## ✅ Lo que está bien

1. **Estructura correcta**: interfaz `TipoContribuyente` + 4 implementaciones + `calcularMonto` reducido a delegación pura (`return tipoContribuyente.getMonto(monto)`). Eso es *Replace Conditional with Polymorphism* en estado puro.
2. **Respondiste las tres consignas** (a, b, c) — más de lo que hiciste en los ejercicios de la Parte A.
3. Elegiste **interfaz** en vez de clase abstracta: decisión defendible (mejor incluso, porque no hay estado ni comportamiento común que compartir). Regla práctica: interfaz para contrato puro, clase abstracta cuando hay estructura compartida (como el *Template Method* del Ejercicio 11).
4. Cada tasa quedó en su clase: agregar un nuevo tipo = agregar una clase nueva sin tocar la calculadora (**Open/Closed**).

## ❌ Lo que resta

1. **Error de sintaxis**: `return = monto * 0.3;` en `NoResidente` — no compila. En un "código resultante" de parcial, un error de compilación resta puntos aunque el diseño sea perfecto.
2. **Nombres de clase**: `Montoributo` → `Monotributo`, `Excento` → `Exento`. Irónico perder puntos de ortografía en un ejercicio cuyo tema central es la claridad de nombres.
3. **`getMonto(double monto)` es un mal nombre**, y es justo lo que el curso enseña a evitar (mirá el 1.1 del cuadernillo: `lmtCrdt()` → `getLimiteCredito()`):
   - Un `get` que recibe parámetros no es un getter: **calcula**.
   - No dice qué devuelve: devuelve el **impuesto**, no "el monto".
   - El cliente llama `calcularMonto` y la interfaz dice `getMonto`: dos nombres para lo mismo.
   - Mejor: `calcularImpuesto(double monto)` o `aplicarImpuesto(double monto)`.
4. **El diagrama no coincide con el código**: dibujás `+ CalculadoraImpuestos(tipoContribuyente: TipoContribuyente; monto: double)` como si fuera un **constructor**, pero esa clase no tiene constructor — esos datos entran por el **método** `calcularMonto`. Debería ser:
   `+ calcularMonto(tipoContribuyente: TipoContribuyente, monto: double): double`
   Además, a `getMonto(monto:double)` le falta el tipo de retorno (`: double`).
5. **Flechas UML**: `TipoContribuyente` es **interfaz**, así que la relación es *realización*: línea **discontinua** con triángulo hueco → `TipoContribuyente <|.. ResponsableInscripto`. Con `--|>` (línea continua) estás dibujando herencia de clase, que contradice tu propio código.

## ⚆ Para llevarla de 8 a 10

1. **Responder la pregunta de seguimiento típica del parcial**: *"¿y quién crea las instancias?"*. Antes se pasaba un `String tipoContribuyente`; ahora alguien debe decidir si construye `new Monotributo()` o `new Exento()`. Mostrá un factory y aclará que el condicional sobre el String queda encapsulado **solo ahí**:

```java
public class TipoContribuyenteFactory {
    public static TipoContribuyente crear(String codigo) {
        switch (codigo) {
            case "responsable_inscripto": return new ResponsableInscripto();
            case "monotributo":           return new Monotributo();
            case "exento":                return new Exento();
            case "no_residente":          return new NoResidente();
            default: throw new IllegalArgumentException("Tipo de contribuyente inválido: " + codigo);
        }
    }
}
```

Esto demuestra que entendés el matiz clave: **el polimorfismo no elimina el condicional, lo confina a un solo punto de creación**.
2. `@Override` en cada implementación (prolijidad, y detecta errores de firma).
3. Las tasas `0.21`, `0.15`, `0.30` son *Magic Numbers*; nombradas (`TASA_IVA`) o al menos como constantes de cada clase queda impecable.
4. Detalle de formato: estás usando `´´´` (acento) en vez de ```` ``` ```` (backticks) para los bloques de código — el Markdown no los renderiza.

## 📋 Checklist mental para este tipo de ejercicio

1. Interfaz/clase abstracta con el método polimórfico bien **nombrado** (que diga qué calcula).
2. Una subclase por rama del `if/switch`, con `@Override`.
3. El cliente queda como delegación de una línea.
4. Diagrama **coherente con el código**: métodos con tipos de retorno, flecha discontinua para interfaces.
5. Aclarar dónde vive ahora la creación de objetos (factory).

# Ejercicio 8 - Clase Persona

```java 
public class Persona {
    private String nombre;
    private String apellido;
    private String calle;
    private String numeroCalle;
    private String piso;
    private String departamento;
    private String ciudad;
    private String codigoPostal;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellido, String calle, String numeroCalle, String piso, String departamento, String ciudad, String codigoPostal, String telefono, String email, LocalDate fechaNacimiento) {
        // ... 11 parámetros ...    
    }

    public String formatearDireccion() {
        return calle + " " + numeroCalle + " " + piso + " " + departamento + ", " + ciudad + " (" + codigoPostal + ")";
    }

    public int edad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
```

Consigna: Aplique Extract Class e Introduce Parameter Object (y, si corresponde, Preserve Whole Object).
Muestre las clases resultantes con sus firmas y cómo queda el constructor de Persona. 
Indique también qué mal olor adicional se corrige al agrupar la dirección.

```java
public class Direccion {
    private String calle;
    private String numeroCalle;
    private String ciudad;
    private String piso;
    private String departamento;
    private String codigPostal;
    
    //Getters and setters...


}

public class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private Direccion direccion;

    public Persona(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Direccion direccion) {
        //...
    }

    public String formatearDireccion() {
        return direccion.calle + " " + direccion.numeroCalle + " " + direccion.piso + " " + direccion.departamento + ", " + direccion.ciudad + " (" + direccion.sodigoPostal + ")";
    }

    public int edad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
```

Se introduce el bad semlls feature envy y lazy class, dado que el metodo formatearDireccion le pide los atributos a la direccion para formatear la direccion, y esto deberia ser resposabilidad del objeto Direccion.

```java

public class Direccion {
    private String calle;
    private String numeroCalle;
    private String ciudad;
    private String piso;
    private String departamento;
    private String codigPostal;
    
    //Getters and setters...

    public String formatearDireccion() {
        return calle + " " + numeroCalle + " " + piso + " " + departamento + ", " + ciudad + " (" + codigoPostal + ")";
    }
}

public class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private Direccion direccion;

    public Persona(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Direccion direccion) {
        //...
    }

    public String formatearDireccion() {
        return direccion.formatearDireccion();
    }

    public int edad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
```

---

# Devolución del Ejercicio 8 (Parte B)

**Nota orientativa: 8/10** — Excelente aplicación de la mecánica iterativa (Extract Class → detectás el Feature Envy que recién se introdujo → Move Method). Se descuenta porque no respondiste una pregunta explícita de la consigna y quedaron errores de compilación.

## ✅ Lo que está bien

1. **Metodología iterativa impecable**: primero hiciste *Extract Class*, después **notaste que `formatearDireccion()` quedó en Feature Envy** (le pide los atributos a `Direccion`) y lo moviste. Eso es exactamente lo que pide el ejercicio 2 del cuadernillo: *"Si vuelve a encontrar un mal olor, retorne al paso (i)"*. Es la primera vez que aplicás este ciclo completo, y es lo que más se valora en la corrección.
2. **Constructor de `Persona`**: pasó de 11 a 6 parámetros, pasando `Direccion` como objeto → *Introduce Parameter Object* / *Preserve Whole Object* aplicado correctamente.
3. **Preservaste el comportamiento**: `Persona.formatearDireccion()` sigue existiendo como delegación, así que ningún cliente se rompe. Un refactoring que mantiene la API visible es un refactoring bien hecho.
4. Buena noticia de forma: ya estás usando ` ``` ` (backticks) en vez de ` ´´´ ` — los bloques de código ahora sí renderizan.

## ❌ Lo que falta (y puntúa)

1. **No respondiste la pregunta de la consigna**: *"Indique qué mal olor adicional se corrige al agrupar la dirección"*. La respuesta esperada es **Data Clumps** (los 6 campos `calle`, `numeroCalle`, `piso`, `departamento`, `ciudad`, `codigoPostal` siempre viajan juntos: en el constructor, en `formatearDireccion`, etc.), con el bonus de evitar **Shotgun Surgery** (si cambia el formato de dirección, solo cambia `Direccion`). Vos contestaste otra cosa: qué smells se *introducen*, no cuál se *corrige*.
2. **"Lazy Class" está mal nombrado**: en el paso intermedio, `Direccion` con solo atributos + getters/setters es un **Data Class**, no un Lazy Class. *Lazy Class* = clase que no justifica su existencia por hacer tan poco (como `Avioneta` en el Ejercicio 4). *Data Class* = solo almacena datos sin comportamiento. Ojo con mezclarlos: en parcial el nombre exacto es lo que puntúa. (Y ojo 2: ese Data Class es **transitorio** — apenas movés `formatearDireccion()` hacia `Direccion`, deja de serlo. Eso vale aclararlo.)
3. **El código no compila** (dos problemas):
   - `Persona.formatearDireccion()` accede a `direccion.calle`, `direccion.piso`... pero esos atributos son **privados** de `Direccion`. Aunque dejaste el comentario `//Getters and setters...`, el código debería usar `direccion.getCalle()`, etc.
   - El campo de código postal aparece con **tres grafías distintas**: `codigPostal` (declaración), `sodigoPostal` (uso en `Persona`) y `codigoPostal` (uso en `Direccion`). Ninguna coincide con otra → no compila.
4. **Firmas incompletas**: la consigna pide "las clases resultantes **con sus firmas**" y `Direccion` no muestra constructor. Debería ser `Direccion(String calle, String numeroCalle, String piso, String departamento, String ciudad, String codigoPostal)`.

## ⚖️ Matiz interesante sobre tu resultado final

Dejaste `Persona.formatearDireccion()` delegando en `direccion.formatearDireccion()`. Está bien por **compatibilidad**, pero dos observaciones:
- Ese método es un **Middle Man** en potencia: si empiezan a acumularse delegaciones de una línea en `Persona` (`getCiudad()`, `getCodigoPostal()`...), ahí sí aplica *Remove Middle Man* y que los clientes usen `persona.getDireccion()`. La regla: una delegación para preservar API está bien; muchas = smell.
- Nombre en `Direccion`: preferí `formatear()` (es su propia dirección, no necesita repetir el sustantivo): `direccion.formatear()`. Es el mismo principio del Rename Method que ya vimos.

## 📋 Respuesta modelo (resumida)

1. **Data Clumps** (los 6 atributos de dirección viajan juntos) → **Extract Class** `Direccion` con constructor completo y `formatear()`.
2. **Long Parameter List** (constructor de 11 parámetros) → **Introduce Parameter Object / Preserve Whole Object**: `Persona(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Direccion direccion)`.
3. **Feature Envy** (post-extracción: `formatearDireccion` vive en `Persona` pero usa datos de `Direccion`) → **Move Method** → `Direccion.formatear()`.
4. *Mal olor corregido al agrupar*: **Data Clumps** (y se evita **Shotgun Surgery** futuro).

## ✏️ Detalles de forma

"bad semlls", "resposabilidad", "codigPostal/sodigoPostal/codigoPostal". Releé los nombres de identificadores antes de entregar: en un ejercicio sobre *claridad de nombres*, tres grafías del mismo campo es el error más caro del examen.

# Ejercicio 9 - Transferencia Bancarias
```java
public class Transferencia {
    private String cbuOrigen;
    private String cbuDestino;
    private double monto;
    private String moneda;   // "ARS", "USD", "EUR"    
    
    public Transferencia(String cbuOrigen, String cbuDestino, double monto, String moneda) {
        if (moneda != "ARS" && moneda != "USD" && moneda != "EUR") {
            throw new Error("Moneda inválida");
        }
        if (cbuOrigen.length() != 22) {
            throw new Error("CBU origen inválido");
        }
        // ...    }
    public double convertirA(String destino) {
        if (this.moneda == "ARS" && destino == "USD") return monto / 1000;
        if (this.moneda == "USD" && destino == "ARS") return monto * 1000;
        return monto;
    }
}
```

El bad smells detectado es primitive obssesion. La solucion Replace primitive with object:

```java 
public class Moneda {    
    public double convertirA(double monto, Moneda moneda) {

    }
}
```

# Ejercicio 10 - Gestion de reportes
```java
public class GeneradorReportes {
    public String generar(Reporte reporte, Filtro filtro) {
        String salida = "";
        if (filtro != null) {
            salida += filtro.aplicar(reporte.getDatos());
        } else {
            salida += reporte.getDatos();
        }
        if (filtro != null && filtro.esInvertido()) {
            salida = new StringBuilder(salida).reverse().toString();
        }
        return salida;
    }
    public String generarResumen(Reporte reporte, Filtro filtro) {
        String salida = "";
        if (filtro != null) {
            salida += filtro.aplicar(reporte.getDatos());
        } else {
            salida += reporte.getDatos();
        }
        return "Resumen: " + salida;
    }
}
```

Codigo: 

```java
public class filtroNull extends Filtro {
    @Override
    public String aplicar(String datos) {
        return datos;
    }

    @Override
    public boolean esInvertido() {
        return false;
    }
}

public class GeneradorReportes {
    public String generar(Reporte reporte, Filtro filtro) {
        String salida = filtro.aplicar(reporte.getDatos());
        if (filtro.esInvertido()) {
            salida = new StringBuilder(salida).reverse().toString();
        }
        return salida;
    }

    public String generarResumen(Reporte reporte, Filtro filtro) {
        String salida = filtro.aplicar(reporte.getDatos());
        return "Resumen: " + salida;
    }
}
```

# Ejercicio 11 - Notificaciones duplicadas

```java
public class NotificadorEmail {
    public void enviar(Mensaje m) {
        String destinatario = m.getDestinatario().trim().toLowerCase();
        if (!destinatario.contains("@")) {
            throw new Error("Destinatario inválido");
        }
        String cuerpo = "Estimado " + m.getDestinatario() + ": " + m.getTexto();
        EmailUtils.enviar(destinatario, cuerpo);
        Log.registrar("EMAIL", destinatario);
    }
}

public class NotificadorSMS {
    public void enviar(Mensaje m) {
        String destinatario = m.getDestinatario().trim().toLowerCase();
        if (!destinatario.contains("@")) {
            throw new Error("Destinatario inválido");
        }
        String cuerpo = "Estimado " + m.getDestinatario() + ": " + m.getTexto();
        SmsUtils.enviar(destinatario, cuerpo);
        Log.registrar("SMS", destinatario);
    }
}
```

```java
public abstract class Notificador {
    public void enviar(Mensaje m) {
        String destinatario = m.getDestinatario().trim().toLowerCase();
        if (!destinatario.contains("@")) {
            throw new Error("Destinatario inválido");
        }
        String cuerpo = "Estimado " + m.getDestinatario() + ": " + m.getTexto();
        enviarNotificacion(destinatario, cuerpo);
        Log.registrar(getTipoNotificacion(), destinatario);
    }

    protected abstract void enviarNotificacion(String destinatario, String cuerpo);
    protected abstract String getTipoNotificacion();
}

public class NotificadorEmail extends Notificador {
    @Override
    protected void enviarNotificacion(String destinatario, String cuerpo) {
        EmailUtils.enviar(destinatario, cuerpo);
    }

    @Override
    protected String getTipoNotificacion() {
        return "EMAIL";
    }
}

public class NotificadorSMS extends Notificador {
    @Override
    protected void enviarNotificacion(String destinatario, String cuerpo) {
        SmsUtils.enviar(destinatario, cuerpo);
    }

    @Override
    protected String getTipoNotificacion() {
        return "SMS";
    }
}
```