package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.ektdinero.bitacora.beans.ProductoSolCotizacion;
import com.shq.entities.Producto;

public class ProductoSolCotizacionDataModel extends ListDataModel<ProductoSolCotizacion> implements SelectableDataModel<ProductoSolCotizacion> {

	public ProductoSolCotizacionDataModel() {  
    }  
  
    public ProductoSolCotizacionDataModel(List<ProductoSolCotizacion> data) {  
        super(data);  
    }  
	
	@Override
	public ProductoSolCotizacion getRowData(String idFilaSelect) {
		
		int idFila = Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<ProductoSolCotizacion> lista = (List<ProductoSolCotizacion>) getWrappedData();  
         
	        for(ProductoSolCotizacion pro : lista) {  
	            if(pro.getProducto().getId() == idFila)  
	                return pro;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(ProductoSolCotizacion productoSolCotizacion) {
		return productoSolCotizacion.getProducto().getId();
	}

}
