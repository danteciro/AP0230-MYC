package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.domain.ui.DocumentoAdjuntoFilter;

import java.io.File;
import java.io.InputStream;
import java.util.List;


public interface DocumentoAdjuntoNeg {
    GuardarDocumentoAdjuntoOutRO enviarDatosAlfresco(DocumentoAdjuntoDTO archivo,File file);
    GuardarDocumentoAdjuntoOutRO registrarDocumentoAdjunto(GuardarDocumentoAdjuntoInRO in);
    GuardarDocumentoAdjuntoOutRO editarDocumentoAdjunto(GuardarDocumentoAdjuntoInRO in);
    GuardarDocumentoAdjuntoOutRO eliminarDocumentoAdjunto(GuardarDocumentoAdjuntoInRO in);
    InputStream descargarDatosAlfresco(DocumentoAdjuntoDTO archivo);
    DocumentoAdjuntoDTO consultarDatosAlfresco(Long idDocumentoAdjunto);
    List<DocumentoAdjuntoDTO> listarDocumentoAdjunto(DocumentoAdjuntoFilter filtro, int[] cuenta);
        
    public DocumentoAdjuntoDTO enviarUnArchivoAlfresco(DocumentoAdjuntoDTO registro);
}