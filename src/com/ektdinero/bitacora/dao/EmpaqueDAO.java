package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.Empaque;


public class EmpaqueDAO extends BaseDAO<Empaque>{

	
	   public EmpaqueDAO(){
	        super(Empaque.class);
	    }
	   
	   public void guardar(Empaque entity)  {
			this.create(entity);
		}
	   
	   public List<Empaque> getLista(){	
		   List<Empaque> lista = this.findByNativeQuery("SELECT * FROM EMPAQUE");	
		   return lista;
		}   
}
