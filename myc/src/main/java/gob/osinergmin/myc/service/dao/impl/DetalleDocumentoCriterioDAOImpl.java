/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghDetalleDocumentoCriterio;
import gob.osinergmin.myc.domain.builder.DetalleDocumentoCriterioBuilder;
import gob.osinergmin.myc.domain.dto.DetalleDocumentoCriterioDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.DetalleDocumentoCriterioDAO;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lchancayauri
 */
@Service
@Transactional
public class DetalleDocumentoCriterioDAOImpl implements DetalleDocumentoCriterioDAO{
    
    private static final Logger LOG = LoggerFactory.getLogger(DetalleDocumentoCriterioDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public DetalleDocumentoCriterioDTO create(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO,UsuarioDTO usuarioDTO) {
        LOG.info("Registro Detalle Documento Criterio DAO Impl");
        DetalleDocumentoCriterioDTO retorno = null;
        try{
            PghDetalleDocumentoCriterio detalleDocumentoCriterio = DetalleDocumentoCriterioBuilder.getDetalleDocumentoCriterio(detalleDocumentoCriterioDTO);
            detalleDocumentoCriterio.setDatosAuditoria(usuarioDTO);
            if(detalleDocumentoCriterio.getCodTrazabilidad()!=null && !detalleDocumentoCriterio.getCodTrazabilidad().equals("")){
                crud.createWithHistory(detalleDocumentoCriterio);
            }else{
                crud.create(detalleDocumentoCriterio);
            }
            
            retorno = DetalleDocumentoCriterioBuilder.toDetalleDocumentoCriterioDto(detalleDocumentoCriterio);
            LOG.info("(Registro Detalle Criterio DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public DetalleDocumentoCriterioDTO update(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO,UsuarioDTO usuarioDTO) {
        LOG.info("Actualizar Registro Detalle Documento Criterio DAO Impl");
        DetalleDocumentoCriterioDTO retorno = null;
        try{
            PghDetalleDocumentoCriterio detalleDocumentoCriterio = DetalleDocumentoCriterioBuilder.getDetalleDocumentoCriterio(detalleDocumentoCriterioDTO);
            detalleDocumentoCriterio.setDatosAuditoria(usuarioDTO);
            if(detalleDocumentoCriterio.getCodTrazabilidad()!=null && !detalleDocumentoCriterio.getCodTrazabilidad().equals("")){
                crud.updateWithHistory(detalleDocumentoCriterio);
            }else{
                crud.update(detalleDocumentoCriterio);
            }
            
            retorno = DetalleDocumentoCriterioBuilder.toDetalleDocumentoCriterioDto(detalleDocumentoCriterio);
            LOG.info("(Actualizar Registro Detalle Documento Criterio DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public List<DetalleDocumentoCriterioDTO> obtenerDetalleDocumentoCriterio(Long idCriterio){
        LOG.info("-- DetalleCriterioDAO - obtenerDetalleDocumentoCriterio --");
        LOG.info("-- parametros idCriterio : " + idCriterio);
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select ddc ");
        jpql.append(" from PghDetalleDocumentoCriterio ddc ");
        jpql.append(" where 1=1 ");
        jpql.append(" and ddc.estado=1 ");
        if(idCriterio != null){
            jpql.append(" and ddc.idCriterio.idCriterio = ").append(idCriterio);
        }
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghDetalleDocumentoCriterio> lstDetalleDocumentoCriterio = query.getResultList();
        List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio = DetalleDocumentoCriterioBuilder.toListDetalleDocumentoCriterioDTO(lstDetalleDocumentoCriterio);
        return listaDetalleDocumentoCriterio;
    }
    
    @Override
    public DetalleDocumentoCriterioDTO obtenerDetalleDocumentoCriterioById(Long idDetalleDocumentoCriterio){
        LOG.info("-- DetalleDocumentoCriterioDAO - obtenerDetalleDocumentoCriterioById --");
        LOG.info("-- parametros idDetalleCriterio : " + idDetalleDocumentoCriterio);
        PghDetalleDocumentoCriterio detalleDocumentoCriterio = crud.find(idDetalleDocumentoCriterio, PghDetalleDocumentoCriterio.class);
        return DetalleDocumentoCriterioBuilder.toDetalleDocumentoCriterioDto(detalleDocumentoCriterio);
    }
    
    @Override
    public DetalleDocumentoCriterioDTO changeState(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO) {
        DetalleDocumentoCriterioDTO retorno = null;
        try{
            PghDetalleDocumentoCriterio registroDTO = crud.find(detalleDocumentoCriterioDTO.getIdDetalleDocumentoCriterio(), PghDetalleDocumentoCriterio.class);
            registroDTO.setEstado(detalleDocumentoCriterioDTO.getEstado());
            crud.update(registroDTO);
            retorno = DetalleDocumentoCriterioBuilder.toDetalleDocumentoCriterioDto(registroDTO);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
}
