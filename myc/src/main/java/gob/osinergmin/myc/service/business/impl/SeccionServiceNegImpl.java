package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import gob.osinergmin.myc.domain.dto.ModuloDTO;
import gob.osinergmin.myc.domain.dto.SeccionDTO;
import gob.osinergmin.myc.domain.ui.ModuloFilter;
import gob.osinergmin.myc.domain.ui.SeccionFilter;
import gob.osinergmin.myc.service.business.SeccionServiceNeg;
import gob.osinergmin.myc.service.dao.SeccionDAO;

@Service("SeccionServiceNeg")
public class SeccionServiceNegImpl implements SeccionServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(SeccionServiceNeg.class);
	@Inject
	private SeccionDAO seccionDAO;
	@Override
	public List<SeccionDTO> findSeccion(SeccionFilter filtro) {
		LOG.info("Funcion: findSeccion");
		List<SeccionDTO> listado=null;
	    try{
	    	listado = seccionDAO.findSeccion(filtro);             	
	    }catch(Exception ex){
	        LOG.error("Error en findModulo", ex);
	    }
		return listado;
	}

}





