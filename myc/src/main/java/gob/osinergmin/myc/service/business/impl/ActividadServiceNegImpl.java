/**
* Resumen           
* Objeto            : ActividadServiceNegImpl.java
* Descripción       : Clase service implementación del mantenimiento de actividades en el MYC.
* Fecha de Creación : 
* PR de Creación    : OSINE_SFS-600
* Autor             : GMD.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* REQF-0009			04/07/2016		Hernan Torres Saenz
* ---------------------------------------------------------------------------------------------------
***/
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.dao.ActividadDAO;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

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
 * @author jpiro
 */
@Service("ActividadServiceNeg")
public class ActividadServiceNegImpl implements ActividadServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(ActividadServiceNeg.class);
    @Inject
    private ActividadDAO actividadDAO;    
    
    @Override
    public List<ActividadDTO> findActividadByFilter(ActividadFilter filtro){
        LOG.info("Neg findActividadByFilter");
        List<ActividadDTO> retorno=null;
        try{
            retorno = actividadDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public List<ActividadDTO> listarActividad(ActividadFilter filtro, int[] cuenta){
        LOG.info("Neg listarActividad");
        List<ActividadDTO> retorno=null;
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            cuenta[0] = actividadDAO.count(filtro).intValue();
            if (cuenta[0] > 0) {
                retorno = actividadDAO.find(filtro);
                LOG.info("cuenta -size: "+retorno.size());
            }
            //retorno = actividadDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
	public List<ProcesoObligacionTipoDTO> listarActividadConfigurada() {
		List<ProcesoObligacionTipoDTO> retorno=null;
		try{
            retorno = actividadDAO.listarConfigurada();
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retorno;
	}

	@Override
	@Transactional
	public ActividadDTO listarActividadxCodigo(ActividadFilter filtro) {
		LOG.info("Negocio Actividad");
        ActividadDTO retorno=null;
        try{
            retorno = actividadDAO.listarActividadxCodigo(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}
	@Override
	public List<ProcesoObligacionTipoDTO> listarActividadConfigurada(ActividadFilter filtro) {
		LOG.info("Neg listarActividadConfigurada");
		List<ProcesoObligacionTipoDTO> retorno=null;
		try{
            retorno = actividadDAO.listarConfigurada(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retorno;
	}
	
	/* OSINE_SFS-600 - REQF-0009 - Inicio */
	@Override
	public List<ActividadDTO> listarAgentesIntalacion(ActividadFilter filtro) {
		LOG.info("Neg listarAgentesIntalacion");
		List<ActividadDTO> retorno=null;
		try{
            retorno = actividadDAO.listarAgentesIntalacion(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retorno;
	}
	
	@Override
	public List<ActividadDTO> listarActividad(ActividadFilter filtro) {
		LOG.info("Neg listarActividad");
		List<ActividadDTO> retorno=null;
		try{
            retorno = actividadDAO.listarActividad(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retorno;
	}
	
	@Override
	public List<ActividadDTO> listarAgente(ActividadFilter filtro) {
		LOG.info("Neg listarActividad");
		List<ActividadDTO> retorno=null;
		try{
            retorno = actividadDAO.listarAgente(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retorno;
	}
	
	@Override
	@Transactional
	public Map<String, Object> guardarActividad(ActividadDTO actividad,UsuarioDTO usuario, boolean forzarOrdenamiento) {
		LOG.info("Neg guardarActividad");
		Map<String, Object> retorno = new HashMap<String, Object>();
		try{			
			if(forzarOrdenamiento){
				ActividadFilter filtro=new ActividadFilter();
				if(actividad.getIdActividadPadre()!=null)
					filtro.setIdActividadPadre(actividad.getIdActividadPadre());
				else 
					filtro.setFlagListarActividadesPadre(true);
				List<ActividadDTO> listaActividadBd = findActividadByFilter(filtro);
				for(ActividadDTO actividadBd : listaActividadBd){
					if(actividadBd.getOrden()>=actividad.getOrden()){
						actividadBd.setOrden(actividadBd.getOrden()+1);
						actividadDAO.actualizarActividad(actividadBd, usuario);
					}
				}
			}
			actividad = actividadDAO.guardarActividad(actividad, usuario);
			retorno.put("Actividad",actividad);
			retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
        	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("",ex);
        }
		return retorno;
	}

	@Override
	@Transactional
	public Map<String, Object> editarActividad(ActividadDTO actividad,UsuarioDTO usuario, boolean forzarOrdenamiento) {
		LOG.info("Neg editarActividad");
		Map<String, Object> retorno = new HashMap<String, Object>();
		try{			
			if(forzarOrdenamiento){
				ActividadFilter filtro=new ActividadFilter();
				if(actividad.getIdActividadPadre()!=null)
					filtro.setIdActividadPadre(actividad.getIdActividadPadre());
				else 
					filtro.setFlagListarActividadesPadre(true);
				List<ActividadDTO> listaActividadBd = findActividadByFilter(filtro);
				for(ActividadDTO actividadBd : listaActividadBd){
					if(actividadBd.getOrden()>=actividad.getOrden()){
						actividadBd.setOrden(actividadBd.getOrden()+1);
						actividadDAO.actualizarActividad(actividadBd, usuario);
					}
				}
			}
			actividad = actividadDAO.actualizarActividad(actividad, usuario);
			retorno.put("Actividad",actividad);
			retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
        	retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
        	retorno.put(ConstantesWeb.VV_MENSAJE, ex.getMessage());
            LOG.error("",ex);
        }
		return retorno;
	}
	
	@Override
	@Transactional
	public ActividadDTO eliminarActividad(Long idActividad, String estado, UsuarioDTO usuario) {
		LOG.info("Neg eliminarActividad");
		ActividadDTO retorno=null;
		try{
			retorno = actividadDAO.cambiarEstadoActividad(idActividad, estado, usuario);            
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retorno;
	}
	/* OSINE_SFS-600 - REQF-0009 - Fin */

	@Override
	public Map<String, Object> verificarEliminarActividad(ActividadFilter filtro) {
		LOG.info("Neg verificarEliminarActividad");
		Map<String, Object> retorno=new HashMap<String, Object>();
		String mensaje = null;
        try{
           mensaje = actividadDAO.verificarEliminarActividad(filtro);
           if(mensaje.length()!=0) {
        	   retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.ERROR);
        	   if(mensaje.indexOf(Constantes.RELACION_MDI_ACTIVIDAD_AGENTE)!=-1)        		   	
        	   		retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.RELACION_ACTIVIDAD + mensaje);
           		else 
           			retorno.put(ConstantesWeb.VV_MENSAJE, Constantes.RELACION_ACTIVIDAD_AGENTE + mensaje);       			
           } else {
        	   retorno.put(ConstantesWeb.VV_RESULTADO, BaseConstantesOutBean.SUCCESS);
           }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}
}
