package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.myc.domain.builder.ModuloBuilder;
import gob.osinergmin.myc.domain.dto.ModuloDTO;
import gob.osinergmin.myc.domain.ui.ModuloFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ModuloDAO;

@Service("ModuloDAO")
public class ModuloDAOImpl implements ModuloDAO{
	private static final Logger LOG = LoggerFactory.getLogger(ModuloDAO.class);
    @Inject
    private CrudDAO crud;

	@Override
	public List<ModuloDTO> findModulo(ModuloFilter filtro) {
		List<ModuloDTO> listado=null;
		try {
			Query query = crud.getEm().createNamedQuery("PghModulo.findAll");			
			listado = ModuloBuilder.toListModuloDto(query.getResultList());
			
		} catch (Exception ex) {
			LOG.error("",ex);
		}
		
		return listado;
	}

}
