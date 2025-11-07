package ar.edu.info.oo1.impuestos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Elian
 */
public class Agencia {
    private List<Contribuyente> contribuyentes;

    public Agencia() {
        contribuyentes = new ArrayList<>();
    }

    public List<Contribuyente> getContribuyentes() {
        return contribuyentes;
    }
    
    public Contribuyente altaContribuyente(String nombre, int dni, String email, String localidad) {
        Contribuyente c = new Contribuyente(nombre,dni,email,localidad);
        this.contribuyentes.add(c);
        
        return c;
    }
    
    public Inmueble altaInmueble(int numeroPartida, double valorLote, double valorEdificacion, Contribuyente propietario) {
        Inmueble i = new Inmueble(numeroPartida, valorLote, valorEdificacion);
        propietario.agregarBien(i);
        
        return i;
    }
    
    public Automotor altaAutomotor(String patente, String marca, String modelo, LocalDate fechaFabricacion, double valor, Contribuyente propietario) {
        Automotor a = new Automotor(patente, marca, modelo, fechaFabricacion, valor);
        propietario.agregarBien(a);
        
        return a;
    }
    
    public Embarcacion altaEmbarcacion(String patente, String marca, String modelo, LocalDate fechaFabricacion, double valor, Contribuyente propietario) {
        Embarcacion e = new Embarcacion(patente, marca, modelo, fechaFabricacion, valor);
        propietario.agregarBien(e);
        
        return e;
    }
    
    public List<Contribuyente> ContribuyentesQueMasPagan(String localidad, int cantidad) {
        return this.contribuyentes.stream()
                .filter(contribuyente -> contribuyente.getLocalidad() == localidad)
                .sorted((c1,c2)->Double.compare(c2.calcularImpuestos(), c1.calcularImpuestos()))
                .limit(cantidad)
                .collect(Collectors.toList());
    }
}
