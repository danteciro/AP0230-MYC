/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.PghInfraccion;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.dto.InfraccionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rcoloradoa
 */
public class InfraccionBuilder {
    public static PghInfraccion getDetalleInfraccion(InfraccionDTO infraccionDTO){
        PghInfraccion registro = null;
        PghObligacion obligacion = null;
        
        if(infraccionDTO != null){
            registro = new PghInfraccion();
            if(infraccionDTO.getIdInfraccion() != null)
                registro.setIdInfraccion(infraccionDTO.getIdInfraccion());
                registro.setDescripcionInfraccion(infraccionDTO.getDescripcionInfraccion());
                registro.setEstado(infraccionDTO.getEstado());
                registro.setIdAccionMaestro(infraccionDTO.getIdAccionMaestro());
                registro.setIdMedidaSeguridadMaestro(infraccionDTO.getIdMedidaSeguridadMaestro());                
                if (infraccionDTO.getDocumentoAdjuntoDTO()!=null){
                    MdiDocumentoAdjunto docAdjunto=new MdiDocumentoAdjunto();
                    docAdjunto.setIdDocumentoAdjunto(infraccionDTO.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto());
                    docAdjunto.setEstado(infraccionDTO.getEstado());                  
                    docAdjunto.setUsuarioCreacion(infraccionDTO.getUsuarioCreacion());
                    docAdjunto.setTerminalCreacion(infraccionDTO.getTerminalCreacion());                    
                    registro.setIdDocumentoAdjunto(docAdjunto);                    
                    }                              
              if(infraccionDTO.getIdObligacion2() != null){
                obligacion = new PghObligacion();
                obligacion.setIdObligacion(infraccionDTO.getIdObligacion().getIdObligacion());
                registro.setIdObligacion(obligacion);             
            }
            registro.setCodTrazabilidad(infraccionDTO.getCodTrazabilidad());
        }
        return registro;
    }
    
    public static List<InfraccionDTO> toListInfraccionDto(List<PghInfraccion> lista, Long idObligacion){
        InfraccionDTO infraccionDTO = null;
        PghObligacion pghObligacion = new PghObligacion();
        pghObligacion.setIdObligacion(idObligacion);
        List<InfraccionDTO> retorno = new ArrayList<InfraccionDTO>();
        if(lista != null){
            for(PghInfraccion maestro : lista){
                infraccionDTO = toInfraccionDto(maestro);
                infraccionDTO.setIdObligacion(pghObligacion);
                retorno.add(infraccionDTO);
            }
        }
        return retorno;
    }
    
    public static InfraccionDTO toInfraccionDto(PghInfraccion infraccion){
        InfraccionDTO infraccionDTO = new InfraccionDTO();        
        infraccionDTO.setIdInfraccion(infraccion.getIdInfraccion());
        infraccionDTO.setDescripcionInfraccion(infraccion.getDescripcionInfraccion());
        infraccionDTO.setEstado(infraccion.getEstado());        
        infraccionDTO.setCodTrazabilidad(infraccion.getCodTrazabilidad());
        infraccionDTO.setIdAccionMaestro(infraccion.getIdAccionMaestro());
        infraccionDTO.setIdMedidaSeguridadMaestro(infraccion.getIdMedidaSeguridadMaestro());
        return infraccionDTO;
    }
       
    
}