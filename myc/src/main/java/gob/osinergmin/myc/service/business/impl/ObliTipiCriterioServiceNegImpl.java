package gob.osinergmin.myc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.ObliTipiDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.business.ObliTipiServiceNeg;
import gob.osinergmin.myc.service.dao.ObliTipiCriterioDAO;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author lbarboza
 */
@Service("ObliTipiCriterioServiceNegImpl")
public class ObliTipiCriterioServiceNegImpl implements ObliTipiServiceNeg {

    private static final Logger LOG = LoggerFactory.getLogger(ObliTipiCriterioServiceNegImpl.class);
    
    @Inject
    private ObliTipiCriterioDAO obliTipiCriterioDAO;

	@Override
	public ObliTipiDTO obtenerRelacion(Long idCriterio) {
		return obliTipiCriterioDAO.obtenerCriterioById(idCriterio);
	}
	@Override
	public List<ObliTipiDTO> obtenerRelaciones(ObliTipiDTO obliTipiDTO) {
		List<ObliTipiDTO> lista = null;
// 05-11-2015		
		lista=obliTipiCriterioDAO.obtenerRelacionesToObligacion(obliTipiDTO);
//		
		return lista;
	}
	@Override
	public ObliTipiDTO guardaRelacion(ObliTipiDTO relacion,UsuarioDTO usuarioDTO) {
		return obliTipiCriterioDAO.crearRelacion(relacion,usuarioDTO);
	}
	
	
	@Override
	public void eliminarRelacion(ObliTipiDTO relacion,UsuarioDTO usuarioDTO) {
		obliTipiCriterioDAO.eliminarRelacion(relacion,usuarioDTO);
		
	}	
	
}