Resumen de temas:
- **Tema 1: Introducción y procesamiento de lenguajes.**
	-  Paradigmas de programación
	- Sintaxis vs Semántica 
	- Interprete vs Compilador
- Tema 2: Las Etapas de la compilacion.
	- 1.Analizador Lexico (Scanner)
	- 2.Analizador Sintáctico (Parser)
	- 3.Semantica Estática
	- 4.Etapa de Síntesis
- Tema 3: Semantica Dinámica (Enforques)
	- Axiomatica
	- Denotacional
	- Operacional 
- Tema 4: Las variables y la 5 tupla 
	- Concepto de ligadura
	- Alcance (scope)
	- Tiempo de vida(l-valor)
- Tema 5: Unidades de Programa y Parametros 
	- Declaración vs Definición 
	- Pasaje de Parametros 
- Tema 6: Modelos de ejecución y pilzas

## Tema 1: Introduccion y procesamiento de lenguajes

### 1.Los Componentes Principales de un Lenguaje

Todos los lenguajes de programación se definen a través de cinco componentes esenciales:
- **Sintaxis:** Es el conjunto de reglas que determinan como se deben estructurar y escribir validamente las instrucciones. Para definirla se utilizan gramáticas formales (como BNF o EBNF)(Gramatica = sintaxis + Semántica) y métodos de analisis (Parsing) que construyen arboles de derivación para verificar que una operación esta bien formada.
- **Semántica:** Define el significado exacto de esas construcciones sintacticas. Se divide en:
	- Estática: se chequea antes de  la ejecución (En compilacion) y revisa cosas que la sintaxis no atrapa, como que una variables este declarada antes de usarse o la compatibilidad de tipos.
	- Dinámica: Describe como se ejecuta el programa paso a paso y los cambios de estado en la memoria. Tiene enfoques como el operacional (maquina abstracta), denotacional (funciones matemáticas) y axiomático (predicados y logica).
- **Sistema de tipos:** establece reglas sobre los tipos de datos para detectar errores y garantizar la consistencia. 
- **Modelo de ejecución:** Define si el programa sera compilado, interpretado o utilizara un modelo híbrido.
- **Mecanismos de abstraccion:** Son las herramientas que provee el lenguaje para manejar la complejidad, como estructuras de control, módulos, funciones o clases.

### 2.Procesamiento del lenguaje: Compiladores vs Interpretes

Dado que las computadoras solo entienden lenguaje de maquina (Ceros y unos), el codigo fuente de alto nivel debe ser procesado. Existen dos grandes enfoques con diferencias muy marcadas.
**El Compilador:** 
	- 