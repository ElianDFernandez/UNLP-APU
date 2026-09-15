Los **principios POUR** son los cuatro pilares fundamentales que estructuran las pautas de accesibilidad web **WCAG** (Web Content Accessibility Guidelines) del W3C/WAI. Cada letra del acrónimo representa una condición esencial que debe cumplir un sitio web:

---

### 1. **P**erceptible (Perceivable)
La información y los componentes de la interfaz de usuario **no pueden ser invisibles a los sentidos** de las personas.
* **Alternativas textuales:** Es obligatorio proporcionar descripciones equivalentes para contenido no textual, como el atributo `alt` en etiquetas de imágenes informativas `<img>`.
* **Contraste de color:** Se debe asegurar un contraste visual suficiente entre el texto y su fondo para facilitar la lectura.
* **Adaptabilidad:** La interfaz debe permitir ajustes de zoom (por ejemplo, hasta un 200%) sin desbordamientos de texto ni pérdida de funcionalidad.

---

### 2. **O**perable (Operable)
Los componentes de la interfaz y la navegación **deben poder ser utilizados por cualquier usuario**, independientemente del dispositivo de entrada que emplee.
* **Navegación por teclado:** Toda la funcionalidad debe estar disponible navegando únicamente con el teclado (usando las teclas `Tab`, `Shift+Tab`, `Enter` y `Espacio`).
* **Indicadores visuales de foco:** El elemento activo debe ser claramente visible durante la navegación por teclado (se debe evitar aplicar `outline: none` sin añadir una alternativa visual equivalente).
* **Sin trampas de foco (*focus traps*):** Debe ser posible desplazarse dentro y fuera de cualquier componente (como modales o menús emergentes) sin quedar atrapado.
* **Orden de tabulación:** La secuencia de foco al tabular debe seguir un orden lógico y coherente con la lectura visual de la página.

---

### 3. **C**omprensible (Understandable)
La información, el contenido y el funcionamiento de la interfaz **deben ser claros y predecibles** para las personas.
* **Comportamiento predecible:** Los elementos interactivos no deben cambiar el contexto de la página de forma inesperada al recibir el foco o interactuar con ellos.
* **Asistencia ante errores:** Los formularios deben incluir instrucciones claras e identificar de manera explícita los errores de validación (por ejemplo, notificando a las tecnologías asistivas mediante atributos como `aria-invalid="true"`).

---

### 4. **R**obusto (Robust)
El código debe ser lo suficientemente consistente para **funcionar de manera confiable** en una gran variedad de navegadores y tecnologías de asistencia (como lectores de pantalla NVDA, JAWS o VoiceOver) tanto actuales como futuras.
* **HTML5 semántico nativo:** Siempre se debe priorizar el uso de etiquetas HTML5 semánticas (`<button>`, `<nav>`, `<header>`), ya que traen integrada la accesibilidad y el soporte de teclado por defecto.
* **Uso correcto de WAI-ARIA:** Los atributos WAI-ARIA (roles, estados y propiedades) solo deben utilizarse cuando los elementos HTML5 nativos no sean suficientes para comunicar el significado semántico en interfaces dinámicas.

---