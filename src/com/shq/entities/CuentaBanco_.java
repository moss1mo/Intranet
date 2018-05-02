package com.shq.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-01T23:03:53.889-0500")
@StaticMetamodel(CuentaBanco.class)
public class CuentaBanco_ {
	public static volatile SingularAttribute<CuentaBanco, String> numCuenta;
	public static volatile SingularAttribute<CuentaBanco, String> clabe;
	public static volatile SingularAttribute<CuentaBanco, String> otroBanco;
	public static volatile SingularAttribute<CuentaBanco, Externo> externo;
	public static volatile SingularAttribute<CuentaBanco, Integer> id;
	public static volatile SingularAttribute<CuentaBanco, String> banco;
}
