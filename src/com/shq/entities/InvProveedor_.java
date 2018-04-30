package com.shq.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-17T13:03:58.527-0500")
@StaticMetamodel(InvProveedor.class)
public class InvProveedor_ {
	public static volatile SingularAttribute<InvProveedor, Integer> id;
	public static volatile SingularAttribute<InvProveedor, Integer> cantidad;
	public static volatile SingularAttribute<InvProveedor, Integer> precio;
	public static volatile SingularAttribute<InvProveedor, Producto> producto;
	public static volatile SingularAttribute<InvProveedor, Externo> proveedor;
}
