package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;
import com.shq.entities.SolCotizacion;

public class SolicitudCotizacionDataModel extends ListDataModel<SolCotizacion> implements SelectableDataModel<SolCotizacion> {

	public SolicitudCotizacionDataModel() {  
    }  
  
    public SolicitudCotizacionDataModel(List<SolCotizacion> data) {  
        super(data);  
    }  
	
	@Override
	public SolCotizacion getRowData(String idFilaSelect) {
		
		int idFila = Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<SolCotizacion> lista = (List<SolCotizacion>) getWrappedData();  
         
	        for(SolCotizacion pro : lista) {  
	            if(pro.getId() == idFila)  
	                return pro;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(SolCotizacion solicitud) {
		return solicitud.getId();
	}

}
