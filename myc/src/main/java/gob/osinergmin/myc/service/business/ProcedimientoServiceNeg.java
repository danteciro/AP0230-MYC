/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.in.GuardarProcedimientoInRO;
import gob.osinergmin.myc.domain.out.GuardarProcedimientoOutRO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.ProcedimientoFilter;
import gob.osinergmin.myc.service.exception.ProcedimientoException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ProcedimientoServiceNeg {
    public List<ProcedimientoDTO> listarProcedimiento(ProcedimientoFilter filtro, int[] cuenta);    
    public List<ActividadDTO> listarActividadProcedimiento(ActividadFilter filtro, int[] cuenta);
    public GuardarProcedimientoOutRO guardarProcedimiento(GuardarProcedimientoInRO in) throws ProcedimientoException;
    public GuardarProcedimientoOutRO eliminarProcedimiento(GuardarProcedimientoInRO in);
    public ProcedimientoDTO buscarProcedimientoByFiltro(ProcedimientoFilter filtro);
    public GuardarProcedimientoOutRO editarProcedimiento(GuardarProcedimientoInRO in) throws ProcedimientoException;
    public GuardarProcedimientoOutRO validarDependProcedimiento(GuardarProcedimientoInRO in);
}
