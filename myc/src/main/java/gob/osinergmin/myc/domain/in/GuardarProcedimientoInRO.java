/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.in;

import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

/**
 *
 * @author jpiro
 */
public class GuardarProcedimientoInRO {
    private ProcedimientoDTO procedimiento;
    private UsuarioDTO usuario;

    public ProcedimientoDTO getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(ProcedimientoDTO procedimiento) {
        this.procedimiento = procedimiento;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
}
