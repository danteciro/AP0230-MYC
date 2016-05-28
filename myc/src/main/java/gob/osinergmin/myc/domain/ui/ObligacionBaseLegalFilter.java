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
public class ObligacionBaseLegalFilter extends BasePaginatorFilter{
    private Long idOblBase;
    private Long idObligacion;
    private Long idBaseLegal;

    public Long getIdOblBase() {
        return idOblBase;
    }

    public void setIdOblBase(Long idOblBase) {
        this.idOblBase = idOblBase;
    }

    public Long getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Long idObligacion) {
        this.idObligacion = idObligacion;
    }

    public Long getIdBaseLegal() {
        return idBaseLegal;
    }

    public void setIdBaseLegal(Long idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }
}