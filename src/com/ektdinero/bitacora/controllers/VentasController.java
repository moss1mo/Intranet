package com.ektdinero.bitacora.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ektdinero.bitacora.beans.ProductoSolCotizacion;
import com.ektdinero.bitacora.beans.ProductoSolCotizacionLote;
import com.ektdinero.bitacora.dao.ApartadosCotizacionDAO;
import com.ektdinero.bitacora.dao.CotizacionProveedorDAO;
import com.ektdinero.bitacora.dao.InventarioDAO;
import com.ektdinero.bitacora.dao.InventarioLotesDAO;
import com.ektdinero.bitacora.dao.ProSolCotizacionParcialDAO;
import com.ektdinero.bitacora.dao.ProductoCotProveedorDAO;
import com.ektdinero.bitacora.dao.SolCotizacionDAO;
import com.ektdinero.bitacora.dao.UsuariosDAO;
import com.ektdinero.bitacora.table.datamodel.CotizacionProveedorDataModel;
import com.ektdinero.bitacora.table.datamodel.InventarioLotesDataModel;
import com.ektdinero.bitacora.table.datamodel.SolicitudCotizacionDataModel;
import com.shq.entities.ApartadosCotizacion;
import com.shq.entities.CotizacionProveedor;
import com.shq.entities.InventarioLotesVw;
import com.shq.entities.InventarioVw;
import com.shq.entities.Producto;
import com.shq.entities.ProductoCotProveedor;
import com.shq.entities.ProductoSolCotizacionParc;
import com.shq.entities.Externo;
import com.shq.entities.SolCotizacion;
import com.shq.entities.Usuario;
import com.shq.utils.Utileria;


@ManagedBean
@SessionScoped
public class VentasController implements Serializable{

	private static final long serialVersionUID = 8568309221535780646L;

	private Usuario usuario = new Usuario();
	private List<SolCotizacion> solicitudesSeleccionadas;
	private List<SolCotizacion> solicitudesAsigSeleccionadas;
	private List<ProductoSolCotizacionLote> listaProductosLoteSeleccionado;
	private InventarioLotesDataModel listaProductosLoteEncontrados;
	private List<ApartadosCotizacion>listaProductosCotizados;
	
	private List<ProductoSolCotizacionParc>listaProductosCotizacionParcial;
	private List<ProductoSolCotizacionParc>listaProductosCotizacionParcialCotizar;


	private BigDecimal compradorAsignado;
	private SolCotizacion solicitud;
	private CotizacionProveedor cotizacionProveedor;
	
	private SolCotizacionDAO solCotizacionDAO = new SolCotizacionDAO();
	private UsuariosDAO usuarioDAO = new UsuariosDAO();
	private InventarioDAO inventarioDAO = new InventarioDAO();
	private InventarioLotesDAO inventarioLotesDAO = new InventarioLotesDAO();
	private ApartadosCotizacionDAO apartadosCotizacionDAO = new ApartadosCotizacionDAO();
	private ProSolCotizacionParcialDAO proSolCotizacionParcialDAO = new ProSolCotizacionParcialDAO();
	private CotizacionProveedorDAO cotizacionProveedorDAO = new CotizacionProveedorDAO();
	private ProductoCotProveedorDAO productoCotProveedorDAO = new ProductoCotProveedorDAO();
	
	private Double totalCotizacionSinIva;
	
	public SolicitudCotizacionDataModel obtenerSolicitudes(){
		return new SolicitudCotizacionDataModel(solCotizacionDAO.getSolicitudes());
	}
	
	
	public SolicitudCotizacionDataModel obtenerSolicitudesAsignadas(Usuario usuario){
		return new SolicitudCotizacionDataModel(solCotizacionDAO.getSolicitudesByUserID(usuario));
	}
	

	
	
