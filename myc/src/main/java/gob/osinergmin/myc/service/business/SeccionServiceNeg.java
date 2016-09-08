package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.SeccionDTO;
import gob.osinergmin.myc.domain.ui.SeccionFilter;

import java.util.List;

public interface SeccionServiceNeg {

	List<SeccionDTO> findSeccion(SeccionFilter seccionFilter);

}
