package com.ektdinero.bitacora.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.ektdinero.bitacora.beans.AlmacenBean;
import com.ektdinero.bitacora.beans.CatalogosBean;
import com.ektdinero.bitacora.beans.ProductoSolCotizacion;
import com.ektdinero.bitacora.dao.AlmacenesDAO;
import com.ektdinero.bitacora.dao.InventarioDAO;
import com.ektdinero.bitacora.dao.ProSolCotizacionDAO;
import com.ektdinero.bitacora.dao.ProductoDAO;
import com.ektdinero.bitacora.dao.ExternoDAO;
import com.ektdinero.bitacora.dao.SolCotizacionDAO;
import com.ektdinero.bitacora.dao.UsuariosDAO;
import com.ektdinero.bitacora.table.datamodel.AlmacenDataModel;
import com.ektdinero.bitacora.table.datamodel.InventarioDataModel;
import com.ektdinero.bitacora.table.datamodel.ProductoDataModel;
import com.ektdinero.bitacora.table.datamodel.ProductoSolCotizacionDataModel;
import com.ektdinero.bitacora.table.datamodel.ProveedorDataModel;
import com.shq.entities.Almacen;
import com.shq.entities.CatPaises;
import com.shq.entities.CatPaisesId;
import com.shq.entities.CatSepomex;
import com.shq.entities.Externo;
import com.shq.entities.InventarioVw;
import com.shq.entities.Producto;
import com.shq.entities.SolCotizacion;
import com.shq.entities.Usuario;
import com.shq.entities.UsuarioRol;
import com.shq.utils.Utileria;

@ManagedBean
@SessionScoped
public class InventarioController implements Serializable {

	private static final long serialVersionUID = 8568309221535780646L;

	private Double tc;
	private String itemAltaInventario;
	private boolean temporal;
	private AlmacenBean almacen = new AlmacenBean();
	private Producto producto = new Producto();
	private Externo proveedor = new Externo();

	private Almacen almacenEnt = new Almacen();
	private AlmacenesDAO almacenDAO = new AlmacenesDAO();
	private ProductoDAO productoDAO = new ProductoDAO();
	private ExternoDAO proveedorDAO = new ExternoDAO();
	private InventarioDAO inventarioDAO = new InventarioDAO();
	private UsuariosDAO usuariosDAO = new UsuariosDAO();

	private AlmacenDataModel almacenTableModel;
	private ProductoSolCotizacionDataModel productoCotizarDataModel;
	private List<ProductoSolCotizacion> listaProductosCotizarSeleccionados;
	private Almacen almacenSeleccionada;
	private Producto productoSeleccionado;
	private List<Producto> listaProductos;
	private List<Producto> listaProductosSeleccionados;
	private ProductoDataModel productoTableModel;
	private ProveedorDataModel proveedorTableModel;
	private InventarioDataModel inventarioTableModel;
	private Externo proveedorSeleccionado;
	private List<Externo> listaProveedores;
	private SolCotizacion solCotizacion = new SolCotizacion();
	private Usuario usuarioCotizacion = new Usuario();

	private List<InventarioVw> listaInventario;
	private InventarioVw inventarioVw;
	private String tipoProveedor;

	private SolCotizacionDAO solCotizacionDAO = new SolCotizacionDAO();
	private ProSolCotizacionDAO proSolCotizacionDAO = new ProSolCotizacionDAO();
	


