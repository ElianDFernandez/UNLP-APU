package ar.edu.info.oo1.impuestos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Contribuyente {
    private String nombre;
    private int dni;
    private String email;
    private String localidad;
    private List<Bien> bienes;

    public Contribuyente(String nombre, int dni, String email, String localidad) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.localidad = localidad;
        this.bienes = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    public double calcularImpuestos(){
        return this.bienes.stream().mapToDouble(bien -> bien.calcularImpuesto()).sum();
    }
    
    public void agregarBien(Bien bien) {
        this.bienes.add(bien);
    }
}
