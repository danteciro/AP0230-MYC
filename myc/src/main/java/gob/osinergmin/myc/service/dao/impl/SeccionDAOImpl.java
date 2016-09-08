package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import gob.osinergmin.myc.domain.builder.SeccionBuilder;
import gob.osinergmin.myc.domain.dto.SeccionDTO;
import gob.osinergmin.myc.domain.ui.SeccionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.SeccionDAO;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service("SeccionDAO")
public class SeccionDAOImpl implements SeccionDAO{
	private static final Logger LOG = LoggerFactory.getLogger(SeccionDAO.class);
    @Inject
    private CrudDAO crud;
	@Override
	public List<SeccionDTO> findSeccion(SeccionFilter filtro) {
		List<SeccionDTO> listado=null;
		try {
			Query query = crud.getEm().createNamedQuery("PghSeccion.findAll");			
			listado = SeccionBuilder.toListSeccionDto(query.getResultList());
			
		} catch (Exception ex) {
			LOG.error("",ex);
		}
		
		return listado;
	}

}
