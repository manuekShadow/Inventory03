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
import com.t3b.msinventory.rest.api.utils.Constants;
import com.t3b.msinventory.utils.Conexion;

@Repository
public class OrderRepository {
	private static final Logger logger = LogManager.getLogger(OrderRepository.class);

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

	public List<Order> getOrderInventoryAll() {
		try {
			conex = new Conexion();
			connSQL = conex.getConexion();

			// JMH
			if (connSQL != null) {
				sql = "SELECT * FROM dba.boa_conteos_nube;";

				listOrder = new ArrayList<>();

				System.out.println("####Inserto el producto scaneado desde el APK: " + sql);

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
							// if (rs.getInt("folio_conteo") != 0) {
							order.setFolio_conteo(rs.getInt("folio_conteo"));
							order.setIclave(rs.getInt("iclave"));
							System.out.println("value del folio" + ": " + order.getFolio_conteo());
							System.out.println("value del folio" + ": " + order.getIclave());
							// } else if (rs.getInt("iclave") != 0) {
							// order.setIclave(rs.getInt("iclave"));
							// System.out.println("value de iclave" + ": " + order.getIclave());
							// }
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
				System.out.println("####VALIDACONEX: " + connSQL);
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
			System.out.println("Objeto Total: " + " " + listOrder.get(j).toString());
		}

		return listOrder;
	}

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

				System.out.println("####Inserto el producto scaneado desde el APK: " + aux);

				sql = "SELECT * FROM dba.boa_conteos_nube;";
				sql = aux;

				listOrder = new ArrayList<>();

				System.out.println("####Inserto el producto scaneado desde el APK: " + sql);

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
							System.out.println("value de la DB" + ": " + orderEntitySP.toString());
							
							
							// if (rs.getInt("folio_conteo") != 0) {
							//Algo habia
							// } else if (rs.getInt("iclave") != 0) {
							// order.setIclave(rs.getInt("iclave"));
							// System.out.println("value de iclave" + ": " + order.getIclave());
							// }
//							listOrder.add(order);
							
							orderEntityResSP = orderEntitySP;
							
						} while (rs.next());
					}
					//if (!anyResults) {
					//	JOptionPane.showMessageDialog(null, "Not Found");
					//}

					//

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("No se encontraron datos asociados al"+" ,IMEI: " +id_scanner); 
					orderEntityResSP.setId_scanner("N/A");
					orderEntityResSP.setFolio_conteo("0");
					System.out.println("valores que se enviaran del MS " + ": " + orderEntitySP.toString());
					if (stmt != null) {
						conex.close(connSQL, stmt, rs, stmt);
					}
				}
/*
				for (int j = 0; listOrder.size() > j; j++) {
					System.out.println("Objeto Total: " + " " + listOrder.get(j).toString());
				}*/

				/*
				 * try {
				 * 
				 * stmt = connSQL.prepareStatement(aux.toLowerCase().replaceAll("\\ ", " "));
				 * 
				 * // HGM if(!resultSetIsEmpty(rs)) {
				 * 
				 * rs = stmt.executeQuery(); //boolean hasResult = rs.next(); // Validar que se
				 * tenga una conindicencia en la DB if (rs.next()) { try {
				 * if(rs.getString("folio_conteo").length() > 0){
				 * orderEntitySP.setFolio_conteo(rs.getString("folio_conteo"));
				 * orderEntitySP.setId_scanner(rs.getString("id_scanner"));
				 * System.out.println("value de la DB" + ": " + orderEntitySP.toString());
				 * 
				 * numFolio = (orderEntitySP.getFolio_conteo()).split("\\.");
				 * orderEntityResSP.setFolio_conteo(numFolio[0]);
				 * orderEntityResSP.setId_scanner(orderEntitySP.getId_scanner());
				 * System.out.println("valores que se enviaran del MS " + ": " +
				 * orderEntitySP.toString()); }else if (rs.getInt("folio_conteo") == 0) {
				 * orderEntitySP.setFolio_conteo(rs.getString("folio_conteo"));
				 * orderEntitySP.setId_scanner(rs.getString("id_scanner"));
				 * System.out.println("value de la DB" + ": " + orderEntitySP.toString());
				 * 
				 * numFolio = (orderEntitySP.getFolio_conteo()).split("\\.");
				 * orderEntityResSP.setFolio_conteo(numFolio[0]);
				 * orderEntityResSP.setId_scanner(orderEntitySP.getId_scanner());
				 * System.out.println("valores que se enviaran del MS " + ": " +
				 * orderEntitySP.toString()); } } catch (Exception e) {
				 * System.out.println(e.getMessage()); orderEntitySP.setFolio_conteo("0");
				 * orderEntitySP.setId_scanner(rs.getString("id_scanner"));
				 * System.out.println("value de la DB" + ": " + orderEntitySP.toString());
				 * orderEntityResSP.setId_scanner(orderEntitySP.getId_scanner());
				 * orderEntityResSP.setFolio_conteo("0");
				 * System.out.println("valores que se enviaran del MS " + ": " +
				 * orderEntitySP.toString()); }
				 * 
				 * } else {
				 * System.out.println("No se encontro folio asociado al IMEI "+" ,IMEI: "
				 * +id_scanner); orderEntityResSP = null; } //
				 * 
				 * }else { System.out.println("No se encontraron datos asociados al"+" ,IMEI: "
				 * +id_scanner); orderEntityResSP.setId_scanner("N/A");
				 * orderEntityResSP.setFolio_conteo("0");
				 * System.out.println("valores que se enviaran del MS " + ": " +
				 * orderEntitySP.toString()); }
				 * 
				 * } catch (SQLException e) { e.printStackTrace();
				 * System.out.println("####ERROR_SQL: " + e.getErrorCode());
				 * System.out.println("No se encontraron datos asociados al"+" ,IMEI: "
				 * +id_scanner); orderEntityResSP.setId_scanner("N/A");
				 * orderEntityResSP.setFolio_conteo("0");
				 * System.out.println("valores que se enviaran del MS " + ": " +
				 * orderEntitySP.toString()); if (stmt != null) { conex.close(connSQL, stmt, rs,
				 * stmt); } }
				 */

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

	public static boolean resultSetIsEmpty(ResultSet rs) {
		try {
			// We point the last row
			rs.getCursorName();
			int rsRows = rs.getRow(); // get last row number

			if (rsRows == 0) {
				return true;
			}

			// It is necessary to back to top the pointer, so we can see all rows in our
			// ResultSet object.
			rs.isBeforeFirst();
			return false;
		} catch (SQLException ex) {
			return true;
		}
	}

}
