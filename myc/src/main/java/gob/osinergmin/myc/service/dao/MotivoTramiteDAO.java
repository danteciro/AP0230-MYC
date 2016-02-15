/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.MotivoTramiteDTO;
import gob.osinergmin.myc.domain.ui.MotivoTramiteFilter;
import gob.osinergmin.myc.service.exception.MotivoTramiteException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface MotivoTramiteDAO {
    public List<MotivoTramiteDTO> find(MotivoTramiteFilter filtro) throws MotivoTramiteException;    
}
