package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghParametroDinamico;
import gob.osinergmin.myc.domain.PghValorParametro;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;

public class ValorParametroBuilder {

	public static PghValorParametro getValorParametro (ValorParametroDTO valorParametroDTO){
		PghValorParametro  valorParametro= null;
		if(valorParametroDTO!=null){
			valorParametro= new PghValorParametro();
			
			valorParametro.setIdValorParametro(valorParametroDTO.getIdValorParametro());
			if(valorParametroDTO.getIdParametroDinamico()!=null){
			    valorParametro.setIdParametroDinamico(new PghParametroDinamico(valorParametroDTO.getIdParametroDinamico()));
			}			
			valorParametro.setEstado(valorParametroDTO.getEstado());
			valorParametro.setDescripcion(valorParametroDTO.getDescripcion());
			valorParametro.setValor(valorParametroDTO.getValor());
			valorParametro.setComentario(valorParametroDTO.getComentario());
			valorParametro.setValorDefecto(valorParametroDTO.getValorDefecto());
			
		}
			
		return valorParametro;
	}
	
	public static List<ValorParametroDTO> toListValorParametro ( List<PghValorParametro> lista){
		List<ValorParametroDTO>  retorno= new ArrayList<ValorParametroDTO>();
		ValorParametroDTO  valorParametroDTO= new ValorParametroDTO();
		if(lista!=null){
			for(PghValorParametro valorParametro : lista){
				valorParametroDTO = toValorParametroDTO(valorParametro);
				retorno.add(valorParametroDTO);
			}
			
		}
			
		return retorno;
	}
	
	
	public static ValorParametroDTO toValorParametroDTO ( PghValorParametro valorParametro){
		ValorParametroDTO  valorParametroDTO= new ValorParametroDTO();
			valorParametroDTO.setIdValorParametro(valorParametro.getIdValorParametro());
		/*	if(valorParametro.getIdParametroDinamico()!=null){
				valorParametroDTO.setIdParametroDinamico(valorParametro.getIdParametroDinamico().getIdParametroDinamico());
			}*/
			valorParametroDTO.setEstado(valorParametro.getEstado());
			valorParametroDTO.setDescripcion(valorParametro.getDescripcion());
			valorParametroDTO.setValor(valorParametro.getValor());
			valorParametroDTO.setComentario(valorParametro.getComentario());
			valorParametroDTO.setValorDefecto(valorParametro.getValorDefecto());
			
			
		return valorParametroDTO;
	}
	
	
	
}
