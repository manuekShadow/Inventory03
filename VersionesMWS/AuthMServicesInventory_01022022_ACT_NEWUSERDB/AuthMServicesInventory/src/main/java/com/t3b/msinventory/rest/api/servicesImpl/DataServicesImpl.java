package com.t3b.msinventory.rest.api.servicesImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t3b.msinventory.rest.api.entities.custom.InfoOrderInsert;
import com.t3b.msinventory.rest.api.entities.custom.InventoryLayout;
import com.t3b.msinventory.rest.api.entities.custom.Order;
import com.t3b.msinventory.rest.api.repository.InventoryLayoutRepository;
import com.t3b.msinventory.rest.api.repository.OrderRepository;
import com.t3b.msinventory.rest.api.repository.TicketRepository;
import com.t3b.msinventory.rest.api.services.DataServices;

@Service
public class DataServicesImpl implements DataServices{
	
	@Autowired
	InventoryLayoutRepository inventoryLayoutRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<InventoryLayout> getInfoLayoutAll() {
		return inventoryLayoutRepository.getInfoLayoutAll();
	}
	
	@Override
	public List<InventoryLayout> getInfoLayoutByClaveTienda(String claveTienda) {
		return inventoryLayoutRepository.getInfoLayoutByClaveTienda(claveTienda);
	}

	@Override
	public  List<Order> getOrderInventoryAll() throws ClassNotFoundException, SQLException{
		return orderRepository.getOrderInventoryAll();
	}

	@Override
	public InfoOrderInsert saveAll(InfoOrderInsert infoOrderInsert) throws ClassNotFoundException, SQLException {
		return ticketRepository.save(infoOrderInsert);
	}

	@Override
	public InfoOrderInsert getFolioOrden(String fecha, String id_scanner) throws ClassNotFoundException, SQLException {
		return orderRepository.getFolioOrden(fecha, id_scanner);
	}

}
