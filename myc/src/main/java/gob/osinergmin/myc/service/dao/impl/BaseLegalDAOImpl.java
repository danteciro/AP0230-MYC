package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghDetalleBaseLegal;
import gob.osinergmin.myc.domain.PghDetalleNormaTecnica;
import gob.osinergmin.myc.domain.PghListadoBaseLegal;
import gob.osinergmin.myc.domain.PghObligacionBaseLegal;
import gob.osinergmin.myc.domain.builder.ActividadBuilder;
import gob.osinergmin.myc.domain.builder.BaseLegalBuilder;
import gob.osinergmin.myc.domain.builder.BaseLegalConcordanciaBuilder;
import gob.osinergmin.myc.domain.builder.DetalleBaseLegalBuilder;
import gob.osinergmin.myc.domain.builder.DetalleNormaTecnicaBuilder;
import gob.osinergmin.myc.domain.builder.ObligacionBaseLegalBuilder;
import gob.osinergmin.myc.domain.builder.PghObligacionBaseLegalBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalConcordanciaDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleNormaTecnicaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.BaseLegalFilter;
import gob.osinergmin.myc.service.dao.BaseLegalDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
/**
 * 
 * @author gvillanueva
 *
 */
@Service
@Transactional
public class BaseLegalDAOImpl implements BaseLegalDAO {	
	private static final Logger LOG = LoggerFactory.getLogger(BaseLegalDAOImpl.class);
	
	@Inject
    private CrudDAO crud;
	
	@Override
	@Transactional
	public BaseLegalDTO changeEstado(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO){
		BaseLegalDTO retorno=null;
		try{
            PghBaseLegal registroDAO = crud.find(baseLegalDTO.getIdBaseLegal(), PghBaseLegal.class);
            registroDAO.setEstado(baseLegalDTO.getEstado());
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            /** Cambia de Estado al Detalle **/
            StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghDetalleBaseLegal p WHERE p.estado='1' and p.idBaseLegal='"+baseLegalDTO.getIdBaseLegal()+"'");
            Query query = crud.getEm().createQuery(jpql.toString());
            LOG.info("query find Id Detalle: " + jpql.toString());
            List<PghDetalleBaseLegal> detalleUpd = query.getResultList();   
            LOG.info("SE PROCEDE A ACTUALIZAR EL DETALLE BASE LEGAL CON ID: " + detalleUpd);
            for(PghDetalleBaseLegal obj :detalleUpd){
            	LOG.info("SE PROCEDE A ACTUALIZAR EL LISTADO BASE LEGAL CON IDS: " + obj.getIdDetalleBaseLegal());
            	PghDetalleBaseLegal detalleUpdate = crud.find(obj.getIdDetalleBaseLegal(), PghDetalleBaseLegal.class);
            	detalleUpdate.setEstado(baseLegalDTO.getEstado());
                detalleUpdate.setDatosAuditoria(usuarioDTO);
                crud.update(detalleUpdate);
            }
            
            
            /** Cambia de Estado a la Lista **/
            StringBuilder jpqlList = new StringBuilder();
            jpqlList.append("SELECT p FROM PghListadoBaseLegal p WHERE p.estado='1' and p.idBaseLegalOri='"+baseLegalDTO.getIdBaseLegal()+"'");
            Query querys = crud.getEm().createQuery(jpqlList.toString());
            LOG.info("query find Listado Id's: " + jpqlList.toString());
            
            List<PghListadoBaseLegal> listadoUpd = querys.getResultList();   
            LOG.info("SE PROCEDE A ACTUALIZAR EL LISTADO : " + listadoUpd);
            
            for(PghListadoBaseLegal obj :listadoUpd){
            	LOG.info("SE PROCEDE A ACTUALIZAR EL LISTADO BASE LEGAL CON IDS: " + obj.getIdListadoBaseLegal());
            	PghListadoBaseLegal regListado = crud.find(obj.getIdListadoBaseLegal(), PghListadoBaseLegal.class);
            	regListado.setEstado(baseLegalDTO.getEstado());
            	regListado.setDatosAuditoria(usuarioDTO);
                crud.update(regListado);
            }
            
    
            retorno=BaseLegalBuilder.toBaseLegalDto(registroDAO);
        }catch(Exception e){
            e.printStackTrace();
        }
		return retorno;
	}
	
	@Override
	@Transactional
	public List<ObligacionBaseLegalDTO> obtenerDependencias(BaseLegalFilter filtro){
		List<ObligacionBaseLegalDTO> listado=null;
		Query query;
		try{
			StringBuilder jpql = new StringBuilder();
			
        	jpql.append("SELECT p.idObligacion.idObligacion FROM PghObligacionBaseLegal p" );
        	if (!StringUtil.isEmptyNum(filtro.getIdBaseLegal())) {
        	jpql.append(" WHERE p.idBaseLegal.idBaseLegal=:idBaseLegal ");
        	}
        	LOG.info("jpql.tostring "+jpql.toString());
        	query = crud.getEm().createQuery(jpql.toString());
        	LOG.info("query "+query);
        	if (!StringUtil.isEmptyNum(filtro.getIdBaseLegal())) {
                query.setParameter("idBaseLegal",filtro.getIdBaseLegal());
            }
        	LOG.info("query "+query);
        	listado= PghObligacionBaseLegalBuilder.toListRelacionDto(query.getResultList());
        	LOG.info("listado "+listado);
		}catch(Exception e){
			LOG.error("Error getValidarDependencia : " + e.getMessage());
		}
	      
		
    	return listado;
	}
	
