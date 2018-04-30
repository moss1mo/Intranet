package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.util.Date;

public class UsuarioBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private String contrasena; 
	private int idUsuario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private String telCelular;
	private String telCasa;
	private String telTrabajo;
	private String telExtension;
	private Date fechaNacimiento;
	
	private int rolUsuario;
	private boolean usuarioDeCambios;
	private boolean desarrollador;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelCelular() {
		return telCelular;
	}
	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}
	public String getTelCasa() {
		return telCasa;
	}
	public void setTelCasa(String telCasa) {
		this.telCasa = telCasa;
	}
	public String getTelTrabajo() {
		return telTrabajo;
	}
	public void setTelTrabajo(String telTrabajo) {
		this.telTrabajo = telTrabajo;
	}
	public String getTelExtension() {
		return telExtension;
	}
	public void setTelExtension(String telExtension) {
		this.telExtension = telExtension;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public boolean isUsuarioDeCambios() {
		return usuarioDeCambios;
	}
	public void setUsuarioDeCambios(boolean usuarioDeCambios) {
		this.usuarioDeCambios = usuarioDeCambios;
	}
	public boolean isDesarrollador() {
		return desarrollador;
	}
	public void setDesarrollador(boolean desarrollador) {
		this.desarrollador = desarrollador;
	}
	public int getRolUsuario() {
		return rolUsuario;
	}
	public void setRolUsuario(int rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
