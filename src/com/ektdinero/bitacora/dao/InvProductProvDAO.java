package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.InvProductProvVw;


public class InvProductProvDAO extends BaseDAO<InvProductProvVw>{

	
	   public InvProductProvDAO(){
	        super(InvProductProvVw.class);
	    }

	   
	   public List<InvProductProvVw> getProveedores(){	
		   List<InvProductProvVw> proveedores = this.findByNativeQuery("SELECT * FROM inv_product_prov_vw");	
		   return proveedores;
		}


	public List<InvProductProvVw> getProveedoresByProducto(String productSelect) {
		 List<InvProductProvVw> proveedores = this.findByNativeQuery("SELECT * FROM inv_product_prov_vw WHERE producto = '"+productSelect+"'");	
		 return proveedores;
	}   
}
