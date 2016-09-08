package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ModuloDTO;
import gob.osinergmin.myc.domain.ui.ModuloFilter;

import java.util.List;

public interface ModuloServiceNeg {

	List<ModuloDTO> findModulo(ModuloFilter moduloFilter);

}
