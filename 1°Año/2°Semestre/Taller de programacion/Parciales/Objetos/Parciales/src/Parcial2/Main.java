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
public class Main {
    public static void main(String[]args) {
        TorneoProfesional torneoP = new TorneoProfesional(10,"Gambito","La plata");
        TorneoAmateur torneoA = new TorneoAmateur("Principiantes", "Buenos Aires");
        
        Torneo torneo1 = new Torneo("Primer Torneo","12/12/2025",2300,2000);
        Torneo torneo2 = new Torneo("SegundoTorneo","01/04/2025",3300,2500);
        
        System.out.println(torneoP.registrarTorneoProfesional(torneo1));
        System.out.println(torneoP.registrarTorneoProfesional(torneo2));
        
        torneoA.registrarTorneoAmateur(1000);
        
        System.out.println(torneoP);
         System.out.println(torneoA);
    }
}
