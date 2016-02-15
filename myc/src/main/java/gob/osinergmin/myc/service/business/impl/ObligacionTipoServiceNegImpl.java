package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.in.GuardarObligacionTipoInRO;
import gob.osinergmin.myc.domain.out.GuardarObligacionTipoOutRO;

import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;

import gob.osinergmin.myc.service.business.ObligacionTipoServiceNeg;
import gob.osinergmin.myc.service.dao.CnfObligacionDAO;
import gob.osinergmin.myc.service.dao.ObligacionTipoDAO;
import gob.osinergmin.myc.service.exception.ObligacionTipoException;
import gob.osinergmin.myc.util.Constantes;


import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ObligacionTipoServiceNeg")
public class ObligacionTipoServiceNegImpl implements  ObligacionTipoServiceNeg{

	private static final Logger LOG = LoggerFactory.getLogger(ObligacionTipoServiceNegImpl.class);
	@Inject 
	private ObligacionTipoDAO obligacionTipoDAO;
	
	@Inject 
	private CnfObligacionDAO cnfObligacionDAO;
	
    @Override
    public List<ObligacionTipoDTO> listarObligacion(){
        List<ObligacionTipoDTO> retorno=null;
        try{
        	ObligacionTipoFilter filtro=new ObligacionTipoFilter();
        	filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO); 
        	filtro.setNombre("");
        	 retorno = obligacionTipoDAO.listarObligacionTipo(filtro);       
            
         
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return retorno;
	}
	
	
    public List<ObligacionTipoDTO> listarObligacionTipo(ObligacionTipoFilter filtro, int[] cuenta){
        List<ObligacionTipoDTO> retorno=null;
        try{
        	 filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO); 
        	 cuenta[0] = obligacionTipoDAO.count(filtro).intValue();
	         if (cuenta[0] > 0) {
	        	 retorno = obligacionTipoDAO.obtenerObligacionTipo(filtro);
	             LOG.info("cuenta -size: "+retorno.size());
	         }
            
         
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return retorno;
	}
	
    @Override
    @Transactional(rollbackFor=ObligacionTipoException.class)
    public GuardarObligacionTipoOutRO guardarObligacionTipo(GuardarObligacionTipoInRO in) throws ObligacionTipoException {
        GuardarObligacionTipoOutRO retorno = new GuardarObligacionTipoOutRO();
        try{
            ObligacionTipoDTO registro=new ObligacionTipoDTO(); 
            ObligacionTipoDTO registroObli=in.getObligacionTipo();
            //for(ObligacionTipoDTO registroObli: in.getFiltro().getObligaciones()){
            registroObli.setIdObligacionTipo(null);
            registroObli.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            String nombre =registroObli.getNombre().replaceAll(" +", " ");            
            registroObli.setNombre(nombre);
            registro= obligacionTipoDAO.create(registroObli, in.getUsuario());//parametroDAO.create(in.getParametro(), in.getUsuario());
            //}
            retorno.setObligacionTipo(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);

        }catch(Exception ex){
            LOG.error("error guardarObligacionTipo", ex);
            throw new ObligacionTipoException(ex.getMessage(),null);
        }
        return retorno;
    }

    @Override
    @Transactional(rollbackFor=ObligacionTipoException.class)
    public GuardarObligacionTipoOutRO editarObligacionTipo(GuardarObligacionTipoInRO in) throws ObligacionTipoException {
        GuardarObligacionTipoOutRO retorno = new GuardarObligacionTipoOutRO();
        try{
            ObligacionTipoDTO registroObli=in.getObligacionTipo();
            //for(ObligacionTipoDTO registroObli: in.getFiltro().getObligaciones()){
            registroObli.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            String nombre =registroObli.getNombre().replaceAll(" +", " ");            
            registroObli.setNombre(nombre);
            ObligacionTipoDTO registro= obligacionTipoDAO.editar(registroObli,in.getUsuario());//parametroDAO.create(in.getParametro(), in.getUsuario());
            //}
            //retorno.setObligacionTipo(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);

        }catch(Exception ex){
            LOG.error("error guardarObligacionTipo", ex);
            throw new ObligacionTipoException(ex.getMessage(),null);
        }
        return retorno;
    }
	 
        @Override
        @Transactional(rollbackFor=ObligacionTipoException.class)
        public GuardarObligacionTipoOutRO eliminarObligacionTipo(GuardarObligacionTipoInRO in) throws ObligacionTipoException {
        GuardarObligacionTipoOutRO retorno = new GuardarObligacionTipoOutRO();
            try{			
                ObligacionTipoDTO registro= obligacionTipoDAO.changeEstado(in.getObligacionTipo(),in.getUsuario());//parametroDAO.create(in.getParametro(), in.getUsuario());
                retorno.setObligacionTipo(registro);
                retorno.setMensaje("ok");
                retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);		
            }catch(Exception ex){
                LOG.error("Error guardarObligacionTipo",ex);
                throw new ObligacionTipoException(ex.getMessage(),null);
            }
            return retorno;
        }


		@Override
		public List<ObligacionTipoDTO> listarObligacionTipoConf() {
			List<ObligacionTipoDTO> retorno=null;
	        try{
	        	ObligacionTipoFilter filtro=new ObligacionTipoFilter();
	        	filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO); 
	        	 retorno = cnfObligacionDAO.findObligacionTipoConfig(filtro);       
	            
	         
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        }
			return retorno;
		}
}
