package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jsifuentes
 */
public class DetalleNormaTecnicaDTO {
    private Long idDetalleNormaTecnica;
    private Long idDetalleBaseLegal;
    private Long idTipoNormaTecnica;
    private String descripcionIdTipoNormaTecnica;
    private String descripcionNorma;
    private String estado;

	public DetalleNormaTecnicaDTO(){
    }
    
	public DetalleNormaTecnicaDTO(Long idTipoNormaTecnica) {
		this.idTipoNormaTecnica = idTipoNormaTecnica;
	}

	public Long getIdDetalleNormaTecnica() {
		return idDetalleNormaTecnica;
	}

	public void setIdDetalleNormaTecnica(Long idDetalleNormaTecnica) {
		this.idDetalleNormaTecnica = idDetalleNormaTecnica;
	}

	public Long getIdDetalleBaseLegal() {
		return idDetalleBaseLegal;
	}

	public void setIdDetalleBaseLegal(Long idDetalleBaseLegal) {
		this.idDetalleBaseLegal = idDetalleBaseLegal;
	}

	public Long getIdTipoNormaTecnica() {
		return idTipoNormaTecnica;
	}

	public void setIdTipoNormaTecnica(Long idTipoNormaTecnica) {
		this.idTipoNormaTecnica = idTipoNormaTecnica;
	}

	public String getDescripcionNorma() {
		return descripcionNorma;
	}

	public void setDescripcionNorma(String descripcionNorma) {
		this.descripcionNorma = descripcionNorma;
	}
    
    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcionIdTipoNormaTecnica() {
		return descripcionIdTipoNormaTecnica;
	}

	public void setDescripcionIdTipoNormaTecnica(
			String descripcionIdTipoNormaTecnica) {
		this.descripcionIdTipoNormaTecnica = descripcionIdTipoNormaTecnica;
	}
	
}
