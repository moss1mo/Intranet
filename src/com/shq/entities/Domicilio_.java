package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-02T22:58:00.501-0500")
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
	public static volatile SingularAttribute<Domicilio, String> referencias;
	public static volatile SingularAttribute<Domicilio, String> entreCalles;
	public static volatile SingularAttribute<Domicilio, String> codColonia;
	public static volatile SingularAttribute<Domicilio, Externo> externo;
	public static volatile SingularAttribute<Domicilio, Empleado> empleado;
	public static volatile SingularAttribute<Domicilio, Boolean> activo;
	public static volatile SingularAttribute<Domicilio, Boolean> fiscal;
	public static volatile SingularAttribute<Domicilio, Boolean> entrega;
	public static volatile SingularAttribute<Domicilio, Boolean> secundaria;
	public static volatile SingularAttribute<Domicilio, String> pais;
	public static volatile SingularAttribute<Domicilio, String> estado;
	public static volatile SingularAttribute<Domicilio, String> municipio;
	public static volatile SingularAttribute<Domicilio, String> colonia;
}
