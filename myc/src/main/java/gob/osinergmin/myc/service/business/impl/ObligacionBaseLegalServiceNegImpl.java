/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionBaseLegalFilter;
import gob.osinergmin.myc.service.business.ObligacionBaseLegalServiceNeg;
import gob.osinergmin.myc.service.dao.ObligacionBaseLegalDAO;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lbarboza
 */
@Service("ObligacionBaseLegalServiceNegImpl")
public class ObligacionBaseLegalServiceNegImpl implements ObligacionBaseLegalServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(ObligacionBaseLegalServiceNegImpl.class);
    
    @Inject
    private ObligacionBaseLegalDAO obligacionBaseLegalDAO;

    @Override
    @Transactional
    public ObligacionBaseLegalDTO guardaObligacionBaseLegal(ObligacionBaseLegalDTO obligacionBaseLegalDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Obligacion Base Legal ServiceNegImpl");
        ObligacionBaseLegalDTO registro = null;
        try{
            registro = obligacionBaseLegalDAO.create(obligacionBaseLegalDTO, usuarioDTO);
            LOG.info("(Registro Obligacion Base Legal ServiceNegImpl) registro: "+registro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }

    @Override
    @Transactional
    public ObligacionBaseLegalDTO eliminarObligacionBaseLegal(ObligacionBaseLegalDTO obligacionBaseLegalDTO) {
        LOG.info("Eliminar Obligacion Base Legal ServiceNegImpl");
        ObligacionBaseLegalDTO eliminar = null;
        try{
            eliminar = obligacionBaseLegalDAO.changeState(obligacionBaseLegalDTO);
            LOG.info("(Eliminar Obligacion Base Legal ServiceNegImpl) registro: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return eliminar;
    }

    @Override
    @Transactional
    public List<ObligacionBaseLegalDTO> listarObligacionBaseLegal(ObligacionBaseLegalFilter filtro, int[] cuenta) {
        LOG.info("Funcion: Listar Obligacion Base Legal-- Service Impl -- Clase: listarObligacionBaseLegal");
        List<ObligacionBaseLegalDTO> listado = null;
        try{
            cuenta[0] = obligacionBaseLegalDAO.count(filtro).intValue();
            LOG.info("cuenta: "+cuenta[0]);
            if(cuenta[0] > 0){
                listado = obligacionBaseLegalDAO.find(filtro);
                LOG.info("Funcion: numero de registros en el listado: "+listado.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return listado;
    }

	@Override
	@Transactional
	public ObligacionBaseLegalDTO eliminarBaseLegalAsociada(
			ObligacionBaseLegalDTO oblgBaseLegal, UsuarioDTO usuarioDTO) {
		LOG.info("Eliminar Obligacion Base Legal ServiceNegImpl");
        ObligacionBaseLegalDTO eliminar = null;
        try{
            eliminar = obligacionBaseLegalDAO.changeState(oblgBaseLegal,usuarioDTO);
            LOG.info("(Eliminar Obligacion Base Legal ServiceNegImpl) registro: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return eliminar;
	}
    
    
}