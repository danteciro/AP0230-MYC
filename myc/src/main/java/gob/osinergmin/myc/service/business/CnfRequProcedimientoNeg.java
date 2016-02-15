/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarCnfRequProcedimientoInRO;
import gob.osinergmin.myc.domain.in.GuardarProcedimientoInRO;
import gob.osinergmin.myc.domain.out.GuardarCnfRequProcedimientoOutRO;
import gob.osinergmin.myc.domain.out.GuardarProcedimientoOutRO;
import gob.osinergmin.myc.domain.ui.CnfRequProcedimientoFilter;
import gob.osinergmin.myc.service.exception.CnfRequProcedimientoException;
import java.util.List;

/**
 *
 * @author jpiro 
 */
public interface CnfRequProcedimientoNeg {
    public List<CnfRequProcedimientoDTO> listarRequisitosProcedimiento(CnfRequProcedimientoFilter filtro);
    public GuardarProcedimientoOutRO guardarRequisitosProcedimiento(GuardarProcedimientoInRO in) throws CnfRequProcedimientoException;
    public GuardarCnfRequProcedimientoOutRO eliminarCnfRequProcedimiento(GuardarCnfRequProcedimientoInRO in);
    public void actualizarOrdenRequProc(String regModificar,UsuarioDTO usuarioDTO) throws CnfRequProcedimientoException;
}
