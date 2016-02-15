package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcTramActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.in.GuardarProcedimientoInRO;
import gob.osinergmin.myc.domain.in.GuardarTramiteActividadInRO;
import gob.osinergmin.myc.domain.out.GuardarProcedimientoOutRO;
import gob.osinergmin.myc.domain.out.GuardarTramiteActividadOutRO;
import gob.osinergmin.myc.domain.ui.ProcedimientoFilter;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.domain.ui.ValorParametroFilter;
import gob.osinergmin.myc.service.business.TramiteActividadServiceNeg;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.dao.TramiteActividadDAO;
import gob.osinergmin.myc.service.exception.ProcedimientoException;
import gob.osinergmin.myc.service.exception.TramiteActividadException;
import gob.osinergmin.myc.util.Constantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
*
* @author jpiro
*/
@Service("TramiteActividadServiceNeg")
public class TramiteActividadServiceNegImpl implements   TramiteActividadServiceNeg {

	@Inject
	private TramiteActividadDAO tramiteActividadDAO;
	
	private static final Logger LOG = LoggerFactory.getLogger(TramiteActividadServiceNegImpl.class);
	
	
    @Override
    @Transactional(readOnly=true)
    public TramiteActividadDTO buscarTramiteActividadByFiltro(TramiteActividadFilter filtro){
        LOG.info("Neg buscarTramiteActividadByFiltro");
        TramiteActividadDTO retorno=null;
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            retorno = tramiteActividadDAO.findById(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	
	@Override
    public List<TramiteActividadDTO> listarTramiteActividad(TramiteActividadFilter filtro, int[] cuenta){
        List<TramiteActividadDTO> retorno=null;
        try{
            
            //TEMPORAL data de prueba
            retorno= new ArrayList<TramiteActividadDTO>();
            ValorParametroDTO fila;
            
            Map<Long,List<String[]>> data=new HashMap<Long,List<String[]>>();
            
            List<String[]> reg=new ArrayList<String[]>();
            
	       	 cuenta[0] = tramiteActividadDAO.count(filtro).intValue();
	         if (cuenta[0] > 0) {
	             retorno = tramiteActividadDAO.find(filtro);
	             LOG.info("cuenta -size: "+retorno.size());
	         }
            
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return retorno;
	}
	
	
    @Override
    @Transactional(rollbackFor=TramiteActividadException.class)
    public GuardarTramiteActividadOutRO guardarTramiteActividad(GuardarTramiteActividadInRO in) throws TramiteActividadException{
    	GuardarTramiteActividadOutRO retorno=new GuardarTramiteActividadOutRO();
        try{
        	TramiteActividadDTO registro=new TramiteActividadDTO();//procedimientoDAO.create(in.getProcedimiento(),in.getUsuario());
            
            List<TramiteDTO> tramites=in.getIdTramiteActividad().getTramites();
            List<TramiteDTO> regTramites=new ArrayList<TramiteDTO>();
            LOG.info("acti-->"+in.getIdTramiteActividad().getActividades());
            List<ActividadDTO> actividades=null;
            if(in.getIdTramiteActividad().getActividades()!=null){
                actividades=in.getIdTramiteActividad().getActividades();
            }
            //inserta tramites
            for (TramiteDTO maestro : tramites) {
                LOG.info("idTramite-->"+maestro.getIdTramite());
                //TramiteActividadDTO pt=new TramiteActividadDTO(registro.getIdTramiteActivdad(),maestro.getIdTramite(),Constantes.CONSTANTE_ESTADO_ACTIVO);
               
                //inserta actividades
                if(actividades!=null){
                    for(ActividadDTO maestroAct : actividades){                        
                    	TramiteActividadDTO pta=new TramiteActividadDTO(registro.getIdTramiteActivdad(),maestro.getIdTramite(),maestroAct.getIdActividad(),Constantes.CONSTANTE_ESTADO_ACTIVO);
                    	TramiteActividadDTO regSave=tramiteActividadDAO.create(pta, in.getUsuario());
                    	LOG.info("PTA registrado, idProTram - idAct= "+ maestroAct.getIdActividad() +" - "+ maestro.getIdTramite()+"-"+regSave);
                    	
                    }
                }                
            }            
            registro.setTramites(regTramites);
            
            retorno.setIdTramiteActividad(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en guardarProcedimiento:"+ex.getMessage());
            throw new TramiteActividadException(ex.getMessage(),null);
        }
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=TramiteActividadException.class)
    public GuardarTramiteActividadOutRO editarTramiteActividad(GuardarTramiteActividadInRO in) throws TramiteActividadException{
    	GuardarTramiteActividadOutRO retorno=new GuardarTramiteActividadOutRO();
        try{
        	TramiteActividadDTO registro=new TramiteActividadDTO();//procedimientoDAO.create(in.getProcedimiento(),in.getUsuario());
        	
           
            TramiteActividadDTO registroTramActiv=  tramiteActividadDAO.updateVerificado(in.getIdTramiteActividad(), in.getUsuario());
            retorno.setIdTramiteActividad(registroTramActiv);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en editarProcedimiento:"+ex.getMessage());
            throw new TramiteActividadException(ex.getMessage(),null);
        }
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=TramiteActividadException.class)
    public GuardarTramiteActividadOutRO eliminarTramiteActividad(GuardarTramiteActividadInRO in){
    	GuardarTramiteActividadOutRO retorno=new GuardarTramiteActividadOutRO();
        try{
        	TramiteActividadDTO registro=new TramiteActividadDTO();//procedimientoDAO.create(in.getProcedimiento(),in.getUsuario());        	
           
            TramiteActividadDTO registroTramActiv=  tramiteActividadDAO.changeState(in.getIdTramiteActividad(), in.getUsuario());
            retorno.setIdTramiteActividad(registroTramActiv);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en editarProcedimiento:"+ex.getMessage());
        }
        return retorno;
    }
}
