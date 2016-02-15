/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.RequisitoFilter;
import gob.osinergmin.myc.service.exception.RequisitoException;

import java.io.File;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface RequisitoDAO {
    public List<RequisitoDTO> find(RequisitoFilter filtro) throws RequisitoException;    
    public Long count(RequisitoFilter filtro) throws RequisitoException;
    public List<RequisitoDTO> verificaRequisitoSimilar(RequisitoFilter filtro) throws RequisitoException;
    public RequisitoDTO create(RequisitoDTO registroDTO,UsuarioDTO usuarioDTO) throws RequisitoException;
    public RequisitoDTO edit(RequisitoDTO registroDTO, UsuarioDTO usuarioDTO) throws RequisitoException;
    public RequisitoDTO changeEstado(RequisitoDTO registroDTO, UsuarioDTO usuarioDTO) throws RequisitoException;
	public List<CnfRequProcedimientoDTO> obtenerDependencias(RequisitoFilter filtro);
	List<RequisitoDTO> validarRequisitoIdentico(RequisitoFilter filtro)
			throws RequisitoException;
}
