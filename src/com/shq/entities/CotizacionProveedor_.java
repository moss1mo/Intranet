package com.shq.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-01T11:24:33.049-0500")
@StaticMetamodel(CotizacionProveedor.class)
public class CotizacionProveedor_ {
	public static volatile SingularAttribute<CotizacionProveedor, BigDecimal> id;
	public static volatile SingularAttribute<CotizacionProveedor, SolCotizacion> solCotizacion;
	public static volatile SetAttribute<CotizacionProveedor, ProductoCotProveedor> productoCotProveedors;
	public static volatile ListAttribute<CotizacionProveedor, ProductoCotProveedor> listaProductoCotProveedors;
	public static volatile SingularAttribute<CotizacionProveedor, String> entregaDomicilio;
	public static volatile SingularAttribute<CotizacionProveedor, Boolean> enviadaVentas;
	public static volatile SingularAttribute<CotizacionProveedor, Boolean> enviadaCompras;
	public static volatile SingularAttribute<CotizacionProveedor, Boolean> enviadaCliente;
	public static volatile SingularAttribute<CotizacionProveedor, Externo> externo;
}
