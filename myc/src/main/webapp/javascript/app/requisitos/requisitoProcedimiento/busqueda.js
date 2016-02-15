// data prueba de tramites
var inst=["Instalación","Modificación de Instalación","Aprobación del Manual de diseño de ductos","Autorización para la construcción de Obras","Inicio de Operación del Ducto","Reconsideración","Apelación"];
var prue=["Acta de Verificación de Pruebas","Acta de Verificación de Conformidad","Acta de Verificación de Pruebas y Conformidad"];
var rho=["Inscripción","Modificación de Registro","Reconsideración","Apelación"];
var igs=["Estudio de Riesgo","Plan de Contingencia","Reconsideración","Apelación"];
var of=["Opinión Favorable"];
// data requisitos
var campos = [
    {nombre: 'tipoPersona', titulo: 'TIPO PERSONA', valores: [{id: '2', desc: 'Natural', default: '0'}, {id: '3', desc: 'Juridica', default: '0'}]},
    {nombre: 'tipoPresentacion', titulo: 'TIPO PRESENTACION', valores: [{id: '1', desc: 'Medio Fisico', default: '1'}, {id: '2', desc: 'Medio Magnetico', default: '0'}, {id: '3', desc: 'Medio Fisico y Medio Magnetico', default: '0'}]},
    {nombre: 'aprobado', titulo: 'APROBADO', valores: [{id: '1', desc: 'SI', default: '0'}, {id: '2', desc: 'NO', default: '0'}]},
    {nombre: 'alterno', titulo: 'ALTERNO', valores: [{id: '1', desc: 'SI', default: '0'}, {id: '2', desc: 'NO', default: '1'}]},
    {nombre: 'operadorMultiple', titulo: 'OPERADOR MULTIPLE', valores: [{id: '1', desc: 'SI', default: '0'}, {id: '2', desc: 'NO', default: '0'}]}
];
var reqGral = [
    {idRequ: '1', requisito: 'Formulario de solicitud.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '2', requisito: 'Copia simple del documento de identidad vigente.', tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '', idPadre: '', comentario: ''},
    {idRequ: '3', requisito: 'Copia simple de la Partida o Ficha Registral  donde obra la Constitución Social de la empresa.', tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '', idPadre: '', comentario: ''},
    {idRequ: '4', requisito: 'Copia simple del certificado de vigencia de poderes del representante legal o apoderado.', tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '', idPadre: '', comentario: ''}
];
var reqGralH15=[
    {   idRequ:'1',requisito:'Formulario de solicitud.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'El formulario de solicitud deberá estar completamente llenado y firmado en todas sus páginas por el solicitante o representante legal, a fin de ser admitido para trámite.'
    },
    {   idRequ:'2',requisito:'En caso el proyecto incluya instalaciones que requieran contar con derecho de vía o servidumbre, deberá acreditar dicho derecho con la documentación correspondiente.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:''
    },
    {   idRequ:'3',requisito:'Copia simple del Estudio Ambiental aprobado que corresponda, según la naturaleza del proyecto. Si no fuese obligatorio contar con un Estudio Ambiental aprobado, bastará con presentar un documento emitido por la correspondiente  autoridad competente, donde conste tal situación.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'La presentación de la documentación vinculada al estudio ambiental no será exigible para este trámite en caso la modificación del manual de diseño se solicite antes de la presentación de la primera solicitud para el otorgamiento de la Autorización de Inicio de Construcción del proyecto y siempre que no exista'
    },
    {   idRequ:'4',requisito:'Estudio de suelos.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:''
    },
    {   idRequ:'5',requisito:'Estudio de Riesgos aprobado. ',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'La aprobación no es aplicable a Plantas Envasadoras.'
    },
    {   idRequ:'6',requisito:'Memoria descriptiva.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:''
    },
    {   idRequ:'7',requisito:'Especificaciones técnicas de los equipos principales del proyecto.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:''
    },
    {   idRequ:'8',requisito:'Documentos de Ingeniería siguientes:',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. En casos especiales, los archivos magneticos podrán ser presentados en otros formatos legibles similares o superiores al autocat, previa consulta y aprobación de la correspondiente Unidad Operativa de OSINERGMIN. Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente.'
    },
    {   idRequ:'9',requisito:'Plano de ubicación.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'8',comentario:''
    },
    {   idRequ:'10',requisito:'Planos de distribución con arreglo de planta y equipos.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'8',comentario:''
    },
    {   idRequ:'11',requisito:'Planos de circulación; requisito sólo aplicable cuando el proyecto contempla la instalación de equipos de despacho a vehículos.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'8',comentario:''
    },
    {   idRequ:'12',requisito:'Planos de obras metalmecánicas, instalación de tanques, tuberías y accesorios.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'8',comentario:''
    },
    {   idRequ:'13',requisito:'Planos de instalaciones para atraque de naves, líneas submarinas, brazos de carga, muelles y facilidades para la atención de naves y barcazas, de ser el caso.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'8',comentario:''
    },
    {   idRequ:'14',requisito:'Planos de instalaciones eléctricas e instrumentación, que contenga la clasificación de áreas peligrosas.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'8',comentario:''
    },
    {   idRequ:'15',requisito:'Planos de obras civiles.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'8',comentario:''
    },
    {   idRequ:'16',requisito:'Diagramas de Tuberías e Instrumentación, incluyendo los sistemas de transferencia de combustibles, recuperación de combustibles, recuperación, quemado procesamiento de gases o vapores, protección contra incendios, automatización,  de ser el caso.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:''
    },
    {   idRequ:'17',requisito:'Copia simple de las autorizaciones otorgadas por el administrador del aeropuerto, Dirección General de Aviación Civil (DGA), Dirección General de Capitanía de Puertos (DICAPI) o Autoridad Portuaria Nacional (APN), según corresponda.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:''
    },
    {idRequ: '18', requisito: 'Copia simple del documento de identidad vigente.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'NATURAL', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '19', requisito: 'Copia simple del documento de identidad vigente del representante legal o apoderado, de ser el caso.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'JURIDICA', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '20', requisito: 'Copia simple del certificado de vigencia de poderes del representante legal o apoderado, expedido dentro de los seis (6) meses  previos a la presentación de la solicitud ante el OSINERGMIN.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'JURIDICA', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: 'El apoderado deberá acreditar facultades administrativas de representación.'
    }
]
var reqGralH18 = [
    {idRequ: '1', requisito: 'Formulario de solicitud.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: 'El formulario de solicitud deberá estar completamente llenado y firmado en todas sus páginas por el solicitante o representante legal, a fin de ser admitido para trámite. '
    },
    {idRequ: '2', requisito: 'En caso que el proyecto incluya instalaciones que requieran contar con derecho de vía o servidumbre, deberá acreditar dicho derecho con la  documentación correspondiente.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '3', requisito: 'Copia simple del Estudio Ambiental aprobado que corresponda según la naturaleza del proyecto, incluyendo las observaciones y subsanaciones, en caso las hubiera, así como la resolución que lo aprueba, solo si la actividad es de hidrocarburos. En caso que la actividad principal fuera de hidrocarburos y no fuese obligatorio contar con un estudio ambiental aprobado bastará con presentar un documento emitido por la correspondiente     autoridad competente, donde conste tal situación.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: 'Si al iniciar el trámite, el administrado no cuenta con este documento, podrá presentar el Estudio Ambiental sin aprobar y el documento que acredite haber iniciado el trámite para su aprobación o de la consulta ante la autoridad competente sobre la necesidad de realizar el Estudio Ambiental; debiendo subsanar, antes de la emisión del ITF,'
    },
    {idRequ: '4', requisito: 'Estudio de Riesgos.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '5', requisito: 'Memoria Descriptiva.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '6', requisito: 'Especificaciones técnicas de los tanques, tuberías, equipos y accesorios  principales del proyecto.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '7', requisito: 'Documentos de Ingeniería correspondiente a la obra, siguientes:',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: 'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente.'
    },
    {idRequ: '8', requisito: 'Plano de situación.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '7', comentario: ''
    },
    {idRequ: '9', requisito: 'Plano de ubicacion.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '7', comentario: ''
    },
    {idRequ: '10', requisito: 'Planos de distribución correspondiente a las áreas donde se proyectan las instalaciones de hidrocarburos (recepción, almacenamiento, ventilación,  entre otros), incluyendo circulación y radios de giro si cuenta con equipos de  despacho a vehículos.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '7', comentario: ''
    },
    {idRequ: '11', requisito: 'Planos de instalaciones mecánicas de tanques, válvulas, tuberías, equipos y  accesorios.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '7', comentario: ''
    },
    {idRequ: '12', requisito: 'Planos de instalaciones para atraque de naves, líneas submarinas, brazos de carga, muelles y facilidades para la atención de naves y barcazas, de ser el caso.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '7', comentario: ''
    },
    {idRequ: '13', requisito: 'Planos de instalaciones eléctricas e instrumentación que contenga la   clasificación de áreas peligrosas.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '7', comentario: ''
    },
    {idRequ: '14', requisito: 'Planos de obras civiles (cimentación o fosas para tanques, diques, etc.)',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '7', comentario: ''
    },
    {idRequ: '15', requisito: 'Diagramas de Flujo de Procesos y diagramas de Tuberías e Instrumentación del sistema de transferencia de los combustibles, sistema de recuperación de combustibles, sistema de quemado o procesamiento de gases, sistema de recuperación de vapores, sistema contra incendios, sistemas de automatización, de ser el caso.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
]
var reqGralH23=[
    {   idRequ:'1',requisito:'Formulario de solicitud.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'El formulario de solicitud deberá estar completamente llenado y firmado en todas sus páginas por el solicitante o representante legal, a fin de ser admitido para trámite.'
    },
    {   idRequ:'2',requisito:'Formulario de declaración jurada de cumplimiento de la normativa técnico-legal aplicable.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'El formulario de declaración jurada deberá estar completamente llenado y firmado por el solicitante o representante legal, a fin de ser admitido para trámite. Dicho formulario se obtiene de la página web de OSINERGMIN: http://www.osinerg.gob.pe/newweb/pages/GFH/RegHidro_Anexo3.htm?333'
    },
    {   idRequ:'3',requisito:'Copia simple del certificado de pruebas en maestranza de cada tanque (requisito sólo aplicable a instalaciones de tanques y/o modificaciones de tanques para almacenamiento de combustibles líquidos según corresponda). Para el caso de grifo flotante, éste documento deberá ser emitido por el astillero correspondiente.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'De contar el tanque con dos o más compartimientos, el certificado deberá ser emitido por cada compartimento.'
    },
    {   idRequ:'4',requisito:'Copia simple del acta de verificación de pruebas y del acta de verificación de conformidad, con resultados satisfactorios (para el caso de grifos flotantes solo es aplicable cuando los tanques y/o tuberías se encuentren en tierra).',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'Las actas de verificación de pruebas y las actas de verificación de la conformidad deberán estar suscritas por el solicitante, por el profesional responsable y un supervisor.'
    },
    {   idRequ:'5',requisito:'Fotografías panorámicas nítidas a color con medidas mínimas de 15 x 10 cm, mostrando las instalaciones culminadas del establecimiento y fotografías nítidas en primer plano de las placas de identificación del fabricante de cada uno de los tanques instalados.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'De contar el tanque con dos o más compartimientos, las fotografías serán por cada compartimiento. Todas las fotografías deberán contar necesariamente con leyenda.'
    },
    {   idRequ:'6',requisito:'Plan de contingencias, elaborado y suscrito por un Ingeniero colegiado y habilitado.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:''
    },
    {   idRequ:'7',requisito:'Copia simple de la póliza de seguros de responsabilidad civil extracontractual vigente.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:'Los montos y las coberturas de las pólizas de seguro de responsabilidad civil extracontractual deberán estar en concordancia con el tipo de instalación, establecimiento o medio utilizado.' 
    },
    {   idRequ:'8',requisito:'Índice de Riesgos del Sistema de Tanques Enterrados de Combustibles Líquidos.',
        tramite:'',actividad:'',zonificacion:'',tipoPersona:'',aprobado:'',tipoPresentacion:'',alterno:'',
        idPadre:'',comentario:''
    },
    {idRequ: '9', requisito: 'Copia simple del documento de identidad vigente.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'NATURAL', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '10', requisito: 'Copia simple del documento de identidad vigente del representante legal o apoderado, de ser el caso.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'JURIDICA', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '11', requisito: 'Copia simple del certificado de vigencia de poderes del representante legal o apoderado, expedido dentro de los seis (6) meses  previos a la presentación de la solicitud ante el OSINERGMIN.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'JURIDICA', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: 'El apoderado deberá acreditar facultades administrativas de representación.'
    }
]

var reqEspe = [
    {idRequ: '5', requisito: 'Copia simple del documento de identidad vigente del representante legal o apoderado, de ser el caso.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'JURIDICA', aprobado: '', tipoPresentacion: 'MEDIO FISICO', alterno: '',
        idPadre: '', comentario: ''},
    {idRequ: '6', requisito: 'Estudio de Riesgos.', tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '', idPadre: '', comentario: ''},
    {idRequ: '7', requisito: 'De Ubicación.', tramite: '', actividad: '', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: 'MEDIO MAGNETICO', alterno: '', idPadre: '6', comentario: ''},
    {idRequ: '8', requisito: 'De Distribución.', tramite: '', actividad: '', zonificacion: '', tipoPersona: 'JURIDICA', aprobado: '', tipoPresentacion: '', alterno: '', idPadre: '6', comentario: ''}
];
var reqEspeH15 = [
    
];
var reqEspeH18 = [
    {idRequ: '16', requisito: 'Copia simple del documento de identidad vigente.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'NATURAL', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '17', requisito: 'Copia simple del documento de identidad vigente del representante legal o apoderado, de ser el caso.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'JURIDICA', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '18', requisito: 'Copia simple del certificado de vigencia de poderes del representante legal o apoderado, expedido dentro de los seis (6) meses previos a la presentación de la solicitud ante el OSINERGMIN.',
        tramite: '', actividad: '', zonificacion: '', tipoPersona: 'JURIDICA', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '19', requisito: 'Solicitud para la instalación de equipos que permitan el suministro de combustibles únicamente a los medios de transporte durante la construcción de las instalaciones de Consumidor Directo de Combustibles Líquidos y/u Otros Productos Derivados de los Hidrocarburos. En esta solicitud se deberá justificar documentalmente la cantidad y tipo de combustible a consumir y el  plazo requerido para la permanencia de la instalación.',
        tramite: '', actividad: 'Consumidor Directo con Instalaciones Estartégicas Temporales de  Combustibles Líquidos y OPDH', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '20', requisito: 'Si realiza actividades de minería conforme a la legislación vigente, presentará el cargo de entrega de la Declaración de Compromisos (artículo 5° del Decreto Legislativo N° 1105) al Gobierno Regional de Madre de Dios o el documento que acredite la Titularidad, Contrato de Cesión, Acuerdo o Contrato de Explotación sobre la Concesión Minera. ',
        tramite: '', actividad: 'Consumidor Directo Especial de Combustible Líquido y OPDH', zonificacion: 'VRAE', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '21', requisito: 'En la Memoria Descriptiva deberá incluir adicionalmente, las especificaciones técnicas, la descripción de todos los equipos y sistemas a utilizar, así como la justificación técnica documentada del uso de todos los combustibles líquidos y/u Otros Productos Derivados de los Hidrocarburos a consumir y el cálculo de la proyección mensual de consumo en galones por producto y por cada equipo a instalar.',
        tramite: '', actividad: 'Consumidor Directo Especial de Combustible Líquido y OPDH', zonificacion: 'VRAE', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    }
];
var reqEspeH23 = [
    {idRequ: '12', requisito: 'Copia simple de los certificados de conformidad de los tanques de almacenamiento de GLP, otorgados por un organismo de certificación acreditado por el Servicio Nacional de Acreditación del INDECOPI que certifique que han sido diseñados, fabricados y probados conforme a la Norma Técnica Peruana, al Código ASME Sección VIII o norma técnica internacional reconocida por el Ministerio de Energía y Minas; o en su reemplazo un reporte U-1 o U-1A según el Código ASME Sección VIII firmado un inspector autorizado de la National Board. En caso que la instalación de GLP cuente con tanques que han sido reparados (en los que la reparación incluya la modificación estructural de las partes sometidas a presión), o modificados, o que no cuenten con el certificado de conformidad de origen, deberán presentar un certificado de inspección que certifique que los tanques de almacenamieno de GLP, se encuentran aptos para seguir operando de acuerdo a la normativa nacional vigente, o al código API 510 o al código NB-23, otorgados por un organismo de inspección acreditado por el Servicio Nacional de Acreditación del INDECOPI. Para el caso de tanques que hayan sido retirados de una instalación y que se reinstalen en otra, se deberá contar con un Certificado de Inspección de acuerdo a lo indicado en el párrafo precedente.',
        tramite: '', actividad: 'Grifo, Estación de Servicios, Estación de Servicios con Gasocentro de GLP y Gasocentro de GLP, Estación de Servicios con Gasocentro de GNV; Estación de Servicios con Gasocentro de GLP y GNV; Gasocentro de GLP y GNV.', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '13', requisito: 'Copia simple de los documentos que demuestren la instalación, según los cálculos realizados, del sistema de protección catódica de tanques y tuberías metálicos monticulados o soterrados, suscritas por el profesional responsable.',
        tramite: '', actividad: 'Grifo, Estación de Servicios, Estación de Servicios con Gasocentro de GLP y Gasocentro de GLP, Estación de Servicios con Gasocentro de GNV; Estación de Servicios con Gasocentro de GLP y GNV; Gasocentro de GLP y GNV.', zonificacion: 'VRAE', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '14', requisito: 'En caso de establecimientos ubicados en zonas urbanas que cuenten con hidrantes o grifos contra incendios, deberán presentar un documento emitido por la empresa de saneamiento de la localidad que acredite el abastecimiento constante de la red pública de agua (requisito sólo aplicable, si se han realizado instalaciones que incluyan el expendio de GLP para uso automotor).',
        tramite: '', actividad: 'Grifo, Estación de Servicios, Estación de Servicios con Gasocentro de GLP y Gasocentro de GLP, Estación de Servicios con Gasocentro de GNV; Estación de Servicios con Gasocentro de GLP y GNV; Gasocentro de GLP y GNV.', zonificacion: 'VRAE', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '15', requisito: 'Planos conforme a obra, según corresponda.',
        tramite: '', actividad: 'Grifo, Estación de Servicios, Estación de Servicios con Gasocentro de GLP y Gasocentro de GLP, Estación de Servicios con Gasocentro de GNV; Estación de Servicios con Gasocentro de GLP y GNV; Gasocentro de GLP y GNV.', zonificacion: 'VRAE', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: 'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. El archivo en formato autocad es opcional para los casos de Grifo flotante y Grifo rural con almacenamiento en cilindros.Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente. Este requisito no será aplicable cuando las instalaciones han sido construidas o modificadas sin variación respecto de lo proyectado en el Informe Técnico de Instalación o de Modificación, para cuyo caso los planos presentados serán considerados como planos Conforme a Obras.'
    },
    {idRequ: '16', requisito: 'Copia simple del Estudio Ambiental aprobado que corresponda según la naturaleza del proyecto, incluyendo las observaciones y subsanaciones, en caso las hubiere; así como la resolución que lo aprueba, emitida por la autoridad competente, si corresponde. Si, por la naturaleza del proyecto, no fuese obligatorio contar con un Estudio Ambiental aprobado, bastará con presentar un documento emitido por la correspondiente autoridad competente, donde conste tal situación.',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '17', requisito: 'Copia simple de la constancia de ubicación y conformidad de la embarcación o balsa flotante; y de las líneas submarinas, de ser el caso, emitido por la capitanía de puerto respectiva, otorgada a favor del solicitante de la Inscripción o modificación en el registro de hidrocarburos; en donde se acredite que cuenta con el correspondiente derecho de uso de áreas acuáticas.',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '18', requisito: 'Copia simple del certificado de matrícula vigente de la embarcación o balsa flotante emitido por la Dirección General de Capitanía de Puertos (DICAPI).',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '19', requisito: 'Para el caso de instalaciones de líneas submarinas deberá presentar copia simple de la Autorización de construcción, otorgada por la autoridad competente de conformidad con la normativa vigente.',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '20', requisito: 'Estudios de riesgos, incluyendo el sistema de recepción de combustible (desde la ribera, litoral, tierra o zona acuática según corresponda).',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '21', requisito: 'Copia simple de los documentos que demuestren la instalación, según los cálculos realizados, del sistema de protección catódica de tanques y tuberías       metálicos soterrados, suscritas por el profesional responsable.',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '22', requisito: 'Memoria descriptiva que incluya las especificaciones técnicas de las instalaciones de hidrocarburos.',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '23', requisito: 'Documentos de Ingeniería correspondiente a la obra, siguientes:',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '24', requisito: 'Plano de situación (escala 1:500).',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '23', comentario: 'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. El archivo en formato autocad es opcional para los casos de Grifo flotante y Grifo rural con almacenamiento en cilindros.Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente.'
    },
    {idRequ: '25', requisito: 'Plano de ubicación indicando las coordenadas UTM del área autorizada (escala 1:500).',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '23', comentario: 'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. El archivo en formato autocad es opcional para los casos de Grifo flotante y Grifo rural con almacenamiento en cilindros.Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente.'
    },
    {idRequ: '26', requisito: 'Plano de distribución, señalando los sistemas de recepción (desde la ribera, litoral, tierra o zona acuática, según corresponda), almacenamiento, ventilación y despacho (escala 1:100).',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '23', comentario: 'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. El archivo en formato autocad es opcional para los casos de Grifo flotante y Grifo rural con almacenamiento en cilindros.Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente.'
    },
    {idRequ: '27', requisito: 'Plano de las instalaciones mecánicas correspondiente a los sistemas de recepción de combustible (desde la ribera, litoral, tierra o zona acuática, según corresponda), almacenamiento, despacho, ventilación y recuperación de vapores (éste último, sólo aplicable para combustibles líquidos Clase I).',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '23', comentario: 'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. El archivo en formato autocad es opcional para los casos de Grifo flotante y Grifo rural con almacenamiento en cilindros.Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente.'
    },
    {idRequ: '28', requisito: 'Plano de instalaciones eléctricas e instrumentación que contenga la clasificación de áreas peligrosas.',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '23', comentario: 'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. El archivo en formato autocad es opcional para los casos de Grifo flotante y Grifo rural con almacenamiento en cilindros.Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente.'
    },
    {idRequ: '29', requisito: 'Plano del sistema de seguridad contra incendio.',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '23', comentario: 'Los planos deben ser presentados en escalas normalizadas adecuadas, con excepción de las indicadas expresamente. Asimismo la presentación de los planos será de manera física y magnética. Por cada plano solicitado se deberá adjuntar 01 archivo magnético, en formato legible en autocad. El archivo en formato autocad es opcional para los casos de Grifo flotante y Grifo rural con almacenamiento en cilindros.Los planos físicos deben estar firmados por el solicitante o su representante legal y por los profesionales responsables de la especialidad, inscritos y habilitados en el colegio profesional correspondiente.'
    },
    {idRequ: '30', requisito: 'Plano de la embarcación aprobados por la Dirección General de Capitanía de Puertos (DICAPI).',
        tramite: '', actividad: 'Grifo flotante', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '23', comentario: ''
    },
    {idRequ: '31', requisito: 'Copia simple del Estudio Ambiental aprobado que corresponda según la naturaleza del proyecto, incluyendo las observaciones y subsanaciones, en caso las hubiere; así como la resolución que lo aprueba, emitida por la autoridad competente, si corresponde. Si, por la naturaleza del proyecto, no fuese obligatorio contar con un Estudio Ambiental aprobado, bastará con presentar un documento emitido por la correspondiente autoridad competente, donde conste tal situación.',
        tramite: '', actividad: 'Grifo Rural', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '32', requisito: 'Copia simple de la clasificación de la zona otorgada por la municipalidad provincial. Para el caso de un proyecto de modificación de la inscriipción del registro de hidrocarburos, el requisito sólo aplica a establecimientos que amplían la capacidad de almacenamiento y/o amplían el área del establecimiento.',
        tramite: '', actividad: 'Grifo Rural', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '33', requisito: 'Memoria descriptiva que incluya las especificaciones técnicas de las instalaciones de hidrocarburos.',
        tramite: '', actividad: 'Grifo Rural', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '34', requisito: 'Documentos de Ingeniería correspondiente a la obra, siguientes:',
        tramite: '', actividad: 'Grifo Rural', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '35', requisito: 'Plano de situación (escala 1:5000).',
        tramite: '', actividad: 'Grifo Rural', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '34', comentario: ''
    },
    {idRequ: '36', requisito: 'Plano de localización o croquis del establecimiento firmado por el solicitante o su representante legal.',
        tramite: '', actividad: 'Grifo Rural', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '34', comentario: ''
    },
    {idRequ: '37', requisito: 'Plano de distribución, señalando la ubicación de los cilindros, equipos contra incendio y pozo(s) a tierra a utilizarse durante el proceso de descarga.',
        tramite: '', actividad: 'Grifo Rural', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '34', comentario: ''
    },
    {idRequ: '38', requisito: 'Plano de instalaciones eléctricas e instrumentación que contenga la clasificación de áreas peligrosas (de ser el caso).',
        tramite: '', actividad: 'Grifo Rural', zonificacion: '', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '34', comentario: ''
    },
    {idRequ: '39', requisito: 'Estudio que asegure la factibilidad del transporte de combustible desde la Planta hasta el punto de descarga del establecimiento. Para el presente caso se exige que el transporte sea contínuo y que en todo el trayecto se cumpla con la normativa vigente.',
        tramite: '', actividad: '', zonificacion: 'VRAEN', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '40', requisito: 'Instalación en el establecimiento de sistema de video vigilancia que opere permanentemente.',
        tramite: '', actividad: '', zonificacion: 'VRAEN', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: ''
    },
    {idRequ: '41', requisito: 'Instalación en el establecimiento de un sistema de medición automática de tanques (ATG) que opere permanentemente.',
        tramite: '', actividad: '', zonificacion: 'VRAEN', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: '',operadorMultiple: ''
    },
    {idRequ: '42', requisito: 'Presentar conjuntamente con la solicitud una declaración jurada a través de la cual se declare el o los operadores que son solidariamente responsables por operar en el mismo establecimiento; distinguiendo los espacios comunes de los propios de cada uno de los operadores.',
        tramite: '', actividad: '', zonificacion: 'VRAEN', tipoPersona: '', aprobado: '', tipoPresentacion: '', alterno: '',
        idPadre: '', comentario: '',operadorMultiple: 'SI'
    }
    

    
    
];

$(function() {
    procesarGridProcedimiento("0");
    initInicioProc();
    initArbolActividadesBusq();
    $('#frmMantProcedimiento').validarForm();
});
function initInicioProc() {
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/configuracionRequisitos';
    });
    confirm.start();
    $('#btnBuscarProc').click(function(){procesarGridProcedimiento();});
    $('#cmbProcesoBusq').change(cargaTramiteBusq);
    $("#dialogProcedimientoRequisitos").dialog({
        resizable: false,
        draggable: true,
        autoOpen: false,
        height: "auto",
        width: 1024,
        modal: true,
        dialogClass: 'dialog',
        title: "CONSULTAR REQUISITOS PROCEDIMIENTO"
    });
}
/////////////////////////
//CONSULTAR PROC - INICIO
/*function verProcedimiento(rowid){
 $.ajax({
 url:baseURL + "pages/procedimiento/abrirMantProcedimiento", 
 type:'get',
 async:false,
 data:{
 },
 beforeSend:muestraLoading,
 success:function(data){
 ocultaLoading();
 $("#dialogMantProcedimiento").html(data);
 $("#dialogMantProcedimiento").dialog({
 resizable: false,
 draggable: true,
 autoOpen: true,
 height:"auto",
 width: "auto",
 modal: true,
 dialogClass: 'dialog',
 title: "CONSULTA PROCEDIMIENTO"
 });
 
 var row = $('#gridProcedimiento').jqGrid('getRowData', rowid);
 $('#txtIdProcedimiento').val(rowid);
 $('#txtItemProc').val(row.item);
 $('#txtNombreRequ').val(row.codigo);
 $('#txtDenominacionProc').val(row.descripcion);
 $('#cmbProceso').val(row.proceso);
 
 $('#frmMantProcedimiento').find('input,select,textarea').attr('disabled',true);
 $('#dialogMantProcedimiento').dialog('open');
 },
 error:errorAjax
 });
 }*/
