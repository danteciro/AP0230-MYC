/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CnfRequProcedimientoFilter;
import gob.osinergmin.myc.service.exception.CnfRequProcedimientoException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface CnfRequProcedimientoDAO {
    public List<CnfRequProcedimientoDTO> find(CnfRequProcedimientoFilter filtro) throws CnfRequProcedimientoException;    
    public List<RequProcParaDinaDTO> findParaDina(Long idRequisitoProcedimiento) throws CnfRequProcedimientoException;    
    public CnfRequProcedimientoDTO create(CnfRequProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws CnfRequProcedimientoException;
    public CnfRequProcedimientoDTO changeEstado(CnfRequProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws CnfRequProcedimientoException;
    public CnfRequProcedimientoDTO actualizarOrdenRequProc(Long idRequisitoProcedimiento,Long nroOrden, UsuarioDTO usuarioDTO) throws CnfRequProcedimientoException;
}
