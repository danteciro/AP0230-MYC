/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghEscenarioIncumplimiento;
import gob.osinergmin.myc.domain.builder.IncumplimientoBuilder;
import gob.osinergmin.myc.domain.dto.IncumplimientoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.IncumplimientoDAO;
import gob.osinergmin.myc.util.Constantes;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author rcoloradoa
 */
@Service
@Transactional
public class IncumplimientoDAOImpl implements IncumplimientoDAO{
    private static final Logger LOG = LoggerFactory.getLogger(IncumplimientoDAOImpl.class);
    
    @Inject
    private CrudDAO crud;
    
    @Override
    public IncumplimientoDTO create(IncumplimientoDTO incumplimientoDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Obligacion Base Legal DAO Impl");
        IncumplimientoDTO retorno = null;
        try{
            PghEscenarioIncumplimiento pghIncumplimiento = IncumplimientoBuilder.getIncumplimiento(incumplimientoDTO);
            pghIncumplimiento.setDatosAuditoria(usuarioDTO);            
            if(pghIncumplimiento.getCodTrazabilidad()!=null && !pghIncumplimiento.getCodTrazabilidad().equals("")){
                crud.createWithHistory(pghIncumplimiento);
            }else{
                crud.create(pghIncumplimiento);
            }
            
            retorno = IncumplimientoBuilder.toIncumplimientoDto(pghIncumplimiento);
            LOG.info("(Registro Obligacion Tipificacion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public List<IncumplimientoDTO> findIncumplimiento(IncumplimientoDTO incumplimientoDTO) {
		
		List<IncumplimientoDTO> retorno=null;
		try {
		
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("Select new PghEscenarioIncumplimiento(dnt.idInfraccion.idInfraccion, dnt.idEsceIncumplimiento, dnt.idEsceIncuMaestro.idMaestroColumna, dnt.idEsceIncuMaestro.descripcion ) ");
            jpql.append( "from PghEscenarioIncumplimiento dnt " );
            jpql.append(" inner join dnt.idEsceIncuMaestro mc  ");   
            jpql.append(" where dnt.estado='1'");
            System.out.println("incumplimientoDTO.getId_esce_incu_maestro()"+incumplimientoDTO.getId_esce_incu_maestro());
            System.out.println("incumplimientoDTO.getId_infraccion()"+incumplimientoDTO.getId_infraccion());
            if(incumplimientoDTO.getId_esce_incu_maestro()!=null){
            jpql.append(" and dnt.idEsceIncuMaestro.idMaestroColumna='"+incumplimientoDTO.getId_esce_incu_maestro()+"'");
            }
            if(incumplimientoDTO.getId_infraccion()!=null){
            jpql.append(" and dnt.idInfraccion.idInfraccion='"+incumplimientoDTO.getId_infraccion()+"'");
            }
            Query 	query = crud.getEm().createQuery(jpql.toString());
            
	        LOG.info("query Consulta By IdObligacion: " + jpql.toString());
	        List<PghEscenarioIncumplimiento>  resultados = query.getResultList();  
	        System.out.println(" Listado  "+resultados);

	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=IncumplimientoBuilder.toListIncumplimientoDto(resultados);
	        }
	        LOG.info("(Consultar Temas de la Obligacion By Id DAO IMPL) Saliendo... :Retorno: " + retorno);

		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return retorno;
	}
    
    
    
    
    @Override
    public List<IncumplimientoDTO> findIncumplimientos(IncumplimientoDTO incumplimientoDTO) {
		LOG.info("(Consultar Temas de la Obligacion By Id DAO IMPL) Ingresando...");
		List<IncumplimientoDTO> retorno=null;
		try {
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("Select new PghEscenarioIncumplimiento(dnt.idInfraccion.idInfraccion, dnt.idEsceIncumplimiento, dnt.idEsceIncuMaestro.idMaestroColumna, dnt.idEsceIncuMaestro.descripcion ) ");
            jpql.append( "from PghEscenarioIncumplimiento dnt " );
            jpql.append(" inner join dnt.idEsceIncuMaestro mc  ");            
            jpql.append(" where dnt.estado='1'");
            System.out.println("incumplimientoDTO.getId_infraccion()"+incumplimientoDTO.getId_infraccion());
            if(!StringUtil.isEmptyNum(incumplimientoDTO.getId_infraccion())){
            jpql.append(" and dnt.idInfraccion.idInfraccion=:idInfracion");
            }
            Query 	query = crud.getEm().createQuery(jpql.toString());
            
	       	 if(!StringUtil.isEmptyNum(incumplimientoDTO.getId_infraccion())){
	             query.setParameter("idInfracion",incumplimientoDTO.getId_infraccion());
	         }
	        LOG.info("query Consulta By IdObligacion: " + jpql.toString());
	        List<PghEscenarioIncumplimiento>  resultados = query.getResultList();  
	        System.out.println(" Listado  "+resultados);

	        if(!CollectionUtils.isEmpty(resultados)){
	        	retorno=IncumplimientoBuilder.toListIncumplimientoDto(resultados);
	        }
	        LOG.info("(Consultar Temas de la Obligacion By Id DAO IMPL) Saliendo... :Retorno: " + retorno);

		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return retorno;
	}
    
    
    @Override
    public IncumplimientoDTO eliminarIncumplimiento(IncumplimientoDTO incumplimientoDTO,UsuarioDTO usuarioDTO){
    IncumplimientoDTO registro = null;
          try{
                 LOG.info("idRubroOpcion---->"+incumplimientoDTO.getId_esce_incumplimiento());
                 
                 PghEscenarioIncumplimiento pghEscenarioIncumplimiento=crud.find(incumplimientoDTO.getId_esce_incumplimiento(), PghEscenarioIncumplimiento.class);
                 pghEscenarioIncumplimiento.setDatosAuditoria(usuarioDTO);
                 pghEscenarioIncumplimiento.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);                 
                 crud.update(pghEscenarioIncumplimiento);
                 
                 registro = IncumplimientoBuilder.toIncumplimientoDto(pghEscenarioIncumplimiento);
                 LOG.info("(Cambiar Estado Rubro Opcion DAO Impl) retorno: "+registro.toString());
          }catch(Exception ex){
                 LOG.error("",ex);
          }
          return registro;
    }
			
}