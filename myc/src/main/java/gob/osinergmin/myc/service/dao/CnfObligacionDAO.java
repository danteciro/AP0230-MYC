package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;
import gob.osinergmin.myc.service.exception.ObligacionException;

import java.util.List;

public interface CnfObligacionDAO {

	public List<ProcesoDTO> findProceso(Long idActividad) throws ObligacionException;

	public List<ObligacionTipoDTO> findObligacionTipo(Long idActividad,Long idTipoProceso);

	public CnfObligacionDTO changeEstado(Long idConfObligacion,String codTrazabilidad,UsuarioDTO usuarioDTO);
	
	public List<ObligacionTipoDTO> findObligacionTipoConfig(ObligacionTipoFilter filtro);
}
