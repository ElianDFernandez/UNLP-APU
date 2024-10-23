# SQL

## DDL (Data Definition Language)
* Lenguaje de definición de datos
    - `CREATE DATABASE`: Crear una nueva base de datos.
    - `DROP DATABASE`: Eliminar una base de datos existente.
    - `ALTER`: Modificar la estructura de una base de datos o tabla.
    - `CREATE`: Crear nuevas tablas u otros objetos en la base de datos.
    - `DROP`: Eliminar tablas u otros objetos de la base de datos.

## DML (Data Manipulation Language)
* Lenguaje de manipulación de datos
    - `INSERT`: Insertar nuevas filas en una tabla.
    - `UPDATE`: Actualizar datos existentes en una tabla.
    - `DELETE`: Eliminar filas de una tabla.
    - `SELECT`: Recuperar datos de una o más tablas.

## Productos en SQL

### Producto cartesiano
El producto cartesiano es una operación que devuelve todas las combinaciones posibles de filas entre dos tablas. No requiere una condición de unión explícita.

```sql
SELECT asociado.nombre, localidad.nombre 
FROM asociado, localidad;
```

### Producto natural
El producto natural es una operación que combina filas de dos tablas basándose en una condición de igualdad en una o más columnas. Utiliza la cláusula INNER JOIN con una condición ON

```sql
SELECT asociado.nombre, localidad.nombre 
FROM asociado  as a
INNER JOIN localidad as l ON a.localidad_id = l.id;
```

## Uniones en SQL

* Union
* Union all
* Interseccion
* Diferencia

## Funciones de agregación
(NO VAN EN WHERE)

* COUNT(): Devuelve el número de filas que coinciden con un criterio.
* SUM(): Devuelve la suma total de una columna numérica.
* AVG(): Devuelve el valor promedio de una columna numérica.
* MIN(): Devuelve el valor mínimo de una columna.
* MAX(): Devuelve el valor máximo de una columna.

