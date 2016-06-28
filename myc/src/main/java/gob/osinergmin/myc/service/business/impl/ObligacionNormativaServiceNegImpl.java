package gob.osinergmin.myc.service.business.impl;

import org.springframework.stereotype.Service;

import gob.osinergmin.myc.domain.dto.CnfObligacionDTO;
import gob.osinergmin.myc.domain.dto.DetalleObligacionDTO;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.InfraccionDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObligacionBaseLegalDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.OpcionDTO;
import gob.osinergmin.myc.domain.dto.RubroOpcionDTO;
import gob.osinergmin.myc.domain.dto.TemaDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.domain.ui.ObligacionFilter;
import gob.osinergmin.myc.service.business.DocumentoAdjuntoNeg;
import gob.osinergmin.myc.service.business.ObligacionNormativaServiceNeg;
import gob.osinergmin.myc.service.dao.DetalleObligacionDAO;
import gob.osinergmin.myc.service.dao.DocumentoAdjuntoDAO;
import gob.osinergmin.myc.service.dao.ObligacionBaseLegalDAO;
import gob.osinergmin.myc.service.dao.ObligacionNormativaDAO;
import gob.osinergmin.myc.service.exception.ObligacionException;
import gob.osinergmin.myc.util.Constantes;
import java.io.File;
import java.io.FileOutputStream;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("OblNormativaServiceNegImpl")
public class ObligacionNormativaServiceNegImpl implements ObligacionNormativaServiceNeg{
	private static final Logger LOG = LoggerFactory.getLogger(ObligacionNormativaServiceNegImpl.class);
	
	@Inject
	private ObligacionNormativaDAO obligacionNormativaDAO;
	
	@Inject 
	private ObligacionBaseLegalDAO obligacionBaseLegalDAO;
	
        @Inject
        private DocumentoAdjuntoDAO documentoAdjuntoDAO;
        
        @Inject
        private DocumentoAdjuntoNeg documentoServiceNeg;
    @Inject 
    private DetalleObligacionDAO detalleObligacionDAO;
        
	@Override
	@Transactional
	public ObligacionNormativaDTO eliminarObligacion(ObligacionNormativaDTO obligacionNormativaDTO,UsuarioDTO usuarioDTO){
		ObligacionNormativaDTO registro=null;
		ObligacionBaseLegalDTO dependencia=null;
		
		registro=obligacionNormativaDAO.changeEstado(obligacionNormativaDTO);
		LOG.info("(Eliminar Obligacion ServiceNegImpl) registro: "+registro.toString());
		int contador=obligacionBaseLegalDAO.findByObligacion(obligacionNormativaDTO).intValue();
		if(contador>0){
			dependencia=obligacionBaseLegalDAO.changeEstadoRelacion(obligacionNormativaDTO,usuarioDTO);
		}
		LOG.info("contador"+contador);
        return registro;
	}
	
