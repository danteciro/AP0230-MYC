package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghObligacionTipo;
import gob.osinergmin.myc.domain.PghParametroDinamico;
import gob.osinergmin.myc.domain.builder.ObligacionTipoBuilder;
import gob.osinergmin.myc.domain.builder.ParametroDinamicoBuilder;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ObligacionTipoFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ObligacionTipoDAO;
import gob.osinergmin.myc.service.exception.ObligacionTipoException;
import gob.osinergmin.myc.service.exception.ParametroException;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.PropertyUtils;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("ObligacionTipoDAO")
public class ObligacionTipoDAOImpl implements  ObligacionTipoDAO{

    private static final Logger LOG = LoggerFactory.getLogger(ObligacionTipoDAOImpl.class);
    @Inject
    private CrudDAO crud;    
    
    public List<ObligacionTipoDTO> findValida(ObligacionTipoFilter filtro) {
        List<ObligacionTipoDTO> listado=null;
        Query query = crud.getEm().createNamedQuery("PghObligacionTipo.findValida");
        query.setParameter("estado",filtro.getEstado());
        query.setParameter("nombre",filtro.getNombre().toUpperCase());
        listado = ObligacionTipoBuilder.toListObligacionTipoDto(query.getResultList());
        return listado;
    }
    
    @Override
    public List<ObligacionTipoDTO> listarObligacionTipo(ObligacionTipoFilter filtro) {
        List<ObligacionTipoDTO> listado=null;

        Query query = getFindQuery(filtro);       
     

        listado = ObligacionTipoBuilder.toListObligacionTipoDto(query.getResultList());

        return listado;
    }
    @Override
    public List<ObligacionTipoDTO> obtenerObligacionTipo(ObligacionTipoFilter filtro) {
        List<ObligacionTipoDTO> listado=null;

        Query query = getFindQuery(filtro);
        
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = ObligacionTipoBuilder.toListObligacionTipoDto(query.getResultList());

        return listado;
    }
    
	@Override
	public Long count(ObligacionTipoFilter filtro){
		 Query query = getFindQuery(filtro);
		 List<PghObligacionTipo> lstObligacionTipo= query.getResultList();
		 if(lstObligacionTipo == null || lstObligacionTipo.size() == 0)
			 return 0L;
		 
	     return new Long(lstObligacionTipo.size());
	}
	
    private Query getFindQuery(ObligacionTipoFilter filtro) {
        Query query=null;
        try{
        	 
        	 query =crud.getEm().createNamedQuery("PghObligacionTipo.findAll");
            if(filtro.getEstado()!=null){
                query.setParameter("estado",filtro.getEstado());
            }
            query.setParameter("nombre","%"+StringUtil.removeBlank(filtro.getNombre().toUpperCase())+"%");
        }catch(Exception ex){
            LOG.error("Error getFindQuery",ex);
        }
        return query;
    }
	 
    @Override
    public ObligacionTipoDTO create(ObligacionTipoDTO obligacionTipoDTO,UsuarioDTO userDTO) throws ObligacionTipoException {
        ObligacionTipoDTO retorno =null;
	try{
            List<ObligacionTipoDTO> listaValida=findValida(new ObligacionTipoFilter(obligacionTipoDTO.getNombre(),Constantes.CONSTANTE_ESTADO_ACTIVO));
            if(!listaValida.isEmpty()){
                throw new ObligacionTipoException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Tipo Obligaci&oacute;n.",null);
            }
            
            PghObligacionTipo ObligacionTipoDAO= ObligacionTipoBuilder.getObligacionTipo(obligacionTipoDTO);
            ObligacionTipoDAO.setDatosAuditoria(userDTO);
            crud.create(ObligacionTipoDAO);
            retorno = ObligacionTipoBuilder.toObligacionTipoDto(ObligacionTipoDAO);
        }catch (ObligacionTipoException ex) {
            LOG.error("error create = ",ex);
            throw ex;
        }catch(Exception e){
            LOG.error("error create ==  ",e);
            ObligacionTipoException e2 = new ObligacionTipoException(ObligacionTipoException.ERROR_CREAR_OBLIGACION_TIPO, e, true);
            throw e2;
        }
        return retorno;
    }
		
