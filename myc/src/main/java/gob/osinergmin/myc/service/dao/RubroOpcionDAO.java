package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.RubroOpcionFilter;
import gob.osinergmin.myc.service.exception.TramiteActividadException;

import java.util.List;

public interface RubroOpcionDAO {

	List<RubroOpcionDTO> find(RubroOpcionFilter filtro);

	Long count(RubroOpcionFilter filtro);

	RubroOpcionDTO create(RubroOpcionDTO rubroOpcionDTO, UsuarioDTO usuarioDTO) throws  TramiteActividadException;
	
	RubroOpcionDTO changeState(RubroOpcionDTO tramiteActividadDTO,	UsuarioDTO user);

}
