# 1. Ingenieria de software
## ¿Que es la ingenieria de software?
Es una disciplina de la ingenieria que se interesa por todos los aspectos de la produccion de software.
Sus actividades son:
- Especificacion
- Desarrollo
- Validacion
- Evolucion
Tambien se realizacn actividades como la gestino de proyectos y el desarrollo de software.

## Definicion segun IEEE
- **Usa metodos sistematicos cuantificables**: La cuantificacion de recursos,proceso y productos es necesaria para optimizar productividad y calidad.
- **Procede dentro de tiempos y costos estimados**: Un ingeniero de software debe cumplir contratos en tiempo y costos.
- **Es utilzada para el "Desarrollo, oprecacion y mantenimiento"**: Se ocupa de todo el ciclo de vida de un producto.

## ¿Que conocimientos debe tenerun ingeniero de software?
El ingeniero de software debe conocer las tecnologias y productos, como sisitemas operativos, lenguajes, bases de datos,etc. Asi tambiene conocer tecnicas de administracion de proyectos. Los Ingenieros de software debe aceptar responsabilidades mas amplias que las responsabilidades tecnicas.
**Responsabilidad y etica laboral (CCDU)**
- Confidencialidad: respetar la confidencialidad de sus empleados y clientes.
- Competencia: No falsificar el nivel de competencia y aceptar responsabilidades fuera de su capacidad.
- Derechos de la propiedad intelectual: Conocer leyes vigentes sobre las patentes  y copyright.
- Uso inapropiado de las computadoras: No debe utilizar sus habilidades tecnicas para el uso inapropiadao de otras computadoras.

# 2. Requerimientos 
## ¿Que es un requerimiento?
Son descripciones de lo que el sistema debe hacer: el servicio que ofrece y las restricciones en su operacion.
Las prinicipales fuentes de requerimientos son los stakeholders, documentacion y especificaciones de sistemas similares.
**Impacto de los errores en la etapa de requerimientos**
- El software resultante puede no satisfacer a los usuarios .
- Las interpretaciones multiples de los requerimientos pueden causar desacuerdos entre los desarrolladores y los clientes.
- Puede gastar tiempo y dinero construyendo el sistema erroneo.

## Requerimientos funcionales y no funcionales 
**Requerimientos funcionales**: Decriben lo que el sistema debe hacer o incluso como el sistema no debe comportarse. Decriben la interaccion entre el sistema y su ambiente, como debe comportarse el sistema ante determinado estimulo.
**Requerimientos no funcionales**: Describen restricciones del sistema que limitan la construccion de una solucion.
**Tipos:**
- Requerimientos del productos: Especificaion comportamientos del producto. (Usabilidad, eficiencia, rendimiento, espacio, fiabilidad, portabilidad).
- Requerimientos organizacionales: Se derivan de las politicas y procedimientos en la organizacion.
- Requerimientos externos: Interoperabilidad, legales, privacidad, seguridad, eticos, etc.
- Requerimientos del dominio: Reflejan las caracteristicas y restricciones del dominio de la aplicacion del sistema.
- Requerimientos por prioridad: Deben ser absolutamente satisfechos, son deseables pero no indispensables, son posibles pero que podrian eliminarse.
- Requerimientos del usuario: Declaraciones en lenguaje natural y diagramas de los servicios que se espera que el sistema provea.

# 3. Stakeholder
Cualquier persona o grupo que sea vera afectadi por el sistema, directa o indirectamente. Aportan visiones diferentes con respecto al sistema.
**Puntos de vista**
Un punto de vista se refiere a las diferentes perspectivas que los stakeholders pueden tener con respecto a un sistema
- Punto de vista de los interactuadores: representan a las personas u otros sistemas que interactuan directamente con el sistema.
- Punto de vista indirecto: representan a los stakeholder que no utilizar el sistema ellos mismos, pero que afectan a los requerimientos.
- Punto de vista del dominio: representan caracteristicas y restricciones del dominio que influyen en los requerimientos del sistema.

