package com.shq.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-08T03:59:16.491-0500")
@StaticMetamodel(ProductoSolCotizacion.class)
public class ProductoSolCotizacion_ {
	public static volatile SingularAttribute<ProductoSolCotizacion, Long> id;
	public static volatile SingularAttribute<ProductoSolCotizacion, SolCotizacion> solCotizacion;
	public static volatile SingularAttribute<ProductoSolCotizacion, Producto> producto;
	public static volatile SingularAttribute<ProductoSolCotizacion, Long> cantidad;
}
