package ar.edu.info.oo1.clientedecorreo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author elian
 */
public class ClienteDeCorreoTest {
    /*
    Test de unidad para Archivo, Email, Carpeta, y Cliente de correo

    Particiones de equivalencia:
    - Archivo: nombre (no vacio, vacio(""))
    - Email: asunto (no vacio, vacio("")), cuerpo (no vacio, vacio("")), archivos adjuntos (0, 1, varios)
    - Carpeta: nombre (no vacio, vacio("")), emails (0, 1, varios)
    - Cliente de correo: carpetas (0, 1, varios), emails en bandeja de entrada (0, 1, varios)
    
    */
    
    private Archivo archivoTest;
    
    @BeforeEach
     void setUp() {
         
     }
    
}
