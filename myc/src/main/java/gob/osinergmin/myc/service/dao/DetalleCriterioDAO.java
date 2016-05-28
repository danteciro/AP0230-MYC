/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.DetalleCriterioFilter;
import gob.osinergmin.myc.domain.ui.DetalleCriterioImplFilter;
import gob.osinergmin.myc.service.exception.DetalleCriterioException;

import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface DetalleCriterioDAO {
    public DetalleCriterioDTO eliminarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException;
    public DetalleCriterioDTO editarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException;
    public DetalleCriterioDTO createSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException;
    public DetalleCriterioDTO create(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO);
    public DetalleCriterioDTO changeState(DetalleCriterioDTO detalleCriterioDTO);
    public List<DetalleCriterioDTO> find(DetalleCriterioFilter filtro);
    public Long count(DetalleCriterioFilter filtro);
    public void deleteAllDetalleCriterio(Long idCriterio);
    public List<DetalleCriterioDTO> listarSancionEspecificaCriterio(Long idCriterio);
    public List<DetalleCriterioDTO> obtenerDetalleCriterio(Long idCriterio);
    public DetalleCriterioDTO obtenerDetalleCriterioById(Long idDetalleCriterio);
	public Long countImpl(DetalleCriterioImplFilter filtro);
	public List<DetalleCriterioDTO> findImpl(DetalleCriterioImplFilter filtro);
}