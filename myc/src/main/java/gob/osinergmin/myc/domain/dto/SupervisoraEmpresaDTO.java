/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author lbarboza
 */
public class SupervisoraEmpresaDTO extends Control implements Comparable{
    private Long idSupervisoraEmpresa;
    private Long tipoEmpresaConstitucion;
    private String razonSocial;
    private String nombreConsorcio;
    private String ruc;
    private MaestroColumnaDTO ciiuPrincipal;
    private String paginaWeb;
    private String orgInf;
    private String estado;
    private String telefonoDireccionFiscal;
    private String numeroContratroVigente;
    private String representantes;
    private Long idUnidadOrganica;

    public SupervisoraEmpresaDTO() {
    }

    public SupervisoraEmpresaDTO(Long idSupervisoraEmpresa) {
        this.idSupervisoraEmpresa = idSupervisoraEmpresa;
    }

    public Long getIdUnidadOrganica() {
        return idUnidadOrganica;
    }

    public void setIdUnidadOrganica(Long idUnidadOrganica) {
        this.idUnidadOrganica = idUnidadOrganica;
    }

    public String getNumeroContratroVigente() {
        return numeroContratroVigente;
    }

    public void setNumeroContratroVigente(String numeroContratroVigente) {
        this.numeroContratroVigente = numeroContratroVigente;
    }

    public String getTelefonoDireccionFiscal() {
        return telefonoDireccionFiscal;
    }

    public void setTelefonoDireccionFiscal(String telefonoDireccionFiscal) {
        this.telefonoDireccionFiscal = telefonoDireccionFiscal;
    }
    
    public Long getIdSupervisoraEmpresa() {
        return idSupervisoraEmpresa;
    }

    public void setIdSupervisoraEmpresa(Long idSupervisoraEmpresa) {
        this.idSupervisoraEmpresa = idSupervisoraEmpresa;
    }

    public Long getTipoEmpresaConstitucion() {
        return tipoEmpresaConstitucion;
    }

    public void setTipoEmpresaConstitucion(Long tipoEmpresaConstitucion) {
        this.tipoEmpresaConstitucion = tipoEmpresaConstitucion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        if(razonSocial!=null){
            this.razonSocial = razonSocial.toUpperCase();
        }else{
            this.razonSocial = razonSocial;
        }
    }
    
    public String getNombreConsorcio() {
		return nombreConsorcio;
	}

	public void setNombreConsorcio(String nombreConsorcio) {
		if(nombreConsorcio!=null){
			this.nombreConsorcio = nombreConsorcio.toUpperCase();
		}else{
			this.nombreConsorcio = nombreConsorcio;
		}
	}

	public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /*public String getCiiuPrincipal() {
        return ciiuPrincipal;
    }

    public void setCiiuPrincipal(String ciiuPrincipal) {
        this.ciiuPrincipal = ciiuPrincipal;
    }*/
    public MaestroColumnaDTO getCiiuPrincipal() {
            return ciiuPrincipal;
    }

    public void setCiiuPrincipal(MaestroColumnaDTO ciiuPrincipal) {
            this.ciiuPrincipal = ciiuPrincipal;
    }
        
    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        if(paginaWeb!=null){
            this.paginaWeb = paginaWeb.toUpperCase();
        }else{
            this.paginaWeb = paginaWeb;
        }
    }

    public String getOrgInf() {
        return orgInf;
    }

    public void setOrgInf(String orgInf) {
        this.orgInf = orgInf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(String representantes) {
        this.representantes = representantes;
    }

	public int compareTo(Object o) {
		SupervisoraEmpresaDTO supervisoraEmpresa = (SupervisoraEmpresaDTO)o; 
		String razonSocial=this.razonSocial==null?"":this.razonSocial;
		String razonSocialCompare=supervisoraEmpresa.razonSocial==null?"":supervisoraEmpresa.razonSocial;
		return razonSocial.compareToIgnoreCase(razonSocialCompare);
	}
}