package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.OrgaActiModuSeccDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.OrgaActiModuSeccionFilter;
import gob.osinergmin.myc.service.business.OrgaActiModuSeccServiceNeg;
import gob.osinergmin.myc.service.dao.OrgaActiModuSeccDAO;
import gob.osinergmin.myc.util.Constantes;

@Service("OrgaActiModuSeccServiceNeg")
public class OrgaActiModuSeccionServiceNegImpl implements OrgaActiModuSeccServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(OrgaActiModuSeccionServiceNegImpl.class);
	
	@Inject
	OrgaActiModuSeccDAO orgaActiModuSeccDAO;
	
	@Override
	public List<OrgaActiModuSeccDTO> listarOrgaActiModuSeccion(OrgaActiModuSeccionFilter filtro, int[] cuenta) {
		List<OrgaActiModuSeccDTO> retorno=null;
        try{
        	 filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO); 
        	 cuenta[0] = orgaActiModuSeccDAO.count(filtro).intValue();
	         if (cuenta[0] > 0) {
	        	 retorno = orgaActiModuSeccDAO.obtenerOrgaActiModuSeccion(filtro);
	             LOG.info("cuenta -size: "+retorno.size());
	         }            
         
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return retorno;
	}

	@Override
	@Transactional
	public OrgaActiModuSeccDTO guardaConfiguracion(OrgaActiModuSeccDTO orgaActiModuSeccDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Registro Configuracion ServiceNegImpl");
		OrgaActiModuSeccDTO registro=null;
		try{
			registro=orgaActiModuSeccDAO.create(orgaActiModuSeccDTO,usuarioDTO);

		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}

	@Override
	@Transactional
	public OrgaActiModuSeccDTO eliminarConfiguracion(OrgaActiModuSeccDTO orgaActiModuSeccDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Eliminar Configuracion ServiceNegImpl");
		OrgaActiModuSeccDTO registro=null;
		try{
			registro=orgaActiModuSeccDAO.delete(orgaActiModuSeccDTO,usuarioDTO);

		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}

	@Override
	public OrgaActiModuSeccDTO find(Long idOrgaActiModuSecc) {
		LOG.info("Buscar Configuracion ServiceNegImpl");
		OrgaActiModuSeccDTO registro=null;
		try{
			registro=orgaActiModuSeccDAO.find(idOrgaActiModuSecc);

		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}

	@Override
	@Transactional
	public OrgaActiModuSeccDTO actualizaConfiguracion(OrgaActiModuSeccDTO orgaActiModuSeccDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Actualiza Configuracion ServiceNegImpl");
		OrgaActiModuSeccDTO registro=null;
		try{
			registro=orgaActiModuSeccDAO.update(orgaActiModuSeccDTO,usuarioDTO);

		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}

	@Override
	public List<OrgaActiModuSeccDTO> validaConfiguracion(OrgaActiModuSeccDTO orgaActiModuSeccDTO) {
		LOG.info("Se valida configuracion");
		List<OrgaActiModuSeccDTO> registro=null;
		try{
			registro=orgaActiModuSeccDAO.valida(orgaActiModuSeccDTO);

		}catch(Exception ex){
			LOG.error("",ex);
		}
		return registro;
	}

}
