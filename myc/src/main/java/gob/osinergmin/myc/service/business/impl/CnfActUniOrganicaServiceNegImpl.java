package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
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

}
