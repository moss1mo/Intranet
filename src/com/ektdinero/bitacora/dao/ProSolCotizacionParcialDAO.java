package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.ProductoSolCotizacionParc;


public class ProSolCotizacionParcialDAO extends BaseDAO<ProductoSolCotizacionParc>{

	
	   public ProSolCotizacionParcialDAO(){
	        super(ProductoSolCotizacionParc.class);
	    }
	   

	   public List<ProductoSolCotizacionParc> getProductos(Long idSolicitud){	
		   return this.findByNativeQuery("SELECT * FROM producto_sol_cotizacion_parc where id_solicitud = '"+idSolicitud+"'");
		}
	   
	   public List<ProductoSolCotizacionParc> getProductosPorCotizar(Long idSolicitud){	
		   return this.findByNativeQuery("SELECT * FROM producto_sol_cotizacion_parc where id_solicitud = '"+idSolicitud+"' AND cantidad_cotizar>0");
		}
	   
	     
}
