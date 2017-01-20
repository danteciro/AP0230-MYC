/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business.impl;

import gob.osinergmin.myc.common.util.MycUtil;
import gob.osinergmin.myc.domain.PghTipificacionSancion;
import gob.osinergmin.myc.domain.dto.CriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleCriterioDTO;
import gob.osinergmin.myc.domain.dto.DetalleDocumentoCriterioDTO;
import gob.osinergmin.myc.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.dto.ObliTipiDTO;
import gob.osinergmin.myc.domain.dto.ObligacionNormativaDTO;
import gob.osinergmin.myc.domain.dto.SancionEspecificaDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.in.GuardarDocumentoAdjuntoInRO;
import gob.osinergmin.myc.domain.out.GuardarDocumentoAdjuntoOutRO;
import gob.osinergmin.myc.domain.ui.CriterioImplFilter;
import gob.osinergmin.myc.domain.ui.TipificacionSancionFilter;
import gob.osinergmin.myc.service.business.CriterioServiceNeg;
import gob.osinergmin.myc.service.business.DocumentoAdjuntoNeg;
import gob.osinergmin.myc.service.business.MaestroColumnaServiceNeg;
import gob.osinergmin.myc.service.business.TipificacionSancionServiceNeg;
import gob.osinergmin.myc.service.dao.CriterioDAO;
import gob.osinergmin.myc.service.dao.DetalleCriterioDAO;
import gob.osinergmin.myc.service.dao.DetalleDocumentoCriterioDAO;
import gob.osinergmin.myc.service.dao.DocumentoAdjuntoDAO;
import gob.osinergmin.myc.service.dao.MaestroColumnaDAO;
import gob.osinergmin.myc.service.dao.ObliTipiCriterioDAO;
import gob.osinergmin.myc.service.dao.TipificacionSancionDAO;
import gob.osinergmin.myc.util.Constantes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lbarboza
 */
@Service("CriterioServiceNegImpl")
public class CriterioServiceNegImpl implements CriterioServiceNeg {

    private static final Logger LOG = LoggerFactory.getLogger(CriterioServiceNegImpl.class);
    @Inject
    private CriterioDAO criterioDAO;
    @Inject
    private DetalleCriterioDAO detalleCriterioDAO;
    @Inject
    private DetalleDocumentoCriterioDAO detalleDocumentoCriterioDAO;
    @Inject
    private DocumentoAdjuntoNeg documentoServiceNeg;
    @Inject
    private DocumentoAdjuntoDAO documentoAdjuntoDAO;
    @Inject
    private MaestroColumnaDAO maestroColumnaDAO;
    @Inject
    private TipificacionSancionDAO tipificacionSancionDAO;
    @Inject
    private ObliTipiCriterioDAO obliTipiCriterioDAO;
    @Inject
    private MaestroColumnaServiceNeg maestroColumnaServiceNeg;
    @Inject
    private TipificacionSancionServiceNeg tipificacionSancionServiceNeg;

