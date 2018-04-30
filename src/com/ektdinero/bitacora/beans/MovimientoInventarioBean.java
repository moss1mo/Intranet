package com.ektdinero.bitacora.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MovimientoInventarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cantidad;
	private BigDecimal costoMxm;
	private BigDecimal costoUsd;
	private BigDecimal dimensiones;
	private Date fechaCaducidad;
	private Date fechaIngreso;
	private Date fechaSalida;
	private BigDecimal hs;
	private int idUnidad;
	private String incoterms;
	private String lote;
	private String motivo;
	private BigDecimal prtjIgi;
	private BigDecimal prtjIva;
	private String status;
	private BigDecimal tc;
	private BigDecimal unidXPresent;
	private AlmacenBean almacen;
	private EmpaqueBean empaque;
	private MotivoMovimientoBean motivoMovimiento;
	private PedimentoBean pedimento;
	private ProductoBean producto;
	private ProveedorBean proveedor;
	private UnidadBean unidad;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getCostoMxm() {
		return costoMxm;
	}
	public void setCostoMxm(BigDecimal costoMxm) {
		this.costoMxm = costoMxm;
	}
	public BigDecimal getCostoUsd() {
		return costoUsd;
	}
	public void setCostoUsd(BigDecimal costoUsd) {
		this.costoUsd = costoUsd;
	}
	public BigDecimal getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(BigDecimal dimensiones) {
		this.dimensiones = dimensiones;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public BigDecimal getHs() {
		return hs;
	}
	public void setHs(BigDecimal hs) {
		this.hs = hs;
	}
	public int getIdUnidad() {
		return idUnidad;
	}
	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}
	public String getIncoterms() {
		return incoterms;
	}
	public void setIncoterms(String incoterms) {
		this.incoterms = incoterms;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public BigDecimal getPrtjIgi() {
		return prtjIgi;
	}
	public void setPrtjIgi(BigDecimal prtjIgi) {
		this.prtjIgi = prtjIgi;
	}
	public BigDecimal getPrtjIva() {
		return prtjIva;
	}
	public void setPrtjIva(BigDecimal prtjIva) {
		this.prtjIva = prtjIva;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getTc() {
		return tc;
	}
	public void setTc(BigDecimal tc) {
		this.tc = tc;
	}
	public BigDecimal getUnidXPresent() {
		return unidXPresent;
	}
	public void setUnidXPresent(BigDecimal unidXPresent) {
		this.unidXPresent = unidXPresent;
	}

	public AlmacenBean getAlmacen() {
		return almacen;
	}
	public void setAlmacen(AlmacenBean almacen) {
		this.almacen = almacen;
	}
	public EmpaqueBean getEmpaque() {
		return empaque;
	}
	public void setEmpaque(EmpaqueBean empaque) {
		this.empaque = empaque;
	}
	public MotivoMovimientoBean getMotivoMovimiento() {
		return motivoMovimiento;
	}
	public void setMotivoMovimiento(MotivoMovimientoBean motivoMovimiento) {
		this.motivoMovimiento = motivoMovimiento;
	}
	public PedimentoBean getPedimento() {
		return pedimento;
	}
	public void setPedimento(PedimentoBean pedimento) {
		this.pedimento = pedimento;
	}
	public ProductoBean getProducto() {
		return producto;
	}
	public void setProducto(ProductoBean producto) {
		this.producto = producto;
	}
	public ProveedorBean getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorBean proveedor) {
		this.proveedor = proveedor;
	}
	public UnidadBean getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadBean unidad) {
		this.unidad = unidad;
	}
}
