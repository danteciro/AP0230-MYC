/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.PghTipificacionSancion;
import gob.osinergmin.myc.domain.builder.TipificacionBuilder;
import gob.osinergmin.myc.domain.builder.TipificacionSancionBuilder;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipificacionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.TipificacionDAO;
import gob.osinergmin.myc.service.exception.TipificacionException;
import gob.osinergmin.myc.util.Constantes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class TipificacionDAOImpl implements TipificacionDAO{
    private static final Logger log = LoggerFactory.getLogger(TipificacionDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public TipificacionDTO create(TipificacionDTO tipificacionDTO,UsuarioDTO usuarioDTO) {
        log.info("Registro Tipificacion DAO Impl");
        TipificacionDTO retorno = null;
        try{
            PghTipificacion tipificacion = TipificacionBuilder.getTipificacion(tipificacionDTO);
            tipificacion.setDatosAuditoria(usuarioDTO);
            
            if(tipificacionDTO.getIdTipificacion() != null){
                crud.update(tipificacion);
            }else{
                crud.create(tipificacion);
            }
            retorno = TipificacionBuilder.toTipificacionDto(tipificacion);
            log.info("(Registro Tipificacion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            log.error("",ex);
        }
        return retorno;
    }

    @Override
    public TipificacionDTO changeState(TipificacionDTO tipificacionDTO) throws TipificacionException{
        TipificacionDTO retorno = null;
        try{
            Map<String, Object> valida= validaEliminarTipificacion(tipificacionDTO.getIdTipificacion());
            
            if(valida.get("rpta").toString().equals("0")){
                throw new TipificacionException(valida.get("msje").toString(),null);
            }
            
            PghTipificacion registroDTO = crud.find(tipificacionDTO.getIdTipificacion(), PghTipificacion.class);
            registroDTO.setEstado(tipificacionDTO.getActivo());
            crud.update(registroDTO);
            retorno = TipificacionBuilder.toTipificacionDto(registroDTO);
        }catch (TipificacionException ex) {
            log.error("error changeState = ",ex);
            throw ex;
        }catch(Exception ex){
            log.error("error changeState... ",ex);
            TipificacionException e2 = new TipificacionException(TipificacionException.ERROR_ELIMINAR_TIPIFICACION, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public Map<String, Object> validaEliminarTipificacion(Long idTipificacion){
        log.info("procesando validaEliminarEtapa");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query query=null;
            
            //verifica que tipificacion no tenga hijos activos
            if(rpta.equals("1")){
                hql="SELECT ti.idTipificacion FROM PghTipificacion ti WHERE ti.estado=:estado and ti.idTipificacionPadre=:idTipificacion ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTipificacion", idTipificacion);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tipificaci&oacute;n mientras este siendo usada como Padre de otra Tipificaci&oacute;n.";
                }
            }
            
            if(rpta.equals("1")){
                hql="SELECT t from PghObligacionTipificacion t where t.estado=:estado and t.idTipificacion.idTipificacion=:idTipificacion ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTipificacion", idTipificacion);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tipificaci&oacute;n mientras este siendo usada en Obligaci&oacute;n Tipificaci&oacute;n.";
                }
            }
            
            if(rpta.equals("1")){
                hql="SELECT t from PghObliTipiCriterio t where t.estado=:estado and t.idTipificacion.idTipificacion=:idTipificacion ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTipificacion", idTipificacion);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tipificaci&oacute;n mientras este siendo usada en Criterio.";
                }
            }
            
            if(rpta.equals("1")){
                hql="SELECT t from PghTipificacionSancion t where t.estado=:estado and t.pghTipificacion.idTipificacion=:idTipificacion ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idTipificacion", idTipificacion);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Tipificaci&oacute;n mientras este siendo usada en Tipificacion Sancion.";
                }
            }
            
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            log.error("Error en validaEliminarEtapa ",ex);
        }
        return retorno;
    }

    @Override
    public List<TipificacionDTO> find(TipificacionFilter filtro) {
        List<TipificacionDTO> listado = null;
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        listado = TipificacionBuilder.toListTipificacionDto(query.getResultList());
        log.info("listado: "+listado.size());
        return listado;
    }
    
    @Override
    public Long countNativo(TipificacionFilter filtro) {
        log.info("contador Nativo DAO IMPL");
        StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT count(p.idTipificacion) FROM PghTipificacion p WHERE p.estado='1' ");
		if(filtro.getCodTipificacion()!=null && !filtro.getCodTipificacion().equals("")){
			jpql.append("and upper(p.codTipificacion) like :codigoTipificacion ");
		}
		if(filtro.getDescripcion()!= null && !filtro.getDescripcion().equals("")){
			jpql.append("and upper(p.descripcion) like :descripcion  ");
		}		
        Query query = crud.getEm().createQuery(jpql.toString());
        if(filtro.getCodTipificacion()!=null && !filtro.getCodTipificacion().equals("")){
        	query.setParameter("codigoTipificacion",StringUtil.removeBlank(filtro.getCodTipificacion().toUpperCase())+"%");
        }        
        if(filtro.getDescripcion()!= null && !filtro.getDescripcion().equals("")){
        	query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
        }		
        return (Long) query.getSingleResult();
    }
    public List<TipificacionDTO> findByNativo(TipificacionFilter filtro){
    	List<TipificacionDTO> listado = null;
    	log.info("listado tipificacion Nativo DAO IMPL");
        StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT distinct pghTipificacion.idTipificacion,pghTipificacion.codTipificacion,pghTipificacion.descripcion,pghTipificacion.sancionMonetaria," +
				"pghTipificacion.basesLegales,pghTipificacion.idTipificacionPadre," +
				"(select t.codTipificacion from PghTipificacion t where t.idTipificacion=pghTipificacion.idTipificacionPadre) as descTipiPadre,pghTipificacion.idTipoMoneda," +
				"pghTipificacion.claseSancion.idMaestroColumna, pghTipificacion.claseSancion.descripcion,pghTipificacion.estado " +
				"FROM PghTipificacion pghTipificacion, PghTipificacion tipiPadre " +
				"WHERE pghTipificacion.estado='1'  ");
		if(filtro.getCodTipificacion()!=null && !filtro.getCodTipificacion().equals("")){
			jpql.append("and upper(pghTipificacion.codTipificacion)  like :codigoTipificacion ");
		}
		if(filtro.getDescripcion()!= null && !filtro.getDescripcion().equals("")){
			jpql.append("and upper(pghTipificacion.descripcion) like :descripcion  ");
		}	
