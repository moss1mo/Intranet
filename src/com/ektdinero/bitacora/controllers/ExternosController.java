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
import org.primefaces.event.FlowEvent;

import com.ektdinero.bitacora.beans.CatalogosBean;
import com.ektdinero.bitacora.dao.ExternoDAO;
import com.ektdinero.bitacora.dao.UsuariosDAO;
import com.shq.entities.CatBancos;
import com.shq.entities.CatPaises;
import com.shq.entities.CatPaisesId;
import com.shq.entities.CatSepomex;
import com.shq.entities.CuentaBanco;
import com.shq.entities.Domicilio;
import com.shq.entities.Externo;
import com.shq.entities.Usuario;
import com.shq.entities.UsuarioRol;
import com.ektdinero.bitacora.table.datamodel.ProveedorDataModel;


@ManagedBean
@SessionScoped
public class ExternosController implements Serializable{

	private static final long serialVersionUID = 8568309221535780646L;

	private Usuario usuario = new Usuario();
	private Externo proveedor = new Externo();
	private UsuariosDAO usuariosDAO = new UsuariosDAO();
	private ExternoDAO proveedorDAO = new ExternoDAO();
	private ProveedorDataModel proveedorTableModel;
	private Externo proveedorSeleccionado;
	private List<Externo> listaProveedores;
	private List<Externo> listaProveedoresFiltrados;
	private String tipoProveedor;
	private boolean domDistinto;
	private CuentaBanco cuenta = new CuentaBanco();
    private boolean skip;

 

	public void mostrarPantallaRegistro() {
		 try { 
				 FacesContext.getCurrentInstance().getExternalContext().redirect( "/Intranet/secured/subMenu/inventario/altas/registrarProveedor.xhtml");
		 	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
	public ProveedorDataModel updateListaProveedores(){
		this.listaProveedores = proveedorDAO.getProveedores();
		if(listaProveedores != null){
			return  proveedorTableModel = new ProveedorDataModel(listaProveedores);
		}
		return proveedorTableModel = new ProveedorDataModel();
	}
	
	public void cargarDatosProveedor(Externo proveedor){
		proveedorSeleccionado = proveedor;
		if(proveedorSeleccionado.getPaisCod().equalsIgnoreCase("mx")){
			tipoProveedor = "nacional";
		}else{
			tipoProveedor = "extranjero";
		}
		
	}
	
	

	
	
	public void cargarDatosUsuario(Usuario usuario){
		this.usuario = usuario;
		proveedor = usuario.getExterno();
	}
	
	public void cargarDatosDomicilio(Usuario usuario){
		this.usuario = usuario;
		proveedor = usuario.getExterno();
		if(proveedor.getDomicilio() == null){
			Domicilio domicilio = new Domicilio();
			domicilio.setPrincipal(true);
			proveedor.setDomicilio(domicilio);
		}
	}
	

	
	
	public void guardarProveedor(){
		try{
			proveedor.setFechaAlta(new Date());
			proveedorDAO.guardarProveedor(proveedor);
			usuario.setExterno(proveedor);
			UsuarioRol role = new UsuarioRol();
			role.setIdRol(new BigDecimal(4));
			usuario.setUsuarioRol(role);
			usuariosDAO.create(usuario);
			proveedor = new Externo();
			usuario = new Usuario();
		    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario externo registrada exitosamente", "Se ha registrado al usuario externo correctamente");
		    RequestContext.getCurrentInstance().showMessageInDialog(message);
		 }catch(Exception e){
			  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario externo no registrada", "No se ha podido registrar al usuario externo, pedimos reportar el error para resolverlo");
		        RequestContext.getCurrentInstance().showMessageInDialog(message);
			 e.printStackTrace();
		 }
		
	}
	
	public void actualizarProveedor(){
		try{
			proveedorDAO.update(proveedor);
			usuariosDAO.update(usuario);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor actualizado exitosamente", "Se ha actualizado el proveedor correctamente");
	    	RequestContext.getCurrentInstance().showMessageInDialog(message);
		}catch(Exception e){
		  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar proveedor", "No se ha podido actualizar el proveedor, pedimos reportar el error para resolverlo");
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		 e.printStackTrace();
		}
	}
	
   public void eliminarProveedor(Externo proveedor){
	   try{
		   proveedor.setActivo(false);
		   String query = "SELECT * FROM USUARIO WHERE ID_EXTERNO = "+proveedor.getIdExterno();
		   List<Usuario> usuarios = usuariosDAO.findByNativeQuery(query);
		  if(usuarios != null && usuarios.size() > 0){
			  Usuario usuario =  usuarios.get(0);
			   usuario.setActivo(false);
			   usuariosDAO.update(usuario);
		  }
		  
		   proveedorDAO.update(proveedor);
		   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor eliminado exitosamente", "Se ha actualizado el proveedor correctamente");
	       RequestContext.getCurrentInstance().showMessageInDialog(message);
		}catch(Exception e){
		  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar proveedor", "No se ha podido actualizar el proveedor, pedimos reportar el error para resolverlo");
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		 e.printStackTrace();
		}
   }
	
	
	public void setProveedor(Externo proveedor) {
		this.proveedor = proveedor;
	}
	

	public Externo getProveedor() {
		return proveedor;
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
		return CatalogosBean.getInstance().getCatMunicipios(proveedor.getEstadoCod());
	}
	
	public List<CatSepomex>getColonias(){
		return CatalogosBean.getInstance().getCatColonias(proveedor.getEstadoCod(),proveedor.getMunCod());
	}
	
	public List<CatSepomex>getCP(){
		return CatalogosBean.getInstance().getCP(proveedor.getEstadoCod(),proveedor.getMunCod(),proveedor.getColoniaCod());
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
	
	public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;
            return "confirmPro";
        }
        else {
            return event.getNewStep();
        }
    }


	public List<Externo> getListaProveedoresFiltrados() {
		return listaProveedoresFiltrados;
	}


	public void setListaProveedoresFiltrados(List<Externo> listaProveedoresFiltrados) {
		this.listaProveedoresFiltrados = listaProveedoresFiltrados;
	}
	
	
}
