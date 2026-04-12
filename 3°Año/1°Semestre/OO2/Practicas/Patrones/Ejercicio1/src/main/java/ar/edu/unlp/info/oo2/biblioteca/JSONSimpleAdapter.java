package ar.edu.unlp.info.oo2.biblioteca;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

/**
 *
 * @author Elian
 */
public class JSONSimpleAdapter implements Exporter {

    @Override
    public String exportar(List<Socio> socios) {
        JSONArray jsonArray = new JSONArray();
        
        for(Socio socio : socios) {
            JSONObject jsonSocio = new JSONObject();
            jsonSocio.put("nombre", socio.getNombre());
            jsonSocio.put("email", socio.getEmail());
            jsonSocio.put("legajo", socio.getLegajo());

            jsonArray.add(jsonSocio);
        }
        
        return jsonArray.toJSONString();
    }
    
}
