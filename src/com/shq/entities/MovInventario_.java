package com.shq.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-28T13:36:48.540-0500")
@StaticMetamodel(MovInventario.class)
public class MovInventario_ {
	public static volatile SingularAttribute<MovInventario, Integer> id;
	public static volatile SingularAttribute<MovInventario, Externo> proveedor;
	public static volatile SingularAttribute<MovInventario, Integer> cantidad;
	public static volatile SingularAttribute<MovInventario, BigDecimal> costoMxn;
	public static volatile SingularAttribute<MovInventario, BigDecimal> costoUsd;
	public static volatile SingularAttribute<MovInventario, BigDecimal> dimensiones;
	public static volatile SingularAttribute<MovInventario, Date> fechaCaducidad;
	public static volatile SingularAttribute<MovInventario, Date> fechaIngreso;
	public static volatile SingularAttribute<MovInventario, Date> fechaSalida;
	public static volatile SingularAttribute<MovInventario, BigDecimal> hs;
	public static volatile SingularAttribute<MovInventario, Integer> idUnidad;
	public static volatile SingularAttribute<MovInventario, String> incoterms;
	public static volatile SingularAttribute<MovInventario, String> lote;
	public static volatile SingularAttribute<MovInventario, String> motivo;
	public static volatile SingularAttribute<MovInventario, BigDecimal> prtjIgi;
	public static volatile SingularAttribute<MovInventario, BigDecimal> prtjIva;
	public static volatile SingularAttribute<MovInventario, String> status;
	public static volatile SingularAttribute<MovInventario, BigDecimal> tc;
	public static volatile SingularAttribute<MovInventario, BigDecimal> unidXPresent;
	public static volatile SingularAttribute<MovInventario, Almacen> almacen;
	public static volatile SingularAttribute<MovInventario, Empaque> empaque;
	public static volatile SingularAttribute<MovInventario, MotivoMov> motivoMov;
	public static volatile SingularAttribute<MovInventario, Pedimento> pedimento;
	public static volatile SingularAttribute<MovInventario, Producto> producto;
}
