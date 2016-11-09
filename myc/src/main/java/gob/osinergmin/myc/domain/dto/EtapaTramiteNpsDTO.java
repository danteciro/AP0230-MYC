package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.domain.NpsConfTramite;
import gob.osinergmin.myc.domain.NpsEtapa;

public class EtapaTramiteNpsDTO {
	
	private Long idEtapaTramite;
    private ConfTramiteDTO idConfTramite;
    private EtapaNpsDTO idEtapa;
    private String estado;
    
	public Long getIdEtapaTramite() {
		return idEtapaTramite;
	}
	public void setIdEtapaTramite(Long idEtapaTramite) {
		this.idEtapaTramite = idEtapaTramite;
	}
	public ConfTramiteDTO getIdConfTramite() {
		return idConfTramite;
	}
	public void setIdConfTramite(ConfTramiteDTO idConfTramite) {
		this.idConfTramite = idConfTramite;
	}
	public EtapaNpsDTO getIdEtapa() {
		return idEtapa;
	}
	public void setIdEtapa(EtapaNpsDTO idEtapa) {
		this.idEtapa = idEtapa;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}