	public void mostrarPantallaRegistro() {
		try {
			if (itemAltaInventario.equalsIgnoreCase("producto")) {
				listaProductos = new ArrayList<Producto>();
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/Intranet/secured/subMenu/inventario/altas/registrarInventario.xhtml");
			}

			if (itemAltaInventario.equalsIgnoreCase("almacen")) {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/Intranet/secured/subMenu/inventario/altas/registrarAlmacen.xhtml");
			}

			if (itemAltaInventario.equalsIgnoreCase("proveedor")) {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/Intranet/secured/subMenu/inventario/altas/registrarProveedor.xhtml");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getItemAltaInventario() {
		return itemAltaInventario;
	}

	public void setItemAltaInventario(String itemAltaInventario) {
		if (itemAltaInventario.equalsIgnoreCase("producto")) {
			updateListaAlmacenes();
		}
		this.itemAltaInventario = itemAltaInventario;
	}

	public boolean isTemporal() {
		return temporal;
	}

	public void setTemporal(boolean temporal) {
		this.temporal = temporal;
	}

	public void updateListas() {
		updateListaAlmacenes();
		updateListaProductos();
	}

	public AlmacenDataModel updateListaAlmacenes() {
		List<Almacen> listAlmacen = almacenDAO.getAlmacenes();
		if (listAlmacen != null) {
			return almacenTableModel = new AlmacenDataModel(listAlmacen);
		}
		return almacenTableModel = new AlmacenDataModel();
	}

	public ProductoDataModel updateListaProductos() {
		List<Producto> listProducto = productoDAO.getProductos();
		if (listProducto != null) {
			return productoTableModel = new ProductoDataModel(listProducto);
		}
		return productoTableModel = new ProductoDataModel();
	}
	
	public ProductoSolCotizacionDataModel updateListaSolCotProductos() {
		List<Producto> listProducto = productoDAO.getProductos();
		List<ProductoSolCotizacion> listProducCot = new ArrayList<>();
		if (listProducto != null) {
			for(Producto pro:listProducto){
				ProductoSolCotizacion productoSol = new ProductoSolCotizacion();
				productoSol.setProducto(pro);
				productoSol.setCantidad(new Long(0));
				listProducCot.add(productoSol);
			}
			
			return productoCotizarDataModel = new ProductoSolCotizacionDataModel(listProducCot);
		}
		return productoCotizarDataModel = new ProductoSolCotizacionDataModel();
	}

	public ProveedorDataModel updateListaProveedores() {
		List<Externo> listaProveedores = proveedorDAO.getProveedores();
		if (listaProveedores != null) {
			return proveedorTableModel = new ProveedorDataModel(listaProveedores);
		}
		return proveedorTableModel = new ProveedorDataModel();
	}

	public InventarioDataModel updateListaInventario() {
		listaInventario = inventarioDAO.getInventario();
		if (listaInventario != null) {
			return setInventarioTableModel(new InventarioDataModel(listaInventario));
		}
		return setInventarioTableModel(new InventarioDataModel());
	}

	public void guardarAlmacen() {

		try {
			almacenEnt.setNombre(almacen.getNombre());
			almacenEnt.setDireccion(almacen.getDireccion());
			if (temporal) {
				almacenEnt.setTipoAlmacen("Temporal");
				almacenEnt.setFechaFinAlmacen(almacen.getFechaFinAlmacen());
			} else {
				almacenEnt.setTipoAlmacen("Indefinido");
			}
			almacenEnt.setFechaFinAlmacen(almacen.getFechaFinAlmacen());
			almacenEnt.setNombreContacto(almacen.getNombreContacto());
			almacenEnt.setHorarioAtencion(almacen.getHorarioAtencion());
			almacenEnt.setTelContacto(almacen.getTelContacto());
			almacenEnt.setCorreoContacto(almacen.getCorreoContacto());

			almacenDAO.guardarAlmacen(almacenEnt);
			almacenEnt = new Almacen();
			almacen = new AlmacenBean();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Almacén registrada exitosamente",
					"Se ha registrado el almacén correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Almacén no registrada",
					"No se ha podido registrar el almacén, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}

	}

	public void guardarProveedor() {
		try {
			proveedor.setFechaAlta(new Date());
			proveedorDAO.guardarProveedor(proveedor);
			proveedor = new Externo();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor registrada exitosamente",
					"Se ha registrado el almacén correctamente");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Proveedor no registrada",
					"No se ha podido registrar el almacén, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}

	}
	
	
	public void guardarSolCotizacion(Usuario usuario) {
		try {
			
			List<com.shq.entities.ProductoSolCotizacion> listaProductosSolicitud = new ArrayList<com.shq.entities.ProductoSolCotizacion>();
			
			if(usuario == null){
				usuario = new Usuario();
				Externo externo = new Externo();
				
				externo.setNombre(solCotizacion.getNombre());
				externo.setCorreoContacto(solCotizacion.getCorreo());
				externo.setRfc(solCotizacion.getRfc());
				externo.setTelContacto(solCotizacion.getTelefono());
				
				externo.setPais(solCotizacion.getPais());
				externo.setEstado(solCotizacion.getEstado());
				externo.setMunicipio(solCotizacion.getMunicipio());
				externo.setColonia(solCotizacion.getColonia());
				externo.setCalle(solCotizacion.getCalle());
				externo.setCp(solCotizacion.getCp());
				externo.setReferencias(solCotizacion.getReferencias());
				externo.setNumExt(solCotizacion.getNumExt());
				externo.setNumInt(solCotizacion.getNumInt());
				
				externo.setClave(usuarioCotizacion.getNombreUsuario());
				externo.setActivo(Boolean.TRUE);
				externo.setFechaAlta(new Date());
				proveedorDAO.guardarProveedor(externo);
				usuario.setExterno(externo);
				usuario.setNombreUsuario(usuarioCotizacion.getNombreUsuario());
				usuario.setPassword(usuarioCotizacion.getPassword());
				UsuarioRol role = new UsuarioRol();
				role.setIdRol(new BigDecimal(6));
				usuario.setUsuarioRol(role);
				usuariosDAO.create(usuario);
			}
				
			
			if(listaProductosCotizarSeleccionados.size()>0){
				solCotizacion.setUsuarioByIdExterno(usuario);
				solCotizacion.setApellidoPaterno("");
				solCotizacion.setApellidoMaterno("");
				solCotizacion.setFechaSol(new Date());
				String direccionFiscal = solCotizacion.getCalleFiscal()+ " "+solCotizacion.getNumExtFiscal()+" "+solCotizacion.getNumIntFiscal()+", CP "+solCotizacion.getCpFiscal()+", "+
				CatalogosBean.getInstance().getCatColonia(solCotizacion.getColoniaFiscal(), solCotizacion.getEstadoFiscal(), solCotizacion.getMunFiscal()).getId().getDAsenta()+", "+
				CatalogosBean.getInstance().getCatMunicipio(solCotizacion.getMunFiscal(),solCotizacion.getEstadoFiscal()).getId().getDMnpio()+", "+
				CatalogosBean.getInstance().getCatEstado(solCotizacion.getEstadoFiscal()).getId().getDEstado() +", "+
				solCotizacion.getPaisFiscal();
				String direccionEntrega = solCotizacion.getCalle()+ " "+solCotizacion.getNumExt()+" "+solCotizacion.getNumInt()+", CP "+solCotizacion.getCp()+", "+
						CatalogosBean.getInstance().getCatColonia(solCotizacion.getColonia(), solCotizacion.getEstado(), solCotizacion.getMunicipio()).getId().getDAsenta()+", "+
						CatalogosBean.getInstance().getCatMunicipio(solCotizacion.getMunicipio(),solCotizacion.getEstado()).getId().getDMnpio()+", "+
						CatalogosBean.getInstance().getCatEstado(solCotizacion.getEstado()).getId().getDEstado() +", "+
						solCotizacion.getPais();
				solCotizacion.setDireccionFiscal(direccionFiscal);
				solCotizacion.setDireccionEntrega(direccionEntrega);
				solCotizacion.setStatus("Solicitud de cotización");
				solCotizacionDAO.guardarSolicitud(solCotizacion);
				for(ProductoSolCotizacion producto:listaProductosCotizarSeleccionados){
					com.shq.entities.ProductoSolCotizacion productoCot = new com.shq.entities.ProductoSolCotizacion();
					productoCot.setCantidad(producto.getCantidad().longValue());
					productoCot.setProducto(producto.getProducto());
					productoCot.setSolCotizacion(solCotizacion);
					listaProductosSolicitud.add(productoCot);
				}
				proSolCotizacionDAO.guardarProductos(listaProductosSolicitud);
				proveedor = new Externo();
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud de cotización registrada exitosamente",
						"Se ha registrado la solicitud de cotización correctamente");
				RequestContext.getCurrentInstance().showMessageInDialog(message);
				updateListaSolCotProductos();
				solCotizacion= new SolCotizacion();
			}else{
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al intentar enviar la solicitud",
						"No se puede solicitar una cotización sin productos seleccionados");
				RequestContext.getCurrentInstance().showMessageInDialog(message);
			}
			
			
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud de cotización no registrada",
					"No se ha podido registrar la solicitud de cotización, pedimos reportar el error para resolverlo");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			e.printStackTrace();
		}

	}

	

