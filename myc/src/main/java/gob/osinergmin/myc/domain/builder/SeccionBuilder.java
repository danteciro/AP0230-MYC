package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghSeccion;
import gob.osinergmin.myc.domain.dto.SeccionDTO;

import java.util.ArrayList;
import java.util.List;

public class SeccionBuilder {
	public static List<SeccionDTO> toListSeccionDto(List<PghSeccion> listado) {
		SeccionDTO registroDTO;
        List<SeccionDTO> retorno = new ArrayList<SeccionDTO>();
        if (listado != null) {
            for (PghSeccion maestro : listado) {
                registroDTO = toSeccionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}

	private static SeccionDTO toSeccionDto(PghSeccion maestro) {
		SeccionDTO registroDTO = new SeccionDTO();
        
        registroDTO.setIdSeccion(maestro.getIdSeccion());
        if(maestro.getRuta()!=null){
        	registroDTO.setRuta(maestro.getRuta());
        }
        if(maestro.getDescripcion()!=null){
        	registroDTO.setDescripcion(maestro.getDescripcion());
        }
        if(maestro.getEstado()!=null){
        	registroDTO.setEstado(maestro.getEstado());
        }
        if(maestro.getObservaciones()!=null){
        	registroDTO.setObservaciones(maestro.getObservaciones());
        }     
        if(maestro.getDescripcionLarga()!=null){
        	registroDTO.setDescripcionLarga(maestro.getDescripcionLarga());
        }

        return registroDTO;
	}
}
