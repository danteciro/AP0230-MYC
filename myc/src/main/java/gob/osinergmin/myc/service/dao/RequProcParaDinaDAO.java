/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.exception.RequProcParaDinaException;

/**
 *
 * @author jpiro
 */
public interface RequProcParaDinaDAO {
    public RequProcParaDinaDTO create(RequProcParaDinaDTO registroDTO, UsuarioDTO usuarioDTO) throws RequProcParaDinaException;
}
