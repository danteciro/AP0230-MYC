package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.PghObligacionTipo;

import java.io.Serializable;
import java.util.Date;


public class CnfActUniOrganicaDTO implements Serializable{
	
		private Long idCnfActUniOrganica;
	    private String estado;
	    private String usuarioCreacion;
	    private Date fechaCreacion;
	    private String terminalCreacion;
	    private String usuarioActualizacion;
	    private Date fechaActualizacion;
	    private String terminalActualizacion;
	    private PghObligacionTipo idObligacionTipo;
	    private MdiUnidadOrganica idUnidadOrganica;
	    private MdiActividad idActividad;
	    
	    /* OSINE_SFS-1232 - REQF- - Inicio */
	    private UnidadOrganicaDTO idUnidadOrganicaDTO;
	    /* OSINE_SFS-1232 - REQF- - Fin */
	    
	    
		public Long getIdCnfActUniOrganica() {
			return idCnfActUniOrganica;
		}
		public void setIdCnfActUniOrganica(Long idCnfActUniOrganica) {
			this.idCnfActUniOrganica = idCnfActUniOrganica;
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
		public PghObligacionTipo getIdObligacionTipo() {
			return idObligacionTipo;
		}
		public void setIdObligacionTipo(PghObligacionTipo idObligacionTipo) {
			this.idObligacionTipo = idObligacionTipo;
		}
		public MdiUnidadOrganica getIdUnidadOrganica() {
			return idUnidadOrganica;
		}
		public void setIdUnidadOrganica(MdiUnidadOrganica idUnidadOrganica) {
			this.idUnidadOrganica = idUnidadOrganica;
		}
		public MdiActividad getIdActividad() {
			return idActividad;
		}
		public void setIdActividad(MdiActividad idActividad) {
			this.idActividad = idActividad;
		}
		
		public UnidadOrganicaDTO getIdUnidadOrganicaDTO() {
			return idUnidadOrganicaDTO;
		}
		public void setIdUnidadOrganicaDTO(UnidadOrganicaDTO idUnidadOrganicaDTO) {
			this.idUnidadOrganicaDTO = idUnidadOrganicaDTO;
		}
	    
		
	    
}
