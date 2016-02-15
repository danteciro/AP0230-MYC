/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghRequisito;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class ActividadBuilder {
    public static List<ActividadDTO> toListActividadDto(List<MdiActividad> lista) {
        ActividadDTO registroDTO;
        List<ActividadDTO> retorno = new ArrayList<ActividadDTO>();
        if (lista != null) {
            for (MdiActividad maestro : lista) {
                registroDTO = toActividadDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static ActividadDTO toActividadDto(MdiActividad registro) {
        ActividadDTO registroDTO = new ActividadDTO();
        
        registroDTO.setIdActividad(registro.getIdActividad());
        registroDTO.setNombre(registro.getNombre());
        registroDTO.setIdActividadPadre(registro.getIdActividadPadre());
        
        return registroDTO;
    }

    
}
