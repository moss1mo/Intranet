package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AlmacenBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String direccion;
	private String nombre;
	
	private String tipoAlmacen;
	private Date fechaFinAlmacen;
	private String nombreContacto;
	private String telContacto;
	private String correoContacto;
	private String horarioAtencion;
	
	private List<MovimientoInventarioBean> movimientosInventario;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<MovimientoInventarioBean> getMovimientosInventario() {
		return movimientosInventario;
	}
	public void setMovimientosInventario(List<MovimientoInventarioBean> movimientosInventario) {
		this.movimientosInventario = movimientosInventario;
	}
	public String getTipoAlmacen() {
		return tipoAlmacen;
	}
	public void setTipoAlmacen(String tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}
	public Date getFechaFinAlmacen() {
		return fechaFinAlmacen;
	}
	public void setFechaFinAlmacen(Date fechaFinAlmacen) {
		this.fechaFinAlmacen = fechaFinAlmacen;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getTelContacto() {
		return telContacto;
	}
	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}
	public String getCorreoContacto() {
		return correoContacto;
	}
	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}
	public String getHorarioAtencion() {
		return horarioAtencion;
	}
	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}
	
	
	
}
