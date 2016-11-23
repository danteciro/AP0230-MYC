package gob.osinergmin.myc.service.business;

import java.util.List;
import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;

public interface EtapaNpsServiceNeg {
	public EtapaNpsDTO create(EtapaNpsDTO etapaNpsDTO, UsuarioDTO usuarioDTO);
	public List<EtapaNpsDTO> listarByConfTramite(EtapaNpsFilter etapaNpsFilter);
	public EtapaNpsDTO update(EtapaNpsDTO etapaNpsDTO, UsuarioDTO usuarioDTO); 
	public List<EtapaNpsDTO> listarEtapasConfiguradas(Long idConfTramite);
	public List<EtapaNpsDTO> listarEtapasIds(String idEtapas);
	public List<EtapaNpsDTO> listarEtapas(EtapaNpsFilter etapaNpsFilter);
	public EtapaNpsDTO findByIdEtapa(Long idEtapa);
	public List<EtapaNpsDTO> validaEtapa(EtapaNpsDTO etapaNpsDTO);
}
