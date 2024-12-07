# Casos de uso

|||||
|-|-|-|
| Nombre | Nombre breve y desrcipcion (Comenzar con un verbo), Ejemplo ver adelanto ||
| Descripcion | Comentario general del proposito de caso de uso, Ejemplo:
En este caso de uso describe el evento en el que el usuario visualiza el adelanto de una pelicual||
| Actores | Una o más entidades, como figuran en el diagrama, Ejmplo: usuario visitante ||
| Precondiciones | Condición necesaria que se asume como verdadera antes de comenzar a ejecutar el CU. En general, es la postcondición de otro CU, Ejemplo: El usuario debe tener una sesión iniciada. ||
| Cusro normal 
secuencia de pasos numerada que reflejan la interacción entre el actor y el sistema.
 | Acciones del actor | Acciones Del sistema |
| Paso 1 | El encargado selecciona la opción de iniciar sesión. ||
| Paso2  || El sistema solicita usuario y contraseña.|
| Paso 3 | El encargado ingresa usuario y contraseña.||
| Paso 4 || El sistema verifica los datos ingresados.|
| Paso 5 || El sistema registra la sesión iniciada y habilita las acciones del encargado.|
| Curso alterno | Paso alternativo 4: el usuario o la contraseña no son validas. Se notifica la discrepancia. Retorna desde el paso 2.||
| Postcondicion | La sesion ha sido iniciada y las opciones para el encargado aparecen habilitadas ||