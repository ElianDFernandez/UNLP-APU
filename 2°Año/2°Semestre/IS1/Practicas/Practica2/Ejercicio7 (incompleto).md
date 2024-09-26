# Mutual
***
## Frente
### ID:
    Afiliarse.
### Titulo:
    Como persona quiero afiliarme para acceder a las prestaciones.
### Reglas de negocio:
    * Poseer tarjeta de credito.
***
## Dorso
### Criterios de aprobacion
**Escenario 1:** Afiliacion correcta.
Dado que una persona con tarjeta de credito quiere afiliarse.
Cuando se ingresen correctamente los datos personales y de la tarjeta de crédito.
Entonces el sistema registrará al afiliado, asociará su tarjeta y permitirá agregar a personas a cargo (pareja e hijos), otorgando un número de afiliado a cada uno.
**Escenario 2:** Afiliacion incompleta por falta de tarjeta de credito.
Dado que una persona sin tarjeta de credito quiere afiliarse.
Cuando se ingresen los datos personales pero no se proporcione una tarjeta de crédito.
Entonces el sistema informará que es necesario poseer una tarjeta de crédito para completar la afiliación.
***
***
## Frente 
### ID:
    Prestacion ortodoncia
### Titulo:
    Como afiliado quiero solicitar una prestacion de ortodoncia
### Reglas de negocio:
    * Pago del mes anterior al que es solicitado.
    * Solo una por afiliado.
    * Solo afiliados menores de 15 años con al menos 9 meses.
    * Debe presentarse historia clinica elaborada por el profesional.
***
## Dorso
### Criterios de aprobacion
**Escensario 1:** Solicitud de la prestacion exitosa
Dado que el afiliado 'Malena' de 14 años, con 12 meses de afiliacion y con la historia clinica correspondiente elaborada por el profesional, con el pago del mes anterior realizado y sin ninguna prestacion de ortodoncia realizada anteriormente. 
Cuando se carge su solicitud.
Entonces el sistema informara que la solicitud fue realizada con exito.
**Escenario 2:** Solicitud de la prestacion fallida por pago no realizado
Dado que el afiliado 'Julieta' de 16 años, con 5 meses de afiliacion y con la historia
clinica correspondiente elaborada por el profesional, con el pago del mes anterior no realizado y sin ninguna prestacion de ortodoncia realizada anteriormente.
Cuando se carge su solicitud.
Entonces el sistema informa que no fue realizado y no se puede completar la solicitud.
**Escensario 3:** Solicitud de la prestacion fallida por ya haberla realizado
Dado que el afiliado 'Elian' ya ha recibido una prestación de ortodoncia y cumple con el resto de los requisitos.
Cuando se cargue su solicitud.
Entonces el sistema informara que solo se puede ralizar una por afiliado.
**Escenario 4:** Solicitud de la prestacion fallida por afiliado mayor de 15 años
Dado que el afiliado 'Hernan' de 16 años, con 6 meses de afiliacion y con la historia clinica correspondiente elaborada por el profesional, con el pago del mes anterior realizado y sin ninguna prestacion de ortodoncia realizada anteriormente.
Cuando se cargue su solicitud.
Entonces el sistema informara que la prestacion solo esta disponible para afiliados menores de 15 años.
**Escenario 5:** Solicitud de la prestacion fallida por afiliado tiempo de afiliacion menor a 9 meses
Dado que el afiliado 'Gaston' de 14 años, con 7 meses de afiliacion y con la historia clinica correspondiente elaborada por el profesional, con el pago del mes anterior realizado y sin ninguna prestacion de ortodoncia realizada anteriormente.
Cuando se cargue su solicitud.
Entonces el sistema informara que la prestacion solo esta disponible para afiliado desde al menos 9 meses.
**Escenario 6:** Solicitud de la prestacion...