package gob.osinergmin.myc.service.business.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.SubEtapaNpsFilter;
import gob.osinergmin.myc.service.business.SubEtapaNpsServiceNeg;
import gob.osinergmin.myc.service.dao.SubEtapaNpsDAO;

@Service("SubEtapaNpsServiceNeg")
public class SubEtapaNpsServiceNegImpl implements SubEtapaNpsServiceNeg{

	@Inject
	private SubEtapaNpsDAO subEtapaNpsDAO;
	
	
	@Override
	@Transactional
	public void create(SubEtapaNpsDTO subEtapaNpsDTO, UsuarioDTO usuarioDTO) {
		subEtapaNpsDTO.setDescripcion(subEtapaNpsDTO.getDescripcion().toUpperCase());
		subEtapaNpsDAO.create(subEtapaNpsDTO, usuarioDTO);
	}

	@Override
	@Transactional
	public SubEtapaNpsDTO update(SubEtapaNpsDTO subEtapaNpsDTO, UsuarioDTO usuarioDTO) {
		subEtapaNpsDTO.setDescripcion(subEtapaNpsDTO.getDescripcion().toUpperCase());
		subEtapaNpsDAO.update(subEtapaNpsDTO, usuarioDTO);
		return subEtapaNpsDTO;
	}

	@Override
	@Transactional
	public List<SubEtapaNpsDTO> listar(SubEtapaNpsFilter subEtapaNpsFilter) {
		List<SubEtapaNpsDTO> lista = subEtapaNpsDAO.listar(subEtapaNpsFilter);
		return lista;
	}
	/* OSINE_SFS-1232 - RSIS 6 - Inicio */
	@Override
	@Transactional
	public List<SubEtapaNpsDTO> listarSubEtapas(String listaEtapas) {
		List<SubEtapaNpsDTO> lista = subEtapaNpsDAO.listarSubEtapas(listaEtapas);
		return lista;
	}
	/* OSINE_SFS-1232 - RSIS 6 - Fin */

	@Override
	@Transactional
	public boolean delete(SubEtapaNpsDTO subEtapaNpsDTO, UsuarioDTO usuarioDTO) {
		return subEtapaNpsDAO.delete(subEtapaNpsDTO, usuarioDTO);
	}

	@Override
	@Transactional
	public SubEtapaNpsDTO findSubEtapaNpsDTO(SubEtapaNpsFilter subEtapaNpsFilter) {
		return subEtapaNpsDAO.findSubEtapaNpsDTO(subEtapaNpsFilter);
	}
	
}
