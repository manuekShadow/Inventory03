package com.t3b.msinventory.rest.api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.t3b.msinventory.rest.api.db.IUser;
import com.t3b.msinventory.rest.api.entities.custom.UsuarioOAUTH;
import com.t3b.msinventory.utils.Conexion;


@ManagedBean("UsuarioByQuery")
@Primary
@Repository
public class UsuarioRepository {

	public static final Logger logger = LogManager.getLogger(UsuarioRepository.class);

	private Conexion conex = null;
	Connection connSQL = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List<UsuarioOAUTH> listUsarios = null;
	UsuarioOAUTH usuarioOAUTH = null;
	
	// Metodo para obtener Credenciales cuando se consulta el API de AUTH
	public List<UsuarioOAUTH> getUserByLogin(String ulogin) throws ClassNotFoundException, SQLException {
		
	
		
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(ulogin);

		listUsarios = JDBCConnect(ulogin);

		return listUsarios;
	}

	// Cliente de Conexion JMHG
	public List<UsuarioOAUTH> JDBCConnect(String uLogin) throws ClassNotFoundException, SQLException{
		try {
			conex = new Conexion();
			connSQL = conex.getConexion();
			
			//JMH
			if(connSQL != null){
	            
				// Create a result set object by executing the query.
				// May throw a SQLException.
				String aux = null;
				
				aux = IUser.SP_FN_CONSULTAINFOUSEROAUTH
						.replaceFirst("\\?",uLogin);

				//System.out.println("####Inserto el producto scaneado desde el APK: " + aux);
				logger.info("####Consulta del SP mediante uLogin en DB: " + aux);
					
	            try {
	                stmt = connSQL.prepareStatement(aux);
	                
	                //HGM
					rs = stmt.executeQuery();
					listUsarios = new ArrayList<UsuarioOAUTH>();
					usuarioOAUTH = new UsuarioOAUTH();

					// Process the result set.
					while (rs.next()) {
						usuarioOAUTH.setUlogin(rs.getString("ulogin"));
						usuarioOAUTH.setUpassword(rs.getString("upassword"));
						System.out.println("value" + ": " + usuarioOAUTH.getUlogin() + ": " + usuarioOAUTH.getUpassword());
						listUsarios.add(usuarioOAUTH);

					}
					//
	                
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }finally {
	                if(stmt != null){                        
	                    conex.close(connSQL, stmt, rs, stmt);
	                }
	            } 
			} else {
				logger.info("####VALIDACONEX: " + connSQL);
				listUsarios = null;
				//System.out.println("####VALIDACONEX: " + connSQL);
			}
			
			
			}catch (Exception e) {
				// TODO: handle exception
			}
		
		
		
		return listUsarios;
		
	}
	
}
