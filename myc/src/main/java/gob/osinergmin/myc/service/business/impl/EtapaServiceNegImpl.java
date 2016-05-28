/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaFilter;
import gob.osinergmin.myc.service.business.EtapaServiceNeg;
import gob.osinergmin.myc.service.dao.EtapaDAO;
import gob.osinergmin.myc.service.exception.EtapaException;
import gob.osinergmin.myc.util.Constantes;
import java.util.HashMap;
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
@Service("EtapaServiceNeg")
public class EtapaServiceNegImpl implements EtapaServiceNeg {
    private static final Logger LOG = LoggerFactory.getLogger(EtapaServiceNegImpl.class);
    @Inject
    private EtapaDAO etapaDAO;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<EtapaDTO> listarEtapaByDescProceso(String descProceso){
        LOG.info("Neg listarEtapaByDescProceso");
        List<EtapaDTO> retorno=null;
        try{
            HashMap resultado = new HashMap();
            
            EtapaFilter filtro=new EtapaFilter();
            filtro.setDescProceso(descProceso);
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            resultado = etapaDAO.listarEtapa(filtro);
            retorno = (List<EtapaDTO>)resultado.get("listado");
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    @Override
    @Transactional(readOnly = true)
    public List<EtapaDTO> findEtapaByFilter(EtapaFilter filtro, int[] cuenta){
        LOG.info("Neg listarEtapaPreOperativo");
        List<EtapaDTO> retorno=null;
        try{
            HashMap resultado = new HashMap();
            
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            resultado = etapaDAO.listarEtapa(filtro);
            retorno = (List<EtapaDTO>)resultado.get("listado");
            Long contador = (Long)resultado.get("cuenta");
            cuenta[0] = contador.intValue();
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    @Transactional
    public EtapaDTO guardarEtapa(EtapaDTO etapaDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Etapa ServiceNegImpl");
        EtapaDTO registro = null;
        try{
            registro = etapaDAO.create(etapaDTO, usuarioDTO);
            LOG.info("(Registro Etapa ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }

    @Override
    @Transactional(rollbackFor=EtapaException.class)
    public EtapaDTO eliminarEtapa(EtapaDTO etapaDTO) throws EtapaException {
        LOG.info("Eliminar Etapa ServiceNegImpl");
        EtapaDTO eliminar = null;
        try{
            eliminar = etapaDAO.changeState(etapaDTO, Constantes.CONSTANTE_ESTADO_INACTIVO);
            LOG.info("(Eliminar Etapa ServiceNegImpl) eliminar: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("Error eliminarEtapa",ex);
            throw new EtapaException(ex.getMessage(),null);
        }
        return eliminar;
    }
	@Override
	public List<EtapaDTO> listarEtapaById(Long idProceso) {
		LOG.info("Neg listarEtapaPreOperativo");
        List<EtapaDTO> retorno=null;
        try{
        	retorno = etapaDAO.listarEtapaById(idProceso);

        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}
        
    @Override
    public List<EtapaDTO> listEtapaDetailById(Long idProceso) {
        LOG.info("Neg listarEtapaPreOperativo");
        List<EtapaDTO> retorno=null;
        try{
            retorno = etapaDAO.listEtapaDetailById(idProceso);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@Override
	 @Transactional(readOnly=true)
	public List<EtapaDTO> validarEtapa(EtapaDTO etapaDTO) {
		LOG.info("Neg validarParametro");
        List<EtapaDTO> retorno=null;
        try{
        	retorno = etapaDAO.validarEtapa(etapaDTO);

        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}
}