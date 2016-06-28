/**
 * Resumen.
 * Objeto            : IncumplimientoServiceNeg.java
 * Descripción       : Bean que contiene los atributos del expediente documento no cargado.
 * Fecha de Creación : 15/06/2012
 * PR de Creación    : OSINE_119
 * Autor             : Roy Colorado
 * ---------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo   Fecha     Nombre                Descripción
 * ----------------------------------------------------------------------------------------
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.IncumplimientoDTO;
import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.InfraccionFilter;

import java.util.List;

public interface IncumplimientoServiceNeg {
	/**
	 * Interface que servirá para implementar el método guardarIncumplimiento
	 * @param incumplimientoDTO
	 * @param usuarioDTO
	 * @return 
	 */
	public IncumplimientoDTO guardaIncumplimiento(IncumplimientoDTO incumplimientoDTO, UsuarioDTO usuarioDTO);
	/**
	 * Interface que servirá para implementar el método listarIncumplimiento
	 * @param idInfraccion
	 * @param idMaestroincumplimiento
	 * @return
	 */
	public List<IncumplimientoDTO> listarIncumplimiento(Long idInfraccion,Long idMaestroincumplimiento);
	/**
	 * Interface que servirá para implementar el método listarIncumplimientos
	 * @param idIncumplimiento
	 * @return
	 */
	public List<IncumplimientoDTO> listarIncumplimientos(Long idIncumplimiento);
	/**
	 * Interface que servirá para implementar el método eliminarIncumplimiento
	 * @param incumplimientoDTO
	 * @param usuarioDTO
	 * @return
	 */
	public IncumplimientoDTO eliminarIncumplimiento (IncumplimientoDTO incumplimientoDTO, UsuarioDTO usuarioDTO);
}
