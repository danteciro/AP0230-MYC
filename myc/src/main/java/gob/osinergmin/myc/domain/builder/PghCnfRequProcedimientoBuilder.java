package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghCnfRequProcedimiento;
import gob.osinergmin.myc.domain.PghMotivoTramite;
import gob.osinergmin.myc.domain.PghProcedimiento;
import gob.osinergmin.myc.domain.PghRequisito;
import gob.osinergmin.myc.domain.PghTramite;
import gob.osinergmin.myc.domain.PghZonificacion;
import gob.osinergmin.myc.domain.PghZonificacionDetalle;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;

import java.util.ArrayList;
import java.util.List;

public class PghCnfRequProcedimientoBuilder {
	
    public static PghCnfRequProcedimiento getCnfRequProcedimiento(CnfRequProcedimientoDTO registroDTO) {
        PghCnfRequProcedimiento registro = null;
        if(registroDTO!=null){
            registro=new PghCnfRequProcedimiento();
            registro.setIdProcedimiento(new PghProcedimiento(registroDTO.getIdProcedimiento()));
            registro.setIdRequisito(new PghRequisito(registroDTO.getIdRequisito()));
            if(registroDTO.getIdTramite()!=null){
                 registro.setIdTramite(new PghTramite(registroDTO.getIdTramite()));
            }           
            if(registroDTO.getIdActividad()!=null){
                registro.setIdActividad(new MdiActividad(registroDTO.getIdActividad()));
            }
            registro.setComentario(registroDTO.getComentario());
            if(registroDTO.getIdRequisitoProcedimientoPad()!=null){
                registro.setIdRequisitoProcedimientoPad(registroDTO.getIdRequisitoProcedimientoPad());
            }            
            if(registroDTO.getIdMotivoTramite()!=null){
                registro.setIdMotivoTramite(new PghMotivoTramite(registroDTO.getIdMotivoTramite()));
            }
            if(registroDTO.getIdZonificacion()!=null){
                registro.setIdZonificacion(new PghZonificacion(registroDTO.getIdZonificacion()));
            }
            registro.setFlgGeneral(registroDTO.getFlgGeneral());
            registro.setEstado(registroDTO.getEstado());
            registro.setNroOrden(registroDTO.getNroOrden());
        }
        return registro;

    }
	
    public static List<CnfRequProcedimientoDTO> toListProcedimientoDto(List<PghCnfRequProcedimiento> lista) {
    	CnfRequProcedimientoDTO registroDTO;
        List<CnfRequProcedimientoDTO> retorno = new ArrayList<CnfRequProcedimientoDTO>();
        if (lista != null) {
            for (PghCnfRequProcedimiento maestro : lista) {
                registroDTO = toProcedimientoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    public static CnfRequProcedimientoDTO toProcedimientoDto(PghCnfRequProcedimiento registro) {
        CnfRequProcedimientoDTO registroDTO = new CnfRequProcedimientoDTO();
        registroDTO.setIdRequisitoProcedimiento(registro.getIdRequisitoProcedimiento());
        registroDTO.setIdRequisitoProcedimientoPad(registro.getIdRequisitoProcedimientoPad());
        registroDTO.setNroOrden(registro.getNroOrden());
        
        if(registro.getIdProcedimiento()!=null){
            ProcedimientoDTO procedimientoDTO = new ProcedimientoDTO();
            procedimientoDTO.setIdProcedimiento(registro.getIdProcedimiento().getIdProcedimiento());
            procedimientoDTO.setItem(registro.getIdProcedimiento().getItem());
            procedimientoDTO.setDenominacion(registro.getIdProcedimiento().getDenominacion());
            registroDTO.setProcedimiento(procedimientoDTO);
        }
        if(registro.getIdRequisito()!=null){
            RequisitoDTO requisito=new RequisitoDTO();
            requisito.setIdRequisito(registro.getIdRequisito().getIdRequisito());
            requisito.setDescripcion(registro.getIdRequisito().getDescripcion());
            registroDTO.setRequisito(requisito);
        }
        if(registro.getIdTramite()!=null){
            registroDTO.setIdTramite(registro.getIdTramite().getIdTramite());
            registroDTO.setDescTramite(registro.getIdTramite().getDescripcion());
        }
        if(registro.getIdActividad()!=null){
            registroDTO.setIdActividad(registro.getIdActividad().getIdActividad());
            registroDTO.setDescActividad(registro.getIdActividad().getNombre());
        }
        if(registro.getIdZonificacion()!=null){
            registroDTO.setIdZonificacion(registro.getIdZonificacion().getIdZonificacion());
            registroDTO.setDescZonificacion(registro.getIdZonificacion().getNombre());
        }
        if(registro.getIdMotivoTramite()!=null){
            registroDTO.setIdMotivoTramite(registro.getIdMotivoTramite().getIdMotivoTramite());
            registroDTO.setDescMotivoTramite(registro.getIdMotivoTramite().getDescripcion());
        }       
    	registroDTO.setComentario(registro.getComentario());
        registroDTO.setFlgGeneral(registro.getFlgGeneral());
        
        return registroDTO;
    }

}
