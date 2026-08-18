# Practicando Refactoring



## Ejercicio 12
```java
  public class TrianguloRectangulo {
      private int b; // Base
      private int a; // Altura
      public TrianguloRectangulo(int valorB, int valorA) {
          this.b = valorB;
          this.a = valorA;
      }
      public int getBase() {
          return this.b;
      }
      public int getAltura() {
          return this.a;
      }

      public double calcularArea(double base) {
          double area = this.a * this.b / 2;
          return area;
      }
  }

```

Bad Smells detectados: 
1-Uncommunicative Name(5-6): Atributos a y b no son descriptivos. Refactrizacion: Renombrar variable.
2-Variable temporal(19): La variable area es temporal. Refactorizacion: Retornar directamente el resultado del calculo.
3-Parametro innecesario(18): El parametro base no se utiliza en el metodo calcularArea. Refactorizacion: Eliminar el parametro base.


## Ejercicio 11

```java
package ar.info.unlp.arboles;

public class ArbolBinario {
    private int valor;
    private ArbolBinario hijoIzquierdo;
    private ArbolBinario hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArbolBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(ArbolBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public ArbolBinario getHijoDerecho() {
        return hijoDerecho;
    }

    public void setDerecha(ArbolBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

   public String recorrerPreorden() {
        String resultado = valor + " - ";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPreorden();
	    }
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPreorden();
        }
        return resultado;
    }

   public String recorrerInorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerInorden();
	    }
        resultado += valor + " - ";
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerInorden();
        }
        return resultado;
    }

   public String recorrerPostorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPostorden();
	    }
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPostorden();
        }
        resultado += valor + " - ";
        return resultado;
    }

}
```

Los bad smells aca son las constantes verificaciones null, que se repiten en cada metodo de recorrido. Refactorizacion: Extraer metodo para verificar si el nodo es null y llamar a ese metodo desde cada recorrido.

Para que el codigo quede mas limpio, cada hijo del nodo se puede recorrer el mismo, evitando el codigo repetido. Si un hijo es null, el metodo de recorrido retornara una cadena vacia, y si no es null, retornara el resultado del recorrido de ese hijo. De esta forma, se elimina la necesidad de verificar null en cada metodo de recorrido.

Pero para esto tenemos que implementar un objeto Arbol Vacio, que se comporta como un nodo pero representa la ausencia de un nodo. Este objeto implementaria los mismos metodos de recorrido, pero retornaria una cadena vacia en cada uno de ellos. De esta forma, el codigo de los recorridos quedaria limpio y sin verificaciones null.

1° Extraer interfaz ArbolBinario con los metodos de recorrido.
2° Implementar clase ArbolVacio que implementa la interfaz ArbolBinario, y en cada metodo de recorrido retorna una cadena vacia.
3° Modificar la clase ArbolBinario para que en lugar de tener referencias a ArbolBinario para los hijos, tenga referencias a la interfaz ArbolBinario. De esta forma, cada hijo puede ser un ArbolBinario o un ArbolVacio, y el codigo de los recorridos queda limpio sin verificaciones null.

Esta Refactorizacion se conoce como "Null Object Pattern", y es una forma de evitar el uso de null y las verificaciones asociadas, utilizando un objeto que representa la ausencia de un valor pero que implementa la misma interfaz que los objetos reales.

```java
package ar.info.unlp.arboles;

// 1. Interfaz común
public interface Arbol {
    String recorrerPreorden();
    String recorrerInorden();
    String recorrerPostorden();
}

// 2. Objeto Nulo
public class ArbolVacio implements Arbol {
    @Override
    public String recorrerPreorden() {
        return "";
    }

    @Override
    public String recorrerInorden() {
        return "";
    }

    @Override
    public String recorrerPostorden() {
        return "";
    }
}

// 3. Clase principal refactorizada
public class ArbolBinario implements Arbol {
    private int valor;
    private Arbol hijoIzquierdo; // Ahora es de tipo interfaz
    private Arbol hijoDerecho;   // Ahora es de tipo interfaz

    public ArbolBinario(int valor) {
        this.valor = valor;
        // 4. Inicializamos con Objeto Nulo en lugar de 'null'
        this.hijoIzquierdo = new ArbolVacio();
        this.hijoDerecho = new ArbolVacio();
    }

    // ... (Getters y Setters se mantienen igual, pero recibiendo/devolviendo tipo Arbol) ...

    public Arbol getHijoIzquierdo() { return hijoIzquierdo; }
    public void setHijoIzquierdo(Arbol hijoIzquierdo) { this.hijoIzquierdo = hijoIzquierdo; }
    
    public Arbol getHijoDerecho() { return hijoDerecho; }
    public void setHijoDerecho(Arbol hijoDerecho) { this.hijoDerecho = hijoDerecho; }

    // 5. Eliminamos los 'if'. El polimorfismo se encarga del resto.
    @Override
    public String recorrerPreorden() {
        return valor + " - " + 
               hijoIzquierdo.recorrerPreorden() + 
               hijoDerecho.recorrerPreorden();
    }

    @Override
    public String recorrerInorden() {
        return hijoIzquierdo.recorrerInorden() + 
               valor + " - " + 
               hijoDerecho.recorrerInorden();
    }

    @Override
    public String recorrerPostorden() {
        return hijoIzquierdo.recorrerPostorden() + 
               hijoDerecho.recorrerPostorden() + 
               valor + " - ";
    }
}
```

## Ejercicio 10

