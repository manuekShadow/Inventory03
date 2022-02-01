package com.t3b.msinventory.rest.api.services;

import java.sql.SQLException;
import java.util.List;

import com.t3b.msinventory.rest.api.entities.custom.InfoOrderInsert;
import com.t3b.msinventory.rest.api.entities.custom.InventoryLayout;
import com.t3b.msinventory.rest.api.entities.custom.Order;

public interface DataServices {
	
	public List<InventoryLayout> getInfoLayoutAll();

	public List<InventoryLayout> getInfoLayoutByClaveTienda(String claveTienda);

	public List<Order> getOrderInventoryAll() throws ClassNotFoundException, SQLException;

	public InfoOrderInsert saveAll(InfoOrderInsert infoOrderInsert) throws ClassNotFoundException, SQLException;

	public InfoOrderInsert getFolioOrden(String fecha, String id_scanner) throws ClassNotFoundException, SQLException;
	
}
