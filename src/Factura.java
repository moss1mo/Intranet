import java.util.List;

public class Factura {

	List<Producto> productos;
	private Double costoTransporte;

	public Double getCostoTransporte() {
		return costoTransporte;
	}

	public void setCostoTransporte(Double costoTransporte) {
		this.costoTransporte = costoTransporte;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
}
