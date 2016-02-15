/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author jpiro
 */
public class AutoayudaFilter extends BasePaginatorFilter{
    private Long idAutoayuda;
    private String nombreAutoayuda;
    private String identificadorAutoayuda;

    public Long getIdAutoayuda() {
        return idAutoayuda;
    }

    public void setIdAutoayuda(Long idAutoayuda) {
        this.idAutoayuda = idAutoayuda;
    }

    public String getNombreAutoayuda() {
        return nombreAutoayuda;
    }

    public void setNombreAutoayuda(String nombreAutoayuda) {
        this.nombreAutoayuda = nombreAutoayuda;
    }

    public String getIdentificadorAutoayuda() {
        return identificadorAutoayuda;
    }

    public void setIdentificadorAutoayuda(String identificadorAutoayuda) {
        this.identificadorAutoayuda = identificadorAutoayuda;
    }
}
