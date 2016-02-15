package gob.osinergmin.myc.domain.dto;

import java.util.List;

public class ProcesoObligacionTipoDTO {
	
	private ActividadDTO actividad;
	private ProcesoDTO proceso;
	private ObligacionTipoDTO obligacionTipo;
	private Long idProceso;
	private Long idObligacionTipo;
	private Long idProOblTip;
	private String estado;
	private Long idActividad;
	private String nombreActividad;
	private Long idActvidadPadre;
	
    List<ActividadDTO> actividades;
    
    public ProcesoObligacionTipoDTO(){
    	
    }
	public ProcesoObligacionTipoDTO(Long idProOblTip,Long idObligacionTipo,Long idProceso,Long idActividad,String estado){
		this.idProOblTip = idProOblTip;
		this.actividad=new ActividadDTO(idActividad);
		this.idObligacionTipo = idObligacionTipo;
		this.idProceso = idProceso;
		this.estado = estado;
	}
    
	public ActividadDTO getActividad() {
		return actividad;
	}
	public void setActividad(ActividadDTO actividad) {
		this.actividad = actividad;
	}
	public ProcesoDTO getProceso() {
		return proceso;
	}
	public void setProceso(ProcesoDTO proceso) {
		this.proceso = proceso;
	}
	public ObligacionTipoDTO getObligacionTipo() {
		return obligacionTipo;
	}
	public void setObligacionTipo(ObligacionTipoDTO obligacionTipo) {
		this.obligacionTipo = obligacionTipo;
	}
	public Long getIdProOblTip() {
		return idProOblTip;
	}
	public void setIdProOblTip(Long idProOblTip) {
		this.idProOblTip = idProOblTip;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<ActividadDTO> getActividades() {
		return actividades;
	}
	public void setActividades(List<ActividadDTO> actividades) {
		this.actividades = actividades;
	}
	public Long getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}
	public Long getIdObligacionTipo() {
		return idObligacionTipo;
	}
	public void setIdObligacionTipo(Long idObligacionTipo) {
		this.idObligacionTipo = idObligacionTipo;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public Long getIdActvidadPadre() {
		return idActvidadPadre;
	}
	public void setIdActvidadPadre(Long idActvidadPadre) {
		this.idActvidadPadre = idActvidadPadre;
	}
		

}
