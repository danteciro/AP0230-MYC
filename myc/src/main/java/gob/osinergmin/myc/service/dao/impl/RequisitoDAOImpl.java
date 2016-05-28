/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghRequisito;
import gob.osinergmin.myc.domain.builder.PghCnfRequProcedimientoBuilder;
import gob.osinergmin.myc.domain.builder.ProcedimientoBuilder;
import gob.osinergmin.myc.domain.builder.RequisitoBuilder;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.RequisitoFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.exception.RequisitoException;
import gob.osinergmin.myc.util.PropertyUtils;

import java.io.File;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("requisitoDAO")
public class RequisitoDAOImpl implements RequisitoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(RequisitoDAO.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public RequisitoDTO changeEstado(RequisitoDTO registroDTO, UsuarioDTO usuarioDTO) throws RequisitoException{
        RequisitoDTO retorno = null;
        try{
            PghRequisito registroDAO = crud.find(registroDTO.getIdRequisito(), PghRequisito.class);
            registroDAO.setEstado(registroDTO.getEstado());
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=RequisitoBuilder.toRequisitoDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(RequisitoException.ERROR_CREAR_REQUISITO),e);
            RequisitoException e2 = new RequisitoException(RequisitoException.ERROR_CREAR_REQUISITO,e, true);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public RequisitoDTO edit(RequisitoDTO registroDTO, UsuarioDTO usuarioDTO) throws RequisitoException{
        RequisitoDTO retorno = null;
        try{
            LOG.info("registroDTO.getFlgEditoComentario()-->"+registroDTO.getFlgEditoComentario());
            if(registroDTO.getFlgEditoComentario().equals("1")){
                Long ProcAct=actualizaComenRequiEnProcedimientos(registroDTO,usuarioDTO);
                LOG.info("RequisitoProcedimientos con comentarioPredet actualizados="+ProcAct);
            }
            
            PghRequisito registroDAO = RequisitoBuilder.getRequisito(registroDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=RequisitoBuilder.toRequisitoDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(RequisitoException.ERROR_CREAR_REQUISITO),e);
            RequisitoException e2 = new RequisitoException(RequisitoException.ERROR_CREAR_REQUISITO,e, true);
            throw e2;
        }
        return retorno;
    }
    
    public Long actualizaComenRequiEnProcedimientos(RequisitoDTO requisitoDTO,UsuarioDTO usuarioDTO){
        Long total=new Long(0);
        
        String queryString;
        StringBuilder jpql = new StringBuilder();
        
        jpql.append("UPDATE PghCnfRequProcedimiento p set p.comentario=:comentarioNuevo, "
                + "p.usuarioActualizacion=:usuarioActualizacion, "
                + "p.fechaActualizacion=:fechaActualizacion, "
                + "p.terminalActualizacion=:terminalActualizacion ");
        jpql.append("WHERE p.estado='1' and p.idRequisitoProcedimiento in ( "
                        + "SELECT pt.idRequisitoProcedimiento from PghCnfRequProcedimiento pt "
                        + "where pt.idRequisito.idRequisito=:idRequisito and pt.comentario=( "
                            + "SELECT rt.comentarioPredeterminado from PghRequisito rt where rt.idRequisito=:idRequisito"
                            + " ) "
                    + " ) " );
        
        //Crear QUERY
        queryString = jpql.toString();
        Query query = this.crud.getEm().createQuery(queryString);
        query.setParameter("comentarioNuevo",requisitoDTO.getComentarioPredeterminado());
        query.setParameter("idRequisito",requisitoDTO.getIdRequisito());
        query.setParameter("usuarioActualizacion",usuarioDTO.getCodigo());
        query.setParameter("fechaActualizacion",new Date());
        query.setParameter("terminalActualizacion",usuarioDTO.getTerminal());
        total=new Long(query.executeUpdate());
        return total;
    }
    
    @Override
    public RequisitoDTO create(RequisitoDTO registroDTO ,UsuarioDTO usuarioDTO) throws RequisitoException{
        RequisitoDTO retorno = null;
        try{
            PghRequisito registroDAO = RequisitoBuilder.getRequisito(registroDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.create(registroDAO);
            
            retorno=RequisitoBuilder.toRequisitoDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(RequisitoException.ERROR_CREAR_REQUISITO),e);
            RequisitoException e2 = new RequisitoException(RequisitoException.ERROR_CREAR_REQUISITO,e, true);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public List<RequisitoDTO> verificaRequisitoSimilar(RequisitoFilter filtro) throws RequisitoException{
        List<RequisitoDTO> retorno=null;
        String queryString;
        StringBuilder jpql = new StringBuilder();
        try{
            jpql.append("SELECT new PghRequisito(p.descripcion) ");
           
            jpql.append("FROM PghRequisito p where p.estado='1'" );
            jpql.append(" and upper(p.descripcion) like '%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%' ");
            //Crear QUERY
            queryString = jpql.toString();
            Query query = this.crud.getEm().createQuery(queryString);
            
            //query.setParameter("idEstadoProcesoVigente",filtro.getIdEstadoProcesoVigente());
            retorno = RequisitoBuilder.toListRequisitoDto(query.getResultList());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        
        return retorno;
    }
    
    @Override
    public List<RequisitoDTO> validarRequisitoIdentico(RequisitoFilter filtro) throws RequisitoException{
        List<RequisitoDTO> retorno=null;
        String queryString;
        StringBuilder jpql = new StringBuilder();
        try{
            jpql.append("SELECT new PghRequisito(p.descripcion) ");           
            jpql.append("FROM PghRequisito p where p.estado='1'" );
            jpql.append(" and upper(p.descripcion) = '"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"'");
            //Crear QUERY
            queryString = jpql.toString();
            Query query = this.crud.getEm().createQuery(queryString);
            
            //query.setParameter("idEstadoProcesoVigente",filtro.getIdEstadoProcesoVigente());
            retorno = RequisitoBuilder.toListRequisitoDto(query.getResultList());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        
        return retorno;
    }
    
    @Override
    public List<RequisitoDTO> find(RequisitoFilter filtro) throws RequisitoException {
        List<RequisitoDTO> listado;
        
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = RequisitoBuilder.toListRequisitoDto(query.getResultList());

        return listado;
    }
    
    @Override
    public List<CnfRequProcedimientoDTO>obtenerDependencias(RequisitoFilter filtro) {
		List<CnfRequProcedimientoDTO> listado=null;
		Query query;
		try{
			StringBuilder jpql = new StringBuilder();
        	//
        	jpql.append("select new PghCnfRequProcedimiento(cr.idProcedimiento.idProcedimiento,cr.idProcedimiento.item ,cr.idProcedimiento.denominacion)" );
        	jpql.append(" from PghCnfRequProcedimiento cr where cr.estado=1" );
        	if (!StringUtil.isEmptyNum(filtro.getIdRequisito())) {
        	jpql.append(" and  cr.idRequisito.idRequisito=:idRequisito ");
        	}
        	query = crud.getEm().createQuery(jpql.toString());
        	
        	if (!StringUtil.isEmptyNum(filtro.getIdRequisito())) {
                query.setParameter("idRequisito",filtro.getIdRequisito());
            }
        	
        	listado= PghCnfRequProcedimientoBuilder.toListProcedimientoDto(query.getResultList());
			
		}catch(Exception e){
			LOG.error("Error getValidarDependencia : " + e.getMessage());
		}
	      
		
    	return listado;
    	
    }
    
    @Override
    public Long count(RequisitoFilter filtro) throws RequisitoException {
        Query query = getFindQuery(filtro, true);
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(RequisitoFilter filtro, boolean count) {
        Query query=null;
        try{
            if (count) {
                if (filtro.getIdRequisito()!= null) {
                    query = crud.getEm().createNamedQuery("PghRequisito.countByIdRequisito");
                }else {
                    query = crud.getEm().createNamedQuery("PghRequisito.countByFilter");
                }
            }else {
                if (filtro.getIdRequisito()!= null) {
                    query = crud.getEm().createNamedQuery("PghRequisito.findByIdRequisito");
                }else {
                    query = crud.getEm().createNamedQuery("PghRequisito.findByFilter");
                }
            }

            if (filtro.getIdRequisito()!= null) {
                query.setParameter("idRequisito",filtro.getIdRequisito());
            }
            if (filtro.getDescripcion()!= null){
                query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    
 
}