    @Override
    public List<BaseLegalDTO> find(BaseLegalFilter filtro){
        List<BaseLegalDTO> listado=null;

        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        listado = BaseLegalBuilder.toListBaseLegalDto(query.getResultList());
        LOG.info("listado: "+listado.size());
        return listado;
    }
    @Override
    public List<BaseLegalDTO> findPadre(BaseLegalFilter filtro){
        List<BaseLegalDTO> listado=null;
        LOG.info("FlagOpcion --> "+filtro.getOpcion());
        Query query = getFindQueryPadre(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        LOG.info("FlagOpcion --> "+filtro.getOpcion());
        if(filtro.getOpcion()==0){
        	listado = BaseLegalBuilder.toListObligacionBaseLegalDto(query.getResultList());        	
        }else{
        	listado = BaseLegalBuilder.toListBaseLegalDto(query.getResultList());
        }
        
        LOG.info("listado: "+listado.size());
        return listado;
    }
	@Override
	@Transactional
	public BaseLegalDTO create(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO){
		LOG.info("Registro Base Legal DAO Impl");
		BaseLegalDTO retorno=null;
		PghDetalleBaseLegal detalleBaseLegal = null;
// 05-11-2015		
		Long idDetalleBaseLegalRetorno = null;
		String codTrazabilidadRetorno = null;
//		
		try{
			String estado="1";
			//Inserta código
//			String flagPadre=baseLegalDTO.getFlagPadre();
//                        String codigoBaseLegal = armaCodigoBaseLegal(flagPadre);
//			BaseLegalDTO lastBaseLegal=findUltimoRegistro();
//			String ultimoCodigo=lastBaseLegal.getCodigoBaseLegal();
//                        Long codigoBaseLegal = crud.findSequence("PGH_CODIGO_BASE_LEGAL_SEQ");
//			String codBaseLegal= MycUtil.generaCodigoBaseLegal(codigoBaseLegal);
			//
//			baseLegalDTO.setCodigoBaseLegal(codigoBaseLegal);
                        baseLegalDTO.setEstado(estado);
			PghBaseLegal baseLegal=BaseLegalBuilder.getBaseLegal(baseLegalDTO);
			baseLegal.setDatosAuditoria(usuarioDTO);
			PghBaseLegal pghBaseLegal= crud.create(baseLegal);
// 05-11-2015			
			codTrazabilidadRetorno = pghBaseLegal.getCodTrazabilidad();
//			
			boolean validarDetalle=validarDetalleBaseLegal(baseLegalDTO);
			
			if(validarDetalle){
				baseLegalDTO.setIdBaseLegal(pghBaseLegal.getIdBaseLegal());
				detalleBaseLegal=DetalleBaseLegalBuilder.getDetalleBaseLegal(baseLegalDTO);
				detalleBaseLegal.setDatosAuditoria(usuarioDTO);
				crud.create(detalleBaseLegal);
// 05-11-2015				
				idDetalleBaseLegalRetorno = detalleBaseLegal.getIdDetalleBaseLegal();				
//				
				System.out.println("ID DetalleBaseLegal: "+ detalleBaseLegal.getIdDetalleBaseLegal());
			}
			System.out.println("lista: " + baseLegalDTO.getListaBasesLegales());
			if(baseLegalDTO.getListaBasesLegales()!=null){
				List<BaseLegalConcordanciaDTO> baseLegalConcordanciaDTO=baseLegalDTO.getListaBasesLegales();
				for(BaseLegalConcordanciaDTO obj :baseLegalConcordanciaDTO){
					obj.setEstado(estado);
					obj.setIdBaseLegalOrigen(pghBaseLegal.getIdBaseLegal());
					PghListadoBaseLegal pghListadoBaseLegal = BaseLegalConcordanciaBuilder.getBaseLegalConcordancia(obj);
					pghListadoBaseLegal.setDatosAuditoria(usuarioDTO);
					crud.create(pghListadoBaseLegal);
				}			
			}
			
			System.out.println("lista de Obligaciones: " + baseLegalDTO.getListaObligaciones());
			if(baseLegalDTO.getListaObligaciones()!=null){
				List<ObligacionBaseLegalDTO> ObligacionBaseLegalDTO=baseLegalDTO.getListaObligaciones();
				for(ObligacionBaseLegalDTO obj :ObligacionBaseLegalDTO){
					obj.setEstado(estado);
					obj.setIdBaseLegal(pghBaseLegal.getIdBaseLegal());
//					Long id = crud.findSequence("PGH_OBL_BASE_LEGAL_SEQ");
//					obj.setIdOblBase(id);
					PghObligacionBaseLegal pghListadoObligacionBaseLegal = ObligacionBaseLegalBuilder.getObligacionBaseLegal(obj);
					pghListadoObligacionBaseLegal.setDatosAuditoria(usuarioDTO);
					crud.create(pghListadoObligacionBaseLegal);
				}			
			}
// 05-11-2015			
			
			
			//jsifuentes inicio
			if(baseLegalDTO.getDetalleNormaTecnica()!=null){
				List<DetalleNormaTecnicaDTO> detalleNormaTecnicaDTO=baseLegalDTO.getDetalleNormaTecnica();
				for (DetalleNormaTecnicaDTO obj : detalleNormaTecnicaDTO) {
					obj.setEstado(estado);
					obj.setIdDetalleBaseLegal(detalleBaseLegal.getIdDetalleBaseLegal());
					PghDetalleNormaTecnica pghDetalleNormaTecnica = DetalleNormaTecnicaBuilder.getDetalleNormaTecnica(obj);
					pghDetalleNormaTecnica.setDatosAuditoria(usuarioDTO);
					crud.create(pghDetalleNormaTecnica);
				}
				
			}
			//jsifuentes fin
			retorno=BaseLegalBuilder.toBaseLegalRetornoDto(pghBaseLegal,idDetalleBaseLegalRetorno,codTrazabilidadRetorno);
//			
			LOG.info("(Registro Base Legal DAO Impl) retorno: "+retorno.toString());
			
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return retorno;
	}
	
    @Override
    public Long count(BaseLegalFilter filtro){
        LOG.info("contador DAO IMPL");
        Query query = getFindQuery(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
    
    @Override
    public Long countPadre(BaseLegalFilter filtro){
        LOG.info("contador DAO IMPL");
        LOG.info("FlagOpcion --> "+filtro.getOpcion());
        Query query = getFindQueryPadre(filtro, true);
        LOG.info("salida contador DAO IMPL");
        return (Long) query.getSingleResult();
    }
	
    private boolean validarDetalleBaseLegal(BaseLegalDTO baseLegalDTO){
        LOG.info("validarDetalleBaseLegal:  "+baseLegalDTO.getArticuloNormaLegal());
        Boolean retorno=false;
        System.out.println(" articulo  "+baseLegalDTO.getArticuloNormaLegal());
        if(baseLegalDTO.getArticuloNormaLegal()!=null || baseLegalDTO.getArticuloAnexo()!=null){
                retorno=true;
        }
        return retorno;
    }
    
    private Query getFindQueryPadre(BaseLegalFilter filtro, boolean count) {
    	Query query=null;
        
        try{
            if (count) {
                if (filtro.getIdBaseLegal()!= null) {
                    query = crud.getEm().createNamedQuery("PghBaseLegal.countByIdBaseLegal");
                }else if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")) {
                    query=buildQueryFindAdvanceByFilter(filtro,true);
                }else{
                    query = buildQueryBaseLegalFilter(filtro,true);
                }
            }else {
                if (filtro.getIdBaseLegal()!= null) {
                    query = crud.getEm().createNamedQuery("PghBaseLegal.findByIdBaseLegal");
                }else if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")) {
                    query=buildQueryFindAdvanceByFilter(filtro,false);
                }else{
                	LOG.info("entroooo--->");
                    query = buildQueryBaseLegalFilter(filtro,false);
                }
            }
                        
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
	
    private Query getFindQuery(BaseLegalFilter filtro, boolean count) {
        Query query=null;
        
        try{
            if (count) {
                if (filtro.getIdBaseLegal()!= null) {
                    query = crud.getEm().createNamedQuery("PghBaseLegal.countByIdBaseLegal");
                }else if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")) {
                    query=buildQueryFindAdvanceByFilter(filtro,true);
                }else{
                    query = crud.getEm().createNamedQuery("PghBaseLegal.countByFilter");
                }
            }else {
                if (filtro.getIdBaseLegal()!= null) {
                    query = crud.getEm().createNamedQuery("PghBaseLegal.findByIdBaseLegal");
                }else if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")) {
                    query=buildQueryFindAdvanceByFilter(filtro,false);
                }else{
                    query = crud.getEm().createNamedQuery("PghBaseLegal.findByFilter");
                }
            }
            
            
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    
    public Query buildQueryFindAdvanceByFilter(BaseLegalFilter filtro, boolean count){
        LOG.info("DAO - buildQueryFindAdvanceByFilter");
        String queryString;
        StringBuilder jpql = new StringBuilder();
        boolean flgTablaDBL=false;
        boolean flgTablaOBL=false;
        Query query = null;
        try {			
		
        //arma CAMPOS QUERY 
        if (count) {
        	if(filtro.getOpcion()==0){
        		jpql.append("Select sum(count(distinct o.idObligacion)) ");
        	}else{
        		jpql.append("Select sum(count(distinct bl.idBaseLegal)) ");
        	}
            
        }else if(filtro.getOpcion()==0){
        	jpql.append("Select distinct new PghObligacion(o.idObligacion,o.codigoObligacion ,o.descripcion,o.estado, ");  
        	jpql.append("sum(case when (select x.idObligacion.idObligacion from PghObligacionBaseLegal x where x.idObligacion.idObligacion=o.idObligacion and x.estado='1' and rownum=1) is not null then 1 else 0 end) as tieneAct) ");
        }else{
        	jpql.append("Select distinct new PghBaseLegal(bl.idBaseLegal, bl.codigoBaseLegal, bl.descripcion,da.idDocumentoAdjunto,da.nombreArchivo,da.rutaAlfresco,bl.flagPadre, ");
            jpql.append("sum(case when (select x.idBaseLegal from PghBaseLegal x where x.idBaseLegalPadre=bl.idBaseLegal and x.estado='1' and rownum=1) is not null then 1 else 0 end) as tieneAct) ");
        }
        
        //arma FROM´s y JOIN´s
        if(filtro.getOpcion()==0){
        	jpql.append("from PghObligacion o "
//                    + "left join o.idDocumentoAdjunto da "
                    + "left join o.pghObligacionBaseLegalList obl "
                    + "left join o.pghDetalleObligacionList do "
                    + "left join o.pghConfObligacionList co "
                    + "left join o.pghTemaObligacionMaestroList tom "
                );
        	//arma WHERE´s
            jpql.append(" WHERE o.estado='1' ");
        }else{
        	jpql.append("from PghBaseLegal bl "
                    + "left join bl.idDocumentoAdjunto da "
                    + "left join bl.pghDetalleBaseLegalList dbl "
                    + "left join bl.pghObligacionBaseLegalList obl "
                    + "left join obl.idObligacion o "
                    + "left join o.pghDetalleObligacionList do "
                    + "left join o.pghConfObligacionList co "
                    + "left join o.pghTemaObligacionMaestroList tom "
                );
        	//arma WHERE´s
            jpql.append(" WHERE bl.estado='1' ");
        }
            //WHERE´s dinamicos
        if(filtro.getTipoNormaLegal() != null){
            jpql.append("and bl.idTipoNormaLegal=:idTipoNormaLegal ");
        }
        if(filtro.getNumeroNormaLegal() != null){
            jpql.append("and bl.numero like '%"+filtro.getNumeroNormaLegal()+"%' ");
        }
        if (filtro.getCodigoBaseLegal()!= null && !StringUtil.removeBlank(filtro.getCodigoBaseLegal()).equals("")) {
            jpql.append("and upper(bl.codigoBaseLegal) like :codigoBaseLegal ");
        } 
        if (filtro.getFechaEntradaVigenciaNormaLegal()!= null) {
            jpql.append("and bl.fechaEntradaVigencia=:fechaEntradaVigencia ");
        }
        if (filtro.getAnioNormaLegal()!= null && !StringUtil.removeBlank(filtro.getAnioNormaLegal()).equals("")) {
            jpql.append("and bl.anio like :anio ");
        } 
        if (filtro.getSiglaNormaLegal()!= null) {
            jpql.append("and bl.idSigla=:idSigla ");
        }
        if(filtro.getTitulo()!= null && !StringUtil.removeBlank(filtro.getTitulo()).equals("")) {
        	jpql.append("and upper(bl.titulo) like '%"+filtro.getTitulo()+"%' ");
        }
        //DBL
        if (filtro.getArticuloNormaLegal()!= null && !StringUtil.removeBlank(filtro.getArticuloNormaLegal()).equals("")) {
            flgTablaDBL=true;
            jpql.append("and upper(dbl.articulo) like :articulo ");
        }
        if (filtro.getTipoAnexo()!= null) {
            flgTablaDBL=true;
            jpql.append("and dbl.idTipoAnexo=:idTipoAnexo ");
        }
        if (filtro.getArticuloAnexo()!= null && !StringUtil.removeBlank(filtro.getArticuloAnexo()).equals("")) {
            flgTablaDBL=true;
            jpql.append("and upper(dbl.articuloAnexo) like :articuloAnexo ");
        }
        if(flgTablaDBL){
            jpql.append("and dbl.estado='1' ");
        }else{
        	if(filtro.getOpcion()==1){
        		String codBaseLegal = StringUtil.removeBlank(filtro.getCodigoBaseLegal());
        		String[] parts = codBaseLegal.split("-");
        		LOG.info("nomenclatura >++>"+parts[0]);
        		if(parts[0].equals("BL")){
        			jpql.append(" and bl.flagPadre is null ");
        		}else{
        			jpql.append(" and bl.flagPadre='P' ");	
        		}
        		
        	}        	
        }
        //OBL-O
        if(filtro.getCodigoObligacion()!=null && !StringUtil.removeBlank(filtro.getCodigoObligacion()).equals("")){
            flgTablaOBL=true;
            jpql.append("and upper(o.codigoObligacion) like :codigoObligacion ");
        }
        if(filtro.getIdCriticidadObligacion()!=null){
            flgTablaOBL=true;
            jpql.append("and o.idCriticidad=:idCriticidadObligacion ");
        }
        if(flgTablaOBL){
        	if(filtro.getOpcion()==0){
        		jpql.append("and obl.estado='1' ");
        	}else{
        		jpql.append("and obl.estado='1' and o.estado='1' ");
        	}
            
        }
        //DO
        if(filtro.getDescObligacionDetalle()!=null && !StringUtil.removeBlank(filtro.getDescObligacionDetalle()).equals("")){
            jpql.append("and upper(do.descripcion) like :descObligacionDetalle and do.estado='1' ");
        }
        //CO
        if(filtro.getIdActividadesBusq()!=null && !StringUtil.removeBlank(filtro.getIdActividadesBusq()).equals("")){
            jpql.append("and co.pghProcesoObligacionTipo.mdiActividad.idActividad in ("+filtro.getIdActividadesBusq()+") and co.estado='1' ");
        }
        
        if(filtro.getIdObligacionTipo()!=null){
        	if(filtro.getIdObligacionTipo()==-1){
        		jpql.append(" and co.pghProcesoObligacionTipo is null ");
        	}else{
        		jpql.append(" and co.pghProcesoObligacionTipo.pghObligacionTipo.idObligacionTipo=:idObligacionTipo ");
        	}        	
        }
        //TOM
        if(filtro.getIdTemasBusq()!=null && !StringUtil.removeBlank(filtro.getIdTemasBusq()).equals("")){
            jpql.append("and tom.idTemaObligacion in ("+filtro.getIdTemasBusq()+") and tom.estado='1' ");
        }
        
        if(filtro.getIdsBaseLegal()!=null && !StringUtil.removeBlank(filtro.getIdsBaseLegal()).equals("")){
            jpql.append("and bl.idBaseLegal not in ("+filtro.getIdsBaseLegal()+")");
        }
        if(filtro.getOpcion()==0){
        	jpql.append(" group by o.idObligacion, o.codigoObligacion, o.descripcion, o.estado ");
        	jpql.append(" order by o.codigoObligacion asc ");        	
        }else{
        	jpql.append(" group by bl.idBaseLegal,bl.codigoBaseLegal, bl.descripcion,da.idDocumentoAdjunto,da.nombreArchivo,bl.flagPadre,da.rutaAlfresco ");
            jpql.append(" order by bl.descripcion desc ");
        }
        
        //arma GROUP BY
//        if (!count) {
//            jpql.append("GROUP BY pro.idProcedimiento, pro.item,pro.denominacion, pr.idProceso,et.idEtapa,et.descripcion ");
//        }
        
        //////////////////////////////////////
        //Crear QUERY
        queryString = jpql.toString();
        LOG.info("Query interno OO> "+queryString);
        query = this.crud.getEm().createQuery(queryString);
        //////////////////////////////////////
        //Ingreso de PARAMETROS
            //parametros de WHERE's
        if(filtro.getTipoNormaLegal() != null){
            query.setParameter("idTipoNormaLegal",filtro.getTipoNormaLegal());
        }
        if (filtro.getCodigoBaseLegal()!= null && !StringUtil.removeBlank(filtro.getCodigoBaseLegal()).equals("")) {
            query.setParameter("codigoBaseLegal","%"+StringUtil.removeBlank(filtro.getCodigoBaseLegal().toUpperCase())+"%");
        }
        if (filtro.getFechaEntradaVigenciaNormaLegal()!= null) {
            query.setParameter("fechaEntradaVigencia",filtro.getFechaEntradaVigenciaNormaLegal());
        }
        if (filtro.getAnioNormaLegal()!= null && !StringUtil.removeBlank(filtro.getAnioNormaLegal()).equals("")) {
            query.setParameter("anio","%"+StringUtil.removeBlank(filtro.getAnioNormaLegal())+"%");
        }
        if (filtro.getSiglaNormaLegal()!= null) {
            query.setParameter("idSigla",filtro.getSiglaNormaLegal());
        } 
        //DBL
        if (filtro.getArticuloNormaLegal()!= null && !StringUtil.removeBlank(filtro.getArticuloNormaLegal()).equals("")) {
            query.setParameter("articulo","%"+StringUtil.removeBlank(filtro.getArticuloNormaLegal().toUpperCase())+"%");
        }
        if (filtro.getTipoAnexo()!= null) {
            query.setParameter("idTipoAnexo",filtro.getTipoAnexo());
        }
        if (filtro.getArticuloAnexo()!= null && !StringUtil.removeBlank(filtro.getArticuloAnexo()).equals("")) {
            query.setParameter("articuloAnexo","%"+StringUtil.removeBlank(filtro.getArticuloAnexo().toUpperCase())+"%");
        }
        //OBL-O
        if(filtro.getCodigoObligacion()!=null && !StringUtil.removeBlank(filtro.getCodigoObligacion()).equals("")){
            query.setParameter("codigoObligacion","%"+StringUtil.removeBlank(filtro.getCodigoObligacion().toUpperCase())+"%");
        }
        if (filtro.getIdCriticidadObligacion()!= null) {
            query.setParameter("idCriticidadObligacion",filtro.getIdCriticidadObligacion());
        }
        //CO
        if(filtro.getIdObligacionTipo()!=null && filtro.getIdObligacionTipo()!=-1){
        	query.setParameter("idObligacionTipo",filtro.getIdObligacionTipo());
        }
        //DO
        if(filtro.getDescObligacionDetalle()!=null && !StringUtil.removeBlank(filtro.getDescObligacionDetalle()).equals("")){
            query.setParameter("descObligacionDetalle","%"+StringUtil.removeBlank(filtro.getDescObligacionDetalle().toUpperCase())+"%");
        }
        
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        //////////////////////////////////////
        return query;
    }
    public Query buildQueryBaseLegalFilter(BaseLegalFilter filtro, boolean count){
        LOG.info("DAO - buildQueryBaseLegalFilter");
        String queryString;
        StringBuilder jpql = new StringBuilder();
        boolean flgTablaDBL=false;
        boolean flgTablaOBL=false;
        Query query = null;
        try {			
		
        //arma CAMPOS QUERY 
        if (count) {        	
        	jpql.append("Select sum(count(distinct bl.idBaseLegal)) ");
            
        }else{
        	jpql.append("Select distinct new PghBaseLegal(bl.idBaseLegal, bl.codigoBaseLegal, bl.descripcion,da.idDocumentoAdjunto,da.nombreArchivo,da.rutaAlfresco,bl.flagPadre, ");
            jpql.append("sum(case when (select x.idBaseLegal from PghBaseLegal x where x.idBaseLegalPadre=bl.idBaseLegal and x.estado='1' and rownum=1) is not null then 1 else 0 end) as tieneAct) ");
        }
        
        	jpql.append("from PghBaseLegal bl "
                    + "left join bl.idDocumentoAdjunto da "
                );
        	//arma WHERE´s
            jpql.append(" WHERE bl.estado='1' and bl.flagPadre = 'P' ");

            //WHERE´s dinamicos

        if (filtro.getCodigoBaseLegal()!= null && !StringUtil.removeBlank(filtro.getCodigoBaseLegal()).equals("")) {
            jpql.append("and upper(bl.codigoBaseLegal) like :codigoBaseLegal ");
        } 
        if (filtro.getDescripcionNormaLegal()!= null && !StringUtil.removeBlank(filtro.getDescripcionNormaLegal()).equals("")) {
            jpql.append("and upper(bl.descripcion) like :descripcion ");
        } 
        if(filtro.getTitulo()!= null && !StringUtil.removeBlank(filtro.getTitulo()).equals("")) {
        	jpql.append("and upper(bl.titulo) like '%"+filtro.getTitulo()+"%' ");
        }
        
        if(filtro.getIdsBaseLegal()!=null && !StringUtil.removeBlank(filtro.getIdsBaseLegal()).equals("")){
            jpql.append("and bl.idBaseLegal not in ("+filtro.getIdsBaseLegal()+")");
        }
  
        jpql.append(" group by bl.idBaseLegal,bl.codigoBaseLegal, bl.descripcion,da.idDocumentoAdjunto,da.nombreArchivo,bl.flagPadre,da.rutaAlfresco ");
        jpql.append(" order by bl.codigoBaseLegal desc ");
       
        //////////////////////////////////////
        //Crear QUERY
        queryString = jpql.toString();
        LOG.info("Query > "+queryString);
        query = this.crud.getEm().createQuery(queryString);
        //////////////////////////////////////
        //Ingreso de PARAMETROS
            //parametros de WHERE's
        if (filtro.getDescripcionNormaLegal()!=null && !StringUtil.isEmpty(filtro.getDescripcionNormaLegal())) {
        	LOG.info("aa");
            query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcionNormaLegal().toUpperCase())+"%");            
        }
        if (!StringUtil.isEmpty(filtro.getCodigoBaseLegal())) {
        	LOG.info("bb");
            query.setParameter("codigoBaseLegal","%"+StringUtil.removeBlank(filtro.getCodigoBaseLegal().toUpperCase())+"%");
        }
        
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        //////////////////////////////////////
        return query;
    }
	/*@Override
	 @SuppressWarnings("unchecked")
	public BaseLegalDTO findBaseLegalbyCodigo(String codigoBaseLegal) {
		System.out.println("ENTRANDO AL findBaseLegalbyCodigo "+codigoBaseLegal);
		BaseLegalDTO retorno=null;
		try{
            Query query = crud.getEm().createNamedQuery("PghBaseLegal.findByCodigoBaseLegal");
            query.setParameter("codigoBaseLegal", codigoBaseLegal);
            System.out.println("zzzzzzzzzzzzzzzzX  "+codigoBaseLegal);
			List<PghBaseLegal> pghBaseLegal=query.getResultList();
            System.out.println("XXXXXXXXXXXXXXXX  "+pghBaseLegal);
//            retorno=BaseLegalBuilder.toListBaseLegalDto(query.getResultList());
        }catch(Exception e){
            e.printStackTrace();
        }
		return retorno;
	}*/
	
	@Override
	public Long contador(BaseLegalFilter filtro){
		LOG.info("contador DAO IMPL bases legales en concordancia");
//		String codigoBaseLegal=filtro.getCodigoBaseLegal();
		Long idBaseLegal=filtro.getIdBaseLegal();
		LOG.info("Query: "+idBaseLegal);
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT count(p) FROM PghListadoBaseLegal p WHERE p.estado='1' and p.idBaseLegalOri.idBaseLegal="+idBaseLegal+"");
        LOG.info("Query: "+jpql.toString());
        Query query = crud.getEm().createQuery(jpql.toString());
		return (Long) query.getSingleResult();
        
	}
	
    @Override
    public List<BaseLegalDTO>  findBaseLegalbyCodigo(BaseLegalFilter filtro) {
    	List<BaseLegalDTO>  retorno=null;
        LOG.info("obtener el metodo findBaseLegalbyCodigo "+ filtro);
    try {
//    	String codigoBaseLegal=filtro.getCodigoBaseLegal();
    	Long idBaseLegal=filtro.getIdBaseLegal();
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p.idBaseLegalDest, p.idBaseLegalDest.codigoBaseLegal,p.idBaseLegalDest.descripcion FROM PghListadoBaseLegal p WHERE p.estado='1' and p.idBaseLegalOri.idBaseLegal="+idBaseLegal);
        Query query = crud.getEm().createQuery(jpql.toString());
        LOG.info("query findBaseLegalbyCodigo: " + jpql.toString());
//        query.setParameter("codigoBaseLegal", codigoBaseLegal);
        List<Object[]>  resultados = query.getResultList();   
        System.out.println(" AAAAAAAAAAAA "+resultados);
        if(!CollectionUtils.isEmpty(resultados)){
        	retorno=BaseLegalConcordanciaBuilder.toListBaseLegalConcordanciaRefDto(resultados);
        }
    
        }catch(RuntimeException e) {
            LOG.error(e.getMessage(),e);   
            e.printStackTrace();
            
        }
        catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
    return retorno;
 }
/*
	public BaseLegalDTO findUltimoRegistro() {
		BaseLegalDTO retorno=null;
		LOG.info("obtener el metodo findUltimoRegistro ");
		try {
	        StringBuilder jpql = new StringBuilder();
	        jpql.append("SELECT p FROM PghBaseLegal p order by p.codigoBaseLegal desc limit 1");
	        Query query = crud.getEm().createQuery(jpql.toString());
	        LOG.info("query findUtimoRegistro: " + jpql.toString());
	        List<PghBaseLegal> resultados = query.getResultList();   
	        System.out.println(" AAAAAAAAAAAA "+resultados);
	        if(resultados.size()>0){
	        	retorno=BaseLegalBuilder.toBaseLegalDto(resultados.get(0));
	        }
	    }catch(RuntimeException e) {
			LOG.error(e.getMessage(),e);   
			e.printStackTrace();
		}
		catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
		
		return retorno;
	}
        */
        public String armaCodigoBaseLegal(String flagPadre) {
                String codigoBaseLegal = "";
		LOG.info("obtener el metodo findUltimoRegistro ");
		try {
			
	        StringBuilder jpql = new StringBuilder();
	        Object codigo;
	        if(flagPadre!=null){
//	        	jpql.append("select lpad(PGH_CODIGO_NORMA_LEGAL_SEQ.NEXTVAL,5,'0') from dual");
	        	jpql.append("SELECT GENERAR_CODIGO_NORMA_LEGAL() FROM DUAL");
		        Query query = crud.getEm().createNativeQuery(jpql.toString());
		        LOG.info("query findUtimoRegistro: " + jpql.toString());
	            codigo = query.getSingleResult();   
		        LOG.info(" codigo = "+codigo);
	        }else{
//	        	jpql.append("select lpad(PGH_CODIGO_BASE_LEGAL_SEQ.NEXTVAL,7,'0') from dual");
	        	jpql.append("SELECT GENERAR_CODIGO_BASE_LEGAL() FROM DUAL");
		        Query query = crud.getEm().createNativeQuery(jpql.toString());
		        LOG.info("query findUtimoRegistro: " + jpql.toString());
	            codigo = query.getSingleResult();   
		        LOG.info(" codigo = "+codigo);
	        }
	        

	        if(flagPadre!=null){
	        	codigoBaseLegal = codigo.toString();
	        }else{
	        	codigoBaseLegal = codigo.toString();
	        }
	        	
                
            }catch(Exception e) {
                LOG.error(e.getMessage(),e);
                e.printStackTrace();
            }
            return codigoBaseLegal;
	}
	@Override
	public Long contadorbyId(Long codigoEditarBaseLegal) {
		LOG.info("contador DAO IMPL ver base legal");
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT count(p) FROM PghBaseLegal p WHERE p.estado='1' and p.idBaseLegal='"+codigoEditarBaseLegal+"'");
        LOG.info("Query: "+jpql.toString());
        Query query = crud.getEm().createQuery(jpql.toString());
		return (Long) query.getSingleResult();
	}

	@Override
	public BaseLegalDTO findBaseLegalbyId(Long codigoEditarBaseLegal) {
		BaseLegalDTO retorno=null;
		LOG.info("obtener Base Legal ");
		try {
			StringBuilder jpql = new StringBuilder();
			jpql.append("SELECT p FROM PghBaseLegal p WHERE p.estado='1' and p.idBaseLegal='"+codigoEditarBaseLegal+"'");
	        LOG.info("Query: "+jpql.toString());
	        Query query = crud.getEm().createQuery(jpql.toString());
			
			List<PghBaseLegal> resultados = query.getResultList();
			System.out.println(" AAAAAAAAAAAA "+resultados);
	        if(resultados.size()>0){
	        	retorno=BaseLegalBuilder.toBaseLegalDto(resultados.get(0));
	        }
			
	    }catch(RuntimeException e) {
			LOG.error(e.getMessage(),e);   
			e.printStackTrace();
		}
		catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
		
		return retorno;
	}

	@Override
	public Long contadorDetallebyId(Long codigoEditarBaseLegal) {
		LOG.info("contador DAO IMPL ver base legal");
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT count(p) FROM PghDetalleBaseLegal p WHERE p.estado='1' and p.idBaseLegal='"+codigoEditarBaseLegal+"'");
        LOG.info("Query: "+jpql.toString());
        Query query = crud.getEm().createQuery(jpql.toString());
		return (Long) query.getSingleResult();
	}

	@Override
	public DetalleBaseLegalDTO findDetalleBaseLegalbyId(Long codigoEditarBaseLegal) {
		DetalleBaseLegalDTO retorno=null;
		LOG.info("obtener Base Legal ");
		try {
			StringBuilder jpql = new StringBuilder();
			jpql.append("SELECT p FROM PghDetalleBaseLegal p WHERE p.estado='1' and p.idBaseLegal='"+codigoEditarBaseLegal+"'");
	        LOG.info("Query: "+jpql.toString());
	        Query query = crud.getEm().createQuery(jpql.toString());
			
			List<PghDetalleBaseLegal> resultados = query.getResultList();
			System.out.println(" AAAAAAAAAAAA "+resultados);
	        if(resultados.size()>0){
	        	retorno=DetalleBaseLegalBuilder.toDetalleBaseLegalRefDto(resultados.get(0));
	        }
			
	    }catch(RuntimeException e) {
			LOG.error(e.getMessage(),e);   
			e.printStackTrace();
		}
		catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
		
		return retorno;
	}

    @Override
    @Transactional
    public BaseLegalDTO update(BaseLegalDTO baseLegalDTO, UsuarioDTO usuarioDTO) {
        BaseLegalDTO retorno = null;
        try{
            String estado="1";
            baseLegalDTO.setEstado(estado);
            PghBaseLegal baseAct = crud.find(baseLegalDTO.getIdBaseLegal(), PghBaseLegal.class);
            PghBaseLegal baseUpd = BaseLegalBuilder.getBaseLegal(baseLegalDTO);
            //Inicio correcciones MYC-5
            if(baseUpd.getIdDocumentoAdjunto()!=null && baseUpd.getIdDocumentoAdjunto().getIdDocumentoAdjunto()!=null){
            	
            }else{            	
            	baseUpd.setIdDocumentoAdjunto(baseAct.getIdDocumentoAdjunto());
            }
            //Fin
            
            boolean validarDetalle=validarDetalleBaseLegal(baseLegalDTO);
            
            LOG.info("SE PROCEDE A ACTUALIZAR BASE LEGAL");
            baseUpd.setEstado(baseLegalDTO.getEstado());
            baseUpd.setDatosAuditoria(usuarioDTO);
            crud.updateWithHistory(baseUpd);
                
            if(baseLegalDTO.getIdDetalleBaseLegal()!=null){
                PghDetalleBaseLegal detalleAct = crud.find(baseLegalDTO.getIdDetalleBaseLegal(), PghDetalleBaseLegal.class);
                PghDetalleBaseLegal detalleUpd = DetalleBaseLegalBuilder.getDetalleBaseLegal(baseLegalDTO);

                LOG.info("SE PROCEDE A ACTUALIZAR EL DETALLE BASE LEGAL");
                detalleUpd.setEstado(baseLegalDTO.getEstado());
                detalleUpd.setDatosAuditoria(usuarioDTO);
                crud.updateWithHistory(detalleUpd);
            }else if(baseLegalDTO.getIdDetalleBaseLegal()==null && validarDetalle){
                baseLegalDTO.setIdBaseLegal(baseUpd.getIdBaseLegal());
                PghDetalleBaseLegal detalleBaseLegal=DetalleBaseLegalBuilder.getDetalleBaseLegal(baseLegalDTO);
                detalleBaseLegal.setDatosAuditoria(usuarioDTO);
                crud.create(detalleBaseLegal);
                LOG.info("id Detalle: "+ detalleBaseLegal.getIdDetalleBaseLegal());
            }
    			
            if(baseLegalDTO.getListaBasesLegales()!=null){

                List<BaseLegalConcordanciaDTO> baseLegalConcordanciaAct=findListado(baseLegalDTO.getIdBaseLegal());
                LOG.info("Listado de Bases Legales de la Base de Datos: "+baseLegalConcordanciaAct);
                List<BaseLegalConcordanciaDTO> baseLegalConcordanciaUpd=baseLegalDTO.getListaBasesLegales();
                LOG.info("Listado de Bases Legales del Front: "+baseLegalConcordanciaUpd);

                String cadenaAct=concatenaListadoBasesLegalesConcordancia(baseLegalConcordanciaAct);
                LOG.info("Listado Base de Datos( Bases en Concordancia ): "+cadenaAct);
                String cadenaUpd=concatenaListadoBasesLegalesConcordancia(baseLegalConcordanciaUpd);
                LOG.info("Listado por Actualizar( Bases en Concordancia ): "+cadenaUpd);

                if(baseLegalConcordanciaAct==null){
                    LOG.info("SE PROCEDE A INSERTAR LAS NUEVAS BASES LEGALES EN CONCORDANCIA");
                    //se comparan las cadenas <--> insertar cuando no existen
                    for(BaseLegalConcordanciaDTO regBase: baseLegalConcordanciaUpd){
                        LOG.info("Base Legal en Concordancia Nuevo-->"+regBase.getIdBaseLegalDestino());
                        regBase.setEstado(estado);
                        regBase.setIdBaseLegalOrigen(baseUpd.getIdBaseLegal());
                        regBase.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
                        PghListadoBaseLegal pghListadoBaseLegal = BaseLegalConcordanciaBuilder.getBaseLegalConcordancia(regBase);
                        pghListadoBaseLegal.setDatosAuditoria(usuarioDTO);
                        crud.createWithHistory(pghListadoBaseLegal);
                    }
                }else{    				
                    if(!cadenaAct.equals(cadenaUpd)){
                        LOG.info("SE PROCEDE A ACTUALIZAR LISTADO DE BASES LEGALES EN CONCORDANCIA");
                        //se comparan las cadenas <--> insertar cuando no existen
                        for(BaseLegalConcordanciaDTO regBase: baseLegalConcordanciaUpd){
                            boolean existe=existIdBaseLegalEnLista(regBase.getIdBaseLegalDestino(),baseLegalConcordanciaAct);
                            if(!existe){
                                LOG.info("Base Legal en Concordancia Nuevo-->"+regBase.getIdBaseLegalDestino());
                                regBase.setEstado(estado);
                                regBase.setIdBaseLegalOrigen(baseUpd.getIdBaseLegal());
                                regBase.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
                                PghListadoBaseLegal pghListadoBaseLegal = BaseLegalConcordanciaBuilder.getBaseLegalConcordancia(regBase);
                                pghListadoBaseLegal.setDatosAuditoria(usuarioDTO);
                                crud.createWithHistory(pghListadoBaseLegal);
                            }
                        }
                        //se comparan las cadenas <--> eliminan cuando no se encuentra en el nuevo listado
                        for(BaseLegalConcordanciaDTO regBase:baseLegalConcordanciaAct){
                            boolean existe=existIdBaseLegalEnLista(regBase.getIdBaseLegalDestino(),baseLegalConcordanciaUpd);
                            if(!existe){
                                LOG.info("Base Legal en Concordancia Cambiar-->"+regBase.getIdBaseLegalDestino());
                                PghListadoBaseLegal regListado = crud.find(regBase.getIdListadoBaseLegal(), PghListadoBaseLegal.class);
                                String estadoUpd="0";
                                regListado.setEstado(estadoUpd);
                                regListado.setDatosAuditoria(usuarioDTO);
                                regListado.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
                                crud.updateWithHistory(regListado);
                            }
                        }
                    }
                }
            }else{ 
                List<BaseLegalConcordanciaDTO> baseLegalConcordanciaAct=findListado(baseLegalDTO.getIdBaseLegal());
                LOG.info("Listado de Bases Legales de la Base de Datos: "+baseLegalConcordanciaAct);
                List<BaseLegalConcordanciaDTO> baseLegalConcordanciaUpd=baseLegalDTO.getListaBasesLegales();
                LOG.info("Listado de Bases Legales del Front: "+baseLegalConcordanciaUpd);

                String cadenaAct=concatenaListadoBasesLegalesConcordancia(baseLegalConcordanciaAct);
                LOG.info("Listado Base de Datos( Bases en Concordancia ): "+cadenaAct);
                String cadenaUpd=concatenaListadoBasesLegalesConcordancia(baseLegalConcordanciaUpd);
                LOG.info("Listado por Actualizar( Bases en Concordancia ): "+cadenaUpd);
                if(baseLegalConcordanciaAct!=null){
                    for(BaseLegalConcordanciaDTO regBase:baseLegalConcordanciaAct){
                        boolean existe=existIdBaseLegalEnLista(regBase.getIdBaseLegalDestino(),baseLegalConcordanciaUpd);
                        if(!existe){
                            LOG.info("Base Legal en Concordancia Cambiar-->"+regBase.getIdBaseLegalDestino());
                            PghListadoBaseLegal regListado = crud.find(regBase.getIdListadoBaseLegal(), PghListadoBaseLegal.class);
                            String estadoUpd="0";
                            regListado.setEstado(estadoUpd);
                            regListado.setDatosAuditoria(usuarioDTO);
                            regListado.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
                            crud.updateWithHistory(regListado);
                        }
                    }
                }
            }
            
            //jsifuentes inicio
			if(baseLegalDTO.getDetalleNormaTecnica()!=null){
				List<DetalleNormaTecnicaDTO> detalleNormaTecnicaDTO=baseLegalDTO.getDetalleNormaTecnica();
				for (DetalleNormaTecnicaDTO obj : detalleNormaTecnicaDTO) {
					obj.setEstado(estado);
					obj.setIdDetalleBaseLegal(baseLegalDTO.getIdDetalleBaseLegal());
					PghDetalleNormaTecnica pghDetalleNormaTecnica = DetalleNormaTecnicaBuilder.getDetalleNormaTecnica(obj);
					pghDetalleNormaTecnica.setDatosAuditoria(usuarioDTO);
					crud.create(pghDetalleNormaTecnica);
				}
				
			}
			//jsifuentes fin
    			
            retorno=BaseLegalBuilder.toBaseLegalDto(baseUpd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return retorno;
    }
	
	private List<BaseLegalConcordanciaDTO> findListado(Long idBaseLegal){
        List<BaseLegalConcordanciaDTO> retorno=null;
        try{
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghListadoBaseLegal p WHERE p.estado='1' and p.idBaseLegalOri='"+idBaseLegal+"'");
            Query query = crud.getEm().createQuery(jpql.toString());
            LOG.info("query findBaseLegalbyCodigo: " + jpql.toString());
//            query.setParameter("codigoBaseLegal", codigoBaseLegal);
            List<PghListadoBaseLegal>  resultados = query.getResultList();   
            System.out.println(" AAAAAAAAAAAA "+resultados);
            if(!CollectionUtils.isEmpty(resultados)){
            	retorno=BaseLegalConcordanciaBuilder.toListBaseLegalConcordanciaDto(resultados);
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
	public static String concatenaListadoBasesLegalesConcordancia(List<BaseLegalConcordanciaDTO> listaConcordancia){
        String retorno="";
        if(listaConcordancia!=null && listaConcordancia.size()>0){
            String[] s = new String[listaConcordancia.size()];
            int cont=0;
            for(BaseLegalConcordanciaDTO maestra : listaConcordancia){s[cont]=maestra.getIdBaseLegalDestino().toString();cont++;}
            retorno = StringUtils.join(s, ",");
        }        
        return retorno;
    }
	public static boolean existIdBaseLegalEnLista(Long idBaseLegal, List<BaseLegalConcordanciaDTO> listado){
        boolean retorno=false;//inicializo como que NO ESTA
        if(listado!=null){
            for(BaseLegalConcordanciaDTO maestroAct : listado){
                if(idBaseLegal.equals(maestroAct.getIdBaseLegalDestino())){
                    retorno=true;
                }
            }
        }
        return retorno;
    }

	@Override
	public Long countObligacion(BaseLegalFilter filtro) {
		LOG.info("contador DAO IMPL Obligaciones por Base Legal (Ingresando)....");
		Long idBaseLegal=filtro.getIdBaseLegal();
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT count(p) FROM PghObligacionBaseLegal p WHERE p.estado='1' and p.idBaseLegal.idBaseLegal='"+idBaseLegal+"'");
        LOG.info("Query: "+jpql.toString());
        Query query = crud.getEm().createQuery(jpql.toString());
        LOG.info("contador DAO IMPL Obligaciones por Base Legal (Saliendo)....");
		return (Long) query.getSingleResult();
	}

	@Override
	public List<ObligacionBaseLegalDTO> findObligacionByBaseLegal(
			BaseLegalFilter filtro) {
		List<ObligacionBaseLegalDTO>  retorno=null;
        LOG.info("Listar Obligaciones By Base Legal (Ingresando)... "+ filtro.getIdBaseLegal());
    try {
    	Long idBaseLegal=filtro.getIdBaseLegal();
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p.idObligacion.idObligacion,p.idObligacion.codigoObligacion,p.idObligacion.descripcion, p.idObligacion.idDocumentoAdjunto "
                + "FROM PghObligacionBaseLegal p WHERE p.estado='1' and p.idBaseLegal.idBaseLegal='"+idBaseLegal+"' order by p.idObligacion.codigoObligacion asc");
        Query query = crud.getEm().createQuery(jpql.toString());
        LOG.info("query : " + jpql.toString());
        List<Object[]>  resultados = query.getResultList();   
        System.out.println(" Resultado Listado de Obligaciones By Base Legal "+resultados);
	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=ObligacionBaseLegalBuilder.toListObligacionBaseLegalRefDto(resultados);
	        }
    	}catch(RuntimeException e) {
            LOG.error(e.getMessage(),e);   
            e.printStackTrace();
        }
        catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
    return retorno;
	}

	@Override
	public List<ObligacionBaseLegalDTO> updateListadoObligaciones(BaseLegalDTO baseLegalDTO, UsuarioDTO usuarioDTO) {
		
            PghBaseLegal baseLegalAct = crud.find(baseLegalDTO.getIdBaseLegal(), PghBaseLegal.class);

            Long idBaseLegal=baseLegalDTO.getIdBaseLegal();// Id de la Base Legal
            // DTO : BaseLegalConcordanciaDTO
            List<ObligacionBaseLegalDTO> listadoObligacionAct = crud.findListObligacionesAct(idBaseLegal);
            LOG.info("Listado de Obligaciones Actuales: "+listadoObligacionAct);

            List<ObligacionBaseLegalDTO> listadoObligacionUpd=baseLegalDTO.getListaObligaciones();
            LOG.info("Listado de Obligaciones Por Actualizar: "+listadoObligacionUpd);

            String cadenaAct=MycUtil.concatenaObligaciones(listadoObligacionAct); // Cadena de Obligaciones Actuales en BD
            LOG.info("Cadena Actual: "+cadenaAct);
            String cadenaUpd=MycUtil.concatenaObligaciones(listadoObligacionUpd); // Cadena de Obligaciones Por Actualizar
            LOG.info("Cadena Por Actualizar: "+cadenaUpd);
            try{
                if(listadoObligacionAct==null){
                        LOG.info("No tiene Obligaciones Asociadas ");
                        for(ObligacionBaseLegalDTO regOblg:listadoObligacionUpd){
                                LOG.info(" ==> Insertando :" +regOblg.getIdObligacion());
                                regOblg.setIdBaseLegal(baseLegalAct.getIdBaseLegal());
                                //Long idOblBase=crud.findSequence("PGH_OBL_BASE_LEGAL_SEQ");
                                //regOblg.setIdOblBase(idOblBase); // Setea Sequence
                                regOblg.setEstado(baseLegalDTO.getEstado());
                                regOblg.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
                                PghObligacionBaseLegal pghListadoObligacion = ObligacionBaseLegalBuilder.getObligacionBaseLegal(regOblg);
                                pghListadoObligacion.setDatosAuditoria(usuarioDTO);
                                crud.createWithHistory(pghListadoObligacion);
                        }
                }else{
                        if(!cadenaAct.equals(cadenaUpd)){
                                LOG.info("Si tiene Obligaciones Asociadas ");
                                LOG.info("Cadena Actual:  " + cadenaAct +" <==> "+" Cadena Nueva:  "+ cadenaUpd);
                                // Se inserta Obligacion cuando no se encuentra en la cadena Actual
                                for(ObligacionBaseLegalDTO regOblg:listadoObligacionUpd){
                                        boolean existe=MycUtil.existeIdEnLista(regOblg.getIdObligacion(), listadoObligacionAct);
                                        if(!existe){
                                                LOG.info(" Nueva Obligación --> " + regOblg.getIdObligacion());
                                                regOblg.setIdBaseLegal(baseLegalAct.getIdBaseLegal());
                                                //Long idOblBase=crud.findSequence("PGH_OBL_BASE_LEGAL_SEQ");
                                                //regOblg.setIdOblBase(idOblBase); // Setea Sequence
                                                regOblg.setEstado(baseLegalDTO.getEstado());
                                                regOblg.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
                                                PghObligacionBaseLegal pghListadoObligacion = ObligacionBaseLegalBuilder.getObligacionBaseLegal(regOblg);
                                                pghListadoObligacion.setDatosAuditoria(usuarioDTO);
                                                crud.createWithHistory(pghListadoObligacion);
                                        }
                                }
                                // Se elimina Obligacion cuando no se encuentra en la cadena Nueva
                                for(ObligacionBaseLegalDTO regOblg:listadoObligacionAct){
                                        boolean existe=MycUtil.existeIdEnLista(regOblg.getIdObligacion(), listadoObligacionUpd);
                                        if(!existe){
                                                LOG.info(" Id Obligación a Eliminar: --> " + regOblg.getIdObligacion());
                                                LOG.info(" Id Registro:  --> " + regOblg.getIdOblBase());
                                                //PghObligacionBaseLegal regEliminar = crud.findObject(regOblg.getIdOblBase());
                                                PghObligacionBaseLegal regEliminar = crud.find(regOblg.getIdOblBase(),PghObligacionBaseLegal.class);
                                                String estado="0";
                                                regEliminar.setEstado(estado);
                                                regEliminar.setDatosAuditoria(usuarioDTO);
                                                regEliminar.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
                                                crud.updateWithHistory(regEliminar);
                                        }
                                }
                        }
                }
            }catch(Exception e){
                LOG.error("Error en updateListadoObligaciones : "+e.getMessage());
                e.printStackTrace();
            }

//		listadoObligacionUpd=ObligacionBaseLegalBuilder.toListObligacionBaseLegalDto(lista);
            return listadoObligacionUpd;
        }

	@Override
	public List<ObligacionBaseLegalDTO> cambiarEstadoListadoObligaciones(BaseLegalDTO baseLegalDTO, UsuarioDTO usuarioDTO) {
		
            PghBaseLegal baseLegalAct = crud.find(baseLegalDTO.getIdBaseLegal(), PghBaseLegal.class);

            Long idBaseLegal=baseLegalDTO.getIdBaseLegal();// Id de la Base Legal
            // DTO : BaseLegalConcordanciaDTO
            List<ObligacionBaseLegalDTO> listadoObligacionAct = crud.findListObligacionesAct(idBaseLegal);
            LOG.info("Listado de Obligaciones Actuales: "+listadoObligacionAct);

            List<ObligacionBaseLegalDTO> listadoObligacionUpd=baseLegalDTO.getListaObligaciones();
            LOG.info("Listado de Obligaciones Por Actualizar: "+listadoObligacionUpd);

            String cadenaAct=MycUtil.concatenaObligaciones(listadoObligacionAct); // Cadena de Obligaciones Actuales en BD
            LOG.info("Cadena Actual: "+cadenaAct);
            String cadenaUpd=MycUtil.concatenaObligaciones(listadoObligacionUpd); // Cadena de Obligaciones Por Actualizar
            LOG.info("Cadena Por Actualizar: "+cadenaUpd);

            try{
                if(listadoObligacionAct!=null){
                        // Se elimina Obligacion cuando no se encuentra en la cadena Nueva
                        for(ObligacionBaseLegalDTO regOblg:listadoObligacionAct){
                                boolean existe=MycUtil.existeIdEnLista(regOblg.getIdObligacion(), listadoObligacionUpd);
                                if(!existe){
                                        LOG.info(" Id Obligación a Eliminar: --> " + regOblg.getIdObligacion());
                                        LOG.info(" Id Registro:  --> " + regOblg.getIdOblBase());
                                        //PghObligacionBaseLegal regEliminar = crud.findObject(regOblg.getIdOblBase());
                                        PghObligacionBaseLegal regEliminar = crud.find(regOblg.getIdOblBase(),PghObligacionBaseLegal.class);
                                        String estado="0";
                                        regEliminar.setEstado(estado);
                                        regEliminar.setDatosAuditoria(usuarioDTO);
                                        regEliminar.setCodTrazabilidad(baseLegalDTO.getCodTrazabilidad());
                                        crud.updateWithHistory(regEliminar);
                                }
                        }
                }
            }catch(Exception e){
                LOG.error("Error en cambiarEstadoListadoObligaciones : "+e.getMessage());
                e.printStackTrace();
            }

            return listadoObligacionUpd;
		
	}

	@Override
	public Long countObligacionBaseLegal(Long idObligacion) {
		LOG.info("contador DAO IMPL Base Legal Por Obligaciones (Ingresando)....");
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT count(p) FROM PghObligacionBaseLegal p WHERE p.estado='1' and p.idObligacion.idObligacion='"+idObligacion+"'");
        LOG.info("Query: "+jpql.toString());
        Query query = crud.getEm().createQuery(jpql.toString());
        LOG.info("contador DAO IMPL Base Legal Por Obligaciones (Saliendo)....");
		return (Long) query.getSingleResult();
	}

	@Override
	public List<ObligacionBaseLegalDTO> findBaseLegalByObligacion(
			Long idObligacion) {
		List<ObligacionBaseLegalDTO>  retorno=null;
        LOG.info("Listar Base Legal By Obligaciones (Ingresando)... "+ idObligacion);
    try {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p.idBaseLegal.idBaseLegal,p.idBaseLegal.codigoBaseLegal,p.idBaseLegal.descripcion,p.idOblBase FROM PghObligacionBaseLegal p WHERE p.estado='1' and p.idObligacion.idObligacion='"+idObligacion+"'");
        Query query = crud.getEm().createQuery(jpql.toString());
        LOG.info("query : " + jpql.toString());
        List<Object[]>  resultados = query.getResultList();   
        System.out.println(" Resultado Listado de Obligaciones By Base Legal "+resultados);
	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=ObligacionBaseLegalBuilder.toListBaseLegalObligacionDto(resultados);
	        }
    	}catch(RuntimeException e) {
            LOG.error(e.getMessage(),e);   
            e.printStackTrace();
        }
        catch(Exception e) {
            LOG.error(e.getMessage(),e);
            e.printStackTrace();
        }
    return retorno;
	}

	@Override
	public List<BaseLegalDTO> listarNormaLegalPadre() {
		List<BaseLegalDTO> retorno=null;
		LOG.info("Listar Normas Legales Padre (Ingresando)... ");
		try {
			String flagPadre = "P";
			StringBuilder jpql = new StringBuilder();
			jpql.append("select p from PghBaseLegal p where p.flagPadre='" +flagPadre +"' and p.estado='1' ");
			Query query=crud.getEm().createQuery(jpql.toString());
			LOG.info("query : " + jpql.toString());
			List<PghBaseLegal> resultados = query.getResultList();
			if(!CollectionUtils.isEmpty(resultados)){
				retorno = BaseLegalBuilder.toListBaseLegalDto(resultados);
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
            e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public List<BaseLegalDTO> listarBaseLegalHijo(Long row_id) {
		List<BaseLegalDTO> retorno=null;
		LOG.info("Listar Bases Legales Padre (Ingresando)... ");
		try {

			StringBuilder jpql = new StringBuilder();
			jpql.append("select id_base_legal,codigo_base_legal,descripcion,estado,flag_padre from(");
			jpql.append("select p.id_base_legal,p.codigo_base_legal,trim(p.descripcion) as descripcion,p.estado,p.flag_padre  from pgh_base_legal p ");
			jpql.append("left join pgh_detalle_base_legal d on p.id_base_legal = d.id_base_legal and d.estado='1' ");
			jpql.append("where p.estado='1' ");
			jpql.append("and d.flg_disposicion is null ");
			jpql.append("and p.id_base_legal_padre ='"+row_id+"' ");			
			// OSINE_SFS-480 - REQF-0007 - Inicio
			//jpql.append("order by to_number(d.articulo),d.inciso_1,d.inciso_2,d.id_tipo_anexo,to_number(d.articulo_anexo),d.inciso_1_anexo,d.inciso_2_anexo ,p.descripcion ");
			jpql.append("order by to_number(d.articulo),nps_ordenar_numeral_fun(d.inciso_1) nulls first,nps_ordenar_numeral_fun(d.inciso_2) nulls first,d.id_tipo_anexo,to_number(d.articulo_anexo),nps_ordenar_numeral_fun(d.inciso_1_anexo) nulls first,nps_ordenar_numeral_fun(d.inciso_2_anexo) nulls first,p.descripcion ");
			jpql.append(")");
			//agregando la consulta para disposiciones
			jpql.append("union all ");
			jpql.append("select id_base_legal,codigo_base_legal,descripcion,estado,flag_padre from(");
			jpql.append("select d.flg_disposicion,p.id_base_legal,p.codigo_base_legal,trim(p.descripcion) as descripcion,p.estado,p.flag_padre  from pgh_base_legal p ");
			jpql.append("left join pgh_detalle_base_legal d on p.id_base_legal = d.id_base_legal and d.estado='1' ");
			jpql.append("where p.estado='1' ");
			jpql.append("and p.id_base_legal_padre ='"+row_id+"' ");	
			jpql.append("and d.flg_disposicion is not null ");
			jpql.append("order by  d.id_nro_disposicion asc ");
			jpql.append(")");
			// OSINE_SFS-480 - REQF-0007 - Fin
			Query query=crud.getEm().createNativeQuery(jpql.toString());
			LOG.info("query : " + jpql.toString());
			List<Object[]> resultados = query.getResultList();
			if(!CollectionUtils.isEmpty(resultados)){
				retorno = BaseLegalBuilder.toListBaseLegalHijoDto(resultados);
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
            e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public List<BaseLegalDTO> listarBaseLegalByObligacion(Long row_id) {
		List<BaseLegalDTO> retorno=null;
		LOG.info("Listar Bases Legales Padre (Ingresando)... ");
		try {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select distinct p.idBaseLegal.idBaseLegal,p.idBaseLegal.codigoBaseLegal,p.idBaseLegal.descripcion,p.idBaseLegal.estado,p.idBaseLegal.flagPadre from PghObligacionBaseLegal p ");
			jpql.append("where p.estado='1' ");
			jpql.append("and p.idObligacion.idObligacion ='"+row_id+"' ");
			jpql.append("order by p.idBaseLegal.descripcion ");					
			Query query=crud.getEm().createQuery(jpql.toString());
			LOG.info("query : " + jpql.toString());
			List<Object[]> resultados = query.getResultList();
			if(!CollectionUtils.isEmpty(resultados)){
				retorno = BaseLegalBuilder.toListBaseLegalByObligacionDto(resultados);
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
            e.printStackTrace();
		}
		return retorno;
	}
	 /**
     * <-- AsociarBaseToBase -->
     * @author l_garcia_reyna
     * @param count
     * @param find
     * @return      
     */
    // 06-11-2015	
	@Override
	public Long countToBase(BaseLegalFilter filtro) {
		LOG.info("contador DAO IMPL");
        Query query = null;
		try {
			query = getFindQueryToBase(filtro, true);
            LOG.info("salida contador DAO IMPL");
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
            e.printStackTrace();
		}
        return (Long) query.getSingleResult();
    }

	private Query getFindQueryToBase(BaseLegalFilter filtro, boolean count) {
        Query query=null;
        try{
            if (count) {
                if (filtro.getIdBaseLegal()!= null) {
                    query = crud.getEm().createNamedQuery("PghBaseLegal.countByIdBaseLegal");
                }else if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")) {
                    query=buildQueryFindBaseToBaseAdvanceByFilter(filtro,true);
                }else{
                    query = crud.getEm().createNamedQuery("PghBaseLegal.countByFilter");
                }
            }else {
                if (filtro.getIdBaseLegal()!= null) {
                    query = crud.getEm().createNamedQuery("PghBaseLegal.findByIdBaseLegal");
                }else if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")) {
                    query=buildQueryFindBaseToBaseAdvanceByFilter(filtro,false);
                }else{
                    query = crud.getEm().createNamedQuery("PghBaseLegal.findByFilter");
                }
            }
            //parametros
            if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")){
                LOG.info("sin parametros es busqueda avanzada..");
            }else{
                if (filtro.getIdBaseLegal()!= null) {
                    query.setParameter("idBaseLegal",filtro.getIdBaseLegal());
                }
                if (!StringUtil.isEmpty(filtro.getDescripcion())) {
                    query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
                }else{
                    query.setParameter("descripcion","%");
                }
                if (!StringUtil.isEmpty(filtro.getCodigoBaseLegal())) {
                    query.setParameter("codigoBaseLegal","%"+StringUtil.removeBlank(filtro.getCodigoBaseLegal().toUpperCase())+"%");
                }else{
                    query.setParameter("codigoBaseLegal","%");
                }
            }
            
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }        
        return query;
    }
    // 06-11-2015
	private Query buildQueryFindBaseToBaseAdvanceByFilter(BaseLegalFilter filtro, boolean count) {

        LOG.info("DAO - buildQueryFindBaseToBaseAdvanceByFilter");
        String queryString;
        StringBuilder jpql = new StringBuilder();
        boolean flgTablaDBL=false;
        boolean flgTablaOBL=false;
        //arma CAMPOS QUERY 
        if (count) {
            jpql.append("Select count(distinct bl.idBaseLegal) ");
        }else{
            jpql.append("Select distinct new PghBaseLegal(bl.idBaseLegal, bl.codigoBaseLegal, bl.descripcion,da.idDocumentoAdjunto,da.nombreArchivo,da.rutaAlfresco) ");
        }
        //arma FROM´s y JOIN´s
        jpql.append("from PghBaseLegal bl "
                    + "left join bl.idDocumentoAdjunto da "
                    + "left join bl.pghDetalleBaseLegalList dbl "
                    + "left join bl.pghObligacionBaseLegalList obl "
                    + "left join obl.idObligacion o "
                    + "left join o.pghDetalleObligacionList do "
                    + "left join o.pghConfObligacionList co "
                    + "left join o.pghTemaObligacionMaestroList tom "
                );
        //arma WHERE´s
        jpql.append(" WHERE bl.estado='1' and bl.flagPadre is null ");    
            //WHERE´s dinamicos
        if(filtro.getTipoNormaLegal() != null){
            jpql.append("and bl.idTipoNormaLegal=:idTipoNormaLegal ");
        }
        if(filtro.getNumeroNormaLegal() != null){
            jpql.append("and bl.numero like '%"+filtro.getNumeroNormaLegal()+"%' ");
        }
        if (filtro.getCodigoBaseLegal()!= null && !StringUtil.removeBlank(filtro.getCodigoBaseLegal()).equals("")) {
            jpql.append("and upper(bl.codigoBaseLegal) like :codigoBaseLegal ");
        } 
        if (filtro.getFechaEntradaVigenciaNormaLegal()!= null) {
            jpql.append("and bl.fechaEntradaVigencia=:fechaEntradaVigencia ");
        }
        if (filtro.getAnioNormaLegal()!= null && !StringUtil.removeBlank(filtro.getAnioNormaLegal()).equals("")) {
            jpql.append("and bl.anio like :anio ");
        } 
        if (filtro.getSiglaNormaLegal()!= null) {
            jpql.append("and bl.idSigla=:idSigla ");
        }
        if(filtro.getTitulo()!= null && !StringUtil.removeBlank(filtro.getTitulo()).equals("")) {
        	jpql.append("and bl.titulo like '%"+filtro.getTitulo()+"%' ");
        }
        //DBL
        if (filtro.getArticuloNormaLegal()!= null && !StringUtil.removeBlank(filtro.getArticuloNormaLegal()).equals("")) {
            flgTablaDBL=true;
            jpql.append("and upper(dbl.articulo) like :articulo ");
        }
        if (filtro.getTipoAnexo()!= null) {
            flgTablaDBL=true;
            jpql.append("and dbl.idTipoAnexo=:idTipoAnexo ");
        }
        if (filtro.getArticuloAnexo()!= null && !StringUtil.removeBlank(filtro.getArticuloAnexo()).equals("")) {
            flgTablaDBL=true;
            jpql.append("and upper(dbl.articuloAnexo) like :articuloAnexo ");
        }
        if(flgTablaDBL){
            jpql.append("and dbl.estado='1' ");
        }
        //OBL-O
        if(filtro.getCodigoObligacion()!=null && !StringUtil.removeBlank(filtro.getCodigoObligacion()).equals("")){
            flgTablaOBL=true;
            jpql.append("and upper(o.codigoObligacion) like :codigoObligacion ");
        }
        if(filtro.getIdCriticidadObligacion()!=null){
            flgTablaOBL=true;
            jpql.append("and o.idCriticidad=:idCriticidadObligacion ");
        }
        if(flgTablaOBL){
            jpql.append("and obl.estado='1' and o.estado='1' ");
        }
        //DO
        if(filtro.getDescObligacionDetalle()!=null && !StringUtil.removeBlank(filtro.getDescObligacionDetalle()).equals("")){
            jpql.append("and upper(do.descripcion) like :descObligacionDetalle and do.estado='1' ");
        }
        //CO
        if(filtro.getIdActividadesBusq()!=null && !StringUtil.removeBlank(filtro.getIdActividadesBusq()).equals("")){
            jpql.append("and co.pghProcesoObligacionTipo.mdiActividad.idActividad in ("+filtro.getIdActividadesBusq()+") and co.estado='1' ");
        } 
        //TOM
        if(filtro.getIdTemasBusq()!=null && !StringUtil.removeBlank(filtro.getIdTemasBusq()).equals("")){
            jpql.append("and tom.idTemaObligacion in ("+filtro.getIdTemasBusq()+") and tom.estado='1' ");
        }
        
        if(filtro.getIdsBaseLegal()!=null && !StringUtil.removeBlank(filtro.getIdsBaseLegal()).equals("")){
            jpql.append("and bl.idBaseLegal not in ("+filtro.getIdsBaseLegal()+")");
        }
        jpql.append(" order by bl.codigoBaseLegal desc ");
        //arma GROUP BY
//        if (!count) {
//            jpql.append("GROUP BY pro.idProcedimiento, pro.item,pro.denominacion, pr.idProceso,et.idEtapa,et.descripcion ");
//        }
        
        //////////////////////////////////////
        //Crear QUERY
        queryString = jpql.toString();
        Query query = this.crud.getEm().createQuery(queryString);
        //////////////////////////////////////
        //Ingreso de PARAMETROS
            //parametros de WHERE's
        if(filtro.getTipoNormaLegal() != null){
            query.setParameter("idTipoNormaLegal",filtro.getTipoNormaLegal());
        }
        if (filtro.getCodigoBaseLegal()!= null && !StringUtil.removeBlank(filtro.getCodigoBaseLegal()).equals("")) {
            query.setParameter("codigoBaseLegal","%"+StringUtil.removeBlank(filtro.getCodigoBaseLegal().toUpperCase())+"%");
        }
        if (filtro.getFechaEntradaVigenciaNormaLegal()!= null) {
            query.setParameter("fechaEntradaVigencia",filtro.getFechaEntradaVigenciaNormaLegal());
        }
        if (filtro.getAnioNormaLegal()!= null && !StringUtil.removeBlank(filtro.getAnioNormaLegal()).equals("")) {
            query.setParameter("anio","%"+StringUtil.removeBlank(filtro.getAnioNormaLegal())+"%");
        }
        if (filtro.getSiglaNormaLegal()!= null) {
            query.setParameter("idSigla",filtro.getSiglaNormaLegal());
        } 
        //DBL
        if (filtro.getArticuloNormaLegal()!= null && !StringUtil.removeBlank(filtro.getArticuloNormaLegal()).equals("")) {
            query.setParameter("articulo","%"+StringUtil.removeBlank(filtro.getArticuloNormaLegal().toUpperCase())+"%");
        }
        if (filtro.getTipoAnexo()!= null) {
            query.setParameter("idTipoAnexo",filtro.getTipoAnexo());
        }
        if (filtro.getArticuloAnexo()!= null && !StringUtil.removeBlank(filtro.getArticuloAnexo()).equals("")) {
            query.setParameter("articuloAnexo","%"+StringUtil.removeBlank(filtro.getArticuloAnexo().toUpperCase())+"%");
        }
        //OBL-O
        if(filtro.getCodigoObligacion()!=null && !StringUtil.removeBlank(filtro.getCodigoObligacion()).equals("")){
            query.setParameter("codigoObligacion","%"+StringUtil.removeBlank(filtro.getCodigoObligacion().toUpperCase())+"%");
        }
        if (filtro.getIdCriticidadObligacion()!= null) {
            query.setParameter("idCriticidadObligacion",filtro.getIdCriticidadObligacion());
        } 
        //DO
        if(filtro.getDescObligacionDetalle()!=null && !StringUtil.removeBlank(filtro.getDescObligacionDetalle()).equals("")){
            query.setParameter("descObligacionDetalle","%"+StringUtil.removeBlank(filtro.getDescObligacionDetalle().toUpperCase())+"%");
        }
        //////////////////////////////////////
        return query;
	}
	//
    // 06-11-2015
	@Override
	public List<BaseLegalDTO> findToBase(BaseLegalFilter filtro) {
        List<BaseLegalDTO> listado=null;

        Query query = getFindQueryToBase(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        listado = BaseLegalBuilder.toListBaseLegalToBaseLegalDto(query.getResultList());
        LOG.info("listado: "+listado.size());
        return listado;	
	}

	@Override
	public String obtenerCodigoBaseLegal(String flagPadre) {
        String codigoBaseLegal = armaCodigoBaseLegal(flagPadre);
        return codigoBaseLegal;
        
	}
	@Override
	public List<BaseLegalDTO> findNormaLegalByDivision(BaseLegalFilter filtro) {
		// TODO Auto-generated method stub
		return null;
	}
}