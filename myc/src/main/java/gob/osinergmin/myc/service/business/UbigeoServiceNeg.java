/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.DepartamentoDTO;
import gob.osinergmin.myc.domain.dto.DistritoDTO;
import gob.osinergmin.myc.domain.dto.ProvinciaDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import gob.osinergmin.myc.domain.ui.UbigeoFilter;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface UbigeoServiceNeg {
    public List<DepartamentoDTO> obtenerListadoDepartamentos();
    public List<ProvinciaDTO> obtenerListadoProvincias(UbigeoFilter filtro);
    public List<DistritoDTO> obtenerListadoDistritos(UbigeoFilter filtro);
    public List<ZonificacionDetalleDTO> listarZonificacionDetalle(UbigeoFilter filtro);
}
