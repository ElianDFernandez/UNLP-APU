/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2;

/**
 *
 * @author elian
 */
public class TorneoAmateur extends SitioWeb {
    private Integer torneosJugados;
    private Integer clicksEfectuados;

    public TorneoAmateur(String nombre, String direccion) {
        super(nombre, direccion);
        this.torneosJugados = 0;
        this.clicksEfectuados = 0;
    }

    public Integer getTorneosJugados() {
        return torneosJugados;
    }

    public void setTorneosJugados(Integer torneosJugados) {
        this.torneosJugados = torneosJugados;
    }

    public Integer getClicksEfectuados() {
        return clicksEfectuados;
    }

    public void setClicksEfectuados(Integer clicksEfectuados) {
        this.clicksEfectuados = clicksEfectuados;
    }

    @Override
    public Integer cotizarSitio() {
        return this.clicksEfectuados*10 + super.getUsuariosRegistrados()*50;
    }
    
    public void registrarTorneoAmateur(Integer clicks) {
        this.clicksEfectuados+=clicks;
        this.torneosJugados++;
    }
}
