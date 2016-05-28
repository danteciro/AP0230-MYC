package gob.osinergmin.myc.domain.in;

import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

/**
*
* @author dmedrano
*/

public class GuardarParametroDinamicoInRO {

	ParametroDinamicoDTO parametro;
	UsuarioDTO usuario;
	
	public ParametroDinamicoDTO getParametro() {
		return parametro;
	}
	public void setParametro(ParametroDinamicoDTO parametro) {
		this.parametro = parametro;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	
	
}
