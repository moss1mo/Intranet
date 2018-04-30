package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.CatBancos;

public class BancosDAO extends BaseDAO<CatBancos>{

	
	   public BancosDAO(){
	        super(CatBancos.class);
	    }
	   
	   
	   public List<CatBancos> getBancos(){	
		   List<CatBancos> lista = this.findByNativeQuery("SELECT * FROM cat_bancos ORDER BY NOMBRE");
		   return lista;
		}   
	   

}
