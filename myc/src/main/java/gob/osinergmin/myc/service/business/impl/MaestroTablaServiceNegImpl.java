/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.MaestroTablaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroTablaFilter;
import gob.osinergmin.myc.service.business.MaestroTablaServiceNeg;
import gob.osinergmin.myc.service.dao.MaestroTablaDAO;
import gob.osinergmin.myc.service.exception.MaestroTablaException;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service("MaestroTablaServiceNeg")
public class MaestroTablaServiceNegImpl implements MaestroTablaServiceNeg {
    private static final Logger LOG = LoggerFactory.getLogger(MaestroTablaServiceNegImpl.class);
    @Inject
    MaestroTablaDAO maestroTablaDAO;
    
    @Override
    public List<MaestroTablaDTO> buscarDominios() throws Exception {
        List<MaestroTablaDTO>  retorno = null; 	
    	try{    		
            retorno = maestroTablaDAO.findDominios();    		
    	}catch(Exception ex){    		
            LOG.info("error service buscarDominios : ",ex);
    	}    	    
    	return retorno;
    }
    @Override
    public List<MaestroTablaDTO> buscarAplicaciones() throws Exception {
        List<MaestroTablaDTO>  retorno = null; 	
    	try{    		
            retorno = maestroTablaDAO.findAplicaciones();    		
    	}catch(Exception ex){    		
            LOG.info("error service buscarDominios : ",ex);
    	}    	    
    	return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=MaestroTablaException.class)
    public MaestroTablaDTO guardarMaestroTabla(MaestroTablaDTO maestroTablaDTO, UsuarioDTO usuarioDTO) throws MaestroTablaException{
        MaestroTablaDTO retorno = null;
        try {
            retorno = maestroTablaDAO.create(maestroTablaDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("Error en guardarMaestroTabla, ",ex);
            throw new MaestroTablaException(ex.getMessage(),null);
        }
        return retorno;
    }
    @Override
    @Transactional(rollbackFor=MaestroTablaException.class)
    public MaestroTablaDTO editarMaestroTabla(MaestroTablaDTO maestroTablaDTO, UsuarioDTO usuarioDTO) throws MaestroTablaException{
        MaestroTablaDTO retorno = null;
        try {
            retorno = maestroTablaDAO.update(maestroTablaDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("Error en editarMaestroTabla, ",ex);
            throw new MaestroTablaException(ex.getMessage(),null);
        }
        return retorno;
    }
    @Override
       public List<MaestroTablaDTO> listarMaestroTabla(
                    MaestroTablaFilter filtro, int[] auxiliar) {
             List<MaestroTablaDTO>  retorno = null; 
       try{                
            retorno = maestroTablaDAO.findDominio(filtro);               
       }catch(Exception ex){             
            LOG.info("error service buscarDominios : ",ex);
       }          
       return retorno;
       }

    
}
