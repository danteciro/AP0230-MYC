/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.controller;

import gob.osinergmin.myc.domain.dto.EtapaDTO;
import gob.osinergmin.myc.domain.ui.EtapaFilter;
import gob.osinergmin.myc.service.business.EtapaServiceNeg;
import gob.osinergmin.myc.service.business.ProcesoServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jpiro
 */
@Controller
@RequestMapping("/etapa")
public class EtapaController {
    private static final Logger LOG = LoggerFactory.getLogger(PrincipalController.class);
    @Inject
    private EtapaServiceNeg etapaServiceNeg;
	@Inject
	private ProcesoServiceNeg procesoServiceNeg;    
    
    @RequestMapping(value="/loadEtapa",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> loadEtapa(EtapaFilter filtro, int rows, int page, int flg_load){
        Map<String,Object> retorno=new HashMap<String,Object>();
        try{
            int inicio = 0;
            LOG.info("procesando loadTramite");
            List<EtapaDTO> listado = null;
            int total = 0;
            Integer cuenta = 0;
            
            if(flg_load==1){
                inicio = rows * page - rows;
                filtro.setStartIndex(inicio);
                filtro.setResultsNumber(rows);
                int[] auxiliar = new int[1];//para el paso por referencia TODO cambiar?
                auxiliar[0] = 0;
                
                listado=etapaServiceNeg.findEtapaByFilter(filtro, auxiliar);
                
                cuenta = auxiliar[0];
                if (cuenta > 0) {
                    total = (int) Math.ceil((double) cuenta / (double) rows);
                }
                LOG.info("cuenta:" + cuenta);
            }
            retorno.put("filas", listado);
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return retorno;
    }
    
    @RequestMapping(value = "/abrirMantEtapa", method = RequestMethod.GET)
    public String abrirMantEtapa( String tipo, Long idProceso,HttpSession sesion,Model model ) {
        try{
            model.addAttribute("listadoProceso", procesoServiceNeg.listarProceso());
            model.addAttribute("tipo", tipo);     
            model.addAttribute("idProceso", idProceso);     
        }catch(Exception e){
            LOG.error("error",e);
        }
        return ConstantesWeb.Navegacion.PAGE_GENERAL_MANT_ETAPA;
    } 
    
}
