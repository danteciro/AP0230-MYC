package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;

import java.util.List;

public interface CnfActUniOrganicaDAO {

	List<ActividadDTO> findActividadDivision(UnidadOrganicaFilter filtro);

}
