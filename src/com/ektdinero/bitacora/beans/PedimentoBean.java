package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PedimentoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String aduana;
	private String ciudad;
	private Date fechaEntrada;
	private String pedimento;
	private List<MovimientoInventarioBean> movimientosInventario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAduana() {
		return aduana;
	}
	public void setAduana(String aduana) {
		this.aduana = aduana;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getPedimento() {
		return pedimento;
	}
	public void setPedimento(String pedimento) {
		this.pedimento = pedimento;
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
