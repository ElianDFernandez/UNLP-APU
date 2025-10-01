package Parcial1;

public class DatosNodo {
    private Integer sum;
    private Integer dif;

    public DatosNodo(Integer sum, Integer dif) {
        this.sum = sum;
        this.dif = dif;
    }

    public Integer getSum() {
        return sum;
    }

    public Integer getDif() {
        return dif;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public void setDif(Integer dif) {
        this.dif = dif;
    }

    @Override
    public String toString() {
        return "Suma: " + this.sum + " Diferencia: " + this.dif;
    }
}
