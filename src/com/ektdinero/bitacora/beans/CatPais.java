package com.ektdinero.bitacora.beans;

import java.io.Serializable;

public class CatPais implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pais;
	private String pais_cod;
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPais_cod() {
		return pais_cod;
	}
	public void setPais_cod(String pais_cod) {
		this.pais_cod = pais_cod;
	}
	
	
	
}
