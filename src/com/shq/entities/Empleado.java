package com.shq.entities;
// Generated 10-feb-2018 21:58:23 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Empleado generated by hbm2java
 */
@Entity
@Table(name = "empleado", catalog = "shq")
public class Empleado implements java.io.Serializable {

	private BigDecimal idEmpleado;
	private Domicilio domicilio;
	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private Date fechaNacimiento;
	private String direccion;
	private String emailEmpresa;
	private String emailPersonal;
	private String telCasa;
	private String telCelular;
	private String telExt;
	private String telTrabajo;
	private String puesto;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Empleado() {
	}

	public Empleado(BigDecimal idEmpleado, String nombre) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
	}

	public Empleado(BigDecimal idEmpleado, Domicilio domicilio, String nombre, String apellidoMaterno,
			String apellidoPaterno, Date fechaNacimiento, String direccion, String emailEmpresa, String emailPersonal,
			String telCasa, String telCelular, String telExt, String telTrabajo, String puesto, Set<Usuario> usuarios) {
		this.idEmpleado = idEmpleado;
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.emailEmpresa = emailEmpresa;
		this.emailPersonal = emailPersonal;
		this.telCasa = telCasa;
		this.telCelular = telCelular;
		this.telExt = telExt;
		this.telTrabajo = telTrabajo;
		this.puesto = puesto;
		this.usuarios = usuarios;
	}

	@Id

	@Column(name = "id_empleado", unique = true, nullable = false, precision = 50, scale = 0)
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public BigDecimal getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(BigDecimal idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_domicilio") 
	public Domicilio getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Column(name = "nombre", nullable = false, length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido_materno", length = 30)
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	@Column(name = "apellido_paterno", length = 30)
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento", length = 10)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Column(name = "direccion", length = 100)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "email_empresa", length = 20)
	public String getEmailEmpresa() {
		return this.emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	@Column(name = "email_personal", length = 20)
	public String getEmailPersonal() {
		return this.emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	@Column(name = "tel_casa", length = 20)
	public String getTelCasa() {
		return this.telCasa;
	}

	public void setTelCasa(String telCasa) {
		this.telCasa = telCasa;
	}

	@Column(name = "tel_celular", length = 20)
	public String getTelCelular() {
		return this.telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	@Column(name = "tel_ext", length = 20)
	public String getTelExt() {
		return this.telExt;
	}

	public void setTelExt(String telExt) {
		this.telExt = telExt;
	}

	@Column(name = "tel_trabajo", length = 20)
	public String getTelTrabajo() {
		return this.telTrabajo;
	}

	public void setTelTrabajo(String telTrabajo) {
		this.telTrabajo = telTrabajo;
	}

	@Column(name = "puesto", length = 50)
	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
