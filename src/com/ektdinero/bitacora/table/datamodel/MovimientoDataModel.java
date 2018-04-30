package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.MovInventario;

public class MovimientoDataModel extends ListDataModel<MovInventario> implements SelectableDataModel<MovInventario> {

	public MovimientoDataModel() {  
    }  
  
    public MovimientoDataModel(List<MovInventario> data) {  
        super(data);  
    }  
	
	@Override
	public MovInventario getRowData(String idFilaSelect) {
		
		int idFila = Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<MovInventario> lista = (List<MovInventario>) getWrappedData();  
         
	        for(MovInventario obj : lista) {  
	            if(obj.getId() == idFila)  
	                return obj;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(MovInventario obj) {
		
		return obj.getId();
	}

}
