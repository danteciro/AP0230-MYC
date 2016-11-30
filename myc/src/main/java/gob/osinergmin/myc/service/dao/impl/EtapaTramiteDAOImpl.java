/*
* Resumen
* Objeto            : EtapaTramiteDAOImpl.java
* Descripción       : Clase que contiene la implementación de los métodos declarados en la clase interfaz EtapaTramiteDAO
* Fecha de Creación : 
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |     Busqueda por filtros
*/

package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import gob.osinergmin.myc.domain.NpsEtapaTramite;
import gob.osinergmin.myc.domain.builder.EtapaTramiteBuilder;
/* OSINE_SFS-1232 - lgarciar - Inicio */
import gob.osinergmin.myc.domain.dto.EtapaTramiteDTO;
/* OSINE_SFS-1232 - lgarciar - Fin */
import gob.osinergmin.myc.domain.dto.EtapaTramiteNpsDTO;
import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;
import gob.osinergmin.myc.domain.ui.EtapaTramiteBusquedaFilter;
/* OSINE_SFS-1232 - lgarciar - Inicio */
import gob.osinergmin.myc.domain.ui.EtapaTramiteFilter;
/* OSINE_SFS-1232 - lgarciar - Fin */
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.EtapaTramiteDAO;
import gob.osinergmin.myc.util.Constantes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/* OSINE_SFS-1232 - lgarciar - Inicio */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* OSINE_SFS-1232 - lgarciar - Fin */

@Repository("EtapaTramiteDAO")
@Transactional
public class EtapaTramiteDAOImpl implements EtapaTramiteDAO {
    /* OSINE_SFS-1232 - lgarciar - Inicio */
    private static final Logger LOG = LoggerFactory.getLogger(EtapaTramiteDAOImpl.class);
    /* OSINE_SFS-1232 - lgarciar - Fin */
	@Inject
	private CrudDAO crudDAO;
        
	@Override
	public EtapaTramiteNpsDTO create(EtapaTramiteNpsDTO etapaTramiteNpsDTO,
			UsuarioDTO usuarioDTO) {
		NpsEtapaTramite npsEtapaTramite = EtapaTramiteBuilder
				.toNpsEtapaTramite(etapaTramiteNpsDTO);
		npsEtapaTramite.setDatosAuditoria(usuarioDTO);
		npsEtapaTramite.setEstado(Constantes.ESTADO_ACTIVO);
		crudDAO.create(npsEtapaTramite);
		return etapaTramiteNpsDTO;
	}

	@Override
	public EtapaTramiteNpsDTO update(EtapaTramiteNpsDTO etapaTramiteNpsDTO,
			UsuarioDTO usuarioDTO) {
		NpsEtapaTramite npsEtapaTramite = EtapaTramiteBuilder
				.toNpsEtapaTramite(etapaTramiteNpsDTO);
		npsEtapaTramite.setDatosAuditoria(usuarioDTO);
		crudDAO.update(npsEtapaTramite);
		return etapaTramiteNpsDTO;
	}

	@Override
	public List<EtapaTramiteNpsDTO> listarEtapaTramite(
			EtapaNpsFilter etapaNpsFilter, ConfTramiteFilter confTramiteFilter) {
		Query query = null;
		List<NpsEtapaTramite> lista = new ArrayList<NpsEtapaTramite>();
		List<EtapaTramiteNpsDTO> listaDto = new ArrayList<EtapaTramiteNpsDTO>();
		try {
			query = crudDAO.getEm().createNamedQuery("NpsEtapaTramite.findAll");
			lista = query.getResultList();
			listaDto = EtapaTramiteBuilder.toListEtapaTramiteDTO(lista);

		} catch (Exception e) {

		}
		return listaDto;
	}

	@Override
	public boolean delete(EtapaTramiteNpsDTO etapaTramiteNpsDTO,UsuarioDTO usuarioDTO) {
		NpsEtapaTramite npsEtapaTramite = EtapaTramiteBuilder.toNpsEtapaTramite(etapaTramiteNpsDTO);
		npsEtapaTramite.setDatosAuditoria(usuarioDTO);
		npsEtapaTramite.setEstado(Constantes.ESTADO_INACTIVO);
		crudDAO.update(npsEtapaTramite);
		return true;
	}

