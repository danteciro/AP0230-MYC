/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author lchancayauri
 */
public class TipificacionSancionDTO {
    
    private Long idTipiSanc;
    private Long idTipificacion;
    private Long idTipoSancion;
    private String estado;
    private TipoSancionDTO tipoSancion;
    private TipificacionDTO tipificacion;
    private CriterioDTO criterio;
    private MaestroColumnaDTO nivel;
    private String descripcionSancion;
    
    
    public CriterioDTO getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioDTO criterio) {
		this.criterio = criterio;
	}

	public MaestroColumnaDTO getNivel() {
		return nivel;
	}

	public void setNivel(MaestroColumnaDTO nivel) {
		this.nivel = nivel;
	}

	public TipificacionDTO getTipificacion() {
		return tipificacion;
	}

	public void setTipificacion(TipificacionDTO tipificacion) {
		this.tipificacion = tipificacion;
	}

	public TipoSancionDTO getTipoSancion() {
        return tipoSancion;
    }

    public void setTipoSancion(TipoSancionDTO tipoSancion) {
        this.tipoSancion = tipoSancion;
    }

    public Long getIdTipiSanc() {
        return idTipiSanc;
    }

    public void setIdTipiSanc(Long idTipiSanc) {
        this.idTipiSanc = idTipiSanc;
    }

    public Long getIdTipificacion() {
        return idTipificacion;
    }

    public void setIdTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

    public Long getIdTipoSancion() {
        return idTipoSancion;
    }

    public void setIdTipoSancion(Long idTipoSancion) {
        this.idTipoSancion = idTipoSancion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public String getDescripcionSancion() {
		return descripcionSancion;
	}

	public void setDescripcionSancion(String descripcionSancion) {
		this.descripcionSancion = descripcionSancion;
	}
    
}
