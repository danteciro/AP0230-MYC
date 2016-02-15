package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.PghCnfTramiteActividad;
import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;

public class GuardarTramiteActividadOutRO extends BaseOutBean {
	private TramiteActividadDTO tramiteActividad;

	public TramiteActividadDTO getTramiteActividad() {
		return tramiteActividad;
	}

	public void setIdTramiteActividad(TramiteActividadDTO tramiteActividad) {
		this.tramiteActividad = tramiteActividad;
	}
	
	
}
