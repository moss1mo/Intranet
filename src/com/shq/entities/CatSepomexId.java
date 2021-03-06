package com.shq.entities;
// Generated 10-feb-2018 22:29:04 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CatSepomexId generated by hbm2java
 */
@Embeddable
public class CatSepomexId implements java.io.Serializable {

	private String DCodigo;
	private String DAsenta;
	private String DTipoAsenta;
	private String DMnpio;
	private String DEstado;
	private String DCiudad;
	private String DCp;
	private String CEstado;
	private String COficina;
	private String CCp;
	private String CTipoAsenta;
	private String CMnpio;
	private String idAsentaCpcons;
	private String DZona;
	private String CCveCiudad;

	public CatSepomexId() {
	}

	public CatSepomexId(String DCodigo, String DAsenta, String DTipoAsenta, String DMnpio, String DEstado,
			String DCiudad, String DCp, String CEstado, String COficina, String CCp, String CTipoAsenta, String CMnpio,
			String idAsentaCpcons, String DZona, String CCveCiudad) {
		this.DCodigo = DCodigo;
		this.DAsenta = DAsenta;
		this.DTipoAsenta = DTipoAsenta;
		this.DMnpio = DMnpio;
		this.DEstado = DEstado;
		this.DCiudad = DCiudad;
		this.DCp = DCp;
		this.CEstado = CEstado;
		this.COficina = COficina;
		this.CCp = CCp;
		this.CTipoAsenta = CTipoAsenta;
		this.CMnpio = CMnpio;
		this.idAsentaCpcons = idAsentaCpcons;
		this.DZona = DZona;
		this.CCveCiudad = CCveCiudad;
	}

	@Column(name = "d_codigo", length = 65535)
	public String getDCodigo() {
		return this.DCodigo;
	}

	public void setDCodigo(String DCodigo) {
		this.DCodigo = DCodigo;
	}

	@Column(name = "d_asenta", length = 65535)
	public String getDAsenta() {
		return this.DAsenta;
	}

	public void setDAsenta(String DAsenta) {
		this.DAsenta = DAsenta;
	}

	@Column(name = "d_tipo_asenta", length = 65535)
	public String getDTipoAsenta() {
		return this.DTipoAsenta;
	}

	public void setDTipoAsenta(String DTipoAsenta) {
		this.DTipoAsenta = DTipoAsenta;
	}

	@Column(name = "D_mnpio", length = 65535)
	public String getDMnpio() {
		return this.DMnpio;
	}

	public void setDMnpio(String DMnpio) {
		this.DMnpio = DMnpio;
	}

	@Column(name = "d_estado", length = 65535)
	public String getDEstado() {
		return this.DEstado;
	}

	public void setDEstado(String DEstado) {
		this.DEstado = DEstado;
	}

	@Column(name = "d_ciudad", length = 65535)
	public String getDCiudad() {
		return this.DCiudad;
	}

	public void setDCiudad(String DCiudad) {
		this.DCiudad = DCiudad;
	}

	@Column(name = "d_CP", length = 65535)
	public String getDCp() {
		return this.DCp;
	}

	public void setDCp(String DCp) {
		this.DCp = DCp;
	}

	@Column(name = "c_estado", length = 65535)
	public String getCEstado() {
		return this.CEstado;
	}

	public void setCEstado(String CEstado) {
		this.CEstado = CEstado;
	}

	@Column(name = "c_oficina", length = 65535)
	public String getCOficina() {
		return this.COficina;
	}

	public void setCOficina(String COficina) {
		this.COficina = COficina;
	}

	@Column(name = "c_CP", length = 65535)
	public String getCCp() {
		return this.CCp;
	}

	public void setCCp(String CCp) {
		this.CCp = CCp;
	}

	@Column(name = "c_tipo_asenta", length = 65535)
	public String getCTipoAsenta() {
		return this.CTipoAsenta;
	}

	public void setCTipoAsenta(String CTipoAsenta) {
		this.CTipoAsenta = CTipoAsenta;
	}

	@Column(name = "c_mnpio", length = 65535)
	public String getCMnpio() {
		return this.CMnpio;
	}

	public void setCMnpio(String CMnpio) {
		this.CMnpio = CMnpio;
	}

	@Column(name = "id_asenta_cpcons", length = 65535)
	public String getIdAsentaCpcons() {
		return this.idAsentaCpcons;
	}

	public void setIdAsentaCpcons(String idAsentaCpcons) {
		this.idAsentaCpcons = idAsentaCpcons;
	}

	@Column(name = "d_zona", length = 65535)
	public String getDZona() {
		return this.DZona;
	}

	public void setDZona(String DZona) {
		this.DZona = DZona;
	}

	@Column(name = "c_cve_ciudad", length = 65535)
	public String getCCveCiudad() {
		return this.CCveCiudad;
	}

