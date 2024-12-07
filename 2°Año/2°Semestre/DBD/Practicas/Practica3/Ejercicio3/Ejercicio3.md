# Ejercicio 3
Agencia (RAZON_SOCIAL, dirección, telef, e-mail)  
Ciudad (CODIGOPOSTAL, nombreCiudad, añoCreación)  
Cliente (DNI, nombre, apellido, teléfono, dirección)  
Viaje (FECHA, HORA, DNI, cpOrigen (Fk), cpDestino (Fk), razon_social(Fk), descripcion) //cpOrigen y
cpDestino corresponden a la ciudades origen y destino del viaje  

1. Eliminar el cliente con DNI:25326992.

            Cliente <= Cliente - σ DNI = 25326992 (Cliente)

2. Listar datos personales de clientes que solo realizaron viajes locales. Se consideran viajes locales
aquellos que tienen la misma ciudad como origen y destino.

            

3. Listar información de agencias que no tengan viajes para el cliente con DNI 22222222 durante el primer
semestre de 2020.
4. Listar información de agencias que realizaron viajes durante 2019 y no realizaron viajes durante 2020.
5. Agregar una agencia de viajes con los datos que desee.
6. Listar datos personales de clientes que viajaron con destino a la ciudad de ‘Lincoln’ pero no realizaron
viajes con origen en ‘La Plata’.
7. Listar nombre, apellido, dirección y teléfono de clientes que viajaron con todas las agencias.
8. Listar código postal, nombre y año de creación de ciudades que no recibieron viajes durante 2020.
9. Reportar información de agencias que realizaron viajes durante 2019 o que tengan dirección igual a
‘General Pinto 1234’.
10. Actualizar el teléfono del cliente con DNI 2789655 al siguiente número de teléfono: 221-4400345