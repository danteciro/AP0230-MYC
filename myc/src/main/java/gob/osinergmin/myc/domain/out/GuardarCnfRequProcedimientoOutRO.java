/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.out;

import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;

/**
 *
 * @author jpiro
 */
public class GuardarCnfRequProcedimientoOutRO extends BaseOutBean {
    private CnfRequProcedimientoDTO cnfRequProcedimiento;

    public CnfRequProcedimientoDTO getCnfRequProcedimiento() {
        return cnfRequProcedimiento;
    }

    public void setCnfRequProcedimiento(CnfRequProcedimientoDTO cnfRequProcedimiento) {
        this.cnfRequProcedimiento = cnfRequProcedimiento;
    }
    
}
