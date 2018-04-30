package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.CotizarVw;


public class CotizarDAO extends BaseDAO<CotizarVw>{

	
	   public CotizarDAO(){
	        super(CotizarVw.class);
	    }

	   
	   public List<CotizarVw> getProductos(){	
		   List<CotizarVw> productos = this.findByNativeQuery("SELECT CANTIDAD,COSTO_PROM,producto FROM cotizar_vw");
			
		   return productos;
		}   
}
