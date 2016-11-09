package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NamedQuery;
import javax.persistence.Query;


import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import gob.osinergmin.myc.controller.MantenimientoConfiguracionSiguoController;
import gob.osinergmin.myc.domain.NpsConfTramite;
import gob.osinergmin.myc.domain.builder.ConfTramiteNpsBuilder;
import gob.osinergmin.myc.domain.dto.ConfTramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ConfTramiteNpsDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;

@Service("ConfTramiteDAO")
public class ConfTramiteNpsDAOImpl implements ConfTramiteNpsDAO {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ConfTramiteNpsDAOImpl.class);
	
	@Inject
	private CrudDAO crudDAO;
	
	@Override
	@Transactional(noRollbackFor = Exception.class)
	public ConfTramiteDTO create(ConfTramiteDTO confTramiteDTO, UsuarioDTO usuarioDTO) {
		ConfTramiteDTO retorno = new ConfTramiteDTO();
		try {
			NpsConfTramite npsConfTramite = ConfTramiteNpsBuilder.toNpsConfTramite(confTramiteDTO);
			npsConfTramite.setDatosAuditoria(usuarioDTO);
			retorno = ConfTramiteNpsBuilder.toNpsConfTramiteDTO(npsConfTramite);
			crudDAO.create(npsConfTramite);
				
		} catch (Exception e) {
			LOG.error(" en create ConfTramiteDTO", e.getMessage());
		}
		return retorno;
		
	}

	@Override
	public ConfTramiteDTO update(ConfTramiteDTO npsConfTramiteDTO, UsuarioDTO usuarioDTO) {
		try {
			 NpsConfTramite npsConfTramite = ConfTramiteNpsBuilder.toNpsConfTramite(npsConfTramiteDTO);
			 npsConfTramite.setDatosAuditoria(usuarioDTO);
			 crudDAO.update(npsConfTramite);
		} catch (Exception e) {
			LOG.error(" en update ", e.getMessage());
		} 
		return npsConfTramiteDTO;
	}

	@Override
	@Transactional
	public List<ConfTramiteDTO> listar(ConfTramiteFilter confTramiteFilter) {
			Query query = null;
			List<ConfTramiteDTO> listaDto = new ArrayList<ConfTramiteDTO>();
		try {
			query = crudDAO.getEm().createNamedQuery("NpsConfTramite.findAll");
			List<NpsConfTramite> lista = query.getResultList();
			listaDto = ConfTramiteNpsBuilder.toListConfTramiteDTO(lista);
			
		} catch (Exception e) {
			LOG.error("Error en listar ConfTramiteDTO ", e.getMessage());
		}
		return listaDto;
	}

	@Override
	public ConfTramiteDTO findById(Long idConfTramite) {
		ConfTramiteDTO  confTramiteDTO = new ConfTramiteDTO();
		try {
			NpsConfTramite npsConfTramite = crudDAO.find(idConfTramite, NpsConfTramite.class);
			confTramiteDTO = ConfTramiteNpsBuilder.toNpsConfTramiteDTO(npsConfTramite);
		} catch (Exception e) {
			LOG.error("Error en  findById ", e.getMessage());
		}
		return confTramiteDTO;
		
	}

	@Override
	public ConfTramiteDTO validaConfiguracion(ConfTramiteDTO confTramiteDTO) {
		ConfTramiteDTO retorno=null;
        try{
        	String queryString;
            StringBuilder jpql = new StringBuilder();
            //arma campos
            jpql.append("SELECT new NpsConfTramite(pot.idConfTramite) " +
            			"FROM NpsConfTramite pot ");  
            //arma condiciones
            jpql.append("WHERE pot.estado = 1 ");
            if(confTramiteDTO.getIdCnfActUniOrganica()!=null && confTramiteDTO.getIdCnfActUniOrganica().getIdCnfActUniOrganica()!=null){
            	jpql.append("and pot.idCnfActUniOrganica.idCnfActUniOrganica =:idCnfActUniOrganica ");
            }  
            if(confTramiteDTO.getIdTramite()!=null && confTramiteDTO.getIdTramite().getIdTramite()!=null){
            	jpql.append("and pot.idTramite.idTramite =:idTramite ");
            } 
            //Crear QUERY
            queryString = jpql.toString();
            LOG.info(queryString);
            Query query = this.crudDAO.getEm().createQuery(queryString);
            //arma filtro
            if(confTramiteDTO.getIdCnfActUniOrganica()!=null && confTramiteDTO.getIdCnfActUniOrganica().getIdCnfActUniOrganica()!=null){
            	query.setParameter("idCnfActUniOrganica",confTramiteDTO.getIdCnfActUniOrganica().getIdCnfActUniOrganica());
            }  
            if(confTramiteDTO.getIdTramite()!=null && confTramiteDTO.getIdTramite().getIdTramite()!=null){
            	query.setParameter("idTramite",confTramiteDTO.getIdTramite().getIdTramite());
            }
            
            List<NpsConfTramite> listado=query.getResultList();
            if(!CollectionUtils.isEmpty(listado)){
            	retorno = ConfTramiteNpsBuilder.toNpsConfTramiteDTO(listado.get(0));
            }
            
            
        }catch(Exception ex){
            LOG.error("error listarObligacionTipo",ex);
        }
        return retorno;
	}	
	
}
