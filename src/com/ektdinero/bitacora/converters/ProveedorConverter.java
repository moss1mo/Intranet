package com.ektdinero.bitacora.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ektdinero.bitacora.dao.ExternoDAO;
import com.shq.entities.Externo;

@FacesConverter(value="proveedorConverter")
public class ProveedorConverter implements Converter {
	
	private ExternoDAO proveedorDAO = new ExternoDAO();


	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equalsIgnoreCase("selecciona")) {
            try {
            	for(Externo obj: proveedorDAO.getProveedores()){
            		if(obj.getIdExterno().intValue() == Integer.valueOf(value))
            		return obj;
            	}
            	return null;
                
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		 if(value==null || value.equals(""))
	            return null;
	        return String.valueOf(((Externo) value).getIdExterno());
	}

	
}
