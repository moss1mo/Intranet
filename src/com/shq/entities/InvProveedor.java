package com.shq.entities;
// Generated 27-feb-2018 13:39:31 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * InvProveedor generated by hbm2java
 */
@Entity
@Table(name = "inv_proveedor", catalog = "shq")
public class InvProveedor implements java.io.Serializable {

	private Integer id;
	private Integer cantidad;
	private Integer precio;
	private Producto producto;
	private Externo externo;

	public InvProveedor() {
	}

	public InvProveedor(Integer id, Integer cantidad) {
		this.id = id;
		this.cantidad = cantidad;
	}

	public InvProveedor(Integer id, Integer cantidad, Integer precio, Producto producto, Externo externo) {
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
		this.externo = externo;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "cantidad", nullable = false, precision = 10, scale = 0)
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "precio")
	public Integer getPrecio() {
		return this.precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producto")
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_externo")
	public Externo getExterno() {
		return this.externo;
	}

	public void setExterno(Externo externo) {
		this.externo = externo;
	}

}
