package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.builder.CnfActUniOrganicaBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.dao.CnfActUniOrganicaDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;

@Service
@Transactional
public class CnfActUniOrganicaDAOImpl implements CnfActUniOrganicaDAO {

	
	private static final Logger LOG = LoggerFactory.getLogger(CnfActUniOrganicaDAOImpl.class);

    @Inject
    private CrudDAO crud;
    
    @Override
	public List<ActividadDTO> findActividadDivision(UnidadOrganicaFilter filtro) {
    	List<ActividadDTO> listado=new ArrayList<ActividadDTO>();
        try{
            Query query = getFindQuery(filtro);
            listado = CnfActUniOrganicaBuilder.toListActividadxUnidadOrganicaDto(query.getResultList());
        }catch(Exception e){
            LOG.error("Exception en find, locadorServiceImpl");
            LOG.error(e.getMessage());
        }
        return listado;
	}
	

    
    private Query getFindQuery(UnidadOrganicaFilter filtro) {
        Query query;
        
        if(filtro.getIdUnidadOrganica()!=null){
            query = crud.getEm().createNamedQuery("PghCnfActUniOrganica.findByIdUnidadOrganica");
        }else{
            query = crud.getEm().createNamedQuery("PghCnfActUniOrganica.findAll");
        }
        
        if (filtro.getIdUnidadOrganica()!= null) {
            query.setParameter("idUnidadOrganica",filtro.getIdUnidadOrganica());
        }
                
        return query;
    }

}
