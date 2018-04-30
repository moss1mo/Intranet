package com.ektdinero.bitacora.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ektdinero.bitacora.beans.SingletonOpciones;
import com.ektdinero.bitacora.dao.UsuariosDAO;
import com.shq.entities.Usuario;
import com.ektdinero.bitacora.table.datamodel.UsuarioDataModel;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -2812536828422798684L;
	
	private Usuario usuario = new Usuario();
	private Usuario usuarioRegistro = new Usuario();
	private Usuario usuarioSeleccionado;
	private UsuariosDAO usuariosDAO = new UsuariosDAO();
	private SingletonOpciones singletonOpc;
	
	
	
	
	 public String  recuperarDatosUsuario(int idUsuario){
			

		 //usuario =usuariosDAO.find(new BigDecimal(idUsuario));
		 usuario =usuariosDAO.obtenerUsuarioPorID(new BigDecimal(idUsuario));
		 return "/menu/miPerfil/misDatos.xhtml";
	 } 

	 
	 public List<String> recuperarListaTodosUsuario(String queryBusqueda){
			List<String> nombresUsuarios = new ArrayList<String>();
			List<Usuario> usuarios =  usuariosDAO.getUsuariosParaAsignacionApps(queryBusqueda);
		
		
				for(Usuario usr : usuarios){
				nombresUsuarios.add(usr.getNombreUsuario());
				
				}
			
			return nombresUsuarios;
		}
	 


	 
	 public void limpiarForm(){
		 usuarioRegistro = new Usuario();
		}
	 

	 
	 
	 public UsuarioDataModel recuperarListaTodosUsuario(){
			List<Usuario> usuarios =  usuariosDAO.getTodosUsuarios();
			
			if(usuarios != null){
				return  new UsuarioDataModel(usuarios);
			}
			return null;
		}
	 
	 
	 
	 public List<String> getListaDeRoles(){
			singletonOpc = SingletonOpciones.getInstance();
			return singletonOpc.getListaRol();
		}
	 
	 public void borrarIntegrante(){
		 usuariosDAO.delete(usuarioSeleccionado.getIdUsuario());
			
		}
	 
	 public void actualizarIntegrante(){
		 try{
			 usuariosDAO.update(usuarioSeleccionado);
		        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario actualizado exitosamente", "Se han guardado los cambios correctamente");
		        RequestContext.getCurrentInstance().showMessageInDialog(message);
		 }catch(Exception e){
			  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Los cambios no se guardaron", "No se pudieron guardar los cambios realizados, pedimos reportar el error para resolverlo");
		        RequestContext.getCurrentInstance().showMessageInDialog(message);
			 e.printStackTrace();
		 }
	
		}
	 
	 public void  guardarIntegrante(){
		 try{
			 usuario.setIdUsuario(new BigDecimal(2));
			 usuariosDAO.create(usuarioRegistro);
			 usuarioRegistro = new Usuario();
		        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado al usuario correctamente");
		        RequestContext.getCurrentInstance().showMessageInDialog(message);
		 }catch(Exception e){
			  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro erroneo", "No se pudo registrar al usuario, pedimos reportar el error para resolverlo");
		        RequestContext.getCurrentInstance().showMessageInDialog(message);
			 e.printStackTrace();
		 }
		
	 }
	
	 
	 public void guardarCambiosUsuario(){
		 try{
			 
			 usuariosDAO.update(usuario);
		        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambios guardados exitosamente", "Se han guardado los cambios correctamente");
		        RequestContext.getCurrentInstance().showMessageInDialog(message);
		 }catch(Exception e){
			  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Los cambios no se guardaron", "No se pudieron guardar los cambios realizados, pedimos reportar el error para resolverlo");
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



	public Usuario getUsuarioRegistro() {
		return usuarioRegistro;
	}


	public void setUsuarioRegistro(Usuario usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}


	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
}
