/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.osinergmin.myc.domain;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gvillanueva
 */
@Entity
@Table(name = "PGH_OBLI_TIPI_CRITERIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghObliTipiCriterio.findAll", query = "SELECT p FROM PghObliTipiCriterio p"),
    @NamedQuery(name = "PghObliTipiCriterio.findByIdObliTipiCriterio", query = "SELECT p FROM PghObliTipiCriterio p WHERE p.idObliTipiCriterio = :idObliTipiCriterio"),
    @NamedQuery(name = "PghObliTipiCriterio.findByEstado", query = "SELECT p FROM PghObliTipiCriterio p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghObliTipiCriterio.findByUsuarioCreacion", query = "SELECT p FROM PghObliTipiCriterio p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghObliTipiCriterio.findByFechaCreacion", query = "SELECT p FROM PghObliTipiCriterio p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghObliTipiCriterio.findByTerminalCreacion", query = "SELECT p FROM PghObliTipiCriterio p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghObliTipiCriterio.findByUsuarioActualizacion", query = "SELECT p FROM PghObliTipiCriterio p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghObliTipiCriterio.findByFechaActualizacion", query = "SELECT p FROM PghObliTipiCriterio p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghObliTipiCriterio.findByTerminalActualizacion", query = "SELECT p FROM PghObliTipiCriterio p WHERE p.terminalActualizacion = :terminalActualizacion")})
public class PghObliTipiCriterio extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OBLI_TIPI_CRITERIO")
    @SequenceGenerator(name = "PGH_OBLI_TIPI_CRITERIO_ID", sequenceName = "PGH_OBLI_TIPI_CRITERIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PGH_OBLI_TIPI_CRITERIO_ID")
    private Long idObliTipiCriterio;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_TIPIFICACION", referencedColumnName = "ID_TIPIFICACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghTipificacion idTipificacion;
    @Column(name = "ID_ACTIVIDAD")
    private Long idActividad;
    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghObligacion idObligacion;
    @JoinColumn(name = "ID_CRITERIO", referencedColumnName = "ID_CRITERIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghCriterio idCriterio;

	public PghObliTipiCriterio() {
    }

    public PghObliTipiCriterio(Long idObliTipiCriterio) {
        this.idObliTipiCriterio = idObliTipiCriterio;
    }

    public PghObliTipiCriterio(Long idObliTipiCriterio, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idObliTipiCriterio = idObliTipiCriterio;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdObliTipiCriterio() {
        return idObliTipiCriterio;
    }

    public void setIdObliTipiCriterio(Long idObliTipiCriterio) {
        this.idObliTipiCriterio = idObliTipiCriterio;
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

    public PghCriterio getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(PghCriterio idCriterio) {
        this.idCriterio = idCriterio;
    }


	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idObliTipiCriterio != null ? idObliTipiCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghObliTipiCriterio)) {
            return false;
        }
        PghObliTipiCriterio other = (PghObliTipiCriterio) object;
        if ((this.idObliTipiCriterio == null && other.idObliTipiCriterio != null) || (this.idObliTipiCriterio != null && !this.idObliTipiCriterio.equals(other.idObliTipiCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghObliTipiCriterio[ idObliTipiCriterio=" + idObliTipiCriterio + " ]";
    }
    
}
