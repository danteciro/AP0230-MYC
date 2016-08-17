package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.DetalleBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.BaseLegalFilter;
import java.util.List;
/**
 * 
 * @author gvillanueva
 *
 */
public interface BaseLegalDAO{
	public List<BaseLegalDTO> find(BaseLegalFilter filtro);
	public List<BaseLegalDTO> findPadre(BaseLegalFilter filtro);
	public Long count(BaseLegalFilter filtro);
	public Long countPadre(BaseLegalFilter filtro);
	public BaseLegalDTO create(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO);
	public BaseLegalDTO update(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO);
	public List<ObligacionBaseLegalDTO> obtenerDependencias(BaseLegalFilter filtro);
	public BaseLegalDTO changeEstado(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO);
	public List<BaseLegalDTO>  findBaseLegalbyCodigo(BaseLegalFilter filtro);
//	public BaseLegalDTO findUltimoRegistro();
	public Long contador(BaseLegalFilter filtro);
	public Long contadorbyId(Long codigoEditarBaseLegal);
	public BaseLegalDTO findBaseLegalbyId(Long codigoEditarBaseLegal);
	public Long contadorDetallebyId(Long codigoEditarBaseLegal);
	public DetalleBaseLegalDTO findDetalleBaseLegalbyId(Long codigoEditarBaseLegal);
	public Long countObligacion(BaseLegalFilter filtro);
	public List<ObligacionBaseLegalDTO> findObligacionByBaseLegal(
			BaseLegalFilter filtro);
	public List<ObligacionBaseLegalDTO> updateListadoObligaciones(
			BaseLegalDTO baseLegalDTO, UsuarioDTO usuarioDTO);
	public List<ObligacionBaseLegalDTO> cambiarEstadoListadoObligaciones(
			BaseLegalDTO baseLegalDTO, UsuarioDTO usuarioDTO);
	public Long countObligacionBaseLegal(Long idObligacion);
	public List<ObligacionBaseLegalDTO> findBaseLegalByObligacion(
			Long idObligacion);
	public List<BaseLegalDTO> listarNormaLegalPadre();
	public List<BaseLegalDTO> listarBaseLegalHijo(Long row_id);
    // 06-11-2015
	public Long countToBase(BaseLegalFilter filtro);
	public List<BaseLegalDTO> findToBase(BaseLegalFilter filtro);
	public List<BaseLegalDTO> listarBaseLegalByObligacion(Long row_id);
	public String obtenerCodigoBaseLegal(String flagPadre);
	public List<BaseLegalDTO> findNormaLegalByDivision(BaseLegalFilter filtro);
	
	
}