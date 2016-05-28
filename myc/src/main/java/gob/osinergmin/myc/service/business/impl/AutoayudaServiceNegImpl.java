/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.AutoayudaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.AutoayudaFilter;
import gob.osinergmin.myc.service.business.AutoayudaServiceNeg;
import gob.osinergmin.myc.service.dao.AutoayudaDAO;
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
@Service("autoayudaServiceNeg")
public class AutoayudaServiceNegImpl implements AutoayudaServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(AutoayudaServiceNegImpl.class);
    
    @Inject
    AutoayudaDAO autoayudaDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<AutoayudaDTO> listarAutoayuda(AutoayudaFilter filtro){
        List<AutoayudaDTO> retorno=null;
        try{
            retorno = autoayudaDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarAutoayuda",ex);
        }
        return retorno;
    }
    
    @Override
    @Transactional
    public AutoayudaDTO editarAutoayuda(AutoayudaDTO autoayudaDTO,UsuarioDTO usuarioDTO){
        LOG.info("editarAutoayuda");
        AutoayudaDTO registro=null;
        try{
            registro=autoayudaDAO.update(autoayudaDTO,usuarioDTO);
            LOG.info("(Actualizar Base Legal ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("error editarAutoayuda",ex);
        }
        return registro;
    }
}
