package com.shq.entities;
// Generated 10-feb-2018 22:29:04 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CatPaisesId generated by hbm2java
 */
@Embeddable
public class CatPaisesId implements java.io.Serializable {

	private String nombre;
	private String name;
	private String nom;
	private String iso;
	private String isoTres;
	private Integer phoneCode;

	public CatPaisesId() {
	}

	public CatPaisesId(String nombre, String name, String nom, String iso, String isoTres, Integer phoneCode) {
		this.nombre = nombre;
		this.name = name;
		this.nom = nom;
		this.iso = iso;
		this.isoTres = isoTres;
		this.phoneCode = phoneCode;
	}

	@Column(name = "nombre", length = 65535)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "name", length = 65535)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "nom", length = 65535)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "iso", length = 65535)
	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	@Column(name = "iso_tres", length = 65535)
	public String getIsoTres() {
		return this.isoTres;
	}

	public void setIsoTres(String isoTres) {
		this.isoTres = isoTres;
	}

	@Column(name = "phone_code")
	public Integer getPhoneCode() {
		return this.phoneCode;
	}

	public void setPhoneCode(Integer phoneCode) {
		this.phoneCode = phoneCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CatPaisesId))
			return false;
		CatPaisesId castOther = (CatPaisesId) other;

		return ((this.getNombre() == castOther.getNombre()) || (this.getNombre() != null
				&& castOther.getNombre() != null && this.getNombre().equals(castOther.getNombre())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null
						&& this.getName().equals(castOther.getName())))
				&& ((this.getNom() == castOther.getNom()) || (this.getNom() != null && castOther.getNom() != null
						&& this.getNom().equals(castOther.getNom())))
				&& ((this.getIso() == castOther.getIso()) || (this.getIso() != null && castOther.getIso() != null
						&& this.getIso().equals(castOther.getIso())))
				&& ((this.getIsoTres() == castOther.getIsoTres()) || (this.getIsoTres() != null
						&& castOther.getIsoTres() != null && this.getIsoTres().equals(castOther.getIsoTres())))
				&& ((this.getPhoneCode() == castOther.getPhoneCode()) || (this.getPhoneCode() != null
						&& castOther.getPhoneCode() != null && this.getPhoneCode().equals(castOther.getPhoneCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getNombre() == null ? 0 : this.getNombre().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getNom() == null ? 0 : this.getNom().hashCode());
		result = 37 * result + (getIso() == null ? 0 : this.getIso().hashCode());
		result = 37 * result + (getIsoTres() == null ? 0 : this.getIsoTres().hashCode());
		result = 37 * result + (getPhoneCode() == null ? 0 : this.getPhoneCode().hashCode());
		return result;
	}

}
