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
public class Main {
    public static void main(String[]args) {
        Participante part1 = new Participante("Elian",12000123,24);
        Participante part2 = new Participante("Ana",32000123,30);
        Pareja pareja1 = new Pareja(part1,part2,"Salsa");
        
        Participante part3 = new Participante("Carlos", 13000123, 28);
        Participante part4 = new Participante("Laura", 33000123, 26);
        Pareja pareja2 = new Pareja(part3, part4, "Tango");

        Participante part5 = new Participante("Juan", 14000123, 22);
        Participante part6 = new Participante("María", 34000123, 27);
        Pareja pareja3 = new Pareja(part5, part6, "Bachata");
        
        Participante part7 = new Participante("Pedro", 15000123, 31);
        Participante part8 = new Participante("Claudia", 35000123, 29);
        Pareja pareja4 = new Pareja(part7, part8, "Merengue");
        
        Participante part9 = new Participante("Felipe", 16000123, 35);
        Participante part10 = new Participante("Sofía", 36000123, 32);
        Pareja pareja5 = new Pareja(part9, part10, "Cumbia");
        
        Concurso concurso = new Concurso(5);
        
        System.out.println(concurso.agregarPareja(pareja1));
        System.out.println(concurso.agregarPareja(pareja2));
        System.out.println(concurso.agregarPareja(pareja3));
        System.out.println(concurso.agregarPareja(pareja4));
        System.out.println(concurso.agregarPareja(pareja5));
        System.out.println(concurso.agregarPareja(pareja1));
        
        System.out.println(concurso.parejaMaxDifEdad());
    }
}
