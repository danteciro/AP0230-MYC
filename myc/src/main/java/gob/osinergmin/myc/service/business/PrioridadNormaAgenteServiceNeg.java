/**
* Resumen           
* Objeto            : PrioridadNormaAgenteServiceNeg.java
* Descripción       : Servicios de Negocio prioridad norma agente en el MYC.
* Fecha de Creación : 28/06/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Erick Ortiz Gil.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ListaPrioridadNormaAgenteDTO;
import gob.osinergmin.myc.domain.dto.PrioridadNormaAgenteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.PrioridadNormaAgenteFilter;
import gob.osinergmin.myc.service.exception.PrioridadNormaAgenteException;

import java.util.List;
import java.util.Map;

public interface PrioridadNormaAgenteServiceNeg {   
    public List<PrioridadNormaAgenteDTO> listarPrioridadNormaAgente(PrioridadNormaAgenteFilter filtro, int[] cuenta) throws PrioridadNormaAgenteException;
    public List<PrioridadNormaAgenteDTO> listarPrioridadNormaAgente(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException;
    public List<PrioridadNormaAgenteDTO> findPrioridadNormaAgenteByFilter(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException;
    public List<BaseLegalDTO> findBaseLegalByIdAgente(Long idAgente) throws PrioridadNormaAgenteException;    
    public Map<String, Object> actualizarPrioridadNormaAgente(ListaPrioridadNormaAgenteDTO listaPrioridad, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException;
    public Map<String, Object> guardarPrioridadNormaAgente(ListaPrioridadNormaAgenteDTO listaPrioridad, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException;
    /**
     * Elimina prioridad norma agente segun tipo de accion
     * @param idObjeto id objeto clave para eliminacion
     * @param tipo tipo de valdiacion de eliminacion
     * @return 
     */
    public Map<String, Object> eliminarPrioridadNormaAgente(Long idObjeto, String tipo, UsuarioDTO usuarioDTO);
}