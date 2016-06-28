/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghOpcion;
import gob.osinergmin.myc.domain.PghRequisito;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class OpcionBuilder {
    public static List<OpcionDTO> toListOpcionDto(List<PghOpcion> lista) {
        OpcionDTO registroDTO;
        List<OpcionDTO> retorno = new ArrayList<OpcionDTO>();
        if (lista != null) {
            for (PghOpcion maestro : lista) {
                registroDTO = toOpcionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static OpcionDTO toOpcionDto(PghOpcion registro) {
    	OpcionDTO registroDTO = new OpcionDTO();
        
        registroDTO.setIdOpcion(registro.getIdOpcion());
        registroDTO.setNombre(registro.getNombre());
        registroDTO.setIdentificador_opcion(registro.getIdentificador_opcion());
        
        return registroDTO;
    }

    
}
