/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;

/**
 *
 * @author jpiro
 */
public class GuardarProcedimientoOutRO extends BaseOutBean{
    private ProcedimientoDTO procedimiento;

    public ProcedimientoDTO getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(ProcedimientoDTO procedimiento) {
        this.procedimiento = procedimiento;
    }
    
}
