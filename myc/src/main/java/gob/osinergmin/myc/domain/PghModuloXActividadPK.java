/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author lchancayauri
 */
@Embeddable
public class PghModuloXActividadPK implements Serializable {
	@Basic(optional = false)
	@Column(name = "ID_MODULO", nullable = false)
	private Long idModulo;
	@Basic(optional = false)
	@Column(name = "ID_ACTIVIDAD", nullable = false)
	private Long idActividad;

	public PghModuloXActividadPK() {
	}

	public PghModuloXActividadPK(Long idModulo, Long idActividad) {
        this.idModulo = idModulo;
        this.idActividad = idActividad;
    }
	
	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PghModuloXActividadPK)) {
			return false;
		}
		PghModuloXActividadPK other = (PghModuloXActividadPK) object;
		if (this.idModulo != other.idModulo) {
			return false;
		}
		if (this.idActividad != other.idActividad) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gob.osinergming.siguoweb.domain.PghModuloXActividadPK[ idModulo="
				+ idModulo + ", idActividad=" + idActividad + " ]";
	}

}
