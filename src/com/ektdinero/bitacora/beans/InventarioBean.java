 package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class InventarioBean implements Serializable	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int cantidad;
	private BigDecimal costoProm;
	private BigDecimal precioProm;
	private ProductoBean producto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getCostoProm() {
		return costoProm;
	}
	public void setCostoProm(BigDecimal costoProm) {
		this.costoProm = costoProm;
	}
	public BigDecimal getPrecioProm() {
		return precioProm;
	}
	public void setPrecioProm(BigDecimal precioProm) {
		this.precioProm = precioProm;
	}
	public ProductoBean getProducto() {
		return producto;
	}
	public void setProducto(ProductoBean producto) {
		this.producto = producto;
	}

}
