En Java, las fechas se representan normalmente con instancias de la clase java.time.LocalDate. Se pueden crear con varios métodos "static" como por ejemplo LocalDate.now().

Investigue cómo hacer para crear una fecha determinada, por ejemplo 15/09/1972. 
Investigue cómo hacer para determinar si la fecha de hoy se encuentra entre las fechas 15/12/1972 y 15/12/2032. Sugerencia: vea los métodos permiten comparar LocalDates y que retornan booleans.
Investigue cómo hacer para calcular el número de días entre dos fechas. Lo mismo para el número de meses y de años Sugerencia: vea el método until.
Tenga en cuenta que los métodos de LocalDate colaboran con otros objetos que están definidos a partir de enums, clases e interfaces de java.time; por ejemplo java.time.temporal.ChronoUnit.DAYS

Tareas:
- Implemente
    Implemente la clase DateLapse (Lapso de tiempo). Un objeto DateLapse representa el lapso de tiempo entre dos fechas determinadas. La primera fecha se conoce como “from” y la segunda como “to”. Una instancia de esta clase entiende los mensajes:

        public LocalDate getFrom()
        “Retorna la fecha de inicio del rango”

        public LocalDate getTo()
        “Retorna la fecha de fin del rango”

        public int sizeInDays()
        “retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”

        public boolean includesDate(LocalDate other)
        “recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.

- Pruebas automatizadas
    * Diseñe los casos de prueba teniendo en cuenta los conceptos de valores de borde y particiones equivalentes vistos en la teoría.
    * Implemente utilizando JUnit los tests automatizados diseñados en el punto anterior.

Resolucion: 

Investigue cómo hacer para crear una fecha determinada, por ejemplo 15/09/1972. 

```java
    LocalDate date = LocalDate.of(1972, 9, 15);
```

Investigue cómo hacer para determinar si la fecha de hoy se encuentra entre las fechas 15/12/1972 y 15/12/2032. 
Sugerencia: vea los métodos permiten comparar LocalDates y que retornan booleans.

```java
    LocalDate today = LocalDate.now();
    LocalDate start = LocalDate.of(1972, 12, 15);
    LocalDate end = LocalDate.of(2032, 12, 15);
    boolean isBetween = (today.isEqual(start) || today.isAfter(start)) && (today.isEqual(end) || today.isBefore(end));
```

Investigue cómo hacer para calcular el número de días entre dos fechas. Lo mismo para el número de meses y de años Sugerencia: vea el método until.

```java
    LocalDate date1 = LocalDate.of(2020, 1, 1);
    LocalDate date2 = LocalDate.of(2021, 1, 1);
    
    long daysBetween = ChronoUnit.DAYS.between(date1, date2);
    long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
    long yearsBetween = ChronoUnit.YEARS.between(date1, date2);
```