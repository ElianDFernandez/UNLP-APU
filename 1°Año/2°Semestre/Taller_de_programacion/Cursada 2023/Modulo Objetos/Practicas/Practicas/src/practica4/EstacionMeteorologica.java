/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author elian
 */
public class EstacionMeteorologica {
    private String nombre;
    private Double latitud;
    private Double longitud;
    private int aniosConsecutivos;
    private int anioInicio;
    private Double [][] temperaturas;

    public EstacionMeteorologica(String nombre, Double latitud, Double longitud,int aniosConsecutivos, int anioInicio) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.aniosConsecutivos = aniosConsecutivos;
        this.anioInicio = anioInicio;
        this.temperaturas = new Double [aniosConsecutivos][12];
        GeneradorAleatorio.iniciar();
        for (int i = 0; i < aniosConsecutivos; i++) {
            for (int j = 0;  j< 12; j++) {
                temperaturas[i][j] = GeneradorAleatorio.generarDouble(50) + 50;
            }
        }
    }

    public int getAniosConsecutivos() {
        return aniosConsecutivos;
    }

    public void setAniosConsecutivos(int aniosConsecutivos) {
        this.aniosConsecutivos = aniosConsecutivos;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Double[][] getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(Double[][] temperaturas) {
        this.temperaturas = temperaturas;
    }
    
    public Boolean registrarTemperatura(Double temperatura, int mes, int anio) {
        if (mes < 0 || mes > 12 || anio < anioInicio || anio > anioInicio + aniosConsecutivos) {
            return false;
        } else {
            this.temperaturas[anio][mes] = temperatura;
            return true;
        }
    }
    
    public Double obtenerTemperatura(int mes, int anio) {
        if (mes < 0 || mes > 12 || anio < anioInicio || anio > anioInicio + aniosConsecutivos) {
            return 0.0;
        } else {
            return temperaturas[anio][mes];
        }
    }
    
    public String mayorTemperatura() {
        Double mayor = 0.0;
        int anio = 0;
        int mes = 0;
        for (int i = 0; i < aniosConsecutivos; i++) {
            for (int j = 0;  j > 12; j++) {
                if (temperaturas[i][j] > mayor) {
                    anio=i;
                    mes=j;
                }
            }
        }
        return "Año: " +anio+ " Mes: "+mes;
    }
    
    public String reportarPromediosAnuales() {
        String reporte ="";
        Double sum = 0.0;
        reporte += this.nombre + " ( " + this.latitud+ " - "+this.longitud+")";
        for (int i = 0; i < aniosConsecutivos; i++) {
            for (int j = 0;  j < 12; j++) {
                sum += temperaturas[i][j];
            }
            reporte += "- Año " + (anioInicio + i) + ": " + (sum / 12); 
        }
        return reporte;
    }
    
    public String reportarPromediosMensual() {
        String reporte ="";
        Double sum = 0.0;
        reporte += this.nombre + " ( " + this.latitud+ " - "+this.longitud+")";
        for (int i = 0; i < 12; i++) {
            for (int j = 0;  j < aniosConsecutivos; j++) {
                sum += temperaturas[j][i];
            }
            reporte += "-  "+getNombreMes(i+1) + ": " + (sum / 12); 
        }
        return reporte;
    }
    
    public String getNombreMes(int mes) {
        String[] nombresMeses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        if (mes >= 1 && mes <= 12) {
            return nombresMeses[mes - 1]; 
        } else {
            return "No valido";
        }
    }

}
  