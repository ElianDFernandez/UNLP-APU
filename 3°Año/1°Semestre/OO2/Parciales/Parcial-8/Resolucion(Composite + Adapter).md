# Ejercicio 1

```JAVA

// Patrong Composite, es un patron que nos permite tratar a objetos individuales y objetos grupales de la misma manera. Ambos implementan la misma interfaz. Este patron ademas nos permite representar una jerarquia entre los objetos.
interface Componente {
    void aplicarEstilo(ConfiguracionDeEstilo estilo);
    String imprimir();
}

public class Boton implements Componente {
    private String texto;
    private String accion;
    private String estilo;

    public Boton(String texto, String accion, String estilo) {
        this.texto = texto;
        this.accion = accion;
        this.estilo = estilo;
    }

    public void aplicarEstilo(ConfiguracionEstilo estilo) {
        this.estilo = estilo.getEstiloBoton();
    }
    
    public String imprimir() {
        return "<boton estilo="+ this.estilo + " texto="+ this.texto + "accion =" this.accion "/>";
    }
}

public class Etiqueta implements Componente {
    private String texto;
    private String estilo;

    public Etiqueta(Sting texto) {
        this.texto = texto;
    }

    public void aplicarEstilo(ConfiguracionEstilo estilo) {
        this.estilo = estilo.getEstiloEtiqueta();
    }

    public String imprimir() {
        return "<etiqueta estilo=\"" + estiloActual + "\"/> " + texto + " </etiqueta>";
    }
}

public class Contenedor implements Componente {
    private List<Componente> componentes = new ArrayList<>();

    public void agregarComponente(Componente componente) {
        componentes.add(componente);
    }

    public void aplicarEstilo(ConfiguracionEstilo estilo) {
        for(Componente componente : componentes) {
            componente.aplicarEstilo(estilo);
        }
    }

    public String imprimir() {
        String string = "<contenedor>";
        for(Componente componente : componentes) {
            string += componente.imprimir();
        }
        string += "</contenedor>";
        return string;
    }
}

// Patron Adapter, Este patron permite que interfaces incompatibles trabajen juntas, en este caso queremos que la interfaz de ListaDesplegable trabaje como la interfaz de Componente, la con la clase ListaAdaptadora logramoes esto.
public class ListaAdaptadora implements Componente {
    private ListaDesplegable lista;

    public ListaAdaptadora(ListaDesplegable lista) {
        this.lista = lista;
    }

    public void aplicarEstilo(ConfiguracionEstilo estilo) {
        lista.setStyle(estilo);
    }

    public String imprimir(){
        return lista.print();
    }
}

public class main {
    public static void main(string[]args) {
        ConfiguracionDeEstilo configuracion = new ConfiguracionDeEstilo();
        Componente contenedor = new Contenedor();
        Boton boton = new Boton("Aceptar", "accept ()", "");
        Etiqueta etiqueta = new Etiqueta("Parcial de objetos");
        contenedor.agregarComponente(boton);
        contenedor.agregarCompoentte(etiqueta);
        contenedor.aplicarEstilo(configuracion);

        System.out.println(contendor.imprimir());
    }
}