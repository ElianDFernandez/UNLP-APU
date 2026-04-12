package oo2.ejercicio9;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    /* Replace Conditional with Polymorphism
    private String formaPago;
    */
    private FormaPago formaPago;
    
    public Pedido(Cliente cliente, List<Producto> productos, FormaPago formaPago) {
        this.cliente = cliente;
        this.productos = productos;
        this.formaPago = formaPago;
    }

    public double getCostoTotal() {
        /* Replace Loop with Pipeline
        double costoProductos = 0;
        for (Producto producto : this.productos) {
            costoProductos += producto.getPrecio();
        }
        */
        double costoProductos = this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();

        /* Replace Conditional with Polymorphism
        double extraFormaPago = 0;
        if ("efectivo".equals(this.formaPago)) {
            extraFormaPago = 0;
        } else if ("6 cuotas".equals(this.formaPago)) {
            extraFormaPago = costoProductos * 0.2;
        } else if ("12 cuotas".equals(this.formaPago)) {
            extraFormaPago = costoProductos * 0.5;
        }
        */
        
        double extraFormaPago = this.formaPago.calcularCostoAdicional(costoProductos);

        /* Extract method y move method (línea 28)
        int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
        */
        int añosDesdeFechaAlta = this.cliente.getAntiguedad();

        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
        
        /* Extract method y replace temp with query (líneas 28 a 33)
        if (añosDesdeFechaAlta > 5) {
            return (costoProductos + extraFormaPago) * 0.9;
        }
        
        return costoProductos + extraFormaPago;
        */
        
        return this.aplicarDescuento(costoProductos + extraFormaPago);
    }
    
    public double aplicarDescuento(double subTotal) {
        if(cliente.getAntiguedad() > 5) {
            return subTotal * 0.9;
        }
        return subTotal;
    }
}

/*
Dado el código anterior, aplique únicamente los siguientes refactoring:
* Replace Loop with Pipeline (líneas 16 a 19)
* Replace Conditional with Polymorphism (líneas 21 a 27)
* Extract method y move method (línea 28)
* Extract method y replace temp with query (líneas 28 a 33)
Realice el diagrama de clases del código refactorizado.

classDiagram
    class Pedido {
        - Cliente cliente
        - List~Producto~ productos
        - FormaPago formaPago
        + Pedido(Cliente, List~Producto~, FormaPago)
        + getCostoTotal() double
        - aplicarDescuento(double subtotal) double
    }

    class Cliente {
        - LocalDate fechaAlta
        + getFechaAlta() LocalDate
        + getAntiguedad() int
    }

    class Producto {
        - double precio
        + getPrecio() double
    }

    class FormaPago {
        <<interface>>
        + calcularCostoAdicional(double costoProductos) double
    }

    class Efectivo {
        + calcularCostoAdicional(double costoProductos) double
    }

    class SeisCuotas {
        + calcularCostoAdicional(double costoProductos) double
    }

    class DoceCuotas {
        + calcularCostoAdicional(double costoProductos) double
    }

    Pedido --> "1" Cliente
    Pedido --> "*" Producto
    Pedido --> "1" FormaPago : strategy
    
    FormaPago <|.. Efectivo
    FormaPago <|.. SeisCuotas
    FormaPago <|.. DoceCuotas
*/