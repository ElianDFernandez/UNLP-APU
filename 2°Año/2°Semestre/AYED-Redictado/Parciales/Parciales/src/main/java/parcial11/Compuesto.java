/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial11;

/**
 *
 * @author Elian
 */
public class Compuesto {
    private int vueltas;
    private double compuesto;
    private String nombre;

    public Compuesto(int vueltas, double compuesto, String nombre) {
        this.vueltas = vueltas;
        this.compuesto = compuesto;
        this.nombre = nombre;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public double getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(double compuesto) {
        this.compuesto = compuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
}
