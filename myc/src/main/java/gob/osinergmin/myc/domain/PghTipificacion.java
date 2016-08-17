/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author cflorian
 */
@Entity
@Table(name = "PGH_TIPIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghTipificacion.countAll", query = "SELECT count(p.idTipificacion) FROM PghTipificacion p"),
    @NamedQuery(name = "PghTipificacion.findAll", query = "SELECT p FROM PghTipificacion p"),
//    @NamedQuery(name = "PghTipificacion.countByFilter",query="SELECT count(p.idTipificacion) FROM PghTipificacion p WHERE p.estado='1' and upper(p.descripcion) like :descripcion and upper(p.codTipificacion) like :codTipificacion "),    
//    @NamedQuery(name = "PghTipificacion.findByFilter",query="SELECT new PghTipificacion(p.idTipificacion,"
//        + "p.claseSancion.idMaestroColumna, p.claseSancion.descripcion,"
//        + "p.codTipificacion,p.descripcion,p.sancionMonetaria,p.idTipificacionPadre,"
//        + "sum(case when tsl.pghTipoSancion.idTipoSancion is not null and tsl.estado='1' then 1 else 0 end) as tieneSanc ) "
//        + "FROM PghTipificacion p left join p.pghTipificacionSancionList tsl "
//        + "WHERE p.estado='1' and upper(p.descripcion) like :descripcion and upper(p.codTipificacion) like :codTipificacion "
//        + "GROUP BY p.idTipificacion,p.claseSancion.idMaestroColumna, p.claseSancion.descripcion,p.codTipificacion,p.descripcion,p.sancionMonetaria,p.idTipificacionPadre "),     
    @NamedQuery(name = "PghTipificacion.countByIdTipificacion", query = "SELECT count(p.idTipificacion) FROM PghTipificacion p WHERE p.idTipificacion = :idTipificacion"),
    @NamedQuery(name = "PghTipificacion.findByIdTipificacion", query = "SELECT p FROM PghTipificacion p WHERE p.idTipificacion = :idTipificacion"),
