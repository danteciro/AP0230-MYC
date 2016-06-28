package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.DetalleNormaTecnicaDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.RubroOpcionFilter;
import gob.osinergmin.myc.domain.ui.TramiteActividadFilter;
import gob.osinergmin.myc.service.exception.ProcTramActividadException;
import gob.osinergmin.myc.service.exception.TramiteActividadException;

import java.util.List;

public interface DetalleNormaTecnicaDAO {

	List<RubroOpcionDTO> find(RubroOpcionFilter filtro);

	Long count(RubroOpcionFilter filtro);

	TramiteActividadDTO findById(TramiteActividadFilter filtro);
	
	DetalleNormaTecnicaDTO create(DetalleNormaTecnicaDTO detalleNormaTecnicaDTO, UsuarioDTO usuarioDTO) throws  TramiteActividadException;
	
	TramiteActividadDTO updateVerificado(
			TramiteActividadDTO tramiteActividadDTO, UsuarioDTO usuarioDTO)
			throws TramiteActividadException;

	RubroOpcionDTO changeState(RubroOpcionDTO tramiteActividadDTO,	UsuarioDTO user);

	List<DetalleNormaTecnicaDTO> findDetalleNormaTecnicaById(Long idDetalleBaseLegal);

}
