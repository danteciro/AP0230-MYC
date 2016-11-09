/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorojasb
 */
@Entity
@Table(name = "NPS_SUBETAPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NpsSubetapa.findAll", query = "SELECT n FROM NpsSubetapa n"),
    @NamedQuery(name = "NpsSubetapa.findByIdSubetapa", query = "SELECT n FROM NpsSubetapa n WHERE n.idSubetapa = :idSubetapa"),
    @NamedQuery(name = "NpsSubetapa.findByDescripcion", query = "SELECT n FROM NpsSubetapa n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "NpsSubetapa.findByEstado", query = "SELECT n FROM NpsSubetapa n WHERE n.estado = :estado"),
    @NamedQuery(name = "NpsSubetapa.findByTiempoDias", query = "SELECT n FROM NpsSubetapa n WHERE n.tiempoDias = :tiempoDias"),
    @NamedQuery(name = "NpsSubetapa.findByIdEtapa", query = "SELECT n FROM NpsSubetapa n WHERE n.idEtapa.idEtapa = :idEtapa and n.estado = '1' ")
})

public class NpsSubetapa extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUBETAPA")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "NPS_SUBETAPA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idSubetapa;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "TIEMPO_DIAS")
    private Long tiempoDias;
    @JoinColumn(name = "ID_ETAPA", referencedColumnName = "ID_ETAPA")
    @ManyToOne(fetch = FetchType.EAGER)
    private NpsEtapa idEtapa;
    @JoinColumn(name = "ID_RESPONSABLE")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiMaestroColumna idResponsable;
    
    public NpsSubetapa() {
    }

    public NpsSubetapa(Long idSubetapa) {
        this.idSubetapa = idSubetapa;
    }

    public NpsSubetapa(Long idSubetapa, String estado, String usuarioCreacion, Date fechaCreacion) {
        this.idSubetapa = idSubetapa;
        this.estado = estado;
      
    }
    public Long getIdSubetapa() {
        return idSubetapa;
    }

    public void setIdSubetapa(Long idSubetapa) {
        this.idSubetapa = idSubetapa;
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

    public Long getTiempoDias() {
        return tiempoDias;
    }

    public void setTiempoDias(Long tiempoDias) {
        this.tiempoDias = tiempoDias;
    }

    public NpsEtapa getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(NpsEtapa idEtapa) {
        this.idEtapa = idEtapa;
    }

    public MdiMaestroColumna getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(MdiMaestroColumna idResponsable) {
		this.idResponsable = idResponsable;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubetapa != null ? idSubetapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NpsSubetapa)) {
            return false;
        }
        NpsSubetapa other = (NpsSubetapa) object;
        if ((this.idSubetapa == null && other.idSubetapa != null) || (this.idSubetapa != null && !this.idSubetapa.equals(other.idSubetapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.NpsSubetapa[ idSubetapa=" + idSubetapa + " ]";
    }
    
}