//		jpql.append("group by pghTipificacion.idTipificacion,pghTipificacion.codTipificacion ");
		jpql.append("order by pghTipificacion.idTipificacion asc");
        Query query = crud.getEm().createQuery(jpql.toString());
        if(filtro.getCodTipificacion()!=null && !filtro.getCodTipificacion().equals("")){
        	query.setParameter("codigoTipificacion",StringUtil.removeBlank(filtro.getCodTipificacion().toUpperCase())+"%");
        }        
        if(filtro.getDescripcion()!= null && !filtro.getDescripcion().equals("")){
        	query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
        }		
        log.info("salida listado tipificacion DAO IMPL");
        List<Object[]> listadoTipificacion = query.getResultList();
        listado = TipificacionBuilder.toListTipificacionNativoDto(listadoTipificacion);
        log.info("listado: "+listado.size());
        return listado;	
    }
    @Override
    public Long count(TipificacionFilter filtro) {
        Query query = getFindQuery(filtro, true);
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(TipificacionFilter filtro, boolean count){
        Query query=null;
        try{
            if(count){
                if(filtro.getIdTipificacion() != null){
                    query = crud.getEm().createNamedQuery("PghTipificacion.countByIdTipificacion");
                }else{
                    //query = crud.getEm().createNamedQuery("PghTipificacion.countByFilter");
                    query=getQueryToFind(filtro,count);
                }
            }else{
                if(filtro.getIdTipificacion() != null){
                    query = crud.getEm().createNamedQuery("PghTipificacion.findByIdTipificacion");
                }else{
                    //query = crud.getEm().createNamedQuery("PghTipificacion.findByFilter");
                    query=getQueryToFind(filtro,count);
                }
            }
            if(filtro.getIdTipificacion() != null){
                query.setParameter("idTipificacion",filtro.getIdTipificacion());
            }
//            if(filtro.getDescripcion() != null){
//                query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
//            }
//            if(filtro.getCodTipificacion()!= null){
//                query.setParameter("codTipificacion","%"+StringUtil.removeBlank(filtro.getCodTipificacion().toUpperCase())+"%");
//            }
        }catch(Exception e){
            log.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
    
    public Query getQueryToFind(TipificacionFilter filtro, boolean count){
        String queryString;
        StringBuilder jpql = new StringBuilder();
        //arma CAMPOS QUERY 
        if (count) {
            jpql.append("SELECT count(distinct p.idTipificacion) ");
        }else{
            jpql.append("SELECT new PghTipificacion(p.idTipificacion,"
                        + "cs.idMaestroColumna, cs.descripcion,"
                        + "p.codTipificacion,p.descripcion,p.sancionMonetaria,p.idTipificacionPadre,ti.descripcion,"
                        + "sum(case when tsl.pghTipoSancion.idTipoSancion is not null and tsl.estado='1' then 1 else 0 end) as tieneSanc ) ");
        }
        //arma FROM´s y JOIN´s
        jpql.append("FROM PghTipificacion p "
                + "left join p.pghTipificacion1 ti "
                + "left join p.pghTipificacionSancionList tsl "
                + "left join p.claseSancion cs ");
        //arma WHERE´s
        jpql.append("WHERE p.estado='1' and upper(p.codTipificacion) like :codTipificacion ");
            //WHERE´s dinamicos
        if (filtro.getDescripcion()!= null && !filtro.getDescripcion().equals("")) {
            jpql.append("and upper(p.descripcion) like :descripcion ");
        } 
        //arma GROUP BY
        if (!count) {
            jpql.append("GROUP BY p.idTipificacion,cs.idMaestroColumna, cs.descripcion,p.codTipificacion,p.descripcion,p.sancionMonetaria,p.idTipificacionPadre,ti.descripcion ");
        }
        
        //////////////////////////////////////
        //Crear QUERY
        queryString = jpql.toString();
        Query query = this.crud.getEm().createQuery(queryString);
        //////////////////////////////////////
        //Ingreso de PARAMETROS
        if (filtro.getDescripcion()!= null && !filtro.getDescripcion().equals("")) {
            query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
        }
        if(filtro.getCodTipificacion()!= null){
            query.setParameter("codTipificacion","%"+StringUtil.removeBlank(filtro.getCodTipificacion().toUpperCase())+"%");
        }
        //////////////////////////////////////
        return query;
    }

    @Override
    public TipificacionDTO obtenerTipificacion(Long idTipificacion){
        log.info("-- TipificacionDAO - obtenerTipificacion --");
        log.info("-- parametros idTipificacion : " + idTipificacion);
        
        PghTipificacion tipificacion = crud.find(idTipificacion, PghTipificacion.class);
        TipificacionDTO tipificacionDTO = TipificacionBuilder.toTipificacionDto(tipificacion);
        return tipificacionDTO;
    }   
    
    @Override
    public List<TipificacionDTO> obtenerTipificaciones(String codigoTipificacion){
        log.info("-- TipificacionDAO - obtenerTipificaciones --");
        log.info("-- parametros codigoTipificacion : " + codigoTipificacion);
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select t ");
        jpql.append(" from PghTipificacion t ");
        jpql.append(" where 1=1 ");
        jpql.append(" and t.estado=1 ");
        jpql.append(" and t.codTipificacion like '").append(codigoTipificacion).append("%'");
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghTipificacion> lstTipificacion = query.getResultList();
        List<TipificacionDTO> listaTipificacion = TipificacionBuilder.toListTipificacionDto(lstTipificacion);
        return listaTipificacion;
    }
    
    @Override
    public List<TipificacionDTO> obtenerTipificacionByCodigo(String codigoTipificacion){
        log.info("-- TipificacionDAO - obtenerTipificaciones --");
        log.info("-- parametros codigoTipificacion : " + codigoTipificacion);
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select t ");
        jpql.append(" from PghTipificacion t ");
        jpql.append(" where 1=1 ");
        jpql.append(" and t.estado=1 ");
        jpql.append(" and t.codTipificacion = '").append(codigoTipificacion).append("'");
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghTipificacion> lstTipificacion = query.getResultList();
        List<TipificacionDTO> listaTipificacion = TipificacionBuilder.toListTipificacionDto(lstTipificacion);
        return listaTipificacion;
    }
    
    @Override
    public List<TipificacionSancionDTO> obtenerTipificacionSancion(String codigoTipificacion){
        log.info("-- TipificacionDAO - obtenerTipificacionSancion --");
        log.info("-- parametros codigoTipificacion : " + codigoTipificacion);
        String dominio = Constantes.DOMINIO_NIVEL_TIPIFICACION;
    	String aplicacion = Constantes.APPLICACION_MYC;
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select ts ");
        jpql.append(" from PghTipificacion t "
                + " inner join t. pghTipificacionSancionList ts");
        jpql.append(" where 1=1 ");
        jpql.append(" and t.estado=1 ");
        jpql.append(" and ts.estado=1 ");
        jpql.append(" and ts.nivel = (SELECT mc FROM MdiMaestroColumna mc " +
        		"left join mc.mdiMaestroTabla mt " +
        		"WHERE " +
        		"mc.mdiMaestroTabla.mdiMaestroTablaPK.dominio = '"+dominio+"' " +
        		"and mc.mdiMaestroTabla.mdiMaestroTablaPK.aplicacion = '"+aplicacion+"' ) ");
        jpql.append(" and t.codTipificacion = '").append(codigoTipificacion).append("'");
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghTipificacionSancion> lstTipificacionSancion = query.getResultList();
        List<TipificacionSancionDTO> listaTipificacionSancion = TipificacionSancionBuilder.getListaTipificacionSancion(lstTipificacionSancion);
        return listaTipificacionSancion;
    }

	@Override
	public Long countByFilter(TipificacionFilter filtro) {
        Query query = getFindQuery(filtro, true);
        return (Long) query.getSingleResult();
	}

    @Override
    public List<TipificacionDTO> findByFilter(TipificacionFilter filtro) {
        List<TipificacionDTO> listado = null;
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        listado = TipificacionBuilder.toListTipificacionDto(query.getResultList());
        return listado;
    }

	@Override
	public List<TipificacionDTO> obtenerTipificacionByCodigoCriterio(String codigoTipificacion) {
		log.info("-- TipificacionDAO - obtenerTipificaciones --");
        log.info("-- parametros codigoTipificacion : " + codigoTipificacion);
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select t ");
        jpql.append(" from PghTipificacion t ");
        jpql.append(" where 1=1 ");
        jpql.append(" and t.estado=1 ");
        jpql.append(" and t.codTipificacion = '").append(codigoTipificacion).append("'");
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghTipificacion> lstTipificacion = query.getResultList();
        List<TipificacionDTO> listaTipificacion = TipificacionBuilder.toListTipificacionDto(lstTipificacion);
        return listaTipificacion;
	}

	@Override
	public List<TipificacionSancionDTO> obtenerTipificacionSancionCriterio(String codTipificacion,Long nivelTipificacion) {
		List<TipificacionSancionDTO> listaTipificacionSancion=null;
		try {
			log.info("-- TipificacionDAO - obtenerTipificacionSancion --");
	        log.info("-- parametros codigoTipificacion : " + codTipificacion);
	        StringBuilder jpql = new StringBuilder();
	        jpql.append(" select ts ");
	        jpql.append(" from PghTipificacion t "
	                + " inner join t. pghTipificacionSancionList ts");
	        jpql.append(" where 1=1 ");
	        jpql.append(" and t.estado=1 ");
	        jpql.append(" and ts.estado=1 ");
	        jpql.append(" and ts.nivel= '").append(nivelTipificacion).append("'");
	        jpql.append(" and t.codTipificacion = '").append(codTipificacion).append("'");
	        String queryString = jpql.toString();
	        Query query = crud.getEm().createQuery(queryString);
	        List<PghTipificacionSancion> lstTipificacionSancion = query.getResultList();
	        listaTipificacionSancion = TipificacionSancionBuilder.getListaTipificacionSancion(lstTipificacionSancion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return listaTipificacionSancion;
	}

	@Override
	public Long buscarSancionEspecifica(Long idTipificacion) {
        Query query=null;
        try {
        	String dominio = Constantes.DOMINIO_NIVEL_TIPIFICACION;
        	String aplicacion = Constantes.APPLICACION_MYC;
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT COUNT(p.id_tipi_sanc) FROM PGH_TIPIFICACION_SANCION p ");
            jpql.append("WHERE p.estado = '1'");
            jpql.append("AND p.nivel = (select m.id_maestro_columna from mdi_maestro_columna m where m.dominio='"+dominio+"' AND m.aplicacion='"+aplicacion+"') ");
            if(idTipificacion!= null){
                jpql.append(" AND p.id_tipificacion = ").append(idTipificacion);
            }
            String queryString = jpql.toString();
            query = crud.getEm().createNativeQuery(queryString);
		} catch (Exception e) {
			e.printStackTrace();
		}
        Long retorno = new Long(query.getSingleResult().toString());
        return retorno;
	}

	@Override
	public List<TipificacionSancionDTO> obtenerTipificacionSancionNivel(String codTipificacion,Long idNivel) {
		log.info("-- TipificacionDAO - obtenerTipificacionSancion Nivel Tipificacion--");
        log.info("-- parametros codigoTipificacion : " + codTipificacion);
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select ts ");
        jpql.append(" from PghTipificacion t "
                + " inner join t. pghTipificacionSancionList ts");
        jpql.append(" where 1=1 ");
        jpql.append(" and t.estado=1 ");
        jpql.append(" and ts.estado=1 ");
        jpql.append(" and ts.nivel= '").append(idNivel).append("'");
        jpql.append(" and t.codTipificacion = '").append(codTipificacion).append("'");
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghTipificacionSancion> lstTipificacionSancion = query.getResultList();
        List<TipificacionSancionDTO> listaTipificacionSancion = TipificacionSancionBuilder.getListaTipificacionSancion(lstTipificacionSancion);
        return listaTipificacionSancion;
	}

	@Override
	public List<TipificacionDTO> findTipificacionPadre(TipificacionFilter filtro) {
		List<TipificacionDTO> listado = null;
		try {
			StringBuilder jpql = new StringBuilder();
			jpql.append("SELECT distinct pghTipificacion.idTipificacion,pghTipificacion.codTipificacion,pghTipificacion.descripcion,pghTipificacion.sancionMonetaria," +
					"pghTipificacion.basesLegales,pghTipificacion.idTipificacionPadre," +
					"(select t.descripcion from PghTipificacion t where t.idTipificacion=pghTipificacion.idTipificacionPadre) as descTipiPadre,pghTipificacion.idTipoMoneda," +
					"pghTipificacion.claseSancion.idMaestroColumna, pghTipificacion.claseSancion.descripcion,pghTipificacion.estado " +
					"FROM PghTipificacion pghTipificacion, PghTipificacion tipiPadre " +
					"WHERE pghTipificacion.estado='1'  ");
			if(filtro.getIdTipificacion()!= null){
				jpql.append("AND pghTipificacion.idTipificacion not in ('"+filtro.getIdTipificacion()+"')");	
			}			
			Query query = crud.getEm().createQuery(jpql.toString());
	        List<Object[]> listadoTipificacion = query.getResultList();
	        listado = TipificacionBuilder.toListTipificacionNativoDto(listadoTipificacion);
	        log.info("listado: "+listado.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return listado;	
	}
	
}
