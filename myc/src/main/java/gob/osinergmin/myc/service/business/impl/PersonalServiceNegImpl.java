/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.ui.PersonalFilter;
import gob.osinergmin.myc.service.business.PersonalServiceNeg;
import gob.osinergmin.myc.service.dao.PersonalDAO;
import gob.osinergmin.myc.domain.dto.PersonalDTO;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service("personalServiceNeg")
public class PersonalServiceNegImpl implements PersonalServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(PersonalServiceNegImpl.class);    
    @Inject
    private PersonalDAO personalDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<PersonalDTO> findPersonal(PersonalFilter filtro){
        LOG.info("Neg findPersonal");
        List<PersonalDTO> retorno=new ArrayList<PersonalDTO>();
        try{
            retorno=personalDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("Error en findPersonal",ex);
        }
        return retorno;
    }
}
