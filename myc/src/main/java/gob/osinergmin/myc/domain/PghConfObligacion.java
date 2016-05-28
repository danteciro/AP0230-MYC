/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.osinergmin.myc.domain;

import gob.osinergmin.myc.domain.component.ColumAddObligacionesTmp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author gvillanueva
 */
@Entity
@Table(name = "PGH_CONF_OBLIGACION")
@NamedQueries({
    @NamedQuery(name = "PghConfObligacion.findAll", query = "SELECT p FROM PghConfObligacion p"),
    @NamedQuery(name = "PghConfObligacion.findByFilter", query = "SELECT p FROM PghConfObligacion p where p.estado='1' and p.idObligacion=:idObligacion")})
public class PghConfObligacion extends ColumAddObligacionesTmp {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONF_OBLIGACION")
    @SequenceGenerator(name = "SEQ_GENERATOR_CONF_OBLG", sequenceName = "PGH_CONF_OBLI_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_CONF_OBLG")
    private Long idConfObligacion;
    @JoinColumns({
        @JoinColumn(name = "ID_OBLIGACION_TIPO", referencedColumnName = "ID_OBLIGACION_TIPO"),
        @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD"),
        @JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID_PROCESO"),
        @JoinColumn(name = "ID_PRO_OBL_TIP", referencedColumnName = "ID_PRO_OBL_TIP")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghProcesoObligacionTipo pghProcesoObligacionTipo;
    @JoinColumn(name = "ID_OBLIGACION", referencedColumnName = "ID_OBLIGACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghObligacion idObligacion;

    public PghConfObligacion() {
    }

    public PghConfObligacion(Long idConfObligacion) {
        this.idConfObligacion = idConfObligacion;
    }

    public PghConfObligacion(Long idConfObligacion, String estado, Date fechaCreacion, String terminalCreacion, String usuarioCreacion) {
        this.idConfObligacion = idConfObligacion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdConfObligacion() {
        return idConfObligacion;
    }

    public void setIdConfObligacion(Long idConfObligacion) {
        this.idConfObligacion = idConfObligacion;
    }

    public PghProcesoObligacionTipo getPghProcesoObligacionTipo() {
        return pghProcesoObligacionTipo;
    }

    public void setPghProcesoObligacionTipo(PghProcesoObligacionTipo pghProcesoObligacionTipo) {
        this.pghProcesoObligacionTipo = pghProcesoObligacionTipo;
    }

    public PghObligacion getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(PghObligacion idObligacion) {
        this.idObligacion = idObligacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfObligacion != null ? idConfObligacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghConfObligacion)) {
            return false;
        }
        PghConfObligacion other = (PghConfObligacion) object;
        if ((this.idConfObligacion == null && other.idConfObligacion != null) || (this.idConfObligacion != null && !this.idConfObligacion.equals(other.idConfObligacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghConfObligacion[ idConfObligacion=" + idConfObligacion + " ]";
    }
    
}
