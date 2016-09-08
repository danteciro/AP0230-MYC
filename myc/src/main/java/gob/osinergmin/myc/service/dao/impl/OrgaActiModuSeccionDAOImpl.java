package gob.osinergmin.myc.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.MdiUnidadOrganica;
import gob.osinergmin.myc.domain.PghModulo;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghOrgaActiModuSecc;
import gob.osinergmin.myc.domain.PghSeccion;
import gob.osinergmin.myc.domain.builder.ObligacionNormativaBuilder;
import gob.osinergmin.myc.domain.builder.OrgaActiModuSeccBuilder;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.OrgaActiModuSeccDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.OrgaActiModuSeccionFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.OrgaActiModuSeccDAO;
import gob.osinergmin.myc.util.Constantes;

@Service("OrgaActiModuSeccDAO")
public class OrgaActiModuSeccionDAOImpl implements OrgaActiModuSeccDAO{
	private static final Logger LOG = LoggerFactory.getLogger(OrgaActiModuSeccDAO.class);
    @Inject
    private CrudDAO crud;

	@Override
	public Long count(OrgaActiModuSeccionFilter filtro) {
		Query query = getFindQuery(filtro);
		 List<PghOrgaActiModuSecc> lista= query.getResultList();
		 if(lista == null || lista.size() == 0)
			 return 0L;
		 
	     return new Long(lista.size());
	}

	private Query getFindQuery(OrgaActiModuSeccionFilter filtro) {
		 Query query=null;
         try{
        	 
           	StringBuilder jpql = new StringBuilder();
           	//
           	jpql.append(" select ams.id_orga_acti_modu_secc,uos.id_unidad_organica as ID_ORGANICA_SUPERIOR,uos.descripcion as DESCRIPCION_SUPERIOR,ams.id_unidad_organica as ID_ORGANICA, uo.descripcion as DESCRIPCION_UNIDAD," +
           				" ma.id_actividad,ma.nombre,ams.orden_componente, mo.id_modulo,mo.descripcion as MODULO_DESCRIPCION,ams.orden_seccion,se.id_seccion,se.descripcion as SECCION_DESCRIPCION");
           	jpql.append(" from pgh_orga_acti_modu_secc ams ");
           	jpql.append(" left join mdi_unidad_organica uo on ams.id_unidad_organica = uo.id_unidad_organica ");
           	jpql.append(" left join mdi_unidad_organica uos on uo.id_unidad_organica_superior = uos.id_unidad_organica ");
           	jpql.append(" left join mdi_actividad ma on ams.id_actividad = ma.id_actividad ");
           	jpql.append(" left join pgh_modulo mo on ams.id_modulo = mo.id_modulo ");
           	jpql.append(" left join pgh_seccion se on ams.id_seccion = se.id_seccion ");
           	jpql.append(" where ams.estado = '1' ");
           	
           	if(!StringUtil.isEmptyNum(filtro.getIdUnidadOrganicaSuperior().getIdUnidadOrganica())){
           		jpql.append(" and uos.id_unidad_organica =:idUnidadOrganicaSuperior ");
           	}
           	if(!StringUtil.isEmptyNum(filtro.getIdUnidadOrganica().getIdUnidadOrganica())){
           		jpql.append(" and ams.id_unidad_organica =:idUnidadOrganica ");
           	}           	
           	if(!StringUtil.isEmptyNum(filtro.getIdActividad().getIdActividad())){
           		jpql.append( " and ams.id_actividad =:idActividad");
           	}
           	if(!StringUtil.isEmptyNum(filtro.getIdModulo().getIdModulo())){
           		jpql.append(" and ams.id_modulo =:idModulo");	
           	}
            //order by 
            jpql.append(" order by uos.id_unidad_organica,uo.id_unidad_organica,ma.id_actividad,ams.orden_componente,ams.orden_seccion ");	
            query = crud.getEm().createNativeQuery(jpql.toString());
          	 
             
            if(!StringUtil.isEmptyNum(filtro.getIdUnidadOrganicaSuperior().getIdUnidadOrganica())){
            	query.setParameter("idUnidadOrganicaSuperior", filtro.getIdUnidadOrganicaSuperior().getIdUnidadOrganica());
            }
            if(!StringUtil.isEmptyNum(filtro.getIdUnidadOrganica().getIdUnidadOrganica())){
            	query.setParameter("idUnidadOrganica", filtro.getIdUnidadOrganica().getIdUnidadOrganica());
            }            
            if(!StringUtil.isEmptyNum(filtro.getIdActividad().getIdActividad())){
            	query.setParameter("idActividad", filtro.getIdActividad().getIdActividad());
           	}
            if(!StringUtil.isEmptyNum(filtro.getIdModulo().getIdModulo())){
            	query.setParameter("idModulo", filtro.getIdModulo().getIdModulo());
           	}
             
         }catch(Exception ex){
        	  LOG.error("Error getFindQuery: "+ex.getMessage());
         }
		return query;
	}

	@Override
	public List<OrgaActiModuSeccDTO> obtenerOrgaActiModuSeccion(OrgaActiModuSeccionFilter filtro) {
		List<OrgaActiModuSeccDTO> listado=null;
		Query query = getFindQuery(filtro);
        
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = OrgaActiModuSeccBuilder.toListOrgaActiModuSeccDto(query.getResultList());

        return listado;
	}

