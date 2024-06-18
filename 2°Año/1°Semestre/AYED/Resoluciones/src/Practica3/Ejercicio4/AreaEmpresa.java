package Practica3.Ejercicio4;

public class AreaEmpresa {
    private String nombre;
    private int tardanza;

    public AreaEmpresa(String nombre, int tardanza) {
        this.nombre = nombre;
        this.tardanza = tardanza;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTardanza() {
        return tardanza;
    }

    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }
    
    
}
