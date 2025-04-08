package pracitca3;

/**
 *
 * @author Elian
 */
public class Circulo {
    private Double radio;
    private String relleno;
    private String contorno;

    public Circulo(Double radio, String relleno, String contorno) {
        this.radio = radio;
        this.relleno = relleno;
        this.contorno = contorno;
    }
    
    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getContorno() {
        return contorno;
    }

    public void setContorno(String contorno) {
        this.contorno = contorno;
    }
    
    public Double calcularPerimetro() {
        if (radio  != null) {
            return (Math.PI  *  radio  * 2);
        } else {
            return null;
        }
    }
    
    public Double calcularArea() {
        if(radio != null) {
            return (Math.PI*radio*radio);
        } else {
            return null;
        }
    }
}
