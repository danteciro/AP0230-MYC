package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jsifuentes
 */
public class OpcionDTO {
    private Long idOpcion;
    private String nombre;
    private Long idOpcionPadre;
    private String identificador_opcion;

    public OpcionDTO(){
    }
    
    public OpcionDTO(Long idOpcion){
    	this.idOpcion=idOpcion;
    }
    
	public Long getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Long idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdOpcionPadre() {
		return idOpcionPadre;
	}

	public void setIdOpcionPadre(Long idOpcionPadre) {
		this.idOpcionPadre = idOpcionPadre;
	}

	public String getIdentificador_opcion() {
		return identificador_opcion;
	}

	public void setIdentificador_opcion(String identificador_opcion) {
		this.identificador_opcion = identificador_opcion;
	}

	
}
