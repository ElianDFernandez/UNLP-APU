# Autoevaluación

---

## Pregunta 1 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** ¿Cuáles de las siguientes intervenciones aseguran una correcta experiencia de navegación exclusivamente por teclado? (Seleccioná todas las que correspondan)

- a. Asumir que el usuario siempre utilizará un dispositivo apuntador (mouse o pantalla táctil).
- b. ✅ Asegurar indicadores visuales de foco claros y visibles al navegar (evitar ``outline: none`` sin reemplazo).
- c. ✅ Evitar trampas de foco (focus traps) que impidan desplazarse fuera de componentes emergentes o modales.
- d. Remover de la página la totalidad del atributo ``tabindex``.
- e. ✅ Mantener un orden de tabulación totalmente coherente con la secuencia visual y lógica de la lectura.

> **Retroalimentación:** Garantizar un foco visual claro, evitar trampas donde el usuario quede atrapado y conservar la secuencia lógica de tabulación son requisitos esenciales del principio Operable.
>
> **Respuestas correctas:** b, c, e

---

## Pregunta 2 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** ¿Cuál es la diferencia principal entre ``<section>`` y ``<div>``?

- a. ``<section>`` solo puede usarse dentro de ``<body>``, ``<div>`` en cualquier lugar
- b. No hay ninguna diferencia funcional ni semántica
- c. ``<div>`` es un elemento en desuso reemplazado por ``<section>``
- d. ✅ ``<section>`` tiene significado semántico y agrupa contenido temáticamente relacionado; ``<div>`` no tiene significado semántico

> **Retroalimentación:** Esa es justamente la razón por la que HTML5 introdujo ``<section>``, ``<article>``, etc.: dar significado que ``<div>`` no aporta.
>
> **Respuesta correcta:** d

---

## Pregunta 3 ❌
**Puntaje:** 0,00 / 1,00

**Enunciado:** ¿Para qué se utiliza la etiqueta ``<section>``?

- a. Para definir una región de la página que contiene contenido indirectamente relacionado con el contenido principal.
- b. Para el encabezado de la página o de una sección.
- c. ✅ Para definir una sección genérica de un documento, como un capítulo o un grupo de contenido temático.
- d. Para agrupar contenido que es independiente y autosuficiente, como una entrada de blog. *(Esta es la función de ``<article>``)*

> **Respuesta correcta:** c

---

## Pregunta 4 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** ¿Cuáles son los 4 principios fundamentales que estructuran las pautas WCAG (acrónimo POUR)? (Seleccioná todas las que correspondan)

- a. ✅ **Operable** (Operable)
- b. ✅ **Comprensible** (Understandable)
- c. Adaptable (Adaptable)
- d. ✅ **Robusto** (Robust)
- e. Rápido (Fast)
- f. ✅ **Perceptible** (Perceivable)

> **Retroalimentación:** Los 4 principios POUR forman los cimientos sobre los cuales se redactan todas las pautas y criterios de conformidad de accesibilidad.
>
> **Respuestas correctas:** a, b, d, f

---

## Pregunta 5 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** ¿De qué color se muestra el texto "Mi color favorito"?

- a. azul
- b. amarillo
- c. ✅ rojo
- d. verde
- e. naranja

> **Retroalimentación:** La prioridad la tiene la declaración asociada al elemento en su definición.
>
> **Respuesta correcta:** c

---

## Pregunta 6 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** De las siguientes opciones, ¿cuál selector posee el nivel de especificidad más alto en CSS?

- a. ``*`` (selector universal)
- b. ``p`` (selector de elemento)
- c. ``.mi-clase`` (selector de clase)
- d. ✅ ``#mi-identificador`` (selector de ID)

> **Retroalimentación:** La especificidad en CSS se calcula en jerarquía: estilos en línea > ID > clases/atributos/pseudoclases > elementos/pseudoelementos.
>
> **Respuesta correcta:** d

---

## Pregunta 7 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** ¿Qué es el "foco" (focus) en el contexto de accesibilidad web?

- a. El color principal del sitio
- b. ✅ El elemento actualmente seleccionado o activo para interacción, típicamente mediante teclado
- c. El nivel de zoom aplicado a la página
- d. La resolución de pantalla del dispositivo

> **Retroalimentación:** Poder ver y controlar el foco es esencial para usuarios que navegan sin mouse.
>
> **Respuesta correcta:** b

---

## Pregunta 8 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** DOM es...

- a. Ninguna de las otras opciones mostradas es correcta.
- b. Una extensión de HTML para acceder a los elementos del documento.
- c. Una librería JavaScript que me permite acceder a los elementos del documento HTML.
- d. Una extensión del navegador que me permite visualizar los elementos del documento HTML.
- e. ✅ Una API a través de la cual se provee funcionalidad para manipular los elementos del documento HTML.

