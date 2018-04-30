package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.ProductoCotProveedor;


public class ProductoCotProveedorDAO extends BaseDAO<ProductoCotProveedor>{

	
	   public ProductoCotProveedorDAO(){
	        super(ProductoCotProveedor.class);
	    }
	   
	   
	   public void guardarProducto(ProductoCotProveedor productoSolicitud){
		   this.create(productoSolicitud);
	   }
	   
	   public void guardarProductos(List<ProductoCotProveedor> listaProductos){
		   try {
			   this.saveAll(listaProductos);
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   public void actualizarProductos(List<ProductoCotProveedor> listaProductos){
		   try {
			   this.updateAll(listaProductos);
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   public List<ProductoCotProveedor> getProductos(){	
		   return this.findByNativeQuery("SELECT * FROM producto_cot_proveedor");
		}
	   
	     
}
