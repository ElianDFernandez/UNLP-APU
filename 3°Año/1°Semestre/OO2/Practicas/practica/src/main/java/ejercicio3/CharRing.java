package ejercicio3;

/**
 *
 * @author elian
 */
public class CharRing {
    private char[] source;
    private int idx;

    public CharRing(String src) {
        source = src.toCharArray();
        idx = 0;
    }

    public char next() {
        if (idx >= source.length)
            idx = 0;
        return source[idx++];
    }
}
