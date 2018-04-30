package com.ektdinero.bitacora.dao;
import java.util.List;

import com.shq.entities.CatSepomex;


public class SepomexDAO extends BaseDAO<CatSepomex>{

	
	   public SepomexDAO(){
	        super(CatSepomex.class);
	    }
	   
	   
	   public List<CatSepomex> getEstados(){	
		   List<CatSepomex> lista = this.findByNativeQuery("SELECT * FROM CAT_SEPOMEX GROUP BY D_ESTADO");	
		   return lista;
		} 
	   
	   public CatSepomex getEstado(String codEstado){
		   List<CatSepomex> resultados = this.findByNativeQuery("SELECT * FROM CAT_SEPOMEX WHERE C_ESTADO = '"+codEstado+"' GROUP BY D_ESTADO");
		   if(resultados != null && resultados.size()>0){
			   return resultados.get(0);
		   }
		   return null;
		} 
	   
	   
	   public List<CatSepomex> getMunicipios(String codEstado){	
		   List<CatSepomex> lista = this.findByNativeQuery("SELECT * FROM CAT_SEPOMEX WHERE C_ESTADO = '"+codEstado+"' GROUP BY D_mnpio");	
		   return lista;
		} 
	   
	   public CatSepomex getMunicipio(String codMun,String codEstado){
		   List<CatSepomex> resultados = this.findByNativeQuery("SELECT * FROM CAT_SEPOMEX WHERE c_mnpio = '"+codMun+"'  and  C_ESTADO = '"+codEstado+"' GROUP BY D_mnpio");
		   if(resultados != null && resultados.size()>0){
			   return resultados.get(0);
		   }
		   return null;
		} 
	   
	   
	   public List<CatSepomex> getColonias(String codEstado,String codMun){	
		   List<CatSepomex> lista = this.findByNativeQuery("SELECT * FROM CAT_SEPOMEX WHERE c_mnpio = '"+codMun+"' AND C_ESTADO = '"+codEstado+"' GROUP BY d_asenta");	
		   return lista;
		} 
	   
	   public CatSepomex getColonia(String idColonia,String codEstado,String codMun){
		   List<CatSepomex> resultados = this.findByNativeQuery("SELECT * FROM CAT_SEPOMEX WHERE id_asenta_cpcons = '"+idColonia+"'  and  C_ESTADO = '"+codEstado+"' AND c_mnpio = '"+codMun+"' GROUP BY d_asenta");
		   if(resultados != null && resultados.size()>0){
			   return resultados.get(0);
		   }
		   return null;
		} 
	   
	   public List<CatSepomex> getCP(String codEstado,String codMun,String idColonia){	
		   List<CatSepomex> lista = this.findByNativeQuery("SELECT * FROM CAT_SEPOMEX WHERE c_mnpio = '"+codMun+"' AND C_ESTADO = '"+codEstado+"' AND id_asenta_cpcons = '"+idColonia+"'");	
		   return lista;
		} 
	   

}
