package gob.osinergmin.myc.domain.dto;



import java.util.Date;

public class DocumentoAdjuntoDTO {

    private Long idDocumentoAdjunto;
  //  private RequisitoDTO requisito;
    private String estado;
    private String nombreArchivo;
    private String titulo;
    private String comentario;
    private Date fechaDocumento;
    private Date fechaCarga;
    private Date fechaCaptura;
    private Long tipoProceso;
    private String nroDocumento;
    private String fotoPrincipal;
    private String descTipoProceso;
    private byte[] rutaAlfrescoTmp;
    private String rutaAlfresco;
    private String archivo;
    private Long idConcurso;
    private String aplicacionSpace;

    public String getAplicacionSpace() {
        return aplicacionSpace;
    }

    public void setAplicacionSpace(String aplicacionSpace) {
        this.aplicacionSpace = aplicacionSpace;
    }

    //private Long tipoDocumentoCarga;
    private MaestroColumnaDTO tipoDocumentoCarga;
    
    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }
    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
   
   
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Date getFechaDocumento() {
        return fechaDocumento;
    }
    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }
    public Date getFechaCarga() {
        return fechaCarga;
    }
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaCaptura() {
        return fechaCaptura;
    }
    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }
   

    public String getNroDocumento() {
        return nroDocumento;
    }
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
    public String getFotoPrincipal() {
        return fotoPrincipal;
    }
    public void setFotoPrincipal(String fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }
    public Long getTipoProceso() {
        return tipoProceso;
    }
    public void setTipoProceso(Long tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    //    public Long getTipoDocumentoCarga() {
    //        return tipoDocumentoCarga;
    //    }
    //    public void setTipoDocumentoCarga(Long tipoDocumentoCarga) {
    //    }
    //    }
    public MaestroColumnaDTO getTipoDocumentoCarga() {
        return tipoDocumentoCarga;
    }

    public void setTipoDocumentoCarga(MaestroColumnaDTO tipoDocumentoCarga) {
        this.tipoDocumentoCarga = tipoDocumentoCarga;
    }
    
    public String getDescTipoProceso() {
        return descTipoProceso;
    }
    public void setDescTipoProceso(String descTipoProceso) {
        this.descTipoProceso = descTipoProceso;
    }
    public String getRutaAlfresco() {
        return rutaAlfresco;
    }
    public void setRutaAlfresco(String rutaAlfresco) {
        this.rutaAlfresco = rutaAlfresco;
    }
    public String getArchivo() {
        return archivo;
    }
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
	public byte[] getRutaAlfrescoTmp() {
		return rutaAlfrescoTmp;
	}
	public void setRutaAlfrescoTmp(byte[] rutaAlfrescoTmp) {
		this.rutaAlfrescoTmp = rutaAlfrescoTmp;
	}

    public Long getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(Long idConcurso) {
        this.idConcurso = idConcurso;
    }
}