	public void crearListaProductos() {
		listaProductos = new ArrayList<Producto>();
	}

	public void agregarProducto() {
		listaProductos.add(producto);
		producto = new Producto();
	}

	public void registrarListaProductos() {
		if (listaProductos != null && listaProductos.size() > 0) {
			productoDAO.guardarProductos(listaProductos);

		}
	}

	public AlmacenBean getAlmacen() {
		return almacen;
	}

	public void setAlmacen(AlmacenBean almacen) {
		this.almacen = almacen;
	}

	public AlmacenDataModel getAlmacenTableModel() {
		updateListaAlmacenes();
		return almacenTableModel;
	}

	public void setAlmacenTableModel(AlmacenDataModel almacenTableModel) {
		this.almacenTableModel = almacenTableModel;
	}

	public Almacen getAlmacenSeleccionada() {
		return almacenSeleccionada;
	}
	
	public void setSolCotDataModel(ProductoSolCotizacionDataModel productoCotizarDataModel) {
		this.productoCotizarDataModel = productoCotizarDataModel;
	}

	
	public ProductoSolCotizacionDataModel geProductoSolCotDataModel() {
		if(productoCotizarDataModel == null){
			updateListaSolCotProductos();
		}
		return productoCotizarDataModel;
	}
	

	public void setAlmacenSeleccionada(Almacen almacenSeleccionada) {
		this.almacenSeleccionada = almacenSeleccionada;
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
		updateListaProductos();
		return productoTableModel;
	}

