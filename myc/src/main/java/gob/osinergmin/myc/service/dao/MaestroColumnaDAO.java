package gob.osinergmin.myc.service.dao;

import java.util.List;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroColumnaFilter;
import gob.osinergmin.myc.service.exception.MaestroColumnaException;

public interface MaestroColumnaDAO {

    public MaestroColumnaDTO changeState(MaestroColumnaDTO maestroColumnaDTO,UsuarioDTO usuarioDTO);
    public MaestroColumnaDTO update(MaestroColumnaDTO maestroColumnaDTO,UsuarioDTO usuarioDTO) throws MaestroColumnaException;
    public MaestroColumnaDTO create(MaestroColumnaDTO maestroColumnaDTO,UsuarioDTO usuarioDTO) throws MaestroColumnaException;
    public MaestroColumnaDTO findById(Long idMaestroColumna) throws MaestroColumnaException;
    public List<MaestroColumnaDTO> findMaestroColumna(String dominio, String aplicacion);
    public List<MaestroColumnaDTO> findByDescripHijos(Long idMaestroColumna, String aplicacion,String estado);
    public List<MaestroColumnaDTO> find(MaestroColumnaFilter filtro) throws MaestroColumnaException;    
    public Long count(MaestroColumnaFilter filtro) throws MaestroColumnaException;    
        
        public List<MaestroColumnaDTO> findTipoNormaLegal() throws Exception;
	    public List<MaestroColumnaDTO> findComponente() throws Exception;
	    public List<MaestroColumnaDTO> findSigla() throws Exception;
	    public List<MaestroColumnaDTO> findTipoAnexo() throws Exception;
	    public List<MaestroColumnaDTO> findNumeroDisposicion() throws Exception;
	    public List<MaestroColumnaDTO> findTipoDisposicion() throws Exception;
	    /*Rsis 11 - Inicio*/
	    public List<MaestroColumnaDTO> findMedidaSeguridad() throws Exception;
	    public List<MaestroColumnaDTO> findAccionInfraccion() throws Exception;
	    public List<MaestroColumnaDTO> findEscenario() throws Exception;
	    /*Rsis 11 - Fin*/
	    /*Rsis 1 - Inicio*/
	    public List<MaestroColumnaDTO> findNumeroAnexo(String codigo) throws Exception;
	    /*Rsis 1 - Fin*/
	    public List<MaestroColumnaDTO> findTemas() throws Exception;
	    public List<MaestroColumnaDTO> findCriticidad() throws Exception;
	    public List<MaestroColumnaDTO> findNormaTecnica() throws Exception;
		List<MaestroColumnaDTO> findMaestroColumnaByCodigo(String dominio,String aplicacion, String codigo);
}
