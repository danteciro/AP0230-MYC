/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcTramActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.in.GuardarProcedimientoInRO;
import gob.osinergmin.myc.domain.out.GuardarProcedimientoOutRO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.CnfRequProcedimientoFilter;
import gob.osinergmin.myc.domain.ui.ProcedimientoFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.business.ProcedimientoServiceNeg;
import gob.osinergmin.myc.service.dao.ActividadDAO;
import gob.osinergmin.myc.service.dao.CnfRequProcedimientoDAO;
import gob.osinergmin.myc.service.dao.ProcTramActividadDAO;
import gob.osinergmin.myc.service.dao.ProcedimientoDAO;
import gob.osinergmin.myc.service.dao.ProcedimientoTramiteDAO;
import gob.osinergmin.myc.service.dao.TramiteDAO;
import gob.osinergmin.myc.service.exception.ProcTramActividadException;
import gob.osinergmin.myc.service.exception.ProcedimientoException;
import gob.osinergmin.myc.util.Constantes;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service
public class ProcedimientoServiceNegImpl implements ProcedimientoServiceNeg {
    private static final Logger LOG = LoggerFactory.getLogger(ProcedimientoServiceNegImpl.class);
    @Inject
    private ProcedimientoDAO procedimientoDAO;
    @Inject
    private ActividadDAO actividadDAO;
    @Inject
    private ProcedimientoTramiteDAO procedimientoTramiteDAO;
    @Inject
    private ProcTramActividadDAO procTramActividadDAO;
    @Inject
    private CnfRequProcedimientoDAO cnfRequProcedimientoDAO;
    @Inject
    private TramiteDAO tramiteDAO;
    
