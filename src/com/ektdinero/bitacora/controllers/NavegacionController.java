package com.ektdinero.bitacora.controllers;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

	@ManagedBean
	@SessionScoped
	public class NavegacionController  implements Serializable {

		private static final long serialVersionUID = -6693612186041757548L;

		/**
	     * Redirect to login page.
	     * @return Login page name.
	     */
	    public String redirectToLogin() {
	        return "/public/tienda/compras.xhtml?faces-redirect=true";
	    }
	     
	    /**
	     * Go to login page.
	     * @return Login page name.
	     */
	    public String toLogin() {
	        return "/public/tienda/compras.xhtml";
	    }
	     
	    /**
	     * Redirect to info page.
	     * @return Info page name.
	     */
	    public String redirectToInfo() {
	        return "/info.xhtml?faces-redirect=true";
	    }
	     
	    /**
	     * Go to info page.
	     * @return Info page name.
	     */
	    public String toInfo() {
	        return "/info.xhtml";
	    }
	     
	    /**
	     * Redirect to welcome page.
	     * @return Welcome page name.
	     */
	    public String redirectToWelcome() {
	    	
	        return "../../secured/menu.xhtml?faces-redirect=true";
	    }
	     
	    /**
	     * Go to welcome page.
	     * @return Welcome page name.
	     */
	    public String toWelcome() {
	        return "../../secured/menu.xhtml";
	    }
	    
	    /**
	     * Redirigea la pagina app seleccionada
	     * @return menuApp
	     */
	    public String redirectToMenuApp() {
	        return "/secured/menuApp.xhtml?faces-redirect=true";
	    }
	     
	    /**
	     * va a welcome page.
	     * @return Welcome page name.
	     */
	    public String toMenuApp() {
	        return "/secured/menuApp.xhtml";
	    }
	    
	    /**
	     * Redirigea la pagina app seleccionada
	     * @return menuApp
	     */
	    public String redirectToApps() {
	        return "menu/misApps/misAplicaciones.xhtml?faces-redirect=true";
	    }
	     
	    /**
	     * va a welcome page.
	     * @return Welcome page name.
	     */
	    public String toApps() {
	        return "menu/misApps/misAplicaciones.xhtml";
	    }

		public String toAppMenu() {
			// TODO Auto-generated method stub
			return "/menuApp.xhtml";
		}
		
		  /**
	     * Redirigea la pagina app seleccionada
	     * @return menuApp
	     */
	    public String redirectToAppMenu() {
	        return "../../../menuApp.xhtml?faces-redirect=true";
	    }
	    
	    public String redirectToPublicCompras(){
	    	return "../tienda/productos.xhtml";
	    }
	     
	}
