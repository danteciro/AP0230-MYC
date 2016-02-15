package gob.osinergmin.myc.domain.dto;

import java.io.Serializable;

public class CfgActividadDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String index;
	private String desActividad;
	private String codActividad;
	private String desGrupoActividad;
	private String codGrupoActividad;
	private String desSubGrupoActividad;
	private String codSubGrupoActividad;
	private String desTipoDireccion;
	private String codTipoDireccion;
	private String desUnidadFiscalizadora;
	private String codUnidadFiscalizadoraUROC;
	private String codUnidadFiscalizadoraUPPD;
	private String codUnidadFiscalizadoraGO;
	private String desScop;
	private String codScop;
	
	private String desEtapa;
	private String desTramite;
	private boolean flgUROC;
	private boolean flgUPPD;
	private boolean flgGO;
	private boolean flgSCOP;
	
	private boolean flgTramInstalacion;
	private boolean flgTramModInstalacion;
	private boolean flgTramEstRiesgo;
	private boolean flgTramPlanContingencia;
	private boolean flgTramOpinionFav;
	private boolean flgTramActasVerif;
	private boolean flgTramActasVerifYPrueba;
	private boolean flgTramActasPrueba;
	private boolean flgTramInscripcion;
	private boolean flgTramModInscripcion;
	private boolean flgTramSuspension;
	private boolean flgTramCancelacion;
	private boolean flgTramHabilitacion;
	private boolean flgTramReconsideracion;
	private boolean flgTramApelacion;
	private boolean flgAsignado;
	
	public String getDesGrupoActividad() {
		return desGrupoActividad;
	}
	public void setDesGrupoActividad(String desGrupoActividad) {
		this.desGrupoActividad = desGrupoActividad;
	}
	public String getCodGrupoActividad() {
		return codGrupoActividad;
	}
	public void setCodGrupoActividad(String codGrupoActividad) {
		this.codGrupoActividad = codGrupoActividad;
	}
	public String getDesActividad() {
		return desActividad;
	}
	public void setDesActividad(String desActividad) {
		this.desActividad = desActividad;
	}
	public String getCodActividad() {
		return codActividad;
	}
	public void setCodActividad(String codActividad) {
		this.codActividad = codActividad;
	}
	public String getDesUnidadFiscalizadora() {
		return desUnidadFiscalizadora;
	}
	public void setDesUnidadFiscalizadora(String desUnidadFiscalizadora) {
		this.desUnidadFiscalizadora = desUnidadFiscalizadora;
	}
	public String getDesScop() {
		return desScop;
	}
	public void setDesScop(String desScop) {
		this.desScop = desScop;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDesTipoDireccion() {
		return desTipoDireccion;
	}
	public void setDesTipoDireccion(String desTipoDireccion) {
		this.desTipoDireccion = desTipoDireccion;
	}
	public String getCodTipoDireccion() {
		return codTipoDireccion;
	}
	public void setCodTipoDireccion(String codTipoDireccion) {
		this.codTipoDireccion = codTipoDireccion;
	}
	public String getCodUnidadFiscalizadoraUROC() {
		return codUnidadFiscalizadoraUROC;
	}
	public void setCodUnidadFiscalizadoraUROC(String codUnidadFiscalizadoraUROC) {
		this.codUnidadFiscalizadoraUROC = codUnidadFiscalizadoraUROC;
	}
	public String getCodUnidadFiscalizadoraUPPD() {
		return codUnidadFiscalizadoraUPPD;
	}
	public void setCodUnidadFiscalizadoraUPPD(String codUnidadFiscalizadoraUPPD) {
		this.codUnidadFiscalizadoraUPPD = codUnidadFiscalizadoraUPPD;
	}
	public String getCodUnidadFiscalizadoraGO() {
		return codUnidadFiscalizadoraGO;
	}
	public void setCodUnidadFiscalizadoraGO(String codUnidadFiscalizadoraGO) {
		this.codUnidadFiscalizadoraGO = codUnidadFiscalizadoraGO;
	}
	public String getCodScop() {
		return codScop;
	}
	public void setCodScop(String codScop) {
		this.codScop = codScop;
	}
	public String getDesSubGrupoActividad() {
		return desSubGrupoActividad;
	}
	public void setDesSubGrupoActividad(String desSubGrupoActividad) {
		this.desSubGrupoActividad = desSubGrupoActividad;
	}
	public String getCodSubGrupoActividad() {
		return codSubGrupoActividad;
	}
	public void setCodSubGrupoActividad(String codSubGrupoActividad) {
		this.codSubGrupoActividad = codSubGrupoActividad;
	}
	public boolean isFlgTramInstalacion() {
		return flgTramInstalacion;
	}
	public void setFlgTramInstalacion(boolean flgTramInstalacion) {
		this.flgTramInstalacion = flgTramInstalacion;
	}
	public boolean isFlgTramModInstalacion() {
		return flgTramModInstalacion;
	}
	public void setFlgTramModInstalacion(boolean flgTramModInstalacion) {
		this.flgTramModInstalacion = flgTramModInstalacion;
	}
	public boolean isFlgTramEstRiesgo() {
		return flgTramEstRiesgo;
	}
	public void setFlgTramEstRiesgo(boolean flgTramEstRiesgo) {
		this.flgTramEstRiesgo = flgTramEstRiesgo;
	}
	public boolean isFlgTramPlanContingencia() {
		return flgTramPlanContingencia;
	}
	public void setFlgTramPlanContingencia(boolean flgTramPlanContingencia) {
		this.flgTramPlanContingencia = flgTramPlanContingencia;
	}
	public boolean isFlgTramOpinionFav() {
		return flgTramOpinionFav;
	}
	public void setFlgTramOpinionFav(boolean flgTramOpinionFav) {
		this.flgTramOpinionFav = flgTramOpinionFav;
	}
	public boolean isFlgTramActasVerif() {
		return flgTramActasVerif;
	}
	public void setFlgTramActasVerif(boolean flgTramActasVerif) {
		this.flgTramActasVerif = flgTramActasVerif;
	}
	public boolean isFlgTramActasVerifYPrueba() {
		return flgTramActasVerifYPrueba;
	}
	public void setFlgTramActasVerifYPrueba(boolean flgTramActasVerifYPrueba) {
		this.flgTramActasVerifYPrueba = flgTramActasVerifYPrueba;
	}
	public boolean isFlgTramActasPrueba() {
		return flgTramActasPrueba;
	}
	public void setFlgTramActasPrueba(boolean flgTramActasPrueba) {
		this.flgTramActasPrueba = flgTramActasPrueba;
	}
	public boolean isFlgTramInscripcion() {
		return flgTramInscripcion;
	}
	public void setFlgTramInscripcion(boolean flgTramInscripcion) {
		this.flgTramInscripcion = flgTramInscripcion;
	}
	public boolean isFlgTramModInscripcion() {
		return flgTramModInscripcion;
	}
	public void setFlgTramModInscripcion(boolean flgTramModInscripcion) {
		this.flgTramModInscripcion = flgTramModInscripcion;
	}
	public boolean isFlgTramSuspension() {
		return flgTramSuspension;
	}
	public void setFlgTramSuspension(boolean flgTramSuspension) {
		this.flgTramSuspension = flgTramSuspension;
	}
	public boolean isFlgTramCancelacion() {
		return flgTramCancelacion;
	}
	public void setFlgTramCancelacion(boolean flgTramCancelacion) {
		this.flgTramCancelacion = flgTramCancelacion;
	}
	public boolean isFlgTramHabilitacion() {
		return flgTramHabilitacion;
	}
	public void setFlgTramHabilitacion(boolean flgTramHabilitacion) {
		this.flgTramHabilitacion = flgTramHabilitacion;
	}
	public boolean isFlgTramReconsideracion() {
		return flgTramReconsideracion;
	}
	public void setFlgTramReconsideracion(boolean flgTramReconsideracion) {
		this.flgTramReconsideracion = flgTramReconsideracion;
	}
	public boolean isFlgTramApelacion() {
		return flgTramApelacion;
	}
	public void setFlgTramApelacion(boolean flgTramApelacion) {
		this.flgTramApelacion = flgTramApelacion;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public boolean isFlgAsignado() {
		return flgAsignado;
	}
	public void setFlgAsignado(boolean flgAsignado) {
		this.flgAsignado = flgAsignado;
	}
	public String getDesEtapa() {
		return desEtapa;
	}
	public void setDesEtapa(String desEtapa) {
		this.desEtapa = desEtapa;
	}
	public String getDesTramite() {
		return desTramite;
	}
	public void setDesTramite(String desTramite) {
		this.desTramite = desTramite;
	}
	public boolean isFlgUROC() {
		return flgUROC;
	}
	public void setFlgUROC(boolean flgUROC) {
		this.flgUROC = flgUROC;
	}
	public boolean isFlgUPPD() {
		return flgUPPD;
	}
	public void setFlgUPPD(boolean flgUPPD) {
		this.flgUPPD = flgUPPD;
	}
	public boolean isFlgGO() {
		return flgGO;
	}
	public void setFlgGO(boolean flgGO) {
		this.flgGO = flgGO;
	}
	public boolean isFlgSCOP() {
		return flgSCOP;
	}
	public void setFlgSCOP(boolean flgSCOP) {
		this.flgSCOP = flgSCOP;
	}
	
	
}
