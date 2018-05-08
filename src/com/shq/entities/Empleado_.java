package com.shq.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-02T22:48:51.266-0500")
@StaticMetamodel(Empleado.class)
public class Empleado_ {
	public static volatile SingularAttribute<Empleado, BigDecimal> idEmpleado;
	public static volatile SingularAttribute<Empleado, String> nombre;
	public static volatile SingularAttribute<Empleado, String> apellidoMaterno;
	public static volatile SingularAttribute<Empleado, String> apellidoPaterno;
	public static volatile SingularAttribute<Empleado, Date> fechaNacimiento;
	public static volatile SingularAttribute<Empleado, String> emailEmpresa;
	public static volatile SingularAttribute<Empleado, String> emailPersonal;
	public static volatile SingularAttribute<Empleado, String> telCasa;
	public static volatile SingularAttribute<Empleado, String> telCelular;
	public static volatile SingularAttribute<Empleado, String> telExt;
	public static volatile SingularAttribute<Empleado, String> telTrabajo;
	public static volatile SingularAttribute<Empleado, String> puesto;
	public static volatile SetAttribute<Empleado, Usuario> usuarios;
	public static volatile SetAttribute<Empleado, Domicilio> domicilios;
}
