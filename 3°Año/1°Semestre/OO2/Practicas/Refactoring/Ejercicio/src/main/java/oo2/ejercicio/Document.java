
package oo2.ejercicio;

import java.util.List;

/**
 *
 * @author Elian
 */
public class Document {
    List<String> words;
  
    public long characterCount() {
 	long count = this.words.stream().mapToLong(w -> w.length()).sum();
        return count;
    }
    
    public long calculateAvg() {
        long avgLength = this.characterCount() / this.words.size();
        return avgLength;
    }
    // Resto del código que no importa
}

/*
Bad Smell:
    1. Duplicated Code -> this.words.stream().mapToLong(w -> w.length()).sum() -> Solucion extract method
    2. Temporary Field -> count y avgLength


Analice el código original y detecte si existe un problema al calcular las estadísticas. 
Explique cuál es el error y en qué casos se da ¿El error identificado sigue presente luego de realizar los refactorings? 
En caso de que no esté presente, ¿en qué momento se resolvió? De acuerdo a lo visto en la teoría, ¿podemos considerar esto un refactoring?

Error:
Al hacer la división: / this.words.size() si es 0 fallara.
¿El error identificado sigue presente luego de realizar los refactorings?:
Si, sigue presente
¿podemos considerar esto un refactoring?:
No, Como define Martin Fowler, el Refactoring es una técnica para alterar la estructura interna de un programa sin cambiar su comportamiento observable. 
Si el código original lanzaba una excepción al recibir una lista vacía, el código refactorizado debe lanzar la misma excepción en las mismas circunstancias.

*/

