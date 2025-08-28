
package tp5.ejercicio5;

public class Persona {
    private String rol;
    private String nombre;
    private String domicilio;

    public Persona(String rol, String nombre, String domicilio){
        this.rol = rol;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }
    
    public boolean esEmpleado() {
        return this.rol == "Empleado";
    }
    
    public boolean esJubilado() {
        return this.rol == "Jubilado";
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }
}
