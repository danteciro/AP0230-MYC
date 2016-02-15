package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.exception.ObligacionException;

import java.util.List;

public interface CnfObligServiceNeg {

	public List<ProcesoDTO> listarProceso(Long idActividad,int[] cuenta) throws ObligacionException;
	public List<ObligacionTipoDTO> listarObligacionTipo(Long idActividad,Long idTipoProceso,int[] cuenta);
	public CnfObligacionDTO eliminarConfiguracion(Long idConfObligacion,String codTrazabilidad,UsuarioDTO usuarioDTO);
	public CnfObligacionDTO eliminarBaseLegalAsociada(Long idAsocObligacion,UsuarioDTO usuarioDTO);
}
