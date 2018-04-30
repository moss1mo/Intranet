package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.Almacen;

public class AlmacenesDAO extends BaseDAO<Almacen>{

	
	   public AlmacenesDAO(){
	        super(Almacen.class);
	    }
	   
	   public void guardarAlmacen(Almacen entity)  {
			this.create(entity);
		}
	   
	   public List<Almacen> getAlmacenes(){	
		   List<Almacen> almacenes = this.findByNativeQuery("SELECT * FROM ALMACEN");
			
		   return almacenes;
		}   
}
