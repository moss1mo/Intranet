package com.shq.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-11-13T10:33:10.411-0600")
@StaticMetamodel(ClienteDomicilio.class)
public class ClienteDomicilio_ {
	public static volatile SingularAttribute<ClienteDomicilio, Integer> id;
	public static volatile SingularAttribute<ClienteDomicilio, Integer> idCliente;
	public static volatile SingularAttribute<ClienteDomicilio, Integer> idPais;
	public static volatile SingularAttribute<ClienteDomicilio, Integer> idEstado;
	public static volatile SingularAttribute<ClienteDomicilio, Integer> idMunicipio;
	public static volatile SingularAttribute<ClienteDomicilio, Integer> idCp;
	public static volatile SingularAttribute<ClienteDomicilio, String> calle;
	public static volatile SingularAttribute<ClienteDomicilio, String> numExt;
	public static volatile SingularAttribute<ClienteDomicilio, String> numInt;
	public static volatile SingularAttribute<ClienteDomicilio, Boolean> principal;
}
