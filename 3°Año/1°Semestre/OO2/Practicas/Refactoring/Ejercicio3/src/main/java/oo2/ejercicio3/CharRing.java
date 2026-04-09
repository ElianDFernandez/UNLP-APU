package oo2.ejercicio3;

/**
 *
 * @author Elian
 */
public class CharRing extends Ring {
    private char[] source;

    public CharRing(String src) {
        source = src.toCharArray();
    }

    public char next() {
        if (idx >= source.length)
            idx = 0;
        return source[idx++];
    }
}

