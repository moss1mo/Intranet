package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.ProductoSolCotizacion;


public class ProSolCotizacionDAO extends BaseDAO<ProductoSolCotizacion>{

	
	   public ProSolCotizacionDAO(){
	        super(ProductoSolCotizacion.class);
	    }
	   
	   
	   public void guardarProducto(ProductoSolCotizacion productoSolicitud){
		   this.create(productoSolicitud);
	   }
	   
	   public void guardarProductos(List<ProductoSolCotizacion> listaProductos){
		   try {
			   this.saveAll(listaProductos);
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   public List<ProductoSolCotizacion> getProductos(){	
		   return this.findByNativeQuery("SELECT * FROM producto_sol_cotizacion");
		}
	   
	     
}
