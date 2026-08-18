1. Hoja de Ruta de Estudio (Roadmap)
=====================================
1.  **Rutinas y Pasaje de Parámetros (Clase 6):** Comienza comprendiendo cómo se estructuran los programas en subunidades y cómo estas intercambian información. Es la base operativa del flujo de control inter-rutinas.
2.  **Estructuras de Control y Excepciones (Clase 9):** Una vez que entiendes la comunicación entre rutinas, pasa al flujo de control interno (a nivel de sentencia) y cómo se manejan los eventos inesperados o errores lógicos.
3.  **Tipos de Datos y Manejo de Memoria (Clases 7 y 8):** Profundiza en cómo se estructuran, alocan y liberan los datos que manipularás con las estructuras de control vistas anteriormente. Incluye el estudio de punteros, recolección de basura y encapsulamiento (TADs).
4.  **Paradigmas de Programación (Clases 11 y 12):** Finaliza con una visión arquitectónica de alto nivel, analizando cómo diferentes paradigmas (Lógico, Funcional, Orientado a Objetos y Aspectos) encaran la resolución de problemas utilizando todos los conceptos previos de distintas maneras.

---

2. Desarrollo y Resumen por Tema
================================

### Tema 1: Rutinas y Pasaje de Parámetros
*   Las **rutinas** (procedimientos y funciones) encapsulan sentencias para definir nuevas operaciones, favoreciendo la modularidad y reutilización mediante llamadas explícitas (*call/return*).
*   Las rutinas intercambian información principalmente mediante el acceso al **ambiente no local** (implícito o explícito) o mediante el uso de **parámetros** (la forma más segura y recomendada).
*   El **pasaje de parámetros** asocia parámetros formales (locales a la rutina) con parámetros reales (valores/variables enviados en la invocación). Los principales modos de pasaje son:
    *   **Modo IN (Por Valor):** Se copia el dato real y el parámetro formal actúa como variable local. Es seguro, pero ineficiente en tiempo y espacio para estructuras grandes.
    *   **Modo OUT (Por Resultado):** El formal actúa como variable local sin inicializar; al terminar, su valor se copia al parámetro real. Puede fallar si no se inicializa correctamente antes de salir.
    *   **Modo IN/OUT (Por Valor/Resultado):** Copia el valor del real al iniciar, trabaja localmente, y vuelve a copiar el resultado al terminar. Evita el *aliasing* durante la ejecución.
    *   **Modo IN/OUT (Por Referencia):** Se pasa la dirección de memoria (L-valor) del parámetro real. Ambos nombres apuntan a la misma ubicación (**aliasing**). Es muy eficiente pero riesgosamente propenso a efectos colaterales.
    *   **Modo IN/OUT (Por Nombre):** Pasa una expresión textual y un entorno evaluador llamado **thunk**. La expresión se evalúa dinámicamente cada vez que se usa el parámetro. Brinda **evaluación diferida**, pero es altamente complejo e ineficiente.
*   **Subprogramas como parámetros:** Al pasar subrutinas como argumentos, se debe definir el entorno de referencia para sus variables libres. Esto se hace mediante reglas de ligadura: **Deep/Profunda** (entorno de definición, usado con alcance estático), **Shallow/Superficial** (entorno de ejecución/llamada) o **Ad-hoc** (entorno desde el cual se pasó el subprograma).
*   Como alternativa estática, lenguajes como Ada proveen **unidades genéricas** (*templates* o plantillas) que se instancian en tiempo de compilación para operar con diferentes tipos de manera segura.

**Cuestionario de Parcial - Tema 1**
1. Explique las diferencias operativas y de seguridad en memoria entre el pasaje de parámetros por Valor/Resultado y el pasaje por Referencia.
2. ¿Qué es un "Thunk" y qué problema resuelve en el pasaje de parámetros por Nombre?
3. Indique la diferencia entre ligadura *Deep* (profunda) y *Shallow* (superficial) al resolver el entorno de un subprograma pasado como parámetro.

---

