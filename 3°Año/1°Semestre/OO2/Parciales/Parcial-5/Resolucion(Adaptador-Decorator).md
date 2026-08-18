1. Solucion:

Adaptador + Decorador

UML
```plantuml
@startuml

interface estacion {
    + getTemperaturaFarenheit(): float
    + getPresion(): float
    + getRadiacionSolar(): float
    + getTemperaturasFarenheit(): float[]

    + getTemperaturaCelsius(): float
    + getPromedioFarenheit(): float
}

public class EstacionAdaptadora implements estacion {
    - estacion: HomeWeatherStation
    + getTemperaturaFarenheit(): float
    + getPresion(): float
    + getRadiacionSolar(): float
    + getTemperaturasFarenheit(): float[]
    + getTemperaturaCelsius(): float
    + getPromedioFarenheit(): float
}

interface DisplayInformacion {
    + mostrarInformacion():string
}

public class DisplayInformacionBase implements DisplayInformacion {
    + mostrarInformacion():string
}

abstract class DisplayInformacionDecorador implements DisplayInformacion {
    - display: DisplayInformacion
    - estacion: estacion
    + mostrarInformacion():string
}

public class DisplayInformacionTemperatura extends DisplayInformacionDecorador {
    + mostrarInformacion():string
}

public class DisplayInformacionPresion extends DisplayInformacionDecorador {
    + mostrarInformacion():string
}

public class DisplayInformacionRadiacion extends DisplayInformacionDecorador {
    + mostrarInformacion():string
}
```

Codigo:

``` java

public interface Estacion {
    public float getTemperaturaFarenheit();
    public float getPresion();
    public float getRadiacionSolar();
    public float[] getTemperaturasFarenheit();

    public float getTemperaturaCelsius();
    public float getPromedioCelsius();
}

public class EstacionAdaptadora implements Estacion {
    private HomeWeatherStation estacion;

    public EstacionAdaptadora(HomeWeatherStation estacion) {
        this.estacion = estacion;
    }

    @Override
    public float getTemperaturaFarenheit() {
        return estacion.getTemperature();
    }

    @Override
    public float getPresion() {
        return estacion.getPressure();
    }

    @Override
    public float getRadiacionSolar() {
        return estacion.getSolarRadiation();
    }

    @Override
    public float[] getTemperaturasFarenheit() {
        return estacion.getTemperatureHistory();
    }

    @Override
    public float getTemperaturaCelsius() {
        return (getTemperaturaFarenheit() - 32) * 5 / 9;
    }

    @Override
    public float getPromedioCelsius() {
        float[] temperaturas = getTemperaturasFarenheit();
        float suma = 0;
        for (float temp : temperaturas) {
            suma += temp;
        }
        return suma / temperaturas.length;
    }
}


public interface DisplayInformacion {
    public String mostrarInformacion();
}

public class DisplayInformacionBase implements DisplayInformacion {
    @Override
    public String mostrarInformacion() {
        return "Información de la estación meteorológica";
    }
}

public abstract class DisplayInformacionDecorador implements DisplayInformacion {
    protected DisplayInformacion display;
    protected Estacion estacion;

    public DisplayInformacionDecorador(DisplayInformacion display, Estacion estacion) {
        this.display = display;
        this.estacion = estacion;
    }

    @Override
    public String mostrarInformacion() {
        return display.mostrarInformacion();
    }
}

public class DisplayInformacionTemperatura extends DisplayInformacionDecorador {
    public DisplayInformacionTemperatura(DisplayInformacion display, Estacion estacion) {
        super(display, estacion);
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\nTemperatura: " + estacion.getTemperaturaCelsius() + " °C" + 
               "\nPromedio de Temperatura: " + estacion.getPromedioCelsius() + " °C";
    }
}

public class DisplayInformacionPresion extends DisplayInformacionDecorador {
    public DisplayInformacionPresion(DisplayInformacion display, Estacion estacion) {
        super(display, estacion);
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\nPresión: " + estacion.getPresion() + " hPa";
    }
}

public class DisplayInformacionRadiacion extends DisplayInformacionDecorador {
    public DisplayInformacionRadiacion(DisplayInformacion display, Estacion estacion) {
        super(display, estacion);
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\nRadiación Solar: " + estacion.getRadiacionSolar() + " W/m²";
    }
}

public static main(String[] args) {
    HomeWeatherStation homeWeatherStation = new HomeWeatherStation();
    Estacion estacion = new EstacionAdaptadora(homeWeatherStation);

    DisplayInformacion displayBase = new DisplayInformacionBase();

    // 1. Ejemplo 1: Mostrar solo presion 
    DisplayInformacion displayPresion = new DisplayInformacionPresion(displayBase, estacion);
    System.out.println(displayPresion.mostrarInformacion());

    // 2. Ejemplo 2: Mostrar presion y Radiacion
    DisplayInformacion displayRadiacion = new DisplayInformacionRadiacion(displayPresion, estacion);
    System.out.println(displayRadiacion.mostrarInformacion());


    // 3. Ejmplo 3: Mostrar Radiacion y temperatura
    DisplayInformacion displayTemperatura = new DisplayInformacionTemperatura(displayBase, estacion);
    DisplayInformacion displayRadiacionTemperatura = new DisplayInformacionRadiacion(displayTemperatura, estacion);
    System.out.println(displayRadiacionTemperatura.mostrarInformacion());
}


```

En este codigo, se utilizan dos patrones de diseño: el patrón Adaptador y el patrón Decorador.

El patron adaptador tiene como objetido que dos interfaces incompatibles puedan trabjaar juntas. En este caso, la clase `EstacionAdaptadora` actua como un adaptador entre la interfaz `Estacion` y la clase `HomeWeatherStation`, permitiendo que los metodos de `HomeWeatherStation` sean utilizados a traves de la interfaz `Estacion`.

El patron decorador permite agregar funcionalidad a un objeto de manera dinamica. En este caso, la clase `DisplayInformacionDecorador` actua como un decorador para la interfaz `DisplayInformacion`, permitiendo agregar informacion adicional (como temperatura, presion y radiacion) a la informacion base de la estacion meteorologica.

