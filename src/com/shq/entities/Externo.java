package com.shq.entities;
// Generated 17-abr-2018 11:49:46 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
 * Externo generated by hbm2java
 */
@Entity
@Table(name = "externo", catalog = "shq")
public class Externo implements java.io.Serializable {

	private BigDecimal idExterno;
	private String clave;
	private String correoContacto;
	private Date fechaAlta;
	private String nombre;
	private String nombreContacto;
	private String rfc;
	private String telContacto;
	private Boolean activo;
	private Set<MovInventario> movInventarios = new HashSet<MovInventario>(0);
	private Set<CotizacionProveedor> cotizacionProveedors = new HashSet<CotizacionProveedor>(0);
	private Set<InvProveedor> invProveedors = new HashSet<InvProveedor>(0);
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private Set<CuentaBanco> cuentasBanco = new HashSet<CuentaBanco>(0);
	private Set<Domicilio> domicilios = new HashSet<Domicilio>(0);


	public Externo() {
	}

	public Externo(BigDecimal idExterno, Boolean activo, Boolean isCliente, Boolean isProveedor) {
		this.idExterno = idExterno;
		this.activo = activo;
	}

	public Externo(BigDecimal idExterno, Domicilio domicilio, String clave, String correoContacto, Date fechaAlta,
			String nombre, String nombreContacto, String rfc, String telContacto, Boolean activo, Boolean isCliente,
			Boolean isProveedor, Set<MovInventario> movInventarios, Set<CotizacionProveedor> cotizacionProveedors,
			Set<InvProveedor> invProveedors, Set<Usuario> usuarios, Set<CuentaBanco> cuentasBanco,Set<Domicilio> domicilios) {
		this.idExterno = idExterno;
		this.domicilios = domicilios;
		this.clave = clave;
		this.correoContacto = correoContacto;
		this.fechaAlta = fechaAlta;
		this.nombre = nombre;
		this.nombreContacto = nombreContacto;
		this.rfc = rfc;
		this.telContacto = telContacto;
		this.cuentasBanco = cuentasBanco;
		this.activo = activo;
		this.movInventarios = movInventarios;
		this.cotizacionProveedors = cotizacionProveedors;
		this.invProveedors = invProveedors;
		this.usuarios = usuarios;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id_externo", unique = true, nullable = false, precision = 50, scale = 0)
	public BigDecimal getIdExterno() {
		return this.idExterno;
	}

	public void setIdExterno(BigDecimal idExterno) {
		this.idExterno = idExterno;
	}

	@Column(name = "clave", length = 50)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "correo_contacto", length = 100)
	public String getCorreoContacto() {
		return this.correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_alta", length = 19)
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "nombre_contacto")
	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	@Column(name = "rfc", length = 50)
	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Column(name = "tel_contacto", length = 50)
	public String getTelContacto() {
		return this.telContacto;
	}

	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}

	@Column(name = "activo", nullable = false)
	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "externo")
	public Set<MovInventario> getMovInventarios() {
		return this.movInventarios;
	}

	public void setMovInventarios(Set<MovInventario> movInventarios) {
		this.movInventarios = movInventarios;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "externo")
	public Set<CotizacionProveedor> getCotizacionProveedors() {
		return this.cotizacionProveedors;
	}

	public void setCotizacionProveedors(Set<CotizacionProveedor> cotizacionProveedors) {
		this.cotizacionProveedors = cotizacionProveedors;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "externo")
	public Set<InvProveedor> getInvProveedors() {
		return this.invProveedors;
	}

	public void setInvProveedors(Set<InvProveedor> invProveedors) {
		this.invProveedors = invProveedors;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "externo")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "externo")
	public Set<CuentaBanco> getCuentasBanco() {
		return cuentasBanco;
	}

	public void setCuentasBanco(Set<CuentaBanco> cuentasBanco) {
		this.cuentasBanco = cuentasBanco;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "externo")
    public Set<Domicilio> getDomicilios() {
        return this.domicilios;
    }
    
    public void setDomicilios(Set<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

}
