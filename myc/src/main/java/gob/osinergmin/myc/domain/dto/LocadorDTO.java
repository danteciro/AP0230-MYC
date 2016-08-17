package gob.osinergmin.myc.domain.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author pmoralesg
 */
public class LocadorDTO extends Control implements Comparable {

//    private Long idGerencia;
    private Long idLocador;
    private MaestroColumnaDTO idTipoDocumento;
    private String numeroDocumento;
    private String ruc;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreCompleto;
    private Long sexo;
    private Date fechaNacimiento;
    private String fechaNacimientoString;//TODO por quitar
    private Long tipoSangre;
    private Long estadoCivil;
    private String hijos;
    private Integer numeroHijos;
    private Long idNacionalidad;
    private String telefonoContacto;
    private String telefonoPersonal;
     
    private String correoElectronicoPersonal;
    private String correoElectronicoInstitucion;
    private Long idProfesion;
     private String origenInformacion;
//    private String primerNombreContacto;
//    private String segundoNombreContacto;
//    private String apellidoPaternoContacto;
//    private String apellidoMaternoContacto;
  
    private String observaciones;
    private String estado;
//    private DireccionLocadorDTO direccionVivienda;
//    private DireccionLocadorDTO direccionOficina;
//    private FotoLocadorDTO fotoLocador;
//    private List<InstAcadLocadorDTO> instAcadLocadorList;
//    private List<LocadorCompetenciaDTO> locadorCompetenciaList;
//    private List<LocadorDestaqueDTO> locadorDestaqueList;

    
    private Long idColegioProfesional;
    private String numeroColegiatura;
    private Date fechaInicioVigencia;
    private Date fechaFinVigencia;
    private String alergiaLocador;
    private String restriccionMedica;
    
    private String categoriaContratoVigente;
    private String areaDestaqueVigente;
    private String nombreCompletoArmado;
    private Long idUnidadOrganica; 
    private String flagVisualizar;
    
    public LocadorDTO() {
    }

    public LocadorDTO(Long idLocador) {
        this.idLocador = idLocador;
    }
    
    public String getFlagVisualizar() {
        return flagVisualizar;
    }

    public void setFlagVisualizar(String flagVisualizar) {    
        this.flagVisualizar = flagVisualizar;
    }

    public Long getIdUnidadOrganica() {
        return idUnidadOrganica;
    }

    public void setIdUnidadOrganica(Long idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }
    
    public String getNombreCompletoArmado() {
        return nombreCompletoArmado;
    }

    public void setNombreCompletoArmado(String nombreCompletoArmado) {
        this.nombreCompletoArmado = nombreCompletoArmado;
    }
    
    public String getAreaDestaqueVigente() {
        return areaDestaqueVigente;
    }

    public void setAreaDestaqueVigente(String areaDestaqueVigente) {
        this.areaDestaqueVigente = areaDestaqueVigente;
    }
    
    public String getCategoriaContratoVigente() {
        return categoriaContratoVigente;
    }

    public void setCategoriaContratoVigente(String categoriaContratoVigente) {
        this.categoriaContratoVigente = categoriaContratoVigente;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        if(nombreCompleto!=null){
            this.nombreCompleto = nombreCompleto.toUpperCase();
        }else{
            this.nombreCompleto = nombreCompleto;
        }
    }

    public String getCorreoElectronicoInstitucion() {
        return correoElectronicoInstitucion;
    }

    public void setCorreoElectronicoInstitucion(String correoElectronicoInstitucion) {
        if(correoElectronicoInstitucion!=null){
            this.correoElectronicoInstitucion = correoElectronicoInstitucion.toUpperCase();
        }else{
            this.correoElectronicoInstitucion = correoElectronicoInstitucion;
        }
    }

