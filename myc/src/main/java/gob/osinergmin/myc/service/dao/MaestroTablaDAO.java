/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.MaestroTablaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroTablaFilter;
import gob.osinergmin.myc.service.exception.MaestroTablaException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface MaestroTablaDAO {
    public List<MaestroTablaDTO> findDominios();
    public List<MaestroTablaDTO> findAplicaciones();
    public MaestroTablaDTO create(MaestroTablaDTO maestroTablaDTO,UsuarioDTO usuarioDTO) throws MaestroTablaException;
    public MaestroTablaDTO update(MaestroTablaDTO maestroTablaDTO,UsuarioDTO usuarioDTO) throws MaestroTablaException;
    public List<MaestroTablaDTO> findDominio(MaestroTablaFilter filtro);
}
