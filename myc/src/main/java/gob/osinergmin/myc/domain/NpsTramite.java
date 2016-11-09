/**
* Resumen		
* Objeto            : NpsTramite.java
* Descripción       : Clase del modelo de dominio NpsTramite
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
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorojasb
 */
@Entity
@Table(name = "NPS_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NpsTramite.findAll", query = "SELECT n FROM NpsTramite n"),
    @NamedQuery(name = "NpsTramite.findByIdTramite", query = "SELECT n FROM NpsTramite n WHERE n.idTramite = :idTramite"),
    @NamedQuery(name = "NpsTramite.findByDescripcion", query = "SELECT n FROM NpsTramite n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "NpsTramite.findByEstado", query = "SELECT n FROM NpsTramite n WHERE n.estado = :estado")})
public class NpsTramite extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRAMITE")
    private Long idTramite;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
   
    @OneToMany(mappedBy = "idTramite", fetch = FetchType.EAGER)
    private List<NpsConfTramite> npsConfTramiteList;

    public NpsTramite() {
    }

    public NpsTramite(Long idTramite) {
        this.idTramite = idTramite;
    }
    
    /* OSINE_SFS-1232 - lgarciar - Inicio */
    public NpsTramite(String descTramite, Long idTramite) {
        this.idTramite = idTramite;
        this.descripcion = descTramite;
    }
    /* OSINE_SFS-1232 - lgarciar - Fin */
    
    public NpsTramite(Long idTramite, String estado) {
        this.idTramite = idTramite;
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
    public List<NpsConfTramite> getNpsConfTramiteList() {
        return npsConfTramiteList;
    }

    public void setNpsConfTramiteList(List<NpsConfTramite> npsConfTramiteList) {
        this.npsConfTramiteList = npsConfTramiteList;
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
        if (!(object instanceof NpsTramite)) {
            return false;
        }
        NpsTramite other = (NpsTramite) object;
        if ((this.idTramite == null && other.idTramite != null) || (this.idTramite != null && !this.idTramite.equals(other.idTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.NpsTramite[ idTramite=" + idTramite + " ]";
    }
    
}
