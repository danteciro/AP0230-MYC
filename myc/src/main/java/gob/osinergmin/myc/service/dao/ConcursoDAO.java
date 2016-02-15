/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ConcursoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConcursoFilter;
import gob.osinergmin.myc.service.exception.ConcursoException;
import java.util.HashMap;

/**
 *
 * @author lbarboza
 */
public interface ConcursoDAO {
    public HashMap obtenerConcurso(ConcursoFilter filtro);
    public ConcursoDTO create(ConcursoDTO concursoDTO, UsuarioDTO usuarioDTO);
    public ConcursoDTO changeState(ConcursoDTO concursoDTO, String estado) throws ConcursoException;
}