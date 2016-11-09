package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.dto.TramiteNpsDTO;
import gob.osinergmin.myc.domain.ui.TramiteNpsFilter;
import gob.osinergmin.myc.service.business.TramiteNpsServiceNeg;
import gob.osinergmin.myc.service.dao.TramiteNpsDAO;

@Service("TramiteNpsService")
public class TramiteNpsServiceNegImpl implements TramiteNpsServiceNeg{

	@Inject
	private TramiteNpsDAO tramiteNpsDAO;
	
	@Override
	@Transactional
	public List<TramiteNpsDTO> listar(TramiteNpsFilter tramiteNpsFilter) {
		return tramiteNpsDAO.listar(tramiteNpsFilter);
	}

}
