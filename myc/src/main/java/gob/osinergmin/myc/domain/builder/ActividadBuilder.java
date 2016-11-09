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
        /* OSINE_SFS-600 - REQF-0009 - Inicio */
        registroDTO.setCodigo(registro.getCodigo());
        registroDTO.setOrden(registro.getOrdenNps());
        /* OSINE_SFS-600 - REQF-0009 - Fin */
        
        /* OSINE_SFS-1232 - REQF- - Inicio */
        registroDTO.setEstado(registro.getEstado());
        
        /* OSINE_SFS-1232 - REQF- - Fin */
        
        return registroDTO;
    }
    
    /* OSINE_SFS-600 - REQF-0009 - Inicio */
    public static List<ActividadDTO> toListActividadAgenteInstalacion(List<Object[]> listadoAgenteInstalacion) {
    	ActividadDTO actividad;
    	List<ActividadDTO> listadoRetorno = new ArrayList<ActividadDTO>();
    	if (listadoAgenteInstalacion != null) {
            for (Object[] maestro : listadoAgenteInstalacion) {
            	actividad = new ActividadDTO();
            	if(maestro[0]!=null){
            		actividad.setIdActividadPadre(new Long(maestro[0].toString()));
            	}            	
            	if(maestro[1]!=null){
            		actividad.setOrdenPadre(Integer.parseInt(maestro[1].toString()));
            	}
            	if(maestro[2]!=null){
            		actividad.setNombrePadre(maestro[2].toString());
            	}
            	
            	if(maestro[3]!=null){
            		actividad.setCodigoPadre(maestro[3].toString());
            	}
            	
            	if(maestro.length>4){
	            	if(maestro[4]!=null){
	            		actividad.setIdActividad(new Long(maestro[4].toString()));
	            	}
	            	if(maestro[5]!=null){
	            		actividad.setOrden(Integer.parseInt(maestro[5].toString()));
	            	}
	            	if(maestro[6]!=null){
	            		actividad.setNombre(maestro[6].toString());
	            	}
	            	if(maestro[7]!=null){
	            		actividad.setCodigo(maestro[7].toString());
	            	}
            	}
            	listadoRetorno.add(actividad);
            }
    	}        
        return listadoRetorno;
    }
    
    public static MdiActividad getMdiActividad(ActividadDTO actividadDto){
    	MdiActividad actividad =null;
    	if(actividadDto!=null){
    		actividad = new MdiActividad();
    		actividad.setCodigo(actividadDto.getCodigo());
    		actividad.setNombre(actividadDto.getNombre());
    		actividad.setOrdenNps(actividadDto.getOrden());
    		if(actividadDto.getIdActividad()!=null){
    			actividad.setIdActividad(actividadDto.getIdActividad());
    		}
    		if(actividadDto.getIdActividadPadre()!=null){
    			actividad.setIdActividadPadre(actividadDto.getIdActividadPadre());
    		}
    	}
    	return actividad;
    }
    
    public static ActividadDTO getActividadDTO(MdiActividad actividad){
    	ActividadDTO actividadDto =null;
    	if(actividad!=null){
    		actividadDto = new ActividadDTO();
    		actividadDto.setCodigo(actividad.getCodigo());
    		actividadDto.setNombre(actividad.getNombre());
    		actividadDto.setOrden(actividad.getOrdenNps());
    		actividadDto.setEstado(actividad.getEstado());
    		if(actividad.getIdActividad()!=null){
    			actividadDto.setIdActividad(actividad.getIdActividad());
    		}
    		if(actividad.getIdActividadPadre()!=null){
    			actividadDto.setIdActividadPadre(actividad.getIdActividadPadre());
    		}
    	}
    	return actividadDto;
    }
    
    public static String toVerificarEliminar(List<Object[]> listado) {
    	String mensaje = "";
    	if (listado != null) {    		
            for (Object[] registro : listado) {
            	for (int i=0;i<registro.length;i++) {
            		if(registro[i]!=null){
            			mensaje+=registro[i].toString()+", ";
            		}
            	}
            }
    	}    
    	if(mensaje.length()!=0)
    		mensaje = "<b>"+mensaje.substring(0, mensaje.length()-2)+"</b>";
        return mensaje;
    }
    /* OSINE_SFS-600 - REQF-0009 - Fin */
    
}
