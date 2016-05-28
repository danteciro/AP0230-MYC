package gob.osinergmin.myc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.service.business.CriterioServiceNeg;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *@author luis_garcia
 * 
 */

@Controller
@RequestMapping("/sancionEspecifica")
public class SancionEspecificaController {	
	private static final Logger LOG = LoggerFactory.getLogger(SancionEspecificaController.class);
	@Inject
	CriterioServiceNeg criterioServiceNeg;

	@RequestMapping(value = "/listarSancionEspecificaCriterio", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> listarSancionEspecificaCriterio(Long idCriterio, int rows, int page, String sidx,String sord, HttpSession session){
        Map<String, Object> listaResultado = new HashMap<String, Object>();
        LOG.info("procesando GET para RequestMapping /findSancionEspecifica");
        LOG.info("-- idCriterio = "+idCriterio);
      
        List<DetalleCriterioDTO> listaDetalleCriterio=null;
        if(idCriterio!=null){
            listaDetalleCriterio = criterioServiceNeg.listarSancionEspecificaCriterio(new Long(idCriterio));
            Long contador = new Long(listaDetalleCriterio.size());
            int indiceInicial = (page - 1) * rows;
            int indiceFinal = indiceInicial + rows;
            List<DetalleCriterioDTO> listaDetalleCriterioPaginada = new ArrayList<DetalleCriterioDTO>();
            listaDetalleCriterioPaginada = listaDetalleCriterio.subList(
                    indiceInicial, indiceFinal > listaDetalleCriterio
                    .size() ? listaDetalleCriterio.size()
                    : indiceFinal);
            Long numeroFilas = (contador / rows);
            if ((contador % rows) > 0) {
                numeroFilas = numeroFilas + 1L;
            }
            listaResultado.put("total", numeroFilas);
            listaResultado.put("pagina", page);
            listaResultado.put("registros", contador);
            listaResultado.put("filas", listaDetalleCriterioPaginada);
        }
        
        return listaResultado;
    }
	
	    
}
