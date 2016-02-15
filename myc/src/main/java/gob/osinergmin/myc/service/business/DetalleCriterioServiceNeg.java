/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

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
public interface DetalleCriterioServiceNeg {
    public DetalleCriterioDTO eliminarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException;
    public DetalleCriterioDTO editarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException;
    public DetalleCriterioDTO guardarSancionEspecifica(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO) throws DetalleCriterioException;
    public DetalleCriterioDTO guardaDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO,UsuarioDTO usuarioDTO);
    public DetalleCriterioDTO eliminarDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO);
    public List<DetalleCriterioDTO> listarDetalleCriterio(DetalleCriterioFilter filtro, int[] cuenta);
	public List<DetalleCriterioDTO> listarDetalleCriterioImpl(DetalleCriterioImplFilter filtro, int[] cuenta);
}