	public void setProductoTableModel(ProductoDataModel productoTableModel) {
		this.productoTableModel = productoTableModel;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public ProveedorDataModel getProveedorTableModel() {
		updateListaProveedores();
		return proveedorTableModel;
	}

	public void setProveedorTableModel(ProveedorDataModel proveedorTableModel) {
		this.proveedorTableModel = proveedorTableModel;
	}

	public Externo getProveedorSeleccionado() {
		return proveedorSeleccionado;
	}

	public void setProveedorSeleccionado(Externo proveedorSeleccionado) {
		this.proveedorSeleccionado = proveedorSeleccionado;
	}

	public List<Externo> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(List<Externo> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public List<InventarioVw> getListaInventario() {
		return listaInventario;
	}

	public void setListaInventario(List<InventarioVw> listaInventario) {
		this.listaInventario = listaInventario;
	}

	public InventarioDataModel getInventarioTableModel() {
		updateListaInventario();
		return inventarioTableModel;
	}

	public InventarioDataModel setInventarioTableModel(InventarioDataModel inventarioTableModel) {
		this.inventarioTableModel = inventarioTableModel;
		return inventarioTableModel;
	}

	public InventarioVw getInventarioVw() {
		return inventarioVw;
	}

	public void setInventarioVw(InventarioVw inventarioVw) {
		this.inventarioVw = inventarioVw;
	}

	public List<CatPaises> getPaises() {
		if (tipoProveedor == null || tipoProveedor.equals("nacional")) {
			CatPaises pais = new CatPaises();
			CatPaisesId id = new CatPaisesId();
			List<CatPaises> paises = new ArrayList<CatPaises>();
			id.setNombre("México");
			id.setIso("MX");
			pais.setId(id);
			paises.add(pais);
			return paises;
		} else {
			return CatalogosBean.getInstance().getCatPais();
		}

	}

	public List<CatSepomex> getEstados() {
		return CatalogosBean.getInstance().getCatEstados();
	}

	public String getTipoProveedor() {
		return tipoProveedor;
	}

	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}

	public List<CatSepomex> getMunicipios() {
		return CatalogosBean.getInstance().getCatMunicipios(proveedor.getEstadoCod());
	}

	public List<CatSepomex> getColonias() {
		return CatalogosBean.getInstance().getCatColonias(proveedor.getEstadoCod(), proveedor.getMunCod());
	}

	public List<CatSepomex> getCP() {
		return CatalogosBean.getInstance().getCP(proveedor.getEstadoCod(), proveedor.getMunCod(),
				proveedor.getColoniaCod());
	}

	public List<Producto> getListaProductosSeleccionados() {
		return listaProductosSeleccionados;
	}

	public void setListaProductosSeleccionados(List<Producto> listaProductosSeleccionados) {
		this.listaProductosSeleccionados = listaProductosSeleccionados;
	}

	public List<ProductoSolCotizacion> getListaProductosCotizarSeleccionados() {
		return listaProductosCotizarSeleccionados;
	}

	public void setListaProductosCotizarSeleccionados(List<ProductoSolCotizacion> listaProductosCotizarSeleccionados) {
		this.listaProductosCotizarSeleccionados = listaProductosCotizarSeleccionados;
	}

	public SolCotizacion getSolCotizacion() {
		return solCotizacion;
	}

	public void setSolCotizacion(SolCotizacion solCotizacion) {
		this.solCotizacion = solCotizacion;
	}

	public Double getTc() {
		return Utileria.getTC();
	}

	public void setTc(Double tc) {
		this.tc = tc;
	}

	public Usuario getUsuarioCotizacion() {
		return usuarioCotizacion;
	}

	public void setUsuarioCotizacion(Usuario usuarioCotizacion) {
		this.usuarioCotizacion = usuarioCotizacion;
	}

}
