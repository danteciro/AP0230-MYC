package gob.osinergmin.myc.service.business;

import java.util.List;

import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.ObliTipiDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

public interface ObliTipiServiceNeg {
	ObliTipiDTO obtenerRelacion(Long idCriterio);

	List<ObliTipiDTO> obtenerRelaciones(ObliTipiDTO obliTipiDTO);
	List<ObliTipiDTO> obtenerRelacionesObligacion(ObliTipiDTO obliTipiDTO);
	ObliTipiDTO guardaRelacion(ObliTipiDTO relacion, UsuarioDTO usuarioDTO);

	void eliminarRelacion(ObliTipiDTO criterio, UsuarioDTO usuarioDTO);
}
