package com.ektdinero.bitacora.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ektdinero.bitacora.dao.MotivoMovimientoDAO;
import com.shq.entities.MotivoMov;

@FacesConverter(value="motivoConverter")
public class MotivoConverter implements Converter {
	
	private MotivoMovimientoDAO motivoDAO = new MotivoMovimientoDAO();


	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equalsIgnoreCase("selecciona")) {
            try {
            	for(MotivoMov obj: motivoDAO.getLista()){
            		if(obj.getId() == Integer.valueOf(value))
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
	        return String.valueOf(((MotivoMov) value).getId());
	}

	
}