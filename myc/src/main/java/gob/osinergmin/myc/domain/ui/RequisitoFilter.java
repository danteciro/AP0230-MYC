/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author jpiro
 */
public class RequisitoFilter extends BasePaginatorFilter{
    private String descripcion;
    private Long idRequisito;
    private DocumentoAdjuntoDTO documento;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Long idRequisito) {
        this.idRequisito = idRequisito;
    }

	public DocumentoAdjuntoDTO getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoAdjuntoDTO documento) {
		this.documento = documento;
	}
    
    

}
