/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiUbigeo;
import gob.osinergmin.myc.domain.PghZonificacion;
import gob.osinergmin.myc.domain.PghZonificacionDetalle;
import gob.osinergmin.myc.domain.dto.ZonificacionDTO;
import gob.osinergmin.myc.domain.dto.ZonificacionDetalleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class ZonificacionDetalleBuilder {
    public static PghZonificacionDetalle getZonificacionDetalle(ZonificacionDetalleDTO zonificacionDetalleDTO){
        PghZonificacionDetalle registro = null;
        PghZonificacion zonificacion = null;
        MdiUbigeo ubigeo = null;
        if(zonificacionDetalleDTO != null){
            registro = new PghZonificacionDetalle();
            if(zonificacionDetalleDTO.getIdZonificacionDetalle() != null){
                registro.setIdZonificacionDetalle(zonificacionDetalleDTO.getIdZonificacionDetalle());
            }
            //if(zonificacionDetalleDTO.getZonificacion() != null){
            if(zonificacionDetalleDTO.getIdZonificacion() != null){
                zonificacion = new PghZonificacion(zonificacionDetalleDTO.getIdZonificacion());
                registro.setIdZonificacion(zonificacion);
            }
            //if(zonificacionDetalleDTO.getUbigeo() != null){
            if(zonificacionDetalleDTO.getIdDepartamento() != null &&
                    zonificacionDetalleDTO.getIdProvincia() != null &&
                    zonificacionDetalleDTO.getIdDistrito() != null){
                ubigeo = new MdiUbigeo(zonificacionDetalleDTO.getIdDepartamento(), zonificacionDetalleDTO.getIdProvincia(), zonificacionDetalleDTO.getIdDistrito());
                registro.setMdiUbigeo(ubigeo);
            }
            registro.setEstado(zonificacionDetalleDTO.getEstado());
        }
        return registro;
    }
    public static List<ZonificacionDetalleDTO> toListZonificacionDetalleDto(List<PghZonificacionDetalle> lista) {
        ZonificacionDetalleDTO registroDTO;
        List<ZonificacionDetalleDTO> retorno = new ArrayList<ZonificacionDetalleDTO>();
        if (lista != null) {
            for (PghZonificacionDetalle maestro : lista) {
                registroDTO = toZonificacionDetalleDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static ZonificacionDetalleDTO toZonificacionDetalleDto(PghZonificacionDetalle registro) {
        ZonificacionDetalleDTO registroDTO = new ZonificacionDetalleDTO();
        
        registroDTO.setIdZonificacionDetalle(registro.getIdZonificacionDetalle());
        if(registro.getIdZonificacion()!=null){
            registroDTO.setZonificacion(new ZonificacionDTO(registro.getIdZonificacion().getIdZonificacion(),registro.getNombreZonificacion()));
        }
        registroDTO.setIdZonificacion(registro.getIdZonificacion().getIdZonificacion());
        registroDTO.setIdDepartamento(registro.getMdiUbigeo().getMdiUbigeoPK().getIdDepartamento());
        registroDTO.setIdProvincia(registro.getMdiUbigeo().getMdiUbigeoPK().getIdProvincia());
        registroDTO.setIdDistrito(registro.getMdiUbigeo().getMdiUbigeoPK().getIdDistrito());
        registroDTO.setNombreDistrito(registro.getMdiUbigeo().getNombre());
        registroDTO.setNombreProvincia(registro.getUbigeoProvincia());
        registroDTO.setNombreDepartamento(registro.getUbigeoDepartamento());
        registroDTO.setNombreZonificacion(registro.getNombreZonificacion());
        
        return registroDTO;
    }
}
