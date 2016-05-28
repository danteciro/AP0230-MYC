/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.domain.PghDetalleDocumentoCriterio;
import gob.osinergmin.myc.domain.dto.DetalleDocumentoCriterioDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lchancayauri
 */
public class DetalleDocumentoCriterioBuilder {
    
    public static PghDetalleDocumentoCriterio getDetalleDocumentoCriterio(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO){
        PghDetalleDocumentoCriterio registro = null;
        if(detalleDocumentoCriterioDTO != null){
            PghCriterio criterio = new PghCriterio();
            criterio.setIdCriterio(detalleDocumentoCriterioDTO.getIdCriterio());
            
            registro = new PghDetalleDocumentoCriterio();
            if(detalleDocumentoCriterioDTO.getIdDetalleDocumentoCriterio() != null && 
                    detalleDocumentoCriterioDTO.getIdDetalleDocumentoCriterio().intValue() > 0){
                registro.setIdDetalleDocumentoCriterio(detalleDocumentoCriterioDTO.getIdDetalleDocumentoCriterio());
            }
            registro.setIdCriterio(criterio);
            registro.setIdDocumentoAdjunto(detalleDocumentoCriterioDTO.getIdDocumentoAdjunto());
            registro.setTitulo(detalleDocumentoCriterioDTO.getTitulo());
            registro.setEstado(detalleDocumentoCriterioDTO.getEstado());
            if(detalleDocumentoCriterioDTO.getCodTrazabilidad()!=null){
                registro.setCodTrazabilidad(detalleDocumentoCriterioDTO.getCodTrazabilidad());
            }
        }
        return registro;
    }
    
    public static List<DetalleDocumentoCriterioDTO> toListDetalleDocumentoCriterioDTO(List<PghDetalleDocumentoCriterio> lista){
        DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO;
        List<DetalleDocumentoCriterioDTO> retorno = new ArrayList<DetalleDocumentoCriterioDTO>();
        if(lista != null){
            for(PghDetalleDocumentoCriterio maestro : lista){
                detalleDocumentoCriterioDTO = toDetalleDocumentoCriterioDto(maestro);
                retorno.add(detalleDocumentoCriterioDTO);
            }
        }
        return retorno;
    }
    
    public static DetalleDocumentoCriterioDTO toDetalleDocumentoCriterioDto(PghDetalleDocumentoCriterio detalleDocumentoCriterio){
        DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO = new DetalleDocumentoCriterioDTO();
        detalleDocumentoCriterioDTO.setIdCriterio(detalleDocumentoCriterio.getIdCriterio().getIdCriterio());
        detalleDocumentoCriterioDTO.setEstado(detalleDocumentoCriterio.getEstado());
        detalleDocumentoCriterioDTO.setIdDetalleDocumentoCriterio(detalleDocumentoCriterio.getIdDetalleDocumentoCriterio());
        detalleDocumentoCriterioDTO.setIdDocumentoAdjunto(detalleDocumentoCriterio.getIdDocumentoAdjunto());
        detalleDocumentoCriterioDTO.setTitulo(detalleDocumentoCriterio.getTitulo());
        return detalleDocumentoCriterioDTO;
    }
    
}
