/**
 * Resumen.
 * Objeto                   : InfraccionDTO.java 
 * Descripción              : DTO que contiene los atributos de Infraccion con sus respectivos get, set.
 * Fecha de Creación        : 13/06/2016
 * PR de Modificacion 		: OSINE_119
 * Autor                    : Roy Colorado.
 * ---------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo       Fecha       Nombre                 Descripcion
 *                                           
 */

package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.domain.PghObligacion;

import java.math.BigInteger;
import java.util.Date;

public class InfraccionDTO {
	/**
	 * Identificador de infracción 
	 */
	private Long idInfraccion;
	/**
	 * Descripción de la infracción
	 */
	private String descripcionInfraccion;
	/**
	 * Identificador de la tabla MaestroColumna
	 */
	private Long idMedidaSeguridadMaestro;
	/**
	 * Identificador de la tabla MaestroColumna
	 */
	private Long idAccionMaestro;
	/**
	 * Identificador del padre
	 */
	private BigInteger idPadre;
	/**
	 * Código de trazabilidad
	 */
	private String codTrazabilidad;
	/**
	 * Código de acción
	 */
	private String codAccion;
	/**
	 * Estado de la infracción
	 */
	private String estado;
	/**
	 * Usuario que creó el registro de la infracción
	 */
	private String usuarioCreacion;
	/**
	 * Fecha de creación del registro de infracción
	 */
	private Date fechaCreacion;
	/**
	 * Terminal de creación del usuario
	 */
	private String terminalCreacion;
	/**
	 * Usuario que actualiza la infracción
	 */
	private String usuarioActualizacion;
	/**
	 * Fecha de actualización del registro de infracción
	 */
	private Date fechaActualizacion;
	/**
	 * Terminal de actualización del usuario 
	 */
	private String terminalActualizacion;
	/**
	 * Entidad de la base de datos con la que se relaciona la infracción
	 */
	private PghObligacion idObligacion;
	private ObligacionNormativaDTO obligacionDTO;
	/**
	 * Identificador temporal de obligación
	 */
	private Long idObligacion2;	
	/**
	 * DTO de tipo DocmentoAdjuntoDTO
	 */
	private DocumentoAdjuntoDTO documentoAdjuntoDTO;
	/**
	 * Identificador de Documento Adjunto
	 */
	private Long getIdDocumentoAdjunto;
    
    
	/**
	 * Constructor vacío de la infracción
	 */
	public InfraccionDTO() {
		super();
	}
	/**
	 * Método que obtiene el identificador de la infracción
	 * @return idInfracción
	 */
	public Long getIdInfraccion() {
		return idInfraccion;
	}
	/**
	 * Método que asignar el identificador de la infracción
	 * @param idInfraccion
	 */
	public void setIdInfraccion(Long idInfraccion) {
		this.idInfraccion = idInfraccion;
	}
	/**
	 * Método que obtiene la descripción de la Infracción
	 * @return descripcionInfraccion
	 */
	public String getDescripcionInfraccion() {
		return descripcionInfraccion;
	}
	public void setDescripcionInfraccion(String descripcionInfraccion) {
		this.descripcionInfraccion = descripcionInfraccion;
	}
	public Long getIdMedidaSeguridadMaestro() {
		return idMedidaSeguridadMaestro;
	}
	public void setIdMedidaSeguridadMaestro(Long idMedidaSeguridadMaestro) {
		this.idMedidaSeguridadMaestro = idMedidaSeguridadMaestro;
	}
	public Long getIdAccionMaestro() {
		return idAccionMaestro;
	}
	public void setIdAccionMaestro(Long idAccionMaestro) {
		this.idAccionMaestro = idAccionMaestro;
	}
	public BigInteger getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(BigInteger idPadre) {
		this.idPadre = idPadre;
	}
	public String getCodTrazabilidad() {
		return codTrazabilidad;
	}
	public void setCodTrazabilidad(String codTrazabilidad) {
		this.codTrazabilidad = codTrazabilidad;
	}
	public String getCodAccion() {
		return codAccion;
	}
	public void setCodAccion(String codAccion) {
		this.codAccion = codAccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public String getTerminalActualizacion() {
		return terminalActualizacion;
	}
	public void setTerminalActualizacion(String terminalActualizacion) {
		this.terminalActualizacion = terminalActualizacion;
	}
	
	public PghObligacion getIdObligacion() {
		return idObligacion;
	}
	public void setIdObligacion(PghObligacion idObligacion) {
		this.idObligacion = idObligacion;
	}
	
	
	/*
	public MdiDocumentoAdjunto getIdDocumentoAdjunto() {
		return idDocumentoAdjunto;
	}
	public void setIdDocumentoAdjunto(MdiDocumentoAdjunto idDocumentoAdjunto) {
		this.idDocumentoAdjunto = idDocumentoAdjunto;
	}
	*/
	
	public DocumentoAdjuntoDTO getDocumentoAdjuntoDTO() {
		return documentoAdjuntoDTO;
	}
	
	public Long getIdObligacion2() {
		return idObligacion2;
	}

	public void setIdObligacion2(Long idObligacion2) {
		this.idObligacion2 = idObligacion2;
	}

	public void setDocumentoAdjuntoDTO(DocumentoAdjuntoDTO documentoAdjuntoDTO) {
		this.documentoAdjuntoDTO = documentoAdjuntoDTO;
	}

	public Long getGetIdDocumentoAdjunto() {
		return getIdDocumentoAdjunto;
	}

	public void setGetIdDocumentoAdjunto(Long getIdDocumentoAdjunto) {
		this.getIdDocumentoAdjunto = getIdDocumentoAdjunto;
	}
	public ObligacionNormativaDTO getObligacionDTO() {
		return obligacionDTO;
	}
	public void setObligacionDTO(ObligacionNormativaDTO obligacionDTO) {
		this.obligacionDTO = obligacionDTO;
	}
	
	
}
