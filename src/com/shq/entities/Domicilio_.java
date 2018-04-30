package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-20T10:51:37.840-0500")
@StaticMetamodel(Domicilio.class)
public class Domicilio_ {
	public static volatile SingularAttribute<Domicilio, BigDecimal> idDomicilio;
	public static volatile SingularAttribute<Domicilio, String> codPais;
	public static volatile SingularAttribute<Domicilio, String> codEstado;
	public static volatile SingularAttribute<Domicilio, String> codMunicipio;
	public static volatile SingularAttribute<Domicilio, String> cp;
	public static volatile SingularAttribute<Domicilio, String> calle;
	public static volatile SingularAttribute<Domicilio, String> numExt;
	public static volatile SingularAttribute<Domicilio, String> numInt;
	public static volatile SingularAttribute<Domicilio, Boolean> principal;
	public static volatile SingularAttribute<Domicilio, String> referencias;
	public static volatile SingularAttribute<Domicilio, String> entreCalles;
	public static volatile SingularAttribute<Domicilio, Integer> idAlmacen;
	public static volatile SingularAttribute<Domicilio, BigDecimal> idExterno;
	public static volatile SetAttribute<Domicilio, Empleado> empleados;
	public static volatile SetAttribute<Domicilio, Externo> externos;
	public static volatile SingularAttribute<Domicilio, String> codColonia;
}
