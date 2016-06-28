package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class RubroOpcionFilter extends BasePaginatorFilter{
	private Long idRubroOpcion;
    private Long idActividad;
    
    public RubroOpcionFilter(){
    	
    }
    
	public Long getIdRubroOpcion() {
		return idRubroOpcion;
	}
	public void setIdRubroOpcion(Long idRubroOpcion) {
		this.idRubroOpcion = idRubroOpcion;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
    
    
}
