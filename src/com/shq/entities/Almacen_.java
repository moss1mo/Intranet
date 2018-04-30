package com.shq.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-23T14:56:17.379-0600")
@StaticMetamodel(Almacen.class)
public class Almacen_ {
	public static volatile SingularAttribute<Almacen, Integer> idAlmacen;
	public static volatile SingularAttribute<Almacen, String> direccion;
	public static volatile SingularAttribute<Almacen, String> nombre;
	public static volatile SingularAttribute<Almacen, String> tipoAlmacen;
	public static volatile SingularAttribute<Almacen, Date> fechaFinAlmacen;
	public static volatile SingularAttribute<Almacen, String> nombreContacto;
	public static volatile SingularAttribute<Almacen, String> telContacto;
	public static volatile SingularAttribute<Almacen, String> correoContacto;
	public static volatile SingularAttribute<Almacen, String> horarioAtencion;
}
