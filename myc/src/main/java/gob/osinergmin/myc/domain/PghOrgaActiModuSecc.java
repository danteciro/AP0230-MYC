/**
* Resumen		
* Objeto			: PghOrgaActiModuSecc.java
* Descripción		: Clase del modelo de dominio PghOrgaActiModuSecc
* Fecha de Creación	: 23/07/2016
* PR de Creación	: RSIS 04
* Autor				: mdiosesf
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------				
* 
*/ 
package gob.osinergmin.myc.domain;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mdiosesf
 */
@Entity
@Table(name = "PGH_ORGA_ACTI_MODU_SECC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghOrgaActiModuSecc.findAll", query = "SELECT p FROM PghOrgaActiModuSecc p WHERE p.estado = '1'")})

public class PghOrgaActiModuSecc extends Auditoria {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="ID_ORGA_ACTI_MODU_SEQ",sequenceName="PGH_ORGA_ACTI_MODU_SECC_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_ORGA_ACTI_MODU_SEQ")
    @Column(name = "ID_ORGA_ACTI_MODU_SECC")
    private Long idOrgaActiModuSecc;
    @Basic(optional = false)
    @Column(name = "ORDEN_COMPONENTE")
    private Long ordenComponente;
    @Basic(optional = false)
    @Column(name = "ORDEN_SECCION")
    private Long ordenSeccion;    
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_SECCION", referencedColumnName = "ID_SECCION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghSeccion idSeccion;
    @JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghModulo idModulo;
    @JoinColumn(name = "ID_UNIDAD_ORGANICA", referencedColumnName = "ID_UNIDAD_ORGANICA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdiUnidadOrganica idUnidadOrganica;
    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdiActividad idActividad;

    public PghOrgaActiModuSecc() {
    }

    public PghOrgaActiModuSecc(Long idOrgaActiModuSecc) {
        this.idOrgaActiModuSecc = idOrgaActiModuSecc;
    }     
    
    public PghOrgaActiModuSecc(Long idOrgaActiModuSecc, Long ordenComponente, Long ordenSeccion, String estado,
    		PghSeccion idSeccion, PghModulo idModulo, MdiUnidadOrganica idUnidadOrganica, MdiActividad idActividad) {
		this.idOrgaActiModuSecc = idOrgaActiModuSecc;
		this.ordenComponente = ordenComponente;
		this.ordenSeccion = ordenSeccion;
		this.estado = estado;
		this.idSeccion = idSeccion;
		this.idModulo = idModulo;
		this.idUnidadOrganica = idUnidadOrganica;
		this.idActividad = idActividad;
	}
    
    public PghOrgaActiModuSecc(Long ordenComponente, String estado,
			Long idModulo, String rutaModulo, String descripcionModulo, String estadoModulo, String observacionesModulo,
			Long idUnidadOrganica, String descripcionUorganica, String detalleUorganica, String codDepSigaUorganica, String siglaUorganica, String estadoUorganica,
			Long idActividad, String codigoActividad, String nombreActividad) {
		this.ordenComponente = ordenComponente;
		this.estado = estado;
		this.idModulo = new PghModulo(idModulo, rutaModulo, descripcionModulo, estadoModulo, observacionesModulo);
		this.idUnidadOrganica = new MdiUnidadOrganica(idUnidadOrganica, descripcionUorganica, detalleUorganica, codDepSigaUorganica, siglaUorganica, estadoUorganica);
		this.idActividad = new MdiActividad(codigoActividad, idActividad, nombreActividad);
	}

	public PghOrgaActiModuSecc(Long idOrgaActiModuSecc, Long ordenComponente, Long ordenSeccion, String estado,
			Long idSeccion, String descripcionSeccion, String rutaSeccion, String observacionesSeccion, String estadoSeccion,
			Long idModulo, String rutaModulo, String descripcionModulo, String estadoModulo, String observacionesModulo,
			Long idUnidadOrganica, String descripcionUorganica, String detalleUorganica, String codDepSigaUorganica, String siglaUorganica, String estadoUorganica,
			Long idActividad, String codigoActividad, String nombreActividad) {
		this.idOrgaActiModuSecc = idOrgaActiModuSecc;
		this.ordenComponente = ordenComponente;
		this.ordenSeccion = ordenSeccion;
		this.estado = estado;
		this.idSeccion = new PghSeccion(idSeccion, descripcionSeccion, rutaSeccion, observacionesSeccion, estadoSeccion);
		this.idModulo = new PghModulo(idModulo, rutaModulo, descripcionModulo, estadoModulo, observacionesModulo);
		this.idUnidadOrganica = new MdiUnidadOrganica(idUnidadOrganica, descripcionUorganica, detalleUorganica, codDepSigaUorganica, siglaUorganica, estadoUorganica);
		this.idActividad = new MdiActividad(codigoActividad, idActividad, nombreActividad);
	}

	public Long getIdOrgaActiModuSecc() {
        return idOrgaActiModuSecc;
    }

    public void setIdOrgaActiModuSecc(Long idOrgaActiModuSecc) {
        this.idOrgaActiModuSecc = idOrgaActiModuSecc;
    }

    public Long getOrdenComponente() {
        return ordenComponente;
    }

    public void setOrdenComponente(Long ordenComponente) {
        this.ordenComponente = ordenComponente;
    }

    public Long getOrdenSeccion() {
        return ordenSeccion;
    }

    public void setOrdenSeccion(Long ordenSeccion) {
        this.ordenSeccion = ordenSeccion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghSeccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(PghSeccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    public PghModulo getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(PghModulo idModulo) {
        this.idModulo = idModulo;
    }

    public MdiUnidadOrganica getIdUnidadOrganica() {
        return idUnidadOrganica;
    }

    public void setIdUnidadOrganica(MdiUnidadOrganica idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }

    public MdiActividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(MdiActividad idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrgaActiModuSecc != null ? idOrgaActiModuSecc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghOrgaActiModuSecc)) {
            return false;
        }
        PghOrgaActiModuSecc other = (PghOrgaActiModuSecc) object;
        if ((this.idOrgaActiModuSecc == null && other.idOrgaActiModuSecc != null) || (this.idOrgaActiModuSecc != null && !this.idOrgaActiModuSecc.equals(other.idOrgaActiModuSecc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.siguoweb.domain.PghOrgaActiModuSecc";
    }
}
