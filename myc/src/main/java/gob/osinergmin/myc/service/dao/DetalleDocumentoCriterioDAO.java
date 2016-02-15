/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.DetalleDocumentoCriterioDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author lchancayauri
 */
public interface DetalleDocumentoCriterioDAO {
    
    public DetalleDocumentoCriterioDTO create(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO,UsuarioDTO usuarioDTO);
    public DetalleDocumentoCriterioDTO update(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO,UsuarioDTO usuarioDTO);
    public List<DetalleDocumentoCriterioDTO> obtenerDetalleDocumentoCriterio(Long idCriterio);
    public DetalleDocumentoCriterioDTO obtenerDetalleDocumentoCriterioById(Long idDetalleDocumentoCriterio);
    public DetalleDocumentoCriterioDTO changeState(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO);
    
}
