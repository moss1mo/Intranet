package com.ektdinero.bitacora.beans;

import java.io.Serializable;

import com.shq.entities.InventarioLotesVw;

public class ProductoSolCotizacionLote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InventarioLotesVw productoInvLote;
	private Long cantidad;
	
	public ProductoSolCotizacionLote(InventarioLotesVw productoInvLote){
		this.productoInvLote = productoInvLote;
	}
	public InventarioLotesVw getProductoInvLote() {
		return productoInvLote;
	}
	public void setProductoInvLote(InventarioLotesVw productoInvLote) {
		this.productoInvLote = productoInvLote;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