//    @NamedQuery(name = "PghTipificacion.findByDescripcion", query = "SELECT p FROM PghTipificacion p WHERE p.descripcion = :descripcion"),
//    @NamedQuery(name = "PghTipificacion.findByIdTipoMoneda", query = "SELECT p FROM PghTipificacion p WHERE p.idTipoMoneda = :idTipoMoneda"),
//    @NamedQuery(name = "PghTipificacion.findBySancionMonetaria", query = "SELECT p FROM PghTipificacion p WHERE p.sancionMonetaria = :sancionMonetaria"),
//    @NamedQuery(name = "PghTipificacion.findByEstado", query = "SELECT p FROM PghTipificacion p WHERE p.estado = :estado"),
//    @NamedQuery(name = "PghTipificacion.findByIdTipificacionPadre", query = "SELECT p FROM PghTipificacion p WHERE p.idTipificacionPadre = :idTipificacionPadre"),
//    @NamedQuery(name = "PghTipificacion.findByUsuarioCreacion", query = "SELECT p FROM PghTipificacion p WHERE p.usuarioCreacion = :usuarioCreacion"),
//    @NamedQuery(name = "PghTipificacion.findByTerminalCreacion", query = "SELECT p FROM PghTipificacion p WHERE p.terminalCreacion = :terminalCreacion"),
//    @NamedQuery(name = "PghTipificacion.findByUsuarioActualizacion", query = "SELECT p FROM PghTipificacion p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
//    @NamedQuery(name = "PghTipificacion.findByTerminalActualizacion", query = "SELECT p FROM PghTipificacion p WHERE p.terminalActualizacion = :terminalActualizacion"),
//    @NamedQuery(name = "PghTipificacion.findByBasesLegales", query = "SELECT p FROM PghTipificacion p WHERE p.basesLegales = :basesLegales"),
//    @NamedQuery(name = "PghTipificacion.findByFechaCreacion", query = "SELECT p FROM PghTipificacion p WHERE p.fechaCreacion = :fechaCreacion"),
//    @NamedQuery(name = "PghTipificacion.findByFechaActualizacion", query = "SELECT p FROM PghTipificacion p WHERE p.fechaActualizacion = :fechaActualizacion")
})
public class PghTipificacion extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPIFICACION")
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_TIPIFICACION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long idTipificacion;
    @Column(name = "COD_TIPIFICACION")
    private String codTipificacion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ID_TIPO_MONEDA")
    private Long idTipoMoneda;
    @Column(name = "SANCION_MONETARIA")
    private String sancionMonetaria;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "BASES_LEGALES")
    private String basesLegales;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASE_SANCION")
    private MdiMaestroColumna claseSancion;
    @OneToMany(mappedBy = "idTipificacion", fetch = FetchType.LAZY)
    private List<PghObliTipiCriterio> pghObliTipiCriterioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipificacion", fetch = FetchType.LAZY)
    private List<PghObligacionTipificacion> pghObligacionTipificacionList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pghTipificacion")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pghTipificacion", fetch = FetchType.LAZY)
    private List<PghTipificacionSancion> pghTipificacionSancionList;
    
    @Column(name = "ID_TIPIFICACION_PADRE")
    private Long idTipificacionPadre;
    @Transient
    private Long tieneAct;
    
    public Long getIdTipificacionPadre() {
		return idTipificacionPadre;
	}

	public void setIdTipificacionPadre(Long idTipificacionPadre) {
		this.idTipificacionPadre = idTipificacionPadre;
	}


	@Transient
    private String tieneSanc;
    @Transient
    private String descTipiPadre;
    
    public PghTipificacion() {
    }

    public PghTipificacion(Long idTipificacion, Long claseSancion, String descClaseSancion,String codTipificacion,String descripcion,String sancionMonetaria,String descTipiPadre, String tieneSanc) {
        this.idTipificacion = idTipificacion;
        this.claseSancion=new MdiMaestroColumna(claseSancion, descClaseSancion);
        this.codTipificacion=codTipificacion;
        this.descripcion=descripcion;
        this.sancionMonetaria=sancionMonetaria;
        this.tieneSanc=tieneSanc;
        this.descTipiPadre=descTipiPadre;
    }
    
    public PghTipificacion(Long idTipificacion, String codTipificacion, String descripcion, String sancionMonetaria, String estado, String basesLegales, Long tieneAct) {
        this.idTipificacion = idTipificacion;
        this.codTipificacion=codTipificacion;
        this.descripcion=descripcion;
        this.sancionMonetaria=sancionMonetaria;
        this.estado = estado;
        this.basesLegales = basesLegales;
        this.tieneAct = tieneAct;
    }

    public String getDescTipiPadre() {
        return descTipiPadre;
    }

    public void setDescTipiPadre(String descTipiPadre) {
        this.descTipiPadre = descTipiPadre;
    }
    
    public String getCodTipificacion() {
        return codTipificacion;
    }

    public String getTieneSanc() {
        return tieneSanc;
    }

    public void setTieneSanc(String tieneSanc) {
        this.tieneSanc = tieneSanc;
    }

    public void setCodTipificacion(String codTipificacion) {
        this.codTipificacion = codTipificacion;
    }
    
    public PghTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

    public Long getIdTipificacion() {
        return idTipificacion;
    }

    public void setIdTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public void setIdTipoMoneda(Long idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public String getSancionMonetaria() {
        return sancionMonetaria;
    }

    public void setSancionMonetaria(String sancionMonetaria) {
        this.sancionMonetaria = sancionMonetaria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getBasesLegales() {
        return basesLegales;
    }

    public void setBasesLegales(String basesLegales) {
        this.basesLegales = basesLegales;
    }
/* Giancarlo 07/07/15
    public PghTipificacion getPghTipificacion() {
        return pghTipificacion;
    }

    public void setPghTipificacion(PghTipificacion pghTipificacion) {
        this.pghTipificacion = pghTipificacion;
    }

    public PghTipificacion getPghTipificacion1() {
        return pghTipificacion1;
    }

    public void setPghTipificacion1(PghTipificacion pghTipificacion1) {
        this.pghTipificacion1 = pghTipificacion1;
    }
*/
    //    public Long getClaseSancion() {
    //        return claseSancion;
    //    }
    //
    //    public void setClaseSancion(Long claseSancion) {
    //        this.claseSancion = claseSancion;
    //    }
    public MdiMaestroColumna getClaseSancion() {
        return claseSancion;
    }

    public void setClaseSancion(MdiMaestroColumna claseSancion) {
        this.claseSancion = claseSancion;
    }
    
    @XmlTransient
    public List<PghObliTipiCriterio> getPghObliTipiCriterioList() {
		return pghObliTipiCriterioList;
	}

	public void setPghObliTipiCriterioList(
			List<PghObliTipiCriterio> pghObliTipiCriterioList) {
		this.pghObliTipiCriterioList = pghObliTipiCriterioList;
	}

	@XmlTransient
    @JsonIgnore
    public List<PghObligacionTipificacion> getPghObligacionTipificacionList() {
        return pghObligacionTipificacionList;
    }

    public void setPghObligacionTipificacionList(List<PghObligacionTipificacion> pghObligacionTipificacionList) {
        this.pghObligacionTipificacionList = pghObligacionTipificacionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PghTipificacionSancion> getPghTipificacionSancionList() {
        return pghTipificacionSancionList;
    }

    public void setPghTipificacionSancionList(List<PghTipificacionSancion> pghTipificacionSancionList) {
        this.pghTipificacionSancionList = pghTipificacionSancionList;
    }
    

    public Long getTieneAct() {
		return tieneAct;
	}

	public void setTieneAct(Long tieneAct) {
		this.tieneAct = tieneAct;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipificacion != null ? idTipificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghTipificacion)) {
            return false;
        }
        PghTipificacion other = (PghTipificacion) object;
        if ((this.idTipificacion == null && other.idTipificacion != null) || (this.idTipificacion != null && !this.idTipificacion.equals(other.idTipificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PghTipificacion[ idTipificacion=" + idTipificacion + " ]";
    }
    
}
