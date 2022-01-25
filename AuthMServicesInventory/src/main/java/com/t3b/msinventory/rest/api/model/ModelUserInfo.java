package com.t3b.msinventory.rest.api.model;

import java.io.Serializable;

import com.t3b.msinventory.rest.api.entities.custom.Usuario;

public class ModelUserInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int code;
	private String mensaje;
	private boolean status;
	private Usuario userInfoResponse;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Usuario getUserInfoResponse() {
		return userInfoResponse;
	}
	public void setUserInfoResponse(Usuario userInfoResponse) {
		this.userInfoResponse = userInfoResponse;
	}
	

}