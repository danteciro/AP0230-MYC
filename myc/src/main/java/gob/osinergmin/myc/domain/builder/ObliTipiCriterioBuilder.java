package gob.osinergmin.myc.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.domain.PghObliTipiCriterio;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.ObliTipiDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;

public class ObliTipiCriterioBuilder {

	public static PghObliTipiCriterio getObliTipiCriterio(ObliTipiDTO obliCriteTipi) {
		PghObliTipiCriterio objeto = new PghObliTipiCriterio();
		if(obliCriteTipi!=null){
			if(obliCriteTipi.getIdObliTipiCriterio()!=null){
				objeto.setIdObliTipiCriterio(obliCriteTipi.getIdObliTipiCriterio());
			}			
			if(obliCriteTipi.getCriterio()!=null){
				PghCriterio criterio = new PghCriterio();
				criterio.setIdCriterio(obliCriteTipi.getCriterio().getIdCriterio());
				objeto.setIdCriterio(criterio);
			}
			if(obliCriteTipi.getTipificacion()!=null){
				PghTipificacion tipificacion = new PghTipificacion();
				tipificacion.setIdTipificacion(obliCriteTipi.getTipificacion().getIdTipificacion());
				objeto.setIdTipificacion(tipificacion);
			}
			if(obliCriteTipi.getObligacion()!=null){
				PghObligacion obligacion = new PghObligacion();
				obligacion.setIdObligacion(obliCriteTipi.getObligacion().getIdObligacion());
				objeto.setIdObligacion(obligacion);
			}
			if(obliCriteTipi.getIdActividad() != null){
				objeto.setIdActividad(obliCriteTipi.getIdActividad());
			}
			objeto.setEstado(obliCriteTipi.getEstado());			
			
		}
		return objeto;
	}

	public static ObliTipiDTO toObliTipiCriterioDto(PghObliTipiCriterio obliTipiCriterio) {
		ObliTipiDTO objeto = new ObliTipiDTO();
		if(obliTipiCriterio!=null){
			if(obliTipiCriterio.getIdObliTipiCriterio()!=null){
				objeto.setIdObliTipiCriterio(obliTipiCriterio.getIdObliTipiCriterio());
			}			
			if(obliTipiCriterio.getIdCriterio()!=null){
				CriterioDTO criterio = new CriterioDTO();
				criterio.setIdCriterio(obliTipiCriterio.getIdCriterio().getIdCriterio());
				objeto.setCriterio(criterio);
			}
			if(obliTipiCriterio.getIdTipificacion()!=null){
				TipificacionDTO tipificacion = new TipificacionDTO();
				tipificacion.setIdTipificacion(obliTipiCriterio.getIdTipificacion().getIdTipificacion());
				objeto.setTipificacion(tipificacion);
			}
			if(obliTipiCriterio.getIdObligacion()!=null){
				ObligacionNormativaDTO obligacion = new ObligacionNormativaDTO();
				obligacion.setIdObligacion(obliTipiCriterio.getIdObligacion().getIdObligacion());
				objeto.setObligacion(obligacion);
			}
			objeto.setEstado(obliTipiCriterio.getEstado());	
		}
		return objeto;
	}

	public static ObliTipiDTO toListObliTipiCriterioDto(Object[] objects) {
		ObliTipiDTO retorno = new ObliTipiDTO();

	        if (objects != null) {
	                PghObliTipiCriterio obliTipiCriterio = (PghObliTipiCriterio)objects[0];
	                PghTipificacion tipificacion = (PghTipificacion)objects[1];
	                retorno = toObliTipiCriterioDto(obliTipiCriterio);
	                retorno.setCodigoTipificacion(tipificacion.getCodTipificacion());
	                retorno.setIdTipificacion(tipificacion.getIdTipificacion());
	        }
	        return retorno;
	    
	}

	public static List<ObliTipiDTO> toListObliTipiCriDto(List<Object[]> lstObliTipiCriterio) {
		ObliTipiDTO obliTipiDTO;
        List<ObliTipiDTO> retorno = null;
        if (lstObliTipiCriterio != null) {
        	retorno = new ArrayList<ObliTipiDTO>();
            for (Object [] obj : lstObliTipiCriterio) {
                obliTipiDTO = new ObliTipiDTO();
                obliTipiDTO.setIdObliTipiCriterio(new Long(obj[0].toString()));
// 05-11-2015
                if(obj[1]!=null){
                	obliTipiDTO.setIdCriterio(new Long(obj[1].toString()));
                }
                
                if(obj[2]!=null){
                	obliTipiDTO.setDescripcionCriterio(obj[2].toString());
                }
                
                if(obj[3]!=null){
                	obliTipiDTO.setCodigoTipificacion(obj[3].toString());
                }
                
                if(obj[4]!=null){
                	obliTipiDTO.setBasesLegales(obj[4].toString());
                }
                if(obj[5]!=null){
                	obliTipiDTO.setSancionMonetaria(obj[5].toString());
                }
                if(obj[6]!=null){
                	obliTipiDTO.setDescripcionActividad(obj[6].toString());
                }
                retorno.add(obliTipiDTO);
            }
        }
        return retorno;
	}



}
