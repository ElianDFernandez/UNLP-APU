package ar.edu.info.oo1.mantenimientos;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Mantenimiento {
    private List<Cliente> clientes;
    private List<Servicio> servicios;
    
    public Mantenimiento() {
        clientes = new LinkedList<>();
        servicios = new LinkedList<>();
    }
    
    public Cliente registrarUnCliente(String nombre, String domicilio){
        Cliente cliente  = new Cliente(nombre, domicilio);
        clientes.add(cliente);
        return cliente;
    }
    
    public ServicioLimpieza registrarServicioLimpieza(Double precioHora, int cantidadHoras, double tarifaMinima) {
        ServicioLimpieza servicioLimpieza = new ServicioLimpieza(tarifaMinima,precioHora,cantidadHoras);
        servicios.add(servicioLimpieza);
        return servicioLimpieza;
    }
    
    public ServicioParquizacion registrarServicioParquizacion(Double precioHora, int cantidadHoras, int maquinasAUtilizar, double costoMantenimiento) {
        ServicioParquizacion servicioParquizacion = new ServicioParquizacion(maquinasAUtilizar, costoMantenimiento, precioHora, cantidadHoras);
        servicios.add(servicioParquizacion);
        return servicioParquizacion;
    }
    
    public void contratarPorUnicaVez(Cliente cliente, LocalDate fecha, Servicio servicio){
        Contrato c = new ContratoUnico(fecha,servicio);
        cliente.agregarContrato(c);
    } 
    
    public void contratarPorFormaProlongada(Cliente cliente, LocalDate fecha, int cantidadDias, Servicio servicio) {
        Contrato c = new ContratoProlongado(fecha, cantidadDias, servicio);
        cliente.agregarContrato(c);
    }
    
    public int cantServiciosMayor(double valor) {
        return (int)this.servicios.stream().filter(contrato-> contrato.monto() > valor).count();
    }
}
