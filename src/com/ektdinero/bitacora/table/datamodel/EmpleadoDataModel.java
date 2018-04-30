package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.shq.entities.Empleado;

public class EmpleadoDataModel extends ListDataModel<Empleado> implements SelectableDataModel<Empleado> {

	public EmpleadoDataModel() {  
    }  
  
    public EmpleadoDataModel(List<Empleado> data) {  
        super(data);  
    }  
	
	@Override
	public Empleado getRowData(String idFilaSelect) {
		
		int idFila =  Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<Empleado> listaEmpleados = (List<Empleado>) getWrappedData();  
         
	        for(Empleado empleado : listaEmpleados) {  
	            if(empleado.getIdEmpleado().intValue() == idFila)  
	                return empleado;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(Empleado empleado) {
		return empleado.getIdEmpleado();
	}

}
