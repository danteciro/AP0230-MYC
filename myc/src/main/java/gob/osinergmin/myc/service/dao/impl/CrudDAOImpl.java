package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.common.util.StringUtil;
import gob.osinergmin.myc.domain.PghObliTipiCriterio;
import gob.osinergmin.myc.domain.PghObligacionBaseLegal;
import gob.osinergmin.myc.domain.PghTemaObligacionMaestro;
import gob.osinergmin.myc.domain.PghTrazabilidadObligaciones;
import gob.osinergmin.myc.domain.builder.ObligacionBaseLegalBuilder;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.exception.CrudException;
import gob.osinergmin.myc.util.Constantes;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author Julio Piro
 */
@Repository("crudDAO")
public class CrudDAOImpl implements CrudDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CrudDAOImpl.class);
    @PersistenceContext(unitName = "gob.osinergmin.myc:default")
    private EntityManager em;        

    @Override
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override 
    public <T> T create(T t) {
        LOG.info("inserting " + t.getClass().getName());
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }
    
    @Override 
    public <T> T createWithHistory(T t) throws CrudException {
        LOG.info("inserting withHistory" + t.getClass().getName());
        
        try{
            //obtener codTrazabilidad
            Method m = t.getClass().getMethod("getCodTrazabilidad");
            Object codTrazabilidad=m.invoke(t);
            if(codTrazabilidad==null || codTrazabilidad.equals("")){
                throw new CrudException("El Registro no tiene CodigoTrazabilidad",null);
            }
            //verfifico codTrazabilidad en Tabla Trazabilidad_Obligaciones BD
            m = t.getClass().getMethod("getDatosAuditoria");
            UsuarioDTO usuarioDTO=(UsuarioDTO) m.invoke(t);
            if(!verificarCodigoTrazabilidad(codTrazabilidad.toString(),usuarioDTO)){
                throw new CrudException("Ocurrio un error con el CodigoTrazabilidad, intente nuevamente.",null);
            }
            //////////////////////////////////
            //insertando registro
            t=create(t);
            Object id=this.em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(t);
            this.em.detach(t);
            //////////////////////////////////
            //obtener atributo PK segun annotation @Id, que sera usado en el "setAtributoId"
            String atributoId="";
            for(Field field  : t.getClass().getDeclaredFields()){
                if (field.isAnnotationPresent(Id.class)){
                    char[] caracteres = field.getName().toCharArray();
                    caracteres[0] = Character.toUpperCase(caracteres[0]);
                    atributoId=new String(caracteres);
                    break;
                }
            }
            if(atributoId.equals("")){
                throw new CrudException("La Entidad no tiene campo @Id",null);
            }
            //registro insertado
            Object registro=this.em.find(t.getClass(), id);
            //detach para romper vinculacion con registro de find
            this.em.detach(registro);
            
            //set id = 0 , id no existente para q hibernate genere insert
            m = registro.getClass().getMethod("set"+atributoId,Long.class);
            m.invoke(registro,new Long(0));
            //set estado
            m = registro.getClass().getMethod("setEstado",String.class);
            m.invoke(registro,Constantes.CONSTANTE_ESTADO_INACTIVO);
            //setIdPadre
            m = registro.getClass().getMethod("setIdPadre",Long.class);
            m.invoke(registro,id);
            //set codAccion
            m = registro.getClass().getMethod("setCodAccion",String.class);
            m.invoke(registro,Constantes.CONSTANTE_TRAZABILIDAD_NUEVO);
            
            //merge para generar insert
            this.em.merge(registro);            
        }catch (CrudException ex) {
            LOG.error("error createWithHistory => "+ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }catch(Exception e){
            CrudException e2 = new CrudException("Error createWithHistory", e, true);
            LOG.error("Error en createWithHistory : "+e.getMessage());
            e.printStackTrace();
            throw e2;
        }
        
        return t;
    }

    @Override
    public <T> T find(Object id, Class<T> type) {
        LOG.info("finding " + type.getName() + " by id=" + id.toString());
        return (T) this.em.find(type, id);
    }


    @Override
    public void delete(Object t) {
        LOG.info("deleting " + t.getClass().getName());
//        Object ref = this.em.getReference(t.getClass(), t);
        this.em.remove(t);
    }
    
    @Transactional
    public void deleteAll( Object t ) {
	LOG.info("deleting " + t.getClass().getName());
	this.em.remove(em.merge(t));
    }
    
    @Override
    public <T> T deleteCompuesto(Class<T> type, Object o) {
        LOG.info("deleting clave compuesta" + type.getClass().getName());
        Object ref = this.em.find(type, o);
        this.em.remove(ref);  
        //this.em.flush();
        return null;     
    }
   
    @Override
    public <T> T update(T t) {
        LOG.info("updating " + t.getClass().getName());
        return (T) this.em.merge(t);
        
    }
        
    /**
     * Actualiza un registro, creando previamente un registro nuevo con los datos anteriores del registro
     * agrega dato del campo idPadreTrazabilidad = el id del registro original
     * agrega dato del campo claveUnicaTrazabilidad
     * @param t, objeto a actualizar
     * @param claveUnicaTrazabilidad
     * @return el registro actualizado
     * @throws Exception si la tabla no tiene un atributo @Id
     */
    @Override
    public <T> T updateWithHistory(T t) throws CrudException {
        LOG.info("updating with history " + t.getClass().getName());
        try{
            //detach para romper vinculacion con registro "t" por si viene de algun find
            this.em.detach(t);
            //obtener atributo PK segun annotation @Id, que sera usado en el "setAtributoId"
            String atributoId="";
            for(Field field  : t.getClass().getDeclaredFields()){
                if (field.isAnnotationPresent(Id.class)){
                    char[] caracteres = field.getName().toCharArray();
                    caracteres[0] = Character.toUpperCase(caracteres[0]);
                    atributoId=new String(caracteres);
                    break;
                }
            }
            if(atributoId.equals("")){
                throw new CrudException("La Entidad no tiene campo @Id",null);
            }
            //obtener id registro
            Object id=this.em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(t);
            //registro original
            Object registro=this.em.find(t.getClass(), id);
            //detach para romper vinculacion con registro de find
            this.em.detach(registro);
            
            //obtener codTrazabilidad y estado
            Method m = t.getClass().getMethod("getCodTrazabilidad");
            Object codTrazabilidad=m.invoke(t);
            m = t.getClass().getMethod("getEstado");
            Object estado=m.invoke(t);
            if(codTrazabilidad==null || codTrazabilidad.equals("")){
                throw new CrudException("El Registro no tiene CodigoTrazabilidad",null);
            }
            //verfifico codTrazabilidad en Tabla Trazabilidad_Obligaciones BD
            m = t.getClass().getMethod("getDatosAuditoria");
            UsuarioDTO usuarioDTO=(UsuarioDTO) m.invoke(t);
            if(!verificarCodigoTrazabilidad(codTrazabilidad.toString(),usuarioDTO)){
                throw new CrudException("Ocurrio un problema con el registro de Trazabilidad, intente nuevamente.",null);
            }
            
            //set id = 0 , id no existente para q hibernate genere insert
            m = registro.getClass().getMethod("set"+atributoId,Long.class);
            m.invoke(registro,new Long(0));
            //set estado
            m = registro.getClass().getMethod("setEstado",String.class);
            m.invoke(registro,Constantes.CONSTANTE_ESTADO_INACTIVO);
            //setIdPadre
            m = registro.getClass().getMethod("setIdPadre",Long.class);
            m.invoke(registro,id);
            //setCodTrazabilidad
            m = registro.getClass().getMethod("setCodTrazabilidad",String.class);
            m.invoke(registro,codTrazabilidad.toString());
            //set codAccion
            m = registro.getClass().getMethod("setCodAccion",String.class);
            if(estado.toString().equals(Constantes.CONSTANTE_ESTADO_ACTIVO)){
                m.invoke(registro,Constantes.CONSTANTE_TRAZABILIDAD_MODIFICAR);
            }else{
                m.invoke(registro,Constantes.CONSTANTE_TRAZABILIDAD_ELIMINAR);
            }
            
            //merge para generar insert
            this.em.merge(registro);
        }catch (CrudException ex) {
            LOG.error("error updateWithHistory => "+ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }catch(Exception e){
            CrudException e2 = new CrudException("Error updateWithHistory", e, true);
            LOG.error("Error en updateWithHistory : "+e.getMessage());
            e.printStackTrace();
            throw e2;
        }
        
        return (T) this.em.merge(t);
    }

    public boolean verificarCodigoTrazabilidad(String codTrazabilidad,UsuarioDTO usuarioDto){
        LOG.info("verificarCodigoTrazabilidad CRUD");
        boolean retorno=true;
        String partes[]=codTrazabilidad.split("_");
        Long idTrazabilidad=new Long(partes[1]);
        if(idTrazabilidad!=null && idTrazabilidad!=0 && usuarioDto!=null){
            //verificar si se debe insertar en BD XD
            PghTrazabilidadObligaciones registro=this.em.find(PghTrazabilidadObligaciones.class, idTrazabilidad);
            if(registro==null){
                PghTrazabilidadObligaciones registroCreado=new PghTrazabilidadObligaciones();
                registroCreado.setIdTrazabilidad(idTrazabilidad);
                registroCreado.setCodTrazabilidad(codTrazabilidad);
                registroCreado.setFechaVigencia(new Date());
                registroCreado.setDatosAuditoria(usuarioDto);
                create(registroCreado);
            }
        }else{
            retorno=false;
        }
        return retorno;
    }
    
    @Override
    public List<Object> findByNamedQuery(String namedQueryName) {
        LOG.info("finding by named query :" + namedQueryName);
        return this.em.createNamedQuery(namedQueryName).getResultList();
    }

    @Override
    public List<Object> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters) {

        return findByNamedQuery(namedQueryName, parameters, 0);
    }

    @Override
    public List<Object> findByNamedQuery(String namedQueryName, int resultLimit) {
        LOG.info("finding by named query :" + namedQueryName);
        return this.em.createNamedQuery(namedQueryName).
                setMaxResults(resultLimit).
                getResultList();
    }

    @Override
    public List<Object> findByNamedQuery(String namedQueryName,
            Map<String, Object> parameters, int resultLimit) {
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        LOG.info("finding by named query :" + namedQueryName);
        Query query = this.em.createNamedQuery(namedQueryName);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    @Override
    public List<Object> findByNativeQuery(String nativeQuery, Map<String, Object> parameters) {
        return findByNativeQuery(nativeQuery, parameters, 0);
    }

    @Override
    public List<Object> findByNativeQuery(String nativeQuery, Map<String, Object> parameters, int resultLimit) {
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        LOG.info("finding by natived query :" + nativeQuery);
        Query query = this.em.createNativeQuery(nativeQuery);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }
    
    @Override
    public Integer actualizarByNamedQuery(String namedQueryName,
            Map<String, Object> parameters) {
        Integer registrosActualizados=new Integer(0);
	Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        LOG.info("actualizando by named query :" + namedQueryName);
        Query query = this.em.createNamedQuery(namedQueryName);       
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        registrosActualizados =query.executeUpdate();
        return registrosActualizados;
    }
    
    @Override
    public Long findSequence(String sequence){
		Long resultado=new Long(0);
		BigDecimal consulta;
		Query query = this.em.createNativeQuery("select " + sequence + ".NEXTVAL from dual");
		consulta = (BigDecimal) query.getSingleResult();
		resultado=consulta.longValue();
		LOG.info("Seq: "+resultado);
		return resultado;
		
	}

	@Override
	public List<ObligacionBaseLegalDTO> findListObligacionesAct(Long o) {
		List<ObligacionBaseLegalDTO> listaObjetos=null;
		LOG.info("CRUD <-> (Ingresando)... " + "==> Id: " + o);

		StringBuilder jpql = new StringBuilder();
		jpql.append("Select p From PghObligacionBaseLegal p ");
		jpql.append("Where p.estado='1'");
		if (!StringUtil.isEmptyNum(o)) {
			jpql.append("and p.idBaseLegal.idBaseLegal=:idBaseLegal");
		}

		Query query = getEm().createQuery(jpql.toString());
		if (!StringUtil.isEmptyNum(o)) {
			query.setParameter("idBaseLegal",o);
		}
		List<PghObligacionBaseLegal>  listado = query.getResultList();   
		LOG.info("Listado: " + listado.toString());
		
		if(!CollectionUtils.isEmpty(listado)){
			listaObjetos=ObligacionBaseLegalBuilder.toListObligacionBaseLegalDto(listado);
		}

		LOG.info("CRUD <-> (Saliendo)...");
		return listaObjetos;
	}

	@Override
	public PghObligacionBaseLegal findObject(Long n) {
		LOG.info("CRUD <-> (Ingresando)... " + "==> Id: " + n);
		PghObligacionBaseLegal pghObligacionBaseLegal=null;
		StringBuilder jpql = new StringBuilder();
		jpql.append("Select p From PghObligacionBaseLegal p ");
		jpql.append("Where p.estado='1'");
		if (!StringUtil.isEmptyNum(n)) {
			jpql.append("and p.idOblBase=:idOblBase");
		}
		Query query = getEm().createQuery(jpql.toString());
		if (!StringUtil.isEmptyNum(n)) {
			query.setParameter("idOblBase",n);
		}
		pghObligacionBaseLegal =  (PghObligacionBaseLegal) query.getResultList().get(0);
		LOG.info("CRUD <-> (Saliendo)..."+pghObligacionBaseLegal);
		return pghObligacionBaseLegal;
	}

	@Override
	public List<ObligacionBaseLegalDTO> findRelacionOblg(
			ObligacionBaseLegalDTO obligacionBaseLegalDTO) {
		LOG.info("CRUD <-> (Ingresando)... " + "==> Id: " + obligacionBaseLegalDTO.getIdObligacion());
		Long n=obligacionBaseLegalDTO.getIdObligacion();
		List<ObligacionBaseLegalDTO> pghObligacionBaseLegalDTO=null;
		StringBuilder jpql = new StringBuilder();
		jpql.append("Select distinct p.idBaseLegal.idBaseLegal,p.idObligacion.idObligacion,p.estado From PghObligacionBaseLegal p ");
		if (!StringUtil.isEmptyNum(n)) {
			jpql.append("Where p.idObligacion.idObligacion=:idObligacion");
		}
		Query query = getEm().createQuery(jpql.toString());
		if (!StringUtil.isEmptyNum(n)) {
			query.setParameter("idObligacion",n);
		}
		List<Object[]> listado=  query.getResultList();
		
		if(!CollectionUtils.isEmpty(listado)){
			pghObligacionBaseLegalDTO=ObligacionBaseLegalBuilder.toListObligacionBaseLegalDtoObjOblg(listado);
		}
		
		LOG.info("CRUD <-> (Saliendo)..."+pghObligacionBaseLegalDTO);
		return pghObligacionBaseLegalDTO;
	}
	
	@Override
	public PghObligacionBaseLegal findBlOblg(Long idOblBl,Long idBaseLegal,Long idObligacion) {
		LOG.info("CRUD <-> (Ingresando)... " + "==> Id: " + idOblBl+" , "+idBaseLegal+" , "+idObligacion);
		
		StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p From PghObligacionBaseLegal p ");
        jpql.append("where p.idOblBase=:idOblgBaseLegal ");
        jpql.append("and p.idBaseLegal.idBaseLegal=:idBaseLegal ");
        jpql.append("and p.idObligacion.idObligacion=:idObligacion ");
        
		Query 	query = getEm().createQuery(jpql.toString());
		query.setParameter("idOblgBaseLegal",idOblBl);
		query.setParameter("idBaseLegal",idBaseLegal);
		query.setParameter("idObligacion",idObligacion);
		
        LOG.info("query find Obligacion Base Legal: " + jpql.toString());
        PghObligacionBaseLegal  resultado = (PghObligacionBaseLegal) query.getResultList().get(0);  
        System.out.println(" Lista Relacion O - B ->"+resultado);

		return resultado;
	}

	@Override
	public PghTemaObligacionMaestro findTemaObligacion(Long idObligacion,
			Long idTemaObligacion) {
		LOG.info("CRUD <-> (Ingresando)... " + "Encontrar Temas==> Ids: " + idObligacion+" , "+idTemaObligacion);
		
		StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p From PghTemaObligacionMaestro p ");
        jpql.append("where p.estado='1' and p.idTemaObligacion=:idTemaObligacion ");
        jpql.append("and p.idObligacion.idObligacion=:idObligacion ");
        
		Query 	query = getEm().createQuery(jpql.toString());
		query.setParameter("idTemaObligacion",idTemaObligacion);
		query.setParameter("idObligacion",idObligacion);
		
        LOG.info("query find Obligacion Base Legal: " + jpql.toString());
        PghTemaObligacionMaestro  resultado = (PghTemaObligacionMaestro) query.getResultList().get(0);  
        System.out.println(" Tema ->"+resultado);

		return resultado;
	}

	@Override
	public PghObliTipiCriterio findCrOblg(Long idObliTipiCriterio,Long idCriterio, Long idTipificacion) {
		
		LOG.info("CRUD <-> (Ingresando)... " + "==> Id: " + idObliTipiCriterio+" , "+idCriterio+" , "+idTipificacion);		
		StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p From PghObliTipiCriterio p ");
        jpql.append("where p.idObliTipiCriterio=:idObliTipiCriterio ");
        jpql.append("and p.idCriterio.idCriterio=:idCriterio ");
        jpql.append("and p.idTipificacion.idTipificacion=:idTipificacion ");
        
		Query 	query = getEm().createQuery(jpql.toString());
		query.setParameter("idObliTipiCriterio",idObliTipiCriterio);
		query.setParameter("idCriterio",idCriterio);
		query.setParameter("idTipificacion",idTipificacion);
		
        LOG.info("query find Tipificacion Criterio: " + jpql.toString());
        PghObliTipiCriterio  resultado = (PghObliTipiCriterio) query.getResultList().get(0);  
        System.out.println(" Lista Relacion O - B ->"+resultado);

		return resultado;	
	}
	
        
}

