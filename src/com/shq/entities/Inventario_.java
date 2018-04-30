package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-11-13T10:33:10.416-0600")
@StaticMetamodel(Inventario.class)
public class Inventario_ {
	public static volatile SingularAttribute<Inventario, Integer> id;
	public static volatile SingularAttribute<Inventario, Integer> cantidad;
	public static volatile SingularAttribute<Inventario, BigDecimal> costoProm;
	public static volatile SingularAttribute<Inventario, BigDecimal> precioProm;
	public static volatile SingularAttribute<Inventario, Integer> idProducto;
}
