/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.builder;

import gob.osinergmin.myc.domain.PghCnfRequProcedimiento;
import gob.osinergmin.myc.domain.PghRequProcParaDina;
import gob.osinergmin.myc.domain.PghValorParametro;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.service.business.impl.ParametroServiceNegImpl;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
public class RequProcParaDinaBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ParametroServiceNegImpl.class);
    
    public static PghRequProcParaDina getRequProcParaDina(RequProcParaDinaDTO registroDTO) {
        PghRequProcParaDina registro = null;
        if(registroDTO!=null){
            registro=new PghRequProcParaDina();
            registro.setIdValorParametro(new PghValorParametro(registroDTO.getValorParametro().getIdValorParametro()));
            registro.setIdRequisitoProcedimiento(new PghCnfRequProcedimiento(registroDTO.getIdRequisitoProcedimiento()));
            registro.setEstado(registroDTO.getEstado());
        }
        return registro;

    }
    
    public static List<RequProcParaDinaDTO> toListRequProcParaDinaDto(List<PghRequProcParaDina> lista) {
        RequProcParaDinaDTO registroDTO;
        List<RequProcParaDinaDTO> retorno = new ArrayList<RequProcParaDinaDTO>();
        if (lista != null) {
            for (PghRequProcParaDina maestro : lista) {
                registroDTO = toRequProcParaDinaDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    public static RequProcParaDinaDTO toRequProcParaDinaDto(PghRequProcParaDina registro) {
        RequProcParaDinaDTO registroDTO = new RequProcParaDinaDTO();
        
        registroDTO.setIdRequProcParaDina(registro.getIdRequProcParaDina());
        if(registro.getIdRequisitoProcedimiento()!=null){
            registroDTO.setIdRequisitoProcedimiento(registro.getIdRequisitoProcedimiento().getIdRequisitoProcedimiento());
        }
        if(registro.getIdValorParametro()!=null){
            ValorParametroDTO valorParametro=new ValorParametroDTO();
            valorParametro.setIdValorParametro(registro.getIdValorParametro().getIdValorParametro());
            valorParametro.setDescripcion(registro.getIdValorParametro().getDescripcion());
            valorParametro.setValor(registro.getIdValorParametro().getValor());
            valorParametro.setIdParametroDinamico(registro.getIdValorParametro().getIdParametroDinamico().getIdParametroDinamico());
            valorParametro.setAmbito(registro.getIdValorParametro().getIdParametroDinamico().getIdAmbitoParametrico().getDescripcion());
            registroDTO.setValorParametro(valorParametro);
        }
        
        
        return registroDTO;
    }
}
