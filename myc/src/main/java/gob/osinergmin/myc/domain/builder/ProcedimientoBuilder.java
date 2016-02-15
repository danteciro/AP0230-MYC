/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghProcedimiento;
import gob.osinergmin.myc.domain.PghProcedimientoTramite;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.service.dao.impl.ProcedimientoDAOImpl;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
public class ProcedimientoBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ProcedimientoDAOImpl.class);
    
    public static PghProcedimiento getProcedimiento(ProcedimientoDTO registroDTO) {
        PghProcedimiento registro = null;
        if(registroDTO!=null){
            registro=new PghProcedimiento();
            registro.setIdProcedimiento(registroDTO.getIdProcedimiento());
            if(!registroDTO.getItem().equals("")){
                registro.setItem(registroDTO.getItem());
            }            
            registro.setDenominacion(registroDTO.getDenominacion());
            if(!registroDTO.getBaseLegal().equals("")){
                registro.setBaseLegal(registroDTO.getBaseLegal());
            }
            registro.setDerechoTramitacion(registroDTO.getDerechoTramitacion());
            if(registroDTO.getIdValorUit()!=null){
                registro.setIdValorUit(new MdiMaestroColumna(registroDTO.getIdValorUit()));
            }
            if(registroDTO.getIdCalificacion()!=null){
                registro.setIdCalificacion(new MdiMaestroColumna(registroDTO.getIdCalificacion()));
            }
            if(registroDTO.getIdSilencioAdministrativo()!=null){
                registro.setIdSilencioAdministrativo(new MdiMaestroColumna(registroDTO.getIdSilencioAdministrativo()));
            }
            LOG.info("registroDTO.getPlazoResolver()-->"+registroDTO.getPlazoResolver());
            if(registroDTO.getPlazoResolver()!=null){
                registro.setPlazoResolver(new Float(registroDTO.getPlazoResolver()));
            }            
            
            if(registroDTO.getIdInicioProcedimiento()!=null){
                registro.setIdInicioProcedimiento(new MdiMaestroColumna(registroDTO.getIdInicioProcedimiento()));
            }
            if(registroDTO.getIdAutoridadCompetente()!=null){
                registro.setIdAutoridadCompetente(new MdiMaestroColumna(registroDTO.getIdAutoridadCompetente()));
            }
            if(registroDTO.getIdReconsideracion()!=null){
                registro.setIdReconsideracion(new MdiMaestroColumna(registroDTO.getIdReconsideracion()));
            }
            if(registroDTO.getIdApelacion()!=null){
                registro.setIdApelacion(new MdiMaestroColumna(registroDTO.getIdApelacion()));
            }
            if(registroDTO.getIdAnexoRrh()!=null){
                registro.setIdAnexoRrh(new MdiMaestroColumna(registroDTO.getIdAnexoRrh()));
            }
            if(!registroDTO.getNotaProcedimiento().equals("")){
                registro.setNotaProcedimiento(registroDTO.getNotaProcedimiento());
            }            
            registro.setEstado(registroDTO.getEstado());
        }
        return registro;
    }
    public static List<ProcedimientoDTO> toListProcedimientoDto(List<PghProcedimiento> lista) {
        ProcedimientoDTO registroDTO;
        List<ProcedimientoDTO> retorno = new ArrayList<ProcedimientoDTO>();
        if(lista != null && lista.size()>0) {
            for (PghProcedimiento maestro : lista) {
                registroDTO = toProcedimientoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static ProcedimientoDTO toProcedimientoDto(PghProcedimiento registro) {
        ProcedimientoDTO registroDTO = new ProcedimientoDTO();
        
        registroDTO.setIdProcedimiento(registro.getIdProcedimiento());
        registroDTO.setItem(registro.getItem());
        registroDTO.setDenominacion(registro.getDenominacion());
        registroDTO.setBaseLegal(registro.getBaseLegal());
        registroDTO.setDerechoTramitacion(registro.getDerechoTramitacion());
        if(registro.getIdValorUit()!=null){
            registroDTO.setIdValorUit(registro.getIdValorUit().getIdMaestroColumna());
        }
        if(registro.getIdCalificacion()!=null){
            registroDTO.setIdCalificacion(registro.getIdCalificacion().getIdMaestroColumna());
        }
        if(registro.getIdSilencioAdministrativo()!=null){
            registroDTO.setIdSilencioAdministrativo(registro.getIdSilencioAdministrativo().getIdMaestroColumna());
        }
        if(registro.getPlazoResolver()!=null){
            registroDTO.setPlazoResolver(registro.getPlazoResolver().intValue());
        }        
        if(registro.getIdInicioProcedimiento()!=null){
            registroDTO.setIdInicioProcedimiento(registro.getIdInicioProcedimiento().getIdMaestroColumna());
        }
        if(registro.getIdAutoridadCompetente()!=null){
            registroDTO.setIdAutoridadCompetente(registro.getIdAutoridadCompetente().getIdMaestroColumna());
        }
        if(registro.getIdReconsideracion()!=null){
            registroDTO.setIdReconsideracion(registro.getIdReconsideracion().getIdMaestroColumna());
        }
        if(registro.getIdApelacion()!=null){
            registroDTO.setIdApelacion(registro.getIdApelacion().getIdMaestroColumna());
        }
        if(registro.getIdAnexoRrh()!=null){
            registroDTO.setIdAnexoRrh(registro.getIdAnexoRrh().getIdMaestroColumna());
        }
        registroDTO.setNotaProcedimiento(registro.getNotaProcedimiento());
        registroDTO.setEstado(registro.getEstado());
        
        registroDTO.setIdEtapa(registro.getIdEtapa());
        registroDTO.setIdProceso(registro.getIdProceso());
        registroDTO.setProceso(registro.getProceso());
        registroDTO.setTieneAct(registro.getTieneAct());
        registroDTO.setDescTramite(registro.getDescTramite());
        registroDTO.setDescActividad(registro.getDescActividad());
        
        return registroDTO;
    }
}