### Tema 2: Estructuras de Control y Excepciones
*   Las **estructuras de control a nivel de sentencia** dirigen el flujo lógico de ejecución en tres grupos fundamentales: Secuencia, Selección e Iteración.
*   La **Secuencia** ejecuta el código instrucción a instrucción, pudiendo usar **sentencias compuestas** delimitadas por bloques (ej. `begin/end` o `{ }`) según el lenguaje.
*   La **Selección** (`if`, `case`, `switch`) genera bifurcaciones. Problemas de legibilidad o ambigüedad como el *dangling else* se resuelven forzando emparejamientos sintácticos o usando palabras explícitas de cierre (ej. `end if`).
*   En estructuras de selección múltiple (como `switch`), el comportamiento **"falling through"** (C/C++) requiere el uso de `break` explícito para no seguir ejecutando los casos consecutivos. Otros lenguajes exigen cierres lógicos como la cláusula `others` (Ada) para evitar variables no inicializadas.
*   **Evaluación de Expresiones Lógicas:** El **circuito corto** (evaluación perezosa) evalúa operandos lógicos de izquierda a derecha y se detiene apenas el resultado final ya está determinado. Esto evita excepciones como división por cero o accesos a punteros nulos, y optimiza el rendimiento. Lenguajes como C, Java y Python usan circuito corto, mientras Pascal usa evaluación estricta (circuito largo).
*   La **Iteración** permite repeticiones condicionadas. Existen bucles con número conocido de pasadas (`for`) y condicionales controlados al inicio (`while`) o al final (`do-while` / `repeat-until`).
*   **Excepciones:** Permiten controlar flujos atípicos de error. En lenguajes como PL/1 se utiliza un **modelo de reasunción**, donde el proceso no termina, sino que se atiende la excepción (mediante una pila de manejadores configurados con `ON CONDITION`) y el flujo continúa.

**Cuestionario de Parcial - Tema 2**
1. Explique la diferencia entre "circuito corto" y "circuito largo" al evaluar expresiones. Dé al menos dos ejemplos de errores en tiempo de ejecución que el circuito corto ayuda a prevenir.
2. ¿Qué comportamiento describe el "falling through" en C/C++ y cómo afecta la seguridad y legibilidad del código?
3. Describa brevemente cómo PL/1 determina qué manejador invocar cuando se levanta una excepción bajo el modelo de reasunción.

---

### Tema 3: Tipos de Datos y Manejo de Memoria
*   Un **Tipo de Datos** define un conjunto de valores posibles y las operaciones permitidas sobre ellos.
*   Existen tipos predefinidos (elementales) que reflejan el hardware subyacente, y **tipos definidos por el usuario** mediante constructores como:
    *   **Producto Cartesiano:** tuplas y registros (`struct` en C).
    *   **Correspondencia Finita:** funciones que mapean índices a valores (arreglos, colecciones).
    *   **Recursión:** estructuras autoreferenciadas de tamaño arbitrario creadas enlazando nodos en memoria (listas ligadas).
*   **Punteros:** Son variables cuyo R-valor es una referencia (dirección de memoria) a otro objeto. Aunque potentes, generan severas **inseguridades**: referencias colgantes (*dangling*), pérdida de memoria, violación de tipos y *aliasing*.
*   **Manejo de Memoria / Garbage Collector (GC):** Estrategias automáticas para recuperar espacio inalcanzable de la Heap.
    *   *Recolección por trazado:* Usa un conjunto raíz de punteros de la pila para marcar los objetos alcanzables en la Heap. Lo no marcado se elimina.
    *   *Inversión de punteros:* Evita usar una pila auxiliar incrustando el control de reversa en los campos de los bloques de memoria.
    *   *Cuenta de referencias y generaciones:* Clasifica los objetos y mantiene un contador. Si llega a 0, se destruye la entidad. Rust resuelve esto sin GC, aplicando estrictas reglas de **Ownership** (Propiedad) donde un valor solo puede tener un dueño.
*   **Tipo de Dato Abstracto (TAD):** Representación de datos más sus funciones encapsuladas bajo el principio básico de **información oculta**. Esto derivó históricamente en el concepto de Clases de la Orientación a Objetos.
*   **Sistema de Tipos y Polimorfismo:**
    *   **Polimorfismo paramétrico:** Un tipo se define tomando otro tipo como argumento genérico (ej. `lista(T)`).
    *   **Polimorfismo por inclusión:** Modela relaciones de herencia y subtipado, donde un subtipo contiene un subconjunto de los valores y el mismo conjunto de operaciones de su tipo superior.

