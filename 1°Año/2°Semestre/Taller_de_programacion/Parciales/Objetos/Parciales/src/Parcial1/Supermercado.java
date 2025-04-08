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
public class Supermercado {
    private String nombre;
    private String direccion;
    private Producto gondolas[][];

    public Supermercado(String nombre, String direccion, Integer gondolas, Integer estantes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.gondolas = new Producto[gondolas][estantes];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Boolean registrarProducto(Producto producto) {
        for (int i = 0; i<gondolas.length; i++) {
            for (int j = 0; j<gondolas[i].length; j++) {
                if (gondolas[i][j] == null) {
                    gondolas[i][j] = producto;
                    return true;
                }
            }
        }
        return false;
    }
    
    public String listarProductos(int g, String m) {
        String listado = "";
        for (int j = 0; j<gondolas[g-1].length; j++) {
            if (gondolas[g-1][j] != null && gondolas[g-1][j].getMarca().equals(m)) {
                listado += gondolas[g-1][j].toString()+"\n";
            }
        }
        return listado;
    }
    
    public Integer maxUnidades() {
        Integer maxGondola = -1;
        Integer maxUnidades = 0;
        Integer aux = 0;
        int i ;
        for (i = 0; i<gondolas.length; i++) {
            aux = 0;
            for (int j = 0; j<gondolas[i].length; j++) {
                if (gondolas[i][j] != null) {
                    aux += gondolas[i][j].getUnidadesExhibidas();
                }
            }
            if (aux > maxUnidades) {
                maxGondola = i;
                maxUnidades = aux;
            }
        }
        return maxGondola+1;
    }
    
    @Override
    public String toString() {
        String representacion = nombre + ", " + direccion + "\n";
        for (int i = 0; i<gondolas.length; i++) {
            representacion += "Gondola  "+(i+1)+"\n";
            for (int j = 0; j<gondolas[i].length; j++) {
                representacion += gondolas[i][j].toString()+"\n";
            }
        }
        return representacion;
    }
}
