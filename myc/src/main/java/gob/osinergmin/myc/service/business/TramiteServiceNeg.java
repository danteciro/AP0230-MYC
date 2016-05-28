/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.exception.TramiteException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface TramiteServiceNeg {
    public List<TramiteDTO> findTramiteByFilter(TramiteFilter filtro);
    public TramiteDTO guardarTramite(TramiteDTO tramiteDTO, UsuarioDTO usuarioDTO) throws TramiteException;
    public TramiteDTO eliminarTramite(TramiteDTO tramiteDTO) throws TramiteException;
}