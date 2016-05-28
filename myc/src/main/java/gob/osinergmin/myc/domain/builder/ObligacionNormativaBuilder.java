package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghDetalleObligacion;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;

import java.util.ArrayList;
import java.util.List;

public class ObligacionNormativaBuilder {
	public static PghObligacion getObligacion(ObligacionNormativaDTO obligacionNormativaDTO) {
		PghObligacion registro = null;
        if(obligacionNormativaDTO!=null){
            registro=new PghObligacion();
            registro.setIdObligacion(obligacionNormativaDTO.getIdObligacion());
            registro.setCodigoObligacion(obligacionNormativaDTO.getCodigoObligacion());
            registro.setDescripcion(obligacionNormativaDTO.getDescripcionObligacion());
            if(obligacionNormativaDTO.getCriticidadObligacion()!=-1){
            	registro.setIdCriticidad(obligacionNormativaDTO.getCriticidadObligacion());
            }
            
            registro.setEstado(obligacionNormativaDTO.getEstado());
            registro.setIdDocumentoAdjunto(obligacionNormativaDTO.getIdDocumentoAdjunto());
            if(obligacionNormativaDTO.getCodTrazabilidad()!=null){
                registro.setCodTrazabilidad(obligacionNormativaDTO.getCodTrazabilidad());
            }
        }
        return registro;

    }
    
    public static List<ObligacionNormativaDTO> toListObligacionDto(List<PghObligacion> lista) {
    	ObligacionNormativaDTO obligacionNormativaDTO;
        List<ObligacionNormativaDTO> retorno = new ArrayList<ObligacionNormativaDTO>();
        if (lista != null) {
            for (PghObligacion maestro : lista) {
            	obligacionNormativaDTO = toObligacionDto(maestro);
                retorno.add(obligacionNormativaDTO);
            }
        }
        return retorno;
        /*llenar listado aca*/
    }
    public static ObligacionNormativaDTO toObligacionDto(PghObligacion obligacion) {
    	ObligacionNormativaDTO obligacionDTO = new ObligacionNormativaDTO();
        
    	obligacionDTO.setIdObligacion(obligacion.getIdObligacion());
    	obligacionDTO.setCodigoObligacion(obligacion.getCodigoObligacion());
    	obligacionDTO.setDescripcionObligacion(obligacion.getDescripcion());
    	obligacionDTO.setEstado(obligacion.getEstado());
    	obligacionDTO.setCriticidadObligacion(obligacion.getIdCriticidad());
        obligacionDTO.setIdDocumentoAdjunto(obligacion.getIdDocumentoAdjunto());
        obligacionDTO.setCodTrazabilidad(obligacion.getCodTrazabilidad());
        return obligacionDTO;
    }
    
    public static ObligacionNormativaDTO toObligacionCriticidadDto(PghObligacion obligacion) {
    	ObligacionNormativaDTO obligacionDTO = new ObligacionNormativaDTO();
        
    	obligacionDTO.setIdObligacion(obligacion.getIdObligacion());
    	obligacionDTO.setCodigoObligacion(obligacion.getCodigoObligacion());
    	obligacionDTO.setDescripcionObligacion(obligacion.getDescripcion());
    	obligacionDTO.setEstado(obligacion.getEstado());
    	
    	obligacionDTO.setCriticidadObligacion(obligacion.getIdCriticidad());
    	
        return obligacionDTO;
    }
    
    public static ObligacionNormativaDTO toDetalleObligacionDto(PghDetalleObligacion detalleObligacion) {
    	ObligacionNormativaDTO obligacionDTO = new ObligacionNormativaDTO();
        
    	obligacionDTO.setIdDetalleObligacion(detalleObligacion.getIdDetalleObligacion());
    	obligacionDTO.setDescripcionActaObligacion(detalleObligacion.getDescripcion());
    	
        return obligacionDTO;
    }
}
