/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_TRAZABILIDAD_OBLIGACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTrazabilidadObligaciones.findAll", query = "SELECT p FROM PghTrazabilidadObligaciones p")})
public class PghTrazabilidadObligaciones extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRAZABILIDAD")
    private Long idTrazabilidad;
    @Size(max = 20)
    @Column(name = "COD_TRAZABILIDAD")
    private String codTrazabilidad;
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigencia;

    public PghTrazabilidadObligaciones() {
    }

    public PghTrazabilidadObligaciones(Long idTrazabilidad) {
        this.idTrazabilidad = idTrazabilidad;
    }

    public PghTrazabilidadObligaciones(Long idTrazabilidad, String usuarioCreacion, String terminalCreacion, Date fechaCreacion) {
        this.idTrazabilidad = idTrazabilidad;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdTrazabilidad() {
        return idTrazabilidad;
    }

    public void setIdTrazabilidad(Long idTrazabilidad) {
        this.idTrazabilidad = idTrazabilidad;
    }

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrazabilidad != null ? idTrazabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTrazabilidadObligaciones)) {
            return false;
        }
        PghTrazabilidadObligaciones other = (PghTrazabilidadObligaciones) object;
        if ((this.idTrazabilidad == null && other.idTrazabilidad != null) || (this.idTrazabilidad != null && !this.idTrazabilidad.equals(other.idTrazabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghTrazabilidadObligaciones[ idTrazabilidad=" + idTrazabilidad + " ]";
    }
    
}
