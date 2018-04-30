package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.Producto;

public class ProductoDataModel extends ListDataModel<Producto> implements SelectableDataModel<Producto> {

	public ProductoDataModel() {  
    }  
  
    public ProductoDataModel(List<Producto> data) {  
        super(data);  
    }  
	
	@Override
	public Producto getRowData(String idFilaSelect) {
		
		int idFila = Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<Producto> lstProductos = (List<Producto>) getWrappedData();  
         
	        for(Producto producto : lstProductos) {  
	            if(producto.getId() == idFila)  
	                return producto;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(Producto producto) {
		
		return producto.getId();
	}

}
