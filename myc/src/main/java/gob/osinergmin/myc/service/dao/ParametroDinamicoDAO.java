package gob.osinergmin.myc.service.dao;

import java.util.List;

import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ParametroFilter;
import gob.osinergmin.myc.service.exception.ParametroException;

public interface ParametroDinamicoDAO {

	public ParametroDinamicoDTO create(ParametroDinamicoDTO parametro, UsuarioDTO user) throws ParametroException;
    public List<ParametroDinamicoDTO> find(ParametroFilter filtro) throws ParametroException;    
    public Long count(ParametroFilter filtro) throws ParametroException;
    public ParametroDinamicoDTO changeEstado(ParametroDinamicoDTO parametro, UsuarioDTO user) throws ParametroException;
	public ParametroDinamicoDTO editar(ParametroDinamicoDTO parametroDTO,	UsuarioDTO userDTO) throws ParametroException;
	List<ParametroDinamicoDTO> obtenerDependencias(ParametroFilter filtro);
	List<ParametroDinamicoDTO> obtenerDependenciasValores(ParametroFilter filtro);
	List<ParametroDinamicoDTO> verificarOtrosParametros(ParametroFilter filtro);
	public long obtenerIdDinamico();
}
