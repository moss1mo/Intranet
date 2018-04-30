package com.shq.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-08T03:59:16.202-0500")
@StaticMetamodel(ApartadosCotizacion.class)
public class ApartadosCotizacion_ {
	public static volatile SingularAttribute<ApartadosCotizacion, Long> id;
	public static volatile SingularAttribute<ApartadosCotizacion, Long> cantidad;
	public static volatile SingularAttribute<ApartadosCotizacion, Producto> producto;
	public static volatile SingularAttribute<ApartadosCotizacion, String> lote;
	public static volatile SingularAttribute<ApartadosCotizacion, Boolean> activo;
	public static volatile SingularAttribute<ApartadosCotizacion, SolCotizacion> solCotizacion;
}
