package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-28T05:14:28.270-0600")
@StaticMetamodel(InvProductProvVwId.class)
public class InvProductProvVwId_ {
	public static volatile SingularAttribute<InvProductProvVwId, String> producto;
	public static volatile SingularAttribute<InvProductProvVwId, BigDecimal> precio;
	public static volatile SingularAttribute<InvProductProvVwId, Long> cantidad;
	public static volatile SingularAttribute<InvProductProvVwId, String> proveedor;
	public static volatile SingularAttribute<InvProductProvVwId, String> nombreContacto;
	public static volatile SingularAttribute<InvProductProvVwId, String> telContacto;
	public static volatile SingularAttribute<InvProductProvVwId, String> correoContacto;
}
