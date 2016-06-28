/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghOpcion;
import gob.osinergmin.myc.domain.PghRubroOpcion;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class RubroOpcionBuilder {
	public static PghRubroOpcion getRubroOpcion(RubroOpcionDTO rubroOpcionDTO){
		PghRubroOpcion rubroOpcion = null;
		if(rubroOpcionDTO != null){
			rubroOpcion = new PghRubroOpcion();
			if(rubroOpcionDTO.getIdRubroOpcion() != null){
				rubroOpcion.setIdRubroOpcion(rubroOpcionDTO.getIdRubroOpcion());
			}
			
			if(rubroOpcionDTO.getIdActividad() != null){
				MdiActividad actividad= new MdiActividad();
				actividad.setIdActividad(rubroOpcionDTO.getIdActividad());
				rubroOpcion.setIdActividad(actividad);
			}
			
			if(rubroOpcionDTO.getOpcion()!=null){
				PghOpcion opcion= new PghOpcion();
				opcion.setIdOpcion(rubroOpcionDTO.getOpcion().getIdOpcion());
				opcion.setNombre(rubroOpcionDTO.getOpcion().getNombre());
				rubroOpcion.setIdOpcion(opcion);
			}
			
//			rubroOpcion.setIdProceso(rubroOpcionDTO.getIdProceso());
//			rubroOpcion.setIdEtapa(rubroOpcionDTO.getIdEtapa());			
			rubroOpcion.setEstado(rubroOpcionDTO.getEstado().toString());
		}
		return rubroOpcion;
	}
	
    public static List<RubroOpcionDTO> toListRubroOpcionDto(List<PghRubroOpcion> lista) {
    	RubroOpcionDTO registroDTO;
        List<RubroOpcionDTO> retorno = new ArrayList<RubroOpcionDTO>();
        if (lista != null) {
            for (PghRubroOpcion maestro : lista) {
                registroDTO = toRubroOpcionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static RubroOpcionDTO toRubroOpcionDto(PghRubroOpcion registro) {
    	RubroOpcionDTO registroDTO = new RubroOpcionDTO();
        
        registroDTO.setIdRubroOpcion(registro.getIdRubroOpcion());
   
        if(registro.getIdOpcion()!=null){
            OpcionDTO opcion=new OpcionDTO();
            opcion.setIdOpcion(registro.getIdOpcion().getIdOpcion());
            opcion.setNombre(registro.getIdOpcion().getNombre());
            registroDTO.setOpcion(opcion);
        }
        if(registro.getIdActividad()!=null){
            registroDTO.setIdActividad(registro.getIdActividad().getIdActividad());
            registroDTO.setDescActividad(registro.getIdActividad().getNombre());
        }
        
        return registroDTO;
    }
}
