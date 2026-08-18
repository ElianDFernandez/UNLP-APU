# Ejercicio 1

```JAVA

public class Proyecto {
    private String nombre;
    private Date inicio;
    private Date fin;
    private String objetivo;
    private int integrantes;
    private Double margen;
    private Double pagoPorIntegrante;
    private EstadoProyecto estado;

    public Proyecto(String nombre, Date inicio, Date fin, String objetivo, int integrantes, Double margen, Double pagoPorIntegrante) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.objetivo = objetivo;
        this.integrantes = integrantes;
        this.margen = margen;
        this.pagoPorIntegrante = pagoPorIntegrante;
        this.estado = new EstadoEnContruccion(this);
    }
    
    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public Double costoDelProyecto() {
        int duracionDias = (int) ((this.fin.getTime() - this.inicio.getTime()) / (1000 * 60 * 60 * 24));
        return duracionDias * this.integrantes * this.pagoPorIntegrante;
    }

    public Double precioDelProyecto() {
        return costoDelProyecto() * (1 + this.margen);
    }

    public void addObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}

public abstract class EstadoProyecto {
    protected Proyecto proyecto;

    public EstadoProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public abstract void aprobarEtapa();
    public abstract void modificarMargen(Double margen);
    public void cancelarProyecto() {
        proyecto.setEstado(new EstadoCancelado(proyecto));
        proyecto.addObjetivo("Cancelado");
    }
}

public class EstadoEnContruccion extends EstadoProyecto {
    public EstadoEnContruccion(Proyecto proyecto) {
        super(proyecto);
    }

    @Override
    public void aprobarEtapa() {
        if(proyecto.costoDelProyecto() != 0) {
            proyecto.setEstado(new EstadoEnEvaluacion(proyecto));
        } else {
            throw new RuntimeException("No se puede aprobar la etapa, el costo del proyecto es 0.");
        }
    }

    @Override
    public void modificarMargen(Double margen) {
        if (margen >= 0.08 && margen <= 0.1) {
            proyecto.margen = margen;
        } 
    }
}

public class EstadoEnEvaluacion extends EstadoProyecto {
    public EstadoEnEvaluacion(Proyecto proyecto) {
        super(proyecto);
    }

    @Override
    public void aprobarEtapa() {
        proyecto.setEstado(new EstadoConfirmado(proyecto));
    }

    @Override
    public void modificarMargen(Double margen) {
        if(margen >= 0.11 && margen <= 0.15) {
            proyecto.margen = margen;
        }
    }
}

public class EstadoConfirmado extends EstadoProyecto {
    public EstadoConfirmado(Proyecto proyecto) {
        super(proyecto);
    }

    @Override
    public void aprobarEtapa() {
    }

    @Override
    public void modificarMargen(Double margen) {
    }
}

public class EstadoCancelado extends EstadoProyecto {
    public EstadoCancelado(Proyecto proyecto) {
        super(proyecto);
    }

    @Override
    public void aprobarEtapa() {
    }

    @Override
    public void modificarMargen(Double margen) {
    }
    
    @Override
    public void cancelarProyecto() {
    }
}
```