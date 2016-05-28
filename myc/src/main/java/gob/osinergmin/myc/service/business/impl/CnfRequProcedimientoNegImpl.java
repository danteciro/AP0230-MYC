/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.CnfRequProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.ProcedimientoDTO;
import gob.osinergmin.myc.domain.dto.RequProcParaDinaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarCnfRequProcedimientoInRO;
import gob.osinergmin.myc.domain.in.GuardarProcedimientoInRO;
import gob.osinergmin.myc.domain.out.GuardarCnfRequProcedimientoOutRO;
import gob.osinergmin.myc.domain.out.GuardarProcedimientoOutRO;
import gob.osinergmin.myc.domain.ui.CnfRequProcedimientoFilter;
import gob.osinergmin.myc.service.business.CnfRequProcedimientoNeg;
import gob.osinergmin.myc.service.dao.CnfRequProcedimientoDAO;
import gob.osinergmin.myc.service.dao.RequProcParaDinaDAO;
import gob.osinergmin.myc.service.exception.CnfRequProcedimientoException;
import gob.osinergmin.myc.util.Constantes;
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
@Service
public class CnfRequProcedimientoNegImpl implements CnfRequProcedimientoNeg {
    private static final Logger LOG = LoggerFactory.getLogger(CnfRequProcedimientoNeg.class);
    @Inject
    CnfRequProcedimientoDAO cnfRequProcedimientoDAO;
    @Inject
    RequProcParaDinaDAO requProcParaDinaDAO;
    
    @Override
    @Transactional
    public GuardarCnfRequProcedimientoOutRO eliminarCnfRequProcedimiento(GuardarCnfRequProcedimientoInRO in){
        GuardarCnfRequProcedimientoOutRO retorno=new GuardarCnfRequProcedimientoOutRO();
        try{
            CnfRequProcedimientoDTO registro=cnfRequProcedimientoDAO.changeEstado(in.getCnfRequProcedimiento(),in.getUsuario());
            
            retorno.setCnfRequProcedimiento(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("error guardarRequisito", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }
        return retorno;
    }
    
    @Override
    @Transactional
    public GuardarCnfRequProcedimientoOutRO eliminarRequProcParaDinaDTO(GuardarCnfRequProcedimientoInRO in){
        GuardarCnfRequProcedimientoOutRO retorno=new GuardarCnfRequProcedimientoOutRO();
        try{
        	RequProcParaDinaDTO registro=requProcParaDinaDAO.changeEstado(in.getRequProcParaDinaDTO(),in.getUsuario());
            
            retorno.setRequProcParaDinaDTO(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("error guardarRequisito", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
        }
        return retorno;
    }
    
    @Override
    @Transactional
    public GuardarProcedimientoOutRO guardarRequisitosProcedimiento(GuardarProcedimientoInRO in) throws CnfRequProcedimientoException{
        GuardarProcedimientoOutRO retorno=new GuardarProcedimientoOutRO();
        try{
            ProcedimientoDTO registro=in.getProcedimiento();
            List<CnfRequProcedimientoDTO> requisitosProc=in.getProcedimiento().getRequProcedimiento();
            
            for(CnfRequProcedimientoDTO regRequProc : requisitosProc){
                regRequProc.setIdProcedimiento(registro.getIdProcedimiento());
                regRequProc.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                CnfRequProcedimientoDTO registradoRP=cnfRequProcedimientoDAO.create(regRequProc, in.getUsuario());
                LOG.info("registradoRP-->"+registradoRP);
                for(RequProcParaDinaDTO regRequProcPD : regRequProc.getValoresParaDina()){
                    if(regRequProcPD.getValorParametro().getIdValorParametro()!=null){
                        LOG.info("registrando ParaDinamico");
                        regRequProcPD.setIdRequisitoProcedimiento(registradoRP.getIdRequisitoProcedimiento());
                        RequProcParaDinaDTO registradoRPPD=requProcParaDinaDAO.create(regRequProcPD, in.getUsuario());
                        LOG.info("--registradoRPPD-->"+registradoRPPD);
                    }
                }
            }
            
            retorno.setProcedimiento(registro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch (Exception ex) {
            LOG.error("Error en guardarProcedimiento:"+ex.getMessage());
            throw new CnfRequProcedimientoException(ex.getMessage(),null);
        }
        
//        catch (Exception ex) {
//            LOG.error("error guardarProcedimiento", ex);
//            retorno.setMensaje("error");
//            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
//        }
        return retorno;
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<CnfRequProcedimientoDTO> listarRequisitosProcedimiento(CnfRequProcedimientoFilter filtro){
        LOG.info("NEG listarRequisitosProcedimiento - inicio");
        List<CnfRequProcedimientoDTO> retorno=null;
        try{           
            retorno = cnfRequProcedimientoDAO.find(filtro);
            for(CnfRequProcedimientoDTO regMaestro : retorno){
                List<RequProcParaDinaDTO> paraDinaReg=cnfRequProcedimientoDAO.findParaDina(regMaestro.getIdRequisitoProcedimiento());
                regMaestro.setValoresParaDina(paraDinaReg);
            }
        }catch(Exception e){
            LOG.error(e.getMessage());
        }
        LOG.info("NEG listarRequisitosProcedimiento - fin");
        return retorno;
    }
    
    @Override
    @Transactional
    public void actualizarOrdenRequProc(String regModificar,UsuarioDTO usuarioDTO) throws CnfRequProcedimientoException{
        LOG.info("actualizarOrdenRequProc");
        try{
            String[] idRequProcNroOrden = regModificar.split("/");
            for(String registro : idRequProcNroOrden){
                String[] reg=registro.split("-");
                CnfRequProcedimientoDTO regDto=cnfRequProcedimientoDAO.actualizarOrdenRequProc(new Long(reg[0]),new Long(reg[1]),usuarioDTO);
            }
        }catch(Exception e){
            LOG.error("Error actualizarOrdenRequProc",e);
            throw new CnfRequProcedimientoException(e.getMessage(),e);
        }        
    }
}
