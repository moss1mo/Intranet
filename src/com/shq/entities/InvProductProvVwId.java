package com.shq.entities;
// Generated 17-abr-2018 11:24:42 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvProductProvVwId generated by hbm2java
 */
@Embeddable
public class InvProductProvVwId implements java.io.Serializable {

	private String producto;
	private BigDecimal precio;
	private long cantidad;
	private String proveedor;
	private String nombreContacto;
	private String telContacto;
	private String correoContacto;

	public InvProductProvVwId() {
	}

	public InvProductProvVwId(long cantidad) {
		this.cantidad = cantidad;
	}

	public InvProductProvVwId(String producto, BigDecimal precio, long cantidad, String proveedor,
			String nombreContacto, String telContacto, String correoContacto) {
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.proveedor = proveedor;
		this.nombreContacto = nombreContacto;
		this.telContacto = telContacto;
		this.correoContacto = correoContacto;
	}

	@Column(name = "producto")
	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	@Column(name = "precio")
	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Column(name = "cantidad", nullable = false, precision = 10, scale = 0)
	public long getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "proveedor")
	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Column(name = "nombre_contacto")
	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	@Column(name = "tel_contacto", length = 50)
	public String getTelContacto() {
		return this.telContacto;
	}

	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}

	@Column(name = "correo_contacto", length = 100)
	public String getCorreoContacto() {
		return this.correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InvProductProvVwId))
			return false;
		InvProductProvVwId castOther = (InvProductProvVwId) other;

		return ((this.getProducto() == castOther.getProducto()) || (this.getProducto() != null
				&& castOther.getProducto() != null && this.getProducto().equals(castOther.getProducto())))
				&& ((this.getPrecio() == castOther.getPrecio()) || (this.getPrecio() != null
						&& castOther.getPrecio() != null && this.getPrecio().equals(castOther.getPrecio())))
				&& (this.getCantidad() == castOther.getCantidad())
				&& ((this.getProveedor() == castOther.getProveedor()) || (this.getProveedor() != null
						&& castOther.getProveedor() != null && this.getProveedor().equals(castOther.getProveedor())))
				&& ((this.getNombreContacto() == castOther.getNombreContacto())
						|| (this.getNombreContacto() != null && castOther.getNombreContacto() != null
								&& this.getNombreContacto().equals(castOther.getNombreContacto())))
				&& ((this.getTelContacto() == castOther.getTelContacto())
						|| (this.getTelContacto() != null && castOther.getTelContacto() != null
								&& this.getTelContacto().equals(castOther.getTelContacto())))
				&& ((this.getCorreoContacto() == castOther.getCorreoContacto())
						|| (this.getCorreoContacto() != null && castOther.getCorreoContacto() != null
								&& this.getCorreoContacto().equals(castOther.getCorreoContacto())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProducto() == null ? 0 : this.getProducto().hashCode());
		result = 37 * result + (getPrecio() == null ? 0 : this.getPrecio().hashCode());
		result = 37 * result + (int) this.getCantidad();
		result = 37 * result + (getProveedor() == null ? 0 : this.getProveedor().hashCode());
		result = 37 * result + (getNombreContacto() == null ? 0 : this.getNombreContacto().hashCode());
		result = 37 * result + (getTelContacto() == null ? 0 : this.getTelContacto().hashCode());
		result = 37 * result + (getCorreoContacto() == null ? 0 : this.getCorreoContacto().hashCode());
		return result;
	}

}
