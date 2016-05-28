package gob.osinergmin.myc.domain.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author gvillanueva
 */
public class ObligacionNormativaDTO {
     
    /** código de la Obligacion**/
    private String codigoBaseLegal;
    /** id de la Obligacion**/
    private Long idObligacion;
    /** código de la Obligacion**/
    private String codigoObligacion;
    /** fecha de entrada en vigencia de la Obligacion**/
    private Date fechaEntradaVigenciaObligacion;
    /** fecha de publicación de la Obligacion**/
    private Date fechaPublicacionObligacion;
    /** fecha de publicación de la Obligacion**/
    private String indiceCreacionObligacion;
    /* descripcion de la Obligacion */
    private String descripcionObligacion;
    /* tema de la Obligacion */
    private String temaObligacion;
    /* criticidad de la Obligacion */
    private Long criticidadObligacion;
    /* tipificacion de la Obligacion */
    private String tipificacionObligacion;
    /* descripcion de la Obligacion */
    private String descripcionActaObligacion;
    /* descripcion de la Obligacion */
    private String descripcionGuiaObligacion;
    private String temporal;
    
    private Long idDetalleObligacion;
    /* listado de actividades configuradas para la obligacion */
    private List<ActividadDTO> listadoActividades;
    /* listado de supervisiones configuradas para la obligacion */
    private List<SupervisionDTO> listadoSupervisiones;
    /* listado de tipificaciones configuradas para la obligacion */
    private List<TipificacionDTO> listadoTipificaciones;
    
    private List<TemaDTO> listaTemas;
    
    private String estado;

    private Long idDocumentoAdjunto;
    
    private DocumentoAdjuntoDTO documentoAdjunto;
    
    private String codTrazabilidad;
// 05-11-2015
    private Long idBaseLegal;
    
    private String nombreArchivo;
    private String rutaAlfresco;
//    
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

	public Long getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Long idObligacion) {
        this.idObligacion = idObligacion;
    }

    public String getCodigoObligacion() {
        return codigoObligacion;
    }

    public void setCodigoObligacion(String codigoObligacion) {
        this.codigoObligacion = codigoObligacion;
    }

    public Date getFechaEntradaVigenciaObligacion() {
        return fechaEntradaVigenciaObligacion;
    }

    public void setFechaEntradaVigenciaObligacion(Date fechaEntradaVigenciaObligacion) {
        this.fechaEntradaVigenciaObligacion = fechaEntradaVigenciaObligacion;
    }

    public Date getFechaPublicacionObligacion() {
        return fechaPublicacionObligacion;
    }

    public void setFechaPublicacionObligacion(Date fechaPublicacionObligacion) {
        this.fechaPublicacionObligacion = fechaPublicacionObligacion;
    }

    public String getIndiceCreacionObligacion() {
        return indiceCreacionObligacion;
    }

    public void setIndiceCreacionObligacion(String indiceCreacionObligacion) {
        this.indiceCreacionObligacion = indiceCreacionObligacion;
    }

    public String getDescripcionObligacion() {
        return descripcionObligacion;
    }

    public void setDescripcionObligacion(String descripcionObligacion) {
        this.descripcionObligacion = descripcionObligacion;
    }

    public String getTemaObligacion() {
        return temaObligacion;
    }

    public void setTemaObligacion(String temaObligacion) {
        this.temaObligacion = temaObligacion;
    }

    public Long getCriticidadObligacion() {
        return criticidadObligacion;
    }

    public void setCriticidadObligacion(Long criticidadObligacion) {
        this.criticidadObligacion = criticidadObligacion;
    }

    public String getTipificacionObligacion() {
        return tipificacionObligacion;
    }

    public void setTipificacionObligacion(String tipificacionObligacion) {
        this.tipificacionObligacion = tipificacionObligacion;
    }

    public String getDescripcionActaObligacion() {
        return descripcionActaObligacion;
    }

    public void setDescripcionActaObligacion(String descripcionActaObligacion) {
        this.descripcionActaObligacion = descripcionActaObligacion;
    }

    public String getDescripcionGuiaObligacion() {
        return descripcionGuiaObligacion;
    }

    public void setDescripcionGuiaObligacion(String descripcionGuiaObligacion) {
        this.descripcionGuiaObligacion = descripcionGuiaObligacion;
    }

    public String getCodigoBaseLegal() {
        return codigoBaseLegal;
    }

    public void setCodigoBaseLegal(String codigoBaseLegal) {
        this.codigoBaseLegal = codigoBaseLegal;
    }

    public List<ActividadDTO> getListadoActividades() {
        return listadoActividades;
    }

    public void setListadoActividades(List<ActividadDTO> listadoActividades) {
        this.listadoActividades = listadoActividades;
    }

    public List<SupervisionDTO> getListadoSupervisiones() {
        return listadoSupervisiones;
    }

    public void setListadoSupervisiones(List<SupervisionDTO> listadoSupervisiones) {
        this.listadoSupervisiones = listadoSupervisiones;
    }

    public String getTemporal() {
        return temporal;
    }

    public void setTemporal(String temporal) {
        this.temporal = temporal;
    }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

    public List<TipificacionDTO> getListadoTipificaciones() {
        return listadoTipificaciones;
    }

    public void setListadoTipificaciones(List<TipificacionDTO> listadoTipificaciones) {
        this.listadoTipificaciones = listadoTipificaciones;
    }

	public List<TemaDTO> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<TemaDTO> listaTemas) {
		this.listaTemas = listaTemas;
	}

    public DocumentoAdjuntoDTO getDocumentoAdjunto() {
        return documentoAdjunto;
    }

    public void setDocumentoAdjunto(DocumentoAdjuntoDTO documentoAdjunto) {
        this.documentoAdjunto = documentoAdjunto;
    }

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }

	public Long getIdBaseLegal() {
		return idBaseLegal;
	}

	public void setIdBaseLegal(Long idBaseLegal) {
		this.idBaseLegal = idBaseLegal;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getRutaAlfresco() {
		return rutaAlfresco;
	}

	public void setRutaAlfresco(String rutaAlfresco) {
		this.rutaAlfresco = rutaAlfresco;
	}
	

}