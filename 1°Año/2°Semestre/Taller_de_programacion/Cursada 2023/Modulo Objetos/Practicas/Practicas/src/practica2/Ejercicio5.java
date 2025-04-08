package practica2;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author elian
 */
public class Ejercicio5 {
    public static void main(String[]args) {
        int cantPartidos = 20;
        Partido[] campeonato = new Partido[cantPartidos];
        
         GeneradorAleatorio.iniciar();
         String local;
         String visitante;
         Integer golesLocal;
         Integer golesVisitante;
         int diml = 0;
        for (int i=0; i<campeonato.length; i++) {
            local = GeneradorAleatorio.generarString(10);
            visitante = GeneradorAleatorio.generarString(10);
            if (visitante.equals("ZZZ")) break;
            golesLocal = GeneradorAleatorio.generarInt(20);
            golesVisitante = GeneradorAleatorio.generarInt(20);
            campeonato[i] = new Partido(local,visitante,golesLocal,golesVisitante);
            diml ++;
        }
        campeonato[2].setLocal("river");
        campeonato[2].setGolesLocal(200);
        campeonato[1].setLocal( "boca");
        
        for (int i=0; i<diml; i++) {
            System.out.println(campeonato[i]);
        }
        
        System.out.println("River gano: " + cuantosGano("river", campeonato));
        System.out.println("Boca metio " + cuantosGolDeLocal("boca",campeonato) + "  de local.");
    }
    
    public static Integer cuantosGano(String equipo, Partido[]campeonato) {
        int gano = 0;
        for (int i=0; i<campeonato.length; i++) {
            if (campeonato[i].getGanador() == equipo)  gano ++;
        }
        return gano;
    }
    
    public static Integer cuantosGolDeLocal(String equipo, Partido[]campeonato) {
        int goles = 0;
        for (int i=0; i<campeonato.length; i++) {
            if (campeonato[i].getLocal() == equipo )  {
                goles += campeonato[i].getGolesLocal();
            }
        }
        return goles;
    }
}
