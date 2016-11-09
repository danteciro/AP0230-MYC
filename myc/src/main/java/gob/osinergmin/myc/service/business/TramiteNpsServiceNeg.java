package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.TramiteNpsDTO;
import gob.osinergmin.myc.domain.ui.TramiteNpsFilter;

import java.util.List;

public interface TramiteNpsServiceNeg {
	public List<TramiteNpsDTO> listar(TramiteNpsFilter tramiteNpsFilter);
}
