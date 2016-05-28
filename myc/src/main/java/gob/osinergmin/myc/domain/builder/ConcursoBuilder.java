/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.MdiConcurso;
import gob.osinergmin.myc.domain.dto.ConcursoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public class ConcursoBuilder {
    public static MdiConcurso getConcurso(ConcursoDTO concursoDTO){
        MdiConcurso registro = null;
        if(concursoDTO != null){
            registro = new MdiConcurso();
            if(concursoDTO.getIdConcurso() != null){
                registro.setIdConcurso(concursoDTO.getIdConcurso());
            }
            registro.setNumeroConcurso(concursoDTO.getNumeroConcurso());
            registro.setNombreConcurso(concursoDTO.getNombreConcurso());
            registro.setDescripcionConcurso(concursoDTO.getDescripcionConcurso());
            registro.setEstado(concursoDTO.getEstado());
        }
        return registro;
    }
    
    public static List<ConcursoDTO> toListConcursoDto(List<MdiConcurso> lista){
        ConcursoDTO concursoDTO;
        List<ConcursoDTO> retorno = new ArrayList<ConcursoDTO>();
        if(lista != null){
            for(MdiConcurso maestro : lista){
                concursoDTO = toConcursoDto(maestro);
                retorno.add(concursoDTO);
            }
        }
        return retorno;
    }
    
    public static ConcursoDTO toConcursoDto(MdiConcurso registro){
        ConcursoDTO registroDTO = new ConcursoDTO();
        
        registroDTO.setIdConcurso(registro.getIdConcurso());
        registroDTO.setNumeroConcurso(registro.getNumeroConcurso());
        registroDTO.setNombreConcurso(registro.getNombreConcurso());
        registroDTO.setDescripcionConcurso(registro.getDescripcionConcurso());
        registroDTO.setEstado(registro.getEstado());
        
        return registroDTO;
    }
}