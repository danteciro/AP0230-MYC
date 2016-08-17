package gob.osinergmin.myc.domain.dto;

public class RolDTO {
	private Long idRol;
	private String nombreRol;
        private String identificadorRol;
	private String estado;
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

    public String getIdentificadorRol() {
        return identificadorRol;
    }

    public void setIdentificadorRol(String identificadorRol) {
        this.identificadorRol = identificadorRol;
    }
    
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}