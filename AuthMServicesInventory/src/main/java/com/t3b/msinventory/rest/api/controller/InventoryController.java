package com.t3b.msinventory.rest.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t3b.msinventory.rest.api.entities.custom.InfoOrderInsert;
import com.t3b.msinventory.rest.api.entities.custom.InventoryLayout;
import com.t3b.msinventory.rest.api.entities.custom.Order;
import com.t3b.msinventory.rest.api.entities.custom.OrderEntity;
import com.t3b.msinventory.rest.api.entities.custom.OrderInsert;
import com.t3b.msinventory.rest.api.entities.custom.OrderResponse;
import com.t3b.msinventory.rest.api.services.DataServices;
import com.t3b.msinventory.rest.api.utils.Constants;

@RestController
@RequestMapping({ "/inventory" })
public class InventoryController {
	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(InventoryController.class);

	OrderEntity ticket = null;
	InfoOrderInsert ticketResponseDB = null;
	int numOrder = 0;

	@Autowired
	DataServices dataServices;

	List<InfoOrderInsert> listInfoOrderInserts;
	List<OrderEntity> listNuevaOrder;

	@GetMapping({ "/layoutInventory" })
	public List<InventoryLayout> getInfoLayoutAll() {
		return this.dataServices.getInfoLayoutAll();
	}

	@GetMapping({ "/layoutInventory/{claveTienda}" })
	public List<InventoryLayout> getInfoLayoutByClaveTienda(@PathVariable("claveTienda") String claveTienda) {
		return this.dataServices.getInfoLayoutByClaveTienda(claveTienda);
	}

	@GetMapping({ "/folioOrdenDevices/{fecha}/{id_scanner}" })
	public ResponseEntity<OrderResponse> getMaxFolioOrdenDevices(@PathVariable("fecha") String fecha,
			@PathVariable("id_scanner") String id_scanner) {
		ResponseEntity<OrderResponse> response;
		System.out.println("Valores Enviados desde la APK " + " fecha: " + fecha + " , " + " imei: " + id_scanner);

		//
		try {

			ticketResponseDB = new InfoOrderInsert();
			ticketResponseDB = getMaxFolio(fecha, id_scanner);

			OrderResponse ticketResponse = new OrderResponse();
			ticketResponse.setTicketId(Integer.valueOf(ticketResponseDB.getFolio_conteo()));
			ticketResponse.setFecha(ticketResponseDB.getFecha());
			ticketResponse.setFolio_conteo(ticketResponseDB.getFolio_conteo());
			ticketResponse.setIclave(ticketResponseDB.getIclave());
			ticketResponse.setTclave(ticketResponseDB.getTclave());
			ticketResponse.setId_scanner(ticketResponseDB.getId_scanner());
			if(ticketResponseDB.getId_scanner().equals("N/A")) {
				ticketResponse.setMessage(Constants.QRY_RESULT_DB);
			}else {
				ticketResponse.setMessage("El IMEI consultado, "+ticketResponseDB.getId_scanner()+" ,"+"Contienen Datos");				
			}

			response = new ResponseEntity(ticketResponse, HttpStatus.CREATED);
			System.out.println("Response que se enviaran del MS " + ": " + ticketResponse.toString());

		} catch (Exception e) {

			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println("Response que se enviaran del MS " + ": " + response.toString());
		} finally {
			listNuevaOrder = null;
		}
		return response;
		//

	}

	public InfoOrderInsert getMaxFolio(String fecha, String id_scanner)
			throws SQLException, ClassNotFoundException {
		return dataServices.getFolioOrden(fecha, id_scanner);
	}

