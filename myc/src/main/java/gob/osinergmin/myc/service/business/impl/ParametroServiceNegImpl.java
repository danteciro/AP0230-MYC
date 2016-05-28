/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.in.GuardarParametroDinamicoInRO;
import gob.osinergmin.myc.domain.out.GuardarParametroDinamicoOutRO;
import gob.osinergmin.myc.domain.ui.ParametroFilter;
import gob.osinergmin.myc.domain.ui.ValorParametroFilter;
import gob.osinergmin.myc.service.business.ParametroServiceNeg;
import gob.osinergmin.myc.service.dao.ParametroDinamicoDAO;
import gob.osinergmin.myc.service.dao.ValorParametroDAO;

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
@Service
public class ParametroServiceNegImpl implements ParametroServiceNeg {
    private static final Logger LOG = LoggerFactory.getLogger(ParametroServiceNegImpl.class);
    @Inject
    private ParametroDinamicoDAO parametroDAO;
    @Inject
    private ValorParametroDAO valorParametroDAO;
    
    @Override
    @Transactional(readOnly=true)
    public List<ParametroDinamicoDTO> listarParametrosValores(ParametroFilter filtro){
        LOG.info("listarParametrosValores - inicio");
        List<ParametroDinamicoDTO> retorno=null;
        try{           
            retorno = parametroDAO.find(filtro);
            for(ParametroDinamicoDTO regMaestro : retorno){
                List<ValorParametroDTO> valoresReg=valorParametroDAO.findValorParametro(new ValorParametroFilter(regMaestro.getIdParametroDinamico()));
                regMaestro.setValores(valoresReg);
            }
        }catch(Exception e){
            LOG.error(e.getMessage());
        }
        LOG.info("listarParametrosValores - fin");
        return retorno;
    }
    
    @Override
    public List<ParametroDinamicoDTO> listarParametro(ParametroFilter filtro, int[] cuenta){
        List<ParametroDinamicoDTO> retorno=null;
        try{                   	
        	 cuenta[0] = parametroDAO.count(filtro).intValue();
             if (cuenta[0] > 0) {
                 retorno = parametroDAO.find(filtro);
                 LOG.info("cuenta -size: "+retorno.size());
             }
        }catch(Exception e){
            LOG.error(e.getMessage());
        }
        return retorno;
    }
    
    @Override
    @Transactional
	public GuardarParametroDinamicoOutRO guardarParametroDinamico(GuardarParametroDinamicoInRO in) {
		GuardarParametroDinamicoOutRO retorno = new GuardarParametroDinamicoOutRO();
		try{
		
			ParametroDinamicoDTO registro= parametroDAO.create(in.getParametro(), in.getUsuario());
			retorno.setParametro(registro);
			retorno.setMensaje("ok");
			retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
			
		}catch(Exception ex){
			LOG.error("error guardarParametroDinamico", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
		}
		
		return retorno;
	}

	@Override
	@Transactional
	public GuardarParametroDinamicoOutRO eliminarParametroDinamico(
			GuardarParametroDinamicoInRO in) {
		GuardarParametroDinamicoOutRO retorno = new GuardarParametroDinamicoOutRO();
		try{
		
			ParametroDinamicoDTO registro= parametroDAO.changeEstado(in.getParametro(), in.getUsuario());
			retorno.setParametro(registro);
			retorno.setMensaje("ok");
			retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
			
		}catch(Exception ex){
			LOG.error("error eliminarParametroDinamico", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
		}
		
		return retorno;
	}
	
	@Override
	@Transactional
	public GuardarParametroDinamicoOutRO editarParametroDinamico(
			GuardarParametroDinamicoInRO in) {
		GuardarParametroDinamicoOutRO retorno = new GuardarParametroDinamicoOutRO();
		try{
		
			ParametroDinamicoDTO registro= parametroDAO.editar(in.getParametro(), in.getUsuario());
			retorno.setParametro(registro);
			retorno.setMensaje("ok");
			retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
			
		}catch(Exception ex){
			LOG.error("error editarParametroDinamico", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
		}
		
		return retorno;
	}
	
    @Override
    public List<ParametroDinamicoDTO> obtenerDependencias(ParametroFilter filtro){
    	GuardarParametroDinamicoOutRO retorno=new GuardarParametroDinamicoOutRO();
    	List<ParametroDinamicoDTO> listado=null;
        try{
            listado = parametroDAO.obtenerDependencias(filtro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("",ex.getMessage());
            
        }
        return listado;
    }

    @Override
    public List<ParametroDinamicoDTO> obtenerDependenciasValores(ParametroFilter filtro){
    	GuardarParametroDinamicoOutRO retorno=new GuardarParametroDinamicoOutRO();
    	List<ParametroDinamicoDTO> listado=null;
        try{
            listado = parametroDAO.obtenerDependenciasValores(filtro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("",ex.getMessage());
            
        }
        return listado;
    }
    
    @Override
    public List<ParametroDinamicoDTO> verificarOtrosParametros(ParametroFilter filtro){
    	GuardarParametroDinamicoOutRO retorno=new GuardarParametroDinamicoOutRO();
    	List<ParametroDinamicoDTO> listado=null;
        try{
            listado = parametroDAO.verificarOtrosParametros(filtro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("",ex.getMessage());
            
        }
        return listado;
    }

    @Override
	public long obtenerIdDinamico() {
		long valorParametro = 0;
		
		try{
			valorParametro = parametroDAO.obtenerIdDinamico();
		}catch(Exception excepcion){
			LOG.error("error obtenerIdDinamico: " + excepcion.getMessage());
		}
		return valorParametro;
	}
	
}
