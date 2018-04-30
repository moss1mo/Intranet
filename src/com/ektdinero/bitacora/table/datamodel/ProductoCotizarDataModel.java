package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.CotizarVw;

public class ProductoCotizarDataModel extends ListDataModel<CotizarVw> implements SelectableDataModel<CotizarVw> {

	public ProductoCotizarDataModel() {  
    }  
  
    public ProductoCotizarDataModel(List<CotizarVw> data) {  
        super(data);  
    }  
	
	@Override
	public CotizarVw getRowData(String idFilaSelect) {
		
		 @SuppressWarnings("unchecked")
		List<CotizarVw> lista = (List<CotizarVw>) getWrappedData();  
         
	        for(CotizarVw obj : lista) {  
	            if(obj.getId().getProducto().equals(idFilaSelect))  
	                return obj;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(CotizarVw obj) {
		return obj.getId();
	}

}
