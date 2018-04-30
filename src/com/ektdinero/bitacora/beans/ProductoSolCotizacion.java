package com.ektdinero.bitacora.beans;

import java.io.Serializable;

import com.shq.entities.Producto;

public class ProductoSolCotizacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Producto producto;
	private Long cantidad;
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
