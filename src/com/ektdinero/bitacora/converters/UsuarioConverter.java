package com.ektdinero.bitacora.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.shq.entities.Usuario;

@FacesConverter(value="UsuarioConverter")
public class UsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		 FacesContext context = FacesContext.getCurrentInstance();
	        Usuario userMB = (Usuario) context.getELContext().getELResolver().getValue(context.getELContext(), null, "resp");
	 
	        
		return userMB.getNombreUsuario();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		 if(value==null || value.equals(""))
	            return null;
	        return ((Usuario)value).getNombreUsuario();
	}

	
}
