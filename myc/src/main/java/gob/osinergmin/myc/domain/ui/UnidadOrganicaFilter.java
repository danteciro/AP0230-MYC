package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;

/**
 *
 * @author mdiosesf
 */
public class UnidadOrganicaFilter {
    private Long idUnidadOrganica;
    private Long idUnidadOrganicaSuperior;
    private String descripcion;
    private String detalle;
    private String estado;
    private String codDepSiga;
    private String sigla;
    private Long nivel;
    private MaestroColumnaDTO nombreNivel;

    public UnidadOrganicaFilter(){}
    
    public UnidadOrganicaFilter(String codDepSiga,String sigla){
        this.codDepSiga=codDepSiga;
        this.sigla=sigla;
    }

    public UnidadOrganicaFilter(Long idUnidadOrganica, Long idUnidadOrganicaSuperior, Long nivel) {
        this.idUnidadOrganica = idUnidadOrganica;
        this.idUnidadOrganicaSuperior = idUnidadOrganicaSuperior;
        this.nivel = nivel;
    }
    
    public String getCodDepSiga() {
        return codDepSiga;
    }

    public void setCodDepSiga(String codDepSiga) {
        this.codDepSiga = codDepSiga;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public Long getIdUnidadOrganica() {
        return idUnidadOrganica;
    }

    public void setIdUnidadOrganica(Long idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }

    public Long getIdUnidadOrganicaSuperior() {
        return idUnidadOrganicaSuperior;
    }

    public void setIdUnidadOrganicaSuperior(Long idUnidadOrganicaSuperior) {
        this.idUnidadOrganicaSuperior = idUnidadOrganicaSuperior;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public MaestroColumnaDTO getNombreNivel() {
		return nombreNivel;
	}

	public void setNombreNivel(MaestroColumnaDTO nombreNivel) {
		this.nombreNivel = nombreNivel;
	}    
}
