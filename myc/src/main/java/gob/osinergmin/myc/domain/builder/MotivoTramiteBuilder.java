/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghMotivoTramite;
import gob.osinergmin.myc.domain.dto.MotivoTramiteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class MotivoTramiteBuilder {
    public static List<MotivoTramiteDTO> toListMotivoTramiteDto(List<PghMotivoTramite> lista) {
        MotivoTramiteDTO registroDTO;
        List<MotivoTramiteDTO> retorno = new ArrayList<MotivoTramiteDTO>();
        if (lista != null) {
            for (PghMotivoTramite maestro : lista) {
                registroDTO = toMotivoTramiteDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static MotivoTramiteDTO toMotivoTramiteDto(PghMotivoTramite registro) {
        MotivoTramiteDTO registroDTO = new MotivoTramiteDTO();
        
        registroDTO.setIdMotivoTramite(registro.getIdMotivoTramite());
        registroDTO.setDescripcion(registro.getDescripcion());
        
        return registroDTO;
    }
}
