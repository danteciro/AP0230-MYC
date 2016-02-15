/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lbarboza
 * 
 */
@Entity
@Table(name = "MDI_MAESTRO_TABLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiMaestroTabla.findAll", query = "SELECT m FROM MdiMaestroTabla m"),
    @NamedQuery(name = "MdiMaestroTabla.findAplicacion", query = "SELECT distinct new MdiMaestroTabla('' as dominio, m.mdiMaestroTablaPK.aplicacion) FROM MdiMaestroTabla m"),
    @NamedQuery(name = "MdiMaestroTabla.findByAplicacionAndDominio", query = "SELECT m FROM MdiMaestroTabla m "
        + "where upper(m.mdiMaestroTablaPK.aplicacion) like :aplicacion and upper(m.mdiMaestroTablaPK.dominio) like :dominio "),
    @NamedQuery(name = "MdiMaestroTabla.findDominios", query = "SELECT new "
        + "MdiMaestroTabla(concat(m.mdiMaestroTablaPK.aplicacion,m.mdiMaestroTablaPK.dominio) as apliDomi, "
        + "m.mdiMaestroTablaPK.dominio,m.mdiMaestroTablaPK.aplicacion,m.descripcion,m.esEditable) FROM MdiMaestroTabla m "
        + "where upper(m.mdiMaestroTablaPK.dominio) like :dominio and upper(m.descripcion) like :descripcion "),
    @NamedQuery(name = "MdiMaestroTabla.findDominio", query = "SELECT distinct new MdiMaestroTabla(m.mdiMaestroTablaPK.dominio,m.mdiMaestroTablaPK.aplicacion,m.descripcion) FROM MdiMaestroTabla m order by m.descripcion ")
})
public class MdiMaestroTabla extends Auditoria {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MdiMaestroTablaPK mdiMaestroTablaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;
    @Size(max = 2)
    @Column(name = "ES_EDITABLE", length = 2)
    private String esEditable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mdiMaestroTabla", fetch = FetchType.LAZY)
    private List<MdiMaestroColumna> mdiMaestroColumnaList;
    
    @Transient
    private String apliDomi;

    public MdiMaestroTabla() {
    }

    public MdiMaestroTabla(MdiMaestroTablaPK mdiMaestroTablaPK) {
        this.mdiMaestroTablaPK = mdiMaestroTablaPK;
    }
    
    public MdiMaestroTabla(String apliDomi,String dominio, String aplicacion, String descripcion,String esEditable) {
        this.apliDomi=apliDomi;
        this.descripcion=descripcion;
        this.mdiMaestroTablaPK = new MdiMaestroTablaPK(dominio, aplicacion);
        this.esEditable=esEditable;
    }

    public MdiMaestroTabla(MdiMaestroTablaPK mdiMaestroTablaPK, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.mdiMaestroTablaPK = mdiMaestroTablaPK;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public MdiMaestroTabla(String dominio, String aplicacion) {
        this.mdiMaestroTablaPK = new MdiMaestroTablaPK(dominio, aplicacion);
    }
    
    public MdiMaestroTabla(String dominio, String aplicacion, String descripcion) {
        this.mdiMaestroTablaPK = new MdiMaestroTablaPK(dominio, aplicacion);
        this.descripcion=descripcion;
    }
    
    public MdiMaestroTabla(String dominio, String aplicacion, String descripcion,String esEditable) {
        this.mdiMaestroTablaPK = new MdiMaestroTablaPK(dominio, aplicacion);
        this.descripcion=descripcion;
        this.esEditable=esEditable;
    }
    
    public MdiMaestroTabla(String dominio) {
        this.mdiMaestroTablaPK = new MdiMaestroTablaPK(dominio,null);
    }

    public MdiMaestroTablaPK getMdiMaestroTablaPK() {
        return mdiMaestroTablaPK;
    }

    public String getApliDomi() {
        return apliDomi;
    }

    public void setApliDomi(String apliDomi) {
        this.apliDomi = apliDomi;
    }

    public void setMdiMaestroTablaPK(MdiMaestroTablaPK mdiMaestroTablaPK) {
        this.mdiMaestroTablaPK = mdiMaestroTablaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEsEditable() {
        return esEditable;
    }

    public void setEsEditable(String esEditable) {
        this.esEditable = esEditable;
    }

    @XmlTransient
    public List<MdiMaestroColumna> getMdiMaestroColumnaList() {
        return mdiMaestroColumnaList;
    }

    public void setMdiMaestroColumnaList(List<MdiMaestroColumna> mdiMaestroColumnaList) {
        this.mdiMaestroColumnaList = mdiMaestroColumnaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mdiMaestroTablaPK != null ? mdiMaestroTablaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiMaestroTabla)) {
            return false;
        }
        MdiMaestroTabla other = (MdiMaestroTabla) object;
        if ((this.mdiMaestroTablaPK == null && other.mdiMaestroTablaPK != null) || (this.mdiMaestroTablaPK != null && !this.mdiMaestroTablaPK.equals(other.mdiMaestroTablaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.mdiws.domain.MdiMaestroTabla[ mdiMaestroTablaPK=" + mdiMaestroTablaPK + " ]";
    }
    
}
