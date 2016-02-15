/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.PghRequisito;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class RequisitoBuilder {
    
    public static PghRequisito getRequisito(RequisitoDTO registroDTO) {
        PghRequisito registro = null;
        if(registroDTO!=null){
            registro=new PghRequisito();
            registro.setIdRequisito(registroDTO.getIdRequisito());
            registro.setEstado(registroDTO.getEstado());
            registro.setDescripcion(registroDTO.getDescripcion());
            registro.setComentarioPredeterminado(registroDTO.getComentarioPredeterminado());
           
            if (registroDTO.getIdDocumentoAdjunto()!=null){
            MdiDocumentoAdjunto docAdjunto=new MdiDocumentoAdjunto();
            docAdjunto.setIdDocumentoAdjunto(registroDTO.getIdDocumentoAdjunto());
            docAdjunto.setNombreArchivo(registroDTO.getNombreArchivo());
            registro.setIdDocumentoAdjunto(docAdjunto);
            }
            //registro.set(registroDTO.getNombreArchivo());
        }
        return registro;

    }
    
    public static List<RequisitoDTO> toListRequisitoDto(List<PghRequisito> lista) {
        RequisitoDTO registroDTO;
        List<RequisitoDTO> retorno = new ArrayList<RequisitoDTO>();
        if (lista != null) {
            for (PghRequisito maestro : lista) {
                registroDTO = toRequisitoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    
    public static RequisitoDTO toRequisitoDto(PghRequisito registro) {
        RequisitoDTO registroDTO = new RequisitoDTO();
        
        registroDTO.setIdRequisito(registro.getIdRequisito());
        registroDTO.setDescripcion(registro.getDescripcion());
        registroDTO.setComentarioPredeterminado(registro.getComentarioPredeterminado());
        if(registro.getIdDocumentoAdjunto()!=null){
        registroDTO.setNombreArchivo(registro.getIdDocumentoAdjunto().getNombreArchivo());
        registroDTO.setRutaAlfresco(registro.getIdDocumentoAdjunto().getRutaAlfresco());
        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto().getIdDocumentoAdjunto());
        }
        
        return registroDTO;
    }
}
