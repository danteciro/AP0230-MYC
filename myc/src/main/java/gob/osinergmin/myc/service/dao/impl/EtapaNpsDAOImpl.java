package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.NpsEtapa;
import gob.osinergmin.myc.domain.builder.EtapaNpsBuilder;
import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ProcesoDTO;
import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.EtapaNpsFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.EtapaDAO;
import gob.osinergmin.myc.service.dao.EtapaNpsDAO;
import gob.osinergmin.myc.service.exception.EtapaException;
import gob.osinergmin.myc.util.Constantes;


@Repository("EtapaNpsDAO")
public class EtapaNpsDAOImpl implements EtapaNpsDAO{

	@Inject
	private CrudDAO crudDAO;
	

	@Override
	@Transactional
	public EtapaNpsDTO create(EtapaNpsDTO etapaNpsDTO, UsuarioDTO usuarioDTO) {
		NpsEtapa npsEtapa = EtapaNpsBuilder.toNpsEtapa(etapaNpsDTO);
		npsEtapa.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
		npsEtapa.setDatosAuditoria(usuarioDTO);
		crudDAO.create(npsEtapa);
		return etapaNpsDTO;
	}

	@Override
	@Transactional
	public EtapaNpsDTO update(EtapaNpsDTO etapaNpsDTO, UsuarioDTO usuarioDTO) {
		NpsEtapa npsEtapa = EtapaNpsBuilder.toNpsEtapa(etapaNpsDTO);
		npsEtapa.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
		npsEtapa.setDatosAuditoria(usuarioDTO);
		crudDAO.update(npsEtapa);		
		return etapaNpsDTO;
	}

	@Override
	public List<EtapaNpsDTO> listarEtapaByConfTramite(EtapaNpsFilter etapaNpsFilter) {
	   javax.persistence.Query query;
	   StringBuilder jpql = new StringBuilder();
	   String jquery = new String();
	   List<EtapaNpsDTO> listaDto = new ArrayList<EtapaNpsDTO>();
	   List<NpsEtapa> listaNps = new ArrayList<NpsEtapa>();
	   if(etapaNpsFilter.getIdConfTramite()!=null){
		   jpql.append(" select distinct etapa from  NpsEtapa etapa, NpsEtapaTramite et where etapa.idEtapa.idEtapa = et.idEtapa and  et.idConfTramite  = " + etapaNpsFilter.getIdConfTramite());
		   jquery = jpql.toString(); 
		   query = crudDAO.getEm().createQuery(jquery);
		   listaNps =  query.getResultList();
		   listaDto =  EtapaNpsBuilder.toListEtapaDTO(listaNps);
	   }
	   query =  crudDAO.getEm().createNamedQuery("NpsEtapa.findAll");
	   listaNps =  query.getResultList();
	   listaDto =  EtapaNpsBuilder.toListEtapaDTO(listaNps);
	   return listaDto;
	}
	
	@Override
	public List<EtapaNpsDTO> listarEtapas(EtapaNpsFilter etapaNpsFilter) {
	   javax.persistence.Query query;
	   StringBuilder jpql = new StringBuilder();
	   String jquery = new String();
	   List<EtapaNpsDTO> listaDto = new ArrayList<EtapaNpsDTO>();
	   List<NpsEtapa> listaNps = new ArrayList<NpsEtapa>();
	   query =  crudDAO.getEm().createNamedQuery("NpsEtapa.findAll");
	   listaNps =  query.getResultList();
	   listaDto =  EtapaNpsBuilder.toListEtapaDTO(listaNps);
	   return listaDto;
	}
	
	@Override
	public List<EtapaNpsDTO> listarEtapasConfiguradas(Long idConfTramite) {
	   StringBuilder jpql = new StringBuilder();
	   List<EtapaNpsDTO> retorno = new ArrayList<EtapaNpsDTO>();
	   String jquery = new String();
	   List<EtapaNpsDTO> listaDto = new ArrayList<EtapaNpsDTO>();
	   if(idConfTramite!=null){			
			jpql.append(" select et.id_etapa,et.estado from nps_etapa_tramite et " );
			jpql.append(" where et.id_conf_tramite="+idConfTramite);
			
			System.out.println("QUERYY:::"+jpql.toString());
       	    Query query = crudDAO.getEm().createNativeQuery(jpql.toString());//createNativeQuery createQuer
       	    List<Object[]> resultado = query.getResultList(); 
		   
       	 if(resultado!=null){
       		 EtapaNpsDTO proceso;
				for(Object[] obj1:resultado){
					proceso = new EtapaNpsDTO();
						 long l1 = Math.round(((Number) obj1[0]).doubleValue());					 
					proceso.setIdEtapa(l1);
					proceso.setEstado(obj1[1].toString());
					retorno.add(proceso);
					}
				}else{
					retorno=null;
				}
	   }

	   return retorno;
	}
	@Override
	public List<EtapaNpsDTO> listarEtapasIds(String idEtapas) {
		List<EtapaNpsDTO> listadto = null;
		List<EtapaNpsDTO> retorno = new ArrayList<EtapaNpsDTO>();
		try {

			idEtapas = formatearIds(idEtapas, ",");
				
				StringBuilder jpql = new StringBuilder();
				jpql.append(" select ns.id_etapa,ns.descripcion,ns.estado,ns.plazo,ns.id_proceso " );
				jpql.append(" FROM nps_etapa ns " );
				jpql.append(" WHERE ns.id_etapa NOT IN (");
				jpql.append(idEtapas);
				jpql.append(")");
				
				System.out.println("QUERYY:::"+jpql.toString());
	        	Query query = crudDAO.getEm().createNativeQuery(jpql.toString());//createNativeQuery createQuery

	        	List<Object[]> resultado = query.getResultList();        	
				
				//ns.id_etapa,ns.descripcion,ns.estado
				if(resultado!=null){
					EtapaNpsDTO proceso;
					for(Object[] obj:resultado){
						proceso = new EtapaNpsDTO();										
							 long l1 = Math.round(((Number) obj[0]).doubleValue());					 
						proceso.setIdEtapa(l1);
						proceso.setDescripcion(obj[1].toString());
						proceso.setEstado(obj[2].toString());
						long l2 = Math.round(((Number) obj[3]).doubleValue());
						String str1 = String.valueOf(l2);
						Long s1 = new Long (str1);
						proceso.setPlazo(s1);
							long l3 = Math.round(((Number) obj[4]).doubleValue());
						ProcesoDTO procesoDTO = new ProcesoDTO();
						procesoDTO.setIdProceso(l3);
						proceso.setIdProceso(procesoDTO);
						retorno.add(proceso);
						}
					}else{
						retorno=null;
					}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}
		public String formatearIds(String listaEtapas,String caracter){
	        StringBuilder sb = null;
	        String etapasFormateado = listaEtapas.trim().isEmpty()?null:listaEtapas;
	        String []arrEtapas = etapasFormateado!=null?listaEtapas.split(caracter):null;
	        if(arrEtapas!=null){
	            sb = new StringBuilder();
	            for (String expediente : arrEtapas) {
	            sb.append("'");
	            sb.append(expediente);
	            sb.append("',");
	            }
	            etapasFormateado = sb.substring(0,sb.length()-1);
	        }
	        return etapasFormateado;
	    }

		@Override
		public EtapaNpsDTO findByIdEtapa(Long idEtapa) {
			NpsEtapa npsEtapa = crudDAO.find(idEtapa, NpsEtapa.class);
			EtapaNpsDTO etapaNpsDTO = EtapaNpsBuilder.toEtapaNpsDTO(npsEtapa);
			return etapaNpsDTO;
		}

}