	@Override
	@Transactional
	public ObligacionNormativaDTO guardaObligacion(ObligacionNormativaDTO obligacionNormativaDTO,UsuarioDTO usuarioDTO){
            LOG.info("Registro Obligacion Normativa ServiceNegImpl");
            ObligacionNormativaDTO registro=null;
            ObligacionBaseLegalDTO registroObligacionBaseLegal = null;
            DetalleObligacionDTO detalle = new DetalleObligacionDTO();
// 05-11-2015     
            ObligacionBaseLegalDTO relacion = new ObligacionBaseLegalDTO();
//            
            try {
                DocumentoAdjuntoDTO documentoAdjunto = obligacionNormativaDTO.getDocumentoAdjunto();
// 05-11-2015
                Long idBaseLegal = obligacionNormativaDTO.getIdBaseLegal();
//
                registro=obligacionNormativaDAO.create(obligacionNormativaDTO,usuarioDTO);
                //Insertar Detalle Obligacion
                detalle.setIdObligacion(registro.getIdObligacion());
				detalle.setCodTrazabilidad(registro.getCodTrazabilidad());
				detalle.setDescripcion(registro.getDescripcionObligacion());
				detalle.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
				detalle = detalleObligacionDAO.create(detalle, usuarioDTO);
				//Setear Id Detalle al objeto de retorno
				registro.setIdDetalleObligacion(detalle.getIdDetalleObligacion());
// 05-11-2015				
				//insertar relacion con baselegal
				relacion.setIdBaseLegal(idBaseLegal);
				relacion.setIdObligacion(registro.getIdObligacion());
				relacion.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
				relacion = obligacionBaseLegalDAO.creaRelacionOblBl(relacion, usuarioDTO);
//				
				//en caso exista documento adjunto
                if(documentoAdjunto != null){
                    int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                    String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                    String rutaAlfrescoBD = registro.getIdObligacion() + "_IMG"+ formato;
                    System.out.println("-- rutaAlfrescoBD = "+rutaAlfrescoBD);
                    File someFile = new File(rutaAlfrescoBD);
                    FileOutputStream fos = new FileOutputStream(someFile);
                    fos.write(documentoAdjunto.getRutaAlfrescoTmp());
                    fos.flush();
                    fos.close();
                    documentoAdjunto.setAplicacionSpace(Constantes.APPLICACION_SPACE_OBLIGACIONES);//setear space 08/06/2015
                    GuardarDocumentoAdjuntoOutRO outFileAlfresco  = documentoServiceNeg.enviarDatosAlfresco(documentoAdjunto, someFile);
                    if (outFileAlfresco != null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")) {
                        GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                        documentoAdjunto.setRutaAlfresco(rutaAlfrescoBD);
                        documentoAdjunto.setIdDocumentoAdjunto(null);
                        documentoAdjunto.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                        inDoc.setDocumento(documentoAdjunto);
                        inDoc.setUsuario(usuarioDTO);

                        GuardarDocumentoAdjuntoOutRO saveDoc = documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                        DocumentoAdjuntoDTO documentoAdjuntoCreado = saveDoc.getDocumento();
                        registro.setIdDocumentoAdjunto(documentoAdjuntoCreado.getIdDocumentoAdjunto());
                        obligacionNormativaDAO.update(registro, usuarioDTO);
                        
                    }
                }
                
                //grabando las concordancia
                for (int i = 0; i < obligacionNormativaDTO.getListaBasesLegales().size(); i++) {
              	  registroObligacionBaseLegal = new ObligacionBaseLegalDTO();
              	  registroObligacionBaseLegal.setIdBaseLegal(obligacionNormativaDTO.getListaBasesLegales().get(i).getIdBaseLegalDestino());
              	  registroObligacionBaseLegal.setIdObligacion(registro.getIdObligacion());
              	  registroObligacionBaseLegal.setEstado("1");
              	  registroObligacionBaseLegal.setCodTrazabilidad(obligacionNormativaDTO.getCodTrazabilidad());
              	  registroObligacionBaseLegal = obligacionBaseLegalDAO.create(registroObligacionBaseLegal, usuarioDTO);
                }
		LOG.info("(Registro Obligacion Normativa ServiceNegImpl) registro: "+registro.toString());
            } catch (Exception ex) {
                LOG.error("", ex);
            }
            
            return registro;
	}
	
	@Override
	public List<ObligacionNormativaDTO> listarObligacion(ObligacionFilter filtro, int[] cuenta){
		LOG.info("Funcion: Listar Obligacion-- Service Impl -- Clase: listarObligacion");
        List<ObligacionNormativaDTO> listado=null;
        cuenta[0] = obligacionNormativaDAO.count(filtro).intValue();
		LOG.info("cuenta: "+cuenta[0]);
		if (cuenta[0] > 0) {
		    listado = obligacionNormativaDAO.find(filtro);
		    LOG.info("Funcion: numero de registros en el listado: "+listado.size());
		}
        return listado;
	}

	@Override
	public ObligacionNormativaDTO findUltimoRegistro() {
		ObligacionNormativaDTO registro=null;
//		registro=obligacionNormativaDAO.findUltimoRegistro();
		return registro;
	}

