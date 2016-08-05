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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gvillanueva
 */
@Entity
@Table(name = "MDI_UNIDAD_SUPERVISADA")
@NamedQueries({
    @NamedQuery(name = "MdiUnidadSupervisada.findAll", query = "SELECT m FROM MdiUnidadSupervisada m"),
    @NamedQuery(name = "MdiUnidadSupervisada.countByIdActividad", query = "SELECT count(m.idUnidadSupervisada) FROM MdiUnidadSupervisada m where m.estado='1' and m.idActividad.idActividad= :idActividad "),
    @NamedQuery(name = "MdiUnidadSupervisada.countByIdActividadxEstratoDistrito", 
    query = "SELECT count(m.idUnidadSupervisada) FROM MdiUnidadSupervisada m " +
    		"left join m.mdiDirccionUnidadSuprvisadaList ml " +
    		"where m.estado= :estado and ml.estado= :estado " +
    		"and m.idActividad.idActividad= :idActividad " +
    		"and ml.mdiUbigeo.mdiUbigeoPK.idDepartamento= :departamento " +
    		"and ml.mdiUbigeo.mdiUbigeoPK.idProvincia= :provincia " +
    		"and ml.mdiUbigeo.mdiUbigeoPK.idDistrito= :distrito " +
    		"and ml.idTipoDireccion = (SELECT mc FROM MdiMaestroColumna mc " +
                                      "left join mc.mdiMaestroTabla mt  " +
                                      "WHERE " +
                                      "mc.mdiMaestroTabla.mdiMaestroTablaPK.dominio = :dominio and " +
                                      "mc.mdiMaestroTabla.mdiMaestroTablaPK.aplicacion = :aplicacion " +
                                      "and mc.codigo= :codigo " +
                                      "and mc.estado='1' and rownum = 1 ) "),
    @NamedQuery(name = "MdiUnidadSupervisada.countByIdActividadxEstratoProvincia", 
    query = "SELECT count(m.idUnidadSupervisada) FROM MdiUnidadSupervisada m " +
    		    		"left join m.mdiDirccionUnidadSuprvisadaList ml " +
    		    		"where m.estado= :estado and ml.estado= :estado " +
    		    		"and m.idActividad.idActividad= :idActividad " +
    		    		"and ml.mdiUbigeo.mdiUbigeoPK.idDepartamento= :departamento " +
    		    		"and ml.mdiUbigeo.mdiUbigeoPK.idProvincia= :provincia "),
    @NamedQuery(name = "MdiUnidadSupervisada.countByIdActividadxEstratoDepartamento", 
    query = "SELECT count(m.idUnidadSupervisada) FROM MdiUnidadSupervisada m " +
    		    		    		"left join m.mdiDirccionUnidadSuprvisadaList ml " +
    		    		    		"where m.estado= :estado and ml.estado= :estado " +
    		    		    		"and m.idActividad.idActividad= :idActividad " +
    		    		    		"and ml.mdiUbigeo.mdiUbigeoPK.idDepartamento= :departamento "),
    @NamedQuery(name = "MdiUnidadSupervisada.findByIdActividadxEstratoDepartamento", 
    query = "SELECT m FROM MdiUnidadSupervisada m " +
    		    		 "left join m.mdiDirccionUnidadSuprvisadaList ml " +
    		    		 "where m.estado= :estado and ml.estado= :estado " +
    		    		 "and m.idActividad.idActividad= :idActividad " +
    		    		 "and ml.mdiUbigeo.mdiUbigeoPK.idDepartamento= :departamento "),    
    @NamedQuery(name = "MdiUnidadSupervisada.findByIdActividadxEstratoProvincia", 
    query = "SELECT m FROM MdiUnidadSupervisada m " +
    		    	    "left join m.mdiDirccionUnidadSuprvisadaList ml " +
    		    	    "where m.estado= :estado and ml.estado= :estado " +
    		    	    "and m.idActividad.idActividad= :idActividad " +
    		    	    "and ml.mdiUbigeo.mdiUbigeoPK.idDepartamento= :departamento " +
    		    	    "and ml.mdiUbigeo.mdiUbigeoPK.idProvincia= :provincia "),
   @NamedQuery(name = "MdiUnidadSupervisada.findByIdActividadxEstratoDistrito", 
   query = "SELECT m FROM MdiUnidadSupervisada m " +
    		    	    "left join m.mdiDirccionUnidadSuprvisadaList ml " +
    		    	    "where m.estado= :estado and ml.estado= :estado " +
    		    	    "and m.idActividad.idActividad= :idActividad " +
    		    	    "and ml.mdiUbigeo.mdiUbigeoPK.idDepartamento= :departamento " +
    		    	    "and ml.mdiUbigeo.mdiUbigeoPK.idProvincia= :provincia " +
    		    	    "and ml.mdiUbigeo.mdiUbigeoPK.idDistrito= :distrito")
})
public class MdiUnidadSupervisada extends Auditoria {

