package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;


public interface InfraccionServiceNeg {
	public InfraccionDTO guardaInfraccion(InfraccionDTO infraccionDTO, UsuarioDTO usuarioDTO);   
	public InfraccionDTO updateInfraccion(InfraccionDTO infraccionDTO, UsuarioDTO usuarioDTO);
	public Long listarInfraccion(Long idObligacion);
}
