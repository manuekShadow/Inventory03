package com.t3b.msinventory.rest.api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.t3b.msinventory.rest.api.db.IInventory;
import com.t3b.msinventory.rest.api.entities.custom.InfoOrderInsert;
import com.t3b.msinventory.utils.Conexion;


@Repository
public class TicketRepository {

	public static final Logger logger = LogManager.getLogger(TicketRepository.class);

	private Conexion conex = null;
	Connection connSQL = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Statement statement = null;
	InfoOrderInsert orderEntitySP;
	InfoOrderInsert orderEntityResSP;
	int numOrder = 0;
	String[] numFolio;


	public InfoOrderInsert save(InfoOrderInsert infoOrderInsert) throws ClassNotFoundException, SQLException {

		try {
			conex = new Conexion();
			connSQL = conex.getConexion();
			orderEntitySP = new InfoOrderInsert();
			orderEntityResSP = new InfoOrderInsert();

			// JMH
			if (connSQL != null) {
				String aux = null;
		
				aux = IInventory.SP_FN_INSERTORDER
						.replaceFirst("\\?",infoOrderInsert.getTclave())
						.replaceFirst("\\?",infoOrderInsert.getFecha())
						.replaceFirst("\\?",infoOrderInsert.getFolio_conteo()) 
						.replaceFirst("\\?",infoOrderInsert.getIclave())
						.replaceFirst("\\?",infoOrderInsert.getId_scanner())
						.replaceFirst("\\?",infoOrderInsert.getNum_conteo())
						.replaceFirst("\\?",infoOrderInsert.getNum_scanner())
						.replaceFirst("\\?",infoOrderInsert.getCb_pieza())
						.replaceFirst("\\?",infoOrderInsert.getEmpaque())
						.replaceFirst("\\?",infoOrderInsert.getTipo_conteo())
						.replaceFirst("\\?",infoOrderInsert.getCantidad_piezas())
						.replaceFirst("\\?",infoOrderInsert.getFecha_hora_registro_producto())
						.replaceFirst("\\?",infoOrderInsert.getHora_inicio_conteo())
						.replaceFirst("\\?",infoOrderInsert.getHora_fin_conteo())
						.replaceFirst("\\?",infoOrderInsert.getStatus_conteo())
						.replaceFirst("\\?",infoOrderInsert.getCb_caja())
						.replaceFirst("\\?",infoOrderInsert.getUseq())
						.replaceFirst("\\?",infoOrderInsert.getHora_envio_nube());
				
				System.out.println("####Inserto el producto scaneado desde el APK: " + aux);

				try {

					stmt = connSQL.prepareStatement(aux.toLowerCase().replaceAll("\\ ", " "));

					// HGM
					rs = stmt.executeQuery();

					// Validar que se tenga una conindicencia en la DB

					// Process the result set.
					while (rs.next()) {
						if (rs.getString("tclave") != null) {
							try {
								if(rs.getString("folio_conteo").length() > 0){
									orderEntitySP.setFolio_conteo(rs.getString("folio_conteo"));
									orderEntitySP.setTclave(rs.getString("tclave"));
									orderEntitySP.setFecha(rs.getString("fecha"));
									orderEntitySP.setId_scanner(rs.getString("id_scanner"));
									System.out.println("value de la DB" + ": " + orderEntitySP.toString());
									numFolio = (orderEntitySP.getFolio_conteo()).split("\\.");
									orderEntityResSP.setFolio_conteo(numFolio[0]);
									orderEntityResSP.setIclave(orderEntitySP.getTclave());
									orderEntityResSP.setFecha(orderEntitySP.getFecha());
									orderEntityResSP.setId_scanner(orderEntitySP.getId_scanner());
									System.out.println("valores que se enviaran del MS " + ": " + orderEntitySP.toString());
								}else if (rs.getInt("iclave") != 0) {
									orderEntitySP.setIclave(rs.getString("iclave"));
									System.out.println("value de iclave" + ": " + orderEntitySP.getIclave());
									orderEntityResSP.setIclave(orderEntitySP.getIclave());
									orderEntitySP.setTclave(rs.getString("tclave"));
									orderEntitySP.setFecha(rs.getString("fecha"));
									orderEntitySP.setId_scanner(rs.getString("id_scanner"));
									System.out.println("value de la DB" + ": " + orderEntitySP.toString());
									orderEntityResSP.setIclave(orderEntitySP.getIclave());
									orderEntityResSP.setTclave(orderEntitySP.getTclave());
									orderEntityResSP.setFecha(orderEntitySP.getFecha());
									orderEntityResSP.setId_scanner(orderEntitySP.getId_scanner());
									System.out.println("valores que se enviaran del MS " + ": " + orderEntitySP.toString());

								}	
							} catch (Exception e) {
								System.out.println(e.getMessage());
								orderEntitySP.setIclave(rs.getString("iclave"));
								orderEntitySP.setTclave(rs.getString("tclave"));
								orderEntitySP.setFecha(rs.getString("fecha"));
								orderEntitySP.setId_scanner(rs.getString("id_scanner"));
								System.out.println("value de la DB" + ": " + orderEntitySP.toString());
								orderEntityResSP.setIclave(orderEntitySP.getIclave());
								orderEntityResSP.setTclave(orderEntitySP.getTclave());
								orderEntityResSP.setFecha(orderEntitySP.getFecha());
								orderEntityResSP.setId_scanner(orderEntitySP.getId_scanner());
								orderEntityResSP.setFolio_conteo("0");
								System.out.println("valores que se enviaran del MS " + ": " + orderEntitySP.toString());
							}
							
						} else {
							System.out.println("No se inserto la "+" folio: "+infoOrderInsert.getFolio_conteo()+" e "+"iclave: "+infoOrderInsert.getIclave());
							orderEntityResSP = null;
						}

					}
					//

				} catch (SQLException e) {
					e.printStackTrace();
					if (stmt != null) {
						conex.close(connSQL, stmt, rs, stmt);
					}
				}

			} else {
				System.out.println("####VALIDACONEX: " + connSQL);
				orderEntityResSP = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (stmt != null) {
				conex.close(connSQL, stmt, rs, stmt);
			}
		} finally {
			if (stmt != null) {
				conex.close(connSQL, stmt, rs, stmt);
			}
		}

		return orderEntityResSP;
	}

}
