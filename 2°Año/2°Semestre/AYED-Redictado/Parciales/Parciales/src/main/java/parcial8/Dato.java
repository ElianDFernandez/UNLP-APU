/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial8;

/**
 *
 * @author Elian
 */
public class Dato {
    private int sum;
    private int dif;

    public Dato(int sum, int dif) {
        this.sum = sum;
        this.dif = dif;
    }

    public int getSum() {
        return sum;
    }

    public int getDif() {
        return dif;
    }

    @Override
    public String toString() {
        // Para que se imprima bien al probar
        return "(" + sum + ", " + dif + ")";
    }
}