function verRequisitosProcedimiento(rowid) {
    var row = $('#gridProcedimiento').jqGrid('getRowData', rowid);
    $('#lblProcedimiento').html(fxGrilla.limpiaPtos(row.denominacion));
    $('#lblProceso').html(row.proceso);

    armaCabeceraRequisitos();
    var dataGral = reqGral;
    var dataEspe = reqEspe;
    if (row.item == 'H15') {
        dataGral = reqGralH15;
        dataEspe = reqEspeH15;
    } else if (row.item == 'H18') {
        dataGral = reqGralH18;
        dataEspe = reqEspeH18;
    }else if (row.item == 'H23') {
        dataGral = reqGralH23;
        dataEspe = reqEspeH23;
    }
    armaGeneralesRequisitos(dataGral);
    armaEspecificosRequisitos(dataEspe);

    $('#dialogProcedimientoRequisitos').dialog('open');
}
function armaCabeceraRequisitos() {
    /*var html="<div class='fila'>";
     html+="<div class='desc ilb' title='DESCRIPCION'>DESCRIPCION</div>";
     html+="<div class='camp ilb' title='TRAMITE'>TRAMITE</div>";
     html+="<div class='camp ilb' title='ACTIVIDAD'>ACTIVIDAD</div>";
     html+="<div class='camp ilb' title='ZONIFICACION'>ZONIFICACION</div>";
     html+="<div class='camp ilb' title='TIPO PERSONA'>TIPO PERSONA</div>";
     $.each(campos,function(k,v){
     html+="<div class='camp ilb' title='"+v.titulo+"'>"+v.titulo+"</div>";
     });
     html+="</div>";
     $('#headRequ').html(html);*/
    var html = "<div class='fila'>";
    html += "<div class='desc ilb titu vam' title='DESCRIPCION'>DESCRIPCION</div>";
    html += "<div class='camp ilb titu vam' title='TRAMITE'>TRAMITE</div>";
    html += "<div class='camp ilb titu vam acti' title='ACTIVIDAD'>ACTIVIDAD</div>";
    html += "<div class='camp ilb titu vam' title='ZONIFICACION'>ZONIFICACION</div>";
    $.each(campos, function(k, v) {
        html += "<div class='camp ilb titu vam' title='" + v.titulo + "'>" + v.titulo + "</div>";
    });
    html += "</div>";
    $('#headRequ').html(html);
}
function armaGeneralesRequisitos(reqGral) {
    /*var html="";
     $.each(reqGral,function(key,val){
     html+="<div class='fila' id='gralRequ"+val.idRequ+"'><div>";
     html+="<div class='desc ilb' title='"+val.requisito+"'>"+val.requisito+"</div>";
     html+="<div class='camp ilb' title='"+val.tramite+"'>"+val.tramite+"</div>";
     html+="<div class='camp ilb' title='"+val.actividad+"'>"+val.actividad+"</div>";
     html+="<div class='camp ilb' title='"+val.zonificacion+"'>"+val.zonificacion+"</div>";
     html+="<div class='camp ilb' title='"+val.tipo_persona+"'>"+val.tipo_persona+"</div>";
     $.each(campos,function(k,v){
     html+="<div class='camp ilb' title='"+val[v.nombre]+"'>"+val[v.nombre]+"</div>";
     });
     html+="</div></div>";
     });
     $('#gralRequ').html(html);*/
    var html = "";
    $.each(reqGral, function(key, val) {
        if (val.idPadre == '') {
            html += "<div class='fila' id='gralRequ" + val.idRequ + "'><div>";
            html += "<div class='desc ilb vat' title='" + val.requisito + "'>" + val.requisito + "</div>";
            html += "<div class='camp ilb vat' title='" + val.tramite + "'>" + val.tramite + "</div>";
            html += "<div class='camp ilb vat acti' title='" + val.actividad + "'>" + val.actividad + "</div>";
            html += "<div class='camp ilb vat' title='" + val.zonificacion + "'>" + val.zonificacion + "</div>";
            $.each(campos, function(k, v) {
                var nombre = (val[v.nombre] == undefined) ? '' : val[v.nombre];
                html += "<div class='camp ilb vat' title='" + nombre + "'>" + nombre + "</div>";
            });
            html += "</div></div>";
        }
    });
    $('#gralRequ').html(html);
    //ingresando hijos 2do nivel
    $.each(reqGral, function(key, val) {
        if (val.idPadre != '') {
            var html = "<div class='fila sr' id='subRequi" + val.idRequ + "'>";
            html += "<div class='desc ilb vat' title='" + val.requisito + "' style='margin-left:10px;width:290px;'>" + val.requisito + "</div>";

            html += "<div class='camp ilb vat' title='" + val.tramite + "'>" + val.tramite + "</div>";
            html += "<div class='camp ilb vat acti' title='" + val.actividad + "'>" + val.actividad + "</div>";
            html += "<div class='camp ilb vat' title='" + val.zonificacion + "'>" + val.zonificacion + "</div>";
            $.each(campos, function(k, v) {
                var nombre = (val[v.nombre] == undefined) ? '' : val[v.nombre];
                html += "<div class='camp ilb vat' title='" + nombre + "'>" + nombre + "</div>";
            });
            html += "</div>";
            $('#gralRequ' + val.idPadre).append(html);
        }
    });
}
function armaEspecificosRequisitos(reqEspe) {
    /*var html="";
     $.each(reqEspe,function(key,val){
     if(val.idPadre==''){
     html+="<div class='fila' id='espeRequ"+val.idRequ+"'>";
     html+="<div class='desc ilb' title='"+val.requisito+"'>"+val.requisito+"</div>";
     html+="<div class='camp ilb' title='"+val.tramite+"'>"+val.tramite+"</div>";
     html+="<div class='camp ilb' title='"+val.actividad+"'>"+val.actividad+"</div>";
     html+="<div class='camp ilb' title='"+val.zonificacion+"'>"+val.zonificacion+"</div>";
     html+="<div class='camp ilb' title='"+val.tipo_persona+"'>"+val.tipo_persona+"</div>";
     $.each(campos,function(k,v){
     html+="<div class='camp ilb' title='"+val[v.nombre]+"'>"+val[v.nombre]+"</div>";
     });
     html+="</div>";
     }
     });
     $('#espeRequ').html(html);
     //ingresando hijos 2do nivel
     $.each(reqEspe,function(key,val){
     if(val.idPadre!=''){
     var html="<div class='fila' id='subRequi"+val.idRequ+"'>";
     html+="<div class='desc ilb' title='"+val.requisito+"' style='margin-left:10px;width:290px;'>"+val.requisito+"</div>";
     html+="<div class='camp ilb' title='"+val.tramite+"'>"+val.tramite+"</div>";
     html+="<div class='camp ilb' title='"+val.actividad+"'>"+val.actividad+"</div>";
     html+="<div class='camp ilb' title='"+val.zonificacion+"'>"+val.zonificacion+"</div>";
     html+="<div class='camp ilb' title='"+val.tipo_persona+"'>"+val.tipo_persona+"</div>";
     $.each(campos,function(k,v){
     html+="<div class='camp ilb' title='"+val[v.nombre]+"'>"+val[v.nombre]+"</div>";
     });
     html+="</div>";
     $('#espeRequ'+val.idPadre).append(html);
     }
     });*/
    var html = "";
    $.each(reqEspe, function(key, val) {
        if (val.idPadre == '') {
            html += "<div class='fila' id='espeRequ" + val.idRequ + "'>";
            html += "<div class='desc ilb vat' title='" + val.requisito + "'>" + val.requisito + "</div>";
            html += "<div class='camp ilb vat' title='" + val.tramite + "'>" + val.tramite + "</div>";
            html += "<div class='camp ilb vat acti' title='" + val.actividad + "'>" + val.actividad + "</div>";
            html += "<div class='camp ilb vat' title='" + val.zonificacion + "'>" + val.zonificacion + "</div>";
            $.each(campos, function(k, v) {
                var nombre = (val[v.nombre] == undefined) ? '' : val[v.nombre];
                html += "<div class='camp ilb vat' title='" + nombre + "'>" + nombre + "</div>";
            });
            html += "</div>";
        }
    });
    $('#espeRequ').html(html);
    //ingresando hijos 2do nivel
    $.each(reqEspe, function(key, val) {
        if (val.idPadre != '') {
            var html = "<div class='fila sr' id='subRequi" + val.idRequ + "'>";
            html += "<div class='desc ilb vat' title='" + val.requisito + "' style='margin-left:10px;width:290px;'>" + val.requisito + "</div>";
            html += "<div class='camp ilb vat' title='" + val.tramite + "'>" + val.tramite + "</div>";
            html += "<div class='camp ilb vat acti' title='" + val.actividad + "'>" + val.actividad + "</div>";
            html += "<div class='camp ilb vat' title='" + val.zonificacion + "'>" + val.zonificacion + "</div>";
            $.each(campos, function(k, v) {
                var nombre = (val[v.nombre] == undefined) ? '' : val[v.nombre];
                html += "<div class='camp ilb vat' title='" + nombre + "'>" + nombre + "</div>";
            });
            html += "</div>";
            $('#espeRequ' + val.idPadre).append(html);
        }
    });
}
//CONSULTAR PROC - FIN
/////////////////////////
function procesarGridProcedimiento(flg_load) {
    if(flg_load === undefined){flg_load=1;}

    /*var mydata = [
        {item: "H13", descripcion: "INFORME TÉCNICO FAVORABLE DEL AVANCE DE OBRAS EN LA CONCESIÓN DEL: SERVICIO DE TRANSPORTE DE HIDROCARBUROS POR DUCTOS, PARA OBTENER LA LIBERACIÓN PARCIAL DE LA GARANTÍA OTORGADA POR EL CONCESIONARIO", proceso: "INSTALACION", tieneAct: 0},
        {item: "H15", descripcion: "INFORME TÉCNICO FAVORABLE PARA INSTALACIÓN O MODIFICACIÓN DE: PLANTAS DE LUBRICANTES, PLANTAS DE ABASTECIMIENTO, PLANTAS ENVASADORAS Y TERMINALES", proceso: "INSTALACION", tieneAct: 1},
        {item: "H16", descripcion: "INFORME TÉCNICO FAVORABLE PARA INSTALACIÓN O MODIFICACIÓN DE: SISTEMAS DE DESPACHO DE COMBUSTIBLES PARA AVIACIÓN Y EMBARCACIONES", proceso: "INSTALACION", tieneAct: 1},
        {item: "", descripcion: "INSCRIPCIÓN O MODIFICACION DEL REGISTRO DE HIDROCARBUROS DE: PLANTAS DE LUBRICANTES, PLANTAS DE ABASTECIMIENTO, PLANTAS ENVASADORAS Y TERMINALES", proceso: "RHO", tieneAct: 0},
        {item: "", descripcion: "ACTAS DE VERIFICACIÓN DE PRUEBAS Y CONFORMIDAD", proceso: "PRUEBAS", tieneAct: 1},
        {item: "H18", descripcion: "INFORME TÉCNICO FAVORABLE PARA INSTALACIÓN O MODIFICACIÓN DE: CONSUMIDOR DIRECTO DE COMBUSTIBLES LIQUIDOS Y/U  OTROS PRODUCTOS DERIVADOS DE LOS HIDROCARBUROS", proceso: "INSTALACION", tieneAct: 1}
    ];
    var mydataSubGrid = [
        {nombre: "Planta de Lubricante y Grasas"}, {nombre: "Plantas de Abastecimiento de Combustible Líquido y OPDH"},
        {nombre: "Plantas de Abastecimiento de Aeropuerto"}, {nombre: "Plantas de Abastecimiento de GLP"},
        {nombre: "Planta Envasadora de GLP"}, {nombre: "Terminales Combustibles Líquidos"}, {nombre: "Terminales GLP"},
        {nombre: "Terminales OPDH"}
    ];
    var mydataSubGridH15 = [
        {nombre: "Planta de Lubricante y Grasas"},
        {nombre: "Planta Envasadora de GLP"},
        {nombre: "Plantas de Abastecimiento de Aeropuerto"},
        {nombre: "Plantas de Abastecimiento de Combustible Líquido y OPDH"},
        {nombre: "Plantas de Abastecimiento de GLP"},
        {nombre: "Terminales Combustibles Líquidos"},
        {nombre: "Terminales Fluviales"},
        {nombre: "Terminales GLP"},
        {nombre: "Terminales Maritimos"},
        {nombre: "Terminales OPDH"}
    ];
    var mydataSubGridH18 = [
        {nombre: "Consumidor Directo con Instalaciones Estartégicas de Combustibles Líquidos y OPDH"},
        {nombre: "Consumidor Directo con Instalaciones Estartégicas Temporales de  Combustibles Líquidos y OPDH"},
        {nombre: "Consumidor Directo de Aviación (Fijo y Movil)"},
        {nombre: "Consumidor Directo de Combustible Líquido con capacidad de 5MB a 50MB"},
        {nombre: "Consumidor Directo de Combustible Líquido con capacidad hasta 5MB"},
        {nombre: "Consumidor Directo de Combustible Líquido con capacidad mayor a 50MB"},
        {nombre: "Consumidor Directo de Combustible Líquido y OPDH  con capacidad hasta 5 MB"},
        {nombre: "Consumidor Directo de OPDH"},
        {nombre: "Consumidor Directo de Petróleo (Fijo y Movil)"},
        {nombre: "Consumidor Directo Especial de Combustible Líquido y OPDH"},
        {nombre: "Consumidor Directo Estratégico"},
        {nombre: "Consumidor Directo Móvil de Combustible Líquido y OPDH"}
    ];*/

    var nombres = ['CODIGO', 'DENOMINACION DE PROCEDIMIENTO', 'ETAPA DE PROCESO', 'tieneAct'];
    var columnas = [
        {name: "item", width: 30, sortable: false, align: "center"},
        {name: "denominacion", width: 500, sortable: false, align: "left"},
        {name: "proceso", width: 80, sortable: false, hidden: false, align: "center"},
        {name: "tieneAct", width: 30, sortable: false, hidden: true, align: "center"}
    ];
    var nombresSubGrid = ['ACTIVIDAD'];
    var columnasSubGrid = [{name: "descripcionActividad",width: 450,sortable: false,align: "left"}];

    $("#gridContenedorProcedimiento").html("");
    var grid = $("<table>", {
        "id": "gridProcedimiento"
    });
    var pager = $("<div>", {
        "id": "paginacionProcedimiento"
    });
    $("#gridContenedorProcedimiento").append(grid).append(pager);

    grid.jqGrid({
        url: baseURL + "pages/procedimiento/findProcedimiento",
        datatype: "json",
        postData: {
            flg_load:flg_load
        },
        hidegrid: false,
        //rowNum: global.rowNum,
        rowNum: 10,
        pager: "#paginacionProcedimiento",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Procedimientos",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idProcedimiento"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid) {
            var row = grid.jqGrid('getRowData', rowid);
            //$('#linkVerProcedimiento').attr('onClick', 'verProcedimiento("'+rowid+'")');
            $('#linkVerProcedimiento').attr('onClick', 'verRequisitosProcedimiento("' + rowid + '")');
            $('#linkGestionarRequisitosProcedimiento').attr('onClick', 'gestionarRequProcedimiento("' + rowid + '")');
        },
        loadComplete: function(data) {
            /*for (var i = 0; i <= mydata.length; i++) {
                jQuery("#gridProcedimiento").jqGrid('addRowData', i + 1, mydata[i]);
            }*/

            $('#contextMenuProcedimiento').parent().remove();
            $('#divContextMenuProcedimiento').html("<ul id='contextMenuProcedimiento'>"
                    + "<li> <a id='linkVerProcedimiento' data-icon='ui-icon-search' title='Ver Detalle'>Consultar</a> </li>"
                    //+ "<li> <a id='linkAgregarActProcedimiento' data-icon='ui-icon-note' title='Agregar Actividades'>Agregar Actividades</a></li>"
                    + "<li> <a id='linkGestionarRequisitosProcedimiento' data-icon='ui-icon-clipboard' title='Gestionar Requisitos'>Gestionar Requisitos</a></li>"
                    + "</ul>");
            $('#contextMenuProcedimiento').puicontextmenu({
                target: $('#gridProcedimiento')
            });
            //colocando puntos suspensivos
            fxGrilla.setPtosSuspensivos('gridProcedimiento', 'descripcion');
        },
        resizeStop: function() {
            //colocando puntos suspensivos
            fxGrilla.setPtosSuspensivos('gridProcedimiento', 'descripcion');
        },
        //SUBGRID
        subGrid: true,
        afterInsertRow: function(rowid, aData, rowelem) {
            var rowData = grid.getRowData(rowid);
            if (rowData["tieneAct"] == 0) {
                $('tr#' + rowid, grid)
                        .children("td.sgcollapsed")
                        .html("")
                        .removeClass('ui-sgcollapsed sgcollapsed');
            }
        },
        subGridOptions: {
            "plusicon": "ui-icon-circle-plus",
            "minusicon": "ui-icon-circle-minus",
            "openicon": "ui-icon-arrowreturn-1-e",
            "reloadOnExpand": false,
            "selectOnExpand": true
        },
        subGridRowExpanded: function(subgrid_id, row_id) {
            var subgrid_table_id, pager_id;
            subgrid_table_id = subgrid_id + "_t";
            pager_id = "p_" + subgrid_table_id;
            $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
            jQuery("#" + subgrid_table_id).jqGrid({
                url: baseURL + "pages/procedimiento/findActividadProcedimiento",
                datatype: "json", 
                postData: {
                    idProcedimiento:row_id,
                    flg_load:1
                },
                colNames: nombresSubGrid,
                colModel: columnasSubGrid,
                //rowNum: global.rowNum,
                rowNum: 10,
                pager: pager_id,
                sortname: 'num',
                sortorder: "asc",
                height: '100%',
                autowidth: true,jsonReader: {
                    root: "filas",
                    page: "pagina",
                    total: "total",
                    records: "registros",
                    repeatitems: false,
                    id: "idActividad"
                },
                
                loadComplete: function(data) {
                    /*var data = mydataSubGrid;
                    //DATA PERSONALIZADA
                    var rowData = grid.getRowData(row_id);
                    if (rowData.item == 'H15') {
                        data = mydataSubGridH15;
                    }
                    else if (rowData.item == 'H18') {
                        data = mydataSubGridH18;
                    }
                    ////////////////////
                    for (var i = 0; i <= data.length; i++) {
                        jQuery("#" + subgrid_table_id).jqGrid('addRowData', i + 1, data[i]);
                    }*/

                    $('#contextMenuProcedimientoSub').parent().remove();
                    $('#divContextMenuProcedimientoSub').html("<ul id='contextMenuProcedimientoSub'>"
                            + "<li> Sin Accion </li>"
                            + "</ul>");
                    $('#contextMenuProcedimientoSub').puicontextmenu({
                        target: $("#gridProcedimiento .ui-subgrid")
                    });
                    $('#contextMenuProcedimientoSub').parent().css('opacity', 0);
                }
            });
        }
    });
}
function gestionarRequProcedimiento(rowid) {
    $('#postGestionarRequisitos').find('input').val('');
    var row = $('#gridProcedimiento').jqGrid('getRowData', rowid);
    $('#idProcedimientoP').val(rowid);
    $('#itemP').val(row.item);
    $('#procedimientoP').val(fxGrilla.limpiaPtos(row.denominacion));
    $('#procesoP').val(row.proceso);
    document.forms["postGestionarRequisitos"].submit();
}
function cargaTramiteBusq() {
    var data;
    switch ($('#cmbProcesoBusq').val()) {
        case 'INSTALACION':
            data=inst;
            break;
        case 'PRUEBAS':
            data=prue;
            break;
        case 'RHO':
            data=rho;
            break;
        case 'IGS':
            data=igs;
            break;
        case 'OF':
            data=of;
            break;
        default : 
            data=[];
    }
    var html = "<option value=''>--Seleccione--</option>";
    $.each(data, function(k, v) {
        html += "<option value='" + v + "'>" + v + "</option>";
    });
    $('#cmbTramiteBusq').html(html);
}
/*ARBOLES*/
function initArbolActividadesBusq() {
    $("#arbolActividadesBusq").fancytree({
        checkbox: true,
        selectMode: 3, //selectMode: 2,
        //source:treeData,
        select: function(event, data) {
            var selKeys = $.map(data.tree.getSelectedNodes(), function(node) {
                if (!node.folder) {
                    return node.key;
                }
            });
            $("#idActividadesSelecBusq").val(selKeys.join(","));
        },
        click: function(event, data) {
            //data.node.toggleSelected();
        },
        keydown: function(event, data) {
            if (event.which === 32) {
                data.node.toggleSelected();
                return false;
            }
        },
        //las sgtes lineas opcionales, son requeridas si existe mas de un arbol en una pagina:
        //initId: "treeData",
        cookieId: "fancytree-Cb1",
        idPrefix: "fancytree-Cb1-"
    });

    $("#arbolActividadesBusq").fancytree("getRootNode").visit(function(node) {
        node.setExpanded(true);
    });
}