/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales.Parcial5;

/**
 *
 * @author Elian
 */
public class Suma {
    private int total;
    private int positivos;
    private int negativos;

    public Suma() {
        this.total = 0;
        this.positivos = 0;
        this.negativos = 0;
    }
   
    public int getTotal() {
        return total;
    }

    public int getPositivos() {
        return positivos;
    }

    public int getNegativos() {
        return negativos;
    }
    
    public void sumar(int num) {
        total+=num;
        if (num > 0) {
            positivos+=num;
        } else {
            negativos+=num;
        }
    }
}
