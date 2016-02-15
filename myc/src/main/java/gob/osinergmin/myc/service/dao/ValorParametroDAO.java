package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.ui.ParametroFilter;
import gob.osinergmin.myc.domain.ui.ValorParametroFilter;
import gob.osinergmin.myc.service.exception.ValorParametroException;

import java.util.List;

import javax.persistence.Query;

public interface ValorParametroDAO{
	public ValorParametroDTO createValor(ValorParametroDTO valorParametroDTO,UsuarioDTO userDTO) throws ValorParametroException;
    public List<ValorParametroDTO> findValorParametro(ValorParametroFilter filtro) throws ValorParametroException;    
    public Long countValor(ValorParametroFilter filtro) throws ValorParametroException;
	ValorParametroDTO editar(ValorParametroDTO parametroDTO, UsuarioDTO userDTO) throws ValorParametroException;
	ValorParametroDTO changeEstado(ValorParametroDTO parametroDTO,UsuarioDTO user) throws ValorParametroException;
	List<ValorParametroDTO> obtenerDependencias(ValorParametroFilter filtro);
	List<ValorParametroDTO> verificarOtrosValoresParametros(	ValorParametroFilter filtro);
	
}
