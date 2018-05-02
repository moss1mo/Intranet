package com.ektdinero.bitacora.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.ektdinero.bitacora.beans.CatalogosBean;
import com.ektdinero.bitacora.dao.CotizacionProveedorDAO;
import com.ektdinero.bitacora.dao.CotizarDAO;
import com.ektdinero.bitacora.dao.InvProductProvDAO;
import com.ektdinero.bitacora.dao.ProSolCotizacionParcialDAO;
import com.ektdinero.bitacora.dao.ProductoCotProveedorDAO;
import com.ektdinero.bitacora.dao.SolCotizacionDAO;
import com.ektdinero.bitacora.dao.UsuariosDAO;
import com.shq.entities.CatBancos;
import com.shq.entities.CatPaises;
import com.shq.entities.CatPaisesId;
import com.shq.entities.CatSepomex;
import com.shq.entities.CotizacionProveedor;
import com.shq.entities.CotizarVw;
import com.shq.entities.CuentaBanco;
import com.shq.entities.Domicilio;
import com.shq.entities.Externo;
import com.shq.entities.InvProductProvVw;
import com.shq.entities.ProductoCotProveedor;
import com.shq.entities.ProductoSolCotizacionParc;
import com.shq.entities.SolCotizacion;
import com.shq.entities.Usuario;
import com.shq.utils.Utileria;
import com.ektdinero.bitacora.table.datamodel.CotizacionProveedorDataModel;
import com.ektdinero.bitacora.table.datamodel.InvProductProvDataModel;
import com.ektdinero.bitacora.table.datamodel.ProductoCotizarDataModel;
import com.ektdinero.bitacora.table.datamodel.SolicitudCotizacionDataModel;


@ManagedBean
@SessionScoped
public class ComprasController implements Serializable{

	private static final long serialVersionUID = 8568309221535780646L;

	private Usuario usuario = new Usuario();
	private Externo externo = new Externo();
	private CotizarVw productoSeleccionado;
	private List<CotizarVw> listaProductos;
	private List<InvProductProvVw> listaProveedores;
	private List<Usuario> listaProveedoresSeleccionados;
	private List<CotizacionProveedor> listaCotizaciones;
	private String tipoProveedor;
	private String productoCotizarSeleccionado;
	private boolean domDistinto;
	private CuentaBanco cuenta = new CuentaBanco();
	private CotizacionProveedor cotizacionProveedor;
	private Double totalCotizacionSinIva;
	
	
	
	private CotizarDAO cotizarDAO = new CotizarDAO();
	private SolCotizacionDAO solCotizacionDAO = new SolCotizacionDAO();
	private InvProductProvDAO invProductProvDAO = new InvProductProvDAO();
	private ProSolCotizacionParcialDAO proSolCotizacionParcialDAO = new ProSolCotizacionParcialDAO();
	private CotizacionProveedorDAO cotizacionProveedorDAO = new CotizacionProveedorDAO();
	private UsuariosDAO usuariosDAO = new UsuariosDAO();
	
	private ProductoCotizarDataModel productoCotizarDM;
	private InvProductProvDataModel invProductProvDM;

