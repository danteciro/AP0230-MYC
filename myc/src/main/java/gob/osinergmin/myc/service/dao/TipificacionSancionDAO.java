/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipificacionSancionFilter;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface TipificacionSancionDAO {
    public HashMap listarTipificacionSancion(TipificacionSancionFilter filtro);
    public TipificacionSancionDTO create(TipificacionSancionDTO tipificacionSancionDTO, UsuarioDTO usuarioDTO);
    public TipificacionSancionDTO changeState(TipificacionSancionDTO tipificacionSancionDTO, String estado);
    public TipificacionSancionDTO buscarTipificacionSancion(TipificacionSancionFilter filtro);
    public List<TipificacionSancionDTO> buscTipifSancByIdDetalleCriterio(TipificacionSancionFilter filtro);
	public TipificacionSancionDTO buscarTipificacionSancionCompleta(Long idTipiSanc);
	public TipificacionSancionDTO cambioEstado(TipificacionSancionDTO tipificacionSancionDTO, UsuarioDTO usuarioDTO);
	public HashMap listarTipificacionBySancion(TipificacionSancionFilter filtro);
	public TipificacionSancionDTO buscarTipificacionSancionNivel(TipificacionSancionFilter filtro);
	public HashMap listarTipificacionBySancionCriterio(TipificacionSancionFilter filtro);
}