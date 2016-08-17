/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public class TipificacionBuilder {

    public static PghTipificacion getTipificacion(TipificacionDTO tipificacionDTO) {
        PghTipificacion registro = null;
        if (tipificacionDTO != null) {
            registro = new PghTipificacion();
            if (tipificacionDTO.getIdTipificacion() != null) {
                registro.setIdTipificacion(new Long(tipificacionDTO.getIdTipificacion()));
            }
            registro.setDescripcion(tipificacionDTO.getDescripcion());
            registro.setSancionMonetaria(tipificacionDTO.getSancionMonetaria());
            registro.setEstado(tipificacionDTO.getActivo());

            registro.setCodTipificacion(tipificacionDTO.getCodTipificacion());
            registro.setBasesLegales(tipificacionDTO.getBasesLegales());
            registro.setIdTipificacionPadre(tipificacionDTO.getIdTipificacionPadre());
            registro.setIdTipoMoneda(tipificacionDTO.getIdTipoMoneda());
            registro.setClaseSancion(new MdiMaestroColumna(tipificacionDTO.getClaseSancion()));
        }
        return registro;
    }

    public static List<TipificacionDTO> toListTipificacionDto(List<PghTipificacion> lista) {
        TipificacionDTO tipificacionDTO;
        List<TipificacionDTO> retorno = new ArrayList<TipificacionDTO>();
        if (lista != null) {
            for (PghTipificacion maestro : lista) {
                tipificacionDTO = toTipificacionDto(maestro);
                retorno.add(tipificacionDTO);
            }
        }
        return retorno;
    }

    public static TipificacionDTO toTipificacionDto(PghTipificacion tipificacion) {
        TipificacionDTO tipificacionDTO = new TipificacionDTO();
        tipificacionDTO.setIdTipificacion(tipificacion.getIdTipificacion());
        tipificacionDTO.setCodTipificacion(tipificacion.getCodTipificacion());
        tipificacionDTO.setDescripcion(tipificacion.getDescripcion());
        tipificacionDTO.setSancionMonetaria(tipificacion.getSancionMonetaria());
        tipificacionDTO.setBasesLegales(tipificacion.getBasesLegales());
        tipificacionDTO.setIdTipificacionPadre(tipificacion.getIdTipificacionPadre());
        tipificacionDTO.setDescTipiPadre(tipificacion.getDescTipiPadre());
        tipificacionDTO.setIdTipoMoneda(tipificacion.getIdTipoMoneda());
        if(tipificacion.getClaseSancion()!=null){
            tipificacionDTO.setClaseSancion(tipificacion.getClaseSancion().getIdMaestroColumna());
            tipificacionDTO.setDescClaseSancion(tipificacion.getClaseSancion().getDescripcion());
        }
        
        tipificacionDTO.setActivo(tipificacion.getEstado());
        tipificacionDTO.setTieneSanc(tipificacion.getTieneSanc());
        if(tipificacion.getTieneAct() !=null && !tipificacion.getTieneAct().equals("0")){
        	tipificacionDTO.setTieneAct(tipificacion.getTieneAct().toString());
        }
        

        return tipificacionDTO;
    }

	public static List<TipificacionDTO> toListTipificacionNativoDto(List<Object[]> listadoTipificacion) {
		TipificacionDTO tipificacionDTO;
        List<TipificacionDTO> retorno = new ArrayList<TipificacionDTO>();
        if (listadoTipificacion != null) {
            for (Object[] maestro : listadoTipificacion) {
            	
            	tipificacionDTO = new TipificacionDTO();
                tipificacionDTO.setIdTipificacion((Long) maestro[0]);
                tipificacionDTO.setCodTipificacion(maestro[1].toString());
                if(maestro[2]!=null){
                	tipificacionDTO.setDescripcion(maestro[2].toString());	
                }                
                if(maestro[3]!=null){
                	tipificacionDTO.setSancionMonetaria(maestro[3].toString());
                }
                if(maestro[4]!=null){
                	tipificacionDTO.setBasesLegales(maestro[4].toString());
                }
                if(maestro[5]!=null){
                    tipificacionDTO.setIdTipificacionPadre((Long) maestro[5]);
                }
                if(maestro[6]!=null){
                	tipificacionDTO.setDescTipiPadre(maestro[6].toString());
                }
                if(maestro[7]!=null){
                    tipificacionDTO.setIdTipoMoneda((Long) maestro[7]);
                }
                if(maestro[8]!=null){
                    tipificacionDTO.setClaseSancion((Long)maestro[8]);
                    tipificacionDTO.setDescClaseSancion(maestro[9].toString());
                }                
                tipificacionDTO.setActivo(maestro[10].toString());
                  retorno.add(tipificacionDTO);
            }
        }
        return retorno;
	}
}