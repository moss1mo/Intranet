package com.ektdinero.bitacora.dao;
import java.math.BigDecimal;
import java.util.List;

import com.shq.entities.InventarioVw;


public class InventarioDAO extends BaseDAO<InventarioVw>{

	
	   public InventarioDAO(){
	        super(InventarioVw.class);
	    }
	   
	   public List<InventarioVw> getInventario(){	
		   return this.findByNativeQuery("SELECT id,cantidad,costo_prom,producto,especificaciones FROM inventario_vw");
		} 
	   
	   public List<InventarioVw> getCantidadProductoPorID(BigDecimal id){	
		   return this.findByNativeQuery("SELECT * FROM inventario_vw where id="+id);
		} 
	   
}

