package gob.osinergmin.myc.util;


import gob.osinergmin.alfresco.remote.rest.ro.out.AlfrescoOutRO;
import gob.osinergmin.alfresco.remote.rest.ro.out.list.ListAlfrescoOutRO;
import gob.osinergmin.alfresco.rest.util.AlfrescoInvoker;
import gob.osinergmin.siged.remote.enums.InvocationResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.cxf.helpers.IOUtils;

public class AlfrescoRemoteTest {

   private static final String HOST = "http://11.160.121.132:8180/siged-rest-old";
   private static final String URL_ALFRESCO_UPLOAD = HOST + "/remote/alfresco/uploadFiles";
   private static final String URL_ALFRESCO_DOWNLOAD = HOST + "/remote/alfresco/download";
   private static final String LOCAL_FOLDER = "C:\\";   
   private static final String FILE_PRUEBA = "BL-0000119_DOCUMENTO.PDF";

   public static void main(String[] args) throws IOException {
      //uploadFilesConGerencia();
      downloadFile();
    //String slash = "/";
    //int slashIndex = new String("Company Home/HIDROCARBUROS/LOCADOR/ARCHIVOS/test1.txt").lastIndexOf(slash);
    //String nombreArchivo = new String("Company Home/HIDROCARBUROS/LOCADOR/ARCHIVOS/test1.txt").substring(slashIndex + 1);
    //System.out.println("nombreArchivo :"+nombreArchivo);
       
   }

   public static void uploadFilesConGerencia() {
      ListAlfrescoOutRO listAlfrescoOutRO;
      List<File> files = new ArrayList<File>();

      files.add(new File(LOCAL_FOLDER + FILE_PRUEBA));    
      listAlfrescoOutRO = AlfrescoInvoker.upload(URL_ALFRESCO_UPLOAD, "NPS_ADMIN", "HIDROCARBUROS", null, null, null, "/LOCADOR/ARCHIVOS", files);
    
    
      if (listAlfrescoOutRO.getResultCode().equals(InvocationResult.SUCCESS.getCode())) {
         System.out.println("Archivos subidos exitosamente: ");

         if (listAlfrescoOutRO.getFiles() != null) {
            for (Iterator<AlfrescoOutRO> iterator = listAlfrescoOutRO.getFiles().iterator(); iterator.hasNext();) {
               System.out.println("------------------------------------------");
               AlfrescoOutRO a = iterator.next();
               System.out.println("FullFilePath: " + a.getFullFilePath());
               System.out.println("------------------------------------------");
            }
         }
      } else {
         System.out.println("Error message: " + listAlfrescoOutRO.getMessage());
         System.out.println("Error errorcode: " + listAlfrescoOutRO.getErrorCode());
         System.out.println("Error resultcode: " + listAlfrescoOutRO.getResultCode());
      }
   }

   public static void downloadFile() throws IOException {
      InputStream in = AlfrescoInvoker.download(URL_ALFRESCO_DOWNLOAD, "NPS_ADMIN", "HIDROCARBUROS", null, null, null, "/LOCADOR/ARCHIVOS/", FILE_PRUEBA);
      

      if (in != null) {
         File file = new File(LOCAL_FOLDER + "prueba\\" + FILE_PRUEBA);
         OutputStream fo = new FileOutputStream(file);
         IOUtils.copyAndCloseInput(in, fo);
         System.out.println("Descargado.. " + "2" + FILE_PRUEBA);
      } else {
         System.out.println("No descargado.");
      }
   }
}
