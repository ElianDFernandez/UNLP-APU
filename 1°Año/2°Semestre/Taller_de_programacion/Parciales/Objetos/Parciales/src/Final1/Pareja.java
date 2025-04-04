/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final1;

/**
 *
 * @author elian
 */
public class Pareja {
    private Participante participante1;
    private Participante participante2;
    private String estiloBaile;

    public Pareja(Participante participante1, Participante participante2, String estiloBaile) {
        this.participante1 = participante1;
        this.participante2 = participante2;
        this.estiloBaile = estiloBaile;
    }

    public Participante getParticipante1() {
        return participante1;
    }

    public void setParticipante1(Participante participante1) {
        this.participante1 = participante1;
    }

    public Participante getparticipante2() {
        return participante2;
    }

    public void setparticipante2(Participante participante2) {
        this.participante2 = participante2;
    }

    public String getEstiloBaile() {
        return estiloBaile;
    }

    public void setEstiloBaile(String estiloBaile) {
        this.estiloBaile = estiloBaile;
    }
    
    public Integer getDiferenciaEdad() {
        Integer dif = participante1.getEdad() - participante2.getEdad();
        return Math.abs(dif);
    }
   
    public String toString() {
        return "Pareja: "+ participante1.getNombre() + " - " + participante2.getNombre();
    }
}
