/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author gvillanueva
 */
@Entity
@Table(name = "PGH_PROCESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghProceso.findAll", query = "SELECT p FROM PghProceso p where p.estado=:estado"),
    @NamedQuery(name = "PghProceso.findByIdentificadorProceso", query = "SELECT p FROM PghProceso p WHERE p.identificadorProceso = :identificadorProceso")
})
public class PghProceso extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROCESO")
    private Long idProceso;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "IDENTIFICADOR_PROCESO")
    private String identificadorProceso;
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pghProceso", fetch = FetchType.LAZY)
    private List<PghProcesoObligacionTipo> pghProcesoObligacionTipoList;
    @OneToMany(mappedBy = "idProceso", fetch = FetchType.LAZY)
    private List<PghEtapa> pghEtapaList;

    public PghProceso() {
    }

    public PghProceso(Long idProceso) {
        this.idProceso = idProceso;
    }
    public PghProceso(Long idProceso, String descripcion ) {
        this.idProceso = idProceso;
        this.descripcion=descripcion;
    }

    public PghProceso(Long idProceso, String estado, Date fechaCreacion, String terminalCreacion, String usuarioCreacion) {
        this.idProceso = idProceso;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
        this.usuarioCreacion = usuarioCreacion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PghProcesoObligacionTipo> getPghProcesoObligacionTipoList() {
        return pghProcesoObligacionTipoList;
    }

    public void setPghProcesoObligacionTipoList(List<PghProcesoObligacionTipo> pghProcesoObligacionTipoList) {
        this.pghProcesoObligacionTipoList = pghProcesoObligacionTipoList;
    }

    public List<PghEtapa> getPghEtapaList() {
        return pghEtapaList;
    }

    public void setPghEtapaList(List<PghEtapa> pghEtapaList) {
        this.pghEtapaList = pghEtapaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghProceso)) {
            return false;
        }
        PghProceso other = (PghProceso) object;
        if ((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghProceso[ idProceso=" + idProceso + " ]";
    }
    
}
