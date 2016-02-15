package gob.osinergmin.myc.service.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.myc.domain.base.BaseConstantesOutBean;
import gob.osinergmin.myc.domain.dto.ParametroDinamicoDTO;
import gob.osinergmin.myc.domain.dto.ValorParametroDTO;
import gob.osinergmin.myc.domain.in.GuardarParametroDinamicoInRO;
import gob.osinergmin.myc.domain.in.GuardarValorParametroInRO;
import gob.osinergmin.myc.domain.out.GuardarParametroDinamicoOutRO;
import gob.osinergmin.myc.domain.out.GuardarValorParametroOutRO;
import gob.osinergmin.myc.domain.ui.ValorParametroFilter;
import gob.osinergmin.myc.service.business.ValorParametroServiceNeg;
import gob.osinergmin.myc.service.dao.ParametroDinamicoDAO;
import gob.osinergmin.myc.service.dao.ValorParametroDAO;

@Service
public class ValorParametroServiceNegImpl  implements ValorParametroServiceNeg{
	 private static final Logger LOG = LoggerFactory.getLogger(ValorParametroServiceNegImpl.class);
	    
	 @Inject
	 private ValorParametroDAO valorParametroDAO;	
	
	 
	@Override
    @Transactional
	public GuardarValorParametroOutRO guardarValorParametro(GuardarValorParametroInRO in) {
		GuardarValorParametroOutRO retorno = new GuardarValorParametroOutRO();
		try{
		
			ValorParametroDTO registro=valorParametroDAO.createValor(in.getValorParametro(), in.getUsuario());
			retorno.setValorParametro(registro);
			retorno.setMensaje("ok");
			retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
			
		}catch(Exception ex){
			LOG.error("error guardarValorParametro", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
		}
		
		return retorno;
	}
	
	
	@Override
    public List<ValorParametroDTO> listarValorParametro(ValorParametroFilter filtro, int[] cuenta){
        List<ValorParametroDTO> retorno=null;
        try{
            
            //TEMPORAL data de prueba
            retorno= new ArrayList<ValorParametroDTO>();
            ValorParametroDTO fila;
            
            Map<Long,List<String[]>> data=new HashMap<Long,List<String[]>>();
            
            List<String[]> reg=new ArrayList<String[]>();
            
	       	 cuenta[0] = valorParametroDAO.countValor(filtro).intValue();
	         if (cuenta[0] > 0) {
	             retorno = valorParametroDAO.findValorParametro(filtro);
	             LOG.info("cuenta -size: "+retorno.size());
	         }
            
            
            /*
            reg.add(new String[]{"1","PRIMERA","Hace referencia al momento de la solicitud","","0"});
            reg.add(new String[]{"2","SEGUNDA","Referencia a la totalidad de la entrega del requisito","","0"});
            data.put(new Long(1), reg);
            reg=new ArrayList<String[]>();
            reg.add(new String[]{"1","RURAL","Hace referencia al momento de la solicitud","","0"});
            reg.add(new String[]{"2","URBANA","Referencia a la totalidad de la entrega del requisito","","0"});
            data.put(new Long(2), reg);
            reg=new ArrayList<String[]>();
            reg.add(new String[]{"1","NATURAL Y JURIDICA","Hace referencia al momento de la solicitud","","1"});
            reg.add(new String[]{"2","NATURAL","Referencia a la totalidad de la entrega del requisito","","0"});
            reg.add(new String[]{"3","JURIDICA","Referencia a la totalidad de la entrega del requisito","","0"});
            data.put(new Long(3), reg);
            reg=new ArrayList<String[]>();
            reg.add(new String[]{"1","MEDIO FISICO","Medio Fisico","","1"});
            reg.add(new String[]{"2","MEDIO MAGNETICO","Medio Magnetico","","0"});
            reg.add(new String[]{"3","MEDIO FISICO Y MAGNETICO","Medio Fisico y Medio Magnetico","","0"});
            data.put(new Long(4), reg);
            reg=new ArrayList<String[]>();
            reg.add(new String[]{"1","SI","Previamente Aprobado","","0"});
            reg.add(new String[]{"2","NO","Si aprobacion previa","","0"});
            data.put(new Long(5), reg);
            reg=new ArrayList<String[]>();
            reg.add(new String[]{"1","SI","Si es alterno","","0"});
            reg.add(new String[]{"2","NO","No es alterno","","1"});
            data.put(new Long(6), reg);
            
            List<String[]> xx=data.get(filtro.getIdValorParametro());
            for (Iterator<String[]> it = xx.iterator(); it.hasNext();) {
                String[] str = it.next();
                fila=new ValorParametroDTO();
                fila.setIdValorParametro(new Long(str[0]));
                fila.setValor(str[1]);
                fila.setDescripcion(str[2]);
                fila.setComentario(str[3]);
                fila.setValorDefecto(str[4]);
                retorno.add(fila);
            } */
        
           
        }catch(Exception e){
            LOG.error(e.getMessage());
        }
        return retorno;
    }
	
	@Override
	@Transactional
	public GuardarValorParametroOutRO editarValorParametro(
			GuardarValorParametroInRO in) {
		GuardarValorParametroOutRO retorno = new GuardarValorParametroOutRO();
		try{
		
			ValorParametroDTO registro= valorParametroDAO.editar(in.getValorParametro(), in.getUsuario());
			retorno.setValorParametro(registro);
			retorno.setMensaje("ok");
			retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
			
		}catch(Exception ex){
			LOG.error("error editarValorParametro", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
		}
		
		return retorno;
	}
	
	@Override
	@Transactional
	public GuardarValorParametroOutRO eliminarValorParametro(
			GuardarValorParametroInRO in) {
		GuardarValorParametroOutRO retorno = new GuardarValorParametroOutRO();
		try{
		
			ValorParametroDTO registro= valorParametroDAO.changeEstado(in.getValorParametro(), in.getUsuario());
			retorno.setValorParametro(registro);
			retorno.setMensaje("ok");
			retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
			
		}catch(Exception ex){
			LOG.error("error eliminarValorParametro", ex);
            retorno.setMensaje("error");
            retorno.setCodigoResultado(BaseConstantesOutBean.ERROR);  
		}
		
		return retorno;
	}


	@Override
	public List<ValorParametroDTO> obtenerDependencias(ValorParametroFilter filtro) {
		GuardarValorParametroOutRO retorno=new GuardarValorParametroOutRO();
    	List<ValorParametroDTO> listado=null;
        try{
            listado = valorParametroDAO.obtenerDependencias(filtro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("",ex.getMessage());
            
        }
        return listado;
	}
	
	
	@Override
	public List<ValorParametroDTO> verificarOtrosValoresParametros(ValorParametroFilter filtro) {
		GuardarValorParametroOutRO retorno=new GuardarValorParametroOutRO();
    	List<ValorParametroDTO> listado=null;
        try{
            listado = valorParametroDAO.verificarOtrosValoresParametros(filtro);
            retorno.setMensaje("ok");
            retorno.setCodigoResultado(BaseConstantesOutBean.SUCCESS);
        }catch(Exception ex){
            LOG.error("",ex.getMessage());
            
        }
        return listado;
	}


}
