/**
* Resumen           
* Objeto            : PrioridadNormaAgenteServiceNegImpl.java
* Descripción       : Implementacion Servicios de Negocio prioridad norma agente en el MYC.
* Fecha de Creación : 28/06/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Erick Ortiz Gil.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.service.business.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.PghNormaAgentePrioridad;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ListaPrioridadNormaAgenteDTO;
import gob.osinergmin.myc.domain.dto.PrioridadNormaAgenteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.PrioridadNormaAgenteFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.PrioridadNormaAgenteServiceNeg;
import gob.osinergmin.myc.service.dao.PrioridadNormaAgenteDAO;
import gob.osinergmin.myc.service.exception.PrioridadNormaAgenteException;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

@Service("PrioridadNormaAgenteServiceNeg")
public class PrioridadNormaAgenteServiceNegImpl implements PrioridadNormaAgenteServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(ActividadServiceNeg.class);
	@Inject
    private PrioridadNormaAgenteDAO prioridadNormaAgenteDAO;
	
	@Override
	public List<PrioridadNormaAgenteDTO> listarPrioridadNormaAgente(PrioridadNormaAgenteFilter filtro, int[] cuenta) throws PrioridadNormaAgenteException{
		LOG.info("Neg listarPrioridadNormaAgente");
        List<PrioridadNormaAgenteDTO> retorno=null;
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            cuenta[0] = prioridadNormaAgenteDAO.count(filtro).intValue();
            if (cuenta[0] > 0) {
                retorno = prioridadNormaAgenteDAO.find(filtro);
                LOG.info("size: "+retorno.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
            throw new PrioridadNormaAgenteException(ex.getMessage(),null);
        }
        return retorno;
	}
	
	public List<PrioridadNormaAgenteDTO> findPrioridadNormaAgenteByFilter(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException{
		LOG.info("Neg findPrioridadNormaAgenteByFilter");
        List<PrioridadNormaAgenteDTO> retorno=null;
        try{
            retorno = prioridadNormaAgenteDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
            throw new PrioridadNormaAgenteException(ex.getMessage(),null);
        }
        return retorno;
	}
	
	public List<BaseLegalDTO> findBaseLegalByIdAgente(Long idAgente) throws PrioridadNormaAgenteException {
		LOG.info("Neg findByActividadAgente");
        List<BaseLegalDTO> retorno=null;
        try{
        	retorno = prioridadNormaAgenteDAO.findBaseLegalByIdAgente(idAgente);
        }catch(Exception ex){
            LOG.error("",ex);
            throw new PrioridadNormaAgenteException(ex.getMessage(),null);
        }
        return retorno;
	}
	
	@Override
    @Transactional(rollbackFor=PrioridadNormaAgenteException.class)
	public Map<String, Object> actualizarPrioridadNormaAgente(ListaPrioridadNormaAgenteDTO listaPrioridad, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException {
		Map<String, Object> retorno = new HashMap<String, Object>();
        PrioridadNormaAgenteFilter filtro=new PrioridadNormaAgenteFilter();
        List<PrioridadNormaAgenteDTO> listaNorma=null;
        boolean entro=false;
        try {        	
        	if(listaPrioridad.getListaPrioridadNorma()!=null && listaPrioridad.getListaPrioridadNorma().size()!=0){
        		filtro.setFlagNotInIdPrioridadNormaAgente(false);
        		filtro.setIdAgente(listaPrioridad.getListaPrioridadNorma().get(0).getIdAgente().getIdActividad());
            	filtro.setCodigosPrioridadNormaAgente(listaPrioridad.getCodigosPrioridadNormaAgente());
            	listaNorma=prioridadNormaAgenteDAO.findPrioridadNormaEdit(filtro);
        	}        		
        	for(PrioridadNormaAgenteDTO registro : listaPrioridad.getListaPrioridadNorma()){
        		registro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        		filtro.setFlagNotInIdPrioridadNormaAgente(true);
        		filtro.setIdAgente(registro.getIdAgente().getIdActividad());
        		filtro.setCodigosPrioridadNormaAgente(listaPrioridad.getCodigosPrioridadNormaAgente());
        		filtro.setCodigosOrden(listaPrioridad.getCodigosOrden());
        		List<PrioridadNormaAgenteDTO> lista=prioridadNormaAgenteDAO.findPrioridadNormaEdit(filtro);
        		if(lista!=null && lista.size()!=0){ entro=false; break; } 
        		else {  
        			entro=true;
        			for(PrioridadNormaAgenteDTO norma : listaNorma){        
        				if(norma.getIdPrioridadNormaAgente().toString().equals(registro.getIdPrioridadNormaAgente().toString()) && !norma.getOrden().toString().equals(registro.getOrden().toString())){
        					prioridadNormaAgenteDAO.update(registro, usuarioDTO); 
        				}
        			}       			
        		}
        	}
        	if(entro){
        		retorno.put("ListaPrioridadNormaAgenteDTO",listaPrioridad);
        		retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	} else {
        		retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);
        		retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_FAIL_UPDATE + " Existen n&uacute;mero de orden repetidos.");
        	}
        } catch (Exception ex) {
        	LOG.error("Error en actualizarPrioridadNormaAgente", ex);
            throw new PrioridadNormaAgenteException(ex.getMessage(),null);
        }
        return retorno;
	}
	
	@Override
    @Transactional(rollbackFor=PrioridadNormaAgenteException.class)
	public Map<String, Object> guardarPrioridadNormaAgente(ListaPrioridadNormaAgenteDTO listaPrioridad, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException {
		Map<String, Object> retorno = new HashMap<String, Object>();
        PrioridadNormaAgenteFilter filtro=new PrioridadNormaAgenteFilter();
        boolean entro=false;
        try {
        	for(PrioridadNormaAgenteDTO registro : listaPrioridad.getListaPrioridadNorma()){
        		registro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        		filtro.setIdAgente(registro.getIdAgente().getIdActividad());
        		filtro.setOrden(registro.getOrden());
        		filtro.setEstado(registro.getEstado());
        		List<PrioridadNormaAgenteDTO> listaNorma=findPrioridadNormaAgenteByFilter(filtro);
        		if(listaNorma!=null && listaNorma.size()==0){        			
        			prioridadNormaAgenteDAO.create(registro, usuarioDTO);   
        			entro=true;
        		}
        	}
        	if(entro){
        		retorno.put("ListaPrioridadNormaAgenteDTO",listaPrioridad);
        		retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
        	} else {
        		retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
        		retorno.put(ConstantesWeb.VV_MENSAJE, ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE + " " + ConstantesWeb.mensajes.MSG_OPERATION_FAIL_CREATE_DUPLICATE);
        	}  
        } catch (Exception ex) {
        	LOG.error("Error en guardarPrioridadNormaAgente", ex);
            throw new PrioridadNormaAgenteException(ex.getMessage(),null);
        }
        return retorno;
	}

	@Override	
    @Transactional(rollbackFor=PrioridadNormaAgenteException.class)
	public List<PrioridadNormaAgenteDTO> listarPrioridadNormaAgente(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException {
		LOG.info("Neg listarPrioridadNormaAgente");
        List<PrioridadNormaAgenteDTO> retorno=null;
        try{
            retorno = prioridadNormaAgenteDAO.findPrioridadNormaAgente(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
            throw new PrioridadNormaAgenteException(ex.getMessage(),null);
        }
        return retorno;
	}
	
	@Override
	@Transactional(rollbackFor=PrioridadNormaAgenteException.class)
	public Map<String, Object> eliminarPrioridadNormaAgente(Long idObjeto, String tipo, UsuarioDTO usuarioDTO){
		Map<String, Object> retorno = new HashMap<String, Object>();
		try{
			prioridadNormaAgenteDAO.eliminarPrioridadNorma(idObjeto, tipo, usuarioDTO);
			retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
		}catch(Exception ex){
			LOG.error("Error en eliminarPrioridadNormaAgente idObjeto "+idObjeto+" tipo "+tipo, ex);
			retorno.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ERROR);
		}
		return retorno;
	}
	
	
}
