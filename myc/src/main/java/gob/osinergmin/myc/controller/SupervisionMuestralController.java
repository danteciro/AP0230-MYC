/**
* Resumen.
* Objeto                            :              SupervisionMuestralController.java.
* Descripción                   	:              Controller encargado de los metodos de la pantalla de la supervision muestral(Registro de la muestra).
* Fecha de Creación     			:              23/05/2016
* Autor                             :              gvillanueva.
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                              		Fecha                             Nombre                              Descripción
* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                     Giancarlo Villanueva                    RSIS25
*/
package gob.osinergmin.myc.controller;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.EstratoUbigeoDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionSubTipoDTO;
import gob.osinergmin.myc.domain.dto.SupervisionMuestralDTO;
import gob.osinergmin.myc.domain.dto.UnidadObliSubTipoDTO;
import gob.osinergmin.myc.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import gob.osinergmin.myc.domain.ui.UnidadSupervisadaFilter;
import gob.osinergmin.myc.service.business.ActividadServiceNeg;
import gob.osinergmin.myc.service.business.EstratoUbigeoServiceNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.UnidadObliSubTipoServiceNeg;
import gob.osinergmin.myc.service.business.UnidadSupervisadaServiceNeg;
import gob.osinergmin.myc.util.Constantes;
import gob.osinergmin.myc.util.ConstantesWeb;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author gvillanueva
 */
@Controller
@RequestMapping("inps/supervisionMuestral")
public class SupervisionMuestralController {
    private static final Logger LOG = LoggerFactory.getLogger(SupervisionMuestralController.class);
    
    @Inject
    private UnidadSupervisadaServiceNeg unidadSupervisadaService;
    @Inject
    private ActividadServiceNeg actividadService;
    @Inject
    private MaestroColumnaServiceNeg maestroColumnaService;
    @Inject
    private EstratoUbigeoServiceNeg estratoUbigeoService;
    @Inject
    private UnidadObliSubTipoServiceNeg unidadObliSubTipoService;
    
