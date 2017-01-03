package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.domain.PghObliTipiCriterio;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.builder.CriterioBuilder;
import gob.osinergmin.myc.domain.builder.ObliTipiCriterioBuilder;
import gob.osinergmin.myc.domain.builder.TipificacionSancionBuilder;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.ObliTipiDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ObliTipiCriterioDAO;
import gob.osinergmin.myc.util.Constantes;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang.StringUtils;

@Service
@Transactional
public class ObliTipiCriterioDAOImpl implements ObliTipiCriterioDAO{
    private static final Logger LOG = LoggerFactory.getLogger(ObliTipiCriterioDAOImpl.class);
    
    @Inject
    private CrudDAO crud;    

	@Override
	public ObliTipiDTO crear(ObliTipiDTO obliCriteTipi, UsuarioDTO usuarioDTO) {
		LOG.info("Registro Criterio DAO Impl");
		ObliTipiDTO retorno = null;
        try{
            PghObliTipiCriterio obliTipiCriterio = ObliTipiCriterioBuilder.getObliTipiCriterio(obliCriteTipi);
            obliTipiCriterio.setDatosAuditoria(usuarioDTO);
            if(obliTipiCriterio.getIdObliTipiCriterio()!=null){
                crud.update(obliTipiCriterio);
            }else{
                crud.create(obliTipiCriterio);
            }  

            LOG.info("create relacion Obli Tipi Criterio registro ingresado ID: "+obliTipiCriterio.getIdObliTipiCriterio());
            retorno = ObliTipiCriterioBuilder.toObliTipiCriterioDto(obliTipiCriterio);
        }catch(Exception ex){
            LOG.error("Error en create criterioDAO : "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
	}

	@Override
	public ObliTipiDTO obtenerCriterioById(Long idCriterio) {
		ObliTipiDTO retorno = new ObliTipiDTO();
		try {
			StringBuilder jpql = new StringBuilder();
	        jpql.append(" select c, t ");
	        jpql.append(" from PghObliTipiCriterio c inner join c.idTipificacion t ");
	        jpql.append(" where 1=1 ");
	        jpql.append(" and c.estado=1 ");
	        if(idCriterio!= null){
	            jpql.append(" and c.idCriterio = ").append(idCriterio);
	        }
	        String queryString = jpql.toString();
	        Query query = crud.getEm().createQuery(queryString);
	        List<Object[]> lstObliTipiCriterio= query.getResultList();
	        LOG.info("lista de criteriostipificacion"+lstObliTipiCriterio);
	        if(lstObliTipiCriterio!=null){
	        	retorno=ObliTipiCriterioBuilder.toListObliTipiCriterioDto(lstObliTipiCriterio.get(0));
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}		
        return retorno;
	}

	@Override
	public Long findByCriterio(CriterioDTO criterioDTO) {
		LOG.info("contador DAO IMPL By Criterio");
		Query query = null;
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT count(p) From PghObliTipiCriterio p where p.estado='1' ");
            jpql.append("and p.idCriterio.idCriterio=:idCriterio ");
            
    		query = crud.getEm().createQuery(jpql.toString());
    		query.setParameter("idCriterio",criterioDTO.getIdCriterio());
    		
        }catch(RuntimeException e) {
        	LOG.error(e.getMessage(),e);   
            e.printStackTrace();
        }catch(Exception e) {
        	LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
        
        LOG.info("Salida contador DAO IMPL By Criterio");
        return (Long) query.getSingleResult();
	}

	@Override
	public ObliTipiDTO changeEstadoRelacion(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO) {
		ObliTipiDTO retorno=null;
		Query query=null;
		try {
			/** Cambia_de_Estado_al_Listado_de_ObliTipiCriterio **/
	        StringBuilder jpql = new StringBuilder();
	        jpql.append("SELECT p From PghObliTipiCriterio p where p.estado='1' ");
	        jpql.append("and p.idCriterio.idCriterio=:idCriterio ");;
	        query = crud.getEm().createQuery(jpql.toString());
			query.setParameter("idCriterio",criterioDTO.getIdCriterio());
			LOG.info("query find Listado Id's: " + jpql.toString());
			
			List<PghObliTipiCriterio> listadoUpd=query.getResultList();
			LOG.info("Se Procede a Actualizar el Listado : " + listadoUpd);
			
			for(PghObliTipiCriterio obj :listadoUpd){
				LOG.info("Se Procede a Actualizar Relacion con ID: " + obj.getIdObliTipiCriterio());
				LOG.info("Se Procede a Actualizar Relacion-Criterio CON ID: " + obj.getIdCriterio().getIdCriterio());
				LOG.info("Se Procede a Actualizar Relacion-Tipificacion CON ID: " + obj.getIdTipificacion().getIdTipificacion());
	        	
	        	Long idObliTipiCriterio=obj.getIdObliTipiCriterio();
	        	Long idCriterio=obj.getIdCriterio().getIdCriterio();
	        	Long idTipificacion=obj.getIdTipificacion().getIdTipificacion();
	        	
	        	PghObliTipiCriterio regListado = crud.findCrOblg(idObliTipiCriterio, idCriterio, idTipificacion);
	        	regListado.setEstado(criterioDTO.getEstado());
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
	public List<ObliTipiDTO> obtenerRelaciones(ObliTipiDTO obliTipiDTO) {
		List<ObliTipiDTO> retorno = new ArrayList<ObliTipiDTO>();
		try {
			StringBuilder jpql = new StringBuilder();
	        jpql.append(" select  c.idObliTipiCriterio, c.idCriterio.idCriterio , c.idCriterio.descripcion, c.idTipificacion.codTipificacion, c.idCriterio.basesLegales");
	        jpql.append(" from PghObliTipiCriterio c");
	        jpql.append(" where 1=1 ");
	        jpql.append(" and c.estado=1 ");
	        if(obliTipiDTO.getIdCriterio()!= null){
	            jpql.append(" and c.idCriterio = ").append(obliTipiDTO.getIdCriterio());
	        }
	        if(obliTipiDTO.getIdTipificacion()!= null){
	            jpql.append(" and c.idTipificacion = ").append(obliTipiDTO.getIdTipificacion());
	        }
	        if(obliTipiDTO.getIdObligacion()!= null){
	            jpql.append(" and c.idObligacion = ").append(obliTipiDTO.getIdObligacion());
	        }
	        String queryString = jpql.toString();
	        Query query = crud.getEm().createQuery(queryString);
	        List<Object []> lstObliTipiCriterio= query.getResultList();
	        LOG.info("lista de criteriostipificacion"+lstObliTipiCriterio);
	        if(lstObliTipiCriterio!=null){
	        	retorno=ObliTipiCriterioBuilder.toListObliTipiCriDto(lstObliTipiCriterio);
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}		
        return retorno;
	}

// 05-11-2015	
	@Override
	public List<ObliTipiDTO> obtenerRelacionesToObligacion(ObliTipiDTO obliTipiDTO) {
		List<ObliTipiDTO> retorno = null;
		try {
			LOG.info("key Tipificacion xxx> "+obliTipiDTO.getIdTipificacion());
			LOG.info("key Obligacion xxx> "+obliTipiDTO.getIdObligacion());
			StringBuilder jpql = new StringBuilder();			
	        jpql.append(" select c.idObliTipiCriterio, c.idCriterio.idCriterio , c.idCriterio.descripcion, c.idTipificacion.codTipificacion, c.idCriterio.basesLegales,c.idCriterio.sancionMonetaria");
	        jpql.append(" from PghObliTipiCriterio c");
	        jpql.append(" where 1=1 ");
	        jpql.append(" and c.estado=1 ");
	        if(obliTipiDTO.getIdCriterio()!= null){
	            jpql.append(" and c.idCriterio = ").append(obliTipiDTO.getIdCriterio());
	        }
	        if(obliTipiDTO.getIdTipificacion()!= null){
	            jpql.append(" and c.idTipificacion = ").append(obliTipiDTO.getIdTipificacion());
	        }
	        if(obliTipiDTO.getIdObligacion()!= null){
	            jpql.append(" and c.idObligacion = ").append(obliTipiDTO.getIdObligacion());
	        }
	        if(obliTipiDTO.getIdActividad() != null){
	        	jpql.append(" and c.idActividad = ").append(obliTipiDTO.getIdActividad());
	        }
	        String queryString = jpql.toString();
	        Query query = crud.getEm().createQuery(queryString);
	        List<Object []> lstObliTipiCriterio= query.getResultList();
	        LOG.info("lista de criteriostipificacion"+lstObliTipiCriterio);
	        if(lstObliTipiCriterio!=null){
	        	retorno=ObliTipiCriterioBuilder.toListObliTipiCriDto(lstObliTipiCriterio);
	        }
	        if(retorno!=null){
	        	int count=0;
	        	for(ObliTipiDTO reg:retorno){
	        		count++;
		            jpql = new StringBuilder();
		            jpql.append(" select ts ");
		            jpql.append(" from PghTipificacionSancion ts ");
		            jpql.append(" where ts.estado=1 ");
		            jpql.append("and ts.nivel= (select mc.idMaestroColumna from MdiMaestroColumna mc where mc.estado='1' and mc.mdiMaestroTabla.mdiMaestroTablaPK.dominio='NIVEL_CRITERIO' and mc.mdiMaestroTabla.mdiMaestroTablaPK.aplicacion='MYC') ");
		            jpql.append("and ts.idCriterio.idCriterio=").append(reg.getIdCriterio());
		            String queryStringDetalle = jpql.toString();
		            Query queryDetalle = crud.getEm().createQuery(queryStringDetalle);
		            List<TipificacionSancionDTO> lista = TipificacionSancionBuilder.getListaTipificacionSancion(queryDetalle.getResultList());	            
		            reg.setTipificacionSancion(lista);
		            String abreviaturaConcatenada="";
			        if(!lista.isEmpty()){
			            String[] s = new String[lista.size()];
			            int cont=0;
			            for(TipificacionSancionDTO maestra : lista){
			            	s[cont]=maestra.getTipoSancion().getAbreviatura()==null?"":maestra.getTipoSancion().getAbreviatura().toString();
			            	cont++;
			            }
			            abreviaturaConcatenada = StringUtils.join(s, ",");
			        }
			        reg.setSancionEspecifica(abreviaturaConcatenada);
		        }
	        }
	        	        	        
		} catch (Exception e) {
			e.printStackTrace();
		}		
        return retorno;
	}	
	
	@Override
	public List<ObliTipiDTO> obtenerRelacionesCompletasToObligacion(ObliTipiDTO obliTipiDTO) {
		List<ObliTipiDTO> retorno = null;
		try {
			LOG.info("key Tipificacion xxx> "+obliTipiDTO.getIdTipificacion());
			LOG.info("key Obligacion xxx> "+obliTipiDTO.getIdObligacion());
			StringBuilder jpql = new StringBuilder();	
			jpql.append("select otc.id_obli_tipi_criterio,otc.id_criterio,c.descripcion,t.cod_tipificacion,c.bases_legales,c.sancion_monetaria,a.nombre,otc.id_tipificacion ");
			jpql.append("from pgh_obli_tipi_criterio otc ");
			jpql.append("inner join pgh_criterio c on (c.id_criterio = otc.id_criterio and c.estado = '1') ");
			jpql.append("inner join pgh_tipificacion t on (t.id_tipificacion = otc.id_tipificacion and t.estado = '1') ");
			jpql.append("left join mdi_actividad a on (a.id_actividad = otc.id_actividad and a.estado = '1') ");
			jpql.append("where ");
			jpql.append("otc.estado = '1' ");
	        
	        if(obliTipiDTO.getIdCriterio()!= null){
	            jpql.append(" and otc.id_criterio = ").append(obliTipiDTO.getIdCriterio());
	        }
	        if(obliTipiDTO.getIdTipificacion()!= null){
	            jpql.append(" and otc.id_tipificacion = ").append(obliTipiDTO.getIdTipificacion());
	        }
	        if(obliTipiDTO.getIdObligacion()!= null){
	            jpql.append(" and otc.id_obligacion = ").append(obliTipiDTO.getIdObligacion());
	        }
	        if(obliTipiDTO.getIdActividad() != null){
	        	jpql.append(" and otc.id_actividad = ").append(obliTipiDTO.getIdActividad());
	        }
	        System.out.println("QUERY : " + jpql.toString());
	        String queryString = jpql.toString();
	        Query query = crud.getEm().createNativeQuery(queryString);
	        List<Object []> lstObliTipiCriterio= query.getResultList();
	        LOG.info("lista de criteriostipificacion"+lstObliTipiCriterio);
	        
	        if(lstObliTipiCriterio!=null){
	        	retorno=ObliTipiCriterioBuilder.toListObliTipiCriDto(lstObliTipiCriterio);
	        }
	        if(retorno!=null){
	        	int count=0;
	        	for(ObliTipiDTO reg:retorno){
	        		count++;
		            jpql = new StringBuilder();
		            jpql.append(" select ts ");
		            jpql.append(" from PghTipificacionSancion ts ");
		            jpql.append(" where ts.estado=1 ");
		            jpql.append("and ts.nivel= (select mc.idMaestroColumna from MdiMaestroColumna mc where mc.estado='1' and mc.mdiMaestroTabla.mdiMaestroTablaPK.dominio='NIVEL_CRITERIO' and mc.mdiMaestroTabla.mdiMaestroTablaPK.aplicacion='MYC') ");
		            jpql.append("and ts.idCriterio.idCriterio=").append(reg.getIdCriterio());
		            String queryStringDetalle = jpql.toString();
		            Query queryDetalle = crud.getEm().createQuery(queryStringDetalle);
		            List<TipificacionSancionDTO> lista = TipificacionSancionBuilder.getListaTipificacionSancion(queryDetalle.getResultList());	            
		            reg.setTipificacionSancion(lista);
		            String abreviaturaConcatenada="";
			        if(!lista.isEmpty()){
			            String[] s = new String[lista.size()];
			            int cont=0;
			            for(TipificacionSancionDTO maestra : lista){
			            	s[cont]=maestra.getTipoSancion().getAbreviatura()==null?"":maestra.getTipoSancion().getAbreviatura().toString();
			            	cont++;
			            }
			            abreviaturaConcatenada = StringUtils.join(s, ",");
			        }
			        reg.setSancionEspecifica(abreviaturaConcatenada);
		        }
	        }
	        	        	        
		} catch (Exception e) {
			e.printStackTrace();
		}		
        return retorno;
	}
	
//	
	@Override
	public ObliTipiDTO crearRelacion(ObliTipiDTO relacion,UsuarioDTO usuarioDTO) {
		LOG.info("Registro Criterio DAO Impl");
		ObliTipiDTO retorno = null;
        try{
            PghObliTipiCriterio obliTipiCriterio = ObliTipiCriterioBuilder.getObliTipiCriterio(relacion);
            obliTipiCriterio.setDatosAuditoria(usuarioDTO);
            if(obliTipiCriterio.getIdObliTipiCriterio()!=null){
                crud.update(obliTipiCriterio);
            }else{
                crud.create(obliTipiCriterio);
            }  

            LOG.info("create relacion Obli Tipi Criterio registro ingresado ID: "+obliTipiCriterio.getIdObliTipiCriterio());
            retorno = ObliTipiCriterioBuilder.toObliTipiCriterioDto(obliTipiCriterio);
        }catch(Exception ex){
            LOG.error("Error en create criterioDAO : "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
	}

	@Override
	public void eliminarRelacion(ObliTipiDTO relacion, UsuarioDTO usuarioDTO) {
		LOG.info("eliminar Relacion" + relacion.getIdObliTipiCriterio() );
		try {
			PghObliTipiCriterio regListado = crud.find(relacion.getIdObliTipiCriterio(),PghObliTipiCriterio.class);
	    	regListado.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
	    	regListado.setDatosAuditoria(usuarioDTO);
	    	crud.update(regListado);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public ObliTipiDTO update(ObliTipiDTO obliCriteTipi, UsuarioDTO usuarioDTO) {
		LOG.info("Registro Criterio DAO Impl");
		ObliTipiDTO retorno = null;
        try{
//        	ObliTipiDTO obliTipiAntiguo = findObliTipi(obliCriteTipi.getCriterio().getIdCriterio());
            PghObliTipiCriterio obliTipiCriterio = ObliTipiCriterioBuilder.getObliTipiCriterio(obliCriteTipi);
            PghTipificacion idTipificacion = new PghTipificacion();
            idTipificacion.setIdTipificacion(obliCriteTipi.getTipificacion().getIdTipificacion());
            obliTipiCriterio.setIdTipificacion(idTipificacion);
            obliTipiCriterio.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            obliTipiCriterio.setDatosAuditoria(usuarioDTO);
            if(obliTipiCriterio.getIdObliTipiCriterio()!=null){
                crud.update(obliTipiCriterio);
            } 

            retorno = ObliTipiCriterioBuilder.toObliTipiCriterioDto(obliTipiCriterio);
        }catch(Exception ex){
            LOG.error("Error en create criterioDAO : "+ex.getMessage());
            ex.printStackTrace();
        }
        return retorno;
	}

	public ObliTipiDTO findObliTipi(Long idCriterio) {
		ObliTipiDTO retorno = new ObliTipiDTO();
		StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p From PghObliTipiCriterio p ");
        jpql.append("where p.estado=1 ");
        jpql.append("and p.idCriterio.idCriterio=:idCriterio ");
        jpql.append("and p.idObligacion is null ");
        
		Query 	query = crud.getEm().createQuery(jpql.toString());
		query.setParameter("idCriterio",idCriterio);

        PghObliTipiCriterio  resultado = (PghObliTipiCriterio) query.getResultList().get(0);  
        System.out.println(" Lista Relacion O - B ->"+resultado);
        retorno = ObliTipiCriterioBuilder.toObliTipiCriterioDto(resultado);

		return retorno;	
	}

	@Override
	public ObliTipiDTO findObliTipiCriterio(ObliTipiDTO obliCritetipiAntiguo){ 
		Long idCriterio = obliCritetipiAntiguo.getCriterio().getIdCriterio();
//		Long idTipificacion = obliCritetipiAntiguo.getTipificacion().getIdTipificacion();
		ObliTipiDTO retorno = new ObliTipiDTO();
		StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p From PghObliTipiCriterio p ");
        jpql.append("where p.estado=1 ");
        jpql.append("and p.idCriterio.idCriterio=:idCriterio ");
//        jpql.append("and p.idTipificacion.idTipificacion=:idTipificacion ");
        jpql.append("and p.idObligacion is null ");
        
		Query 	query = crud.getEm().createQuery(jpql.toString());
		if(idCriterio!=null){
			query.setParameter("idCriterio",idCriterio);
		}
//		if(idTipificacion!=null){
//			query.setParameter("idTipificacion",idTipificacion);
//		}		
        PghObliTipiCriterio  resultado = (PghObliTipiCriterio) query.getResultList().get(0);  
        System.out.println(" Lista Relacion O - B ->"+resultado);
        retorno = ObliTipiCriterioBuilder.toObliTipiCriterioDto(resultado);

		return retorno;	
	}
	
	
}