/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.IncumplimientoDTO;
import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

import java.util.List;

/**
 *
 * @author rcoloradoa
 */
public interface IncumplimientoDAO {
    public IncumplimientoDTO create(IncumplimientoDTO incumplimientoDTO, UsuarioDTO usuarioDTO);
	public List<IncumplimientoDTO> findIncumplimiento(IncumplimientoDTO incumplimientoDTO);
	public List<IncumplimientoDTO> findIncumplimientos(IncumplimientoDTO incumplimientoDTO);
	public IncumplimientoDTO eliminarIncumplimiento(IncumplimientoDTO incumplimientoDTO,UsuarioDTO usuarioDTO);
}