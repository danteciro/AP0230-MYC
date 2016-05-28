/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghListadoBaseLegal;
import gob.osinergmin.myc.domain.PghTipificacionSancion;
import gob.osinergmin.myc.domain.builder.BaseLegalConcordanciaBuilder;
import gob.osinergmin.myc.domain.builder.TipificacionSancionBuilder;
import gob.osinergmin.myc.domain.dto.BaseLegalConcordanciaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipificacionSancionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.TipificacionSancionDAO;
import gob.osinergmin.myc.util.Constantes;

import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author lbarboza
 */
@Service("TipificacionSancionDAO")
public class TipificacionSancionDAOImpl implements TipificacionSancionDAO{
    private static final Logger LOG = LoggerFactory.getLogger(TipificacionSancionDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public HashMap listarTipificacionSancion(TipificacionSancionFilter filtro) {
        HashMap resultado = new HashMap();
        List<TipificacionSancionDTO> retorno = null;
        try{
            Long cuenta = count(filtro);
            resultado.put("cuenta", cuenta);
            
            Query query = getFindQuery(filtro, false);
            if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
                query.setFirstResult(filtro.getStartIndex());
                query.setMaxResults(filtro.getResultsNumber());
            }
            
            retorno = TipificacionSancionBuilder.getListaTipificacionSancion(query.getResultList());
            resultado.put("listado", retorno);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return resultado;
    }

    @Override
    public TipificacionSancionDTO create(TipificacionSancionDTO tipificacionSancionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Tipificacion Sancion DAO Impl");
        TipificacionSancionDTO retorno = null;
        try{
            PghTipificacionSancion tipificacionSancion = TipificacionSancionBuilder.getTipificacionSancion(tipificacionSancionDTO);
            tipificacionSancion.setDatosAuditoria(usuarioDTO);
            
            if(tipificacionSancionDTO.getIdTipiSanc() != null){
                crud.update(tipificacionSancion);
            }else{
                crud.create(tipificacionSancion);
            }
            retorno = TipificacionSancionBuilder.getTipificacionSancion(tipificacionSancion);
            LOG.info("(Registro Tipificacion Sancion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

    @Override
    public TipificacionSancionDTO changeState(TipificacionSancionDTO tipificacionSancionDTO, String estado) {
        LOG.info("Cambiar Estado Tipificacion Sancion DAO Impl");
        TipificacionSancionDTO retorno = null;
        try{
            Query query = crud.getEm().createNamedQuery("PghTipificacionSancion.findByIdTipiSanc");
            TipificacionSancionFilter filtro = new TipificacionSancionFilter();
            filtro.setIdTipiSanc(tipificacionSancionDTO.getIdTipiSanc());
            query.setParameter("idTipiSanc",filtro.getIdTipiSanc());
            tipificacionSancionDTO = TipificacionSancionBuilder.getTipificacionSancion((PghTipificacionSancion)query.getResultList().get(0));
            
            PghTipificacionSancion tipificacionSancion = TipificacionSancionBuilder.getTipificacionSancion(tipificacionSancionDTO);
            tipificacionSancion.setEstado(estado);
            
            crud.update(tipificacionSancion);
            
            retorno = TipificacionSancionBuilder.getTipificacionSancion(tipificacionSancion);
            LOG.info("(Cambiar Estado Tipificacion Sancion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    public Long count(TipificacionSancionFilter filtro) {
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(TipificacionSancionFilter filtro, boolean count) {
        Query query=null;
        try{
            if(count){
                if(filtro.getIdCriterio()!=null && filtro.getNivel()!=null){
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.countByIdCriterioNivel");
                }else if (filtro.getIdTipiSanc()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.countByIdTipiSanc");
                }else if (filtro.getIdTipificacion()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.countByIdTipificacion");
                }else if (filtro.getIdTipoSancion()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.countByIdTipoSancion");
                }else {
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.countAll");
                }
            }else{
                if(filtro.getIdCriterio()!=null && filtro.getNivel()!=null){
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.findByIdCriterioNivel");
                }else if (filtro.getIdTipiSanc()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.findByIdTipiSanc");
                }else if (filtro.getIdTipificacion()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.findByIdTipificacion");
                }else if (filtro.getIdTipoSancion()!= null) {
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.findByIdTipoSancion");
                }else {
                    query = crud.getEm().createNamedQuery("PghTipificacionSancion.findAll");
                }
            }

            if (filtro.getIdTipiSanc()!= null) {
                query.setParameter("idTipiSanc",filtro.getIdTipiSanc());
            }
            if (filtro.getIdTipificacion()!= null) {
                query.setParameter("idTipificacion",filtro.getIdTipificacion());
            }
            if (filtro.getIdTipoSancion()!= null) {
                query.setParameter("idTipoSancion",filtro.getIdTipoSancion());
            }
            if (filtro.getEstado()!= null) {
                query.setParameter("estado",filtro.getEstado());
            }
            if(filtro.getIdCriterio()!=null && filtro.getNivel()!=null){
                query.setParameter("idCriterio",filtro.getIdCriterio());
                query.setParameter("nivel",filtro.getNivel());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }

	@Override
	public List<TipificacionSancionDTO> buscTipifSancByIdDetalleCriterio(TipificacionSancionFilter filtro) {
            List<TipificacionSancionDTO> retorno=null;
            try{
                StringBuilder jpql = new StringBuilder();
                jpql.append("SELECT p from PghTipificacionSancion p "+
                                    "WHERE p.idDetalleCriterio.idDetalleCriterio=:idDetalleCriterio " +
                                    "AND p.estado=:estado ");
                Query query = crud.getEm().createQuery(jpql.toString());
                
                query.setParameter("idDetalleCriterio",filtro.getIdDetalleCriterio());
                query.setParameter("estado",filtro.getEstado());
                
                List<PghTipificacionSancion>  resultados = query.getResultList();   
                retorno=TipificacionSancionBuilder.getListaTipificacionSancion(resultados);            
            }catch(Exception ex){
                LOG.error("",ex);
            }
            return retorno;
	}
        
	@Override
	public TipificacionSancionDTO buscarTipificacionSancion(TipificacionSancionFilter filtro) {
		TipificacionSancionDTO retorno=null;
        try{
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p from PghTipificacionSancion p "+
            			"WHERE p.pghTipificacion.idTipificacion=:idTipificacion " +
            			"AND p.pghTipoSancion.idTipoSancion=:idTipoSancion and p.estado='1'");
            Query query = crud.getEm().createQuery(jpql.toString());
            if(filtro.getIdTipificacion()!=null){
            	query.setParameter("idTipificacion",filtro.getIdTipificacion());
            }
            if(filtro.getIdTipoSancion()!=null){
            	query.setParameter("idTipoSancion",filtro.getIdTipoSancion());
            }
            
            List<PghTipificacionSancion>  resultados = query.getResultList();   
            System.out.println(" lista de tipificacion sancion "+resultados);
            if(!CollectionUtils.isEmpty(resultados)){
            	retorno=TipificacionSancionBuilder.getTipificacionSancion(resultados.get(0));
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}

	@Override
	public TipificacionSancionDTO buscarTipificacionSancionCompleta(Long idTipiSanc) {
		TipificacionSancionDTO retorno = new TipificacionSancionDTO();
		try{
//        	StringBuilder jpql = new StringBuilder();
//            jpql.append("SELECT p from PghTipificacionSancion p "+
//            			"WHERE p.estado=1 " +
//            			"AND p.pghTipificacion.idTipificacion=:idTipificacion " +
//            			"AND p.pghTipoSancion.idTipoSancion=:idTipoSancion " +
//            			"AND p.idCriterio.idCriterio =:idCriterio ");
//            Query query = crud.getEm().createQuery(jpql.toString());
//            if(tipificacionSancionDTO.getIdTipificacion()!=null){
//            	query.setParameter("idTipificacion",tipificacionSancionDTO.getIdTipificacion());
//            }
//            if(tipificacionSancionDTO.getIdTipoSancion()!=null){
//            	query.setParameter("idTipoSancion",tipificacionSancionDTO.getIdTipoSancion());
//            }
//            if(tipificacionSancionDTO.getCriterio()!=null){
//            	query.setParameter("idCriterio",tipificacionSancionDTO.getCriterio().getIdCriterio());
//            }
            PghTipificacionSancion res=crud.find(idTipiSanc, PghTipificacionSancion.class);
                    
//            List<PghTipificacionSancion>  resultados = query.getResultList();   
            System.out.println(" lista de tipificacion sancion "+res);
            //if(!CollectionUtils.isEmpty(resultados)){
            	retorno=TipificacionSancionBuilder.getTipificacionSancion(res);
            //}
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retorno;
	}

	@Override
	public TipificacionSancionDTO cambioEstado(TipificacionSancionDTO tipificacionSancionDTO, UsuarioDTO usuarioDTO) {
		TipificacionSancionDTO retorno = null;
        try{
            Query query = crud.getEm().createNamedQuery("PghTipificacionSancion.findByIdTipiSanc");
            TipificacionSancionFilter filtro = new TipificacionSancionFilter();
            filtro.setIdTipiSanc(tipificacionSancionDTO.getIdTipiSanc());
            query.setParameter("idTipiSanc",filtro.getIdTipiSanc());
            tipificacionSancionDTO = TipificacionSancionBuilder.getTipificacionSancion((PghTipificacionSancion)query.getResultList().get(0));
            
            PghTipificacionSancion tipificacionSancion = TipificacionSancionBuilder.getTipificacionSancion(tipificacionSancionDTO);
            tipificacionSancion.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            
            crud.update(tipificacionSancion);
            
            retorno = TipificacionSancionBuilder.getTipificacionSancion(tipificacionSancion);
            LOG.info("(Cambiar Estado Tipificacion Sancion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}

	@Override
	public HashMap listarTipificacionBySancion(TipificacionSancionFilter filtro) {
		HashMap resultado = new HashMap();
        List<TipificacionSancionDTO> retorno = null;
        try{
            String dominio = Constantes.DOMINIO_NIVEL_TIPIFICACION;
        	String aplicacion = Constantes.APPLICACION_MYC;
        	StringBuilder jpql = new StringBuilder();
            jpql.append("select p.id_Tipi_Sanc,t.id_Tipo_Sancion,t.descripcion from Pgh_Tipificacion_Sancion p ");
            jpql.append("inner join Pgh_Tipo_Sancion t ");
            jpql.append("on p.id_Tipo_Sancion = t.id_Tipo_Sancion ");
            jpql.append("where p.estado = '1'");
            jpql.append("and p.estado = '1'");
            jpql.append("and p.nivel = (select m.id_maestro_columna from mdi_maestro_columna m where m.dominio='"+dominio+"' AND m.aplicacion='"+aplicacion+"') ");
            if(filtro.getIdTipificacion()!= null){
                jpql.append(" AND p.id_tipificacion = ").append(filtro.getIdTipificacion());
            }
            String queryString = jpql.toString();
            Query query = crud.getEm().createNativeQuery(queryString);
            List<Object[]> listaSanciones = query.getResultList();
             retorno = TipificacionSancionBuilder.getListaTipificacionBySancion(listaSanciones);
            resultado.put("listado", retorno);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return resultado;
	}

	@Override
	public TipificacionSancionDTO buscarTipificacionSancionNivel(TipificacionSancionFilter filtro) {
		TipificacionSancionDTO retorno=null;
        try{
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p from PghTipificacionSancion p ");
            jpql.append("WHERE p.estado='1' ");
            jpql.append("AND p.nivel.idMaestroColumna=:idNivel ");
            jpql.append("AND p.pghTipificacion.idTipificacion=:idTipificacion ");
            jpql.append("AND p.pghTipoSancion.idTipoSancion=:idTipoSancion");
            Query query = crud.getEm().createQuery(jpql.toString());
            if(filtro.getIdTipificacion()!=null){
            	query.setParameter("idTipificacion",filtro.getIdTipificacion());
            }
            if(filtro.getIdTipoSancion()!=null){
            	query.setParameter("idTipoSancion",filtro.getIdTipoSancion());
            }
            if(filtro.getNivel()!=null){
            	query.setParameter("idTipoSancion",filtro.getNivel());
            }
            
            List<PghTipificacionSancion>  resultados = query.getResultList();   
            System.out.println(" lista de tipificacion sancion "+resultados);
            if(!CollectionUtils.isEmpty(resultados)){
            	retorno=TipificacionSancionBuilder.getTipificacionSancion(resultados.get(0));
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}

	@Override
	public HashMap listarTipificacionBySancionCriterio(TipificacionSancionFilter filtro) {
		HashMap resultado = new HashMap();
        List<TipificacionSancionDTO> retorno = null;
        try{
            String dominio = Constantes.DOMINIO_NIVEL_CRITERIO;
        	String aplicacion = Constantes.APPLICACION_MYC;
        	StringBuilder jpql = new StringBuilder();
            jpql.append("select p.id_Tipi_Sanc,t.id_Tipo_Sancion,t.descripcion,p.id_Tipificacion from Pgh_Tipificacion_Sancion p ");
            jpql.append("inner join Pgh_Tipo_Sancion t ");
            jpql.append("on p.id_Tipo_Sancion = t.id_Tipo_Sancion ");
            jpql.append("where p.estado = '1'");
            jpql.append("and t.estado = '1'");
            jpql.append("and p.nivel = (select m.id_maestro_columna from mdi_maestro_columna m where m.dominio='"+dominio+"' AND m.aplicacion='"+aplicacion+"') ");
            if(filtro.getIdCriterio()!= null){
                jpql.append(" AND p.id_criterio = ").append(filtro.getIdCriterio());
            }
            String queryString = jpql.toString();
            Query query = crud.getEm().createNativeQuery(queryString);
            List<Object[]> listaSanciones = query.getResultList();
             retorno = TipificacionSancionBuilder.getListaTipificacionBySancionCriterio(listaSanciones);
            resultado.put("listado", retorno);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return resultado;
	}
    
}