package Arboles.Parcial1;

public class DatoNodo {
    private int suma;
    private int diferencia;

    public DatoNodo(int suma, int diferencia) {
        this.suma = suma;
        this.diferencia = diferencia;
    }

    public int getSuma() {
        return suma;
    }

    public int getDiferencia() {
        return diferencia;
    }

    @Override
    public String toString() {
        return "DatoNodo{" + "suma=" + suma + ", diferencia=" + diferencia + '}';
    }
}