	public void  actualizarCantidades(ProductoSolCotizacionLote producto){
		
		try{
			ApartadosCotizacion apartado = new ApartadosCotizacion();
			ApartadosCotizacion apartadoExistente = null;
			apartado.setActivo(true);
			apartado.setCantidad(producto.getCantidad());
			apartado.setLote(producto.getProductoInvLote().getId().getLote());
			Producto productoCompleto = new Producto();
			productoCompleto.setId(producto.getProductoInvLote().getId().getIdProducto().intValue());
			apartado.setProducto(productoCompleto);
			apartado.setSolCotizacion(solicitud);
			if(apartado.getLote() != null && apartado.getProducto() != null && apartado.getSolCotizacion() != null ){
				apartadoExistente = apartadosCotizacionDAO.buscarProductoCotizado(apartado.getLote(),apartado.getProducto().getId(),apartado.getSolCotizacion().getId());
			}

			if(apartadoExistente == null){
				apartadosCotizacionDAO.guardarApartado(apartado);
			}else{
				apartadoExistente.setCantidad(apartadoExistente.getCantidad()+producto.getCantidad());
				apartadosCotizacionDAO.actualizarApartado(apartadoExistente);
			}
			
			Producto pro = new Producto();
			pro.setProducto(producto.getProductoInvLote().getId().getProducto());
			buscarProductoInventario(pro);
			verListaProductosCotizados(solicitud);

			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación registrada exitosamente",
				"Se ha registrado la asignanción correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Asignación no registrada",
				"No se ha podido registrar la asignanción, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}
	}
	
	public void removerProductoCotizacion(ApartadosCotizacion producto){
		try{
		apartadosCotizacionDAO.eliminarProductoCotizacion(producto.getId());
		buscarProductoInventario(producto.getProducto());
		verListaProductosCotizados(solicitud);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Eliminado exitosamente",
				"Se ha eliminado el producto correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Producto no eliminado",
				"No se ha podido eliminar el prodcuto, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}
	}

	public List<Usuario> obtenerUsuariosCompradores(){
		return usuarioDAO.getUsuariosCompradores();
	}
	
	public void verListaProductosCotizados(SolCotizacion solicitud){
		listaProductosCotizados = apartadosCotizacionDAO.getApartados(solicitud.getId());
	}
	
	public void verDetalleSolicitud(SolCotizacion solicitud){
		
		this.solicitud = solicitud;
		Iterator<com.shq.entities.ProductoSolCotizacion> it = solicitud.getProductoSolCotizacions().iterator();
		boolean alMenosUno = false;
		boolean completo = false;
		listaProductosLoteEncontrados = null;
		InventarioVw productoInv;
		
		while (it.hasNext()){
			com.shq.entities.ProductoSolCotizacion producto = it.next();
			List<InventarioVw> inventario = inventarioDAO.getCantidadProductoPorID(new BigDecimal(producto.getProducto().getId()));
			 if(inventario.size()>0){
				  productoInv =	inventario.get(0);
				  
				  if(!alMenosUno){
						if(productoInv.getId().getCantidad().longValue()>0){
							alMenosUno = true;				
						}
					}
					
					if(producto.getCantidad() <productoInv.getId().getCantidad().longValue()){
						completo = true;
					}else{
						 completo = false;	
					}	
			}
			
		}
		
		if(completo || alMenosUno){
			verListaProductosCotizados(solicitud);
    		RequestContext.getCurrentInstance().execute("location.href='detalleSolicitudExt.xhtml'");
		}else{
			RequestContext.getCurrentInstance().execute("location.href='detalleSolicitud.xhtml'");
		}
		
	}
	
	
	public CotizacionProveedorDataModel obtenerSolicitudesCompra(Usuario usuario){
		return new CotizacionProveedorDataModel(cotizacionProveedorDAO.obtenerCotizacionesProveedoresPorComprador(usuario.getIdUsuario().longValue()));
	}
	
	public CotizacionProveedorDataModel obtenerCotizacionesRecibidas(Usuario usuario){
		return new CotizacionProveedorDataModel(cotizacionProveedorDAO.obtenerCotizacionesProveedoresPorVendedor(usuario.getIdUsuario().longValue()));

	}
	
	

	public void verDetalleCotizacionRecibida(CotizacionProveedor cotizacionProveedor){
		this.cotizacionProveedor = cotizacionProveedor;
		totalCotizacionSinIva = new Double(0);
		for(ProductoCotProveedor producto:cotizacionProveedor.getListaProductoCotProveedors()){
			if(producto.getMoneda()== null || producto.getMoneda().equals("USD")){
				totalCotizacionSinIva = totalCotizacionSinIva + (producto.getCantidad()*producto.getCosto()*Utileria.getTC());
			}else{
				totalCotizacionSinIva = totalCotizacionSinIva+(producto.getCantidad()*producto.getCosto());
			}
		}
		RequestContext.getCurrentInstance().execute("location.href='detalleCotizacion.xhtml'");
	}
	
	
	
	public void guardarAsignacionCotizacion(Usuario usuario) {
		try {
			
			for(SolCotizacion sol:solicitudesSeleccionadas){
				sol.setStatus("Cotización asignada");
				sol.setUsuarioByIdVendedor(usuario);
			}
			solCotizacionDAO.actualizarSolicitudes(solicitudesSeleccionadas);
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación registrada exitosamente",
					"Se ha registrado la asignanción correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Asignación no registrada",
					"No se ha podido registrar la asignanción, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}

	}
	
	
	public void enviarCotizacion(){
		try {
			
			if(listaProductosCotizacionParcialCotizar.size() == 0 && listaProductosCotizacionParcial.size() == 0){
				solicitud.setStatus("Cotización enviada a comprador");
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(compradorAsignado);
				solicitud.setUsuarioByIdComprador(usuario);
			}else if(listaProductosCotizacionParcialCotizar.size()>0){
				solicitud.setStatus("Cotización enviada a cliente y al comprador");
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(compradorAsignado);
				solicitud.setUsuarioByIdComprador(usuario);
			}else{
				solicitud.setStatus("Cotización enviada a cliente");
			}
		
		solCotizacionDAO.actualizarSolicitud(solicitud);
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación registrada exitosamente",
				"Se ha registrado la asignanción correctamente");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	} catch (Exception e) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Asignación no registrada",
				"No se ha podido registrar la asignanción, pedimos reportar el error para resolverlo");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		e.printStackTrace();
	}
	}

