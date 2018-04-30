package com.shq.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-20T10:51:37.988-0500")
@StaticMetamodel(ProductoCotProveedor.class)
public class ProductoCotProveedor_ {
	public static volatile SingularAttribute<ProductoCotProveedor, Long> id;
	public static volatile SingularAttribute<ProductoCotProveedor, CotizacionProveedor> cotizacionProveedor;
	public static volatile SingularAttribute<ProductoCotProveedor, Producto> producto;
	public static volatile SingularAttribute<ProductoCotProveedor, Long> cantidad;
	public static volatile SingularAttribute<ProductoCotProveedor, Long> costo;
	public static volatile SingularAttribute<ProductoCotProveedor, Long> tiempoEntrega;
	public static volatile SingularAttribute<ProductoCotProveedor, Long> dispMensual;
	public static volatile SingularAttribute<ProductoCotProveedor, String> moneda;
}
