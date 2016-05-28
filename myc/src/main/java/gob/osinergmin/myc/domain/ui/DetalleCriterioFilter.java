/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author lbarboza
 */
public class DetalleCriterioFilter extends BasePaginatorFilter{
    private Long idDetalleCriterio;
    private String sancionEspecifica;

    public Long getIdDetalleCriterio() {
        return idDetalleCriterio;
    }

    public void setIdDetalleCriterio(Long idDetalleCriterio) {
        this.idDetalleCriterio = idDetalleCriterio;
    }

    public String getSancionEspecifica() {
        return sancionEspecifica;
    }

    public void setSancionEspecifica(String sancionEspecifica) {
        this.sancionEspecifica = sancionEspecifica;
    }
}