**Cuestionario de Parcial - Tema 3**
1. Indique tres fuentes de inseguridad generadas por el uso de punteros para la creación de estructuras recursivas.
2. Describa brevemente en qué consiste la técnica de recolección de basura por "Trazado".
3. Defina el concepto de Tipo de Dato Abstracto (TAD) y qué mecanismo principal utiliza para manejar la complejidad.
4. ¿Cómo clasificaría el mecanismo que permite definir a la entidad "Febrero" como un subtipo del conjunto "Meses" conservando sus operaciones?

---

### Tema 4: Paradigmas de Programación
*   **Paradigma Funcional:** El valor más importante es la **función** y las mismas son tratadas como valores de primera clase (pueden ser argumentos y retornos). Su base es el **Cálculo Lambda**, independiente de sintaxis formales y fundamentado en simplificación y sustitución. Permite enfoques como la **evaluación perezosa** (deferida, calculando sólo lo necesario) y el proceso de **currificación** (transformar funciones que reciben estructuras múltiples en cadenas anidadas de funciones de un solo argumento).
*   **Paradigma Lógico (Declarativo):** Describe los resultados esperados usando reglas deductivas en lugar de secuencias de comandos explícitas. Un programa en Prolog consiste en **Cláusulas de Horn**, clasificadas en:
    *   **Hechos:** Verdades o relaciones absolutas (ej. `tiene(coche,ruedas)`).
    *   **Reglas:** Evaluaciones lógicas anidadas de la forma `conclusión :- condición`.
    *   **Queries:** Consultas del usuario a las que el sistema busca responder deduciendo o infiriendo la cadena de variables.
*   **Programación Orientada a Objetos (POO):** Basada en la interacción de objetos (instancias de Clases) enviándose **mensajes** para desencadenar la ejecución de **métodos**. Las Clases brindan un segundo nivel de abstracción generando jerarquías de herencia.
*   **Programación Orientada a Aspectos:** Permite dividir lógicas transversales (que atraviesan distintas capas del sistema, como auditorías). Inserta comportamiento encapsulado en **Advice (consejos)** dentro de la clase **Target (objetivo)** en puntos específicos denominados **Joinpoints**, todo mediante un proceso llamado **Weaving (costura)**.

**Cuestionario de Parcial - Tema 4**
1. Diferencie conceptualmente un "Hecho" de una "Regla" dentro del paradigma lógico, indicando su sintaxis para una cláusula de Horn.
2. ¿A qué se refiere el término "currificación" en la programación funcional y qué ventaja provee al definir los tipos de una función?
3. En la programación orientada a aspectos, defina brevemente el rol que cumplen el "Advice" y el "Joinpoint".

---

*Nota explícita sobre conceptos incompletos en el material:* En tu hoja de ruta del Tema 2 (Estructuras de control y Excepciones), el apunte correspondiente a *Excepciones* es una captura muy mínima enfocada mayoritariamente en PL/1 (modelo de reasunción) y un fragmento de código de Python. Si la cátedra evalúa los diferentes **"Modelos de Manejo de Excepciones" (Terminación vs. Reasunción vs. Retiro)** y sus diagramas de control asociados, deberías buscar la bibliografía obligatoria recomendada, ya que esa parte teórica profunda no está cubierta exhaustivamente en las diapositivas disponibles.

---
---

3. Clave de Respuestas (Autoevaluación)
======================================

