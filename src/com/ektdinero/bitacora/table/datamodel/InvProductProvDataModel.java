package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.InvProductProvVw;

public class InvProductProvDataModel extends ListDataModel<InvProductProvVw> implements SelectableDataModel<InvProductProvVw> {

	public InvProductProvDataModel() {  
    }  
  
    public InvProductProvDataModel(List<InvProductProvVw> data) {  
        super(data);  
    }  
	
	@Override
	public InvProductProvVw getRowData(String idFilaSelect) {
		
		 @SuppressWarnings("unchecked")
		List<InvProductProvVw> lista = (List<InvProductProvVw>) getWrappedData();  
         
	        for(InvProductProvVw obj : lista) {  
	            if(obj.getId().getProducto().equals(idFilaSelect))  
	                return obj;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(InvProductProvVw obj) {
		return obj.getId();
	}

}
