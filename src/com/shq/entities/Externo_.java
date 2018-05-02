package com.shq.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-30T23:42:11.651-0500")
@StaticMetamodel(Externo.class)
public class Externo_ {
	public static volatile SingularAttribute<Externo, BigDecimal> idExterno;
	public static volatile SingularAttribute<Externo, Domicilio> domicilio;
	public static volatile SingularAttribute<Externo, String> clave;
	public static volatile SingularAttribute<Externo, String> correoContacto;
	public static volatile SingularAttribute<Externo, Date> fechaAlta;
	public static volatile SingularAttribute<Externo, String> nombre;
	public static volatile SingularAttribute<Externo, String> nombreContacto;
	public static volatile SingularAttribute<Externo, String> rfc;
	public static volatile SingularAttribute<Externo, String> telContacto;
	public static volatile SingularAttribute<Externo, String> pais;
	public static volatile SingularAttribute<Externo, String> paisCod;
	public static volatile SingularAttribute<Externo, String> estado;
	public static volatile SingularAttribute<Externo, String> estadoCod;
	public static volatile SingularAttribute<Externo, String> municipio;
	public static volatile SingularAttribute<Externo, String> munCod;
	public static volatile SingularAttribute<Externo, String> colonia;
	public static volatile SingularAttribute<Externo, String> coloniaCod;
	public static volatile SingularAttribute<Externo, String> cp;
	public static volatile SingularAttribute<Externo, String> calle;
	public static volatile SingularAttribute<Externo, String> numInt;
	public static volatile SingularAttribute<Externo, String> numExt;
	public static volatile SingularAttribute<Externo, String> referencias;
	public static volatile SingularAttribute<Externo, String> entreCalles;
	public static volatile SingularAttribute<Externo, Boolean> activo;
	public static volatile SingularAttribute<Externo, String> direccionFiscal;
	public static volatile SingularAttribute<Externo, String> direccionRecoleccion;
	public static volatile SetAttribute<Externo, MovInventario> movInventarios;
	public static volatile SetAttribute<Externo, CotizacionProveedor> cotizacionProveedors;
	public static volatile SetAttribute<Externo, InvProveedor> invProveedors;
	public static volatile SetAttribute<Externo, Usuario> usuarios;
	public static volatile SetAttribute<Externo, CuentaBanco> cuentasBanco;
}
