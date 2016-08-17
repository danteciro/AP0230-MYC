/**
* Resumen           
* Objeto            : PrioridadNormaAgenteDAOImpl.java
* Descripción       : Clase implementación del acceso a datos de prioridad norma agente en el MYC.
* Fecha de Creación : 04/07/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernandez.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.service.dao.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghConfObligacion;
import gob.osinergmin.myc.domain.PghNormaAgentePrioridad;
import gob.osinergmin.myc.domain.builder.BaseLegalBuilder;
import gob.osinergmin.myc.domain.builder.PrioridadNormaAgenteBuilder;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.PrioridadNormaAgenteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.PrioridadNormaAgenteFilter;
import gob.osinergmin.myc.service.dao.ActividadDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.PrioridadNormaAgenteDAO;
import gob.osinergmin.myc.service.exception.PrioridadNormaAgenteException;
import gob.osinergmin.myc.util.Constantes;

@Service("PrioridadNormaAgenteDAO")
public class PrioridadNormaAgenteDAOImpl implements PrioridadNormaAgenteDAO { 
	private static final Logger LOG = LoggerFactory.getLogger(ActividadDAO.class);
	@Inject
    private CrudDAO crud;
	@Override
	public List<PrioridadNormaAgenteDTO> find(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException {
		List<PrioridadNormaAgenteDTO> listado;
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        listado = PrioridadNormaAgenteBuilder.toListPrioridadNormaAgenteDto(query.getResultList());

        return listado;
	}

	@Override
	public Long count(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException {
		Query query = getFindQuery(filtro, true);
        return (Long) query.getSingleResult();
	}
	
	private Query getFindQuery(PrioridadNormaAgenteFilter filtro, boolean count) {
        Query query=null;
        try {
            if (count) {
                if (filtro.getIdPrioridadNormaAgente()!= null) {
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.countByIdNormaAgentePrioridad");
                }else if (filtro.getIdAgente()!= null && filtro.getOrden()!=null) {
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.countByIdOrden");
                }else if (filtro.getIdAgente()!= null && filtro.getOrden()==null) {
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.countByIdActividad");
                }else if (filtro.getIdBaseLegal()!= null) {
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.countByIdBaseLegal");                
                }else{ 
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.countAll");
                }               
            }else {
            	if (filtro.getIdPrioridadNormaAgente()!= null) {
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.findByIdNormaAgentePrioridad");
                }else if (filtro.getIdAgente()!= null && filtro.getOrden()!=null) {
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.findByIdOrden");
                }else if (filtro.getIdAgente()!= null && filtro.getOrden()==null) {
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.findByIdActividad");
                }else if (filtro.getIdBaseLegal()!= null) {
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.findByIdBaseLegal");                
                }else{
                    query = crud.getEm().createNamedQuery("PghNormaAgentePrioridad.findAll");
                }
            }

            if (filtro.getIdPrioridadNormaAgente()!= null) {
                query.setParameter("idNormaAgentePrioridad",filtro.getIdPrioridadNormaAgente());
            }
            if (filtro.getIdAgente()!= null && filtro.getOrden()!=null) {
                query.setParameter("idActividad",filtro.getIdAgente());
                query.setParameter("orden",filtro.getOrden());
            }
            if (filtro.getIdAgente()!= null && filtro.getOrden()==null) {
                query.setParameter("idActividad",filtro.getIdAgente());
            }
            if (filtro.getEstado()!= null){
                query.setParameter("estado",filtro.getEstado());
            }
            if (filtro.getIdBaseLegal()!= null){
                query.setParameter("idBaseLegal",filtro.getIdBaseLegal());
            }           
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
	
	@Override
	public List<PrioridadNormaAgenteDTO> findPrioridadNormaEdit(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException {
		List<PrioridadNormaAgenteDTO> retorno=null;
		Query query=null;
		try{
			String queryString;
			StringBuilder jpql = new StringBuilder();
			if(filtro.isFlagNotInIdPrioridadNormaAgente())
				jpql.append("SELECT p FROM PghNormaAgentePrioridad p LEFT JOIN p.idAgente ac WHERE p.estado = 1 AND ac.idActividad = :idAgente AND  p.idNormaAgentePrioridad NOT IN ("+filtro.getCodigosPrioridadNormaAgente()+") AND p.orden IN ("+filtro.getCodigosOrden()+")");
			else 
				jpql.append("SELECT p FROM PghNormaAgentePrioridad p LEFT JOIN p.idAgente ac WHERE p.estado = 1 AND ac.idActividad = :idAgente AND p.idNormaAgentePrioridad IN ("+filtro.getCodigosPrioridadNormaAgente()+")");
			
			queryString = jpql.toString();
			query = crud.getEm().createQuery(queryString);
			if(filtro.getIdAgente()!=null){
                query.setParameter("idAgente",filtro.getIdAgente());
            }     
            retorno = PrioridadNormaAgenteBuilder.toListPrioridadNormaAgenteDto(query.getResultList());
		}catch(Exception e){
			LOG.error("Error findPrioridadNormaEdit : " + e.getMessage());
		}
		return retorno;
	}

	@Override
	public List<BaseLegalDTO> findBaseLegalByIdAgente(Long idAgente) throws PrioridadNormaAgenteException {
		List<BaseLegalDTO> retorno=null;
		Query query=null;
		try{
			String queryString;
			StringBuilder jpql = new StringBuilder();
			jpql.append("SELECT * FROM (SELECT DISTINCT normlgl.ID_BASE_LEGAL, normlgl.CODIGO_BASE_LEGAL, normlgl.DESCRIPCION, normlgl.ESTADO, normlgl.ID_PADRE "
			+ "FROM PGH_BASE_LEGAL normlgl, "  
			+ "PGH_BASE_LEGAL bl, "
			+ "PGH_OBLIGACION_BASE_LEGAL obl, "
			+ "PGH_OBLIGACION o, "
			+ "PGH_CONF_OBLIGACION co, "
			+ "PGH_PROCESO_OBLIGACION_TIPO pot, " 
			+ "MDI_ACTIVIDAD a WHERE 1 = 1 "
			+ "AND normlgl.ID_BASE_LEGAL = bl.ID_BASE_LEGAL_PADRE "
			+ "AND bl.ID_BASE_LEGAL = obl.ID_BASE_LEGAL "
			+ "AND obl.ID_OBLIGACION = o.ID_OBLIGACION "
			+ "AND o.ID_OBLIGACION = co.ID_OBLIGACION "
			+ "AND co.ID_OBLIGACION_TIPO = pot.ID_OBLIGACION_TIPO "
			+ "AND co.ID_ACTIVIDAD = pot.ID_ACTIVIDAD "
			+ "AND co.ID_PROCESO = pot.ID_PROCESO " 
			+ "AND co.ID_PRO_OBL_TIP = pot.ID_PRO_OBL_TIP " 
			+ "AND pot.ID_ACTIVIDAD = a.ID_ACTIVIDAD "
			+ "AND normlgl.FLAG_PADRE = 'P' "
			+ "AND normlgl.ESTADO = 1 AND bl.ESTADO = 1 AND obl.ESTADO = 1 AND o.ESTADO = 1 AND co.ESTADO = 1 AND pot.ESTADO = 1 AND a.ESTADO = 1 "
			+ "AND a.ID_ACTIVIDAD_PADRE IS NOT NULL ");
			if(idAgente!=null){
				jpql.append("AND a.ID_ACTIVIDAD = :idAgente ");
			}
			jpql.append("MINUS "
			+ "SELECT DISTINCT nap.ID_BASE_LEGAL, bl.CODIGO_BASE_LEGAL, bl.DESCRIPCION, bl.ESTADO, bl.ID_PADRE "
			+ "FROM PGH_NORMA_AGENTE_PRIORIDAD nap, "
			+ "PGH_BASE_LEGAL bl "
			+ "WHERE 1 = 1 "
			+ "AND nap.estado = 1 AND bl.estado = 1 "
			+ "AND nap.ID_BASE_LEGAL = bl.ID_BASE_LEGAL ");		
			if(idAgente!=null){
				jpql.append("AND nap.ID_AGENTE = :idAgente) ORDER BY DESCRIPCION");
			}
			queryString = jpql.toString();
            query = this.crud.getEm().createNativeQuery(queryString);
            if(idAgente!=null){
                query.setParameter("idAgente",idAgente);
            }
            List<Object[]> lista = query.getResultList();
            retorno = BaseLegalBuilder.toListBaseLegalByObligacionDto(lista);

		}catch(Exception e){
			LOG.error("Error findByActividadAgente : " + e.getMessage());
		}
		return retorno;
	}

	@Override
	public PrioridadNormaAgenteDTO update(PrioridadNormaAgenteDTO prioridadNormaAgenteDTO, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException {
		PrioridadNormaAgenteDTO retorno=null;
        try{
        	PghNormaAgentePrioridad registro=PrioridadNormaAgenteBuilder.toPrioridadNormaAgentePgh(prioridadNormaAgenteDTO);
            registro.setDatosAuditoria(usuarioDTO);
            crud.update(registro);
            retorno = prioridadNormaAgenteDTO;
        }catch (Exception ex) {
            LOG.error("error update  ",ex);
            throw new PrioridadNormaAgenteException(ex);
        }
        return retorno;
	}

	@Override
	public PrioridadNormaAgenteDTO create(PrioridadNormaAgenteDTO prioridadNormaAgenteDTO, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException {
		PrioridadNormaAgenteDTO retorno=null;
        try{
        	PghNormaAgentePrioridad registro=PrioridadNormaAgenteBuilder.toPrioridadNormaAgentePgh(prioridadNormaAgenteDTO);
            registro.setDatosAuditoria(usuarioDTO);
            crud.create(registro);
            retorno = prioridadNormaAgenteDTO;
        }catch (Exception ex) {
            LOG.error("error create  ",ex);
            throw new PrioridadNormaAgenteException(ex);
        }
        return retorno;
	}

	@Override
	public List<PrioridadNormaAgenteDTO> findPrioridadNormaAgente(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException {
		List<PrioridadNormaAgenteDTO> retorno=null;
		Query query=null;
		try{
			String queryString;
			StringBuilder jpql = new StringBuilder();
			jpql.append("SELECT np.ID_NORMA_AGENTE_PRIORIDAD, np.ID_AGENTE, np.ID_BASE_LEGAL AS ID_BASE_LEGAL_NORMA , np.ESTADO AS ESTADO_NORMA, np.ORDEN, t.*  FROM PGH_NORMA_AGENTE_PRIORIDAD np LEFT JOIN "
			+ "(SELECT DISTINCT normlgl.ID_BASE_LEGAL, normlgl.CODIGO_BASE_LEGAL, normlgl.DESCRIPCION, normlgl.ESTADO, normlgl.ID_PADRE, a.id_actividad FROM "
			+ "PGH_BASE_LEGAL normlgl, "
			+ "PGH_BASE_LEGAL bl, "
			+ "PGH_OBLIGACION_BASE_LEGAL obl, "
			+ "PGH_OBLIGACION o, "
			+ "PGH_CONF_OBLIGACION co, "
			+ "PGH_PROCESO_OBLIGACION_TIPO pot, " 
			+ "MDI_ACTIVIDAD a WHERE 1 = 1 "
			+ "AND normlgl.ID_BASE_LEGAL = bl.ID_BASE_LEGAL_PADRE "
			+ "AND bl.ID_BASE_LEGAL = obl.ID_BASE_LEGAL "
			+ "AND obl.ID_OBLIGACION = o.ID_OBLIGACION "
			+ "AND o.ID_OBLIGACION = co.ID_OBLIGACION "
			+ "AND co.ID_OBLIGACION_TIPO = pot.ID_OBLIGACION_TIPO "
			+ "AND co.ID_ACTIVIDAD = pot.ID_ACTIVIDAD "
			+ "AND co.ID_PROCESO = pot.ID_PROCESO " 
			+ "AND co.ID_PRO_OBL_TIP = pot.ID_PRO_OBL_TIP " 
			+ "AND pot.ID_ACTIVIDAD = a.ID_ACTIVIDAD "
			+ "AND normlgl.FLAG_PADRE = 'P' "
			+ "AND normlgl.ESTADO = 1 AND bl.ESTADO = 1 AND obl.ESTADO = 1 AND o.ESTADO = 1 AND co.ESTADO = 1 AND pot.ESTADO = 1 AND a.ESTADO = 1 "
			+ "AND a.ID_ACTIVIDAD_PADRE IS NOT NULL ");
			jpql.append("AND a.ID_ACTIVIDAD = :idAgente) t ON np.ID_AGENTE = t.Id_ACTIVIDAD and np.ID_BASE_LEGAL = t.ID_BASE_LEGAL ");
			jpql.append("WHERE np.ESTADO = 1 AND np.ID_AGENTE = :idAgente ORDER BY np.ORDEN");

			queryString = jpql.toString();
            query = this.crud.getEm().createNativeQuery(queryString);
            if(filtro.getIdAgente()!=null){
                query.setParameter("idAgente",filtro.getIdAgente());
            }
            List<Object[]> lista = query.getResultList();
            retorno = PrioridadNormaAgenteBuilder.toListPrioridadNormaDto(lista);

		}catch(Exception e){
			LOG.error("Error findByActividadAgente : " + e.getMessage());
		}
		return retorno;
	}
	
	public void eliminarPrioridadNorma(Long idObject, String tipo, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException{
		if(Constantes.ELIMINAR_ORDEN_NORMA_ID_NORMA_PRIORIDAD.equals(tipo)){
			eliminarPorIdPrioridadNormaAgente(idObject, usuarioDTO);
		}else if(Constantes.ELIMINAR_ORDEN_NORMA_ID_BASE_LEGAL.equals(tipo)){
			eliminarPorIdBaseLegal(idObject, usuarioDTO);
		}else if(Constantes.ELIMINAR_ORDEN_NORMA_ID_OBLIGACION.equals(tipo)){
			eliminarPorIdObligacion(idObject, usuarioDTO);
		}else if(Constantes.ELIMINAR_ORDEN_NORMA_ID_RELACION_BASE_OBLIGACION.equals(tipo)){
			eliminarPorIdBaseLegal(idObject, usuarioDTO); //logica la misma que para eliminar base legal
		}else if(Constantes.ELIMINAR_ORDEN_NORMA_ID_CONF_OBLIGACION.equals(tipo)){
			eliminarPorIdConfObligacion(idObject, usuarioDTO); //logica la misma que para eliminar obligacion
		}	
	}
	/**
	 * Eliminamos por id de Norma Prioridad (estado a 0)
	 * @param idPrioridadNorma id norma prioridad	 * 
	 * @param usuarioDTO usuario auditoria
	 */
	private void eliminarPorIdPrioridadNormaAgente(Long idPrioridadNorma, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException{		
		try{
			PghNormaAgentePrioridad normaAgente = crud.find(idPrioridadNorma, PghNormaAgentePrioridad.class);
			if(normaAgente!=null){
				normaAgente.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
				normaAgente.setDatosAuditoria(usuarioDTO);
				crud.update(normaAgente);
			}			
		}catch(Exception ex){
			LOG.error("eliminarPorIdPrioridadNormaAgente",ex);
			throw new PrioridadNormaAgenteException(ex);
		}		
	}
	
	/**
	 * Se elimino la base legal tratar de eliminar prioridad norma agente
	 * @param idBaseLegal id base legal eliminada
	 * @param usuarioDTO usuario auditoria
	 */
	private void eliminarPorIdBaseLegal(Long idBaseLegal, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException{
		try{
			//buscamos la base legal eliminada
			PghBaseLegal baseLegal = crud.find(idBaseLegal, PghBaseLegal.class);
			Long idNormaLegal = baseLegal.getIdBaseLegalPadre();
			//buscamos la norma legal eliminada
			PghBaseLegal normaLegal = crud.find(idNormaLegal, PghBaseLegal.class);
			String query = "update pgh_norma_agente_prioridad nap "+
						   "set nap.estado                 = :estadoInactivo, "+
						   "nap.usuario_actualizacion  = :usuarioActualizacion, "+
						   "nap.fecha_actualizacion    = :fechaActualizacion, "+
						   "nap.terminal_actualizacion = :terminalActualizacion "+
						   "where nap.estado = '1' "+
						   "and nap.id_base_legal = :idNormaLegal "+
						   "and nap.id_agente not in "+
						   "(select distinct a.id_actividad "+
						    "from pgh_base_legal       nl1, "+
						    "pgh_base_legal            bl, "+
						    "pgh_obligacion_base_legal obl, "+
						    "pgh_obligacion            o, "+
						    "pgh_conf_obligacion       co, "+
						    "mdi_actividad             a "+
						    "where 1 = 1 "+
						    "and nl1.id_base_legal = bl.id_base_legal_padre "+
						    "and bl.id_base_legal = obl.id_base_legal "+
						    "and obl.id_obligacion = o.id_obligacion "+
						    "and o.id_obligacion = co.id_obligacion "+
						    "and co.id_actividad = a.id_actividad "+
						    "and nl1.estado = '1' "+
						    "and nl1.flag_padre = 'P' "+
						    "and bl.estado = '1' "+
						    "and obl.estado = '1' "+
						    "and o.estado = '1' "+
						    "and co.estado = '1' "+
						    "and a.estado = '1' "+
						    "and a.id_actividad_padre is not null "+
						    "and nl1.id_base_legal = :idNormaLegal) ";
			Query q = crud.getEm().createNativeQuery(query);
			q.setParameter("estadoInactivo", Constantes.CONSTANTE_ESTADO_INACTIVO);
			q.setParameter("usuarioActualizacion", usuarioDTO.getCodigo());
			q.setParameter("fechaActualizacion", new Date());
			q.setParameter("terminalActualizacion", usuarioDTO.getTerminal());
			q.setParameter("idNormaLegal", normaLegal.getIdBaseLegal());
			q.executeUpdate();
		}catch(Exception ex){
			LOG.error("eliminarPorIdBaseLegal",ex);
			throw new PrioridadNormaAgenteException(ex);
		}
	}
	private void eliminarPorIdObligacion(Long idObligacion, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException{
		try{
			String query = "update pgh_norma_agente_prioridad nap "+
						   "set nap.estado                 = :estadoInactivo, "+
						       "nap.usuario_actualizacion  = :usuarioActualizacion, "+
						       "nap.fecha_actualizacion    = :fechaActualizacion, "+
						       "nap.terminal_actualizacion = :terminalActualizacion "+
						 	"where nap.estado = 1 "+
						   	"and nap.id_agente in "+ 
						   		"( select co2.id_actividad from pgh_obligacion o2, pgh_conf_obligacion co2 "+
						     	"where o2.id_obligacion = co2.id_obligacion and o2.id_obligacion = :idObligacion ) "+
						   	"and (nap.id_base_legal,nap.id_agente) not in "+   
							       	"(select distinct nl1.id_base_legal, a.id_actividad "+
							          	"from pgh_base_legal            nl1, "+
							               "pgh_base_legal            bl, "+
							               "pgh_obligacion_base_legal obl, "+
							               "pgh_obligacion            o, "+
							               "pgh_conf_obligacion       co, "+
							               "mdi_actividad             a "+
							         	"where 1 = 1 "+
							           	   "and nl1.id_base_legal = bl.id_base_legal_padre "+
							           	   "and bl.id_base_legal = obl.id_base_legal "+
							           	   "and obl.id_obligacion = o.id_obligacion "+
							           	   "and o.id_obligacion = co.id_obligacion "+
							          	   "and co.id_actividad = a.id_actividad "+
							               "and nl1.estado = 1 "+
							               "and nl1.flag_padre = 'P' "+
							               "and bl.estado = 1 "+
							               "and obl.estado = 1 "+
							               "and o.estado = 1 "+
							               "and co.estado = 1 "+
							               "and a.estado = 1 "+
							               "and a.id_actividad_padre is not null "+
							               "and a.id_actividad in "+ 
							                   "( select co1.id_actividad from pgh_obligacion o1, pgh_conf_obligacion co1 "+
							                   "where o1.id_obligacion = co1.id_obligacion and o1.id_obligacion = :idObligacion ) "+
							                   ")";	
				Query q = crud.getEm().createNativeQuery(query);
				q.setParameter("estadoInactivo", Constantes.CONSTANTE_ESTADO_INACTIVO);
				q.setParameter("usuarioActualizacion", usuarioDTO.getCodigo());
				q.setParameter("fechaActualizacion", new Date());
				q.setParameter("terminalActualizacion", usuarioDTO.getTerminal());
				q.setParameter("idObligacion", idObligacion);
				q.executeUpdate();
		}catch(Exception ex){
			LOG.error("eliminarPorIdBaseLegal",ex);
			throw new PrioridadNormaAgenteException(ex);
		}
	}	
	
	private void eliminarPorIdConfObligacion(Long idConfObligacion, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException{
		try{
			PghConfObligacion co = crud.find(idConfObligacion, PghConfObligacion.class);			
			eliminarPorIdObligacion(co.getIdObligacion().getIdObligacion(), usuarioDTO);
		}catch(Exception ex){
			LOG.error("eliminarPorIdObligacion",ex);
			throw new PrioridadNormaAgenteException(ex);
		}
	}	
	
	
	
	
}
