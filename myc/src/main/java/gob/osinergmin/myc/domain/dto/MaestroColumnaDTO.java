package gob.osinergmin.myc.domain.dto;

import java.io.Serializable;
/**
 *
 * @author gvillanueva
 */
public class MaestroColumnaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idMaestroColumna;
    private String codigo;
    private String descripcion;
    private String estado;    
    private String dominio;
    private String aplicacion;
    
    private Long idComponente;
    private String descripcionComponente;
    private Long idActividad;
    private Long idSigla;
    private String descripcionSigla;
    private Long idTipoAnexo;
    private String descripcionTipoAnexo;
    private Long idTemaObligacion;
    private String descripcionTemaObligacion;
    private Long idCriticidadObligacion;
    private String descripcionCriticidadObligacion;
    private Long idTipoNormaTecnica;
    private String descripcionTipoNormaTecnica;
    private boolean select;
    private String esEditable;
    
    public MaestroColumnaDTO(){
        
    }
    public MaestroColumnaDTO(Long idMaestroColumna){
        this.idMaestroColumna=idMaestroColumna;
        
    }
    public MaestroColumnaDTO(Long idMaestroColumna,String descripcion){
        this.idMaestroColumna=idMaestroColumna;
        this.descripcion=descripcion;
        
    }

    public String getEsEditable() {
        return esEditable;
    }

    public void setEsEditable(String esEditable) {
        this.esEditable = esEditable;
    }

    public Long getIdMaestroColumna() {
        return idMaestroColumna;
    }

    public void setIdMaestroColumna(Long idMaestroColumna) {
        this.idMaestroColumna = idMaestroColumna;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Long getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Long idComponente) {
        this.idComponente = idComponente;
    }

    public String getDescripcionComponente() {
        return descripcionComponente;
    }

    public void setDescripcionComponente(String descripcionComponente) {
        this.descripcionComponente = descripcionComponente;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Long getIdSigla() {
        return idSigla;
    }

    public void setIdSigla(Long idSigla) {
        this.idSigla = idSigla;
    }

    public String getDescripcionSigla() {
        return descripcionSigla;
    }

    public void setDescripcionSigla(String descripcionSigla) {
        this.descripcionSigla = descripcionSigla;
    }

    public Long getIdTipoAnexo() {
        return idTipoAnexo;
    }

    public void setIdTipoAnexo(Long idTipoAnexo) {
        this.idTipoAnexo = idTipoAnexo;
    }

    public String getDescripcionTipoAnexo() {
        return descripcionTipoAnexo;
    }

    public void setDescripcionTipoAnexo(String descripcionTipoAnexo) {
        this.descripcionTipoAnexo = descripcionTipoAnexo;
    }
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public String getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
    
    

    public Long getIdTemaObligacion() {
        return idTemaObligacion;
    }

    public void setIdTemaObligacion(Long idTemaObligacion) {
        this.idTemaObligacion = idTemaObligacion;
    }

    public String getDescripcionTemaObligacion() {
        return descripcionTemaObligacion;
    }

    public void setDescripcionTemaObligacion(String descripcionTemaObligacion) {
        this.descripcionTemaObligacion = descripcionTemaObligacion;
    }

    public Long getIdCriticidadObligacion() {
        return idCriticidadObligacion;
    }

    public void setIdCriticidadObligacion(Long idCriticidadObligacion) {
        this.idCriticidadObligacion = idCriticidadObligacion;
    }

    public String getDescripcionCriticidadObligacion() {
        return descripcionCriticidadObligacion;
    }

    public void setDescripcionCriticidadObligacion(String descripcionCriticidadObligacion) {
        this.descripcionCriticidadObligacion = descripcionCriticidadObligacion;
    }

    public Long getIdTipoNormaTecnica() {
        return idTipoNormaTecnica;
    }

    public void setIdTipoNormaTecnica(Long idTipoNormaTecnica) {
        this.idTipoNormaTecnica = idTipoNormaTecnica;
    }

    public String getDescripcionTipoNormaTecnica() {
        return descripcionTipoNormaTecnica;
    }

    public void setDescripcionTipoNormaTecnica(String descripcionTipoNormaTecnica) {
        this.descripcionTipoNormaTecnica = descripcionTipoNormaTecnica;
    }
	public boolean getSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
    
    
}
