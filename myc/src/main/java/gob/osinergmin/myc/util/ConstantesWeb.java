package gob.osinergmin.myc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jpiro
 */
public class ConstantesWeb {
    public static final int VV_EXITO = 0;
    public static final int VV_ERROR = 1;
    public static final int VV_ADVERTENCIA = 2;
    
    public static final String VV_RESULTADO = "resultado";
    public static final String VV_MENSAJE = "mensaje";
    
    public static String FECHA="";
    public static String USUARIO="";
    
    private ConstantesWeb() {
    }
    
    public static String getFECHA() {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        String prefix = DATE_FORMAT.format(today);
        ConstantesWeb.FECHA=prefix;
        return ConstantesWeb.FECHA;
    }
    public static String getUSUARIO(HttpServletRequest request) {
        String usuario = ((String) request.getSession().getAttribute("j_username"));
        ConstantesWeb.USUARIO=usuario;
        return ConstantesWeb.USUARIO;
    }
    
    public static class Navegacion{
        public static final String PAGE_GENERAL_INICIO="principal";
        public static final String PAGE_GENERAL_INICIO_MANTENIMIENTO="mantenimiento";
        public static final String PAGE_GENERAL_INICIO_CONFIGURACION="configuracion";
        
        //requisitos
        public static final String PAGE_REQUISITOS_MANT="requisitos/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_PARAMETRO="requisitos/parametro/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_ZONIFICACION="general/mantenimiento/zonificacion";
        public static final String PAGE_REQUISITOS_MANT_ZONIFICACION_DETALLE="general/mantenimiento/zonificacionDetalle";
        
        public static final String PAGE_REQUISITOS_MANT_MAESTRO_COLUMNA="general/maestroColumna/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_FRM_MAESTRO_COLUMNA="general/maestroColumna/mantFrmMaestroColumna";
        public static final String PAGE_REQUISITOS_MANT_MAESTRO_TABLA="general/maestroTabla/mantFrmMaestroTabla";
        
        public static final String PAGE_REQUISITOS_MANT_PROCEDIMIENTO="requisitos/procedimiento/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_FRM_PROCEDIMIENTO="requisitos/procedimiento/mantFrmProcedimiento";
        public static final String PAGE_REQUISITOS_MANT_REQUISITO="requisitos/requisito/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_FRM_REQUISITO="requisitos/requisito/mantFrmRequisito";
        
        public static final String PAGE_REQUISITOS_CONF="requisitos/configuracion";
        public static final String PAGE_REGISTRO_CONF="registro/configuracion";
        public static final String PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO="requisitos/requisitoProcedimiento/busqueda";
       
        public static final String PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_NUEVO="requisitos/requisitoProcedimiento/nuevo";
        public static final String PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_CONSULTA="requisitos/requisitoProcedimiento/consultabkp";        
        public static final String PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_FRM_AGREGAR_REQUISITO="requisitos/requisitoProcedimiento/common/frmAgregarRequisito";        
        
        public static final String PAGE_REQUISITOS_FRM_SELECT_ACTIVIDADES="requisitos/common/actividad/popupBusqActividad";
        public static final String PAGE_GENERAL_FRM_SELECT_DISTRITO="general/common/distrito/popupBusqDistrito";
        public static final String PAGE_GENERAL_FRM_SELECT_SANC_ADM="general/common/sancionAdministrativa/popupBusqSancAdm";
        
        //Oficina Regional
        
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES="registro/oficinasRegionales/busqueda";
        public static final String PAGE_REGISTRO_CONF_FRM_OFICINASREGICONALES="registro/oficinasRegionales/mantFrmOficinaRegional";
        public static final String PAGE_REGISTRO_CONF_FRM_REGION="registro/oficinasRegionales/configuracionRegion";
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES_FRM_BUSQUEDARESPONSABLE="registro/oficinasRegionales/popupBusqResponsable";
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES_FRM_ASIGNACION_UBIGEO="registro/oficinasRegionales/popupAsignacionUbigeo";
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES_FRM_ASIGNACION_OFICINA_REGIONAL="registro/oficinasRegionales/popupAsignacionOficinaRegional";
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES_NUEVO="registro/oficinasRegionales/nuevo";
        
        //obligaciones
        public static final String PAGE_INICIO_INDICE="indicemo";
        public static final String PAGE_INICIO_MANTENIMIENTOS="mantenimientosmo";
        public static final String PAGE_INICIO_MANTENIMIENTO_BASE_LEGAL="moduloObligaciones/baseLegal/inicio";
        public static final String PAGE_INICIO_MANTENIMIENTO_OBLIGACION="moduloObligaciones/Obligacion/obligacion";
        public static final String PAGE_INICIO_MANTENIMIENTO_OBLIGACIONNORMATIVA="moduloObligaciones/Obligacion/obligacionNormativa";
        
        
        //formularios comunes obligaciones
        public static final String PAGE_OBLIGACIONES_FORM_ARBOLACTIVIDADES="moduloObligaciones/common/formArbolActividades";
        public static final String PAGE_OBLIGACIONES_FORM_ARBOLPRODUCTOS="moduloObligaciones/common/formArbolProductos";
        public static final String PAGE_OBLIGACIONES_FORM_BUSQUEDA_AVANZADA_BASE_LEGAL="moduloObligaciones/common/formBusqAvanzadaBaseLegal";
        
