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
public class TorneoProfesional  extends SitioWeb {
    private Torneo torneos[];
    private Integer torneosRegistrados;

    public TorneoProfesional(Integer n, String nombre, String direccion) {
        super(nombre, direccion);
        this.torneos = new Torneo[n];
        this.torneosRegistrados =   0;
    }
    
    public Torneo[] getTorneos() {
        return torneos;
    }

    public void setTorneos(Torneo[] torneos) {
        this.torneos = torneos;
    }
    
    public boolean registrarTorneoProfesional(Torneo torneo) {
        if (torneos[torneosRegistrados ] == null) {
            torneos[torneosRegistrados ] = torneo;
            torneosRegistrados++;
            return true;
        } 
        return false;
    }
    
    public Integer sumRecaudado() {
        Integer sum = 0;
        for (int i = 0; i<this.torneosRegistrados; i++) {
            sum+=torneos[i].getMontoInscripcion() - torneos[i].getMontoPremios();
        }
        return sum;
    }
    
    @Override
    public Integer cotizarSitio() {
        return torneosRegistrados*1000 + sumRecaudado();
    }
    
}
