package gob.osinergmin.myc.service.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghOpcion;
import gob.osinergmin.myc.domain.PghConfObligacion;
import gob.osinergmin.myc.domain.PghDetalleObligacion;
import gob.osinergmin.myc.domain.PghInfraccion;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghProcesoObligacionTipo;
import gob.osinergmin.myc.domain.PghTemaObligacionMaestro;
import gob.osinergmin.myc.domain.builder.BaseLegalConcordanciaBuilder;
import gob.osinergmin.myc.domain.builder.CnfObligacionBuilder;
import gob.osinergmin.myc.domain.builder.DetalleObligacionBuilder;
import gob.osinergmin.myc.domain.builder.InfraccionBuilder;
import gob.osinergmin.myc.domain.builder.MaestroColumnaBuilder;
import gob.osinergmin.myc.domain.builder.ObligacionNormativaBuilder;
import gob.osinergmin.myc.domain.builder.OpcionBuilder;
import gob.osinergmin.myc.domain.builder.ProcesoObligacionTipoBuilder;
import gob.osinergmin.myc.domain.builder.TemaObligacionBuilder;
import gob.osinergmin.myc.domain.dto.BaseLegalConcordanciaDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TemaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.BaseLegalFilter;
import gob.osinergmin.myc.domain.ui.ObligacionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ObligacionNormativaDAO;
import gob.osinergmin.myc.service.exception.ObligacionException;
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
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class ObligacionNormativaDAOImpl implements ObligacionNormativaDAO{
	private static final Logger LOG = LoggerFactory.getLogger(BaseLegalDAOImpl.class);
	
	@Inject
    private CrudDAO crud;
	
	public ObligacionNormativaDTO changeEstado(ObligacionNormativaDTO obligacionNormativaDTO){
		ObligacionNormativaDTO retorno=null;
		try{
            PghObligacion registroDAO = crud.find(obligacionNormativaDTO.getIdObligacion(), PghObligacion.class);
            registroDAO.setEstado(obligacionNormativaDTO.getEstado());
            crud.update(registroDAO);
            retorno=ObligacionNormativaBuilder.toObligacionDto(registroDAO);
        }catch(Exception e){
            
        }
		return retorno;
	}
	
	@Override
	public ObligacionNormativaDTO create(ObligacionNormativaDTO obligacionNormativaDTO,UsuarioDTO usuarioDTO) {
		LOG.info("Registro Obligacion Normativa DAO Impl");
		ObligacionNormativaDTO retorno=null;
		try{
			//Inserta código
//			ObligacionNormativaDTO lastObligacion=findUltimoRegistro();
//			String ultimoCodigo=lastObligacion.getCodigoObligacion();
//			String codObligacion=MycUtil.generaObligacion(ultimoCodigo);
			//
			String codigoObligacion = armaCodigoObligacion();
			obligacionNormativaDTO.setCodigoObligacion(codigoObligacion);
			PghObligacion obligacion=ObligacionNormativaBuilder.getObligacion(obligacionNormativaDTO);
                        obligacion.setDatosAuditoria(usuarioDTO);
                        if(obligacion.getCodTrazabilidad()!=null && !obligacion.getCodTrazabilidad().equals("")){
                            crud.createWithHistory(obligacion);
                        }else{
                            crud.create(obligacion);
                        }
			
			retorno=ObligacionNormativaBuilder.toObligacionDto(obligacion);
			LOG.info("(Registro Obligacion DAO Impl) retorno: "+retorno.toString());
			
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return retorno;
	}
        
	@Override
	public List<ObligacionNormativaDTO> find(ObligacionFilter filtro){
		List<ObligacionNormativaDTO> listado=null;

        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        LOG.info("Query: "+query.toString());
        listado = ObligacionNormativaBuilder.toListObligacionDto(query.getResultList());
		LOG.info("listado: "+listado.size());
        return listado;
	}
	@Override
	public Long count(ObligacionFilter filtro){
		LOG.info("contador DAO IMPL");
		Query query = getFindQuery(filtro, true);
		LOG.info("salida contador DAO IMPL");
		return (Long) query.getSingleResult();
	}
	
	private Query getFindQuery(ObligacionFilter filtro, boolean count) {
        Query query=null;
        try{
            if (count) {
                if (filtro.getIdObligacion()!= null) {
                    query = crud.getEm().createNamedQuery("PghObligacion.countByIdBaseLegal");
                }else if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")){
                    query=buildQueryFindAdvanceByFilter(filtro,true);
                }else {
                    query = crud.getEm().createNamedQuery("PghObligacion.countByFilter");
                }
            }else {
                if (filtro.getIdObligacion()!= null) {
                    query = crud.getEm().createNamedQuery("PghObligacion.findByIdObligacion");
                }else if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")){
                    query=buildQueryFindAdvanceByFilter(filtro,false);
                }else {
                    query = crud.getEm().createNamedQuery("PghObligacion.findByFilter");
                }
            }
            ///////
            if(filtro.getFlgBusqAvanzada()!=null && filtro.getFlgBusqAvanzada().equals("1")){
                LOG.info("no es busq avanzada de obligaciones");
            }else{
                if (filtro.getIdObligacion()!= null) {
                    query.setParameter("idObligacion",filtro.getIdObligacion());
                }
                if (filtro.getDescripcion()!= null){
                    query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
                }
            }
            

        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
        
    public Query buildQueryFindAdvanceByFilter(ObligacionFilter filtro, boolean count){
        LOG.info("obligacionesDAO - buildQueryFindAdvanceByFilter");
        String queryString;
        StringBuilder jpql = new StringBuilder();
        
        //arma CAMPOS QUERY 
        if (count) {
            jpql.append("Select count(distinct o.idObligacion) ");
        }else{
            jpql.append("Select distinct new PghObligacion(o.idObligacion, o.codigoObligacion, o.descripcion) ");
        }
        
        //arma FROM´s y JOIN´s
        jpql.append("from PghObligacion o "
                    + "left join o.pghDetalleObligacionList do "
                    + "left join o.pghConfObligacionList co "
                    + "left join o.pghTemaObligacionMaestroList tom "
                );
        
        //arma WHERE´s
        jpql.append(" WHERE o.estado='1' ");
            
            //WHERE´s dinamicos
        //OBL-O
        if(filtro.getCodigoObligacion()!=null && !StringUtil.removeBlank(filtro.getCodigoObligacion()).equals("")){
            jpql.append("and upper(o.codigoObligacion) like :codigoObligacion ");
        }
        if(filtro.getIdCriticidadObligacion()!=null){
            jpql.append("and o.idCriticidad=:idCriticidadObligacion ");
        }
        //DO
        if(filtro.getDescDetalle()!=null && !StringUtil.removeBlank(filtro.getDescDetalle()).equals("")){
            jpql.append("and upper(do.descripcion) like :descDetalle and do.estado='1' ");
        }
        //CO
        if(filtro.getIdActividadesBusq()!=null && !StringUtil.removeBlank(filtro.getIdActividadesBusq()).equals("")){
            jpql.append("and co.pghProcesoObligacionTipo.mdiActividad.idActividad in ("+filtro.getIdActividadesBusq()+") and co.estado='1' ");
        }
        //TOM
        if(filtro.getIdTemasBusq()!=null && !StringUtil.removeBlank(filtro.getIdTemasBusq()).equals("")){
            jpql.append("and tom.idTemaObligacion in ("+filtro.getIdTemasBusq()+") and tom.estado='1' ");
        }
        
        if(filtro.getIdsObligacion()!=null && !StringUtil.removeBlank(filtro.getIdsObligacion()).equals("")){
            jpql.append("and o.idObligacion not in ("+filtro.getIdsObligacion()+") ");
        }
        
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
        //OBL-O
        if(filtro.getCodigoObligacion()!=null && !StringUtil.removeBlank(filtro.getCodigoObligacion()).equals("")){
            query.setParameter("codigoObligacion","%"+StringUtil.removeBlank(filtro.getCodigoObligacion().toUpperCase())+"%");
        }
        if (filtro.getIdCriticidadObligacion()!= null) {
            query.setParameter("idCriticidadObligacion",filtro.getIdCriticidadObligacion());
        } 
        //DO
        if(filtro.getDescDetalle()!=null && !StringUtil.removeBlank(filtro.getDescDetalle()).equals("")){
            query.setParameter("descDetalle","%"+StringUtil.removeBlank(filtro.getDescDetalle().toUpperCase())+"%");
        }
        
        //////////////////////////////////////
        return query;
    }

//    @Override
//    public ObligacionNormativaDTO findUltimoRegistro() {
//        ObligacionNormativaDTO retorno = null;
//        LOG.info("obtener el metodo findUltimoRegistro ");
//        try {
//            StringBuilder jpql = new StringBuilder();
//            jpql.append("SELECT p FROM PghObligacion p order by p.codigoObligacion desc limit 1");
//            Query query = crud.getEm().createQuery(jpql.toString());
//            LOG.info("query findUtimoRegistro: " + jpql.toString());
//            List<PghObligacion> resultados = query.getResultList();
//            System.out.println(" AAAAAAAAAAAA " + resultados);
//            if (resultados.size() > 0) {
//                retorno = ObligacionNormativaBuilder.toObligacionDto(resultados.get(0));
//            }
//        } catch (RuntimeException e) {
//            LOG.error(e.getMessage(), e);
//            e.printStackTrace();
//        } catch (Exception e) {
//            LOG.error(e.getMessage(), e);
//            e.printStackTrace();
//        }
//
//        return retorno;
//    }
    
    public String armaCodigoObligacion() {
//		BaseLegalDTO retorno=null;
                String codigoObligacion = "";
		LOG.info("obtener el metodo find UltimoRegistroObligacion ");
		try {
	        StringBuilder jpql = new StringBuilder();
//	        jpql.append("select lpad(PGH_CODIGO_OBLIGACION_SEQ.NEXTVAL,7,'0') from dual");
	        jpql.append("select GENERAR_CODIGO_OBLIGACION from dual");
	        Query query = crud.getEm().createNativeQuery(jpql.toString());
	        LOG.info("query armaCodigoObligacion: " + jpql.toString());
//	        List<PghBaseLegal> resultados = query.getResultList();   
                Object codigo = query.getSingleResult();   
	        LOG.info(" codigo = "+codigo);
//	        if(resultados.size()>0){
//	        	retorno=BaseLegalBuilder.toBaseLegalDto(resultados.get(0));
//	        }
	        codigoObligacion = codigo.toString();
            }catch(Exception e) {
                LOG.error(e.getMessage(),e);
                e.printStackTrace();
            }
            return codigoObligacion;
	}

    @Override
    public List<MaestroColumnaDTO> findTemas() {
        List<MaestroColumnaDTO> listaMaestroColumnaDTO = null;
        try {

            List<MdiMaestroColumna> listaMaestroColumna = null;
            Map<String, Object> parameters = new HashMap<String, Object>();
            String dominio = "PGH_OBLIG_CLASIF";
            String aplicacion = "OBLIGACIONES";
            parameters.put("dominio", dominio);
            parameters.put("aplicacion", aplicacion);
            LOG.info("parametros: " + parameters);
            listaMaestroColumna = crud.findByNamedQuery("MdiMaestroColumna.findByDominioAplicacion", parameters);
            LOG.info("TIPO TEMA BD" + listaMaestroColumna);
            listaMaestroColumnaDTO = MaestroColumnaBuilder.getMaestroColumnaDTOList(listaMaestroColumna);
            LOG.info("TIPO TEMA DTO: " + listaMaestroColumnaDTO + "TIPO TEMA BD" + listaMaestroColumna);

        } catch (Exception e) {
            LOG.error("error", e);
        }
        return listaMaestroColumnaDTO;
    }

    @Override
    public ObligacionNormativaDTO registrarRelaciones(Long idObligacion, Long idCriticidad, String listTema, UsuarioDTO usuarioDTO) {
        ObligacionNormativaDTO retorno = null;
        try {
        	//char estado = '1';
            PghObligacion oblgAct = crud.find(idObligacion, PghObligacion.class);
            oblgAct.setIdCriticidad(idCriticidad);
            oblgAct.setDatosAuditoria(usuarioDTO);
            crud.update(oblgAct);

            /**
             * PghTe *
             */
            TemaDTO temaDTO = new TemaDTO();

            temaDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            temaDTO.setIdObligacion(oblgAct.getIdObligacion());
            temaDTO.setIdTemaObligacion(new Long(listTema));
            
            
            
            Long id = crud.findSequence("PGH_TEMA_OBL_MAE_SEQ");
            temaDTO.setIdTemOblMa(id);

            LOG.info("idTema: " + temaDTO.getIdTemOblMa());
            PghTemaObligacionMaestro oblgTema = TemaObligacionBuilder.getTemaObligacion(temaDTO);
            oblgTema.setDatosAuditoria(usuarioDTO);
            crud.create(oblgTema);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

	@Override
	public CnfObligacionDTO registrarConfiguracion(Long idObligacion,
			Long idRubro, Long idProceso, String oblgTipo,String codTrazabilidad, UsuarioDTO usuarioDTO) throws ObligacionException {
		LOG.info("(Registrar configuración DAOImpl) Ingresando... ");
		CnfObligacionDTO retorno =null;
		try {
			CnfObligacionDTO cnfOblgDTO=new CnfObligacionDTO();
			String estado = "1";
			// setear datos al DTO de configuracion
			cnfOblgDTO.setEstado(estado);
			cnfOblgDTO.setIdObligacion(idObligacion);
			cnfOblgDTO.setIdActividad(idRubro);
			cnfOblgDTO.setIdProceso(idProceso);
			cnfOblgDTO.setIdObligacionTipo(new Long(oblgTipo));
                        cnfOblgDTO.setCodTrazabilidad(codTrazabilidad);
			
			// Id de la configuracion
			ProcesoObligacionTipoDTO confProcOblg=findConfObligacion(idRubro,idProceso,oblgTipo);//find id Proceso/ObligacionTipo/Actividad
			LOG.info("Codigo IdProOblgTipo: "+confProcOblg.getIdProOblTip());
			cnfOblgDTO.setIdProOblTip(confProcOblg.getIdProOblTip());
			
			// lista de configuraciones por obligacion
			List<CnfObligacionDTO> CnfObligacionAct=findCnfByObligacion(idObligacion);
			LOG.info("Listado de Configuraciones de la Obligacion:  "+CnfObligacionAct);

			boolean existe=existConfigEnLista(cnfOblgDTO.getIdProOblTip(), CnfObligacionAct);
			if(!existe){
				PghConfObligacion pghCnfObligacion=CnfObligacionBuilder.getConfObligacion(cnfOblgDTO);
				pghCnfObligacion.setDatosAuditoria(usuarioDTO);
                                if(pghCnfObligacion.getCodAccion()!=null && !pghCnfObligacion.getCodTrazabilidad().equals("")){
                                    crud.createWithHistory(pghCnfObligacion);
                                }else{
                                    crud.create(pghCnfObligacion);
                                }				
			}else{
				throw new ObligacionException("Ya Existe Configuraci&oacute;n",null);
			}
			
			LOG.info("(Registrar configuración DAOImpl) Saliendo... ");
			
		} catch (ObligacionException e) {
                    LOG.error("error Registrar Configuracion ObligacionNormativaDAO : "+e.getMessage());
                    e.printStackTrace();
                    throw e;
		}catch(Exception ex){
                    LOG.error("error Registrar Configuracion ObligacionNormativaDAO = "+ex.getMessage());
                    ex.printStackTrace();
                    ObligacionException e2 = new ObligacionException("Error Registrar Configuracion Obligacion", ex, true);
                    throw e2;
                }
		return retorno;
	}
	/*PR OSINE_119 - Item 16 - Inicio*/	
	@Override
	public List<OpcionDTO> obtenerOpciones(String idRubro) {
		LOG.info("(Registrar configuración DAOImpl) Ingresando... ");
		List<OpcionDTO> retorno =null;
		try {
			RubroOpcionDTO rubroOpcionDTO=new RubroOpcionDTO();
			String estado = "1";
			rubroOpcionDTO.setEstado(estado);							
			 retorno=findOpciones(idRubro);						
			LOG.info("(Registrar configuración DAOImpl) Saliendo... ");
			
		} catch (Exception e) {
                    LOG.error("error Registrar Configuracion ObligacionNormativaDAO : "+e.getMessage());
                    e.printStackTrace();                    
		}
		return retorno;
	}
	/*PR OSINE_119 - Item 16 - Fin*/
	
	/*PR OSINE_119 - Item 14 - Inicio*/
	private List<OpcionDTO> findOpciones(String idRubro){
		LOG.info("(Encontrar Configuración DAOImpl) Ingresando... ");
		Query query=null;
		List<OpcionDTO> retorno=null;
		try {
			StringBuilder jpql = new StringBuilder();
	       	jpql.append("Select new  PghOpcion(o.identificador_opcion) ");
            jpql.append( "from PghRubroOpcion ro " );
            jpql.append(" inner join ro.idActividad a  " );
            jpql.append(" inner join ro.idOpcion o  " );
            jpql.append(" where ro.idActividad.idActividad in ("+idRubro+")");
            jpql.append(" and ro.estado='1'" );
            jpql.append(" and o.aplicacion='MYC'" );
            
            jpql.append(" group by o.identificador_opcion");
            query = crud.getEm().createQuery(jpql.toString());                                  	             	        	       
	        LOG.info("query IdConfiguracion: " + jpql.toString());
            List<PghOpcion> resultados = query.getResultList();
            System.out.println(" Resultado Query FindConfiguracion: " + resultados.size());
            if (resultados.size() > 0) {
            	retorno = OpcionBuilder.toListOpcionDto(resultados);
            }
            LOG.info("(Encontrar Configuración DAOImpl) Saliendo... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	/*PR OSINE_119 - Item 14 - Fin*/
	private ProcesoObligacionTipoDTO findConfObligacion(Long idRubro,Long idProceso,String oblgTipo){
		LOG.info("(Encontrar Configuración DAOImpl) Ingresando... ");
		ProcesoObligacionTipoDTO confProcOblg=null;
		try {
			StringBuilder jpql = new StringBuilder();
	        jpql.append("SELECT p FROM PghProcesoObligacionTipo p where estado='1' and p.pghProcesoObligacionTipoPK.idActividad='"+idRubro+"'");
	        jpql.append("and p.pghProcesoObligacionTipoPK.idProceso='"+idProceso+"' and p.pghProcesoObligacionTipoPK.idObligacionTipo='"+oblgTipo+"'");
	        Query query = crud.getEm().createQuery(jpql.toString());
	        LOG.info("query IdConfiguracion: " + jpql.toString());
            List<PghProcesoObligacionTipo> resultados = query.getResultList();
            System.out.println(" Resultado Query FindConfiguracion: " + resultados.size());
            if (resultados.size() > 0) {
            	confProcOblg = ProcesoObligacionTipoBuilder.toProcesoObligacionTipoDto(resultados.get(0));
            }
            LOG.info("(Encontrar Configuración DAOImpl) Saliendo... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return confProcOblg;
	}

	@Override
	public Long contador(ObligacionFilter filtro) {
		LOG.info("(Contador DAO IMPL) Ingresando..." + filtro.getIdObligacion());
		StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT count(p.idConfObligacion) FROM PghConfObligacion p where estado='1' and p.idObligacion='"+filtro.getIdObligacion()+"'");
		Query 	query = crud.getEm().createQuery(jpql.toString());
		LOG.info("(Contador DAO IMPL) Saliendo... :Retorno:" +query);
		return (Long) query.getSingleResult();
	}

	@Override
	public List<CnfObligacionDTO> findObligacionById(ObligacionFilter filtro) {
		List<CnfObligacionDTO>  retorno=null;
		LOG.info("(Encontrar Obligacion By Id DAO IMPL) Ingresando...");
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p.idConfObligacion,p.pghProcesoObligacionTipo.mdiActividad.idActividad, p.pghProcesoObligacionTipo.mdiActividad.nombre,p.pghProcesoObligacionTipo.pghProceso.descripcion,p.pghProcesoObligacionTipo.pghObligacionTipo.nombre,p.pghProcesoObligacionTipo.pghProcesoObligacionTipoPK.idProOblTip FROM PghConfObligacion p where estado='1' and p.idObligacion='"+filtro.getIdObligacion()+"'");
    		Query 	query = crud.getEm().createQuery(jpql.toString());
	        LOG.info("query find Configuracion By IdObligacion: " + jpql.toString());
	        List<Object[]>  resultados = query.getResultList();  
	        System.out.println(" Listado de Configuracion "+resultados);
	        
	        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
	            query.setFirstResult(filtro.getStartIndex());
	            query.setMaxResults(filtro.getResultsNumber());
	        }
	        
	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=CnfObligacionBuilder.toListConfObligacionDesc(resultados);
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
	
	/**
	 * 
	 * @param idObligacion
	 * @return
	 */
	private List<CnfObligacionDTO> findCnfByObligacion(Long idObligacion) {
		List<CnfObligacionDTO>  retorno=null;
		LOG.info("(Encontrar Configuracion By Obligacion By Id DAO IMPL) Ingresando...");
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghConfObligacion p where estado='1' and p.idObligacion='"+idObligacion+"'");
    		Query 	query = crud.getEm().createQuery(jpql.toString());
	        LOG.info("query find Configuracion By IdObligacion: " + jpql.toString());
	        List<PghConfObligacion>  resultados = query.getResultList();  
	        System.out.println(" Listado de Configuracion "+resultados);
	        
	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=CnfObligacionBuilder.toListConfObligacion(resultados);
	        }
	        LOG.info("(Encontrar Configuracion By Obligacion By Id DAO IMPL) Saliendo... :Retorno: " + retorno);
        }catch(Exception e) {
        	LOG.error(e.getMessage(),e);
        	e.printStackTrace();
        }
        return retorno;
	}
	
	private static boolean existConfigEnLista(Long idObligacion, List<CnfObligacionDTO> listado){
        boolean retorno=false;//inicializo como que NO ESTA
        if(listado!=null){
            for(CnfObligacionDTO maestroAct : listado){
                if(idObligacion.equals(maestroAct.getIdProOblTip())){
                    retorno=true;
                }
            }
        }
        return retorno;
    }

	@Override
	public ObligacionNormativaDTO consultaObligacionById(Long idObligacion) {
		ObligacionNormativaDTO  retorno=null;
		LOG.info("(Consultar Obligacion By Id DAO IMPL) Ingresando...");
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghObligacion p where estado='1' and p.idObligacion='"+idObligacion+"'");
    		Query 	query = crud.getEm().createQuery(jpql.toString());
	        LOG.info("query Consulta By IdObligacion: " + jpql.toString());
	        List<PghObligacion>  resultados = query.getResultList();  
	        System.out.println(" Listado de Configuracion "+resultados);

	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=ObligacionNormativaBuilder.toObligacionDto(resultados.get(0));
	        }
	        LOG.info("(Consultar Obligacion By Id DAO IMPL) Saliendo... :Retorno: " + retorno);
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
	public DetalleObligacionDTO consultaDetalleObligacionById(
			Long idObligacion) {
		DetalleObligacionDTO  retorno=null;
		LOG.info("(Consultar Detalle Obligacion By Id DAO IMPL) Ingresando...");
        try {
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghDetalleObligacion p where estado='1' and p.idObligacion='"+idObligacion+"'");
    		Query 	query = crud.getEm().createQuery(jpql.toString());
	        LOG.info("query Consulta By IdObligacion: " + jpql.toString());
	        List<PghDetalleObligacion>  resultados = query.getResultList();  
	        System.out.println(" Listado  "+resultados);

	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=DetalleObligacionBuilder.toDetalleObligacionDto(resultados.get(0));
	        }
	        LOG.info("(Consultar Detalle Obligacion By Id DAO IMPL) Saliendo... :Retorno: " + retorno);
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
	public List<TemaDTO> findTemaObligacion(Long idObligacion) {
		LOG.info("(Consultar Temas de la Obligacion By Id DAO IMPL) Ingresando...");
		List<TemaDTO> retorno=null;
		try {
			StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghTemaObligacionMaestro p where estado='1' and p.idObligacion.idObligacion='"+idObligacion+"'");
    		Query 	query = crud.getEm().createQuery(jpql.toString());
	        LOG.info("query Consulta By IdObligacion: " + jpql.toString());
	        List<PghTemaObligacionMaestro>  resultados = query.getResultList();  
	        System.out.println(" Listado  "+resultados);

	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=TemaObligacionBuilder.toListTemaObligacionDto(resultados);
	        }
	        LOG.info("(Consultar Temas de la Obligacion By Id DAO IMPL) Saliendo... :Retorno: " + retorno);
			
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return retorno;
	}
	/*PR OSINE_119 - Item 14 - Inicio*/
	@Override
	public InfraccionDTO findInfraccionObligacion(Long idObligacion) {
		LOG.info("(Consultar Temas de la Obligacion By Id DAO IMPL) Ingresando...");
		InfraccionDTO retorno=null;
		try {
			StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghInfraccion p where estado='1' and p.idObligacion.idObligacion='"+idObligacion+"'");
    		Query 	query = crud.getEm().createQuery(jpql.toString());
	        LOG.info("query Consulta By IdObligacion: " + jpql.toString());
	        List<PghInfraccion>  resultados = query.getResultList();  
	        System.out.println(" Listado  "+resultados);

	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=InfraccionBuilder.toInfraccionDto(resultados.get(0));
	        }
	        LOG.info("(Consultar Temas de la Obligacion By Id DAO IMPL) Saliendo... :Retorno: " + retorno);
			
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return retorno;
	}
	/*PR OSINE_119 - Item 14 - Fin*/
	
    @Override
    public ObligacionNormativaDTO registrarRelaciones(ObligacionNormativaDTO registro, UsuarioDTO usuarioDTO) {
        ObligacionNormativaDTO retorno = null;
        try {
            PghObligacion oblgAct = crud.find(registro.getIdObligacion(), PghObligacion.class);
//            oblgAct.setIdCriticidad(registro.getCriticidadObligacion());
//            oblgAct.setDatosAuditoria(usuarioDTO);
//            crud.update(oblgAct);

            /**
             * PghTema
             **/
            //Encontrar Listado de Temas en la Base de Datos 
            List<TemaDTO> temaObligacionAct=findListadoTemas(registro.getIdObligacion());
            LOG.info("Listado de Temas por Obligacion de la Base de Datos: "+temaObligacionAct);
            //Asignar Listado de Temas por Actualizar
            List<TemaDTO> temaObligacionUpd=registro.getListaTemas();
            LOG.info("Listado de Temas que viene por Actualizar: "+ temaObligacionUpd);
            //Crea las Cadenas
            String cadenaAct=MycUtil.concatenaListadoTemas(temaObligacionAct);
            LOG.info("Cadena de Base de Datos: "+cadenaAct);
            String cadenaUpd=MycUtil.concatenaListadoTemas(temaObligacionUpd);
            LOG.info("Cadena por Actualizar "+cadenaUpd);
			
            if(registro.getListaTemas()!=null && !registro.getListaTemas().equals("")){
            	LOG.info("SE PROCEDE A INSERTAR TEMAS ASOCIADOS A LA OBLIGACION --> NUEVOS REGISTROS");
            	if(temaObligacionAct==null){
                    //se comparan las cadenas <--> insertar cuando no existen
                    for(TemaDTO registroTema:temaObligacionUpd){
                        LOG.info("Registro Nuevo Tema--> "+registroTema.getIdTemaObligacion());	
                        registroTema.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                        registroTema.setIdObligacion(oblgAct.getIdObligacion());
                        registroTema.setCodTrazabilidad(registro.getCodTrazabilidad());
                        PghTemaObligacionMaestro oblgTema = TemaObligacionBuilder.getTemaObligacion(registroTema);
                        oblgTema.setDatosAuditoria(usuarioDTO);
                        if(oblgTema.getCodTrazabilidad()!=null && !oblgTema.getCodTrazabilidad().equals("")){
                            crud.createWithHistory(oblgTema);
                        }else{
                            crud.create(oblgTema);
                        }
                    }
            	}else{
                    if(!cadenaAct.equals(cadenaUpd)){
                        LOG.info("SE PROCEDE A ACTUALIZAR LOS TEMAS ");
                        //se comparan las cadenas <--> insertar cuando no existen
                        for(TemaDTO registroTema:temaObligacionUpd){
                            boolean existe=MycUtil.existIdTemaEnLista(registroTema.getIdTemaObligacion(),temaObligacionAct);
                            if(!existe){
                                LOG.info("Nuevo Tema-->"+registroTema.getIdTemaObligacion());
                                registroTema.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                                registroTema.setIdObligacion(oblgAct.getIdObligacion());
                                registroTema.setCodTrazabilidad(registro.getCodTrazabilidad());
                                PghTemaObligacionMaestro oblgTema = TemaObligacionBuilder.getTemaObligacion(registroTema);
                                oblgTema.setDatosAuditoria(usuarioDTO);
                                if(oblgTema.getCodTrazabilidad()!=null && !oblgTema.getCodTrazabilidad().equals("")){
                                    crud.createWithHistory(oblgTema);
                                }else{
                                    crud.create(oblgTema);
                                }
                            }
                        }
                        //se comparan las cadenas <--> eliminan cuando no se encuentra en el nuevo listado
                        for(TemaDTO registroTema:temaObligacionAct){
                            boolean existe=MycUtil.existIdTemaEnLista(registroTema.getIdTemaObligacion(),temaObligacionUpd);
                            if(!existe){
                                LOG.info("Tema Eliminado Logico(Cambio Estado)-->"+registroTema.getIdTemaObligacion());
                                PghTemaObligacionMaestro regListado = crud.findTemaObligacion(registroTema.getIdObligacion(),registroTema.getIdTemaObligacion());
                                regListado.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                                regListado.setDatosAuditoria(usuarioDTO);
                                regListado.setCodTrazabilidad(registro.getCodTrazabilidad());
                                if(regListado.getCodTrazabilidad()!=null && ! regListado.getCodTrazabilidad().equals("")){
                                    crud.updateWithHistory(regListado);
                                }else{
                                    crud.update(regListado);
                                }
                            }
                        }
                    }
            	}
			
            }else{
            	if(temaObligacionAct!=null && !temaObligacionAct.equals("")){
                    for(TemaDTO registroTema:temaObligacionAct){
                        boolean existe=MycUtil.existIdTemaEnLista(registroTema.getIdTemaObligacion(),temaObligacionUpd);
                        if(!existe){
                            LOG.info("Tema Eliminado Logico(Cambio Estado)-->"+registroTema.getIdTemaObligacion());
                            PghTemaObligacionMaestro regListado = crud.findTemaObligacion(registroTema.getIdObligacion(),registroTema.getIdTemaObligacion());
                            regListado.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                            regListado.setDatosAuditoria(usuarioDTO);
                            regListado.setCodTrazabilidad(registro.getCodTrazabilidad());
                            if(regListado.getCodTrazabilidad()!=null && ! regListado.getCodTrazabilidad().equals("")){
                                crud.updateWithHistory(regListado);
                            }else{
                                crud.update(regListado);
                            }
                        }
                    }
            	}
            	
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

	private List<TemaDTO> findListadoTemas(Long idObligacion) {
		List<TemaDTO> retorno=null;
        try{
        	StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM PghTemaObligacionMaestro p WHERE p.estado='1' and p.idObligacion.idObligacion='"+idObligacion+"'");
            Query query = crud.getEm().createQuery(jpql.toString());
            LOG.info("query findTemaObligacionById: " + jpql.toString());
//            query.setParameter("codigoBaseLegal", codigoBaseLegal);
            List<PghTemaObligacionMaestro>  resultados = query.getResultList();   
            System.out.println(" AAAAAAAAAAAA "+resultados);
            if(!CollectionUtils.isEmpty(resultados)){
            	retorno=TemaObligacionBuilder.toListTemaObligacionDto(resultados);
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}

    @Override
    public ObligacionNormativaDTO eliminarRelaciones(ObligacionNormativaDTO registro, UsuarioDTO usuarioDTO) {
        ObligacionNormativaDTO retorno = null;
        try {
            PghObligacion oblgAct = crud.find(registro.getIdObligacion(), PghObligacion.class);

            //Encontrar Listado de Temas en la Base de Datos 
            List<TemaDTO> temaObligacionAct=findListadoTemas(registro.getIdObligacion());
            LOG.info("Listado de Temas por Obligacion de la Base de Datos: "+temaObligacionAct);
            //Asignar Listado de Temas por Actualizar
            List<TemaDTO> temaObligacionUpd=registro.getListaTemas();
            LOG.info("Listado de Temas que viene por Actualizar: "+ temaObligacionUpd);
            //Crea las Cadenas
            String cadenaAct=MycUtil.concatenaListadoTemas(temaObligacionAct);
            LOG.info("Cadena de Base de Datos: "+cadenaAct);
            String cadenaUpd=MycUtil.concatenaListadoTemas(temaObligacionUpd);
            LOG.info("Cadena por Actualizar "+cadenaUpd);
			
            if(registro.getListaTemas()==null){
            	if(temaObligacionAct!=null && !temaObligacionAct.equals("")){
                    for(TemaDTO registroTema:temaObligacionAct){
                        boolean existe=MycUtil.existIdTemaEnLista(registroTema.getIdTemaObligacion(),temaObligacionUpd);
                        if(!existe){
                            LOG.info("Tema Eliminado Logico(Cambio Estado)-->"+registroTema.getIdTemaObligacion());
                            PghTemaObligacionMaestro regListado = crud.findTemaObligacion(registroTema.getIdObligacion(),registroTema.getIdTemaObligacion());
                            //char estadoUpd='0';
                            regListado.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                            regListado.setDatosAuditoria(usuarioDTO);
                            regListado.setCodTrazabilidad(registro.getCodTrazabilidad());
                            if(regListado.getCodTrazabilidad()!=null && !regListado.getCodTrazabilidad().equals("")){
                                crud.updateWithHistory(regListado);
                            }else{
                                crud.update(regListado);
                            }
                        }
                    }
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
	}

    @Override
    public ObligacionNormativaDTO update(ObligacionNormativaDTO obligacionNormativaDTO, UsuarioDTO usuarioDTO) {
        ObligacionNormativaDTO retorno=null;
            try{
            PghObligacion registroDAO = crud.find(obligacionNormativaDTO.getIdObligacion(), PghObligacion.class);
            registroDAO.setDescripcion(obligacionNormativaDTO.getDescripcionObligacion());
            registroDAO.setIdCriticidad(obligacionNormativaDTO.getCriticidadObligacion());
            if(registroDAO.getIdDocumentoAdjunto() == null ){
                registroDAO.setIdDocumentoAdjunto(obligacionNormativaDTO.getIdDocumentoAdjunto());
            }else{
                if(obligacionNormativaDTO.getIdDocumentoAdjunto() != null){
                    registroDAO.setIdDocumentoAdjunto(obligacionNormativaDTO.getIdDocumentoAdjunto());
                }
            }
            
            registroDAO.setDatosAuditoria(usuarioDTO);
            if(obligacionNormativaDTO.getCodTrazabilidad()!=null && !obligacionNormativaDTO.getCodTrazabilidad().equals("")){
            	registroDAO.setCodTrazabilidad(obligacionNormativaDTO.getCodTrazabilidad());
                crud.updateWithHistory(registroDAO);
            }else{
            	crud.update(registroDAO);
            }
            
            retorno=ObligacionNormativaBuilder.toObligacionDto(registroDAO);
        }catch(Exception e){
            LOG.error("error update ObligacionNormativaDAO"+e.getMessage());
        }
        return retorno;
    }
	
	
}