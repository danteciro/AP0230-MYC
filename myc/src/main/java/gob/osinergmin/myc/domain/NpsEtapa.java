/**
* Resumen		
* Objeto            : NpsEtapa.java
* Descripción       : Clase del modelo de dominio NpsEtapa
* Fecha de Creación : 
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |   Fecha       |    Nombre                    |   Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |   Busqueda por filtros
*
*/ 

package gob.osinergmin.myc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorojasb
 */
@Entity
@Table(name = "NPS_ETAPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NpsEtapa.findAll", query = "SELECT n FROM NpsEtapa n"),
    @NamedQuery(name = "NpsEtapa.findByIdEtapa", query = "SELECT n FROM NpsEtapa n WHERE n.idEtapa = :idEtapa"),
    @NamedQuery(name = "NpsEtapa.findByIdProceso", query = "SELECT n FROM NpsEtapa n WHERE n.idProceso = :idProceso"),
    @NamedQuery(name = "NpsEtapa.findByDescripcion", query = "SELECT n FROM NpsEtapa n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "NpsEtapa.findByEstado", query = "SELECT n FROM NpsEtapa n WHERE n.estado = :estado"),
    @NamedQuery(name = "NpsEtapa.findByPlazo", query = "SELECT n FROM NpsEtapa n WHERE n.plazo = :plazo")})
public class NpsEtapa extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ETAPA")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "NPS_ETAPA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idEtapa;
    @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID_PROCESO")
    @ManyToOne(fetch = FetchType.EAGER)
    private PghProceso idProceso;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "PLAZO")
    private Long plazo;
    @OneToMany(mappedBy = "idEtapa", fetch = FetchType.LAZY)
    private List<NpsSubetapa> npsSubetapaList;
    @OneToMany(mappedBy = "idEtapa", fetch = FetchType.LAZY)
    private List<NpsEtapaTramite> npsEtapaTramiteList;

    
    public NpsEtapa() {
    }

    public NpsEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }
    
    /* OSINE_SFS-1232 - lgarciar - Inicio */
    public NpsEtapa(Long idEtapa, String descEtapa, Long plazo) {
        this.idEtapa = idEtapa;
        this.descripcion = descEtapa;
        this.plazo = plazo;
    }
    /* OSINE_SFS-1232 - lgarciar - Fin */

    public NpsEtapa(Long idEtapa, String estado, String usuarioCreacion, Date fechaCreacion) {
        this.idEtapa = idEtapa;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
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

    public PghProceso getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(PghProceso idProceso) {
		this.idProceso = idProceso;
	}

	public Long getPlazo() {
        return plazo;
    }

    public void setPlazo(Long plazo) {
        this.plazo = plazo;
    }

    @XmlTransient
    public List<NpsSubetapa> getNpsSubetapaList() {
        return npsSubetapaList;
    }

    public void setNpsSubetapaList(List<NpsSubetapa> npsSubetapaList) {
        this.npsSubetapaList = npsSubetapaList;
    }

    @XmlTransient
    public List<NpsEtapaTramite> getNpsEtapaTramiteList() {
        return npsEtapaTramiteList;
    }

    public void setNpsEtapaTramiteList(List<NpsEtapaTramite> npsEtapaTramiteList) {
        this.npsEtapaTramiteList = npsEtapaTramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapa != null ? idEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NpsEtapa)) {
            return false;
        }
        NpsEtapa other = (NpsEtapa) object;
        if ((this.idEtapa == null && other.idEtapa != null) || (this.idEtapa != null && !this.idEtapa.equals(other.idEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.NpsEtapa[ idEtapa=" + idEtapa + " ]";
    }
    
}
