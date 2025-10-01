public class Profesor {
    private String nombre;
    private String apellido;
    private String email;
    private String facultad;
    private String catedra;

    public Profesor(String nombre, String apellido, String email, String facultad, String catedra) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.facultad = facultad;
        this.catedra = catedra;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFacultad() {
        return this.facultad;
    }

    public String getCatedra() {
        return this.catedra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String tusDatos() {
        return "Nombre: " + this.nombre + "\n" +
               "Apellido: " + this.apellido + "\n" +
               "Email: " + this.email + "\n" +
               "Facultad: " + this.facultad + "\n" +
               "Catedra: " + this.catedra;
    }

}