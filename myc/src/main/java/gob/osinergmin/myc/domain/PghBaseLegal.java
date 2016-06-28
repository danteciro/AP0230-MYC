/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligaciones;
import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_BASE_LEGAL")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PghBaseLegal.findAll", query = "SELECT p FROM PghBaseLegal p"),
    @NamedQuery(name = "PghBaseLegal.findActiveAll", query = "SELECT p FROM PghBaseLegal p WHERE p.estado='1'"),
    @NamedQuery(name = "PghBaseLegal.countAll",query="SELECT count(p.idBaseLegal) FROM PghBaseLegal p WHERE p.estado='1'"),
    @NamedQuery(name = "PghBaseLegal.countByFilter",query="SELECT count(p.idBaseLegal) FROM PghBaseLegal p WHERE p.estado='1' and upper(p.descripcion) like :descripcion and upper(p.codigoBaseLegal) like :codigoBaseLegal "),
    @NamedQuery(name = "PghBaseLegal.countByIdBaseLegal",query="SELECT count(p.idBaseLegal) FROM PghBaseLegal p WHERE p.estado='1' and p.idBaseLegal=:idBaseLegal"),
    @NamedQuery(name = "PghBaseLegal.findByFilter",query="SELECT p FROM PghBaseLegal p WHERE p.estado='1' and upper(p.descripcion) like :descripcion and upper(p.codigoBaseLegal) like :codigoBaseLegal order by p.codigoBaseLegal desc "),
    @NamedQuery(name = "PghBaseLegal.countByFilterPadre",query="SELECT count(p.idBaseLegal) FROM PghBaseLegal p " +
    		"WHERE p.estado='1' " +
    		"and p.flagPadre='P' " +
    		"and upper(p.descripcion) like :descripcion " +
    		"and upper(p.codigoBaseLegal) like :codigoBaseLegal " +
    		"and upper(p.titulo) like :titulo "),
    @NamedQuery(name = "PghBaseLegal.findByFilterPadre",query="SELECT new PghBaseLegal(p.idBaseLegal, p.codigoBaseLegal, p.descripcion,d.idDocumentoAdjunto,d.nombreArchivo,d.rutaAlfresco,p.flagPadre," +
    		"sum(case when (select x.idBaseLegal from PghBaseLegal x where x.idBaseLegalPadre=p.idBaseLegal and x.estado='1' and rownum=1) is not null then 1 else 0 end) as tieneAct) " +
    		"FROM PghBaseLegal p left join p.idDocumentoAdjunto d  " +
    		"WHERE p.estado='1' and p.flagPadre='P' and upper(p.descripcion) like :descripcion and upper(p.codigoBaseLegal) like :codigoBaseLegal " +
    		"and upper(p.titulo) like :titulo " +
    		"group by p.idBaseLegal,p.codigoBaseLegal, p.descripcion,d.idDocumentoAdjunto,d.nombreArchivo,d.rutaAlfresco,p.flagPadre " +
    		"order by p.codigoBaseLegal desc "),
    @NamedQuery(name=  "PghBaseLegal.findByIdBaseLegal",query="SELECT p FROM PghBaseLegal P WHERE P.estado='1' and p.idBaseLegal=:idBaseLegal "),
    @NamedQuery(name=  "PghBaseLegal.findByCodigoBaseLegal",query="SELECT p FROM PghBaseLegal P WHERE P.estado='1' and p.codigoBaseLegal=:codigoBaseLegal ")})
