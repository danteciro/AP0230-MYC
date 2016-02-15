/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghEtapa;
import gob.osinergmin.myc.domain.PghProceso;
import gob.osinergmin.myc.domain.dto.EtapaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class EtapaBuilder {
    public static PghEtapa getEtapa(EtapaDTO etapaDTO){
        PghEtapa registro = null;
        PghProceso proceso = null;
        if(etapaDTO != null){
            registro = new PghEtapa();
            if(etapaDTO.getIdEtapa() != null){
                registro.setIdEtapa(etapaDTO.getIdEtapa());
            }
            registro.setDescripcion(etapaDTO.getDescripcion());
            registro.setEstado(etapaDTO.getEstado());
            if(etapaDTO.getIdProceso() != null){
                proceso = new PghProceso(etapaDTO.getIdProceso());
                registro.setIdProceso(proceso);
            }
        }
        return registro;
    }
    public static List<EtapaDTO> toListEtapaDto(List<PghEtapa> lista) {
        EtapaDTO registroDTO;
        List<EtapaDTO> retorno = new ArrayList<EtapaDTO>();
        if (lista != null) {
            for (PghEtapa maestro : lista) {
                registroDTO = toEtapaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static EtapaDTO toEtapaDto(PghEtapa registro) {
        EtapaDTO registroDTO = new EtapaDTO();
        
        registroDTO.setIdEtapa(registro.getIdEtapa());
        registroDTO.setProceso(registro.getProceso());//LEBQ
        registroDTO.setDescripcion(registro.getDescripcion());
        registroDTO.setIdProceso(registro.getIdProceso().getIdProceso());//LEBQ
        
        return registroDTO;
    }
    
    public static List<EtapaDTO> toListEtapaUtilDto(List<PghEtapa> lista) {
        EtapaDTO registroDTO;
        List<EtapaDTO> retorno = new ArrayList<EtapaDTO>();
        if (lista != null) {
            for (PghEtapa maestro : lista) {
                registroDTO = toEtapaUtilDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static EtapaDTO toEtapaUtilDto(PghEtapa registro) {
        EtapaDTO registroDTO = new EtapaDTO();
        
        registroDTO.setIdEtapa(registro.getIdEtapa());
        registroDTO.setProceso(registro.getProceso());//LEBQ
        registroDTO.setDescripcion(registro.getDescripcion());
        registroDTO.setNroTram(registro.getNroTram());
        registroDTO.setNroAct(registro.getNroAct());
//        registroDTO.setIdProceso(registro.getIdProceso().getIdProceso());//LEBQ
        
        return registroDTO;
    }
    
}
