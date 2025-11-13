package ar.edu.info.oo1.mantenimientos;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Elian
 */
public class montoAPagarTest {
    /*
    Particiones Equivalentes

    Considerando solo contrataciones por unica vez

    Cliente con contratoUnicaVezDiaDeSemanaServicioLimpiezaMayorTarifaMinima
    Cliente con ContratoUnicaVezDiaDeSemandaSeriviCioLimpiezaMenorTarifaMinima

    Cliente Con ContratoUnicaVezFinDeSemandaSeriviCioLimpiezaMayorTarifaMinima
    Cliente con contratoUnicaVezFinDeSemanaServicioLimpiezaMenorTarifaMinima
    */
    
    private Cliente cliente;
   
    private ServicioLimpieza ServicioMayor;
    private ServicioLimpieza ServicioMinima;
    
    private ContratoUnico contratoDiaSemanaMayor;
    private ContratoUnico contratoDiaSemanaMinima;
    private ContratoUnico contratoFinSemanaMayor;
    private ContratoUnico contratoFinSemanaMinima;
    
   
    
    @BeforeEach
    void setUp(){
        cliente = new Cliente("Elian", "Av 1");
        
        ServicioMayor = new ServicioLimpieza(100, 50, 3);
        ServicioMinima = new ServicioLimpieza(100, 50, 1);
        
        contratoDiaSemanaMayor = new ContratoUnico(LocalDate.now(),ServicioMayor);
        contratoDiaSemanaMinima = new ContratoUnico(LocalDate.now(),ServicioMinima);
        contratoFinSemanaMayor = new ContratoUnico(LocalDate.now().plusDays(1),ServicioMayor);
        contratoFinSemanaMinima = new ContratoUnico(LocalDate.now().plusDays(1), ServicioMinima);
    }
    
    @Test
    void testContatoDiaSemanaMayor(){
        cliente.agregarContrato(contratoDiaSemanaMayor);
        assertEquals(150,cliente.monto());
    }
    
    @Test
    void testContratoDiaSemanaMenor(){
        cliente.agregarContrato(contratoDiaSemanaMinima);
        assertEquals(100,cliente.monto());
    }
    
    @Test
    void testContratoFinSemanaMayor(){
        cliente.agregarContrato(contratoFinSemanaMayor);
        assertEquals(150*1.15,cliente.monto());
    }
    
    @Test
    void testContratoFinSemanaMenor(){
        cliente.agregarContrato(contratoFinSemanaMinima);
        assertEquals(100*1.15,cliente.monto());
    }
}
