package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;

public class GuardarObligacionTipoOutRO  extends BaseOutBean  {
	
	ObligacionTipoDTO obligacionTipo;

	public ObligacionTipoDTO getObligacionTipo() {
		return obligacionTipo;
	}

	public void setObligacionTipo(ObligacionTipoDTO obligacionTipo) {
		this.obligacionTipo = obligacionTipo;
	}
	
	
}
