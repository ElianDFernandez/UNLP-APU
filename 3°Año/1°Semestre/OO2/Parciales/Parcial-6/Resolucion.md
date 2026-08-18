1. Modelado de solucion:

Patrones a usar State y Composite.

UML:
```plantuml
@startuml

abstract Tarea {
    - descripcion: String
    + getDescripcion(): String
    <abstract> + getEstimacionTotal(): int
    <abstract> + getTiempoUtilizado(): int
    <abstract> + getAvance(): float
}

public class TareaSimple extends Tarea {
    - descripcion: String
    - duracionEstimada: int
    - inicio: int
    - fin: int

    - estado: EstadoTarea
    + iniciar(): void
    + finalizar(): void
    + getTiempoUtilizado(): int

    + getDescripcion(): String
    + getDuracionEstimada(): int
    + getInicio(): int
    + getFin(): int
    + setInicio(inicio: int): void
    + setFin(fin: int): void

    + getEstado(): EstadoTarea
    + setEstado(estado: EstadoTarea): void

    + getEstimacionTotal(): int
    + getAvance(): float
}

public class TareaCompuesta extends Tarea {
    - descripcion: String
    - tareas: List<Tarea>

    + getDescripcion(): String
    + addTarea(tarea: Tarea): void
    + getTareas(): List<Tarea>

    + getEstimacionTotal(): int
    + getTiempoUtilizado(): int+
    + getAvance(): float
}

public interface EstadoTarea {
    + iniciar(tarea: TareaSimple): void
    + finalizar(tarea: TareaSimple): void

    + getTiempoUtilizado(tarea: TareaSimple): int
}

public class EstadoPendiente implements EstadoTarea {
    + iniciar(tarea: TareaSimple): void
    + finalizar(tarea: TareaSimple): void
    + getTiempoUtilizado(tarea: TareaSimple): int
}

public class EstadoIniciada implements EstadoTarea {
    + iniciar(tarea: TareaSimple): void
    + finalizar(tarea: TareaSimple): void
    + getTiempoUtilizado(tarea: TareaSimple): int
}

public class EstadoFinalizada implements EstadoTarea {
    + iniciar(tarea: TareaSimple): void
    + finalizar(tarea: TareaSimple): void
    + getTiempoUtilizado(tarea: TareaSimple): int
}
```

