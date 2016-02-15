/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcedimientoFilter;
import gob.osinergmin.myc.service.exception.ProcedimientoException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ProcedimientoDAO {
    public List<ProcedimientoDTO> find(ProcedimientoFilter filtro) throws ProcedimientoException;
    public Long count(ProcedimientoFilter filtro) throws ProcedimientoException;
    public ProcedimientoDTO create(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoException;
    public ProcedimientoDTO changeEstado(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoException;
    public ProcedimientoDTO changeEstadoVerificado(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoException;
    public ProcedimientoDTO findById(ProcedimientoFilter filtro) throws ProcedimientoException;
    public ProcedimientoDTO updateVerificado(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoException;
}