# 4. Elicitacion de requerimientos 
Es el proceso de adquirir todo el conocimiento relevante necesario para producir un modelo de los requerimientos de un dominio de problema.
La elicitacion de requerimientos es una actividad principalmente de caracter social, mucho mas que tecnologico.
**Problemas a la hora de elicitar**:
* Comunicacion
    - (Cliente) Dificultad para expresar necesidades
    - (Cliente) No ser conciente de sus necesidades
    - (Cliente) No entender como la tecnologia puede ayudar
    - (Cliente) Miedo a parecer incomlpetentes por ignorancia tecnologica
    - (Desarrolladores) No tomar decisiones por no poder prever las consecuencias, no entender las alternativas o no tener una vision global
    - (Desarrolladores) Cultura y vocabulario diferentes, conflictos personal o politicos
    - (Desarrolladores) Intereses distintos en el sistema a desarrollar
    - (Desarrolladores) Medios de comunicacion inadecuados
* Limitaciones cognitivas (Por parte del desarrollador)
    - No conocer el dominio del problema
    - Hacer suposiciones sobre el dominio del problema
    - Hacer suposiciones sobre aspectos tecnologicos
    - Hacer simplificaciones excesivas
* Conducta humana 
    - Conflictos y ambiguedades en los roles de los participantes
    - Pasividad de clientes, usuarios o ingenieros de requisitos
    - Temor a que el nuevo sistema lo deje sin trabajo
* Tecnicos 
    - Complejidad del dominio del problema
    - Complejidad de los requisitos 
    - Multiples fuentes de requisitos 
    - Fuentes de informacion poco claras

## Fuentes de informacion 
### Metodos discretos: 
Menos pertubadores que otras formas de averiguar requerimientos. Se consideran insuficientes para recopilar informacion por si solos.
- Muestreo de la documentacion, formularios y datos existentes.
- Investigacion y vistas al lugar
- Observacion del ambiente de trabajo

### Metodos interactivos 
Pueden usarse para obtener los requerimientos de los miembos de la organizacion de distintas formas interactivas con las personas en la organizacion.
- Cuestionarios 
- Entrevistas 
- Planeacion conjunta de requerimientos(JRP o JAD)
- Lluvia de ideas (Brainstorming)

### Cuestionarios 
Un cuestionario es un documento que permite al analista recabar informacion y opiniones de los encuestados.
* Ventajas 
    - Respuesta rapida
    - Economicos
    - Anonimos
    - Estructurados de facil analisis
* Desventajas 
    - Numero bajo de respuetas
    - No responde a todas las preguntas
    - Preguntas rigidas
    - No se puede realizar el analisis corporal
    - Dificiles de preparas

**Tipos:**
* Cuestionario de **formato libre**: Se formula una pregunta y el encuestado registra la respuesta en el espacio provisto despues de la pregunta.
* Cuestionario de **formaro fijo**: Requieren la seleccion de una respuesta entre respuestas predefinidas.

### Entrevistas 
Es una tecnica de exploracion mediante la cual el analista de sistemas recolecta informacion de las personas a traves de la interaccion cara a cara.
* Ventajas 
    - El entrevistado se siente incluido en el proyecto
    - Es posible obtener una retroalimentaicon del encuestado
    - Es posible adaptar las preguntas de acuerto al entrevistado
    - Posibilidad de obtener informacion no verbal
* Desventajas 
    - Costosas 
    - Tiempo y recursos humanos 
    - Dependen de las habilidades del entrevistador 
    - No aplicables a distancias

**Tipos:**
* **Estructuradas(Cerradas)**: 
    - El encuestador tiene un conjunto especifico de preguntas para hacerselas al entrevistado
    - Se dirige al usuario sobre un requerimiento puntual
    - No permite adquirir un amplico conocimiento del dominio
* **No Estructuradas(Abiertas)**: 
    - El encuestador lleva un tema general
    - Sin preparacion de pregutnas especificas
    - Iniciar con preguntas que no dependen del conexto, para conocer el problema, la gente involucrada, etc.

**Tipos de preguntas:**
* Abiertas: Permiten al encuestado responder de cualquier manera, permitiendo espontaniedad.
* Cerradas: Las respuestas son directas, cortas o de seleccion especifica.
* Sondeo: Permite obtener mas detalle sobre un tema puntual.

