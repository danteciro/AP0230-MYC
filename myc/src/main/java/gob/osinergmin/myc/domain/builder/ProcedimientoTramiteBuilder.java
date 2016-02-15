/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghProcedimiento;
import gob.osinergmin.myc.domain.PghProcedimientoTramite;
import gob.osinergmin.myc.domain.PghTramite;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.service.dao.impl.ProcedimientoDAOImpl;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
public class ProcedimientoTramiteBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ProcedimientoDAOImpl.class);
    
    public static PghProcedimientoTramite getProcedimientoTramite(ProcedimientoTramiteDTO registroDTO) {
        PghProcedimientoTramite registro = null;
        if(registroDTO!=null){
            registro=new PghProcedimientoTramite();
            registro.setIdProcedimientoTramite(registroDTO.getIdProcedimientoTramite());
            if(registroDTO.getIdProcedimiento()!=null){
                registro.setIdProcedimiento( new PghProcedimiento(registroDTO.getIdProcedimiento()) );
            }
            if(registroDTO.getIdTramite()!=null){
                registro.setIdTramite(new PghTramite(registroDTO.getIdTramite()) );
            }
            registro.setEstado(registroDTO.getEstado());
        }
        return registro;
    }
    public static List<ProcedimientoTramiteDTO> toListProcedimientoTramiteDto(List<PghProcedimientoTramite> lista) {
        ProcedimientoTramiteDTO registroDTO;
        List<ProcedimientoTramiteDTO> retorno = new ArrayList<ProcedimientoTramiteDTO>();
        if (lista != null) {
            for (PghProcedimientoTramite maestro : lista) {
                registroDTO = toProcedimientoTramiteDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static ProcedimientoTramiteDTO toProcedimientoTramiteDto(PghProcedimientoTramite registro) {
        ProcedimientoTramiteDTO registroDTO = new ProcedimientoTramiteDTO();
        
        registroDTO.setIdProcedimientoTramite(registro.getIdProcedimientoTramite());
        registroDTO.setIdProcedimiento(registro.getIdProcedimiento().getIdProcedimiento());
        if(registro.getIdTramite()!=null){
            registroDTO.setIdTramite(registro.getIdTramite().getIdTramite());
            registroDTO.setDescTramite(registro.getIdTramite().getDescripcion());
        }
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
}
