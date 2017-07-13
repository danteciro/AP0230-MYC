/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lbarboza
 */
@Entity
@Table(name = "PGH_OBLIGACION_TIPIFICACION") 
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghObligacionTipificacion.findAll", query = "SELECT p FROM PghObligacionTipificacion p"),
    @NamedQuery(name = "PghObligacionTipificacion.findByIdObligacion", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.idObligacion.idObligacion = :idObligacion"),
    @NamedQuery(name = "PghObligacionTipificacion.findByIdTipificacion", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.idTipificacion.idTipificacion = :idTipificacion"),
    @NamedQuery(name = "PghObligacionTipificacion.findByEstado", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghObligacionTipificacion.findByUsuarioCreacion", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghObligacionTipificacion.findByFechaCreacion", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghObligacionTipificacion.findByTerminalCreacion", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghObligacionTipificacion.findByUsuarioActualizacion", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghObligacionTipificacion.findByFechaActualizacion", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghObligacionTipificacion.findByTerminalActualizacion", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghObligacionTipificacion.findByIdObliTipi", query = "SELECT p FROM PghObligacionTipificacion p WHERE p.idObliTipi = :idObliTipi")})
public class PghObligacionTipificacion extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OBLI_TIPI")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_OBLI_TIPI_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idObliTipi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ID_ACTIVIDAD")
    private Long idActividad;
//    @JoinColumn(name = "ID_TIPIFICACION", referencedColumnName = "ID_TIPIFICACION", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private PghTipificacion pghTipificacion;
//    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private PghObligacion pghObligacion;
    @JoinColumn(name = "ID_TIPIFICACION", referencedColumnName = "ID_TIPIFICACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghTipificacion idTipificacion;
    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghObligacion idObligacion;
    
    public PghObligacionTipificacion() {
    }

//    public PghObligacionTipificacion(PghObligacionTipificacionPK pghObligacionTipificacionPK) {
//        this.pghObligacionTipificacionPK = pghObligacionTipificacionPK;
//    }
//
//    public PghObligacionTipificacion(PghObligacionTipificacionPK pghObligacionTipificacionPK, String estado) {
//        this.pghObligacionTipificacionPK = pghObligacionTipificacionPK;
//        this.estado = estado;
//    }
//
//    public PghObligacionTipificacion(Long idObligacion, Long idTipificacion, Long idObliTipi) {
//        this.pghObligacionTipificacionPK = new PghObligacionTipificacionPK(idObligacion, idTipificacion, idObliTipi);
//    }
//
//    public PghObligacionTipificacionPK getPghObligacionTipificacionPK() {
//        return pghObligacionTipificacionPK;
//    }
//
//    public void setPghObligacionTipificacionPK(PghObligacionTipificacionPK pghObligacionTipificacionPK) {
//        this.pghObligacionTipificacionPK = pghObligacionTipificacionPK;
//    }

    public Long getIdObliTipi() {
        return idObliTipi;
    }

    public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public void setIdObliTipi(Long idObliTipi) {
        this.idObliTipi = idObliTipi;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghTipificacion getIdTipificacion() {
        return idTipificacion;
    }

    public void setIdTipificacion(PghTipificacion idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

    public PghObligacion getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(PghObligacion idObligacion) {
        this.idObligacion = idObligacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObliTipi != null ? idObliTipi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghObligacionTipificacion)) {
            return false;
        }
        PghObligacionTipificacion other = (PghObligacionTipificacion) object;
        if ((this.idObliTipi == null && other.idObliTipi != null) || (this.idObliTipi != null && !this.idObliTipi.equals(other.idObliTipi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.PghObligacionTipificacion[ idObliTipi=" + idObliTipi + " ]";
    }
    
}
