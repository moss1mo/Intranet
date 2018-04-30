package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.Empleado;


public class EmpleadoDAO extends BaseDAO<Empleado>{

	
	   public EmpleadoDAO(){
	        super(Empleado.class);
	    }
	   
	   public void guardarEmpleado(Empleado entity)  {
			this.create(entity);
		}
	   
	   public List<Empleado> getEmpleados(){	
		   List<Empleado> empleados = this.findByNativeQuery("SELECT * FROM empleado");	
		   return empleados;
		}   
}
