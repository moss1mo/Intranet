package com.ektdinero.bitacora.table.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;
import com.shq.entities.Usuario;

public class UsuarioDataModel extends ListDataModel<Usuario> implements SelectableDataModel<Usuario> {

	public UsuarioDataModel() {  
    }  
  
    public UsuarioDataModel(List<Usuario> data) {  
        super(data);  
    }  
	
	@Override
	public Usuario getRowData(String idFilaSelect) {
		
		int idFila = Integer.getInteger(idFilaSelect);
		 @SuppressWarnings("unchecked")
		List<Usuario> lista = (List<Usuario>) getWrappedData();  
         
	        for(Usuario obj : lista) {  
	            if(obj.getIdUsuario().intValue() == idFila)  
	                return obj;  
	        }  
	          
	        return null;  
	}

	@Override
	public Object getRowKey(Usuario usuario) {
		
		return usuario.getIdUsuario();
	}
}
