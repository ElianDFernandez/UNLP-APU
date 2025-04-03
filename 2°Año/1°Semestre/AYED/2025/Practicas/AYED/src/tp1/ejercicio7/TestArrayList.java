/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import tp1.Estudiante;

/**
 *
 * @author Elian
 */
public class TestArrayList {
    public static void main(String[]args) {
        List<Integer> lista = new ArrayList();
        // List<Integer> lista = new LinkedList();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese números separados por espacio (presione 0 para finalizar):");
        int num = s.nextInt();
        while (num != 0) {
            lista.add(num);
            num = s.nextInt();
        }
        
        s.close();
        
        for (Integer numero:lista) {
            System.out.println(numero);
            
        }
        
        System.out.println(esCapicua(lista));
        
        invertir(lista);
        
        for (Integer numero:lista) {
            System.out.println(numero);
        }
        
        /*
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        lista.forEach(numero -> System.out.println(numero));
        */
        
        puntod();
        List<Integer> secuencia = new ArrayList<>();
        puntog(secuencia, 6);

        System.out.println(secuencia);
        
        List<Integer> numeros = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
    
        System.out.println(sumarLinkedList(numeros)); // Output: 15
        
    }
    
    public static void puntod(){
        List<Estudiante> estudiantes = new ArrayList();
        estudiantes.add(new Estudiante("Juan", "Pérez", 101, "juan@example.com", "Calle 123"));
        estudiantes.add(new Estudiante("María", "López", 102, "maria@example.com", "Av. Principal 456"));
        estudiantes.add(new Estudiante("Carlos", "Gómez", 103, "carlos@example.com", "Calle Secundaria 789"));
        
        List<Estudiante> estudiantesCopia = estudiantes; // Copia la referencia, por lo tanto es la misma lista
        // Para crear una nueva lista tiene que ser List<Estudiante> estudiantesCopia = new ArrayList<>();

        estudiantesCopia.get(0).setApellido("Fernandez");

        for (Estudiante est : estudiantes) {
            System.out.println(est.tusDatos());
        }
        for (Estudiante est : estudiantesCopia) {
            System.out.println(est.tusDatos());
        }
        
        Estudiante nuevoEstudiante = new Estudiante("Elian" ,"Fernandez", 230, "elianf@gmail.com", "Calle 100");
        if (!existe(estudiantes,nuevoEstudiante)) {
            estudiantes.add(nuevoEstudiante);
        } else {
            System.out.println("Ya existe");
        }
        
        if (!existe(estudiantes,nuevoEstudiante)) {
            estudiantes.add(nuevoEstudiante);
        } else {
            System.out.println("Ya existe");
        }
        
        for (Estudiante est : estudiantes) {
            System.out.println(est.tusDatos());
        }
    }
    
    public static <T> Boolean existe(List<T> lista, T nuevo) {
        return lista.contains(nuevo);
    }
    
    public static boolean esCapicua(List <Integer> numeros) {
        int ult = numeros.size();
        for (int i=0; i < ult; i++) {
            if (!numeros.get(i).equals(numeros.get(ult-1))) {
                return false;
            }
            ult = ult-1;
        }
        return true;
    }
    
    public static void puntog(List<Integer> numeros, int numero) {
        if (numero != 1) {
            numeros.add(numero);
            if (numero  % 2 == 0) {
                puntog(numeros, numero/2);
            } else {
                puntog(numeros, (numero*3)+1);
            }
        } else if (numero == 1 ){
            numeros.add(numero);
        }
    }
    
    public static void invertir(List<Integer> lista) {
        int size = lista.size();
        for (int i=0; i<size / 2; i++) {
            Integer pri = lista.get(i);
            Integer ult = lista.get(size-1-i);
            lista.set(i, ult);
            lista.set(size-1-i, pri);
        }
    }
    
    public static int sumarLinkedList(List<Integer> lista) {
        return sumarRecursivo(lista, 0);
    }

    private static int sumarRecursivo(List<Integer> lista, int indice) {
        if (indice == lista.size()) {
            return 0;
        }
        return lista.get(indice) + sumarRecursivo(lista, indice + 1);
    }
    
    
}
