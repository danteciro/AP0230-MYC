/**
* Resumen.
* Objeto                            :              ObligacionSubTipoController.java.
* Descripción                   	:              Controller encargado de los metodos de la pantalla de la supervision muestral.
* Fecha de Creación     			:              23/05/2016
* Autor                             :              gvillanueva.
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                              		Fecha                             Nombre                              Descripción
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                     Giancarlo Villanueva                    RSIS25
*/
package gob.osinergmin.myc.controller;
import java.util.ArrayList;
import java.util.List;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.ui.ObligacionSubTipoFilter;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.ObligacionSubTipoServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("inps/obligacionSubTipo")
public class ObligacionSubTipoController {


	    @Inject
	    private ObligacionSubTipoServiceNeg obligacionSubTipoServiceNeg;
	    @Inject
	    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
	    
	    private static final Logger LOG = LoggerFactory.getLogger(ProcesoObligacionTipoController.class);
	    
	    @RequestMapping(value = "/listarObligacionSubTipo", method = RequestMethod.GET)
	    public @ResponseBody
	    List<ObligacionSubTipoDTO> listarObligacionSubTipo(Long idObligacionTipo) {
	        List<ObligacionSubTipoDTO> listObligacionSubTipo = new ArrayList<ObligacionSubTipoDTO>();
	        try{
	        	ObligacionSubTipoFilter filtro = new ObligacionSubTipoFilter();
	        	filtro.setIdObligacionTipo(idObligacionTipo);
	        	filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
	        	filtro.setIdentificadorSeleccion(Constantes.IDENTIFICADOR_SELECCION_MUESTRAL);
	        	listObligacionSubTipo=obligacionSubTipoServiceNeg.listarObligacionesSubTipo(filtro);
	        }catch(Exception e){
	            LOG.info("error al procesar listado de Obligaciones Sub Tipo " +e);
	        }
	        return listObligacionSubTipo;
	    }
	    
	    @RequestMapping(value = "/obtenerParametros", method = RequestMethod.GET)
	    public @ResponseBody
	    MaestroColumnaDTO obtenerParametros(String codigo) {
	    	MaestroColumnaDTO parametro = new MaestroColumnaDTO();
	        try{
	        	String dominio = Constantes.DOMINIO_PORC_SUPERV_MUESTRAL;
	        	String aplicacion = Constantes.APPLICACION_INPS;
	        	parametro=maestroColumnaServiceNeg.buscarByDominioByAplicacionByCodigo(dominio, aplicacion,codigo).get(0);
	        }catch(Exception e){
	            LOG.info("error al obtener parametro " +e);
	        }
	        return parametro;
	    }
	    
}