**Organiacion de una entrevista** 
- Piramidal: Empienzan con preguntas cerrados y termina con preguntas abiertas.
- Embudo: Empienzan con preguntas abiertas y termina con preguntas cerradas.
- Diamante: preguntas cerrdas luego abiertas y termina con pregutnas cerradas.

**Preparacion previo(Kendall)**
1. Leer los antecedentes: Buscar un vocabulario comun.
2. Establecer los objetivos de la entrevista: Usando los antecedentes. 
3. Seleccionar a los entrevistas: Se debe minimizar el numvero de entrevistas.
4. Planificacion de la entrevista y preparaacion del entrevistado.
5. Seleccion del tipo de preguntas a usar y su estructura.

**Reglas de una entrevista:**
* **Haga**:
    - Vistase adecuadamente 
    - Sea cortes
    - Escuche cuidadosamente
    - Mentenga el control de la entrevista
    - Explore
    - Observe los gestos y la comunicacion no oral
    - Sea paciente
    - Mentanga al entrevistado en calma
    - Mentenga su autocontrol
    - Termine a timpo 
* **Evite**: 
    - Suponer que una respueta termino o no lleva a ningun lado
    - Revelar pistas orales y no orales 
    - Usar la jerga 
    - Revelar sus sesgos personales
    - Hablar en lugar de esuchar 
    - Suponer cualquier cosa acerca del tema o el entrevistado
    - Uso de la grabadora

### Planeacion conjunta de requerimientos(JRP)
La planeacion conjunta de requerimientos es el proceso mediante el cual se conducen reuniones de grupo altamente estructurados con el proposito de analizar problemas y definiir requerimientos.

* Ventajas
    - Ahorro de tiempo
    - Usuarios involucrados
    - Desarrollos creativos
* Desventajas 
    - Es dificil organizodr los horarios de los involucrados
    - Es complejo encontrar un grupo de participantes integrados y organizados

**Participantes**
- Patrocinador: responsable del proyecto, toma las decisiones finales.
- Facilitador: Dirige las sesiones y tiene amplias habilidadesd de comunicacion y negociacion
- Usuarios y gerentes: Los usuarios comunican los requerimientos y los gerentes los aprueban
- Secretarios: Llevan el registros de la sesion
- Equipos de TI: Escuchan y toman nota de los requerimientos

**Como planear las sesiones de JRP:**
* Seleccion de una ubicacion para las sesiones de JRP: Siempre que sea posible, deberan conducirse lejos del lugar de trabajo de la compañia. Las reuniones deben tener todas las herramientas y comodidades.
* Seleccion de los participantes: Debe incluirse un facilitador, secretarios y representantes clave del área de negocio. La gerencia debe estar comprometida con la participación de estos usuarios. También pueden incluirse miembros del equipo de TI y especialistas técnicos.
* Preparación de la Agenda: El facilitador debe informar a los participantes sobre los objetivos y alcance de la sesión. La agenda debe distribuirse con anticipación y estructurarse en tres partes:
    - Introducción: Explicación de expectativas, reglas y motivación de los asistentes.
    - Cuerpo: Discusión detallada de los temas principales.
    - Conclusión: Resumen de la sesión y registro de aspectos pendientes.

### Brainstorming
**¿Que es?**
La lluvia de ideas (Brainstorming) es una técnica para generar ideas al alentar a los participantes para que ofrezcan tantas  ideas  como  sea  posible  en  un  corto  tiempo  sin  ningún  aná lisis  hasta  que  se  hayan  agotado  las  ideas. 
Incluye una serie de fases de aplicación:
- Descubrir hechos
- Producir ideas
- Descubrir soluciones

# 5. Ingenieria de requerimientos
La ingenieria de requerimientos es la disciplina que se encarga de desarrollar una especificacion completa, consistente y no ambigua, la cual servira como base para acuerdos comunes entre las partes involucradas y en donde se describen las funciones que realizara el sistema. 
La meta del proceso de ingenieria de requerimientos es crear y mantener un documento de requerimientos del sistema. El proceso general corresponde a cuatro subprocesos de alto nivel de ingenieria de requerimientos: 
1. Estudio de viabilidad
2. Obtencion y analisis de requerimientos
3. Especificacion de requerimientos
4. Validacion de requerimientos 
5. Gestion de requerimientos

