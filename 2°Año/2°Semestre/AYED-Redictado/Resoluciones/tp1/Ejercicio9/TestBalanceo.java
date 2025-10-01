public class TestBalanceo {
    private String s;

    public boolean testBalanceo(String $s) {
        if ($s == null && $s == "") {
            return false;
        }

        Queue <Character> $cola = new Queue<>();
        for (int i = 0; i < $s.length(); i++) {
            char $c = $s.charAt(i);
            if ($c == '(' || $c == '[' || $c == '{') {
                $cola.enqueue($c);
            } else if ($c == ')' || $c == ']' || $c == '}') {
                if ($cola.isEmpty()) {
                    return false;
                }
                char $tope = $cola.dequeue();
                if (($c == ')' && $tope != '(') || ($c == ']' && $tope != '[') || ($c == '}' && $tope != '{')) {
                    return false;
                }
            }
        }
        return true;
    }
}
