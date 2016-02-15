package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import gob.osinergmin.myc.domain.PghConfObligacion;
import gob.osinergmin.myc.domain.PghProceso;
import gob.osinergmin.myc.domain.PghProcesoObligacionTipo;
import gob.osinergmin.myc.domain.builder.CnfObligacionBuilder;
import gob.osinergmin.myc.domain.builder.ProcesoObligacionTipoBuilder;
import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;
import gob.osinergmin.myc.service.dao.CnfObligacionDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.exception.ObligacionException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CnfObligacionDAOImpl implements CnfObligacionDAO{
	private static final Logger LOG = LoggerFactory.getLogger(CnfObligacionDAOImpl.class);
	@Inject
    private CrudDAO crud;
	
	@Override
	public List<ProcesoDTO> findProceso(Long idActividad) throws ObligacionException{
		
		List<ProcesoDTO> resultado=null;
		try{
			StringBuilder jpql = new StringBuilder();
			jpql.append(" SELECT distinct p.pghProcesoObligacionTipoPK.idProceso,pro.descripcion FROM ");
			jpql.append(" PghProcesoObligacionTipo p,PghProceso pro");
			jpql.append(" WHERE p.estado='1' ");
			jpql.append(" AND p.pghProcesoObligacionTipoPK.idProceso = pro.idProceso");
			jpql.append(" AND p.pghProcesoObligacionTipoPK.idActividad = '"+idActividad+"'");
			
			Query query = crud.getEm().createQuery(jpql.toString());
//			query.setParameter("pActividad", idActividad);
			
			List<Object[]> lstProcesos = query.getResultList();
			LOG.info("lista: "+lstProcesos);
			if(!CollectionUtils.isEmpty(lstProcesos)){
				resultado=ProcesoObligacionTipoBuilder.toListProcesoByObligacionTipoDto(lstProcesos);
	        }else{
	        	throw new ObligacionException("No existe Configuraci\u00F3n para el Rubro Seleccionado", null);
	        }
			
		} catch (ObligacionException ex) {
			throw new ObligacionException(ex.getMessage(),null);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		return resultado;
	}
	
	@Override
	public List<ObligacionTipoDTO> findObligacionTipo(Long idActividad,
			Long idTipoProceso) {
		List<ObligacionTipoDTO> resultado=null;
		try {
			StringBuilder jpql = new StringBuilder();
			
			jpql.append(" SELECT distinct p FROM PghProcesoObligacionTipo p ");
			jpql.append(" where p.estado='1' ");
			if(idActividad !=null){
				jpql.append(" and p.pghProcesoObligacionTipoPK.idProceso=:proceso ");	
			}
			if(idTipoProceso!=null){
				jpql.append(" and p.pghProcesoObligacionTipoPK.idActividad=:idActividad  ");
			}			
			Query query = crud.getEm().createQuery(jpql.toString());
			if(idTipoProceso!=null){
			query.setParameter("proceso", idTipoProceso);
			}
			if(idActividad !=null){
			query.setParameter("idActividad", idActividad);
			}
			List<PghProcesoObligacionTipo> lstObligacionesTipo = query.getResultList();
			LOG.info("lista: "+lstObligacionesTipo);
			if(!CollectionUtils.isEmpty(lstObligacionesTipo)){
				resultado=ProcesoObligacionTipoBuilder.toListobligacionTipoByObligacionTipoDto(lstObligacionesTipo);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	@Override
	public List<ObligacionTipoDTO> findObligacionTipoConfig(ObligacionTipoFilter filtro) {
		List<ObligacionTipoDTO> resultado=null;
		try {
			StringBuilder jpql = new StringBuilder();
			
			jpql.append(" select distinct p.id_obligacion_tipo,ot.nombre FROM pgh_proceso_obligacion_tipo p ");
			jpql.append(" left join pgh_obligacion_tipo ot on p.id_obligacion_tipo = ot.id_obligacion_tipo and ot.estado = 1 ");
			if(filtro.getEstado()!=null){
				jpql.append(" where p.estado=:estado ");
			}
			Query query = crud.getEm().createNativeQuery(jpql.toString());
			if(filtro.getEstado()!=null){
				query.setParameter("estado", filtro.getEstado());
			}
			List<Object[]> lstObligacionesTipo = query.getResultList();
			LOG.info("lista: "+lstObligacionesTipo);
			if(!CollectionUtils.isEmpty(lstObligacionesTipo)){
				resultado=ProcesoObligacionTipoBuilder.toListOblgTipoConfDto(lstObligacionesTipo);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public CnfObligacionDTO changeEstado(Long idConfObligacion,String codTrazabilidad,UsuarioDTO usuarioDTO) {
		CnfObligacionDTO retorno = null;
		try {
			PghConfObligacion cnfObligacion = crud.find(idConfObligacion,PghConfObligacion.class);
			String estado="0";
			cnfObligacion.setEstado(estado);
			cnfObligacion.setDatosAuditoria(usuarioDTO);
                        cnfObligacion.setCodTrazabilidad(codTrazabilidad);
                        if(cnfObligacion.getCodTrazabilidad()!=null && !cnfObligacion.getCodTrazabilidad().equals("")){
                            crud.updateWithHistory(cnfObligacion);
                        }else{
                            crud.update(cnfObligacion);
                        }		
			
			retorno=CnfObligacionBuilder.toConfObligacionDto(cnfObligacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	

}
