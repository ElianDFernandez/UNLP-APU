/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1;

/**
 *
 * @author elian
 */
public class Main {
    public static void main(String[]args) {
        Supermercado vea = new  Supermercado("Vea","Av 2, Ca 48",2,5);
        
        Producto[] productos = {
            new Producto(1, "Chocolate", "Aguila", 40, 3000.0),
            new Producto(2, "Leche", "La Serenísima", 100, 120.0),
            new Producto(3, "Pan", "Bimbo", 50, 250.0),
            new Producto(4, "Arroz", "Gallo", 200, 150.0),
            new Producto(5, "Fideos", "Matarazzo", 180, 170.0),
            new Producto(6, "Café", "Nescafé", 70, 800.0),
            new Producto(7, "Aceite", "Cocinero", 90, 500.0),
            new Producto(8, "Azúcar", "Ledesma", 150, 200.0),
            new Producto(9, "Sal", "Celusal", 300, 80.0),
            new Producto(10, "Jugo", "Tang", 500, 15.0),
            new Producto(11, "Queso", "La Paulina", 60, 900.0)
        };

        for (int i = 0; i < productos.length; i++) {
            Boolean estado = vea.registrarProducto(productos[i]);
            if (!estado) {
                System.out.println("Producto " + (i + 1) + " no registrado.");
            } else {
                System.out.println("Producto " + (i + 1) + " registrado.");
            }
        }
        
        System.out.print("Listado productos de la gondola 1:  " + vea.listarProductos(1, "La Serenísima"));
        System.out.print("Gondola con mayor unidades exhibidas: " +vea.maxUnidades());
         System.out.print(vea.toString());
    }
}
