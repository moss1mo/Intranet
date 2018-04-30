package com.shq.entities;
// Generated 10-feb-2018 22:29:04 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Unidad generated by hbm2java
 */
@Entity
@Table(name = "UNIDAD", catalog = "shq")
public class Unidad implements java.io.Serializable {

	private int id;
	private String descripcion;

	public Unidad() {
	}

	public Unidad(int id) {
		this.id = id;
	}

	public Unidad(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
