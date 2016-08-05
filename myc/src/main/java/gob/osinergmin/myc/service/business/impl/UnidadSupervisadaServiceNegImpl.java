package gob.osinergmin.myc.service.business.impl;
import gob.osinergmin.myc.domain.dto.RequisitoDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.domain.ui.UnidadSupervisadaFilter;
import gob.osinergmin.myc.service.business.UnidadSupervisadaServiceNeg;
import gob.osinergmin.myc.service.dao.UnidadOrganicaDAO;
import gob.osinergmin.myc.service.dao.UnidadSupervisadaDAO;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author gvillanueva
 */
@Service("unidadSupervisadaServiceNeg")
public class UnidadSupervisadaServiceNegImpl implements UnidadSupervisadaServiceNeg {  

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UnidadSupervisadaServiceNegImpl.class);
    
    @Inject
    private UnidadSupervisadaDAO unidadSupervisadaDAO;
    
	@Override
	public Long contarUnidadSupervisadaxActividad(UnidadSupervisadaFilter filtro) {
		LOG.info("Negocio Unidad Supervisada");
		Long cuenta=null;
        try{ 
        	if(filtro.getIdActividad()!=null){
        		cuenta = unidadSupervisadaDAO.contarUnidadSupervisadaxActividad(filtro);
        	}
			
        }catch(Exception ex){
        	ex.printStackTrace();
            LOG.error("",ex);
        }
        return cuenta;
	}

	@Override
	public Long contarUnidadSupervisadaxActividadxEstratoDistrito(UnidadSupervisadaFilter filtro) {
		LOG.info("Lista unidades supervisadas por actividad y distrito");
		Long cuenta=new Long(0);
        try{ 
        		cuenta = unidadSupervisadaDAO.contarUnidadSupervisadaxActividadxEstratoDistrito(filtro);
			
        }catch(Exception ex){
        	ex.printStackTrace();
            LOG.error("",ex);
        }
        return cuenta;
	}

	@Override
	public Long contarUnidadSupervisadaxActividadxEstratoProvincia(UnidadSupervisadaFilter filtro) {
		LOG.info("Lista unidades supervisadas por actividad y provincia");
		Long cuenta=new Long(0);
        try{ 
        		cuenta = unidadSupervisadaDAO.contarUnidadSupervisadaxActividadxEstratoProvincia(filtro);
			
        }catch(Exception ex){
        	ex.printStackTrace();
            LOG.error("",ex);
        }
        return cuenta;
	}

	@Override
	public Long contarUnidadSupervisadaxActividadxEstratoDepartamento(UnidadSupervisadaFilter filtro) {
		LOG.info("Lista unidades supervisadas por actividad y departamento");
		Long cuenta=new Long(0);
        try{ 
        		cuenta = unidadSupervisadaDAO.contarUnidadSupervisadaxActividadxEstratoDepartamento(filtro);
			
        }catch(Exception ex){
        	ex.printStackTrace();
            LOG.error("",ex);
        }
        return cuenta;
	}

	@Override
	public List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoDepartamento(UnidadSupervisadaFilter filtro) {
		LOG.info("Lista unidades supervisadas por actividad y departamento");
		List<UnidadSupervisadaDTO> lista = null;
        try{ 
        		lista = unidadSupervisadaDAO.listarUnidadSupervisadaxActividadxEstratoDepartamento(filtro);
			
        }catch(Exception ex){
        	ex.printStackTrace();
            LOG.error("",ex);
        }
        return lista;
	}

	@Override
	public List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoDistrito(UnidadSupervisadaFilter filtro) {
		LOG.info("Lista unidades supervisadas por actividad y departamento provincia distrito");
		List<UnidadSupervisadaDTO> lista = null;
        try{ 
        		lista = unidadSupervisadaDAO.listarUnidadSupervisadaxActividadxEstratoDistrito(filtro);
			
        }catch(Exception ex){
        	ex.printStackTrace();
            LOG.error("",ex);
        }
        return lista;
	}

	@Override
	public List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoProvincia(UnidadSupervisadaFilter filtro) {
		LOG.info("Lista unidades supervisadas por actividad y departamento provincia");
		List<UnidadSupervisadaDTO> lista = null;
        try{ 
        		lista = unidadSupervisadaDAO.listarUnidadSupervisadaxActividadxEstratoProvincia(filtro);
			
        }catch(Exception ex){
        	ex.printStackTrace();
            LOG.error("",ex);
        }
        return lista;
	}
	
		
}