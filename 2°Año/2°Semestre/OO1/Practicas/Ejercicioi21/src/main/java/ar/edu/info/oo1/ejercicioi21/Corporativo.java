package ar.edu.info.oo1.ejercicioi21;

/**
 *
 * @author elian
 */
public class Corporativo extends Cliente{
    private int cuit;

    public Corporativo(int cuit, String nombre, String direccion) {
        super(nombre, direccion);
        this.cuit = cuit;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
}
