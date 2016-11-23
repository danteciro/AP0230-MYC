package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import org.jfree.util.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.builder.ConfTramiteNpsBuilder;
import gob.osinergmin.myc.domain.dto.ConfTramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;
import gob.osinergmin.myc.service.business.ConfTramiteNpsServiceNeg;
import gob.osinergmin.myc.service.dao.ConfTramiteNpsDAO;

@Service("ConfTramiteServiceNeg")
public class ConfTramiteNpsServiceNegImpl implements ConfTramiteNpsServiceNeg {

	@Inject
	private ConfTramiteNpsDAO confTramiteDAO;
	
	@Override
	@Transactional(noRollbackFor = Exception.class)
	public ConfTramiteDTO create(ConfTramiteDTO npsConfTramiteDTO, UsuarioDTO usuarioDTO) {
		ConfTramiteDTO retorno = null;
		try {
			 npsConfTramiteDTO.setOrientacion(npsConfTramiteDTO.getOrientacion().toUpperCase());
			retorno = confTramiteDAO.create(npsConfTramiteDTO, usuarioDTO);
		} catch (Exception e) {
			Log.error("Eror en guardar ConfTramiteServiceNeg", e);
		}
		return retorno;
	}

	@Override
	@Transactional
	public ConfTramiteDTO update(ConfTramiteDTO npsConfTramiteDTO, UsuarioDTO usuarioDTO) {
		npsConfTramiteDTO.setOrientacion(npsConfTramiteDTO.getOrientacion().toUpperCase());
		confTramiteDAO.update(npsConfTramiteDTO, usuarioDTO);
		return npsConfTramiteDTO;
		
	}

	@Override
	@Transactional
	public List<ConfTramiteDTO> listar(ConfTramiteFilter confTramiteFilter) {
		return confTramiteDAO.listar(confTramiteFilter);
		
	}

	@Override
	@Transactional
	public ConfTramiteDTO findById(Long idConfTramite) {
		return confTramiteDAO.findById(idConfTramite);
	}

	@Override
	@Transactional
	public ConfTramiteDTO validaConfiguracion(ConfTramiteDTO confTramiteDTO) {
		ConfTramiteDTO retorno = null;
		try {
			retorno = confTramiteDAO.validaConfiguracion(confTramiteDTO);
		} catch (Exception e) {
			Log.error("Error al validar configuracion", e);
		}
		return retorno;
	}
	
}
