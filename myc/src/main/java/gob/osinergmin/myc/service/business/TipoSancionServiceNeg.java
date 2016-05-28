/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.TipoSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TipoSancionFilter;
import gob.osinergmin.myc.service.exception.TipoSancionException;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface TipoSancionServiceNeg {
    public List<TipoSancionDTO> listarTipoSancion(TipoSancionFilter filtro, int[] cuenta);
    public TipoSancionDTO guardarTipoSancion(TipoSancionDTO tipoSancionDTO, UsuarioDTO usuarioDTO) throws TipoSancionException;
    public TipoSancionDTO eliminarTipoSancion(TipoSancionDTO tipoSancionDTO) throws TipoSancionException;
}