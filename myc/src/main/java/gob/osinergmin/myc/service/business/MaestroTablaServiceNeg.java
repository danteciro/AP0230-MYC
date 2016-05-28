/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.MaestroTablaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroTablaFilter;
import gob.osinergmin.myc.service.exception.MaestroTablaException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface MaestroTablaServiceNeg {
    public List<MaestroTablaDTO> buscarDominios() throws Exception;
    public List<MaestroTablaDTO> buscarAplicaciones() throws Exception;
    public MaestroTablaDTO guardarMaestroTabla(MaestroTablaDTO maestroTablaDTO, UsuarioDTO usuarioDTO) throws MaestroTablaException;
    public MaestroTablaDTO editarMaestroTabla(MaestroTablaDTO maestroTablaDTO, UsuarioDTO usuarioDTO) throws MaestroTablaException;
    public List<MaestroTablaDTO> listarMaestroTabla(MaestroTablaFilter filtro, int[] auxiliar);
}
