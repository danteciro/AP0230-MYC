/**
* Resumen
* Objeto		: PersonalDTO.java
* Descripci�n		: Objeto que transporta datos de Personal
* Fecha de Creaci�n	: 
* PR de Creaci�n	: OSINE_SFS-480
* Autor			: Julio Piro Gonzales
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripci�n
* ---------------------------------------------------------------------------------------------------
* OSINE_SFS-480     12/05/2016      Luis Garc�a Reyna           Correo de Alerta a Empresa Supervisora cuando se le asigne Orden de Servicio.
* OSINE_SFS-480     23/05/2016      Luis Garc�a Reyna           Implementar la funcionalidad de devoluci�n de asignaciones de acuerdo a especificaciones.
*
*/

package gob.osinergmin.myc.domain.dto;

import java.util.List;

/**
 *
 * @author jpiro
 */
public class PersonalDTO {
    private Long idPersonal;
    private String nombreUsuarioSiged;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long idPersonalSiged;
    private RolDTO rol;
    private CargoDTO cargo;
//    private List<ExpedienteDTO> expedientes;
    private LocadorDTO locador;
    private SupervisoraEmpresaDTO supervisoraEmpresa;
    private MaestroColumnaDTO tipoDocumentoIdentidad;
    private UnidadOrganicaDTO unidad;
    private UnidadOrganicaDTO division;
    private UnidadOrganicaDTO gerencia;
    private List<PersonalUnidadOrganicaDTO> listPersonalUnidadOrganica;
    private PersonalUnidadOrganicaDTO personalUnidadOrganicaDefault;
    /* OSINE_SFS-480 - RSIS 12 - Inicio */
    private String nombreCompleto;
    private String correoElectronico;
    /* OSINE_SFS-480 - RSIS 12 - Fin */
    /* OSINE_SFS-480 - RSIS 40 - Inicio */
    public PersonalDTO() {
    }
    
    public PersonalDTO(Long idPersonal) {
        this.idPersonal = idPersonal;
    }
    /* OSINE_SFS-480 - RSIS 40 - Fin */

    public PersonalUnidadOrganicaDTO getPersonalUnidadOrganicaDefault() {
        return personalUnidadOrganicaDefault;
    }

    public void setPersonalUnidadOrganicaDefault(PersonalUnidadOrganicaDTO personalUnidadOrganicaDefault) {
        this.personalUnidadOrganicaDefault = personalUnidadOrganicaDefault;
    }
    
    public List<PersonalUnidadOrganicaDTO> getListPersonalUnidadOrganica() {
        return listPersonalUnidadOrganica;
    }

    public void setListPersonalUnidadOrganica(List<PersonalUnidadOrganicaDTO> listPersonalUnidadOrganica) {
        this.listPersonalUnidadOrganica = listPersonalUnidadOrganica;
    }

    public UnidadOrganicaDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadOrganicaDTO unidad) {
        this.unidad = unidad;
    }

    public UnidadOrganicaDTO getDivision() {
        return division;
    }

    public void setDivision(UnidadOrganicaDTO division) {
        this.division = division;
    }

    public UnidadOrganicaDTO getGerencia() {
        return gerencia;
    }

    public void setGerencia(UnidadOrganicaDTO gerencia) {
        this.gerencia = gerencia;
    }

    public MaestroColumnaDTO getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(MaestroColumnaDTO tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }
    
    public CargoDTO getCargo() {
        return cargo;
    }

    public void setCargo(CargoDTO cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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

    	public Long getIdPersonalSiged() {
		return idPersonalSiged;
	}

	public void setIdPersonalSiged(Long idPersonalSiged) {
		this.idPersonalSiged = idPersonalSiged;
	}

	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}
        /* OSINE_SFS-480 - RSIS 12 - Inicio */
        public String getNombreCompleto() {
            return nombreCompleto;
        }
        public void setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
        }
        public String getCorreoElectronico() {
            return correoElectronico;
        }    
        public void setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
        }
        /* OSINE_SFS-480 - RSIS 12 - Fin */

		public LocadorDTO getLocador() {
			return locador;
		}

		public void setLocador(LocadorDTO locador) {
			this.locador = locador;
		}

		public SupervisoraEmpresaDTO getSupervisoraEmpresa() {
			return supervisoraEmpresa;
		}

		public void setSupervisoraEmpresa(SupervisoraEmpresaDTO supervisoraEmpresa) {
			this.supervisoraEmpresa = supervisoraEmpresa;
		}
        
}
