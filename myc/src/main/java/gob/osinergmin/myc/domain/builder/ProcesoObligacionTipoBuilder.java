package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghObligacionTipo;
import gob.osinergmin.myc.domain.PghProceso;
import gob.osinergmin.myc.domain.PghProcesoObligacionTipo;
import gob.osinergmin.myc.domain.PghProcesoObligacionTipoPK;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;

public class ProcesoObligacionTipoBuilder {
    /**
     * Objeto DTO to JPA
     * @param registroDTO
     * @return
     */
    public static PghProcesoObligacionTipo getProcesoObligacionTipo(ProcesoObligacionTipoDTO registroDTO){
        PghProcesoObligacionTipo registro=null;
        if(registroDTO!=null){
            registro= new PghProcesoObligacionTipo();
            
            if(registroDTO.getIdProOblTip()!= null && 
                registroDTO.getIdProceso()!= null && 
                registroDTO.getIdObligacionTipo()!= null && 
                (registroDTO.getActividad()!=null && registroDTO.getActividad().getIdActividad()!=null ) ){
                PghProcesoObligacionTipoPK pk = new PghProcesoObligacionTipoPK(registroDTO.getIdObligacionTipo(),registroDTO.getIdProceso(),registroDTO.getActividad().getIdActividad(),registroDTO.getIdProOblTip());
                registro.setPghProcesoObligacionTipoPK(pk);
            }
            
            if(registroDTO.getActividad()!=null){
                MdiActividad actividad= new MdiActividad();
                actividad.setIdActividad(registroDTO.getActividad().getIdActividad());
                actividad.setNombre(registroDTO.getActividad().getNombre());
                registro.setMdiActividad(actividad);
            }
            if(registroDTO.getProceso()!=null){
                PghProceso proceso= new PghProceso();
                proceso.setIdProceso(registroDTO.getProceso().getIdProceso());
                proceso.setDescripcion(registroDTO.getProceso().getDescripcion());
                registro.setPghProceso(proceso);
            }   
            if(registroDTO.getObligacionTipo()!=null){
                PghObligacionTipo obligacionTipo = new  PghObligacionTipo();
                obligacionTipo.setIdObligacionTipo(registroDTO.getObligacionTipo().getIdObligacionTipo());
                obligacionTipo.setNombre(registroDTO.getObligacionTipo().getNombre());
                registro.setPghObligacionTipo(obligacionTipo);
            }   
            registro.setEstado(registroDTO.getEstado());
        }
        return registro;
    }
	/**
	 * List Objeto DTO
	 * @param lista
	 * @return
	 */
	public static List<ProcesoObligacionTipoDTO> toListProcesoObligacionTipoDto(List<PghProcesoObligacionTipo> lista){
		ProcesoObligacionTipoDTO proceso;
		List<ProcesoObligacionTipoDTO> retorno=new ArrayList<ProcesoObligacionTipoDTO>();
		if(lista != null){
			for(PghProcesoObligacionTipo maestro:lista){
				proceso = toProcesoObligacionTipoDto(maestro);
				retorno.add(proceso);
			}
		}
		return retorno;
	}
	/**
	 * Objeto JPA to DTO
	 * @param registro
	 * @return
	 */
	public static ProcesoObligacionTipoDTO toProcesoObligacionTipoDto(PghProcesoObligacionTipo registro){
		ProcesoObligacionTipoDTO registroDTO = new ProcesoObligacionTipoDTO();
		if(registro!=null){
			
	        if(registro.getMdiActividad()!=null){
	            ActividadDTO actividad=new ActividadDTO();
	            actividad.setIdActividad(registro.getMdiActividad().getIdActividad());
	            actividad.setNombre(registro.getMdiActividad().getNombre());
	            registroDTO.setActividad(actividad);
	        }
	        
	        if(registro.getPghProceso()!=null){
	        	ProcesoDTO proceso= new ProcesoDTO();
	        	proceso.setIdProceso(registro.getPghProceso().getIdProceso());
	        	proceso.setDescripcion(registro.getPghProceso().getDescripcion());
	        	registroDTO.setProceso(proceso);
	        }
	        if(registro.getPghObligacionTipo()!=null){
	        	ObligacionTipoDTO obligacionTipo = new  ObligacionTipoDTO();
	        	obligacionTipo.setIdObligacionTipo(registro.getPghObligacionTipo().getIdObligacionTipo());
	        	obligacionTipo.setNombre(registro.getPghObligacionTipo().getNombre());
	        	registroDTO.setObligacionTipo(obligacionTipo);
	        }        
			
			registroDTO.setIdProOblTip(registro.getPghProcesoObligacionTipoPK().getIdProOblTip());
			registroDTO.setEstado(registro.getEstado());
		}
		return registroDTO;
		
	}
	
