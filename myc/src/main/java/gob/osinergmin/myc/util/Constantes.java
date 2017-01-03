/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.util;

/**
 *
 * @author jpiro
 */
public class Constantes {
    public static final String CONSTANTE_ESTADO_ACTIVO = "1";
    public static final String CONSTANTE_VALOR_UNO = "1";
    public static final String CONSTANTE_VALOR_CERO = "0";
    public static final String CONSTANTE_VACIO = "";
    public static final Long CONSTANTE_VALOR_COMBO_NO_SELECCIONADO = new Long(-1);
    /*Rsis 13 - Inicio*/
    //public static final char CONSTANTE_ESTADO_ACTIVO_INFRACCION = '1';
    /*Rsis 13 - Inicio*/
    public static final String CONSTANTE_ESTADO_INACTIVO = "0";
    public static final String DOMINIO_AMBITO_PARAMETRICO= "AMBITO_PARAMETRICO";
    public static final String DOMINIO_TIPO_CONSULTA= "TIPO_PARAMETRO";
    public static final String DOMINIO_TIPO_SANCION= "TIPO_SANCION";
    public static final String DOMINIO_TIPO_CRITERIO= "TIPO_CRITERIO";    
    public static final String APPLICACION_MYC="MYC";
    public static final String APPLICACION_SGLSS="SGLSS";
    public static final String APPLICACION_INPS="INPS"; /* OSINE_SFS-480 - RSIS10 */
    
    public static final String APPLICACION_SPACE_REQUISITOS="REQUISITOS";
    public static final String APPLICACION_SPACE_LOCADOR="LOCADOR";
    public static final String APPLICACION_SPACE_OBLIGACIONES="OBLIGACIONES";
    public static final String APPLICACION_SPACE_GENERALES="GENERALES";
    
    public static final String DESC_PROCESO_PRE_OPERATIVA= "PRE-OPERATIVA";
    public static final String DOMINIO_ANEXO_RRH= "ANEXO_RRH";
    public static final String DOMINIO_CALIFICACION= "CALIFICACION";
    public static final String DOMINIO_VALOR_UIT= "VALOR_UIT";
    public static final String DOMINIO_EVALUACION_PREVIA= "EVALUACION_PREVIA";
    public static final String DOMINIO_INICIO_PROCEDIMIENTO= "INICIO_PROCEDIMIENTO";
    public static final String DOMINIO_AUTORIDAD_RESOLVER= "AUTORIDAD_RESOLVER";
    public static final String DOMINIO_INST_RESO_RECONSI= "INST_RESO_RECONSI";
    public static final String DOMINIO_INST_RESO_APEL= "INST_RESO_APEL";
    public static final String DOMINIO_NIVEL_TIPIFICACION = "NIVEL_TIPIFICACION";
    public static final String DOMINIO_NIVEL_CRITERIO="NIVEL_CRITERIO";
    public static final String DOMINIO_NIVEL_SANCION="NIVEL_SANCION";
    public static final String DOMINIO_FILTRO_EMP_SUPERVISORA="FILTRO_EMP_SUP"; /* OSINE_SFS-480 - RSIS10 */
    public static final String DOMINIO_NIVEL_UNIDAD_ORGA ="NIVEL_UNIDAD_ORGA"; /* OSINE_SFS-480 - RSIS09 */
    
    public static final Long CONSTANTE_SEDE_UNIDAD_ORGANICA = 1L; /* OSINE_SFS-480 - RSIS09 */
    
    public static final String CONSTANTE_ARCHIVO_CRITERIO = "archivoCriterio";
    public static final String CONSTANTE_ARCHIVO_OBLIGACION = "archivoObligacion";
    public static final String CONSTANTE_ARCHIVO_DESCRIPCON = "archivoDescripcion";
    /*Rsis 11 - Inicio*/
    public static final String CONSTANTE_ARCHIVO_INFRACCION = "archivoInfraccion";
    /*Rsis 11 - Fin*/
    
