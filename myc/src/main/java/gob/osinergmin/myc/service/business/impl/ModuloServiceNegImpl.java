package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import gob.osinergmin.myc.domain.dto.ModuloDTO;
import gob.osinergmin.myc.domain.ui.ModuloFilter;
import gob.osinergmin.myc.service.business.ModuloServiceNeg;
import gob.osinergmin.myc.service.dao.ModuloDAO;

@Service("ModuloServiceNeg")
public class ModuloServiceNegImpl implements ModuloServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(ModuloServiceNeg.class);
	@Inject
	private ModuloDAO moduloDAO;

	@Override
	public List<ModuloDTO> findModulo(ModuloFilter filtro) {
		LOG.info("Funcion: findModulo");
		List<ModuloDTO> listado=null;
        try{
        	listado = moduloDAO.findModulo(filtro);             	
        }catch(Exception ex){
            LOG.error("Error en findModulo", ex);
        }
		return listado;
	}

}