	public static List<ProcesoDTO> toListProcesoByObligacionTipoDto(List<Object[]> lista){
		List<ProcesoDTO> retorno=new ArrayList<ProcesoDTO>();
		if(lista != null){
			ProcesoDTO objDTO;
			for (int i = 0; i < lista.size(); i++) {
				Object[] nombreObjeto = new Object[10];
				nombreObjeto =  lista.get(i);
				Long num = (Long) nombreObjeto[0]; 
				String text = (String) nombreObjeto[1];
				objDTO = new ProcesoDTO();
				objDTO.setIdProceso(num);
				objDTO.setDescripcion(text);
				retorno.add(objDTO);
			}
		}
		return retorno;
		
	} 
	
	public static List<ObligacionTipoDTO> toListobligacionTipoByObligacionTipoDto(List<PghProcesoObligacionTipo> lista){
		List<ObligacionTipoDTO> retorno=new ArrayList<ObligacionTipoDTO>();
		if(lista != null){
			ObligacionTipoDTO objDTO;
			for (PghProcesoObligacionTipo maestro: lista) {
				objDTO = new ObligacionTipoDTO();
				objDTO.setIdObligacionTipo(maestro.getPghObligacionTipo().getIdObligacionTipo());
				objDTO.setNombre(maestro.getPghObligacionTipo().getNombre());
				retorno.add(objDTO);
			}
		}
		return retorno;
		
	} 
	
	public static List<ProcesoObligacionTipoDTO> toListProcesoObligacionTipoByActividadDto(	List<Object[]> resultado) {
		List<ProcesoObligacionTipoDTO> retorno = new ArrayList<ProcesoObligacionTipoDTO>();
		if(resultado!=null){
			ProcesoObligacionTipoDTO proceso;
			for(Object[] obj:resultado){
				proceso = new ProcesoObligacionTipoDTO();
				ActividadDTO actividad = new ActividadDTO();
				actividad.setIdActividad((Long) obj[0]);
				actividad.setNombre(obj[1].toString());
				actividad.setIdActividadPadre((Long) obj[2]);
				proceso.setActividad(actividad);
				retorno.add(proceso);
			}
		}
		return retorno;
	} 
	public static List<ProcesoObligacionTipoDTO> toListProcesoObligacionTipoByActividadFancyDto(List<Object[]> resultado) {
		List<ProcesoObligacionTipoDTO> retorno = new ArrayList<ProcesoObligacionTipoDTO>();
		if(resultado!=null){
			ProcesoObligacionTipoDTO proceso;
			for(Object[] obj:resultado){
				proceso = new ProcesoObligacionTipoDTO();
				proceso.setIdActividad((Long) obj[0]);
				proceso.setNombreActividad(obj[1].toString());
				proceso.setIdActvidadPadre((Long) obj[2]);
				retorno.add(proceso);
			}
		}
		return retorno;
	}
	public static List<ObligacionTipoDTO> toListOblgTipoConfDto(List<Object[]> lstObligacionesTipo) {
		List<ObligacionTipoDTO> retorno = new ArrayList<ObligacionTipoDTO>();
		if(lstObligacionesTipo!=null){
			ObligacionTipoDTO oblTipo;
			for(Object[] obj:lstObligacionesTipo){
				oblTipo = new ObligacionTipoDTO();
				oblTipo.setIdObligacionTipo(new Long(obj[0].toString()));
				oblTipo.setNombre(obj[1].toString());
				retorno.add(oblTipo);
			}
		}
		return retorno;
	}
	
}
