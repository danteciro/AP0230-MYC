package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.domain.PghTipificacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbarboza
 */
public class TipificacionDTO {
    
    /** Codigo de la tipificacion**/
    private Long idTipificacion;
    private String codTipificacion;
    /** Tipificacion**/
//    private String tipificacion;
    /** Descripcion de la tipificacion**/
    private String descripcion;
    /** Sancion monetaria - Hasta**/
    private String sancionMonetaria;
    private String basesLegales;
    private Long idTipificacionPadre;
    private String descTipiPadre;
    private Long idTipoMoneda;
    private Long claseSancion;
    private String descClaseSancion;
    /** Listado de otras sanciones**/
//    private HashNMap otrasSanciones;
    /** código de la Obligacion**/
//    private String codigoObligacion;
    /**/
    private String activo;
    private String seleccionado;
    
	private String sancionEspecifica;
	private List<TipificacionSancionDTO> TipificacionSancion;
    
    List<TipificacionSancionDTO> listaTipificacionSancion = new ArrayList<TipificacionSancionDTO>();
    
    private String tieneSanc;

    public String getDescTipiPadre() {
        return descTipiPadre;
    }

    public void setDescTipiPadre(String descTipiPadre) {
        this.descTipiPadre = descTipiPadre;
    }

    public String getDescClaseSancion() {
        return descClaseSancion;
    }

    public void setDescClaseSancion(String descClaseSancion) {
        this.descClaseSancion = descClaseSancion;
    }

    public String getTieneSanc() {
        return tieneSanc;
    }

    public void setTieneSanc(String tieneSanc) {
        this.tieneSanc = tieneSanc;
    }
    
    public Long getIdTipificacion() {
        return idTipificacion;
    }

    public void setIdTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

//    public String getTipificacion() {
//        return tipificacion;
//    }
//
//    public void setTipificacion(String tipificacion) {
//        this.tipificacion = tipificacion;
//    }

//    public String getDescripcionTipificacion() {
//        return descripcionTipificacion;
//    }
//
//    public void setDescripcionTipificacion(String descripcionTipificacion) {
//        this.descripcionTipificacion = descripcionTipificacion;
//    }

    public String getSancionMonetaria() {
        return sancionMonetaria;
    }

    public void setSancionMonetaria(String sancionMonetaria) {
        this.sancionMonetaria = sancionMonetaria;
    }

//    public HashNMap getOtrasSanciones() {
//        return otrasSanciones;
//    }
//
//    public void setOtrasSanciones(HashNMap otrasSanciones) {
//        this.otrasSanciones = otrasSanciones;
//    }

//    public String getCodigoObligacion() {
//        return codigoObligacion;
//    }
//
//    public void setCodigoObligacion(String codigoObligacion) {
//        this.codigoObligacion = codigoObligacion;
//    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    public List<TipificacionSancionDTO> getListaTipificacionSancion() {
        return listaTipificacionSancion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodTipificacion() {
        return codTipificacion;
    }

    public void setCodTipificacion(String codTipificacion) {
        this.codTipificacion = codTipificacion;
    }

    public String getBasesLegales() {
        return basesLegales;
    }

    public void setBasesLegales(String basesLegales) {
        this.basesLegales = basesLegales;
    }

    public Long getIdTipificacionPadre() {
        return idTipificacionPadre;
    }

    public Long getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public void setIdTipoMoneda(Long idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }
    
    public void setIdTipificacionPadre(Long idTipificacionPadre) {
        this.idTipificacionPadre = idTipificacionPadre;
    }

    public void setListaTipificacionSancion(List<TipificacionSancionDTO> listaTipificacionSancion) {
        this.listaTipificacionSancion = listaTipificacionSancion;
    }

    public String getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(String seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Long getClaseSancion() {
        return claseSancion;
    }

    public void setClaseSancion(Long claseSancion) {
        this.claseSancion = claseSancion;
    }

	public String getSancionEspecifica() {
		return sancionEspecifica;
	}

	public void setSancionEspecifica(String sancionEspecifica) {
		this.sancionEspecifica = sancionEspecifica;
	}

	public List<TipificacionSancionDTO> getTipificacionSancion() {
		return TipificacionSancion;
	}

	public void setTipificacionSancion(List<TipificacionSancionDTO> tipificacionSancion) {
		TipificacionSancion = tipificacionSancion;
	}
    
}