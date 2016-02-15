/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghObligacionTipificacion;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.dto.ObligacionTipificacionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public class ObligacionTipificacionBuilder {
    public static PghObligacionTipificacion getObligacionTipificacion(ObligacionTipificacionDTO obligacionTipificacionDTO){
        PghObligacionTipificacion registro = null;
        PghObligacion pghObligacion = null;
        PghTipificacion pghTipificacion = null;
        
        if(obligacionTipificacionDTO != null){
            registro = new PghObligacionTipificacion();
//            if(obligacionTipificacionDTO.getIdObliTipi() != null &&
//                    obligacionTipificacionDTO.getIdObligacion() != null &&
//                    obligacionTipificacionDTO.getIdTipificacion() != null){
//                PghObligacionTipificacionPK pk = new PghObligacionTipificacionPK(obligacionTipificacionDTO.getIdObligacion(), obligacionTipificacionDTO.getIdTipificacion(), obligacionTipificacionDTO.getIdObliTipi());
//                registro.setPghObligacionTipificacionPK(pk);
//            }
            registro.setIdObliTipi(obligacionTipificacionDTO.getIdObliTipi());
            registro.setIdObligacion(new PghObligacion(obligacionTipificacionDTO.getIdObligacion()));
            registro.setIdTipificacion(new PghTipificacion(obligacionTipificacionDTO.getIdTipificacion()));
            registro.setEstado(obligacionTipificacionDTO.getEstado());
            if(obligacionTipificacionDTO.getCodTrazabilidad()!=null){
                registro.setCodTrazabilidad(obligacionTipificacionDTO.getCodTrazabilidad());
            }
        }
        return registro;
    }
    
    public static List<ObligacionTipificacionDTO> toListObligacionTipificacionDto(List<PghObligacionTipificacion> lista){
        ObligacionTipificacionDTO obligacionTipificacionDTO;
        List<ObligacionTipificacionDTO> retorno = new ArrayList<ObligacionTipificacionDTO>();
        if(lista != null){
            for(PghObligacionTipificacion maestro : lista){
                obligacionTipificacionDTO = toObligacionTipificacionDto(maestro);
                retorno.add(obligacionTipificacionDTO);
            }
        }
        return retorno;
    }
    
    public static ObligacionTipificacionDTO toObligacionTipificacionDto(PghObligacionTipificacion obligacionTipificacion){
        ObligacionTipificacionDTO obligacionTipificacionDTO = new ObligacionTipificacionDTO();
        
        obligacionTipificacionDTO.setIdObligacion(obligacionTipificacion.getIdObligacion().getIdObligacion());
        obligacionTipificacionDTO.setIdTipificacion(obligacionTipificacion.getIdTipificacion().getIdTipificacion());
        obligacionTipificacionDTO.setEstado(obligacionTipificacion.getEstado());
        obligacionTipificacionDTO.setIdObliTipi(obligacionTipificacion.getIdObliTipi());
        
        return obligacionTipificacionDTO;
    }
    
    public static List<ObligacionTipificacionDTO> toListObligacionTipificacionRefDto(List<Object[]> lista) {
        List<ObligacionTipificacionDTO> retorno = new ArrayList<ObligacionTipificacionDTO>();
        if(lista != null){
            ObligacionTipificacionDTO registroDTO;
            for(Object[] maestro : lista){
                registroDTO = new ObligacionTipificacionDTO();
                registroDTO.setIdObligacion((Long) maestro[0]);
                registroDTO.setCodigoTipificacion(maestro[1].toString());
                registroDTO.setDescripcion(maestro[2].toString());
                
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    
    public static List<Object> toListObligacionTipificacionDtoObj(List<PghObligacionTipificacion> lista){
        List<Object> retorno = new ArrayList<Object>();
        if(lista != null){
            for(PghObligacionTipificacion maestro : lista){
                ObligacionTipificacionDTO obligacionTipificacionDTO = new ObligacionTipificacionDTO();
                
                obligacionTipificacionDTO.setIdObliTipi(maestro.getIdObliTipi());
                obligacionTipificacionDTO.setIdObligacion(maestro.getIdObligacion().getIdObligacion());
                obligacionTipificacionDTO.setIdTipificacion(maestro.getIdTipificacion().getIdTipificacion());
                obligacionTipificacionDTO.setEstado(maestro.getEstado());
            }
        }
        return retorno;
    }
}