/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghProcTramActividad;
import gob.osinergmin.myc.domain.builder.ActividadBuilder;
import gob.osinergmin.myc.domain.builder.ProcTramActividadBuilder;
import gob.osinergmin.myc.domain.builder.ProcedimientoBuilder;
import gob.osinergmin.myc.domain.builder.ProcedimientoTramiteBuilder;
import gob.osinergmin.myc.domain.builder.TramiteActividadBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcTramActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.domain.dto.TramiteActividadDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcTramActividadFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ProcTramActividadDAO;
import gob.osinergmin.myc.service.exception.ProcTramActividadException;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.PropertyUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpiro
 */
@Service("procTramActividadDAO")
public class ProcTramActividadDAOImpl implements ProcTramActividadDAO {
    private static final Logger LOG = LoggerFactory.getLogger(ProcTramActividadDAO.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public ProcTramActividadDTO changeEstado(ProcTramActividadDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcTramActividadException{
        ProcTramActividadDTO retorno = null;
        try{
            PghProcTramActividad registroDAO = crud.find(registroDTO.getIdProcTramActi(), PghProcTramActividad.class);
            registroDAO.setEstado(registroDTO.getEstado());
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=ProcTramActividadBuilder.toProcTramActividadDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ProcTramActividadException.ERROR_EDITAR_PROC_TRAM_ACTIVIDAD),e);
            ProcTramActividadException e2 = new ProcTramActividadException(ProcTramActividadException.ERROR_EDITAR_PROC_TRAM_ACTIVIDAD,e, true);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public List<ProcTramActividadDTO> findByFilter(ProcTramActividadFilter filtro) throws ProcTramActividadException{
        List<ProcTramActividadDTO> listado;

        Query query = getFindQuery(filtro);
        listado = ProcTramActividadBuilder.toListProcTramActividadDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(ProcTramActividadFilter filtro) {
        Query query=null;
        try{
            if (filtro.getIdActividad()!= null && filtro.getIdProcedimientoTramite()!=null) {
                query = crud.getEm().createNamedQuery("PghProcTramActividad.findByIdProcedimientoTramiteIdActividad");
            }else if (filtro.getIdProcedimientoTramite()!= null) {
                query = crud.getEm().createNamedQuery("PghProcTramActividad.findByIdProcedimientoTramite");
            }else{
                query = crud.getEm().createNamedQuery("PghProcTramActividad.findAll");
            }
            
            if (filtro.getIdActividad()!= null) {
                query.setParameter("idActividad",filtro.getIdActividad());
            }
            if (filtro.getIdProcedimientoTramite()!= null) {
                query.setParameter("idProcedimientoTramite",filtro.getIdProcedimientoTramite());
            }
            if (filtro.getEstado()!= null){
                query.setParameter("estado",filtro.getEstado());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    
    @Override
    public List<ActividadDTO> findActividadByFilter(ProcTramActividadFilter filtro) throws ProcTramActividadException{
        List<ActividadDTO> listado;

        Query query = getFindQueryActividad(filtro);
        listado = ActividadBuilder.toListActividadDto(query.getResultList());

        return listado;
    }   
    
    private Query getFindQueryActividad(ProcTramActividadFilter filtro) {
        Query query=null;
        try{
            if (filtro.getIdProcedimientoTramite()!= null) {
                query = crud.getEm().createNamedQuery("MdiActividad.findByIdProcedimientoTramite");
            }else{
                query = crud.getEm().createNamedQuery("MdiActividad.findAll");
            }
            
            if (filtro.getIdProcedimientoTramite()!= null) {
                query.setParameter("idProcedimientoTramite",filtro.getIdProcedimientoTramite());
            }
            if (filtro.getEstado()!= null){
                query.setParameter("estado",filtro.getEstado());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    
    @Override
    public ProcTramActividadDTO create(ProcTramActividadDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcTramActividadException{
        LOG.info("metodo create");
        ProcTramActividadDTO retorno = null;
        try{
            //verifica idTramite-idActividad tengan relacion en CnfTramiteActividad
            List<TramiteActividadDTO> valiTramActi=valiRelacionTramiteRubro(new ProcTramActividadFilter(registroDTO.getIdProcedimientoTramite(),registroDTO.getIdActividad(),registroDTO.getEstado()));
            LOG.info("valiTramActi---->"+valiTramActi);
            if(valiTramActi.isEmpty()){
                Query query=crud.getEm().createNamedQuery("MdiActividad.findByIdActividad");
                query.setParameter("idActividad",registroDTO.getIdActividad());query.setParameter("estado",registroDTO.getEstado());
                ActividadDTO regActi=(ActividadDTO) ActividadBuilder.toListActividadDto(query.getResultList()).get(0);
                query=crud.getEm().createNamedQuery("PghProcedimientoTramite.findByIdProcedimientoTramite");
                query.setParameter("idProcedimientoTramite",registroDTO.getIdProcedimientoTramite());query.setParameter("estado",registroDTO.getEstado());
                ProcedimientoTramiteDTO regProcTram=(ProcedimientoTramiteDTO) ProcedimientoTramiteBuilder.toListProcedimientoTramiteDto(query.getResultList()).get(0);
                throw new ProcTramActividadException("Rubro no permitido en Tr&aacute;mite. "+regActi.getNombre()+" - "+regProcTram.getDescTramite()+".",null);
            }
            
            //verifica idTramite-idActividad, no exista en otro procedimiento
            List<ProcedimientoDTO> valiProc=valiExistProcConTramiteRubro(new ProcTramActividadFilter(registroDTO.getIdProcedimientoTramite(),registroDTO.getIdActividad(),registroDTO.getEstado()));
            LOG.info("valiProc---->"+valiProc);
            if(valiProc!=null && valiProc.size()>0){
                String msg="";
                if(valiProc.get(0).getItem()!=null){
                    msg=valiProc.get(0).getItem()+" - "+valiProc.get(0).getDenominacion();
                }else{
                    msg=valiProc.get(0).getDenominacion();
                }
                throw new ProcTramActividadException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Tr&aacute;mite &#8211; Rubro en el Procedimiento: "+msg+".",null);
            }

            PghProcTramActividad registroDAO = ProcTramActividadBuilder.getProcTramActividad(registroDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.create(registroDAO);
            
            retorno=ProcTramActividadBuilder.toProcTramActividadDto(registroDAO);
        }catch (ProcTramActividadException ex) {
            LOG.error("error create ProcTramActividadDAO = "+ex.getMessage());
            throw ex;
        }catch(Exception ex){
            LOG.error("error create ProcTramActividadDAO ==  "+ex.getMessage());
            ProcTramActividadException e2 = new ProcTramActividadException(ProcTramActividadException.ERROR_CREAR_PROC_TRAM_ACTIVIDAD, ex, true);
        }
        return retorno;
    }
    
    public List<ProcedimientoDTO> valiExistProcConTramiteRubro(ProcTramActividadFilter filtro){
        LOG.info("metodo validaCreateProcedimiento");
        List<ProcedimientoDTO> listProc=new ArrayList<ProcedimientoDTO>();
        //busco ProcedimientoTramite para saber idTramite
        Query query=crud.getEm().createNamedQuery("PghProcedimientoTramite.findByIdProcedimientoTramite");
        query.setParameter("idProcedimientoTramite",filtro.getIdProcedimientoTramite());
        query.setParameter("estado",filtro.getEstado());
        ProcedimientoTramiteDTO regProcTram=(ProcedimientoTramiteDTO) ProcedimientoTramiteBuilder.toListProcedimientoTramiteDto(query.getResultList()).get(0);
        //busco procedimientos con el idTramite - idActividad
        query=crud.getEm().createNamedQuery("PghProcedimiento.findProcByIdProcedimientoIdTramite");
        query.setParameter("estado",filtro.getEstado());
        query.setParameter("idTramite",regProcTram.getIdTramite());
        query.setParameter("idActividad",filtro.getIdActividad());
        listProc = ProcedimientoBuilder.toListProcedimientoDto(query.getResultList());
                    
        return listProc;
    }
    public List<TramiteActividadDTO> valiRelacionTramiteRubro(ProcTramActividadFilter filtro){
        LOG.info("metodo validaCreateProcedimiento");
        List<TramiteActividadDTO> retorno=new ArrayList<TramiteActividadDTO>();
        //busco ProcedimientoTramite para saber idTramite
        Query query=crud.getEm().createNamedQuery("PghProcedimientoTramite.findByIdProcedimientoTramite");
        query.setParameter("idProcedimientoTramite",filtro.getIdProcedimientoTramite());
        query.setParameter("estado",filtro.getEstado());
        ProcedimientoTramiteDTO regProcTram=(ProcedimientoTramiteDTO) ProcedimientoTramiteBuilder.toListProcedimientoTramiteDto(query.getResultList()).get(0);
        LOG.info("regProcTram-->"+regProcTram);
        //busco procedimientos con el idTramite - idActividad
        query=crud.getEm().createNamedQuery("PghCnfTramiteActividad.findByIdTramiteIdActividad");
        query.setParameter("estado",filtro.getEstado());
        query.setParameter("idTramite",regProcTram.getIdTramite());
        query.setParameter("idActividad",filtro.getIdActividad());
        retorno = TramiteActividadBuilder.toListTramiteActividadDto(query.getResultList());
        LOG.info("tramiActi-->"+retorno);
                    
        return retorno;
    }
}
