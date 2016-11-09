package gob.osinergmin.myc.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author gvillanueva
 */
@Entity
@Table(name = "PGH_CNF_ACT_UNI_ORGANICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCnfActUniOrganica.findAll", query = "SELECT p FROM PghCnfActUniOrganica p"),
    @NamedQuery(name = "PghCnfActUniOrganica.findByIdCnfActUniOrganica", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.idCnfActUniOrganica = :idCnfActUniOrganica"),
    @NamedQuery(name = "PghCnfActUniOrganica.findByEstado", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghCnfActUniOrganica.findByUsuarioCreacion", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghCnfActUniOrganica.findByFechaCreacion", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghCnfActUniOrganica.findByTerminalCreacion", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghCnfActUniOrganica.findByUsuarioActualizacion", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghCnfActUniOrganica.findByFechaActualizacion", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghCnfActUniOrganica.findByTerminalActualizacion", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.terminalActualizacion = :terminalActualizacion"),
    /* OSINE_SFS-1232 - REQF- - Inicio */
    @NamedQuery(name = "PghCnfActUniOrganica.findByUnidadAndActividad", query = "SELECT p FROM PghCnfActUniOrganica p WHERE p.idUnidadOrganica.idUnidadOrganica = :idUnidadOrganica and  p.idActividad.idActividad = :idActividad"),
    /* OSINE_SFS-1232 - REQF- - Fin */
    @NamedQuery(name = "PghCnfActUniOrganica.findByIdUnidadOrganica", query = "SELECT a FROM PghCnfActUniOrganica c " +
    		" left join c.idActividad a " +
    		" where " +
    		"c.estado=1 " +
    		"and c.idUnidadOrganica.idUnidadOrganica=:idUnidadOrganica")})
public class PghCnfActUniOrganica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CNF_ACT_UNI_ORGANICA")
    private Long idCnfActUniOrganica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 38)
    @Column(name = "TERMINAL_CREACION")
    private String terminalCreacion;
    @Size(max = 38)
    @Column(name = "USUARIO_ACTUALIZACION")
    private String usuarioActualizacion;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Size(max = 38)
    @Column(name = "TERMINAL_ACTUALIZACION")
    private String terminalActualizacion;
    @JoinColumn(name = "ID_OBLIGACION_TIPO", referencedColumnName = "ID_OBLIGACION_TIPO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghObligacionTipo idObligacionTipo;
    @JoinColumn(name = "ID_UNIDAD_ORGANICA", referencedColumnName = "ID_UNIDAD_ORGANICA")
    @ManyToOne(fetch = FetchType.EAGER)//Victor
    private MdiUnidadOrganica idUnidadOrganica; //Victor
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiActividad idActividad;
    

    public PghCnfActUniOrganica() {
    }

    public PghCnfActUniOrganica(Long idCnfActUniOrganica) {
        this.idCnfActUniOrganica = idCnfActUniOrganica;
    }
    
    /* OSINE_SFS-1232 - lgarciar - Inicio */
    public PghCnfActUniOrganica(Long idCnfActUniOrganica, Long idActividad, String nombre) {
        this.idCnfActUniOrganica = idCnfActUniOrganica;
        this.idActividad = new MdiActividad(idActividad, nombre);
    }
    /* OSINE_SFS-1232 - lgarciar - Fin */

    public PghCnfActUniOrganica(Long idCnfActUniOrganica, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idCnfActUniOrganica = idCnfActUniOrganica;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdCnfActUniOrganica() {
        return idCnfActUniOrganica;
    }

    public void setIdCnfActUniOrganica(Long idCnfActUniOrganica) {
        this.idCnfActUniOrganica = idCnfActUniOrganica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTerminalCreacion() {
        return terminalCreacion;
    }

    public void setTerminalCreacion(String terminalCreacion) {
        this.terminalCreacion = terminalCreacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getTerminalActualizacion() {
        return terminalActualizacion;
    }

    public void setTerminalActualizacion(String terminalActualizacion) {
        this.terminalActualizacion = terminalActualizacion;
    }

    public PghObligacionTipo getIdObligacionTipo() {
        return idObligacionTipo;
    }

    public void setIdObligacionTipo(PghObligacionTipo idObligacionTipo) {
        this.idObligacionTipo = idObligacionTipo;
    }

    public MdiUnidadOrganica getIdUnidadOrganica() {
        return idUnidadOrganica;
    }

    public void setIdUnidadOrganica(MdiUnidadOrganica idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }

    public MdiActividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(MdiActividad idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCnfActUniOrganica != null ? idCnfActUniOrganica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghCnfActUniOrganica)) {
            return false;
        }
        PghCnfActUniOrganica other = (PghCnfActUniOrganica) object;
        if ((this.idCnfActUniOrganica == null && other.idCnfActUniOrganica != null) || (this.idCnfActUniOrganica != null && !this.idCnfActUniOrganica.equals(other.idCnfActUniOrganica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PghCnfActUniOrganica[ idCnfActUniOrganica=" + idCnfActUniOrganica + " ]";
    }
    
}
