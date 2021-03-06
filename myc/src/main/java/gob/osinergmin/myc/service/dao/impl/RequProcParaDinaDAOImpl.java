/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghCnfRequProcedimiento;
import gob.osinergmin.myc.domain.PghRequProcParaDina;
import gob.osinergmin.myc.domain.builder.PghCnfRequProcedimientoBuilder;
import gob.osinergmin.myc.domain.builder.RequProcParaDinaBuilder;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.RequProcParaDinaDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.exception.CnfRequProcedimientoException;
import gob.osinergmin.myc.service.exception.RequProcParaDinaException;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.PropertyUtils;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("requProcParaDinaDAO")
public class RequProcParaDinaDAOImpl implements RequProcParaDinaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(RequisitoDAO.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public RequProcParaDinaDTO create(RequProcParaDinaDTO registroDTO, UsuarioDTO usuarioDTO) throws RequProcParaDinaException{
        RequProcParaDinaDTO retorno = null;
        try{
            PghRequProcParaDina registroDAO = RequProcParaDinaBuilder.getRequProcParaDina(registroDTO);
            registroDAO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.create(registroDAO);
            
            retorno=RequProcParaDinaBuilder.toRequProcParaDinaDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(RequProcParaDinaException.ERROR_CREAR_REQU_PROC_PARA_DINA),e);
            RequProcParaDinaException e2 = new RequProcParaDinaException(RequProcParaDinaException.ERROR_CREAR_REQU_PROC_PARA_DINA,e, true);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public RequProcParaDinaDTO changeEstado(RequProcParaDinaDTO registroDTO, UsuarioDTO usuarioDTO) throws RequProcParaDinaException{
        RequProcParaDinaDTO retorno = null;
        try{
        	String queryString = "";
        	queryString += "UPDATE PghRequProcParaDina p SET "
            		+ " p.usuarioActualizacion = '" + usuarioDTO.getCodigo() + "' , "
    				+ " p.terminalActualizacion = '" + usuarioDTO.getTerminal() + "' , "
    				+ " p.estado  = 0";
                	queryString += " WHERE ESTADO = 1 ";
        	if(registroDTO.getValorParametro().getIdValorParametro()!=null){
        		queryString += "AND p.idValorParametro.idValorParametro = " + registroDTO.getValorParametro().getIdValorParametro()+ " ";
        	}
        	crud.getEm().createQuery(queryString).executeUpdate();
            retorno=registroDTO;
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(RequProcParaDinaException.ERROR_ELIMINAR_REQU_PROC_PARA_DINA),e);
            RequProcParaDinaException e2 = new RequProcParaDinaException(RequProcParaDinaException.ERROR_ELIMINAR_REQU_PROC_PARA_DINA,e, true);
            throw e2;
        }
        return retorno;
    }
}
