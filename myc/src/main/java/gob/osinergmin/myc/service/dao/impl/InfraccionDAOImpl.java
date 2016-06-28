/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.MdiDocumentoAdjunto;
import gob.osinergmin.myc.domain.PghInfraccion;
import gob.osinergmin.myc.domain.builder.InfraccionBuilder;
import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.InfraccionDAO;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rcoloradoa
 */
@Service
@Transactional
public class InfraccionDAOImpl implements InfraccionDAO{
    private static final Logger LOG = LoggerFactory.getLogger(InfraccionDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public InfraccionDTO create(InfraccionDTO infraccionDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Detalle Obligacion DAO Impl");
        InfraccionDTO retorno = null;
        try{
            PghInfraccion infraccion = InfraccionBuilder.getDetalleInfraccion(infraccionDTO);            
            infraccion.setDatosAuditoria(usuarioDTO);
            if(infraccion.getCodTrazabilidad()!=null && !infraccion.getCodTrazabilidad().equals("")){
            	crud.createWithHistory(infraccion);
            }else{
                crud.create(infraccion);
            }            
            retorno = InfraccionBuilder.toInfraccionDto(infraccion);
            LOG.info("(Registro Detalle Obligacion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    
    @Override
	public InfraccionDTO update(InfraccionDTO infraccionDTO,
			UsuarioDTO usuarioDTO) {
		LOG.info("Actualizar Detalle Obligacion DAO Impl");
        InfraccionDTO retorno = null;
        try{
        	
            PghInfraccion infraccion = crud.find(infraccionDTO.getIdInfraccion(),PghInfraccion.class);
            infraccion.setDescripcionInfraccion(infraccionDTO.getDescripcionInfraccion());
            if(infraccion.getIdDocumentoAdjunto() == null ){
            	MdiDocumentoAdjunto docAdjunto=new MdiDocumentoAdjunto();
                docAdjunto.setIdDocumentoAdjunto(infraccionDTO.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto());            	
                infraccion.setIdDocumentoAdjunto(docAdjunto);
            }else{
                if(infraccionDTO.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto() != null){
                	MdiDocumentoAdjunto docAdjunto=new MdiDocumentoAdjunto();
                    docAdjunto.setIdDocumentoAdjunto(infraccionDTO.getDocumentoAdjuntoDTO().getIdDocumentoAdjunto());            	
                    infraccion.setIdDocumentoAdjunto(docAdjunto);
                }
            }            
            infraccion.setCodTrazabilidad(infraccionDTO.getCodTrazabilidad());
            infraccion.setDescripcionInfraccion(infraccionDTO.getDescripcionInfraccion());
            infraccion.setEstado(infraccionDTO.getEstado());            
            infraccion.setCodAccion(infraccionDTO.getCodAccion());
            infraccion.setIdMedidaSeguridadMaestro(infraccionDTO.getIdMedidaSeguridadMaestro());
            infraccion.setIdAccionMaestro(infraccionDTO.getIdAccionMaestro());
            if(infraccion.getCodTrazabilidad()!=null && !infraccion.getCodTrazabilidad().equals("")){
                crud.updateWithHistory(infraccion);
            }else{
                crud.update(infraccion);
            }            
            retorno = InfraccionBuilder.toInfraccionDto(infraccion);
            LOG.info("(Actualizar Detalle Obligacion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
	}

	@Override
	public Long findInfraccion(InfraccionDTO infraccion) {
		Long retorno=null;		
		Query query=null;
		query = crud.getEm().createNamedQuery("PghInfraccion.findByIdObligacion");
		if (infraccion.getIdObligacion2()!= null){
            query.setParameter("idObligacion",infraccion.getIdObligacion2());
        }		
		List<InfraccionDTO> list=InfraccionBuilder.toListInfraccionDto(query.getResultList(),infraccion.getIdObligacion2());
		if(list!=null && list.size()>0){
		retorno= list.get(0).getIdInfraccion();            
		}
		return retorno;
	}

   
	
    
}