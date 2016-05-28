/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.domain.PghDetalleCriterio;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.PghTipificacionSancion;
import gob.osinergmin.myc.domain.PghTipoSancion;
import gob.osinergmin.myc.domain.builder.DetalleCriterioBuilder;
import gob.osinergmin.myc.domain.builder.TipificacionSancionBuilder;
import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.DetalleCriterioFilter;
import gob.osinergmin.myc.domain.ui.DetalleCriterioImplFilter;
import gob.osinergmin.myc.domain.ui.TipificacionSancionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.DetalleCriterioDAO;
import gob.osinergmin.myc.service.dao.TipificacionSancionDAO;
import gob.osinergmin.myc.service.exception.DetalleCriterioException;
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
public class DetalleCriterioDAOImpl implements DetalleCriterioDAO{
    private static final Logger LOG = LoggerFactory.getLogger(DetalleCriterioDAOImpl.class);
    
    @Inject
    private CrudDAO crud;
    @Inject
    private TipificacionSancionDAO tipificacionSancionDAO;

    @Override
    public DetalleCriterioDTO eliminarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException {
        LOG.info("eliminarSancionEspecifica");
        DetalleCriterioDTO retorno = null;
        try{
            PghDetalleCriterio detalleCriterio=crud.find(detalleCriterioDTO.getIdDetalleCriterio(), PghDetalleCriterio.class);
            
            //PghDetalleCriterio detalleCriterio = new PghDetalleCriterio();
            detalleCriterio.setDatosAuditoria(usuarioDTO);
            detalleCriterio.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            crud.update(detalleCriterio);
            
            List<TipificacionSancionDTO> listaAct=tipificacionSancionDAO.buscTipifSancByIdDetalleCriterio(new TipificacionSancionFilter(detalleCriterioDTO.getIdDetalleCriterio(),Constantes.CONSTANTE_ESTADO_ACTIVO));
            
            for(TipificacionSancionDTO regAct: listaAct){
                LOG.info("Eliminado logico TipiSancion-->"+regAct.getIdTipoSancion());
                LOG.info("reg.Act="+regAct.getIdTipiSanc());
                PghTipificacionSancion tipiSancDel=crud.find(regAct.getIdTipiSanc(), PghTipificacionSancion.class);
                tipiSancDel.setDatosAuditoria(usuarioDTO);
                tipiSancDel.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                crud.update(tipiSancDel);
            }
                        
            retorno = DetalleCriterioBuilder.toDetalleCriterioDto(detalleCriterio);
        }catch(Exception ex){
            LOG.error("error create eliminarSancionEspecifica",ex);
            DetalleCriterioException e2 = new DetalleCriterioException(ex.getMessage(), ex);
            throw e2;
        }
        return retorno;
    }
    @Override
    public DetalleCriterioDTO editarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException {
        LOG.info("editarSancionEspecifica");
        DetalleCriterioDTO retorno = null;
        try{
            PghDetalleCriterio detalleCriterio=crud.find(detalleCriterioDTO.getIdDetalleCriterio(), PghDetalleCriterio.class);
            
            //PghDetalleCriterio detalleCriterio = new PghDetalleCriterio();
            detalleCriterio.setDatosAuditoria(usuarioDTO);
            detalleCriterio.setSancionEspecifica(detalleCriterioDTO.getSancionEspecifica());
            detalleCriterio.setTipoSancionEspecifica(new MdiMaestroColumna(detalleCriterioDTO.getTipoSancionEspecifica()));
            detalleCriterio.setSancionMonetaria(detalleCriterioDTO.getSancionMonetaria());
            detalleCriterio.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            crud.update(detalleCriterio);
            
            List<TipificacionSancionDTO> listaAct=tipificacionSancionDAO.buscTipifSancByIdDetalleCriterio(new TipificacionSancionFilter(detalleCriterioDTO.getIdDetalleCriterio(),Constantes.CONSTANTE_ESTADO_ACTIVO));
            List<TipificacionSancionDTO> listaUpd=detalleCriterioDTO.getTipificacionSancion();
            
            
            String txtTipoSancAct=MycUtil.concatenaTipificacionSancion(listaAct);
            LOG.info("Act---->"+txtTipoSancAct);
            String txtTipoSancUpd=MycUtil.concatenaTipificacionSancion(listaUpd);
            LOG.info("Upd---->"+txtTipoSancUpd);
            
            if(!txtTipoSancAct.equals(txtTipoSancUpd)){
                LOG.info("Se modifico TipiSanciones");
                if(listaUpd!=null){
                    for(TipificacionSancionDTO regUpd: listaUpd){
                        boolean existe=MycUtil.existeIdSancionEnLista(regUpd.getIdTipoSancion(),listaAct);
                        if(!existe){
                            LOG.info("creo registro-"+regUpd.getIdTipoSancion());
                            PghTipificacionSancion tipiSanc=new PghTipificacionSancion();
                            tipiSanc.setDatosAuditoria(usuarioDTO);
                            tipiSanc.setPghTipoSancion(new PghTipoSancion(regUpd.getIdTipoSancion()));
                            tipiSanc.setPghTipificacion(new PghTipificacion(regUpd.getIdTipificacion()));
                            tipiSanc.setIdCriterio(new PghCriterio(detalleCriterioDTO.getIdCriterio()));
                            tipiSanc.setIdDetalleCriterio(new PghDetalleCriterio(detalleCriterio.getIdDetalleCriterio()));
                            tipiSanc.setNivel(new MdiMaestroColumna(detalleCriterioDTO.getNivel()));
                            tipiSanc.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                            crud.create(tipiSanc);
                        }
                    }
                }
                for(TipificacionSancionDTO regAct: listaAct){
                    boolean existe=MycUtil.existeIdSancionEnLista(regAct.getIdTipoSancion(),listaUpd);
                    if(!existe){
                        LOG.info("Eliminado logico TipiSancion-->"+regAct.getIdTipoSancion());
                        LOG.info("reg.Act="+regAct.getIdTipiSanc());
                        PghTipificacionSancion tipiSancDel=crud.find(regAct.getIdTipiSanc(), PghTipificacionSancion.class);
                        tipiSancDel.setDatosAuditoria(usuarioDTO);
                        tipiSancDel.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                        crud.update(tipiSancDel);
                    }
                }
            }
            
            retorno = DetalleCriterioBuilder.toDetalleCriterioDto(detalleCriterio);
        }catch(Exception ex){
            LOG.error("error create editarSancionEspecifica",ex);
            DetalleCriterioException e2 = new DetalleCriterioException(ex.getMessage(), ex);
            throw e2;
        }
        return retorno;
    }
    @Override
    public DetalleCriterioDTO createSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException {
        LOG.info("createSancionEspecifica");
        DetalleCriterioDTO retorno = null;
        try{
            PghDetalleCriterio detalleCriterio = new PghDetalleCriterio();
            detalleCriterio.setDatosAuditoria(usuarioDTO);
            detalleCriterio.setIdCriterio(new PghCriterio(detalleCriterioDTO.getIdCriterio()));
            detalleCriterio.setSancionEspecifica(detalleCriterioDTO.getSancionEspecifica());
            detalleCriterio.setTipoSancionEspecifica(new MdiMaestroColumna(detalleCriterioDTO.getTipoSancionEspecifica()));
            detalleCriterio.setSancionMonetaria(detalleCriterioDTO.getSancionMonetaria());
            detalleCriterio.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            crud.create(detalleCriterio);
            if(detalleCriterioDTO.getTipificacionSancion()!=null){
                for(TipificacionSancionDTO reg : detalleCriterioDTO.getTipificacionSancion()){
                    PghTipificacionSancion tipiSanc=new PghTipificacionSancion();
                    tipiSanc.setDatosAuditoria(usuarioDTO);
                    tipiSanc.setPghTipoSancion(new PghTipoSancion(reg.getIdTipoSancion()));
                    tipiSanc.setPghTipificacion(new PghTipificacion(reg.getIdTipificacion()));
                    tipiSanc.setIdCriterio(new PghCriterio(detalleCriterioDTO.getIdCriterio()));
                    tipiSanc.setIdDetalleCriterio(new PghDetalleCriterio(detalleCriterio.getIdDetalleCriterio()));
                    tipiSanc.setNivel(new MdiMaestroColumna(detalleCriterioDTO.getNivel()));
                    tipiSanc.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    crud.create(tipiSanc);
                }
            }
            retorno = DetalleCriterioBuilder.toDetalleCriterioDto(detalleCriterio);
        }catch(Exception ex){
            LOG.error("error create createSancionEspecifica",ex.getMessage());
            DetalleCriterioException e2 = new DetalleCriterioException(ex.getMessage(), ex);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public DetalleCriterioDTO create(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) {
        LOG.info("Registro Detalle Criterio DAO Impl");
        DetalleCriterioDTO retorno = null;
        try{
            PghDetalleCriterio detalleCriterio = DetalleCriterioBuilder.getDetalleCriterio(detalleCriterioDTO);
            detalleCriterio.setDatosAuditoria(usuarioDTO);
            if(detalleCriterio.getCodTrazabilidad()!=null && !detalleCriterio.getCodTrazabilidad().equals("")){
                crud.createWithHistory(detalleCriterio);
            }else{
                crud.create(detalleCriterio);
            }
            
            retorno = DetalleCriterioBuilder.toDetalleCriterioDto(detalleCriterio);
            LOG.info("(Registro Detalle Criterio DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public DetalleCriterioDTO changeState(DetalleCriterioDTO detalleCriterioDTO) {
        DetalleCriterioDTO retorno = null;
        try{
            PghDetalleCriterio registroDTO = crud.find(detalleCriterioDTO.getIdDetalleCriterio(), PghDetalleCriterio.class);
            registroDTO.setEstado(detalleCriterioDTO.getEstado());
            registroDTO.setCodTrazabilidad(detalleCriterioDTO.getCodTrazabilidad());
            if(registroDTO.getCodTrazabilidad()!=null && !registroDTO.getCodTrazabilidad().equals("")){
                crud.updateWithHistory(registroDTO);
            }else{
                crud.update(registroDTO);
            }
            
            retorno = DetalleCriterioBuilder.toDetalleCriterioDto(registroDTO);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public List<DetalleCriterioDTO> find(DetalleCriterioFilter filtro) {
        List<DetalleCriterioDTO> listado = null;
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        listado = DetalleCriterioBuilder.toListDetalleCriterioDto(query.getResultList());
        LOG.info("listado: "+listado.size());
        return listado;
    }

    @Override
    public Long count(DetalleCriterioFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(DetalleCriterioFilter filtro, boolean count){
        Query query = null;
        try{
            if(count){
                if(filtro.getIdDetalleCriterio() != null){
                    query = crud.getEm().createNamedQuery("PghDetalleCriterio.countByIdDetalleCriterio");
                }else{
                    query = crud.getEm().createNamedQuery("PghDetalleCriterio.countByFilter");
                }
            }else{
                if(filtro.getIdDetalleCriterio() != null){
                    query = crud.getEm().createNamedQuery("PghDetalleCriterio.findByIdDetalleCriterio");
                }else{
                    query = crud.getEm().createNamedQuery("PghDetalleCriterio.findByFilter");
                }
            }
            
            if(filtro.getIdDetalleCriterio() != null){
                query.setParameter("idDetalleCriterio", filtro.getIdDetalleCriterio());
            }
            if(filtro.getSancionEspecifica() != null){
                query.setParameter("sancionEspecifica", filtro.getSancionEspecifica());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

    @Override
    public void deleteAllDetalleCriterio(Long idCriterio){
        LOG.info("deleteAllDetalle DAO IMPL");
        String query = "UPDATE PghDetalleCriterio dc SET dc.estado = 0 "
                + "WHERE dc.estado = 1 and dc.idCriterio.idCriterio ="+idCriterio;
        crud.getEm().createQuery(query).executeUpdate();
    }
    
    @Override
    public List<DetalleCriterioDTO> listarSancionEspecificaCriterio(Long idCriterio){
        LOG.info("-- DetalleCriterioDAO - listarSancionEspecificaCriterio --");
        LOG.info("-- parametros idCriterio : " + idCriterio);
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select dc ");
        jpql.append(" from PghDetalleCriterio dc ");
        jpql.append(" where dc.estado=1 ");
        jpql.append(" and dc.idCriterio.idCriterio = ").append(idCriterio);
        
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<DetalleCriterioDTO> listaDetalleCriterio = DetalleCriterioBuilder.toListDetalleCriterioDto(query.getResultList());
        
        for(DetalleCriterioDTO reg:listaDetalleCriterio){
            jpql = new StringBuilder();
            jpql.append(" select ts ");
            jpql.append(" from PghTipificacionSancion ts ");
            jpql.append(" where ts.estado=1 and ts.idDetalleCriterio.idDetalleCriterio=").append(reg.getIdDetalleCriterio());
            queryString = jpql.toString();
            query = crud.getEm().createQuery(queryString);
            List<TipificacionSancionDTO> lista = TipificacionSancionBuilder.getListaTipificacionSancion(query.getResultList());            
            reg.setTipificacionSancion(lista);
        }
        return listaDetalleCriterio;
    }
    @Override
    public List<DetalleCriterioDTO> obtenerDetalleCriterio(Long idCriterio){
    	LOG.info("-- DetalleCriterioDAO - obtenerDetalleCriterio --");
        LOG.info("-- parametros idCriterio : " + idCriterio);
        StringBuilder jpql = new StringBuilder();
        	jpql.append(" select dc ");
        	jpql.append(" from PghDetalleCriterio dc ");
        	jpql.append(" where 1=1 ");
        	jpql.append(" and dc.estado=1 ");
        if(idCriterio != null){
        	jpql.append(" and dc.idCriterio.idCriterio = ").append(idCriterio);
        }
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghDetalleCriterio> lstDetalleCriterio = query.getResultList();
        List<DetalleCriterioDTO> listaDetalleCriterio = DetalleCriterioBuilder.toListDetalleCriterioDto(lstDetalleCriterio);
        return listaDetalleCriterio;
    }
    
    @Override
    public DetalleCriterioDTO obtenerDetalleCriterioById(Long idDetalleCriterio){
        LOG.info("-- DetalleCriterioDAO - obtenerDetalleCriterioById --");
        LOG.info("-- parametros idDetalleCriterio : " + idDetalleCriterio);
        PghDetalleCriterio detalleCriterio = crud.find(idDetalleCriterio, PghDetalleCriterio.class);
        return DetalleCriterioBuilder.toDetalleCriterioDto(detalleCriterio);
    }

	@Override
	public Long countImpl(DetalleCriterioImplFilter filtro) {
		LOG.info("contador DAO IMPL");
        Query query = getFindImplQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
	}

	@Override
	public List<DetalleCriterioDTO> findImpl(DetalleCriterioImplFilter filtro) {
		List<DetalleCriterioDTO> listado=null;

        Query query = getFindImplQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        listado = DetalleCriterioBuilder.toListDetalleCriterioImplDto(query.getResultList());
        LOG.info("listado: "+listado.size());
        return listado;
	}

	private Query getFindImplQuery(DetalleCriterioImplFilter filtro, boolean countImpl) {
		
		Query query = null;
        try{
            if(countImpl){
                if(filtro.getIdCriterio() != null){
                	System.out.println("Hola");
                    query = crud.getEm().createNamedQuery("PghDetalleCriterio.countByFilterDetalle");
                }else{
                    query = crud.getEm().createNamedQuery("PghDetalleCriterio.countByFilter");
                }
            }else{
                if(filtro.getIdCriterio() != null){
                    query = crud.getEm().createNamedQuery("PghDetalleCriterio.findByIdDetalleCriterioDetalle");
                }else{
                    query = crud.getEm().createNamedQuery("PghDetalleCriterio.findByFilter");
                }
            }            
            if(filtro.getIdCriterio() != null){            	
                query.setParameter("idCriterio", filtro.getIdCriterio());
            }
            if(filtro.getSancionEspecifica() != null){
                query.setParameter("sancionEspecifica", filtro.getSancionEspecifica());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
	}	
}