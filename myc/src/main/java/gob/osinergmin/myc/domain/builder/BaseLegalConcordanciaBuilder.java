package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghListadoBaseLegal;
import gob.osinergmin.myc.domain.dto.BaseLegalConcordanciaDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;

import java.util.ArrayList;
import java.util.List;

public class BaseLegalConcordanciaBuilder {

    public static PghListadoBaseLegal getBaseLegalConcordancia(BaseLegalConcordanciaDTO registroDTO) {
        PghListadoBaseLegal registro = null;
        if(registroDTO!=null){
            registro=new PghListadoBaseLegal();
            
            PghBaseLegal blo = new PghBaseLegal();
            blo.setIdBaseLegal(registroDTO.getIdBaseLegalOrigen());
            registro.setIdBaseLegalOri(blo);
            
            PghBaseLegal bld = new PghBaseLegal();
            bld.setIdBaseLegal(registroDTO.getIdBaseLegalDestino());
            registro.setIdBaseLegalDest(bld);
            
            registro.setEstado(registroDTO.getEstado());
            if(registroDTO.getCodTrazabilidad()!=null){
                registro.setCodTrazabilidad(registroDTO.getCodTrazabilidad());
            }
        }
        return registro;
    }
    
    public static List<BaseLegalConcordanciaDTO> toListBaseLegalConcordanciaDto(List<PghListadoBaseLegal> lista) {
    	BaseLegalConcordanciaDTO baseLegalConcordanciaDTO;
        List<BaseLegalConcordanciaDTO> retorno = new ArrayList<BaseLegalConcordanciaDTO>();
        if (lista != null) {
            for (PghListadoBaseLegal maestro : lista) {
            	baseLegalConcordanciaDTO = toBaseLegalConcordanciaDto(maestro);
                retorno.add(baseLegalConcordanciaDTO);
            }
        }
        return retorno;
        /*llenar listado aca*/
    }
    
    public static BaseLegalConcordanciaDTO toBaseLegalConcordanciaDto(PghListadoBaseLegal registro) {
    	BaseLegalConcordanciaDTO registroDTO = new BaseLegalConcordanciaDTO();
        
    	if(registro!=null){
    	registroDTO.setIdListadoBaseLegal(registro.getIdListadoBaseLegal());
    	registroDTO.setIdBaseLegalOrigen(registro.getIdBaseLegalOri().getIdBaseLegal());
    	registroDTO.setIdBaseLegalDestino(registro.getIdBaseLegalDest().getIdBaseLegal());
    	registroDTO.setEstado(registro.getEstado());
    	
    	registroDTO.setCodigoBaseLegal(registro.getIdBaseLegalDest().getCodigoBaseLegal());
        registroDTO.setDescripcion(registro.getIdBaseLegalDest().getDescripcion());
    	
    	}
        return registroDTO;
    }
    
    public static List<BaseLegalDTO> toListBaseLegalConcordanciaRefDto(List<Object[]> lista) {
        List<BaseLegalDTO> retorno = new ArrayList<BaseLegalDTO>();
        if (lista != null) {
        	BaseLegalDTO registroDTO = new BaseLegalDTO();
            for (Object[] maestro : lista) {
            	PghBaseLegal pghBaseLegal = (PghBaseLegal)maestro[0];
            	registroDTO = new BaseLegalDTO();
            	registroDTO.setIdBaseLegal(pghBaseLegal.getIdBaseLegal());
            	registroDTO.setCodigoBaseLegal(pghBaseLegal.getCodigoBaseLegal());
                registroDTO.setDescripcionGeneralBaseLegal(pghBaseLegal.getDescripcion());
                
                retorno.add(registroDTO);
            }
        }
        return retorno;
        /*llenar listado aca*/
    }
}