Codigo JAVA:
```java

public abstract class Tarea {
    private String descripcion;
    
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    abstract int getEstimacionTotal();
    abstract int getTiempoUtilizado();
    abstract double getAvance();
    abstract void iniciar();
    abstract void finalizar();
}

public class TareaSimple extends Tarea {
    private int duracionEstimada;
    private int inicio;
    private int fin;
    private EstadoTarea estado;

    public TareaSimple(String descripcion, int duracionEstimada) {
        super(descripcion);
        this.duracionEstimada = duracionEstimada;
        this.estado = new EstadoPendiente(this);
    }

    public int getInicio() {
        return this.inicio
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    } 

    public int getFin() {
        return this.fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }    

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }


    public void iniciar() {
        estado.iniciar();
    } 

    public void finalizar() {
        estado.finalizar();
    }

    public int getEstimacionTotal() {
        return this.duracionEstimada;
    }

    public int getTiempoUtilizado() {
        return estado.getTiempoUtilizado();
    } 

    public double getAvance() {
        return this.getTiempoUtilizado()/this.estmiacionTotal();
    }
}

public class TareaCompleja extends Tarea {
    private List<Terea> tareas;

    public TereaCompleja(String descripcion) {
        super(descripcion);
        this.tareas = new ArrayList<>();
    }

    public void addTarea(Tarea tarea) {
        this.tareas.add(tarea);
    }

    public int getEstimacionTotal() {
        int estimacion = 0;
        for(Tarea tarea : tareas) {
            estimacion += tarea.getEstimacionTotal();
        }

        return estimacion;
    }

    public int getTiempoUtilizado() {
        int tiempoUtilizado = 0;
        for(Tarea tarea : tareas) {
            tiempoUtilizado += tarea.getTiempoUtilizado();
        }

        return tiempoUtilizado;
    }

    public double getAvance() {
        return this.getTiempoUtilizado()/this.estmiacionTotal(); 
    } 

    public void iniciar() {
        for(Tarea tarea : tareas) {
            tarea.inciar();
        }
    }

    public void finalizar() {
        for(Tarea tarea : tareas) {
            tarea.finalizar();
        }
    }
}  

public abstract class EstadoTarea {
    protected TareaSimple tarea;

    public abstract void iniciar();
    public abstract void finalizar();
    public abstract int getTiempoUtilizado();
}

public class EstadoPendiente extends EstadoTarea {
    public EstadoPendiente(TareaSimple tarea) {
        this.tarea = tarea;
    }

    public void iniciar() {
        tarea.setInicio(System.currentTimeMillis());
        tarea.setEstado(new EstadoIniciada(tarea));
    }

    public void finalizar() {
        throw new Exception("No se puede finalizar una tarea pendiente");
    }

    public int getTiempoUtilizado() {
        return 0;
    }
}

public class EstadoIniciada extends EstadoTarea {
    public EstadoIniciada(TareaSimple tarea) {
        this.tarea = tarea;
    }

    public void iniciar() {
        throw new Exception("No se puede iniciar una tarea iniciada");
    }

    public void finalizar() {
        tarea.setFin(System.currentTimeMillis());
        tarea.setEstado(new EstadoFinalizada(tarea));
    }

    public int getTiempoUtilizado() {
        return 0;
    }
}

public class EstadoFinalizada extends EstadoTarea {
    public EstadoFinalizada(TareaSimple tarea) {
        this.tarea = tarea;
    }

    public void iniciar() {
        throw new Exception("No se puede iniciar una tarea finalizada");
    }

    public void finalizar() {
        throw new Exception("No se puede finalizar una tarea finalizada");
    }

    public int getTiempoUtilizado() {
        return tarea.getFin() - tarea.getInicio();
    }
}

public static void main(String[] args) {
    TareaSimple tarea1 = new TareaSimple("Tarea 1", 10);
    TareaSimple tarea2 = new TareaSimple("Tarea 2", 20);
    TareaCompleja tareaCompleja = new TareaCompleja("Tarea Compleja");
    tareaCompleja.addTarea(tarea1);
    tareaCompleja.addTarea(tarea2);

    tareaCompleja.iniciar();
    // Esperar un tiempo
    tareaCompleja.finalizar();

    System.out.println("Estimacion total: " + tareaCompleja.getEstimacionTotal());
    System.out.println("Tiempo utilizado: " + tareaCompleja.getTiempoUtilizado());
    System.out.println("Avance: " + tareaCompleja.getAvance());
}
```

El patron state es un patron que permite a un objeto alterar su comportamiento cuando su estado interno cambia. Estos estados son clases que implementan una interfaz comun lo que permite al objeto cambiar de estado sin necesidad de condicionales. Cada estado pasa a ser responsable de su comportamiento y del pase a otro estado.

Ademas aca usamos en patron Composite, que nos permite tratar a un grupo de objetos o a un objeto individual de la misma manera ya que ambos implementan la misma interfaz. El patron composite ademas nos permite representar una jerarquia de objetos de manera que podamos trabajar con ellos de manera uniforme.

Roles para cada Patron:

La clase abstracta Tarea es la interfaz comun de nuestro patron composite. Es la que nos permite tratar a ambos objetos tarea simple y compleja de la misma manera.

Las clases TareaSimple y TareaCompleja son los componentes concretos de nuestro patron composite.

Dentro de TareaSimple es donde aparece el patron State, la TareaSimple es quien puede cambiar su estado interno y modificar su comportamiento

La interfaz EstadoTarea es la interfaz comun a nuestros estados, es la que nos permite tratar a los distintos estados de la misma manera.

EstadoPendiente, EstadoIniciada y EstadoFinalizada son los estados concretos de nuestro patron State. Cada uno de ellos implementa la interfaz EstadoTarea y define su comportamiento especifico para los metodos iniciar, finalizar y getTiempoUtilizado.