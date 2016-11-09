package gob.osinergmin.myc.service.business;

import java.util.List;

import gob.osinergmin.myc.domain.dto.ConfTramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;

public interface ConfTramiteNpsServiceNeg {
	public ConfTramiteDTO create(ConfTramiteDTO npsConfTramiteDTO, UsuarioDTO usuarioDTO);
	public ConfTramiteDTO update(ConfTramiteDTO npsConfTramiteDTO, UsuarioDTO usuarioDTO);
	public List<ConfTramiteDTO> listar(ConfTramiteFilter confTramiteFilter);
	public ConfTramiteDTO findById(Long idConfTramite);
	public ConfTramiteDTO validaConfiguracion(ConfTramiteDTO confTramiteDTO);
}
