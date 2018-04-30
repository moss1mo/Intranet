package com.ektdinero.bitacora.dao;
import java.math.BigDecimal;
import java.util.List;

import com.shq.entities.CotizacionProveedor;


public class CotizacionProveedorDAO extends BaseDAO<CotizacionProveedor>{

	
	   public CotizacionProveedorDAO(){
	        super(CotizacionProveedor.class);
	    }
	   
	   
	   public CotizacionProveedor guardarSolicitud(CotizacionProveedor solicitud){
		   return this.create(solicitud);
	   }
	   
	   public CotizacionProveedor getSolicitudPorID(BigDecimal id){	
		   return this.find(id);
		}
	   
	   public List<CotizacionProveedor> getSolicitudes(){	
		   return this.findByNativeQuery("SELECT * FROM cotizacion_proveedor");
		}
	   
	   public boolean noExisteCotizacionProveedor(long idSolicitud,BigDecimal idProveedor){	
		   return this.findByNativeQuery("SELECT * FROM cotizacion_proveedor where id_externo="+idProveedor.intValue()+" && id_solicitud="+idSolicitud).isEmpty();
		}
	   
	   public CotizacionProveedor obtenerCotizacionProveedor(long idSolicitud,BigDecimal idProveedor){
		   return this.findByNativeQuery("SELECT * FROM cotizacion_proveedor where id_externo="+idProveedor.intValue()+" && id_solicitud="+idSolicitud).get(0);
		}
	   
	   public List<CotizacionProveedor> obtenerCotizacionesProveedoresPorComprador(long idComprador){
		   return this.findByNativeQuery("SELECT * FROM cotizacion_proveedor cot_prov left "
		   		+ "join sol_cotizacion cot on cot.id = cot_prov.id_solicitud where id_comprador="+idComprador);
		}


	public List<CotizacionProveedor> obtenerCotizacionesProveedoresPorVendedor(long idVendedor) {
		  return this.findByNativeQuery("SELECT * FROM cotizacion_proveedor cot_prov left "
			   		+ "join sol_cotizacion cot on cot.id = cot_prov.id_solicitud where id_vendedor="+idVendedor);
	}
	
	public CotizacionProveedor obtenerCotizacionesProveedoresPorSolicitud(long idSolicitud) {
		return this.findByNativeQuery("SELECT * FROM cotizacion_proveedor where enviada_cliente=1 && id_solicitud="+idSolicitud).get(0);
	}
}
