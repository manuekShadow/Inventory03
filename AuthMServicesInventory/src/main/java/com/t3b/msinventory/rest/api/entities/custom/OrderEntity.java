package com.t3b.msinventory.rest.api.entities.custom;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;


//@Entity
//@Table(name = "boa_conteos_nube")
//@IdClass(OrderEntity.class)
public class OrderEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id
	@NotNull
//	@Column(unique = true)
	private String tclave;
//	@Id
//	@Column(unique = true)
	private Date fecha;
//	@Id
//	@Column(unique = true)
    private Integer folio_conteo;
//	@Id
//	@Column(unique = true)
    private Integer iclave;
    private Integer num_conteo;
    private Integer num_scanner;
	private String cb_pieza;
    private Integer empaque;
	private Integer tipo_conteo;
    private Integer cantidad_piezas;
    private Timestamp fecha_hora_registro_producto;
    private Time hora_inicio_conteo;
    private Time hora_fin_conteo;
    private Integer status_conteo; //ESTATUS DEL CONTEO (1=ABIERTO, 2=TERMINADO, 3 = ENVIADO AL BOT)
    private String cb_caja;
    private Integer useq;
    private Timestamp hora_envio_nube;
	
    public String getTclave() {
		return tclave;
	}
	public void setTclave(String tclave) {
		this.tclave = tclave;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getFolio_conteo() {
		return folio_conteo;
	}
	public void setFolio_conteo(Integer folio_conteo) {
		this.folio_conteo = folio_conteo;
	}
	public Integer getIclave() {
		return iclave;
	}
	public void setIclave(Integer iclave) {
		this.iclave = iclave;
	}
	public Integer getNum_conteo() {
		return num_conteo;
	}
	public void setNum_conteo(Integer num_conteo) {
		this.num_conteo = num_conteo;
	}
	public Integer getNum_scanner() {
		return num_scanner;
	}
	public void setNum_scanner(Integer num_scanner) {
		this.num_scanner = num_scanner;
	}
	public String getCb_pieza() {
		return cb_pieza;
	}
	public void setCb_pieza(String cb_pieza) {
		this.cb_pieza = cb_pieza;
	}
	public Integer getEmpaque() {
		return empaque;
	}
	public void setEmpaque(Integer empaque) {
		this.empaque = empaque;
	}
	public Integer getTipo_conteo() {
		return tipo_conteo;
	}
	public void setTipo_conteo(Integer tipo_conteo) {
		this.tipo_conteo = tipo_conteo;
	}
	public Integer getCantidad_piezas() {
		return cantidad_piezas;
	}
	public void setCantidad_piezas(Integer cantidad_piezas) {
		this.cantidad_piezas = cantidad_piezas;
	}
	public Timestamp getFecha_hora_registro_producto() {
		return fecha_hora_registro_producto;
	}
	public void setFecha_hora_registro_producto(Timestamp fecha_hora_registro_producto) {
		this.fecha_hora_registro_producto = fecha_hora_registro_producto;
	}
	public Time getHora_inicio_conteo() {
		return hora_inicio_conteo;
	}
	public void setHora_inicio_conteo(Time hora_inicio_conteo) {
		this.hora_inicio_conteo = hora_inicio_conteo;
	}
	public Time getHora_fin_conteo() {
		return hora_fin_conteo;
	}
	public void setHora_fin_conteo(Time hora_fin_conteo) {
		this.hora_fin_conteo = hora_fin_conteo;
	}
	public Integer getStatus_conteo() {
		return status_conteo;
	}
	public void setStatus_conteo(Integer status_conteo) {
		this.status_conteo = status_conteo;
	}
	public String getCb_caja() {
		return cb_caja;
	}
	public void setCb_caja(String cb_caja) {
		this.cb_caja = cb_caja;
	}
	public Integer getUseq() {
		return useq;
	}
	public void setUseq(Integer useq) {
		this.useq = useq;
	}
	public Timestamp getHora_envio_nube() {
		return hora_envio_nube;
	}
	public void setHora_envio_nube(Timestamp hora_envio_nube) {
		this.hora_envio_nube = hora_envio_nube;
	}
	public OrderEntity(String tclave, Date fecha, Integer folio_conteo, Integer iclave, Integer num_conteo,
			Integer num_scanner, String cb_pieza, Integer empaque, Integer tipo_conteo, Integer cantidad_piezas,
			Timestamp fecha_hora_registro_producto, Time hora_inicio_conteo, Time hora_fin_conteo,
			Integer status_conteo, String cb_caja, Integer useq, Timestamp hora_envio_nube) {
		super();
		this.tclave = tclave;
		this.fecha = fecha;
		this.folio_conteo = folio_conteo;
		this.iclave = iclave;
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
	@Override
	public String toString() {
		return "Order [tclave=" + tclave + ", fecha=" + fecha + ", folio_conteo=" + folio_conteo + ", iclave="
				+ iclave + ", num_conteo=" + num_conteo + ", num_scanner=" + num_scanner + ", cb_pieza=" + cb_pieza
				+ ", empaque=" + empaque + ", tipo_conteo=" + tipo_conteo + ", cantidad_piezas=" + cantidad_piezas
				+ ", fecha_hora_registro_producto=" + fecha_hora_registro_producto + ", hora_inicio_conteo="
				+ hora_inicio_conteo + ", hora_fin_conteo=" + hora_fin_conteo + ", status_conteo=" + status_conteo
				+ ", cb_caja=" + cb_caja + ", useq=" + useq + ", hora_envio_nube=" + hora_envio_nube + "]";
	}
	
	public OrderEntity() {
			// TODO Auto-generated constructor stub
	}

}
