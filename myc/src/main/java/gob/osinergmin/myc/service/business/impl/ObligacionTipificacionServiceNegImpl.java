/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.ObligacionTipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionTipificacionFilter;
import gob.osinergmin.myc.service.business.ObligacionTipificacionServiceNeg;
import gob.osinergmin.myc.service.dao.ObligacionTipificacionDAO;
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
@Service("ObligacionTipificacionServiceNegImpl")
public class ObligacionTipificacionServiceNegImpl implements ObligacionTipificacionServiceNeg {

    private static final Logger LOG = LoggerFactory.getLogger(ObligacionTipificacionServiceNegImpl.class);
    @Inject
    private ObligacionTipificacionDAO obligacionTipificacionDAO;

    @Override
    @Transactional
    public ObligacionTipificacionDTO guardaObligacionTipificacion(ObligacionTipificacionDTO obligacionTipificacionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Obligacion Tipificacion ServiceNegImpl");
        ObligacionTipificacionDTO registro = null;
        try {
            registro = obligacionTipificacionDAO.create(obligacionTipificacionDTO, usuarioDTO);
            LOG.info("(Registro Obligacion Tipificacion ServiceNegImpl) registro: " + registro.toString());
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return registro;
    }

    @Override
    @Transactional
    public ObligacionTipificacionDTO eliminarObligacionTipificacion(ObligacionTipificacionDTO obligacionTipificacionDTO) {
        LOG.info("Eliminar Obligacion Tipificacion ServiceNegImpl -- eliminarObligacionTipificacion");
        ObligacionTipificacionDTO eliminar = null;
        try {
            List<ObligacionTipificacionDTO> listaObligacionTipificacion = obligacionTipificacionDAO.findObligacionTipificacion(obligacionTipificacionDTO);
            ObligacionTipificacionDTO obligacionTipificacion = listaObligacionTipificacion.get(0);
            obligacionTipificacion.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            obligacionTipificacion.setCodTrazabilidad(obligacionTipificacionDTO.getCodTrazabilidad());
            eliminar = obligacionTipificacionDAO.changeState(obligacionTipificacion);
            LOG.info("(Eliminar Obligacion Tipificacion ServiceNegImpl) registro: " + eliminar.toString());
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return eliminar;
    }

    @Override
    @Transactional
    public List<TipificacionDTO> listarTipificacion(Long idObligacion) {
        LOG.info("Funcion: Listar Tipificacion-- Service Impl -- Clase: listarTipificacion");
        LOG.info("-- idObligacion = "+idObligacion);
        ObligacionTipificacionDTO obligacionTipificacion = new ObligacionTipificacionDTO();
        obligacionTipificacion.setIdObligacion(idObligacion);
        return obligacionTipificacionDAO.findTificacion(obligacionTipificacion);
    }
    
    @Override
    @Transactional
    public List<TipificacionDTO> listarTipificacion(Long idObligacion, Long idTipificacion) {
        LOG.info("Funcion: Listar Tipificacion-- Service Impl -- Clase: listarTipificacion");
        LOG.info("-- idObligacion = "+idObligacion);
        LOG.info("-- idTipificacion = "+idTipificacion);
        ObligacionTipificacionDTO obligacionTipificacion = new ObligacionTipificacionDTO();
        obligacionTipificacion.setIdObligacion(idObligacion);
        obligacionTipificacion.setIdTipificacion(idTipificacion);
        return obligacionTipificacionDAO.findTificacion(obligacionTipificacion);
    }
}