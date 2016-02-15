/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.in;

import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

/**
 *
 * @author jpiro
 */
public class GuardarCnfRequProcedimientoInRO {
    private CnfRequProcedimientoDTO cnfRequProcedimiento;
    private UsuarioDTO usuario;

    public CnfRequProcedimientoDTO getCnfRequProcedimiento() {
        return cnfRequProcedimiento;
    }

    public void setCnfRequProcedimiento(CnfRequProcedimientoDTO cnfRequProcedimiento) {
        this.cnfRequProcedimiento = cnfRequProcedimiento;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
}
