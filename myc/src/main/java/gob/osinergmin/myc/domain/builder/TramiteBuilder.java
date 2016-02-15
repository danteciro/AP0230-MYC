/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghEtapa;
import gob.osinergmin.myc.domain.PghTramite;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class TramiteBuilder {
    public static PghTramite getTramite(TramiteDTO tramiteDTO){
        PghTramite registro = null;
        PghEtapa etapa = null;
        if(tramiteDTO != null){
            registro = new PghTramite();
            if(tramiteDTO.getIdTramite() != null){
                registro.setIdTramite(tramiteDTO.getIdTramite());
            }
            registro.setDescripcion(tramiteDTO.getDescripcion());
            registro.setEstado(tramiteDTO.getEstado());
            if(tramiteDTO.getIdEtapa() != null){
                etapa = new PghEtapa(tramiteDTO.getIdEtapa());
                registro.setIdEtapa(etapa);
            }
        }
        return registro;
    }
    public static List<TramiteDTO> toListTramiteDto(List<PghTramite> lista) {
        TramiteDTO registroDTO;
        List<TramiteDTO> retorno = new ArrayList<TramiteDTO>();
        if (lista != null) {
            for (PghTramite maestro : lista) {
                registroDTO = toTramiteDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static TramiteDTO toTramiteDto(PghTramite registro) {
        TramiteDTO registroDTO = new TramiteDTO();
        
        registroDTO.setIdTramite(registro.getIdTramite());
        //registroDTO.setIdEtapa(registro.getIdEtapa().getIdEtapa());
        registroDTO.setDescripcion(registro.getDescripcion());
        
        return registroDTO;
    }
}
