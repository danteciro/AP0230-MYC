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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_DETALLE_BASE_LEGAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghDetalleBaseLegal.findAll", query = "SELECT p FROM PghDetalleBaseLegal p"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByIdDetalleBaseLegal", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.idDetalleBaseLegal = :idDetalleBaseLegal"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByIdNivelArticulo", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.idNivelArticulo = :idNivelArticulo"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByArticulo", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.articulo = :articulo"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByInciso1", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.inciso1 = :inciso1"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByInciso2", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.inciso2 = :inciso2"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByNormaTecnica", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.normaTecnica = :normaTecnica"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByFechaEntradaVigencia", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.fechaEntradaVigencia = :fechaEntradaVigencia"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByFechaPublicacion", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.fechaPublicacion = :fechaPublicacion"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByModificatorias", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.modificatorias = :modificatorias"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByConcordancias", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.concordancias = :concordancias"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByDescripcion", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByEstado", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByUsuarioCreacion", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByFechaCreacion", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByTerminalCreacion", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByUsuarioActualizacion", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByFechaActualizacion", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByTerminalActualizacion", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.terminalActualizacion = :terminalActualizacion"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByIdTipoAnexo", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.idTipoAnexo = :idTipoAnexo"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByArticuloAnexo", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.articuloAnexo = :articuloAnexo"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByInciso1Anexo", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.inciso1Anexo = :inciso1Anexo"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByInciso2Anexo", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.inciso2Anexo = :inciso2Anexo"),
    @NamedQuery(name = "PghDetalleBaseLegal.findByIdTipoNormaTecnica", query = "SELECT p FROM PghDetalleBaseLegal p WHERE p.idTipoNormaTecnica = :idTipoNormaTecnica")})
