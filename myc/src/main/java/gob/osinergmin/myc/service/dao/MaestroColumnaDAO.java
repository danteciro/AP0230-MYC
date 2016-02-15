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
	    public List<MaestroColumnaDTO> findTemas() throws Exception;
	    public List<MaestroColumnaDTO> findCriticidad() throws Exception;
	    public List<MaestroColumnaDTO> findNormaTecnica() throws Exception;
}
