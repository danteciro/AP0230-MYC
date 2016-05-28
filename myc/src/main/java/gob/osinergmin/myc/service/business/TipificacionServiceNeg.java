/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipificacionFilter;
import gob.osinergmin.myc.service.exception.TipificacionException;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface TipificacionServiceNeg {
    public TipificacionDTO guardaTipificacion(TipificacionDTO tipificacionDTO,UsuarioDTO usuarioDTO);
    public TipificacionDTO eliminarTipificacion(TipificacionDTO tipificacionDTO) throws TipificacionException;
    public List<TipificacionDTO> listarTipificacion(TipificacionFilter filtro, int[] cuenta);
    
    public List<TipificacionDTO> listarTipificaciones(TipificacionFilter filtro, int[] cuenta);
    
    public TipificacionDTO obtenerTipificacion(Long idTipificacion);
    public List<TipificacionDTO> obtenerTipificaciones(String codigoTipificacion);
    public TipificacionDTO obtenerTipificacion(String codigoTipificacion);
	public TipificacionDTO obtenerTipificacionCriterio(String codigo);
	public TipificacionDTO obtenerTipificacionCriterio(Long idTipificacion);
	public TipificacionDTO obtenerTipificacionNivel(Long idTipificacion);
	public Object listarTipificacionesPadre(TipificacionFilter filtro1);
}