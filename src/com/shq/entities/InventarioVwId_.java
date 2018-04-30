package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-11T02:54:04.975-0600")
@StaticMetamodel(InventarioVwId.class)
public class InventarioVwId_ {
	public static volatile SingularAttribute<InventarioVwId, BigDecimal> id;
	public static volatile SingularAttribute<InventarioVwId, BigDecimal> cantidad;
	public static volatile SingularAttribute<InventarioVwId, BigDecimal> costoProm;
	public static volatile SingularAttribute<InventarioVwId, String> producto;
	public static volatile SingularAttribute<InventarioVwId, String> especificaciones;
}
