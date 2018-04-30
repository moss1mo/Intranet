package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.MovInventario;


public class MovimientosDAO extends BaseDAO<MovInventario>{

	
	   public MovimientosDAO(){
	        super(MovInventario.class);
	    }
	   
	   public void guardarMovimiento(MovInventario entity)  {
			this.create(entity);
		}
	   
	   public void guardarLista(List<MovInventario> entities)  {
			try {
				this.saveAll(entities);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   
	   public List<MovInventario> getMovimientosEntrada(){	
		   List<MovInventario> movimientos = this.findByNativeQuery("SELECT * FROM MOV_INVENTARIO where FECHA_INGRESO IS NOT NULL");		
		   return movimientos;
		}  
	   public List<MovInventario> getMovimientosSalida(){	
		   List<MovInventario> movimientos = this.findByNativeQuery("SELECT * FROM MOV_INVENTARIO where FECHA_SALIDA IS NOT NULL");		
		   return movimientos;
		}  
}
