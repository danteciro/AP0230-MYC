package gob.osinergmin.myc.domain.in;

import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

public class GuardarRubroOpcionInRO {
	 private RubroOpcionDTO idRubroOpcion;
	 private UsuarioDTO usuario;
	 

	public RubroOpcionDTO getIdRubroOpcion() {
		return idRubroOpcion;
	}
	public void setIdRubroOpcion(RubroOpcionDTO idRubroOpcion) {
		this.idRubroOpcion = idRubroOpcion;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	 
	 
	 
}
