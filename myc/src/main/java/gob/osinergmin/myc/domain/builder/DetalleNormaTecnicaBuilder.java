/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghOpcion;
import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghDetalleBaseLegal;
import gob.osinergmin.myc.domain.PghDetalleNormaTecnica;
import gob.osinergmin.myc.domain.PghObligacion;
import gob.osinergmin.myc.domain.PghObligacionBaseLegal;
import gob.osinergmin.myc.domain.dto.DetalleNormaTecnicaDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
//import gob.osinergmin.myc.domain.PghObligacionBaseLegalPK;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.OpcionDTO;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;

/**
 *
 * @author jsifuentes
 */
public class DetalleNormaTecnicaBuilder {
    public static PghDetalleNormaTecnica getDetalleNormaTecnica(DetalleNormaTecnicaDTO detalleNormaTecnicaDTO){
    	PghDetalleNormaTecnica registro = null;
//        PghObligacion pghObligacion = null;
//        PghBaseLegal pghBaseLegal = null;
        
        if(detalleNormaTecnicaDTO != null){
            registro = new PghDetalleNormaTecnica();
            PghDetalleBaseLegal pghDetalleBaseLegal = new PghDetalleBaseLegal();
            pghDetalleBaseLegal.setIdDetalleBaseLegal(detalleNormaTecnicaDTO.getIdDetalleBaseLegal());
            registro.setIdDetalleBaseLegal(pghDetalleBaseLegal);
            
            MdiMaestroColumna mdiMaestroColumna = new MdiMaestroColumna();
            mdiMaestroColumna.setIdMaestroColumna(detalleNormaTecnicaDTO.getIdTipoNormaTecnica());
            
            registro.setIdTipoNormaTecnica(mdiMaestroColumna);
            
            registro.setDescripcionNormaTecnica(detalleNormaTecnicaDTO.getDescripcionNorma());

            registro.setEstado(detalleNormaTecnicaDTO.getEstado().charAt(0));
        }
        return registro;
    }
    
    public static List<DetalleNormaTecnicaDTO> toListDetalleNormaTecnicaDto(List<PghDetalleNormaTecnica> lista) {
    	DetalleNormaTecnicaDTO registroDTO;
        List<DetalleNormaTecnicaDTO> retorno = new ArrayList<DetalleNormaTecnicaDTO>();
        if (lista != null) {
            for (PghDetalleNormaTecnica maestro : lista) {
                registroDTO = toOpcionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    
    public static DetalleNormaTecnicaDTO toOpcionDto(PghDetalleNormaTecnica registro) {
    	DetalleNormaTecnicaDTO registroDTO = new DetalleNormaTecnicaDTO();
    	registroDTO.setIdDetalleNormaTecnica(registro.getIdDetalleNormaTecnica());
    	registroDTO.setDescripcionNorma(registro.getDescripcionNormaTecnica());
        registroDTO.setIdTipoNormaTecnica(registro.getIdTipoNormaTecnica().getIdMaestroColumna());
        registroDTO.setDescripcionIdTipoNormaTecnica(registro.getIdTipoNormaTecnica().getDescripcion());
        registroDTO.setIdDetalleBaseLegal(registro.getIdDetalleBaseLegal().getIdDetalleBaseLegal());
        return registroDTO;
    }
    
}