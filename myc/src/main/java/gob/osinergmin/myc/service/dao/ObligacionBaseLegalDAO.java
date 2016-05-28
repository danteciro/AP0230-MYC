/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionBaseLegalFilter;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface ObligacionBaseLegalDAO {
    public ObligacionBaseLegalDTO create(ObligacionBaseLegalDTO obligacionBaseLegalDTO, UsuarioDTO usuarioDTO);
    public ObligacionBaseLegalDTO changeState(ObligacionBaseLegalDTO obligacionBaseLegalDTO);
    public List<ObligacionBaseLegalDTO> find(ObligacionBaseLegalFilter filtro);
    public Long count(ObligacionBaseLegalFilter filtro);
	public ObligacionBaseLegalDTO changeState(ObligacionBaseLegalDTO oblgBaseLegal,
			UsuarioDTO usuarioDTO);
	public Long findByBaseLegal(BaseLegalDTO baseLegalDTO);
	public ObligacionBaseLegalDTO changeEstadoRelacion(BaseLegalDTO baseLegalDTO,UsuarioDTO usuarioDTO);
	public Long findByObligacion(ObligacionNormativaDTO obligacionNormativaDTO);
	public ObligacionBaseLegalDTO changeEstadoRelacion(ObligacionNormativaDTO obligacionNormativaDTO, UsuarioDTO usuarioDTO);
// 05-11-2015	
	public ObligacionBaseLegalDTO creaRelacionOblBl(ObligacionBaseLegalDTO relacion, UsuarioDTO usuarioDTO);
//	
}