/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaFilter;
import gob.osinergmin.myc.service.exception.EtapaException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface EtapaDAO {
    public HashMap listarEtapa(EtapaFilter filtro) throws EtapaException;
    public EtapaDTO create(EtapaDTO etapaDTO, UsuarioDTO usuarioDTO);
    public EtapaDTO changeState(EtapaDTO etapaDTO, String estado) throws EtapaException;
	public List<EtapaDTO> listarEtapaById(Long idProceso);
	public List<EtapaDTO> listEtapaDetailById(Long idProceso);
	public List<EtapaDTO> validarEtapa(EtapaDTO etapaDTO);
}