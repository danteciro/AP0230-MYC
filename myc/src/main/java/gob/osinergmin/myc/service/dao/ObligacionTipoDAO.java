package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;
import gob.osinergmin.myc.service.exception.ObligacionTipoException;

import java.util.List;

public interface ObligacionTipoDAO {
	List<ObligacionTipoDTO> obtenerObligacionTipo(ObligacionTipoFilter filtro);
	Long count(ObligacionTipoFilter filtro);
	ObligacionTipoDTO create(ObligacionTipoDTO obligacionTipoDTO,UsuarioDTO userDTO) throws ObligacionTipoException ;
	ObligacionTipoDTO changeEstado(ObligacionTipoDTO obligacionTipoDTO,UsuarioDTO userDTO) throws ObligacionTipoException;
	ObligacionTipoDTO editar(ObligacionTipoDTO obligacionTipoDTO,UsuarioDTO userDTO) throws ObligacionTipoException ;
	List<ObligacionTipoDTO> listarObligacionTipo(ObligacionTipoFilter filtro);
	List<ObligacionTipoDTO> listaObligacionTipoSeleccionMuestral(String identificador);
}