public class PghDetalleBaseLegal extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="ID_DETALLE_BASE_LEGAL_SEQ",sequenceName="PGH_DETALLE_BASE_LEGAL_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_DETALLE_BASE_LEGAL_SEQ")
    @Column(name = "ID_DETALLE_BASE_LEGAL")
    private Long idDetalleBaseLegal;
    @Column(name = "ARTICULO")
    private String articulo;
    @Column(name = "INCISO_1")
    private String inciso1;
    @Column(name = "INCISO_2")
    private String inciso2;
    @Column(name = "NORMA_TECNICA")
    private String normaTecnica;
    @Column(name = "FECHA_ENTRADA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntradaVigencia;
    @Column(name = "FECHA_PUBLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @Column(name = "MODIFICATORIAS")
    private Character modificatorias;
    @Column(name = "CONCORDANCIAS")
    private Character concordancias;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ID_NIVEL_ARTICULO")
    private Long idNivelArticulo;
    @Column(name = "ID_TIPO_ANEXO")
    private Long idTipoAnexo;
    @Column(name = "ARTICULO_ANEXO")
    private String articuloAnexo;
    /*Rsis 1 - Inicio*/
    @Column(name = "NUMERO_TIPO_ANEXO")
    private String numeroAnexo;
    /*Rsis 1 - Fin*/
    @Column(name = "INCISO_1_ANEXO")
    private String inciso1Anexo;
    @Column(name = "INCISO_2_ANEXO")
    private String inciso2Anexo;
    @Column(name = "ID_TIPO_NORMA_TECNICA")
    private Long idTipoNormaTecnica;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ID_NRO_DISPOSICION")
    private Long idNumeroDisposicion;
    @Column(name = "ID_TIPO_DISPOSICION")
    private Long idTipoDisposicion;
    @Column(name = "FLG_DISPOSICION")
    private String flgDisposicion;
    @JoinColumn(name = "ID_BASE_LEGAL", referencedColumnName = "ID_BASE_LEGAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghBaseLegal idBaseLegal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetalleBaseLegal", fetch = FetchType.LAZY)
    private List<PghDetalleNormaTecnica> pghDetalleNormaTecnicaList;
    

    public PghDetalleBaseLegal() {
    }

    public PghDetalleBaseLegal(Long idDetalleBaseLegal) {
        this.idDetalleBaseLegal = idDetalleBaseLegal;
    }

    public PghDetalleBaseLegal(Long idDetalleBaseLegal, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idDetalleBaseLegal = idDetalleBaseLegal;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdDetalleBaseLegal() {
        return idDetalleBaseLegal;
    }

    public void setIdDetalleBaseLegal(Long idDetalleBaseLegal) {
        this.idDetalleBaseLegal = idDetalleBaseLegal;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getInciso1() {
        return inciso1;
    }

    public void setInciso1(String inciso1) {
        this.inciso1 = inciso1;
    }

    public String getInciso2() {
        return inciso2;
    }

    public void setInciso2(String inciso2) {
        this.inciso2 = inciso2;
    }

    public String getNormaTecnica() {
        return normaTecnica;
    }

    public void setNormaTecnica(String normaTecnica) {
        this.normaTecnica = normaTecnica;
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

    public Character getModificatorias() {
        return modificatorias;
    }

    public void setModificatorias(Character modificatorias) {
        this.modificatorias = modificatorias;
    }

    public Character getConcordancias() {
        return concordancias;
    }

    public void setConcordancias(Character concordancias) {
        this.concordancias = concordancias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdNivelArticulo() {
        return idNivelArticulo;
    }

    public void setIdNivelArticulo(Long idNivelArticulo) {
        this.idNivelArticulo = idNivelArticulo;
    }

    public Long getIdTipoAnexo() {
        return idTipoAnexo;
    }

    public void setIdTipoAnexo(Long idTipoAnexo) {
        this.idTipoAnexo = idTipoAnexo;
    }

    public String getArticuloAnexo() {
        return articuloAnexo;
    }

    public void setArticuloAnexo(String articuloAnexo) {
        this.articuloAnexo = articuloAnexo;
    }

    public String getInciso1Anexo() {
        return inciso1Anexo;
    }

    public void setInciso1Anexo(String inciso1Anexo) {
        this.inciso1Anexo = inciso1Anexo;
    }

    public Long getIdNumeroDisposicion() {
		return idNumeroDisposicion;
	}

	public void setIdNumeroDisposicion(Long idNumeroDisposicion) {
		this.idNumeroDisposicion = idNumeroDisposicion;
	}

	public Long getIdTipoDisposicion() {
		return idTipoDisposicion;
	}

	public void setIdTipoDisposicion(Long idTipoDisposicion) {
		this.idTipoDisposicion = idTipoDisposicion;
	}

	

	public String getFlgDisposicion() {
		return flgDisposicion;
	}

	public void setFlgDisposicion(String flgDisposicion) {
		this.flgDisposicion = flgDisposicion;
	}

	public String getInciso2Anexo() {
        return inciso2Anexo;
    }

    public void setInciso2Anexo(String inciso2Anexo) {
        this.inciso2Anexo = inciso2Anexo;
    }

    public Long getIdTipoNormaTecnica() {
        return idTipoNormaTecnica;
    }

    public void setIdTipoNormaTecnica(Long idTipoNormaTecnica) {
        this.idTipoNormaTecnica = idTipoNormaTecnica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghBaseLegal getIdBaseLegal() {
        return idBaseLegal;
    }

    public void setIdBaseLegal(PghBaseLegal idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }
    /*Rsis 1 - Inicio*/       
    public String getNumeroAnexo() {
		return numeroAnexo;
	}
    
	public void setNumeroAnexo(String numeroAnexo) {
		this.numeroAnexo = numeroAnexo;
	}
	
	/*jsifuentes - Inicio*/
    @XmlTransient
    public List<PghDetalleNormaTecnica> getPghDetalleNormaTecnicaList() {
        return pghDetalleNormaTecnicaList;
    }

    public void setPghDetalleNormaTecnicaList(List<PghDetalleNormaTecnica> pghDetalleNormaTecnicaList) {
        this.pghDetalleNormaTecnicaList = pghDetalleNormaTecnicaList;
    }
    /*jsifuentes - Inicio*/
	/*Rsis 1 - Fin*/
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleBaseLegal != null ? idDetalleBaseLegal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghDetalleBaseLegal)) {
            return false;
        }
        PghDetalleBaseLegal other = (PghDetalleBaseLegal) object;
        if ((this.idDetalleBaseLegal == null && other.idDetalleBaseLegal != null) || (this.idDetalleBaseLegal != null && !this.idDetalleBaseLegal.equals(other.idDetalleBaseLegal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghDetalleBaseLegal[ idDetalleBaseLegal=" + idDetalleBaseLegal + " ]";
    }
    
}
