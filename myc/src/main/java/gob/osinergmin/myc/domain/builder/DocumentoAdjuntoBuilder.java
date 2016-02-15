package gob.osinergmin.myc.domain.builder;



import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class DocumentoAdjuntoBuilder {
    
    public static MdiDocumentoAdjunto getDocumentoAdjunto(DocumentoAdjuntoDTO registroDTO) throws UnsupportedEncodingException {
        MdiDocumentoAdjunto registro = null;
        if(registroDTO!=null){
            registro = new MdiDocumentoAdjunto();
            
            registro.setIdDocumentoAdjunto(registroDTO.getIdDocumentoAdjunto());
            registro.setNombreArchivo(registroDTO.getNombreArchivo());
            registro.setRutaAlfresco(registroDTO.getRutaAlfresco());
            registro.setTitulo(registroDTO.getTitulo());
            registro.setComentario(registroDTO.getComentario());
            registro.setFechaDocumento(registroDTO.getFechaDocumento());
            registro.setFechaCarga(registroDTO.getFechaCarga());
            registro.setFechaCaptura(registroDTO.getFechaCaptura());
            registro.setEstado(registroDTO.getEstado());
            registro.setNroDocumento(registroDTO.getNroDocumento());
            /*
            if(registroDTO.getTipoDocumentoCarga()!=null){
                MdiMaestroColumna tipoDocumentoCarga = new MdiMaestroColumna();
                tipoDocumentoCarga.setIdMaestroColumna(registroDTO.getTipoDocumentoCarga().getIdMaestroColumna());
                tipoDocumentoCarga.setDescripcion(registroDTO.getTipoDocumentoCarga().getDescripcion());
                registro.setTipoDocumentoCarga(tipoDocumentoCarga);                
            }*/
            
            registro.setIdConcurso(registroDTO.getIdConcurso());
        }
                
        return registro;
    }
    
    public static List<DocumentoAdjuntoDTO> toListDocumentoAdjuntoDto(List<MdiDocumentoAdjunto> lista) {
       DocumentoAdjuntoDTO registroDTO;
        List<DocumentoAdjuntoDTO> listaDTO = new ArrayList<DocumentoAdjuntoDTO>();
        if (lista != null) {
            for (MdiDocumentoAdjunto maestro : lista) {
                registroDTO = toDocumentoAdjuntoDto(maestro);
                listaDTO.add(registroDTO);
            }
        }
        return listaDTO;
    } 
    

    
    public static DocumentoAdjuntoDTO toDocumentoAdjuntoDto(MdiDocumentoAdjunto registro) {
        DocumentoAdjuntoDTO registroDTO = new DocumentoAdjuntoDTO();
        
        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
        registroDTO.setNombreArchivo(registro.getNombreArchivo());
        registroDTO.setRutaAlfresco(registro.getRutaAlfresco());
        registroDTO.setTitulo(registro.getTitulo());
        registroDTO.setComentario(registro.getComentario());
        registroDTO.setFechaDocumento(registro.getFechaDocumento());
        registroDTO.setFechaCarga(registro.getFechaCarga());
        registroDTO.setFechaCaptura(registro.getFechaCaptura());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setIdConcurso(registro.getIdConcurso());
        /*
        if(registro.getTipoDocumentoCarga()!=null){
            MaestroColumnaDTO maesColuDTO=new MaestroColumnaDTO();
            maesColuDTO.setIdMaestroColumna(registro.getTipoDocumentoCarga().getIdMaestroColumna());
            maesColuDTO.setDescripcion(registro.getTipoDocumentoCarga().getDescripcion());
            registroDTO.setTipoDocumentoCarga(maesColuDTO);
        }*/
                
        return  registroDTO;
    }
    
   
}
