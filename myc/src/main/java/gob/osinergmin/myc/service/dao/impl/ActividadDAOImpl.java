/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.builder.ActividadBuilder;
import gob.osinergmin.myc.domain.builder.ObligacionSubTipoBuilder;
import gob.osinergmin.myc.domain.builder.ProcesoObligacionTipoBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.service.dao.ActividadDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.exception.ActividadException;
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
                }else if (filtro.getIdRubroOpcion()!= null) {
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
    
    
    
}