      public MaestroColumnaDTO getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(MaestroColumnaDTO idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        if(numeroDocumento!=null){
            this.numeroDocumento = numeroDocumento.toUpperCase();
        }else{
            this.numeroDocumento = numeroDocumento;
        }
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        if(primerNombre!=null){
            this.primerNombre = primerNombre.toUpperCase();
        }else{
            this.primerNombre = primerNombre;
        }
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        if(segundoNombre!=null){
            this.segundoNombre = segundoNombre.toUpperCase();
        }else{
            this.segundoNombre = segundoNombre;
        }
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        if(apellidoPaterno!=null){
            this.apellidoPaterno = apellidoPaterno.toUpperCase();
        }else{
            this.apellidoPaterno = apellidoPaterno;
        }
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        if(apellidoMaterno!=null){
            this.apellidoMaterno = apellidoMaterno.toUpperCase();
        }else{
            this.apellidoMaterno = apellidoMaterno;
        }
    }

    public Long getSexo() {
        return sexo;
    }

    public void setSexo(Long sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(Long tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Long getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Long estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getHijos() {
        return hijos;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

    public Integer getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(Integer numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        if(correoElectronicoPersonal!=null){
            this.correoElectronicoPersonal = correoElectronicoPersonal.toUpperCase();
        }else{
            this.correoElectronicoPersonal = correoElectronicoPersonal;
        }
    }

    public Long getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Long idProfesion) {
        this.idProfesion = idProfesion;
    }

   

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdColegioProfesional() {
        return idColegioProfesional;
    }

    public void setIdColegioProfesional(Long idColegioProfesional) {
        this.idColegioProfesional = idColegioProfesional;
    }

    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(String numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

 

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }


    public String getAlergiaLocador() {
        return alergiaLocador;
    }

    public void setAlergiaLocador(String alergiaLocador) {
        if(alergiaLocador!=null){
            this.alergiaLocador = alergiaLocador.toUpperCase();
        }else{
            this.alergiaLocador = alergiaLocador;
        }
    }

    public String getRestriccionMedica() {
        return restriccionMedica;
    }

    public void setRestriccionMedica(String restriccionMedica) {
        if(restriccionMedica!=null){
            this.restriccionMedica = restriccionMedica.toUpperCase();
        }else{
            this.restriccionMedica = restriccionMedica;
        }
    }

    

    public String getFechaNacimientoString() {
        return fechaNacimientoString;
    }

    public void setFechaNacimientoString(String fechaNacimientoString) {
        this.fechaNacimientoString = fechaNacimientoString;
    }

    //    public Long getIdGerencia() {
    //        return idGerencia;
    //    }
    //
    //    public void setIdGerencia(Long idGerencia) {
    //        this.idGerencia = idGerencia;
    //    }
    public Long getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Long idLocador) {
        this.idLocador = idLocador;
    }


    public Long getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(Long idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        if(observaciones!=null){
            this.observaciones = observaciones.toUpperCase();
        }else{
            this.observaciones = observaciones;
        }
    }

//    public List<InstAcadLocadorDTO> getInstAcadLocadorList() {
//        return instAcadLocadorList;
//    }
//
//    public void setInstAcadLocadorList(List<InstAcadLocadorDTO> instAcadLocadorList) {
//        this.instAcadLocadorList = instAcadLocadorList;
//    }
//
//    public List<LocadorCompetenciaDTO> getLocadorCompetenciaList() {
//        return locadorCompetenciaList;
//    }
//
//    public void setLocadorCompetenciaList(List<LocadorCompetenciaDTO> locadorCompetenciaList) {
//        this.locadorCompetenciaList = locadorCompetenciaList;
//    }
//
//    public List<LocadorDestaqueDTO> getLocadorDestaqueList() {
//        return locadorDestaqueList;
//    }
//
//    public void setLocadorDestaqueList(List<LocadorDestaqueDTO> locadorDestaqueList) {
//        this.locadorDestaqueList = locadorDestaqueList;
//    }

    public String getOrigenInformacion() {
        return origenInformacion;
    }

    public void setOrigenInformacion(String origenInformacion) {
        this.origenInformacion = origenInformacion;
    }

	public int compareTo(Object o) {
		LocadorDTO locador = (LocadorDTO)o; 
		String nombreCompleto = this.nombreCompletoArmado==null?"":this.nombreCompletoArmado;
		String nombreCompletoCompare = locador.nombreCompletoArmado==null?"":locador.nombreCompletoArmado;
		return nombreCompleto.compareToIgnoreCase(nombreCompletoCompare);
	}
}
