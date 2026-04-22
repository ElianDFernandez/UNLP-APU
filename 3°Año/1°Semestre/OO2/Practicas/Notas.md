ToDoIteam

Ejercicio 8: ToDoItem
Se desea definir un sistema de seguimiento de tareas similar a Jira. 
En este sistema hay tareas en las cuales se puede definir el nombre y una serie de comentarios. Las tareas atraviesan diferentes etapas a lo largo de su ciclo de vida y ellas son: pending, in-progress, paused y finished. Cada tarea debe estar modelada mediante la clase ToDoItem con el siguiente protocolo: 

public class ToDoItem {
/**
* Instancia un ToDoItem nuevo en estado pending con <name> como nombre.
*/
        public ToDoItem(String name)

   	/**
* Pasa el ToDoItem a in-progress, siempre y cuando su estado actual sea
* pending. Si se encuentra en otro estado, no hace nada.
*/
        public void start()

	/**
* Pasa el ToDoItem a paused si su estado es in-progress, o a in-progress sí * su estado es paused. Caso contrario (pending o finished) genera un error
* informando la causa específica del mismo.
*/
        public void togglePause()


	/**
* Pasa el ToDoItem a finished, siempre y cuando su estado actual sea 
* in-progress o paused. Si se encuentra en otro estado, no hace nada.
*/
        public void finish()


	/**
* Retorna el tiempo que transcurrió desde que se inició el ToDoItem (start)
* hasta que se finalizó. En caso de que no esté finalizado, el tiempo que
* haya transcurrido hasta el momento actual. Si el ToDoItem no se inició,
* genera un error informando la causa específica del mismo.
*/
        public Duration workedTime()


/**
* Agrega un comentario al ToDoItem siempre y cuando no haya finalizado. Caso
* contrario no hace nada."

*/
        public void addComment(String comment)
}

Nota: para generar o levantar un error debe utilizar la expresión 
throw new RuntimeException("Este es mi mensaje de error");

El mensaje de error específico que se espera en este ejercicio debe ser descriptivo del caso. Por ejemplo, para el método togglePause() , el mensaje de error debe indicar que el ToDoItem no se encuentra en in-progress o paused: 

throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");

Tareas:
Modele una solución orientada a objetos para el problema planteado utilizando un diagrama de clases UML. Si utilizó algún patrón de diseño indique cuáles son los participantes en su modelo de acuerdo a Gamma et al.
Implemente su solución en Java. Para comprobar cómo funciona recomendamos usar test cases.

Que patron usar? Para este ejercicio, el patrón de diseño más adecuado sería el patrón State (Estado). Este patrón permite que un objeto altere su comportamiento cuando su estado interno cambia, lo que es exactamente lo que ocurre con las tareas en este sistema de seguimiento.
Participantes del patrón State en este modelo:

Context: ToDoItem: Esta es la clase principal que representa una tarea. Contiene una referencia al estado actual de la tarea y delega las operaciones relacionadas con el estado a este objeto de estado.
State: Esta es una interfaz que define las operaciones que deben implementarse para cada estado de la tarea (pending, in-progress, paused, finished). Cada estado concreto implementará esta interfaz y definirá su propio comportamiento para las operaciones.
Concrete States: Estas son las clases que implementan la interfaz State y representan cada uno de los estados específicos de la tarea (PendingState, InProgressState, PausedState, FinishedState).
En este modelo, cada estado concreto implementará las operaciones start(), togglePause(), finish(), workedTime(), y addComment() de manera diferente, dependiendo de las reglas de negocio asociadas a cada estado. El ToDoItem delegará estas operaciones al estado actual, lo que permitirá que el comportamiento de la tarea cambie dinámicamente a medida que su estado cambia.
Para calcular el tiempo trabajado, cada estado concreto puede mantener un registro de cuándo se inició la tarea y cuándo se pausó o finalizó, lo que permitirá calcular el tiempo transcurrido de manera precisa.


Ejercicio 9: Decodificador de películas 
Sea una empresa de cable on demand que entrega decodificadores a sus clientes para que miren las películas que ofrece. El decodificador muestra la grilla de películas y también sugiere películas. 

