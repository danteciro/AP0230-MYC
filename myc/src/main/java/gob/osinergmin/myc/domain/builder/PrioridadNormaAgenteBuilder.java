/**
* Resumen           
* Objeto            : PrioridadNormaAgenteBuilder.java
* Descripción       : Clase builder de prioridad norma agente en el MYC.
* Fecha de Creación : 04/07/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernandez.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.domain.builder;
import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghBaseLegal;
import gob.osinergmin.myc.domain.PghNormaAgentePrioridad;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.PrioridadNormaAgenteDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdiosesf
 */
public class PrioridadNormaAgenteBuilder {
    public static List<PrioridadNormaAgenteDTO> toListPrioridadNormaAgenteDto(List<PghNormaAgentePrioridad> lista) {
    	PrioridadNormaAgenteDTO registroDTO;
        List<PrioridadNormaAgenteDTO> retorno = new ArrayList<PrioridadNormaAgenteDTO>();
        if (lista != null) {
            for (PghNormaAgentePrioridad norma : lista) {
                registroDTO = toPrioridadNormaAgenteDto(norma);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    public static PrioridadNormaAgenteDTO toPrioridadNormaAgenteDto(PghNormaAgentePrioridad registro) {
    	PrioridadNormaAgenteDTO registroDTO = new PrioridadNormaAgenteDTO();   	
    	registroDTO.setIdPrioridadNormaAgente(registro.getIdNormaAgentePrioridad());    	
    	if(registro.getOrden() != null) 
    		registroDTO.setOrden(registro.getOrden());     	
    	if(registro.getIdBaseLegal()!=null){
    		BaseLegalDTO baseLegalDTO = new BaseLegalDTO();
    		baseLegalDTO.setIdBaseLegal(registro.getIdBaseLegal().getIdBaseLegal());
    		baseLegalDTO.setCodigoBaseLegal(registro.getIdBaseLegal().getCodigoBaseLegal());
    		baseLegalDTO.setDescripcionGeneralBaseLegal(registro.getIdBaseLegal().getDescripcion());
    		baseLegalDTO.setEstado(registro.getIdBaseLegal().getEstado());
    		registroDTO.setIdBaseLegal(baseLegalDTO);
    	}    	
    	if(registro.getIdAgente()!=null){	
    		ActividadDTO actividadDTO = new ActividadDTO();
    		actividadDTO.setIdActividad(registro.getIdAgente().getIdActividad());
    		actividadDTO.setNombre(registro.getIdAgente().getNombre());
    		registroDTO.setIdAgente(actividadDTO);
    	}        
        return registroDTO;
    }    
    
    public static PghNormaAgentePrioridad toPrioridadNormaAgentePgh(PrioridadNormaAgenteDTO registro) {
    	PghNormaAgentePrioridad registroPGH = new PghNormaAgentePrioridad();   	
    	registroPGH.setIdNormaAgentePrioridad(registro.getIdPrioridadNormaAgente()); 
    	registroPGH.setEstado(registro.getEstado());
    	if(registro.getOrden() != null) 
    		registroPGH.setOrden(registro.getOrden());     	
    	if(registro.getIdBaseLegal()!=null){
    		PghBaseLegal baseLegalPGH = new PghBaseLegal();
    		baseLegalPGH.setIdBaseLegal(registro.getIdBaseLegal().getIdBaseLegal());
    		baseLegalPGH.setCodigoBaseLegal(registro.getIdBaseLegal().getCodigoBaseLegal());
    		baseLegalPGH.setDescripcion(registro.getIdBaseLegal().getDescripcionGeneralBaseLegal());
    		baseLegalPGH.setEstado(registro.getIdBaseLegal().getEstado());
    		registroPGH.setIdBaseLegal(baseLegalPGH);
    	}    	
    	if(registro.getIdAgente()!=null){	
    		MdiActividad actividadMDI = new MdiActividad();
    		actividadMDI.setIdActividad(registro.getIdAgente().getIdActividad());
    		actividadMDI.setNombre(registro.getIdAgente().getNombre());
    		registroPGH.setIdAgente(actividadMDI);
    	}        
        return registroPGH;
    }    
    
    public static List<PrioridadNormaAgenteDTO> toListPrioridadNormaDto(List<Object[]> lista) {
    	PrioridadNormaAgenteDTO registroDTO;
        List<PrioridadNormaAgenteDTO> retorno = new ArrayList<PrioridadNormaAgenteDTO>();
        if (lista != null) {
            for (Object[] norma : lista) {
                registroDTO = toPrioridadNormaAgenteDto(norma);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    }
    
    public static PrioridadNormaAgenteDTO toPrioridadNormaAgenteDto(Object[] registro) {
    	PrioridadNormaAgenteDTO registroDTO = new PrioridadNormaAgenteDTO();   	
    	registroDTO.setIdPrioridadNormaAgente(new Long(registro[0].toString())); 
    	ActividadDTO actividadDTO = new ActividadDTO();
    	if(registro[1] != null)
    		actividadDTO.setIdActividad(new Long(registro[1].toString()));
   		registroDTO.setIdAgente(actividadDTO);
    	BaseLegalDTO baseLegalDTO = new BaseLegalDTO();
    	if(registro[2] != null) 
    		baseLegalDTO.setIdBaseLegal(new Long(registro[2].toString()));
    	if(registro[3] != null) 
    		registroDTO.setEstado(registro[3].toString());  
    	if(registro[4] != null) 
    		registroDTO.setOrden(new Long(registro[4].toString()));  
    	if(registro[6] != null) 
    		baseLegalDTO.setCodigoBaseLegal(registro[6].toString());
    	if(registro[7] != null) 
    		baseLegalDTO.setDescripcionGeneralBaseLegal(registro[7].toString());
    	if(registro[8] != null) 
    		baseLegalDTO.setEstado(registro[8].toString());
    	registroDTO.setIdBaseLegal(baseLegalDTO);   	
    	
        return registroDTO;
    }    
}
