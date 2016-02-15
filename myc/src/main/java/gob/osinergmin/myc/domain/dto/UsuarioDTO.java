/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

import java.io.Serializable;

/**
 *
 * @author jpiro
 */
public class UsuarioDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String terminal;

    public UsuarioDTO() {
            super();
    }

    public UsuarioDTO(String codigo, String terminal) {
            super();
            this.codigo = codigo;
            this.terminal = terminal;
    }

    public String getCodigo() {
            return codigo;
    }

    public void setCodigo(String codigo) {
            this.codigo = codigo;
    }

    public String getTerminal() {
            return terminal;
    }

    public void setTerminal(String terminal) {
            this.terminal = terminal;
    }
}
