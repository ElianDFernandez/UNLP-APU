package ar.edu.info.oo1.clientedecorreo;

import java.util.List;

/**
 *
 * @author elian
 */
public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> adjuntos;
    
    public Email(String titulo, String cuerpo, List<Archivo> adjuntos) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = adjuntos;
    }
    
    public String getTitutlo() {
        return this.titulo;
    } 
    
    public String getCuerpo() {
        return this.cuerpo;
    }
    
    public List<Archivo> adjuntos () {
        return this.adjuntos;
    }
    
    public Integer tamaño() {
        Integer tamaño = this.titulo.length() + this.cuerpo.length();
        for(Archivo archivo : this.adjuntos) {
            tamaño += archivo.tamaño();
        }
        
        return tamaño;
    }
}
