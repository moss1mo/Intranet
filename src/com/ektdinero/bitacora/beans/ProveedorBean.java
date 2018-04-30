package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProveedorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String clave;
	private String correoContacto;
	private String direccion;
	private Date fechaAlta;
	private String nombre;
	private String nombreContacto;
	private String rfc;
	private String telContacto;
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
	public String getCorreoContacto() {
		return correoContacto;
	}
	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTelContacto() {
		return telContacto;
	}
	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
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
