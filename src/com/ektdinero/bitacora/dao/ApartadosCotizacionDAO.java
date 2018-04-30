package com.ektdinero.bitacora.dao;
import java.util.List;

import com.ektdinero.bitacora.beans.ProductoSolCotizacionLote;
import com.shq.entities.ApartadosCotizacion;

public class ApartadosCotizacionDAO extends BaseDAO<ApartadosCotizacion>{

	
	   public ApartadosCotizacionDAO(){
	        super(ApartadosCotizacion.class);
	    }
	   
	   public void guardarApartado(ApartadosCotizacion entity)  {
			this.create(entity);
		}
	   
	   public List<ApartadosCotizacion> getApartados(Long idSolicitud){	
		   List<ApartadosCotizacion> apartados = this.findByNativeQuery("SELECT * FROM apartados_cotizacion where id_solicitud= '"+idSolicitud+"'");	
		   return apartados;
		}   
	   
	   
	   public ApartadosCotizacion buscarProductoCotizado(String lote,int idProducto,Long idSolicitud){
		   List<ApartadosCotizacion> apartados = this.findByNativeQuery("SELECT * FROM apartados_cotizacion where lote= '"+lote+"' AND id_producto='"+idProducto+"' AND id_solicitud='"+idSolicitud+"'");	
		   if(apartados != null && apartados.size()>0){
			   return apartados.get(0); 
		   }else{
			   return null;
		   }
		   
		
	   }

	public void actualizarApartado(ApartadosCotizacion apartadoExistente) {
		this.update(apartadoExistente);
	}

	public void eliminarProductoCotizacion(Long idProductoCotizacion) {
		this.delete(idProductoCotizacion);		
	}
}
