package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;

public class GuardarRubroOpcionOutRO extends BaseOutBean {
	private RubroOpcionDTO rubroOpcion;

	public RubroOpcionDTO getRubroOpcion() {
		return rubroOpcion;
	}

	public void setRubroOpcion(RubroOpcionDTO rubroOpcion) {
		this.rubroOpcion = rubroOpcion;
	}
}
