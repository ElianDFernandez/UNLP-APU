<div style="text-align: center;" markdown="1">

<h2>Ejercicio 2</h2>

Banda (codigoB, nombreBanda, genero_musical, año_creacion)  
Integrante (DNI, nombre, apellido, dirección, email, fecha_nacimiento, codigoB(fk))  
Escenario (nroEscenario, nombre_escenario, ubicación, cubierto, m2, descripción)  
Recital (fecha, hora, nroEscenario(fk), codigoB(fk) )  

</div>

1. Listar datos personales de integrantes con apellido ‘Garcia’ o fecha de nacimiento anterior a 2005, que toquen en bandas de rock and roll.

            π nombre,apellido,DNI,dirección,email,fecha_nacimiento (σ (apellido = 'Garcia') v (fecha_nacimiento < 01/01/2005)  ^ (genero_musical = 'rock and roll') (Integrante |x| Banda))


2. Listar nombre de escenario, ubicación y descripción de escenarios que no tuvieron recitales durante
2019.

            Recitales2019 <= π nombre_escenario,ubicación,descripción (σ(fecha <= 01/01/2019) ^ (fecha >= 31/12/2019) (Escenario |x| Recital))
            
            π nombre_escenario,ubicación,descripción (Escenario - Recitales2019)

3. Listar nombre de escenario, ubicación y descripción de escenarios que tuvieron recitales con género musical rock and roll o tuvieron recitales durante 2020.

            π nombre_escenario, ubicación, descripcion (σ (genero_musical=’rock and roll’) V (fecha >= 01/01/2020 V fecha <= 31/12/2020) (Escenario |X|Recital |X| Banda))

4. Listar nombre, género musical y año de creación de bandas que hayan realizado recitales en
escenarios cubiertos durante 2019. // cubierto es true, false según corresponda

            π nombreBanda,genero_musical,año_creacion(σ (cubierto = true) ^(fecha <= 01/01/2019) ^ (fecha >= 31/12/2019) (Banda |x| Escenario |x| Recital))

5. Listar DNI, nombre, apellido, dirección y email de integrantes nacidos entre 2000 y 2005 y que toquen
en bandas con género pop que hayan tenido recitales durante 2020.

            BandasPop2020 <= π codigoB (σ (genero_musica = 'pop' ^ fecha <= 01/01/2020 ^ fecha >= 31/12/2020) (Banda |x| Recital))

            π DNI,nombre,apellido, direccion, email (σ(fecha_nacimiento <= 01/01/2000 ^ fecha_nacimiento >= 31/12/2005) (Integrante |x| BandasPop2020))

6. Listar DNI, nombre, apellido,email de integrantes que hayan tocado en el escenario con nombre
‘Gustavo Cerati’ y no hayan tocado en el escenario con nombre ‘Carlos Gardel’.

            TocaronEnGustavoCerati <= π codigoB (σ (nombre_escenario = 'Gustavo Cerati') Escenario |x| Banda |x| Recital )
            TocaronEnCarloGardel <= π codigoB (σ (nombre_escenario = 'Carlos Gardel') Escenario |x| Banda |x| Recital )
            BandasSoloGustavoCerati<=TocaronEnGustavoCerati−TocaronEnCarlosGardel

            Integrantes <= π DNI,nombre,apellido, direccion, email (Integrantes |X| BandasSoloGustavoCerati)

7. Modificar el año de creación de la banda de nombre ‘Ratones Paranoicos’ a: 1983.

            δ año_creacion ⇐ 1983 σ nombreBanda = ‘Ratones Paranoicos’ (Banda) 

8. Reportar nombre, género musical y año de creación de bandas que hayan realizado recitales durante
2019, y además hayan tocado durante 2020.

            TocaronEn2019 <= π nombre,genero_musical, año_crecion (σ fecha <= 01/01/2019 ^ fecha >= 31/12/2019 (Banda |x| Recital))
            TocaronEn2020 <= π nombre,genero_musical, año_crecion (σ fecha <= 01/01/2020 ^ fecha >= 31/12/2020 (Banda |x| Recital))

            Reporte <= (TocaronEn2019 ∩ TocaronEn2020)

9. Listar el cronograma de recitales del día 04/12/2019. Se deberá listar: nombre de la banda que
ejecutará el recital, fecha, hora, y el nombre y ubicación del escenario correspondiente.

            π nombreBanda, fecha, hora, nombre_escenario, ubicaion(σ fecha = 04/12/2019 (Banda |x| Recital |x| Escenario))
