/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.DepartamentoDTO;
import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.ProvinciaDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.UbigeoFilter;
import gob.osinergmin.myc.service.exception.UbigeoException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface UbigeoDAO {
    public List<DepartamentoDTO> obtenerDepartamentos(UbigeoFilter filtro) throws UbigeoException;
    public List<ProvinciaDTO> obtenerProvincias(UbigeoFilter filtro) throws UbigeoException;
    public List<DistritoDTO> obtenerDistritos(UbigeoFilter filtro) throws UbigeoException;
    public List<ZonificacionDetalleDTO> listarZonificacionDetalle(UbigeoFilter filtro) throws UbigeoException;
}
