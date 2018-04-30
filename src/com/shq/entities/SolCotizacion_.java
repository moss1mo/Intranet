package com.shq.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-20T10:51:38.024-0500")
@StaticMetamodel(SolCotizacion.class)
public class SolCotizacion_ {
	public static volatile SingularAttribute<SolCotizacion, Long> id;
	public static volatile SingularAttribute<SolCotizacion, Usuario> usuarioByIdComprador;
	public static volatile SingularAttribute<SolCotizacion, Usuario> usuarioByIdVendedor;
	public static volatile SingularAttribute<SolCotizacion, Usuario> usuarioByIdExterno;
	public static volatile SingularAttribute<SolCotizacion, String> nota;
	public static volatile SingularAttribute<SolCotizacion, String> status;
	public static volatile SingularAttribute<SolCotizacion, Date> fechaSol;
	public static volatile SingularAttribute<SolCotizacion, String> nombre;
	public static volatile SingularAttribute<SolCotizacion, String> apellidoPaterno;
	public static volatile SingularAttribute<SolCotizacion, String> apellidoMaterno;
	public static volatile SingularAttribute<SolCotizacion, String> telefono;
	public static volatile SingularAttribute<SolCotizacion, String> correo;
	public static volatile SingularAttribute<SolCotizacion, String> dondeEntregar;
	public static volatile SingularAttribute<SolCotizacion, String> pais;
	public static volatile SingularAttribute<SolCotizacion, String> estado;
	public static volatile SingularAttribute<SolCotizacion, String> colonia;
	public static volatile SingularAttribute<SolCotizacion, String> cp;
	public static volatile SingularAttribute<SolCotizacion, String> calle;
	public static volatile SingularAttribute<SolCotizacion, String> referencias;
	public static volatile SingularAttribute<SolCotizacion, String> numInt;
	public static volatile SingularAttribute<SolCotizacion, String> numExt;
	public static volatile SingularAttribute<SolCotizacion, Date> fechaEntrega;
	public static volatile SingularAttribute<SolCotizacion, String> municipio;
	public static volatile SingularAttribute<SolCotizacion, String> msjCotizCliente;
	public static volatile SingularAttribute<SolCotizacion, String> paisFiscal;
	public static volatile SingularAttribute<SolCotizacion, String> munFiscal;
	public static volatile SingularAttribute<SolCotizacion, String> estadoFiscal;
	public static volatile SingularAttribute<SolCotizacion, String> coloniaFiscal;
	public static volatile SingularAttribute<SolCotizacion, String> cpFiscal;
	public static volatile SingularAttribute<SolCotizacion, String> calleFiscal;
	public static volatile SingularAttribute<SolCotizacion, String> numExtFiscal;
	public static volatile SingularAttribute<SolCotizacion, String> numIntFiscal;
	public static volatile SingularAttribute<SolCotizacion, String> rfc;
	public static volatile SingularAttribute<SolCotizacion, String> metodoPago;
	public static volatile SingularAttribute<SolCotizacion, String> valor;
	public static volatile SingularAttribute<SolCotizacion, String> fletera;
	public static volatile SetAttribute<SolCotizacion, ProductoSolCotizacion> productoSolCotizacions;
	public static volatile SetAttribute<SolCotizacion, ApartadosCotizacion> apartadosCotizacions;
	public static volatile SingularAttribute<SolCotizacion, String> direccionEntrega;
	public static volatile SingularAttribute<SolCotizacion, String> direccionFiscal;
	public static volatile SingularAttribute<SolCotizacion, Integer> codStatus;
}
