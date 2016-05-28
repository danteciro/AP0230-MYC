/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcedimientoTramiteFilter;
import gob.osinergmin.myc.service.exception.ProcedimientoTramiteException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ProcedimientoTramiteDAO {
    public List<ProcedimientoTramiteDTO> find(ProcedimientoTramiteFilter filtro) throws ProcedimientoTramiteException;
    public ProcedimientoTramiteDTO create(ProcedimientoTramiteDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoTramiteException;
    public List<ProcedimientoTramiteDTO> updateVerificado(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoTramiteException;
    public ProcedimientoTramiteDTO changeEstado(ProcedimientoTramiteDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoTramiteException;
}
