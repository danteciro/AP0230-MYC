/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghDetalleObligacion;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public class DetalleObligacionBuilder {
    public static PghDetalleObligacion getDetalleObligacion(DetalleObligacionDTO detalleObligacionDTO){
        PghDetalleObligacion registro = null;
        PghObligacion obligacion = null;
        
        if(detalleObligacionDTO != null){
            registro = new PghDetalleObligacion();
            if(detalleObligacionDTO.getIdDetalleObligacion() != null)
                registro.setIdDetalleObligacion(detalleObligacionDTO.getIdDetalleObligacion());
                registro.setDescripcion(detalleObligacionDTO.getDescripcion());
                registro.setEstado(detalleObligacionDTO.getEstado());
                registro.setTipoDescObl(detalleObligacionDTO.getTipoDescObl());
            if(detalleObligacionDTO.getIdObligacion() != null){
                obligacion = new PghObligacion();
                obligacion.setIdObligacion(detalleObligacionDTO.getIdObligacion());
                registro.setIdObligacion(obligacion);
            }
            registro.setIdDocumentoAdjunto(detalleObligacionDTO.getIdDocumentoAdjunto());
            registro.setCodTrazabilidad(detalleObligacionDTO.getCodTrazabilidad());
        }
        return registro;
    }
    
    public static List<DetalleObligacionDTO> toListDetalleObligacionDto(List<PghDetalleObligacion> lista){
        DetalleObligacionDTO detalleObligacionDTO;
        List<DetalleObligacionDTO> retorno = new ArrayList<DetalleObligacionDTO>();
        if(lista != null){
            for(PghDetalleObligacion maestro : lista){
                detalleObligacionDTO = toDetalleObligacionDto(maestro);
                retorno.add(detalleObligacionDTO);
            }
        }
        return retorno;
    }
    
    public static DetalleObligacionDTO toDetalleObligacionDto(PghDetalleObligacion detalleObligacion){
        DetalleObligacionDTO detalleObligacionDTO = new DetalleObligacionDTO();
        
        detalleObligacionDTO.setIdDetalleObligacion(detalleObligacion.getIdDetalleObligacion());
        detalleObligacionDTO.setDescripcion(detalleObligacion.getDescripcion());
        detalleObligacionDTO.setTipoDescObl(detalleObligacion.getTipoDescObl());
        detalleObligacionDTO.setEstado(detalleObligacion.getEstado());
        detalleObligacionDTO.setIdObligacion(detalleObligacion.getIdObligacion().getIdObligacion());
        detalleObligacionDTO.setIdDocumentoAdjunto(detalleObligacion.getIdDocumentoAdjunto());
        detalleObligacionDTO.setCodTrazabilidad(detalleObligacion.getCodTrazabilidad());
        return detalleObligacionDTO;
    }
}