**Soluciones - Tema 1: Rutinas y Pasaje de Parámetros**
1. **Diferencia IN/OUT vs Referencia:** En Valor/Resultado (IN/OUT) el subprograma trabaja con una copia local independiente (L-Valor propio) sin vincularse en tiempo de ejecución al real, y al final sobreescribe el parámetro real de una sola vez. En Referencia, se comparte el L-Valor originando *aliasing*, provocando que toda modificación afecte inmediatamente a la variable de origen, lo que puede causar fallos de seguridad y legibilidad.
2. **Thunk / Pasaje por Nombre:** Un Thunk es un puntero/bloque de código encapsulado utilizado en el pasaje por Nombre. Pospone la evaluación de la expresión enviada como parámetro hasta el instante exacto en que sea usada (evaluación diferida), calculándola siempre en el entorno dinámico de quien invocó el proceso.
3. **Reglas de Ligadura en Subprogramas pasados como parámetro:** La ligadura *Deep* (profunda) liga a las variables libres del subprograma en el entorno léxico donde este fue originalmente definido o declarado. La ligadura *Shallow* (superficial), en cambio, resuelve el ambiente en el entorno exacto en donde se está ejecutando la instrucción de llamada al momento dinámico (quien lo invoca).

**Soluciones - Tema 2: Estructuras de Control y Excepciones**
1. **Circuito Corto:** Consiste en evaluar expresiones lógicas (AND/OR) de izquierda a derecha, frenando drásticamente el proceso al detectar el primer valor que sella de modo definitivo el resultado final, previniendo así errores en tiempo de ejecución. Ejemplos: previene división por cero (`return (x!=0) && (10/x)`) o evita índice fuera de rango (`IndexError`) al chequear una longitud antes de acceder.
2. **Falling Through:** En constructores `switch` o casos múltiples de C/C++, ocurre cuando se omite el `break`. Causa que la ejecución transite desde un bloque `case` coincidente hacia los bloques subsiguientes de forma secuencial indiscriminada. Puede inducir fallos semánticos graves en la lógica y arruinar la legibilidad de la elección.
3. **Manejo de Excepciones:** PL/1 utiliza el mecanismo de *reasunción*, el cual estipula que un proceso fallido no se liquida de inmediato, sino que se suspende, transfiere el control a su manejador apilado (`ON CONDITION`) y luego reanuda la operación en la sentencia siguiente al origen de la falla.

**Soluciones - Tema 3: Tipos de Datos y Manejo de Memoria**
1. **Inseguridades de punteros:** Violación de tipos, referencias sueltas/colgantes (dangling), variables no inicializadas, uniones vulnerables, *aliasing*, y liberación de memoria ineficiente con objetos perdidos.
2. **Estrategia por trazado (GC):** En esta estrategia, el Garbage Collector entra en acción al acabarse la memoria. Genera un conjunto de trabajo (T) rastreando los punteros desde la pila hacia la Heap. Marca y recorre todo objeto vivo y sus descendientes, considerando a los elementos inalcanzables como basura a eliminar.
3. **TAD y principio básico:** El TAD es la especificación estricta de una representación de datos asociada obligatoriamente a sus funciones matemáticas / operaciones lógicas. El principio elemental que lo enmarca es la *ocultación de la información* (abstracción) aislando la implementación física del consumidor del dato.
4. **Polimorfismo:** Pertenece al *Polimorfismo Universal de Inclusión*. En este modelo se determinan los constructos de herencia o subtipados en donde se acota el conjunto de valores y mantiene firmes las propiedades/comportamientos elementales de su clase superior (Meses).

**Soluciones - Tema 4: Paradigmas de Programación**
1. **Hechos vs. Reglas en Prolog:** El "hecho" manifiesta una verdad indudable o relación elemental y atómica sin variables condicionantes sintácticas (ej. `longitud([],0)`). La "Regla" o cláusula estipula una dependencia lógica estructurada como `conclusión :- condición`, actuando como el equivalente a un IF invertido evaluando conjunciones (AND) del lado derecho.
2. **Currificación:** Consiste en atomizar una estructura funcional multicapa reemplazando argumentos agrupados o parámetros tuplados por una cadena de evaluación parcial simple. Esto descompone la función en firmas en donde cada bloque individual exige y absorbe un solo argumento retornado una subfunción especializada.
3. **Advice y Joinpoint en POAspectos:** En la programación por aspectos transversal, un *Advice* (consejo) es concretamente el encapsulamiento de código interceptor inyectado en ejecución, mientras que el *Joinpoint* (punto de cruce) determina explícitamente el instante preciso, clase física y regla operativa elegida en la línea temporal donde dicho código debe incorporarse e incidir.