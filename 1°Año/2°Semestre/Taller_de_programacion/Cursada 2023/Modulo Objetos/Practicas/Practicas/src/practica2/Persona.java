package practica2;

public class Persona {
    private String nombre;
    private Integer dni;
    private Integer edad;

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

    public Persona(){
    }
    
    public Persona(String nombre, Integer dni, Integer edad) {
        setNombre(nombre);
        setDni(dni);
        setEdad(edad);
    }
    
    @Override
    public String toString() {
        return "Mi nombre es " + getNombre() + " mi DNI es "+ getDni() + " y tengo " + getEdad()+ " años.";
    }
    
}
