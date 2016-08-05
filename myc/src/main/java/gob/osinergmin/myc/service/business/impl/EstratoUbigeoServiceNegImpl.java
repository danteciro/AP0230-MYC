package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.dto.EstratoUbigeoDTO;
import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.service.business.EstratoUbigeoServiceNeg;
import gob.osinergmin.myc.service.dao.EstratoUbigeoDAO;

@Service("EstratoUbigeoServiceNeg")
public class EstratoUbigeoServiceNegImpl implements EstratoUbigeoServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(EstratoUbigeoServiceNegImpl.class);
	
	@Inject
	private EstratoUbigeoDAO estratoUbigeoDAO;
	@Override
	@Transactional(readOnly=true)
	public List<EstratoUbigeoDTO> listarEstratoUbigeo() {
		LOG.info("Negocio EstratoUbigeoService");
        List<EstratoUbigeoDTO> retorno=null;
        try{
        	retorno = estratoUbigeoDAO.listarEstratoUbigeo();

        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}

}
