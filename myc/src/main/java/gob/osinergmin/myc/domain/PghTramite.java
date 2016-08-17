/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.PghEtapa;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTramite.findAll", query = "SELECT p FROM PghTramite p where p.estado=:estado"),
    @NamedQuery(name = "PghTramite.findByIdEtapa", query = "SELECT p FROM PghTramite p where p.estado=:estado and p.idEtapa.idEtapa=:idEtapa"),
    @NamedQuery(name = "PghTramite.findByIdEtapaAndDescripcion", query = "SELECT p FROM PghTramite p where p.estado=:estado and p.idEtapa.idEtapa=:idEtapa and upper(p.descripcion)=:descripcion "),
    @NamedQuery(name = "PghTramite.findByIdTramite", query = "SELECT p FROM PghTramite p where p.idTramite=:idTramite"),
    @NamedQuery(name = "PghTramite.findByIdProcedimiento", query = "Select tr "
        + " from PghProcedimiento pro left join pro.pghProcedimientoTramiteList pt left join pt.idTramite tr "
        + " WHERE pro.estado=:estado and tr.estado=:estado and pt.estado=:estado and pro.idProcedimiento=:idProcedimiento "),
    @NamedQuery(name = "PghTramite.findByIdTramiteActividad", query = "Select ta.idTramite from PghCnfTramiteActividad ta " +
    		"left join ta.idTramite tr" +
    		" WHERE ta.estado=:estado  and tr.estado=:estado and ta.idActividad.idActividad=:idActividad ")
})
public class PghTramite extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRAMITE")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_TRAMITE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idTramite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTramite", fetch = FetchType.LAZY)
    private List<PghProcedimientoTramite> pghProcedimientoTramiteList;
    @OneToMany(mappedBy = "idTramite", fetch = FetchType.LAZY)
    private List<PghCnfTramiteActividad> pghCnfTramiteActividadList;
    @JoinColumn(name = "ID_ETAPA", referencedColumnName = "ID_ETAPA")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghEtapa idEtapa;
    @OneToMany(mappedBy = "idTramite", fetch = FetchType.LAZY)
    private List<PghCnfRequProcedimiento> pghCnfRequProcedimientoList;
    @OneToMany(mappedBy = "idTramite", fetch = FetchType.LAZY)
    private List<PghMotivoTramite> pghMotivoTramiteList;

    public PghTramite() {
    }

    public PghTramite(Long idTramite) {
        this.idTramite = idTramite;
    }
    public PghTramite(Long idTramite,Long idEtapa,Long idProceso) {
        this.idTramite = idTramite;
        this.idEtapa=new PghEtapa(idEtapa,idProceso);
    }
    public PghTramite(Long idTramite , String descripcion) {
        this.idTramite = idTramite;
        this.descripcion=descripcion;
    }

    public PghTramite(Long idTramite, String usuarioCreacion, Date fechaCreacion, String terminalCreacion, String estado) {
        this.idTramite = idTramite;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
        this.estado = estado;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghProcedimientoTramite> getPghProcedimientoTramiteList() {
        return pghProcedimientoTramiteList;
    }

    public void setPghProcedimientoTramiteList(List<PghProcedimientoTramite> pghProcedimientoTramiteList) {
        this.pghProcedimientoTramiteList = pghProcedimientoTramiteList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghCnfTramiteActividad> getPghCnfTramiteActividadList() {
        return pghCnfTramiteActividadList;
    }

    public void setPghCnfTramiteActividadList(List<PghCnfTramiteActividad> pghCnfTramiteActividadList) {
        this.pghCnfTramiteActividadList = pghCnfTramiteActividadList;
    }

    public PghEtapa getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(PghEtapa idEtapa) {
        this.idEtapa = idEtapa;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghCnfRequProcedimiento> getPghCnfRequProcedimientoList() {
        return pghCnfRequProcedimientoList;
    }

    public void setPghCnfRequProcedimientoList(List<PghCnfRequProcedimiento> pghCnfRequProcedimientoList) {
        this.pghCnfRequProcedimientoList = pghCnfRequProcedimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTramite != null ? idTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTramite)) {
            return false;
        }
        PghTramite other = (PghTramite) object;
        if ((this.idTramite == null && other.idTramite != null) || (this.idTramite != null && !this.idTramite.equals(other.idTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghTramite[ idTramite=" + idTramite + " ]";
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

    @XmlTransient
    @JsonIgnore
    public List<PghMotivoTramite> getPghMotivoTramiteList() {
        return pghMotivoTramiteList;
    }

    public void setPghMotivoTramiteList(List<PghMotivoTramite> pghMotivoTramiteList) {
        this.pghMotivoTramiteList = pghMotivoTramiteList;
    }
    
}