    @Override
    @Transactional
    public CriterioDTO guardaCriterio(CriterioDTO criterioDTO, List<DetalleCriterioDTO> listaDetalleCriterio,List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio, UsuarioDTO usuarioDTO) {
        LOG.info("Registro Criterio CriterioServiceNeg");
        CriterioDTO criterio = null;
        try {
            criterio = criterioDAO.create(criterioDTO, usuarioDTO);
            LOG.info("criterio creado = "+criterio.getIdCriterio());
            for (DetalleCriterioDTO detalleCriterioDTO : listaDetalleCriterio) {
                detalleCriterioDTO.setIdCriterio(criterio.getIdCriterio());
                detalleCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                detalleCriterioDTO.setCodTrazabilidad(criterioDTO.getCodTrazabilidad());
                detalleCriterioDAO.create(detalleCriterioDTO, usuarioDTO);
            }
            for (DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO : listaDetalleDocumentoCriterio) {
                
                DocumentoAdjuntoDTO documentoAdjunto = detalleDocumentoCriterioDTO.getDocumento();
                
                detalleDocumentoCriterioDTO.setIdCriterio(criterio.getIdCriterio());
                detalleDocumentoCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                detalleDocumentoCriterioDTO.setCodTrazabilidad(criterioDTO.getCodTrazabilidad());
                detalleDocumentoCriterioDTO = detalleDocumentoCriterioDAO.create(detalleDocumentoCriterioDTO, usuarioDTO);

                System.out.println("-- documentoAdjunto.getNombreArchivo() = "+documentoAdjunto.getNombreArchivo());
                int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                String rutaAlfrescoBD = criterioDTO.getIdObligacion() + "_" + criterio.getIdCriterio() + "_" + detalleDocumentoCriterioDTO.getIdDetalleDocumentoCriterio() + "_IMG" + formato;
                System.out.println("-- rutaAlfrescoBD = "+rutaAlfrescoBD);
                File someFile = new File(rutaAlfrescoBD);
                FileOutputStream fos = new FileOutputStream(someFile);
                fos.write(documentoAdjunto.getRutaAlfrescoTmp());
                fos.flush();
                fos.close();
                
                System.out.println("-- Guardando alfresco inicio");
                GuardarDocumentoAdjuntoOutRO outFileAlfresco  = documentoServiceNeg.enviarDatosAlfresco(documentoAdjunto, someFile);
                System.out.println("-- Guardando alfresco fin");
                System.out.println("-- Resultado alfresco "+outFileAlfresco.getMensaje());
                if (outFileAlfresco != null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")) {
                    GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                    documentoAdjunto.setRutaAlfresco(rutaAlfrescoBD);
                    documentoAdjunto.setIdDocumentoAdjunto(null);
                    documentoAdjunto.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    inDoc.setDocumento(documentoAdjunto);
                    inDoc.setUsuario(usuarioDTO);

                    GuardarDocumentoAdjuntoOutRO saveDoc = documentoServiceNeg.registrarDocumentoAdjunto(inDoc);

                    detalleDocumentoCriterioDTO.setIdDocumentoAdjunto(saveDoc.getDocumento().getIdDocumentoAdjunto());
                    detalleDocumentoCriterioDAO.update(detalleDocumentoCriterioDTO, usuarioDTO);
                }
            }
            LOG.info("(Registro Criterio CriterioServiceNeg) registro: " + criterio.toString());
        } catch (Exception ex) {
            LOG.error("Error guardaCriterio : "+ ex.getMessage());
            ex.printStackTrace();
        }
        return criterio;
    }

