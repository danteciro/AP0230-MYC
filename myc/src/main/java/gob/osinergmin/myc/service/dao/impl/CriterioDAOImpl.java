/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.domain.PghDetalleCriterio;
import gob.osinergmin.myc.domain.builder.CriterioBuilder;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.SancionEspecificaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CriterioFilter;
import gob.osinergmin.myc.domain.ui.CriterioImplFilter;
import gob.osinergmin.myc.service.dao.CriterioDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.NamedQuery;
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
public class CriterioDAOImpl implements CriterioDAO{
    private static final Logger LOG = LoggerFactory.getLogger(CriterioDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public CriterioDTO create(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO) {
        LOG.info("Registro Criterio DAO Impl");
        CriterioDTO retorno = null;
        try{
            PghCriterio criterio = CriterioBuilder.getCriterio(criterioDTO);
            criterio.setDatosAuditoria(usuarioDTO);
            if(criterio.getCodTrazabilidad()!=null && !criterio.getCodTrazabilidad().equals("")){
                crud.createWithHistory(criterio);
            }else{
                crud.create(criterio);
            }  

            LOG.info("create CriterioDAO registro ingresado ID: "+criterio.getIdCriterio());
            retorno = CriterioBuilder.toCriterioDto(criterio);
        }catch(Exception ex){
            LOG.error("Error en create criterioDAO : "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
    }
    
    @Override
    public CriterioDTO update(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO) {
        LOG.info("Registro Criterio DAO Impl");
        CriterioDTO retorno = null;
        try{
            PghCriterio criterio = CriterioBuilder.getCriterio(criterioDTO);
            criterio.setDatosAuditoria(usuarioDTO);
            if(criterio.getCodTrazabilidad()!=null && !criterio.getCodTrazabilidad().equals("")){
                crud.updateWithHistory(criterio);
            }else{
                crud.update(criterio);
            }
            
            retorno = CriterioBuilder.toCriterioDto(criterio);
            LOG.info("(Registro Criterio DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public CriterioDTO changeState(CriterioDTO criterioDTO) {
        CriterioDTO retorno = null;
        try{
            PghCriterio registroDTO = crud.find(criterioDTO.getIdCriterio(), PghCriterio.class);
            registroDTO.setEstado(criterioDTO.getEstado());
            registroDTO.setCodTrazabilidad(criterioDTO.getCodTrazabilidad());
            crud.updateWithHistory(registroDTO);
            retorno = CriterioBuilder.toCriterioDto(registroDTO);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public List<CriterioDTO> find(CriterioFilter filtro) {
        List<CriterioDTO> listado = null;
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        listado = CriterioBuilder.toListCriterioDto(query.getResultList());
        LOG.info("listado: "+listado.size());
        return listado;
    }

    @Override
    public Long count(CriterioFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(CriterioFilter filtro, boolean count){
        Query query=null;
        try{
            if(count){
                if(filtro.getIdCriterio() != null){
                    query = crud.getEm().createNamedQuery("PghCriterio.countByIdCriterio");
                }else{
                    query = crud.getEm().createNamedQuery("PghCriterio.countByFilter");
                }
            }else{
                if(filtro.getIdCriterio() != null){
                    query = crud.getEm().createNamedQuery("PghCriterio.findByIdCriterio");
                }else{
                    query = crud.getEm().createNamedQuery("PghCriterio.findByFilter");
                }
            }
            
            if(filtro.getIdCriterio() != null){
                query.setParameter("idCriterio",filtro.getIdCriterio());
            }
            if(filtro.getDescripcion() != null){
                query.setParameter("descripcion",filtro.getDescripcion());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
    
    @Override
    public List<CriterioDTO> obtenerCriterios(CriterioDTO criterio){
        LOG.info("-- CriterioDAO - obtenerCriterios --");
        LOG.info("-- parametros idObligacion : " + criterio.getIdObligacion());
        LOG.info("-- parametros idTipificacion : " + criterio.getIdTipificacion());
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select c, t ");
        jpql.append(" from PghCriterio c inner join c.idTipificacion t ");
        jpql.append(" where 1=1 ");
        jpql.append(" and c.estado=1 ");
        if(criterio.getIdObligacion() != null){
            jpql.append(" and c.idObligacion.idObligacion = ").append(criterio.getIdObligacion());
        }
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<Object[]> lstCriterio = query.getResultList();
        List<CriterioDTO> listaCriterio = CriterioBuilder.toListCriterio(lstCriterio);
        return listaCriterio;
    }
    
    @Override
    public CriterioDTO obtenerCriterioById(Long idCriterio){
        LOG.info("-- CriterioDAO - obtenerCriterioById --");
        LOG.info("-- parametros idCriterio : " + idCriterio);
        PghCriterio criterio = crud.find(idCriterio, PghCriterio.class);
        return CriterioBuilder.toCriterioMaestroDto(criterio);
    }

	@Override
	public Long countImpl(CriterioImplFilter filtro) {
		LOG.info("contador DAO IMPL");
        Query query = getFindImplQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
	}

	

	@Override
	public List<CriterioDTO> findImpl(CriterioImplFilter filtro) {
		List<CriterioDTO> listado=null;
		Long idCriterio=filtro.getIdCriterio();
        StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT distinct tipi.id_Tipificacion as idTipi,tipi.cod_Tipificacion as desctipi, crite.id_Criterio, crite.descripcion as desccrite,maestro.descripcion as descmaestro from pgh_criterio crite "
				+"inner join pgh_Obli_Tipi_Criterio oblitipi " 
				+"on (crite.id_Criterio=oblitipi.id_Criterio) "
				+"inner join pgh_Tipificacion tipi "
				+"on (oblitipi.id_Tipificacion=tipi.id_Tipificacion) " 
				+"inner join mdi_Maestro_Columna maestro "
				+"on (crite.tipo_Criterio=maestro.id_Maestro_Columna) "				
				+"WHERE crite.estado='1' and oblitipi.estado=1 ");
		jpql.append(" and crite.descripcion like '%"+filtro.getDescripcion()+"%' ");
		if(filtro.getIdsCriterios()!=null && filtro.getIdsCriterios()!="0"){
			jpql.append(" and crite.id_criterio not in(" + filtro.getIdsCriterios()+")");
		}
        Query query = crud.getEm().createNativeQuery(jpql.toString());        
        LOG.info("query findIdCriteriobyIdCriterio: " + jpql.toString());
        List<Object[]>  resultados = query.getResultList();
        System.out.println(" Lista de Resultados "+resultados);
        listado=CriterioBuilder.toListCriterioRefDto(resultados);
        return listado;
	}

	private Query getFindImplQuery(CriterioImplFilter filtro, boolean countImpl) {
		Query query=null;
        
        try{
            if (countImpl) {
                if (filtro.getIdCriterio()!= null) {
                    query = crud.getEm().createNamedQuery("PghCriterio.countByIdCriterio");
                }else{
                    query = crud.getEm().createNamedQuery("PghCriterio.countByFilter");
                }
            }else {
                if (filtro.getIdCriterio()!= null) {
                    query = crud.getEm().createNamedQuery("PghCriterio.findByIdCriterio");
                }else{
                    query = crud.getEm().createNamedQuery("PghCriterio.findByFilter");
                }
            }
            ////////////parametros
            if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")){
                LOG.info("sin parametros es busqueda avanzada..");
            }else{
                if (filtro.getIdCriterio()!= null) {
                    query.setParameter("idCriterio",filtro.getIdCriterio());
                }
                if (!StringUtil.isEmpty(filtro.getDescripcion())) {
                    query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
                }else{
                    query.setParameter("descripcion","%");
                }                
            }            
            
        }catch(Exception e){
            LOG.error("Error getFindImplQuery: "+e.getMessage());
        }        
        return query;
	}

	/**
	 * @author l_garcia
	 */
	
	@Override
	public CriterioDTO changeEstado(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO) {
		CriterioDTO retorno=null;		
		try{
            PghCriterio registroDAO = crud.find(criterioDTO.getIdCriterio(), PghCriterio.class);
            registroDAO.setEstado(criterioDTO.getEstado());
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            /** Cambia_de_Estado_al_Detalle **/
            StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghDetalleCriterio p WHERE p.estado='1' and p.idBaseLegal='"+criterioDTO.getIdCriterio()+"'");
            Query query = crud.getEm().createQuery(jpql.toString());
            LOG.info("query find Id Detalle: " + jpql.toString());
            List<PghDetalleCriterio> detalleUpd = query.getResultList();   
            LOG.info("Se procede a actualizar el detalle Criterio CON ID: " + detalleUpd);
            for(PghDetalleCriterio obj :detalleUpd){
            	LOG.info("Se procede a actualizar el listado Criterio CON IDS: " + obj.getIdDetalleCriterio());
            	PghDetalleCriterio detalleUpdate = crud.find(obj.getIdDetalleCriterio(), PghDetalleCriterio.class);
            	detalleUpdate.setEstado(criterioDTO.getEstado());
                detalleUpdate.setDatosAuditoria(usuarioDTO);
                crud.update(detalleUpdate);
            }
            
            retorno=CriterioBuilder.toCriterioDto(registroDAO);
        }catch(Exception e){
            e.printStackTrace();
        }
		return retorno;	
	}

	@Override
	public Long buscarSancionEspecifica(Long idCriterio) {
        LOG.info("contador DAO IMPL");
        LOG.info("ID CRITERIO : --> "+idCriterio);
        Query query=null;
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT count(p.idDetalleCriterio) FROM PghDetalleCriterio p ");
            jpql.append("WHERE p.estado=1 ");
            if(idCriterio!= null){
                jpql.append(" AND p.idCriterio.idCriterio = ").append(idCriterio);
            }
            String queryString = jpql.toString();
            query = crud.getEm().createQuery(queryString);
            LOG.info("salida contador DAO IMPL");
		} catch (Exception e) {
			e.printStackTrace();
		}
        LOG.info("Query : ' "+query.toString());
        return (Long) query.getSingleResult();
	}
	
}



