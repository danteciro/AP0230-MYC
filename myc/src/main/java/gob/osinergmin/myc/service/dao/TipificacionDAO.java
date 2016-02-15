/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipificacionFilter;
import gob.osinergmin.myc.service.exception.TipificacionException;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface TipificacionDAO {
    public TipificacionDTO create(TipificacionDTO tipificacionDTO,UsuarioDTO usuarioDTO);
    public TipificacionDTO changeState(TipificacionDTO tipificacionDTO) throws TipificacionException;
    public List<TipificacionDTO> find(TipificacionFilter filtro);
    public Long count(TipificacionFilter filtro);
    
    public TipificacionDTO obtenerTipificacion(Long idTipificacion);
    public List<TipificacionDTO> obtenerTipificacionByCodigo(String codigoTipificacion);
    public List<TipificacionDTO> obtenerTipificaciones(String codigoTipificacion);
    public List<TipificacionSancionDTO> obtenerTipificacionSancion(String codigoTipificacion);
    
	public Long countByFilter(TipificacionFilter filtro);
	public List<TipificacionDTO> findByFilter(TipificacionFilter filtro);
	public Long countNativo(TipificacionFilter filtro);
	public List<TipificacionDTO> findByNativo(TipificacionFilter filtro);
	public List<TipificacionDTO> obtenerTipificacionByCodigoCriterio(String codigoTipificacion);
	public List<TipificacionSancionDTO> obtenerTipificacionSancionCriterio(String codTipificacion,Long nivelTipificacion);
	public Long buscarSancionEspecifica(Long idTipificacion);
	public List<TipificacionSancionDTO> obtenerTipificacionSancionNivel(String codTipificacion, Long idNivel);
	public List<TipificacionDTO> findTipificacionPadre(TipificacionFilter filtro);
    
}