package com.ektdinero.bitacora.dao;
import java.math.BigDecimal;
import java.util.List;

import com.shq.entities.SolCotizacion;
import com.shq.entities.Usuario;


public class SolCotizacionDAO extends BaseDAO<SolCotizacion>{

	
	   public SolCotizacionDAO(){
	        super(SolCotizacion.class);
	    }
	   
	   
	   public void guardarSolicitud(SolCotizacion solicitud){
		   this.create(solicitud);
	   }
	   
	   public List<SolCotizacion> getSolicitudes(){	
		   return this.findByNativeQuery("SELECT * FROM sol_cotizacion where cod_status = 0 and id_vendedor IS null order by fecha_sol desc");
		}


	public void actualizarSolicitudes(List<SolCotizacion> solicitudes) {
		try {
			this.updateAll(solicitudes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarSolicitud(SolCotizacion solicitud) {
		try {
			this.update(solicitud);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<SolCotizacion> getSolicitudesByUserID(Usuario usuario) {
		return this.findByNativeQuery("SELECT * FROM sol_cotizacion where id_vendedor="+usuario.getIdUsuario());
	}  
	
	public List<SolCotizacion> getSolicitudesByComprador(Usuario usuario) {
		return this.findByNativeQuery("SELECT * FROM sol_cotizacion where id_comprador="+usuario.getIdUsuario());
	}


	public List<SolCotizacion> getSolicitudesByCliente(Usuario usuario) {
		return this.findByNativeQuery("SELECT * FROM sol_cotizacion where id_externo="+usuario.getIdUsuario());
	}


	public List<SolCotizacion> getSolicitudesReqDisponibles(BigDecimal id_externo_logeado) {
		
		return this.findByNativeQuery("SELECT * FROM sol_cotizacion sc left join cotizacion_proveedor cp on sc.id = cp.id_solicitud "+
        "where (sc.cod_status=3 || sc.cod_status=4) and cp.id_externo = "+id_externo_logeado);
	}
	
	public List<SolCotizacion> getCotizacionesByComprador(Usuario usuario) {
		return this.findByNativeQuery("SELECT * FROM sol_cotizacion where id_comprador="+usuario.getIdUsuario() +" AND cod_status=4");
	}


	public List<SolCotizacion> getCotizacionesRecibidasByUserID(Usuario usuario) {
 		return this.findByNativeQuery("SELECT * FROM sol_cotizacion where id_vendedor="+usuario.getIdUsuario()+ " AND cod_status=5");
	}
}
