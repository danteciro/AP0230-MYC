package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;

import java.util.List;

public interface EtapaNpsDAO {
   public List<EtapaNpsDTO> listarEtapaByConfTramite(EtapaNpsFilter etapaNpsFilter);
   public EtapaNpsDTO create(EtapaNpsDTO etapaNpsDTO, UsuarioDTO usuarioDTO);
   public EtapaNpsDTO update(EtapaNpsDTO etapaNpsDTO, UsuarioDTO usuarioDTO);
   public List<EtapaNpsDTO> listarEtapasConfiguradas(Long idConfTramite);
   public List<EtapaNpsDTO> listarEtapasIds(String idEtapas);
   public List<EtapaNpsDTO> listarEtapas(EtapaNpsFilter etapaNpsFilter);
   public EtapaNpsDTO findByIdEtapa(Long idEtapa);
public List<EtapaNpsDTO> validaEtapa(EtapaNpsDTO etapaNpsDTO);

}
