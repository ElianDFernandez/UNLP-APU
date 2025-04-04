/*
4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso(1..4). 
Realice un programa que permita informar la cantidad de personas que concurrieron a cada oficina de cada piso.
Para esto, simule la llegada de personas al edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual quiere concurrir. 
La llegada de personas finaliza al indicar un nro. de piso 9. Al finalizar la llegada de personas, informe lo pedido.

 */
package practica1;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class Ejercicio4 {
    private Boolean[][] oficinas = new Boolean[8][4];
            
    public static void main(String[]args) {
        Ejercicio4 ejercicio4 = new Ejercicio4();
        GeneradorAleatorio.iniciar();
        int empleados = GeneradorAleatorio.generarInt(32);
        for (int i=0; i<empleados; i++) {
            System.out.println("Llego empleado " + (i+1));
            Boolean oficinaLibre = false;
            while (!oficinaLibre){
                int piso = GeneradorAleatorio.generarInt(8);
                int oficina = GeneradorAleatorio.generarInt(4);
                if (ejercicio4.registrarLlegada(piso, oficina)){
                    oficinaLibre = true;
                    System.out.println("Empleado " + i + " entro en el piso: " + piso + " y oficina " + oficina);
                }
            }
        }
        System.out.println("Empleados presentes: " + ejercicio4.presentes());
    }
    
    public Ejercicio4(){
        for (int i=0; i<this.oficinas.length; i++) {
            for (int j=0; j<this.oficinas[i].length; j++) {
                oficinas[i][j]=false;
            }
        }
    }
    
    public Boolean registrarLlegada(int piso, int oficina) {
        if (this.oficinas[piso][oficina] == false){
            this.oficinas[piso][oficina] = true;
            return true;
        }
        return false;
    }
    
    public Integer presentes(){
        int presentes = 0;
        for (int i=0; i<this.oficinas.length; i++) {
            for (int j=0; j<this.oficinas[i].length; j++) {
                if (this.oficinas[i][j] == true) presentes++;
            }
        }
        return presentes;
    }
}
