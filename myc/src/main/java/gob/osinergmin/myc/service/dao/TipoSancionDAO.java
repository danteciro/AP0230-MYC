/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.TipoSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipoSancionFilter;
import gob.osinergmin.myc.service.exception.TipoSancionException;
import java.util.HashMap;

/**
 *
 * @author lbarboza
 */
public interface TipoSancionDAO {
    public HashMap listarTipoSancion(TipoSancionFilter filtro);
    public TipoSancionDTO create(TipoSancionDTO tipoSancionDTO, UsuarioDTO usuarioDTO) throws TipoSancionException;
    public TipoSancionDTO changeState(TipoSancionDTO tipoSancionDTO, String estado) throws TipoSancionException;
}