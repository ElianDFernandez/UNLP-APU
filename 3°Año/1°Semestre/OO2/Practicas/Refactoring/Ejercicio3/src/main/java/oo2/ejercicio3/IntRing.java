package oo2.ejercicio3;

/**
 *
 * @author Elian
 */
public class IntRing extends Ring{
    private int[] source;

    public IntRing(int[] src) {
        source = src;
    }

    public int next() {
        if (idx >= source.length)
            idx = 0;
        return source[idx++];
    }
}

