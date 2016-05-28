package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghObligacionTipo;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;

import java.util.ArrayList;
import java.util.List;

public class ObligacionTipoBuilder {
	 public static PghObligacionTipo getObligacionTipo(ObligacionTipoDTO ObligacionTipoDTO){
	        PghObligacionTipo registro = null;
	        if(ObligacionTipoDTO != null){
	            registro = new PghObligacionTipo();
	            if(ObligacionTipoDTO.getIdObligacionTipo() != null){
	                registro.setIdObligacionTipo(ObligacionTipoDTO.getIdObligacionTipo());
	            }
	            registro.setNombre(ObligacionTipoDTO.getNombre());
	            registro.setEstado(ObligacionTipoDTO.getEstado());
	        }
	        return registro;
	    }
	    
	    public static List<ObligacionTipoDTO> toListObligacionTipoDto(List<PghObligacionTipo> lista) {
	        ObligacionTipoDTO registroDTO;
	        List<ObligacionTipoDTO> retorno = new ArrayList<ObligacionTipoDTO>();
	        if (lista != null) {
	            for (PghObligacionTipo maestro : lista) {
	                registroDTO = toObligacionTipoDto(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	    }
	    
	    public static ObligacionTipoDTO toObligacionTipoDto(PghObligacionTipo registro) {
	        ObligacionTipoDTO registroDTO = new ObligacionTipoDTO();
	        
	        registroDTO.setIdObligacionTipo(registro.getIdObligacionTipo());
	        registroDTO.setNombre(registro.getNombre());
	        registroDTO.setEstado(registro.getEstado());
	        
	        return registroDTO;
	    }
}
