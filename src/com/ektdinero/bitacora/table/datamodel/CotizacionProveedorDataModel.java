package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.CotizacionProveedor;

public class CotizacionProveedorDataModel extends ListDataModel<CotizacionProveedor> implements SelectableDataModel<CotizacionProveedor> {

	public CotizacionProveedorDataModel() {  
    }  
  
    public CotizacionProveedorDataModel(List<CotizacionProveedor> data) {  
        super(data);  
    }  
	
	@Override
	public CotizacionProveedor getRowData(String idFilaSelect) {
		
		int idFila = Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<CotizacionProveedor> lista = (List<CotizacionProveedor>) getWrappedData();  
         
	        for(CotizacionProveedor pro : lista) {  
	            if(pro.getId().intValue() == idFila)  
	                return pro;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(CotizacionProveedor solicitud) {
		return solicitud.getId();
	}

}
