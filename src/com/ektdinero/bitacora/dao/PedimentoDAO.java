package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.Pedimento;


public class PedimentoDAO extends BaseDAO<Pedimento>{

	
	   public PedimentoDAO(){
	        super(Pedimento.class);
	    }
	   
	   public void guardar(Pedimento entity)  {
			this.create(entity);
		}
	   
	   public List<Pedimento> getLista(){	
		   List<Pedimento> lista = this.findByNativeQuery("SELECT * FROM PEDIMENTO");	
		   return lista;
		}   
}
