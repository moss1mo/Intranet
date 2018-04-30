package com.ektdinero.bitacora.dao;


import java.math.BigDecimal;
import java.util.List;

import com.shq.entities.Usuario;

public class UsuariosDAO extends BaseDAO<Usuario> {
	
	
	 
	    public UsuariosDAO(){
	        super(Usuario.class);
	    }
	 
	    /**
	     * Returns new user
	     * @return User
	     */
	    public Usuario getNuevoUsuario(){
	        return new Usuario();
	    }
	    
	    public Usuario autenticaUsuario(String nombreUsuario,String contrasena){
	    	Usuario usuario = null;
	    	List<Usuario> consultaUsuarios = this.findByNativeQuery("SELECT * FROM usuario WHERE nombre_usuario = '"+nombreUsuario+"' AND password ="+"'"+contrasena+"'");
	    		if(consultaUsuarios == null || consultaUsuarios.size() > 0){
	    			 usuario = consultaUsuarios.get(0);
	    		}
	    		return 	usuario;
	    	}
	    
	    
	    public BigDecimal getIdUsuario(String nombre){
	    	Usuario usuario = null;
	    	List<Usuario> consultaUsuarios = this.findByNativeQuery("SELECT * FROM usuario WHERE nombre = '"+nombre+"'");
	    	if(consultaUsuarios == null || consultaUsuarios.size() > 0){
   			 usuario = consultaUsuarios.get(0);
   			 return usuario.getIdUsuario();
   		}
	    	
	    	return new BigDecimal(0);
	    }
	
	
	    public boolean validaExistenciaUsuario(String nombreUsuario){
	    	
	    	List<Usuario> usuarios = this.findByNativeQuery("SELECT * FROM usuario WHERE nombre_usuario  = '"+nombreUsuario+"' ");
	    	if(usuarios.size()>0){
	    		return true;
	    	}else{
	    		return false;
	    	}

		}
	
	
	public List<Usuario> getUsuariosParaAsignacionApps(String queryBusqueda){

    	List<Usuario> usuariosCambios = this.findByNativeQuery("SELECT * FROM usuario WHERE nombre_usuario LIKE '%"+queryBusqueda+"%'");
	
		return usuariosCambios;
	}
	
	public List<Usuario> getTodosUsuarios(){

    	List<Usuario> usuarios = this.findByNativeQuery("SELECT * FROM usuario");
	
		return usuarios;
	}
	
	public List<Usuario> getUsuariosExternos(BigDecimal idUsuario){

    	List<Usuario> usuarios = this.findByNativeQuery("SELECT * FROM usuario where id_rol = 6 and id_usuario != "+idUsuario);
	
		return usuarios;
	}

	public List<Usuario> getUsuariosCompradores() {
		return this.findByNativeQuery("SELECT * FROM usuario where id_rol=2");
	}

	public Usuario obtenerUsuarioPorID(BigDecimal idUsuario) {
		Usuario usuario = null;
    	List<Usuario> consultaUsuarios = this.findByNativeQuery("SELECT * FROM usuario WHERE id_usuario = "+idUsuario);
    		if(consultaUsuarios == null || consultaUsuarios.size() > 0){
    			 usuario = consultaUsuarios.get(0);
    		}
    		return 	usuario;
	}
	
	

	
	
	


	
	



	
}
