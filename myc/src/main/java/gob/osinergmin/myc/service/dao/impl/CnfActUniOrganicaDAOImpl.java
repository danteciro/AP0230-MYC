package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import gob.osinergmin.myc.domain.PghCnfActUniOrganica;
import gob.osinergmin.myc.domain.builder.CnfActUniOrganicaBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfActUniOrganicaDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
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

    /* OSINE_SFS-1232 - REQF- - Inicio */
    @Override
	public List<CnfActUniOrganicaDTO> findByActividadAndUnidadOrganica(UnidadOrganicaFilter unidadOrganicaFilter, ActividadFilter actividadFilter) {
    	List<CnfActUniOrganicaDTO> listado=null;
        try{
            Query query = null;
            query = crud.getEm().createNamedQuery("PghCnfActUniOrganica.findByUnidadAndActividad");
            if(unidadOrganicaFilter.getIdUnidadOrganica()!=null){
            	query.setParameter("idUnidadOrganica", unidadOrganicaFilter.getIdUnidadOrganica());
            }
            if(actividadFilter.getIdActividad()!=null){
            	query.setParameter("idActividad", actividadFilter.getIdActividad());
            }            
            
            List<PghCnfActUniOrganica> lista = query.getResultList();
            if(!CollectionUtils.isEmpty(lista)){
            	listado = CnfActUniOrganicaBuilder.toListCnfActUniOrganicaDTO(lista);
            }
            
        }catch(Exception e){
            LOG.error("Exception en find, locadorServiceImpl");
            LOG.error(e.getMessage());
        }
        return listado;
	}
	
    /* OSINE_SFS-1232 - REQF- - Fin */
    
    
    
    
}
