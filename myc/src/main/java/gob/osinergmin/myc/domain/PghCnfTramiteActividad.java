/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "PGH_CNF_TRAMITE_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghCnfTramiteActividad.findAll", query = "SELECT p FROM PghCnfTramiteActividad p"),
    @NamedQuery(name = "PghCnfTramiteActividad.findByIdTramiteIdActividad", query = "SELECT p FROM PghCnfTramiteActividad p where p.estado=:estado and p.idTramite.idTramite=:idTramite and p.idActividad.idActividad=:idActividad"),
    @NamedQuery(name = "PghCnfTramiteActividad.findByIdTramiteActividad", query = "SELECT p FROM PghCnfTramiteActividad p where p.estado=:estado and p.idTramiteActivdad=:idTramiteActivdad")
})
public class PghCnfTramiteActividad extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_CNF_TRAMITE_ACTIVIDAD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    @Column(name = "ID_TRAMITE_ACTIVDAD")
    private Long idTramiteActivdad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghTramite idTramite;
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiActividad idActividad;

    @Transient
    private Long idEtapa;
    @Transient
    private String descEtapa;
    @Transient
    private Long idProceso;
    @Transient
    private String descripcion;
    
    public PghCnfTramiteActividad() {
    }

    public PghCnfTramiteActividad(Long idTramiteActivdad) {
        this.idTramiteActivdad = idTramiteActivdad;
    }
    
    public PghCnfTramiteActividad(Long idTramiteActivdad, String estado, Long idActividad,String nombre, Long idTramite, String descripcion, Long idEtapa, String descEtapa, Long idProceso, String descripcionProceso){
    	  this.idTramiteActivdad = idTramiteActivdad;
          this.estado = estado;
          this.idActividad= new MdiActividad(idActividad,nombre);
          this.idTramite= new PghTramite(idTramite,descripcion);
          this.idEtapa=idEtapa;
          this.idProceso=idProceso;
          this.descripcion=descripcionProceso;
          this.descEtapa=descEtapa;
    }

    public PghCnfTramiteActividad(Long idTramiteActivdad, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idTramiteActivdad = idTramiteActivdad;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public String getDescEtapa() {
        return descEtapa;
    }

    public void setDescEtapa(String descEtapa) {
        this.descEtapa = descEtapa;
    }

    public Long getIdTramiteActivdad() {
        return idTramiteActivdad;
    }

    public void setIdTramiteActivdad(Long idTramiteActivdad) {
        this.idTramiteActivdad = idTramiteActivdad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghTramite getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(PghTramite idTramite) {
        this.idTramite = idTramite;
    }

    public MdiActividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(MdiActividad idActividad) {
        this.idActividad = idActividad;
    }
       

    public Long getIdEtapa() {
		return idEtapa;
	}

	public void setIdEtapa(Long idEtapa) {
		this.idEtapa = idEtapa;
	}

	public Long getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTramiteActivdad != null ? idTramiteActivdad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghCnfTramiteActividad)) {
            return false;
        }
        PghCnfTramiteActividad other = (PghCnfTramiteActividad) object;
        if ((this.idTramiteActivdad == null && other.idTramiteActivdad != null) || (this.idTramiteActivdad != null && !this.idTramiteActivdad.equals(other.idTramiteActivdad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghCnfTramiteActividad[ idTramiteActivdad=" + idTramiteActivdad + " ]";
    }
    
}
