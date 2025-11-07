package ar.edu.info.oo1.impuestos;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Elian
 */
public class ContribuyenteTest {
    /*
        Particiones equivalentes contribuyentes solo con embarcaciones

        contribuyente sin embarcaciones 
        contribuyente con embarcaciones fecha fabricacion menor a 10 años
        contribuyente con embarcaciones fecha fabricacion mayor o igual a 10 años y menor a 1 millon
        contribuyente con embarcaciones fecha fabricacion mayor o igual a 10 años y mayor a 1 millon
    */
    private Contribuyente cConEmbaraciones;
    private Contribuyente cSinEmbarcaciones;
    private Embarcacion embFecha9años;
    private Embarcacion embFecha10añosMenorA1Millon;
    private Embarcacion embFecha11añosMayorA1Millon;
    
    @BeforeEach
    void setUp(){
        cSinEmbarcaciones = new Contribuyente("Elian Fernandez", 42884131, "elianf321@gmail.com", "Las Flores");
        cConEmbaraciones = new Contribuyente("Ezequiel Fernandez", 21502678, "ezequiel@gmail.com", "Las Flores");
        
        embFecha9años = new Embarcacion("AAA123","Lancha","Yamaha",LocalDate.of(2000, 10, 10),10000);
        embFecha10añosMenorA1Millon = new Embarcacion("AAA123","Lancha","Yamaha",LocalDate.of(2015, 12, 30),10000);
        embFecha11añosMayorA1Millon = new Embarcacion("AAA123","Lancha","Yamaha",LocalDate.of(2016, 12, 30),1100000);
    }
    
    @Test 
    void testContribuyenteSinEmbarcaciones(){
        assertEquals(0,cSinEmbarcaciones.calcularImpuestos());
    }
    
    @Test
    void testContribuyenteConEmbarcacionesMenor10Años(){
        cConEmbaraciones.agregarBien(embFecha9años);
        assertEquals(0,cConEmbaraciones.calcularImpuestos());
    }
    
    @Test
    void testContribuyentesConEmbarcacionesMayor10AñosMenor1Millon(){
        cConEmbaraciones.agregarBien(embFecha10añosMenorA1Millon);
        assertEquals((10000*0.10),cConEmbaraciones.calcularImpuestos());
    }
    
    @Test
    void testContribuyentesConEmbarcacionesMayor10AñosMayor1Millon(){
        cConEmbaraciones.agregarBien(embFecha11añosMayorA1Millon);
        assertEquals((1100000*0.15),cConEmbaraciones.calcularImpuestos());
    }
}
