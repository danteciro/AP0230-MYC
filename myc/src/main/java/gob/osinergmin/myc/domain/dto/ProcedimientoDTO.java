/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.service.dao.impl.ProcedimientoDAOImpl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpiro
 */
public class ProcedimientoDTO {
    private Long idProcedimiento;
    private String item;
    private String denominacion;
    private String baseLegal;
    private Float derechoTramitacion;
    private Long idValorUit;
    private Long idCalificacion;
    private Long idSilencioAdministrativo;
    private Integer plazoResolver;
    private Long idInicioProcedimiento;
    private Long idAutoridadCompetente;
    private Long idReconsideracion;
    private Long idApelacion;
    private Long idAnexoRrh;
    private String notaProcedimiento;
    
    private Long idProceso;
    private Long idEtapa;
    private String proceso;
    private Long tieneAct;
    private String estado;
    List<TramiteDTO> tramites;
    List<ActividadDTO> actividades;
    private String descTramite;
    private String descActividad;
    
    private List<CnfRequProcedimientoDTO> requProcedimiento;
    
    List<ProcedimientoTramiteDTO> procTramites;

    public ProcedimientoDTO(){
    }
    
    public ProcedimientoDTO(Long idProcedimiento){
        this.idProcedimiento=idProcedimiento;
    }

    public String getDescTramite() {
        return descTramite;
    }

    public void setDescTramite(String descTramite) {
        this.descTramite = descTramite;
    }

    public String getDescActividad() {
        return descActividad;
    }

    public void setDescActividad(String descActividad) {
        this.descActividad = descActividad;
    }

    public List<ProcedimientoTramiteDTO> getProcTramites() {
        return procTramites;
    }

    public void setProcTramites(List<ProcedimientoTramiteDTO> procTramites) {
        this.procTramites = procTramites;
    }
    
    public List<CnfRequProcedimientoDTO> getRequProcedimiento() {
        return requProcedimiento;
    }

    public void setRequProcedimiento(List<CnfRequProcedimientoDTO> requProcedimiento) {
        this.requProcedimiento = requProcedimiento;
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    public Long getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }

    public List<TramiteDTO> getTramites() {
        return tramites;
    }

    public void setTramites(List<TramiteDTO> tramites) {
        this.tramites = tramites;
    }

    public String getNotaProcedimiento() {
        return notaProcedimiento;
    }

    public void setNotaProcedimiento(String notaProcedimiento) {
        this.notaProcedimiento = notaProcedimiento;
    }

    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        if(denominacion!=null){
            this.denominacion = denominacion.toUpperCase();
        }else{
            this.denominacion = denominacion;
        }
    }

    public String getBaseLegal() {
        return baseLegal;
    }

    public void setBaseLegal(String baseLegal) {
        this.baseLegal = baseLegal;
    }

    public Float getDerechoTramitacion() {
        return derechoTramitacion;
    }

    public void setDerechoTramitacion(Float derechoTramitacion) {
        this.derechoTramitacion = derechoTramitacion;
    }

    public Long getIdValorUit() {
        return idValorUit;
    }

    public void setIdValorUit(Long idValorUit) {
        this.idValorUit = idValorUit;
    }

    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Long getIdSilencioAdministrativo() {
        return idSilencioAdministrativo;
    }

    public void setIdSilencioAdministrativo(Long idSilencioAdministrativo) {
        this.idSilencioAdministrativo = idSilencioAdministrativo;
    }

    public Integer getPlazoResolver() {
        return plazoResolver;
    }

    public void setPlazoResolver(Integer plazoResolver) {
        this.plazoResolver = plazoResolver;
    }

    public Long getIdInicioProcedimiento() {
        return idInicioProcedimiento;
    }

    public void setIdInicioProcedimiento(Long idInicioProcedimiento) {
        this.idInicioProcedimiento = idInicioProcedimiento;
    }

    public Long getIdAutoridadCompetente() {
        return idAutoridadCompetente;
    }

    public void setIdAutoridadCompetente(Long idAutoridadCompetente) {
        this.idAutoridadCompetente = idAutoridadCompetente;
    }

    public Long getIdReconsideracion() {
        return idReconsideracion;
    }

    public void setIdReconsideracion(Long idReconsideracion) {
        this.idReconsideracion = idReconsideracion;
    }

    public Long getIdApelacion() {
        return idApelacion;
    }

    public void setIdApelacion(Long idApelacion) {
        this.idApelacion = idApelacion;
    }

    public Long getIdAnexoRrh() {
        return idAnexoRrh;
    }

    public void setIdAnexoRrh(Long idAnexoRrh) {
        this.idAnexoRrh = idAnexoRrh;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public Long getTieneAct() {
        return tieneAct;
    }

    public void setTieneAct(Long tieneAct) {
        this.tieneAct = tieneAct;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}