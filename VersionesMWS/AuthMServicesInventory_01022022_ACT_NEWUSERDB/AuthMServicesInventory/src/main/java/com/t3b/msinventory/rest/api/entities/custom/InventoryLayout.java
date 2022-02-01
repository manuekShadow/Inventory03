package com.t3b.msinventory.rest.api.entities.custom;

public class InventoryLayout {

	private String claveTienda;
	private String descTienda;
	private String claveProducto;
	private String descProducto;
	private String unidad;
	private String cb;
	private String grupo;
	private String statusConteo; // ESTATUS DEL CONTEO (1=ABIERTO, 2=TERMINADO, 3 = ENVIADO AL BOT)
	private String empaque;
	private String tipoConteo;
	private String cbCaja;	

	public InventoryLayout(String claveTienda, String descTienda, String claveProducto, String descProducto,
			String unidad, String cb, String grupo, String statusConteo, String empaque, String tipoConteo,
			String cbCaja) {
		super();
		this.claveTienda = claveTienda;
		this.descTienda = descTienda;
		this.claveProducto = claveProducto;
		this.descProducto = descProducto;
		this.unidad = unidad;
		this.cb = cb;
		this.grupo = grupo;
		this.statusConteo = statusConteo;
		this.empaque = empaque;
		this.tipoConteo = tipoConteo;
		this.cbCaja = cbCaja;
	}

	public String getClaveTienda() {
		return claveTienda;
	}

	public void setClaveTienda(String claveTienda) {
		this.claveTienda = claveTienda;
	}

	public String getDescTienda() {
		return descTienda;
	}

	public void setDescTienda(String descTienda) {
		this.descTienda = descTienda;
	}

	public String getClaveProducto() {
		return claveProducto;
	}

	public void setClaveProducto(String claveProducto) {
		this.claveProducto = claveProducto;
	}

	public String getDescProducto() {
		return descProducto;
	}

	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getCb() {
		return cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getStatusConteo() {
		return statusConteo;
	}

	public void setStatusConteo(String statusConteo) {
		this.statusConteo = statusConteo;
	}

	public String getEmpaque() {
		return empaque;
	}

	public void setEmpaque(String empaque) {
		this.empaque = empaque;
	}

	public String getTipoConteo() {
		return tipoConteo;
	}

	public void setTipoConteo(String tipoConteo) {
		this.tipoConteo = tipoConteo;
	}

	public String getCbCaja() {
		return cbCaja;
	}

	public void setCbCaja(String cbCaja) {
		this.cbCaja = cbCaja;
	}

	@Override
	public String toString() {
		return "InventoryLayout [claveTienda=" + claveTienda + ", descTienda=" + descTienda + ", claveProducto="
				+ claveProducto + ", descProducto=" + descProducto + ", unidad=" + unidad + ", cb=" + cb + ", grupo="
				+ grupo + ", statusConteo=" + statusConteo + ", empaque=" + empaque + ", tipoConteo=" + tipoConteo
				+ ", cbCaja=" + cbCaja + "]";
	}

}
