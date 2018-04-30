package com.shq.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-11-13T10:33:10.435-0600")
@StaticMetamodel(Pedimento.class)
public class Pedimento_ {
	public static volatile SingularAttribute<Pedimento, Integer> id;
	public static volatile SingularAttribute<Pedimento, String> aduana;
	public static volatile SingularAttribute<Pedimento, String> ciudad;
	public static volatile SingularAttribute<Pedimento, Date> fechaEntrada;
	public static volatile SingularAttribute<Pedimento, String> pedimento;
}
