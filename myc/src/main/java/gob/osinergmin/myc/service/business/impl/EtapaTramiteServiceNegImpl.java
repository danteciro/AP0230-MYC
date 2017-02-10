/*
* Resumen
* Objeto            : EtapaTramiteServiceNegImpl.java
* Descripción       : Clase de la capa de negocio que contiene la implementación de los métodos declarados en la clase interfaz EtapaTramiteServiceNeg
* Fecha de Creación : 07/11/2016
* PR de Creación    : 
* Autor             : GMD
* =====================================================================================================================================================================
* Modificaciones |
* Motivo         |  Fecha        |   Nombre                     |     Descripción
* =====================================================================================================================================================================
* OSINE_SFS-1232 | 07/11/2016    |   Luis García Reyna          |     Busqueda por filtros
*/

package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.domain.dto.EtapaTramiteDTO;
import gob.osinergmin.myc.domain.ui.EtapaTramiteFilter;
import gob.osinergmin.myc.service.business.EtapaTramiteServiceNeg;
import gob.osinergmin.myc.service.dao.EtapaTramiteDAO;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author lgarciar
 */
@Service("etapaTramiteServiceNeg")
public class EtapaTramiteServiceNegImpl implements EtapaTramiteServiceNeg{
    
    @Inject
    private EtapaTramiteDAO etapaTramiteDAO;

    private static final Logger LOG = LoggerFactory.getLogger(EtapaTramiteServiceNegImpl.class);

    @Override
    public List<EtapaTramiteDTO> listarEtapaTramite(EtapaTramiteFilter filtro) {
        LOG.info("listarEtapaTramite - inicio");
        List<EtapaTramiteDTO> lista = null;
        try {
            lista = etapaTramiteDAO.listarEtapaTramite(filtro);
        } catch (Exception ex) {
            LOG.error("Error en listarEtapaTramite", ex);
        }
        LOG.info("listarEtapaTramite - fin");
        return lista;
    }
    
}



