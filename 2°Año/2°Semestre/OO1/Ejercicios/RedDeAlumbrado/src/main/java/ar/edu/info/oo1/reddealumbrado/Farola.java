package ar.edu.info.oo1.reddealumbrado;

import java.util.ArrayList;
import java.util.List;

/*
-----------------------------------------
 UML - Clase Farola
-----------------------------------------

+----------------------------------+
|                             Farola                             |
+----------------------------------+
| - encendida : boolean                          |
| - vecinas : List<Farola>                      |
+----------------------------------+
| + Farola(id: int)                                      |
| + conectarCon(otra: Farola): void  |
| + getVecinas(): List<Farola>           |
| + encender(): void                                |
| + apagar(): void                                     |
| + estaEncendida(): boolean              |
| + toString(): String                               |
+----------------------------------+

Notas:
- La clase modela una farola en la red de alumbrado.
- Cada farola conoce a sus vecinas (autoasociación).
- Encender/apagar se propaga a las vecinas si el estado cambia.
*/
public class Farola {
    private boolean encedida;
    private List<Farola> vecinas;
    
    /*
    * Crear una farola. Debe inicializarla como apagada
    */
    public Farola() {
            this.encedida = false;
            this.vecinas = new ArrayList<>();
        }

    /*
    * Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
    */
    public void pairWithNeighbor( Farola otraFarola ) {
        if (!this.vecinas.contains(otraFarola)){
            this.vecinas.add(otraFarola);
            otraFarola.pairWithNeighbor(this);
        }
    }

    /*
    * Retorna sus farolas vecinas
    */
    public List<Farola> getNeighbors () {
        return this.vecinas;
    }    

    /*
    * Si la farola no está encendida, la enciende y propaga la acción.
    */
    public void turnOn() {
        if(this.encedida) return;
        if (!this.encedida) {
            this.encedida = true;
        } 
        this.vecinas.forEach(vecina -> {
            vecina.turnOn();
        });
    }

    /*
    * Si la farola no está apagada, la apaga y propaga la acción.
    */
    public void turnOff() {
        if(!this.encedida) return;
        if(this.encedida) {
            this.encedida=false;
        }
        this.vecinas.forEach(vecina -> {
            vecina.turnOff();
        });
    }

    /*
    * Retorna true si la farola está encendida.
    */
    public boolean isOn() {
        return this.encedida == true;
    }

    /*
    * Retorna true si la farola está apagada.
    */
    public boolean isOff() {
        return this.encedida == false;
    }
}
