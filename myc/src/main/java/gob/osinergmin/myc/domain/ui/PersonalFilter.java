/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

/**
 *
 * @author jpiro
 */
public class PersonalFilter {
    private Long idPersonal;
    private String nombreUsuarioSiged;
    private String descRol;
    private Long idLocador;
    private Long idSupervisoraEmpresa;
    private String estado;
    private String aplicacion;
    private String flagDefault;

    public PersonalFilter(){}

    public PersonalFilter(Long idPersonal) {
        this.idPersonal = idPersonal;
    }
    
    public PersonalFilter(String nombreUsuarioSiged, String descRol){
        this.nombreUsuarioSiged=nombreUsuarioSiged;        
        this.descRol=descRol;
    }

    public PersonalFilter(Long idLocador, Long idSupervisoraEmpresa) {
        this.idLocador = idLocador;
        this.idSupervisoraEmpresa = idSupervisoraEmpresa;
    }

    public String getFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(String flagDefault) {
        this.flagDefault = flagDefault;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Long idLocador) {
        this.idLocador = idLocador;
    }

    public Long getIdSupervisoraEmpresa() {
        return idSupervisoraEmpresa;
    }

    public void setIdSupervisoraEmpresa(Long idSupervisoraEmpresa) {
        this.idSupervisoraEmpresa = idSupervisoraEmpresa;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombreUsuarioSiged() {
        return nombreUsuarioSiged;
    }

    public void setNombreUsuarioSiged(String nombreUsuarioSiged) {
        this.nombreUsuarioSiged = nombreUsuarioSiged;
    }

    public String getDescRol() {
        return descRol;
    }

    public void setDescRol(String descRol) {
        this.descRol = descRol;
    }

}
