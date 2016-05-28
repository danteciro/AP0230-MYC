/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.ZonificacionDetalleFilter;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface ZonificacionDetalleDAO {
    public List<ZonificacionDetalleDTO> obtenerZonificacionDetalle(ZonificacionDetalleFilter filtro);
    public ZonificacionDetalleDTO create(ZonificacionDetalleDTO zonificacionDetalleDTO, UsuarioDTO usuarioDTO);
    public ZonificacionDetalleDTO changeState(ZonificacionDetalleDTO zonificacionDetalleDTO, String estado);
    public void disabledZonificacionDetalle(Long idZonificacion);
    public List<DistritoDTO> obtenerDistritosUnicos(Long idZonificacion, Long idDepartamento, Long idProvincia);
    public ZonificacionDetalleDTO obtenerZonificacionDetalleUbigeo(Long idZonificacionDetalle, Long idDepartamento, Long idProvincia, Long idDistrito);
}