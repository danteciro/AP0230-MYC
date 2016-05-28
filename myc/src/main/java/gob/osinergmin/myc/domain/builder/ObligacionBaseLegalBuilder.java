/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghObligacionBaseLegal;
//import gob.osinergmin.myc.domain.PghObligacionBaseLegalPK;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;

/**
 *
 * @author lbarboza
 */
public class ObligacionBaseLegalBuilder {
    public static PghObligacionBaseLegal getObligacionBaseLegal(ObligacionBaseLegalDTO obligacionBaseLegalDTO){
        PghObligacionBaseLegal registro = null;
//        PghObligacion pghObligacion = null;
//        PghBaseLegal pghBaseLegal = null;
        
        if(obligacionBaseLegalDTO != null){
            registro = new PghObligacionBaseLegal();
//            if(obligacionBaseLegalDTO.getIdOblBase() != null && 
//                obligacionBaseLegalDTO.getIdBaseLegal() != null && 
//                obligacionBaseLegalDTO.getIdObligacion() != null){
//                PghObligacionBaseLegalPK pk = new PghObligacionBaseLegalPK(obligacionBaseLegalDTO.getIdObligacion(), obligacionBaseLegalDTO.getIdBaseLegal(), obligacionBaseLegalDTO.getIdOblBase());
//                registro.setPghObligacionBaseLegalPK(pk);
//            }
            registro.setIdOblBase(obligacionBaseLegalDTO.getIdOblBase());
            if(obligacionBaseLegalDTO.getIdBaseLegal()!=null){
                registro.setIdBaseLegal(new PghBaseLegal(obligacionBaseLegalDTO.getIdBaseLegal()));
            }
            if(obligacionBaseLegalDTO.getIdObligacion()!=null){
                registro.setIdObligacion(new PghObligacion(obligacionBaseLegalDTO.getIdObligacion()));
            }
            registro.setEstado(obligacionBaseLegalDTO.getEstado());
            registro.setCodTrazabilidad(obligacionBaseLegalDTO.getCodTrazabilidad());
        }
        return registro;
    }
    
    public static List<ObligacionBaseLegalDTO> toListObligacionBaseLegalDto(List<PghObligacionBaseLegal> lista){
        ObligacionBaseLegalDTO obligacionBaseLegalDTO;
        List<ObligacionBaseLegalDTO> retorno = new ArrayList<ObligacionBaseLegalDTO>();
        if(lista != null){
            for(PghObligacionBaseLegal maestro : lista){
                obligacionBaseLegalDTO = toObligacionBaseLegalDto(maestro);
                retorno.add(obligacionBaseLegalDTO);
            }
        }
        return retorno;
    }
    
    public static ObligacionBaseLegalDTO toObligacionBaseLegalDto(PghObligacionBaseLegal obligacionBaseLegal){
        ObligacionBaseLegalDTO obligacionBaseLegalDTO = new ObligacionBaseLegalDTO();
        
        obligacionBaseLegalDTO.setIdOblBase(obligacionBaseLegal.getIdOblBase());
        obligacionBaseLegalDTO.setIdObligacion(obligacionBaseLegal.getIdObligacion().getIdObligacion());
        obligacionBaseLegalDTO.setIdBaseLegal(obligacionBaseLegal.getIdBaseLegal().getIdBaseLegal());
        obligacionBaseLegalDTO.setEstado(obligacionBaseLegal.getEstado());
        
        return obligacionBaseLegalDTO;
    }
    
    public static List<ObligacionBaseLegalDTO> toListObligacionBaseLegalRefDto(List<Object[]> lista) {
        List<ObligacionBaseLegalDTO> retorno = new ArrayList<ObligacionBaseLegalDTO>();
        if (lista != null) {
        	ObligacionBaseLegalDTO registroDTO;
            for (Object[] maestro : lista) {
            	Log.info("lista: "+lista);
            	registroDTO = new ObligacionBaseLegalDTO();
            	registroDTO.setIdObligacion((Long) maestro[0]);
            	registroDTO.setCodigoObligacion(maestro[1].toString());
                registroDTO.setDescripcion(maestro[2].toString());
                if(maestro[3] != null){
                    registroDTO.setIdDocumentoAdjunto((Long)maestro[3]);
                }
                retorno.add(registroDTO);
            }
        }
        return retorno;
        /*llenar listado aca*/
    }
    
    public static List<ObligacionBaseLegalDTO> toListBaseLegalObligacionDto(List<Object[]> lista) {
        List<ObligacionBaseLegalDTO> retorno = new ArrayList<ObligacionBaseLegalDTO>();
        if (lista != null) {
        	ObligacionBaseLegalDTO registroDTO;
            for (Object[] maestro : lista) {
            	Log.info("lista: "+lista);
            	registroDTO = new ObligacionBaseLegalDTO();
            	registroDTO.setIdBaseLegal((Long) maestro[0]);
            	registroDTO.setCodigoBaseLegal(maestro[1].toString());
                registroDTO.setDescripcion(maestro[2].toString());
                registroDTO.setIdOblBase((Long) maestro[3]);
                
                retorno.add(registroDTO);
            }
        }
        return retorno;
        /*llenar listado aca*/
    }
    
    public static List<Object> toListObligacionBaseLegalDtoObj(List<PghObligacionBaseLegal> lista) {
        List<Object> retorno = new ArrayList<Object>();
        if (lista != null) {
            for (PghObligacionBaseLegal maestro : lista) {
            	ObligacionBaseLegalDTO obligacionBaseLegalDTO = new ObligacionBaseLegalDTO();
                
                obligacionBaseLegalDTO.setIdOblBase(maestro.getIdOblBase());
                obligacionBaseLegalDTO.setIdObligacion(maestro.getIdObligacion().getIdObligacion());
                obligacionBaseLegalDTO.setIdBaseLegal(maestro.getIdBaseLegal().getIdBaseLegal());
                obligacionBaseLegalDTO.setEstado(maestro.getEstado());
                
                retorno.add(obligacionBaseLegalDTO);
            }
        }
        return retorno;
        /*llenar listado aca*/
    }

	public static List<ObligacionBaseLegalDTO> toListObligacionBaseLegalDtoObjOblg(List<Object[]> listado) {
		List<ObligacionBaseLegalDTO> retorno = new ArrayList<ObligacionBaseLegalDTO>();
        if (listado != null) {
        	ObligacionBaseLegalDTO registroDTO;
            for (Object[] maestro : listado) {
            	Log.info("lista: "+listado);
            	registroDTO = new ObligacionBaseLegalDTO();
            	registroDTO.setIdBaseLegal((Long) maestro[0]);
            	registroDTO.setIdObligacion((Long) maestro[1]);
                registroDTO.setEstado(maestro[2].toString());
                
                retorno.add(registroDTO);
            }
        }
        return retorno;
	}
    
}