        //paginas de edicion
        public static final String PAGE_OBLIGACIONES_BASE_LEGAL_NUEVO="moduloObligaciones/baseLegal/nuevo";
        
        //Actividades
        public static final String PAGE_REGISTRO_CONF_BUSQ_ACTIVIDAD="registro/actividad/busqueda";
        public static final String PAGE_REGISTRO_CONF_REG_ASIGNACION="registro/actividad/popupAsignacion";
        public static final String PAGE_REGISTRO_CONF_FRM_SELECT_ACTIVIDADES="registro/actividad/popupBusqActividad";
        
        //Mantenimiento General
        public static final String PAGE_GENERAL_MANT="general/mantenimiento";
        
        //Tramite Actividad
        public static final String PAGE_GENERAL_MANT_TRAMITE_ACTIV="general/tramiteActividad/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_TRAMITE_ACTIV="general/tramiteActividad/mantFrmTramiteActividad";
        public static final String PAGE_GENERAL_MANT_FRM_EDIT_TRAMITE_ACTIV="general/tramiteActividad/mantEditFrmTramiteActividad";
        
        //Concurso
        public static final String PAGE_GENERAL_MANT_CONSURSO="general/concurso/mantenimiento";
        public static final String PAGE_GENERAL_MANT_CONSURSO_ADJUNTOS="general/concurso/mantFrmArchivo";
        
        //Proceso Obligaciones
        public static final String PAGE_GENERAL_MANT_PROCESO_OBLI="general/procesoObligacionTipo/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_OBLIGACION_PROCESO="general/procesoObligacionTipo/mantFrmProcesoObligacionTipo";
        public static final String PAGE_GENERAL_MANT_FRM_EDIT_OBLIGACION_PROCESO="general/procesoObligacionTipo/mantEditFrmObligacionProceso";
        
        //Obligacion Tipo
        public static final String PAGE_GENERAL_MANT_OBLI_TIPO="general/obligacionTipo/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_OBLIGACION_TIPO="general/obligacionTipo/mantFrmObligacionTipo";
        public static final String PAGE_GENERAL_MANT_FRM_NUEVO_OBLIGACION_TIPO="general/obligacionTipo/mantFrmNuevoObligacionTipo";
        
        //Etapa
        //public static final String PAGE_REQUISITOS_MANT_ETAPA_TRAMITE="general/etapaTramite/etapaTramite";
        public static final String PAGE_REQUISITOS_MANT_ETAPA_TRAMITE="general/mantenimiento/etapaTramite";
        public static final String PAGE_GENERAL_MANT_ETAPA="general/etapaTramite/mantFrmEtapa";
        public static final String PAGE_GENERAL_MANT_TRAMITE="general/etapaTramite/mantFrmTramite";
        
        //Tipo Sancion
        public static final String PAGE_GENERAL_MANT_TIPO_SANCION="general/tipoSancion/mantFrmTipoSancion";
        //tipificacion
        public static final String PAGE_GENERAL_MANT_TIPIFICACION="general/tipificacion/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_TIPIFICACION="general/tipificacion/mantFrmTipificacion";
        //autoayuda
        public static final String PAGE_GENERAL_MANT_AUTOAYUDA="general/autoayuda/mantenimiento";
        //criterio
        public static final String PAGE_GENERAL_MANT_CRITERIO="general/criterio/mantCriterio";
        public static final String PAGE_GENERAL_MANT_FRM_CRITERIO="general/criterio/mantFrmCriterio";
        //sanciones
        public static final String PAGE_GENERAL_MANT_SANCIONES="general/criterio/mantSanciones";

        
    }
    
    public static class mensajes{
    	//Mensajes 
        //Mensajes Base Legal
        public static final String MSG_OPERATION_SUCCESS_CREATE="Se guard\u00F3 satisfactoriamente: ";
        public static final String MSG_OPERATION_SUCCESS_UPDATE="Se actualiz\u00F3 satisfactoriamente:";
        public static final String MSG_OPERATION_SUCCESS_DELETE="Se elimin\u00F3 satisfactoriamente:";
        
        public static final String MSG_OPERATION_FAIL_CREATE="Fallo al guardar: ";
        public static final String MSG_OPERATION_FAIL_UPDATE="Fallo al actualizar: ";
        public static final String MSG_OPERATION_FAIL_DELETE="Fallo al eliminar: ";
        
        public static final String MSG_OPERATION_FAIL_CREATE_DUPLICATE="Ya Existe ";
        
        public static final String MSG_OPERATION_SUCCESS_CREATE_RELATION="Se asign\u00F3 satisfactoriamente: ";
        public static final String MSG_OPERATION_SUCCESS_DELETE_RELATION="Se elimin\u00F3 satisfactoriamente: ";
        
        public static final String MSG_OPERATION_FAIL_CREATE_RELATION="Fallo al asignar: ";
        public static final String MSG_OPERATION_FAIL_DELETE_RELATION="Fallo al desasignar: ";
        
        //Entidades
        public static final String MSG_ENTITY_OBLIGACION="Obligaci\u00F3n";
        public static final String MSG_ENTITY_BASELEGAL="Base Legal";
        public static final String MSG_ENTITY_TIPIFICACION="Tipificaci\u00F3n";
        public static final String MSG_ENTITY_CONFIGURACION="Configuraci\u00F3n";
        public static final String MSG_ENTITY_TEMA="Tema";
        public static final String MSG_ENTITY_CRITERIO="Criterio";
    }
    
}
