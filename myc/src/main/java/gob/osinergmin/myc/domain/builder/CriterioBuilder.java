/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;

/**
 *
 * @author lbarboza
 */
public class CriterioBuilder {

    public static PghCriterio getCriterio(CriterioDTO criterioDTO) {
        PghCriterio criterio = null;
        if (criterioDTO != null) {
            PghObligacion obligacion = new PghObligacion();
            obligacion.setIdObligacion(criterioDTO.getIdObligacion());
            PghTipificacion tipificacion = new PghTipificacion();
            tipificacion.setIdTipificacion(criterioDTO.getIdTipificacion());
            
            criterio = new PghCriterio();
            criterio.setIdCriterio(criterioDTO.getIdCriterio());
            criterio.setDescripcion(criterioDTO.getDescripcion());
//	05-11-2015
            if(criterioDTO.getTipoCriterio()!=null && criterioDTO.getTipoCriterio().getIdMaestroColumna()!=null){
            	MdiMaestroColumna tipoCriterio = new MdiMaestroColumna();
                tipoCriterio.setIdMaestroColumna(criterioDTO.getTipoCriterio().getIdMaestroColumna());
                criterio.setTipoCriterio(tipoCriterio);
            }
            
            if(criterioDTO.getBasesLegales()!=null){
                criterio.setBasesLegales(criterioDTO.getBasesLegales());
            }
//
            if(criterioDTO.getSancionMonetaria()!=null){
                criterio.setSancionMonetaria(criterioDTO.getSancionMonetaria());
            }
            criterio.setEstado(criterioDTO.getEstado());
            if(criterioDTO.getCodTrazabilidad()!=null){
                criterio.setCodTrazabilidad(criterioDTO.getCodTrazabilidad());
            }
        }
        return criterio;
    }

    public static List<CriterioDTO> toListCriterioDto(List<PghCriterio> lista) {
        CriterioDTO criterioDTO;
        List<CriterioDTO> retorno = new ArrayList<CriterioDTO>();
        if (lista != null) {
            for (PghCriterio maestro : lista) {
                criterioDTO = toCriterioDto(maestro);
                retorno.add(criterioDTO);
            }
        }
        return retorno;
    }

    public static CriterioDTO toCriterioDto(PghCriterio criterio) {
        CriterioDTO criterioDTO = new CriterioDTO();
        criterioDTO.setIdCriterio(criterio.getIdCriterio());
        criterioDTO.setDescripcion(criterio.getDescripcion());
//        criterioDTO.setIdTipificacion(criterio.getIdTipificacion().getIdTipificacion());
//        criterioDTO.setIdObligacion(criterio.getIdObligacion().getIdObligacion());
        criterioDTO.setEstado(criterio.getEstado());
        return criterioDTO;
    }
    
    public static CriterioDTO toCriterioMaestroDto(PghCriterio criterio) {
        CriterioDTO criterioDTO = new CriterioDTO();
        criterioDTO.setIdCriterio(criterio.getIdCriterio());
        criterioDTO.setDescripcion(criterio.getDescripcion());
        if(criterio.getTipoCriterio()!=null){
        	MaestroColumnaDTO maestro = new MaestroColumnaDTO();
            maestro.setIdMaestroColumna(criterio.getTipoCriterio().getIdMaestroColumna());
            criterioDTO.setTipoCriterio(maestro);
        }
        criterioDTO.setSancionMonetaria(criterio.getSancionMonetaria());
        criterioDTO.setEstado(criterio.getEstado());
        return criterioDTO;
    }
    
    public static List<CriterioDTO> toListCriterio(List<Object[]> lista) {
        CriterioDTO criterioDTO;
        List<CriterioDTO> retorno = new ArrayList<CriterioDTO>();
        if (lista != null) {
            for (Object[] object : lista) {
                PghCriterio criterio = (PghCriterio)object[0];
                PghTipificacion tipificacion = (PghTipificacion)object[1];
                criterioDTO = toCriterioDto(criterio);
                criterioDTO.setCodigoTipificacion(tipificacion.getCodTipificacion());
                retorno.add(criterioDTO);
            }
        }
        return retorno;
    }

    //Implementado_Builder_Criterio
	public static List<CriterioDTO> toListCriterioImplDto(List<PghCriterio> lista) {
		CriterioDTO criterioDTO;
        List<CriterioDTO> retorno = new ArrayList<CriterioDTO>();
        if (lista != null) {
        	Log.info("Ingreso...!!!-->");
            for (PghCriterio maestro : lista) {
            	criterioDTO = toCriterioImplDto(maestro);
                retorno.add(criterioDTO);
            }
        }
        return retorno;
        /*llenar_listado*/
	}

	private static CriterioDTO toCriterioImplDto(PghCriterio criterio) {
		CriterioDTO criterioDTO = new CriterioDTO();
        
		if(criterio.getIdCriterio()!=null){
		criterioDTO.setIdCriterio(criterio.getIdCriterio());	
		}
//		criterioDTO.setIdTipificacion(criterio.getIdTipificacion().getIdTipificacion());	
//		criterioDTO.setDescripcionTipificacion(criterio.getIdTipificacion().getDescripcion());
		criterioDTO.setIdTipificacion(criterio.getIdCriterio());	
				
		criterioDTO.setDescripcion(criterio.getDescripcion());		
		if(criterio.getTipoCriterio()!=null) {		            
            MaestroColumnaDTO tipoCriterio = MaestroColumnaBuilder.getMaestroColumnaDTO(criterio.getTipoCriterio(),false);              
            criterioDTO.setTipoCriterio(tipoCriterio);
        }  		
        
        return criterioDTO;
    }

	public static List<CriterioDTO> toListCriterioRefDto(List<Object[]> lista) {
		List<CriterioDTO> retorno = new ArrayList<CriterioDTO>();
        if (lista != null) {
        	CriterioDTO registroDTO;
            for (Object[] maestro : lista) {
            	Log.info("lista: "+lista);
            	registroDTO = new CriterioDTO();
            	if(maestro[0]!=null){
            	registroDTO.setIdTipificacion(new Long( maestro[0].toString())); 
            	} 
            	if(maestro[1]!=null){
            	registroDTO.setCodigoTipificacion(maestro[1].toString());
            	} 
            	if(maestro[2]!=null){
            	registroDTO.setIdCriterio(new Long( maestro[2].toString()));
            	} 
            	if(maestro[3]!=null){
            	registroDTO.setDescripcion(maestro[3].toString());
            	} 
            	if(maestro[4]!=null){
            		MaestroColumnaDTO maestroTipo=new MaestroColumnaDTO();
                	maestroTipo.setDescripcion(maestro[4].toString());
                	registroDTO.setTipoCriterio(maestroTipo);
            	}       	
                
                retorno.add(registroDTO);
            }
        }
        return retorno;
        /*llenar_listado_aca*/
	}
	
}
	