	@Override
	@Transactional
	public OrgaActiModuSeccDTO create(OrgaActiModuSeccDTO orgaActiModuSeccDTO,UsuarioDTO usuarioDTO) {
		LOG.info("Registro Configuracion DAO Impl");
		OrgaActiModuSeccDTO retorno=null;
		try{

			PghOrgaActiModuSecc configuracion=OrgaActiModuSeccBuilder.getOrgaActiModuSecc(orgaActiModuSeccDTO);
			configuracion.setDatosAuditoria(usuarioDTO);
			crud.create(configuracion);
			
			retorno=OrgaActiModuSeccBuilder.toOrgaActiModuSeccDto(configuracion);
			
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return retorno;
	}

	@Override
	@Transactional
	public OrgaActiModuSeccDTO delete(OrgaActiModuSeccDTO orgaActiModuSeccDTO,UsuarioDTO usuarioDTO) {
		OrgaActiModuSeccDTO retorno =null;
		try{
			PghOrgaActiModuSecc oblgAct = crud.find(orgaActiModuSeccDTO.getIdOrgaActiModuSecc(), PghOrgaActiModuSecc.class);
			oblgAct.setDatosAuditoria(usuarioDTO);
			oblgAct.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
			crud.update(oblgAct);
			retorno=OrgaActiModuSeccBuilder.toOrgaActiModuSeccDto(oblgAct);	
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return retorno;
	}

	@Override
	public OrgaActiModuSeccDTO find(Long idOrgaActiModuSecc) {
		OrgaActiModuSeccDTO retorno =null;
		Query query=null;
		StringBuilder jpql = new StringBuilder();
       	//
       	jpql.append(" select ams.id_orga_acti_modu_secc,uos.id_unidad_organica as ID_ORGANICA_SUPERIOR,uos.descripcion as DESCRIPCION_SUPERIOR,ams.id_unidad_organica as ID_ORGANICA, uo.descripcion as DESCRIPCION_UNIDAD," +
       				" ma.id_actividad,ma.nombre,ams.orden_componente, mo.id_modulo,mo.descripcion as MODULO_DESCRIPCION,ams.orden_seccion,se.id_seccion,se.descripcion as SECCION_DESCRIPCION");
       	jpql.append(" from pgh_orga_acti_modu_secc ams ");
       	jpql.append(" left join mdi_unidad_organica uo on ams.id_unidad_organica = uo.id_unidad_organica ");
       	jpql.append(" left join mdi_unidad_organica uos on uo.id_unidad_organica_superior = uos.id_unidad_organica ");
       	jpql.append(" left join mdi_actividad ma on ams.id_actividad = ma.id_actividad ");
       	jpql.append(" left join pgh_modulo mo on ams.id_modulo = mo.id_modulo ");
       	jpql.append(" left join pgh_seccion se on ams.id_seccion = se.id_seccion ");
       	jpql.append(" where ams.estado = '1' ");
       	
       	if(!StringUtil.isEmptyNum(idOrgaActiModuSecc)){
       		jpql.append(" and ams.id_orga_acti_modu_secc =:idOrgaActiModuSecc ");
       	}
        //order by 
        jpql.append(" order by uos.id_unidad_organica,uo.id_unidad_organica,ma.id_actividad,ams.orden_componente,ams.orden_seccion ");	
        query = crud.getEm().createNativeQuery(jpql.toString());        
        if(!StringUtil.isEmptyNum(idOrgaActiModuSecc)){
        	query.setParameter("idOrgaActiModuSecc", idOrgaActiModuSecc);
        }        
        retorno = OrgaActiModuSeccBuilder.toListOrgaActiModuSeccDto(query.getResultList()).get(0);

        return retorno;
	}

	@Override
	@Transactional
	public OrgaActiModuSeccDTO update(OrgaActiModuSeccDTO orgaActiModuSeccDTO,UsuarioDTO usuarioDTO) {
		OrgaActiModuSeccDTO retorno =null;
		try{
			PghOrgaActiModuSecc oblgAct = crud.find(orgaActiModuSeccDTO.getIdOrgaActiModuSecc(), PghOrgaActiModuSecc.class);
			//
			MdiUnidadOrganica idUnidadOrganica = new MdiUnidadOrganica();
			idUnidadOrganica.setIdUnidadOrganica(orgaActiModuSeccDTO.getIdUnidadOrganica().getIdUnidadOrganica());
			oblgAct.setIdUnidadOrganica(idUnidadOrganica);
			MdiActividad idActividad = new MdiActividad();
			idActividad.setIdActividad(orgaActiModuSeccDTO.getIdActividad().getIdActividad());
			oblgAct.setIdActividad(idActividad);
			PghModulo idModulo = new PghModulo();
			idModulo.setIdModulo(orgaActiModuSeccDTO.getIdModulo().getIdModulo());
			oblgAct.setIdModulo(idModulo);
			PghSeccion idSeccion = new PghSeccion();
			idSeccion.setIdSeccion(orgaActiModuSeccDTO.getIdSeccion().getIdSeccion());
			oblgAct.setIdSeccion(idSeccion);
			oblgAct.setOrdenComponente(orgaActiModuSeccDTO.getOrdenComponente());
			oblgAct.setOrdenSeccion(orgaActiModuSeccDTO.getOrdenSeccion());
			//
			oblgAct.setDatosAuditoria(usuarioDTO);
			crud.update(oblgAct);
			retorno=OrgaActiModuSeccBuilder.toOrgaActiModuSeccDto(oblgAct);	
		}catch(Exception ex){
			LOG.error("",ex);
		}
		return retorno;
	}	
	

}
