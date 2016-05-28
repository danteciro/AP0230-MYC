/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionBaseLegalFilter;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface ObligacionBaseLegalServiceNeg {
    public ObligacionBaseLegalDTO guardaObligacionBaseLegal(ObligacionBaseLegalDTO obligacionBaseLegalDTO, UsuarioDTO usuarioDTO);
    public ObligacionBaseLegalDTO eliminarObligacionBaseLegal(ObligacionBaseLegalDTO obligacionBaseLegalDTO);
    public List<ObligacionBaseLegalDTO> listarObligacionBaseLegal(ObligacionBaseLegalFilter filtro, int[] cuenta);
	public ObligacionBaseLegalDTO eliminarBaseLegalAsociada(
			ObligacionBaseLegalDTO oblgBaseLegal, UsuarioDTO usuarioDTO);
}