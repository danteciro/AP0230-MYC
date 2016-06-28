/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.IncumplimientoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.business.IncumplimientoServiceNeg;
import gob.osinergmin.myc.service.dao.IncumplimientoDAO;
import gob.osinergmin.myc.service.dao.InfraccionDAO;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rcoloradoa
 */
@Service("IncumplimientoServiceNegImpl")
public class IncumplimientoServiceNegImpl implements IncumplimientoServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(IncumplimientoServiceNegImpl.class);
    
    @Inject
    private InfraccionDAO infraccionDAO;   
    
    @Inject
    private IncumplimientoDAO incumplimientoDAO;
    
    @Override
    @Transactional
    public IncumplimientoDTO guardaIncumplimiento(IncumplimientoDTO incumplimientoDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Infraccion ServiceNegImpl");
        IncumplimientoDTO registro = null;
        try{            
            registro = incumplimientoDAO.create(incumplimientoDTO, usuarioDTO);                            
                registro.setId_infraccion(incumplimientoDTO.getId_infraccion());                          
            LOG.info("(Registro Detalle Obligacion ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }

    
    @Override
    @Transactional
    public List<IncumplimientoDTO> listarIncumplimientos(Long idInfraccion) {
        LOG.info("Funcion: Listar Tipificacion-- Service Impl -- Clase: listarTipificacion");
        LOG.info("-- idObligacion = "+idInfraccion);
        IncumplimientoDTO incumplimientoDTO = new IncumplimientoDTO();
        incumplimientoDTO.setId_infraccion(idInfraccion);
        return incumplimientoDAO.findIncumplimientos(incumplimientoDTO);
    }
    
	@Override
    @Transactional
    public List<IncumplimientoDTO> listarIncumplimiento(Long idInfraccion,Long idMaestroincumplimiento) {
        LOG.info("Funcion: Listar Tipificacion-- Service Impl -- Clase: listarTipificacion");
        LOG.info("-- idObligacion = "+idMaestroincumplimiento);
        IncumplimientoDTO incumplimientoDTO = new IncumplimientoDTO();
        incumplimientoDTO.setId_esce_incu_maestro(idMaestroincumplimiento);
        incumplimientoDTO.setId_infraccion(idInfraccion);
        
        return incumplimientoDAO.findIncumplimiento(incumplimientoDTO);
    }
	
	@Override
    @Transactional
    public IncumplimientoDTO eliminarIncumplimiento(IncumplimientoDTO incumplimientoDTO,UsuarioDTO usuarioDTO) {
        LOG.info("Funcion: Listar Tipificacion-- Service Impl -- Clase: listarTipificacion");
        LOG.info("-- idObligacion = "+incumplimientoDTO.getId_esce_incumplimiento());        
        return incumplimientoDAO.eliminarIncumplimiento(incumplimientoDTO,usuarioDTO);
    }
	
    
}