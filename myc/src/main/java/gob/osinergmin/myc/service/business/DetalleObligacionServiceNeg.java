/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.DetalleObligacionFilter;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface DetalleObligacionServiceNeg {
    public DetalleObligacionDTO guardaDetalleObligacion(DetalleObligacionDTO detalleObligacionDTO, UsuarioDTO usuarioDTO);
    public DetalleObligacionDTO eliminarDetalleObligacion(DetalleObligacionDTO detalleObligacionDTO);
    public List<DetalleObligacionDTO> listarDetalleObligacion(DetalleObligacionFilter filtro, int[] cuenta);
	public DetalleObligacionDTO updateDetalleObligacion(
			DetalleObligacionDTO detalleObligacionDTO, UsuarioDTO usuarioDTO);
}