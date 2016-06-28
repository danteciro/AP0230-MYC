/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;


import gob.osinergmin.myc.domain.MdiMaestroColumna;

import gob.osinergmin.myc.domain.PghEscenarioIncumplimiento;
import gob.osinergmin.myc.domain.PghInfraccion;
import gob.osinergmin.myc.domain.dto.IncumplimientoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rcoloradoa
 */
public class IncumplimientoBuilder {
	public static PghEscenarioIncumplimiento getIncumplimiento(IncumplimientoDTO incumplimientoDTO){
        PghEscenarioIncumplimiento registro = null;
        PghInfraccion pghInfraccion = null;
        MdiMaestroColumna mdiMaestroColumna = new MdiMaestroColumna();
        if(incumplimientoDTO != null){
            registro = new PghEscenarioIncumplimiento();
            mdiMaestroColumna.setIdMaestroColumna(incumplimientoDTO.getId_esce_incu_maestro());
            pghInfraccion = new PghInfraccion();
            pghInfraccion.setIdInfraccion(incumplimientoDTO.getId_infraccion());
            registro.setIdEsceIncumplimiento(incumplimientoDTO.getId_esce_incumplimiento());
            registro.setIdInfraccion(pghInfraccion);
            registro.setIdEsceIncuMaestro(mdiMaestroColumna);
            registro.setEstado(incumplimientoDTO.getEstado());
            registro.setUsuarioCreacion(incumplimientoDTO.getUsuario_creacion());
            registro.setTerminalCreacion(incumplimientoDTO.getTerminal_creacion());
            if(incumplimientoDTO.getCod_trazabilidad()!=null){
                registro.setCodTrazabilidad(incumplimientoDTO.getCod_trazabilidad());
            }
        }
        return registro;
    }
    
	public static List<IncumplimientoDTO> toListIncumplimientoDto(List<PghEscenarioIncumplimiento> lista) {
        IncumplimientoDTO incumplimientoDTO;
        List<IncumplimientoDTO> retorno = new ArrayList<IncumplimientoDTO>();
        if (lista != null) {
            for (PghEscenarioIncumplimiento maestro : lista) {
                incumplimientoDTO = toIncumplimientoDto(maestro);
                retorno.add(incumplimientoDTO);
            }
        }
        return retorno;
    }
	
	public static IncumplimientoDTO toIncumplimientoDto(PghEscenarioIncumplimiento pghIncumplimiento) {
        IncumplimientoDTO incumplimientoDTO = new IncumplimientoDTO();               
        incumplimientoDTO.setId_esce_incumplimiento(pghIncumplimiento.getIdEsceIncumplimiento());
        incumplimientoDTO.setId_infraccion(pghIncumplimiento.getIdInfraccion().getIdInfraccion());
        incumplimientoDTO.setId_esce_incu_maestro(pghIncumplimiento.getIdEsceIncuMaestro().getIdMaestroColumna());
        incumplimientoDTO.setCod_trazabilidad(pghIncumplimiento.getCodTrazabilidad());
        incumplimientoDTO.setEstado(pghIncumplimiento.getEstado());
        incumplimientoDTO.setCod_accion(pghIncumplimiento.getCodAccion());
        incumplimientoDTO.setDescripcionEscenarioIncumplimiento(pghIncumplimiento.getIdEsceIncuMaestro().getDescripcion());        
        
        return incumplimientoDTO;
    }
       
    
}