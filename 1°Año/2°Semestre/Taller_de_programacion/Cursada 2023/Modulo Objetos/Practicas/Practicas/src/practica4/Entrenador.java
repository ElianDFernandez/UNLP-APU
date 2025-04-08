/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author elian
 */
public class Entrenador  extends Empleado{
    private Integer campeonatosGanados;

    public Entrenador(Integer campeonatosGanados, String nombre, Double sueldo, Integer antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.campeonatosGanados = campeonatosGanados;
    }
    
    public Integer getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(Integer campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    @Override
    public Double calcularEfectividad() {
        if (this.getAntiguedad() != 0) {
            Double promedio = (double) this.campeonatosGanados / getAntiguedad();
            return ( promedio );
        } else {
            return 0.0;
        }
    }
    
    @Override
    public Double calcularSueldoACobrar() {
        Double sueldoBase = suledoBase();
        if (this.campeonatosGanados > 1 && this.campeonatosGanados < 4) {
            return sueldoBase + 5000;
        }  else if (this.campeonatosGanados > 5 && this.campeonatosGanados < 10) {
            return sueldoBase + 30000;
        } else if (this.campeonatosGanados > 10) {
            return sueldoBase + 50000;
        } else {
            return sueldoBase;
        }
    }
}
