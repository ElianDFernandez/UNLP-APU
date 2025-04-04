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
class Producto {
    private Integer codigo;
    private String nombre;
    private String marca;
    private Integer unidadesExhibidas;
    private Double precioUnidad;

    public Producto(Integer codigo, String nombre, String marca, Integer unidadesExhibidas, Double precioUnidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.unidadesExhibidas = unidadesExhibidas;
        this.precioUnidad = precioUnidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Integer getUnidadesExhibidas() {
        return unidadesExhibidas;
    }

    public void setUnidadesExhibidas(Integer unidadesExhibidas) {
        this.unidadesExhibidas = unidadesExhibidas;
    }

    @Override
    public String toString() {
        return "Producto{" +codigo+" - "+marca+ " - "+unidadesExhibidas+ " - " + precioUnidad+ "}";
    }
    
    
}
