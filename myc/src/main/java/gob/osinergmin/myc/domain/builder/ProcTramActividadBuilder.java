/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghProcTramActividad;
import gob.osinergmin.myc.domain.PghProcedimientoTramite;
import gob.osinergmin.myc.domain.dto.ProcTramActividadDTO;
import gob.osinergmin.myc.service.dao.impl.ProcedimientoDAOImpl;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
public class ProcTramActividadBuilder {
    
    
    public static PghProcTramActividad getProcTramActividad(ProcTramActividadDTO registroDTO) {
        PghProcTramActividad registro = null;
        if(registroDTO!=null){
            registro=new PghProcTramActividad();
            if(registroDTO.getIdProcedimientoTramite()!=null){
                registro.setIdProcedimientoTramite(new PghProcedimientoTramite(registroDTO.getIdProcedimientoTramite()) );
            }
            if(registroDTO.getIdActividad()!=null){
                registro.setIdActividad(new MdiActividad(registroDTO.getIdActividad()) );
            }
            registro.setEstado(registroDTO.getEstado());
        }
        return registro;
    }
    public static List<ProcTramActividadDTO> toListProcTramActividadDto(List<PghProcTramActividad> lista) {
        ProcTramActividadDTO registroDTO;
        List<ProcTramActividadDTO> retorno = new ArrayList<ProcTramActividadDTO>();
        if (lista != null) {
            for (PghProcTramActividad maestro : lista) {
                registroDTO = toProcTramActividadDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static ProcTramActividadDTO toProcTramActividadDto(PghProcTramActividad registro) {
        ProcTramActividadDTO registroDTO = new ProcTramActividadDTO();
        
        registroDTO.setIdProcTramActi(registro.getIdProcTramActi());
        registroDTO.setIdProcedimientoTramite(registro.getIdProcedimientoTramite().getIdProcedimientoTramite());
        registroDTO.setIdActividad(registro.getIdActividad().getIdActividad());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
    
}
