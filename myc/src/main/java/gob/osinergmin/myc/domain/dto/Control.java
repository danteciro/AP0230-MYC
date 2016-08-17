package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;

/**
 *
 * @author jpiro
 */
public class Control {
    private String mensajeValidacion=BaseConstantesOutBean.MENSAJE_VALIDA_DEFAULT;

    public String getMensajeValidacion() {
        return mensajeValidacion;
    }

    public void setMensajeValidacion(String mensajeValidacion) {
        this.mensajeValidacion = mensajeValidacion;
    }

}
