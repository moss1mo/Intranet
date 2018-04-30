
public class Producto {

	private String harmonizedCode;
	private String producto;
	private Double IGI;
	private Double IVA;
	private String unidad;
	private Double presentacion;
	private Double cantidad;
	private Double costoUSD;
	private Double costoMXN;	
	private Double dtaUnidad;
	private Double costoTransporte;
	
	private Double costoVariableAduana;
	private Double costoFijoAduana;
	private Double costoSeguro;
	
	private Double costoVariableLogistica;
	private Double costoFijoLogistica;
	private Double precioMercado;
		
	private Double alto = 0.4;
	private Double ancho = 0.4;
	private Double largo = 0.4;
	
	public String getHarmonizedCode() {
		return harmonizedCode;
	}
	public void setHarmonizedCode(String harmonizedCode) {
		this.harmonizedCode = harmonizedCode;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Double getIGI() {
		return IGI;
	}
	public void setIGI(Double iGI) {
		IGI = iGI;
	}
	public Double getIVA() {
		return IVA;
	}
	public void setIVA(Double iVA) {
		IVA = iVA;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public Double getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(Double presentacion) {
		this.presentacion = presentacion;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getCostoUSD() {
		return costoUSD;
	}
	public void setCostoUSD(Double costoUSD) {
		this.costoUSD = costoUSD;
	}
	public Double getCostoMXN() {
		return costoMXN;
	}
	public void setCostoMXN(Double costoMXN) {
		this.costoMXN = costoMXN;
	}
	public Double getDtaUnidad() {
		return dtaUnidad;
	}
	public void setDtaUnidad(Double dtaUnidad) {
		this.dtaUnidad = dtaUnidad;
	}
	public Double getCostoTransporte() {
		return costoTransporte;
	}
	public void setCostoTransporte(Double costoTransporte) {
		this.costoTransporte = costoTransporte;
	}
	public Double getCostoVariableAduana() {
		return costoVariableAduana;
	}
	public void setCostoVariableAduana(Double costoVariableAduana) {
		this.costoVariableAduana = costoVariableAduana;
	}
	public Double getCostoFijoAduana() {
		return costoFijoAduana;
	}
	public void setCostoFijoAduana(Double costoFijoAduana) {
		this.costoFijoAduana = costoFijoAduana;
	}
	public Double getCostoSeguro() {
		return costoSeguro;
	}
	public void setCostoSeguro(Double costoSeguro) {
		this.costoSeguro = costoSeguro;
	}
	public Double getCostoVariableLogistica() {
		return costoVariableLogistica;
	}
	public void setCostoVariableLogistica(Double costoVariableLogistica) {
		this.costoVariableLogistica = costoVariableLogistica;
	}
	public Double getCostoFijoLogistica() {
		return costoFijoLogistica;
	}
	public void setCostoFijoLogistica(Double costoFijoLogistica) {
		this.costoFijoLogistica = costoFijoLogistica;
	}

	public Double getAlto() {
		return alto;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getLargo() {
		return largo;
	}
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	
	public Double getDimensionTotalProducto() {
		return 	(this.cantidad/this.presentacion)*(this.alto*this.ancho*this.largo);
	}
	public Double getPrecioMercado() {
		return precioMercado;
	}
	public void setPrecioMercado(Double precioMercado) {
		this.precioMercado = precioMercado;
	}
	

}
