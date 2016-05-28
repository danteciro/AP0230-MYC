/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;
import java.math.BigInteger;

/**
 *
 * @author lbarboza
 */
public class ObligacionTipificacionFilter extends BasePaginatorFilter{
    private BigInteger idObliTipi;
    private Long idObligacion;
    private Long idTipificacion;

    public BigInteger getIdObliTipi() {
        return idObliTipi;
    }

    public void setIdObliTipi(BigInteger idObliTipi) {
        this.idObliTipi = idObliTipi;
    }

    public Long getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Long idObligacion) {
        this.idObligacion = idObligacion;
    }

    public Long getIdTipificacion() {
        return idTipificacion;
    }

    public void setIdTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }
}