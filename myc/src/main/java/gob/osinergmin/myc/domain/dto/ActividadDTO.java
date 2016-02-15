package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author gvillanueva
 */
public class ActividadDTO {
    private Long idActividad;
    private Long idActividadPadre;
    private String descripcionActividad;//verificar en BD dice nombre XD
    private String nombre;
    private String codigo;
    private Integer nivel;
    private String activo;
    private String esMayor;

    public ActividadDTO(){
    }
    
    public ActividadDTO(Long idActividad){
    	this.idActividad=idActividad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Long getIdActividadPadre() {
        return idActividadPadre;
    }

    public void setIdActividadPadre(Long idActividadPadre) {
        this.idActividadPadre = idActividadPadre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEsMayor() {
        return esMayor;
    }

    public void setEsMayor(String esMayor) {
        this.esMayor = esMayor;
    }
    
    
   
    
}
