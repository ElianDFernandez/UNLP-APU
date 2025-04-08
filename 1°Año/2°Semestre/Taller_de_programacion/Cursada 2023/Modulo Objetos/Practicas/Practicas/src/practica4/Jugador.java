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
public class Jugador extends Empleado{
    private Integer partidosJugados;
    private Integer golesAnotados;

    public Jugador(Integer partidosJugados, Integer golesAnotados, String nombre, Double sueldo, Integer antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.partidosJugados = partidosJugados;
        this.golesAnotados = golesAnotados;
    }

    public Integer getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(Integer partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public Integer getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(Integer golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    @Override
    public Double calcularEfectividad() {
        if (partidosJugados != 0) {
            return (double)(golesAnotados / partidosJugados);
        } else {
                return 0.0;
        }
    }
    
    public Double calcularSueldoACobrar() {
        Double sueldoBase = suledoBase();
        if (calcularEfectividad() > 0.5) {
            return sueldoBase + this.getSueldo();
        } else {
            return sueldoBase;
        }
    }
}