	public void mostrarPantallaRegistro() {
		 try { 
				 FacesContext.getCurrentInstance().getExternalContext().redirect( "/Intranet/secured/subMenu/inventario/altas/registrarProveedor.xhtml");
		 	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
	public ProductoCotizarDataModel updateListaProductos(){
		this.listaProductos = cotizarDAO.getProductos();
		if(listaProductos != null){
			return  productoCotizarDM = new ProductoCotizarDataModel(listaProductos);
		}
		return productoCotizarDM = new ProductoCotizarDataModel();
	}
	
	public InvProductProvDataModel updateListaProveedoresCotizar(){
		this.listaProveedores = invProductProvDAO.getProveedoresByProducto(productoCotizarSeleccionado);
		if(listaProveedores != null){
			return  invProductProvDM = new InvProductProvDataModel(listaProveedores);
		}
		return invProductProvDM = new InvProductProvDataModel();
	}
	
	
	public SolicitudCotizacionDataModel obtenerSolicitudesAsignadas(Usuario usuario){
		productoCotizarDM = null;
		productoCotizarSeleccionado=null;
		return new SolicitudCotizacionDataModel(solCotizacionDAO.getSolicitudesByComprador(usuario));
	}
	
	public SolicitudCotizacionDataModel obtenerSolicitudesCliente(Usuario usuario){
		return new SolicitudCotizacionDataModel(solCotizacionDAO.getSolicitudesByCliente(usuario));
	}
	
	public void seleccionarProductoCotizar(String productoCotizarSeleccionado){
		this.productoCotizarSeleccionado = productoCotizarSeleccionado;
	}

	
	public List<ProductoSolCotizacionParc> obtenerListaApartadosCotizacion(SolCotizacion solicitud){
		return proSolCotizacionParcialDAO.getProductosPorCotizar(solicitud.getId());

	}
	
	public void enviarProveedores(SolCotizacion solicitud){
		try{
			CotizacionProveedorDAO cotProvDAO = new CotizacionProveedorDAO();
			ProductoCotProveedorDAO productoCotProveedorDAO = new ProductoCotProveedorDAO();

			for(Usuario usuario:listaProveedoresSeleccionados){
				CotizacionProveedor cotProveedor = new CotizacionProveedor();
				cotProveedor.setExterno(usuario.getExterno());
				cotProveedor.setSolCotizacion(solicitud);
				cotProveedor = cotProvDAO.guardarSolicitud(cotProveedor);
				
				List<ProductoCotProveedor> productosCotProveedor = new ArrayList<ProductoCotProveedor>();
				Iterator<com.shq.entities.ProductoSolCotizacion> it = solicitud.getProductoSolCotizacions().iterator();
				while(it.hasNext()){
					com.shq.entities.ProductoSolCotizacion producto = it.next();
					ProductoCotProveedor productoCotProveedor = new ProductoCotProveedor();
					productoCotProveedor.setProducto(producto.getProducto());
					productoCotProveedor.setCosto(new Long(0));
					productoCotProveedor.setCantidad(producto.getCantidad());
					productoCotProveedor.setCotizacionProveedor(cotProveedor);
					productoCotProveedor.setDispMensual(new Long(0));
					productoCotProveedor.setTiempoEntrega(new Long(0));
					productosCotProveedor.add(productoCotProveedor);
				}
				productoCotProveedorDAO.guardarProductos(productosCotProveedor);
				
			}
			
			
			
			
			
			
			
			
			solicitud.setStatus("Solicitando requisición");
			solicitud.setCodStatus(3);
			solCotizacionDAO.actualizarSolicitud(solicitud);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Requisición enviada a proveedores exitosamente",
				"Se ha enviado la requisición correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Requisición a proveedores no enviada",
				"No se ha podido enviar la requisición, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}
	}
	
	
	public void cargarDatosUsuario(Usuario usuario){
		this.usuario = usuario;
		externo = usuario.getExterno();
		//this.usuario = usuariosDAO.find(usuario.getIdUsuario());

	}
	
	public void cargarDatosDomicilio(Usuario usuario){
		this.usuario = usuario;
		externo = usuario.getExterno();
		if(externo.getDomicilio() == null){
			Domicilio domicilio = new Domicilio();
			domicilio.setPrincipal(true);
			externo.setDomicilio(domicilio);
		}
	}
	
	

	
	public CotizacionProveedorDataModel obtenerSolicitudesCompra(Usuario usuario){
		return new CotizacionProveedorDataModel(cotizacionProveedorDAO.obtenerCotizacionesProveedoresPorComprador(usuario.getIdUsuario().longValue()));
	}
	
	
	public void verDetalleCotizacion(CotizacionProveedor cotizacionProveedor){
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
	
	
	public void verDetalleCotizacionCliente(SolCotizacion solicitud){
		this.cotizacionProveedor = cotizacionProveedorDAO.obtenerCotizacionesProveedoresPorSolicitud(solicitud.getId());
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
	
	public void enviarCotizacionVendedor(){
		
		try{
			cotizacionProveedor.getSolCotizacion().setCodStatus(5);
			cotizacionProveedor.getSolCotizacion().setStatus("Cotización enviada al vendedor SHQ");
			cotizacionProveedorDAO.update(this.cotizacionProveedor);
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cotización enviada al vendedor exitosamente",
				"Se ha enviado la cotizacíon al comprador correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cotización no enviada al vendedor",
				"No se ha enviado la cotizacíon al vendedor correctamente, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}
		
	}
	
	
	public void aceptarCotizacion(){
		try{
			cotizacionProveedor.getSolCotizacion().setCodStatus(6);
			cotizacionProveedor.getSolCotizacion().setStatus("Cotización aceptada por el cliente");
			cotizacionProveedorDAO.update(this.cotizacionProveedor);
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cotización enviada al vendedor exitosamente",
				"Se ha enviado la cotizacíon al comprador correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cotización no enviada al vendedor",
				"No se ha enviado la cotizacíon al vendedor correctamente, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}
	}
	
	public void enviarPedidoProveedor(){
		try{
			cotizacionProveedor.getSolCotizacion().setCodStatus(8);
			cotizacionProveedor.getSolCotizacion().setStatus("Pedido enviado al proveedor");
			cotizacionProveedorDAO.update(this.cotizacionProveedor);
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido enviada al proveedor exitosamente",
				"Se ha enviado el pedido al proveedor correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pedido no enviado al proveedor",
				"No se ha enviado el pedido al proveedor correctamente, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}
	}
	
	public List<Usuario> obtenerProveedores(SolCotizacion solCotizacion){
		return usuariosDAO.getUsuariosExternos(solCotizacion.getUsuarioByIdExterno().getIdUsuario());	
	}
	
	public void setProveedor(Externo externo) {
		this.externo = externo;
	}
	

	public Externo getProveedor() {
		return externo;
	}



	public ProductoCotizarDataModel getProductoCotizarTableModel() {
		updateListaProductos();
		return productoCotizarDM;
	}



	public void setProductoCotizarTableModel(ProductoCotizarDataModel productoCotizarDM) {
		this.productoCotizarDM = productoCotizarDM;
	}

	
	public InvProductProvDataModel getInvProductProvTableModel() {
		updateListaProveedoresCotizar();
		return invProductProvDM;
	}



	public void setInvProductProvTableModel(InvProductProvDataModel invProductProvDM) {
		this.invProductProvDM = invProductProvDM;
	}


	public CotizarVw getProductoSeleccionado() {
		return productoSeleccionado;
	}



	public void setProductoSeleccionado(CotizarVw productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}



	public List<CotizarVw> getListaProductos() {
		return listaProductos;
	}



	public void setListaProductos(List<CotizarVw> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	
	
	
	
	/**  TO DELETE **/

	
	public List<CatPaises>getPaises(){
		if(tipoProveedor == null || tipoProveedor.equals("nacional")){
			CatPaises pais = new CatPaises();
			CatPaisesId id = new CatPaisesId();
			List<CatPaises> paises = new ArrayList<CatPaises>();
			id.setNombre("México");
			id.setIso("MX");
			pais.setId(id);
			paises.add(pais);
			return paises;
		}else{
			return CatalogosBean.getInstance().getCatPais();
		}
		
	}
	
	public List<CatSepomex>getEstados(){
		return CatalogosBean.getInstance().getCatEstados();
	}



	public String getTipoProveedor() {
		return tipoProveedor;
	}



	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}
	
	public List<CatSepomex>getMunicipios(){
		return CatalogosBean.getInstance().getCatMunicipios(externo.getEstadoCod());
	}
	
	public List<CatSepomex>getColonias(){
		return CatalogosBean.getInstance().getCatColonias(externo.getEstadoCod(),externo.getMunCod());
	}
	
	public List<CatSepomex>getCP(){
		return CatalogosBean.getInstance().getCP(externo.getEstadoCod(),externo.getMunCod(),externo.getColoniaCod());
	}
	
	public List<CatBancos>getBancos(){
		return CatalogosBean.getInstance().getBancos();
	}


	public boolean isDomDistinto() {
		return domDistinto;
	}


	public void setDomDistinto(boolean domDistinto) {
		this.domDistinto = domDistinto;
	}


	public CuentaBanco getCuenta() {
		return cuenta;
	}


	public void setCuenta(CuentaBanco cuenta) {
		this.cuenta = cuenta;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<InvProductProvVw> getListaProveedores() {
		return listaProveedores;
	}


	public void setListaProveedores(List<InvProductProvVw> listaProveedores) {
		this.listaProveedores = listaProveedores;
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


	public List<Usuario> getListaProveedoresSeleccionados() {
		return listaProveedoresSeleccionados;
	}


	public void setListaProveedoresSeleccionados(List<Usuario> listaProveedoresSeleccionados) {
		this.listaProveedoresSeleccionados = listaProveedoresSeleccionados;
	}


	public List<CotizacionProveedor> getListaCotizaciones() {
		return listaCotizaciones;
	}


	public void setListaCotizaciones(List<CotizacionProveedor> listaCotizaciones) {
		this.listaCotizaciones = listaCotizaciones;
	}
	
	
}
