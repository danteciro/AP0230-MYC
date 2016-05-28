package gob.osinergmin.myc.service.business.impl;

import java.util.List;

import javax.inject.Inject;

import org.jfree.util.Log;

import gob.osinergmin.myc.domain.dto.BaseLegalDTO;
import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.ObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.business.CnfObligServiceNeg;
import gob.osinergmin.myc.service.dao.CnfObligacionDAO;
import gob.osinergmin.myc.service.dao.impl.CnfObligacionDAOImpl;
import gob.osinergmin.myc.service.exception.ObligacionException;
import gob.osinergmin.myc.service.exception.ProcedimientoException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CnfObligServiceNegImpl implements CnfObligServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(CnfObligServiceNegImpl.class);
	
	@Inject
	CnfObligacionDAO cnfObligacionDAO;
	
	@Override
	public List<ProcesoDTO> listarProceso(Long idActividad, int[] cuenta) throws ObligacionException{
		LOG.info("(ServiceNegImpl) Listar ProcesoxActividad");
		List<ProcesoDTO> proceso=null;
		try {
			proceso = cnfObligacionDAO.findProceso(idActividad);
			Log.info("cuenta -size: "+proceso.size());
		} catch (ObligacionException ex) {
			throw new ObligacionException(ex.getMessage(),null);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		return proceso;
	}

	@Override
	public List<ObligacionTipoDTO> listarObligacionTipo(Long idActividad,
			Long idTipoProceso, int[] cuenta) {
		LOG.info("(ServiceNegImpl) Listar ObligacionTipoxProcesoxActividad");
		List<ObligacionTipoDTO> obligacionTipo=null;
		obligacionTipo=cnfObligacionDAO.findObligacionTipo(idActividad,idTipoProceso);
		return obligacionTipo;
	}

	@Override
	public CnfObligacionDTO eliminarConfiguracion(Long idConfObligacion,String codTrazabilidad,UsuarioDTO usuarioDTO) {
		CnfObligacionDTO registro=null;
		try{
			registro=cnfObligacionDAO.changeEstado(idConfObligacion,codTrazabilidad,usuarioDTO);
			LOG.info("(ServiceNegImpl) Eliminar Configuracion con Codigo: "+registro.getIdConfObligacion());
		}catch(Exception ex){
			LOG.error("",ex);
		}
        return registro;
	}

	@Override
	public CnfObligacionDTO eliminarBaseLegalAsociada(Long idAsocObligacion,
			UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
