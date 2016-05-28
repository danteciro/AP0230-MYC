package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghParametroDinamico;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;

public class ParametroDinamicoBuilder {

	
	public static PghParametroDinamico getParametrodinamico (ParametroDinamicoDTO parametroDTO){
		PghParametroDinamico  parametro= null;
		if(parametroDTO!=null){
			parametro= new PghParametroDinamico();
			parametro.setIdParametroDinamico(parametroDTO.getIdParametroDinamico());
			
			 if(parametroDTO.getIdAmbitoParametrico()!=null){
				 MdiMaestroColumna ambitoParametrico= new MdiMaestroColumna();
	             ambitoParametrico.setIdMaestroColumna(parametroDTO.getIdAmbitoParametrico().getIdMaestroColumna());
	             ambitoParametrico.setDescripcion(parametroDTO.getIdAmbitoParametrico().getDescripcion());
	             parametro.setIdAmbitoParametrico(ambitoParametrico);
			 }
			parametro.setEstado(parametroDTO.getEstado());
			parametro.setDescripcion(parametroDTO.getDescripcion());
			parametro.setNombre(parametroDTO.getNombre().trim());
			parametro.setComentario(parametroDTO.getComentario());
			
			if(parametroDTO.getIdTipoConsulta().getIdMaestroColumna()!=null){
				 MdiMaestroColumna tipoConsulta= new MdiMaestroColumna();
				 tipoConsulta.setIdMaestroColumna(parametroDTO.getIdTipoConsulta().getIdMaestroColumna());
				 tipoConsulta.setDescripcion(parametroDTO.getIdAmbitoParametrico().getDescripcion());
	             parametro.setIdTipoConsulta(tipoConsulta);
			 }
			parametro.setPregunta(parametroDTO.getPregunta());
			
			
		}
			
		return parametro;
	}
	
	public static List<ParametroDinamicoDTO> toListParametroDinamicoDTO(List<PghParametroDinamico> lista){
		ParametroDinamicoDTO parametroDTO = new ParametroDinamicoDTO();
		List<ParametroDinamicoDTO> retorno =new ArrayList<ParametroDinamicoDTO>();
		
		if(lista!=null){
			 for(PghParametroDinamico parametro:  lista){
			 parametroDTO=toParametroDinamicoDTO(parametro);
			 retorno.add(parametroDTO);
			 }
		}
		return retorno;
		
	}
	 
	
	public static ParametroDinamicoDTO toParametroDinamicoDTO(PghParametroDinamico  parametro){
		
		ParametroDinamicoDTO parametroDTO = new ParametroDinamicoDTO();
		parametroDTO.setIdParametroDinamico(parametro.getIdParametroDinamico());
		
		 if(parametro.getIdAmbitoParametrico()!=null){
             MaestroColumnaDTO ambitoParametrico= new MaestroColumnaDTO();
             ambitoParametrico.setIdMaestroColumna(parametro.getIdAmbitoParametrico().getIdMaestroColumna());
            ambitoParametrico.setDescripcion(parametro.getIdAmbitoParametrico().getDescripcion());
             parametroDTO.setIdAmbitoParametrico(ambitoParametrico);
		 }
		parametroDTO.setNombre(parametro.getNombre().trim());
		parametroDTO.setDescripcion(parametro.getDescripcion());
		parametroDTO.setEstado(parametro.getEstado());
		parametroDTO.setComentario(parametro.getComentario());
		
		if(parametro.getIdTipoConsulta()!=null){
			MaestroColumnaDTO tipoConsulta= new MaestroColumnaDTO();
			 tipoConsulta.setIdMaestroColumna(parametro.getIdTipoConsulta().getIdMaestroColumna());
			 tipoConsulta.setDescripcion(parametro.getIdAmbitoParametrico().getDescripcion());
			 parametroDTO.setIdTipoConsulta(tipoConsulta);
		 }
		parametroDTO.setPregunta(parametro.getPregunta());
		
		
		return parametroDTO;
		
	}
}
