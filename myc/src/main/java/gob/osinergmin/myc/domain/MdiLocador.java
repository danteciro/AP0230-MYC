/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.MdiMaestroColumna;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jpiro
 */
@Entity
@Table(name = "MDI_LOCADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiLocador.findAll", query = "SELECT m FROM MdiLocador m")})
public class MdiLocador extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOCADOR")
    private Long idLocador;
    @Basic(optional = false)
    @NotNull
//    @Column(name = "ID_TIPO_DOCUMENTO_IDENTIDAD")
//    private long idTipoDocumentoIdentidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_DOCUMENTO_IDENTIDAD")
    private MdiMaestroColumna idTipoDocumentoIdentidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Size(max = 15)
    @Column(name = "RUC")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Column(name = "SEXO")
    private Long sexo;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "TIPO_SANGRE")
    private Long tipoSangre;
    @Column(name = "ESTADO_CIVIL")
    private Long estadoCivil;
    @Size(max = 2)
    @Column(name = "HIJOS")
    private String hijos;
    @Column(name = "NUMERO_HIJOS")
    private Short numeroHijos;
    @Column(name = "ID_NACIONALIDAD")
    private Long idNacionalidad;
    @Size(max = 30)
    @Column(name = "TELEFONO_CONTACTO")
    private String telefonoContacto;
    @Column(name = "ID_COLEGIO_PROFESIONAL")
    private Long idColegioProfesional;
    @Size(max = 20)
    @Column(name = "NUMERO_COLEGIATURA")
    private String numeroColegiatura;
    @Size(max = 30)
    @Column(name = "TELEFONO_PERSONAL")
    private String telefonoPersonal;
    @Column(name = "FECHA_FIN_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinVigencia;
    @Size(max = 500)
    @Column(name = "ALERGIA_LOCADOR")
    private String alergiaLocador;
    @Column(name = "FECHA_INICIO_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioVigencia;
    @Size(max = 500)
    @Column(name = "RESTRICCION_MEDICA")
    private String restriccionMedica;
    @Size(max = 50)
    @Column(name = "CORREO_ELECTRONICO_PERSONAL")
    private String correoElectronicoPersonal;
    @Size(max = 50)
    @Column(name = "CORREO_ELECTRONICO_LABORAL")
    private String correoElectronicoLaboral;
    @Column(name = "ID_PROFESION")
    private Long idProfesion;
    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private char estado;
    @Size(max = 2)
    @Column(name = "ORIGEN_INFORMACION")
    private String origenInformacion;
    @Size(max = 200)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Size(max = 8)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "COROCO_IDCORRENTISTA")
    private Integer corocoIdcorrentista;
    @OneToMany(mappedBy = "idLocador", fetch = FetchType.LAZY)
    private List<MdiContratoEmpresaLocador> mdiContratoEmpresaLocadorList;
    @OneToMany(mappedBy = "idLocador", fetch = FetchType.LAZY)
    private List<PghPersonal> pghPersonalList;

    public MdiLocador() {
    }

    public MdiLocador(Long idLocador) {
        this.idLocador = idLocador;
    }

    public MdiLocador(Long idLocador, Long idTipoDocumentoIdentidad,String descTipoDocumentoIdentidad ,String numeroDocumento, String primerNombre, String apellidoPaterno, String apellidoMaterno, char estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idLocador = idLocador;
//        this.idTipoDocumentoIdentidad = idTipoDocumentoIdentidad;
        this.idTipoDocumentoIdentidad=new MdiMaestroColumna(idTipoDocumentoIdentidad,descTipoDocumentoIdentidad);
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Long idLocador) {
        this.idLocador = idLocador;
    }
    
    public MdiMaestroColumna getIdTipoDocumentoIdentidad() {
		return idTipoDocumentoIdentidad;
	}

	public void setIdTipoDocumentoIdentidad(
			MdiMaestroColumna idTipoDocumentoIdentidad) {
		this.idTipoDocumentoIdentidad = idTipoDocumentoIdentidad;
	}

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Long getSexo() {
        return sexo;
    }

    public void setSexo(Long sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(Long tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Long getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Long estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getHijos() {
        return hijos;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

    public Short getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(Short numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public Long getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(Long idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Long getIdColegioProfesional() {
        return idColegioProfesional;
    }

    public void setIdColegioProfesional(Long idColegioProfesional) {
        this.idColegioProfesional = idColegioProfesional;
    }

    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(String numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public String getAlergiaLocador() {
        return alergiaLocador;
    }

    public void setAlergiaLocador(String alergiaLocador) {
        this.alergiaLocador = alergiaLocador;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public String getRestriccionMedica() {
        return restriccionMedica;
    }

    public void setRestriccionMedica(String restriccionMedica) {
        this.restriccionMedica = restriccionMedica;
    }

    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    public String getCorreoElectronicoLaboral() {
        return correoElectronicoLaboral;
    }

    public void setCorreoElectronicoLaboral(String correoElectronicoLaboral) {
        this.correoElectronicoLaboral = correoElectronicoLaboral;
    }

    public Long getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Long idProfesion) {
        this.idProfesion = idProfesion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getOrigenInformacion() {
        return origenInformacion;
    }

    public void setOrigenInformacion(String origenInformacion) {
        this.origenInformacion = origenInformacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCorocoIdcorrentista() {
        return corocoIdcorrentista;
    }

    public void setCorocoIdcorrentista(Integer corocoIdcorrentista) {
        this.corocoIdcorrentista = corocoIdcorrentista;
    }

    @XmlTransient
    public List<MdiContratoEmpresaLocador> getMdiContratoEmpresaLocadorList() {
        return mdiContratoEmpresaLocadorList;
    }

    public void setMdiContratoEmpresaLocadorList(List<MdiContratoEmpresaLocador> mdiContratoEmpresaLocadorList) {
        this.mdiContratoEmpresaLocadorList = mdiContratoEmpresaLocadorList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghPersonal> getPghPersonalList() {
        return pghPersonalList;
    }

    public void setPghPersonalList(List<PghPersonal> pghPersonalList) {
        this.pghPersonalList = pghPersonalList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocador != null ? idLocador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiLocador)) {
            return false;
        }
        MdiLocador other = (MdiLocador) object;
        if ((this.idLocador == null && other.idLocador != null) || (this.idLocador != null && !this.idLocador.equals(other.idLocador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.MdiLocador[ idLocador=" + idLocador + " ]";
    }
    
}
