/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;
import java.util.Date;

/**
 *
 * @author gvillanueva
 */
public class BaseLegalFilter extends BasePaginatorFilter {
    private Long idBaseLegal;
    private String codigoBaseLegal;
    private String descripcion;
    private String descripcionNormaLegal;
    private Date fechaEntradaVigenciaNormaLegal;
    private Long tipoNormaLegal;
    private Long numeroNormaLegal;
    private String anioNormaLegal;
    private Long siglaNormaLegal;
    private String titulo;
    private String articuloNormaLegal;
    private Long tipoAnexo;
    private String articuloAnexo;
    
    private String codigoObligacion;
    private String descObligacion;
    //descrip detalle (acta y declaracion jurada)
    private String descObligacionDetalle;
    private Long idCriticidadObligacion;
    
    //para busqueda varios actividades (rubros) por obligacion
    private String idActividadesBusq;
    //para busqueda varios temas por obligacion (rubros)
    private String idTemasBusq;

    private String idsBaseLegal;
    //indicador de busqueda avanzada
    private String flgBusqAvanzada;
    private Long idObligacionTipo;
    private Long opcion;

    public String getFlgBusqAvanzada() {
        return flgBusqAvanzada;
    }

    public void setFlgBusqAvanzada(String flgBusqAvanzada) {
        this.flgBusqAvanzada = flgBusqAvanzada;
    }
    
    public String getDescObligacionDetalle() {
        return descObligacionDetalle;
    }

    public void setDescObligacionDetalle(String descObligacionDetalle) {
        this.descObligacionDetalle = descObligacionDetalle;
    }
    
    public String getIdTemasBusq() {
        return idTemasBusq;
    }

    public void setIdTemasBusq(String idTemasBusq) {
        this.idTemasBusq = idTemasBusq;
    }
    
    public String getIdActividadesBusq() {
        return idActividadesBusq;
    }

    public void setIdActividadesBusq(String idActividadesBusq) {
        this.idActividadesBusq = idActividadesBusq;
    }

    public Long getIdCriticidadObligacion() {
        return idCriticidadObligacion;
    }

    public void setIdCriticidadObligacion(Long idCriticidadObligacion) {
        this.idCriticidadObligacion = idCriticidadObligacion;
    }

    public String getDescObligacion() {
        return descObligacion;
    }

    public void setDescObligacion(String descObligacion) {
        this.descObligacion = descObligacion;
    }
    
    public String getCodigoObligacion() {
        return codigoObligacion;
    }

    public void setCodigoObligacion(String codigoObligacion) {
        this.codigoObligacion = codigoObligacion;
    }

    public Date getFechaEntradaVigenciaNormaLegal() {
        return fechaEntradaVigenciaNormaLegal;
    }

    public void setFechaEntradaVigenciaNormaLegal(Date fechaEntradaVigenciaNormaLegal) {
        this.fechaEntradaVigenciaNormaLegal = fechaEntradaVigenciaNormaLegal;
    }

    public Long getTipoNormaLegal() {
        return tipoNormaLegal;
    }

    public void setTipoNormaLegal(Long tipoNormaLegal) {
        this.tipoNormaLegal = tipoNormaLegal;
    }

    public Long getNumeroNormaLegal() {
        return numeroNormaLegal;
    }

    public void setNumeroNormaLegal(Long numeroNormaLegal) {
        this.numeroNormaLegal = numeroNormaLegal;
    }

    public String getAnioNormaLegal() {
        return anioNormaLegal;
    }

    public void setAnioNormaLegal(String anioNormaLegal) {
        this.anioNormaLegal = anioNormaLegal;
    }

    public Long getSiglaNormaLegal() {
        return siglaNormaLegal;
    }

    public void setSiglaNormaLegal(Long siglaNormaLegal) {
        this.siglaNormaLegal = siglaNormaLegal;
    }

    public String getArticuloNormaLegal() {
        return articuloNormaLegal;
    }

    public void setArticuloNormaLegal(String articuloNormaLegal) {
        this.articuloNormaLegal = articuloNormaLegal;
    }

    public Long getTipoAnexo() {
        return tipoAnexo;
    }

    public void setTipoAnexo(Long tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }

    public String getArticuloAnexo() {
        return articuloAnexo;
    }

    public void setArticuloAnexo(String articuloAnexo) {
        this.articuloAnexo = articuloAnexo;
    }

    public Long getIdBaseLegal() {
        return idBaseLegal;
    }

    public void setIdBaseLegal(Long idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoBaseLegal() {
		return codigoBaseLegal;
	}

	public void setCodigoBaseLegal(String codigoBaseLegal) {
		this.codigoBaseLegal = codigoBaseLegal;
	}

    public String getIdsBaseLegal() {
        return idsBaseLegal;
    }

    public void setIdsBaseLegal(String idsBaseLegal) {
        this.idsBaseLegal = idsBaseLegal;
    }

	public Long getOpcion() {
		return opcion;
	}

	public void setOpcion(Long opcion) {
		this.opcion = opcion;
	}

	public Long getIdObligacionTipo() {
		return idObligacionTipo;
	}

	public void setIdObligacionTipo(Long idObligacionTipo) {
		this.idObligacionTipo = idObligacionTipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcionNormaLegal() {
		return descripcionNormaLegal;
	}

	public void setDescripcionNormaLegal(String descripcionNormaLegal) {
		this.descripcionNormaLegal = descripcionNormaLegal;
	}
	
    
}
