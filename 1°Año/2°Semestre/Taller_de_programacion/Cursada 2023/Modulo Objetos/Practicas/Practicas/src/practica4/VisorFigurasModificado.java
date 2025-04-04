/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author elian
 */
public class VisorFigurasModificado {
    private int guardadas;
    private int capacidadMaxima = 5;
    private Figura [] vector;
    
    public VisorFigurasModificado() {
        vector = new Figura[capacidadMaxima];
        guardadas = 0;
    }
    
    public int getGuardadas() {
        return this.guardadas;
    }
    
    public void guardar (Figura f) {
        if (this.quedaEspacio()) {
            vector[this.getGuardadas()] = f;
            guardadas++;
        }
    }
    
    public boolean quedaEspacio() {
        return !(this.getGuardadas() == capacidadMaxima);
    }
    
    public void mostrar() {
        for(int i=0; i<getGuardadas(); i++) {
            System.out.println(vector[i].toString());
        }
    }
}
