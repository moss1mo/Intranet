package com.shq.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-02T16:27:12.874-0500")
@StaticMetamodel(CuentaBanco.class)
public class CuentaBanco_ {
	public static volatile SingularAttribute<CuentaBanco, Integer> id;
	public static volatile SingularAttribute<CuentaBanco, String> numCuenta;
	public static volatile SingularAttribute<CuentaBanco, String> clabe;
	public static volatile SingularAttribute<CuentaBanco, String> banco;
	public static volatile SingularAttribute<CuentaBanco, String> otroBanco;
	public static volatile SingularAttribute<CuentaBanco, Externo> externo;
}
