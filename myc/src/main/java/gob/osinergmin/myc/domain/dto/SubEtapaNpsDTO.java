package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.domain.NpsEtapa;


public class SubEtapaNpsDTO {
		private Long idSubetapa;
	    private String descripcion;
	    private String estado;
	    private Long tiempoDias;
	    private EtapaNpsDTO idEtapa;
	    private MaestroColumnaDTO idResponsable;
	    
	    public Long getIdSubetapa() {
			return idSubetapa;
		}
		public void setIdSubetapa(Long idSubetapa) {
			this.idSubetapa = idSubetapa;
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
		public Long getTiempoDias() {
			return tiempoDias;
		}
		public void setTiempoDias(Long tiempoDias) {
			this.tiempoDias = tiempoDias;
		}
		
		public EtapaNpsDTO getIdEtapa() {
			return idEtapa;
		}
		public void setIdEtapa(EtapaNpsDTO idEtapa) {
			this.idEtapa = idEtapa;
		}
		public MaestroColumnaDTO getIdResponsable() {
			return idResponsable;
		}
		public void setIdResponsable(MaestroColumnaDTO idResponsable) {
			this.idResponsable = idResponsable;
		}
		
		
		
}
