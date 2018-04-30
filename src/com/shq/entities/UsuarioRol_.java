package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-23T14:56:18.121-0600")
@StaticMetamodel(UsuarioRol.class)
public class UsuarioRol_ {
	public static volatile SingularAttribute<UsuarioRol, BigDecimal> idRol;
	public static volatile SingularAttribute<UsuarioRol, Integer> cod;
	public static volatile SingularAttribute<UsuarioRol, String> nombre;
	public static volatile SetAttribute<UsuarioRol, Usuario> usuarios;
}
