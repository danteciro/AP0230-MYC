package gob.osinergmin.myc.service.dao;

import java.util.List;

import gob.osinergmin.myc.domain.dto.ConfTramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;

public interface ConfTramiteNpsDAO {
	public ConfTramiteDTO create(ConfTramiteDTO npsConfTramiteDTO, UsuarioDTO usuarioDTO);
	public ConfTramiteDTO update(ConfTramiteDTO npsConfTramiteDTO, UsuarioDTO usuarioDTO);
	public List<ConfTramiteDTO> listar(ConfTramiteFilter confTramiteFilter); 
	public ConfTramiteDTO findById(Long idConfTramite);
	public ConfTramiteDTO validaConfiguracion(ConfTramiteDTO confTramiteDTO);
	
}
