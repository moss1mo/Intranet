package com.ektdinero.bitacora.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.ektdinero.bitacora.dao.UsuariosDAO;
import com.shq.entities.Usuario;
import com.shq.entities.UsuarioRol;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {


	private static final long serialVersionUID = -4603249595379483344L;
	  private String username;
	  private String password;
	  private String nombreUsuarioLogeado;
	  private Integer tipoUsr = -1;
	  private UsuarioRol rol;
	  private String nombreRol;
	  private Usuario usuarioLogeado;
	  private UsuariosDAO  usuariosDAO = new UsuariosDAO();
	     
	    private boolean loggedIn;
	 
	    @ManagedProperty(value="#{navegacionController}")
	    private NavegacionController navigationBean;

	    public void doLogin() {
	    	
	    		usuarioLogeado = usuariosDAO.autenticaUsuario(username,password);
	    			if (usuarioLogeado != null) {
	                loggedIn = true;
		    		 //RequestContext.getCurrentInstance().closeDialog("/public/login/empleados");
		    		 
	                	nombreUsuarioLogeado = usuarioLogeado.getNombreUsuario();	                
	                
                	if(usuarioLogeado.getUsuarioRol() != null){
    		    		tipoUsr = usuarioLogeado.getUsuarioRol().getIdRol().intValue();
    		    		nombreRol = usuarioLogeado.getUsuarioRol().getNombre();
    		    		rol = usuarioLogeado.getUsuarioRol();
                	}
		    		
		    		 //RequestContext.getCurrentInstance().execute("location.href='"+navigationBean.redirectToWelcome()+"'");
                	if(rol.getCod() != 5){
                		RequestContext.getCurrentInstance().execute("location.href='"+navigationBean.redirectToWelcome()+"'");
                	}else{ 
                		
                		RequestContext.getCurrentInstance().execute("location.href='"+navigationBean.redirectToPublicCompras()+"'");
                	}

		    		 
		    		 
	    			}else{
		    	        username=null;
		    	        password= null;
		    	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login incorrecto", "El usuario y/o la contraseña son incorrectos");  
		    	        RequestContext.getCurrentInstance().showMessageInDialog(message);   
	    				
	    			}
	    			

	     
	         
	    }
	    
	    
	    public void limpiarForm(){
			
	    	username = null;
	    	password = null;
		}
	    

	    public String doLogout() {
	       
	        loggedIn = false;
	        usuarioLogeado=null;
	        username= null;
	        // Set logout message
//	        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
//	        msg.setSeverity(FacesMessage.SEVERITY_INFO);
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("JSESSIONID", null, null);  
//	        FacesContext.getCurrentInstance().addMessage(null, msg);
	         
	        return navigationBean.redirectToLogin();
	    }

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isLoggedIn() {
			return loggedIn;
		}

		public void setLoggedIn(boolean loggedIn) {
			this.loggedIn = loggedIn;
		}

		public NavegacionController getNavigationBean() {
			return navigationBean;
		}

		public void setNavigationBean(NavegacionController navigationBean) {
			this.navigationBean = navigationBean;
		}

		public Integer getTipoUsr() {
			return tipoUsr;
		}

		public void setTipoUsr(Integer tipoUsr) {
			this.tipoUsr = tipoUsr;
		}

		public Usuario getUsuarioLogeado() {
			return usuarioLogeado;
		}

		public void setUsuarioLogeado(Usuario usuarioLogeado) {
			this.usuarioLogeado = usuarioLogeado;
		}

		public String getNombreUsuarioLogeado() {
			return nombreUsuarioLogeado;
		}

		public void setNombreUsuarioLogeado(String nombreUsuarioLogeado) {
			this.nombreUsuarioLogeado = nombreUsuarioLogeado;
		}


		public UsuarioRol getRol() {
			return rol;
		}


		public void setRol(UsuarioRol rol) {
			this.rol = rol;
		}


		public String getNombreRol() {
			return nombreRol;
		}


		public void setNombreRol(String nombreRol) {
			this.nombreRol = nombreRol;
		}

		

	
}
