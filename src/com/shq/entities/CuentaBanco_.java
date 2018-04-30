package com.shq.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-17T14:06:54.129-0500")
@StaticMetamodel(CuentaBanco.class)
public class CuentaBanco_ {
	public static volatile SingularAttribute<CuentaBanco, Integer> id;
	public static volatile SingularAttribute<CuentaBanco, String> numCuenta;
	public static volatile SingularAttribute<CuentaBanco, String> clabe;
	public static volatile SingularAttribute<CuentaBanco, Integer> idBanco;
	public static volatile SingularAttribute<CuentaBanco, String> otroBanco;
	public static volatile SingularAttribute<CuentaBanco, Externo> externo;
}
