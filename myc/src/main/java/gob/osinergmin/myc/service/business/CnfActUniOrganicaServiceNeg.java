package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;

import java.util.List;

public interface CnfActUniOrganicaServiceNeg {
	public List<ActividadDTO> findActividadDivision(UnidadOrganicaFilter unidadOrganicaFilter);
}
