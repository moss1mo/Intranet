package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.InventarioVw;

public class InventarioDataModel extends ListDataModel<InventarioVw> implements SelectableDataModel<InventarioVw> {

	public InventarioDataModel() {  
    }  
  
    public InventarioDataModel(List<InventarioVw> data) {  
        super(data);  
    }

	@Override
	public InventarioVw getRowData(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getRowKey(InventarioVw arg0) {
		// TODO Auto-generated method stub
		return null;
	}  
	

}
