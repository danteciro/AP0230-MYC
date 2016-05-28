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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "MDI_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiActividad.findAll", query = "SELECT m FROM MdiActividad m WHERE m.estado=:estado order by m.nombre"),
    @NamedQuery(name = "MdiActividad.findByIdActividad", query = "SELECT m FROM MdiActividad m WHERE m.estado=:estado and m.idActividad=:idActividad"),
    @NamedQuery(name = "MdiActividad.countAll", query = "SELECT count(m.idActividad) FROM MdiActividad m WHERE m.estado=:estado"),
    @NamedQuery(name = "MdiActividad.countByIdProcedimiento", query = "SELECT count(distinct ac.idActividad) "
                + "FROM PghProcedimiento pro "
                + "left join pro.pghProcedimientoTramiteList pt "
                + "left join pt.idTramite tr "
                + "left join tr.idEtapa et "
                + "left join pt.pghProcTramActividadList pta "
                + "left join pta.idActividad ac WHERE ac.estado=:estado and pta.estado=:estado and pro.idProcedimiento=:idProcedimiento"),
    @NamedQuery(name = "MdiActividad.findByIdProcedimiento", query = "SELECT distinct new MdiActividad(ac.idActividad,ac.nombre) "
                + "FROM PghProcedimiento pro "
                + "left join pro.pghProcedimientoTramiteList pt "
                + "left join pt.idTramite tr "
                + "left join tr.idEtapa et "
                + "left join pt.pghProcTramActividadList pta "
                + "left join pta.idActividad ac WHERE ac.estado=:estado and pta.estado=:estado and pro.idProcedimiento=:idProcedimiento"),
    @NamedQuery(name = "MdiActividad.countByIdProcedimientoIdTramite", query = "SELECT count(distinct ac.idActividad) "
                + "FROM PghProcTramActividad pta "
                + "left join pta.idProcedimientoTramite pt "
                + "left join pta.idActividad ac "
                + "WHERE ac.estado=:estado and pta.estado=:estado "
                    + "and pt.idProcedimientoTramite.idTramite.idTramite=:idTramite "
                    + "and pt.idProcedimientoTramite.idProcedimiento.idProcedimiento=:idProcedimiento"),
   @NamedQuery(name = "MdiActividad.countByIdTramiteActividad", query = "SELECT count(distinct ac.idActividad) "
                            + "FROM PghCnfTramiteActividad ta "
                            + "left join ta.idActividad ac "
                            + "WHERE ac.estado=:estado and ta.estado=:estado and ta.idTramiteActivdad=:idTramiteActivdad"),
    @NamedQuery(name = "MdiActividad.findByIdProcedimientoIdTramite", query = "SELECT distinct new MdiActividad(ac.idActividad,ac.nombre) "
                + "FROM PghProcTramActividad pta "
                + "left join pta.idProcedimientoTramite pt "
                + "left join pta.idActividad ac "
                + "WHERE ac.estado=:estado and pta.estado=:estado "
                    + "and pt.idProcedimientoTramite.idTramite.idTramite=:idTramite "
                    + "and pt.idProcedimientoTramite.idProcedimiento.idProcedimiento=:idProcedimiento"),
    @NamedQuery(name = "MdiActividad.findByIdProcedimientoTramite", query = "SELECT distinct new MdiActividad(ac.idActividad,ac.nombre) "
                + "FROM PghProcTramActividad pta "
                + "left join pta.idProcedimientoTramite pt "
                + "left join pta.idActividad ac "
                + "WHERE ac.estado=:estado and pta.estado=:estado and pt.idProcedimientoTramite=:idProcedimientoTramite"),
    @NamedQuery(name = "MdiActividad.findByIdTramiteActividad", query = "SELECT distinct new MdiActividad(ac.idActividad,ac.nombre) "
            + "FROM PghCnfTramiteActividad ta "
            + "left join ta.idActividad ac "
            + "WHERE ac.estado=:estado and ta.estado=:estado and ta.idTramiteActivdad=:idTramiteActivdad")
})
public class MdiActividad extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ACTIVIDAD")
    private Long idActividad;
    @Column(name = "ID_ACTIVIDAD_PADRE")
    private Long idActividadPadre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "NIVEL")
    private Integer nivel;
    @Size(max = 2)
    @Column(name = "ES_MAYOR")
    private String esMayor;
    @Column(name = "ETAPA")
    private Long etapa;
    @OneToMany(mappedBy = "idActividad", fetch = FetchType.LAZY)
    private List<PghProcTramActividad> pghProcTramActividadList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "mdiActividad1", fetch = FetchType.LAZY)
    private MdiActividad mdiActividad;
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private MdiActividad mdiActividad1;
    @OneToMany(mappedBy = "idActividad", fetch = FetchType.LAZY)
    private List<PghCnfTramiteActividad> pghCnfTramiteActividadList;
    @OneToMany(mappedBy = "idActividad", fetch = FetchType.LAZY)
    private List<PghCnfRequProcedimiento> pghCnfRequProcedimientoList;

    public MdiActividad() {
    }

    public MdiActividad(Long idActividad) {
        this.idActividad = idActividad;
    }
    
    public MdiActividad(Long idActividad,String nombre) {
        this.idActividad = idActividad;
        this.nombre=nombre;
    }

    public MdiActividad(Long idActividad, String estado, String codigo, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idActividad = idActividad;
        this.estado = estado;
        this.codigo = codigo;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Long getIdActividadPadre() {
        return idActividadPadre;
    }

    public void setIdActividadPadre(Long idActividadPadre) {
        this.idActividadPadre = idActividadPadre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getEsMayor() {
        return esMayor;
    }

    public void setEsMayor(String esMayor) {
        this.esMayor = esMayor;
    }

    public Long getEtapa() {
        return etapa;
    }

    public void setEtapa(Long etapa) {
        this.etapa = etapa;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghProcTramActividad> getPghProcTramActividadList() {
        return pghProcTramActividadList;
    }

    public void setPghProcTramActividadList(List<PghProcTramActividad> pghProcTramActividadList) {
        this.pghProcTramActividadList = pghProcTramActividadList;
    }

    public MdiActividad getMdiActividad() {
        return mdiActividad;
    }

    public void setMdiActividad(MdiActividad mdiActividad) {
        this.mdiActividad = mdiActividad;
    }

    public MdiActividad getMdiActividad1() {
        return mdiActividad1;
    }

    public void setMdiActividad1(MdiActividad mdiActividad1) {
        this.mdiActividad1 = mdiActividad1;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghCnfTramiteActividad> getPghCnfTramiteActividadList() {
        return pghCnfTramiteActividadList;
    }

    public void setPghCnfTramiteActividadList(List<PghCnfTramiteActividad> pghCnfTramiteActividadList) {
        this.pghCnfTramiteActividadList = pghCnfTramiteActividadList;
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
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiActividad)) {
            return false;
        }
        MdiActividad other = (MdiActividad) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.MdiActividad[ idActividad=" + idActividad + " ]";
    }
    
}
