package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghConfObligacion;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghProcesoObligacionTipo;
import gob.osinergmin.myc.domain.PghProcesoObligacionTipoPK;
import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CnfObligacionBuilder {

	public static PghConfObligacion getConfObligacion(CnfObligacionDTO cnfOblgDTO){
		PghConfObligacion registro=new PghConfObligacion();
		if(cnfOblgDTO!=null){
			registro.setEstado(cnfOblgDTO.getEstado());
//			registro.setIdConfObligacion(new BigDecimal(cnfOblgDTO.getIdConfObligacion()));
			PghProcesoObligacionTipo pghProcesoObligacionTipo = new PghProcesoObligacionTipo(cnfOblgDTO.getIdObligacionTipo(), cnfOblgDTO.getIdProceso(),
					cnfOblgDTO.getIdActividad(),cnfOblgDTO.getIdProOblTip());
			registro.setPghProcesoObligacionTipo(pghProcesoObligacionTipo);
			
			PghObligacion pghObligacion=new PghObligacion(cnfOblgDTO.getIdObligacion());
			registro.setIdObligacion(pghObligacion);
                        
                        registro.setCodTrazabilidad(cnfOblgDTO.getCodTrazabilidad());
		}
		return registro;
	}
	
	public static List<CnfObligacionDTO> toListConfObligacion(List<PghConfObligacion> lista){
		CnfObligacionDTO proceso;
		List<CnfObligacionDTO> retorno=new ArrayList<CnfObligacionDTO>();
		if(lista != null){
			for(PghConfObligacion maestro:lista){
				proceso = toConfObligacionDto(maestro);
				retorno.add(proceso);
			}
		}
		return retorno;
		
	}
	/**
	 * Objeto JPA to DTO
	 * @param registro
	 * @return
	 */
	public static CnfObligacionDTO toConfObligacionDto(PghConfObligacion registro){
		CnfObligacionDTO registroDTO = new CnfObligacionDTO();
		if(registro!=null){
			registroDTO.setEstado(registro.getEstado());
			registroDTO.setIdActividad(registro.getPghProcesoObligacionTipo().getPghProcesoObligacionTipoPK().getIdActividad());
			registroDTO.setIdConfObligacion(registro.getIdConfObligacion());
			PghObligacion pghObligacion=new PghObligacion();
			registroDTO.setIdObligacion(pghObligacion.getIdObligacion());
			registroDTO.setIdObligacionTipo(registro.getPghProcesoObligacionTipo().getPghProcesoObligacionTipoPK().getIdObligacionTipo());
			registroDTO.setIdProceso(registro.getPghProcesoObligacionTipo().getPghProcesoObligacionTipoPK().getIdProceso());
			registroDTO.setIdProOblTip(registro.getPghProcesoObligacionTipo().getPghProcesoObligacionTipoPK().getIdProOblTip());
			
		}
		return registroDTO;
		
	}
	
	public static List<CnfObligacionDTO> toListConfObligacionDesc(List<Object[]> lista){
		List<CnfObligacionDTO> retorno=new ArrayList<CnfObligacionDTO>();
		if(lista != null){
			CnfObligacionDTO proceso;
			for(Object[] maestro:lista){
				proceso  = new CnfObligacionDTO();
				proceso.setIdConfObligacion(new Long(maestro[0].toString()));
				proceso.setIdActividad(new Long(maestro[1].toString()));
				proceso.setNombreActividad(maestro[2].toString());
				proceso.setNombreProceso(maestro[3].toString());
				proceso.setDescripcionObligacionTipo(maestro[4].toString());
				proceso.setIdProOblTip(new Long(maestro[5].toString()));
				retorno.add(proceso);
			}
		}
		return retorno;
	}
	
}
