package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.EtapaTramiteNpsDTO;
import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;
import gob.osinergmin.myc.domain.ui.EtapaTramiteBusquedaFilter;
import gob.osinergmin.myc.service.business.EtapaNpsServiceNeg;
import gob.osinergmin.myc.service.business.EtapaTramiteNpsServiceNeg;
import gob.osinergmin.myc.service.dao.ConfTramiteNpsDAO;
import gob.osinergmin.myc.service.dao.EtapaTramiteDAO;

@Service("EtapaTramiteServiceNeg")
public class EtapaTramiteNpsServiceNegImpl implements EtapaTramiteNpsServiceNeg {

	@Inject
	private EtapaTramiteDAO etapaTramiteDAO;

	@Override
	@Transactional
	public EtapaTramiteNpsDTO create(EtapaTramiteNpsDTO etapaTramiteNpsDTO,UsuarioDTO usuarioDTO) {
		etapaTramiteNpsDTO = etapaTramiteDAO.create(etapaTramiteNpsDTO,usuarioDTO);
		return etapaTramiteNpsDTO;
	}

	@Override
	@Transactional
	public EtapaTramiteNpsDTO update(EtapaTramiteNpsDTO etapaTramiteNpsDTO,UsuarioDTO usuarioDTO) {
		etapaTramiteNpsDTO = etapaTramiteDAO.update(etapaTramiteNpsDTO,usuarioDTO);
		return etapaTramiteNpsDTO;
	}

	@Override
	@Transactional
	public List<EtapaTramiteNpsDTO> listarEtapaTramite(
			EtapaNpsFilter etapaNpsFilter, ConfTramiteFilter confTramiteFilter) {
		List<EtapaTramiteNpsDTO> lista = etapaTramiteDAO.listarEtapaTramite(
				etapaNpsFilter, confTramiteFilter);
		return lista;
	}

	@Override
	@Transactional
	public boolean delete(EtapaTramiteNpsDTO etapaTramiteNpsDTO , UsuarioDTO usuarioDTO) {
		etapaTramiteDAO.delete(etapaTramiteNpsDTO, usuarioDTO); 
		return true;
	}

	@Override
	@Transactional
	public EtapaTramiteNpsDTO findByIdEtapaTramite(Long idEtapaTramite) {
		EtapaTramiteNpsDTO etapaTramiteNpsDTO = etapaTramiteDAO
				.findByIdEtapaTramite(idEtapaTramite);
		return etapaTramiteNpsDTO;
	}

	@Override
	@Transactional(readOnly=true)
	public List<EtapaTramiteNpsDTO> buscarEtapaTramite(
			EtapaTramiteBusquedaFilter etapaTramiteBusquedaFilter) {
		List<EtapaTramiteNpsDTO> etapaTramiteNpsDTO = etapaTramiteDAO.buscarEtapaTramite(etapaTramiteBusquedaFilter);
		return etapaTramiteNpsDTO;
	}

	@Override
	public boolean validaEtapaTramiteBySubEtapa(SubEtapaNpsDTO subEtapaNpsDTO) {
		return etapaTramiteDAO.validaEtapaTramiteBySubEtapa(subEtapaNpsDTO);
	}

}
