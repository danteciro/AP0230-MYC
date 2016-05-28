package gob.osinergmin.myc.domain.in;

import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

public class GuardarTramiteActividadInRO {
	 private TramiteActividadDTO idTramiteActividad;
	 private UsuarioDTO usuario;
	 
	public TramiteActividadDTO getIdTramiteActividad() {
		return idTramiteActividad;
	}
	public void setIdTramiteActividad(TramiteActividadDTO idTramiteActividad) {
		this.idTramiteActividad = idTramiteActividad;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	 
	 
	 
}
