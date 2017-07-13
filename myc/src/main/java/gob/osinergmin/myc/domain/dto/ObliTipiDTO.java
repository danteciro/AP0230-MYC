package gob.osinergmin.myc.domain.dto;
import java.util.List;
public class ObliTipiDTO {
	
	
	private Long idCriterio;
	private Long idObliTipiCriterio;
	private Long idTipificacion;
	private Long idObligacion;
	private CriterioDTO criterio;
	private TipificacionDTO tipificacion;
	private ObligacionNormativaDTO obligacion;
	private String codigoTipificacion; 	
	private String Estado;
	private String descripcionCriterio;	
// 05-11-2015	
	private String basesLegales;
	private String sancionMonetaria;
	private String sancionEspecifica;
	private Long idActividad;
	private String descripcionActividad;
	private List<TipificacionSancionDTO> TipificacionSancion;
//	
	
	public String getDescripcionCriterio() {
		return descripcionCriterio;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}
	public void setDescripcionCriterio(String descripcionCriterio) {
		this.descripcionCriterio = descripcionCriterio;
	}
	public String getCodigoTipificacion() {
		return codigoTipificacion;
	}
	public void setCodigoTipificacion(String codigoTipificacion) {
		this.codigoTipificacion = codigoTipificacion;
	}
	
	public CriterioDTO getCriterio() {
		return criterio;
	}
	public void setCriterio(CriterioDTO criterio) {
		this.criterio = criterio;
	}
	public TipificacionDTO getTipificacion() {
		return tipificacion;
	}
	public void setTipificacion(TipificacionDTO tipificacion) {
		this.tipificacion = tipificacion;
	}
	public ObligacionNormativaDTO getObligacion() {
		return obligacion;
	}
	public void setObligacion(ObligacionNormativaDTO obligacion) {
		this.obligacion = obligacion;
	}
	public Long getIdCriterio() {
		return idCriterio;
	}
	public void setIdCriterio(Long idCriterio) {
		this.idCriterio = idCriterio;
	}
	public Long getIdObliTipiCriterio() {
		return idObliTipiCriterio;
	}
	public void setIdObliTipiCriterio(Long idObliTipiCriterio) {
		this.idObliTipiCriterio = idObliTipiCriterio;
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
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getBasesLegales() {
		return basesLegales;
	}
	public void setBasesLegales(String basesLegales) {
		this.basesLegales = basesLegales;
	}
	public String getSancionMonetaria() {
		return sancionMonetaria;
	}
	public void setSancionMonetaria(String sancionMonetaria) {
		this.sancionMonetaria = sancionMonetaria;
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
