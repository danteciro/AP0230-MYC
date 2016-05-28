/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipificacionFilter;
import gob.osinergmin.myc.service.business.TipificacionServiceNeg;
import gob.osinergmin.myc.service.dao.MaestroColumnaDAO;
import gob.osinergmin.myc.service.dao.TipificacionDAO;
import gob.osinergmin.myc.service.exception.EtapaException;
import gob.osinergmin.myc.service.exception.TipificacionException;
import gob.osinergmin.myc.util.Constantes;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lbarboza
 */
@Service("TipificacionServiceNegImpl")
public class TipificacionServiceNegImpl implements TipificacionServiceNeg {
    private static final Logger log = LoggerFactory.getLogger(TipificacionServiceNegImpl.class);
    @Inject
    private TipificacionDAO tipificacionDAO;
    @Inject
    private MaestroColumnaDAO maestroColumnaDAO;
    @Override
    @Transactional
    public TipificacionDTO guardaTipificacion(TipificacionDTO tipificacionDTO, UsuarioDTO usuarioDTO) {
        log.info("Registro Tipificacion ServiceNegImpl");
        TipificacionDTO registro = null;
        try {
            registro = tipificacionDAO.create(tipificacionDTO, usuarioDTO);
            log.info("(Registro Tipificacion ServiceNegImpl) registro: " + registro.toString());
        } catch (Exception ex) {
            log.error("", ex);
        }
        return registro;
    }
    @Override
    @Transactional(rollbackFor=TipificacionException.class)
    public TipificacionDTO eliminarTipificacion(TipificacionDTO tipificacionDTO) throws TipificacionException{
        log.info("Eliminar Tipificacion ServiceNegImpl");
        TipificacionDTO eliminar = null;
        try {
            eliminar = tipificacionDAO.changeState(tipificacionDTO);
            log.info("(Eliminar Tipificacion ServiceNegImpl) registro: " + eliminar.toString());
        } catch (Exception ex) {
            log.error("Error eliminarTipificacion",ex);
            throw new TipificacionException(ex.getMessage(),null);
        }
        return eliminar;
    }

    @Override
    @Transactional
    public List<TipificacionDTO> listarTipificacion(TipificacionFilter filtro, int[] cuenta) {
        log.info("Funcion: Listar Tipificacion-- Service Impl -- Clase: listarTipificacion");
        List<TipificacionDTO> listado = null;
        try {
            cuenta[0] = tipificacionDAO.count(filtro).intValue();
            log.info("cuenta: " + cuenta[0]);
            if (cuenta[0] > 0) {
                listado = tipificacionDAO.find(filtro);
                log.info("Funcion: numero de registros en el listado: " + listado.size());
            }
        } catch (Exception ex) {
            log.error("", ex);
        }
        return listado;
    }

    @Override
    @Transactional
    public TipificacionDTO obtenerTipificacion(Long idTipificacion) {
        log.info("Funcion: obtenerTipificacion -- Service Impl -- Clase: TipificacionServiceNeg");
        log.info("-- parametro idTipificacion : " + idTipificacion);
        TipificacionDTO tipificacion = tipificacionDAO.obtenerTipificacion(idTipificacion);
        List<TipificacionSancionDTO> listaTipificacionSancion = tipificacionDAO.obtenerTipificacionSancion(tipificacion.getCodTipificacion());
        
        tipificacion.setListaTipificacionSancion(listaTipificacionSancion);
        return tipificacion;
    }
    
    @Override
    @Transactional
    public List<TipificacionDTO> obtenerTipificaciones(String codigoTipificacion) {
        log.info("Funcion: obtenerTipificaciones -- Service Impl -- Clase: TipificacionServiceNeg");
        log.info("-- parametro codigoTipificacion : " + codigoTipificacion);
        List<TipificacionDTO> listaTipificacion = tipificacionDAO.obtenerTipificaciones(codigoTipificacion);
        return listaTipificacion;
    }
    
    @Override
    @Transactional
    public TipificacionDTO obtenerTipificacion(String codigoTipificacion) {
        log.info("Funcion: obtenerTipificaciones -- Service Impl -- Clase: TipificacionServiceNeg");
        log.info("-- parametro codigoTipificacion : " + codigoTipificacion);
        TipificacionDTO tipificacion = null;
        List<TipificacionDTO> listaTipificacion = tipificacionDAO.obtenerTipificacionByCodigo(codigoTipificacion);
        if(!listaTipificacion.isEmpty()){
            tipificacion = listaTipificacion.get(0);
        }
        return tipificacion;
    }

