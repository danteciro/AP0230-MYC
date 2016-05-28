/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.domain.PghDetalleCriterio;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;

/**
 *
 * @author lbarboza
 */
public class DetalleCriterioBuilder {
    public static PghDetalleCriterio getDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO){
        PghDetalleCriterio registro = null;
        
        if(detalleCriterioDTO != null){
            PghCriterio criterio = new PghCriterio();
            criterio.setIdCriterio(detalleCriterioDTO.getIdCriterio());
                
            registro = new PghDetalleCriterio();
            registro.setSancionEspecifica(detalleCriterioDTO.getSancionEspecifica());
            registro.setIdCriterio(criterio);
            registro.setEstado(detalleCriterioDTO.getEstado());
            if(detalleCriterioDTO.getCodTrazabilidad()!=null){
                registro.setCodTrazabilidad(detalleCriterioDTO.getCodTrazabilidad());
            }
        }
        return registro;
    }
    
    public static List<DetalleCriterioDTO> toListDetalleCriterioDto(List<PghDetalleCriterio> lista){
        DetalleCriterioDTO detalleCriterioDTO;
        List<DetalleCriterioDTO> retorno = new ArrayList<DetalleCriterioDTO>();
        if(lista != null){
            for(PghDetalleCriterio maestro : lista){
                detalleCriterioDTO = toDetalleCriterioDto(maestro);
                retorno.add(detalleCriterioDTO);
            }
        }
        return retorno;
    }
    
    public static DetalleCriterioDTO toDetalleCriterioDto(PghDetalleCriterio detalleCriterio){
        DetalleCriterioDTO detalleCriterioDTO = new DetalleCriterioDTO();
        detalleCriterioDTO.setIdDetalleCriterio(detalleCriterio.getIdDetalleCriterio());
        detalleCriterioDTO.setSancionEspecifica(detalleCriterio.getSancionEspecifica());
        detalleCriterioDTO.setIdCriterio(detalleCriterio.getIdCriterio().getIdCriterio());
        detalleCriterioDTO.setEstado(detalleCriterio.getEstado());
        
        detalleCriterioDTO.setSancionEspecifica(detalleCriterio.getSancionEspecifica());
        detalleCriterioDTO.setSancionMonetaria(detalleCriterio.getSancionMonetaria());
        if(detalleCriterio.getTipoSancionEspecifica()!=null){
            detalleCriterioDTO.setTipoSancionEspecifica(detalleCriterio.getTipoSancionEspecifica().getIdMaestroColumna());
            detalleCriterioDTO.setDescTipoSancionEspecifica(detalleCriterio.getTipoSancionEspecifica().getDescripcion());
        }
        
        return detalleCriterioDTO;
    }

	public static List<DetalleCriterioDTO> toListDetalleCriterioImplDto(List<PghDetalleCriterio> lista) {
		DetalleCriterioDTO detalleCriterioDTO;
        List<DetalleCriterioDTO> retorno = new ArrayList<DetalleCriterioDTO>();
        if (lista != null) {
        	Log.info("Ingreso...!!!-->");
            for (PghDetalleCriterio maestro : lista) {
            	detalleCriterioDTO = toDetalleCriterioImplDto(maestro);
                retorno.add(detalleCriterioDTO);
            }
        }
        return retorno;
        /*llenar_listado*/
	}

	private static DetalleCriterioDTO toDetalleCriterioImplDto(PghDetalleCriterio detalleCriterio) {
		
		DetalleCriterioDTO detalleCriterioDTO = new DetalleCriterioDTO();
        detalleCriterioDTO.setIdDetalleCriterio(detalleCriterio.getIdDetalleCriterio());
        detalleCriterioDTO.setSancionEspecifica(detalleCriterio.getSancionEspecifica());
        detalleCriterioDTO.setIdCriterio(detalleCriterio.getIdCriterio().getIdCriterio());
        detalleCriterioDTO.setEstado(detalleCriterio.getEstado());
        
        return detalleCriterioDTO;
	}
}