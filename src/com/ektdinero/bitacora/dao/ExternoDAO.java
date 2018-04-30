package com.ektdinero.bitacora.dao;
import java.util.List;
import com.shq.entities.Externo;


public class ExternoDAO extends BaseDAO<Externo>{

	
	   public ExternoDAO(){
	        super(Externo.class);
	    }
	   
	   public void guardarProveedor(Externo entity)  {
			this.create(entity);
		}
	   
	   public List<Externo> getProveedores(){	
		   List<Externo> proveedores = this.findByNativeQuery("SELECT * FROM externo WHERE ACTIVO = 1");
			
		   return proveedores;
		}   
}
