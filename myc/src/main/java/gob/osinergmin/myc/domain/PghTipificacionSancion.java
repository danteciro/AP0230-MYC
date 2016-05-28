/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

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
 * @author cflorian
 */
@Entity
@Table(name = "PGH_TIPIFICACION_SANCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTipificacionSancion.countByIdCriterioNivel", query = "SELECT distinct count(p.idTipiSanc) FROM PghTipificacionSancion p WHERE p.estado = :estado and p.idCriterio.idCriterio=:idCriterio and p.nivel.idMaestroColumna=:nivel "),
    @NamedQuery(name = "PghTipificacionSancion.findByIdCriterioNivel", query = "SELECT distinct p FROM PghTipificacionSancion p WHERE p.estado = :estado and p.idCriterio.idCriterio=:idCriterio and p.nivel.idMaestroColumna=:nivel "),
    
    @NamedQuery(name = "PghTipificacionSancion.countAll", query = "SELECT count(p.idTipiSanc) FROM PghTipificacionSancion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghTipificacionSancion.findAll", query = "SELECT p FROM PghTipificacionSancion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghTipificacionSancion.countByIdTipiSanc", query = "SELECT count(p.idTipiSanc) FROM PghTipificacionSancion p WHERE p.idTipiSanc = :idTipiSanc"),
    @NamedQuery(name = "PghTipificacionSancion.findByIdTipiSanc", query = "SELECT p FROM PghTipificacionSancion p WHERE p.idTipiSanc = :idTipiSanc"),
    @NamedQuery(name = "PghTipificacionSancion.countByEstado", query = "SELECT count(p.idTipiSanc) FROM PghTipificacionSancion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghTipificacionSancion.findByEstado", query = "SELECT p FROM PghTipificacionSancion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghTipificacionSancion.findByUsuarioCreacion", query = "SELECT p FROM PghTipificacionSancion p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghTipificacionSancion.findByFechaCreacion", query = "SELECT p FROM PghTipificacionSancion p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghTipificacionSancion.findByTerminalCreacion", query = "SELECT p FROM PghTipificacionSancion p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghTipificacionSancion.findByUsuarioActualizacion", query = "SELECT p FROM PghTipificacionSancion p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghTipificacionSancion.findByFechaActualizacion", query = "SELECT p FROM PghTipificacionSancion p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghTipificacionSancion.findByTerminalActualizacion", query = "SELECT p FROM PghTipificacionSancion p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghTipificacionSancion.countByIdTipificacion", query = "SELECT count(p.idTipiSanc) FROM PghTipificacionSancion p WHERE p.pghTipificacion.idTipificacion = :idTipificacion and p.estado=:estado"),
    @NamedQuery(name = "PghTipificacionSancion.findByIdTipificacion", query = "SELECT p FROM PghTipificacionSancion p WHERE p.pghTipificacion.idTipificacion = :idTipificacion and p.estado=:estado"),
    @NamedQuery(name = "PghTipificacionSancion.countByIdTipoSancion", query = "SELECT count(p.idTipiSanc) FROM PghTipificacionSancion p WHERE p.pghTipoSancion.idTipoSancion = :idTipoSancion"),
    @NamedQuery(name = "PghTipificacionSancion.findByIdTipoSancion", query = "SELECT p FROM PghTipificacionSancion p WHERE p.pghTipoSancion.idTipoSancion = :idTipoSancion")})
public class PghTipificacionSancion extends Auditoria {
    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected PghTipificacionSancionPK pghTipificacionSancionPK;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPI_SANC")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_TIPI_TIPO_SANC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idTipiSanc;
    @Column(name = "ESTADO")
    private String estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIVEL")
    private MdiMaestroColumna nivel;
    @JoinColumn(name = "ID_TIPO_SANCION", referencedColumnName = "ID_TIPO_SANCION")
    @ManyToOne(optional = false)
    private PghTipoSancion pghTipoSancion;
    @JoinColumn(name = "ID_TIPIFICACION", referencedColumnName = "ID_TIPIFICACION")
    @ManyToOne(optional = false)
    private PghTipificacion pghTipificacion;
    @JoinColumn(name = "ID_DETALLE_CRITERIO", referencedColumnName = "ID_DETALLE_CRITERIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghDetalleCriterio idDetalleCriterio;
    @JoinColumn(name = "ID_CRITERIO", referencedColumnName = "ID_CRITERIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghCriterio idCriterio;

    public PghTipificacionSancion() {
    }
    
    

//    public PghTipificacionSancion(PghTipificacionSancionPK pghTipificacionSancionPK) {
//        this.pghTipificacionSancionPK = pghTipificacionSancionPK;
//    }
//
//    public PghTipificacionSancion(long idTipificacion, long idTipoSancion) {
//        this.pghTipificacionSancionPK = new PghTipificacionSancionPK(idTipificacion, idTipoSancion);
//    }

//    public PghTipificacionSancionPK getPghTipificacionSancionPK() {
//        return pghTipificacionSancionPK;
//    }
//
//    public void setPghTipificacionSancionPK(PghTipificacionSancionPK pghTipificacionSancionPK) {
//        this.pghTipificacionSancionPK = pghTipificacionSancionPK;
//    }
    
    public MdiMaestroColumna getNivel() {
		return nivel;
	}



	public void setNivel(MdiMaestroColumna nivel) {
		this.nivel = nivel;
	}



	public Long getIdTipiSanc() {
        return idTipiSanc;
    }

    public PghDetalleCriterio getIdDetalleCriterio() {
		return idDetalleCriterio;
	}

	public void setIdDetalleCriterio(PghDetalleCriterio idDetalleCriterio) {
		this.idDetalleCriterio = idDetalleCriterio;
	}

	public PghCriterio getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(PghCriterio idCriterio) {
		this.idCriterio = idCriterio;
	}

	public void setIdTipiSanc(Long idTipiSanc) {
        this.idTipiSanc = idTipiSanc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghTipoSancion getPghTipoSancion() {
        return pghTipoSancion;
    }

    public void setPghTipoSancion(PghTipoSancion pghTipoSancion) {
        this.pghTipoSancion = pghTipoSancion;
    }

    public PghTipificacion getPghTipificacion() {
        return pghTipificacion;
    }

    public void setPghTipificacion(PghTipificacion pghTipificacion) {
        this.pghTipificacion = pghTipificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipiSanc != null ? idTipiSanc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTipificacionSancion)) {
            return false;
        }
        PghTipificacionSancion other = (PghTipificacionSancion) object;
        if ((this.idTipiSanc == null && other.idTipiSanc != null) || (this.idTipiSanc != null && !this.idTipiSanc.equals(other.idTipiSanc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PghTipificacionSancion[ pghTipificacionSancionPK=" + idTipiSanc + " ]";
    }
    
}
