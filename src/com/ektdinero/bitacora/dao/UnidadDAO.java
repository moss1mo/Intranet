package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.Unidad;


public class UnidadDAO extends BaseDAO<Unidad>{

	
	   public UnidadDAO(){
	        super(Unidad.class);
	    }
	   
	   public void guardar(Unidad entity)  {
			this.create(entity);
		}
	   
	   public List<Unidad> getLista(){	
		   List<Unidad> lista = this.findByNativeQuery("SELECT * FROM UNIDAD");	
		   return lista;
		}   
}
