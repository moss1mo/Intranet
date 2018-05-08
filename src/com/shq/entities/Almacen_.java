package com.shq.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-02T19:40:04.950-0500")
@StaticMetamodel(Almacen.class)
public class Almacen_ {
	public static volatile SingularAttribute<Almacen, Integer> idAlmacen;
	public static volatile SingularAttribute<Almacen, String> nombre;
	public static volatile SingularAttribute<Almacen, String> tipoAlmacen;
	public static volatile SingularAttribute<Almacen, Date> fechaFinAlmacen;
	public static volatile SingularAttribute<Almacen, String> nombreContacto;
	public static volatile SingularAttribute<Almacen, String> telContacto;
	public static volatile SingularAttribute<Almacen, String> correoContacto;
	public static volatile SingularAttribute<Almacen, String> horarioAtencion;
	public static volatile SingularAttribute<Almacen, Domicilio> domicilio;
}
