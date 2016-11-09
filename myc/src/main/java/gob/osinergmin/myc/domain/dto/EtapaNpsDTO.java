package gob.osinergmin.myc.domain.dto;


public class EtapaNpsDTO {
	 	private Long idEtapa;
	    private ProcesoDTO idProceso;
	    private String descripcion;
	    private String estado;
	    private Long plazo;
	   
	    
		public Long getIdEtapa() {
			return idEtapa;
		}
		public void setIdEtapa(Long idEtapa) {
			this.idEtapa = idEtapa;
		}
	
		public ProcesoDTO getIdProceso() {
			return idProceso;
		}
		public void setIdProceso(ProcesoDTO idProceso) {
			this.idProceso = idProceso;
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
		public Long getPlazo() {
			return plazo;
		}
		public void setPlazo(Long plazo) {
			this.plazo = plazo;
		}
	
	    
	    
	    
}
