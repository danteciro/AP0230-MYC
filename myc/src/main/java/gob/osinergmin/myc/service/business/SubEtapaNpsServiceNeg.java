package gob.osinergmin.myc.service.business;

import java.util.List;

import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.SubEtapaNpsFilter;

public interface SubEtapaNpsServiceNeg {
	public void create(SubEtapaNpsDTO subEtapaNpsDTO, UsuarioDTO usuarioDTO);
	public SubEtapaNpsDTO  update(SubEtapaNpsDTO subEtapaNpsDTO, UsuarioDTO usuarioDTO);
	public List<SubEtapaNpsDTO> listar(	SubEtapaNpsFilter subEtapaNpsFilter);
	/* OSINE_SFS-1232 - RSIS 6 - Inicio */
	public List<SubEtapaNpsDTO> listarSubEtapas( String  listaEtapas);
	/* OSINE_SFS-1232 - RSIS 6 - Fin */
	public boolean delete(SubEtapaNpsDTO subEtapaNpsDTO, UsuarioDTO usuarioDTO);
	
	public SubEtapaNpsDTO findSubEtapaNpsDTO(SubEtapaNpsFilter subEtapaNpsFilter);
}
