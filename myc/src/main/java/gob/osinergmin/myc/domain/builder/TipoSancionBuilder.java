/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghTipoSancion;
import gob.osinergmin.myc.domain.dto.TipoSancionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public class TipoSancionBuilder {
    public static PghTipoSancion getTipoSancion(TipoSancionDTO tipoSancionDTO){
        PghTipoSancion registro = null;
        if(tipoSancionDTO != null){
            registro = new PghTipoSancion();
            if(tipoSancionDTO.getIdTipoSancion() != null){
                registro.setIdTipoSancion(tipoSancionDTO.getIdTipoSancion());
            }
            registro.setDescripcion(tipoSancionDTO.getDescripcion());
            registro.setEstado(tipoSancionDTO.getEstado().charAt(0));
        }
        return registro;
    }
    
    public static List<TipoSancionDTO> toListTipoSancionDto(List<PghTipoSancion> lista){
        TipoSancionDTO registroDTO;
        List<TipoSancionDTO> retorno = new ArrayList<TipoSancionDTO>();
        if(lista != null){
            for(PghTipoSancion maestro : lista){
                registroDTO = toTipoSancionDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    
    public static TipoSancionDTO toTipoSancionDto(PghTipoSancion registro){
        
        TipoSancionDTO registroDTO = new TipoSancionDTO();
        
        registroDTO.setIdTipoSancion(registro.getIdTipoSancion());
        registroDTO.setDescripcion(registro.getDescripcion());
        registroDTO.setEstado(registro.getEstado().toString());
        
        return registroDTO;
    }
}