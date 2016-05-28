package gob.osinergmin.myc.domain.dto;

public class ObligacionBaseLegalDTO {
	private Long idObligacion;
	private Long idBaseLegal;
        private String estado;
        private Long idOblBase;
        private String codigoObligacion;
        private String descripcion;
        private String codigoBaseLegal;
        private Long idDocumentoAdjunto;
     
        private String codTrazabilidad;

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }
        
	public String getCodigoBaseLegal() {
			return codigoBaseLegal;
		}
		public void setCodigoBaseLegal(String codigoBaseLegal) {
			this.codigoBaseLegal = codigoBaseLegal;
		}
	public Long getIdObligacion() {
		return idObligacion;
	}
	public void setIdObligacion(Long idObligacion) {
		this.idObligacion = idObligacion;
	}
	public Long getIdBaseLegal() {
		return idBaseLegal;
	}
	public void setIdBaseLegal(Long idBaseLegal) {
		this.idBaseLegal = idBaseLegal;
	}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdOblBase() {
        return idOblBase;
    }

    public void setIdOblBase(Long idOblBase) {
        this.idOblBase = idOblBase;
    }
	public String getCodigoObligacion() {
		return codigoObligacion;
	}
	public void setCodigoObligacion(String codigoObligacion) {
		this.codigoObligacion = codigoObligacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    public Long getIdDocumentoAdjunto() {
        return idDocumentoAdjunto;
    }

    public void setIdDocumentoAdjunto(Long idDocumentoAdjunto) {
        this.idDocumentoAdjunto = idDocumentoAdjunto;
    }
    
}