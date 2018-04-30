package com.ektdinero.bitacora.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import com.ektdinero.bitacora.dao.AlmacenesDAO;
import com.ektdinero.bitacora.dao.EmpaqueDAO;
import com.ektdinero.bitacora.dao.MotivoMovimientoDAO;
import com.ektdinero.bitacora.dao.MovimientosDAO;
import com.ektdinero.bitacora.dao.ProductoDAO;
import com.ektdinero.bitacora.dao.ExternoDAO;
import com.ektdinero.bitacora.dao.UnidadDAO;
import com.shq.entities.Almacen;
import com.shq.entities.Empaque;
import com.shq.entities.Externo;
import com.shq.entities.MotivoMov;
import com.shq.entities.MovInventario;
import com.shq.entities.Pedimento;
import com.shq.entities.Producto;
import com.shq.entities.Unidad;
import com.ektdinero.bitacora.table.datamodel.AlmacenDataModel;
import com.ektdinero.bitacora.table.datamodel.MovimientoDataModel;
import com.ektdinero.bitacora.table.datamodel.ProductoDataModel;
import com.ektdinero.bitacora.table.datamodel.ProveedorDataModel;


@ManagedBean
@SessionScoped
public class MovimientosInventarioController implements Serializable{

	private static final long serialVersionUID = 8568309221535780646L;

	private Producto producto = new Producto();
	private Externo proveedor = new Externo();
	private Almacen almacen  = new Almacen();
	private MovInventario movimiento  = new MovInventario();
	private MovInventario movimientoSeleccionado  = new MovInventario();

	
	private AlmacenesDAO almacenDAO = new AlmacenesDAO();
	private ProductoDAO productoDAO = new ProductoDAO();
	private ExternoDAO proveedorDAO = new ExternoDAO();
	private MovimientosDAO movimientosDAO = new MovimientosDAO();
	private EmpaqueDAO empaqueDAO = new EmpaqueDAO();
	private UnidadDAO unidadDAO = new UnidadDAO();
	private MotivoMovimientoDAO motivoMovDAO = new MotivoMovimientoDAO();
	
	private List<Almacen> listaAlmacenes;
	private List<Externo> listaProveedores;
	private List<Producto> listaProductos;
	private List<MovInventario> listaMovimientos;
	private List<MovInventario> listaMovimientosSalida;

	
	private ProductoDataModel productoTableModel;
	private ProveedorDataModel proveedorTableModel;
	private AlmacenDataModel almacenTableModel;
	private MovimientoDataModel movimientoTableModel;
	private MovimientoDataModel movimientoTableModelSalida;

	
	
	
	public void updateListas(){
		updateListaAlmacenes();
		updateListaProductos();
		updateListaProveedores();
		updateListaMovimientos();
	}


	
	public AlmacenDataModel updateListaAlmacenes(){
		List<Almacen> listAlmacen = almacenDAO.getAlmacenes();
		if(listAlmacen != null){
			return  almacenTableModel = new AlmacenDataModel(listAlmacen);
		}
		return almacenTableModel = new AlmacenDataModel();
	}
	
	
	public ProductoDataModel updateListaProductos(){
		List<Producto> listProducto = productoDAO.getProductos();
		if(listProducto != null){
			return  productoTableModel = new ProductoDataModel(listProducto);
		}
		return productoTableModel = new ProductoDataModel();
	}
	
	
	public ProveedorDataModel updateListaProveedores(){
		List<Externo> listaProveedores = proveedorDAO.getProveedores();
		if(listaProveedores != null){
			return  proveedorTableModel = new ProveedorDataModel(listaProveedores);
		}
		return proveedorTableModel = new ProveedorDataModel();
	}
	
	public MovimientoDataModel updateListaMovimientos(){
		List<MovInventario> listaMovimientos = movimientosDAO.getMovimientosEntrada();
		if(listaMovimientos != null){
			return  movimientoTableModel = new MovimientoDataModel(listaMovimientos);
		}
		return movimientoTableModel = new MovimientoDataModel();
	}
	
