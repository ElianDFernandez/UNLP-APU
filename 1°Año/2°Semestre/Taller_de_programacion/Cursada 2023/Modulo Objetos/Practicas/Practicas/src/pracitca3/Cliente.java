package pracitca3;

/**
 *
 * @author Elian
 */
public class Cliente {
    private String nombre;
    private Integer dni;
    private Integer edad;

    public Cliente(String nombre, Integer dni, Integer edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return "{ Nombre: "+ nombre + " Dni: "+ dni + " Edad: "+ edad +" }";
    }
}
