/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.MdiMaestroTabla;
import gob.osinergmin.myc.domain.builder.MaestroTablaBuilder;
import gob.osinergmin.myc.domain.dto.MaestroTablaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroTablaFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.MaestroTablaDAO;
import gob.osinergmin.myc.service.exception.MaestroTablaException;
import gob.osinergmin.myc.util.Constantes;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service("maestroTablaDAO")
public class MaestroTablaDAOImpl implements MaestroTablaDAO {
    private static final Logger LOG = LoggerFactory.getLogger(MaestroTablaDAOImpl.class);
    @Inject
    private CrudDAO crud;

    @Override
    @Transactional(readOnly=true)
    public List<MaestroTablaDTO> findDominios(){
        LOG.info("entro findDominios");
        List<MaestroTablaDTO> listaMaestroTablaDTO = null;
        try {                	
                List<MdiMaestroTabla> listaMaestroColumna = null;
                listaMaestroColumna = crud.findByNamedQuery("MdiMaestroTabla.findDominio");       	
                listaMaestroTablaDTO = MaestroTablaBuilder.toListMaestroTablaDtoRef(listaMaestroColumna);
        } catch (Exception e) {  
                LOG.error("Error findDominios : ", e);
        }
        return listaMaestroTablaDTO;
    }
    @Override
    @Transactional(readOnly=true)
    public List<MaestroTablaDTO> findAplicaciones(){
        LOG.info("entro findAplicaciones");
        List<MaestroTablaDTO> listaMaestroTablaDTO = null;
        try {                	
                List<MdiMaestroTabla> listaMaestroColumna = null;
                listaMaestroColumna = crud.findByNamedQuery("MdiMaestroTabla.findAplicacion");       	
                listaMaestroTablaDTO = MaestroTablaBuilder.toListMaestroTablaDto(listaMaestroColumna);
        } catch (Exception e) {  
                LOG.error("Error findAplicaciones : ", e);
        }
        return listaMaestroTablaDTO;
    }
    
    @Override
    public MaestroTablaDTO create(MaestroTablaDTO maestroTablaDTO,UsuarioDTO usuarioDTO) throws MaestroTablaException{
        MaestroTablaDTO retorno = null;
        try{
            List<MaestroTablaDTO> listaValida= find(new MaestroTablaFilter(maestroTablaDTO.getAplicacion(),maestroTablaDTO.getDominio()));
            if(!listaValida.isEmpty()){
                throw new MaestroTablaException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Grupo de Negocio.",null);
            }
            
            MdiMaestroTabla registro=MaestroTablaBuilder.getMdiMaestroTabla(maestroTablaDTO);
            registro.setDatosAuditoria(usuarioDTO);
            crud.create(registro);
            retorno = MaestroTablaBuilder.toMaestroTablaDto(registro);
        }catch (MaestroTablaException ex) {
            LOG.error("error create TramiteDAO = "+ex.getMessage());
            throw ex;
        }catch(Exception ex){
            LOG.error("error create TramiteDAO ==  "+ex.getMessage());
            MaestroTablaException e2 = new MaestroTablaException(MaestroTablaException.ERROR_CREAR_MAESTRO_TABLA, ex, true);
            throw e2;
        }
        return retorno;
    }
    @Override
    public MaestroTablaDTO update(MaestroTablaDTO maestroTablaDTO,UsuarioDTO usuarioDTO) throws MaestroTablaException{
        MaestroTablaDTO retorno = null;
        try{
            MdiMaestroTabla registro=MaestroTablaBuilder.getMdiMaestroTabla(maestroTablaDTO);
            registro.setDatosAuditoria(usuarioDTO);
            crud.update(registro);
            retorno = MaestroTablaBuilder.toMaestroTablaDto(registro);
        }catch(Exception ex){
            LOG.error("Error en update",ex);
        }
        return retorno;
    }
    
    public List<MaestroTablaDTO> find(MaestroTablaFilter filtro) throws MaestroTablaException{
        List<MaestroTablaDTO> retorno=null;
        try{
            Query query = getFindQuery(filtro);
            retorno = MaestroTablaBuilder.toListMaestroTablaDto(query.getResultList());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    private Query getFindQuery(MaestroTablaFilter filtro) {
        Query query=null;
        try{
            if(filtro.getAplicacion()!= null && filtro.getDominio()!=null){
                query = crud.getEm().createNamedQuery("MdiMaestroTabla.findByAplicacionAndDominio");
            }else {
                query = crud.getEm().createNamedQuery("MdiMaestroTabla.findAll");
            }
            
            if (filtro.getAplicacion()!= null) {
                query.setParameter("aplicacion",filtro.getAplicacion().toUpperCase());
            }
            if (filtro.getDominio()!= null) {
                query.setParameter("dominio",filtro.getDominio().toUpperCase());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    
    @Override
	@Transactional(readOnly=true)
	public List<MaestroTablaDTO> findDominio(MaestroTablaFilter filtro) {
		LOG.info("entro findDominios");
        List<MaestroTablaDTO> listaMaestroTablaDTO = null;
        try {                	
                Query query = crud.getEm().createNamedQuery("MdiMaestroTabla.findDominios");
                if(filtro.getDominio()!=null){
                    query.setParameter("dominio","%"+StringUtil.removeBlank(filtro.getDominio().toUpperCase())+"%");
                }else{
                    query.setParameter("dominio","%");
                }
                if(filtro.getDescripcion()!=null){
                    query.setParameter("descripcion","%"+StringUtil.removeBlank(filtro.getDescripcion().toUpperCase())+"%");
                }else{
                    query.setParameter("descripcion","%");
                }
                
                
                listaMaestroTablaDTO = MaestroTablaBuilder.toListMaestroTablaDtoRef(query.getResultList());
        } catch (Exception e) {  
                LOG.error("Error findDominios : ", e);
        }
        return listaMaestroTablaDTO;
	}
}
