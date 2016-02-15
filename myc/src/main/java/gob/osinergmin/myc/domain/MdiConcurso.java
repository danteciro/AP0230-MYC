/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lbarboza
 */
@Entity
@Table(name = "MDI_CONCURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiConcurso.countAll", query = "SELECT count(m.idConcurso) FROM MdiConcurso m"),
    @NamedQuery(name = "MdiConcurso.findAll", query = "SELECT m FROM MdiConcurso m"),
    @NamedQuery(name = "MdiConcurso.countByIdConcurso", query = "SELECT count(m.idConcurso) FROM MdiConcurso m WHERE m.idConcurso = :idConcurso"),
    @NamedQuery(name = "MdiConcurso.findByIdConcurso", query = "SELECT m FROM MdiConcurso m WHERE m.idConcurso = :idConcurso"),
    @NamedQuery(name = "MdiConcurso.countByFilter", query = "SELECT count(m.idConcurso) FROM MdiConcurso m WHERE m.estado = '1' and upper(m.numeroConcurso) like :numeroConcurso and upper(m.nombreConcurso) like :nombreConcurso and upper(m.descripcionConcurso) like :descripcionConcurso"),
    @NamedQuery(name = "MdiConcurso.findByFilter", query = "SELECT m FROM MdiConcurso m WHERE m.estado = '1' and upper(m.numeroConcurso) like :numeroConcurso and upper(m.nombreConcurso) like :nombreConcurso and upper(m.descripcionConcurso) like :descripcionConcurso")
    //@NamedQuery(name = "MdiConcurso.findByNumeroConcurso", query = "SELECT m FROM MdiConcurso m WHERE m.numeroConcurso = :numeroConcurso"),
    //@NamedQuery(name = "MdiConcurso.findByNombreConcurso", query = "SELECT m FROM MdiConcurso m WHERE m.nombreConcurso = :nombreConcurso"),
    //@NamedQuery(name = "MdiConcurso.findByDescripcionConcurso", query = "SELECT m FROM MdiConcurso m WHERE upper(m.descripcionConcurso) = :descripcionConcurso"),
    //@NamedQuery(name = "MdiConcurso.findByNumeroPlazas", query = "SELECT m FROM MdiConcurso m WHERE m.numeroPlazas = :numeroPlazas"),
    //@NamedQuery(name = "MdiConcurso.findByFechaConvocatoria", query = "SELECT m FROM MdiConcurso m WHERE m.fechaConvocatoria = :fechaConvocatoria"),
    //@NamedQuery(name = "MdiConcurso.findByFechaPropuestaTecnica", query = "SELECT m FROM MdiConcurso m WHERE m.fechaPropuestaTecnica = :fechaPropuestaTecnica"),
    //@NamedQuery(name = "MdiConcurso.findByFechaPropuestaEconomica", query = "SELECT m FROM MdiConcurso m WHERE m.fechaPropuestaEconomica = :fechaPropuestaEconomica"),
    //@NamedQuery(name = "MdiConcurso.findByFechaEmisionResultado", query = "SELECT m FROM MdiConcurso m WHERE m.fechaEmisionResultado = :fechaEmisionResultado"),
    //@NamedQuery(name = "MdiConcurso.findByEstado", query = "SELECT m FROM MdiConcurso m WHERE m.estado = :estado"),
    })
public class MdiConcurso extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONCURSO")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "MDI_CONCURSO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idConcurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NUMERO_CONCURSO")
    private String numeroConcurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_CONCURSO")
    private String nombreConcurso;
    @Size(max = 200)
    @Column(name = "DESCRIPCION_CONCURSO")
    private String descripcionConcurso;
    @Column(name = "NUMERO_PLAZAS")
    private BigInteger numeroPlazas;
    @Column(name = "FECHA_CONVOCATORIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConvocatoria;
    @Column(name = "FECHA_PROPUESTA_TECNICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPropuestaTecnica;
    @Column(name = "FECHA_PROPUESTA_ECONOMICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPropuestaEconomica;
    @Column(name = "FECHA_EMISION_RESULTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmisionResultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idConcurso", fetch = FetchType.LAZY)
    private List<MdiContratoEmpresaLocador> mdiContratoEmpresaLocadorList;
    
    public MdiConcurso() {
    }

    public MdiConcurso(Long idConcurso) {
        this.idConcurso = idConcurso;
    }

    public MdiConcurso(Long idConcurso, String numeroConcurso, String nombreConcurso, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idConcurso = idConcurso;
        this.numeroConcurso = numeroConcurso;
        this.nombreConcurso = nombreConcurso;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(Long idConcurso) {
        this.idConcurso = idConcurso;
    }

    public String getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    public String getNombreConcurso() {
        return nombreConcurso;
    }

    public void setNombreConcurso(String nombreConcurso) {
        this.nombreConcurso = nombreConcurso;
    }

    public String getDescripcionConcurso() {
        return descripcionConcurso;
    }

    public void setDescripcionConcurso(String descripcionConcurso) {
        this.descripcionConcurso = descripcionConcurso;
    }

    public BigInteger getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(BigInteger numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public Date getFechaConvocatoria() {
        return fechaConvocatoria;
    }

    public void setFechaConvocatoria(Date fechaConvocatoria) {
        this.fechaConvocatoria = fechaConvocatoria;
    }

    public Date getFechaPropuestaTecnica() {
        return fechaPropuestaTecnica;
    }

    public void setFechaPropuestaTecnica(Date fechaPropuestaTecnica) {
        this.fechaPropuestaTecnica = fechaPropuestaTecnica;
    }

    public Date getFechaPropuestaEconomica() {
        return fechaPropuestaEconomica;
    }

    public void setFechaPropuestaEconomica(Date fechaPropuestaEconomica) {
        this.fechaPropuestaEconomica = fechaPropuestaEconomica;
    }

    public Date getFechaEmisionResultado() {
        return fechaEmisionResultado;
    }

    public void setFechaEmisionResultado(Date fechaEmisionResultado) {
        this.fechaEmisionResultado = fechaEmisionResultado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @XmlTransient
    public List<MdiContratoEmpresaLocador> getMdiContratoEmpresaLocadorList() {
        return mdiContratoEmpresaLocadorList;
    }

    public void setMdiContratoEmpresaLocadorList(List<MdiContratoEmpresaLocador> mdiContratoEmpresaLocadorList) {
        this.mdiContratoEmpresaLocadorList = mdiContratoEmpresaLocadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcurso != null ? idConcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiConcurso)) {
            return false;
        }
        MdiConcurso other = (MdiConcurso) object;
        if ((this.idConcurso == null && other.idConcurso != null) || (this.idConcurso != null && !this.idConcurso.equals(other.idConcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.MdiConcurso[ idConcurso=" + idConcurso + " ]";
    }
    
}
