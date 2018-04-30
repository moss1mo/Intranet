package com.ektdinero.bitacora.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.ektdinero.bitacora.dao.EmpleadoDAO;

import com.ektdinero.bitacora.dao.UsuariosDAO;
import com.shq.entities.Domicilio;
import com.shq.entities.Empleado;
import com.shq.entities.Usuario;
import com.shq.entities.UsuarioRol;
import com.ektdinero.bitacora.table.datamodel.EmpleadoDataModel;
import com.ektdinero.bitacora.table.datamodel.ProveedorDataModel;


@ManagedBean
@SessionScoped
public class EmpleadosController implements Serializable{

	private static final long serialVersionUID = 8568309221535780646L;

	private Usuario usuario = new Usuario();
	private Empleado empleado = new Empleado();
	private UsuariosDAO usuariosDAO = new UsuariosDAO();
	private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	private Empleado empleadoSeleccionado;
	private List<Empleado> listaEmpleados;//validar si necesita
	private EmpleadoDataModel empleadoTableModel;

 

	public EmpleadosController(){
		UsuarioRol role = new UsuarioRol();
		Domicilio domicilio = new Domicilio();
		domicilio.setPrincipal(true);
		empleado.setDomicilio(domicilio);
		usuario.setUsuarioRol(role);
	}
	public void mostrarPantallaRegistro() {
		 try { 
				 FacesContext.getCurrentInstance().getExternalContext().redirect( "/Intranet/secured/subMenu/empleados/registrarEmpleado.xhtml");
		 	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
	

	public void guardarEmpleado(){
		try{
			empleadoDAO.guardarEmpleado(empleado);
			usuario.setEmpleado(empleado);
			usuariosDAO.create(usuario);
			empleado = new Empleado();
			usuario = new Usuario();
		    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empleado registrado exitosamente", "Se ha registrado el empleado correctamente");
		    RequestContext.getCurrentInstance().showMessageInDialog(message);
		 }catch(Exception e){
			  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empleado no registrado", "No se ha podido registrar el empleado, pedimos reportar el error para resolverlo");
		        RequestContext.getCurrentInstance().showMessageInDialog(message);
			 e.printStackTrace();
		 }
		
	}
	
	public void actualizarEmpleado(){
		try{
			empleadoDAO.update(empleado);
			usuariosDAO.update(usuario);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empleado registrado exitosamente", "Se ha registrado el empleado correctamente");
	    	RequestContext.getCurrentInstance().showMessageInDialog(message);
		}catch(Exception e){
		  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empleado no registrado", "No se ha podido registrar el empleado, pedimos reportar el error para resolverlo");
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		 e.printStackTrace();
		}
	}
	
	public EmpleadoDataModel updateListaEmpleados(){
		List<Empleado> listaEmpleados = empleadoDAO.getEmpleados();
		if(listaEmpleados != null){
			return new EmpleadoDataModel(listaEmpleados);
		}
		return new EmpleadoDataModel();
	}
	
	public void cargarDatosUsuario(Usuario usuario){
		this.usuario = usuario;
		//this.usuario = usuariosDAO.find(usuario.getIdUsuario());
		empleado = usuario.getEmpleado();
	}
	
	public void cargarDatosDomicilio(Usuario usuario){
		this.usuario = usuario;
		empleado = usuario.getEmpleado();
		if(empleado.getDomicilio() == null){
			Domicilio domicilio = new Domicilio();
			domicilio.setPrincipal(true);
			empleado.setDomicilio(domicilio);
		}
	}
	
	
	public EmpleadoDataModel getEmpleadoTableModel() {
		empleadoTableModel = updateListaEmpleados();
		return empleadoTableModel;
	}



	public void setEmpleadoTableModel(EmpleadoDataModel empleadoTableModel) {
		this.empleadoTableModel = empleadoTableModel;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}




	public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
