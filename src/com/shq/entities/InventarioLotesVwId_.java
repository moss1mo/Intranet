package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-08T03:59:16.422-0500")
@StaticMetamodel(InventarioLotesVwId.class)
public class InventarioLotesVwId_ {
	public static volatile SingularAttribute<InventarioLotesVwId, Long> idProducto;
	public static volatile SingularAttribute<InventarioLotesVwId, String> lote;
	public static volatile SingularAttribute<InventarioLotesVwId, BigDecimal> cantidad;
	public static volatile SingularAttribute<InventarioLotesVwId, BigDecimal> precio;
	public static volatile SingularAttribute<InventarioLotesVwId, String> producto;
	public static volatile SingularAttribute<InventarioLotesVwId, String> especificaciones;
}
