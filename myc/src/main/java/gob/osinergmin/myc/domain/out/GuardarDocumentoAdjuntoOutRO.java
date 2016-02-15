package gob.osinergmin.myc.domain.out;

import java.io.File;

import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;

public class GuardarDocumentoAdjuntoOutRO extends BaseOutBean {

	private DocumentoAdjuntoDTO documento;
	private File archivo;
	
	public DocumentoAdjuntoDTO getDocumento() {
		return documento;
	}
	public void setDocumento(DocumentoAdjuntoDTO documento) {
		this.documento = documento;
	}
	public File getArchivo() {
		return archivo;
	}
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	
	
	
}
