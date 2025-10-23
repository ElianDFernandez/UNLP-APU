Enunciado – presupuesto de excursiones  
 
Se está desarrollando un sistema para una empresa que organiza excursiones, con el 
objetivo de calcular el costo total de los presupuestos que prepara para sus clientes. 
Cada presupuesto puede estar compuesto tanto por excursiones como por alquileres 
de equipos. El sistema debe ser capaz de manejar ambos tipos de elementos y 
calcular su costo total de manera integrada. 
Las excursiones contienen la siguiente información relevante: el costo del traslado de 
ida y vuelta, el costo del guía, el valor del seguro, y una lista de lugares que se 
visitarán, representada como una lista de cadenas de texto. Por otro lado, los 
alquileres de equipos se definen por el costo por día del equipo, la cantidad de días 
que se alquila, y el nombre del equipo (por ejemplo, "carpa").  
El precio de una excursión se calcula sumando el costo del traslado, el valor del 
seguro, y el costo total del guía. Este último se obtiene multiplicando el costo del guía 
por el número de lugares incluidos en la lista. El precio de un alquiler de equipo se 
calcula multiplicando el costo diario por el número de días de alquiler. 
Además, se sabe de cada cliente cuáles fueron los presupuestos contratados 
previamente. Así, la empresa posee una diferenciación en los costos finales que 
pagará cada cliente, dependiendo de cuán buen cliente ha sido hasta la fecha. De 
esta forma, a los clientes que hayan tenido en su historial más de 5 presupuestos 
contratados y que acumulen más de 1 millón de pesos se les otorga un descuento del 
10 %.  
 
Es importante poder saber el costo de un presupuesto para un cliente.  Y conocer 
todos los presupuestos creados por la empresa, así como el costo total sin 
descuento de los mismos. 

Candidatos a clases:

- Presupuesto
- Cliente
- Excursion
- AlquilerEquipo
- Empresa

Relaciones entre clases:

- Una Empresa tiene muchos Presupuestos.
- Un Presupuesto puede contener múltiples Excursiones y Alquileres de Equipo.
- Un Cliente puede tener múltiples Presupuestos contratados.

Atributos y métodos principales:
- Clase Excursion:
    - Atributos: costo_traslado_ida, costo_traslado_vuelta, costo_guia, valor_seguro, lugares_visitar
    - Método: calcular_precio()

- Clase AlquilerEquipo:
    - Atributos: costo_diario, cantidad_dias, nombre_equipo
    - Método: calcular_precio()

- Clase Presupuesto:
    - Atributos: lista_excursiones, lista_alquileres
    - Método: calcular_costo_total()

- Clase Cliente:
    - Atributos: nombre, historial_presupuestos
    - Método: calcular_descuento()

- Clase Empresa:
    - Atributos: lista_presupuestos
    - Método: calcular_costo_total_sin_descuento()



Como se defien cardinalidades en el diagrama de clases:
- Entre Presupuesto y Excursion: Un Presupuesto puede tener 0 o más Excursiones (*), y una Excursion pertenece a exactamente 1 Presupuesto (1). Se indica con "*" en el lado de Excursion y "1" en el lado de Presupuesto.

entre alquilerEquipo y Equipo, el alquiler tiene 1 o mas equipos y el equipo pertenece a un solo alquiler. Entonces se indica con "*" en el lado de Equipo y "1" en el lado de AlquilerEquipo.