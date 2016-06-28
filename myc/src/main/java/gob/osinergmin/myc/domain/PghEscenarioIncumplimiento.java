/**
 * Resumen.
 * Objeto                   : PghEscenarioIncumplimiento.java 
 * Descripción              : Clase Entidad mapeada de la base de datos haciendo referencia a pgh_escenario_incumplimiento
 * Fecha de Creación        : 15/06/2016
 * PR de Modificacion 		: OSINE_119
 * Autor                    : Roy Colorado
 * ---------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo       Fecha       Nombre                 Descripcion
 * 	
 * ----------------------------------------------------------------------------------------                                          
 */
package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PGH_ESCENARIO_INCUMPLIMIENTO")
@XmlRootElement
public class PghEscenarioIncumplimiento extends ColumAddObligacionesTmp{
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_ESCE_INCUMPLIMIENTO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESCE_INCUMPLIMIENTO")
    private Long idEsceIncumplimiento;
    @NotNull
    @Column(name = "ESTADO")
    private String estado;    
    @JoinColumn(name = "ID_INFRACCION", referencedColumnName = "ID_INFRACCION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghInfraccion idInfraccion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESCE_INCU_MAESTRO")
    private MdiMaestroColumna idEsceIncuMaestro;
    
    public PghEscenarioIncumplimiento() {
    }

    public PghEscenarioIncumplimiento(Long idEsceIncumplimiento) {
        this.idEsceIncumplimiento = idEsceIncumplimiento;
    }

    public PghEscenarioIncumplimiento(Long idInfraccion , Long idEsceIncumplimiento, Long idEsceIncuMaestro, String descripcionEscenarioIncumplimiento) {
    	//this.idInfraccion.setIdInfraccion(idInfraccion);
    	this.idInfraccion = new PghInfraccion(idInfraccion);
        this.idEsceIncumplimiento = idEsceIncumplimiento;
        //this.idEsceIncuMaestro = idEsceIncuMaestro;
        this.idEsceIncuMaestro = new MdiMaestroColumna(idEsceIncuMaestro,descripcionEscenarioIncumplimiento);        
    }
    

    
    public Long getIdEsceIncumplimiento() {
        return idEsceIncumplimiento;
    }

    public void setIdEsceIncumplimiento(Long idEsceIncumplimiento) {
        this.idEsceIncumplimiento = idEsceIncumplimiento;
    }
    
    public MdiMaestroColumna getIdEsceIncuMaestro() {
		return idEsceIncuMaestro;
	}

	public void setIdEsceIncuMaestro(MdiMaestroColumna idEsceIncuMaestro) {
		this.idEsceIncuMaestro = idEsceIncuMaestro;
	}

	/*
    public long getIdEsceIncuMaestro() {
        return idEsceIncuMaestro;
    }

    public void setIdEsceIncuMaestro(long idEsceIncuMaestro) {
        this.idEsceIncuMaestro = idEsceIncuMaestro;
    }
    */
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    /*
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTerminalCreacion() {
        return terminalCreacion;
    }

    public void setTerminalCreacion(String terminalCreacion) {
        this.terminalCreacion = terminalCreacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getTerminalActualizacion() {
        return terminalActualizacion;
    }

    public void setTerminalActualizacion(String terminalActualizacion) {
        this.terminalActualizacion = terminalActualizacion;
    }
	*/
    public PghInfraccion getIdInfraccion() {
        return idInfraccion;
    }

    public void setIdInfraccion(PghInfraccion idInfraccion) {
        this.idInfraccion = idInfraccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsceIncumplimiento != null ? idEsceIncumplimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghEscenarioIncumplimiento)) {
            return false;
        }
        PghEscenarioIncumplimiento other = (PghEscenarioIncumplimiento) object;
        if ((this.idEsceIncumplimiento == null && other.idEsceIncumplimiento != null) || (this.idEsceIncumplimiento != null && !this.idEsceIncumplimiento.equals(other.idEsceIncumplimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "incumplimiento.PghEscenarioIncumplimiento[ idEsceIncumplimiento=" + idEsceIncumplimiento + " ]";
    }
    
}

