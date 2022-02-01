package com.t3b.msinventory.rest.api.entities.custom;

import java.util.List;

public class OrderResponseLayInv {
		@Override
	public String toString() {
		return "OrderResponseLayInv [Id=" + Id + ", message=" + message + ", inventoryLayoutList=" + inventoryLayoutList
				+ "]";
	}
		private Integer Id;
		private String message;
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public List<InventoryLayout> getInventoryLayoutList() {
			return inventoryLayoutList;
		}
		public void setInventoryLayoutList(List<InventoryLayout> inventoryLayoutList) {
			this.inventoryLayoutList = inventoryLayoutList;
		}
		private List<InventoryLayout> inventoryLayoutList; 
		
		
}
