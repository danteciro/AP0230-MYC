/**
* Resumen           
* Objeto            : PrioridadNormaAgenteDAO.java
* Descripción       : Clase de acceso a datos de prioridad norma agente en el MYC.
* Fecha de Creación : 04/07/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernandez.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.service.dao;
import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.PrioridadNormaAgenteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.PrioridadNormaAgenteFilter;
import gob.osinergmin.myc.service.exception.PrioridadNormaAgenteException;
import java.util.List;

public interface PrioridadNormaAgenteDAO { 
	public List<PrioridadNormaAgenteDTO> find(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException;
    public Long count(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException;
    public List<BaseLegalDTO> findBaseLegalByIdAgente(Long idAgente) throws PrioridadNormaAgenteException;
    public PrioridadNormaAgenteDTO update(PrioridadNormaAgenteDTO prioridadNormaAgenteDTO,UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException;
    public PrioridadNormaAgenteDTO create(PrioridadNormaAgenteDTO prioridadNormaAgenteDTO,UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException;
    public List<PrioridadNormaAgenteDTO> findPrioridadNormaAgente(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException;
    public List<PrioridadNormaAgenteDTO> findPrioridadNormaEdit(PrioridadNormaAgenteFilter filtro) throws PrioridadNormaAgenteException;
    public void eliminarPrioridadNorma(Long idObject, String tipo, UsuarioDTO usuarioDTO) throws PrioridadNormaAgenteException;
}
