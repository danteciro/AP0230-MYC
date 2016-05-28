package gob.osinergmin.myc.domain.dto;

import java.util.Date;
import java.util.List;
/**
 *
 * @author gvillanueva
 */
 public class BaseLegalDTO {
    
    /** id de la Base Legal**/
    private Long idBaseLegal;
    /** código de la Base Legal**/
    private String codigoBaseLegal;
        /** Norma Legal **/
    /** descripción del tipo de la norma legal**/
    private Long tipoNormaLegal;
    /** número de la norma legal **/
    private String numeroNormaLegal;
    /** año de la norma legal**/
    private String anioNormaLegal;
    /** sigla de la norma legal**/
    private Long siglaNormaLegal;
    /** imagen de la norma legal**/
    /* modif jpiro 20150107 - ini */
    //private String fileNormaLegal;
    /* modif jpiro 20150107 - fin */
    /** titulo de la norma legal**/
    private String tituloNormaLegal;
    /** id del Detalle de la Base Legal**/
    private Long idDetalleBaseLegal;
    /** nivel del artículo **/
    private Long idNivelArtirculo;
    /** articulo de la norma legal**/
    private String articuloNormaLegal;
    /** inciso nivel 1 de la norma legal**/
    private String incisoUnoNormaLegal;
    /** inciso nivel 2 de la norma legal**/
    private String incisoDosNormaLegal;
    /** Anexo de la Norma Legal **/
    /** descripción del tipo de anexo **/
    private Long tipoAnexo;
    /** artículo del anexo **/
    private String articuloAnexo;
    /** inciso nivel 1 del anexo **/
    private String incisoUnoAnexo;
    /** inciso nivel 2 del anexo **/
    private String incisoDosAnexo;
    /** Norma Técnica **/
    /** descripción del tipo de la norma técnica **/
    private Long tipoNormaTecnica;
    /** descripción específica de la norma técnica **/
    private String descripcionNormaTecnica;
    /** concordancia**/
    private char concordancia;
    /** modificatorias**/
    private char modificatoria;
    private char obligacion;
    /** fecha de entrada en vigencia de la norma legal**/
    private Date fechaEntradaVigenciaNormaLegal;
    /** fecha de publicación de la norma legal**/
    private Date fechaPublicacionNormaLegal;
    /**  **/
    private Date fechaEntradaVigenciaNorma;
    private Date fechaPublicacionNorma;
    /* descripcion General de la base Legal */
    private String descripcionGeneralBaseLegal;
    /* estado */
    private String estado;
    
    private Long tieneAct;
    
    private Long idBaseLegalRef;
    private Date fechaTerminoVigenciaNormaLegal;
    private Long idDocumentoAdjunto;
    /**
     * Campos de Auditoria * 
     **/
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String terminalCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
    private String terminalModificacion;
    
    /** listado de bases legales **/
    private List<BaseLegalConcordanciaDTO> listaBasesLegales;
    
    private List<ObligacionBaseLegalDTO> listaObligaciones;
    
    
    private String nombreArchivo;
    private String rutaAlfresco;
    private String codTrazabilidad;
    private String flagPadre;
    private Long idBaseLegalPadre;
    /**/
    private Long idOblBase;
    private Long idObligacion;
    private String codigoObligacion;
    private String descripcionObligacion;
    private String estadoObligacion;
    
    private Long correlativo;

    
        
    public String getFlagPadre() {
		return flagPadre;
	}

	public void setFlagPadre(String flagPadre) {
		this.flagPadre = flagPadre;
	}

	public Long getIdBaseLegalPadre() {
		return idBaseLegalPadre;
	}

	public void setIdBaseLegalPadre(Long idBaseLegalPadre) {
		this.idBaseLegalPadre = idBaseLegalPadre;
	}

	public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
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
    
    public Long getIdBaseLegalRef() {
		return idBaseLegalRef;
	}

	public void setIdBaseLegalRef(Long idBaseLegalRef) {
		this.idBaseLegalRef = idBaseLegalRef;
	}

	public Date getFechaTerminoVigenciaNormaLegal() {
		return fechaTerminoVigenciaNormaLegal;
	}

	public void setFechaTerminoVigenciaNormaLegal(
			Date fechaTerminoVigenciaNormaLegal) {
		this.fechaTerminoVigenciaNormaLegal = fechaTerminoVigenciaNormaLegal;
	}

	public Long getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}

	public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}

	public char getObligacion() {
		return obligacion;
	}

	public void setObligacion(char obligacion) {
		this.obligacion = obligacion;
	}

	public Long getTieneAct() {
		return tieneAct;
	}

	public void setTieneAct(Long tieneAct) {
		this.tieneAct = tieneAct;
	}

	public Long getIdDetalleBaseLegal() {
		return idDetalleBaseLegal;
	}

		
	public Date getFechaEntradaVigenciaNorma() {
		return fechaEntradaVigenciaNorma;
	}

	public void setFechaEntradaVigenciaNorma(Date fechaEntradaVigenciaNorma) {
		this.fechaEntradaVigenciaNorma = fechaEntradaVigenciaNorma;
	}

	public Date getFechaPublicacionNorma() {
		return fechaPublicacionNorma;
	}

	public void setFechaPublicacionNorma(Date fechaPublicacionNorma) {
		this.fechaPublicacionNorma = fechaPublicacionNorma;
	}

	public void setIdDetalleBaseLegal(Long idDetalleBaseLegal) {
		this.idDetalleBaseLegal = idDetalleBaseLegal;
	}

	public Long getIdNivelArtirculo() {
		return idNivelArtirculo;
	}

	public void setIdNivelArtirculo(Long idNivelArtirculo) {
		this.idNivelArtirculo = idNivelArtirculo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/*Constructor*/    
    public BaseLegalDTO(){
    }
    
    
    public String getCodigoBaseLegal() {
		return codigoBaseLegal;
	}

	public void setCodigoBaseLegal(String codigoBaseLegal) {
		this.codigoBaseLegal = codigoBaseLegal;
	}

	public Long getTipoNormaLegal() {
		return tipoNormaLegal;
	}

	public void setTipoNormaLegal(Long tipoNormaLegal) {
		this.tipoNormaLegal = tipoNormaLegal;
	}

	public String getNumeroNormaLegal() {
		return numeroNormaLegal;
	}

	public void setNumeroNormaLegal(String numeroNormaLegal) {
		this.numeroNormaLegal = numeroNormaLegal;
	}

	public String getAnioNormaLegal() {
		return anioNormaLegal;
	}

	public void setAnioNormaLegal(String anioNormaLegal) {
		this.anioNormaLegal = anioNormaLegal;
	}

	public Long getSiglaNormaLegal() {
		return siglaNormaLegal;
	}

	public void setSiglaNormaLegal(Long siglaNormaLegal) {
		this.siglaNormaLegal = siglaNormaLegal;
	}

//	public String getFileNormaLegal() {
//		return fileNormaLegal;
//	}
//
//	public void setFileNormaLegal(String fileNormaLegal) {
//		this.fileNormaLegal = fileNormaLegal;
//	}

	public String getTituloNormaLegal() {
		return tituloNormaLegal;
	}

	public void setTituloNormaLegal(String tituloNormaLegal) {
		this.tituloNormaLegal = tituloNormaLegal;
	}

	/*retorna el id de la Base Legal ** @return idBaseLegal.*/
    public Long getIdBaseLegal() {
        return idBaseLegal;
    }
    /* coloca id de la Base Legal. ** @param idBaseLegal.*/
    public void setIdBaseLegal(Long idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }
    /*retorna la fecha de entrada en vigencia de la norma legal ** @return fechaEntradaVigenciaNormaLegal.*/
    public Date getFechaEntradaVigenciaNormaLegal(){
        return fechaEntradaVigenciaNormaLegal;
    }
    /* coloca la fecha de entrada en vigencia de la norma legal ** @param fechaEntradaVigenciaNormaLegal.*/
    public void setFechaEntradaVigenciaNormaLegal(Date fechaEntradaVigenciaNormaLegal) {
        this.fechaEntradaVigenciaNormaLegal = fechaEntradaVigenciaNormaLegal;
    }
    /*retorna la fecha de publicacion de la norma legal ** @return fechaPublicacionNormaLegal.*/
    public Date getFechaPublicacionNormaLegal(){
        return fechaPublicacionNormaLegal;
    }
    /* coloca la fecha de publicacion de la norma legal ** @param fechaPublicacionNormaLegal.*/
    public void setFechaPublicacionNormaLegal(Date fechaPublicacionNormaLegal) {
        this.fechaPublicacionNormaLegal = fechaPublicacionNormaLegal;
    }
    
    /*retorna articulo de la norma legal ** @return articuloNormaLegal.*/
    public String getArticuloNormaLegal(){
        return articuloNormaLegal;
    }
    /* coloca articulo de la norma legal ** @param articuloNormaLegal.*/
    public void setArticuloNormaLegal(String articuloNormaLegal) {
        this.articuloNormaLegal = articuloNormaLegal;
    }
    /*retorna inciso nivel 1 de la norma legal ** @return incisoUnoNormaLegal.*/
    public String getIncisoUnoNormaLegal(){
        return incisoUnoNormaLegal;
    }
    /* coloca inciso nivel 1 de la norma legal ** @param incisoUnoNormaLegal.*/
    public void setIncisoUnoNormaLegal(String incisoUnoNormaLegal) {
        this.incisoUnoNormaLegal = incisoUnoNormaLegal;
    }
    /*retorna inciso nivel 2 de la norma legal ** @return incisoDosNormaLegal.*/
    public String getIncisoDosNormaLegal(){
        return incisoDosNormaLegal;
    }
    /* coloca inciso nivel 2 de la norma legal ** @param incisoDosNormaLegal.*/
    public void setIncisoDosNormaLegal(String incisoDosNormaLegal) {
        this.incisoDosNormaLegal = incisoDosNormaLegal;
    }
    /*retorna tipo de anexo de la norma legal ** @return tipoAnexo.*/
    public Long getTipoAnexo(){
        return tipoAnexo;
    }
    /* coloca tipo de anexo de la norma legal ** @param tipoAnexo.*/
    public void setTipoAnexo(Long tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }
    /*retorna artículo de anexo de la norma legal ** @return articuloAnexo.*/
    public String getArticuloAnexo(){
        return articuloAnexo;
    }
    /* coloca artículo de anexo de la norma legal ** @param articuloAnexo.*/
    public void setArticuloAnexo(String articuloAnexo) {
        this.articuloAnexo = articuloAnexo;
    }
    /*retorna inciso nivel 1 de anexo de la norma legal ** @return incisoUnoAnexo.*/
    public String getIncisoUnoAnexo(){
        return incisoUnoAnexo;
    }
    /* coloca inciso nivel 1 de anexo de la norma legal ** @param incisoUnoAnexo.*/
    public void setIncisoUnoAnexo(String incisoUnoAnexo) {
        this.incisoUnoAnexo = incisoUnoAnexo;
    }
    /*retorna inciso nivel 2 de anexo de la norma legal ** @return incisoDosAnexo.*/
    public String getIncisoDosAnexo(){
        return incisoDosAnexo;
    }
    /* coloca inciso nivel 2 de anexo de la norma legal ** @param incisoDosAnexo.*/
    public void setIncisoDosAnexo(String incisoDosAnexo) {
        this.incisoDosAnexo = incisoDosAnexo;
    }
    /*retorna tipo de norma tecnica ** @return tipoNormaTecnica.*/
    public Long getTipoNormaTecnica(){
        return tipoNormaTecnica;
    }
    /* coloca tipo de norma tecnica ** @param tipoNormaTecnica.*/
    public void setTipoNormaTecnica(Long tipoNormaTecnica) {
        this.tipoNormaTecnica = tipoNormaTecnica;
    }
    /*retorna tipo de norma tecnica ** @return descripcionNormaTecnica.*/
    public String getDescripcionNormaTecnica(){
        return descripcionNormaTecnica;
    }
    /* coloca tipo de norma tecnica ** @param descripcionNormaTecnica.*/
    public void setDescripcionNormaTecnica(String descripcionNormaTecnica) {
        this.descripcionNormaTecnica = descripcionNormaTecnica;
    }
       
    /*retorna base legal en concordancia ** @return descripcionConcordancia.*/
    public char getConcordancia(){
        return concordancia;
    }
    /* coloca descripcion de base legal en concordancia ** @param descripcionConcordancia.*/
    public void setConcordancia(char concordancia) {
        this.concordancia = concordancia;
    }
    /*retorna descripcion general de la base legal ** @return descripcionGeneralBaseLegal.*/
    public String getDescripcionGeneralBaseLegal() {
        return descripcionGeneralBaseLegal;
    }
    /* coloca descripcion general de la base legal ** @param descripcionGeneralBaseLegal.*/
    public void setDescripcionGeneralBaseLegal(String descripcionGeneralBaseLegal) {
        this.descripcionGeneralBaseLegal = descripcionGeneralBaseLegal;
    }

	public char getModificatoria() {
		return modificatoria;
	}

	public void setModificatoria(char modificatoria) {
		this.modificatoria = modificatoria;
	}

	public List<BaseLegalConcordanciaDTO> getListaBasesLegales() {
		return listaBasesLegales;
	}

	public void setListaBasesLegales(List<BaseLegalConcordanciaDTO> listaBasesLegales) {
		this.listaBasesLegales = listaBasesLegales;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getTerminalCreacion() {
		return terminalCreacion;
	}

	public void setTerminalCreacion(String terminalCreacion) {
		this.terminalCreacion = terminalCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getTerminalModificacion() {
		return terminalModificacion;
	}

	public void setTerminalModificacion(String terminalModificacion) {
		this.terminalModificacion = terminalModificacion;
	}

	public List<ObligacionBaseLegalDTO> getListaObligaciones() {
		return listaObligaciones;
	}

	public void setListaObligaciones(List<ObligacionBaseLegalDTO> listaObligaciones) {
		this.listaObligaciones = listaObligaciones;
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

	public String getDescripcionObligacion() {
		return descripcionObligacion;
	}

	public void setDescripcionObligacion(String descripcionObligacion) {
		this.descripcionObligacion = descripcionObligacion;
	}

	public String getEstadoObligacion() {
		return estadoObligacion;
	}

	public void setEstadoObligacion(String estadoObligacion) {
		this.estadoObligacion = estadoObligacion;
	}

	public Long getIdOblBase() {
		return idOblBase;
	}

	public void setIdOblBase(Long idOblBase) {
		this.idOblBase = idOblBase;
	}

	public Long getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(Long correlativo) {
		this.correlativo = correlativo;
	}
	
	
}
