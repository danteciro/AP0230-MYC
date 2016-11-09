package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfActUniOrganicaDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;

import java.util.List;

public interface CnfActUniOrganicaServiceNeg {
	public List<ActividadDTO> findActividadDivision(UnidadOrganicaFilter unidadOrganicaFilter);
	/* OSINE_SFS-1232 - REQF- - Inicio */
	public List<CnfActUniOrganicaDTO> findByActividadAndUnidadOrganica(UnidadOrganicaFilter unidadOrganicaFilter, ActividadFilter actividadFilter);
	/* OSINE_SFS-1232 - REQF- - Inicio */
}
