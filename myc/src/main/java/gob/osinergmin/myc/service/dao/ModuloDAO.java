package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ModuloDTO;
import gob.osinergmin.myc.domain.ui.ModuloFilter;

import java.util.List;


public interface ModuloDAO {

	List<ModuloDTO> findModulo(ModuloFilter filtro);

}
