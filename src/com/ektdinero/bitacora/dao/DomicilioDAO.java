package com.ektdinero.bitacora.dao;


import java.util.List;

import com.shq.entities.Domicilio;
import com.shq.entities.Externo;


public class DomicilioDAO extends BaseDAO<Domicilio>{

	
	   public DomicilioDAO(){
	        super(Domicilio.class);
	    }
	   
	   public void guardarDomicilio(Domicilio domicilio){	
		    this.create(domicilio);
		}

	   public List<Domicilio> obtenerDomiciliosPorUsuario(Externo externo) {   
		   return this.findByNativeQuery("SELECT * FROM DOMICILIO WHERE id_externo = "+externo.getIdExterno()+" AND activo = 1");
	   } 
	
	   public void actualizarDomicilio(Domicilio domicilio){
		   this.update(domicilio);
	   }

}

