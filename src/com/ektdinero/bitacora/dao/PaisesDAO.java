package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.CatPaises;


public class PaisesDAO extends BaseDAO<CatPaises>{

	
	   public PaisesDAO(){
	        super(CatPaises.class);
	    }
	   
	   
	   public List<CatPaises> getLista(){	
		   List<CatPaises> lista = this.findByNativeQuery("SELECT * FROM CAT_PAISES where iso != 'MX'");	
		   return lista;
		}   
}
