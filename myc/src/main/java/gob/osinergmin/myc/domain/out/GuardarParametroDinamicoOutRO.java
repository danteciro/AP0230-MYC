package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;

public class GuardarParametroDinamicoOutRO extends BaseOutBean  {
	
	private ParametroDinamicoDTO parametro;

	public ParametroDinamicoDTO getParametro() {
		return parametro;
	}

	public void setParametro(ParametroDinamicoDTO parametro) {
		this.parametro = parametro;
	} 
	
	

}
