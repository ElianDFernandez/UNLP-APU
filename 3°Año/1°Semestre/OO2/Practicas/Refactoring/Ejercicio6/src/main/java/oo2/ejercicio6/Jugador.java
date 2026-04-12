package oo2.ejercicio6;

/**
 *
 * @author elian
 */
public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public void sumarPuntos(int puntos){
        this.puntuacion += puntos;
    }
    
    public void restarPuntos(int puntos) {
        this.puntuacion -= puntos;
    }
}
