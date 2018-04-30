package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.Externo;

public class ProveedorDataModel extends ListDataModel<Externo> implements SelectableDataModel<Externo> {

	public ProveedorDataModel() {  
    }  
  
    public ProveedorDataModel(List<Externo> data) {  
        super(data);  
    }  
	
	@Override
	public Externo getRowData(String idFilaSelect) {
		
		int idFila =  Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<Externo> listaProveedores = (List<Externo>) getWrappedData();  
         
	        for(Externo proveedor : listaProveedores) {  
	            if(proveedor.getIdExterno().intValue() == idFila)  
	                return proveedor;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(Externo proveedor) {
		
		return proveedor.getIdExterno();
	}

}
