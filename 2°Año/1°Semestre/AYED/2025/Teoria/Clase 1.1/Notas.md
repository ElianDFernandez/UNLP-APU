# Repaso de conceptos básicos de JAVA
## Clases e instancias

En  java,  el  código  fuente  es  escrito  en  archivos  con  texto  plano  con extensión .java. Esos archivos son posteriormente compilados en archivos con extensión .class por el compilador java. 
Un archivo con extensión .class no contiene código nativo/específico para un procesador determinado sino que contiene bytecodes (el lenguaje de la máquina virtual de java).

![](Img/Captura%20de%20pantalla%202025-03-15%20145637.png)

El javac.exe es el compilador, viene con la plataforma.
El java.exe es un programa que viene con la plataforma java, que permite ejecutar los bytecodes, es el intérprete java.

## ¿Cómo declarar una clase en JAVA?

```java
public class MiClase {
    private int atributo1;
    private String atributo2;

    public MiClase(int atributo1, String atributo2) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
    }
}
```

## Tipos de datos en Java

En java hay 2 categorías de tipos de datos: tipo primitivo y tipo referencial o de una 
clase particular.

* **Tipo primitivo**: Son los tipos de datos básicos que están soportados por el lenguaje de programación. Son 8 tipos de datos primitivos en java: byte, short, int, long, float, double, char, boolean.
    - **Inicializacion**: Los tipos primitivos se inicializan con un valor por defecto.
        * **boolean**: false
        * **chat**: '\u0000'
        * **byte, short, int, long**: 0
        * **float, double**: 0.0

* **Tipo referencial**: Son los tipos de datos que son creados por el usuario. Son los objetos de las clases que se crean en java.
    - **Inicializacion**: Los tipos referencial se inicializan con null.

**Clases wrapper**: Son clases que permiten convertir un tipo primitivo en un objeto. Por ejemplo, la clase Integer permite convertir un int en un objeto Integer. 

## Clases y objetos
### ¿Cómo se crean instancias de una clase?
se usa el operador **new**

```java
public class Main {
    public static void main(String[] args) {
        MiClase objeto1 = new MiClase(1, "Hola");
        MiClase objeto2 = new MiClase(2, "Mundo");
    }
}
```

#### ¿Qué son los Constructores?

Un constructor es un método especial que se llama cuando se crea un objeto de una clase. En java, un constructor tiene el mismo nombre que la clase y no tiene un tipo de retorno.

```java
public class MiClase {
    private int atributo1;
    private String atributo2;

    public MiClase(int atributo1, String atributo2) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
    }
}
```
La inicialización está garantizada: cuando un objeto es creado, se aloca almacenamiento 
en la memoria HEAP y se invoca al constructor. 
**Memoria HEAP**: es el lugar donde se almacenan los objetos.

Formas de construir constructores:
* **Constructor por defecto**: Es un constructor que no tiene parámetros.
* **Constructor con parámetros**: Es un constructor que tiene parámetros.
* **Sobre carga de constructores**: Es tener más de un constructor en una clase.

### Variables de instancia y variables locales

* **Variables de instancia**: Son variables que se declaran dentro de una clase pero fuera
de cualquier método. Cada objeto de la clase tiene su propia copia de las variables de instancia.
* **Variables locales**: Son variables que se declaran dentro de un método. Solo son accesibles dentro del método donde se declaran.

```java
public class MiClase {
    private int atributo1; // Variable de instancia

    public void miMetodo() {
        int variableLocal = 0; // Variable local
    }
}
```
**This**: Es una referencia a la instancia actual de la clase. Se usa para referirse a las variables de instancia de la clase.

```java
public class MiClase {
    private int atributo1;

    public MiClase(int atributo1) {
        this.atributo1 = atributo1;
    }
}
```

### Variables y métodos de clase

* **Variables de clase**: Son variables que se declaran con la palabra clave static. Son compartidas por todos los objetos de la clase.
* **Métodos de clase**: Son métodos que se declaran con la palabra clave static. Se pueden invocar sin necesidad de crear un objeto de la clase.

```java
public class MiClase {
    private static int variableDeClase; // Variable de clase

    public static void miMetodo() { // Método de clase
        System.out.println("Hola Mundo");
    }
}
```

### Arreglos 

Un arreglo es un conjunto de variables del mismo tipo que se almacenan en una sola estructura de datos. Los arreglos se declaran de la siguiente forma:

```java
    int[] intArray;         // sólo declara
    intArray = new int[5];  //crea el declarado arriba
    double montos[]=new double[12]; //declara y crea
    String[] items=new String[4];   //declara y crea
```
**Arreglo de objetos**: Un arreglo de objetos es un arreglo de referencias a objetos.
**Arreglo de primitivos**: Un arreglo de primitivos es un arreglo de valores primitivos. 

**Arreglo multidimensional**: Un arreglo multidimensional es un arreglo de arreglos. 

```java
    int[][] intArray = new int[3][4]; // 3 filas y 4 columnas
    int[][] intArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
```

### Pasaje de parámetros en Java

En java, los parámetros se pasan por valor. Esto significa que cuando se pasa un parámetro a un método, se pasa una copia del valor original. 

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;
        cambiarValor(x);
        System.out.println(x); // Imprime 10
    }

    public static void cambiarValor(int x) {
        x = 20;
    }
}
```

**Clases wrapper y clase String**: Las clases wrapper y la clase String son inmutables. Esto significa que una vez que se crea un objeto de estas clases, no se puede cambiar su valor.

**Tipo de dato referencia**: Cuando se pasa un objeto como parámetro, se pasa la referencia al objeto. Esto significa que si se cambia el objeto dentro del método, el cambio se refleja fuera del método.
