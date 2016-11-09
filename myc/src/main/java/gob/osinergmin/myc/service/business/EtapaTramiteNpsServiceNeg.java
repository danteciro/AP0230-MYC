package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.EtapaTramiteNpsDTO;
import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;
import gob.osinergmin.myc.domain.ui.EtapaTramiteBusquedaFilter;
import gob.osinergmin.myc.service.dao.ConfTramiteNpsDAO;

import java.util.List;

public interface EtapaTramiteNpsServiceNeg {

	public EtapaTramiteNpsDTO create(EtapaTramiteNpsDTO etapaTramiteNpsDTO, UsuarioDTO usuarioDTO);
	public EtapaTramiteNpsDTO update(EtapaTramiteNpsDTO etapaTramiteNpsDTO, UsuarioDTO usuarioDTO);
	public List<EtapaTramiteNpsDTO> listarEtapaTramite(EtapaNpsFilter etapaNpsFilter, ConfTramiteFilter confTramiteFilter);
	public boolean delete(EtapaTramiteNpsDTO etapaTramiteNpsDTO , UsuarioDTO usuarioDTO);
	public EtapaTramiteNpsDTO findByIdEtapaTramite(Long idEtapaTramite);
	public List<EtapaTramiteNpsDTO> buscarEtapaTramite(EtapaTramiteBusquedaFilter etapaTramiteBusquedaFilter);
	public boolean validaEtapaTramiteBySubEtapa(SubEtapaNpsDTO subEtapaNpsDTO);
}
