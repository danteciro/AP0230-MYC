/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionDetalleFilter;
import gob.osinergmin.myc.service.business.ZonificacionDetalleServiceNeg;
import gob.osinergmin.myc.service.dao.ZonificacionDetalleDAO;
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
@Service("zonificacionDetalleServiceNeg")
public class ZonificacionDetalleServiceNegImpl implements ZonificacionDetalleServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(ZonificacionDetalleServiceNegImpl.class);
    @Inject
    private ZonificacionDetalleDAO zonificacionDetalleDAO;

    @Override
    public List<ZonificacionDetalleDTO> obtenerListadoZonificacionDetalle(Long idZonificacion) {
        List<ZonificacionDetalleDTO> retorno = new ArrayList<ZonificacionDetalleDTO>();
        LOG.info("Neg obtenerListadoZonificacionDetalle");
        try{
  
                ZonificacionDetalleFilter filtro = new ZonificacionDetalleFilter();
                filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                filtro.setIdZonificacion(idZonificacion);
                retorno = zonificacionDetalleDAO.obtenerZonificacionDetalle(filtro);

        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    @Transactional
    public ZonificacionDetalleDTO guardarZonificacionDetalle(ZonificacionDetalleDTO zonificacionDetalleDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Zonificacion Detalle ServiceNegImpl");
        ZonificacionDetalleDTO registro = null;
        try{
            registro = zonificacionDetalleDAO.create(zonificacionDetalleDTO, usuarioDTO);
            LOG.info("(Registro Zonificacion Detalle ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }

    @Override
    @Transactional
    public ZonificacionDetalleDTO eliminarZonificacionDetalle(ZonificacionDetalleDTO zonificacionDetalleDTO) {
        LOG.info("Eliminar Zonificacion Detalle ServiceNegImpl");
        ZonificacionDetalleDTO eliminar = null;
        try{
            eliminar = zonificacionDetalleDAO.changeState(zonificacionDetalleDTO, Constantes.CONSTANTE_ESTADO_INACTIVO);
            LOG.info("(Eliminar Zonificacion Detalle ServiceNegImpl) eliminar: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return eliminar;
    }
    
    @Override
    public List<DistritoDTO> obtenerListadoDistritosUnicos(Long idZonificacion, Long idDepartamento, Long idProvincia){
        List<DistritoDTO> listaDistritos =null;
        LOG.info("Neg obtenerListadoDistritosUnicos");
        try{
            listaDistritos = zonificacionDetalleDAO.obtenerDistritosUnicos(idZonificacion, idDepartamento, idProvincia);
        }catch(Exception ex){
            LOG.error("",ex);
        }        
        return listaDistritos;
    }

    @Override
    @Transactional(readOnly = true)
    public ZonificacionDetalleDTO obtenerZonificacionDetalle(Long idZonificacionDetalle, Long idDepartamento, Long idProvincia, Long idDistrito) {
        ZonificacionDetalleDTO zonificacionDetalleDTO = null;
        try{
            zonificacionDetalleDTO = zonificacionDetalleDAO.obtenerZonificacionDetalleUbigeo(idZonificacionDetalle, idDepartamento, idProvincia, idDistrito);
        }catch(Exception ex){
            
        }
        return zonificacionDetalleDTO;
    }
    
}