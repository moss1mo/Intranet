package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.Almacen;

public class AlmacenDataModel extends ListDataModel<Almacen> implements SelectableDataModel<Almacen> {

	public AlmacenDataModel() {  
    }  
  
    public AlmacenDataModel(List<Almacen> data) {  
        super(data);  
    }  
	
	@Override
	public Almacen getRowData(String idFilaSelect) {
		
		int idFila = Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<Almacen> listaAlmacenes = (List<Almacen>) getWrappedData();  
         
	        for(Almacen almacen : listaAlmacenes) {  
	            if(almacen.getIdAlmacen() == idFila)  
	                return almacen;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(Almacen almacen) {
		
		return almacen.getIdAlmacen();
	}

}
