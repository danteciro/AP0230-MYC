package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;

public class GuardarProcesoObligacionTipoOutRO extends BaseOutBean {
	private ProcesoObligacionTipoDTO procesoObligacionTipo;

	public ProcesoObligacionTipoDTO getProcesoObligacionTipo() {
		return procesoObligacionTipo;
	}

	public void setProcesoObligacionTipo(
			ProcesoObligacionTipoDTO procesoObligacionTipo) {
		this.procesoObligacionTipo = procesoObligacionTipo;
	}
	
	
}