	@Override
	public EtapaTramiteNpsDTO findByIdEtapaTramite(Long idEtapaTramite) {
		NpsEtapaTramite npsEtapaTramite = crudDAO.find(idEtapaTramite,
				NpsEtapaTramite.class);
		EtapaTramiteNpsDTO etapaTramiteNpsDTO = EtapaTramiteBuilder
				.toEtapaTramiteDTO(npsEtapaTramite);
		return etapaTramiteNpsDTO;
	}

	@Override
	public List<EtapaTramiteNpsDTO> buscarEtapaTramite(
		EtapaTramiteBusquedaFilter etapaTramiteBusquedaFilter) {
		Query query = null;
		List<NpsEtapaTramite> listado = new ArrayList<NpsEtapaTramite>();
		List<EtapaTramiteNpsDTO> listadoDto = new ArrayList<EtapaTramiteNpsDTO>();
		try {
			StringBuilder jpql = new StringBuilder();
			//jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct ,PghCnfActUniOrganica cauo,NpsTramite t,  MdiUnidadOrganica uo , NpsEtapa e , NpsSubetapa se,  MdiActividad act where  et.estado = '1'  ");
			//agente,tramite y responsable
			if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null && etapaTramiteBusquedaFilter.getIdActividad()!=null
				 && etapaTramiteBusquedaFilter.getIdAgente()!=null && etapaTramiteBusquedaFilter.getIdTramite() != null && etapaTramiteBusquedaFilter.getIdResponsable()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se , PghCnfActUniOrganica cauo ");
				jpql.append( " where et.estado = '1' and et.idConfTramite.idConfTramite = ct.idConfTramite and ct.idTramite.idTramite =  " + etapaTramiteBusquedaFilter.getIdTramite());
				jpql.append(" and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica and cauo.idActividad.idActividad =   " + etapaTramiteBusquedaFilter.getIdAgente());
				jpql.append(" and et.idEtapa.idEtapa =  e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
			}//agente y responsable
			else if (etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					&& etapaTramiteBusquedaFilter.getIdActividad()!=null && etapaTramiteBusquedaFilter.getIdAgente()!=null && etapaTramiteBusquedaFilter.getIdResponsable() != null) {
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , PghCnfActUniOrganica cauo, MdiUnidadOrganica uo , NpsEtapa e , NpsSubetapa se ");
				jpql.append(" where et.estado = '1' and et.idConfTramite.idConfTramite =  ct.idConfTramite and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
				jpql.append(" and cauo.idActividad.idActividad = " + etapaTramiteBusquedaFilter.getIdAgente());
				jpql.append(" and et.idEtapa.idEtapa =  e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
				
			}//agente y tramite
			else if (etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					&& etapaTramiteBusquedaFilter.getIdActividad()!=null && etapaTramiteBusquedaFilter.getIdAgente()!=null && etapaTramiteBusquedaFilter.getIdTramite() != null) {
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , PghCnfActUniOrganica cauo, MdiUnidadOrganica uo ");
				jpql.append(" where  et.estado = '1' and et.idConfTramite.idConfTramite = ct.idConfTramite and ct.idTramite.idTramite = " + etapaTramiteBusquedaFilter.getIdTramite());
			    jpql.append(" and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica and cauo.idActividad.idActividad =   " + etapaTramiteBusquedaFilter.getIdAgente());
			}
			//actividad,responsable y tramite
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					&& etapaTramiteBusquedaFilter.getIdActividad()!=null && etapaTramiteBusquedaFilter.getIdTramite() != null 
					&& etapaTramiteBusquedaFilter.getIdResponsable() != null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiActividad act  ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite = ct.idConfTramite and ct.idTramite.idTramite = " + etapaTramiteBusquedaFilter.getIdTramite());
				jpql.append(" and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
				jpql.append(" and cauo.idActividad.idActividad = act.idActividad and act.idActividadPadre =  " + etapaTramiteBusquedaFilter.getIdActividad());
				jpql.append(" and et.idEtapa.idEtapa =  e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
			
			}//actividad y responsable
			else if (etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					&& etapaTramiteBusquedaFilter.getIdActividad()!=null && etapaTramiteBusquedaFilter.getIdResponsable() != null) {
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiActividad act  ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite =  ct.idConfTramite and  ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
				jpql.append(" and cauo.idActividad.idActividad = act.idActividad and act.idActividadPadre =  " + etapaTramiteBusquedaFilter.getIdActividad());
				jpql.append(" and et.idEtapa.idEtapa =  e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
				
			}//actividad y tramite
			else if (etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					&& etapaTramiteBusquedaFilter.getIdActividad()!=null && etapaTramiteBusquedaFilter.getIdTramite() != null) {
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiActividad act  ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite =  ct.idConfTramite and  ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
				jpql.append(" and ct.idTramite.idTramite = " + etapaTramiteBusquedaFilter.getIdTramite());
				jpql.append(" and cauo.idActividad.idActividad = act.idActividad and act.idActividadPadre =  " + etapaTramiteBusquedaFilter.getIdActividad());
			}
			// division responsable y tramite
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					&& etapaTramiteBusquedaFilter.getIdTramite() != null && etapaTramiteBusquedaFilter.getIdResponsable() != null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiActividad act  ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite = ct.idConfTramite and ct.idTramite.idTramite = " + etapaTramiteBusquedaFilter.getIdTramite());
				jpql.append(" and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
				jpql.append(" and  cauo.idUnidadOrganica.idUnidadOrganica =   " + etapaTramiteBusquedaFilter.getIdDivision());
				jpql.append(" and et.idEtapa.idEtapa =  e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
				
			}//division y responsable
			else if (etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					 && etapaTramiteBusquedaFilter.getIdResponsable() != null) {
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiActividad act  ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite =  ct.idConfTramite and  ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
				jpql.append(" and  cauo.idUnidadOrganica.idUnidadOrganica =   " + etapaTramiteBusquedaFilter.getIdDivision());
				jpql.append(" and et.idEtapa.idEtapa =  e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
				
			}//division y tramite
			else if (etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					 && etapaTramiteBusquedaFilter.getIdTramite() != null) {
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiActividad act  ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite =  ct.idConfTramite and  ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
				jpql.append(" and  cauo.idUnidadOrganica.idUnidadOrganica =  " + etapaTramiteBusquedaFilter.getIdDivision());
				jpql.append(" and ct.idTramite.idTramite = " + etapaTramiteBusquedaFilter.getIdTramite());
			}//gerencia tramite y responsable
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdTramite()!=null  && etapaTramiteBusquedaFilter.getIdResponsable()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiUnidadOrganica uo ");
				jpql.append("  where   et.estado = '1' and  et.idConfTramite.idConfTramite = ct.idConfTramite ");
			    jpql.append("  and  ct.idTramite.idTramite  =  t.idTramite and   t.idTramite = " + etapaTramiteBusquedaFilter.getIdTramite());
				jpql.append("  and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica and cauo.idUnidadOrganica.idUnidadOrganica = uo.idUnidadOrganica and uo.idUnidadOrganicaSuperior =   " + etapaTramiteBusquedaFilter.getIdGerencia());
				jpql.append(" and et.idEtapa.idEtapa =  e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
			}
			//gerencia y tramite
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdTramite()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiUnidadOrganica uo  ");
				jpql.append("  where   et.estado = '1' and  et.idConfTramite.idConfTramite = ct.idConfTramite ");
			    jpql.append("  and  ct.idTramite.idTramite  =  t.idTramite and   t.idTramite = " + etapaTramiteBusquedaFilter.getIdTramite());
				jpql.append("  and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica and cauo.idUnidadOrganica.idUnidadOrganica = uo.idUnidadOrganica and uo.idUnidadOrganicaSuperior =   " + etapaTramiteBusquedaFilter.getIdGerencia());
			
			}//gerencia y responsable
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdResponsable()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiActividad act , MdiUnidadOrganica uo  ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite = ct.idConfTramite and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
			    jpql.append(" and  cauo.idUnidadOrganica.idUnidadOrganica = uo.idUnidadOrganica and uo.idUnidadOrganicaSuperior =   " + etapaTramiteBusquedaFilter.getIdGerencia());
				jpql.append(" and et.idEtapa.idEtapa =  e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
			
			}//agente
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null 
					&& etapaTramiteBusquedaFilter.getIdActividad()!=null && etapaTramiteBusquedaFilter.getIdAgente()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , PghCnfActUniOrganica cauo, MdiUnidadOrganica uo ");
				jpql.append(" where et.idConfTramite.idConfTramite =  ct.idConfTramite and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
				jpql.append("  and cauo.idActividad.idActividad = " + etapaTramiteBusquedaFilter.getIdAgente());
			}//actividad
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null && 
					 etapaTramiteBusquedaFilter.getIdActividad()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , PghCnfActUniOrganica cauo , MdiActividad act ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite =  ct.idConfTramite and  ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica and ");
				jpql.append("	cauo.idActividad.idActividad = act.idActividad and act.idActividadPadre =  " + etapaTramiteBusquedaFilter.getIdActividad());
			}//division 
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , PghCnfActUniOrganica cauo, MdiUnidadOrganica uo ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite = ct.idConfTramite  and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
			    jpql.append(" and  cauo.idUnidadOrganica.idUnidadOrganica =   " + etapaTramiteBusquedaFilter.getIdDivision());
			}// division y tramite
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null && etapaTramiteBusquedaFilter.getIdDivision()!=null && etapaTramiteBusquedaFilter.getIdTramite()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , PghCnfActUniOrganica cauo, MdiUnidadOrganica uo ");
			    jpql.append(" where   et.estado = '1' and  et.idConfTramite.idConfTramite = ct.idConfTramite and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
			    jpql.append(" and ct.idConfTramite  = " + etapaTramiteBusquedaFilter.getIdTramite());
			    jpql.append(" and  cauo.idUnidadOrganica.idUnidadOrganica =   " + etapaTramiteBusquedaFilter.getIdDivision());
			}//gerencia
			else if(etapaTramiteBusquedaFilter.getIdGerencia()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t , NpsEtapa e , NpsSubetapa se, PghCnfActUniOrganica cauo , MdiActividad act , MdiUnidadOrganica uo  ");
				jpql.append(" where  et.estado = '1' and  et.idConfTramite.idConfTramite = ct.idConfTramite and ct.idCnfActUniOrganica.idCnfActUniOrganica = cauo.idCnfActUniOrganica ");
			    jpql.append(" and  cauo.idUnidadOrganica.idUnidadOrganica = uo.idUnidadOrganica and uo.idUnidadOrganicaSuperior =   " + etapaTramiteBusquedaFilter.getIdGerencia());
			}
			// solo tramite
			else if (etapaTramiteBusquedaFilter.getIdTramite() != null) {
				jpql.append(" select distinct et from NpsEtapaTramite et , NpsConfTramite ct , NpsTramite t  where ");
				jpql.append("  et.idConfTramite.idConfTramite = ct.idConfTramite and ct.idTramite.idTramite = t.idTramite ");
				jpql.append("  and t.idTramite =  " + etapaTramiteBusquedaFilter.getIdTramite());
			}//solo responsable
			else if(etapaTramiteBusquedaFilter.getIdResponsable()!=null){
				jpql.append(" select distinct et from NpsEtapaTramite et, NpsEtapa e , NpsSubetapa se ");
				jpql.append(" where  et.estado = '1' and  et.idEtapa.idEtapa = e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa  ");
				jpql.append(" and se.idResponsable.idMaestroColumna =  " + etapaTramiteBusquedaFilter.getIdResponsable());
			}else{
				jpql.append(" select distinct et from NpsEtapaTramite et where et.estado = '1' ");
				
			}
			
			String jquery = jpql.toString();
			query = crudDAO.getEm().createQuery(jquery);
			listado = query.getResultList(); 
			listadoDto = EtapaTramiteBuilder.toListEtapaTramiteDTO(listado);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listadoDto;
	}
        
    /* OSINE_SFS-1232 - lgarciar - Inicio */
    @Override
    public List<EtapaTramiteDTO> listarEtapaTramite(EtapaTramiteFilter filtro) {
        LOG.info("listarEtapaTramite");
        List<EtapaTramiteDTO> retorno=null;
        try {
            String queryString;
            StringBuilder jpql = new StringBuilder();
            
            //arma campos
            jpql.append("SELECT distinct new NpsEtapaTramite"
            + "("
            + "et.idEtapaTramite, nct.idConfTramite, nt.idTramite, nt.descripcion as descTramite, "
            + "ne.idEtapa, ne.descripcion as descEtapa, ne.plazo, pcauo.idCnfActUniOrganica, act.idActividad, act.nombre, " );
            if(filtro.getIdResponsable()!=null && !filtro.getIdResponsable().equals("")){
            	jpql.append("ns.idResponsable.idMaestroColumna , ");	
            }            
            jpql.append(" (select count(se.idSubetapa) from NpsSubetapa se where se.estado=1 and se.idEtapa.idEtapa=ns.idEtapa) as countSubEtapa "
            + ") "
            + "FROM NpsEtapaTramite et "  
            + "LEFT JOIN et.idConfTramite nct "
            + "LEFT JOIN nct.idTramite nt "
            + "LEFT JOIN et.idEtapa ne "
            + "LEFT JOIN ne.npsSubetapaList ns "
            + "LEFT JOIN ns.idResponsable mc "
            + "LEFT JOIN nct.idCnfActUniOrganica pcauo "
            + "LEFT JOIN pcauo.idUnidadOrganica muo "
            + "LEFT JOIN pcauo.idActividad act ");
            jpql.append("WHERE et.estado=1 "
//                + "and ns.estado=1 "
            );
            
            //filtros
            if(filtro.getIdGerencia()!=null && !filtro.getIdGerencia().equals("")){               
                jpql.append(" and muo.idUnidadOrganica in (Select distinct new MdiUnidadOrganica"
                        + "("
                        + " muo.idUnidadOrganica "
                        + ") "
                        + "FROM MdiUnidadOrganica muo "
                        + "LEFT JOIN muo.pghCnfActUniOrganicaList pcauo "
                        + "LEFT JOIN nct.idCnfActUniOrganica pcauo " 
                        + "WHERE muo.idUnidadOrganicaSuperior = :idGerencia and muo.estado=1 and pcauo.idCnfActUniOrganica is not null )");                 
            }
            
            if(filtro.getIdDivision()!=null && !filtro.getIdDivision().equals("")){               
                jpql.append(" and muo.idUnidadOrganica = :idDivision " );
            }
            
//            if(filtro.getIdSector()!=null && !filtro.getIdSector().equals("")){
//            
//            }
            
            if(filtro.getIdActividad()!=null && !filtro.getIdActividad().equals("")){                
                jpql.append(" and act.idActividadPadre = :idActividadPadre " );
            }
            
            if(filtro.getIdAgente()!=null && !filtro.getIdAgente().equals("")){                
                jpql.append(" and act.idActividad = :idActividad " );
            }
            
            if(filtro.getIdResponsable()!=null && !filtro.getIdResponsable().equals("")){                
                jpql.append(" and ns.idResponsable.idMaestroColumna = :idResponsable " );
            }
            
            if(filtro.getIdTramite()!=null && !filtro.getIdTramite().equals("")){               
                jpql.append(" and nct.idTramite.idTramite = :idTramite " );
            }
                    
            //Crear QUERY
            queryString = jpql.toString();
            LOG.info(queryString);
            Query query = this.crudDAO.getEm().createQuery(queryString);
            
            //settear parametros
            if(filtro.getIdGerencia()!=null && !filtro.getIdGerencia().equals("")){
                query.setParameter("idGerencia",filtro.getIdGerencia());
            }            
            if(filtro.getIdDivision()!=null && !filtro.getIdDivision().equals("")){
                query.setParameter("idDivision",filtro.getIdDivision());
            }            
//            if(filtro.getIdSector()!=null && !filtro.getIdSector().equals("")){

//            }            
            if(filtro.getIdActividad()!=null && !filtro.getIdActividad().equals("")){
                query.setParameter("idActividadPadre",filtro.getIdActividad());   
            }            
            if(filtro.getIdAgente()!=null && !filtro.getIdAgente().equals("")){
                query.setParameter("idActividad",filtro.getIdAgente());
            }            
            if(filtro.getIdResponsable()!=null && !filtro.getIdResponsable().equals("")){
                query.setParameter("idResponsable",filtro.getIdResponsable());
            }            
            if(filtro.getIdTramite()!=null && !filtro.getIdTramite().equals("")){
               query.setParameter("idTramite",filtro.getIdTramite()); 
            }
                         
            retorno= EtapaTramiteBuilder.toListaEtapaTramiteDTO(query.getResultList());
                    
        }catch(Exception e){
            LOG.error("error en listarEtapaTramite",e);
        }
        return retorno;
    }
    /* OSINE_SFS-1232 - lgarciar - Fin */

	@Override
	public boolean validaEtapaTramiteBySubEtapa(SubEtapaNpsDTO subEtapaNpsDTO) {
			Query query = null;
			List<NpsEtapaTramite> listado = new ArrayList<NpsEtapaTramite>();
			try {
				StringBuilder jpql = new StringBuilder();
				if(subEtapaNpsDTO!=null &&  subEtapaNpsDTO.getIdSubetapa()!=null){
					jpql.append(" select et from NpsEtapaTramite et, NpsEtapa e , NpsSubetapa se where et.idEtapa.idEtapa = e.idEtapa  and e.idEtapa = se.idEtapa.idEtapa and se.idSubetapa = " + subEtapaNpsDTO.getIdSubetapa());
					String jquery = jpql.toString();
					query = crudDAO.getEm().createQuery(jquery);
					listado = query.getResultList(); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(listado!=null && listado.size()>1){
				return true;
			}
		return false;
	}

}
