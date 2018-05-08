package com.shq.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-02T22:48:06.328-0500")
@StaticMetamodel(Externo.class)
public class Externo_ {
	public static volatile SingularAttribute<Externo, BigDecimal> idExterno;
	public static volatile SingularAttribute<Externo, String> clave;
	public static volatile SingularAttribute<Externo, String> correoContacto;
	public static volatile SingularAttribute<Externo, Date> fechaAlta;
	public static volatile SingularAttribute<Externo, String> nombre;
	public static volatile SingularAttribute<Externo, String> nombreContacto;
	public static volatile SingularAttribute<Externo, String> rfc;
	public static volatile SingularAttribute<Externo, String> telContacto;
	public static volatile SingularAttribute<Externo, Boolean> activo;
	public static volatile SetAttribute<Externo, MovInventario> movInventarios;
	public static volatile SetAttribute<Externo, CotizacionProveedor> cotizacionProveedors;
	public static volatile SetAttribute<Externo, InvProveedor> invProveedors;
	public static volatile SetAttribute<Externo, Usuario> usuarios;
	public static volatile SetAttribute<Externo, CuentaBanco> cuentasBanco;
	public static volatile SetAttribute<Externo, Domicilio> domicilios;
}
