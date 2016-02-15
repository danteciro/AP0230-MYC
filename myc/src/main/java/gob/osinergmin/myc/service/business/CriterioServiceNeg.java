/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleDocumentoCriterioDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CriterFilter;
import gob.osinergmin.myc.domain.ui.CriterioFilter;
import gob.osinergmin.myc.domain.ui.CriterioImplFilter;

import java.util.List;

/**
 *
 * @author lbarboza
 */
public interface CriterioServiceNeg {
    public CriterioDTO guardaCriterio(CriterioDTO criterioDTO, List<DetalleCriterioDTO> listaDetalleCriterio, List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio, UsuarioDTO usuarioDTO);
    public CriterioDTO actualizarCriterio(CriterioDTO criterioDTO, UsuarioDTO usuarioDTO);
    public CriterioDTO eliminarCriterio(CriterioDTO criterioDTO);
//    public List<CriterioDTO> listarCriterio(CriterioFilter filtro, int[] cuenta);
    public List<CriterioDTO> listarCriterio(CriterioDTO criterio);
    public List<DetalleCriterioDTO> listarSancionEspecificaCriterio(Long idCriterio);
    public List<DetalleCriterioDTO> listarDetalleCriterio(Long idCriterio);
    public List<DetalleDocumentoCriterioDTO> listarDetalleDocumentoCriterio(Long idCriterio);
    public DetalleCriterioDTO guardaDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO, UsuarioDTO usuarioDTO);
    public DetalleDocumentoCriterioDTO guardaDetalleDocumentoCriterio(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO, UsuarioDTO usuarioDTO);
    public DetalleCriterioDTO eliminarDetalleCriterio(DetalleCriterioDTO detalleCriterio);
    public DetalleDocumentoCriterioDTO eliminarDetalleDocumentoCriterio(Long idDetalleDocumentoCriterio, UsuarioDTO usuarioDTO);
    
	public List<CriterioDTO> listarCriterioImpl(CriterioImplFilter filtro,int[] cuenta);
	public CriterioDTO guardaCriterio(CriterioDTO criterio,UsuarioDTO usuarioDTO);
	public CriterioDTO guardaCriterioMaestro(CriterioDTO criterio,UsuarioDTO usuarioDTO, Long idTipificacion, String[] listaSanciones);
	public CriterioDTO editarCriterioMaestro(CriterioDTO criterio,UsuarioDTO usuarioDTO, Long idTipificacion, String[] listaSanciones);
	public CriterioDTO obtenerCriterio(Long idCriterio);
	
	//Eliminar_lgarcia
	public CriterioDTO eliminarCriterio(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO);
    
}