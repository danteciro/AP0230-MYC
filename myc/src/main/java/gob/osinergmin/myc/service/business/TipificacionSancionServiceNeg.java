/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipificacionSancionFilter;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface TipificacionSancionServiceNeg {
    public List<TipificacionSancionDTO> findTipificacionSancion(TipificacionSancionFilter filtro, int[] cuenta);
    public TipificacionSancionDTO guardarTipificacionSancion(TipificacionSancionDTO tipificacionSancionDTO, UsuarioDTO usuarioDTO);
    public TipificacionSancionDTO eliminarTipificacionSancion(TipificacionSancionDTO tipificacionSancionDTO);
	public TipificacionSancionDTO buscarTipificacionSancion(Long idTipoSancion,Long idTipificacion);
	public TipificacionSancionDTO buscarTipificacionSancionNivel(Long idTipoSancion, Long idTipificacion, Long idNivel);
	public List<TipificacionSancionDTO> findTipificacionSancionCriterio(TipificacionSancionFilter filtro, int[] cuenta);
}