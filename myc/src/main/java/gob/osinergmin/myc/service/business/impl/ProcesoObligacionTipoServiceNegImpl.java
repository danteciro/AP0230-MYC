package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.in.GuardarProcesoObligacionTipoInRO;
import gob.osinergmin.myc.domain.in.GuardarTramiteActividadInRO;
import gob.osinergmin.myc.domain.out.GuardarProcesoObligacionTipoOutRO;
import gob.osinergmin.myc.domain.out.GuardarTramiteActividadOutRO;
import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;
import gob.osinergmin.myc.domain.ui.ProcesoObligacionTipoFilter;
import gob.osinergmin.myc.service.business.ProcesoObligacionTipoServiceNeg;
import gob.osinergmin.myc.service.dao.ProcesoObligacionTipoDAO;
import gob.osinergmin.myc.service.exception.ProcesoObligacionTipoException;
import gob.osinergmin.myc.service.exception.TramiteActividadException;
import gob.osinergmin.myc.util.Constantes;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("ProcesoObligacionTipoServiceNeg")
public class ProcesoObligacionTipoServiceNegImpl implements ProcesoObligacionTipoServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(ProcesoObligacionTipoServiceNegImpl.class);
	@Inject 
	private ProcesoObligacionTipoDAO procesoObligacionTipoDAO;
	@Override
    public List<ProcesoObligacionTipoDTO> listarProcesoObligacionTipo(ProcesoObligacionTipoFilter filtro, int[] cuenta){
        List<ProcesoObligacionTipoDTO> retorno=null;
        try{
        	 filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO); 
        	 cuenta[0] = procesoObligacionTipoDAO.count(filtro).intValue();
	         if (cuenta[0] > 0) {
	        	 retorno = procesoObligacionTipoDAO.obtenerProcesoObligacionTipo(filtro);
	             LOG.info("cuenta -size: "+retorno.size());
	         }
            
         
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return retorno;
	}
	
    @Override
    @Transactional(rollbackFor=ProcesoObligacionTipoException.class)
    public GuardarProcesoObligacionTipoOutRO guardarProcesoObligacionTipo(GuardarProcesoObligacionTipoInRO in) throws ProcesoObligacionTipoException{
    	GuardarProcesoObligacionTipoOutRO retorno=new GuardarProcesoObligacionTipoOutRO();
        try{
            //ProcesoObligacionTipoDTO registro=new ProcesoObligacionTipoDTO();//procedimientoDAO.create(in.getProcedimiento(),in.getUsuario());
            ProcesoObligacionTipoDTO registro=in.getProcesoObligacionTipo();
            LOG.info("acti-->"+in.getProcesoObligacionTipo().getActividades());
            List<ActividadDTO> actividades=null;
            if(in.getProcesoObligacionTipo().getActividades()!=null){
                actividades=in.getProcesoObligacionTipo().getActividades();
            }
              
            //inserta actividades
            if(actividades!=null){
                for(ActividadDTO maestroAct : actividades){                        
                    ProcesoObligacionTipoDTO pta=new ProcesoObligacionTipoDTO(registro.getIdProOblTip(),registro.getIdObligacionTipo(),registro.getIdProceso(),maestroAct.getIdActividad(),Constantes.CONSTANTE_ESTADO_ACTIVO);
                    ProcesoObligacionTipoDTO regSave=procesoObligacionTipoDAO.create(pta, in.getUsuario());
                    LOG.info("PTA registrado, idProTram - idAct= "+ maestroAct.getIdActividad() +"-"+regSave);

                }
            }                
                        
            registro.setActividades(actividades);
            
            retorno.setProcesoObligacionTipo(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en guardarProcedimiento:"+ex.getMessage());
            throw new ProcesoObligacionTipoException(ex.getMessage(),null);
        }
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=ProcesoObligacionTipoException.class)
    public GuardarProcesoObligacionTipoOutRO editarProcesoObligacionTipo(GuardarProcesoObligacionTipoInRO in) throws ProcesoObligacionTipoException{
    	GuardarProcesoObligacionTipoOutRO retorno=new GuardarProcesoObligacionTipoOutRO();
        try{
            ProcesoObligacionTipoDTO registro=in.getProcesoObligacionTipo();
            LOG.info("acti-->"+in.getProcesoObligacionTipo().getActividades());
            List<ActividadDTO> actividades=null;
            if(in.getProcesoObligacionTipo().getActividades()!=null){
                actividades=in.getProcesoObligacionTipo().getActividades();
            }
              
            //inserta actividades
            if(actividades!=null){
                for(ActividadDTO maestroAct : actividades){                        
                    ProcesoObligacionTipoDTO pta=new ProcesoObligacionTipoDTO(registro.getIdProOblTip(),registro.getIdObligacionTipo(),registro.getIdProceso(),maestroAct.getIdActividad(),Constantes.CONSTANTE_ESTADO_ACTIVO);
                    ProcesoObligacionTipoDTO regSave=procesoObligacionTipoDAO.edit(pta, in.getUsuario());
                }
            }                
                        
            registro.setActividades(actividades);
            
            retorno.setProcesoObligacionTipo(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en guardarProcedimiento",ex);
            throw new ProcesoObligacionTipoException(ex.getMessage(),null);
        }
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=ProcesoObligacionTipoException.class)
    public GuardarProcesoObligacionTipoOutRO eliminarProcesoObligacionTipo(GuardarProcesoObligacionTipoInRO in) throws ProcesoObligacionTipoException{
    	GuardarProcesoObligacionTipoOutRO retorno=new GuardarProcesoObligacionTipoOutRO();
        try{
            ProcesoObligacionTipoDTO regUpd=procesoObligacionTipoDAO.changeState(in.getProcesoObligacionTipo(), in.getUsuario());                
            retorno.setProcesoObligacionTipo(regUpd);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en guardarProcedimiento:"+ex.getMessage());
            throw new ProcesoObligacionTipoException(ex.getMessage(),null);
        }
        return retorno;
    }
    
	
}
