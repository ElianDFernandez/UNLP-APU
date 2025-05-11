/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parciales.Parcial12;

/**
 *
 * @author Elian
 */
public class Nodo {
    private int sum;
    private int dif;

    public Nodo() {
        this.sum = 0;
        this.dif = 0;
    }

    public int getSum() {
        return sum;
    }

    public int getDif() {
        return dif;
    }
    
    public void agregar(int num1, int num2) {
        this.sum = num1 + num2;
        this.dif = num1 - num2;
    }
}
