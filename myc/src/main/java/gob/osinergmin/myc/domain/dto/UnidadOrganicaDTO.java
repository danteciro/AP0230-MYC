package gob.osinergmin.myc.domain.dto;
/**
 *
 * @author mdiosesf
 */
public class UnidadOrganicaDTO {
    private Long idUnidadOrganica;
    private Long idUnidadOrganicaSuperior;
    private String descripcion;
    private String estado;
    private String codDepSiga;
    private Long sede;
    private String sigla;  
    private String detalle;   
    private Long idPersonal;
    private String descripcionDivision;   
    private Long identificadorEntidad;
    private Long nivel;
    private MaestroColumnaDTO nombreNivel;
	
	public UnidadOrganicaDTO() {
    }

    public UnidadOrganicaDTO(Long idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }
	
    public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

	public Long getIdentificadorEntidad() {
        return identificadorEntidad;
    }

    public void setIdentificadorEntidad(Long identificadorEntidad) {
        this.identificadorEntidad = identificadorEntidad;
    }

    public String getCodDepSiga() {
        return codDepSiga;
    }

    public void setCodDepSiga(String codDepSiga) {
    	if(codDepSiga!=null)
    		codDepSiga = codDepSiga.toUpperCase();
        this.codDepSiga = codDepSiga;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
    	if(sigla!=null)
    		sigla = sigla.toUpperCase();
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
    	if(descripcion!=null)
    		descripcion = descripcion.toUpperCase();
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public Long getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Long idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getDescripcionDivision() {
		return descripcionDivision;
	}

	public void setDescripcionDivision(String descripcionDivision) {
		this.descripcionDivision = descripcionDivision;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		if(detalle!=null)
			detalle = detalle.toUpperCase();
		this.detalle = detalle;
	}

	public MaestroColumnaDTO getNombreNivel() {
		return nombreNivel;
	}

	public void setNombreNivel(MaestroColumnaDTO nombreNivel) {
		this.nombreNivel = nombreNivel;
	}

	public Long getSede() {
		return sede;
	}

	public void setSede(Long sede) {
		this.sede = sede;
	}    
}
