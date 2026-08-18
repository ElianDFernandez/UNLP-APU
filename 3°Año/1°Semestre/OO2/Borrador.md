## Repasando Builder
```java
// Producto
public class Casa {
    int pisos;
    int habitaciones;
    int banos;

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }
}

// Builder
public interface casaBuilder {
    void buildPisos();
    void buildHabitaciones();
    void buildBanos();
    Casa getCasa();
}

// Builder Concreto
public class CasaBarataBuilder implements casaBuilder {
    private Casa casa;

    public CasaBarataBBuilder() {
        this.casa = new Casa();
    }

    @Override
    public void buildPisos() {
        casa.setPisos(1);
    }

    @Override
    public void buildHabitaciones() {
        casa.setHabitaciones(2);
    }

    @Override
    public void buildBanos() {
        casa.setBanos(1);
    }

    @Override
    public Casa getCasa() {
        return this.casa;
    }
}

public class CasaLujoBuilder implements casaBuilder {
    private Casa casa;

    public CasaLujoBuilder() {
        this.casa = new Casa();
    }

    @Override
    public void buildPisos() {
        casa.setPisos(3);
    }

    @Override
    public void buildHabitaciones() {
        casa.setHabitaciones(5);
    }

    @Override
    public void buildBanos() {
        casa.setBanos(4);
    }

    @Override
    public Casa getCasa() {
        return this.casa;
    }
}

// Director
public class Director {
    private casaBuilder builder;

    public Director(casaBuilder builder) {
        this.builder = builder;
    }

    public void construirCasa() {
        builder.buildPisos();
        builder.buildHabitaciones();
        builder.buildBanos();
    }

    public Casa getCasa() {
        return builder.getCasa();
    }
}

// Uso 
public class Main {
    public static void main(String[] args) {
        casaBuilder builder = new CasaBarataBuilder();
        Director director = new Director(builder);
        director.construirCasa();
        Casa casaBarata = director.getCasa();
    }
}
```