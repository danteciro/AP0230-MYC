/**
* Resumen		
* Objeto            : EtapaTramiteDAO.java
* Descripción       : Clase que proporciona una interfaz para la implementación de métodos en ExpedienteDAOImpl
* Fecha de Creación : 
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |   Fecha       |    Nombre                    |   Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |   Busqueda por filtros
*
*/ 

package gob.osinergmin.myc.service.dao;

import java.util.List;

import gob.osinergmin.myc.domain.dto.EtapaTramiteDTO;
import gob.osinergmin.myc.domain.dto.EtapaTramiteNpsDTO;
import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfTramiteFilter;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;
import gob.osinergmin.myc.domain.ui.EtapaTramiteBusquedaFilter;
import gob.osinergmin.myc.domain.ui.EtapaTramiteFilter;

public interface EtapaTramiteDAO {
	
	public EtapaTramiteNpsDTO create(EtapaTramiteNpsDTO etapaTramiteNpsDTO, UsuarioDTO usuarioDTO);
	public EtapaTramiteNpsDTO update(EtapaTramiteNpsDTO etapaTramiteNpsDTO, UsuarioDTO usuarioDTO);
	public List<EtapaTramiteNpsDTO> listarEtapaTramite(EtapaNpsFilter etapaNpsFilter, ConfTramiteFilter confTramiteFilter);
	public boolean delete(EtapaTramiteNpsDTO etapaTramiteNpsDTO, UsuarioDTO usuarioDTO);
	public EtapaTramiteNpsDTO findByIdEtapaTramite(Long idEtapaTramite);
	public List<EtapaTramiteNpsDTO> buscarEtapaTramite(EtapaTramiteBusquedaFilter etapaTramiteBusquedaFilter);
	public boolean validaEtapaTramiteBySubEtapa(SubEtapaNpsDTO subEtapaNpsDTO);
        
        /* OSINE_SFS-1232 - lgarciar - Inicio */
        public List<EtapaTramiteDTO> listarEtapaTramite(EtapaTramiteFilter filtro);
        /* OSINE_SFS-1232 - lgarciar - Fin */
	
}
