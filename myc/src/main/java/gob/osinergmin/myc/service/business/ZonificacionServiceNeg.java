/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionFilter;
import gob.osinergmin.myc.service.exception.ZonificacionException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ZonificacionServiceNeg {
    public List<ZonificacionDTO> obtenerListadoZonificacion(ZonificacionFilter filtro);
    public ZonificacionDTO obtenerZonificacion(String nombre);
    public ZonificacionDTO obtenerZonificacionValidaNombre(String nombre);
    public ZonificacionDTO guardarZonificacion(ZonificacionDTO zonificacionDTO, UsuarioDTO usuarioDTO);
    public ZonificacionDTO eliminarZonificacion(ZonificacionDTO zonificacionDTO) throws ZonificacionException;
}