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
public class TipificacionFilter extends BasePaginatorFilter{
    private Long idTipificacion;
    private String descripcion;
    private String codigoObligacion;
    private String codTipificacion;

    public Long getIdTipificacion() {
        return idTipificacion;
    }

    public String getCodTipificacion() {
		return codTipificacion;
	}

	public void setCodTipificacion(String codTipificacion) {
		this.codTipificacion = codTipificacion;
	}

	public void setIdTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoObligacion() {
        return codigoObligacion;
    }

    public void setCodigoObligacion(String codigoObligacion) {
        this.codigoObligacion = codigoObligacion;
    }
}