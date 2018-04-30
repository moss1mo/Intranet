package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-08T03:59:16.521-0500")
@StaticMetamodel(ProductoSolCotizacionParcId.class)
public class ProductoSolCotizacionParcId_ {
	public static volatile SingularAttribute<ProductoSolCotizacionParcId, Long> idSolicitud;
	public static volatile SingularAttribute<ProductoSolCotizacionParcId, Long> idProducto;
	public static volatile SingularAttribute<ProductoSolCotizacionParcId, String> producto;
	public static volatile SingularAttribute<ProductoSolCotizacionParcId, Long> cantidadSolicitada;
	public static volatile SingularAttribute<ProductoSolCotizacionParcId, BigDecimal> cantidadAlmacen;
	public static volatile SingularAttribute<ProductoSolCotizacionParcId, BigDecimal> cantidadCotizar;
}
