package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;

public class GuardarValorParametroOutRO extends BaseOutBean {

	
	private ValorParametroDTO valorParametro;
	private UsuarioDTO usuario;
	
	
	public ValorParametroDTO getValorParametro() {
		return valorParametro;
	}
	public void setValorParametro(ValorParametroDTO valorParametro) {
		this.valorParametro = valorParametro;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
