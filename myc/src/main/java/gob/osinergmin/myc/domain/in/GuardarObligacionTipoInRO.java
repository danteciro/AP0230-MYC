package gob.osinergmin.myc.domain.in;

import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;

public class GuardarObligacionTipoInRO {
	
	private ObligacionTipoDTO obligacionTipo;
	UsuarioDTO usuario;
	
	ObligacionTipoFilter filtro;
	
	
	public ObligacionTipoDTO getObligacionTipo() {
		return obligacionTipo;
	}
	public void setObligacionTipo(ObligacionTipoDTO obligacionTipo) {
		this.obligacionTipo = obligacionTipo;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public ObligacionTipoFilter getFiltro() {
		return filtro;
	}
	public void setFiltro(ObligacionTipoFilter filtro) {
		this.filtro = filtro;
	}
	
	
	
	
}
