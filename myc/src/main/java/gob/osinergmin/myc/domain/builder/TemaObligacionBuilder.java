package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;

import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghTemaObligacionMaestro;
//import gob.osinergmin.myc.domain.PghTemaObligacionMaestroPK;
import gob.osinergmin.myc.domain.dto.TemaDTO;

public class TemaObligacionBuilder {
	
	public static PghTemaObligacionMaestro getTemaObligacion(TemaDTO temaDTO){
		PghTemaObligacionMaestro registro=null;
		if(temaDTO!=null){
			registro = new PghTemaObligacionMaestro();
			registro.setEstado(temaDTO.getEstado());
			
			registro.setIdTemaObligacion(temaDTO.getIdTemaObligacion());
			
//			PghTemaObligacionMaestroPK registroPK=new PghTemaObligacionMaestroPK(temaDTO.getIdObligacion(), temaDTO.getIdTemOblMa());
//			registro.setPghTemaObligacionMaestroPK(registroPK);
                        registro.setIdTemOblMa(temaDTO.getIdTemOblMa());
			
			PghObligacion pghObligacion = new PghObligacion(temaDTO.getIdObligacion());
			registro.setIdObligacion(pghObligacion);
                        registro.setCodTrazabilidad(temaDTO.getCodTrazabilidad());
		}
		return registro;
	}
	
	public static List<TemaDTO> toListTemaObligacionDto(List<PghTemaObligacionMaestro> lista){
		TemaDTO temaDTO;
		List<TemaDTO> retorno = new ArrayList<TemaDTO>();
		if(lista!=null){
			for(PghTemaObligacionMaestro maestro:lista){
				temaDTO = toTemaDto(maestro);
                retorno.add(temaDTO);
			}
		}
		
		return retorno;
	}
	
	public static TemaDTO toTemaDto(PghTemaObligacionMaestro retorno){
		TemaDTO temaDTO = new TemaDTO();
		if(retorno!=null){
			temaDTO.setEstado(retorno.getEstado());
			temaDTO.setIdObligacion(retorno.getIdObligacion().getIdObligacion());
			temaDTO.setIdTemaObligacion(retorno.getIdTemaObligacion());
			temaDTO.setIdTemOblMa(retorno.getIdTemOblMa());
		}
		return temaDTO;
		
	}

}