	public void guardarAsignacionComprador() {
		try {
			
				solicitud.setStatus("Cotización enviada a comprador");
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(compradorAsignado);
				solicitud.setUsuarioByIdComprador(usuario);
			
			solCotizacionDAO.actualizarSolicitud(solicitud);
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación registrada exitosamente",
					"Se ha registrado la asignanción correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Asignación no registrada",
					"No se ha podido registrar la asignanción, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}

	}
	
	public void generarCotizacion(){
		listaProductosCotizacionParcial = proSolCotizacionParcialDAO.getProductos(solicitud.getId());
		listaProductosCotizacionParcialCotizar = proSolCotizacionParcialDAO.getProductosPorCotizar(solicitud.getId());
		
		RequestContext.getCurrentInstance().execute("location.href='cotizacionGenerada.xhtml'");

	}
	
	
	public void buscarProductoInventario(Producto producto){
		   ArrayList<ProductoSolCotizacionLote> listaProductosLote = new ArrayList<ProductoSolCotizacionLote>();
			for(InventarioLotesVw invLote:inventarioLotesDAO.getInventarioPorProducto(producto)){
				listaProductosLote.add(new ProductoSolCotizacionLote(invLote));
			}
			listaProductosLoteEncontrados = new InventarioLotesDataModel(listaProductosLote);
			
	}
	
	
	
	public SolicitudCotizacionDataModel obtenerRequisicionesDisponibles(BigDecimal id_externo_logeado){
		return new SolicitudCotizacionDataModel(solCotizacionDAO.getSolicitudesReqDisponibles(id_externo_logeado));
	}
	
public void verDetalleRequisicion(SolCotizacion solicitud,Externo proveedor){
			this.cotizacionProveedor = cotizacionProveedorDAO.obtenerCotizacionProveedor(solicitud.getId(),proveedor.getIdExterno());
			RequestContext.getCurrentInstance().execute("location.href='detalleRequisicion.xhtml'");
		
	}

	public void guardarRequisicionProveedor(){
		try {
			Iterator<ProductoCotProveedor> productosIT = this.cotizacionProveedor.getProductoCotProveedors().iterator();
			List<ProductoCotProveedor> listaActualizada = new ArrayList<ProductoCotProveedor>();
			while(productosIT.hasNext()){
				listaActualizada.add(productosIT.next());
			}
			productoCotProveedorDAO.actualizarProductos(listaActualizada);
			cotizacionProveedor.getSolCotizacion().setCodStatus(4);
			cotizacionProveedor.getSolCotizacion().setStatus("Cotización enviada por el proveedor");
			cotizacionProveedorDAO.update(this.cotizacionProveedor);

			
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisición registrada exitosamente",
				"Se ha registrado la requisición correctamente");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Requisición no registrada",
					"No se ha podido registrar la requisición, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}
		
	}
	
	
	public void enviarCotizacionAlCliente(){
		try{
			
			cotizacionProveedor.getSolCotizacion().setCodStatus(5);
			cotizacionProveedor.getSolCotizacion().setStatus("Cotización enviada al cliente");
			cotizacionProveedor.setEnviadaCliente(true);
			cotizacionProveedorDAO.update(this.cotizacionProveedor);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisición registrada exitosamente",
			"Se ha registrado la requisición correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			} catch (Exception e) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Requisición no registrada",
						"No se ha podido registrar la requisición, pedimos reportar el error para resolverlo");
				RequestContext.getCurrentInstance().showMessageInDialog(message);
				e.printStackTrace();
			}
	}
	
	
	public void solicitarPedidoComprador(){
		try{
			
			cotizacionProveedor.getSolCotizacion().setCodStatus(7);
			cotizacionProveedor.getSolCotizacion().setStatus("Pedido solicitado al comprador SHQ");
			cotizacionProveedorDAO.update(this.cotizacionProveedor);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido registrado exitosamente",
			"Se ha registrado el pedido correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			} catch (Exception e) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Requisición no registrada",
						"No se ha podido registrar el pedido, pedimos reportar el error para resolverlo");
				RequestContext.getCurrentInstance().showMessageInDialog(message);
				e.printStackTrace();
			}
	}
	
	
	
	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<SolCotizacion> getSolicitudesSeleccionadas() {
		return solicitudesSeleccionadas;
	}


	public void setSolicitudesSeleccionadas(List<SolCotizacion> solicitudesSeleccionadas) {
		this.solicitudesSeleccionadas = solicitudesSeleccionadas;
	}


	public List<SolCotizacion> getSolicitudesAsigSeleccionadas() {
		return solicitudesAsigSeleccionadas;
	}


	public void setSolicitudesAsigSeleccionadas(List<SolCotizacion> solicitudesAsigSeleccionadas) {
		this.solicitudesAsigSeleccionadas = solicitudesAsigSeleccionadas;
	}


	public BigDecimal getCompradorAsignado() {
		return compradorAsignado;
	}


	public void setCompradorAsignado(BigDecimal compradorAsignado) {
		this.compradorAsignado = compradorAsignado;
	}


	public SolCotizacion getSolicitud() {
		return solicitud;
	}


	public void setSolicitud(SolCotizacion solicitud) {
		this.solicitud = solicitud;
	}


	public List<ProductoSolCotizacionLote> getListaProductosLoteSeleccionado() {
		return listaProductosLoteSeleccionado;
	}


	public void setListaProductosLoteSeleccionado(List<ProductoSolCotizacionLote> listaProductosLoteSeleccionado) {
		this.listaProductosLoteSeleccionado = listaProductosLoteSeleccionado;
	}


	public InventarioLotesDataModel getListaProductosLoteEncontrados() {
		return listaProductosLoteEncontrados;
	}


	public void setListaProductosLoteEncontrados(InventarioLotesDataModel listaProductosLoteEncontrados) {
		this.listaProductosLoteEncontrados = listaProductosLoteEncontrados;
	}




	public List<ApartadosCotizacion> getListaProductosCotizados() {
		return listaProductosCotizados;
	}


	public void setListaProductosCotizados(List<ApartadosCotizacion> listaProductosCotizados) {
		this.listaProductosCotizados = listaProductosCotizados;
	}


	public List<ProductoSolCotizacionParc> getListaProductosCotizacionParcial() {
		return listaProductosCotizacionParcial;
	}


	public void setListaProductosCotizacionParcial(List<ProductoSolCotizacionParc> listaProductosCotizacionParcial) {
		this.listaProductosCotizacionParcial = listaProductosCotizacionParcial;
	}


	public List<ProductoSolCotizacionParc> getListaProductosCotizacionParcialCotizar() {
		return listaProductosCotizacionParcialCotizar;
	}


	public void setListaProductosCotizacionParcialCotizar(
			List<ProductoSolCotizacionParc> listaProductosCotizacionParcialCotizar) {
		this.listaProductosCotizacionParcialCotizar = listaProductosCotizacionParcialCotizar;
	}


	public CotizacionProveedor getCotizacionProveedor() {
		return cotizacionProveedor;
	}


	public void setCotizacionProveedor(CotizacionProveedor cotizacionProveedor) {
		this.cotizacionProveedor = cotizacionProveedor;
	}


	public Double getTotalCotizacionSinIva() {
		return totalCotizacionSinIva;
	}


	public void setTotalCotizacionSinIva(Double totalCotizacionSinIva) {
		this.totalCotizacionSinIva = totalCotizacionSinIva;
	}


	

	
	
}