	public MovimientoDataModel updateListaMovimientosSalida(){
		List<MovInventario> listaMovimientos = movimientosDAO.getMovimientosSalida();
		if(listaMovimientos != null){
			return  movimientoTableModelSalida = new MovimientoDataModel(listaMovimientos);
		}
		return movimientoTableModelSalida = new MovimientoDataModel();
	}
	
	//Consultas genericas abstraer a un controller catalogoController
	public 	List<Almacen> obtenerAlmacenes(){
	 return almacenDAO.getAlmacenes();
	}
	
	public 	List<Producto> obtenerProductos(){
		return productoDAO.getProductos();
	}
	
	public 	List<Externo> obtenerProveedores(){
		return proveedorDAO.getProveedores();
	}
	
	public 	List<Empaque> obtenerEmpaques(){
		 return empaqueDAO.getLista();
	}
	
	public 	List<Pedimento> obtenerPedimentos(){
		// temrporal en lo que se define lo de pedimentos return pedimentoDAO.getLista();
		return new ArrayList<Pedimento>();
	}
	
	public 	List<Unidad> obtenerUnidades(){
		 return unidadDAO.getLista();
	}
	
	public 	List<MotivoMov> obtenerMotivos(){
		 return motivoMovDAO.getLista();
	}
	
	
	
	 public List<Producto> completeProductos(String query) {
			List<Producto> all = productoDAO.getProductos();
			List<Producto> filtered = new ArrayList<Producto>();
	         
	        for (int i = 0; i < all.size(); i++) {
	        	Producto product = all.get(i);
	            if(product.getProducto().toLowerCase().startsWith(query)) {
	            	filtered.add(product);
	            }
	        }
	         
	        return filtered;
	    }

	
	

	public void mostrarPantallaRegistro() {
		 try {
			 listaMovimientos = new ArrayList<MovInventario>();
				 FacesContext.getCurrentInstance().getExternalContext().redirect("/Intranet/secured/subMenu/inventario/entradas/registrarEntrada.xhtml");
		 	} catch (IOException e) {
			e.printStackTrace();
		}
    }	
	
	public void mostrarPantallaRegistroSalida() {
		 try {
			 listaMovimientosSalida = new ArrayList<MovInventario>();
				 FacesContext.getCurrentInstance().getExternalContext().redirect("/Intranet/secured/subMenu/inventario/salidas/registrarSalida.xhtml");
		 	} catch (IOException e) {
			e.printStackTrace();
		}
   }

	
	
	public String onFlowProcess(FlowEvent event) {
            return event.getNewStep();
    }

	public AlmacenDataModel getAlmacenTableModel() {
		return almacenTableModel;
	}



	public void setAlmacenTableModel(AlmacenDataModel almacenTableModel) {
		this.almacenTableModel = almacenTableModel;
	}


	public List<Producto> getListaProductos() {
		return listaProductos;
	}



	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	

	public Producto getProducto() {
		return producto;
	}
	
	public void setProveedor(Externo proveedor) {
		this.proveedor = proveedor;
	}
	

	public Externo getProveedor() {
		return proveedor;
	}



	public ProductoDataModel getProductoTableModel() {
		return productoTableModel;
	}



	public void setProductoTableModel(ProductoDataModel productoTableModel) {
		this.productoTableModel = productoTableModel;
	}



	public ProveedorDataModel getProveedorTableModel() {
		return proveedorTableModel;
	}



	public void setProveedorTableModel(ProveedorDataModel proveedorTableModel) {
		this.proveedorTableModel = proveedorTableModel;
	}



	public List<Externo> getListaProveedores() {
		return listaProveedores;
	}



	public void setListaProveedores(List<Externo> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}



	public List<Almacen> getListaAlmacenes() {
		return listaAlmacenes;
	}



