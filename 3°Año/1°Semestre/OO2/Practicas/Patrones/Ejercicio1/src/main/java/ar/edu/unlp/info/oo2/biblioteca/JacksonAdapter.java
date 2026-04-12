package ar.edu.unlp.info.oo2.biblioteca;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class JacksonAdapter implements Exporter {

    @Override
    public String exportar(List<Socio> socios) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Convierte toda la lista de socios a JSON automáticamente
            return mapper.writeValueAsString(socios);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error procesando el JSON con Jackson", e);
        }
    }
}
