package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.util.List;

public class UnidadBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descripcion;
	private List<MovimientoInventarioBean> movimientosInventario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<MovimientoInventarioBean> getMovimientosInventario() {
		return movimientosInventario;
	}
	public void setMovimientosInventario(List<MovimientoInventarioBean> movimientosInventario) {
		this.movimientosInventario = movimientosInventario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
