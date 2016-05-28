/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.MotivoTramiteDTO;
import gob.osinergmin.myc.domain.ui.MotivoTramiteFilter;
import gob.osinergmin.myc.service.business.MotivoTramiteNeg;
import gob.osinergmin.myc.service.dao.MotivoTramiteDAO;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("motivoTramiteNeg")
public class MotivoTramiteNegImpl implements MotivoTramiteNeg{
    private static final Logger LOG = LoggerFactory.getLogger(RequisitoServiceNegImpl.class);
    @Inject
    private MotivoTramiteDAO motivoTramiteDAO;
    
    public List<MotivoTramiteDTO> findMotivoTramiteByFilter(MotivoTramiteFilter filtro){
        LOG.info("Neg findMotivoTramiteByFilter");
        List<MotivoTramiteDTO> retorno=null;
        try{
            retorno = motivoTramiteDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
}
