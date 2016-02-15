/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.PghEtapa;
import gob.osinergmin.myc.domain.PghProceso;
import gob.osinergmin.myc.domain.PghTramite;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class TramiteActividadBuilder {
	public static PghCnfTramiteActividad getTramiteActividad(TramiteActividadDTO tramiteActividadDTO){
		PghCnfTramiteActividad tramiteActividad = null;
		if(tramiteActividadDTO != null){
			tramiteActividad = new PghCnfTramiteActividad();
			if(tramiteActividadDTO.getIdTramiteActivdad() != null){
				tramiteActividad.setIdTramiteActivdad(tramiteActividadDTO.getIdTramiteActivdad());
			}
			if(tramiteActividadDTO.getActividad()!=null){
				MdiActividad actividad= new MdiActividad();
				actividad.setIdActividad(tramiteActividadDTO.getActividad().getIdActividad());
				actividad.setNombre(tramiteActividadDTO.getActividad().getNombre());
				tramiteActividad.setIdActividad(actividad);
			}
			
			tramiteActividad.setIdProceso(tramiteActividadDTO.getIdProceso());
			tramiteActividad.setIdEtapa(tramiteActividadDTO.getIdEtapa());
			
	        if(tramiteActividadDTO.getIdTramite()!=null){
	        	PghTramite tramite =new PghTramite();
	        	tramite.setIdTramite(tramiteActividadDTO.getIdTramite());
	        	tramite.setDescripcion(tramiteActividadDTO.getDescripcion());
	        	tramiteActividad.setIdTramite(tramite);   
	        }
			tramiteActividad.setEstado(tramiteActividadDTO.getEstado().toString());
		}
		return tramiteActividad;
	}
	
    public static List<TramiteActividadDTO> toListTramiteActividadDto(List<PghCnfTramiteActividad> lista) {
        TramiteActividadDTO registroDTO;
        List<TramiteActividadDTO> retorno = new ArrayList<TramiteActividadDTO>();
        if (lista != null) {
            for (PghCnfTramiteActividad maestro : lista) {
                registroDTO = toTramiteActividadDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static TramiteActividadDTO toTramiteActividadDto(PghCnfTramiteActividad registro) {
        TramiteActividadDTO registroDTO = new TramiteActividadDTO();
        
        registroDTO.setIdTramiteActivdad(registro.getIdTramiteActivdad());
   
        if(registro.getIdActividad()!=null){
            ActividadDTO actividad=new ActividadDTO();
            actividad.setIdActividad(registro.getIdActividad().getIdActividad());
            actividad.setNombre(registro.getIdActividad().getNombre());
            registroDTO.setActividad(actividad);
        }
        if(registro.getIdTramite()!=null){

        	registroDTO.setIdTramite(registro.getIdTramite().getIdTramite()); 	
        	registroDTO.setDescTramite(registro.getIdTramite().getDescripcion());
        }
        	registroDTO.setIdEtapa(registro.getIdEtapa());      	
                registroDTO.setDescEtapa(registro.getDescEtapa());      	
        	registroDTO.setIdProceso(registro.getIdProceso());
        	registroDTO.setDescripcion(registro.getDescripcion());
        
        
        return registroDTO;
    }
}
