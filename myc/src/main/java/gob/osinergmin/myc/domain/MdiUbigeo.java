/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "MDI_UBIGEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiUbigeo.findDepartamento", query = "SELECT u " +
                "FROM MdiUbigeo u " +
                "WHERE " +
                " u.mdiUbigeoPK.idProvincia = '00' and " +
                " u.mdiUbigeoPK.idDistrito = '00' order by u.nombre "),
    @NamedQuery(name = "MdiUbigeo.findProvinciaByIdDepartamento", query = "SELECT u " +
                "FROM MdiUbigeo u " +
                "WHERE " +
                " u.mdiUbigeoPK.idProvincia != '00' and " +
                " u.mdiUbigeoPK.idDistrito = '00' and " +
                " u.mdiUbigeoPK.idDepartamento = :idDepartamento order by u.nombre "),
    @NamedQuery(name = "MdiUbigeo.findDistritoByParametros", query = "SELECT u " +
                "FROM MdiUbigeo u " +
                "WHERE " +
                " u.mdiUbigeoPK.idDistrito != '00' and " +
                " u.mdiUbigeoPK.idDepartamento = :idDepartamento and " +
                " u.mdiUbigeoPK.idProvincia = :idProvincia order by u.nombre ")    
})
public class MdiUbigeo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MdiUbigeoPK mdiUbigeoPK;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ESTADO")
    private String estado;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "mdiUbigeo", fetch = FetchType.LAZY)
    private List<MdiSedeEmpresaLocador> mdiSedeEmpresaLocadorList;
    @OneToMany(mappedBy = "mdiUbigeo", fetch = FetchType.LAZY)
    private List<MdiDireccionEmpSupervisada> mdiDireccionEmpSupervisadaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mdiUbigeo", fetch = FetchType.LAZY)
    private List<MdiDirccionUnidadSuprvisada> mdiDirccionUnidadSuprvisadaList;
    @OneToMany(mappedBy = "mdiUbigeo", fetch = FetchType.LAZY)
    private List<MdiDireccionRegion> mdiDireccionRegionList;*/
    @OneToMany(mappedBy = "mdiUbigeo", fetch = FetchType.LAZY)
    private List<PghZonificacionDetalle> pghZonificacionDetalleList;

    public MdiUbigeo() {
    }

    public MdiUbigeo(MdiUbigeoPK mdiUbigeoPK) {
        this.mdiUbigeoPK = mdiUbigeoPK;
    }

    public MdiUbigeo(String idDepartamento, String idProvincia, String idDistrito) {
        this.mdiUbigeoPK = new MdiUbigeoPK(idDepartamento, idProvincia, idDistrito);
    }
    
    public MdiUbigeo(String idDepartamento, String idProvincia, String idDistrito,String nombre) {
        this.mdiUbigeoPK = new MdiUbigeoPK(idDepartamento, idProvincia, idDistrito);
        this.nombre=nombre;
    }

    public MdiUbigeoPK getMdiUbigeoPK() {
        return mdiUbigeoPK;
    }

    public void setMdiUbigeoPK(MdiUbigeoPK mdiUbigeoPK) {
        this.mdiUbigeoPK = mdiUbigeoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*@XmlTransient
    public List<MdiSedeEmpresaLocador> getMdiSedeEmpresaLocadorList() {
        return mdiSedeEmpresaLocadorList;
    }

    public void setMdiSedeEmpresaLocadorList(List<MdiSedeEmpresaLocador> mdiSedeEmpresaLocadorList) {
        this.mdiSedeEmpresaLocadorList = mdiSedeEmpresaLocadorList;
    }

    @XmlTransient
    public List<MdiDireccionEmpSupervisada> getMdiDireccionEmpSupervisadaList() {
        return mdiDireccionEmpSupervisadaList;
    }

    public void setMdiDireccionEmpSupervisadaList(List<MdiDireccionEmpSupervisada> mdiDireccionEmpSupervisadaList) {
        this.mdiDireccionEmpSupervisadaList = mdiDireccionEmpSupervisadaList;
    }

    @XmlTransient
    public List<MdiDirccionUnidadSuprvisada> getMdiDirccionUnidadSuprvisadaList() {
        return mdiDirccionUnidadSuprvisadaList;
    }

    public void setMdiDirccionUnidadSuprvisadaList(List<MdiDirccionUnidadSuprvisada> mdiDirccionUnidadSuprvisadaList) {
        this.mdiDirccionUnidadSuprvisadaList = mdiDirccionUnidadSuprvisadaList;
    }

    @XmlTransient
    public List<MdiDireccionRegion> getMdiDireccionRegionList() {
        return mdiDireccionRegionList;
    }

    public void setMdiDireccionRegionList(List<MdiDireccionRegion> mdiDireccionRegionList) {
        this.mdiDireccionRegionList = mdiDireccionRegionList;
    }*/

    @XmlTransient
    public List<PghZonificacionDetalle> getPghZonificacionDetalleList() {
        return pghZonificacionDetalleList;
    }

    public void setPghZonificacionDetalleList(List<PghZonificacionDetalle> pghZonificacionDetalleList) {
        this.pghZonificacionDetalleList = pghZonificacionDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mdiUbigeoPK != null ? mdiUbigeoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiUbigeo)) {
            return false;
        }
        MdiUbigeo other = (MdiUbigeo) object;
        if ((this.mdiUbigeoPK == null && other.mdiUbigeoPK != null) || (this.mdiUbigeoPK != null && !this.mdiUbigeoPK.equals(other.mdiUbigeoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.test.MdiUbigeo[ mdiUbigeoPK=" + mdiUbigeoPK + " ]";
    }
    
}