	@Override
	public List<MaestroColumnaDTO> listarTemas(int[] cuenta) {
		LOG.info("Neg listarTemas");
        List<MaestroColumnaDTO> retorno=null;
        retorno = obligacionNormativaDAO.findTemas();
		LOG.info("cuenta -size: "+retorno.size());
        return retorno;
	}

	@Override
	public ObligacionNormativaDTO registrarRelaciones(Long idObligacion,Long idCriticidad, String listTema,UsuarioDTO usuarioDTO) {
		ObligacionNormativaDTO retorno=null;
		retorno = obligacionNormativaDAO.registrarRelaciones(idObligacion,idCriticidad,listTema,usuarioDTO);
		LOG.info("cuenta -size: "+retorno);
		return retorno;
	}

	@Override
	public CnfObligacionDTO registrarConfiguracion(Long idObligacion,Long idRubro, Long idProceso, String oblgTipo,String codTrazabilidad, UsuarioDTO usuarioDTO) throws ObligacionException {
		CnfObligacionDTO retorno=null;
		try {
			retorno = obligacionNormativaDAO.registrarConfiguracion(idObligacion,idRubro,idProceso,oblgTipo,codTrazabilidad,usuarioDTO);
			LOG.info("cuenta -size: "+retorno);
			
		} catch (ObligacionException ex) {
			ex.printStackTrace();
            LOG.error("Error en Registrar Configuracion:"+ex.getMessage());
            throw new ObligacionException(ex.getMessage(),null);
		}
		
		return retorno;
	}
	/*PR OSINE_119 - Item 16 - Inicio*/
	
	@Override
	public List<OpcionDTO> obtenerOpciones(String idRubro) {
		List<OpcionDTO> retorno=null;
		retorno = obligacionNormativaDAO.obtenerOpciones(idRubro);
		LOG.info("cuenta -size: "+retorno);
		
		return retorno;
	}
	
	/*PR OSINE_119 - Item 16 - Inicio*/
	@Override
	public List<CnfObligacionDTO> findObligacionById(ObligacionFilter filtro, int[] auxiliar) {
		LOG.info("(Encontrar Obligacion By Id Service Neg Impl)Ingresando...");
		List<CnfObligacionDTO> registro=null;
		auxiliar[0] = obligacionNormativaDAO.contador(filtro).intValue();
		LOG.info("auxiliar: "+auxiliar[0]);
		if (auxiliar[0] > 0) {
			registro=obligacionNormativaDAO.findObligacionById(filtro);
			LOG.info("Funcion: numero de registros en el listado: "+registro.size());
		}
		LOG.info("(Encontrar Obligacion By Id Service Neg Impl)Saliendo... :Registro: " + registro);
		return registro;
	}

	@Override
	public ObligacionNormativaDTO consultaObligacionById(Long idObligacion) {
		LOG.info("Funcion: Consultar Obligacion");
		ObligacionNormativaDTO retorno=null;
		retorno = obligacionNormativaDAO.consultaObligacionById(idObligacion);
		return retorno;
	}

	@Override
	public DetalleObligacionDTO consultaDetalleObligacionById(
			Long idObligacion) {
		LOG.info("Funcion: Consultar Detalle de la Obligacion");
		DetalleObligacionDTO retorno=null;
		retorno = obligacionNormativaDAO.consultaDetalleObligacionById(idObligacion);
		return retorno;
	}

	@Override
	public List<TemaDTO> consultaTemaByObligacionId(Long idObligacion) {
		LOG.info("Funcion: Consultar Temas de la Obligacion");
		List<TemaDTO> lista=null;
		lista=obligacionNormativaDAO.findTemaObligacion(idObligacion);
		return lista;
	}
	/*PR OSINE_119 - Item 14 - Inicio*/
	@Override
		public InfraccionDTO consultaInfraccionByObligacionId(Long idObligacion) {
		LOG.info("Funcion: Consultar Temas de la Obligacion");
		InfraccionDTO lista=null;
		lista=obligacionNormativaDAO.findInfraccionObligacion(idObligacion);
		return lista;
	}
	/*PR OSINE_119 - Item 14 - Fin*/
	@Override
	public ObligacionNormativaDTO registrarRelaciones(
			ObligacionNormativaDTO registro, UsuarioDTO usuarioDTO) {
		ObligacionNormativaDTO retorno=null;
		retorno = obligacionNormativaDAO.registrarRelaciones(registro,usuarioDTO);
		LOG.info("cuenta -size: "+retorno);
		return retorno;
	}