    @Override
    @Transactional(readOnly=true)
    public GuardarProcedimientoOutRO validarDependProcedimiento(GuardarProcedimientoInRO in){
        LOG.info("neg validarDependProcedimiento");
        GuardarProcedimientoOutRO retorno=new GuardarProcedimientoOutRO();
        try{
            LOG.info("IdProcedimiento()="+in.getProcedimiento().getIdProcedimiento());
            //VALIDA TRAMITES, busco TRAMITES RETIRADOS
            boolean validaTramites=validaDependTramites(in);
            if(!validaTramites){
                retorno.setCodigoResultado(BaseConstantesOutBean.RESTRICT);
                retorno.setMensaje("Desasigne los Requisitos Espec&iacuteficos Asociados al Tramite a desasignar.");
            }else{
                boolean validaActividades=validaDependActividades(in);
                if(!validaActividades){
                    retorno.setCodigoResultado(BaseConstantesOutBean.RESTRICT);
                    retorno.setMensaje("Desasigne los Requisitos Espec&iacuteficos Asociados al Rubro a desasignar.");
                }else{
                    //VALIDA PROCEDIMIENTO, buscar requProc del procedimiento
                    List<CnfRequProcedimientoDTO> requProc=cnfRequProcedimientoDAO.find(new CnfRequProcedimientoFilter(in.getProcedimiento().getIdProcedimiento(),null,null,Constantes.CONSTANTE_ESTADO_ACTIVO));
                    if(requProc!=null && requProc.size()>0){
                        retorno.setCodigoResultado(BaseConstantesOutBean.DEPENDENCE);
                        retorno.setMensaje("Los cambios realizados al procedimiento, se aplicar&aacute;n de aqu&iacute en adelante. &#191;Confirmar si desea realizar los cambios?");
                    }else{
                        retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
                        retorno.setMensaje("&#191;Ud est&aacute; seguro de Guardar los Cambios en este Procedimiento?");
                    }
                }
            }
        }catch (Exception ex) {
            LOG.error("error guardarProcedimiento", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }
        return retorno;
    }
    
    public boolean validaDependTramites(GuardarProcedimientoInRO in){
        boolean validaTramites=true;
        try{
            List<TramiteDTO> tramRetirados=MycUtil.listTramiteNoExisteEnListTramite(tramiteDAO.find(new TramiteFilter(in.getProcedimiento().getIdProcedimiento(),Constantes.CONSTANTE_ESTADO_ACTIVO)),in.getProcedimiento().getTramites());
            LOG.info("idsTramitesRetirados->"+MycUtil.concatenaTramites(tramRetirados)+"-->"+tramRetirados);
            if(tramRetirados!=null && tramRetirados.size()>0){
                //buscar requProc de cada tramite. si uno tiene requProc asignados, se retorna validacion
                for(TramiteDTO regTramiteReti : tramRetirados){
                    LOG.info("idTramRetirado--->"+regTramiteReti.getIdTramite());
                    //buscar requProc de idTramite
                    List<CnfRequProcedimientoDTO> requProc=cnfRequProcedimientoDAO.find(new CnfRequProcedimientoFilter(in.getProcedimiento().getIdProcedimiento(),regTramiteReti.getIdTramite(),null,Constantes.CONSTANTE_ESTADO_ACTIVO));
                    LOG.info("cuenta requProc segun idTramite-->"+requProc.size());
                    if(requProc!=null && requProc.size()>0){
                        validaTramites=false;
                        break;
                    }
                }
            }
        }catch(Exception e){
            LOG.error("error validaDependTramites", e);
        }
        return validaTramites;
    }
    
    public boolean validaDependActividades(GuardarProcedimientoInRO in){
        boolean validaActividades=true;
        try{
            //2014/11/19, actualmente si se retira una actividad de un tramite, este se retirara de todos los tramites,
            //por lo que segun eso, la validacion se hace a nivel de la actividad (idAct)y procedimiento (idProc)
            //de modo q sera suficiente encontrar un requProc con el idAct para validar como rechazo a edicion
            List<ActividadDTO> actiActu=actividadDAO.find(new ActividadFilter(in.getProcedimiento().getIdProcedimiento(),Constantes.CONSTANTE_ESTADO_ACTIVO));
            String txtActiActu=MycUtil.concatenaActividades(actiActu);
            List<ActividadDTO> actiUpda=in.getProcedimiento().getActividades();
            String txtActiUpda=MycUtil.concatenaActividades(actiUpda);
            LOG.info("txtActiActu="+txtActiActu+"-txtActiUpda="+txtActiUpda);
            
            List<ActividadDTO> actiRetirados=MycUtil.listActividadNoExisteEnListActividad(actividadDAO.find(new ActividadFilter(in.getProcedimiento().getIdProcedimiento(),Constantes.CONSTANTE_ESTADO_ACTIVO)),in.getProcedimiento().getActividades());
            LOG.info("idsActividadesRetirados->"+MycUtil.concatenaActividades(actiRetirados)+"-->"+actiRetirados);
            if(actiRetirados!=null && actiRetirados.size()>0){
                //buscar requProc de cada tramite. si uno tiene requProc asignados, se retorna validacion
                for(ActividadDTO regActiReti : actiRetirados){
                    LOG.info("idActiRetirado--->"+regActiReti.getIdActividad());
                    //buscar requProc de idActividad
                    List<CnfRequProcedimientoDTO> requProc=cnfRequProcedimientoDAO.find(new CnfRequProcedimientoFilter(in.getProcedimiento().getIdProcedimiento(),null,regActiReti.getIdActividad(),Constantes.CONSTANTE_ESTADO_ACTIVO));
                    LOG.info("cuenta requProc segun idActividad-->"+requProc.size());
                    if(requProc!=null && requProc.size()>0){
                        validaActividades=false;
                        break;
                    }
                }
            }
        }catch(Exception e){
            LOG.error("error validaDependActividades", e);
        }
        return validaActividades;
    }
    
    @Override
    @Transactional(rollbackFor=ProcedimientoException.class)
    public GuardarProcedimientoOutRO editarProcedimiento(GuardarProcedimientoInRO in) throws ProcedimientoException{
        GuardarProcedimientoOutRO retorno=new GuardarProcedimientoOutRO();
        try{
            ProcedimientoDTO registro=procedimientoDAO.updateVerificado(in.getProcedimiento(),in.getUsuario());
            
            List<ProcedimientoTramiteDTO> registroProcTram=procedimientoTramiteDAO.updateVerificado(in.getProcedimiento(),in.getUsuario());
            LOG.info("tram nuevos-->"+registroProcTram);            
            
            retorno.setProcedimiento(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            ex.printStackTrace();
            LOG.error("Error en guardarProcedimiento:"+ex.getMessage());
            throw new ProcedimientoException(ex.getMessage(),null);
        }
        return retorno;
    }
    
    @Override
    @Transactional(readOnly=true)
    public ProcedimientoDTO buscarProcedimientoByFiltro(ProcedimientoFilter filtro){
        LOG.info("Neg buscarProcedimientoByFiltro");
        ProcedimientoDTO retorno=null;
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            retorno = procedimientoDAO.findById(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
        
    @Override
    @Transactional
    public GuardarProcedimientoOutRO eliminarProcedimiento(GuardarProcedimientoInRO in){
        LOG.info("NEG eliminarProcedimiento - inicio");
        GuardarProcedimientoOutRO retorno=new GuardarProcedimientoOutRO();
        try{
            //VALIDA PROCEDIMIENTO, buscar requProc del procedimiento
            List<CnfRequProcedimientoDTO> requProc=cnfRequProcedimientoDAO.find(new CnfRequProcedimientoFilter(in.getProcedimiento().getIdProcedimiento(),null,null,Constantes.CONSTANTE_ESTADO_ACTIVO));
            if(requProc!=null && requProc.size()>0){
                retorno.setCodigoResultado(BaseConstantesOutBean.RESTRICT);
                retorno.setMensaje("ELIMINACI&Oacute;N NO PERMITIDA, PROCEDIMIENTO CON REQUISITOS -> DESASIGNAR");
            }else{
                ProcedimientoDTO registro=procedimientoDAO.changeEstadoVerificado(in.getProcedimiento(),in.getUsuario());
                retorno.setProcedimiento(registro);
                retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
                retorno.setMensaje("&#191;Ud est&aacute; seguro de Guardar los Cambios en este Procedimiento?");
            }
            
            
        }catch (Exception ex) {
            LOG.error("error eliminarRequisito", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }
        LOG.info("NEG eliminarProcedimiento - fin");
        return retorno;
    }
    
    @Override
    @Transactional(rollbackFor=ProcedimientoException.class)
    public GuardarProcedimientoOutRO guardarProcedimiento(GuardarProcedimientoInRO in) throws ProcedimientoException{
        GuardarProcedimientoOutRO retorno=new GuardarProcedimientoOutRO();
        try{
            ProcedimientoDTO registro=procedimientoDAO.create(in.getProcedimiento(),in.getUsuario());
            
            List<TramiteDTO> tramites=in.getProcedimiento().getTramites();
            List<TramiteDTO> regTramites=new ArrayList<TramiteDTO>();
            LOG.info("acti-->"+in.getProcedimiento().getActividades());
            List<ActividadDTO> actividades=null;
            if(in.getProcedimiento().getActividades()!=null){
                actividades=in.getProcedimiento().getActividades();
            }
            //inserta tramites
            for (TramiteDTO maestro : tramites) {
                LOG.info("idTramite-->"+maestro.getIdTramite());
                ProcedimientoTramiteDTO pt=new ProcedimientoTramiteDTO(registro.getIdProcedimiento(),maestro.getIdTramite(),Constantes.CONSTANTE_ESTADO_ACTIVO);
                ProcedimientoTramiteDTO registradoPT=procedimientoTramiteDAO.create( pt, in.getUsuario() );
                LOG.info("PT registrado, idPro - idProcTram = "+registro.getIdProcedimiento()+" - "+registradoPT.getIdProcedimientoTramite());
                regTramites.add(new TramiteDTO(registradoPT.getIdTramite()));
                //inserta actividades
                if(actividades!=null){
                    for(ActividadDTO maestroAct : actividades){                        
                        ProcTramActividadDTO pta = new ProcTramActividadDTO(registradoPT.getIdProcedimientoTramite(),maestroAct.getIdActividad(),Constantes.CONSTANTE_ESTADO_ACTIVO);
                        ProcTramActividadDTO registradoPTA=procTramActividadDAO.create( pta, in.getUsuario() );
                        LOG.info("PTA registrado, idProTram - idAct= "+registradoPTA.getIdProcedimientoTramite()+" - "+registradoPTA.getIdActividad());
                    }
                }                
            }            
            registro.setTramites(regTramites);
            
            retorno.setProcedimiento(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en guardarProcedimiento:"+ex.getMessage());
            throw new ProcedimientoException(ex.getMessage(),null);
        }
        return retorno;
    }
    
    @Override
    public List<ProcedimientoDTO> listarProcedimiento(ProcedimientoFilter filtro, int[] cuenta){
        LOG.info("Neg listarProcedmiento");
        List<ProcedimientoDTO> retorno=null;
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            cuenta[0] = procedimientoDAO.count(filtro).intValue();
            if (cuenta[0] > 0) {
                retorno = procedimientoDAO.find(filtro);
                LOG.info("cuenta -size: "+retorno.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public List<ActividadDTO> listarActividadProcedimiento(ActividadFilter filtro, int[] cuenta){
        LOG.info("Neg listarActividadProcedimiento");
        List<ActividadDTO> retorno=null;
        try{
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            cuenta[0] = actividadDAO.count(filtro).intValue();
            if (cuenta[0] > 0) {
                retorno = actividadDAO.find(filtro);
                LOG.info("cuenta -size: "+retorno.size());
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
}