    @RequestMapping(value = "/registrarSeleccionMuestral", method = RequestMethod.POST)
    public @ResponseBody 
        Map<String, Object> registrar(SupervisionMuestralDTO supervisionMuestral,HttpServletRequest request, HttpSession session){
        LOG.info("Registrar Seleccion Muestral ");
        Map<String, Object> salida = new HashMap<String, Object>();        
        try{
        	
        	MaestroColumnaDTO periodo=maestroColumnaService.buscarByDominioByAplicacionByCodigo(Constantes.DOMINIO_SUPERV_MUEST_PERIODO, Constantes.APPLICACION_INPS,Constantes.CODIGO_PERIODO).get(0);
        	Long cantPeriodos = new Long(periodo.getDescripcion());
        	Calendar calendar = Calendar.getInstance();
        	int year = calendar.get(Calendar.YEAR);
        	int mes = calendar.get(Calendar.MONTH);
        	Long per = obtenerPeriodoActual(cantPeriodos,mes);
        	String perUnidad = year+""+per;
        	UnidadObliSubTipoDTO filtroPruebaMuestral = new UnidadObliSubTipoDTO();
        	filtroPruebaMuestral.setPeriodo(perUnidad);
        	filtroPruebaMuestral.setIdObligacionSubTipoF(supervisionMuestral.getIdSubTipoSupervision());
        	filtroPruebaMuestral.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        	List<UnidadObliSubTipoDTO> existePruebaMuestral = unidadObliSubTipoService.listarPruebaMuestralxPeriodoxSubTipo(filtroPruebaMuestral);
        	if(existePruebaMuestral==null || existePruebaMuestral.size()==0){
        		// Busca ID de la unidad supervisada
            	String codigo = maestroColumnaService.buscarByDominioByAplicacion(Constantes.DOMINIO_SUPERVISION_MUESTRAL_CODIGO_ACTIVIDAD, Constantes.APPLICACION_INPS).get(0).getDescripcion();//codigo de la actividad Estaciones de Servicios y Grifos
            	ActividadFilter filtroActividad = new ActividadFilter();
            	filtroActividad.setCodigo(codigo);
            	filtroActividad.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);//cambiar estado activo
            	// Busca Actividad por Codigo
            	
            	ActividadDTO actividad = actividadService.listarActividadxCodigo(filtroActividad); 
            	if(actividad!=null){            	
            	Long idActividad = actividad.getIdActividad();
            	UnidadSupervisadaFilter filtro = new UnidadSupervisadaFilter();
            	filtro.setIdActividad(idActividad);
            	// m: total de unidades supervisadas por rubro:Grifos y Estaciones de Servicios 
            	double m = unidadSupervisadaService.contarUnidadSupervisadaxActividad(filtro);
            	LOG.info(" total del universo: "+ m);
            	// n1 = n*: muestra representativa no corregida
            		// z: valor critico de la distribucion || p: probabilidad || e: margen error en la estimacion || c: valor de contingencia
            	MaestroColumnaDTO valorCritico=maestroColumnaService.buscarByDominioByAplicacionByCodigo(Constantes.DOMINIO_PORC_SUPERV_MUESTRAL, Constantes.APPLICACION_INPS,Constantes.CODIGO_VALOR_CRITICO).get(0);
            	MaestroColumnaDTO margenError=maestroColumnaService.buscarByDominioByAplicacionByCodigo(Constantes.DOMINIO_PORC_SUPERV_MUESTRAL, Constantes.APPLICACION_INPS,Constantes.CODIGO_ERROR).get(0);
            	double z = Double.parseDouble(valorCritico.getDescripcion());
            	double p = supervisionMuestral.getProbEncontrarGES();
            	double e = Double.parseDouble(margenError.getDescripcion())/100;
            	double c = supervisionMuestral.getPorcSupContingencia();            	
            	double n1 = calculoMuestraNoCorregida(z,p,e);
            	LOG.info(" muestra representativa no corregida: "+ n1);
            	// n: muestra representativa corregida
            	double n = calculoMuestraCorregida(n1,m);
            	LOG.info(" muestra representativa corregida: "+ n);
            	// nr: muestra representativa corregida redondeada
            	double nr = Math.ceil(n);
            	LOG.info(" muestra representativa corregida Redondeada al Entero Mayor: "+ nr);
            	// ntu: número total de unidades por estrato
            	double ntu = 0.0;
            	// ntut: número total de unidades por todos los estratos
            	double ntut = 0.0;
            	// porcEstrato: porcentaje de unidades por estrato
            	double porcEstrato;
            	// cantEstrato: cantidad de unidades por estrato
            	double cantEstrato = 0.0;
            	// cantTotEstrato: cantidad total de unidades por estrato
            	double cantTotEstrato = 0.0;
            	// cantContingencia: cantidad de unidades de contingencia por estrato 
            	double cantContingencia = 0.0;
            	filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            	filtro.setTipoDireccion(maestroColumnaService.buscarByDominioByAplicacion(Constantes.DOMINIO_DIRE_INPS_SM, Constantes.APPLICACION_INPS).get(0).getCodigo());
            	filtro.setDominio(Constantes.DOMINIO_TIPO_DIRECCION);
            	filtro.setAplicacion(Constantes.APPLICACION_SGLSS);
            	// listaEstratoUbigeo: lista de estratos
            	List<EstratoUbigeoDTO> listaEstratoUbigeo = estratoUbigeoService.listarEstratoUbigeo(); 
            	List<UnidadSupervisadaDTO> listaUnidadSupervisada = new ArrayList<UnidadSupervisadaDTO>();
            	List<UnidadSupervisadaDTO> listaUnidadSupervisadaContingencia = new ArrayList<UnidadSupervisadaDTO>();
            	for(EstratoUbigeoDTO estratoUbigeo:listaEstratoUbigeo){
            		LOG.info("lista ["+estratoUbigeo.getIdEstratoUbigeo()+"] :=: DE " +estratoUbigeo.getDepartamento() +" PR "+estratoUbigeo.getProvincia() +" DI " + estratoUbigeo.getDistrito());
            		filtro.setDepartamento(estratoUbigeo.getDepartamento());
        			filtro.setProvincia(estratoUbigeo.getProvincia());
        			filtro.setDistrito(estratoUbigeo.getDistrito());        			
            		if(estratoUbigeo.getDepartamento()!=null && !estratoUbigeo.getDepartamento().equals("00") && estratoUbigeo.getProvincia()!=null && !estratoUbigeo.getProvincia().equals("00") && estratoUbigeo.getDistrito()!=null && !estratoUbigeo.getDistrito().equals("00") ){
            			LOG.info("Nivel Distrito");        			
            			ntu  = unidadSupervisadaService.contarUnidadSupervisadaxActividadxEstratoDistrito(filtro);        			
            			porcEstrato = calcularPorcentajeEstrato(ntu,m);
            			cantEstrato = calcularCantidadEstrato(porcEstrato,nr);
            			cantContingencia = calcularCantidadEstratoContingencia(cantEstrato,c);
            			LOG.info("N° Total de Unidades Supervisadas por Distrito: "+ntu +" %Estrato: "+porcEstrato + " Cantidad Estrato "+cantEstrato + " Cantidad Estrato Contingencia "+cantContingencia);
            			List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoDistrito = unidadSupervisadaService.listaUnidadSupervisadaEstratoDistrito(filtro);
            			Collections.shuffle(listaUnidadSupervisadaEstratoDistrito);
            			Long contador=new Long(0);
            			Long contadorContingencia = new Long(0);
            			for (UnidadSupervisadaDTO unidadesEstratoDistrito :listaUnidadSupervisadaEstratoDistrito) {
            				contador++;        				
            				if(contador>cantEstrato){
            					contadorContingencia++;
            					if(contadorContingencia<cantContingencia || contadorContingencia==cantContingencia) {
            						listaUnidadSupervisadaContingencia.add(unidadesEstratoDistrito);
            						LOG.info("Contador Distrito: "+contadorContingencia + " idUnidad: " + unidadesEstratoDistrito.getIdUnidadSupervisada());
            					}
            				}else{
            					listaUnidadSupervisada.add(unidadesEstratoDistrito);
            					LOG.info("Contador Distrito: "+contador + " idUnidad: " + unidadesEstratoDistrito.getIdUnidadSupervisada());
            				}
            			}
            		}
            		if(estratoUbigeo.getDepartamento()!=null && !estratoUbigeo.getDepartamento().equals("00") && estratoUbigeo.getProvincia()!=null && !estratoUbigeo.getProvincia().equals("00") && estratoUbigeo.getDistrito().equals("00") ){
            			LOG.info("Nivel Provincia");
            			ntu  = unidadSupervisadaService.contarUnidadSupervisadaxActividadxEstratoProvincia(filtro);
            			porcEstrato = calcularPorcentajeEstrato(ntu,m);
            			cantEstrato = calcularCantidadEstrato(porcEstrato,nr);
            			cantContingencia = calcularCantidadEstratoContingencia(cantEstrato,c);
            			LOG.info("N° Total de Unidades Supervisadas por Provincia: "+ntu +" %Estrato: "+porcEstrato + " Cantidad Estrato "+cantEstrato  + " Cantidad Estrato Contingencia "+cantContingencia);
            			List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoProvincia = unidadSupervisadaService.listaUnidadSupervisadaEstratoProvincia(filtro);
            			Collections.shuffle(listaUnidadSupervisadaEstratoProvincia);
            			Long contador=new Long(0);
            			Long contadorContingencia = new Long(0);
            			for (UnidadSupervisadaDTO unidadesEstratoProvincia :listaUnidadSupervisadaEstratoProvincia) {
            				contador++;        				
            				if(contador>cantEstrato){
            					contadorContingencia++;
            					if(contadorContingencia<cantContingencia || contadorContingencia==cantContingencia) {
            						listaUnidadSupervisadaContingencia.add(unidadesEstratoProvincia);
            						LOG.info("Contador Distrito: "+contadorContingencia + " idUnidad: " + unidadesEstratoProvincia.getIdUnidadSupervisada());
            					}
            				}else{
            					listaUnidadSupervisada.add(unidadesEstratoProvincia);
            					LOG.info("Contador Distrito: "+contador + " idUnidad: " + unidadesEstratoProvincia.getIdUnidadSupervisada());
            				}
            			}
            		}
            		if(estratoUbigeo.getDepartamento()!=null && !estratoUbigeo.getDepartamento().equals("00") && estratoUbigeo.getProvincia().equals("00") && estratoUbigeo.getDistrito().equals("00") ){
            			LOG.info("Nivel Departamento");
            			ntu  = unidadSupervisadaService.contarUnidadSupervisadaxActividadxEstratoDepartamento(filtro);
            			porcEstrato = calcularPorcentajeEstrato(ntu,m);
            			cantEstrato = calcularCantidadEstrato(porcEstrato,nr);
            			cantContingencia = calcularCantidadEstratoContingencia(cantEstrato,c);
            			LOG.info("N° Total de Unidades Supervisadas por Departamento: "+ntu +" %Estrato: "+porcEstrato + " Cantidad Estrato "+cantEstrato+ " Cantidad Estrato Contingencia "+cantContingencia);
            			List<UnidadSupervisadaDTO> listaUnidadSupervisadaEstratoDepartamento = unidadSupervisadaService.listaUnidadSupervisadaEstratoDepartamento(filtro);
            			Collections.shuffle(listaUnidadSupervisadaEstratoDepartamento);
            			Long contador=new Long(0);
            			Long contadorContingencia = new Long(0);
            			for (UnidadSupervisadaDTO unidadesEstratoDepartamento :listaUnidadSupervisadaEstratoDepartamento) {
            				contador++;        				
            				if(contador>cantEstrato){
            					contadorContingencia++;
            					if(contadorContingencia<cantContingencia || contadorContingencia==cantContingencia) {
            						listaUnidadSupervisadaContingencia.add(unidadesEstratoDepartamento);
            						LOG.info("Contador Distrito: "+contadorContingencia + " idUnidad: " + unidadesEstratoDepartamento.getIdUnidadSupervisada());
            					}
            				}else{
            					listaUnidadSupervisada.add(unidadesEstratoDepartamento);
            					LOG.info("Contador Distrito: "+contador + " idUnidad: " + unidadesEstratoDepartamento.getIdUnidadSupervisada());
            				}
            			}
            			
            		}
            		ntut+=ntu;
            		cantTotEstrato+=cantEstrato;
            	}          	
            	
            	UnidadObliSubTipoDTO unidadMuestral = new UnidadObliSubTipoDTO();
            	UsuarioDTO usuarioDTO = new UsuarioDTO();
            	usuarioDTO.setCodigo(ConstantesWeb.getUSUARIO(request));
            	usuarioDTO.setTerminal(Inet4Address.getLocalHost().getHostAddress().toString());
            	//Registrar Unidades Muestrales
            	unidadMuestral.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);        	
            	unidadMuestral.setPeriodo(perUnidad.toString());
            	ObligacionSubTipoDTO idObligacionSubTipo = new ObligacionSubTipoDTO();
            	idObligacionSubTipo.setIdObligacionSubTipo(supervisionMuestral.getIdSubTipoSupervision());
            	unidadMuestral.setIdObligacionSubTipo(idObligacionSubTipo);
            	MaestroColumnaDTO muestral=maestroColumnaService.buscarByDominioByAplicacionByCodigo(Constantes.DOMINIO_TIPO_SELECCION_ORDEN_SERVICIO, Constantes.APPLICACION_INPS,Constantes.CODIGO_SUPERVISION_MUESTRAL_CODIGO_MUESTRAL).get(0);/* OSINE_SFS-480 - RSIS27 */
            	unidadMuestral.setTipoSeleccion(muestral.getIdMaestroColumna().toString());/* OSINE_SFS-480 - RSIS27 */
            	unidadMuestral.setFlagSupOrdenServicio(Constantes.CONSTANTE_ESTADO_INACTIVO);/* OSINE_SFS-480 - RSIS27 */
            	List<UnidadObliSubTipoDTO> listaUnidadMuestral=unidadObliSubTipoService.guardarUnidadMuestral(listaUnidadSupervisada,usuarioDTO,unidadMuestral);
            	LOG.info("Lista muestral[] "+listaUnidadMuestral);
            	//Registar Unidades Muestrales Contingencia
            	UnidadObliSubTipoDTO unidadMuestralContingencia = new UnidadObliSubTipoDTO();
            	unidadMuestralContingencia.setFlagSupOrdenServicio(Constantes.CONSTANTE_ESTADO_INACTIVO);/* OSINE_SFS-480 - RSIS27 */
            	unidadMuestralContingencia.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);        	
            	unidadMuestralContingencia.setPeriodo(perUnidad.toString());
            	unidadMuestralContingencia.setIdObligacionSubTipo(idObligacionSubTipo);
            	MaestroColumnaDTO contingencia=maestroColumnaService.buscarByDominioByAplicacionByCodigo(Constantes.DOMINIO_TIPO_SELECCION_ORDEN_SERVICIO, Constantes.APPLICACION_INPS,Constantes.CODIGO_SUPERVISION_MUESTRAL_CODIGO_CONTIGENCIA).get(0);/* OSINE_SFS-480 - RSIS27 */
            	unidadMuestralContingencia.setTipoSeleccion(contingencia.getIdMaestroColumna().toString());/* OSINE_SFS-480 - RSIS27 */
            	List<UnidadObliSubTipoDTO> listaUnidadMuestralContingencia=unidadObliSubTipoService.guardarUnidadMuestral(listaUnidadSupervisadaContingencia,usuarioDTO,unidadMuestralContingencia);
            	LOG.info("Lista contingencia[] "+listaUnidadMuestralContingencia);
            	LOG.info("total por Estrato : "+cantTotEstrato);
            	LOG.info("total : "+ntut);   
            		salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_EXITO);
            	}else{
            		salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA_EXISTENCIA);
            	}
            	
        	}else{
        		salida.put(ConstantesWeb.VV_RESULTADO, ConstantesWeb.VV_ADVERTENCIA);
        	}
        	
        	
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return salida;
    }
    
	private Long obtenerPeriodoActual(Long cantPeriodos,int mes) {
		Long per = new Long(0);
		Long cantMeses = 12/cantPeriodos;
    	Long contPeriodo = new Long(0);
    	Long longPeriodo=new Long(0);
    	ArrayList<Long> dominio = new ArrayList<Long>();
    	for(int i=0;i<cantPeriodos+1;i++){        		
    		longPeriodo=cantMeses*contPeriodo;
    		contPeriodo++;
    		dominio.add(longPeriodo);
    	}
    	contPeriodo=new Long(0);
    	for (int i = 0; i < cantPeriodos; i++){
    		contPeriodo++;
    		if(mes>dominio.get(i) && (mes<dominio.get(i+1)||mes==dominio.get(i+1))){
    			per=contPeriodo;
    		}
    	}
    	LOG.info("Array Periodos: "+dominio);
    	LOG.info("Periodo: "+per);
    	return per;
	}

	private double calcularCantidadEstratoContingencia(double cantEstrato, double c) {
		double cantEstratoContingencia = cantEstrato*c;
		cantEstratoContingencia = Math.ceil(cantEstratoContingencia);
		return cantEstratoContingencia;
	}

	private double calcularCantidadEstrato(double porcEstrato, double nr) {
		double cantEstrato = porcEstrato*nr;
		cantEstrato=Math.round(cantEstrato);
		return cantEstrato;
	}
    
	private double calcularPorcentajeEstrato(double ntu, double m) {
		double porcentaje = ntu/m;
		return porcentaje;
	}

	private double calculoMuestraCorregida(double n1, double m) {
		double n = n1/(1+(n1/m));
		return n;
	}

	private double calculoMuestraNoCorregida(double z, double p, double e) {
		double n1 = (Math.pow(z, 2)*p*(1-p))/(Math.pow(e, 2));		
		return n1;
	}
}
