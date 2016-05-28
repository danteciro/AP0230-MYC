/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiMaestroTabla;
import gob.osinergmin.myc.domain.MdiMaestroTablaPK;
import gob.osinergmin.myc.domain.dto.MaestroTablaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class MaestroTablaBuilder {
    public static List<MaestroTablaDTO> toListMaestroTablaDto(List<MdiMaestroTabla> lista) {
        MaestroTablaDTO registroDTO;
        List<MaestroTablaDTO> retorno = new ArrayList<MaestroTablaDTO>();
        if(lista != null && lista.size()>0) {
            for (MdiMaestroTabla maestro : lista) {
                registroDTO = toMaestroTablaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    public static MaestroTablaDTO toMaestroTablaDto(MdiMaestroTabla registro) {
        MaestroTablaDTO registroDTO = new MaestroTablaDTO();
        
        registroDTO.setDominio(registro.getMdiMaestroTablaPK().getDominio());
        registroDTO.setAplicacion(registro.getMdiMaestroTablaPK().getAplicacion());
        
        return registroDTO;
    }
    
    public static MdiMaestroTabla getMdiMaestroTabla(MaestroTablaDTO maestroTablaDTO) {
        MdiMaestroTabla maestroTabla = null;
        if(maestroTablaDTO!=null){
            maestroTabla = new MdiMaestroTabla();
            maestroTabla.setDescripcion(maestroTablaDTO.getDescripcion());
            maestroTabla.setEsEditable(maestroTablaDTO.getEsEditable());
            MdiMaestroTablaPK maestroTablaPk = new MdiMaestroTablaPK();
            maestroTablaPk.setAplicacion(maestroTablaDTO.getAplicacion());
            maestroTablaPk.setDominio(maestroTablaDTO.getDominio());
            maestroTabla.setMdiMaestroTablaPK(maestroTablaPk);
        }
        return maestroTabla;
}   
    public static List<MaestroTablaDTO> toListMaestroTablaDtoRef(List<MdiMaestroTabla> lista) {
        MaestroTablaDTO registroDTO;
        List<MaestroTablaDTO> retorno = new ArrayList<MaestroTablaDTO>();
        if(lista != null && lista.size()>0) {
            for (MdiMaestroTabla maestro : lista) {
                registroDTO = toMaestroTablaDtoRef(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    public static MaestroTablaDTO toMaestroTablaDtoRef(MdiMaestroTabla registro) {
        MaestroTablaDTO registroDTO = new MaestroTablaDTO();
        
        registroDTO.setApliDomi(registro.getApliDomi());
        registroDTO.setDescripcion(registro.getDescripcion());
        registroDTO.setDominio(registro.getMdiMaestroTablaPK().getDominio());
        registroDTO.setAplicacion(registro.getMdiMaestroTablaPK().getAplicacion());
        registroDTO.setEsEditable(registro.getEsEditable());
        
        return registroDTO;
    }
}
