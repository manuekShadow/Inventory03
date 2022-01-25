package com.t3b.msinventory.rest.api.entities.custom;

public class InfoOrderInsert {
	
	private String tclave;
    private String fecha;
    private String folio_conteo;
    private String iclave;
    private String id_scanner;
    private String num_conteo;
    private String num_scanner;
	private String cb_pieza;
    private String empaque;
	private String tipo_conteo;
    private String cantidad_piezas;
    private String fecha_hora_registro_producto;
    private String hora_inicio_conteo;
    private String hora_fin_conteo;
    private String status_conteo; //ESTATUS DEL CONTEO (1=ABIERTO, 2=TERMINADO, 3 = ENVIADO AL BOT)
    private String cb_caja;
    private String useq;
    private String hora_envio_nube;
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
	public String getNum_conteo() {
		return num_conteo;
	}
	public void setNum_conteo(String num_conteo) {
		this.num_conteo = num_conteo;
	}
	public String getNum_scanner() {
		return num_scanner;
	}
	public void setNum_scanner(String num_scanner) {
		this.num_scanner = num_scanner;
	}
	public String getCb_pieza() {
		return cb_pieza;
	}
	public void setCb_pieza(String cb_pieza) {
		this.cb_pieza = cb_pieza;
	}
	public String getEmpaque() {
		return empaque;
	}
	public void setEmpaque(String empaque) {
		this.empaque = empaque;
	}
	public String getTipo_conteo() {
		return tipo_conteo;
	}
	public void setTipo_conteo(String tipo_conteo) {
		this.tipo_conteo = tipo_conteo;
	}
	public String getCantidad_piezas() {
		return cantidad_piezas;
	}
	public void setCantidad_piezas(String cantidad_piezas) {
		this.cantidad_piezas = cantidad_piezas;
	}
	public String getFecha_hora_registro_producto() {
		return fecha_hora_registro_producto;
	}
	public void setFecha_hora_registro_producto(String fecha_hora_registro_producto) {
		this.fecha_hora_registro_producto = fecha_hora_registro_producto;
	}
	public String getHora_inicio_conteo() {
		return hora_inicio_conteo;
	}
	public void setHora_inicio_conteo(String hora_inicio_conteo) {
		this.hora_inicio_conteo = hora_inicio_conteo;
	}
	public String getHora_fin_conteo() {
		return hora_fin_conteo;
	}
	public void setHora_fin_conteo(String hora_fin_conteo) {
		this.hora_fin_conteo = hora_fin_conteo;
	}
	public String getStatus_conteo() {
		return status_conteo;
	}
	public void setStatus_conteo(String status_conteo) {
		this.status_conteo = status_conteo;
	}
	public String getCb_caja() {
		return cb_caja;
	}
	public void setCb_caja(String cb_caja) {
		this.cb_caja = cb_caja;
	}
	public String getUseq() {
		return useq;
	}
	public void setUseq(String useq) {
		this.useq = useq;
	}
	public String getHora_envio_nube() {
		return hora_envio_nube;
	}
	public void setHora_envio_nube(String hora_envio_nube) {
		this.hora_envio_nube = hora_envio_nube;
	}

	public String getId_scanner() {
		return id_scanner;
	}
	public void setId_scanner(String id_scanner) {
		this.id_scanner = id_scanner;
	}
	@Override
	public String toString() {
		return "InfoOrderInsert [tclave=" + tclave + ", fecha=" + fecha + ", folio_conteo=" + folio_conteo + ", iclave="
				+ iclave + ", id_scanner=" + id_scanner + ", num_conteo=" + num_conteo + ", num_scanner=" + num_scanner
				+ ", cb_pieza=" + cb_pieza + ", empaque=" + empaque + ", tipo_conteo=" + tipo_conteo
				+ ", cantidad_piezas=" + cantidad_piezas + ", fecha_hora_registro_producto="
				+ fecha_hora_registro_producto + ", hora_inicio_conteo=" + hora_inicio_conteo + ", hora_fin_conteo="
				+ hora_fin_conteo + ", status_conteo=" + status_conteo + ", cb_caja=" + cb_caja + ", useq=" + useq
				+ ", hora_envio_nube=" + hora_envio_nube + "]";
	}
	
	public InfoOrderInsert(String tclave, String fecha, String folio_conteo, String iclave, String id_scanner,
			String num_conteo, String num_scanner, String cb_pieza, String empaque, String tipo_conteo,
			String cantidad_piezas, String fecha_hora_registro_producto, String hora_inicio_conteo,
			String hora_fin_conteo, String status_conteo, String cb_caja, String useq, String hora_envio_nube) {
		super();
		this.tclave = tclave;
		this.fecha = fecha;
		this.folio_conteo = folio_conteo;
		this.iclave = iclave;
		this.id_scanner = id_scanner;
		this.num_conteo = num_conteo;
		this.num_scanner = num_scanner;
		this.cb_pieza = cb_pieza;
		this.empaque = empaque;
		this.tipo_conteo = tipo_conteo;
		this.cantidad_piezas = cantidad_piezas;
		this.fecha_hora_registro_producto = fecha_hora_registro_producto;
		this.hora_inicio_conteo = hora_inicio_conteo;
		this.hora_fin_conteo = hora_fin_conteo;
		this.status_conteo = status_conteo;
		this.cb_caja = cb_caja;
		this.useq = useq;
		this.hora_envio_nube = hora_envio_nube;
	}
	public InfoOrderInsert() {
		super();
	}
    
    

}
