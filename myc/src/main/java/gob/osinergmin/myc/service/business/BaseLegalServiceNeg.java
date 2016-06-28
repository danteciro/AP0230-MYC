package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleNormaTecnicaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

import java.util.List;
import gob.osinergmin.myc.domain.ui.BaseLegalFilter;
/**
 *
 * @author gvillanueva
 */


public interface BaseLegalServiceNeg {
	
	public List<BaseLegalDTO> listarBaseLegal(BaseLegalFilter filtro, int[] cuenta);
	public List<BaseLegalDTO> listarBaseLegalPadre(BaseLegalFilter filtro, int[] cuenta);
	
	public BaseLegalDTO guardaBaseLegal(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO);
	public BaseLegalDTO editarBaseLegal(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO);
	public List<ObligacionBaseLegalDTO> obtenerDependencias(BaseLegalFilter filtro);
	public BaseLegalDTO eliminarBaseLegal(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO);
	public List<BaseLegalDTO> listarBaseLegalConcordancia(BaseLegalFilter filtro, int[] cuenta);
	public List<BaseLegalDTO> findBaseLegalbyCodigo(BaseLegalFilter filtro,int[] cuenta);
	
	public BaseLegalDTO findBaseLegalbyId(Long codigoEditarBaseLegal);
//	public BaseLegalDTO findUltimoRegistro();
	public DetalleBaseLegalDTO findDetalleBaseLegalbyId(Long codigoEditarBaseLegal);

	public List<ObligacionBaseLegalDTO> findObligacionByBaseLegal(
			BaseLegalFilter filtro, int[] auxiliar);

	public List<ObligacionBaseLegalDTO> findBaseLegalByObligacion(
			Long idObligacion, int[] auxiliar);

	public List<BaseLegalDTO> listarNormaLegalPadre();

	public BaseLegalDTO findBaseLegalPadrebyId(Long idBaseLegalPadre);
	public List<BaseLegalDTO> listarBaseLegalHijo(Long row_id);
	//lgarciar_05/11/2015_10:10_pm
	public List<BaseLegalDTO> listarBaseLegalToBaseLegal(BaseLegalFilter filtro, int[] auxiliar);
	public List<BaseLegalDTO> listarBaseLegalByObligacion(Long row_id);
	public List<DetalleNormaTecnicaDTO> findDetalleNormaTecnicaById(Long idDetalleBaseLegal);
	public List<BaseLegalDTO> verificarBaseLegalExistente(BaseLegalFilter filtro);
	
}
