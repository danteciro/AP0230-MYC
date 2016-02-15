/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.PghProcedimiento;
import gob.osinergmin.myc.domain.PghProcedimientoTramite;
import gob.osinergmin.myc.domain.PghTramite;
import gob.osinergmin.myc.domain.builder.ProcedimientoTramiteBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcTramActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcTramActividadFilter;
import gob.osinergmin.myc.domain.ui.ProcedimientoTramiteFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ProcTramActividadDAO;
import gob.osinergmin.myc.service.dao.ProcedimientoTramiteDAO;
import gob.osinergmin.myc.service.dao.TramiteDAO;
import gob.osinergmin.myc.service.exception.ProcedimientoTramiteException;
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
@Service("procedimientoTramiteDAO")
public class ProcedimientoTramiteDAOImpl implements ProcedimientoTramiteDAO {
    private static final Logger LOG = LoggerFactory.getLogger(ProcedimientoTramiteDAO.class);
    @Inject
    private CrudDAO crud;
    @Inject
    private TramiteDAO tramiteDAO;
    @Inject 
    private ProcTramActividadDAO procTramActividadDAO;
    
    @Override
    public List<ProcedimientoTramiteDTO> updateVerificado(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoTramiteException{
        List<ProcedimientoTramiteDTO> retorno=new ArrayList<ProcedimientoTramiteDTO>();
        try{
            //listar datos de= tramites, actividades
            //tramAct tramites ACTuales existentes en BD
            //tramUpd tramites para el UPDate
            List<TramiteDTO> tramAct=tramiteDAO.find(new TramiteFilter(registroDTO.getIdProcedimiento(),Constantes.CONSTANTE_ESTADO_ACTIVO));
            List<TramiteDTO> tramUpd=registroDTO.getTramites();
            String txtTramAct=MycUtil.concatenaTramites(tramAct);
            String txtTramUpd=MycUtil.concatenaTramites(tramUpd);
            LOG.info("txtTramAct-txtTramUpd---->"+txtTramAct+"-"+txtTramUpd);
            List<ActividadDTO> actiUpd=registroDTO.getActividades();
            String txtActiUpd=MycUtil.concatenaActividades(actiUpd);
                        
            //SI SE MODIFICO TRAMITES
            if(!txtTramAct.equals(txtTramUpd)){
                LOG.info("SE PROCEDE A ACTUALIZAR PROCEDIMIENTO TRAMITE");
                //COMPARO UPD(vienen por Update) con ACT(actuales en la base de batos), 
                //SE INSERTAN, porq la diferencia serian los NUEVOS
                for(TramiteDTO regTramUpd : tramUpd){
                    boolean existe=MycUtil.existIdTramiteEnLista(regTramUpd.getIdTramite(),tramAct);
                    LOG.info("comparacion tramUPD--->"+regTramUpd.getIdTramite()+"=="+existe);
                    //si NO EXISTE, existe=false, inserto ProcedimientoTramiteDTO con las actividades (ProcTramAct)
                    if(!existe){
                        LOG.info("TramNUEVO-->"+regTramUpd.getIdTramite());
                        //registra tramite
                        ProcedimientoTramiteDTO procTramReg=create(new ProcedimientoTramiteDTO(registroDTO.getIdProcedimiento(), regTramUpd.getIdTramite(), Constantes.CONSTANTE_ESTADO_ACTIVO), usuarioDTO);
                        retorno.add(procTramReg);
                        //registra actividades
                        if(actiUpd!=null){
                            for(ActividadDTO regActiUpd : actiUpd){                        
                                ProcTramActividadDTO registradoPTA=procTramActividadDAO.create( new ProcTramActividadDTO(procTramReg.getIdProcedimientoTramite(),regActiUpd.getIdActividad(),Constantes.CONSTANTE_ESTADO_ACTIVO), usuarioDTO );
                                LOG.info("PTA registrado, idProTram - idAct= "+registradoPTA.getIdProcedimientoTramite()+" - "+registradoPTA.getIdActividad());
                            }
                        }
                    }
                }
                //COMPARO ACT(actuales en la base de batos) con UPD(vienen por Update), 
                //SE RETIRAN, pq la diferencia serian los q se estan deshabilitando
                for(TramiteDTO regTramAct : tramAct){
                    boolean existe=MycUtil.existIdTramiteEnLista(regTramAct.getIdTramite(),tramUpd);
                    LOG.info("comparacion tramACT--->"+regTramAct.getIdTramite()+"=="+existe);
                    //si NO EXISTE, existe=false, retiro ProcedimientoTramiteDTO con las actividades (ProcTramAct)
                    if(!existe){
                        LOG.info("TramRETIRADO-->"+regTramAct.getIdTramite());
                        //retiro tramite con actividades
                        //busco idProcTram, segun idProc + idTram (regTramUpd)
                        ProcedimientoTramiteDTO procTramAct=find(new ProcedimientoTramiteFilter(registroDTO.getIdProcedimiento(), regTramAct.getIdTramite(), Constantes.CONSTANTE_ESTADO_ACTIVO)).get(0);
                        LOG.info("IdPROCTramRETIRADO-->"+procTramAct.getIdProcedimientoTramite());
                        procTramAct.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                        ProcedimientoTramiteDTO procTramReti=changeEstado(procTramAct,usuarioDTO);
                        List<ActividadDTO> actiAct=procTramActividadDAO.findActividadByFilter(new ProcTramActividadFilter(procTramReti.getIdProcedimientoTramite(),Constantes.CONSTANTE_ESTADO_ACTIVO));
                        String txtActiAct=MycUtil.concatenaActividades(actiAct);
                        LOG.info("txtActiAct-->"+txtActiAct);
                        if(!txtActiAct.equals("")){
                            //retiro procTramActis
                            List<ProcTramActividadDTO> procTramActiAct=procTramActividadDAO.findByFilter(new ProcTramActividadFilter(procTramReti.getIdProcedimientoTramite(),Constantes.CONSTANTE_ESTADO_ACTIVO));
                            for(ProcTramActividadDTO regProcTramActiAct : procTramActiAct){
                                regProcTramActiAct.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                                ProcTramActividadDTO regProcTramActiReti=procTramActividadDAO.changeEstado(regProcTramActiAct,usuarioDTO);
                                LOG.info("IdProcTramActRETIRADO-->"+regProcTramActiReti.getIdProcTramActi());
                            }
                        }
                    }
                }
            }
            //COMPARO tramUPD CON tramACT, y solo en los que coinciden valido las actividades, si se agregan o se retiran actividades
            //no valido los que no coinciden, pq esos ya fueron tratados lineas arriba.
            //COMPARO UPD(vienen por Update) con ACT(actuales en la base de batos), si es vicerversa seria los mismo , pq solo tratare los repetidos
            for(TramiteDTO regTramUpd : tramUpd){
                boolean existe=MycUtil.existIdTramiteEnLista(regTramUpd.getIdTramite(),tramAct);
                LOG.info("comparacion DE tram IGUALES UPD y ACT--->"+regTramUpd.getIdTramite()+"=="+existe);
                //SI EXISTE, actualizo actividades (ProcTramActi)
                if(existe){
                    LOG.info("TramREPETIDO-->"+regTramUpd.getIdTramite());
                    //busco idProcTram, segun idProc + idTram (regTramUpd)
                    ProcedimientoTramiteDTO procTramAct=find(new ProcedimientoTramiteFilter(registroDTO.getIdProcedimiento(), regTramUpd.getIdTramite(), Constantes.CONSTANTE_ESTADO_ACTIVO)).get(0);
                    LOG.info("IdPROCTramREPETIDO-->"+procTramAct.getIdProcedimientoTramite());
                    List<ActividadDTO> actiAct=procTramActividadDAO.findActividadByFilter(new ProcTramActividadFilter(procTramAct.getIdProcedimientoTramite(),Constantes.CONSTANTE_ESTADO_ACTIVO));
                    String txtActiAct=MycUtil.concatenaActividades(actiAct);
                    LOG.info("txtActiAct-->"+txtActiAct+"lista-->"+actiAct);
                    if(!txtActiAct.equals(txtActiUpd)){
                        //inserto procTramActis
                        if(actiUpd!=null){
                            for(ActividadDTO regActiUpd : actiUpd){
                                boolean existeActi=MycUtil.existIdActividadEnLista(regActiUpd.getIdActividad(),actiAct);
                                if(!existeActi){
                                    ProcTramActividadDTO registradoPTA=procTramActividadDAO.create( new ProcTramActividadDTO(procTramAct.getIdProcedimientoTramite(),regActiUpd.getIdActividad(),Constantes.CONSTANTE_ESTADO_ACTIVO), usuarioDTO );
                                    LOG.info("IdProcTramActREGISTRADO, idProTram - idAct= "+registradoPTA.getIdProcedimientoTramite()+" - "+registradoPTA.getIdActividad());
                                }
                            }
                        }
                        //retiro procTramActis
                        for(ActividadDTO regActiAct : actiAct){
                            boolean existeActi=MycUtil.existIdActividadEnLista(regActiAct.getIdActividad(),actiUpd);
                            if(!existeActi){
                                List<ProcTramActividadDTO> procTramActiAct=procTramActividadDAO.findByFilter(new ProcTramActividadFilter(procTramAct.getIdProcedimientoTramite(),regActiAct.getIdActividad(),Constantes.CONSTANTE_ESTADO_ACTIVO));
                                for(ProcTramActividadDTO regProcTramActiAct : procTramActiAct){
                                    regProcTramActiAct.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                                    ProcTramActividadDTO regProcTramActiReti=procTramActividadDAO.changeEstado(regProcTramActiAct,usuarioDTO);
                                    LOG.info("IdProcTramActRETIRADO-->"+regProcTramActiReti.getIdProcTramActi());
                                }
                            }
                        }
                        
                    }
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
            LOG.error("ERROR updateVerificado ProcedimientoTramiteDAO ------>"+e.getMessage());
            ProcedimientoTramiteException e2 = new ProcedimientoTramiteException(e.getMessage(), null);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public ProcedimientoTramiteDTO changeEstado(ProcedimientoTramiteDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoTramiteException{
        ProcedimientoTramiteDTO retorno = null;
        try{
            PghProcedimientoTramite registroDAO = crud.find(registroDTO.getIdProcedimientoTramite(), PghProcedimientoTramite.class);
            registroDAO.setEstado(registroDTO.getEstado());
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=ProcedimientoTramiteBuilder.toProcedimientoTramiteDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ProcedimientoTramiteException.ERROR_EDITAR_PROCEDIMIENTO_TRAMITE),e);
            ProcedimientoTramiteException e2 = new ProcedimientoTramiteException(ProcedimientoTramiteException.ERROR_EDITAR_PROCEDIMIENTO_TRAMITE,e, true);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public List<ProcedimientoTramiteDTO> find(ProcedimientoTramiteFilter filtro) throws ProcedimientoTramiteException{
        List<ProcedimientoTramiteDTO> listado;

        Query query = getFindQuery(filtro);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = ProcedimientoTramiteBuilder.toListProcedimientoTramiteDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(ProcedimientoTramiteFilter filtro) {
        Query query=null;
        try{
            if (filtro.getIdProcedimiento()!= null && filtro.getIdTramite()!= null) {
                query = crud.getEm().createNamedQuery("PghProcedimientoTramite.findByIdProcedimientoIdTramite");
            }else {
                query = crud.getEm().createNamedQuery("PghProcedimientoTramite.findAll");
            }
            
            if (filtro.getIdProcedimiento()!= null) {
                query.setParameter("idProcedimiento",new PghProcedimiento(filtro.getIdProcedimiento()));
            }
            if (filtro.getIdTramite()!= null) {
                query.setParameter("idTramite",new PghTramite(filtro.getIdTramite()));
            }
            if (filtro.getEstado()!= null) {
                query.setParameter("estado",filtro.getEstado());
            }
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    
    @Override
    public ProcedimientoTramiteDTO create(ProcedimientoTramiteDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoTramiteException{
        ProcedimientoTramiteDTO retorno = null;
        try{
            PghProcedimientoTramite registroDAO = ProcedimientoTramiteBuilder.getProcedimientoTramite(registroDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.create(registroDAO);
            
            retorno=ProcedimientoTramiteBuilder.toProcedimientoTramiteDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ProcedimientoTramiteException.ERROR_CREAR_PROCEDIMIENTO_TRAMITE),e);
            ProcedimientoTramiteException e2 = new ProcedimientoTramiteException(ProcedimientoTramiteException.ERROR_CREAR_PROCEDIMIENTO_TRAMITE,e, true);
            throw e2;
        }
        return retorno;
    }
}
