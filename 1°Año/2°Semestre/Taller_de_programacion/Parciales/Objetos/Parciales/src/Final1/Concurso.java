/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final1;

/**
 *
 * @author elian
 */
public class Concurso {
    Pareja parejas[];
    
    public Concurso(Integer n) {
        this.parejas = new Pareja[n];
    }
    
    public Boolean hayLugar() {
        if (parejas[parejas.length -1] == null) {
            return true;
        }
        return false;
    }
    
    public Boolean agregarPareja(Pareja pareja) {
        if (hayLugar()) {
            for (int i=0; i<parejas.length; i++) {
                if (parejas[i] == null) {
                    parejas[i] = pareja;
                    return true;
                }
            }
        } 
        return false;
    }
    
    public Pareja parejaMaxDifEdad() {
        Pareja pareja=null;
        Integer maxDif = 0;
        for(int i= 0; i<parejas.length; i++) {
            if (parejas[i] != null  &&  parejas[i].getDiferenciaEdad() > maxDif) {
                pareja = parejas[i];
                maxDif = parejas[i].getDiferenciaEdad();
            } 
        }
        return pareja;
    }
}
