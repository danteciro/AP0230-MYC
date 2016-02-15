/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipificacionSancionFilter;
import gob.osinergmin.myc.service.business.TipificacionSancionServiceNeg;
import gob.osinergmin.myc.service.dao.TipificacionSancionDAO;
import gob.osinergmin.myc.util.Constantes;
import java.util.HashMap;
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
@Service("TipificacionSancionServiceNeg")
public class TipificacionSancionServiceNegImpl implements TipificacionSancionServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(TipificacionSancionServiceNegImpl.class);
    @Inject
    private TipificacionSancionDAO tipificacionSancionDAO;

    @Override
    @Transactional(readOnly = true)
    public List<TipificacionSancionDTO> findTipificacionSancion(TipificacionSancionFilter filtro, int[] cuenta) {
        LOG.info("Neg listarTipificacionSancionPreOperativo");
        List<TipificacionSancionDTO> retorno = null;
        try{
            HashMap resultado = new HashMap();
            
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            resultado = tipificacionSancionDAO.listarTipificacionBySancion(filtro);
            retorno = (List<TipificacionSancionDTO>)resultado.get("listado");
            Long contador = (Long)resultado.get("cuenta");
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    @Transactional
    public TipificacionSancionDTO guardarTipificacionSancion(TipificacionSancionDTO tipificacionSancionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Tipificacion Sancion ServiceNegImpl");
        TipificacionSancionDTO registro = null;
        try{
            registro = tipificacionSancionDAO.create(tipificacionSancionDTO, usuarioDTO);
            LOG.info("(Registro Tipificacion Sancion ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }

    @Override
    @Transactional
    public TipificacionSancionDTO eliminarTipificacionSancion(TipificacionSancionDTO tipificacionSancionDTO) {
        LOG.info("Eliminar Tipificacion Sancion ServiceNegImpl");
        TipificacionSancionDTO eliminar = null;
        try{
            eliminar = tipificacionSancionDAO.changeState(tipificacionSancionDTO, Constantes.CONSTANTE_ESTADO_INACTIVO);
            LOG.info("(Eliminar Tipificacion Sancion ServiceNegImpl) eliminar: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return eliminar;
    }

	@Override
	public TipificacionSancionDTO buscarTipificacionSancion(Long idTipoSancion,Long idTipificacion) {
		TipificacionSancionDTO registro = null;
		TipificacionSancionFilter filtro = new TipificacionSancionFilter();
		filtro.setIdTipificacion(idTipificacion);
		filtro.setIdTipoSancion(idTipoSancion);
		registro = tipificacionSancionDAO.buscarTipificacionSancion(filtro);
		return registro;
	}

	@Override
	public TipificacionSancionDTO buscarTipificacionSancionNivel(Long idTipoSancion, Long idTipificacion, Long idNivel) {
		TipificacionSancionDTO registro = null;
		TipificacionSancionFilter filtro = new TipificacionSancionFilter();
		filtro.setIdTipificacion(idTipificacion);
		filtro.setIdTipoSancion(idTipoSancion);
		filtro.setNivel(idNivel);
		registro = tipificacionSancionDAO.buscarTipificacionSancionNivel(filtro);
		return registro;
	}

	@Override
	public List<TipificacionSancionDTO> findTipificacionSancionCriterio(TipificacionSancionFilter filtro, int[] cuenta) {
		LOG.info("Neg listarTipificacionSancionPreOperativo");
        List<TipificacionSancionDTO> retorno = null;
        try{
            HashMap resultado = new HashMap();
            
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            resultado = tipificacionSancionDAO.listarTipificacionBySancionCriterio(filtro);
            retorno = (List<TipificacionSancionDTO>)resultado.get("listado");
            Long contador = (Long)resultado.get("cuenta");
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}        
}