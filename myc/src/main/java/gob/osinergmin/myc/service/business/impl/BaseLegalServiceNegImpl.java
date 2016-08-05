package gob.osinergmin.myc.service.business.impl;


import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleNormaTecnicaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.BaseLegalFilter;
import gob.osinergmin.myc.service.business.BaseLegalServiceNeg;
import gob.osinergmin.myc.service.dao.BaseLegalDAO;
import gob.osinergmin.myc.service.dao.DetalleNormaTecnicaDAO;
import gob.osinergmin.myc.service.dao.ObligacionBaseLegalDAO;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author gvillanueva
 *
 */
@Service("baseLegalServiceNeg")
public class BaseLegalServiceNegImpl implements BaseLegalServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(BaseLegalServiceNegImpl.class);
	@Inject
	private BaseLegalDAO baseLegalDAO;
	
	@Inject
	private ObligacionBaseLegalDAO obligacionBaseLegalDAO;
	@Inject
	private DetalleNormaTecnicaDAO detalleNormaTecnicaDAO;
	
	@Override
    @Transactional
	public List<BaseLegalDTO> listarBaseLegal(BaseLegalFilter filtro, int[] cuenta){
		LOG.info("Funcion: Listar Bases Legales -- Service Impl -- Clase: listarBaseLegal");
        List<BaseLegalDTO> listado=null;
        try{
            cuenta[0] = baseLegalDAO.count(filtro).intValue();
            LOG.info("cuenta: "+cuenta[0]);
            if (cuenta[0] > 0) {
                listado = baseLegalDAO.find(filtro);
                LOG.info("Funcion: numero de registros en el listado: "+listado.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return listado;
	}
	
	@Override
    @Transactional
	public List<BaseLegalDTO> listarBaseLegalPadre(BaseLegalFilter filtro, int[] cuenta){
		LOG.info("Funcion: Listar Bases Legales -- Service Impl -- Clase: listarBaseLegal Padre");
        List<BaseLegalDTO> listado=null;
        try{
            cuenta[0] = baseLegalDAO.countPadre(filtro).intValue();
            LOG.info("cuenta: "+cuenta[0]);
            if (cuenta[0] > 0) {
                listado = baseLegalDAO.findPadre(filtro);
                LOG.info("Funcion: numero de registros en el listado Padre: "+listado.size());
                
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return listado;
	}
	
    @Override
    @Transactional(readOnly = true)
    public List<BaseLegalDTO> listarBaseLegalConcordancia(BaseLegalFilter filtro, int[] cuenta){
            LOG.info("Funcion: Listar Bases Legales Concordancia -- Service Impl -- Clase: listarBaseLegalConcordancia");
    List<BaseLegalDTO> listado=null;
    try{
        cuenta[0] = baseLegalDAO.count(filtro).intValue();
        LOG.info("cuenta: "+cuenta[0]);
        if (cuenta[0] > 0) {
            listado = baseLegalDAO.find(filtro);
            LOG.info("Funcion: numero de registros en el listado: "+listado.size());
        }
    }catch(Exception ex){
        LOG.error("",ex);
    }
    return listado;
    }
		
	@Override
	@Transactional
	public BaseLegalDTO guardaBaseLegal(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO){
		LOG.info("Registro Base Legal ServiceNegImpl");
		BaseLegalDTO registro=null;
		try{
			registro=baseLegalDAO.create(baseLegalDTO,usuarioDTO);
			
			LOG.info("(Registro Base Legal ServiceNegImpl) registro: "+registro.toString());
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}
	@Override
	@Transactional
	public List<ObligacionBaseLegalDTO> obtenerDependencias(BaseLegalFilter filtro){
		LOG.info("Obtener Dependencias ServiceNegImpl");
		List<ObligacionBaseLegalDTO> listado=null;
		try{
			listado=baseLegalDAO.obtenerDependencias(filtro);
			LOG.info("(Obtener Dependencias ServiceNegImpl) registro: "+listado.toString());
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return listado;
	}
	
	@Override
	@Transactional
	public BaseLegalDTO eliminarBaseLegal(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO){
		BaseLegalDTO registro=null;
		ObligacionBaseLegalDTO dependencia=null;
		try{
			registro=baseLegalDAO.changeEstado(baseLegalDTO,usuarioDTO);
			LOG.info("(Eliminar Base Legal ServiceNegImpl) registro: "+registro.toString());
			
			int contador=obligacionBaseLegalDAO.findByBaseLegal(baseLegalDTO).intValue();
			if(contador>0){
				dependencia=obligacionBaseLegalDAO.changeEstadoRelacion(baseLegalDTO,usuarioDTO);
			}
			LOG.info("contador"+contador);
			
		}catch(Exception ex){
			LOG.error("",ex);
		}
        return registro;
	}

	@Override
	public List<BaseLegalDTO> findBaseLegalbyCodigo(BaseLegalFilter filtro,int[] cuenta) {
		List<BaseLegalDTO> registro=null;
		try{
			
			cuenta[0] = baseLegalDAO.contador(filtro).intValue();
			LOG.info("cuenta: "+cuenta[0]);
			if (cuenta[0] > 0) {
				registro=baseLegalDAO.findBaseLegalbyCodigo(filtro);
				LOG.info("Funcion: numero de registros en el listado: "+registro.size());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return registro;
	}

//	@Override
//	public BaseLegalDTO findUltimoRegistro() {
//		BaseLegalDTO registro=null;
//		try{
//			registro=baseLegalDAO.findUltimoRegistro();
//		}catch(Exception ex){
//			
//		}
//		return registro;
//	}

	@Override
	public BaseLegalDTO findBaseLegalbyId(Long codigoEditarBaseLegal) {
		BaseLegalDTO registro=null;
		DetalleBaseLegalDTO detalle=null;
		try{
			int[] cuenta=new int[1];
			cuenta[0] = baseLegalDAO.contadorbyId(codigoEditarBaseLegal).intValue();
			LOG.info("cuenta: "+cuenta[0]);
			if (cuenta[0] > 0) {
				registro=baseLegalDAO.findBaseLegalbyId(codigoEditarBaseLegal);
				LOG.info("Funcion: numero de registros en el listado: "+registro);
				
			}
			
			int[] auxiliar=new int[1];
			BaseLegalFilter filtro=new BaseLegalFilter();
			filtro.setIdBaseLegal(codigoEditarBaseLegal);
			auxiliar[0] = baseLegalDAO.countObligacion(filtro).intValue();
			LOG.info("Nro de Obligaciones Por Base Legal: "+auxiliar[0]);
			if(auxiliar[0]>0){
				registro.setObligacion('1');
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return registro;
	}

	

	@Override
	public DetalleBaseLegalDTO findDetalleBaseLegalbyId(Long codigoEditarBaseLegal) {
		DetalleBaseLegalDTO detalle=null;
		try{
			int[] cuenta=new int[1];
			cuenta[0] = baseLegalDAO.contadorDetallebyId(codigoEditarBaseLegal).intValue();
			LOG.info("cuenta: "+cuenta[0]);
		if (cuenta[0] > 0) {
			detalle=baseLegalDAO.findDetalleBaseLegalbyId(codigoEditarBaseLegal);
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return detalle;
	}



	@Override
	@Transactional
	public BaseLegalDTO editarBaseLegal(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO) {
		LOG.info("Actualizar Base Legal ServiceNegImpl");
		BaseLegalDTO registro=null;
		ObligacionBaseLegalDTO registroObligacionBaseLegal = null;
		try{
			// Actualización de la Base Legal con Bases Legales en Concordancia
			registro=baseLegalDAO.update(baseLegalDTO,usuarioDTO);
			LOG.info("(Actualizar Base Legal ServiceNegImpl) registro: "+registro.toString());
			// Actualización de las Obligaciones Asociadas
			LOG.info("Lista de Obligaciones: " + baseLegalDTO.getListaObligaciones());
			if(baseLegalDTO.getListaObligaciones()!=null){
				baseLegalDTO.setEstado("1");
				List<ObligacionBaseLegalDTO> listadoActualizado=baseLegalDAO.updateListadoObligaciones(baseLegalDTO,usuarioDTO); 
			}else if(baseLegalDTO.getListaObligaciones()==null){
				List<ObligacionBaseLegalDTO> listadoActualizado=baseLegalDAO.cambiarEstadoListadoObligaciones(baseLegalDTO,usuarioDTO); 
			}
			
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}



	@Override
	public List<ObligacionBaseLegalDTO> findObligacionByBaseLegal(
			BaseLegalFilter filtro, int[] auxiliar) {
		List<ObligacionBaseLegalDTO> registro=null;
		try{
			auxiliar[0] = baseLegalDAO.countObligacion(filtro).intValue();
			LOG.info("cuenta: "+auxiliar[0]);
			if (auxiliar[0] > 0) {
				registro=baseLegalDAO.findObligacionByBaseLegal(filtro);
				LOG.info("Funcion: numero de registros en el listado: "+registro.size());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return registro;
	}



	@Override
	public List<ObligacionBaseLegalDTO> findBaseLegalByObligacion(
			Long idObligacion, int[] auxiliar) {
		List<ObligacionBaseLegalDTO> registro=null;
		try{
			auxiliar[0] = baseLegalDAO.countObligacionBaseLegal(idObligacion).intValue();
			LOG.info("cuenta: "+auxiliar[0]);
			if (auxiliar[0] > 0) {
				registro=baseLegalDAO.findBaseLegalByObligacion(idObligacion);
				LOG.info("Funcion: numero de registros en el listado: "+registro.size());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return registro;
	}

	@Override
	public List<BaseLegalDTO> listarNormaLegalPadre() {
		List<BaseLegalDTO> listaNormaLegalPadre = null;
		try {
			listaNormaLegalPadre = baseLegalDAO.listarNormaLegalPadre();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaNormaLegalPadre;
	}

	@Override
	public BaseLegalDTO findBaseLegalPadrebyId(Long idBaseLegalPadre) {
		BaseLegalDTO registro=null;
		try {			
				registro=baseLegalDAO.findBaseLegalbyId(idBaseLegalPadre);
				LOG.info("Funcion: numero de registros en el listado: "+registro);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registro;
	}

	@Override
	public List<BaseLegalDTO> listarBaseLegalHijo(Long row_id) {
		List<BaseLegalDTO> listaBaseLegalHijo = null;
		try {
			listaBaseLegalHijo = baseLegalDAO.listarBaseLegalHijo(row_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaBaseLegalHijo;
	}
	 /**
     * <-- AsociarBaseToBase -->
     * @author l_garcia_reyna
     * @return      
     */
    // 06-11-2015
	@Override
	public List<BaseLegalDTO> listarBaseLegalToBaseLegal(BaseLegalFilter filtro, int[] cuenta) {

        LOG.info("Funcion: Listar Bases Legales para asociar -- Service Impl -- Clase: listarBaseLegalToBaseLegal");
        List<BaseLegalDTO> listado=null;
        try{
        	cuenta[0] = baseLegalDAO.countToBase(filtro).intValue();
        	LOG.info("cuenta: "+cuenta[0]);
        	if (cuenta[0] > 0) {
        		listado = baseLegalDAO.findToBase(filtro);
        		LOG.info("Funcion: numero de registros en el listado: "+listado.size());
        	}
        }catch(Exception ex){
        	LOG.error("",ex);
        }
        return listado;
	}

	@Override
	public List<BaseLegalDTO> listarBaseLegalByObligacion(Long row_id) {
		List<BaseLegalDTO> listaBaseLegalByObligacion = null;
		try {
			listaBaseLegalByObligacion = baseLegalDAO.listarBaseLegalByObligacion(row_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaBaseLegalByObligacion;
	}

	@Override
	public List<DetalleNormaTecnicaDTO> findDetalleNormaTecnicaById(Long idDetalleBaseLegal) {
		List<DetalleNormaTecnicaDTO>detalleNormaTecnicaDTO = null;
		try {
			detalleNormaTecnicaDTO = detalleNormaTecnicaDAO.findDetalleNormaTecnicaById(idDetalleBaseLegal);	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return detalleNormaTecnicaDTO;
	}
	
	@Override
	public List<BaseLegalDTO> verificarBaseLegalExistente(BaseLegalFilter filtro) {
        List<BaseLegalDTO> listado=null;
        try{
        	listado = baseLegalDAO.findToBase(filtro);
        }catch(Exception ex){
        	LOG.error("",ex);
        }
        return listado;
	}

	@Override
	public String obtenerCodigoBaseLegal(String flagPadre) {		
        String codigo=null;
        try{
        	codigo = baseLegalDAO.obtenerCodigoBaseLegal(flagPadre);
        }catch(Exception ex){
        	LOG.error("",ex);
        }
        return codigo;
	}
	
	//
}