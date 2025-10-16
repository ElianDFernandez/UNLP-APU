package ar.edu.info.oo1.clientedecorreo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elian
 */
public class ClienteDeCorreo {
    private Carpeta inbox;
    private List<Carpeta> carpetas;
    
    public ClienteDeCorreo(){
        this.inbox = new Carpeta("inbox");
        this.carpetas = new ArrayList<>();
    }
    
    public void recibir(Email email) {
        this.inbox.agregar(email);
    }
    
    public Email buscar(String texto) {
        Email resultado = inbox.buscar(texto);
        if (resultado == null) {
                for(Carpeta carpeta : carpetas) {
                    resultado = carpeta.buscar(texto);
                }
        }
        
        return resultado;
    }
    
    public Integer espacioOcupado() {
        Integer tamaño = 0;
        inbox.tamaño();
        for(Carpeta carpeta : carpetas) {
            tamaño+=carpeta.tamaño();
        }
        
        return tamaño;
    }
}
