package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcesoObligacionTipoFilter;
import gob.osinergmin.myc.service.exception.ProcesoObligacionTipoException;

import java.util.List;

public interface ProcesoObligacionTipoDAO {

	List<ProcesoObligacionTipoDTO> obtenerProcesoObligacionTipo(ProcesoObligacionTipoFilter filtro);
	Long count(ProcesoObligacionTipoFilter filtro);
	ProcesoObligacionTipoDTO create(ProcesoObligacionTipoDTO procesoObligacionTipoDTO,UsuarioDTO usuarioDTO) throws ProcesoObligacionTipoException;
	ProcesoObligacionTipoDTO changeState(ProcesoObligacionTipoDTO procesoObligacionDTO, UsuarioDTO user) throws ProcesoObligacionTipoException;
        ProcesoObligacionTipoDTO edit(ProcesoObligacionTipoDTO procesoObligacionDTO, UsuarioDTO user) throws ProcesoObligacionTipoException;
}
