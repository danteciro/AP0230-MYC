/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.DetalleCriterioFilter;
import gob.osinergmin.myc.domain.ui.DetalleCriterioImplFilter;
import gob.osinergmin.myc.service.business.DetalleCriterioServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.dao.DetalleCriterioDAO;
import gob.osinergmin.myc.service.exception.DetalleCriterioException;
import gob.osinergmin.myc.util.Constantes;
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
@Service("DetalleCriterioServiceNegImpl")
public class DetalleCriterioServiceNegImpl implements DetalleCriterioServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(DetalleCriterioServiceNegImpl.class);
    
    @Inject
    private DetalleCriterioDAO detalleCriterioDAO;
    @Inject
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;

    @Override
    @Transactional(rollbackFor=DetalleCriterioException.class)
    public DetalleCriterioDTO eliminarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException {
        LOG.info("eliminarSancionEspecifica");
        DetalleCriterioDTO registro = null;
        try{
            registro = detalleCriterioDAO.eliminarSancionEspecifica(detalleCriterioDTO,usuarioDTO); 
        }catch(Exception ex){
            LOG.error("Error en eliminarSancionEspecifica",ex.getMessage());
            throw new DetalleCriterioException(ex.getMessage(),null);
        }
        return registro;
    }
    @Override
    @Transactional(rollbackFor=DetalleCriterioException.class)
    public DetalleCriterioDTO editarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException {
        LOG.info("guardarSancionEspecifica");
        DetalleCriterioDTO registro = null;
        try{
            detalleCriterioDTO.setNivel(maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_NIVEL_SANCION).get(0).getIdMaestroColumna());
            registro = detalleCriterioDAO.editarSancionEspecifica(detalleCriterioDTO,usuarioDTO); 
        }catch(Exception ex){
            LOG.error("Error en guardarSancionEspecifica",ex.getMessage());
            throw new DetalleCriterioException(ex.getMessage(),null);
        }
        return registro;
    }
    @Override
    @Transactional(rollbackFor=DetalleCriterioException.class)
    public DetalleCriterioDTO guardarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException {
        LOG.info("guardarSancionEspecifica");
        DetalleCriterioDTO registro = null;
        try{
            detalleCriterioDTO.setNivel(maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_NIVEL_SANCION).get(0).getIdMaestroColumna());
            registro = detalleCriterioDAO.createSancionEspecifica(detalleCriterioDTO,usuarioDTO); 
        }catch(Exception ex){
            LOG.error("Error en guardarSancionEspecifica",ex.getMessage());
            throw new DetalleCriterioException(ex.getMessage(),null);
        }
        return registro;
    }
    
    @Override
    @Transactional
    public DetalleCriterioDTO guardaDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) {
        LOG.info("Registro Detalle Criterio ServiceNegImpl");
        DetalleCriterioDTO registro = null;
        try{
            registro = detalleCriterioDAO.create(detalleCriterioDTO,usuarioDTO);
            LOG.info("(Registro Detalle Criterio ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }

    @Override
    @Transactional
    public DetalleCriterioDTO eliminarDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO) {
        LOG.info("Eliminar Detalle Criterio ServiceNegImpl");
        DetalleCriterioDTO eliminar = null;
        try{
            eliminar = detalleCriterioDAO.changeState(detalleCriterioDTO);
            LOG.info("(Eliminar Detalle Criterio ServiceNegImpl) registro: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return eliminar;
    }

    @Override
    @Transactional
    public List<DetalleCriterioDTO> listarDetalleCriterio(DetalleCriterioFilter filtro, int[] cuenta) {
        LOG.info("Funcion: Listar Detalle Criterio-- Service Impl -- Clase: listarDetalleCriterio");
        List<DetalleCriterioDTO> listado = null;
        try{
            cuenta[0] = detalleCriterioDAO.count(filtro).intValue();
            LOG.info("cuenta: "+cuenta[0]);
            if(cuenta[0] > 0){
                listado = detalleCriterioDAO.find(filtro);
                LOG.info("Funcion: numero de registros en el listado: "+listado.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return listado;
    }

	@Override
	public List<DetalleCriterioDTO> listarDetalleCriterioImpl(DetalleCriterioImplFilter filtro, int[] cuenta) {
		LOG.info("Funcion: Listar DetalleCriterio -- Service Impl -- Clase: listarDetalleCriterioImpl");
        List<DetalleCriterioDTO> listado=null;
        try{
            cuenta[0] = detalleCriterioDAO.countImpl(filtro).intValue();
            LOG.info("cuenta: "+cuenta[0]);
            if (cuenta[0] > 0) {
                listado = detalleCriterioDAO.findImpl(filtro);
                LOG.info("Funcion: numero de registros en el listado: "+listado.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return listado;
	}
    
}