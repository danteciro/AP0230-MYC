package gob.osinergmin.myc.service.dao;

import java.util.List;

import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.ObliTipiDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

public interface ObliTipiCriterioDAO {

	ObliTipiDTO crear(ObliTipiDTO obliCriteTipi, UsuarioDTO usuarioDTO);

	ObliTipiDTO obtenerCriterioById(Long idCriterio);
	//Implementacion_lgarcia
	Long findByCriterio(CriterioDTO criterioDTO);

	ObliTipiDTO changeEstadoRelacion(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO);

	List<ObliTipiDTO> obtenerRelaciones(ObliTipiDTO obliTipiDTO);

	ObliTipiDTO crearRelacion(ObliTipiDTO relacion, UsuarioDTO usuarioDTO);

	void eliminarRelacion(ObliTipiDTO relacion, UsuarioDTO usuarioDTO);

	ObliTipiDTO update(ObliTipiDTO obliCriteTipi, UsuarioDTO usuarioDTO);
	
	public ObliTipiDTO findObliTipi(Long idCriterio);

	ObliTipiDTO findObliTipiCriterio(ObliTipiDTO obliCritetipiAntiguo);
// 05-11-2015	
	public List<ObliTipiDTO> obtenerRelacionesToObligacion(ObliTipiDTO obliTipiDTO);
	public List<ObliTipiDTO> obtenerRelacionesCompletasToObligacion(ObliTipiDTO obliTipiDTO);
//
	
}
