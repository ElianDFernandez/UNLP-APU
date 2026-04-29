package oo2.ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Elian
 */
public class TopografiaMixta implements Topografia {
    private List<Topografia> partes;
    
    public TopografiaMixta() {
        this.partes = new ArrayList<>();
    }
    
    public void agregarParte(Topografia parte) {
        this.partes.add(parte);
    }
    
    public double proporcionAgua() {
        double suma = 0.0;
        for (Topografia parte : partes) {
            suma += parte.proporcionAgua();
        }
        return suma/partes.size();
    }
    
    public double proporcionTierra() {
        double suma = 0.0;
        for (Topografia parte : partes) {
            suma += parte.proporcionTierra();
        }
        return suma/partes.size();
    }
    
    /**
     * comparar igualdad entre topografías. 
     * Dos topografías son iguales si tienen exactamente la misma composición. 
     * Es decir, son iguales las proporciones de agua y tierra, y además, para aquellas que son mixtas, la disposición de sus partes es igual.
     */
    @Override
    public boolean equals(Object topografia) {
        if (this == topografia) return true;
        if (!(topografia instanceof TopografiaMixta)) return false;
        TopografiaMixta casteo = (TopografiaMixta) topografia;
        return Objects.equals(partes, casteo.partes);
    }
}
