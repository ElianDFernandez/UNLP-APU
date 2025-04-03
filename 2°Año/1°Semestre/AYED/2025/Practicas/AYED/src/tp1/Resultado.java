/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

/**
 *
 * @author Elian
 */
public class Resultado {
    private int max;
    private int min;
    private double promedio;

    public Resultado(int max, int min, double promedio) {
        this.max = max;
        this.min = min;
        this.promedio = promedio;
    }

    public int getMax() { return max; }
    public int getMin() { return min; }
    public double getPromedio() { return promedio; }
    
    public void setMax(int max) { this.max = max; }
    public void setMin(int min) { this.min = min; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
}
