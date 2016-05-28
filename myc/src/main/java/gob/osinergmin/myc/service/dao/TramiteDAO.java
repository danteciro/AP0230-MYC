/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.exception.TramiteException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface TramiteDAO {
    public List<TramiteDTO> find(TramiteFilter filtro) throws TramiteException;
    public TramiteDTO create(TramiteDTO tramiteDTO, UsuarioDTO usuarioDTO) throws TramiteException;
    public TramiteDTO changeState(TramiteDTO tramiteDTO, String estado) throws TramiteException;
}