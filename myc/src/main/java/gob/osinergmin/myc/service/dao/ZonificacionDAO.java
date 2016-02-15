/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionFilter;
import gob.osinergmin.myc.service.exception.ZonificacionException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ZonificacionDAO {
    public List<ZonificacionDTO> obtenerZonificacion(ZonificacionFilter filtro) throws ZonificacionException;
    public List<ZonificacionDTO> obtenerZonificacionValidaNombre(ZonificacionFilter filtro) throws ZonificacionException;
    public ZonificacionDTO create(ZonificacionDTO zonificacionDTO, UsuarioDTO usuarioDTO);
    public ZonificacionDTO changeState(ZonificacionDTO zonificacionDTO, String estado) throws ZonificacionException;
}
