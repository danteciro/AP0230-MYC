/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.in.GuardarRubroOpcionInRO;
import gob.osinergmin.myc.domain.out.GuardarRubroOpcionOutRO;
import gob.osinergmin.myc.domain.ui.OpcionFilter;
import gob.osinergmin.myc.domain.ui.RubroOpcionFilter;
import gob.osinergmin.myc.service.business.RubroOpcionServiceNeg;
import gob.osinergmin.myc.service.dao.OpcionDAO;
import gob.osinergmin.myc.service.dao.RubroOpcionDAO;
import gob.osinergmin.myc.service.exception.RubroOpcionException;
import gob.osinergmin.myc.service.exception.TramiteActividadException;
import gob.osinergmin.myc.util.Constantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jsifuentes
 */
@Service("RubroOpcionServiceNeg")
public class RubroOpcionServiceNegImpl implements RubroOpcionServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(RubroOpcionServiceNegImpl.class);
    @Inject
    private OpcionDAO opcionDAO;
    
    @Inject
    private RubroOpcionDAO rubroOpcionDAO;
    
    @Override
    public List<OpcionDTO> listarOpciones(OpcionFilter filtro, int[] cuenta){
        LOG.info("Neg listarOpciones");
        List<OpcionDTO> retorno=null;
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            filtro.setAplicacion(Constantes.CONSTANTE_APLICAION_MYC);
            cuenta[0] = opcionDAO.count(filtro).intValue();
            if (cuenta[0] > 0) {
                retorno = opcionDAO.find(filtro);
                LOG.info("cuenta -size: "+retorno.size());
            }
            //retorno = actividadDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=RubroOpcionException.class)
    public GuardarRubroOpcionOutRO guardarRubroOpcion(GuardarRubroOpcionInRO in) throws RubroOpcionException{
    	GuardarRubroOpcionOutRO retorno=new GuardarRubroOpcionOutRO();
        try{
        	RubroOpcionDTO registro=new RubroOpcionDTO();
        	OpcionFilter opcionFilter = new OpcionFilter();
        	opcionFilter.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        	opcionFilter.setIdActividad(in.getIdRubroOpcion().getIdActividad());
        	boolean encontro=false;
            
        	List<OpcionDTO> opcionesBD =  opcionDAO.find(opcionFilter);
        	List<OpcionDTO> opcionesMant =  in.getIdRubroOpcion().getOpciones();
			
			//registrar rubro opcion nueva
        	for (OpcionDTO opcionMant : opcionesMant) {
        		
        		for (OpcionDTO opcionBD : opcionesBD) {
        			// si no lo encontro
        			if (opcionMant.getIdOpcion() == opcionBD.getIdOpcion()){
        				encontro = true;
        			}
				}
			}
        	
        	List<OpcionDTO> opciones=null;
            if(in.getIdRubroOpcion().getOpciones()!=null){
            	opciones=in.getIdRubroOpcion().getOpciones();
            }
            
            //inserta opciones
            if(!encontro){
                for(OpcionDTO maestro : opciones){
                	RubroOpcionDTO pta=new RubroOpcionDTO(registro.getIdRubroOpcion(),Constantes.CONSTANTE_ESTADO_ACTIVO, maestro.getIdOpcion(),in.getIdRubroOpcion().getIdActividad());
                	RubroOpcionDTO regSave=rubroOpcionDAO.create(pta, in.getUsuario());
                	retorno.setMensaje("ok");
                    retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
                }
            }
            else{
            	retorno.setMensaje("Existe una configuraci&oacute;n registrada para esta actividad");
                retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);
            }
        }catch (Exception ex) {
            LOG.error("Error en guardarRubroOpcion:"+ex.getMessage());
            throw new RubroOpcionException(ex);
        }
        return retorno;
    }
    
    @Override
    public List<RubroOpcionDTO> listarRubroOpcion(RubroOpcionFilter filtro, int[] cuenta){
        List<RubroOpcionDTO> retorno=null;
        try{
            
            //TEMPORAL data de prueba
            retorno= new ArrayList<RubroOpcionDTO>();
            ValorParametroDTO fila;
            
            Map<Long,List<String[]>> data=new HashMap<Long,List<String[]>>();
            
            List<String[]> reg=new ArrayList<String[]>();
            
	       	 cuenta[0] = rubroOpcionDAO.count(filtro).intValue();
	         if (cuenta[0] > 0) {
	             retorno = rubroOpcionDAO.find(filtro);
	             LOG.info("cuenta -size: "+retorno.size());
	         }
            
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return retorno;
	}
    
    @Override
    @Transactional(rollbackFor=RubroOpcionException.class)
    public GuardarRubroOpcionOutRO editarRubroOpcion(GuardarRubroOpcionInRO in) throws RubroOpcionException{
    	GuardarRubroOpcionOutRO retorno=new GuardarRubroOpcionOutRO();
        try{
        	OpcionFilter opcionFilter = new OpcionFilter();
        	opcionFilter.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        	opcionFilter.setIdActividad(in.getIdRubroOpcion().getIdActividad());
        	List<OpcionDTO> opcionesBD =  opcionDAO.find(opcionFilter);
        	List<OpcionDTO> opcionesMant =  in.getIdRubroOpcion().getOpciones();
        	List<OpcionDTO> opcionesFaltantes  = new ArrayList<OpcionDTO>();
        	
        	RubroOpcionFilter rubroOpcionFilter = new RubroOpcionFilter();
        	rubroOpcionFilter.setIdActividad(in.getIdRubroOpcion().getIdActividad());
        	List<RubroOpcionDTO>rubroOpcion = rubroOpcionDAO.find(rubroOpcionFilter);
        	List<RubroOpcionDTO>rubroOpcionEliminar = new ArrayList<RubroOpcionDTO>();
        	
       	
        	//registrar rubro opcion nueva
        	for (OpcionDTO opcionMant : opcionesMant) {
        		boolean encontro=false;
        		for (OpcionDTO opcionBD : opcionesBD) {
        			// si no lo encontro
        			if (opcionMant.getIdOpcion() == opcionBD.getIdOpcion()){
        				encontro = true;
        			}
				}
    			if (!encontro){
    				opcionesFaltantes.add(opcionMant); //agregar
    				System.out.println("fasdf");
    			}
			}
        	
        	//registra
        	if(opcionesFaltantes.size()!=0){
                for(OpcionDTO maestro : opcionesFaltantes){
                	RubroOpcionDTO pta=new RubroOpcionDTO(null,Constantes.CONSTANTE_ESTADO_ACTIVO, maestro.getIdOpcion(),in.getIdRubroOpcion().getIdActividad());
                	RubroOpcionDTO regSave=rubroOpcionDAO.create(pta, in.getUsuario());
                }
            }
        	
        	//eliminar rubro opcion 
        	for (RubroOpcionDTO rubroOpcionBD : rubroOpcion) {
    			boolean encontro=false;
        		for (OpcionDTO opcionMant : opcionesMant) {
        			// si no lo encontro
        			if (rubroOpcionBD.getOpcion().getIdOpcion() == opcionMant.getIdOpcion()){
        				encontro = true;
        			}
				}
        		if (!encontro){
        			rubroOpcionEliminar.add(rubroOpcionBD);//eliminar
    				System.out.println("fasdf");
    			}
			}
        	
        	//elimina
        	if(rubroOpcionEliminar.size()!=0){
        		for (RubroOpcionDTO rubroOpcionDTO : rubroOpcionEliminar) {
        			rubroOpcionDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
        			RubroOpcionDTO registroRubroOpcion=  rubroOpcionDAO.changeState(rubroOpcionDTO, in.getUsuario());
        		}
        	}	
        	
        	
        	
        	System.out.println("RubroOpcionServiceNegImpl.editarRubroOpcion()");
//        	TramiteActividadDTO registro=new TramiteActividadDTO();
//            TramiteActividadDTO registroTramActiv=  tramiteActividadDAO.updateVerificado(in.getIdTramiteActividad(), in.getUsuario());
//            retorno.setRubroOpcion(rubroOpcionEliminar.get(0));
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en editarRubroOpcion:"+ex.getMessage());
            throw new RubroOpcionException(ex);
        }
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=RubroOpcionException.class)
    public GuardarRubroOpcionOutRO eliminarRubroOpcion(GuardarRubroOpcionInRO in){
    	GuardarRubroOpcionOutRO retorno=new GuardarRubroOpcionOutRO();
        try{
        	RubroOpcionDTO registro=new RubroOpcionDTO();
        	RubroOpcionFilter rubroOpcionFilter = new RubroOpcionFilter();
        	rubroOpcionFilter.setIdActividad(in.getIdRubroOpcion().getIdActividad());
        	List<RubroOpcionDTO>rubroOpcion = rubroOpcionDAO.find(rubroOpcionFilter);
        	
        	for (RubroOpcionDTO rubroOpcionDTO : rubroOpcion) {
        		rubroOpcionDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            	RubroOpcionDTO registroRubroOpcion=  rubroOpcionDAO.changeState(rubroOpcionDTO, in.getUsuario());
                retorno.setRubroOpcion(registroRubroOpcion);
			}
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en editarProcedimiento:"+ex.getMessage());
        }
        return retorno;
    }
}
