/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.business.TramiteServiceNeg;
import gob.osinergmin.myc.service.dao.TramiteDAO;
import gob.osinergmin.myc.service.exception.TramiteException;
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
@Service("TramiteServiceNeg")
public class TramiteServiceNegImpl implements TramiteServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(RequisitoServiceNegImpl.class);
    @Inject
    private TramiteDAO tramiteDAO;
    
    @Override
    public List<TramiteDTO> findTramiteByFilter(TramiteFilter filtro){
        LOG.info("Neg findTramiteByFilter");
        List<TramiteDTO> retorno=null;
        try{
            retorno = tramiteDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    @Transactional(rollbackFor=TramiteException.class)
    public TramiteDTO guardarTramite(TramiteDTO tramiteDTO, UsuarioDTO usuarioDTO) throws TramiteException {
        LOG.info("Registro Tramite ServiceNegImpl");
        TramiteDTO registro = null;
        try{
            registro = tramiteDAO.create(tramiteDTO, usuarioDTO);
            LOG.info("(Registro Tramite ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("Error en guardarTramite, ",ex);
            throw new TramiteException(ex.getMessage(),null);
        }
        return registro;
    }

    @Override
    @Transactional(rollbackFor=TramiteException.class)
    public TramiteDTO eliminarTramite(TramiteDTO tramiteDTO) throws TramiteException{
        LOG.info("Eliminar Tramite ServiceNegImpl");
        TramiteDTO eliminar = null;
        try{
            eliminar = tramiteDAO.changeState(tramiteDTO, Constantes.CONSTANTE_ESTADO_INACTIVO);
            LOG.info("(Eliminar Tramite ServiceNegImpl) eliminar: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("Error eliminarTramite",ex);
            throw new TramiteException(ex.getMessage(),null);
        }
        return eliminar;
    }
}
