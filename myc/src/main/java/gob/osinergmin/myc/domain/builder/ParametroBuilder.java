/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghRequisito;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class ParametroBuilder {
    public static List<ParametroDinamicoDTO> toListParametroDto(List<PghRequisito> lista) {
        ParametroDinamicoDTO parametroDTO;
        List<ParametroDinamicoDTO> retorno = new ArrayList<ParametroDinamicoDTO>();
        if (lista != null) {
            for (PghRequisito maestro : lista) {
                parametroDTO = toParametroDto(maestro);
                retorno.add(parametroDTO);
            }
        }
        return retorno;
    } 
    public static ParametroDinamicoDTO toParametroDto(PghRequisito registro) {
        ParametroDinamicoDTO registroDTO = new ParametroDinamicoDTO();
        
        registroDTO.setIdParametroDinamico(registro.getIdRequisito());
        
        return registroDTO;
    }
}