    public static final String CONSTANTE_TRAZABILIDAD_NUEVO = "N";
    public static final String CONSTANTE_TRAZABILIDAD_MODIFICAR = "U";
    public static final String CONSTANTE_TRAZABILIDAD_ELIMINAR = "D";
    
    public static final String CONSTANTE_DOMINIO_TIPO_DOC_CONCURSO="DOCUMENTO_CONCURSO";
    
    public static final String CONSTANTE_MSJE_YA_EXISTE="Ya existe";
	public static final String CONSTANTE_ARCHIVO_BASE_LEGAL = "listaArchivosBL";
	public static final String VALOR = "--Seleccione--";
	public static final String VALOR_DEFECTO = "--SELECCIONE--";
	public static final long ID_PROCEDIMIENTO = 165;
	public static final long ID_REQUISITO = 166;
	public static final String CONSTANTE_APLICAION_MYC= "MYC";
	public static final String ID_TIPO_SUPERVISION="ID_TIPO_SUPERV";
    
    /* Inicio: OSINE_SFS-480 - RSIS25 */
    public static final String IDENTIFICADOR_SELECCION_MUESTRAL = "S";	
    public static final String DOMINIO_PORC_SUPERV_MUESTRAL = "PORC_SUPERV_MUESTRAL"; 
    public static final String CODIGO_VALOR_CRITICO = "VALOR_CRITICO";
    public static final String CODIGO_PROBABILIDAD = "PROBABILIDAD"; 
    public static final String CODIGO_ERROR = "ERROR"; 
    public static final String DOMINIO_DIRE_INPS_SM = "DIRE_INPS_SM";
    public static final String DOMINIO_TIPO_DIRECCION = "TIPO_DIRECCION";
    public static final String CODIGO_CONTINGENCIA = "CONTINGENCIA";
    public static final String FLAG_SI_CONTINGENCIA = "C";
    public static final String FLAG_NO_CONTINGENCIA = "M";
    public static final String DOMINIO_SUPERV_MUEST_PERIODO = "SUPERV_MUEST_PERIODO";
    public static final String CODIGO_PERIODO = "PERIODO";
    public static final String DOMINIO_SUPERVISION_MUESTRAL_CODIGO_ACTIVIDAD = "SUP_MUE_COD_ACTI";
    public static final String DOMINIO_TIPO_SELECCION_ORDEN_SERVICIO = "TIPO_SEL_ORD_SER";	
    public static final String CODIGO_SUPERVISION_MUESTRAL_CODIGO_CONTIGENCIA = "TPOS03";
    public static final String CODIGO_SUPERVISION_MUESTRAL_CODIGO_MUESTRAL = "TPOS02";
    public static final String CODIGO_SUPERVISION_MUESTRAL_CODIGO_ASIGNACION = "TPOS01";
    /* Fin: OSINE_SFS-480 - RSIS25 */
	public static Long IDPERSONAL;
	public static final String ESTADO_ACTIVO="1";
    public static final String ESTADO_INACTIVO="0";
    public static final String PERSONAL_UNIDAD_ORGANICA_DIVISION = "PERSONAL_UNIDAD_ORGANICA_DIVISION";
	public static final String ACTIVIDAD_ORGANICA_DIVISION = "ACTIVIDAD_UNIDAD_ORGANICA";
	public static final String ACTIVIDADES_ORGANICA_DIVISION_CONCATENADA = "ACTIVIDAD_UNIDAD_ORGANICA_CONCATENADA";


/* OSINE_SFS-600 - REQF-0009 - Inicio */
	public static final String ESMAYOR_DEFAULT = "1";
	public static final String NOMBRE_CORTO_DEFAULT = ".";
	public static final char FLAG_GABINETE_DEFAULT = '0';
	public static final String AMBITO_DEFAULT = "NPS";
	public static final Integer PLAZO_DESCARGO_DEFAULT = 5;
		
