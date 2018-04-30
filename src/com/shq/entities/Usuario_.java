package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-20T10:51:38.056-0500")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, BigDecimal> idUsuario;
	public static volatile SingularAttribute<Usuario, Empleado> empleado;
	public static volatile SingularAttribute<Usuario, Externo> externo;
	public static volatile SingularAttribute<Usuario, UsuarioRol> usuarioRol;
	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile SingularAttribute<Usuario, String> nombreUsuario;
	public static volatile SingularAttribute<Usuario, Boolean> activo;
}
