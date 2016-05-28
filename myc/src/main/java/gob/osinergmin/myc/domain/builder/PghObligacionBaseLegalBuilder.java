package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghObligacionBaseLegal;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;

import java.util.ArrayList;
import java.util.List;

public class PghObligacionBaseLegalBuilder {
	
    public static List<ObligacionBaseLegalDTO> toListRelacionDto(List<PghObligacionBaseLegal> lista) {
    	ObligacionBaseLegalDTO registroDTO;
        List<ObligacionBaseLegalDTO> retorno = new ArrayList<ObligacionBaseLegalDTO>();
        if (lista != null) {
            for (PghObligacionBaseLegal maestro : lista) {
                registroDTO = toRelacionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static ObligacionBaseLegalDTO toRelacionDto(PghObligacionBaseLegal registro) {
    	ObligacionBaseLegalDTO registroDTO = new ObligacionBaseLegalDTO();
        registroDTO.setIdObligacion(registro.getIdObligacion().getIdObligacion());
        
        return registroDTO;
    }
	
//    public static List<ObligacionBaseLegalDTO> toListRelacionDto(List<PghObligacionBaseLegalPK> lista) {
//    	ObligacionBaseLegalDTO registroDTO;
//        List<ObligacionBaseLegalDTO> retorno = new ArrayList<ObligacionBaseLegalDTO>();
//        if (lista != null) {
//            for (PghObligacionBaseLegalPK maestro : lista) {
//                registroDTO = toRelacionDto(maestro);
//                retorno.add(registroDTO);
//            }
//        }
//        return retorno;
//    } 
//    public static ObligacionBaseLegalDTO toRelacionDto(PghObligacionBaseLegalPK registro) {
//    	ObligacionBaseLegalDTO registroDTO = new ObligacionBaseLegalDTO();
//        ObligacionNormativaDTO obligacionDTO = new ObligacionNormativaDTO();
//        obligacionDTO.setIdObligacion(registro.getIdObligacion());
//        registroDTO.setIdObligacion(obligacionDTO.getIdObligacion());
//        
//        return registroDTO;
//    }

}