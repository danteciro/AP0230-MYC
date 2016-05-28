/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghCnfRequProcedimiento;
import gob.osinergmin.myc.domain.builder.PghCnfRequProcedimientoBuilder;
import gob.osinergmin.myc.domain.builder.RequProcParaDinaBuilder;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.CnfRequProcedimientoFilter;
import gob.osinergmin.myc.service.dao.CnfRequProcedimientoDAO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.RequisitoDAO;
import gob.osinergmin.myc.service.exception.CnfRequProcedimientoException;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.PropertyUtils;
import java.math.BigDecimal;
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
@Service("cnfRequProcedimientoDAO")
public class CnfRequProcedimientoDAOImpl implements CnfRequProcedimientoDAO{
    private static final Logger LOG = LoggerFactory.getLogger(CnfRequProcedimientoDAO.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public CnfRequProcedimientoDTO changeEstado(CnfRequProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws CnfRequProcedimientoException{
        CnfRequProcedimientoDTO retorno = null;
        try{
            PghCnfRequProcedimiento registroDAO = crud.find(registroDTO.getIdRequisitoProcedimiento(), PghCnfRequProcedimiento.class);
            registroDAO.setEstado(registroDTO.getEstado());
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.update(registroDAO);
            
            retorno=PghCnfRequProcedimientoBuilder.toProcedimientoDto(registroDAO);
        }catch(Exception e){
            LOG.error("ERROR--->"+e.getMessage());
            LOG.error(PropertyUtils.getProperty(CnfRequProcedimientoException.ERROR_CREAR_REQU_PROCEDIMIENTO),e);
            CnfRequProcedimientoException e2 = new CnfRequProcedimientoException(CnfRequProcedimientoException.ERROR_CREAR_REQU_PROCEDIMIENTO,e, true);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public CnfRequProcedimientoDTO create(CnfRequProcedimientoDTO registroDTO, UsuarioDTO usuarioDTO) throws CnfRequProcedimientoException{
        CnfRequProcedimientoDTO retorno = null;
        try{
            //validar q registro CnfRequProcedimientoDTO a registrar no tenga un similar
            boolean validaRequProc=validaCreateRequProc(registroDTO);
            
            if(!validaRequProc){
                throw new CnfRequProcedimientoException("Requisito Espec&iacute;fico duplicado",null);
            }
            //buscar nroOrden
            Long nroOrden=generarNroOrden(registroDTO);
            LOG.info("---------->nroOrden generado="+nroOrden);
            registroDTO.setNroOrden(nroOrden);
            ////////////////////////////////////////////////////////////////////////////
            PghCnfRequProcedimiento registroDAO = PghCnfRequProcedimientoBuilder.getCnfRequProcedimiento(registroDTO);
            registroDAO.setDatosAuditoria(usuarioDTO);
            crud.create(registroDAO);
            
            retorno=PghCnfRequProcedimientoBuilder.toProcedimientoDto(registroDAO);
        }catch (CnfRequProcedimientoException ex) {
            LOG.error("error create CnfRequProcedimientoException",ex.getMessage());
            throw ex;
        }catch(Exception ex){
            LOG.error("error create Exception",ex.getMessage());
            CnfRequProcedimientoException e2 = new CnfRequProcedimientoException(CnfRequProcedimientoException.ERROR_CREAR_REQU_PROCEDIMIENTO,ex, true);
            throw e2;
        }
        return retorno;
    }
    
    public Long generarNroOrden(CnfRequProcedimientoDTO registroDTO){
        Long retorno;
        BigDecimal consulta;
        //
        StringBuilder jpql = new StringBuilder();
        jpql.append( "select nvl((max(nro_orden)+1),1) " 
                + "from pgh_cnf_requ_procedimiento " 
                + "where estado=1 and id_procedimiento="+registroDTO.getIdProcedimiento() 
                + " and flg_general="+registroDTO.getFlgGeneral() );
        if (registroDTO.getIdRequisitoProcedimientoPad()!= null) {
            jpql.append(" and id_requisito_procedimiento_pad = " + registroDTO.getIdRequisitoProcedimientoPad());
        }else{
            jpql.append(" and id_requisito_procedimiento_pad is null ");
        }
        String queryString = jpql.toString();
        //
        Query query = this.crud.getEm().createNativeQuery(queryString);
        //Query query = this.crud.getEm().createQuery(queryString);
        consulta = (BigDecimal) query.getSingleResult();
        retorno=consulta.longValue();
        
        return retorno;
    }
    
    public boolean validaCreateRequProc(CnfRequProcedimientoDTO registroDTO){
        LOG.info("DAO validaCreateRequProc - inicio");
        boolean retorno=true;
        try{
            Query query=getQueryValidaProc(registroDTO);
            List<CnfRequProcedimientoDTO> listado=PghCnfRequProcedimientoBuilder.toListProcedimientoDto(query.getResultList());
            LOG.info("listaReqProcIguales--->"+listado);
            if(!listado.isEmpty()){
                //buscop paraDina de cada reqProc
                String txtParaDinaNuevos=MycUtil.concatenaValorParametroFromRequProcParaDina(registroDTO.getValoresParaDina());
                LOG.info("txtParaDinaNuevos-->"+txtParaDinaNuevos);
                for(CnfRequProcedimientoDTO reg : listado){
                    //buscar RequProcParaDina segun idRquProc
                    List<RequProcParaDinaDTO> paraDinaBD=findParaDina(reg.getIdRequisitoProcedimiento());
                    String txtParaDinaBD=MycUtil.concatenaValorParametroFromRequProcParaDina(paraDinaBD);
                    LOG.info("txtParaDinaBD-->"+txtParaDinaBD);
                    if(txtParaDinaNuevos.equals(txtParaDinaBD)){
                        retorno=false;
                        break;
                    }
                }
            }
        }catch(Exception e){
            LOG.error("ERROR en validaCreateRequProc.");
            e.printStackTrace();            
        }
        
        LOG.info("DAO validaCreateRequProc - fin");
        return retorno;
    }
    
    public Query getQueryValidaProc(CnfRequProcedimientoDTO registroDTO){
        LOG.info("DAO getQueryValidaProc - inicio");
        String queryString;
        StringBuilder jpql = new StringBuilder();
        //arma QUERY 
        jpql.append("SELECT p FROM PghCnfRequProcedimiento p "
                + "where p.estado=:estado and p.idProcedimiento.idProcedimiento=:idProcedimiento "
                + "and p.idRequisito.idRequisito=:idRequisito and flgGeneral=:flgGeneral ");
        //WHERE´s
        if (registroDTO.getIdTramite()!= null) {
            jpql.append("and p.idTramite.idTramite=:idTramite ");
        }else{
            jpql.append("and p.idTramite.idTramite is null ");
        } 
        
        if (registroDTO.getIdActividad()!= null) {
            jpql.append("and p.idActividad.idActividad=:idActividad ");
        }else{
            jpql.append("and p.idActividad.idActividad is null ");
        }
        
        if (registroDTO.getIdZonificacion()!= null) {
            jpql.append("and p.idZonificacion.idZonificacion=:idZonificacion ");
        }else{
            jpql.append("and p.idZonificacion.idZonificacion is null ");
        }
        
        if (registroDTO.getIdRequisitoProcedimientoPad()!= null) {
            jpql.append("and p.idRequisitoProcedimientoPad=:idRequisitoProcedimientoPad ");
        }else{
            jpql.append("and p.idRequisitoProcedimientoPad is null ");
        }
        
        if (registroDTO.getIdMotivoTramite()!= null) {
            jpql.append("and p.idMotivoTramite.idMotivoTramite=:idMotivoTramite ");
        }else{
            jpql.append("and p.idMotivoTramite.idMotivoTramite is null ");
        }
        
        //////////////////////////////////////
        //Crear QUERY
        queryString = jpql.toString();
        Query query = this.crud.getEm().createQuery(queryString);
        //////////////////////////////////////
        //Ingreso de PARAMETROS
        query.setParameter("estado",registroDTO.getEstado());
        query.setParameter("idProcedimiento",registroDTO.getIdProcedimiento());
        query.setParameter("idRequisito",registroDTO.getIdRequisito());
        query.setParameter("flgGeneral",registroDTO.getFlgGeneral());
        //parametros de WHERE's
        if (registroDTO.getIdTramite()!= null) {
            query.setParameter("idTramite",registroDTO.getIdTramite());
        }
        if (registroDTO.getIdActividad()!= null) {
            query.setParameter("idActividad",registroDTO.getIdActividad());
        }
        if (registroDTO.getIdZonificacion()!= null) {
            query.setParameter("idZonificacion",registroDTO.getIdZonificacion());
        }
        if (registroDTO.getIdRequisitoProcedimientoPad()!= null) {
            query.setParameter("idRequisitoProcedimientoPad",registroDTO.getIdRequisitoProcedimientoPad());
        }
        if (registroDTO.getIdMotivoTramite()!= null) {
            query.setParameter("idMotivoTramite",registroDTO.getIdMotivoTramite());
        }
        LOG.info("DAO getQueryValidaProc - fin");
        return query;
    }
    
    @Override
    public List<RequProcParaDinaDTO> findParaDina(Long idRequisitoProcedimiento) throws CnfRequProcedimientoException{
        List<RequProcParaDinaDTO> listado = null;
        Query query=crud.getEm().createNamedQuery("PghRequProcParaDina.findByIdRequisitoProcedimiento");
        query.setParameter("idRequisitoProcedimiento",idRequisitoProcedimiento);
        query.setParameter("estado",Constantes.CONSTANTE_ESTADO_ACTIVO);
        listado = RequProcParaDinaBuilder.toListRequProcParaDinaDto(query.getResultList());
        return listado;
    }
    
    @Override
    public List<CnfRequProcedimientoDTO> find(CnfRequProcedimientoFilter filtro) throws CnfRequProcedimientoException{
        List<CnfRequProcedimientoDTO> listado = null;

        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }

        listado = PghCnfRequProcedimientoBuilder.toListProcedimientoDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(CnfRequProcedimientoFilter filtro, boolean count) {
        Query query=null;
        try{
            if (count) {
                if (filtro.getIdProcedimiento()!= null && filtro.getFlgGeneral()!=null) {
                    query = crud.getEm().createNamedQuery("PghCnfRequProcedimiento.countByIdProcedimiento");
                }else {
                    query = crud.getEm().createNamedQuery("PghCnfRequProcedimiento.countAll");
                }
            }else {
                if (filtro.getIdActividad()!= null && filtro.getIdProcedimiento()!= null && filtro.getFlgGeneral()==null) {
                    query = crud.getEm().createNamedQuery("PghCnfRequProcedimiento.findAllByIdProcedimientoIdActividad");
                }else if (filtro.getIdTramite()!= null && filtro.getIdProcedimiento()!= null && filtro.getFlgGeneral()==null) {
                    query = crud.getEm().createNamedQuery("PghCnfRequProcedimiento.findAllByIdProcedimientoIdTramite");
                }else if (filtro.getIdProcedimiento()!= null && filtro.getFlgGeneral()!=null) {
                    query = crud.getEm().createNamedQuery("PghCnfRequProcedimiento.findByIdProcedimiento");
                }else if (filtro.getIdProcedimiento()!= null && filtro.getFlgGeneral()==null) {
                    query = crud.getEm().createNamedQuery("PghCnfRequProcedimiento.findAllByIdProcedimiento");
                }else {
                    query = crud.getEm().createNamedQuery("PghCnfRequProcedimiento.findAll");
                }
            }

            if (filtro.getFlgGeneral()!= null) {
                query.setParameter("flgGeneral",filtro.getFlgGeneral());
            }
            if (filtro.getIdProcedimiento()!= null) {
                query.setParameter("idProcedimiento",filtro.getIdProcedimiento());
            }
            if (filtro.getIdTramite()!= null) {
                query.setParameter("idTramite",filtro.getIdTramite());
            }
            if (filtro.getIdActividad()!= null) {
                query.setParameter("idActividad",filtro.getIdActividad());
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
    public CnfRequProcedimientoDTO actualizarOrdenRequProc(Long idRequisitoProcedimiento,Long nroOrden, UsuarioDTO usuarioDTO) throws CnfRequProcedimientoException{
        LOG.error("actualizarOrdenRequProc");
        LOG.error(nroOrden+"-->"+idRequisitoProcedimiento);
        CnfRequProcedimientoDTO retorno = null;
        try {
            PghCnfRequProcedimiento registroDAO = crud.find(idRequisitoProcedimiento, PghCnfRequProcedimiento.class);
            registroDAO.setDatosAuditoria(usuarioDTO);
            registroDAO.setNroOrden(nroOrden);
            crud.update(registroDAO);

            retorno = PghCnfRequProcedimientoBuilder.toProcedimientoDto(registroDAO);
        } catch (Exception e) {
            LOG.error("error en actualizarOrdenRequProc",e.getMessage());
            CnfRequProcedimientoException e2 = new CnfRequProcedimientoException(CnfRequProcedimientoException.ERROR_GENERICO, e, true);
            throw e2;
        }
        return retorno;
    }
}
