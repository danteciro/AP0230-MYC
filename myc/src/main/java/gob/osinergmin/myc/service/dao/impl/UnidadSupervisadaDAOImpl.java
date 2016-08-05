/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;
import gob.osinergmin.myc.domain.MdiUnidadSupervisada;
import gob.osinergmin.myc.domain.builder.UnidadOrganicaBuilder;
import gob.osinergmin.myc.domain.builder.UnidadSupervisadaBuilder;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.domain.ui.UnidadSupervisadaFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.UnidadOrganicaDAO;
import gob.osinergmin.myc.service.dao.UnidadSupervisadaDAO;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
*
* @author mdiosesf
*/

@Service
@Transactional
public class UnidadSupervisadaDAOImpl implements UnidadSupervisadaDAO{	
	private static final Logger LOG = LoggerFactory.getLogger(UnidadSupervisadaDAOImpl.class);	
	@Inject
    private CrudDAO crud;

	@Override
	public Long contarUnidadSupervisadaxActividad(UnidadSupervisadaFilter filtro) {
		Query query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.countByIdActividad");
		if(filtro.getIdActividad()!=null){
			query.setParameter("idActividad",filtro.getIdActividad());
		}		
        return (Long) query.getSingleResult();
	}

	@Override
	public Long contarUnidadSupervisadaxActividadxEstratoDistrito(UnidadSupervisadaFilter filtro) {
		Query query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.countByIdActividadxEstratoDistrito");
		if(filtro.getIdActividad()!=null){
			query.setParameter("idActividad",filtro.getIdActividad());
		}
		query.setParameter("departamento",filtro.getDepartamento());
		query.setParameter("provincia",filtro.getProvincia());
		query.setParameter("distrito",filtro.getDistrito());
		query.setParameter("estado",filtro.getEstado());
		query.setParameter("dominio",filtro.getDominio());
		query.setParameter("aplicacion",filtro.getAplicacion());
		query.setParameter("codigo",filtro.getTipoDireccion());
        return (Long) query.getSingleResult();
	}

	@Override
	public Long contarUnidadSupervisadaxActividadxEstrato(UnidadSupervisadaFilter filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long contarUnidadSupervisadaxActividadxEstratoProvincia(UnidadSupervisadaFilter filtro) {
		Query query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.countByIdActividadxEstratoProvincia");
		if(filtro.getIdActividad()!=null){
			query.setParameter("idActividad",filtro.getIdActividad());
		}
		query.setParameter("departamento",filtro.getDepartamento());
		query.setParameter("provincia",filtro.getProvincia());
		query.setParameter("estado",filtro.getEstado());
        return (Long) query.getSingleResult();
	}

	@Override
	public Long contarUnidadSupervisadaxActividadxEstratoDepartamento(UnidadSupervisadaFilter filtro) {
		Query query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.countByIdActividadxEstratoDepartamento");
		if(filtro.getIdActividad()!=null){
			query.setParameter("idActividad",filtro.getIdActividad());
		}
		query.setParameter("departamento",filtro.getDepartamento());
		query.setParameter("estado",filtro.getEstado());
        return (Long) query.getSingleResult();
	}

	@Override
	public List<UnidadSupervisadaDTO> listarUnidadSupervisadaxActividadxEstratoDepartamento(UnidadSupervisadaFilter filtro) {
		List<UnidadSupervisadaDTO> lista = new ArrayList<UnidadSupervisadaDTO>();
		Query query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.findByIdActividadxEstratoDepartamento");
		if(filtro.getIdActividad()!=null){
			query.setParameter("idActividad",filtro.getIdActividad());
		}
		query.setParameter("departamento",filtro.getDepartamento());
		query.setParameter("estado",filtro.getEstado());
		lista = UnidadSupervisadaBuilder.toListUnidadSupervisadaDto(query.getResultList());
		
		return lista;
	}

	@Override
	public List<UnidadSupervisadaDTO> listarUnidadSupervisadaxActividadxEstratoDistrito(UnidadSupervisadaFilter filtro) {
		List<UnidadSupervisadaDTO> lista = new ArrayList<UnidadSupervisadaDTO>();
		Query query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.findByIdActividadxEstratoDistrito");
		if(filtro.getIdActividad()!=null){
			query.setParameter("idActividad",filtro.getIdActividad());
		}
		query.setParameter("departamento",filtro.getDepartamento());
		query.setParameter("provincia",filtro.getProvincia());
		query.setParameter("distrito",filtro.getDistrito());
		query.setParameter("estado",filtro.getEstado());
		lista = UnidadSupervisadaBuilder.toListUnidadSupervisadaDto(query.getResultList());
		
		return lista;
	}

	@Override
	public List<UnidadSupervisadaDTO> listarUnidadSupervisadaxActividadxEstratoProvincia(UnidadSupervisadaFilter filtro) {
		List<UnidadSupervisadaDTO> lista = new ArrayList<UnidadSupervisadaDTO>();
		Query query = crud.getEm().createNamedQuery("MdiUnidadSupervisada.findByIdActividadxEstratoProvincia");
		if(filtro.getIdActividad()!=null){
			query.setParameter("idActividad",filtro.getIdActividad());
		}
		query.setParameter("departamento",filtro.getDepartamento());
		query.setParameter("provincia",filtro.getProvincia());
		query.setParameter("estado",filtro.getEstado());
		lista = UnidadSupervisadaBuilder.toListUnidadSupervisadaDto(query.getResultList());
		
		return lista;
	}
	
	
	

}