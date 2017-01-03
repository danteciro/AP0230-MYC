package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroColumnaFilter;
import gob.osinergmin.myc.service.exception.MaestroColumnaException;

import java.util.List;

public interface MaestroColumnaServiceNeg {

    public MaestroColumnaDTO eliminarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO, UsuarioDTO usuarioDTO);
    public MaestroColumnaDTO actualizarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO, UsuarioDTO usuarioDTO) throws MaestroColumnaException;
    public MaestroColumnaDTO guardarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO, UsuarioDTO usuarioDTO) throws MaestroColumnaException;
    public MaestroColumnaDTO findById(Long idMaestroColumna);
    public List<MaestroColumnaDTO> buscarMycByDominio(String dominio) throws Exception;
    public List<MaestroColumnaDTO> buscarByDominioByAplicacion(String dominio,String aplicacion) throws Exception;
    public List<MaestroColumnaDTO> buscarByDescripHijos(Long IdMaestroColumna) throws Exception;
    public List<MaestroColumnaDTO> listarTipoNormaLegal();
    public List<MaestroColumnaDTO> listarComponente() throws Exception;
    public List<MaestroColumnaDTO> listarSigla();
    public List<MaestroColumnaDTO> listarTipoAnexo();
    public List<MaestroColumnaDTO> listarNumeroDisposicion();
    public List<MaestroColumnaDTO> listarTipoDisposicion();
    /*Rsis 11 - Inicio*/
    public List<MaestroColumnaDTO> listarMedidaSeguridad();
    public List<MaestroColumnaDTO> listarAccionInfraccion();
    public List<MaestroColumnaDTO> listarEscenario();
    /*Rsis 11 - Fin*/
    public List<MaestroColumnaDTO> listarNumeroAnexo(String codigo);    
    public List<MaestroColumnaDTO> listarTemas() throws Exception;
    public List<MaestroColumnaDTO> listarCriticidad();
    public List<MaestroColumnaDTO> listarNormaTecnica() throws Exception;
    public List<MaestroColumnaDTO> listarMaestroColumna(MaestroColumnaFilter filtro,int[] cuenta);
    public List<MaestroColumnaDTO> listarMaestroColumna(MaestroColumnaFilter filtro); /* OSINE_SFS-480 - RSIS09 - mdiosesf */
	List<MaestroColumnaDTO> buscarByDominioByAplicacionByCodigo(String dominio,String aplicacion, String codigo) throws Exception;/*OSINE_SFS_480 - RSIS25*/
}
