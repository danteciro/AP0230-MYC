/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

import java.util.List;

/**
 *
 * @author lbarboza
 */
public class DetalleCriterioDTO {
    private Long idDetalleCriterio;
    private String sancionEspecifica;
    private Long idCriterio;
    private Long tipoSancionEspecifica;
    private String estado;
    private String codTrazabilidad;
    private String sancionMonetaria;
    List<TipificacionSancionDTO> TipificacionSancion;
    private Long nivel;
    private String descTipoSancionEspecifica;
    private String concatIdTipoSancion;

    public String getConcatIdTipoSancion() {
        return concatIdTipoSancion;
    }

    public void setConcatIdTipoSancion(String concatIdTipoSancion) {
        this.concatIdTipoSancion = concatIdTipoSancion;
    }

    public String getDescTipoSancionEspecifica() {
        return descTipoSancionEspecifica;
    }

    public void setDescTipoSancionEspecifica(String descTipoSancionEspecifica) {
        this.descTipoSancionEspecifica = descTipoSancionEspecifica;
    }
    
    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public List<TipificacionSancionDTO> getTipificacionSancion() {
        return TipificacionSancion;
    }

    public void setTipificacionSancion(List<TipificacionSancionDTO> TipificacionSancion) {
        this.TipificacionSancion = TipificacionSancion;
    }

    public String getSancionMonetaria() {
        return sancionMonetaria;
    }

    public void setSancionMonetaria(String sancionMonetaria) {
        this.sancionMonetaria = sancionMonetaria;
    }
    
    public Long getTipoSancionEspecifica() {
        return tipoSancionEspecifica;
    }

    public void setTipoSancionEspecifica(Long tipoSancionEspecifica) {
        this.tipoSancionEspecifica = tipoSancionEspecifica;
    }

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }
    
    public Long getIdDetalleCriterio() {
        return idDetalleCriterio;
    }

    public void setIdDetalleCriterio(Long idDetalleCriterio) {
        this.idDetalleCriterio = idDetalleCriterio;
    }

    public String getSancionEspecifica() {
        return sancionEspecifica;
    }

    public void setSancionEspecifica(String sancionEspecifica) {
        this.sancionEspecifica = sancionEspecifica;
    }

    public Long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Long idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}