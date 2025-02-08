/*
4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso(1..4). 
Realice un programa que permita informar la cantidad de personas que concurrieron a cada oficina de cada piso.
Para esto, simule la llegada de personas al edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual quiere concurrir. 
La llegada de personas finaliza al indicar un nro. de piso 9. Al finalizar la llegada de personas, informe lo pedido.

 */
package practica1;

import PaqueteLectura.Lector;

public class Ejercicio4 {
    private Boolean[][] oficinas = new Boolean[8][4];
            
    public static void main(String[]args) {
        
    }
    
    public Ejercicio4(){
        for (int i=0; i<this.oficinas.length; i++) {
            for (int j=0; j<this.oficinas[i].length; j++) {
                oficinas[i][j]=false;
            }
        }
    }
    
    public void registrarLlegada(int piso, int oficina) {
        this.oficinas[piso][oficina] = true;
    }
    
    public Integer presentes(){
        int presentes = 0;
        for (int i=0; i<this.oficinas.length; i++) {
            for (int j=0; j<this.oficinas[i].length; j++) {
                if (this.oficinas[i][j] = true) presentes++;
            }
        }
        return presentes;
    }
}