    private static final long serialVersionUID = 1L;
    @Size(max = 12)
    @Column(name = "CODIGO_OSINERGMIN")
    private String codigoOsinergmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE_UNIDAD")
    private String nombreUnidad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UNIDAD_SUPERVISADA")
    private Long idUnidadSupervisada;
    @Column(name = "ID_TIPO_UNIDAD")
    private Long idTipoUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 250)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "ZONA")
    private Character zona;
    @Size(max = 100)
    @Column(name = "UTM")
    private String utm;
    @Size(max = 10)
    @Column(name = "RESOLUCION_DIRECTORAL")
    private String resolucionDirectoral;
    @Column(name = "ID_TIPO_ACTIVIDAD")
    private Short idTipoActividad;
    @Size(max = 1180)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "ID_ZONA")
    private Long idZona;
    @Column(name = "ID_TIPO_DIRECCION_ACTIVIDAD")
    private Long idTipoDireccionActividad;
    @Column(name = "ID_ETAPA")
    private Long idEtapa;
    @JoinColumn(name = "ID_EMPRESA_SUPERVISADA", referencedColumnName = "ID_EMPRESA_SUPERVISADA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdiEmpresaSupervisada idEmpresaSupervisada;
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiActividad idActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadSupervisada", fetch = FetchType.LAZY)
    private List<PghUnidObliSubTipo> pghUnidObliSubTipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadSupervisada", fetch = FetchType.LAZY)
    private List<MdiDirccionUnidadSuprvisada> mdiDirccionUnidadSuprvisadaList;
    
    public MdiUnidadSupervisada() {
    }

    public MdiUnidadSupervisada(Long idUnidadSupervisada) {
        this.idUnidadSupervisada = idUnidadSupervisada;
    }

    public MdiUnidadSupervisada(Long idUnidadSupervisada, String nombreUnidad, Date fechaCreacion, String usuarioCreacion, String terminalCreacion, String estado) {
        this.idUnidadSupervisada = idUnidadSupervisada;
        this.nombreUnidad = nombreUnidad;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.estado = estado;
    }

    public String getCodigoOsinergmin() {
        return codigoOsinergmin;
    }

    public void setCodigoOsinergmin(String codigoOsinergmin) {
        this.codigoOsinergmin = codigoOsinergmin;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdUnidadSupervisada() {
        return idUnidadSupervisada;
    }

    public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
        this.idUnidadSupervisada = idUnidadSupervisada;
    }

    public Long getIdTipoUnidad() {
        return idTipoUnidad;
    }

    public void setIdTipoUnidad(Long idTipoUnidad) {
        this.idTipoUnidad = idTipoUnidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Character getZona() {
        return zona;
    }

    public void setZona(Character zona) {
        this.zona = zona;
    }

    public String getUtm() {
        return utm;
    }

    public void setUtm(String utm) {
        this.utm = utm;
    }

    public String getResolucionDirectoral() {
        return resolucionDirectoral;
    }

    public void setResolucionDirectoral(String resolucionDirectoral) {
        this.resolucionDirectoral = resolucionDirectoral;
    }

    public Short getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(Short idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public Long getIdTipoDireccionActividad() {
        return idTipoDireccionActividad;
    }

    public void setIdTipoDireccionActividad(Long idTipoDireccionActividad) {
        this.idTipoDireccionActividad = idTipoDireccionActividad;
    }

    public Long getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }

    public MdiEmpresaSupervisada getIdEmpresaSupervisada() {
        return idEmpresaSupervisada;
    }

    public void setIdEmpresaSupervisada(MdiEmpresaSupervisada idEmpresaSupervisada) {
        this.idEmpresaSupervisada = idEmpresaSupervisada;
    }

    public MdiActividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(MdiActividad idActividad) {
        this.idActividad = idActividad;
    }

    public List<PghUnidObliSubTipo> getPghUnidObliSubTipoList() {
        return pghUnidObliSubTipoList;
    }

    public void setPghUnidObliSubTipoList(List<PghUnidObliSubTipo> pghUnidObliSubTipoList) {
        this.pghUnidObliSubTipoList = pghUnidObliSubTipoList;
    }  
    
    public List<MdiDirccionUnidadSuprvisada> getMdiDirccionUnidadSuprvisadaList() {
		return mdiDirccionUnidadSuprvisadaList;
	}

	public void setMdiDirccionUnidadSuprvisadaList(
			List<MdiDirccionUnidadSuprvisada> mdiDirccionUnidadSuprvisadaList) {
		this.mdiDirccionUnidadSuprvisadaList = mdiDirccionUnidadSuprvisadaList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadSupervisada != null ? idUnidadSupervisada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiUnidadSupervisada)) {
            return false;
        }
        MdiUnidadSupervisada other = (MdiUnidadSupervisada) object;
        if ((this.idUnidadSupervisada == null && other.idUnidadSupervisada != null) || (this.idUnidadSupervisada != null && !this.idUnidadSupervisada.equals(other.idUnidadSupervisada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Z.MdiUnidadSupervisada[ idUnidadSupervisada=" + idUnidadSupervisada + " ]";
    }
    
}
