/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.out;

import java.io.File;

import gob.osinergmin.myc.domain.base.BaseOutBean;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;

/**
 *
 * @author jpiro
 */
public class GuardarRequisitoOutRO extends BaseOutBean {
    private RequisitoDTO requisito;
    private File archivo;

    public RequisitoDTO getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitoDTO requisito) {
        this.requisito = requisito;
    }

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
    
}
