import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Ejercicio7 {

    /*
    // sin recursividad
    public void invertirArrayList (ArrayList<Integer> lista){
        Stack<Integer> pila = new Stack<>();
        for (int i = 0; i < lista.size(); i++) {
            pila.push(lista.get(i));
        }
        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, pila.pop());
        }
    } 
    
    // recursividad
    public void invertirArrayListRec (ArrayList<Integer> lista){
        if (lista == null || lista.size() <= 1) {
            return;
        }
        Stack<Integer> pila = new Stack<>();
        for (int i = 0; i < lista.size(); i++) {
            pila.push(lista.get(i));
        }
        invertirArrayListRecHelper(lista, pila, 0);
    }

    private void invertirArrayListRecHelper (ArrayList<Integer> lista, Stack<Integer> pila, int index){
        if (pila.isEmpty()) {
            return;
        }
        lista.set(index, pila.pop());
        invertirArrayListRecHelper(lista, pila, index + 1);
    }
    */

    //sumar recursivo lista
    public int sumarLinkedList(LinkedList<Integer> lista) {
        if(lista == null || lista.size() <= 1) {
            return 0;
        }
        return sumarLinkedListHelper(lista, 0, 0);
    }

    private int sumarLinkedListHelper(LinkedList<Integer> lista, Integer suma, int index) {
        if (index == lista.size()) {
            return suma;
        }
        suma += lista.get(index);
        return sumarLinkedListHelper(lista, suma, index + 1);

    }
    
    //Combinar ordenado
    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> lista = new ArrayList<>();
        if (lista1.isEmpty() && !lista2.isEmpty()) {
            lista.addAll(lista2);
            return lista;
        }
        if (lista2.isEmpty() && !lista1.isEmpty()) {
            lista.addAll(lista1);
            return lista;
        }
        
        return combinarOrdenadoHelper(lista, lista1, lista2, 0, 0);
    }

    private ArrayList<Integer> combinarOrdenadoHelper(ArrayList<Integer> lista, ArrayList<Integer> lista1, ArrayList<Integer> lista2, int index1, int index2) {
        Integer valor1 = null;
        Integer valor2 = null;
        if (lista1.size() > index1) {
            valor1 = lista1.get(index1);
        }
        if (lista2.size() > index2) {
            valor2 = lista2.get(index2);
        }

        if (valor1 != null && valor2 != null) {
            if (valor1 < valor2) {
                lista.add(valor1);
                return combinarOrdenadoHelper(lista, lista1, lista2, index1 + 1, index2);
            } else {
                lista.add(valor2);
                return combinarOrdenadoHelper(lista, lista1, lista2, index1, index2 + 1);
            }
        }

        if (valor1 != null) {
            lista.add(valor1);
            return combinarOrdenadoHelper(lista, lista1, lista2, index1 + 1, index2);
        }

        if (valor2 != null) {
            lista.add(valor2);
            return combinarOrdenadoHelper(lista, lista1, lista2, index1, index2 + 1);
        }

        return lista;
    }


    public void imprimirLista(List<Integer> lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    public static void main(String []args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        System.out.println(new Ejercicio7().sumarLinkedList(lista));

        // test combinar ordenado
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);
        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(2);
        lista2.add(4);
        System.out.println(new Ejercicio7().combinarOrdenado(lista1, lista2));
    }
}
