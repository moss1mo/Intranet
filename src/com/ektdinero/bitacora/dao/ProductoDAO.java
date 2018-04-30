package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.Producto;


public class ProductoDAO extends BaseDAO<Producto>{

	
	   public ProductoDAO(){
	        super(Producto.class);
	    }
	   
	   public void guardarProducto(Producto entity)  {
			this.create(entity);
		}
	   
	   public void guardarProductos(List<Producto> entities)  {
			try {
				this.saveAll(entities);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   
	   public List<Producto> getProductos(){	
		   List<Producto> productos = this.findByNativeQuery("SELECT * FROM PRODUCTO");
		   return productos;
		}   
}
