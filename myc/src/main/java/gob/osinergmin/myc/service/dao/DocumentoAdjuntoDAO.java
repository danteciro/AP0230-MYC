package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.DocumentoAdjuntoFilter;

import java.io.File;
import java.util.HashMap;

public interface DocumentoAdjuntoDAO {
    public DocumentoAdjuntoDTO uploadFiles(DocumentoAdjuntoDTO documentoDTO, File file);
    public DocumentoAdjuntoDTO create(DocumentoAdjuntoDTO documentoDTO,UsuarioDTO userDTO);
    public DocumentoAdjuntoDTO editar(DocumentoAdjuntoDTO documentoDTO,UsuarioDTO userDTO);
    public DocumentoAdjuntoDTO get(Long idDocumentoAdjunto);
    public DocumentoAdjuntoDTO changeState(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO userDTO);
    public DocumentoAdjuntoDTO findDocumentoAdjunto(Long idDocumentoAdjunto);    
    public HashMap listarDocumentoAdjunto(DocumentoAdjuntoFilter filtro);
    
}
