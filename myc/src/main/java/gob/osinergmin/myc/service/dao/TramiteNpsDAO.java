package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.NpsTramite;
import gob.osinergmin.myc.domain.dto.TramiteNpsDTO;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.domain.ui.TramiteNpsFilter;

import java.util.List;

public interface TramiteNpsDAO {
	public List<TramiteNpsDTO> listar(TramiteNpsFilter tramiteNpsFilter);
}