	@GetMapping({ "/OrderInventory" })
	public List<Order> getOrderInventoryAll() {
		return this.dataServices.getOrderInventoryAll();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping({ "/insertOrderInventory" })
	public ResponseEntity<OrderResponse> saveTicket(@RequestBody List<OrderInsert> listOrderInsert) {
		ResponseEntity<OrderResponse> response;
		System.out.println(listOrderInsert.toString());

		listNuevaOrder = new ArrayList<>();
		listInfoOrderInserts = new ArrayList<>();

		InfoOrderInsert infoOrderInsert = null;
		for (int i = 0; listOrderInsert.size() > i; i++) {

			infoOrderInsert = new InfoOrderInsert();

			infoOrderInsert.setTclave(listOrderInsert.get(i).getTclave());
			infoOrderInsert.setFecha(String.valueOf(listOrderInsert.get(i).getFecha()));
			infoOrderInsert.setNum_scanner(String.valueOf(listOrderInsert.get(i).getNum_scanner()));
			infoOrderInsert.setIclave(String.valueOf(listOrderInsert.get(i).getIclave()));
			infoOrderInsert.setId_scanner(listOrderInsert.get(i).getId_scanner());
			infoOrderInsert.setCb_pieza(listOrderInsert.get(i).getCb_pieza());
			infoOrderInsert.setEmpaque(String.valueOf(listOrderInsert.get(i).getEmpaque()));
			infoOrderInsert.setNum_conteo(String.valueOf(listOrderInsert.get(i).getNum_conteo()));
			infoOrderInsert.setTipo_conteo(String.valueOf(listOrderInsert.get(i).getTipo_conteo()));
			infoOrderInsert.setCantidad_piezas(String.valueOf(listOrderInsert.get(i).getCantidad_piezas()));
			infoOrderInsert.setHora_inicio_conteo(String.valueOf(listOrderInsert.get(i).getHora_inicio_conteo()));
			infoOrderInsert.setHora_fin_conteo(String.valueOf(listOrderInsert.get(i).getHora_fin_conteo()));
			infoOrderInsert.setStatus_conteo(String.valueOf(listOrderInsert.get(i).getStatus_conteo()));
			infoOrderInsert.setCb_caja(listOrderInsert.get(i).getCb_caja());
			infoOrderInsert.setUseq(String.valueOf(listOrderInsert.get(i).getUseq()));
			infoOrderInsert.setFolio_conteo(String.valueOf(listOrderInsert.get(i).getFolio_conteo()));
			infoOrderInsert.setHora_envio_nube(String.valueOf(listOrderInsert.get(i).getHora_envio_nube()));
			infoOrderInsert.setFecha_hora_registro_producto(
					String.valueOf(listOrderInsert.get(i).getFecha_hora_registro_producto()));
			listInfoOrderInserts.add(infoOrderInsert);
		}
		try {

			for (int i = 0; listOrderInsert.size() > i; i++) {
				ticketResponseDB = new InfoOrderInsert();
				ticketResponseDB = setOrder(listInfoOrderInserts.get(i));
				if (ticketResponseDB.getFolio_conteo() == null && ticketResponseDB.getFolio_conteo().equals("0")) {
					numOrder = 0;
					ticketResponseDB.setFolio_conteo(String.valueOf(numOrder));
					break;
				} else {
					ticketResponseDB.setFolio_conteo(ticketResponseDB.getFolio_conteo());
				}
			}

			OrderResponse ticketResponse = new OrderResponse();
			ticketResponse.setTicketId(Integer.valueOf(ticketResponseDB.getFolio_conteo()));
			ticketResponse.setFecha(ticketResponseDB.getFecha());
			ticketResponse.setFolio_conteo(ticketResponseDB.getFolio_conteo());
			ticketResponse.setIclave(ticketResponseDB.getIclave());
			ticketResponse.setTclave(ticketResponseDB.getTclave());
			ticketResponse.setId_scanner(ticketResponseDB.getId_scanner());
			ticketResponse.setMessage("El ticket se genero satisfactoriamente.");

			response = new ResponseEntity(ticketResponse, HttpStatus.CREATED);
			System.out.println("Response que se enviaran del MS " + ": " + ticketResponse.toString());

		} catch (Exception e) {

			response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

		} finally {
			listNuevaOrder = null;
		}
		return response;
	}

	public InfoOrderInsert setOrder(InfoOrderInsert infoOrderInsert) throws SQLException, ClassNotFoundException {
		return dataServices.saveAll(infoOrderInsert);
	}

}