	public void setListaAlmacenes(List<Almacen> listaAlmacenes) {
		this.listaAlmacenes = listaAlmacenes;
	}



	public Almacen getAlmacen() {
		return almacen;
	}



	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}



	public MovimientosDAO getMovimientosDAO() {
		return movimientosDAO;
	}



	public void setMovimientosDAO(MovimientosDAO movimientosDAO) {
		this.movimientosDAO = movimientosDAO;
	}



	public MovimientoDataModel getMovimientoTableModel() {
		updateListaMovimientos();
		return movimientoTableModel;
	}



	public void setMovimientoTableModel(MovimientoDataModel movimientoTableModel) {
		this.movimientoTableModel = movimientoTableModel;
	}
	
	
	public void agregarMovimientoEntrada(){
		listaMovimientos.add(movimiento);
		movimiento = new MovInventario();
	}
	
	public void agregarMovimientoSalida(){
		listaMovimientosSalida.add(movimiento);
		movimiento = new MovInventario();
	}
	
	
	
	
	
	public void guardarEntrada(){
		if(listaMovimientos != null && listaMovimientos.size() > 0){
			movimientosDAO.guardarLista(listaMovimientos);
		}
		
	}
	
	public void guardarSalida(){
		if(listaMovimientosSalida != null && listaMovimientosSalida.size() > 0){
			movimientosDAO.guardarLista(listaMovimientosSalida);	
		}
		
	}


	public MovInventario getMovimiento() {
		if(movimiento == null){
			movimiento = new MovInventario();	
		}
		/**
		 * ARREGLAR CAMBIANDO TIPO DATO DE LA TABLA MOV_INV
		 * 
		 *  `id_almacen` int(11) DEFAULT NULL,
  `id_empaque` int(11) DEFAULT NULL,
  `id_motivo_mov` int(11) DEFAULT NULL,
  `id_pedimento` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  CAMIBIAR A DECIMAL
		 * 
		if(movimiento.getAlmacen()== null){
			movimiento.setAlmacen(new Almacen());
		}
		if(movimiento.getProducto() == null){
			movimiento.setProducto(new Producto());
		}
		if(movimiento.getMotivoMov() == null){
			movimiento.setMotivoMov(new MotivoMov());
		}
		if(movimiento.getEmpaque() == null){
			movimiento.setEmpaque(new Empaque());
		}
		if(movimiento.getPedimento() == null){
			//de forma temporal mientras se agrega funcionalidad de pedimento
			//movimiento.setPedimento(new Pedimento());
		}
		
		if(movimiento.getUnidad() == null){
			movimiento.setUnidad(new Unidad());
		}**/
		
		if(movimiento.getProveedor() == null){
			movimiento.setProveedor(new Externo());
		}

		
		return movimiento;
	}



	public void setMovimiento(MovInventario movimiento) {
		this.movimiento = movimiento;
	}



	public MovInventario getMovimientoSeleccionado() {
		return movimientoSeleccionado;
	}



	public void setMovimientoSeleccionado(MovInventario movimientoSeleccionado) {
		this.movimientoSeleccionado = movimientoSeleccionado;
	}



	public List<MovInventario> getListaMovimientos() {
		return listaMovimientos;
	}



	public void setListaMovimientos(List<MovInventario> listaMovimientos) {
		this.listaMovimientos = listaMovimientos;
	}



	public MovimientoDataModel getMovimientoTableModelSalida() {
		updateListaMovimientosSalida();
		return movimientoTableModelSalida;
	}



	public void setMovimientoTableModelSalida(MovimientoDataModel movimientoTableModelSalida) {
		this.movimientoTableModelSalida = movimientoTableModelSalida;
	}



	public List<MovInventario> getListaMovimientosSalida() {
		return listaMovimientosSalida;
	}



	public void setListaMovimientosSalida(List<MovInventario> listaMovimientosSalida) {
		this.listaMovimientosSalida = listaMovimientosSalida;
	}


	
}
