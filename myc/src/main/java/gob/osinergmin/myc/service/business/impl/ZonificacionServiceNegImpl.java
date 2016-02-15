/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionFilter;
import gob.osinergmin.myc.service.business.ZonificacionServiceNeg;
import gob.osinergmin.myc.service.dao.ZonificacionDAO;
import gob.osinergmin.myc.service.dao.ZonificacionDetalleDAO;
import gob.osinergmin.myc.service.exception.ZonificacionException;
import gob.osinergmin.myc.util.Constantes;
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
@Service("zonificacionServiceNeg")
public class ZonificacionServiceNegImpl implements ZonificacionServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(ZonificacionServiceNegImpl.class);
    @Inject
    private ZonificacionDAO zonificacionDAO;
    @Inject
    private ZonificacionDetalleDAO zonificacionDetalleDAO;
    
    public List<ZonificacionDTO> obtenerListadoZonificacion(ZonificacionFilter filtro){
        List<ZonificacionDTO> retorno=null;
        LOG.info("Neg obtenerListadoZonificacion");
        try{
//            ZonificacionFilter filtro=new ZonificacionFilter();
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
//            filtro.setNombre(nombre);
            retorno = zonificacionDAO.obtenerZonificacion(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno; 
    }

    @Override
    @Transactional
    public ZonificacionDTO guardarZonificacion(ZonificacionDTO zonificacionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Zonificacion ServiceNegImpl");
        ZonificacionDTO registro = null;
        try{
            registro = zonificacionDAO.create(zonificacionDTO, usuarioDTO);
            LOG.info("(Registro Zonificacion ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }

    @Override
    @Transactional(rollbackFor= ZonificacionException.class)
    public ZonificacionDTO eliminarZonificacion(ZonificacionDTO zonificacionDTO) throws ZonificacionException{
        LOG.info("Eliminar Zonificacion ServiceNegImpl");
        Long idZonificacion = zonificacionDTO.getIdZonificacion();
        ZonificacionDTO eliminar = null;
        try{
            eliminar = zonificacionDAO.changeState(zonificacionDTO, Constantes.CONSTANTE_ESTADO_INACTIVO);
            zonificacionDetalleDAO.disabledZonificacionDetalle(idZonificacion);
            LOG.info("(Eliminar Zonificacion ServiceNegImpl) eliminar: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("Error eliminarZonificacion",ex);
            throw new ZonificacionException(ex.getMessage(),null);
        }
        return eliminar;
    }

    @Override
    public ZonificacionDTO obtenerZonificacion(String nombre) {
        ZonificacionDTO retorno=null;
        LOG.info("Neg obtenerZonificacion");
        try{
            ZonificacionFilter filtro=new ZonificacionFilter();
            filtro.setNombre(nombre);
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
//            filtro.setNombre(nombre);
            retorno = (ZonificacionDTO)zonificacionDAO.obtenerZonificacion(filtro).get(0);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno; 
    }
    @Override
    public ZonificacionDTO obtenerZonificacionValidaNombre(String nombre) {
        ZonificacionDTO retorno=null;
        LOG.info("Neg obtenerZonificacion");
        try{
            ZonificacionFilter filtro=new ZonificacionFilter();
            filtro.setNombre(nombre);
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            retorno = (ZonificacionDTO)zonificacionDAO.obtenerZonificacionValidaNombre(filtro).get(0);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno; 
    }
}