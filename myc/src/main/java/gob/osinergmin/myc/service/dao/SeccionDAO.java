package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.SeccionDTO;
import gob.osinergmin.myc.domain.ui.SeccionFilter;

import java.util.List;

public interface SeccionDAO {

	List<SeccionDTO> findSeccion(SeccionFilter filtro);

}
