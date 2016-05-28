/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.SancionEspecificaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CriterFilter;
import gob.osinergmin.myc.domain.ui.CriterioFilter;
import gob.osinergmin.myc.domain.ui.CriterioImplFilter;

import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface CriterioDAO {
    public CriterioDTO create(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO);
    public CriterioDTO update(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO);
    public CriterioDTO changeState(CriterioDTO criterioDTO);
    public List<CriterioDTO> find(CriterioFilter filtro);
    public Long count(CriterioFilter filtro);
    public List<CriterioDTO> obtenerCriterios(CriterioDTO criterio);
    public CriterioDTO obtenerCriterioById(Long idCriterio);
    //Implementado_lgarcia
	public Long countImpl(CriterioImplFilter filtro);
	public List<CriterioDTO> findImpl(CriterioImplFilter filtro);
	public CriterioDTO changeEstado(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO);
	public Long buscarSancionEspecifica(Long idCriterio);
	
	
}