	public static final String RELACION_MDI_ACTIVIDAD_AGENTE = "Agentes";
	public static final String RELACION_MDI_UNIDAD_SUPERVISADA = "Unidades supervisadas";
	public static final String RELACION_PGH_CNF_ACT_UNI_ORGANICA = "Unidades org&aacute;nicas(divisi&oacute;n/gerencia)";
	public static final String RELACION_PGH_CNF_REQU_PROCEDIMIENTO = "Configuraciones de requisitos y procedimientos";
	public static final String RELACION_PGH_CNF_TRAMITE_ACTIVIDAD =	"Configuraciones de tr&aacute;mites";
	public static final String RELACION_PGH_CONFIGURACION =	"Unidades de medida";
	public static final String RELACION_PGH_EMPR_SUPE_ACTI_OBLI = "Configuraciones de Empresa supervisora y tipo de supervisi&oacute;n";
	public static final String RELACION_PGH_MAESTRO_X_ACTIVIDAD = "Configurados de Maestros columna";
	public static final String RELACION_PGH_MODULO_X_ACTIVIDAD = "M&oacute;dulos SIGUO";
	public static final String RELACION_PGH_NORMA_AGENTE_PRIORIDAD = "Prioridades de normas y agentes relacionados";
	public static final String RELACION_PGH_OPCION_ACTIVIDAD = "Opciones";
	public static final String RELACION_PGH_PLANTILLA_RESULTADO = "Registros de plantillas de documentos";
	public static final String RELACION_PGH_PROC_TRAM_ACTIVIDAD = "Procedimientos y Tr&aacute;mites";
	public static final String RELACION_PGH_PROCESO_OBLIGACION_TIPO = "Proceso y tipo de supervisi&oacute;n";
	public static final String RELACION_ACTIVIDAD = "No se pudo eliminar la actividad, se encontraron las siguientes relaciones activas: ";
	public static final String RELACION_ACTIVIDAD_AGENTE = "No se pudo eliminar el agente, se encontraron las siguientes relaciones activas: ";
	
	/* OSINE_SFS-600 - REQF-0009 - Fin */
	
	/* OSINE_SFS-600 - REQF-0012 - Inicio */
	public static final String ELIMINAR_ORDEN_NORMA_ID_NORMA_PRIORIDAD = "NORMA_PRIORIDAD";
	public static final String ELIMINAR_ORDEN_NORMA_ID_BASE_LEGAL = "BASE_LEGAL";
	public static final String ELIMINAR_ORDEN_NORMA_ID_OBLIGACION = "OBLIGACION";
	public static final String ELIMINAR_ORDEN_NORMA_ID_RELACION_BASE_OBLIGACION = "REL_BASE_OBL";
	public static final String ELIMINAR_ORDEN_NORMA_ID_CONF_OBLIGACION = "CONG_OBLIGACION";
	/* OSINE_SFS-600 - REQF-0012 - Fin */
	/* OSINE_SFS-600 - REQF-0012 - Inicio */
	public static final Long NIVEL_OSINERGMIN = new Long(1);
	public static final Long NIVEL_GERENCIA = new Long(2);
	public static final Long NIVEL_DIVISION = new Long(3);
	public static final Long NIVEL_SUB_DIVISION = new Long(4);
	public static final Long NIVEL_UNIDAD = new Long(5);
	/* OSINE_SFS-600 - REQF-0012 - Fin */

	
    /* OSINE_SFS-1232 - REQF- - Inicio */
	public static final String SECTOR_DOMINIO = "NPS_SECTOR";
	public static final String RESPONSABLE_DOMINIO = "NPS_RESPONSABLE";
	public static final String PROCESO_PRE_OPERATIVO = "PROCESO_PREOPERATIVO";
	public static final String MANTENIMIENTO_MOFIDICAR = "modificar";
	public static final String MANTENIMIENTO_CONSULTAR = "consultar";
	
	/* OSINE_SFS-1232 - REQF- - Inicio */
	
	

}