    @Override
    public List<TipificacionDTO> listarTipificaciones(TipificacionFilter filtro, int[] cuenta) {
        log.info("Funcion: Listar Tipificacion-- Service Impl -- Clase: listarTipificaciones");
        List<TipificacionDTO> listado = null;
        List<TipificacionDTO> listadoRetorno = null;
        try {
            cuenta[0] = tipificacionDAO.countNativo(filtro).intValue();
            Long sanciones;
            if (cuenta[0] > 0) {
                listado = tipificacionDAO.findByNativo(filtro);
                listadoRetorno = new ArrayList<TipificacionDTO>();
                for(TipificacionDTO tipificacion : listado){
                	sanciones = tipificacionDAO.buscarSancionEspecifica(tipificacion.getIdTipificacion());
					if(sanciones>0){
						tipificacion.setTieneSanc("1");
					}else{
						tipificacion.setTieneSanc("0");
					}
					listadoRetorno.add(tipificacion);
                }
            }
        } catch (Exception ex) {
            log.error("", ex);
        }
        return listado;
    }
	@Override
	public TipificacionDTO obtenerTipificacionCriterio(String codigoTipificacion) {
		log.info("Funcion: obtenerTipificaciones -- Service Impl -- Clase: TipificacionServiceNeg");
        log.info("-- parametro codigoTipificacion : " + codigoTipificacion);
        TipificacionDTO tipificacion = null;
        List<TipificacionDTO> listaTipificacion = tipificacionDAO.obtenerTipificacionByCodigoCriterio(codigoTipificacion);
        if(!listaTipificacion.isEmpty()){
            tipificacion = listaTipificacion.get(0);
        }
        return tipificacion;
	}
	@Override
	public TipificacionDTO obtenerTipificacionCriterio(Long idTipificacion) {
		TipificacionDTO tipificacion=null;
		List<TipificacionSancionDTO> listaTipificacionSancion=null;
		try {
			log.info("Funcion: obtenerTipificacion -- Service Impl -- Clase: TipificacionServiceNeg");
	        log.info("-- parametro idTipificacion : " + idTipificacion);
	        tipificacion = tipificacionDAO.obtenerTipificacion(idTipificacion);
	         String aplicacion = Constantes.APPLICACION_MYC;
	         List<MaestroColumnaDTO> nivelMaestro = maestroColumnaDAO.findMaestroColumna(Constantes.DOMINIO_NIVEL_TIPIFICACION, aplicacion);
	         Long nivelTipificacion=nivelMaestro.get(0).getIdMaestroColumna();
	        listaTipificacionSancion = tipificacionDAO.obtenerTipificacionSancionCriterio(tipificacion.getCodTipificacion(),nivelTipificacion);	        
	        tipificacion.setListaTipificacionSancion(listaTipificacionSancion);
		} catch (Exception e) {
			// TODO: handle exception
		}		
        return tipificacion;
	}
	@Override
	public TipificacionDTO obtenerTipificacionNivel(Long idTipificacion) {
		log.info("Funcion: obtenerTipificacion - Nivel: Tipificacion ");
        log.info("-- parametro idTipificacion : " + idTipificacion);
        TipificacionDTO tipificacion = tipificacionDAO.obtenerTipificacion(idTipificacion);
        List<MaestroColumnaDTO> listaNivel = maestroColumnaDAO.findMaestroColumna(Constantes.DOMINIO_NIVEL_TIPIFICACION, Constantes.APPLICACION_MYC); 
        Long idNivel = listaNivel.get(0).getIdMaestroColumna();
        List<TipificacionSancionDTO> listaTipificacionSancion = tipificacionDAO.obtenerTipificacionSancionNivel(tipificacion.getCodTipificacion(),idNivel);
        
        tipificacion.setListaTipificacionSancion(listaTipificacionSancion);
        return tipificacion;
	}
	@Override
	public Object listarTipificacionesPadre(TipificacionFilter filtro) {
		log.info("Funcion: Listar Tipificacion-- Service Impl -- Clase: listarTipificaciones");
        List<TipificacionDTO> listado = null;
        try {
        	listado = tipificacionDAO.findTipificacionPadre(filtro);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return listado;
	}	
    
}