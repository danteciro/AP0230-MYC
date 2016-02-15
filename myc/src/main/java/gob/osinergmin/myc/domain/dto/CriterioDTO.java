package gob.osinergmin.myc.domain.dto;

import java.util.List;

import gob.osinergmin.myc.domain.PghTipificacion;

/**
 *
 * @author lbarboza
 */
public class CriterioDTO {
    
    /** Codigo del criterio**/
    private Long idCriterio;
    /** Descripcion del criterio**/
    private String descripcion;
    /** Id de la tipificacion asociada**/
    private Long idTipificacion;
    /** código de la Obligacion**/
    private Long idObligacion;
    
    private String sancionMonetaria;
    
    private String estado;
    private String codigoTipificacion;
    private MaestroColumnaDTO tipoCriterio;    
    private String descripcionTipificacion;
    private TipificacionSancionDTO tipiSancion;
    private List<TipificacionSancionDTO> listaTipificacionSancion;
    private String tieneSancion;
// 05-11-2015
    private String basesLegales;
//
    public String getSancionMonetaria() {
		return sancionMonetaria;
	}

	public void setSancionMonetaria(String sancionMonetaria) {
		this.sancionMonetaria = sancionMonetaria;
	}

	public List<TipificacionSancionDTO> getListaTipificacionSancion() {
		return listaTipificacionSancion;
	}

	public void setListaTipificacionSancion(
			List<TipificacionSancionDTO> listaTipificacionSancion) {
		this.listaTipificacionSancion = listaTipificacionSancion;
	}

	public TipificacionSancionDTO getTipiSancion() {
		return tipiSancion;
	}

	public void setTipiSancion(TipificacionSancionDTO tipiSancion) {
		this.tipiSancion = tipiSancion;
	}

	private String codTrazabilidad;

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }

    public Long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Long idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdTipificacion() {
        return idTipificacion;
    }

    public void setIdTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

    public Long getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Long idObligacion) {
        this.idObligacion = idObligacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoTipificacion() {
        return codigoTipificacion;
    }

    public void setCodigoTipificacion(String codigoTipificacion) {
        this.codigoTipificacion = codigoTipificacion;
    }

	public MaestroColumnaDTO getTipoCriterio() {
		return tipoCriterio;
	}

	public void setTipoCriterio(MaestroColumnaDTO tipoCriterio) {
		this.tipoCriterio = tipoCriterio;
	}



	public String getDescripcionTipificacion() {
		return descripcionTipificacion;
	}

	public void setDescripcionTipificacion(String descripcionTipificacion) {
		this.descripcionTipificacion = descripcionTipificacion;
	}

	public String getTieneSancion() {
		return tieneSancion;
	}

	public void setTieneSancion(String tieneSancion) {
		this.tieneSancion = tieneSancion;
	}

	public String getBasesLegales() {
		return basesLegales;
	}

	public void setBasesLegales(String basesLegales) {
		this.basesLegales = basesLegales;
	}
    
}