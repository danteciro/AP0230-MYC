package gob.osinergmin.myc.domain.in;

import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

public class GuardarProcesoObligacionTipoInRO {
	private UsuarioDTO usuario;
	private ProcesoObligacionTipoDTO procesoObligacionTipo;
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public ProcesoObligacionTipoDTO getProcesoObligacionTipo() {
		return procesoObligacionTipo;
	}
	public void setProcesoObligacionTipo(
			ProcesoObligacionTipoDTO procesoObligacionTipo) {
		this.procesoObligacionTipo = procesoObligacionTipo;
	}
	
	
	
	
	
}
