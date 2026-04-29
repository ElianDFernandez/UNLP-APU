package oo2.ejercicio4;

/**
 *
 * @author Elian
 */
public class TopografiaPantano implements Topografia {
    @Override
    public double proporcionAgua() {
        return 0.7;
    }
    
    @Override
    public double proporcionTierra() {
        return 0.3;
    }

    @Override
    public boolean equals(Object topografia) {
        if (this == topografia) return true;
        return topografia instanceof TopografiaPantano;
    }
}
