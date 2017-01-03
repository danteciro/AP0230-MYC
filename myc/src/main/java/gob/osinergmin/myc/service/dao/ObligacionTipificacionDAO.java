/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ObligacionTipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionTipificacionFilter;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface ObligacionTipificacionDAO {
    public ObligacionTipificacionDTO create(ObligacionTipificacionDTO obligacionTipificacionDTO, UsuarioDTO usuarioDTO);
    public ObligacionTipificacionDTO changeState(ObligacionTipificacionDTO obligacionTipificacionDTO);
    public List<TipificacionDTO> findTipificacionPorObligacion(ObligacionTipificacionDTO obligacionTipificacion);
    public List<TipificacionDTO> findTificacion(ObligacionTipificacionDTO obligacionTipificacion);
    public List<ObligacionTipificacionDTO> findObligacionTipificacion(ObligacionTipificacionDTO obligacionTipificacion);
    
}