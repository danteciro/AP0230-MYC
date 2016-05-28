/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.ConcursoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConcursoFilter;
import gob.osinergmin.myc.service.business.ConcursoServiceNeg;
import gob.osinergmin.myc.service.dao.ConcursoDAO;
import gob.osinergmin.myc.service.exception.ConcursoException;
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
@Service("concursoServiceNeg")
public class ConcursoServiceNegImpl implements ConcursoServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(ConcursoServiceNegImpl.class);
    @Inject
    private ConcursoDAO concursoDAO;

    @Override
    public List<ConcursoDTO> obtenerListadoConcurso(ConcursoFilter filtro, int[] cuenta) {
        List<ConcursoDTO> retorno = null;
        LOG.info("Neg obtenerListadoConcurso");
        try{
            HashMap resultado = new HashMap();
            
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO.charAt(0));
            resultado = concursoDAO.obtenerConcurso(filtro);
            retorno = (List<ConcursoDTO>)resultado.get("listado");
            Long contador = (Long)resultado.get("cuenta");
            cuenta[0] = contador.intValue();
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    @Transactional
    public ConcursoDTO guardarConcurso(ConcursoDTO concursoDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Concurso ServiceNegImpl");
        ConcursoDTO registro = null;
        try{
            registro = concursoDAO.create(concursoDTO, usuarioDTO);
            LOG.info("(Registro Concurso ServiceNegImpl) registro: "+registro.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return registro;
    }

    @Override
    @Transactional(rollbackFor= ConcursoException.class)
    public ConcursoDTO eliminarConcurso(ConcursoDTO concursoDTO) throws ConcursoException{
        LOG.info("eliminarConcurso");
        ConcursoDTO eliminar = null;
        try{
            eliminar = concursoDAO.changeState(concursoDTO, Constantes.CONSTANTE_ESTADO_INACTIVO);
            LOG.info("(Eliminar Concurso ServiceNegImpl) registro: "+eliminar.toString());
        }catch(Exception ex){
            LOG.error("Error eliminarConcurso",ex);
            throw new ConcursoException(ex.getMessage(),null);
        }
        return eliminar;
    }
    
}