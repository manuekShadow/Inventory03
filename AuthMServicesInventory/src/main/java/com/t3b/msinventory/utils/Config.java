package com.t3b.msinventory.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Properties;

public class Config {

	public static String rutaBase = System.getProperty("user.dir")+File.separator;
    public static String rutaConf = rutaBase+"config"+File.separator;
    public static String archivoprops = "WSDashboard.properties";
    
    public static String host = "";
    public static String port = "";
    public static String user = "";
    public static String pass = "";
    public static String name = "";
    public static String jdni = "";
    public static String surl = "";
    public static String driv = "";
    public static String cat = "";

    public static String ms_port = "";
    public static String ms_url = "";

    //JMH
    public static boolean estaCargada = false;
    public static String bdServiceName="";

    public static void act_datos(String driver,String url,String hostt,String service){
    	driv= driver;
        surl = url;
        host = hostt;
        bdServiceName = service;        
    }
    //
    public static void cargaConfig(){
        try{
            estaCargada=false;
            System.out.println("Ruta Base: " + rutaConf+archivoprops);
            File arch = new File(rutaConf+archivoprops);
            if(arch.exists()){
                Properties props = new Properties();
                props.load(new FileInputStream(rutaConf+archivoprops));

                host = props.getProperty("host").equals(null)?"192.200.1.26":props.getProperty("host").toString();
                port = props.getProperty("port").equals(null)?"2638":props.getProperty("port").toString();
                user = props.getProperty("user").equals(null)?"dba":props.getProperty("user").toString();
                pass = props.getProperty("pass").equals(null)?"5575349":props.getProperty("pass").toString();
                if(pass.equals("###"))
                    pass = generaPass(1);
                name = props.getProperty("name").equals(null)?"master64":props.getProperty("name").toString();
                jdni = props.getProperty("jdni").equals(null)?"x":props.getProperty("jdni").toString();
                surl = props.getProperty("ms.url").equals(null)?"jdbc:sybase:Tds:":props.getProperty("ms.url").toString();
                driv = props.getProperty("driv").equals(null)?"com.sybase.jdbc4.jdbc.SybDriver":props.getProperty("driv").toString();

                ms_port = props.getProperty("ms.port").equals(null)?"8080":props.getProperty("ms.port").toString();
                
                //JMH
                bdServiceName  = props.getProperty("bdServiceName")==null?"":props.getProperty("bdServiceName").toString();
                //
                
                System.out.println("#####Conectado a: " + host+ " #####");
                System.out.println("#####Conectado a: " + port+ " #####");
                estaCargada = true;

            }
        }catch(Exception ex){
            System.out.println("Excepcion al cargar la configuracion: " + ex.toString());
            estaCargada = false;
        }
    }


    private static String generaPass(int mesActual){
        int annio = 0;
        int mes = 0;
        String regreso = "";
        String aux = "";
        Calendar cal = Calendar.getInstance();
        if(mesActual != 1){
            cal.add(Calendar.MONTH, -1);
        }
        mes = cal.get(Calendar.MONTH) + 1;
        annio = cal.get(Calendar.YEAR);
        switch(mes){
            case 1: aux = "z"; break;
            case 2: aux = "x"; break;
            case 3: aux = "y"; break;
            case 4: aux = "o"; break;
            case 5: aux = "m"; break;
            case 6: aux = "l"; break;
            case 7: aux = "g"; break;
            case 8: aux = "f"; break;
            case 9: aux = "e"; break;
            case 10: aux = "d"; break;
            case 11: aux = "b"; break;
            case 12: aux = "a"; break;
        }
        regreso = annio+""+(mes < 10?"0"+mes:mes)+aux;
        System.out.println(regreso);
        return regreso;
    }

}