package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.ektdinero.bitacora.beans.ProductoSolCotizacionLote;
import com.shq.entities.InventarioLotesVw;

public class InventarioLotesDataModel extends ListDataModel<ProductoSolCotizacionLote> implements SelectableDataModel<ProductoSolCotizacionLote> {

	public InventarioLotesDataModel() {  
    }  
  
    public InventarioLotesDataModel(List<ProductoSolCotizacionLote> data) {  
        super(data);  
    }  
	
	@Override
	public ProductoSolCotizacionLote getRowData(String idFilaSelect) {
		
		 @SuppressWarnings("unchecked")
		List<ProductoSolCotizacionLote> lista = (List<ProductoSolCotizacionLote>) getWrappedData();  
	        for(ProductoSolCotizacionLote obj : lista) {  
	            if(obj.getProductoInvLote().getId().getIdProducto().equals(idFilaSelect))  
	                return obj;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(ProductoSolCotizacionLote obj) {
		return obj.getProductoInvLote().getId().getIdProducto();
	}

}
