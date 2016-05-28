/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ConcursoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConcursoFilter;
import gob.osinergmin.myc.service.exception.ConcursoException;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface ConcursoServiceNeg {
    List<ConcursoDTO> obtenerListadoConcurso(ConcursoFilter filtro, int[] cuenta);
    public ConcursoDTO guardarConcurso(ConcursoDTO concursoDTO, UsuarioDTO usuarioDTO);
    public ConcursoDTO eliminarConcurso(ConcursoDTO concursoDTO) throws ConcursoException;
}