package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.myc.domain.builder.EstratoUbigeoBuilder;
import gob.osinergmin.myc.domain.dto.EstratoUbigeoDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.EstratoUbigeoDAO;

@Service("EstratoUbigeoDAO")
public class EstratoUbigeoDAOImpl implements EstratoUbigeoDAO{
	private static final Logger LOG = LoggerFactory.getLogger(EstratoUbigeoDAOImpl.class);
    @Inject
    private CrudDAO crud;
	@Override
	public List<EstratoUbigeoDTO> listarEstratoUbigeo() {
		List<EstratoUbigeoDTO> listado=null;
		Query query = crud.getEm().createNamedQuery("PghEstratoUbigeo.findAll");
        listado = EstratoUbigeoBuilder.toListEstratoUbigeoDto(query.getResultList());        
        return listado;   
	}

}
