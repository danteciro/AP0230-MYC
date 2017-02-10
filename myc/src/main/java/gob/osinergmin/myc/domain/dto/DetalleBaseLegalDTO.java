package gob.osinergmin.myc.domain.dto;

import java.util.Date;
import java.util.List;
/**
 *
 * @author gvillanueva
 */

public class DetalleBaseLegalDTO {
    
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
    /** fecha de entrada en vigencia de la norma legal**/
    private Date fechaEntradaVigenciaNorma;
    /** fecha de publicación de la norma legal**/
    private Date fechaPublicacionNorma;
    /* descripcion General de la base Legal */
    private String descripcionGeneralBaseLegal;
    /* estado */
    private String estado;
    /** id de la Base Legal**/
    private Long idBaseLegal;
    /*Rsis 1 - Inicio*/
    /** numero de Anexo de la base Legal**/
    private String numeroAnexo;
    /*Rsis 1 - Fin*/
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
    private List<BaseLegalDTO> listaBasesLegales;
    
    
    
        
    public Long getIdDetalleBaseLegal() {
		return idDetalleBaseLegal;
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
    public DetalleBaseLegalDTO(){
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
    public Date getFechaEntradaVigenciaNorma(){
        return fechaEntradaVigenciaNorma;
    }
    /* coloca la fecha de entrada en vigencia de la norma legal ** @param fechaEntradaVigenciaNormaLegal.*/
    public void setFechaEntradaVigenciaNorma(Date fechaEntradaVigenciaNormaLegal) {
        this.fechaEntradaVigenciaNorma = fechaEntradaVigenciaNormaLegal;
    }
    /*retorna la fecha de publicacion de la norma legal ** @return fechaPublicacionNormaLegal.*/
    public Date getFechaPublicacionNorma(){
        return fechaPublicacionNorma;
    }
    /* coloca la fecha de publicacion de la norma legal ** @param fechaPublicacionNormaLegal.*/
    public void setFechaPublicacionNorma(Date fechaPublicacionNorma) {
        this.fechaPublicacionNorma = fechaPublicacionNorma;
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

	public List<BaseLegalDTO> getListaBasesLegales() {
		return listaBasesLegales;
	}

	public void setListaBasesLegales(List<BaseLegalDTO> listaBasesLegales) {
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
	/*Rsis 1 - Inicio*/
	public String getNumeroAnexo() {
		return numeroAnexo;
	}

	public void setNumeroAnexo(String numeroAnexo) {
		this.numeroAnexo = numeroAnexo;
	}
	/*Rsis 1 - Fin*/
    
        
}
