package com.t3b.msinventory.rest.api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.t3b.msinventory.rest.api.db.IInventory;
import com.t3b.msinventory.rest.api.entities.custom.InfoOrderInsert;
import com.t3b.msinventory.rest.api.entities.custom.Order;
import com.t3b.msinventory.rest.api.entities.custom.OrderInsert;
import com.t3b.msinventory.rest.api.entities.custom.Response;
import com.t3b.msinventory.utils.Conexion;
import com.t3b.msinventory.utils.Log4J2PropertiesConf;

@Repository
public class OrderRepository {
	private static final Logger logger = LogManager.getLogger(Log4J2PropertiesConf.class);

	String sql = null;
	private Conexion conex = null;
	Connection connSQL = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List<Order> listOrder = null;
	Order order;
	InfoOrderInsert orderEntitySP, orderEntityResSP;
	int numOrder = 0;
	String[] numFolio;

	public List<OrderInsert> save(List<OrderInsert> ticket) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			List<OrderInsert> ticket_insert = ticket;

			Map<String, OrderInsert> map = new HashMap<String, OrderInsert>();
			for (int i = 0; ticket_insert.size() > i; i++) {
				map.put(String.valueOf(i), ticket_insert.get(i));
			}

			return ticket;

		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
					logger.warn(ex);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					logger.warn(ex);
				}
			}
		}
	}

	public OrderInsert methodSave(OrderInsert ticket) {
		OrderInsert numOrder = null;
		return numOrder;
	}

	public List<Order> getOrderInventoryAll() throws SQLException{
		try {
			conex = new Conexion();
			connSQL = conex.getConexion();

			// JMH
			if (connSQL != null) {
				sql = "SELECT * FROM dba.boa_conteos_nube;";

				listOrder = new ArrayList<>();
				logger.info("####Inserto el producto scaneado desde el APK: " + sql);
				//System.out.println("####Inserto el producto scaneado desde el APK: " + sql);

				try {

					stmt = connSQL.prepareStatement(sql);

					// HGM
					rs = stmt.executeQuery();

					// Validar que se tenga una conindicencia en la DB

					// Process the result set.

					boolean anyResults = false;
					if (rs.next()) {
						do {
							order = new Order();
							order.setFolio_conteo(rs.getInt("folio_conteo"));
							order.setIclave(rs.getInt("iclave"));
							
							logger.info("value del folio" + ": " + order.getFolio_conteo());
							logger.info("value del folio" + ": " + order.getIclave());
							//System.out.println("value del folio" + ": " + order.getFolio_conteo());
							//System.out.println("value del folio" + ": " + order.getIclave());
							listOrder.add(order);
						} while (rs.next());
					}
					if (!anyResults) {
						JOptionPane.showMessageDialog(null, "Not Found");
					}

					//

				} catch (SQLException e) {
					e.printStackTrace();
					if (stmt != null) {
						conex.close(connSQL, stmt, rs, stmt);
					}
				}

			} else {
				logger.info("####VALIDACONEX: " + connSQL);
				//System.out.println("####VALIDACONEX: " + connSQL);
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

		for (int j = 0; listOrder.size() > j; j++) {
			logger.info("Objeto Total: " + " " + listOrder.get(j).toString());
			//System.out.println("Objeto Total: " + " " + listOrder.get(j).toString());
		}

		return listOrder;
	}

	@SuppressWarnings("unused")
	public InfoOrderInsert getFolioOrden(String fecha, String id_scanner) {

		try {
			conex = new Conexion();
			connSQL = conex.getConexion();
			orderEntitySP = new InfoOrderInsert();
			orderEntityResSP = new InfoOrderInsert();

			// JMH
			if (connSQL != null) {
				String aux = null;

				aux = IInventory.CONSULT_FOLIOORDER.replaceFirst("\\?", fecha).replaceFirst("\\?", id_scanner);
				logger.info("####Inserto el producto scaneado desde el APK: " + aux);
				//System.out.println("####Inserto el producto scaneado desde el APK: " + aux);

				sql = "SELECT * FROM dba.boa_conteos_nube;";
				sql = aux;

				listOrder = new ArrayList<>();

				logger.info("####Inserto el producto scaneado desde el APK: " + sql);
				//System.out.println("####Inserto el producto scaneado desde el APK: " + sql);

				try {

					stmt = connSQL.prepareStatement(sql);

					// HGM
					rs = stmt.executeQuery();

					// Validar que se tenga una conindicencia en la DB

					// Process the result set.

					boolean anyResults = false;
					if (rs.next()) {
						do {
							
							orderEntitySP.setFolio_conteo(rs.getString("folio_conteo"));
							orderEntitySP.setId_scanner(rs.getString("id_scanner"));
							logger.info("value de la DB" + ": " + orderEntitySP.toString());
							//System.out.println("value de la DB" + ": " + orderEntitySP.toString());
									
							orderEntityResSP = orderEntitySP;
							
						} while (rs.next());
					}

				} catch (SQLException e) {
					
					Response<Boolean> response = new Response<>();
					
					response.setMessage("Ocurrio un error");
					logger.info(e.getMessage());
					
					logger.error(e.toString());
					logger.info("No se encontraron datos asociados al"+" ,IMEI: " +id_scanner);
					//System.out.println("No se encontraron datos asociados al"+" ,IMEI: " +id_scanner); 
					orderEntityResSP.setId_scanner("N/A");
					orderEntityResSP.setFolio_conteo("0");
					logger.info("valores que se enviaran del MS " + ": " + orderEntitySP.toString());
					//System.out.println("valores que se enviaran del MS " + ": " + orderEntitySP.toString());
					if (stmt != null) {
						conex.close(connSQL, stmt, rs, stmt);
					}
				}

			} else {
				logger.info("####VALIDACONEX: " + connSQL);
				//System.out.println("####VALIDACONEX: " + connSQL);
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

	public static boolean resultSetIsEmpty(ResultSet rs) {
		try {
			// We point the last row
			rs.getCursorName();
			int rsRows = rs.getRow(); // get last row number

			if (rsRows == 0) {
				return true;
			}
			rs.isBeforeFirst();
			return false;
		} catch (SQLException ex) {
			return true;
		}
	}

}

