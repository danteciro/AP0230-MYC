/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghDetalleObligacion;
import gob.osinergmin.myc.domain.builder.DetalleObligacionBuilder;
import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.DetalleObligacionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.DetalleObligacionDAO;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lbarboza
 */
@Service
@Transactional
public class DetalleObligacionDAOImpl implements DetalleObligacionDAO{
    private static final Logger LOG = LoggerFactory.getLogger(DetalleObligacionDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public DetalleObligacionDTO create(DetalleObligacionDTO detalleObligacionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Detalle Obligacion DAO Impl");
        DetalleObligacionDTO retorno = null;
        try{
            PghDetalleObligacion detalleObligacion = DetalleObligacionBuilder.getDetalleObligacion(detalleObligacionDTO);
            detalleObligacion.setDatosAuditoria(usuarioDTO);
            if(detalleObligacion.getCodTrazabilidad()!=null && !detalleObligacion.getCodTrazabilidad().equals("")){
                crud.createWithHistory(detalleObligacion);
            }else{
                crud.create(detalleObligacion);
            }
            
            retorno = DetalleObligacionBuilder.toDetalleObligacionDto(detalleObligacion);
            LOG.info("(Registro Detalle Obligacion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public DetalleObligacionDTO changeState(DetalleObligacionDTO detalleObligacionDTO) {
        DetalleObligacionDTO retorno = null;
        try{
            PghDetalleObligacion registroDTO = crud.find(detalleObligacionDTO.getIdDetalleObligacion(), PghDetalleObligacion.class);
            registroDTO.setEstado(detalleObligacionDTO.getEstado());
            crud.update(registroDTO);
            retorno = DetalleObligacionBuilder.toDetalleObligacionDto(registroDTO);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public List<DetalleObligacionDTO> find(DetalleObligacionFilter filtro) {
        List<DetalleObligacionDTO> listado = null;
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        listado = DetalleObligacionBuilder.toListDetalleObligacionDto(query.getResultList());
        LOG.info("listado: "+listado.size());
        return listado;
    }

    @Override
    public Long count(DetalleObligacionFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(DetalleObligacionFilter filtro, boolean count){
        Query query = null;
        try{
            if(count){
                if(filtro.getIdDetalleObligacion() != null){
                    query = crud.getEm().createNamedQuery("PghDetalleObligacion.countByIdDetalleObligacion");
                }else{
                    query = crud.getEm().createNamedQuery("PghDetalleObligacion.countByFilter");
                }
            }else{
                if(filtro.getIdDetalleObligacion() != null){
                    query = crud.getEm().createNamedQuery("PghDetalleObligacion.findByIdDetalleObligacion");
                }else{
                    query = crud.getEm().createNamedQuery("PghDetalleObligacion.findByFilter");
                }
            }
            
            if(filtro.getIdDetalleObligacion() != null){
                query.setParameter("idDetalleObligacion", filtro.getIdDetalleObligacion());
            }
            if(filtro.getDescripcion() != null){
                query.setParameter("descripcion", filtro.getDescripcion());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

	@Override
	public DetalleObligacionDTO update(DetalleObligacionDTO detalleObligacionDTO,
			UsuarioDTO usuarioDTO) {
		LOG.info("Actualizar Detalle Obligacion DAO Impl");
        DetalleObligacionDTO retorno = null;
        try{
        	
            PghDetalleObligacion detalleObligacion = crud.find(detalleObligacionDTO.getIdDetalleObligacion(),PghDetalleObligacion.class);
            detalleObligacion.setDescripcion(detalleObligacionDTO.getDescripcion());
            detalleObligacion.setDatosAuditoria(usuarioDTO);
            if(detalleObligacion.getIdDocumentoAdjunto() == null ){
                detalleObligacion.setIdDocumentoAdjunto(detalleObligacionDTO.getIdDocumentoAdjunto());
            }else{
                if(detalleObligacionDTO.getIdDocumentoAdjunto() != null){
                    detalleObligacion.setIdDocumentoAdjunto(detalleObligacionDTO.getIdDocumentoAdjunto());
                }
            }
            detalleObligacion.setCodTrazabilidad(detalleObligacionDTO.getCodTrazabilidad());
            if(detalleObligacion.getCodTrazabilidad()!=null && !detalleObligacion.getCodTrazabilidad().equals("")){
                crud.updateWithHistory(detalleObligacion);
            }else{
                crud.update(detalleObligacion);
            }
            
            retorno = DetalleObligacionBuilder.toDetalleObligacionDto(detalleObligacion);
            LOG.info("(Actualizar Detalle Obligacion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}
    
}