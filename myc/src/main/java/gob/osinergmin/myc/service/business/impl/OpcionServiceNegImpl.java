/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.ui.OpcionFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.OpcionServiceNeg;
import gob.osinergmin.myc.service.dao.OpcionDAO;
import gob.osinergmin.myc.util.Constantes;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* Resumen.
* Objeto                   : OpcionServiceNegImpl.java 
* Descripción              : ServiceImpl para el uso del modulo de rubroOpcion.
* Fecha de Creación        : 26/05/2016
* PR de Modificacion       : OSINE_119
* Autor                    : Juan Sifuentes Acosta.
* ---------------------------------------------------------------------------------------
* Modificaciones
* Motivo       Fecha       Nombre                 Descripcion
* ----------------------------------------------------------------------------------------
 */

@Service("OpcionServiceNeg")
public class OpcionServiceNegImpl implements OpcionServiceNeg{
    private static final Logger LOG = LoggerFactory.getLogger(ActividadServiceNeg.class);
    @Inject
    private OpcionDAO opcionDAO;
    
    /**Metodo para listar opciones mediante un filtro 
     * @param filtro
     * @return retorno
     */
    @Override
    public List<OpcionDTO> findOpcionByFilter(OpcionFilter filtro){
        LOG.info("Neg findTramiteByFilter");
        List<OpcionDTO> retorno=null;
        try{
            retorno = opcionDAO.find(filtro);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }

	@Override
	public Long obtenerIdTipoSupervision() {
		// TODO Auto-generated method stub
		Long retorno = null;
		OpcionFilter filtro = new OpcionFilter();
		filtro.setIdentificadorOpcion(Constantes.ID_TIPO_SUPERVISION);    
		filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
		filtro.setAplicacion(Constantes.APPLICACION_MYC);
		
		try{
			retorno=opcionDAO.findIdentificadorOpcion(filtro);
		}catch(Exception ex){
			LOG.error("error Obtener Tipo supervision",ex);
		}
		return retorno;
	}
}