	public void setCCveCiudad(String CCveCiudad) {
		this.CCveCiudad = CCveCiudad;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CatSepomexId))
			return false;
		CatSepomexId castOther = (CatSepomexId) other;

		return ((this.getDCodigo() == castOther.getDCodigo()) || (this.getDCodigo() != null
				&& castOther.getDCodigo() != null && this.getDCodigo().equals(castOther.getDCodigo())))
				&& ((this.getDAsenta() == castOther.getDAsenta()) || (this.getDAsenta() != null
						&& castOther.getDAsenta() != null && this.getDAsenta().equals(castOther.getDAsenta())))
				&& ((this.getDTipoAsenta() == castOther.getDTipoAsenta())
						|| (this.getDTipoAsenta() != null && castOther.getDTipoAsenta() != null
								&& this.getDTipoAsenta().equals(castOther.getDTipoAsenta())))
				&& ((this.getDMnpio() == castOther.getDMnpio()) || (this.getDMnpio() != null
						&& castOther.getDMnpio() != null && this.getDMnpio().equals(castOther.getDMnpio())))
				&& ((this.getDEstado() == castOther.getDEstado()) || (this.getDEstado() != null
						&& castOther.getDEstado() != null && this.getDEstado().equals(castOther.getDEstado())))
				&& ((this.getDCiudad() == castOther.getDCiudad()) || (this.getDCiudad() != null
						&& castOther.getDCiudad() != null && this.getDCiudad().equals(castOther.getDCiudad())))
				&& ((this.getDCp() == castOther.getDCp()) || (this.getDCp() != null && castOther.getDCp() != null
						&& this.getDCp().equals(castOther.getDCp())))
				&& ((this.getCEstado() == castOther.getCEstado()) || (this.getCEstado() != null
						&& castOther.getCEstado() != null && this.getCEstado().equals(castOther.getCEstado())))
				&& ((this.getCOficina() == castOther.getCOficina()) || (this.getCOficina() != null
						&& castOther.getCOficina() != null && this.getCOficina().equals(castOther.getCOficina())))
				&& ((this.getCCp() == castOther.getCCp()) || (this.getCCp() != null && castOther.getCCp() != null
						&& this.getCCp().equals(castOther.getCCp())))
				&& ((this.getCTipoAsenta() == castOther.getCTipoAsenta())
						|| (this.getCTipoAsenta() != null && castOther.getCTipoAsenta() != null
								&& this.getCTipoAsenta().equals(castOther.getCTipoAsenta())))
				&& ((this.getCMnpio() == castOther.getCMnpio()) || (this.getCMnpio() != null
						&& castOther.getCMnpio() != null && this.getCMnpio().equals(castOther.getCMnpio())))
				&& ((this.getIdAsentaCpcons() == castOther.getIdAsentaCpcons())
						|| (this.getIdAsentaCpcons() != null && castOther.getIdAsentaCpcons() != null
								&& this.getIdAsentaCpcons().equals(castOther.getIdAsentaCpcons())))
				&& ((this.getDZona() == castOther.getDZona()) || (this.getDZona() != null
						&& castOther.getDZona() != null && this.getDZona().equals(castOther.getDZona())))
				&& ((this.getCCveCiudad() == castOther.getCCveCiudad())
						|| (this.getCCveCiudad() != null && castOther.getCCveCiudad() != null
								&& this.getCCveCiudad().equals(castOther.getCCveCiudad())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDCodigo() == null ? 0 : this.getDCodigo().hashCode());
		result = 37 * result + (getDAsenta() == null ? 0 : this.getDAsenta().hashCode());
		result = 37 * result + (getDTipoAsenta() == null ? 0 : this.getDTipoAsenta().hashCode());
		result = 37 * result + (getDMnpio() == null ? 0 : this.getDMnpio().hashCode());
		result = 37 * result + (getDEstado() == null ? 0 : this.getDEstado().hashCode());
		result = 37 * result + (getDCiudad() == null ? 0 : this.getDCiudad().hashCode());
		result = 37 * result + (getDCp() == null ? 0 : this.getDCp().hashCode());
		result = 37 * result + (getCEstado() == null ? 0 : this.getCEstado().hashCode());
		result = 37 * result + (getCOficina() == null ? 0 : this.getCOficina().hashCode());
		result = 37 * result + (getCCp() == null ? 0 : this.getCCp().hashCode());
		result = 37 * result + (getCTipoAsenta() == null ? 0 : this.getCTipoAsenta().hashCode());
		result = 37 * result + (getCMnpio() == null ? 0 : this.getCMnpio().hashCode());
		result = 37 * result + (getIdAsentaCpcons() == null ? 0 : this.getIdAsentaCpcons().hashCode());
		result = 37 * result + (getDZona() == null ? 0 : this.getDZona().hashCode());
		result = 37 * result + (getCCveCiudad() == null ? 0 : this.getCCveCiudad().hashCode());
		return result;
	}

}