Usted debe implementar la aplicación para que el decodificador sugiera películas. El decodificador conoce la grilla de películas (lista completa que ofrece la empresa), como así también las películas que reproduce. De cada película se conoce título, año de estreno, películas similares y puntaje. La similaridad establece una relación recíproca entre dos películas, por lo que si A es similar a B entonces también B es similar a A. 

Cada decodificador puede ser configurado para que sugiera 3 películas (que no haya reproducido) por alguno de los siguientes criterios:
(i) novedad: las películas más recientes. 
(ii) similaridad: las películas similares a alguna película que reprodujo, ordenadas de más a menos reciente.
(iii) puntaje: las películas de mayor puntaje, para igual puntaje considera las más recientes.

Tenga en cuenta que la configuración del criterio de sugerencia del decodificador no es fija, sino que el usuario la debe poder cambiar en cualquier momento. El sistema debe soportar agregar nuevos tipos de sugerencias aparte de las tres mencionadas.

Sea un decodificador que reprodujo Thor y Rocky, y posee la siguiente lista de películas:
Thor, 7.9, 2007 (Similar a Capitan America, Iron Man)
Capitan America, 7.8, 2016 (Similar a Thor, Iron Man)
Iron man, 7.9, 2010 (Similar a Thor, Capitan America)
Dunkirk, 7.9, 2017
Rocky, 8.1, 1976 (Similar a Rambo)
Rambo, 7.8, 1979 (Similar a Rocky)

Las películas que debería sugerir son:
(i) Dunkirk, Capitan America,  Iron man
(ii) Capitán América,  Iron man, Rambo
(iii) Dunkirk, Iron man, Capitan America

Nota: si existen más de 3 películas con el mismo criterio, retorna 3 de ellas sin importar cuales. Por ejemplo, si las 6 películas son del 2018,  el criterio (i) retorna 3 cualquiera. 

Tareas:
Realice el diseño de una correcta solución orientada a objetos con un diagrama UML de clases.
Si utiliza patrones de diseño indique cuáles y también indique los participantes de esos patrones en su solución según el libro de Gamma et al.
Escriba un test case que incluya estos pasos, con los ejemplos mencionados anteriormente:
configure al decodificador para que sugiera por similaridad (ii)
solicite al mismo decodificador las sugerencias
configure al mismo decodificador para que sugiera por puntaje (iii)
solicite al mismo decodificador las sugerencias
Programe su solución en Java. Debe implementarse respetando todas las buenas prácticas de diseño y programación de POO.

Para este ejercicio, el patrón de diseño más adecuado sería el patrón Strategy (Estrategia). Este patrón permite definir una familia de algoritmos, encapsular cada uno de ellos y hacerlos intercambiables. En este caso, los algoritmos serían los diferentes criterios de sugerencia (novedad, similaridad, puntaje).
Participantes del patrón Strategy en este modelo:
Context: Decodificador: Esta es la clase principal que representa el decodificador. Contiene una referencia a la estrategia de sugerencia actual y delega la operación de sugerencia a esta estrategia.
Strategy: Esta es una interfaz que define el método para generar sugerencias de películas. Cada criterio de sugerencia implementará esta interfaz y definirá su propio algoritmo para generar las sugerencias.
Concrete Strategies: Estas son las clases que implementan la interfaz Strategy y representan cada uno de los criterios específicos de sugerencia (NovedadStrategy, SimilaridadStrategy, PuntajeStrategy).
En este modelo, cada estrategia concreta implementará el método para generar sugerencias de películas de manera diferente, dependiendo de las reglas de negocio asociadas a cada criterio. El Decodificador delegará la operación de sugerencia a la estrategia actual, lo que permitirá que el comportamiento de sugerencia cambie dinámicamente a medida que el usuario cambie la configuración del criterio de sugerencia. Además, el sistema puede ser fácilmente extendido para agregar nuevos criterios de sugerencia simplemente implementando nuevas estrategias sin necesidad de modificar el código existente del Decodificador.

No es state porque el comportamiento de las tareas no cambia dinámicamente en función de su estado, sino que cada tarea tiene un estado fijo y el comportamiento se determina por ese estado. En cambio, el patrón State se utiliza cuando un objeto puede cambiar su comportamiento en tiempo de ejecución dependiendo de su estado interno, lo cual no es el caso aquí.

