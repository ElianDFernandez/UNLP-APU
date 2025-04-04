package pracitca3;

/**
 *
 * @author Elian
 */
public class Triangulo {
    private Double lado1;
    private Double lado2;
    private Double lado3;
    private String relleno;
    private String contorno;

    public Double getLado1() {
        return lado1;
    }

    public void setLado1(Double lado1) {
        this.lado1 = lado1;
    }

    public Double getLado2() {
        return lado2;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    public Double getLado3() {
        return lado3;
    }

    public void setLado3(Double lado3) {
        this.lado3 = lado3;
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

    public Triangulo(Double lado1, Double lado2, Double lado3, String relleno, String contorno) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.relleno = relleno;
        this.contorno = contorno;
    }
    
    public Boolean esTrianguloValido() {
        return (lado1!= null || lado2!=null || lado3!=null);
    }
    
    public Double calcularPerimetro() {
        if (esTrianguloValido()) {
            return lado1+lado2+lado3;
        } else {
            return 0.0;
        }
    }
    
    public Double calcularArea() {
        Double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }
}
