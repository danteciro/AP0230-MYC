/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.DetalleObligacionFilter;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface DetalleObligacionDAO {
    public DetalleObligacionDTO create(DetalleObligacionDTO detalleObligacionDTO, UsuarioDTO usuarioDTO);
    public DetalleObligacionDTO changeState(DetalleObligacionDTO detalleObligacionDTO);
    public List<DetalleObligacionDTO> find(DetalleObligacionFilter filtro);
    public Long count(DetalleObligacionFilter filtro);
	public DetalleObligacionDTO update(DetalleObligacionDTO detalleObligacionDTO,
			UsuarioDTO usuarioDTO);
}