public class PghBaseLegal extends ColumAddObligacionesTmp  {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="ID_BASE_LEGAL_SEQ",sequenceName="PGH_BASE_LEGAL_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_BASE_LEGAL_SEQ")
    @Column(name = "ID_BASE_LEGAL")
    private Long idBaseLegal;
    @Column(name = "CODIGO_BASE_LEGAL")
    private String codigoBaseLegal;
    @Column(name = "ID_TIPO_NORMA_LEGAL")
    private Long idTipoNormaLegal;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "ANIO")
    private String anio;
    @Column(name = "ID_SIGLA")
    private Long idSigla;
    @Column(name = "FECHA_ENTRADA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntradaVigencia;
    @Column(name = "FECHA_PUBLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    /*Rsis 1 - Inicio*/
    //@Column(name = "NUMERO_TIPO_ANEXO")
    //private String numeroAnexo;
    /*Rsis 1 - Inicio*/
    @Column(name = "ID_BASE_LEGAL_REF")
    private Long idBaseLegalRef;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FLAG_PADRE")
    private String flagPadre;
    @Column(name = "ID_BASE_LEGAL_PADRE")
    private Long idBaseLegalPadre;
    @Column(name = "FECHA_TERMINO_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminoVigencia;
    @JoinColumn(name = "ID_DOCUMENTO_ADJUNTO", referencedColumnName = "ID_DOCUMENTO_ADJUNTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiDocumentoAdjunto idDocumentoAdjunto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBaseLegalOri", fetch = FetchType.LAZY)
    private List<PghListadoBaseLegal> pghListadoBaseLegalList;
    @OneToMany(mappedBy = "idBaseLegalDest", fetch = FetchType.LAZY)
    private List<PghListadoBaseLegal> pghListadoBaseLegalList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBaseLegal", fetch = FetchType.LAZY)
    private List<PghDetalleBaseLegal> pghDetalleBaseLegalList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pghBaseLegal", fetch = FetchType.LAZY)
//    private List<PghObligacionBaseLegal> pghObligacionBaseLegalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBaseLegal", fetch = FetchType.LAZY)
    private List<PghObligacionBaseLegal> pghObligacionBaseLegalList;
    //campo flag
    @Transient
    private Long tieneAct;
    
    
    public Long getTieneAct() {
		return tieneAct;
	}

	public void setTieneAct(Long tieneAct) {
		this.tieneAct = tieneAct;
	}

	public PghBaseLegal() {
    }

    public PghBaseLegal(Long idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }
    
    public PghBaseLegal(Long idBaseLegal, String codigoBaseLegal, String descripcion,Long idDocumentoAdjunto,String nombreArchivo,String rutaAlfresco,Long tieneAct) {
        this.idBaseLegal = idBaseLegal;
        this.codigoBaseLegal = codigoBaseLegal;
        this.descripcion = descripcion;
        this.idDocumentoAdjunto=new MdiDocumentoAdjunto(idDocumentoAdjunto,nombreArchivo,rutaAlfresco);
        this.tieneAct = tieneAct;
    }
    
    public PghBaseLegal(Long idBaseLegal, String codigoBaseLegal, String descripcion,Long idDocumentoAdjunto,String nombreArchivo,String rutaAlfresco,String flagPadre,Long tieneAct) {
        this.idBaseLegal = idBaseLegal;
        this.codigoBaseLegal = codigoBaseLegal;
        this.descripcion = descripcion;
        this.idDocumentoAdjunto=new MdiDocumentoAdjunto(idDocumentoAdjunto,nombreArchivo,rutaAlfresco);
        this.tieneAct = tieneAct;
        this.flagPadre = flagPadre;
    }
    
    public PghBaseLegal(Long idBaseLegal, String codigoBaseLegal, String descripcion,String estado) {
        this.idBaseLegal = idBaseLegal;
        this.codigoBaseLegal = codigoBaseLegal;
        this.descripcion = descripcion;
        this.estado = estado;
    } 
    
    public PghBaseLegal(Long idBaseLegal, String codigoBaseLegal, String descripcion,Long idDocumentoAdjunto,String nombreArchivo,String rutaAlfresco) {
        this.idBaseLegal = idBaseLegal;
        this.codigoBaseLegal = codigoBaseLegal;
        this.descripcion = descripcion;
        this.idDocumentoAdjunto=new MdiDocumentoAdjunto(idDocumentoAdjunto,nombreArchivo,rutaAlfresco);
    }

    public PghBaseLegal(Long idBaseLegal, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idBaseLegal = idBaseLegal;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdBaseLegal() {
        return idBaseLegal;
    }

    public void setIdBaseLegal(Long idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }

    
    public String getFlagPadre() {
		return flagPadre;
	}

	public void setFlagPadre(String flagPadre) {
		this.flagPadre = flagPadre;
	}

	public Long getIdBaseLegalPadre() {
		return idBaseLegalPadre;
	}

	public void setIdBaseLegalPadre(Long idBaseLegalPadre) {
		this.idBaseLegalPadre = idBaseLegalPadre;
	}

	public String getCodigoBaseLegal() {
        return codigoBaseLegal;
    }

    public void setCodigoBaseLegal(String codigoBaseLegal) {
        this.codigoBaseLegal = codigoBaseLegal;
    }

    public Long getIdTipoNormaLegal() {
        return idTipoNormaLegal;
    }

    public void setIdTipoNormaLegal(Long idTipoNormaLegal) {
        this.idTipoNormaLegal = idTipoNormaLegal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Long getIdSigla() {
        return idSigla;
    }

    public void setIdSigla(Long idSigla) {
        this.idSigla = idSigla;
    }

    public Date getFechaEntradaVigencia() {
        return fechaEntradaVigencia;
    }

    public void setFechaEntradaVigencia(Date fechaEntradaVigencia) {
        this.fechaEntradaVigencia = fechaEntradaVigencia;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdBaseLegalRef() {
        return idBaseLegalRef;
    }

    public void setIdBaseLegalRef(Long idBaseLegalRef) {
        this.idBaseLegalRef = idBaseLegalRef;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaTerminoVigencia() {
        return fechaTerminoVigencia;
    }

    public void setFechaTerminoVigencia(Date fechaTerminoVigencia) {
        this.fechaTerminoVigencia = fechaTerminoVigencia;
    }

    public MdiDocumentoAdjunto getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(MdiDocumentoAdjunto idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }
    
    /*Rsis 1 - Inicio*/
    /*public String getNumeroAnexo() {
		return numeroAnexo;
	}

	public void setNumeroAnexo(String numeroAnexo) {
		this.numeroAnexo = numeroAnexo;
	}
	*/
	/*Rsis 1 - Fin*/
	@XmlTransient
    public List<PghObligacionBaseLegal> getPghObligacionBaseLegalList() {
        return pghObligacionBaseLegalList;
    }

    public void setPghObligacionBaseLegalList(List<PghObligacionBaseLegal> pghObligacionBaseLegalList) {
        this.pghObligacionBaseLegalList = pghObligacionBaseLegalList;
    }

    public List<PghListadoBaseLegal> getPghListadoBaseLegalList() {
        return pghListadoBaseLegalList;
    }

    public void setPghListadoBaseLegalList(List<PghListadoBaseLegal> pghListadoBaseLegalList) {
        this.pghListadoBaseLegalList = pghListadoBaseLegalList;
    }

    public List<PghListadoBaseLegal> getPghListadoBaseLegalList1() {
        return pghListadoBaseLegalList1;
    }

    public void setPghListadoBaseLegalList1(List<PghListadoBaseLegal> pghListadoBaseLegalList1) {
        this.pghListadoBaseLegalList1 = pghListadoBaseLegalList1;
    }

    public List<PghDetalleBaseLegal> getPghDetalleBaseLegalList() {
        return pghDetalleBaseLegalList;
    }

    public void setPghDetalleBaseLegalList(List<PghDetalleBaseLegal> pghDetalleBaseLegalList) {
        this.pghDetalleBaseLegalList = pghDetalleBaseLegalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBaseLegal != null ? idBaseLegal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghBaseLegal)) {
            return false;
        }
        PghBaseLegal other = (PghBaseLegal) object;
        if ((this.idBaseLegal == null && other.idBaseLegal != null) || (this.idBaseLegal != null && !this.idBaseLegal.equals(other.idBaseLegal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghBaseLegal[ idBaseLegal=" + idBaseLegal + " ]";
    }
    
}
