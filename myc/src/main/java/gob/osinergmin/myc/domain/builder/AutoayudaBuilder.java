/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghAutoayuda;
import gob.osinergmin.myc.domain.dto.AutoayudaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class AutoayudaBuilder {
    public static List<AutoayudaDTO> toListAutoayudaDto(List<PghAutoayuda> lista) {
        AutoayudaDTO registroDTO;
        List<AutoayudaDTO> retorno = new ArrayList<AutoayudaDTO>();
        if (lista != null) {
            for (PghAutoayuda maestro : lista) {
                registroDTO = toAutoayudaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static AutoayudaDTO toAutoayudaDto(PghAutoayuda registro) {
        AutoayudaDTO registroDTO = new AutoayudaDTO();
        
        registroDTO.setIdAutoayuda(registro.getIdAutoayuda());
        registroDTO.setNombreAutoayuda(registro.getNombreAutoayuda());
        registroDTO.setIdentificadorAutoayuda(registro.getIdentificadorAutoayuda());
        registroDTO.setDescripcionAutoayuda(registro.getDescripcionAutoayuda());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
    
    public static PghAutoayuda getAutoayuda(AutoayudaDTO registroDTO) {
        PghAutoayuda registro = null;
        if(registroDTO!=null){
            registro=new PghAutoayuda();
            registro.setIdAutoayuda(registroDTO.getIdAutoayuda());
            registro.setEstado(registroDTO.getEstado());
            registro.setNombreAutoayuda(registroDTO.getNombreAutoayuda());
            registro.setIdentificadorAutoayuda(registroDTO.getIdentificadorAutoayuda());
            registro.setDescripcionAutoayuda(registroDTO.getDescripcionAutoayuda());
        }
        return registro;

    }
}
