/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.TipoSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipoSancionFilter;
import gob.osinergmin.myc.service.business.TipoSancionServiceNeg;
import gob.osinergmin.myc.service.dao.TipoSancionDAO;
import gob.osinergmin.myc.service.exception.ProcesoObligacionTipoException;
import gob.osinergmin.myc.service.exception.TipoSancionException;
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
@Service("TipoSancionServiceNeg")
public class TipoSancionServiceNegImpl implements TipoSancionServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(TipoSancionServiceNegImpl.class);
    @Inject
    private TipoSancionDAO tipoSancionDAO;

    @Override
    @Transactional(readOnly = true)
    public List<TipoSancionDTO> listarTipoSancion(TipoSancionFilter filtro, int[] cuenta) {
        LOG.info("Neg listarTipoSancion");
        List<TipoSancionDTO> retorno = null;
        try{
            HashMap resultado = new HashMap();
            
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            resultado = tipoSancionDAO.listarTipoSancion(filtro);
            retorno = (List<TipoSancionDTO>)resultado.get("listado");
            Long contador = (Long)resultado.get("cuenta");
            cuenta[0] = contador.intValue();
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    @Transactional(rollbackFor=TipoSancionException.class)
    public TipoSancionDTO guardarTipoSancion(TipoSancionDTO tipoSancionDTO, UsuarioDTO usuarioDTO) throws TipoSancionException{
        LOG.info("Registro Tipo Sancion ServiceNegImpl");
        TipoSancionDTO registro = null;
        try{
            registro = tipoSancionDAO.create(tipoSancionDTO, usuarioDTO);
            LOG.info("(Registro Tipo Sancion ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("Error en guardarTipoSancion",ex);
            throw new TipoSancionException(ex.getMessage(),null);
        }
        return registro;
    }

    @Override
    @Transactional(rollbackFor=TipoSancionException.class)
    public TipoSancionDTO eliminarTipoSancion(TipoSancionDTO tipoSancionDTO) throws TipoSancionException{
        LOG.info("Eliminar Tipo Sancion ServiceNegImpl");
        TipoSancionDTO eliminar = null;
        try{
            eliminar = tipoSancionDAO.changeState(tipoSancionDTO, Constantes.CONSTANTE_ESTADO_INACTIVO);
            LOG.info("(Eliminar Tipo Sancion ServiceNegImpl) eliminar: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("Error eliminarEtapa",ex);
            throw new TipoSancionException(ex.getMessage(),null);
        }
        return eliminar;
    }
    
}