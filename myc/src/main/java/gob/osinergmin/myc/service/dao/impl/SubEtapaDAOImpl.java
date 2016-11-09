package gob.osinergmin.myc.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import gob.osinergmin.myc.domain.MdiMaestroColumna;
import gob.osinergmin.myc.domain.NpsEtapa;
import gob.osinergmin.myc.domain.NpsSubetapa;
import gob.osinergmin.myc.domain.builder.SubEtapaNpsBuilder;
import gob.osinergmin.myc.domain.dto.EtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.SubEtapaNpsDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.SubEtapaNpsFilter;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.SubEtapaNpsDAO;
import gob.osinergmin.myc.util.Constantes;

@Repository("SubEtapaDAO")
public class SubEtapaDAOImpl implements SubEtapaNpsDAO{

	@Inject
	private CrudDAO crudDAO;
	
	@Override
	public SubEtapaNpsDTO create(SubEtapaNpsDTO subEtapaNpsDTO,UsuarioDTO usuarioDTO) {
		NpsSubetapa npsSubetapa = SubEtapaNpsBuilder.toSubEtapaNps(subEtapaNpsDTO);
	    npsSubetapa.setEstado(Constantes.ESTADO_ACTIVO);
		npsSubetapa.setDatosAuditoria(usuarioDTO);
		crudDAO.create(npsSubetapa);
		return subEtapaNpsDTO;
	}

	@Override
	public SubEtapaNpsDTO update(SubEtapaNpsDTO subEtapaNpsDTO,UsuarioDTO usuarioDTO) {
		NpsSubetapa  npsSubetapa = SubEtapaNpsBuilder.toSubEtapaNps(subEtapaNpsDTO);
		npsSubetapa.setDatosAuditoria(usuarioDTO);
		npsSubetapa.setEstado(Constantes.ESTADO_ACTIVO);
		crudDAO.update(npsSubetapa);
		return subEtapaNpsDTO;
	}

	@Override
	public List<SubEtapaNpsDTO> listar(SubEtapaNpsFilter subEtapaNpsFilter) {
		Query query = null;
		
		if(subEtapaNpsFilter.getIdEtapa()!=null && subEtapaNpsFilter.getIdEtapa().getIdEtapa()!=null){
			query = crudDAO.getEm().createNamedQuery("NpsSubetapa.findByIdEtapa");
			query.setParameter("idEtapa", subEtapaNpsFilter.getIdEtapa().getIdEtapa());
		}else{
			query = crudDAO.getEm().createNamedQuery("NpsSubetapa.findAll");
		}
		
		List<NpsSubetapa> lista = query.getResultList();
	    List<SubEtapaNpsDTO> listadto = SubEtapaNpsBuilder.toListSubEtapaDTO(lista);
		return listadto;
	}
	
	/* OSINE_SFS-1232 - RSIS 6 - Inicio */
	@Override
	public List<SubEtapaNpsDTO> listarSubEtapas(String listaEtapas) {
		List<SubEtapaNpsDTO> listadto = null;
		List<SubEtapaNpsDTO> retorno = new ArrayList<SubEtapaNpsDTO>();
		listaEtapas = formatearIds(listaEtapas, ",");
		try {			
			
			StringBuilder jpql = new StringBuilder();
			jpql.append(" select ns.id_subetapa,ns.descripcion,ns.estado,ns.tiempo_dias,ns.id_etapa,ns.id_responsable " );
			jpql.append("  FROM nps_subetapa ns " );
			jpql.append(" WHERE ns.id_etapa IN (");
			jpql.append(listaEtapas);
			jpql.append(")");
			jpql.append(" and ns.estado = '1' " );
			jpql.append(" order by ns.id_etapa ");
			
			System.out.println("QUERYY:::"+jpql.toString());
        	Query query = crudDAO.getEm().createNativeQuery(jpql.toString());//createNativeQuery createQuery

        	List<Object[]> resultado = query.getResultList();        	
			
			//ns.id_subetapa,ns.descripcion,ns.estado,ns.tiempo_dias,ns.id_etapa,ns.id_responsable,ne.descripcion,mc.descripcion
			if(resultado!=null){
				SubEtapaNpsDTO proceso;
				for(Object[] obj:resultado){
					proceso = new SubEtapaNpsDTO();
					//ns.id_subetapa,ns.descripcion,ns.estado,ns.tiempo_dias,ns.id_etapa,ns.id_responsable					
						 long l1 = Math.round(((Number) obj[0]).doubleValue());					 
					proceso.setIdSubetapa(l1);
					proceso.setDescripcion(obj[1].toString());
					proceso.setEstado(obj[2].toString());
						long l2 = Math.round(((Number) obj[3]).doubleValue());
						String str1 = String.valueOf(l2);
						short s1 =Short.valueOf(str1);
					proceso.setTiempoDias(new Long(obj[3].toString()));
						long l3 = Math.round(((Number) obj[4]).doubleValue());	
						NpsEtapa objNpsEtapa = crudDAO.find(l3, NpsEtapa.class);
						EtapaNpsDTO etapaNpsDTO = new EtapaNpsDTO();
						etapaNpsDTO.setIdEtapa(objNpsEtapa.getIdEtapa());
						etapaNpsDTO.setDescripcion(objNpsEtapa.getDescripcion());
					proceso.setIdEtapa(etapaNpsDTO);
						long l4 = Math.round(((Number) obj[5]).doubleValue());
						MdiMaestroColumna objMdiMaestroColumna = crudDAO.find(l4, MdiMaestroColumna.class);
						MaestroColumnaDTO maestroColumnaDTO = new MaestroColumnaDTO();
						maestroColumnaDTO.setIdMaestroColumna(objMdiMaestroColumna.getIdMaestroColumna());
						maestroColumnaDTO.setDescripcion(objMdiMaestroColumna.getDescripcion());
					proceso.setIdResponsable(maestroColumnaDTO);
					retorno.add(proceso);
					}
				}else{
					retorno=null;
				}
		} catch (Exception e) {

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
    /* OSINE_SFS-1232 - RSIS 6 - Fin */

	@Override
	public boolean delete(SubEtapaNpsDTO subEtapaNpsDTO, UsuarioDTO usuarioDTO) {
		NpsSubetapa npsSubetapa = new NpsSubetapa();
		npsSubetapa = SubEtapaNpsBuilder.toSubEtapaNps(subEtapaNpsDTO);
		npsSubetapa.setEstado(Constantes.ESTADO_INACTIVO);
		npsSubetapa.setDatosAuditoria(usuarioDTO);
		crudDAO.update(npsSubetapa);
		return true;
	}

	@Override
	public SubEtapaNpsDTO findSubEtapaNpsDTO(SubEtapaNpsFilter subEtapaNpsFilter) {
		  NpsSubetapa npsSubetapa = crudDAO.find(subEtapaNpsFilter.getIdSubetapa(), NpsSubetapa.class);
		  SubEtapaNpsDTO subEtapaNpsDTO = SubEtapaNpsBuilder.toSubEtapaNpsDTO(npsSubetapa);
		return subEtapaNpsDTO;
	}
}
