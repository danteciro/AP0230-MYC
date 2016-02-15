/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghZonificacion;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class ZonificacionBuilder {
    public static PghZonificacion getZonificacion(ZonificacionDTO zonificacionDTO){
        PghZonificacion registro = null;
        if(zonificacionDTO != null){
            registro = new PghZonificacion();
            if(zonificacionDTO.getIdZonificacion() != null){
                registro.setIdZonificacion(zonificacionDTO.getIdZonificacion());
            }
            registro.setNombre(zonificacionDTO.getNombre().toUpperCase());
            registro.setEstado(zonificacionDTO.getEstado());
        }
        return registro;
    }
    
    public static List<ZonificacionDTO> toListZonificacionDto(List<PghZonificacion> lista) {
        ZonificacionDTO registroDTO;
        List<ZonificacionDTO> retorno = new ArrayList<ZonificacionDTO>();
        if (lista != null) {
            for (PghZonificacion maestro : lista) {
                registroDTO = toZonificacionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    
    public static ZonificacionDTO toZonificacionDto(PghZonificacion registro) {
        ZonificacionDTO registroDTO = new ZonificacionDTO();
        
        registroDTO.setIdZonificacion(registro.getIdZonificacion());
        registroDTO.setNombre(registro.getNombre().toUpperCase());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
}
