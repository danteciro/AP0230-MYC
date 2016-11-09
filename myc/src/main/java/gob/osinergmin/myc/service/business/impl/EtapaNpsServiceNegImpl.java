package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaFilter;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;
import gob.osinergmin.myc.service.business.EtapaNpsServiceNeg;
import gob.osinergmin.myc.service.dao.EtapaNpsDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("EtapaNpsServiceNeg")
public class EtapaNpsServiceNegImpl implements EtapaNpsServiceNeg{

	@Inject
	private EtapaNpsDAO etapaNpsDAO;
	
	@Override
	@Transactional
	public EtapaNpsDTO create(EtapaNpsDTO etapaNpsDTO, UsuarioDTO usuarioDTO) {
		etapaNpsDTO.setDescripcion(etapaNpsDTO.getDescripcion().toUpperCase());
		etapaNpsDAO.create(etapaNpsDTO, usuarioDTO);
		return etapaNpsDTO;
	}

	@Override
	@Transactional
	public List<EtapaNpsDTO> listarByConfTramite(EtapaNpsFilter etapaNpsFilter) {
		List<EtapaNpsDTO> listar = etapaNpsDAO.listarEtapaByConfTramite(etapaNpsFilter);
		return listar;
	}
	
	@Override
	@Transactional
	public List<EtapaNpsDTO> listarEtapas(EtapaNpsFilter etapaNpsFilter) {
		List<EtapaNpsDTO> listar = etapaNpsDAO.listarEtapas(etapaNpsFilter);
		return listar;
	}

	@Override
	public EtapaNpsDTO update(EtapaNpsDTO etapaNpsDTO, UsuarioDTO usuarioDTO) {
		etapaNpsDTO.setDescripcion(etapaNpsDTO.getDescripcion().toUpperCase());
		etapaNpsDAO.update(etapaNpsDTO, usuarioDTO);
		return etapaNpsDTO;
	}

	@Override
	@Transactional
	public List<EtapaNpsDTO> listarEtapasConfiguradas(Long idConfTramite) {
		List<EtapaNpsDTO> listar = etapaNpsDAO.listarEtapasConfiguradas(idConfTramite);
		return listar;
	}
	
	@Override
	@Transactional
	public List<EtapaNpsDTO> listarEtapasIds(String idEtapas) {
		List<EtapaNpsDTO> listar = etapaNpsDAO.listarEtapasIds(idEtapas);
		return listar;
	}

	@Override
	public EtapaNpsDTO findByIdEtapa(Long idEtapa){
		return etapaNpsDAO.findByIdEtapa(idEtapa);
	}
	
}
