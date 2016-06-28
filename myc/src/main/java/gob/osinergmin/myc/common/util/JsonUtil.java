package gob.osinergmin.myc.common.util;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    public static String convertirObjetoACadenaJson(Object objeto){
        Gson objetoGson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer("dd/MM/yyyy")).create();
        return objetoGson.toJson(objeto);
    }
    
    public static <T> T convertirCadenaJsonAObjeto(String cadena, Class<T> clase){
        //Gson objetoGson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer("dd/MM/yyyy")).create();
     Gson objetoGson=null;
     try {
//        cadena=new String(cadena.getBytes("ISO-8859-1"),"UTF-8");
        cadena=URLDecoder.decode(cadena, "UTF-8");
        GsonBuilder objetoGsonBuilder = new GsonBuilder();
        //         objetoGsonBuilder.setDateFormat("dd/MM/yyyy");
                objetoGsonBuilder.registerTypeAdapter(Date.class, new DateSerializer("dd/MM/yyyy"));
        //         objetoGsonBuilder.registerTypeAdapter(String.class, new StringSerializer());
                //objetoGsonBuilder.serializeNulls();
        //         objetoGsonBuilder.registerTypeAdapter(String.class, new StringSerializer());
                objetoGson = objetoGsonBuilder.create();
                objetoGson.fromJson(cadena, clase);
        } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        }
        return objetoGson.fromJson(cadena, clase);
    }
    
    public static <T> T convertirCadenaJsonAObjetoRequest(String cadena, Class<T> clase){
        //Gson objetoGson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer("dd/MM/yyyy")).create();
     Gson objetoGson=null;
        GsonBuilder objetoGsonBuilder = new GsonBuilder();
        //         objetoGsonBuilder.setDateFormat("dd/MM/yyyy");
                objetoGsonBuilder.registerTypeAdapter(Date.class, new DateSerializer("dd/MM/yyyy"));
        //         objetoGsonBuilder.registerTypeAdapter(String.class, new StringSerializer());
                //objetoGsonBuilder.serializeNulls();
        //         objetoGsonBuilder.registerTypeAdapter(String.class, new StringSerializer());
                objetoGson = objetoGsonBuilder.create();
                objetoGson.fromJson(cadena, clase);
        return objetoGson.fromJson(cadena, clase);
    }
    
    public static String convertirObjetoACadenaJson(Object objeto, String formatoFecha){
        Gson objetoGson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer(formatoFecha)).create();
        return objetoGson.toJson(objeto);
    }
    
    
}
