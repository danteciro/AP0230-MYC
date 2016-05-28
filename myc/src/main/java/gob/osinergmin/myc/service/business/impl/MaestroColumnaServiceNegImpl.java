package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroColumnaFilter;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.dao.MaestroColumnaDAO;
import gob.osinergmin.myc.service.exception.MaestroColumnaException;
import gob.osinergmin.myc.util.Constantes;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MaestroColumnaServiceNeg")
public class MaestroColumnaServiceNegImpl implements MaestroColumnaServiceNeg{
    @Inject
    private MaestroColumnaDAO maestroColumnaDAO;
    private static final Logger LOG = LoggerFactory.getLogger(MaestroColumnaServiceNegImpl.class);

    @Override
    @Transactional
    public MaestroColumnaDTO eliminarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO, UsuarioDTO usuarioDTO){
        MaestroColumnaDTO retorno = null;
        try {
            retorno = maestroColumnaDAO.changeState(maestroColumnaDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=MaestroColumnaException.class)
    public MaestroColumnaDTO actualizarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO, UsuarioDTO usuarioDTO) throws MaestroColumnaException{
        MaestroColumnaDTO retorno = null;
        try {
            retorno = maestroColumnaDAO.update(maestroColumnaDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("Error en actualizarMaestroColumna", ex);
            throw new MaestroColumnaException(ex.getMessage(),null);
        }
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=MaestroColumnaException.class)
    public MaestroColumnaDTO guardarMaestroColumna(MaestroColumnaDTO maestroColumnaDTO, UsuarioDTO usuarioDTO) throws MaestroColumnaException{
        MaestroColumnaDTO retorno = null;
        try {
            retorno = maestroColumnaDAO.create(maestroColumnaDTO, usuarioDTO);
        } catch (Exception ex) {
            LOG.error("Error en guardarMaestroColumna", ex);
            throw new MaestroColumnaException(ex.getMessage(),null);
        }
        return retorno;
    }
    
    @Override
    @Transactional(readOnly=true)
    public MaestroColumnaDTO findById(Long idMaestroColumna){
        LOG.info("Neg listarRequisito");
        MaestroColumnaDTO retorno=null;
        try{
            retorno=maestroColumnaDAO.findById(idMaestroColumna);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }        
        
    @Override
    @Transactional(readOnly=true)
    public List<MaestroColumnaDTO> listarMaestroColumna(MaestroColumnaFilter filtro,int[] cuenta){
        LOG.info("Neg listarRequisito");
        List<MaestroColumnaDTO> retorno=null;
        try{
            cuenta[0] = maestroColumnaDAO.count(filtro).intValue();
            if (cuenta[0] > 0) {
                retorno = maestroColumnaDAO.find(filtro);
                LOG.info("cuenta -size: "+retorno.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public List<MaestroColumnaDTO> buscarMycByDominio(String dominio) throws Exception {
		List<MaestroColumnaDTO>  retorno = null; 	
    	try{    		
    		String aplicacion = Constantes.APPLICACION_MYC;
    		retorno = maestroColumnaDAO.findMaestroColumna(dominio, aplicacion);    		
    		
    	}catch(Exception ex){    		
    		LOG.info("error web service",ex);
    		ex.printStackTrace();
    	}    	    
    	return retorno;
    }
    
    @Override
    public List<MaestroColumnaDTO> buscarByDominioByAplicacion(String dominio,String aplicacion) throws Exception{
        List<MaestroColumnaDTO>  retorno = null; 	
    	try{    		
            retorno = maestroColumnaDAO.findMaestroColumna(dominio, aplicacion);    		
    	}catch(Exception ex){    		
    		LOG.info("error web service",ex);
    	}    	    
    	return retorno;
    }
    
    @Override
    public List<MaestroColumnaDTO> buscarByDescripHijos(Long IdMaestroColumna) throws Exception {
        List<MaestroColumnaDTO>  retorno = null; 	
    	try{    		
            retorno = maestroColumnaDAO.findByDescripHijos(IdMaestroColumna, Constantes.APPLICACION_MYC,Constantes.CONSTANTE_ESTADO_ACTIVO);    		
    		
    	}catch(Exception ex){    		
    		LOG.info("error buscarByDescripHijos",ex);
    	}    	    
    	return retorno;
    }
	@Override
	public List<MaestroColumnaDTO> listarTipoNormaLegal(){
	        List<MaestroColumnaDTO> listado = null;
	        try{
	        listado=maestroColumnaDAO.findTipoNormaLegal();
	        }catch(Exception e){
	            LOG.error(e.getMessage() + "error en el service.Neg");
	        }
	        return listado;
	    }
	    @Override
	    public List<MaestroColumnaDTO> listarComponente() throws Exception{
	        List<MaestroColumnaDTO> listado = null;
	        try{
	        	listado=maestroColumnaDAO.findComponente();
	        }catch(Exception e){
	            LOG.error(e.getMessage());
	        }
	        return listado;
	    }
	    @Override
	    public List<MaestroColumnaDTO> listarSigla(){
	        List<MaestroColumnaDTO> listado = null;
	        try{
	        	listado=maestroColumnaDAO.findSigla();
	        }catch(Exception e){
	            LOG.error(e.getMessage());
	        }
	        return listado;
	    }
	    @Override
	    public List<MaestroColumnaDTO> listarTipoAnexo(){
	        List<MaestroColumnaDTO> listado = null;
	        try{
	        	listado=maestroColumnaDAO.findTipoAnexo();
	        }catch(Exception e){
	            LOG.error(e.getMessage());
	        }
	        return listado;
	    }
	    @Override
	    public List<MaestroColumnaDTO> listarTemas() throws Exception{
	        List<MaestroColumnaDTO> listado = null;
	        try{
	        	listado=maestroColumnaDAO.findTemas();
	        }catch(Exception e){
	            LOG.error(e.getMessage());
	        }
	        return listado;
	    }
	    @Override
	    public List<MaestroColumnaDTO> listarCriticidad(){
	        List<MaestroColumnaDTO> listado = null;
	        try{
	        	listado=maestroColumnaDAO.findCriticidad();
	        }catch(Exception e){
	            LOG.error(e.getMessage());
	        }
	        return listado;
	    }
	    @Override
	    public List<MaestroColumnaDTO> listarNormaTecnica() throws Exception{
	        List<MaestroColumnaDTO> listado = null;
	        try{
	        	listado=maestroColumnaDAO.findNormaTecnica();
	        }catch(Exception e){
	            LOG.error(e.getMessage());
	        }
	        return listado;
	    }
}
