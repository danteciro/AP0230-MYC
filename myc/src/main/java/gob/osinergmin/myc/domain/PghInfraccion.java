/**
 * Resumen.
 * Objeto                   : PghInfraccion.java 
 * Descripción              : Clase Entidad mapeada de la base de datos haciendo referencia a PGH_INFRACCION 
 * Fecha de Creación        : 13/06/2016
 * PR de Modificacion 		: OSINE_119
 * Autor                    : Roy Colorado.
 * ---------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo       Fecha       Nombre                 Descripcion
 * ----------------------------------------------------------------------------------------                                          
 */

package gob.osinergmin.myc.domain;


import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;

import java.io.Serializable;
import java.util.Date;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "PGH_INFRACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghInfraccion.findByIdObligacion", query = "SELECT m FROM PghInfraccion m WHERE m.estado=:estado and m.idObligacion=:idObligacion order by m.idInfraccion")
})
public class PghInfraccion extends ColumAddObligacionesTmp{
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @Id    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFRACCION")
    /**
     * 
     */
    @SequenceGenerator(name = "SEQ_GENERATOR_INFRACCION", sequenceName = "PGH_INFRACCION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_INFRACCION")
    private Long idInfraccion;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_INFRACCION")
    private String descripcionInfraccion;
    @Column(name = "ID_MEDIDA_SEGURIDAD_MAESTRO")
    private Long idMedidaSeguridadMaestro;
    @Column(name = "ID_ACCION_MAESTRO")
    private Long idAccionMaestro;
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION")
    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    private PghObligacion idObligacion;
//    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION")
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private PghObligacion idObligacion;
//    @JoinColumn(name = "ID_DOCUMENTO_ADJUNTO", referencedColumnName = "ID_DOCUMENTO_ADJUNTO")
//    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
//    private MdiDocumentoAdjunto idDocumentoAdjunto;
    @JoinColumn(name = "ID_DOCUMENTO_ADJUNTO", referencedColumnName = "ID_DOCUMENTO_ADJUNTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private MdiDocumentoAdjunto idDocumentoAdjunto;
    
    
    public PghInfraccion() {
    }

    public PghInfraccion(Long idInfraccion) {
        this.idInfraccion = idInfraccion;
    }

    public PghInfraccion(Long idInfraccion,String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idInfraccion = idInfraccion;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdInfraccion() {
        return idInfraccion;
    }
    public void setIdInfraccion(Long idInfraccion) {
        this.idInfraccion = idInfraccion;
    }

    public String getDescripcionInfraccion() {
        return descripcionInfraccion;
    }

    public void setDescripcionInfraccion(String descripcionInfraccion) {
        this.descripcionInfraccion = descripcionInfraccion;
    }

    public Long getIdMedidaSeguridadMaestro() {
        return idMedidaSeguridadMaestro;
    }

    public void setIdMedidaSeguridadMaestro(Long idMedidaSeguridadMaestro) {
        this.idMedidaSeguridadMaestro = idMedidaSeguridadMaestro;
    }

    public Long getIdAccionMaestro() {
        return idAccionMaestro;
    }

    public void setIdAccionMaestro(Long idAccionMaestro) {
        this.idAccionMaestro = idAccionMaestro;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public PghObligacion getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(PghObligacion idObligacion) {
        this.idObligacion = idObligacion;
    }
    
    public MdiDocumentoAdjunto getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(MdiDocumentoAdjunto idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfraccion != null ? idInfraccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghInfraccion)) {
            return false;
        }
        PghInfraccion other = (PghInfraccion) object;
        if ((this.idInfraccion == null && other.idInfraccion != null) || (this.idInfraccion != null && !this.idInfraccion.equals(other.idInfraccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lo.PghInfraccion[ idInfraccion=" + idInfraccion + " ]";
    }
    
}

