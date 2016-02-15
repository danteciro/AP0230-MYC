/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghProcedimiento;
import gob.osinergmin.myc.domain.builder.ProcedimientoBuilder;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcTramActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoTramiteDTO;
import gob.osinergmin.myc.domain.dto.TramiteDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ProcTramActividadFilter;
import gob.osinergmin.myc.domain.ui.ProcedimientoFilter;
import gob.osinergmin.myc.domain.ui.ProcedimientoTramiteFilter;
import gob.osinergmin.myc.domain.ui.TramiteFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ProcTramActividadDAO;
import gob.osinergmin.myc.service.dao.ProcedimientoDAO;
import gob.osinergmin.myc.service.dao.ProcedimientoTramiteDAO;
import gob.osinergmin.myc.service.dao.TramiteDAO;
import gob.osinergmin.myc.service.exception.ProcedimientoException;
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
@Service("procedimientoDAO")
public class ProcedimientoDAOImpl implements ProcedimientoDAO{
    private static final Logger LOG = LoggerFactory.getLogger(ProcedimientoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    @Inject
    private ProcedimientoTramiteDAO procedimientoTramiteDAO;
    @Inject
    private TramiteDAO tramiteDAO;
    @Inject
    private ProcTramActividadDAO procTramActividadDAO;
    
    @Override
    public ProcedimientoDTO updateVerificado(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoException{
        ProcedimientoDTO retorno = null;
        try{
            //verifica Item-Denominacion no existan en algun Procedimiento
            List<ProcedimientoDTO> valiProc=valiProcItemDenominacion(registroDTO);
            LOG.info("valiProc---->"+valiProc);
            if(!valiProc.isEmpty()){
                if(!valiProc.get(0).getIdProcedimiento().equals(registroDTO.getIdProcedimiento())){//comparo con el primero "get(0)" porque siempre deberia solo regresar maximo un registro
                    throw new ProcedimientoException("Ya existe otro Procedimiento con el Item y Denomicaci&oacute;n especificados",null);
                }
            }
                        
            PghProcedimiento regAct = crud.find(registroDTO.getIdProcedimiento(), PghProcedimiento.class);
            PghProcedimiento regUpd = ProcedimientoBuilder.getProcedimiento(registroDTO);
            boolean verIgualProc=verificaIgualProc(regUpd,regAct);
            LOG.info("verIgualProc--->"+verIgualProc);
            if(!verIgualProc){
                LOG.info("SE PROCEDE A ACTUALIZAR PROCEDIMIENTO");
                regUpd.setEstado(registroDTO.getEstado());
                regUpd.setDatosAuditoria(usuarioDTO);
                crud.update(regUpd);
            }
            
            retorno=ProcedimientoBuilder.toProcedimientoDto(regUpd);
        }catch (ProcedimientoException ex) {
            LOG.error("error updateVerificado ProcedimientoDAO = "+ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }catch(Exception ex){
            LOG.error("error updateVerificado ProcedimientoDAO ==  "+ex.getMessage());
            ex.printStackTrace();
            ProcedimientoException e2 = new ProcedimientoException(ProcedimientoException.ERROR_EDITAR_PROCEDIMIENTO, ex, true);
        }
        return retorno;
    }
    
    private boolean verificaIgualProc(PghProcedimiento regUpd,PghProcedimiento regAct){
        boolean retorno=true;
        //comparacion Act con Upd
        if(!regAct.getDenominacion().equals(regUpd.getDenominacion())){
            LOG.info("act-upd-getDenominacion->"+regAct.getDenominacion()+"-"+regUpd.getDenominacion());
            retorno=false;
        }
        if(!regAct.getBaseLegal().equals(regUpd.getBaseLegal())){
            LOG.info("act-upd-getBaseLegal->"+regAct.getBaseLegal()+"-"+regUpd.getBaseLegal());
            retorno=false;
        }
        Float dtAct=new Float(0);
        Float dtUpd=new Float(0);
        if(regAct.getDerechoTramitacion()!=null){
            dtAct=regAct.getDerechoTramitacion();
        }
        if(regUpd.getDerechoTramitacion()!=null){
            dtUpd=regUpd.getDerechoTramitacion();
        }
        if(!dtAct.equals(dtUpd)){
            LOG.info("act-upd-getDerechoTramitacion->"+regAct.getDerechoTramitacion()+"-"+regUpd.getDerechoTramitacion());
            retorno=false;
        }
        String itemAct, itemUpd;
        if(regAct.getItem()!=null){itemAct=regAct.getItem();}else{itemAct="";}
        if(regUpd.getItem()!=null){itemUpd=regUpd.getItem();}else{itemUpd="";}
        if(!itemAct.equals(itemUpd)){
            LOG.info("act-upd-getItem->"+itemAct+"-"+itemUpd);
            retorno=false;
        }
        String npAct, npUpd;
        if(regAct.getNotaProcedimiento()!=null){npAct=regAct.getNotaProcedimiento();}else{npAct="";}
        if(regUpd.getNotaProcedimiento()!=null){npUpd=regUpd.getNotaProcedimiento();}else{npUpd="";}
        if(!npAct.equals(npUpd)){
            LOG.info("act-upd-getNotaProcedimiento->"+npAct+"-"+npUpd);
            retorno=false;
        }
        if(!regAct.getPlazoResolver().equals(regUpd.getPlazoResolver())){
            LOG.info("act-upd-getPlazoResolver->"+regAct.getPlazoResolver()+"-"+regUpd.getPlazoResolver());
            retorno=false;
        }
        Long actIdAR=new Long(0);
        if(regAct.getIdAnexoRrh()!=null && regAct.getIdAnexoRrh().getIdMaestroColumna()!=null){
            actIdAR=regAct.getIdAnexoRrh().getIdMaestroColumna();
        }
        Long updIdAR=new Long(0);
        if(regUpd.getIdAnexoRrh()!=null && regUpd.getIdAnexoRrh().getIdMaestroColumna()!=null){
            updIdAR=regUpd.getIdAnexoRrh().getIdMaestroColumna();
        }
        if(!actIdAR.equals(updIdAR)){
            LOG.info("act-upd-getIdAnexoRrh->"+actIdAR+"-"+updIdAR);
            retorno=false;
        }
        Long actIdApel=new Long(0);
        if(regAct.getIdApelacion()!=null && regAct.getIdApelacion().getIdMaestroColumna()!=null){
            actIdApel=regAct.getIdApelacion().getIdMaestroColumna();
        }
        Long updIdApel=new Long(0);
        if(regUpd.getIdApelacion()!=null && regUpd.getIdApelacion().getIdMaestroColumna()!=null){
            updIdApel=regUpd.getIdApelacion().getIdMaestroColumna();
        }
        if(!actIdApel.equals(updIdApel)){
            LOG.info("act-upd-getIdApelacion->"+actIdApel+"-"+updIdApel);
            retorno=false;
        }        
        Long actIdAC=new Long(0);
        if(regAct.getIdAutoridadCompetente()!=null && regAct.getIdAutoridadCompetente().getIdMaestroColumna()!=null){
            actIdAC=regAct.getIdAutoridadCompetente().getIdMaestroColumna();
        }
        Long updIdAC=new Long(0);
        if(regUpd.getIdAutoridadCompetente()!=null && regUpd.getIdAutoridadCompetente().getIdMaestroColumna()!=null){
            updIdAC=regUpd.getIdAutoridadCompetente().getIdMaestroColumna();
        }
        if(!actIdAC.equals(updIdAC)){
            LOG.info("act-upd-getIdAutoridadCompetente->"+actIdAC+"-"+updIdAC);
            retorno=false;
        }        
        Long actIdCal=new Long(0);
        if(regAct.getIdCalificacion()!=null && regAct.getIdCalificacion().getIdMaestroColumna()!=null){
            actIdCal=regAct.getIdCalificacion().getIdMaestroColumna();
        }
        Long updIdCal=new Long(0);
        if(regUpd.getIdCalificacion()!=null && regUpd.getIdCalificacion().getIdMaestroColumna()!=null){
            updIdCal=regUpd.getIdCalificacion().getIdMaestroColumna();
        }
        if(!actIdCal.equals(updIdCal)){
            LOG.info("act-upd-getIdCalificacion->"+actIdCal+"-"+updIdCal);
            retorno=false;
        }
        Long actIdIP=new Long(0);
        if(regAct.getIdInicioProcedimiento()!=null && regAct.getIdInicioProcedimiento().getIdMaestroColumna()!=null){
            actIdIP=regAct.getIdInicioProcedimiento().getIdMaestroColumna();
        }
        Long updIdIP=new Long(0);
        if(regUpd.getIdInicioProcedimiento()!=null && regUpd.getIdInicioProcedimiento().getIdMaestroColumna()!=null){
            updIdIP=regUpd.getIdInicioProcedimiento().getIdMaestroColumna();
        }
        if(!actIdIP.equals(updIdIP)){
            LOG.info("act-upd-getIdInicioProcedimiento->"+actIdIP+"-"+updIdIP);
            retorno=false;
        }        
        Long actIdRec=new Long(0);
        if(regAct.getIdReconsideracion()!=null && regAct.getIdReconsideracion().getIdMaestroColumna()!=null){
            actIdRec=regAct.getIdReconsideracion().getIdMaestroColumna();
        }
        Long updIdRec=new Long(0);
        if(regUpd.getIdReconsideracion()!=null && regUpd.getIdReconsideracion().getIdMaestroColumna()!=null){
            updIdRec=regUpd.getIdReconsideracion().getIdMaestroColumna();
        }
        if(!actIdRec.equals(updIdRec)){
            LOG.info("act-upd-getIdReconsideracion->"+actIdRec+"-"+updIdRec);
            retorno=false;
        }        
        Long actIdSA=new Long(0);
        if(regAct.getIdSilencioAdministrativo()!=null && regAct.getIdSilencioAdministrativo().getIdMaestroColumna()!=null){
            actIdSA=regAct.getIdSilencioAdministrativo().getIdMaestroColumna();
        }
        Long updIdSA=new Long(0);
        if(regUpd.getIdSilencioAdministrativo()!=null && regUpd.getIdSilencioAdministrativo().getIdMaestroColumna()!=null){
            updIdSA=regUpd.getIdSilencioAdministrativo().getIdMaestroColumna();
        }
        if(!actIdSA.equals(updIdSA)){
            LOG.info("act-upd-getIdSilencioAdministrativo->"+actIdSA+"-"+updIdSA);
            retorno=false;
        }        
        return retorno;
    }
    
    @Override
    public ProcedimientoDTO changeEstadoVerificado(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoException{
        LOG.info("DAO changeEstadoVerificado - inicio");
        ProcedimientoDTO retorno = null;
        try{
            PghProcedimiento registroDAO = crud.find(registroDTO.getIdProcedimiento(), PghProcedimiento.class);
            List<TramiteDTO> tramAct=tramiteDAO.find(new TramiteFilter(registroDTO.getIdProcedimiento(),Constantes.CONSTANTE_ESTADO_ACTIVO));
            //change PROC
            registroDAO.setEstado(registroDTO.getEstado());
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            //change procTramite
            LOG.info("tramAct-"+tramAct.size()+"=>"+tramAct);
            for(TramiteDTO regTramAct : tramAct){
                LOG.info("TramRETIRADO-->"+regTramAct.getIdTramite());
                //retiro tramite con actividades
                //busco idProcTram, segun idProc + idTram (regTramUpd)
                ProcedimientoTramiteDTO procTramAct=procedimientoTramiteDAO.find(new ProcedimientoTramiteFilter(registroDTO.getIdProcedimiento(), regTramAct.getIdTramite(), Constantes.CONSTANTE_ESTADO_ACTIVO)).get(0);
                LOG.info("IdPROCTramRETIRADO-->"+procTramAct.getIdProcedimientoTramite());
                procTramAct.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                ProcedimientoTramiteDTO procTramReti=procedimientoTramiteDAO.changeEstado(procTramAct,usuarioDTO);
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
            
            retorno=ProcedimientoBuilder.toProcedimientoDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR changeEstado--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ProcedimientoException.ERROR_ELIMINAR_PROCEDIMIENTO),e);
            ProcedimientoException e2 = new ProcedimientoException(ProcedimientoException.ERROR_ELIMINAR_PROCEDIMIENTO,e, true);
            throw e2;
        }
        LOG.info("DAO changeEstadoVerificado - fin");
        return retorno;
    }
    
    @Override
    public ProcedimientoDTO changeEstado(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoException{
        ProcedimientoDTO retorno = null;
        try{
            PghProcedimiento registroDAO = crud.find(registroDTO.getIdProcedimiento(), PghProcedimiento.class);
            registroDAO.setEstado(registroDTO.getEstado());
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=ProcedimientoBuilder.toProcedimientoDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR changeEstado--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(ProcedimientoException.ERROR_ELIMINAR_PROCEDIMIENTO),e);
            ProcedimientoException e2 = new ProcedimientoException(ProcedimientoException.ERROR_ELIMINAR_PROCEDIMIENTO,e, true);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public ProcedimientoDTO create(ProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws ProcedimientoException{
        ProcedimientoDTO retorno = null;
        try{
            PghProcedimiento registroDAO = ProcedimientoBuilder.getProcedimiento(registroDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            
            //verifica Item-Denominacion no existan en algun Procedimiento
            List<ProcedimientoDTO> valiProc=valiProcItemDenominacion(registroDTO);
            LOG.info("valiProc---->"+valiProc);
            if(!valiProc.isEmpty()){
                throw new ProcedimientoException("Ya existe un Procedimiento con el Item y Denomicaci&oacute;n especificados",null);
            }
            
            crud.create(registroDAO);
            retorno=ProcedimientoBuilder.toProcedimientoDto(registroDAO);
        }catch (ProcedimientoException ex) {
            LOG.error("error create ProcedimientoDAO = "+ex.getMessage());
            throw ex;
        }catch(Exception ex){
            LOG.error("error create ProcedimientoDAO ==  "+ex.getMessage());
            ProcedimientoException e2 = new ProcedimientoException(ProcedimientoException.ERROR_CREAR_PROCEDIMIENTO, ex, true);
        }
        return retorno;
    }
    
    public List<ProcedimientoDTO> valiProcItemDenominacion(ProcedimientoDTO registroDTO){
        List<ProcedimientoDTO> retorno=new ArrayList<ProcedimientoDTO>();
        Query query;
        if(registroDTO.getItem()!=null && !registroDTO.getItem().equals("")){
            query=crud.getEm().createNamedQuery("PghProcedimiento.findByItemDenominacion");
        }else{
            query=crud.getEm().createNamedQuery("PghProcedimiento.findByItemNullDenominacion");
        }
        
        if(registroDTO.getItem()!=null && !registroDTO.getItem().equals("")){
            query.setParameter("item",registroDTO.getItem());
        }
        query.setParameter("denominacion",registroDTO.getDenominacion());
        query.setParameter("estado",registroDTO.getEstado());
        retorno=ProcedimientoBuilder.toListProcedimientoDto(query.getResultList());
        LOG.info("regProcValidar-->"+retorno);
        
        return retorno;
    }
    
    @Override
    public ProcedimientoDTO findById(ProcedimientoFilter filtro) throws ProcedimientoException{
        ProcedimientoDTO retorno;

        Query query = crud.getEm().createNamedQuery("PghProcedimiento.findByIdProcedimiento");
        query.setParameter("idProcedimiento",filtro.getIdProcedimiento());
        query.setParameter("estado",filtro.getEstado());
        
        retorno = (ProcedimientoDTO) ProcedimientoBuilder.toListProcedimientoDto(query.getResultList()).get(0);

        return retorno;
    }
    
    @Override
    public List<ProcedimientoDTO> find(ProcedimientoFilter filtro) throws ProcedimientoException {
        List<ProcedimientoDTO> listado;

        Query query = getQueryToFind(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = ProcedimientoBuilder.toListProcedimientoDto(query.getResultList());

        return listado;
    }
    
    @Override
    public Long count(ProcedimientoFilter filtro) throws ProcedimientoException {
        Query query = getQueryToFind(filtro, true);
        return (Long) query.getSingleResult();
    }
    
    private Query getQueryToFind(ProcedimientoFilter filtro, boolean count) {
        String queryString;
        StringBuilder jpql = new StringBuilder();
        //arma CAMPOS QUERY 
        if (count) {
            jpql.append("Select count(distinct pro.idProcedimiento) ");
        }else{
            jpql.append("Select new PghProcedimiento(pro.idProcedimiento, pro.item,pro.denominacion,pr.idProceso,et.idEtapa,et.descripcion as proceso,"
                    + "sum(case when pta.idActividad.idActividad is not null and pta.estado=:estado then 1 else 0 end) as tieneAct ) ");
        }
        //arma FROM´s y JOIN´s
        jpql.append("from PghProcedimiento pro "
                + "left join pro.pghProcedimientoTramiteList pt "
                + "left join pt.idTramite tr "
                + "left join tr.idEtapa et "
                + "left join et.idProceso pr "
                + "left join pt.pghProcTramActividadList pta "
                + "left join pta.idActividad ac ");
        //arma WHERE´s
        jpql.append(" WHERE pro.estado=:estado and pt.estado=:estado "
                + "and upper(pro.denominacion) like :denominacion "
                + "and upper(pro.baseLegal) like :baseLegal ");
            //WHERE´s dinamicos
        if (filtro.getIdEtapa()!= null) {
            jpql.append("and et.idEtapa=:idEtapa ");
        } 
        if (filtro.getIdTramite()!= null) {
            jpql.append("and tr.idTramite=:idTramite ");
        }
        if (filtro.getIdActividad()!= null) {
            jpql.append("and ac.idActividad=:idActividad ");
        }
        if(filtro.getItem()!=null && !StringUtil.removeBlank(filtro.getItem()).equals("")){
            jpql.append("and upper(pro.item) like :item ");
        }
        //arma GROUP BY
        if (!count) {
            jpql.append("GROUP BY pro.idProcedimiento, pro.item,pro.denominacion, pr.idProceso,et.idEtapa,et.descripcion ");
        }
        
        //////////////////////////////////////
        //Crear QUERY
        queryString = jpql.toString();
        Query query = this.crud.getEm().createQuery(queryString);
        //////////////////////////////////////
        //Ingreso de PARAMETROS
            //parametros de WHERE's
        if (filtro.getEstado()!= null) {
            query.setParameter("estado",filtro.getEstado());
        }
        if (filtro.getDenominacion()!= null) {
            query.setParameter("denominacion","%"+StringUtil.removeBlank(filtro.getDenominacion().toUpperCase())+"%");
        }
        if (filtro.getBaseLegal()!= null) {
            query.setParameter("baseLegal","%"+StringUtil.removeBlank(filtro.getBaseLegal().toUpperCase())+"%");
        }
        if (filtro.getIdEtapa()!= null) {
            query.setParameter("idEtapa",filtro.getIdEtapa());
        } 
        if (filtro.getIdTramite()!= null) {
            query.setParameter("idTramite",filtro.getIdTramite());
        } 
        if (filtro.getIdActividad()!= null) {
            query.setParameter("idActividad",filtro.getIdActividad());
        } 
        if (filtro.getItem()!= null && !StringUtil.removeBlank(filtro.getItem()).equals("")) {
            query.setParameter("item","%"+StringUtil.removeBlank(filtro.getItem().toUpperCase())+"%");
        }
        //////////////////////////////////////
        return query;
    }
}