> **Retroalimentación:** También permite el manejo de eventos.
>
> **Respuesta correcta:** e

---

## Pregunta 9 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** ¿Cuál es la función del atributo ``alt`` en una etiqueta de imagen ``<img>``?

- a. ✅ Aportar una alternativa textual que será leída por los lectores de pantalla o mostrada si la imagen no carga.
- b. Acelerar el tiempo de renderizado de la imagen.
- c. Mostrar un mensaje o tooltip al situar el puntero del mouse sobre la gráfica.
- d. Establecer las proporciones dimensionales de la imagen.

> **Retroalimentación:** Proporcionar una descripción textual equivalente es obligatorio para garantizar el principio de Perceptibilidad en imágenes informativas.
>
> **Respuesta correcta:** a

---

## Pregunta 10 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** Para agrupar una serie de enlaces de navegación en una página web, ¿cuál es la etiqueta semántica recomendada?

- a. ``<header>``
- b. ✅ ``<nav>``
- c. ``<aside>``
- d. ``<footer>``

> **Retroalimentación:** La etiqueta ``<nav>`` está específicamente pensada para agrupar enlaces de navegación principales, facilitando la comprensión de la estructura del sitio para los lectores de pantalla y motores de búsqueda.
>
> **Respuesta correcta:** b

---

## Pregunta 11 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** Las etiquetas ``<div>`` y ``<span>`` son consideradas no semánticas. ¿Qué significa esto?

- a. Son invisibles para los navegadores y no se renderizan.
- b. ✅ Su propósito es simplemente agrupar contenido para aplicar estilos o manipularlo con JavaScript, sin un significado inherente para el contenido que contienen.
- c. No tienen ningún propósito en el desarrollo web y deben evitarse.
- d. Solo pueden ser usadas dentro de etiquetas semánticas.

> **Retroalimentación:** Las etiquetas ``<div>`` y ``<span>`` son contenedores genéricos que no transmiten información sobre el tipo de contenido que albergan, lo que las hace no semánticas.
>
> **Respuesta correcta:** b

---

## Pregunta 12 ❌
**Puntaje:** 0,00 / 1,00

**Enunciado:** La cláusula ``doctype``...

- a. Indica que el tipo de archivo transferido: en este documento texto con formato HTML.
- b. Indica la versión de JavaScript con la que el navegador debe procesar los scripts.
- c. ✅ Indica la versión de HTML utilizada en el documento.
- d. Ninguna de las otras opciones mostradas es correcta.

> **Respuesta correcta:** c

---

## Pregunta 13 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** ¿Cuál es la diferencia conceptual entre ``margin`` y ``padding``?

- a. Ambas propiedades funcionan de forma idéntica, la distinción es solo por convención.
- b. ✅ ``margin`` es el espacio exterior alrededor del borde; ``padding`` es el espacio de separación interior entre el borde y el contenido.
- c. ``margin`` altera el color del borde y ``padding`` el color del texto.
- d. ``padding`` es el espacio exterior y ``margin`` es el espacio interior.

> **Retroalimentación:** Padding define el espacio interno entre el contenido y el borde; margin genera el espacio externo que separa al elemento de sus vecinos.
>
> **Respuesta correcta:** b

---

## Pregunta 14 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** ¿Qué indica explícitamente la presencia de la declaración ``aria-invalid="true"`` en un campo de entrada?

- a. Indica que el control es únicamente de lectura (readonly).
- b. Señala que el campo se encuentra deshabilitado para la edición.
- c. Indica que el campo es de llenado obligatorio.
- d. ✅ Comunica a las tecnologías asistivas que el contenido o valor actual del campo contiene un error de validación.

> **Retroalimentación:** El atributo ``aria-invalid`` advierte al software de asistencia que los datos ingresados no se ajustan al formato o reglas del campo.
>
> **Respuesta correcta:** d

---

## Pregunta 15 ✅
**Puntaje:** 1,00 / 1,00

**Enunciado:** Si dos selectores CSS con la misma especificidad hacen referencia al mismo elemento, ¿qué regla se aplica?

- a. ✅ La última regla que aparece en la hoja de estilos.
- b. No se aplica ninguna de las dos reglas.
- c. La primera regla que aparece en la hoja de estilos.
- d. La regla que utilice unidades relativas (em, rem).

> **Retroalimentación:** CSS aplica las reglas en cascada. Cuando la especificidad es la misma, la última regla declarada en el código anula a las anteriores.
>
> **Respuesta correcta:** a

---

**Resumen:** 13/15 correctas (86,7%)