package practica2;

/**
 *
 * @author elian
 */
public class Partido {
    private String local;
    private String visitante;
    private Integer golesLocal;
    private Integer golesVisitante;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
   
    public Partido(){}
    
    public Partido(String local, String visitante, Integer golesLocal, Integer golesVisitante) {
        setLocal(local);
        setVisitante(visitante);
        setGolesLocal(golesLocal);
        setGolesVisitante(golesVisitante);
    }
    
    public Boolean hayGanador() {
        return (golesLocal != golesVisitante);
    }
    
    public Boolean hayEmpate() {
        return (golesLocal == golesVisitante);
    }
    
    public String getGanador () {
        if(this.hayGanador()) {
            if (golesLocal > golesVisitante) {
                return local;
            } else {
                return visitante;
            } 
        } else {
            return "";
        }
    }
    
    @Override
    public String toString() {
        return ("{" + this.local + ": " + this.golesLocal + "  VS  " + this.visitante + ": " + this.golesVisitante + "}");
    }
}
