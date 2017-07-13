/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ObligacionTipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionTipificacionFilter;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface ObligacionTipificacionServiceNeg {
    public ObligacionTipificacionDTO guardaObligacionTipificacion(ObligacionTipificacionDTO obligacionTipificacionDTO, UsuarioDTO usuarioDTO);
    public ObligacionTipificacionDTO eliminarObligacionTipificacion(ObligacionTipificacionDTO obligacionTipificacionDTO);
    
    public List<TipificacionDTO> listarTipificacion(Long idObligacion);
    public List<TipificacionDTO> listarTipificacionPorObligacion(Long idObligacion);
    public List<TipificacionDTO> listarTipificacion(Long idObligacion, Long idTipificacion);
    public List<TipificacionDTO> listarTipificacion(Long idObligacion, Long idTipificacion,Long idActividad);
}