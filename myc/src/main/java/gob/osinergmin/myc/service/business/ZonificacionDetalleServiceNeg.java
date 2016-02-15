/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface ZonificacionDetalleServiceNeg {
    public List<ZonificacionDetalleDTO> obtenerListadoZonificacionDetalle(Long idZonificacion);
    public ZonificacionDetalleDTO guardarZonificacionDetalle(ZonificacionDetalleDTO zonificacionDetalleDTO, UsuarioDTO usuarioDTO);
    public ZonificacionDetalleDTO eliminarZonificacionDetalle(ZonificacionDetalleDTO zonificacionDetalleDTO);
    public List<DistritoDTO> obtenerListadoDistritosUnicos(Long idZonificacion, Long idDepartamento, Long idProvincia);
    public ZonificacionDetalleDTO obtenerZonificacionDetalle(Long idZonificacionDetalle, Long idDepartamento, Long idProvincia, Long idDistrito);
}