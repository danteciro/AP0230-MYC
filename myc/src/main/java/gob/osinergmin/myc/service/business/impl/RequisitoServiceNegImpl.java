/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import gob.osinergmin.myc.domain.in.GuardarRequisitoInRO;
import gob.osinergmin.myc.domain.out.GuardarRequisitoOutRO;
import gob.osinergmin.myc.domain.ui.RequisitoFilter;
import gob.osinergmin.myc.service.business.RequisitoServiceNeg;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
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
@Service("requisitoServiceNeg")
public class RequisitoServiceNegImpl implements RequisitoServiceNeg {
    private static final Logger LOG = LoggerFactory.getLogger(RequisitoServiceNegImpl.class);
    
    @Inject
    private RequisitoDAO requisitoDAO;
    
    @Override
    @Transactional
    public GuardarRequisitoOutRO eliminarRequisito(GuardarRequisitoInRO in){
        GuardarRequisitoOutRO retorno=new GuardarRequisitoOutRO();
        try{
            RequisitoDTO registro=requisitoDAO.changeEstado(in.getRequisito(),in.getUsuario());
            
            retorno.setRequisito(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("error guardarRequisito", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }
        return retorno;
    }
    
    @Override
    @Transactional
    public GuardarRequisitoOutRO editarRequisito(GuardarRequisitoInRO in){
        GuardarRequisitoOutRO retorno=new GuardarRequisitoOutRO();
        try{
            RequisitoDTO registro=requisitoDAO.edit(in.getRequisito(),in.getUsuario());
            
            retorno.setRequisito(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("error guardarRequisito", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }
        return retorno;
    }
    
    @Override
    @Transactional
    public GuardarRequisitoOutRO guardarRequisito(GuardarRequisitoInRO in){
        GuardarRequisitoOutRO retorno=new GuardarRequisitoOutRO();
        try{     	        	
        	
            RequisitoDTO registro=requisitoDAO.create(in.getRequisito(),in.getUsuario());
            
            retorno.setRequisito(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("error guardarRequisito", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }
        return retorno;
    }
    
    @Override
    public List<RequisitoDTO> verificaRequisitoSimilar(RequisitoFilter filtro){
        List<RequisitoDTO> retorno=null;
        try{
            retorno = requisitoDAO.verificaRequisitoSimilar(filtro);
        }catch(Exception ex){
            LOG.error("",ex.getMessage());
        }
        return retorno;
    }  
    
    @Override
    public List<RequisitoDTO> validarRequisitoIdentico(RequisitoFilter filtro){
        List<RequisitoDTO> retorno=null;
        try{
            retorno = requisitoDAO.validarRequisitoIdentico(filtro);
        }catch(Exception ex){
            LOG.error("",ex.getMessage());
        }
        return retorno;
    }  
    @Override
    public List<CnfRequProcedimientoDTO> obtenerDependencias(RequisitoFilter filtro){
    	GuardarRequisitoOutRO retorno=new GuardarRequisitoOutRO();
    	List<CnfRequProcedimientoDTO> listado=null;
        try{
            listado = requisitoDAO.obtenerDependencias(filtro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("",ex.getMessage());
            
        }
        return listado;
    }
    
    @Override
    @Transactional 
    public RequisitoDTO buscarRequisitoByFiltro(RequisitoFilter filtro){
        LOG.info("Neg buscarRequisitoByFiltro");
        RequisitoDTO retorno=null;
        try{
            retorno = requisitoDAO.find(filtro).get(0);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    @Transactional 
    public List<RequisitoDTO> listarRequisito(RequisitoFilter filtro,int[] cuenta){
        LOG.info("Neg listarRequisito");
        List<RequisitoDTO> retorno=null;
        try{
            cuenta[0] = requisitoDAO.count(filtro).intValue();
            if (cuenta[0] > 0) {
                retorno = requisitoDAO.find(filtro);
                LOG.info("cuenta -size: "+retorno.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    

   
}
