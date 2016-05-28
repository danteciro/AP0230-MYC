/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcTramActividadDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcTramActividadFilter;
import gob.osinergmin.myc.service.exception.ProcTramActividadException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ProcTramActividadDAO {
    public List<ActividadDTO> findActividadByFilter(ProcTramActividadFilter filtro) throws ProcTramActividadException;    
    public List<ProcTramActividadDTO> findByFilter(ProcTramActividadFilter filtro) throws ProcTramActividadException;    
    public ProcTramActividadDTO create(ProcTramActividadDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcTramActividadException;
    public ProcTramActividadDTO changeEstado(ProcTramActividadDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcTramActividadException;
}
