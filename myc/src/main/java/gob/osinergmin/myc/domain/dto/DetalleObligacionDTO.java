/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author lbarboza
 */
public class DetalleObligacionDTO {
    private Long idDetalleObligacion;
    private String descripcion;
    private String estado;
    private String tipoDescObl;
    private Long idObligacion;

    private Long idDocumentoAdjunto;
    
    private DocumentoAdjuntoDTO documentoAdjunto;
    String codTrazabilidad;

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }
    
    public Long getIdDetalleObligacion() {
        return idDetalleObligacion;
    }

    public void setIdDetalleObligacion(Long idDetalleObligacion) {
        this.idDetalleObligacion = idDetalleObligacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoDescObl() {
        return tipoDescObl;
    }

    public void setTipoDescObl(String tipoDescObl) {
        this.tipoDescObl = tipoDescObl;
    }

    public Long getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Long idObligacion) {
        this.idObligacion = idObligacion;
    }

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }

    public DocumentoAdjuntoDTO getDocumentoAdjunto() {
        return documentoAdjunto;
    }

    public void setDocumentoAdjunto(DocumentoAdjuntoDTO documentoAdjunto) {
        this.documentoAdjunto = documentoAdjunto;
    }
    
}