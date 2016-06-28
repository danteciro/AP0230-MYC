/**
 * Resumen.
 * Objeto                   : IncumplimientoDTO.java 
 * Descripción              : DTO que contiene los atributos de Incumplimiento con sus respectivos get, set.
 * Fecha de Creación        : 13/06/2016
 * PR de Modificacion 		: OSINE_119
 * Autor                    : Roy Colorado.
 * ---------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo       Fecha       Nombre                 Descripcion
 *                                           
 */
package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.PghObligacion;

import java.math.BigInteger;
import java.util.Date;

public class IncumplimientoDTO {
	
	private Long id_esce_incumplimiento;
	private Long id_infraccion;
	private Long id_esce_incu_maestro;
	private BigInteger padre;
	private String cod_trazabilidad ;
	private String cod_accion;
	private String estado;
	private String usuario_creacion;
	private Date fecha_creacion;
	private String terminal_creacion;
	private String usuario_actualizacion;
	private Date fecha_actualizacion;
	private String terminal_actualizacion;
	private String descripcionEscenarioIncumplimiento;
	
	public IncumplimientoDTO() {
		super();
	}
	public Long getId_esce_incumplimiento() {
		return id_esce_incumplimiento;
	}
	public void setId_esce_incumplimiento(Long id_esce_incumplimiento) {
		this.id_esce_incumplimiento = id_esce_incumplimiento;
	}
	public Long getId_infraccion() {
		return id_infraccion;
	}
	public void setId_infraccion(Long id_infraccion) {
		this.id_infraccion = id_infraccion;
	}
	public Long getId_esce_incu_maestro() {
		return id_esce_incu_maestro;
	}
	public void setId_esce_incu_maestro(Long id_esce_incu_maestro) {
		this.id_esce_incu_maestro = id_esce_incu_maestro;
	}
	public BigInteger getPadre() {
		return padre;
	}
	public void setPadre(BigInteger padre) {
		this.padre = padre;
	}
	public String getCod_trazabilidad() {
		return cod_trazabilidad;
	}
	public void setCod_trazabilidad(String cod_trazabilidad) {
		this.cod_trazabilidad = cod_trazabilidad;
	}
	public String getCod_accion() {
		return cod_accion;
	}
	public void setCod_accion(String cod_accion) {
		this.cod_accion = cod_accion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario_creacion() {
		return usuario_creacion;
	}
	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getTerminal_creacion() {
		return terminal_creacion;
	}
	public void setTerminal_creacion(String terminal_creacion) {
		this.terminal_creacion = terminal_creacion;
	}
	public String getUsuario_actualizacion() {
		return usuario_actualizacion;
	}
	public void setUsuario_actualizacion(String usuario_actualizacion) {
		this.usuario_actualizacion = usuario_actualizacion;
	}
	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}
	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}
	public String getTerminal_actualizacion() {
		return terminal_actualizacion;
	}
	public void setTerminal_actualizacion(String terminal_actualizacion) {
		this.terminal_actualizacion = terminal_actualizacion;
	}
	public String getDescripcionEscenarioIncumplimiento() {
		return descripcionEscenarioIncumplimiento;
	}
	public void setDescripcionEscenarioIncumplimiento(
			String descripcionEscenarioIncumplimiento) {
		this.descripcionEscenarioIncumplimiento = descripcionEscenarioIncumplimiento;
	}
	
	
}
