/**
* Resumen           
* Objeto            : ActividadDAOImpl.java
* Descripcion       : Clase implementacion del acceso a datos del mantenimiento de actividades en el MYC.
* Fecha de Creacion : 
* PR de Creacion    : OSINE_SFS-600
* Autor             : GMD.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripcion
* REQF-0009			04/07/2016		Hernan Torres Saenz
* REQF-0008			05/07/2016		Mario Dioses Fernandez
* ---------------------------------------------------------------------------------------------------
*/

package gob.osinergmin.myc.service.dao.impl;
import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.builder.ActividadBuilder;
import gob.osinergmin.myc.domain.builder.ProcesoObligacionTipoBuilder;
import gob.osinergmin.myc.domain.builder.UnidadOrganicaBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.CnfActUniOrganicaFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.dao.ActividadDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.exception.ActividadException;
import gob.osinergmin.myc.util.Constantes;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
/**
 *
 * @author jpiro
 */
@Service("ActividadDAO")
public class ActividadDAOImpl implements ActividadDAO {
    private static final Logger LOG = LoggerFactory.getLogger(ActividadDAO.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<ActividadDTO> find(ActividadFilter filtro) throws ActividadException{
        List<ActividadDTO> listado;

        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = ActividadBuilder.toListActividadDto(query.getResultList());

        return listado;
    }
    
    @Override
    public Long count(ActividadFilter filtro) throws ActividadException{
        Query query = getFindQuery(filtro, true);
        return (Long) query.getSingleResult();
    }
    
    private Query getFindQuery(ActividadFilter filtro, boolean count) {
        Query query=null;
        try{
            if (count) {
                if (filtro.getIdProcedimiento()!= null && filtro.getIdTramite()!= null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.countByIdProcedimientoIdTramite");
                }else if (filtro.getIdProcedimiento()!= null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.countByIdProcedimiento");
                }else if (filtro.getIdTramiteActividad()!= null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.countByIdTramiteActividad");
                }else{
                    query = crud.getEm().createNamedQuery("MdiActividad.countAll");
                }
            }else {
                if (filtro.getIdProcedimiento()!= null && filtro.getIdTramite()!= null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.findByIdProcedimientoIdTramite");
                }else if (filtro.getIdProcedimiento()!= null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.findByIdProcedimiento");
                }else if (filtro.getIdTramiteActividad()!= null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.findByIdTramiteActividad");
				/* OSINE_SFS-600 - REQF-0009 - Inicio */
                }else if (filtro.isFlagListarActividadesPadre()) {
                    query = crud.getEm().createNamedQuery("MdiActividad.findActividadPadre");
                }
                else if (filtro.getIdActividadPadre()!=null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.findAgentesByIdActividadPadre");
                }
                /* OSINE_SFS-600 - REQF-0009 - Fin */
                /* OSINE_SFS-600 - REQF-0008 - Inicio */
                else if (filtro.getIdActividad()!= null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.findByIdActividad");
                }
                /* OSINE_SFS-600 - REQF-0008 - Fin */
                else if (filtro.getIdRubroOpcion()!= null) {
                    query = crud.getEm().createNamedQuery("MdiActividad.findByIdRubroOpcion");
                }else{
                    query = crud.getEm().createNamedQuery("MdiActividad.findAll");
                }
            }

            if (filtro.getIdProcedimiento()!= null) {
                query.setParameter("idProcedimiento",filtro.getIdProcedimiento());
            }
            if (filtro.getIdTramite()!= null) {
                query.setParameter("idTramite",filtro.getIdTramite());
            }
            if (filtro.getEstado()!= null){
                query.setParameter("estado",filtro.getEstado());
            }
            if (filtro.getIdTramiteActividad()!= null){
                query.setParameter("idTramiteActivdad",filtro.getIdTramiteActividad());
            }
			/* OSINE_SFS-600 - REQF-0009 - Inicio */
            if (filtro.getIdActividad()!= null){
                query.setParameter("idActividad",filtro.getIdActividad());
            }
            if (filtro.getIdActividadPadre()!= null){
                query.setParameter("idActividadPadre",filtro.getIdActividadPadre());
            }
            /* OSINE_SFS-600 - REQF-0009 - Fin */
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    
    @Override
	public List<ProcesoObligacionTipoDTO> listarConfigurada() {
		List<ProcesoObligacionTipoDTO> retorno=null;
		try{
			StringBuilder jpql = new StringBuilder();
			jpql.append("SELECT DISTINCT p.mdiActividad.idActividad,p.mdiActividad.nombre,p.mdiActividad.idActividadPadre From PghProcesoObligacionTipo p" );
			LOG.info("jpql.tostring "+jpql.toString());
        	Query query = crud.getEm().createQuery(jpql.toString());
        	LOG.info("resultado Query "+query.toString());
        	List<Object[]> resultado = query.getResultList();
        	retorno = ProcesoObligacionTipoBuilder.toListProcesoObligacionTipoByActividadFancyDto(resultado);
        	LOG.info("listado ActividadesConfiguradas "+retorno);
		}catch(Exception e){
			LOG.error("Error getValidarDependencia : " + e.getMessage());
		}
		return retorno;
	}

	@Override
	public ActividadDTO listarActividadxCodigo(ActividadFilter filtro) {
		ActividadDTO listado=null;
		Query query = crud.getEm().createNamedQuery("MdiActividad.findByCodigo");
		if(filtro.getCodigo()!=null){
			query.setParameter("codigo", filtro.getCodigo());
		}
		if(filtro.getEstado()!=null){
			query.setParameter("estado", filtro.getEstado());
		}	
		List<MdiActividad> actividad= (List<MdiActividad>) query.getResultList(); 
		if(!CollectionUtils.isEmpty(actividad)){
			listado = (ActividadDTO) ActividadBuilder.toListActividadDto(actividad).get(0);
		}        
        return listado;    
	}
    
    
    
	@Override
	public List<ProcesoObligacionTipoDTO> listarConfigurada(
			ActividadFilter filtro) {
		List<ProcesoObligacionTipoDTO> retorno=null;
		try{
			StringBuilder jpql = new StringBuilder();
			jpql.append(" SELECT DISTINCT p.mdiActividad.idActividad,p.mdiActividad.nombre,p.mdiActividad.idActividadPadre From PghProcesoObligacionTipo p " );
			jpql.append(" where p.estado='1' ");
			if(filtro.getIdsActividades()!=null){
				jpql.append(" and p.mdiActividad.idActividad in ("+filtro.getIdsActividades()+")");
			}			
			LOG.info("jpql.tostring "+jpql.toString());
        	Query query = crud.getEm().createQuery(jpql.toString());
        	LOG.info("resultado Query "+query.toString());
        	List<Object[]> resultado = query.getResultList();
        	retorno = ProcesoObligacionTipoBuilder.toListProcesoObligacionTipoByActividadFancyDto(resultado);
        	LOG.info("listado ActividadesConfiguradas "+retorno);
		}catch(Exception e){
			LOG.error("Error getValidarDependencia : " + e.getMessage());
		}
		return retorno;
	}
	
	
	
	 /* OSINE_SFS-600 - REQF-0009 - Inicio */
	@Override
	public List<ActividadDTO> listarAgentesIntalacion(ActividadFilter filtro) {
		List<ActividadDTO> retornoListado=null;
		LOG.info("listarAgentesIntalacion");
		try{
			StringBuilder jpql = new StringBuilder();
			jpql.append("select a1.id_actividad  as idActividadPadre, a1.orden_nps as ordenPadre, a1.nombre as nombrePadre, a1.codigo as codigoPadre, "
					+ "a.id_actividad, a.orden_nps, a.nombre, a.codigo "
					+ "from mdi_actividad a "
					+ "inner join mdi_actividad a1 on a1.id_actividad=a.id_actividad_padre "
					+ "where a.estado=1 and a1.estado=1 " );
			if(filtro.getIdActividadPadre()!=null && !filtro.getIdActividadPadre().equals("")){
				jpql.append("and a.id_actividad_padre=:idActividadPadre ");
			}
			
			if(filtro.getOrden()!=null && !filtro.getOrden().equals("")){
				jpql.append("and a.orden_nps=:orden ");
			}
			if(filtro.getNombre()!=null && !filtro.getNombre().equals("")){
				jpql.append("and upper(a.nombre) like :nombre ");
			}
			jpql.append("order by a1.orden_nps, a1.nombre, a.orden_nps, a.nombre ");
			Query query = crud.getEm().createNativeQuery(jpql.toString());
			
			if(filtro.getIdActividadPadre()!=null && !filtro.getIdActividadPadre().equals("")){
	        	query.setParameter("idActividadPadre",filtro.getIdActividadPadre());
	        }        
	        if(filtro.getNombre()!= null && !filtro.getNombre().equals("")){
	        	query.setParameter("nombre","%"+StringUtil.removeBlank(filtro.getNombre().toUpperCase())+"%");
	        }
	        if(filtro.getOrden()!=null && !filtro.getOrden().equals("")){
	        	query.setParameter("orden",filtro.getOrden());
	        }
	        List<Object[]> listadoAgenteInstalacion = query.getResultList();
	        retornoListado = ActividadBuilder.toListActividadAgenteInstalacion(listadoAgenteInstalacion);
	        
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retornoListado;
	}
	
	@Override
	public List<ActividadDTO> listarActividad(ActividadFilter filtro) {
		List<ActividadDTO> retornoListado=null;
		LOG.info("listarActividades");
		try{
			StringBuilder jpql = new StringBuilder();
			jpql.append("select a.id_actividad, a.orden_nps, a.nombre, a.codigo "
					+ "from mdi_actividad a "
					+ "where a.estado=1 "
					+ "and (a.id_actividad_padre IS NULL or a.id_actividad_padre='') ");
			
			if(filtro.getNombre()!=null && !filtro.getNombre().equals("")){
				jpql.append("and upper(a.nombre) like :nombre ");
			}
			
			if(filtro.getOrden()!=null && !filtro.getOrden().equals("")){
				jpql.append("and a.orden_nps=:orden ");
			}
			
			jpql.append("order by a.orden_nps ");
			
			Query query = crud.getEm().createNativeQuery(jpql.toString());
			
			if(filtro.getNombre()!= null && !filtro.getNombre().equals("")){
	        	query.setParameter("nombre","%"+StringUtil.removeBlank(filtro.getNombre().toUpperCase())+"%");
	        }
			
			if(filtro.getOrden()!=null && !filtro.getOrden().equals("")){
	        	query.setParameter("orden",filtro.getOrden());
	        }        
	        
	        List<Object[]> listadoAgenteInstalacion = query.getResultList();
	        retornoListado = ActividadBuilder.toListActividadAgenteInstalacion(listadoAgenteInstalacion);
	        
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retornoListado;
	}
	
	@Override
	public List<ActividadDTO> listarAgente(ActividadFilter filtro) {
		List<ActividadDTO> retornoListado=null;
		LOG.info("listarActividades");
		try{
			StringBuilder jpql = new StringBuilder();
			jpql.append("select a.id_actividad, a.orden_nps, a.nombre, a.codigo "
					+ "from mdi_actividad a "
					+ "where a.estado=1 ");
					//+ "and a.id_actividad_padre=:idActividadPadre ");
			
			if(filtro.getIdActividadPadre()!=null && !filtro.getIdActividadPadre().equals("")){
				jpql.append("and id_actividad_padre = :id_actividad_padre ");
			}
			
			if(filtro.getNombre()!=null && !filtro.getNombre().equals("")){
				jpql.append("and upper(a.nombre) like :nombre ");
			}
			
			if(filtro.getOrden()!=null && !filtro.getOrden().equals("")){
				jpql.append("and a.orden_nps=:orden ");
			}
			
			jpql.append("order by a.orden_nps ");
			
			Query query = crud.getEm().createNativeQuery(jpql.toString());
			
			if(filtro.getIdActividadPadre()!=null && !filtro.getIdActividadPadre().equals("")){
				query.setParameter("id_actividad_padre",filtro.getIdActividadPadre());
			}
			
			if(filtro.getNombre()!= null && !filtro.getNombre().equals("")){
	        	query.setParameter("nombre","%"+StringUtil.removeBlank(filtro.getNombre().toUpperCase())+"%");
	        }
			
			if(filtro.getOrden()!=null && !filtro.getOrden().equals("")){
	        	query.setParameter("orden",filtro.getOrden());
	        }        
	        
	        List<Object[]> listadoAgenteInstalacion = query.getResultList();
	        retornoListado = ActividadBuilder.toListActividadAgenteInstalacion(listadoAgenteInstalacion);
	        
        }catch(Exception ex){
            LOG.error("",ex);
        }
		return retornoListado;
	}
	
	@Override
	public ActividadDTO guardarActividad(ActividadDTO actividad, UsuarioDTO usuario) throws ActividadException {
		ActividadDTO retorno = null;
        try{
        	MdiActividad registro = ActividadBuilder.getMdiActividad(actividad);
        	registro.setDatosAuditoria(usuario);
        	registro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        	registro.setEsMayor(Constantes.ESMAYOR_DEFAULT);
        	registro.setNombreCorto(Constantes.NOMBRE_CORTO_DEFAULT);
        	registro.setFlagGabinete(Constantes.FLAG_GABINETE_DEFAULT);
        	registro.setAmbito(Constantes.AMBITO_DEFAULT);
        	registro.setPlazoDescargo(Constantes.PLAZO_DESCARGO_DEFAULT);
            crud.create(registro);
            retorno = ActividadBuilder.getActividadDTO(registro);
        }catch(Exception ex){
            LOG.error("error create... ",ex);
            ActividadException e2 = new ActividadException(ActividadException.ERROR_CREAR_ACTIVIDAD, ex, true);
            throw e2;
        }
        return retorno;
	}

	@Override
	public ActividadDTO actualizarActividad(ActividadDTO actividad, UsuarioDTO usuario) throws ActividadException {
		ActividadDTO retorno = null;
        try{
            MdiActividad registro = crud.find(actividad.getIdActividad(), MdiActividad.class);
            registro.setCodigo(actividad.getCodigo());
            registro.setNombre(actividad.getNombre());
            registro.setOrdenNps(actividad.getOrden());
            //registro.setEstado(actividad.getEstado());
            registro.setDatosAuditoria(usuario);
            crud.update(registro);
            retorno = ActividadBuilder.getActividadDTO(registro);
        }catch(Exception ex){
            LOG.error("error update... ",ex);
            ActividadException e2 = new ActividadException(ActividadException.ERROR_EDITAR_ACTIVIDAD, ex, true);
            throw e2;
        }
        return retorno;
	}
	
	@Override
	public ActividadDTO cambiarEstadoActividad(Long idActividad, String estado,UsuarioDTO usuario) throws ActividadException {
		ActividadDTO retorno = null;
        try{
            MdiActividad registro = crud.find(idActividad, MdiActividad.class);
            registro.setEstado(estado);
            registro.setDatosAuditoria(usuario);
            crud.update(registro);
            retorno = ActividadBuilder.getActividadDTO(registro);
        }catch(Exception ex){
            LOG.error("error update... ",ex);
            ActividadException e2 = new ActividadException(ActividadException.ERROR_EDITAR_ACTIVIDAD, ex, true);
            throw e2;
        }
        return retorno;
	}
	/* OSINE_SFS-600 - REQF-0009 - Fin */

	@Override
	public String verificarEliminarActividad(ActividadFilter filtro) throws ActividadException {
		String retorno=null;
		try{
			String queryString;
			StringBuilder jpql = new StringBuilder();		
			jpql.append("SELECT " +
				"CASE WHEN ag.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_MDI_ACTIVIDAD_AGENTE +"' END AS msjAgente, " +
				"CASE WHEN us.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_MDI_UNIDAD_SUPERVISADA +"' END AS msjUsupervisada,  " +
				"CASE WHEN cauo.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_CNF_ACT_UNI_ORGANICA +"' END AS msjUorganica, " +
				"CASE WHEN crp.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_CNF_REQU_PROCEDIMIENTO +"' END AS msjConfRequisito, " +
				"CASE WHEN cta.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_CNF_TRAMITE_ACTIVIDAD +"' END AS msjConfTramite, " +
				"CASE WHEN conf.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_CONFIGURACION +"' END AS msjUmedida, " +
				"CASE WHEN esao.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_EMPR_SUPE_ACTI_OBLI +"' END AS msjConfEmpSup, " +
				"CASE WHEN maa.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_MAESTRO_X_ACTIVIDAD +"' END AS msjMcolumna, " +
				"CASE WHEN moa.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_MODULO_X_ACTIVIDAD +"' END AS msjMactividad, " +
				"CASE WHEN nap.ID_AGENTE IS NOT NULL THEN '"+ Constantes.RELACION_PGH_NORMA_AGENTE_PRIORIDAD +"' END AS msjNorma, " +
				"CASE WHEN op.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_OPCION_ACTIVIDAD +"' END AS msjOpcion, " +
				"CASE WHEN pr.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_PLANTILLA_RESULTADO +"' END AS msjPResultado, " +
				"CASE WHEN pta.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_PROC_TRAM_ACTIVIDAD +"' END AS msjPTramites, " +
				"CASE WHEN pot.ID_ACTIVIDAD IS NOT NULL THEN '"+ Constantes.RELACION_PGH_PROCESO_OBLIGACION_TIPO +"' END AS msjOTipoProceso " +
				"FROM MDI_ACTIVIDAD act " +
				"LEFT JOIN (SELECT * FROM MDI_ACTIVIDAD p WHERE p.id_actividad_padre IS NOT NULL) ag ON act.ID_ACTIVIDAD = ag.ID_ACTIVIDAD_PADRE AND ag.ESTADO = '1' " +
				"LEFT JOIN MDI_UNIDAD_SUPERVISADA us ON act.ID_ACTIVIDAD = us.ID_ACTIVIDAD AND us.ESTADO = '1' " +
				"LEFT JOIN PGH_CNF_ACT_UNI_ORGANICA cauo ON act.ID_ACTIVIDAD = cauo.ID_ACTIVIDAD AND cauo.ESTADO = '1' " +
				"LEFT JOIN PGH_CNF_REQU_PROCEDIMIENTO crp ON act.ID_ACTIVIDAD = crp.ID_ACTIVIDAD AND crp.ESTADO = '1' " +
				"LEFT JOIN PGH_CNF_TRAMITE_ACTIVIDAD cta ON act.ID_ACTIVIDAD = cta.ID_ACTIVIDAD AND cta.ESTADO = '1' " +
				"LEFT JOIN PGH_CONFIGURACION conf ON act.ID_ACTIVIDAD = conf.ID_ACTIVIDAD " +
				"LEFT JOIN PGH_EMPR_SUPE_ACTI_OBLI esao ON act.ID_ACTIVIDAD = esao.ID_ACTIVIDAD AND esao.ESTADO = '1' " +
				"LEFT JOIN PGH_MAESTRO_X_ACTIVIDAD maa ON act.ID_ACTIVIDAD = maa.ID_ACTIVIDAD " +
				"LEFT JOIN PGH_MODULO_X_ACTIVIDAD moa ON act.ID_ACTIVIDAD = moa.ID_ACTIVIDAD  " +
				"LEFT JOIN PGH_NORMA_AGENTE_PRIORIDAD nap ON act.ID_ACTIVIDAD = nap.ID_AGENTE AND nap.ESTADO = '1' " +
				"LEFT JOIN PGH_OPCION_ACTIVIDAD op ON act.ID_ACTIVIDAD = op.ID_ACTIVIDAD AND op.ESTADO = '1' " +
				"LEFT JOIN PGH_PLANTILLA_RESULTADO pr ON act.ID_ACTIVIDAD = pr.ID_ACTIVIDAD AND pr.ESTADO = '1' " +
				"LEFT JOIN PGH_PROC_TRAM_ACTIVIDAD pta ON act.ID_ACTIVIDAD = pta.ID_ACTIVIDAD AND pta.ESTADO = '1' " +
				"LEFT JOIN PGH_PROCESO_OBLIGACION_TIPO pot ON act.ID_ACTIVIDAD = pot.ID_ACTIVIDAD AND pot.ESTADO = '1' " +
				"WHERE act.ESTADO = '1' AND " +
				"act.ID_ACTIVIDAD = :idActividad AND ROWNUM = 1");
			queryString = jpql.toString();
			Query query = this.crud.getEm().createNativeQuery(queryString);
            if(filtro.getIdActividad()!=null){
                query.setParameter("idActividad",filtro.getIdActividad());
            }
        	List<Object[]> resultado = query.getResultList();
        	retorno = ActividadBuilder.toVerificarEliminar(resultado);
        	LOG.info("listado verificarEliminarActividad "+retorno);
		}catch(Exception e){
			LOG.error("Error verificarEliminarActividad : " + e.getMessage());
		}
		return retorno;
	}

	@Override
	public List<ActividadDTO> findActividadByEtapaConfiguracion(ActividadFilter filtro, UnidadOrganicaFilter unidadOrganicaFilter) throws ActividadException {
		Query query = null;
		StringBuilder sql = new StringBuilder();
		String queryString = new String();
		List<ActividadDTO> lista = new ArrayList<ActividadDTO>();
		List<MdiActividad> listaMdiActividad =  new ArrayList<MdiActividad>();
		sql.append(" select distinct act from MdiActividad act, PghCnfActUniOrganica cuo where act.idActividad = cuo.idActividad.idActividad ");
		if(unidadOrganicaFilter.getIdUnidadOrganica()!=null){
			sql.append(" and cuo.idUnidadOrganica.idUnidadOrganica = " + unidadOrganicaFilter.getIdUnidadOrganica());
		}
		
		queryString = sql.toString();
		query = crud.getEm().createQuery(queryString);
		listaMdiActividad = query.getResultList();
		lista = ActividadBuilder.toListActividadDto(listaMdiActividad); 
		return lista;
	}

	public boolean estaEnLista(List<ActividadDTO> lista, ActividadDTO actividadDTO){
		for (ActividadDTO actividad : lista) {
			if(actividad.getIdActividad().equals(actividadDTO.getIdActividad()))
				return true;
		}
		return false;
	}   
	
	 /* OSINE_SFS-1232 - REQF- - Inicio */
	@Override
	public List<ActividadDTO> findActividadesPadre(ActividadFilter actividadFilter, UnidadOrganicaFilter unidadOrganicaFilter)throws ActividadException {
		List<ActividadDTO> listaActividadHijas = findActividadByEtapaConfiguracion(actividadFilter, unidadOrganicaFilter);
	    List<ActividadDTO> listaActividadPadre = new ArrayList<ActividadDTO>();
	    actividadFilter.setIdActividad(listaActividadHijas.get(0).getIdActividadPadre());
	    actividadFilter.setEstado(Constantes.ESTADO_ACTIVO);
	    ActividadDTO actividadDTOPadre = this.find(actividadFilter).get(0);
	    
		if(listaActividadHijas!=null && listaActividadHijas.size()>0)
			listaActividadPadre.add(actividadDTOPadre);
		
		for (ActividadDTO actividadDTO : listaActividadHijas) {
			 actividadFilter.setIdActividad(actividadDTO.getIdActividadPadre());
			 actividadFilter.setEstado(Constantes.ESTADO_ACTIVO);
			 List<ActividadDTO> listaActividadDTOPadre = find(actividadFilter);
			 if(listaActividadDTOPadre!=null && listaActividadDTOPadre.size()>0){
				 
				 actividadDTOPadre = listaActividadDTOPadre.get(0);
			 }
			 if(actividadDTOPadre!=null){
			  if(!estaEnLista(listaActividadPadre, actividadDTOPadre)){
				listaActividadPadre.add(actividadDTOPadre);
			  }
		    }
	    }
		return listaActividadPadre;
	}

	@Override
	public List<ActividadDTO> findActividadesHijasJoinEtapaConfiguracion( ActividadFilter filtro) throws ActividadException {
		Query query = null;
		StringBuilder sql = new StringBuilder();
		String queryString = new String();
		List<ActividadDTO> lista = new ArrayList<ActividadDTO>();
		List<MdiActividad> listaMdiActividad =  new ArrayList<MdiActividad>();
		sql.append(" select distinct act from MdiActividad act, PghCnfActUniOrganica cuo where act.idActividad = cuo.idActividad.idActividad  ");
		if(filtro.getIdActividad()!=null){
			sql.append(" and act.idActividadPadre = " + filtro.getIdActividad()); 
		}
		queryString = sql.toString();
		query = crud.getEm().createQuery(queryString);
		listaMdiActividad = query.getResultList();
		lista = ActividadBuilder.toListActividadDto(listaMdiActividad); 
		return lista;
	}

	@Override
	public List<ActividadDTO> findActividadByIdCnfActUniOrganicaDTO(CnfActUniOrganicaFilter cnfActUniOrganicaFilter) {
		Query query = null;
		StringBuilder sql = new StringBuilder();
		String queryString = new String();
		List<ActividadDTO> lista = new ArrayList<ActividadDTO>();
		List<MdiActividad> listaMdi =  new ArrayList<MdiActividad>();
		sql.append(" select distinct act from MdiActividad act, PghCnfActUniOrganica cuo where act.idActividad = cuo.idActividad.idActividad ");
		if(cnfActUniOrganicaFilter.getIdCnfActUniOrganicaFilter()!=null){
			sql.append(" and cuo.idCnfActUniOrganica = " + cnfActUniOrganicaFilter.getIdCnfActUniOrganicaFilter()); 
		}
		queryString = sql.toString();
		query = crud.getEm().createQuery(queryString);
		listaMdi = query.getResultList();
		lista = ActividadBuilder.toListActividadDto(listaMdi); 
		return lista;
	}

	 /* OSINE_SFS-1232 - REQF- - Fin */
}
