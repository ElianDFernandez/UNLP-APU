package pracitca3;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Elian
 */
public class Hotel {
    Habitacion[] habitaciones;
    
    public Hotel(int capacidad) {
        habitaciones = new Habitacion[capacidad];
        
        GeneradorAleatorio.iniciar();
        for (int i=0; i<capacidad; i++) {
            Double costo = GeneradorAleatorio.generarDouble(10000)+2000;
            habitaciones[i] = new Habitacion(costo,false);
        }
    }
    
    public Boolean registrarCliente(Cliente cliente, Integer nroHabitacion) {
        if(nroHabitacion > habitaciones.length || habitaciones[nroHabitacion].getOcupada()) {
            return false;
        } else {
            habitaciones[nroHabitacion].setCliente(cliente);
            habitaciones[nroHabitacion].setOcupada(true);
            return true;
        }
    }
    
    public void aumentarPrecios(Double aumento) {
        for(int i=0; i<habitaciones.length; i++) {
            habitaciones[i].setCostoNoche(habitaciones[i].getCostoNoche()+aumento);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < habitaciones.length; i++) {
            sb.append("{Habitación ").append(i + 1).append(": $").append(habitaciones[i].getCostoNoche()).append(", ");
            if (habitaciones[i].getOcupada()) {
                sb.append("ocupada, Cliente: ").append(habitaciones[i].getCliente().toString());
            } else {
                sb.append("libre");
            }
            sb.append("}\n");
        }

        return sb.toString();
    }
}
