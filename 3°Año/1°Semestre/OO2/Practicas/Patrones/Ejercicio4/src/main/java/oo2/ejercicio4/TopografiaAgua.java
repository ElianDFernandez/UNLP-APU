package oo2.ejercicio4;

/**
 *
 * @author Elian
 */
public class TopografiaAgua implements Topografia {
    @Override
    public double proporcionAgua() {
        return 1.0;
    }

    @Override
    public double proporcionTierra() {
        return 0.0;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj instanceof TopografiaAgua;
    }
}
