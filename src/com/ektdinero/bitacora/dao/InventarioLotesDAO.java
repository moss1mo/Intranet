package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.InventarioLotesVw;
import com.shq.entities.Producto;


public class InventarioLotesDAO extends BaseDAO<InventarioLotesVw>{

	
	   public InventarioLotesDAO(){
	        super(InventarioLotesVw.class);
	    }

	   public List<InventarioLotesVw> getInventarioPorProducto(Producto producto){	
		   List<InventarioLotesVw> productosInv = this.findByNativeQuery("SELECT * FROM inventario_lotes_vw where producto='"+producto.getProducto()+"'");	
		   return productosInv;
		}
	   
	   public List<InventarioLotesVw> getInventario(){	
		   List<InventarioLotesVw> productosInv = this.findByNativeQuery("SELECT * FROM inventario_lotes_vw");	
		   return productosInv;
		}

  
}
