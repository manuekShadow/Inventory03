package com.t3b.msinventory.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author jmarquez
 *
 */
public class Conexion {
    
	private static final Logger logger = LogManager.getLogger(Conexion.class);
	
    private Connection con = null;    
    @SuppressWarnings("unused")
	private String pass = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    /**
     * Metodo que crea la conexion hacia la base de datos
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    /*public Conexion() throws ClassNotFoundException, SQLException{
    	
        if(!Config.estaCargada)
            Config.cargaConfig();
                    
            Class.forName(Config.driv);
            try {
                con = DriverManager.getConnection(Config.surl+Config.host+":"+Config.port+"?ServiceName="+Config.bdServiceName, "acrdb", "");                
                pass = Config.pass;
            } catch (SQLException ex) {
                try {                        
                    con = DriverManager.getConnection(Config.surl+Config.host+":"+Config.port+"?ServiceName="+Config.bdServiceName, Config.user, "");                                            
                    pass = Config.pass;
                } catch (SQLException ex1) {                    
                    con = DriverManager.getConnection(Config.surl+Config.host+":"+Config.port+"?ServiceName="+Config.bdServiceName, Config.user, Config.pass);                                                
                    pass = Config.pass;                    
                }
            }        
    }*/
    
    /**
     * Metodo que devuelve el recurso de conexion
     * @return 
     */
    public Connection getConexion(){        
        return this.con;        
    } 
    
    public void close(Connection con, Statement st, ResultSet rs, PreparedStatement preparedStatement) {
        try{
            if(st != null)
                st.close();

            if(rs != null)
                rs.close();
            
            if(preparedStatement != null)
                preparedStatement.close();

            if(con != null) {
            	con.close();
                //con.commit();
            }
                
        }catch(SQLException ex){
            logger.log(Level.ERROR,"ERROR_EDN_CONECT", Config.name, this.getClass().getName(), "close bd", ex.getMessage());
        }
    }
    
    //Nueva Conexion
    public Conexion() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
    	if(!Config.estaCargada) {
    		Config.cargaConfig();
    	}
          
        /*
         * Open the connection. May throw a SQLException.
         */
           DriverManager.registerDriver((Driver) Class.forName(Config.driv).newInstance());
           
           try {
               con = DriverManager.getConnection(Config.surl+Config.host+":"+Config.port+"?ServiceName="+Config.bdServiceName, "acrdb", "");                
               pass = Config.pass;
           } catch (SQLException ex) {
               try {                        
                   con = DriverManager.getConnection(Config.surl+Config.host+":"+Config.port+"?ServiceName="+Config.bdServiceName, Config.user, "");                                            
                   pass = Config.pass;
               } catch (SQLException ex1) {                    
                   con = DriverManager.getConnection(Config.surl+Config.host+":"+Config.port+"?ServiceName="+Config.bdServiceName, Config.user, Config.pass);                                                
                   pass = Config.pass;                    
               }
           }      
	}
    //
}
