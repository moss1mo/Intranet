package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.MotivoMov;


public class MotivoMovimientoDAO extends BaseDAO<MotivoMov>{

	
	   public MotivoMovimientoDAO(){
	        super(MotivoMov.class);
	    }
	   
	   public void guardar(MotivoMov entity)  {
			this.create(entity);
		}
	   
	   public List<MotivoMov> getLista(){	
		   List<MotivoMov> lista = this.findByNativeQuery("SELECT * FROM MOTIVO_MOV");	
		   return lista;
		}   
}
