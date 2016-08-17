/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author jpiro
 */
public class ActividadFilter extends BasePaginatorFilter {
    private Long idActividad;
    private Long idProcedimiento;
    private Long idTramite;
    private String estado;
    private Long idTramiteActividad;    
	private Long idRubroOpcion;
	private String idsActividades;
	
	
	/* OSINE_SFS-600 - REQF-0009 - Inicio */
    private Long idActividadPadre;
    private String nombre;
	private Integer orden;
	private Integer ordenPadre;
	private String codigo;
	private String codigoPadre;	
	private boolean flagListarActividadesPadre;
    /* OSINE_SFS-600 - REQF-0009 - Fin */

    public ActividadFilter(){
    }
    public ActividadFilter(Long idProcedimiento,String estado){
        this.idProcedimiento=idProcedimiento;
        this.estado=estado;
    }
    public ActividadFilter(String estado,Long idTramiteActividad){
        this.idTramiteActividad=idTramiteActividad;
        this.estado=estado;
    }
    
    /* OSINE_SFS-600 - REQF-0009 - Inicio */
    public ActividadFilter(boolean flagActividadesPadre){
        this.flagListarActividadesPadre=flagActividadesPadre;
    }
    /* OSINE_SFS-600 - REQF-0009 - Fin */
    
    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }
	public Long getIdTramiteActividad() {
		return idTramiteActividad;
	}
	public void setIdTramiteActividad(Long idTramiteActividad) {
		this.idTramiteActividad = idTramiteActividad;
	}	
    public Long getIdRubroOpcion() {
		return idRubroOpcion;
	}
	public void setIdRubroOpcion(Long idRubroOpcion) {
		this.idRubroOpcion = idRubroOpcion;
	}
	public String getIdsActividades() {
		return idsActividades;
	}
	public void setIdsActividades(String idsActividades) {
		this.idsActividades = idsActividades;
	}
	
	/* OSINE_SFS-600 - REQF-0009 - Inicio */
	public Long getIdActividadPadre() {
		return idActividadPadre;
	}
	public void setIdActividadPadre(Long idActividadPadre) {
		this.idActividadPadre = idActividadPadre;
	}
	
	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	public Integer getOrdenPadre() {
		return ordenPadre;
	}
	public void setOrdenPadre(Integer ordenPadre) {
		this.ordenPadre = ordenPadre;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigoPadre() {
		return codigoPadre;
	}
	
	public void setCodigoPadre(String codigoPadre) {
		this.codigoPadre = codigoPadre;
	}
	
	public boolean isFlagListarActividadesPadre() {
		return flagListarActividadesPadre;
	}
	public void setFlagListarActividadesPadre(boolean flagListarActividadesPadre) {
		this.flagListarActividadesPadre = flagListarActividadesPadre;
	}
	/* OSINE_SFS-600 - REQF-0009 - Fin */
}
