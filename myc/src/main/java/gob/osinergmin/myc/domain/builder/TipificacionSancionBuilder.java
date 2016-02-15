/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.PghCriterio;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.PghTipificacionSancion;
import gob.osinergmin.myc.domain.PghTipoSancion;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.TipoSancionDTO;
import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author lchancayauri
 */
public class TipificacionSancionBuilder {
    public static PghTipificacionSancion getTipificacionSancion(TipificacionSancionDTO tipificacionSancionDTO){
        PghTipificacionSancion registro = null;
        PghTipificacion tipificacion = null;
        PghTipoSancion tipoSancion = null;
        if(tipificacionSancionDTO != null){
            registro = new PghTipificacionSancion();
            if(tipificacionSancionDTO.getIdTipiSanc() != null){
                registro.setIdTipiSanc(tipificacionSancionDTO.getIdTipiSanc());
            }
            if(tipificacionSancionDTO.getIdTipificacion() != null){
                tipificacion = new PghTipificacion(tipificacionSancionDTO.getIdTipificacion());
                registro.setPghTipificacion(tipificacion);
            }
            if(tipificacionSancionDTO.getIdTipoSancion() != null){
                tipoSancion = new PghTipoSancion(tipificacionSancionDTO.getIdTipoSancion());
                registro.setPghTipoSancion(tipoSancion);
            }
            if(tipificacionSancionDTO.getCriterio()!=null){
            	PghCriterio criterio = new PghCriterio();
            	criterio.setIdCriterio(tipificacionSancionDTO.getCriterio().getIdCriterio());
            	registro.setIdCriterio(criterio);
            }
            MdiMaestroColumna nivel = new MdiMaestroColumna();
            nivel.setIdMaestroColumna(tipificacionSancionDTO.getNivel().getIdMaestroColumna());
            registro.setNivel(nivel);
            registro.setEstado(tipificacionSancionDTO.getEstado());
        }
        return registro;
    }
    
    public static List<TipificacionSancionDTO> getListaTipificacionSancion(List<PghTipificacionSancion> listaTipificacionSancion) {
        List<TipificacionSancionDTO> listaTipificacionSancionDTO = new ArrayList<TipificacionSancionDTO>();
        if (!CollectionUtils.isEmpty(listaTipificacionSancion)) {
            TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO();
            for (PghTipificacionSancion tipificacionSancion : listaTipificacionSancion) {
                tipificacionSancionDTO = getTipificacionSancion(tipificacionSancion);
                listaTipificacionSancionDTO.add(tipificacionSancionDTO);
            }
        }
        return listaTipificacionSancionDTO;
    }

    public static TipificacionSancionDTO getTipificacionSancion(PghTipificacionSancion tipificacionSancion) {
        TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO();
        if (tipificacionSancion != null) {
            if(tipificacionSancion.getIdTipiSanc() != null){
                tipificacionSancionDTO.setIdTipiSanc(tipificacionSancion.getIdTipiSanc());
            }
            if(tipificacionSancion.getIdCriterio()!=null){
            	CriterioDTO criterio = new CriterioDTO();
            	criterio.setIdCriterio(tipificacionSancion.getIdCriterio().getIdCriterio());
            	tipificacionSancionDTO.setCriterio(criterio);
            }
            
            tipificacionSancionDTO.setIdTipificacion(tipificacionSancion.getPghTipificacion().getIdTipificacion());
            tipificacionSancionDTO.setIdTipoSancion(tipificacionSancion.getPghTipoSancion().getIdTipoSancion());
            tipificacionSancionDTO.setEstado(tipificacionSancion.getEstado());
            //tipoSancion
// 05-11-2015
            TipoSancionDTO tipoSancionDTO=new TipoSancionDTO(tipificacionSancion.getPghTipoSancion().getIdTipoSancion(),tipificacionSancion.getPghTipoSancion().getDescripcion(),tipificacionSancion.getPghTipoSancion().getAbreviatura());
            tipificacionSancionDTO.setTipoSancion(tipoSancionDTO);
            System.out.println(" ABREVIATURA XX>"+ tipificacionSancionDTO.getTipoSancion().getAbreviatura());
//
            //nivel
            if(tipificacionSancion.getNivel()!=null){
                MaestroColumnaDTO nivel =new MaestroColumnaDTO();
                nivel.setIdMaestroColumna(tipificacionSancion.getNivel().getIdMaestroColumna());
                tipificacionSancionDTO.setNivel(nivel);
            }            
        }
        return tipificacionSancionDTO;
    }

	public static List<TipificacionSancionDTO> getListaTipificacionBySancion(List<Object[]> listaSanciones) {
		List<TipificacionSancionDTO> retorno = new ArrayList<TipificacionSancionDTO>(); 
		if(listaSanciones!=null){
			TipificacionSancionDTO sancion = null;
			for(Object[] maestro : listaSanciones ){
				sancion = new TipificacionSancionDTO();
				sancion.setIdTipiSanc(new Long(maestro[0].toString()));
				sancion.setIdTipoSancion(new Long(maestro[1].toString()));
				sancion.setDescripcionSancion(maestro[2].toString());
				retorno.add(sancion);
			}
		}
		return retorno;
	}
	
	public static List<TipificacionSancionDTO> getListaTipificacionBySancionCriterio(List<Object[]> listaSanciones) {
		List<TipificacionSancionDTO> retorno = new ArrayList<TipificacionSancionDTO>(); 
		if(listaSanciones!=null){
			TipificacionSancionDTO sancion = null;
			for(Object[] maestro : listaSanciones ){
				sancion = new TipificacionSancionDTO();
				sancion.setIdTipiSanc(new Long(maestro[0].toString()));
				sancion.setIdTipoSancion(new Long(maestro[1].toString()));
				sancion.setDescripcionSancion(maestro[2].toString());
				sancion.setIdTipificacion(new Long(maestro[3].toString()));
				retorno.add(sancion);
			}
		}
		return retorno;
	}

}
