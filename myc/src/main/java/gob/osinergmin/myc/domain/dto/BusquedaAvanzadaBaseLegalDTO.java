package gob.osinergmin.myc.domain.dto;

import java.util.Date;
import java.util.List;
/**
 *
 * @author gvillanueva
 */
public class BusquedaAvanzadaBaseLegalDTO {
    
    /** código de la Base Legal**/
    private String codigoBaseLegal;
    
    /** Norma Legal **/
    /** descripción del tipo de la norma legal**/
    private String tipoNormaLegal;
    /** número de la norma legal **/
    private Long numeroNormaLegal;
    /** año de la norma legal**/
    private Integer anoNormaLegal;
    /** sigla de la norma legal**/
    private String siglaNormaLegal;
    /** fecha de entrada en vigencia de la norma legal**/
    private Date fechaEntradaVigenciaNormaLegal;
    /** fecha de publicación de la norma legal**/
    private Date fechaPublicacionNormaLegal;
    /* título de la norma legal*/
    private String TituloNormaLegal;
    /* articulo de la norma legal*/
    private String articuloNormaLegal;
    /** inciso nivel 1 de la norma legal**/
    private String incisoUnoNormaLegal;
    /** inciso nivel 2 de la norma legal**/
    private String incisoDosNormaLegal;
    
    /** Anexo de la Norma Legal **/
    /** descripción del tipo de anexo **/
    private String tipoAnexo;
    /** artículo del anexo **/
    private String articuloAnexo;
    /** inciso nivel 1 del anexo **/
    private String incisoUnoAnexo;
    /** inciso nivel 2 del anexo **/
    private String incisoDosAnexo;
   
    /** Norma Técnica **/
    /** descripción del tipo de la norma técnica **/
    private String tipoNormaTecnica;
    /** descripción específica de la norma técnica **/
    private String descripcionNormaTecnica;
    
    /** fecha de entrada en vigencia de la norma a su mas bajo nivel **/
    private Date fechaEntradaVigenciaNorma;
    
    /** descripción de la base legal seleccionada para en Concordancia **/
    private String descripcionConcordancia;
    
      
    
    /** Listado de Actividades **/
    private List<ActividadDTO> listaActividades= null;
    /** Listado de Productos **/
    private List<ProductoDTO> listaProductos=null;
    /*Listado de Tipos de Transporte*/
    private List<TransporteDTO> listaTransportes=null;
    
    public String getCodigoBaseLegal() {
        return codigoBaseLegal;
    }

    public void setCodigoBaseLegal(String codigoBaseLegal) {
        this.codigoBaseLegal = codigoBaseLegal;
    }

    public String getTipoNormaLegal() {
        return tipoNormaLegal;
    }

    public void setTipoNormaLegal(String tipoNormaLegal) {
        this.tipoNormaLegal = tipoNormaLegal;
    }

    public Long getNumeroNormaLegal() {
        return numeroNormaLegal;
    }

    public void setNumeroNormaLegal(Long numeroNormaLegal) {
        this.numeroNormaLegal = numeroNormaLegal;
    }

    public Integer getAnoNormaLegal() {
        return anoNormaLegal;
    }

    public void setAnoNormaLegal(Integer anoNormaLegal) {
        this.anoNormaLegal = anoNormaLegal;
    }

    public String getSiglaNormaLegal() {
        return siglaNormaLegal;
    }

    public void setSiglaNormaLegal(String siglaNormaLegal) {
        this.siglaNormaLegal = siglaNormaLegal;
    }

    public Date getFechaEntradaVigenciaNormaLegal() {
        return fechaEntradaVigenciaNormaLegal;
    }

    public void setFechaEntradaVigenciaNormaLegal(Date fechaEntradaVigenciaNormaLegal) {
        this.fechaEntradaVigenciaNormaLegal = fechaEntradaVigenciaNormaLegal;
    }

    public Date getFechaPublicacionNormaLegal() {
        return fechaPublicacionNormaLegal;
    }

    public void setFechaPublicacionNormaLegal(Date fechaPublicacionNormaLegal) {
        this.fechaPublicacionNormaLegal = fechaPublicacionNormaLegal;
    }

    public String getTituloNormaLegal() {
        return TituloNormaLegal;
    }

    public void setTituloNormaLegal(String TituloNormaLegal) {
        this.TituloNormaLegal = TituloNormaLegal;
    }

    public String getArticuloNormaLegal() {
        return articuloNormaLegal;
    }

    public void setArticuloNormaLegal(String articuloNormaLegal) {
        this.articuloNormaLegal = articuloNormaLegal;
    }

    public String getIncisoUnoNormaLegal() {
        return incisoUnoNormaLegal;
    }

    public void setIncisoUnoNormaLegal(String incisoUnoNormaLegal) {
        this.incisoUnoNormaLegal = incisoUnoNormaLegal;
    }

    public String getIncisoDosNormaLegal() {
        return incisoDosNormaLegal;
    }

    public void setIncisoDosNormaLegal(String incisoDosNormaLegal) {
        this.incisoDosNormaLegal = incisoDosNormaLegal;
    }

    public String getTipoAnexo() {
        return tipoAnexo;
    }

    public void setTipoAnexo(String tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }

    public String getArticuloAnexo() {
        return articuloAnexo;
    }

    public void setArticuloAnexo(String articuloAnexo) {
        this.articuloAnexo = articuloAnexo;
    }

    public String getIncisoUnoAnexo() {
        return incisoUnoAnexo;
    }

    public void setIncisoUnoAnexo(String incisoUnoAnexo) {
        this.incisoUnoAnexo = incisoUnoAnexo;
    }

    public String getIncisoDosAnexo() {
        return incisoDosAnexo;
    }

    public void setIncisoDosAnexo(String incisoDosAnexo) {
        this.incisoDosAnexo = incisoDosAnexo;
    }

    public String getTipoNormaTecnica() {
        return tipoNormaTecnica;
    }

    public void setTipoNormaTecnica(String tipoNormaTecnica) {
        this.tipoNormaTecnica = tipoNormaTecnica;
    }

    public String getDescripcionNormaTecnica() {
        return descripcionNormaTecnica;
    }

    public void setDescripcionNormaTecnica(String descripcionNormaTecnica) {
        this.descripcionNormaTecnica = descripcionNormaTecnica;
    }

    public Date getFechaEntradaVigenciaNorma() {
        return fechaEntradaVigenciaNorma;
    }

    public void setFechaEntradaVigenciaNorma(Date fechaEntradaVigenciaNorma) {
        this.fechaEntradaVigenciaNorma = fechaEntradaVigenciaNorma;
    }

    public String getDescripcionConcordancia() {
        return descripcionConcordancia;
    }

    public void setDescripcionConcordancia(String descripcionConcordancia) {
        this.descripcionConcordancia = descripcionConcordancia;
    }

    public List<ActividadDTO> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(List<ActividadDTO> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public List<ProductoDTO> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoDTO> listaProductos) {
        this.listaProductos = listaProductos;
    }
    /*retorna lista de transportes ** @return listaTransportes.*/
    public List<TransporteDTO> getListaTransportes() {
        return listaTransportes;
    }
    /* coloca lista de transporte ** @param listaTransportes.*/
    public void setListaTransportes(List<TransporteDTO> listaTransportes) {
        this.listaTransportes = listaTransportes;
    }
}
