package com.shq.entities;
// Generated 10-feb-2018 22:29:04 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UsuarioRol generated by hbm2java
 */
@Entity
@Table(name = "usuario_rol", catalog = "shq")
public class UsuarioRol implements java.io.Serializable {

	private BigDecimal idRol;
	private int cod;
	private String nombre;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public UsuarioRol() {
	}

	public UsuarioRol(BigDecimal idRol, int cod, String nombre) {
		this.idRol = idRol;
		this.cod = cod;
		this.nombre = nombre;
	}

	public UsuarioRol(BigDecimal idRol, int cod, String nombre, Set<Usuario> usuarios) {
		this.idRol = idRol;
		this.cod = cod;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	@Id

	@Column(name = "id_rol", unique = true, nullable = false, precision = 50, scale = 0)
	public BigDecimal getIdRol() {
		return this.idRol;
	}

	public void setIdRol(BigDecimal idRol) {
		this.idRol = idRol;
	}

	@Column(name = "cod", nullable = false)
	public int getCod() {
		return this.cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	@Column(name = "nombre", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioRol")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
