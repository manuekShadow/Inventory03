package com.t3b.msinventory.rest.api.entities.custom;

public class OrderResponse {
	private Integer ticketId;
	private String tclave;
    private String fecha;
    private String folio_conteo;
    private String iclave;
	private String message;
	private String id_scanner;
    
	public Integer getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTclave() {
		return tclave;
	}

	public void setTclave(String tclave) {
		this.tclave = tclave;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFolio_conteo() {
		return folio_conteo;
	}

	public void setFolio_conteo(String folio_conteo) {
		this.folio_conteo = folio_conteo;
	}

	public String getIclave() {
		return iclave;
	}

	public void setIclave(String iclave) {
		this.iclave = iclave;
	}

	public String getId_scanner() {
		return id_scanner;
	}

	public void setId_scanner(String id_scanner) {
		this.id_scanner = id_scanner;
	}

	@Override
	public String toString() {
		return "OrderResponse [ticketId=" + ticketId + ", tclave=" + tclave + ", fecha=" + fecha + ", folio_conteo="
				+ folio_conteo + ", iclave=" + iclave + ", message=" + message + ", id_scanner=" + id_scanner + "]";
	}


}
