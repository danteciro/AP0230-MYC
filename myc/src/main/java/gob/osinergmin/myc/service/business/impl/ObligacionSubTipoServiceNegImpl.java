package gob.osinergmin.myc.service.business.impl;


import java.util.List;

import javax.inject.Inject;

import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.ui.ObligacionSubTipoFilter;
import gob.osinergmin.myc.service.business.ObligacionSubTipoServiceNeg;
import gob.osinergmin.myc.service.dao.ObligacionSubTipoDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("ObligacionSubTipoServiceNeg")
public class ObligacionSubTipoServiceNegImpl implements  ObligacionSubTipoServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(ObligacionSubTipoServiceNegImpl.class);
	
	@Inject 
	private ObligacionSubTipoDAO obligacionSubTipoDAO;
	
	
	@Override
	@Transactional
	public List<ObligacionSubTipoDTO> listarObligacionesSubTipo(ObligacionSubTipoFilter filtro) {
		List<ObligacionSubTipoDTO> retorno=null;
        try{	        	
        	retorno = obligacionSubTipoDAO.listaObligacionSubTipo(filtro); 
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return retorno;
	}

	

}
