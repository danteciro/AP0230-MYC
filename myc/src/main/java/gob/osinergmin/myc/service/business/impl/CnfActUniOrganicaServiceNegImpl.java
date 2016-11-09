package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfActUniOrganicaDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.business.CnfActUniOrganicaServiceNeg;
import gob.osinergmin.myc.service.dao.CnfActUniOrganicaDAO;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("cnfActUniOrganicaService")
public class CnfActUniOrganicaServiceNegImpl implements CnfActUniOrganicaServiceNeg{
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CnfActUniOrganicaServiceNegImpl.class);
    
    @Inject
    CnfActUniOrganicaDAO cnfActUniOrganicaDAO;

	@Override
	public List<ActividadDTO> findActividadDivision(
			UnidadOrganicaFilter filtro) {
		LOG.info("Capa Negocio => Actividades por Division");
		List<ActividadDTO> listado=null;
        try{
        	listado = cnfActUniOrganicaDAO.findActividadDivision(filtro);            	
        }catch(Exception ex){
            LOG.error("Error ",ex);
        }
        return listado;	
	}

	/* OSINE_SFS-1232 - REQF- - Inicio */
	@Override
	public List<CnfActUniOrganicaDTO> findByActividadAndUnidadOrganica(
			UnidadOrganicaFilter unidadOrganicaFilter,
			ActividadFilter actividadFilter) {
		LOG.info("Capa Negocio => findByActividadAndUnidadOrganica");
		List<CnfActUniOrganicaDTO> listado=null;
        try{
        	listado = cnfActUniOrganicaDAO.findByActividadAndUnidadOrganica(unidadOrganicaFilter, actividadFilter);            	
        }catch(Exception ex){
            LOG.error("Error ",ex);
        }
        return listado;	
	}
	/* OSINE_SFS-1232 - REQF- - Inicio */
}
