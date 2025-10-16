package ar.edu.info.oo1.clientedecorreo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elian
 */
public class Carpeta {
    private String nombre;
    private List<Email> emails;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.emails = new ArrayList<>();
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void mover(Email email, Carpeta destino) {
        if (emails.contains(email)) {
            destino.agregar(email);
            this.emails.remove(email);
        }
    }
    
    public void agregar(Email email) {
        this.emails.add(email);
    }
    
    public Email buscar(String texto) {
        for (Email email : emails) {
            if (email.getTitutlo().contains(texto) || email.getCuerpo().contains(texto)) {
                return email;
            }
        }
        return null;
    }
    
    public Integer tamaño() {
        Integer tamaño = 0;
        for(Email email : emails) {
            tamaño += email.tamaño();
        }
        
        return tamaño;
    }
}
