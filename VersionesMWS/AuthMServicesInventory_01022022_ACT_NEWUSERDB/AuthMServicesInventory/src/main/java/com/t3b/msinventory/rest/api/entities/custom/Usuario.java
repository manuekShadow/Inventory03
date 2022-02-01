package com.t3b.msinventory.rest.api.entities.custom;

import java.sql.Date;

//import javax.persistence.Column;

import io.micrometer.core.lang.NonNull;

public class Usuario {
	
	private int useq;
	private String ulogin;
	private String unombre;
	private String uapellidop;
	private String uapellidom;
	private String upassword;
	private String uarea;
	private String utelefono;
	private String uext;
	private String umail;
	private Date ufechacambio;
	private Date ufechainactivo;
	@NonNull
	private String uclavegrupo;
	@NonNull
	private String tclave;
	@NonNull
	private Number nempleado;
	@NonNull
	private String usuario_alm;
	
	private Integer ptoclave;
	@NonNull
	private String upuesto;
	private String uclaveasistencias;
	@NonNull
	private Date fecha_alta;
	@NonNull
	private Date fecha_baja;
	@NonNull
	private Date fecha_acceso;
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	public String getUlogin() {
		return ulogin;
	}
	public void setUlogin(String ulogin) {
		this.ulogin = ulogin;
	}
	public String getUnombre() {
		return unombre;
	}
	public void setUnombre(String unombre) {
		this.unombre = unombre;
	}
	public String getUapellidop() {
		return uapellidop;
	}
	public void setUapellidop(String uapellidop) {
		this.uapellidop = uapellidop;
	}
	public String getUapellidom() {
		return uapellidom;
	}
	public void setUapellidom(String uapellidom) {
		this.uapellidom = uapellidom;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUarea() {
		return uarea;
	}
	public void setUarea(String uarea) {
		this.uarea = uarea;
	}
	public String getUtelefono() {
		return utelefono;
	}
	public void setUtelefono(String utelefono) {
		this.utelefono = utelefono;
	}
	public String getUext() {
		return uext;
	}
	public void setUext(String uext) {
		this.uext = uext;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public Date getUfechacambio() {
		return ufechacambio;
	}
	public void setUfechacambio(Date ufechacambio) {
		this.ufechacambio = ufechacambio;
	}
	public Date getUfechainactivo() {
		return ufechainactivo;
	}
	public void setUfechainactivo(Date ufechainactivo) {
		this.ufechainactivo = ufechainactivo;
	}
	public String getUclavegrupo() {
		return uclavegrupo;
	}
	public void setUclavegrupo(String uclavegrupo) {
		this.uclavegrupo = uclavegrupo;
	}
	public String getTclave() {
		return tclave;
	}
	public void setTclave(String tclave) {
		this.tclave = tclave;
	}
	public Number getNempleado() {
		return nempleado;
	}
	public void setNempleado(Number nempleado) {
		this.nempleado = nempleado;
	}
	public String getUsuario_alm() {
		return usuario_alm;
	}
	public void setUsuario_alm(String usuario_alm) {
		this.usuario_alm = usuario_alm;
	}
	
	public String getUpuesto() {
		return upuesto;
	}
	public void setUpuesto(String upuesto) {
		this.upuesto = upuesto;
	}
	public String getUclaveasistencias() {
		return uclaveasistencias;
	}
	public void setUclaveasistencias(String uclaveasistencias) {
		this.uclaveasistencias = uclaveasistencias;
	}
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public Date getFecha_acceso() {
		return fecha_acceso;
	}
	public void setFecha_acceso(Date fecha_acceso) {
		this.fecha_acceso = fecha_acceso;
	}
	
	//@Column(name = "ptoclave", nullable = false)
	public Integer getPtoclave() {
		return ptoclave;
	}
	public void setPtoclave(Integer ptoclave) {
		this.ptoclave = ptoclave;
	}
		
}