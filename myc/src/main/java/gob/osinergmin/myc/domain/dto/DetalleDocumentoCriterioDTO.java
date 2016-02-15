/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

import java.io.Serializable;

/**
 *
 * @author lchancayauri
 */
public class DetalleDocumentoCriterioDTO implements Serializable {

    private Long idDetalleDocumentoCriterio;
    private String titulo;
    private String estado;
    private Long idCriterio;
    private Long idDocumentoAdjunto;
    private DocumentoAdjuntoDTO documento;
    private String codTrazabilidad;

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }
        
    public Long getIdDetalleDocumentoCriterio() {
        return idDetalleDocumentoCriterio;
    }

    public void setIdDetalleDocumentoCriterio(Long idDetalleDocumentoCriterio) {
        this.idDetalleDocumentoCriterio = idDetalleDocumentoCriterio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Long idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }

    public DocumentoAdjuntoDTO getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoAdjuntoDTO documento) {
        this.documento = documento;
    }
    
}
