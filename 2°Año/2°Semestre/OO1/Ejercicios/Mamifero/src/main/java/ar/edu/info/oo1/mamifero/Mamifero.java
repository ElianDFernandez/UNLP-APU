package ar.edu.info.oo1.mamifero;

import java.time.LocalDate;

/**
 *
 * @author elian
 */
public class Mamifero {
    private Mamifero madre;
    private Mamifero padre;
    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;

    public Mamifero() {
    }
    
    public Mamifero(String identificador) {
        this.identificador = identificador;
    }
    
    public String getIdentificador() {
        return this.identificador;
    }
    
    public void setIdentificador(String indentificador) {
        this.identificador = indentificador;
    }
    
    public String getEspecie(){
        return this.especie;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate fecha) {
        this.fechaNacimiento = fecha;
    }

    public Mamifero getMadre() {
        if(this.madre != null) {
            return madre;
        } else {
            return null;
        }
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    public Mamifero getPadre() {
        if (this.padre != null) {
            return padre;
        } else {
            return null;
        }
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }
    
    public Mamifero getAbueloMaterno() {
        Mamifero madre = this.getMadre();
        if (madre != null) {
                return this.madre.getPadre();
        } else {
            return null;
        }
    }
    
    public Mamifero getAbuelaMaterna() {
        Mamifero madre = this.getMadre();
        if (madre != null) {
            return this.madre.getMadre();
        } else {
            return null;
        }
    }
    
    public Mamifero getAbueloPaterno() {
        Mamifero padre = this.getPadre();
        if (padre !=null) {
            return this.padre.getPadre();
        } else {
            return null;
        }
    }
    
    public Mamifero getAbuelaPaterna() {
        Mamifero padre = this.getPadre();
        if (padre !=null) {
            return this.padre.getMadre();
        } else {
            return null;
        }
    }
    
    public boolean tieneComoAncestroA(Mamifero mamifero) {
        if (this.getMadre() != null && this.getMadre().equals(mamifero)) {
            return true;
        }
        if (this.getPadre() != null && this.getPadre().equals(mamifero) ) {
            return true;
        }
        if (this.getMadre() != null && this.getMadre().tieneComoAncestroA(mamifero)) {
            return true;
        }
        if (this.getPadre() != null && this.getPadre().tieneComoAncestroA(mamifero)){
            return true;
        }
        return false;
    }
}
