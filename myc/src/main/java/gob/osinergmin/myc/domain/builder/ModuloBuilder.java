package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghModulo;
import gob.osinergmin.myc.domain.dto.ModuloDTO;

import java.util.ArrayList;
import java.util.List;

public class ModuloBuilder {

	public static List<ModuloDTO> toListModuloDto(List<PghModulo> listado) {
		ModuloDTO registroDTO;
        List<ModuloDTO> retorno = new ArrayList<ModuloDTO>();
        if (listado != null) {
            for (PghModulo maestro : listado) {
                registroDTO = toModuloDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}

	private static ModuloDTO toModuloDto(PghModulo maestro) {
		ModuloDTO registroDTO = new ModuloDTO();
        
        registroDTO.setIdModulo(maestro.getIdModulo());
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

        return registroDTO;
	}
	
	

}
