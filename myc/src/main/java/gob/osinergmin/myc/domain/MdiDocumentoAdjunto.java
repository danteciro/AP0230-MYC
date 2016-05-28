/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
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
@Table(name = "MDI_DOCUMENTO_ADJUNTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MdiDocumentoAdjunto.countAll", query = "SELECT count(m.idDocumentoAdjunto) FROM MdiDocumentoAdjunto m"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findAll", query = "SELECT m FROM MdiDocumentoAdjunto m"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByIdDocumentoAdjunto", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.idDocumentoAdjunto = :idDocumentoAdjunto"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByNombreArchivo", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.nombreArchivo = :nombreArchivo"),
    @NamedQuery(name = "MdiDocumentoAdjunto.countByTitulo", query = "SELECT count(m.idDocumentoAdjunto) FROM MdiDocumentoAdjunto m WHERE m.titulo = :titulo and m.estado = '1'"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByTitulo", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.titulo = :titulo and m.estado = '1'"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByComentario", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.comentario = :comentario"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByFechaCarga", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.fechaCarga = :fechaCarga"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByFechaDocumento", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.fechaDocumento = :fechaDocumento"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByTipoDocumentoCarga", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.tipoDocumentoCarga = :tipoDocumentoCarga"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByFechaCaptura", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.fechaCaptura = :fechaCaptura"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByIdUnidadSupervisada", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.idUnidadSupervisada = :idUnidadSupervisada"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByRutaAlfresco", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.rutaAlfresco = :rutaAlfresco"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByEstado", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.estado = :estado"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByTipoProceso", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.tipoProceso = :tipoProceso"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByNroDocumento", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.nroDocumento = :nroDocumento"),
    @NamedQuery(name = "MdiDocumentoAdjunto.countByIdConcurso", query = "SELECT count(m.idDocumentoAdjunto) FROM MdiDocumentoAdjunto m WHERE m.idConcurso = :idConcurso and m.estado = :estado"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByIdConcurso", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.idConcurso = :idConcurso and m.estado = :estado"),
    @NamedQuery(name = "MdiDocumentoAdjunto.findByFotoPrincipal", query = "SELECT m FROM MdiDocumentoAdjunto m WHERE m.fotoPrincipal = :fotoPrincipal")})
public class MdiDocumentoAdjunto extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCUMENTO_ADJUNTO")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "MDI_DOCUMENTO_ADJUNTO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idDocumentoAdjunto;
    @Size(max = 500)
    @Column(name = "NOMBRE_ARCHIVO")
    private String nombreArchivo;
    @Size(max = 250)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 4000)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Column(name = "FECHA_CARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCarga;
    @Column(name = "FECHA_DOCUMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_DOCUMENTO_CARGA")
    private long tipoDocumentoCarga;
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "TIPO_DOCUMENTO_CARGA")    
//    private MdiMaestroColumna tipoDocumentoCarga;
    @Column(name = "FECHA_CAPTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaptura;
    @Column(name = "ID_UNIDAD_SUPERVISADA")
    private Long idUnidadSupervisada;
    @Size(max = 200)
    @Column(name = "RUTA_ALFRESCO")
    private String rutaAlfresco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "TIPO_PROCESO")
    private Long tipoProceso;
    @Size(max = 38)
    @Column(name = "NRO_DOCUMENTO")
    private String nroDocumento;
    @Column(name = "FOTO_PRINCIPAL")
    private Character fotoPrincipal;
    @Column(name = "ID_CONCURSO")
    private Long idConcurso;
    
    @OneToMany(mappedBy = "idDocumentoAdjunto", fetch = FetchType.LAZY)
    private List<PghRequisito> pghRequisitoList;

    public MdiDocumentoAdjunto() {
    }

    public MdiDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }
    
    public MdiDocumentoAdjunto(Long idDocumentoAdjunto,String nombreArchivo,String rutaAlfresco) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
        this.nombreArchivo=nombreArchivo;
        this.rutaAlfresco=rutaAlfresco;
    }

//    public MdiDocumentoAdjunto(Long idDocumentoAdjunto, String usuarioCreacion, Date fechaCreacion, String terminalCreacion, long tipoDocumentoCarga, String estado) {
//        this.idDocumentoAdjunto = idDocumentoAdjunto;
//        this.usuarioCreacion = usuarioCreacion;
//        this.fechaCreacion = fechaCreacion;
//        this.terminalCreacion = terminalCreacion;
//        this.tipoDocumentoCarga = new MdiMaestroColumna(tipoDocumentoCarga);
//        this.estado = estado;
//    }

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }



    public String getNombreArchivo() {
		return nombreArchivo;
	}
    public String getTitulo() {
        return titulo;
    }

	public void setNombreArchivo(String nombre) {
		this.nombreArchivo = nombre;
	}
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    //    public long getTipoDocumentoCarga() {
    //        return tipoDocumentoCarga;
    //    }
    //
    //    public void setTipoDocumentoCarga(long tipoDocumentoCarga) {
    //        this.tipoDocumentoCarga = tipoDocumentoCarga;
    //    }
    //    public MdiMaestroColumna getTipoDocumentoCarga() {
    //        return tipoDocumentoCarga;
    //    }
    //
    //    public void setTipoDocumentoCarga(MdiMaestroColumna tipoDocumentoCarga) {
    //        this.tipoDocumentoCarga = tipoDocumentoCarga;
    //    }
    public long getTipoDocumentoCarga() {
        return tipoDocumentoCarga;
    }

    public void setTipoDocumentoCarga(long tipoDocumentoCarga) {
        this.tipoDocumentoCarga = tipoDocumentoCarga;
    }
    
    

    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public Long getIdUnidadSupervisada() {
        return idUnidadSupervisada;
    }

    public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
        this.idUnidadSupervisada = idUnidadSupervisada;
    }

    public String getRutaAlfresco() {
        return rutaAlfresco;
    }

    public void setRutaAlfresco(String rutaAlfresco) {
        this.rutaAlfresco = rutaAlfresco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(Long tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Character getFotoPrincipal() {
        return fotoPrincipal;
    }

    public void setFotoPrincipal(Character fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }

    public Long getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(Long idConcurso) {
        this.idConcurso = idConcurso;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghRequisito> getPghRequisitoList() {
        return pghRequisitoList;
    }

    public void setPghRequisitoList(List<PghRequisito> pghRequisitoList) {
        this.pghRequisitoList = pghRequisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoAdjunto != null ? idDocumentoAdjunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiDocumentoAdjunto)) {
            return false;
        }
        MdiDocumentoAdjunto other = (MdiDocumentoAdjunto) object;
        if ((this.idDocumentoAdjunto == null && other.idDocumentoAdjunto != null) || (this.idDocumentoAdjunto != null && !this.idDocumentoAdjunto.equals(other.idDocumentoAdjunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.MdiDocumentoAdjunto[ idDocumentoAdjunto=" + idDocumentoAdjunto + " ]";
    }
    
}
