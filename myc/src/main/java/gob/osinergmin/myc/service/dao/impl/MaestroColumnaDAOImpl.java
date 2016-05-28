package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.MdiMaestroTabla;
import gob.osinergmin.myc.domain.builder.MaestroColumnaBuilder;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.MaestroColumnaFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.MaestroColumnaDAO;
import gob.osinergmin.myc.service.exception.MaestroColumnaException;
import gob.osinergmin.myc.util.Constantes;
import javax.persistence.Query;

@Service("maestroColumnaDAO")
public class MaestroColumnaDAOImpl implements MaestroColumnaDAO{
    private static final Logger LOG = LoggerFactory.getLogger(MaestroColumnaDAOImpl.class);
    @Inject
    private CrudDAO crud;

    @Override
    public MaestroColumnaDTO changeState(MaestroColumnaDTO maestroColumnaDTO,UsuarioDTO usuarioDTO){
        MaestroColumnaDTO retorno = null;
        try{
            MdiMaestroColumna registro = crud.find(maestroColumnaDTO.getIdMaestroColumna(), MdiMaestroColumna.class);
            registro.setEstado(maestroColumnaDTO.getEstado());
            crud.update(registro);
            retorno = MaestroColumnaBuilder.getMaestroColumnaDTO(registro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @Override
    public MaestroColumnaDTO update(MaestroColumnaDTO maestroColumnaDTO,UsuarioDTO usuarioDTO) throws MaestroColumnaException{
        MaestroColumnaDTO retorno = null;
        try{
            List<MaestroColumnaDTO> listaValida=find(new MaestroColumnaFilter(maestroColumnaDTO.getAplicacion(),maestroColumnaDTO.getDominio(),maestroColumnaDTO.getDescripcion()));
            if(!listaValida.isEmpty() && !listaValida.get(0).getIdMaestroColumna().equals(maestroColumnaDTO.getIdMaestroColumna()) ){
                //throw new MaestroColumnaException("Ya existe un Registro con la descripci&oacute;n indicada.",null);
                throw new MaestroColumnaException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Valor.",null);
            }
            
            MdiMaestroColumna registro = crud.find(maestroColumnaDTO.getIdMaestroColumna(), MdiMaestroColumna.class);
            registro.setDescripcion(maestroColumnaDTO.getDescripcion());
            registro.setCodigo(maestroColumnaDTO.getCodigo());
            registro.setMdiMaestroTabla(new MdiMaestroTabla(maestroColumnaDTO.getDominio(), maestroColumnaDTO.getAplicacion()));
            registro.setDatosAuditoria(usuarioDTO);
            crud.update(registro);
            retorno = MaestroColumnaBuilder.getMaestroColumnaDTO(registro);
        }catch (MaestroColumnaException ex) {
            LOG.error("error update = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error update... ",ex);
            MaestroColumnaException e2 = new MaestroColumnaException(MaestroColumnaException.ERROR_EDITAR_MAESTRO_COLUMNA, ex, true);
            throw e2;
        }
        return retorno;
    }
    @Override
    public MaestroColumnaDTO create(MaestroColumnaDTO maestroColumnaDTO,UsuarioDTO usuarioDTO) throws MaestroColumnaException{
        MaestroColumnaDTO retorno = null;
        try{
            List<MaestroColumnaDTO> listaValida=find(new MaestroColumnaFilter(maestroColumnaDTO.getAplicacion(),maestroColumnaDTO.getDominio(),maestroColumnaDTO.getDescripcion()));
            if(!listaValida.isEmpty()){
                //throw new MaestroColumnaException("Ya existe un Registro con la descripci&oacute;n indicada.",null);
                throw new MaestroColumnaException(Constantes.CONSTANTE_MSJE_YA_EXISTE+" Valor.",null);
            }
            
            MdiMaestroColumna registro=MaestroColumnaBuilder.getMdiMaestroColumna(maestroColumnaDTO);
            registro.setDatosAuditoria(usuarioDTO);
            crud.create(registro);
            retorno = MaestroColumnaBuilder.getMaestroColumnaDTO(registro);
        }catch (MaestroColumnaException ex) {
            LOG.error("error create = ",ex);
            throw ex;
        }catch(Exception ex){
            LOG.error("error create... ",ex);
            MaestroColumnaException e2 = new MaestroColumnaException(MaestroColumnaException.ERROR_CREAR_MAESTRO_COLUMNA, ex, true);
            throw e2;
        }
        return retorno;
    }
    
    @Override
    public Long count(MaestroColumnaFilter filtro) throws MaestroColumnaException {
        Query query = getFindQuery(filtro, true);
        return (Long) query.getSingleResult();
    }
    @Override
    public List<MaestroColumnaDTO> find(MaestroColumnaFilter filtro) throws MaestroColumnaException {
        List<MaestroColumnaDTO> listado;
        Query query = getFindQuery(filtro, false);
        if (filtro.getStartIndex() != null && filtro.getResultsNumber() != null) {
            query.setFirstResult(filtro.getStartIndex());
            query.setMaxResults(filtro.getResultsNumber());
        }
        listado = MaestroColumnaBuilder.getMaestroColumnaDTOList(query.getResultList());

        return listado;
    }
    
    @Override
    public MaestroColumnaDTO findById(Long idMaestroColumna) throws MaestroColumnaException {
        MaestroColumnaDTO retorno=null;
        
        MdiMaestroColumna registro=crud.find(idMaestroColumna, MdiMaestroColumna.class);
        if(registro!=null){
            retorno = MaestroColumnaBuilder.getMaestroColumnaDTO(registro);
        }       

        return retorno;
    }
    
    private Query getFindQuery(MaestroColumnaFilter filtro, boolean count) {
        Query query=null;
        try{
            if (count) {
                if (filtro.getDominio()!= null && !filtro.getDominio().equals("") && filtro.getAplicacion()!= null && !filtro.getAplicacion().equals("")) {
                    query = crud.getEm().createNamedQuery("MdiMaestroColumna.countByFilter");
                }else {
                    query = crud.getEm().createNamedQuery("MdiMaestroColumna.countAll");
                }
            }else {
                if(filtro.getDescripcion()!=null && filtro.getAplicacion()!=null && filtro.getDominio()!=null){
                    query = crud.getEm().createNamedQuery("MdiMaestroColumna.findByValidate");
                }else if (filtro.getDominio()!= null && !filtro.getDominio().equals("") && filtro.getAplicacion()!= null && !filtro.getAplicacion().equals("")) {
                    query = crud.getEm().createNamedQuery("MdiMaestroColumna.findByFilter");
                }else {
                    query = crud.getEm().createNamedQuery("MdiMaestroColumna.findAll");
                }
            }

            if (filtro.getDominio()!= null && !filtro.getDominio().equals("")) {
                query.setParameter("dominio",filtro.getDominio());
            }
            if (filtro.getAplicacion()!= null && !filtro.getAplicacion().equals("")) {
                query.setParameter("aplicacion",filtro.getAplicacion());
            }
            if (filtro.getDescripcion()!= null && !filtro.getDescripcion().equals("")) {
                query.setParameter("descripcion",filtro.getDescripcion());
            }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        
        return query;
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<MaestroColumnaDTO> findMaestroColumna(String dominio, String aplicacion){
                    LOG.info("entro findMaestroColumna");
            List<MaestroColumnaDTO> listaMaestroColumnaDTO = null;
            try {                	
                    List<MdiMaestroColumna> listaMaestroColumna = null;
                    Map<String, Object> parameters = new HashMap<String, Object>();
                    parameters.put("dominio", dominio);
                    parameters.put("aplicacion", aplicacion);
                    listaMaestroColumna = crud.findByNamedQuery("MdiMaestroColumna.findByDominioAplicacion", parameters);       	
                    listaMaestroColumnaDTO = MaestroColumnaBuilder.getMaestroColumnaDTOList(listaMaestroColumna);
            } catch (Exception e) {  
                    LOG.error("error", e);
                    e.printStackTrace();
            }
            return listaMaestroColumnaDTO;
        }
	 
        @Override
        @Transactional(readOnly=true)
        public List<MaestroColumnaDTO> findByDescripHijos(Long idMaestroColumna,String aplicacion, String estado){
            LOG.info("entro findByDescripHijos");
            List<MaestroColumnaDTO> listaMaestroColumnaDTO = null;
            try {                	
                    List<MdiMaestroColumna> listaMaestroColumna = null;
                    Map<String, Object> parameters = new HashMap<String, Object>();
                    parameters.put("aplicacion",aplicacion);
                    //parameters.put("estado",estado);
                    parameters.put("idMaestroColumna",idMaestroColumna);
                    listaMaestroColumna = crud.findByNamedQuery("MdiMaestroColumna.findByDescripHijos", parameters);  
                    listaMaestroColumnaDTO = MaestroColumnaBuilder.getMaestroColumnaDTOList(listaMaestroColumna);
            } catch (Exception e) {  
                    LOG.error("error", e);
            }
            return listaMaestroColumnaDTO;
        }
        
        @Override
		@Transactional(readOnly=true)
		public List<MaestroColumnaDTO> findTipoNormaLegal() throws Exception{
        	LOG.info("entro findTipoNormaLegal");
        	List<MaestroColumnaDTO> listaMaestroColumnaDTO = null;
        	try{
		        	
		        	List<MdiMaestroColumna> listaMaestroColumna = null;
	                Map<String, Object> parameters = new HashMap<String, Object>();
	                String dominio="TIPO_NORMALEGAL";
	                String aplicacion="OBLIGACIONES";
	                parameters.put("dominio", dominio);
	                parameters.put("aplicacion", aplicacion);
	                LOG.info("parametros: "+parameters);
	                listaMaestroColumna = crud.findByNamedQuery("MdiMaestroColumna.findByDominioAplicacion", parameters);   
	                LOG.info("TIPO NORMA LEGAL BD"+listaMaestroColumna);
	                listaMaestroColumnaDTO = MaestroColumnaBuilder.getMaestroColumnaDTOList(listaMaestroColumna);
			        LOG.info("TIPO NORMA LEGAL DTO: "+listaMaestroColumnaDTO +"TIPO NORMA LEGAL BD"+listaMaestroColumna);

		        }catch(Exception e){
		        	LOG.error("error", e);
		        }
		        return listaMaestroColumnaDTO;
		    }
		    @Override
		    @Transactional(readOnly=true)
		    public List<MaestroColumnaDTO> findComponente() throws Exception{
		        List<MaestroColumnaDTO> listado = null;
		        try{
		        listado = new ArrayList<MaestroColumnaDTO>();
		        MaestroColumnaDTO componente1=new MaestroColumnaDTO();
		        componente1.setIdComponente(new Long(1));
		        componente1.setDescripcionComponente("Baterias");
		        componente1.setIdActividad(new Long(13));
		        listado.add(componente1);
		        }catch(Exception e){
		        	LOG.error("error", e);
		        }
		        return listado;
		    }
		    @Override
		    @Transactional(readOnly=true)
		    public List<MaestroColumnaDTO> findSigla() throws Exception{
		    	LOG.info("entro findSigla");
		    	List<MaestroColumnaDTO> listaMaestroColumnaDTO = null;
		        try{
		        List<MdiMaestroColumna> listaMaestroColumna = null;
                Map<String, Object> parameters = new HashMap<String, Object>();
                String dominio="SIGLA_BASELEGAL";
                String aplicacion="OBLIGACIONES";
                parameters.put("dominio", dominio);
                parameters.put("aplicacion", aplicacion);
                LOG.info("parametros: "+parameters);
                listaMaestroColumna = crud.findByNamedQuery("MdiMaestroColumna.findByDominioAplicacion", parameters);       	
                listaMaestroColumnaDTO = MaestroColumnaBuilder.getMaestroColumnaDTOList(listaMaestroColumna);
		        LOG.info("SIGLAS DTO: "+listaMaestroColumnaDTO +"SIGLAS BD"+listaMaestroColumna);
		        }catch(Exception e){
		            LOG.error(e.getMessage());
		        }
		        return listaMaestroColumnaDTO;
		    }
		    @Override
		    @Transactional(readOnly=true)
		    public List<MaestroColumnaDTO> findTipoAnexo() throws Exception{
		    	LOG.info("entro findTipoAnexo");
	        	List<MaestroColumnaDTO> listaMaestroColumnaDTO = null;
	        	try{
			        	
			        	List<MdiMaestroColumna> listaMaestroColumna = null;
		                Map<String, Object> parameters = new HashMap<String, Object>();
		                String dominio="TIPO_ANEXONORMA";
		                String aplicacion="OBLIGACIONES";
		                parameters.put("dominio", dominio);
		                parameters.put("aplicacion", aplicacion);
		                LOG.info("parametros: "+parameters);
		                listaMaestroColumna = crud.findByNamedQuery("MdiMaestroColumna.findByDominioAplicacion", parameters);   
		                LOG.info("TIPO ANEXO BD"+listaMaestroColumna);
		                listaMaestroColumnaDTO = MaestroColumnaBuilder.getMaestroColumnaDTOList(listaMaestroColumna);
				        LOG.info("TIPO ANEXO DTO: "+listaMaestroColumnaDTO +"TIPO ANEXO BD"+listaMaestroColumna);

			        }catch(Exception e){
			        	LOG.error("error", e);
			        }
			        return listaMaestroColumnaDTO;

		    }
		    @Override
		    @Transactional(readOnly=true)
		    public List<MaestroColumnaDTO> findTemas() throws Exception{
		        List<MaestroColumnaDTO> listado = null;
		        try{
		        listado = new ArrayList<MaestroColumnaDTO>();
		        MaestroColumnaDTO tema1=new MaestroColumnaDTO();
		        tema1.setIdTemaObligacion(new Long(1));
		        tema1.setDescripcionTemaObligacion("Almacenamiento");
		        listado.add(tema1);
		        
		        MaestroColumnaDTO tema2=new MaestroColumnaDTO();
		        tema2.setIdTemaObligacion(new Long(2));
		        tema2.setDescripcionTemaObligacion("Aportes por Regulaci\u00F3n");
		        listado.add(tema2);
		        
		        MaestroColumnaDTO tema3=new MaestroColumnaDTO();
		        tema3.setIdTemaObligacion(new Long(3));
		        tema3.setDescripcionTemaObligacion("Calidad (de Combustibles en Estab. Venta al P\u00FAblico y Plantas Abastecimiento)");
		        listado.add(tema3);
		        
		        MaestroColumnaDTO tema4=new MaestroColumnaDTO();
		        tema4.setIdTemaObligacion(new Long(4));
		        tema4.setDescripcionTemaObligacion("Cilindros GLP - Varios (Peso Neto, Canje, Pintado)");
		        listado.add(tema4);
		        
		        MaestroColumnaDTO tema5=new MaestroColumnaDTO();
		        tema5.setIdTemaObligacion(new Long(5));
		        tema5.setDescripcionTemaObligacion("Comerciales");
		        listado.add(tema5);
		        
		        MaestroColumnaDTO tema6=new MaestroColumnaDTO();
		        tema6.setIdTemaObligacion(new Long(6));
		        tema6.setDescripcionTemaObligacion("Distancias, Accesos, Circulaci\u00F3n y Radios de Giro");
		        listado.add(tema6);
		        
		        MaestroColumnaDTO tema7=new MaestroColumnaDTO();
		        tema7.setIdTemaObligacion(new Long(7));
		        tema7.setDescripcionTemaObligacion("El\u00E9ctricos");
		        listado.add(tema7);
		        
		        MaestroColumnaDTO tema8=new MaestroColumnaDTO();
		        tema8.setIdTemaObligacion(new Long(8));
		        tema8.setDescripcionTemaObligacion("Generales");
		        listado.add(tema8);
		        
		        MaestroColumnaDTO tema9=new MaestroColumnaDTO();
		        tema9.setIdTemaObligacion(new Long(9));
		        tema9.setDescripcionTemaObligacion("Inspecci\u00F3n de Cilindros de GLP");
		        listado.add(tema9);
		        
		        MaestroColumnaDTO tema10=new MaestroColumnaDTO();
		        tema10.setIdTemaObligacion(new Long(10));
		        tema10.setDescripcionTemaObligacion("Instrumentaci\u00F3n");
		        listado.add(tema10);
		        
		        MaestroColumnaDTO tema11=new MaestroColumnaDTO();
		        tema11.setIdTemaObligacion(new Long(11));
		        tema11.setDescripcionTemaObligacion("Mec\u00E1nicos");
		        listado.add(tema11);
		        
		        MaestroColumnaDTO tema12=new MaestroColumnaDTO();
		        tema12.setIdTemaObligacion(new Long(12));
		        tema12.setDescripcionTemaObligacion("Metrol\u00F3gico");
		        listado.add(tema12);
		        
		        MaestroColumnaDTO tema13=new MaestroColumnaDTO();
		        tema13.setIdTemaObligacion(new Long(13));
		        tema13.setDescripcionTemaObligacion("Operaciones");
		        listado.add(tema13);
		        
		        MaestroColumnaDTO tema14=new MaestroColumnaDTO();
		        tema14.setIdTemaObligacion(new Long(14));
		        tema14.setDescripcionTemaObligacion("Se\u00f1alizaciones y Equipos de Seguridad");
		        listado.add(tema14);
		        
		        MaestroColumnaDTO tema15=new MaestroColumnaDTO();
		        tema15.setIdTemaObligacion(new Long(15));
		        tema15.setDescripcionTemaObligacion("Sistemas Contra Incendio");
		        listado.add(tema15);
		        
		        MaestroColumnaDTO tema16=new MaestroColumnaDTO();
		        tema16.setIdTemaObligacion(new Long(16));
		        tema16.setDescripcionTemaObligacion("Transitorias o Complementarias");
		        listado.add(tema16);
		        
		        }catch(Exception e){
		            LOG.error(e.getMessage());
		        }
		        return listado;
		    }
		    @Override
		    @Transactional(readOnly=true)
		    public List<MaestroColumnaDTO> findCriticidad() throws Exception{
		    	LOG.info("entro findCriticidad");
	        	List<MaestroColumnaDTO> listaMaestroColumnaDTO = null;
	        	try{
			        	
			        	List<MdiMaestroColumna> listaMaestroColumna = null;
		                Map<String, Object> parameters = new HashMap<String, Object>();
		                String dominio="PGH_OBLIG_CRITIC";
		                String aplicacion="OBLIGACIONES";
		                parameters.put("dominio", dominio);
		                parameters.put("aplicacion", aplicacion);
		                LOG.info("parametros: "+parameters);
		                listaMaestroColumna = crud.findByNamedQuery("MdiMaestroColumna.findByDominioAplicacion", parameters);   
		                LOG.info("TIPO CRITICIDAD BD"+listaMaestroColumna);
		                listaMaestroColumnaDTO = MaestroColumnaBuilder.getMaestroColumnaDTOList(listaMaestroColumna);
				        LOG.info("TIPO CRITICIDAD DTO: "+listaMaestroColumnaDTO +"TIPO CRITICIDAD BD"+listaMaestroColumna);

			        }catch(Exception e){
			        	LOG.error("error", e);
			        }
			        return listaMaestroColumnaDTO;
		        
		        
		    }
		    @Override
		    @Transactional(readOnly=true)
		    public List<MaestroColumnaDTO> findNormaTecnica() throws Exception{
		    	LOG.info("entro findTipoNormaTecnica");
	        	List<MaestroColumnaDTO> listaMaestroColumnaDTO = null;
	        	try{
			        	
			        	List<MdiMaestroColumna> listaMaestroColumna = null;
		                Map<String, Object> parameters = new HashMap<String, Object>();
		                String dominio="TIPO_NORMATECNICA";
		                String aplicacion="OBLIGACIONES";
		                parameters.put("dominio", dominio);
		                parameters.put("aplicacion", aplicacion);
		                LOG.info("parametros: "+parameters);
		                listaMaestroColumna = crud.findByNamedQuery("MdiMaestroColumna.findByDominioAplicacion", parameters);   
		                LOG.info("TIPO NORMA TECNICA BD"+listaMaestroColumna);
		                listaMaestroColumnaDTO = MaestroColumnaBuilder.getMaestroColumnaDTOList(listaMaestroColumna);
				        LOG.info("TIPO NORMA TECNICA DTO: "+listaMaestroColumnaDTO +"TIPO NORMA TECNICA BD"+listaMaestroColumna);

			        }catch(Exception e){
			        	LOG.error("error", e);
			        }
			        return listaMaestroColumnaDTO;
		    }
}
