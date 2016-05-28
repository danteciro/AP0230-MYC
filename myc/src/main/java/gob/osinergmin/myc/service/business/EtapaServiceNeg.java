/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaFilter;
import gob.osinergmin.myc.service.exception.EtapaException;
import java.util.List;

/**
 *
 * @author jpiro
 */
public interface EtapaServiceNeg {
    public List<EtapaDTO> listarEtapaByDescProceso(String descProceso);
    public List<EtapaDTO> findEtapaByFilter(EtapaFilter filtro, int[] cuenta);
    public EtapaDTO guardarEtapa(EtapaDTO etapaDTO, UsuarioDTO usuarioDTO);
    public EtapaDTO eliminarEtapa(EtapaDTO etapaDTO) throws EtapaException;
	public List<EtapaDTO> listarEtapaById(Long idProceso);
    public List<EtapaDTO> listEtapaDetailById(Long idProceso);
	List<EtapaDTO> validarEtapa(EtapaDTO etapaDTO);
}