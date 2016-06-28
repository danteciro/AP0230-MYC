/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;


/**
 *
 * @author rcoloradoa
 */
public interface InfraccionDAO {
    public InfraccionDTO create(InfraccionDTO detalleObligacionDTO, UsuarioDTO usuarioDTO);
	public InfraccionDTO update(InfraccionDTO detalleObligacionDTO,UsuarioDTO usuarioDTO);
	public Long findInfraccion(InfraccionDTO infraccion);		
}