/**
* Resumen           
* Objeto            : PghNormaAgentePrioridad.java
* Descripción       : Clase Domain prioridad norma agente en el MYC.
* Fecha de Creación : 04/07/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Mario Dioses Fernandez.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.domain;
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
@Table(name = "PGH_NORMA_AGENTE_PRIORIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PghNormaAgentePrioridad.findAll", query = "SELECT p FROM PghNormaAgentePrioridad p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghNormaAgentePrioridad.countAll", query = "SELECT count(p.idNormaAgentePrioridad) FROM PghNormaAgentePrioridad p WHERE p.estado = :estado"),
    @NamedQuery(name = "PghNormaAgentePrioridad.findByIdOrden", query = "SELECT p FROM PghNormaAgentePrioridad p LEFT JOIN p.idAgente ac WHERE p.estado = :estado AND ac.idActividad = :idActividad AND p.orden = :orden"),
    @NamedQuery(name = "PghNormaAgentePrioridad.countByIdOrden", query = "SELECT count(p.idNormaAgentePrioridad) FROM PghNormaAgentePrioridad p LEFT JOIN p.idAgente ac WHERE p.estado = :estado AND ac.idActividad = :idActividad AND p.orden = :orden"),
    @NamedQuery(name = "PghNormaAgentePrioridad.findByIdActividad", 
    		query = "SELECT distinct new PghNormaAgentePrioridad (p.idNormaAgentePrioridad, p.orden, bl.idBaseLegal, bl.codigoBaseLegal, bl.descripcion, bl.estado, ac.idActividad, ac.nombre) "
    		+ "FROM PghNormaAgentePrioridad p LEFT JOIN p.idBaseLegal bl LEFT JOIN p.idAgente ac WHERE ac.idActividad = :idActividad AND p.estado = :estado"),
    @NamedQuery(name = "PghNormaAgentePrioridad.countByIdActividad", 
			query = "SELECT count(p.idNormaAgentePrioridad) "
					+ "FROM PghNormaAgentePrioridad p LEFT JOIN p.idBaseLegal bl LEFT JOIN p.idAgente ac WHERE ac.idActividad = :idActividad AND p.estado = :estado"),
	@NamedQuery(name = "PghNormaAgentePrioridad.findByIdBaseLegal", 
			query = "SELECT distinct new PghNormaAgentePrioridad (p.idNormaAgentePrioridad, p.orden, bl.idBaseLegal, bl.codigoBaseLegal, bl.descripcion, bl.estado, ac.idActividad, ac.nombre) "
			+ "FROM PghNormaAgentePrioridad p LEFT JOIN p.idBaseLegal bl LEFT JOIN p.idAgente ac WHERE bl.idBaseLegal = :idBaseLegal AND p.estado = :estado"),
	@NamedQuery(name = "PghNormaAgentePrioridad.countByIdBaseLegal", 
			query = "SELECT count(p.idNormaAgentePrioridad) "
			+ "FROM PghNormaAgentePrioridad p LEFT JOIN p.idBaseLegal bl LEFT JOIN p.idAgente ac WHERE bl.idBaseLegal = :idBaseLegal AND p.estado = :estado"),
	@NamedQuery(name = "PghNormaAgentePrioridad.countByIdNormaAgentePrioridad", query = "SELECT count(p.idNormaAgentePrioridad) FROM PghNormaAgentePrioridad p WHERE p.idNormaAgentePrioridad = :idNormaAgentePrioridad AND p.estado = :estado"),
    @NamedQuery(name = "PghNormaAgentePrioridad.findByIdNormaAgentePrioridad", query = "SELECT p FROM PghNormaAgentePrioridad p WHERE p.idNormaAgentePrioridad = :idNormaAgentePrioridad AND p.estado = :estado")})
public class PghNormaAgentePrioridad extends Auditoria {
    private static final long serialVersionUID = 1L;   
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PGH_NORM_AGENTE_PRIORIDAD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    @Column(name = "ID_NORMA_AGENTE_PRIORIDAD")
    private Long idNormaAgentePrioridad;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)    
    @Column(name = "ORDEN")
    private Long orden;
    @JoinColumn(name = "ID_BASE_LEGAL", referencedColumnName = "ID_BASE_LEGAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghBaseLegal idBaseLegal;
    @JoinColumn(name = "ID_AGENTE", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdiActividad idAgente;

    public PghNormaAgentePrioridad() {}

    public PghNormaAgentePrioridad(Long idNormaAgentePrioridad) {
        this.idNormaAgentePrioridad = idNormaAgentePrioridad;
    }

    public PghNormaAgentePrioridad(Long idNormaAgentePrioridad, Long orden, Long idBaseLegal, String codigoBaseLegal, String descripcionBaseLegal, String estadoBaseLegal, Long idActividad, String nombreActividad) {
        this.idNormaAgentePrioridad = idNormaAgentePrioridad;
        this.orden = orden;
        this.idBaseLegal = new PghBaseLegal(idBaseLegal, codigoBaseLegal, descripcionBaseLegal, estadoBaseLegal);
        this.idAgente = new MdiActividad(idActividad, nombreActividad);
    }
    
    public PghNormaAgentePrioridad(Long idNormaAgentePrioridad, Long orden, Long idBaseLegal, Long idActividad) {
        this.idNormaAgentePrioridad = idNormaAgentePrioridad;
        this.orden = orden;
        this.idBaseLegal = new PghBaseLegal(idBaseLegal);
        this.idAgente = new MdiActividad(idActividad);
    }

    public Long getIdNormaAgentePrioridad() {
        return idNormaAgentePrioridad;
    }

    public void setIdNormaAgentePrioridad(Long idNormaAgentePrioridad) {
        this.idNormaAgentePrioridad = idNormaAgentePrioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public PghBaseLegal getIdBaseLegal() {
        return idBaseLegal;
    }

    public void setIdBaseLegal(PghBaseLegal idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }

    public MdiActividad getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(MdiActividad idAgente) {
        this.idAgente = idAgente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNormaAgentePrioridad != null ? idNormaAgentePrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PghNormaAgentePrioridad)) {
            return false;
        }
        PghNormaAgentePrioridad other = (PghNormaAgentePrioridad) object;
        if ((this.idNormaAgentePrioridad == null && other.idNormaAgentePrioridad != null) || (this.idNormaAgentePrioridad != null && !this.idNormaAgentePrioridad.equals(other.idNormaAgentePrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.osinergmin.myc.domain.PghNormaAgentePrioridad";
    }
}
