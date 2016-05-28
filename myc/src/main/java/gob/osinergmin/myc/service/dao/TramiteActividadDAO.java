package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.service.exception.ProcTramActividadException;
import gob.osinergmin.myc.service.exception.TramiteActividadException;

import java.util.List;

public interface TramiteActividadDAO {

	List<TramiteActividadDTO> find(TramiteActividadFilter filtro);

	Long count(TramiteActividadFilter filtro);

	TramiteActividadDTO findById(TramiteActividadFilter filtro);
	
	TramiteActividadDTO create(TramiteActividadDTO tramiteActividadDTO, UsuarioDTO usuarioDTO) throws  TramiteActividadException;
	
	TramiteActividadDTO updateVerificado(
			TramiteActividadDTO tramiteActividadDTO, UsuarioDTO usuarioDTO)
			throws TramiteActividadException;

	TramiteActividadDTO changeState(TramiteActividadDTO tramiteActividadDTO,
			UsuarioDTO user);

}