	@Override
	public ObligacionNormativaDTO eliminarRelaciones(
			ObligacionNormativaDTO registro, UsuarioDTO usuarioDTO) {
		ObligacionNormativaDTO retorno=null;
		retorno = obligacionNormativaDAO.eliminarRelaciones(registro,usuarioDTO);
		LOG.info("cuenta -size: "+retorno);
		return retorno;
	}

    @Override
    public ObligacionNormativaDTO updateObligacion(ObligacionNormativaDTO obligacionNormativaDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Actualiza Obligacion Normativa ServiceNegImpl");
        ObligacionNormativaDTO registro=null;
        try{
            DocumentoAdjuntoDTO documentoAdjunto = obligacionNormativaDTO.getDocumentoAdjunto();
            registro=obligacionNormativaDAO.update(obligacionNormativaDTO,usuarioDTO);

            if(documentoAdjunto != null){
                String rutaAlfrescoBD;
                if(registro.getIdDocumentoAdjunto() != null){
                    DocumentoAdjuntoDTO documentoAdjuntoActual = documentoAdjuntoDAO.get(registro.getIdDocumentoAdjunto());
                    rutaAlfrescoBD = documentoAdjuntoActual.getRutaAlfresco();
                }else{
                    int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                    String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                    rutaAlfrescoBD = registro.getIdObligacion() + "_IMG"+ formato;
                }
                System.out.println("-- rutaAlfrescoBD = "+rutaAlfrescoBD);
                File someFile = new File(rutaAlfrescoBD);
                FileOutputStream fos = new FileOutputStream(someFile);
                fos.write(documentoAdjunto.getRutaAlfrescoTmp());
                fos.flush();
                fos.close();
                documentoAdjunto.setAplicacionSpace(Constantes.APPLICACION_SPACE_OBLIGACIONES);//setear space 08/06/2015
                GuardarDocumentoAdjuntoOutRO outFileAlfresco  = documentoServiceNeg.enviarDatosAlfresco(documentoAdjunto, someFile);
                if (outFileAlfresco != null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")) {

                    if(registro.getIdDocumentoAdjunto() != null){
                        DocumentoAdjuntoDTO documentoAdjuntoActual = documentoAdjuntoDAO.get(registro.getIdDocumentoAdjunto());
                        documentoAdjuntoActual.setNombreArchivo(documentoAdjunto.getNombreArchivo());
                        GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                        inDoc.setDocumento(documentoAdjuntoActual);
                        inDoc.setUsuario(usuarioDTO);
                        documentoServiceNeg.editarDocumentoAdjunto(inDoc);
                    }else{
                        GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                        documentoAdjunto.setRutaAlfresco(rutaAlfrescoBD);
                        documentoAdjunto.setIdDocumentoAdjunto(null);
                        documentoAdjunto.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                        inDoc.setDocumento(documentoAdjunto);
                        inDoc.setUsuario(usuarioDTO);

                        GuardarDocumentoAdjuntoOutRO saveDoc = documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                        DocumentoAdjuntoDTO documentoAdjuntoCreado = saveDoc.getDocumento();
                        registro.setIdDocumentoAdjunto(documentoAdjuntoCreado.getIdDocumentoAdjunto());
                        obligacionNormativaDAO.update(registro, usuarioDTO);
                    }
                }
            }
            LOG.info("(Actualiza Obligacion Normativa ServiceNegImpl) registro: "+registro.toString());
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return registro;
    }
	
}