    @Override
    @Transactional
    public CriterioDTO actualizarCriterio(CriterioDTO criterioDTO, UsuarioDTO usuarioDTO) {
        LOG.info("Actualizar Criterio CriterioServiceNeg");
        CriterioDTO criterio = null;
        try {
            criterio = criterioDAO.update(criterioDTO, usuarioDTO);
            LOG.info("(Registro Criterio CriterioServiceNeg) registro: " + criterio.toString());
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return criterio;
    }

    @Override
    @Transactional
    public CriterioDTO eliminarCriterio(CriterioDTO criterioDTO) {
        LOG.info("Eliminar Criterio CriterioServiceNeg");
        CriterioDTO eliminar = null;
        try {
            criterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            eliminar = criterioDAO.changeState(criterioDTO);
            detalleCriterioDAO.deleteAllDetalleCriterio(criterioDTO.getIdCriterio());
            LOG.info("(Eliminar Criterio CriterioServiceNeg) registro: " + eliminar.toString());
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return eliminar;
    }

//    @Override
//    @Transactional
//    public List<CriterioDTO> listarCriterio(CriterioFilter filtro, int[] cuenta) {
//        LOG.info("Funcion: Listar Criterio-- Service Impl -- Clase: listarCriterio");
//        List<CriterioDTO> listado = null;
//        try{
//            cuenta[0] = criterioDAO.count(filtro).intValue();
//            LOG.info("cuenta: "+cuenta[0]);
//            if(cuenta[0] > 0){
//                listado = criterioDAO.find(filtro);
//                LOG.info("Funcion: numero de registros en el listado: "+listado.size());
//            }
//        }catch(Exception ex){
//            LOG.error("",ex);
//        }
//        return listado;
//    }
    @Override
    @Transactional
    public List<CriterioDTO> listarCriterio(CriterioDTO criterio) {
        return criterioDAO.obtenerCriterios(criterio);
    }

    @Override
    @Transactional
    public List<DetalleCriterioDTO> listarSancionEspecificaCriterio(Long idCriterio) {
        return detalleCriterioDAO.listarSancionEspecificaCriterio(idCriterio);
    }
    @Override
    @Transactional
    public List<DetalleCriterioDTO> listarDetalleCriterio(Long idCriterio) {
        return detalleCriterioDAO.obtenerDetalleCriterio(idCriterio);
    }
    
    @Override
    @Transactional
    public List<DetalleDocumentoCriterioDTO> listarDetalleDocumentoCriterio(Long idCriterio) {
        List<DetalleDocumentoCriterioDTO> listaDetalleDocumentoCriterio = detalleDocumentoCriterioDAO.obtenerDetalleDocumentoCriterio(idCriterio);
        for (DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO : listaDetalleDocumentoCriterio) {
            if(detalleDocumentoCriterioDTO.getIdDocumentoAdjunto() != null){
                DocumentoAdjuntoDTO documentoAdjunto = documentoAdjuntoDAO.get(detalleDocumentoCriterioDTO.getIdDocumentoAdjunto());
                detalleDocumentoCriterioDTO.setDocumento(documentoAdjunto);
            }
        }
        return listaDetalleDocumentoCriterio;
    }

    @Override
    @Transactional
    public DetalleCriterioDTO guardaDetalleCriterio(DetalleCriterioDTO detalleCriterioDTO, UsuarioDTO usuarioDTO) {
        LOG.info("GuardaDetallCriterio Criterio CriterioServiceNeg");
        try {
            detalleCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            detalleCriterioDTO = detalleCriterioDAO.create(detalleCriterioDTO, usuarioDTO);
            LOG.info("(Registro Criterio CriterioServiceNeg) registro: " + detalleCriterioDTO.toString());
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return detalleCriterioDTO;
    }
    
    @Override
    @Transactional
    public DetalleDocumentoCriterioDTO guardaDetalleDocumentoCriterio(DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO, UsuarioDTO usuarioDTO) {
        LOG.info("GuardaDetalleDocumentoCriterio Criterio CriterioServiceNeg");
        try {
            detalleDocumentoCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            
                DocumentoAdjuntoDTO documentoAdjunto = detalleDocumentoCriterioDTO.getDocumento();
                detalleDocumentoCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                detalleDocumentoCriterioDTO = detalleDocumentoCriterioDAO.create(detalleDocumentoCriterioDTO, usuarioDTO);

                CriterioDTO criterioDTO = criterioDAO.obtenerCriterioById(detalleDocumentoCriterioDTO.getIdCriterio());
                System.out.println("-- documentoAdjunto.getNombreArchivo() = "+documentoAdjunto.getNombreArchivo());
                int lastIndexOf = documentoAdjunto.getNombreArchivo().lastIndexOf(".");
                String formato = documentoAdjunto.getNombreArchivo().substring(lastIndexOf);
                String rutaAlfrescoBD = criterioDTO.getIdObligacion() + "_" + criterioDTO.getIdCriterio() + "_" + detalleDocumentoCriterioDTO.getIdDetalleDocumentoCriterio() + "_IMG" + formato;
                System.out.println("-- rutaAlfrescoBD = "+rutaAlfrescoBD);
                File someFile = new File(rutaAlfrescoBD);
                FileOutputStream fos = new FileOutputStream(someFile);
                fos.write(documentoAdjunto.getRutaAlfrescoTmp());
                fos.flush();
                fos.close();

                GuardarDocumentoAdjuntoOutRO outFileAlfresco  = documentoServiceNeg.enviarDatosAlfresco(documentoAdjunto, someFile);
                if (outFileAlfresco != null && outFileAlfresco.getMensaje().equalsIgnoreCase("ok")) {
                    GuardarDocumentoAdjuntoInRO inDoc = new GuardarDocumentoAdjuntoInRO();
                    documentoAdjunto.setRutaAlfresco(rutaAlfrescoBD);
                    documentoAdjunto.setIdDocumentoAdjunto(null);
                    documentoAdjunto.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    inDoc.setDocumento(documentoAdjunto);
                    inDoc.setUsuario(usuarioDTO);

                    GuardarDocumentoAdjuntoOutRO saveDoc = documentoServiceNeg.registrarDocumentoAdjunto(inDoc);
                    detalleDocumentoCriterioDTO.setIdDocumentoAdjunto(saveDoc.getDocumento().getIdDocumentoAdjunto());
                    detalleDocumentoCriterioDAO.update(detalleDocumentoCriterioDTO, usuarioDTO);
                }
            
            LOG.info("(Registro Detalle Docuemtno Criterio CriterioServiceNeg) registro: " + detalleDocumentoCriterioDTO.toString());
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return detalleDocumentoCriterioDTO;
    }

    @Override
    @Transactional
    public DetalleCriterioDTO eliminarDetalleCriterio(DetalleCriterioDTO detalleCriterio) {
        LOG.info("Eliminar Detalle Criterio CriterioServiceNeg");
        DetalleCriterioDTO eliminar = null;
        try {
            DetalleCriterioDTO detalleCriterioDTO = detalleCriterioDAO.obtenerDetalleCriterioById(detalleCriterio.getIdDetalleCriterio());
            detalleCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            detalleCriterioDTO.setCodTrazabilidad(detalleCriterio.getCodTrazabilidad());
            eliminar = detalleCriterioDAO.changeState(detalleCriterioDTO);
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return eliminar;
    }
    
    @Override
    @Transactional
    public DetalleDocumentoCriterioDTO eliminarDetalleDocumentoCriterio(Long idDetalleDocumentoCriterio, UsuarioDTO usuarioDTO) {
        LOG.info("Eliminar Detalle Documento Criterio CriterioServiceNeg");
        DetalleDocumentoCriterioDTO eliminar = null;
        try {
            DetalleDocumentoCriterioDTO detalleDocumentoCriterioDTO = detalleDocumentoCriterioDAO.obtenerDetalleDocumentoCriterioById(idDetalleDocumentoCriterio);
            detalleDocumentoCriterioDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
            eliminar = detalleDocumentoCriterioDAO.changeState(detalleDocumentoCriterioDTO);
            if(eliminar.getIdDocumentoAdjunto() != null){
                DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
                documentoAdjuntoDTO.setIdDocumentoAdjunto(eliminar.getIdDocumentoAdjunto());
                documentoAdjuntoDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                documentoAdjuntoDAO.changeState(documentoAdjuntoDTO,usuarioDTO);
            }
        } catch (Exception ex) {
            LOG.error("", ex);
        }
        return eliminar;
    }
    
    //Implementacion_Criterio
	@Override
	public List<CriterioDTO> listarCriterioImpl(CriterioImplFilter filtro,int[] cuenta) {
		LOG.info("Funcion: Listar Criterio -- Service Impl -- Clase: listarCriterioImpl");
        List<CriterioDTO> listado=null;
        List<CriterioDTO> listadoRetorno=null;
        try{
        	Long sanciones;
            cuenta[0] = criterioDAO.countImpl(filtro).intValue();
            LOG.info("cuenta: "+cuenta[0]);
            if (cuenta[0] > 0) {
                listado = criterioDAO.findImpl(filtro);
                LOG.info("Funcion: numero de registros en el listado: "+listado.size());
                listadoRetorno = new ArrayList<CriterioDTO>();
                for(CriterioDTO criterio : listado){
                	sanciones = criterioDAO.buscarSancionEspecifica(criterio.getIdCriterio());
                	LOG.info("# sanciones : -->  "+ sanciones);
					if(sanciones>0){
						criterio.setTieneSancion("1");
					}else{
						criterio.setTieneSancion("0");
					}
					listadoRetorno.add(criterio);
                }
                
            }
        }catch(Exception ex){
            LOG.error("",ex);
        }
        return listadoRetorno;
	}

	@Override
	public CriterioDTO guardaCriterio(CriterioDTO criterio,UsuarioDTO usuarioDTO) {
		LOG.info("-- Service guardar criterio -- ");
		CriterioDTO retorno = new CriterioDTO();
		try {
			retorno = criterioDAO.create(criterio, usuarioDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return retorno;
	}
	
	@Override
	@Transactional
	public CriterioDTO guardaCriterioMaestro(CriterioDTO criterio,UsuarioDTO usuarioDTO, Long idTipificacion, String[] listaSanciones) {
		LOG.info("-- Service guardar criterio -- ");
		CriterioDTO criterioRetorno = new CriterioDTO();
// 05-11-2015		
		Long idObligacion = criterio.getIdObligacion();
		LOG.info("ID Obligacion ===>>>> "+idObligacion);
// 		
		try {
			criterioRetorno = criterioDAO.create(criterio, usuarioDTO);
			LOG.info("Id Tipificacion : "+idTipificacion);  
        	LOG.info("Id Criterio : "+criterioRetorno.getIdCriterio());
//        	if(idTipificacion!=null){
//        		ObliTipiDTO obliCriteTipi = new ObliTipiDTO();   
//        		CriterioDTO criti = new CriterioDTO();
//        		criti.setIdCriterio(criterioRetorno.getIdCriterio());
//        		obliCriteTipi.setCriterio(criti);   
//        		TipificacionDTO tipi = new TipificacionDTO();
//        		tipi.setIdTipificacion(idTipificacion);        		
//        		obliCriteTipi.setTipificacion(tipi);
//        		obliCriteTipi.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
//        		obliCriteTipi = obliTipiCriterioDAO.crear(obliCriteTipi,usuarioDTO);
//        	}
        	if(!listaSanciones.equals("") && listaSanciones!=null){
        		for (String sancion : listaSanciones) {
                    TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO();  
                    CriterioDTO crite = new CriterioDTO();
                    crite.setIdCriterio(criterioRetorno.getIdCriterio());
                    tipificacionSancionDTO.setCriterio(crite);
                    tipificacionSancionDTO.setIdTipificacion(new Long(idTipificacion));                    
                    tipificacionSancionDTO.setIdTipoSancion(new Long(sancion));
                    tipificacionSancionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    String aplicacion = Constantes.APPLICACION_MYC;
                    List<MaestroColumnaDTO> nivelMaestro = maestroColumnaDAO.findMaestroColumna(Constantes.DOMINIO_NIVEL_CRITERIO, aplicacion);                    
                    Long idNivelTipificacion = nivelMaestro.get(0).getIdMaestroColumna();
                    MaestroColumnaDTO maestroNivel = new MaestroColumnaDTO();
                    maestroNivel.setIdMaestroColumna(idNivelTipificacion);
                    tipificacionSancionDTO.setNivel(maestroNivel);
                    tipificacionSancionDTO = tipificacionSancionDAO.create(tipificacionSancionDTO, usuarioDTO);
                }
        	}
// 05-11-2015       	
        	ObliTipiDTO relacion = new ObliTipiDTO();
        	ObligacionNormativaDTO obligacion = new  ObligacionNormativaDTO();
        	obligacion.setIdObligacion(idObligacion);
        	relacion.setObligacion(obligacion);
        	CriterioDTO criter = new CriterioDTO();
        	criter.setIdCriterio(criterioRetorno.getIdCriterio());
        	relacion.setCriterio(criter);
        	relacion.setIdActividad(criterio.getIdActividad());
        	TipificacionDTO tipif = new TipificacionDTO();
        	tipif.setIdTipificacion(idTipificacion);
        	relacion.setTipificacion(tipif);
        	relacion.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
        	relacion.setCodTrazabilidad(criterio.getCodTrazabilidad());
        	relacion = obliTipiCriterioDAO.crearRelacion(relacion, usuarioDTO);
//
        	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return criterioRetorno;
	}
    @Override
    @Transactional
    public CriterioDTO editarCriterioMaestro(CriterioDTO criterio,UsuarioDTO usuarioDTO, Long idTipificacion, String[] listaSanciones) {
        LOG.info("-- Service editar criterio -- ");
        CriterioDTO criterioRetorno = new CriterioDTO();
        try {
            criterioRetorno = criterioDAO.update(criterio, usuarioDTO);
            LOG.info("Id Tipificacion : "+idTipificacion);  
            LOG.info("Id Criterio : "+criterioRetorno.getIdCriterio());
            CriterioDTO criti = new CriterioDTO();
            criti.setIdCriterio(criterioRetorno.getIdCriterio());
            TipificacionDTO tipi = new TipificacionDTO();
            tipi.setIdTipificacion(idTipificacion);   
            //acttualiza tipificacion gvillanueva
            if(idTipificacion!=null){
            	
                ObliTipiDTO obliCritetipiAntiguo = new ObliTipiDTO();
                obliCritetipiAntiguo.setCriterio(criti);
                obliCritetipiAntiguo.setTipificacion(tipi);                
                
                obliCritetipiAntiguo = obliTipiCriterioDAO.findObliTipiCriterio(obliCritetipiAntiguo);
                LOG.info("Tipificacion antigua --> "+obliCritetipiAntiguo.getTipificacion().getIdTipificacion());
                LOG.info("Tipificacion nueva -->"+idTipificacion);
                if(obliCritetipiAntiguo.getTipificacion().getIdTipificacion()!=idTipificacion){
                    obliCritetipiAntiguo = obliTipiCriterioDAO.update(obliCritetipiAntiguo,usuarioDTO);
                    TipificacionSancionFilter filtro= new TipificacionSancionFilter();
                    filtro.setIdCriterio(criterio.getIdCriterio());
                    List<MaestroColumnaDTO> nivelMaestro = maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_NIVEL_CRITERIO);            
                    Long idNivelTipificacion = nivelMaestro.get(0).getIdMaestroColumna();
                    filtro.setNivel(idNivelTipificacion);
                    filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    int[] cuenta=null;
                    List<TipificacionSancionDTO> listaAct = tipificacionSancionServiceNeg.findTipificacionSancionCriterio(filtro, cuenta);
                    String txtTipoSancAct=MycUtil.concatenaTipificacionSancion(listaAct);
                    LOG.info("ActXDDDD---->"+txtTipoSancAct);
                    
                    for(TipificacionSancionDTO regAct: listaAct){
                            LOG.info("Eliminado logicooooo TipiSancion-->"+regAct.getIdTipoSancion());
                            LOG.info("regAct a eliminarrrrrr="+regAct.getIdTipiSanc());
                            TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO(); 
//                		tipificacionSancionDTO.setCriterio(criti);
//                            tipificacionSancionDTO.setIdTipificacion(idTipificacion);                    
//                            tipificacionSancionDTO.setIdTipoSancion(regAct.getIdTipoSancion());                    
                            tipificacionSancionDTO = tipificacionSancionDAO.buscarTipificacionSancionCompleta(regAct.getIdTipiSanc());
                            LOG.info("regAct encontrado a eliminarrrrrr="+tipificacionSancionDTO.getIdTipiSanc());
                            
                            tipificacionSancionDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                            tipificacionSancionDTO = tipificacionSancionDAO.cambioEstado(tipificacionSancionDTO, usuarioDTO);                        
                    }
                    
                    ObliTipiDTO obliCriteTipi = new ObliTipiDTO();  
                    obliCriteTipi.setCriterio(criti);   
                    obliCriteTipi.setTipificacion(tipi);
                    obliCriteTipi.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                    obliCriteTipi = obliTipiCriterioDAO.crear(obliCriteTipi,usuarioDTO);
                }
                		
                
            }
            ///////////////////////
            //actualiza tipoSancion
                //acomodando los nuevos
            List<TipificacionSancionDTO> listaUpd=new ArrayList<TipificacionSancionDTO>(); 
            if(listaSanciones!=null){
                for (String sancion : listaSanciones) {
                    TipificacionSancionDTO reg=new TipificacionSancionDTO();
                    reg.setIdTipoSancion(new Long(sancion));
                    listaUpd.add(reg);
                }
            }
            	//buscar los de BD
            TipificacionSancionFilter filtro= new TipificacionSancionFilter();
            filtro.setIdCriterio(criterio.getIdCriterio());
            List<MaestroColumnaDTO> nivelMaestro = maestroColumnaServiceNeg.buscarMycByDominio(Constantes.DOMINIO_NIVEL_CRITERIO);            
            Long idNivelTipificacion = nivelMaestro.get(0).getIdMaestroColumna();
            filtro.setNivel(idNivelTipificacion);
            filtro.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
            int[] cuenta=null;
            List<TipificacionSancionDTO> listaAct = tipificacionSancionServiceNeg.findTipificacionSancionCriterio(filtro, cuenta);

            String txtTipoSancAct=MycUtil.concatenaTipificacionSancion(listaAct);
            LOG.info("ActXD---->"+txtTipoSancAct);
            String txtTipoSancUpd=MycUtil.concatenaTipificacionSancion(listaUpd);
            LOG.info("UpdXD---->"+txtTipoSancUpd);
        	
            if(!txtTipoSancAct.equals(txtTipoSancUpd)){
                LOG.info("Se modifico TipiSanciones");
                if(listaUpd!=null){
                    for(TipificacionSancionDTO regUpd: listaUpd){
                        boolean existe=MycUtil.existeIdSancionEnLista(regUpd.getIdTipoSancion(),listaAct);
                        if(!existe){
                            LOG.info("creo registro-"+regUpd.getIdTipoSancion());
                            TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO();                      
                            tipificacionSancionDTO.setCriterio(criti);
                            tipificacionSancionDTO.setIdTipificacion(idTipificacion);                    
                            tipificacionSancionDTO.setIdTipoSancion(regUpd.getIdTipoSancion());
                            tipificacionSancionDTO.setEstado(Constantes.CONSTANTE_ESTADO_ACTIVO);
                            MaestroColumnaDTO maestroNivel = new MaestroColumnaDTO();
                            maestroNivel.setIdMaestroColumna(idNivelTipificacion);
                            tipificacionSancionDTO.setNivel(maestroNivel);
                            tipificacionSancionDTO = tipificacionSancionDAO.create(tipificacionSancionDTO, usuarioDTO);
                        }
                    }
                }
                for(TipificacionSancionDTO regAct: listaAct){
                    boolean existe=MycUtil.existeIdSancionEnLista(regAct.getIdTipoSancion(),listaUpd);
                    if(!existe){
                        LOG.info("Eliminado logico TipiSancion-->"+regAct.getIdTipoSancion());
                        LOG.info("regAct a eliminar="+regAct.getIdTipiSanc());
            		TipificacionSancionDTO tipificacionSancionDTO = new TipificacionSancionDTO(); 
//            		tipificacionSancionDTO.setCriterio(criti);
//                        tipificacionSancionDTO.setIdTipificacion(idTipificacion);                    
//                        tipificacionSancionDTO.setIdTipoSancion(regAct.getIdTipoSancion());                    
                        //tipificacionSancionDTO = tipificacionSancionDAO.buscarTipificacionSancionCompleta(tipificacionSancionDTO);
                        tipificacionSancionDTO = tipificacionSancionDAO.buscarTipificacionSancionCompleta(regAct.getIdTipiSanc());
                        LOG.info("regAct encontrado a eliminar="+tipificacionSancionDTO.getIdTipiSanc());
                        
                        tipificacionSancionDTO.setEstado(Constantes.CONSTANTE_ESTADO_INACTIVO);
                        tipificacionSancionDTO = tipificacionSancionDAO.cambioEstado(tipificacionSancionDTO, usuarioDTO);
                    }
                }
            }
            
        } catch (Exception e) {
            LOG.error("error editarCriterioMaestro",e);
        }		
        return criterioRetorno;
    }

	@Override
	public CriterioDTO obtenerCriterio(Long idCriterio) {
		return criterioDAO.obtenerCriterioById(idCriterio);
	}

	/**
	 * @author l_garcia
	 */
	
	@Override
	public CriterioDTO eliminarCriterio(CriterioDTO criterioDTO,UsuarioDTO usuarioDTO) {
		CriterioDTO registro=null;
		ObliTipiDTO dependencia=null;
		try{
			registro=criterioDAO.changeEstado(criterioDTO,usuarioDTO);
			LOG.info("(Eliminar Criterio ServiceNegImpl) registro: "+registro.toString());
			
			int contador=obliTipiCriterioDAO.findByCriterio(criterioDTO).intValue();
			if(contador>0){
				dependencia=obliTipiCriterioDAO.changeEstadoRelacion(criterioDTO,usuarioDTO);
			}
			LOG.info("contador"+contador);
			
		}catch(Exception ex){
			LOG.error("",ex);
		}
        return registro;
	}
	
}