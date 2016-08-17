/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.service.exception.ActividadException;
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
}
