package com.ektdinero.bitacora.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ektdinero.bitacora.dao.ProductoDAO;
import com.shq.entities.Producto;

@FacesConverter(value="ProductoConverter")
public class ProductoConverter implements Converter {
	
	private ProductoDAO productoDAO = new ProductoDAO();


	@Override
	/**public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		 FacesContext context = FacesContext.getCurrentInstance();
	        Producto productoMB = (Producto) context.getELContext().getELResolver().getValue(context.getELContext(), null, "resp");
		return productoMB;
	}
	**/
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0 && !value.equalsIgnoreCase("selecciona")) {
            try {
            	for(Producto producto: productoDAO.getProductos()){
            		if(producto.getId() == Integer.valueOf(value))
            		return producto;
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
	        return String.valueOf(((Producto) value).getId());
	}

	
}
