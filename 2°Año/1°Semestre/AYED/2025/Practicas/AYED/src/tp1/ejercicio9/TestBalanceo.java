package tp1.ejercicio9;

import java.util.Stack;

public class TestBalanceo {
    public static void main(String[] args) {
        String prueba1 = "{( )[ ( ) ]}";
        String prueba2 = "( [ ) ]";
        String prueba3 = "[ { ( ) } ]";
        String prueba4 = "{ [ ( ] ) }";

        System.out.println(testBalanceo(prueba1)); // true
        System.out.println(testBalanceo(prueba2)); // false
        System.out.println(testBalanceo(prueba3)); // true
        System.out.println(testBalanceo(prueba4)); // false
    }
    
    public static Boolean testBalanceo(String caracteres){
        Stack<Character> pila = new Stack<>();
        
        for(char c : caracteres.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    return false;
                }
                char primero = pila.pop();
                if (c == ')' && primero != '(') {
                    return false;
                } else if (c == ']' && primero != '[') {
                    return false;
                } else if (c == '}' && primero != '{') {
                    return false;
                }
            }
        }
        
        return pila.isEmpty();
    }
}
