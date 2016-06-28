/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rcoloradoa
 */
@Entity
@Table(name = "PGH_DETALLE_NORMA_TECNICA")
@XmlRootElement
public class PghDetalleNormaTecnica  extends Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PGH_DETALLE_NORMA_TECNICA_SEQ",sequenceName="PGH_DETALLE_NORMA_TECNICA_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PGH_DETALLE_NORMA_TECNICA_SEQ")
    @Column(name = "ID_DETALLE_NORMA_TECNICA")
    private Long idDetalleNormaTecnica;
//    @Column(name = "ID_TIPO_NORMA_TECNICA")
//    private Long idTipoNormaTecnica;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_NORMA_TECNICA")
    private String descripcionNormaTecnica;
    @Column(name = "ID_PADRE")
    private BigInteger idPadre;
    @Size(max = 20)
    @Column(name = "COD_TRAZABILIDAD")
    private String codTrazabilidad;
    @Size(max = 1)
    @Column(name = "COD_ACCION")
    private String codAccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private Character estado;    
    @JoinColumn(name = "ID_DETALLE_BASE_LEGAL", referencedColumnName = "ID_DETALLE_BASE_LEGAL")
    @ManyToOne(fetch = FetchType.LAZY)
    private PghDetalleBaseLegal idDetalleBaseLegal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_NORMA_TECNICA")
    private MdiMaestroColumna idTipoNormaTecnica;
    

    public PghDetalleNormaTecnica() {
    }

    
    
    public PghDetalleNormaTecnica(Long idDetalleNormaTecnica,String descripcionNormaTecnica, Long idTipoNormaTecnica, String descripcionIdTipoNormaTecnica, Long idBaseLegal) {
		this.idDetalleNormaTecnica = idDetalleNormaTecnica;
		this.descripcionNormaTecnica = descripcionNormaTecnica;
		this.idTipoNormaTecnica = new MdiMaestroColumna(idTipoNormaTecnica,descripcionIdTipoNormaTecnica);
		this.idDetalleBaseLegal = new PghDetalleBaseLegal(idBaseLegal);
	}



	public PghDetalleNormaTecnica(Long idDetalleNormaTecnica) {
        this.idDetalleNormaTecnica = idDetalleNormaTecnica;
    }

    public PghDetalleNormaTecnica(Long idDetalleNormaTecnica, Character estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idDetalleNormaTecnica = idDetalleNormaTecnica;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdDetalleNormaTecnica() {
        return idDetalleNormaTecnica;
    }

    public void setIdDetalleNormaTecnica(Long idDetalleNormaTecnica) {
        this.idDetalleNormaTecnica = idDetalleNormaTecnica;
    }

//    public Long getIdTipoNormaTecnica() {
//        return idTipoNormaTecnica;
//    }
//
//    public void setIdTipoNormaTecnica(Long idTipoNormaTecnica) {
//        this.idTipoNormaTecnica = idTipoNormaTecnica;
//    }
    
    public String getDescripcionNormaTecnica() {
        return descripcionNormaTecnica;
    }

    public MdiMaestroColumna getIdTipoNormaTecnica() {
		return idTipoNormaTecnica;
	}

	public void setIdTipoNormaTecnica(MdiMaestroColumna idTipoNormaTecnica) {
		this.idTipoNormaTecnica = idTipoNormaTecnica;
	}

	public void setDescripcionNormaTecnica(String descripcionNormaTecnica) {
        this.descripcionNormaTecnica = descripcionNormaTecnica;
    }

    public BigInteger getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(BigInteger idPadre) {
        this.idPadre = idPadre;
    }

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }

    public String getCodAccion() {
        return codAccion;
    }

    public void setCodAccion(String codAccion) {
        this.codAccion = codAccion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }


    public PghDetalleBaseLegal getIdDetalleBaseLegal() {
        return idDetalleBaseLegal;
    }

    public void setIdDetalleBaseLegal(PghDetalleBaseLegal idDetalleBaseLegal) {
        this.idDetalleBaseLegal = idDetalleBaseLegal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleNormaTecnica != null ? idDetalleNormaTecnica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghDetalleNormaTecnica)) {
            return false;
        }
        PghDetalleNormaTecnica other = (PghDetalleNormaTecnica) object;
        if ((this.idDetalleNormaTecnica == null && other.idDetalleNormaTecnica != null) || (this.idDetalleNormaTecnica != null && !this.idDetalleNormaTecnica.equals(other.idDetalleNormaTecnica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lki.PghDetalleNormaTecnica[ idDetalleNormaTecnica=" + idDetalleNormaTecnica + " ]";
    }
    
}
