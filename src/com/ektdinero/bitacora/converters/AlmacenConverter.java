package com.ektdinero.bitacora.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ektdinero.bitacora.dao.AlmacenesDAO;
import com.shq.entities.Almacen;

@FacesConverter(value="almacenConverter")
public class AlmacenConverter implements Converter {
	
	private AlmacenesDAO almacenDAO = new AlmacenesDAO();


	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equalsIgnoreCase("selecciona")) {
            try {
            	for(Almacen obj: almacenDAO.getAlmacenes()){
            		if(obj.getIdAlmacen() == Integer.valueOf(value))
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
	        return String.valueOf(((Almacen) value).getIdAlmacen());
	}

	
}
