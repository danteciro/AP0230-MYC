/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;


import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.CnfActUniOrganicaFilter;
import gob.osinergmin.myc.domain.ui.UnidadOrganicaFilter;
import gob.osinergmin.myc.service.exception.ActividadException;
import gob.osinergmin.myc.service.exception.UnidadOrganicaException;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface ActividadDAO {
    public List<ActividadDTO> find(ActividadFilter filtro) throws ActividadException;
    public Long count(ActividadFilter filtro) throws ActividadException;
    public List<ProcesoObligacionTipoDTO> listarConfigurada();
	public ActividadDTO listarActividadxCodigo(ActividadFilter filtro);
	public List<ProcesoObligacionTipoDTO> listarConfigurada(ActividadFilter filtro);
	
	/* OSINE_SFS-600 - REQF-0009 - Inicio */
    public List<ActividadDTO> listarAgentesIntalacion(ActividadFilter filtro);
    public List<ActividadDTO> listarActividad(ActividadFilter filtro);
    public ActividadDTO guardarActividad (ActividadDTO actividad, UsuarioDTO usuario) throws ActividadException;
    public ActividadDTO actualizarActividad (ActividadDTO actividad, UsuarioDTO usuario) throws ActividadException;
    public ActividadDTO cambiarEstadoActividad (Long idActividad, String estado,UsuarioDTO usuario) throws ActividadException;
    public String verificarEliminarActividad (ActividadFilter filtro) throws ActividadException;
    public List<ActividadDTO> listarAgente(ActividadFilter filtro) throws ActividadException;
    /* OSINE_SFS-600 - REQF-0009 - Fin */
    /* OSINE_SFS-1232 - REQF- - Inicio */
    public List<ActividadDTO> findActividadByEtapaConfiguracion(ActividadFilter filtro, UnidadOrganicaFilter unidadOrganicaFilter) throws ActividadException;
	public List<ActividadDTO> findActividadesPadre(ActividadFilter filtro, UnidadOrganicaFilter unidadOrganicaFilter) throws ActividadException;
	public List<ActividadDTO> findActividadesHijasJoinEtapaConfiguracion(ActividadFilter filtro) throws ActividadException;	
    
	public List<ActividadDTO> findActividadByIdCnfActUniOrganicaDTO(CnfActUniOrganicaFilter cnfActUniOrganicaFilter);
	/* OSINE_SFS-1232 - REQF- - Inicio */
    
    
}
