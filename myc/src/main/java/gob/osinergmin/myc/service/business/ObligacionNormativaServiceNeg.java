package gob.osinergmin.myc.service.business;

import java.util.List;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.TemaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.ObligacionFilter;
import gob.osinergmin.myc.service.exception.ObligacionException;

public interface ObligacionNormativaServiceNeg{
	public ObligacionNormativaDTO guardaObligacion(ObligacionNormativaDTO obligacionNormativaDTO,UsuarioDTO usuarioDTO);
	public ObligacionNormativaDTO eliminarObligacion(ObligacionNormativaDTO obligacionNormativaDTO, UsuarioDTO usuarioDTO);
	public List<ObligacionNormativaDTO> listarObligacion(ObligacionFilter filtro, int[] cuenta);
	public ObligacionNormativaDTO findUltimoRegistro();
	public List<MaestroColumnaDTO> listarTemas(int[] cuenta);
	public ObligacionNormativaDTO registrarRelaciones(Long idObligacion,Long idCriticidad,String listTema,UsuarioDTO usuarioDTO);
	public CnfObligacionDTO registrarConfiguracion(Long idObligacion,Long idRubro, Long idProceso, String oblgTipo,String codTrazabilidad, UsuarioDTO usuarioDTO) throws ObligacionException;
	public List<CnfObligacionDTO> findObligacionById(ObligacionFilter filtro, int[] auxiliar);
	public ObligacionNormativaDTO consultaObligacionById(Long idObligacion);
	public DetalleObligacionDTO consultaDetalleObligacionById(
			Long idObligacion);
	public List<TemaDTO> consultaTemaByObligacionId(Long idObligacion);
	public ObligacionNormativaDTO registrarRelaciones(
			ObligacionNormativaDTO registro, UsuarioDTO usuarioDTO);
	public ObligacionNormativaDTO eliminarRelaciones(
			ObligacionNormativaDTO registro, UsuarioDTO usuarioDTO);
	public ObligacionNormativaDTO updateObligacion(
			ObligacionNormativaDTO obligacionNormativaDTO, UsuarioDTO usuarioDTO);
}