    @Override
    public ObligacionTipoDTO changeEstado(ObligacionTipoDTO obligacionTipoDTO,UsuarioDTO userDTO) throws ObligacionTipoException{
        ObligacionTipoDTO retorno =null;
        try{
            Map<String, Object> valida= validaEliminarObligacionTipo(obligacionTipoDTO.getIdObligacionTipo());
            
            if(valida.get("rpta").toString().equals("0")){
                throw new ObligacionTipoException(valida.get("msje").toString(),null);
            }
            
            PghObligacionTipo ObligacionTipoDAO=crud.find(obligacionTipoDTO.getIdObligacionTipo(), PghObligacionTipo.class);
            ObligacionTipoDAO.setDatosAuditoria(userDTO);
            ObligacionTipoDAO.setEstado(obligacionTipoDTO.getEstado());
            crud.update(ObligacionTipoDAO);
            retorno = ObligacionTipoBuilder.toObligacionTipoDto(ObligacionTipoDAO);
        }catch (ObligacionTipoException ex) {
            LOG.error("error changeState = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error changeState... ",ex);
            ObligacionTipoException e2 = new ObligacionTipoException(ObligacionTipoException.ERROR_ELIMINAR_OBLIGACION_TIPO, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public Map<String, Object> validaEliminarObligacionTipo(Long idObligacionTipo){
        LOG.info("procesando validaEliminarObligacionTipo");
        Map<String,Object> retorno = new HashMap<String,Object>();
        try{
            String hql,rpta="1",msje="";
            Query query=null;
            
            //verifica que la etapa no tenga un hijo-Tramite
            if(rpta.equals("1")){
                hql="select t from PghProcesoObligacionTipo t where t.estado=:estado and t.pghObligacionTipo.idObligacionTipo=:idObligacionTipo ";
                query = crud.getEm().createQuery(hql);
                query.setParameter("estado", Constantes.CONSTANTE_ESTADO_ACTIVO);query.setParameter("idObligacionTipo", idObligacionTipo);
                if(!query.getResultList().isEmpty()){
                    rpta="0";
                    msje="No se puede eliminar Obligaci&oacute;n Tipo, mientras este siendo usada en Proceso - Obligaci&oacute;n Tipo.";
                }
            }
            
            retorno.put("rpta",rpta);
            retorno.put("msje",msje);
        }catch(Exception ex){
            LOG.error("Error en validaEliminarObligacionTipo ",ex);
        }
        return retorno;
    }

    @Override
    public ObligacionTipoDTO editar(ObligacionTipoDTO obligacionTipoDTO,UsuarioDTO userDTO) throws ObligacionTipoException {
        ObligacionTipoDTO retorno =null;
        try{
            List<ObligacionTipoDTO> listaValida=findValida(new ObligacionTipoFilter(obligacionTipoDTO.getNombre(),Constantes.CONSTANTE_ESTADO_ACTIVO));
            if(!listaValida.isEmpty() && !listaValida.get(0).getIdObligacionTipo().equals(obligacionTipoDTO.getIdObligacionTipo())){
                throw new ObligacionTipoException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Tipo Obligaci&oacute;n.",null);
            }
            
            PghObligacionTipo ObligacionTipoDAO= ObligacionTipoBuilder.getObligacionTipo(obligacionTipoDTO);
            ObligacionTipoDAO.setDatosAuditoria(userDTO);
            crud.update(ObligacionTipoDAO);
            retorno = ObligacionTipoBuilder.toObligacionTipoDto(ObligacionTipoDAO);
        }catch (ObligacionTipoException ex) {
            LOG.error("error editar = ",ex);
            throw ex;
        }catch(Exception e){
            LOG.error("error editar ==  ",e);
            ObligacionTipoException e2 = new ObligacionTipoException(ObligacionTipoException.ERROR_EDITAR_OBLIGACION_TIPO, e, true);
            throw e2;
        }
        return retorno;
    }

}
