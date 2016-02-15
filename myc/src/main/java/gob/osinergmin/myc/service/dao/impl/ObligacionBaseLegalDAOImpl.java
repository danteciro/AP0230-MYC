/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.PghObligacionBaseLegal;
import gob.osinergmin.myc.domain.builder.ObligacionBaseLegalBuilder;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionBaseLegalFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ObligacionBaseLegalDAO;
import gob.osinergmin.myc.util.Constantes;
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
public class ObligacionBaseLegalDAOImpl implements ObligacionBaseLegalDAO{
    private static final Logger LOG = LoggerFactory.getLogger(ObligacionBaseLegalDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public ObligacionBaseLegalDTO create(ObligacionBaseLegalDTO obligacionBaseLegalDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Obligacion Base Legal DAO Impl");
        ObligacionBaseLegalDTO retorno = null;
        try{
            List<ObligacionBaseLegalDTO> relAct=crud.findRelacionOblg(obligacionBaseLegalDTO);
        	
            ObligacionBaseLegalDTO existe=MycUtil.existeObjectEnLista(obligacionBaseLegalDTO.getIdBaseLegal(), relAct);
            if(existe!=null){
                if(existe.getEstado().equals("0")){
                    Long idBaseLegal=obligacionBaseLegalDTO.getIdBaseLegal();
                    Long idObligacion=obligacionBaseLegalDTO.getIdObligacion();

                    existe.setIdBaseLegal(idBaseLegal);
                    existe.setIdObligacion(idObligacion);
                    existe.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    existe.setCodTrazabilidad(obligacionBaseLegalDTO.getCodTrazabilidad());
                    PghObligacionBaseLegal registro = ObligacionBaseLegalBuilder.getObligacionBaseLegal(existe);
                    registro.setDatosAuditoria(usuarioDTO);
                    if(registro.getCodTrazabilidad()!=null && !registro.getCodTrazabilidad().equals("")){
                        crud.createWithHistory(registro);
                    }else{
                        crud.create(registro);
                    }
                }else if(existe.getEstado().equals("1")){
                    LOG.info("No se hizo nada");
                }
            }

            if(existe==null){
                PghObligacionBaseLegal obligacionBaseLegal = ObligacionBaseLegalBuilder.getObligacionBaseLegal(obligacionBaseLegalDTO);
                obligacionBaseLegal.setDatosAuditoria(usuarioDTO);
                if(obligacionBaseLegal.getCodTrazabilidad()!=null && !obligacionBaseLegal.getCodTrazabilidad().equals("")){
                    crud.createWithHistory(obligacionBaseLegal);
                }else{
                    crud.create(obligacionBaseLegal);
                }
                retorno = ObligacionBaseLegalBuilder.toObligacionBaseLegalDto(obligacionBaseLegal);
            }
            
            LOG.info("(Registro Obligacion Base Legal DAO Impl) retorno: "+retorno);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public ObligacionBaseLegalDTO changeState(ObligacionBaseLegalDTO obligacionBaseLegalDTO) {
        ObligacionBaseLegalDTO retorno = null;
        try{
            PghObligacionBaseLegal registroDTO = crud.find(obligacionBaseLegalDTO.getIdOblBase(), PghObligacionBaseLegal.class);
            registroDTO.setEstado(obligacionBaseLegalDTO.getEstado());
            crud.update(registroDTO);
            retorno = ObligacionBaseLegalBuilder.toObligacionBaseLegalDto(registroDTO);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public List<ObligacionBaseLegalDTO> find(ObligacionBaseLegalFilter filtro) {
        List<ObligacionBaseLegalDTO> listado = null;
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        listado = ObligacionBaseLegalBuilder.toListObligacionBaseLegalDto(query.getResultList());
        LOG.info("listado: "+listado.size());
        return listado;
    }

    @Override
    public Long count(ObligacionBaseLegalFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(ObligacionBaseLegalFilter filtro, boolean count){
        Query query = null;
        try{
            if(count){
                if(filtro.getIdOblBase() != null){
                    query = crud.getEm().createNamedQuery("PghObligacionBaseLegal.countByIdOblBase");
                }else{
                    query = crud.getEm().createNamedQuery("PghObligacionBaseLegal.countByFilter");
                }
            }else{
                if(filtro.getIdOblBase() != null){
                    query = crud.getEm().createNamedQuery("PghObligacionBaseLegal.findByIdOblBase");
                }else{
                    query = crud.getEm().createNamedQuery("PghObligacionBaseLegal.findByFilter");
                }
            }
            
            if(filtro.getIdOblBase() != null){
                query.setParameter("idOblBase", filtro.getIdOblBase());
            }
            if(filtro.getIdObligacion() != null){
                query.setParameter("idObligacion", filtro.getIdObligacion());
            }
            if(filtro.getIdBaseLegal() != null){
                query.setParameter("idBaseLegal", filtro.getIdBaseLegal());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

    @Override
    public ObligacionBaseLegalDTO changeState(ObligacionBaseLegalDTO oblgBaseLegal,UsuarioDTO usuarioDTO) {
		LOG.info("Eliminar Obligacion Base Legal DAO Impl con ID:  --> " +oblgBaseLegal.getIdOblBase());
		LOG.info("Eliminar Obligacion Base Legal DAO Impl con ID:  --> " +oblgBaseLegal.getIdBaseLegal());
		LOG.info("Eliminar Obligacion Base Legal DAO Impl con ID:  --> " +oblgBaseLegal.getIdObligacion());
		
		ObligacionBaseLegalDTO retorno = null;
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p From PghObligacionBaseLegal p where p.estado='1' ");
            jpql.append("and p.idOblBase=:idOblgBaseLegal ");
            jpql.append("and p.idBaseLegal.idBaseLegal=:idBaseLegal ");
            jpql.append("and p.idObligacion.idObligacion=:idObligacion ");
            
    		Query 	query = crud.getEm().createQuery(jpql.toString());
    		query.setParameter("idOblgBaseLegal",oblgBaseLegal.getIdOblBase());
    		query.setParameter("idBaseLegal",oblgBaseLegal.getIdBaseLegal());
    		query.setParameter("idObligacion",oblgBaseLegal.getIdObligacion());
    		
	        LOG.info("query find Obligacion Base Legal: " + jpql.toString());
	        PghObligacionBaseLegal  resultado = (PghObligacionBaseLegal) query.getResultList().get(0);  
	        LOG.info(" Lista Relacion O - B ->"+resultado);
	        
	        resultado.setEstado("0");
	        resultado.setDatosAuditoria(usuarioDTO);
                resultado.setCodTrazabilidad(oblgBaseLegal.getCodTrazabilidad());
                if(resultado.getCodTrazabilidad()!=null && !resultado.getCodTrazabilidad().equals("")){
                    crud.updateWithHistory(resultado);
                }else{
                    crud.update(resultado);
                }
	        
	        
	        if(resultado!=null){
	        	retorno=ObligacionBaseLegalBuilder.toObligacionBaseLegalDto(resultado);;
	        }
	        
	        LOG.info("(Encontrar Obligacion By Id DAO IMPL) Saliendo... :Retorno: " + retorno);
        }catch(RuntimeException e) {
            LOG.error(e.getMessage(),e);   
            e.printStackTrace();
        }catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return retorno;
	}

	@Override
	public Long findByBaseLegal(BaseLegalDTO baseLegalDTO) {
		LOG.info("contador DAO IMPL By Base Legal");
		Query query = null;
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT count(p) From PghObligacionBaseLegal p where p.estado='1' ");
            jpql.append("and p.idBaseLegal.idBaseLegal=:idBaseLegal ");
            
    		query = crud.getEm().createQuery(jpql.toString());
    		query.setParameter("idBaseLegal",baseLegalDTO.getIdBaseLegal());
    		
        }catch(RuntimeException e) {
            LOG.error(e.getMessage(),e);   
            e.printStackTrace();
        }catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
        
        LOG.info("Salida contador DAO IMPL By Base Legal");
        return (Long) query.getSingleResult();
	}

	@Override
	public ObligacionBaseLegalDTO changeEstadoRelacion(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO) {
		ObligacionBaseLegalDTO retorno=null;
		Query query=null;
		try {
			/** Cambia de Estado al Listado de Obligaciones **/
	        StringBuilder jpql = new StringBuilder();
	        jpql.append("SELECT p From PghObligacionBaseLegal p where p.estado='1' ");
	        jpql.append("and p.idBaseLegal.idBaseLegal=:idBaseLegal ");;
	        query = crud.getEm().createQuery(jpql.toString());
			query.setParameter("idBaseLegal",baseLegalDTO.getIdBaseLegal());
			LOG.info("query find Listado Id's: " + jpql.toString());
			
			List<PghObligacionBaseLegal> listadoUpd=query.getResultList();
			LOG.info("SE PROCEDE A ACTUALIZAR EL LISTADO : " + listadoUpd);
			
			for(PghObligacionBaseLegal obj :listadoUpd){
	        	LOG.info("SE PROCEDE A ACTUALIZAR RELACION CON ID: " + obj.getIdOblBase());
	        	LOG.info("SE PROCEDE A ACTUALIZAR RELACION-BASE LEGAL CON ID: " + obj.getIdBaseLegal().getIdBaseLegal());
	        	LOG.info("SE PROCEDE A ACTUALIZAR RELACION-OBLIGACION CON ID: " + obj.getIdObligacion().getIdObligacion());
	        	
	        	Long idOblBl=obj.getIdOblBase();
	        	Long idBaseLegal=obj.getIdBaseLegal().getIdBaseLegal();
	        	Long idObligacion=obj.getIdObligacion().getIdObligacion();
	        	
	        	PghObligacionBaseLegal regListado = crud.findBlOblg(idOblBl, idBaseLegal, idObligacion);
	        	regListado.setEstado(baseLegalDTO.getEstado());
	        	regListado.setDatosAuditoria(usuarioDTO);
	            crud.update(regListado);
	        }
			
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);   
            e.printStackTrace();
		}

        return retorno;
	}

	@Override
	public Long findByObligacion(ObligacionNormativaDTO obligacionNormativaDTO) {
		LOG.info("contador DAO IMPL By Obligacion");
		Query query = null;
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT count(p) From PghObligacionBaseLegal p where p.estado='1' ");
            jpql.append("and p.idObligacion.idObligacion=:idObligacion ");
            
    		query = crud.getEm().createQuery(jpql.toString());
    		query.setParameter("idObligacion",obligacionNormativaDTO.getIdObligacion());
    		
        }catch(RuntimeException e) {
            LOG.error(e.getMessage(),e);   
            e.printStackTrace();
        }catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
        
        LOG.info("Salida contador DAO IMPL By Obligacion");
        return (Long) query.getSingleResult();
	}

	@Override
	public ObligacionBaseLegalDTO changeEstadoRelacion(
			ObligacionNormativaDTO obligacionNormativaDTO, UsuarioDTO usuarioDTO) {
		ObligacionBaseLegalDTO retorno=null;
		Query query=null;
		try {
			/** Cambia de Estado al Listado de Obligaciones **/
	        StringBuilder jpql = new StringBuilder();
	        jpql.append("SELECT p From PghObligacionBaseLegal p where p.estado='1' ");
	        jpql.append("and p.idObligacion.idObligacion=:idObligacion ");;
	        query = crud.getEm().createQuery(jpql.toString());
			query.setParameter("idObligacion",obligacionNormativaDTO.getIdObligacion());
			LOG.info("query find Listado Id's: " + jpql.toString());
			
			List<PghObligacionBaseLegal> listadoUpd=query.getResultList();
			LOG.info("SE PROCEDE A ACTUALIZAR EL LISTADO : " + listadoUpd);
			
			for(PghObligacionBaseLegal obj :listadoUpd){
	        	LOG.info("SE PROCEDE A ACTUALIZAR RELACION CON ID: " + obj.getIdOblBase());
	        	LOG.info("SE PROCEDE A ACTUALIZAR RELACION-BASE LEGAL CON ID: " + obj.getIdBaseLegal().getIdBaseLegal());
	        	LOG.info("SE PROCEDE A ACTUALIZAR RELACION-OBLIGACION CON ID: " + obj.getIdObligacion().getIdObligacion());
	        	
	        	Long idOblBl=obj.getIdOblBase();
	        	Long idBaseLegal=obj.getIdBaseLegal().getIdBaseLegal();
	        	Long idObligacion=obj.getIdObligacion().getIdObligacion();
	        	
	        	PghObligacionBaseLegal regListado = crud.findBlOblg(idOblBl, idBaseLegal, idObligacion);
	        	regListado.setEstado(obligacionNormativaDTO.getEstado());
	        	regListado.setDatosAuditoria(usuarioDTO);
	            crud.update(regListado);
	        }
			
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);   
            e.printStackTrace();
		}

        return retorno;
	}
// 03-11-2015	
	@Override
	public ObligacionBaseLegalDTO creaRelacionOblBl(ObligacionBaseLegalDTO relacion, UsuarioDTO usuarioDTO) {
		ObligacionBaseLegalDTO retorno = new ObligacionBaseLegalDTO();
		try {
			PghObligacionBaseLegal registro = ObligacionBaseLegalBuilder.getObligacionBaseLegal(relacion);
			registro.setDatosAuditoria(usuarioDTO);
			if(relacion.getCodTrazabilidad()!=null && !relacion.getCodTrazabilidad().equals("")){
                crud.createWithHistory(registro);
            }else{
            	crud.create(registro);
            }
			
			retorno=ObligacionBaseLegalBuilder.toObligacionBaseLegalDto(registro);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}	
//	
}