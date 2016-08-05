package gob.osinergmin.myc.service.business.impl;
import gob.osinergmin.myc.domain.dto.ConfFiltroEmpSupDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ConfFiltroEmpSupFilter;
import gob.osinergmin.myc.service.business.ConfFiltroEmpSupServiceNeg;
import gob.osinergmin.myc.service.dao.ConfFiltroEmpSupDAO;
import gob.osinergmin.myc.service.exception.ConfFiltroEmpSupException;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 *
 * @author mdiosesf
 */
@Service("ConfFiltroEmpSupServiceNeg")
public class ConfFiltroEmpSupServiceNegImpl implements ConfFiltroEmpSupServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(ConfFiltroEmpSupServiceNeg.class);
    @Inject
    private ConfFiltroEmpSupDAO confFiltroEmpSupDAO;    
    
    @Override
	public List<ConfFiltroEmpSupDTO> ConfFiltroEmpSup(ConfFiltroEmpSupFilter filtro) throws ConfFiltroEmpSupException {
    	LOG.info("Neg ConfFiltroEmpSup");
    	List<ConfFiltroEmpSupDTO> retorno=null;
        try{
            retorno = confFiltroEmpSupDAO.findConfFiltroEmpSup(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
            throw new ConfFiltroEmpSupException(ex.getMessage(),null);
        }
        return retorno;
	}

	@Override
	public ConfFiltroEmpSupDTO guardarConfFiltroEmpSup(ConfFiltroEmpSupDTO confFiltroEmpSupDTO, UsuarioDTO usuarioDTO) throws ConfFiltroEmpSupException {
		ConfFiltroEmpSupDTO retorno = null;
        try {
            retorno = confFiltroEmpSupDAO.create(confFiltroEmpSupDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("Error en guardarConfFiltroEmpSup", ex);
            throw new ConfFiltroEmpSupException(ex.getMessage(),null);
        }
        return retorno;
	}

	@Override
	public ConfFiltroEmpSupDTO editarConfFiltroEmpSup(ConfFiltroEmpSupDTO confFiltroEmpSupDTO, UsuarioDTO usuarioDTO) throws ConfFiltroEmpSupException {
		ConfFiltroEmpSupDTO retorno = null;
        try {
            retorno = confFiltroEmpSupDAO.update(confFiltroEmpSupDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("Error en guardarConfFiltroEmpSup", ex);
            throw new ConfFiltroEmpSupException(ex.getMessage(),null);
        }
        return retorno;
	} 
}
