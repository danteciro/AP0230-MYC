package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import gob.osinergmin.myc.domain.NpsTramite;
import gob.osinergmin.myc.domain.builder.TramiteNpsBuilder;
import gob.osinergmin.myc.domain.dto.TramiteNpsDTO;
import gob.osinergmin.myc.domain.ui.TramiteNpsFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.TramiteNpsDAO;


@Repository("TramiteNpsDAOImpl")
public class TramiteNpsDAOImpl implements TramiteNpsDAO{

	@Inject
	private CrudDAO crudDAO;
	
	@Override
	@Transactional
	public List<TramiteNpsDTO> listar(TramiteNpsFilter tramiteNpsFilter) {
		Query query = null;
		List<NpsTramite> lista = new ArrayList<NpsTramite>();
		List<TramiteNpsDTO> listaDto = new ArrayList<TramiteNpsDTO>();
		try {
			query = crudDAO.getEm().createNamedQuery("NpsTramite.findAll");
			lista = query.getResultList();
			listaDto = TramiteNpsBuilder.toListTramiteNpsDTO(lista);
		} catch (Exception e) {
		}
		return listaDto;
	}

	
	
}
