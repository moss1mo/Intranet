package com.ektdinero.bitacora.beans;

import java.io.Serializable;

public class CatEstado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estado;
	private String estado_cod;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado_cod() {
		return estado_cod;
	}
	public void setEstado_cod(String estado_cod) {
		this.estado_cod = estado_cod;
	}
	

	
	
}
