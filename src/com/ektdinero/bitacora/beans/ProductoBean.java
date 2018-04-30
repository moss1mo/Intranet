package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.util.List;

public class ProductoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int id;
	private String clave;
	private String especificaciones;
	private String producto;
	private List<InventarioBean> inventarios;
	private List<MovimientoInventarioBean> movimientosInventario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getEspecificaciones() {
		return especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public List<InventarioBean> getInventarios() {
		return inventarios;
	}
	public void setInventarios(List<InventarioBean> inventarios) {
		this.inventarios = inventarios;
	}
	public List<MovimientoInventarioBean> getMovimientosInventario() {
		return movimientosInventario;
	}
	public void setMovimientosInventario(List<MovimientoInventarioBean> movimientosInventario) {
		this.movimientosInventario = movimientosInventario;
	}
}
