/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.in;

import java.io.File;

import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;

/**
 *
 * @author jpiro
 */
public class GuardarRequisitoInRO {
    private RequisitoDTO requisito;
    private UsuarioDTO usuario;
    private File file;

    public RequisitoDTO getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitoDTO requisito) {
        this.requisito = requisito;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
    
    
}
